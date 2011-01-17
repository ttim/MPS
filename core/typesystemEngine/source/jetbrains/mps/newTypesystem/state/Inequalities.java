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

import jetbrains.mps.newTypesystem.SubTyping;
import jetbrains.mps.newTypesystem.TypesUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.util.ManyToManyMap;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 10, 2010
 * Time: 5:26:43 PM
 */
public class Inequalities {
  private final State myState;
  ManyToManyMap<SNode, SNode> myInputsToOutputs = new ManyToManyMap<SNode, SNode>();
  ManyToManyMap<SNode, InequalityBlock> myNodesToBlocks = new ManyToManyMap<SNode, InequalityBlock>();
  Set<SNode> myNodes = new LinkedHashSet<SNode>();

  private boolean solvingInProcess = false;

  public Inequalities(State state) {
    myState = state;
  }

  private SNode getNodeWithNoInput(ManyToManyMap<SNode, SNode> inputsToOutputs, Set<SNode> unsorted) {
    for (SNode node : unsorted) {
      if (inputsToOutputs.getBySecond(node).isEmpty()) {
        return node;
      }
    }
    return unsorted.iterator().next();
  }

  private List<SNode> sort(ManyToManyMap<SNode, SNode> inputsToOutputs, Set<SNode> unsorted) {
    SNode node = unsorted.iterator().next();
    int size = unsorted.size();
    List<SNode> result = new LinkedList<SNode>();
    while (result.size() < size) {
      SNode current = getNodeWithNoInput(inputsToOutputs, unsorted);
      result.add(current);
      unsorted.remove(current);
      if (unsorted.isEmpty()) {
        assert result.size() == size;
        return result;
      }
      if (inputsToOutputs.getByFirst(current).isEmpty()) {
        node = unsorted.iterator().next();
      } else {
        node = inputsToOutputs.getByFirst(current).iterator().next();
      }
      inputsToOutputs.clearFirst(current);
    }
    return result;
  }

  private List<InequalityBlock> getInequalitiesToSolve() {
    List<InequalityBlock> result = new LinkedList<InequalityBlock>();
    Set<Block> set = myState.getBlocks(BlockKind.INEQUALITY);
    for (Block block : set) {
      InequalityBlock inequality = (InequalityBlock) block;
      if (!inequality.getRelationKind().isCheckOnly()) {
        result.add(inequality);
      }
    }
    return result;
  }

  public void solveInequalities() {
    solvingInProcess = true;
    List<InequalityBlock> inequalities = getInequalitiesToSolve();
    initializeMaps(inequalities);
    while (iteration(inequalities)) {
      inequalities = getInequalitiesToSolve();
    }
  }

  private void addVariablesLink(SNode input, SNode output) {
    if (TypesUtil.isVariable(input) && TypesUtil.isVariable(output)) {
      myInputsToOutputs.addLink(input, output);
    }
  }

  private void initializeMaps(List<InequalityBlock> inequalities) {
    myInputsToOutputs.clear();
    myNodesToBlocks.clear();
    myNodes.clear();
    for (InequalityBlock inequality : inequalities) {
      SNode input = myState.getRepresentative(inequality.getInput());
      SNode output = myState.getRepresentative(inequality.getOutput());
      if (input != null) {
        if (TypesUtil.isVariable(input)) {
          myNodes.add(input);
        }
        if (TypesUtil.isVariable(output)) {
          myNodes.add(output);
        }
        if (input != output) {
          addVariablesLink(input, output);
          myNodesToBlocks.addLink(input, inequality);
          if (!TypesUtil.isVariable(input) && !TypesUtil.isVariable(output)) {
            List<SNode> inputVariables= TypesUtil.getVariables(input);
            List<SNode> outputVariables = TypesUtil.getVariables(output);
            myNodes.addAll(inputVariables);
            myNodes.addAll(outputVariables);
            for (SNode inputVar : inputVariables) {
              for (SNode outputVar : outputVariables) {
                addVariablesLink(myState.getRepresentative(inputVar), myState.getRepresentative(outputVar));
              }
            }
          }
        }
        myNodesToBlocks.addLink(output, inequality);
      }
    }
  }

  private boolean iteration(List<InequalityBlock> inequalities) {
    initializeMaps(inequalities);
    if (myNodes.size() == 0) {
      return false;
    }
    List<SNode> sortedNodes = sort(myInputsToOutputs, myNodes);
    for (SNode node: sortedNodes) {
   // SNode node = getNodeWithNoInput(myInputsToOutputs, nodes.iterator().next(),nodes.size());
      if (solveInequalitiesForNode(node)) {
       return true;
      }
    }
    //last chance
    for (InequalityBlock inequality : inequalities) {
      if (inequality.processReplacementRules()) {
        return true;
      }
    }
    return false;
  }

  private boolean solveInequalitiesForNode(SNode node) {
    Map<SNode, InequalityBlock> typesToBlocks = new HashMap<SNode, InequalityBlock>();
    assert TypesUtil.isVariable(node);
    Set<InequalityBlock> blocks = myNodesToBlocks.getByFirst(node);
    Set<SNode> superTypes = new LinkedHashSet<SNode>();
    Set<SNode> subTypes = new LinkedHashSet<SNode>();
    for (InequalityBlock block : blocks) {
      if (block.getRelationKind().isCheckOnly()) {
        continue;
      }
      SNode left = myState.getRepresentative(block.getLeftNode());
      SNode right = myState.getRepresentative(block.getRightNode());
      if (right == left) {
        continue;
      }
      if (left == node && !TypesUtil.isVariable(right)) {
        superTypes.add(right);
        typesToBlocks.put(right, block);
      }
      if (right == node && !TypesUtil.isVariable(left)) {
        subTypes.add(left);
        typesToBlocks.put(left, block);
      }
    }
    SubTyping subTyping = new SubTyping(myState);
    SNode result = null;
    EquationInfo info = null;
    if (!subTypes.isEmpty()) {
      result = subTyping.createLCS(subTypes);
      InequalityBlock block = typesToBlocks.get(result);
      info = (block != null) ? block.getEquationInfo() : typesToBlocks.get(subTypes.iterator().next()).getEquationInfo();
    } else if (!superTypes.isEmpty()) {
      result = subTyping.createMeet(superTypes);
      InequalityBlock block = typesToBlocks.get(result);
      info = (block != null) ? block.getEquationInfo() : typesToBlocks.get(superTypes.iterator().next()).getEquationInfo();
    }
    if (result != null) {
      myState.addEquation(node, result, info);
    }
    return result != null;
  }



  public Map<Set<SNode>, Set<InequalityBlock>> getInequalityGroups(Set<Block> inequalities) {
    Map<SNode, Set<SNode>> components = new HashMap<SNode, Set<SNode>>();
    Map<Set<SNode>, Set<InequalityBlock>> groupsToInequalities = new HashMap<Set<SNode>, Set<InequalityBlock>>();
    for (Block block : inequalities) {
      InequalityBlock inequality = (InequalityBlock) block;

      List<SNode> variables = TypesUtil.getVariables(myState.expand(inequality.getRightNode()));
      variables.addAll(TypesUtil.getVariables(myState.expand(inequality.getLeftNode())));
      if (variables.size() == 0) {
        continue;
      }
      Set<SNode> currentResult = new HashSet<SNode>();

      Set<InequalityBlock> currentInequalities = new HashSet<InequalityBlock>();
      currentInequalities.add(inequality);
      for (SNode var : variables) {
        var = myState.getRepresentative(var);
        currentResult.add(var);
        Set<SNode> varGroup = components.remove(var);
        if (varGroup != null) {
          currentResult.addAll(varGroup);
          for (SNode var2 : varGroup) {
            if (!variables.contains(var2)) {
              components.put(var2, currentResult);
            }
          }
        }
        components.put(var, currentResult);
        Set<InequalityBlock> remove = groupsToInequalities.remove(varGroup);
        if (remove != null) {
          currentInequalities.addAll(remove);
        }
      }
      groupsToInequalities.put(currentResult, currentInequalities);
    }
    return groupsToInequalities;
  }

  public void clear() {

  }

  private void iteration_Old( List<InequalityBlock> inequalities) {
    Set<SNode> nodes = new LinkedHashSet<SNode>();
    ManyToManyMap<SNode, SNode> inputsToOutputs = new ManyToManyMap<SNode, SNode>();
    ManyToManyMap<SNode, InequalityBlock> nodesToBlocks = new ManyToManyMap<SNode, InequalityBlock>();
    for (InequalityBlock inequality : inequalities) {

      SNode input = myState.getRepresentative(inequality.getInput());
      SNode output = myState.getRepresentative(inequality.getOutput());
      if (input != null) {
        if (input != output) {
          inputsToOutputs.addLink(input, output);
          nodesToBlocks.addLink(input, inequality);
          nodes.add(input);
          if (!TypesUtil.isVariable(input) && !TypesUtil.isVariable(output)) {
            for (SNode inputVar : TypesUtil.getVariables(input)) {
              for (SNode outputVar : TypesUtil.getVariables(output)) {
                inputsToOutputs.addLink(myState.getRepresentative(inputVar), myState.getRepresentative(outputVar));
              }
            }
          }
        }
        nodesToBlocks.addLink(output, inequality);
        nodes.add(output);
      }

    }

  //  System.out.println(nodes);
    if (nodes.isEmpty()) {
      return;
    }
    List<SNode> sortedNodes = sort(inputsToOutputs, nodes);

    Map<SNode, InequalityBlock> typesToBlocks = new HashMap<SNode, InequalityBlock>();
    //System.out.println(sortedNodes);

    for (SNode node : sortedNodes) {
      //todo shallow concrete
      if (!TypesUtil.isVariable(node)) {
        continue;
      }
      Set<InequalityBlock> blocks = nodesToBlocks.getByFirst(node);
      Set<SNode> superTypes = new LinkedHashSet<SNode>();
      Set<SNode> subTypes = new LinkedHashSet<SNode>();
      for (InequalityBlock block : blocks) {
        if (block.getRelationKind().isCheckOnly()) {
          continue;
        }
        SNode left = myState.getRepresentative(block.getLeftNode());
        SNode right = myState.getRepresentative(block.getRightNode());
        if (right == left) {
          continue;
        }
        if (left == node && !TypesUtil.isVariable(right)) {
          superTypes.add(right);
          typesToBlocks.put(right, block);
        }
        if (right == node && !TypesUtil.isVariable(left)) {
          subTypes.add(left);
          typesToBlocks.put(left, block);
        }
      }
      SubTyping subTyping = new SubTyping(myState);
      if (TypesUtil.isVariable(node)) {
        SNode result = null;
        EquationInfo info = null;
        if (!subTypes.isEmpty()) {
          result = subTyping.createLCS(subTypes);
          InequalityBlock block = typesToBlocks.get(result);
          info = (block != null) ? block.getEquationInfo() : typesToBlocks.get(subTypes.iterator().next()).getEquationInfo();
        } else if (!superTypes.isEmpty()) {
          result = subTyping.createMeet(superTypes);
          InequalityBlock block = typesToBlocks.get(result);
          info = (block != null) ? block.getEquationInfo() : typesToBlocks.get(superTypes.iterator().next()).getEquationInfo();
        }
        if (result != null) {
          myState.addEquation(node, result, info);
        }
      } else {
      }
    }
  }

}
