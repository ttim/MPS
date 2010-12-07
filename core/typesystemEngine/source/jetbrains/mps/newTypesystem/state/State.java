/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.newTypesystem.state;


import com.intellij.openapi.util.Pair;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.newTypesystem.TypeCheckingContextNew;
import jetbrains.mps.newTypesystem.TypesUtil;
import jetbrains.mps.newTypesystem.VariableIdentifier;
import jetbrains.mps.newTypesystem.operation.AbstractOperation;
import jetbrains.mps.newTypesystem.operation.AddRemarkOperation;
import jetbrains.mps.newTypesystem.operation.CheckAllOperation;
import jetbrains.mps.newTypesystem.operation.block.AddBlockOperation;
import jetbrains.mps.newTypesystem.operation.block.AddDependencyOperation;
import jetbrains.mps.newTypesystem.operation.block.RemoveBlockOperation;
import jetbrains.mps.newTypesystem.operation.block.RemoveDependencyOperation;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.WhenConcreteEntity;
import jetbrains.mps.util.ManyToManyMap;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 10, 2010
 * Time: 6:09:38 PM
 */
public class State {
  private static final Logger LOG = Logger.getLogger(State.class);

  private final TypeCheckingContextNew myTypeCheckingContext;

  private final Equations myEquations;
  private final jetbrains.mps.newTypesystem.state.Inequalities myInequalities;
  private final jetbrains.mps.newTypesystem.state.NodeMaps myNodeMaps;

  private final VariableIdentifier myVariableIdentifier;

  private final Stack<AbstractOperation> myOperationStack = new Stack<AbstractOperation>();
  private AbstractOperation myOperation = new CheckAllOperation();
  private boolean myInsideStateChangeAction = false;


  @StateObject
  private final Map<ConditionKind, ManyToManyMap<SNode, Block>> myBlocksAndInputs =
    new HashMap<ConditionKind, ManyToManyMap<SNode, Block>>();

  @StateObject
  private final Set<Block> myBlocks = new HashSet<Block>();

  public State(TypeCheckingContextNew tcc) {
    myTypeCheckingContext = tcc;
    myEquations = new Equations(this);
    myInequalities = new jetbrains.mps.newTypesystem.state.Inequalities(this);
    myNodeMaps = new jetbrains.mps.newTypesystem.state.NodeMaps(this);
    myVariableIdentifier = new VariableIdentifier();
    {
      myBlocksAndInputs.put(ConditionKind.SHALLOW, new ManyToManyMap<SNode, Block>());
      myBlocksAndInputs.put(ConditionKind.CONCRETE, new ManyToManyMap<SNode, Block>());
    }
  }


  @StateMethod
  public void addDependency(Block dataFlowBlock, SNode var, ConditionKind condition) {
    assertIsInStateChangeAction();
    ManyToManyMap<SNode, Block> map = myBlocksAndInputs.get(condition);
    map.addLink(var, dataFlowBlock);
  }

  @StateMethod
  public void removeDependency(Block dataFlowBlock, SNode var, ConditionKind condition) {
    assertIsInStateChangeAction();
    ManyToManyMap<SNode, Block> map = myBlocksAndInputs.get(condition);
    map.removeLink(var, dataFlowBlock);
  }

  @StateMethod
  public void removeBlockNoVars(Block dataFlowBlock) {
    assertIsInStateChangeAction();
    for (ManyToManyMap<SNode, Block> map : myBlocksAndInputs.values()) {
      assert !map.containsSecond(dataFlowBlock);
    }
    boolean removed = myBlocks.remove(dataFlowBlock);
    assert removed;
  }

  @StateMethod
  public void addBlockNoVars(Block dataFlowBlock) {
    assertIsInStateChangeAction();
    for (ManyToManyMap<SNode, Block> map : myBlocksAndInputs.values()) {
      assert !map.containsSecond(dataFlowBlock);
    }
    boolean addedAnew = myBlocks.add(dataFlowBlock);
    assert addedAnew;
  }

  public void substitute(SNode oldVar, SNode type) {
    for (ConditionKind conditionKind : myBlocksAndInputs.keySet()) {
      ManyToManyMap<SNode, Block> map = myBlocksAndInputs.get(conditionKind);
      Set<Block> blocks = map.getByFirst(oldVar);
      if (blocks == null) {
        return;
      }
      for (Block block : blocks) {
        for (SNode variable : conditionKind.getUnresolvedInputs(type, this)) {
          addInputAndTrack(block, variable, conditionKind);
        }
        removeInputAndTrack(block, oldVar, conditionKind);
        testInputsResolved(block);
      }
    }
  }

  private void addInputAndTrack(Block block, SNode var, ConditionKind conditionKind) {
    executeOperation(new AddDependencyOperation(block, var, conditionKind));
  }

  private void removeInputAndTrack(Block block, SNode var, ConditionKind conditionKind) {
    executeOperation(new RemoveDependencyOperation(block, var, conditionKind));
  }

  private void becameConcrete(Block block) {
    executeOperation(new RemoveBlockOperation(block));
  }

  public void addBlock(Block block) {
    executeOperation(new AddBlockOperation(block));
  }

  private void testInputsResolved(Block block) {
    boolean concrete = true;
    for (ManyToManyMap<SNode, Block> map : myBlocksAndInputs.values()) {
      concrete = concrete && map.getBySecond(block).isEmpty();
    }
    if (concrete) {
      becameConcrete(block);
    }
  }

  public void collectVarsExecuteIfNecessary(Block block) {
    Set<Pair<SNode,ConditionKind>> initialInputs = block.getInitialInputs();
    for (Pair<SNode,ConditionKind> input : initialInputs) {
      SNode type = input.first;
      ConditionKind conditionKind = input.second;
      for (SNode variable : conditionKind.getUnresolvedInputs(type, this)) {
        addInputAndTrack(block, variable, conditionKind);
      }
    }
    testInputsResolved(block);
  }


  //---------------------------------------------

  public Equations getEquations() {
    return myEquations;
  }

  public void addEquation(SNode left, SNode right, EquationInfo info) {
    myEquations.addEquation(left, right, info);
  }

  public void addInequality(SNode subType, SNode superType, boolean isWeak, boolean check, EquationInfo info) {
    myInequalities.addInequality(subType, superType, isWeak, check, info);
  }

  public void addRelation(SNode subType, SNode superType, jetbrains.mps.newTypesystem.state.RelationMapKind kind, EquationInfo info) {
    if (!kind.isComparable()) {
      myInequalities.addInequality(subType, superType, kind.isWeak(), kind.isCheckOnly(), info);
    } else {
      myInequalities.addComparableEquation(subType, superType, kind.isWeak(), info);
    }
  }

  public void addComparable(SNode subType, SNode superType, boolean isWeak, EquationInfo info) {
    myInequalities.addComparableEquation(subType, superType, isWeak, info);
  }

  public jetbrains.mps.newTypesystem.state.NodeMaps getNodeMaps() {
    return myNodeMaps;
  }

  public jetbrains.mps.newTypesystem.state.Inequalities getInequalities() {
    return myInequalities;
  }

  public TypeCheckingContextNew getTypeCheckingContext() {
    return myTypeCheckingContext;
  }

  public void executeStateChangeAction(Runnable action) {
    try {
      myInsideStateChangeAction = true;
      action.run();
    } finally {
      myInsideStateChangeAction = false;
    }
  }

  public void assertIsInStateChangeAction() {
    LOG.assertLog(myInsideStateChangeAction, "state change can be executed only inside state change action");
  }

  public void executeOperation(AbstractOperation operation) {
    if (operation == null) {
      return;
    }
    if (!myOperationStack.empty()) {
      myOperationStack.peek().addConsequence(operation);
    }
    myOperationStack.push(operation);
    try {
      operation.execute(this);
    } finally {
      myOperationStack.pop();
    }
  }

  @Deprecated
  public boolean isConcrete(SNode node) {
    return !TypesUtil.isVariable(node);
  }

  @Deprecated
  public boolean isConcrete(SNode node, boolean shallow) {
    return !TypesUtil.isVariable(node);
  }

  public void addError(SNode node, IErrorReporter error, EquationInfo info) {
    myNodeMaps.addNodeToError(node, error, info);
  }

  public SNode typeOf(SNode node, EquationInfo info) {
    return myNodeMaps.typeOf(node, info);
  }

  public void clear(boolean clearDiff) {
    myEquations.clear();
    myInequalities.clear();
    myNodeMaps.clear();
    myVariableIdentifier.clear();
    myBlocks.clear();
    for (ManyToManyMap map : myBlocksAndInputs.values()) {
      map.clear();
    }
    if (clearDiff) {
      myOperationStack.clear();
      myOperation = new CheckAllOperation();
      myOperationStack.push(myOperation);
    }
  }

  public void solveInequalities() {
    executeOperation(new AddRemarkOperation("Solving inequalities", new Runnable() {
      @Override
      public void run() {
        myInequalities.solveInequalities();
      }
    }));
  }

  public void checkInequalities() {
    executeOperation(new AddRemarkOperation("Checking inequalities", new Runnable() {
      @Override
      public void run() {
        myInequalities.check();
      }
    }));
  }

  public void checkNonConcreteWhenConcretes() {
    // todo
  }

  public SNode expand(SNode node) {
    return myEquations.expandNode(node);
  }

  public Stack<AbstractOperation> getOperationStack() {
    return myOperationStack;
  }

  public AbstractOperation getOperation() {
    return myOperation;
  }

  public void expandAll() {
    executeOperation(new AddRemarkOperation("Types Expansion", new Runnable() {
      @Override
      public void run() {
        myNodeMaps.expandAll();
      }
    }));
  }

  public boolean executeOperationsBeforeAnchor(AbstractOperation firstOp, Object anchor) {
    firstOp.redo(this);
    if (firstOp.equals(anchor)) {
      return true;
    }
    if (firstOp.getConsequences() == null) {
      return false;
    }
    for (AbstractOperation child : firstOp.getConsequences()) {
      if (executeOperationsBeforeAnchor(child, anchor)) {
        return true;
      }
    }
    return false;
  }

  public SNode getRepresentative(SNode node) {
    return myEquations.getRepresentative(node);
  }

  public SNode createNewRuntimeTypesVariable() {
    SNode typeVar = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.RuntimeTypeVariable",
      myTypeCheckingContext.getRuntimeTypesModel(), GlobalScope.getInstance(), false);
    typeVar.setName(myVariableIdentifier.getNewVarName());
//  registerTypeVariable(typeVar);          todo ?
    return typeVar;
  }

  public void reset() {
    clear(false);
    myOperation.playRecursively(this);
  }
}
