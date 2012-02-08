package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.smodel.search.AbstractSearchScope;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.search.IReferenceInfoResolver;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.scope.Scope;

public class LocalVariablesScope extends AbstractSearchScope {
  private SNode myContextNode;
  private List<SNode> myLocalVariables;

  public LocalVariablesScope(SNode contextNode) {
    this.myContextNode = contextNode;
  }

  @NotNull
  public List<SNode> getNodes(Condition<SNode> condition) {
    if (this.myLocalVariables == null) {
      this.myLocalVariables = new ArrayList<SNode>();
      SNode statementList = SNodeOperations.as(LocalVariablesScope.findThisOrParent(this.myContextNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ILocalVariableElementList")), "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList");
      if (statementList != null) {
        SNode currentStatement = SNodeOperations.as(LocalVariablesScope.findThisOrParent(this.myContextNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ILocalVariableElement")), "jetbrains.mps.baseLanguage.structure.ILocalVariableElement");
        this._populateLocalVariables(statementList, currentStatement, this.myLocalVariables);
      }
      // specially process loop variables 
      SNode loopStatement = SNodeOperations.as(LocalVariablesScope.findThisOrParent(this.myContextNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.AbstractLoopStatement")), "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement");
      if (loopStatement != null) {
        this._populateLocalVariables(loopStatement, this.myLocalVariables);
      }
      // specially process catch variables 
      SNode catchClause = SNodeOperations.as(LocalVariablesScope.findThisOrParent(this.myContextNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.CatchClause")), "jetbrains.mps.baseLanguage.structure.CatchClause");
      if (catchClause != null) {
        this._populateLocalVariablesForCatch(catchClause, this.myLocalVariables);
      }
      // specially process variables in switch cases before current 
      SNode switchStatement = SNodeOperations.as(findThisOrParent(myContextNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.SwitchStatement")), "jetbrains.mps.baseLanguage.structure.SwitchStatement");
      while ((switchStatement != null)) {
        SNode caseStatement = getLastSourceNode(this.myContextNode, switchStatement);
        if (caseStatement != SLinkOperations.getTarget(switchStatement, "expression", true) && caseStatement != switchStatement) {
          for (SNode caseClause : ListSequence.fromList(SLinkOperations.getTargets(switchStatement, "case", true))) {
            if (caseClause == caseStatement) {
              break;
            }
            _populateLocalVariablesFromList(SLinkOperations.getTarget(caseClause, "body", true), null, myLocalVariables);
          }
        }
        switchStatement = SNodeOperations.as(findThisOrParent(SNodeOperations.getParent(switchStatement), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.SwitchStatement")), "jetbrains.mps.baseLanguage.structure.SwitchStatement");
      }
      // filter nulls 
      List<SNode> tmp = new ArrayList();
      for (SNode node : myLocalVariables) {
        if (node != null) {
          tmp.add(node);
        }
      }
      myLocalVariables = tmp;
    }
    if (condition == AbstractSearchScope.TRUE_CONDITION) {
      return this.myLocalVariables;
    }
    List<SNode> result = new ArrayList<SNode>(this.myLocalVariables.size());
    for (SNode node : this.myLocalVariables) {
      if (condition.met(node)) {
        result.add(node);
      }
    }
    return result;
  }

  private void _populateLocalVariables(SNode statementList, SNode beforeStatement, List<SNode> result) {
    if (statementList == null) {
      return;
    }
    if (statementList != beforeStatement) {
      this._populateLocalVariablesFromList(statementList, beforeStatement, result);
    }
    SNode containingStatement = SNodeOperations.as(LocalVariablesScope.findThisOrParent(statementList, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ILocalVariableElement")), "jetbrains.mps.baseLanguage.structure.ILocalVariableElement");
    if (containingStatement != null) {
      statementList = SNodeOperations.getAncestor(containingStatement, "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList", false, false);
      this._populateLocalVariables(statementList, containingStatement, result);
    }
  }

  private void _populateLocalVariablesFromList(SNode statementList, SNode beforeStatement, List<SNode> result) {
    for (SNode sNode : ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(statementList, "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList"), "virtual_getLocalVariableElements_1238805763253", new Class[]{SNode.class}))) {
      // todo: bad code =( 
      if (ListSequence.fromList(SNodeOperations.getAncestors(beforeStatement, null, false)).contains(sNode)) {
        break;
      }

      if (sNode == beforeStatement) {
        break;
      }
      if (!(SNodeOperations.isInstanceOf(sNode, "jetbrains.mps.baseLanguage.structure.ILocalVariableElement"))) {
        continue;
      }
      SNode declNode = ((SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(sNode, "jetbrains.mps.baseLanguage.structure.ILocalVariableElement"), "virtual_getLocalVariableDeclaration_1238803857389", new Class[]{SNode.class}));
      if (declNode != null) {
        result.add(declNode);
      }
    }
  }

  private void _populateLocalVariables(SNode loopStatement, List<SNode> result) {
    for (SNode child : SNodeOperations.getChildren(loopStatement)) {
      if (child.getRole_().equals("body")) {
        continue;
      }
      if (SNodeOperations.isInstanceOf(child, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
        result.add(child);
      }

      // <node> 
      List<SNode> moreChildren = new ArrayList<SNode>();
      if (SNodeOperations.isInstanceOf(loopStatement, "jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop")) {
        ListSequence.fromList(moreChildren).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(loopStatement, "jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop"), "loopVariable", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return (SLinkOperations.getTarget(it, "variable", true) != null);
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(it, "variable", true);
          }
        }));
      }
      for (SNode child_ : moreChildren) {
        result.add(child_);
      }
    }

    SNode containingLoop = SNodeOperations.as(LocalVariablesScope.findThisOrParent(SNodeOperations.getParent(loopStatement), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.AbstractLoopStatement")), "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement");
    if (containingLoop != null) {
      this._populateLocalVariables(containingLoop, result);
    }
  }

  private void _populateLocalVariablesForCatch(SNode tryCatchStatement, List<SNode> result) {
    SNode throwable = SLinkOperations.getTarget(tryCatchStatement, "throwable", true);
    if (throwable != null) {
      result.add(throwable);
    }
    SNode containingCatchClause = SNodeOperations.as(LocalVariablesScope.findThisOrParent(SNodeOperations.getParent(tryCatchStatement), SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.CatchClause")), "jetbrains.mps.baseLanguage.structure.CatchClause");
    if (containingCatchClause != null) {
      this._populateLocalVariablesForCatch(containingCatchClause, result);
    }
  }

  @Override
  public IReferenceInfoResolver getReferenceInfoResolver(SNode referenceNode, SNode targetConcept) {
    if (SModelUtil.isAssignableConcept(targetConcept, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"))) {
      return new IReferenceInfoResolver() {
        public SNode resolve(String referenceInfo, SModelReference targetModelReference) {
          if (referenceInfo == null) {
            return null;
          }
          for (SNode node : LocalVariablesScope.this.getNodes(AbstractSearchScope.TRUE_CONDITION)) {
            if (referenceInfo.equals(node.getName())) {
              return node;
            }
          }
          return null;
        }
      };
    }
    return super.getReferenceInfoResolver(referenceNode, targetConcept);
  }

  private static SNode findThisOrParent(SNode sourceNode, SNode concept) {
    SNode testNode = sourceNode;
    while (testNode != null) {
      if (testNode.isInstanceOfConcept(concept)) {
        return testNode;
      }
      if (SNodeOperations.isInstanceOf(testNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction") && !(SNodeOperations.isInstanceOf(testNode, "jetbrains.mps.baseLanguage.structure.Closure"))) {
        break;
      }
      testNode = Scope.parent(testNode);
    }
    return null;
  }

  private static SNode getLastSourceNode(SNode sourceNode, SNode ancestorNode) {
    if (sourceNode == ancestorNode) {
      return sourceNode;
    }
    SNode testNode = sourceNode;
    while (ancestorNode != Scope.parent(testNode)) {
      testNode = Scope.parent(testNode);
    }
    return testNode;
  }
}
