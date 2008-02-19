package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.dependencies.InferenceMethod;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import java.util.Set;
import jetbrains.mps.cfg.BasicBlock;
import jetbrains.mps.cfg.IControlFlowGraph;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;

public class RulesFunctions_BaseLanguage {

  @InferenceMethod()
  public static void comparisonOp(SNode binOp) {
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(binOp, "rightExpression", true), "jetbrains.mps.baseLanguage.helgins", "1176897133366", true), SLinkOperations.getTarget(new QuotationClass_26().createNode(), "descriptor", false), SLinkOperations.getTarget(binOp, "rightExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1176897142200");
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(binOp, "leftExpression", true), "jetbrains.mps.baseLanguage.helgins", "1176897185028", true), SLinkOperations.getTarget(new QuotationClass_27().createNode(), "descriptor", false), SLinkOperations.getTarget(binOp, "leftExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1176897185023");
    TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_28().createNode(), binOp, "jetbrains.mps.baseLanguage.helgins", "1176897196207");
  }

  @InferenceMethod()
  public static void numericOp(final SNode binOp) {
    final SNode rightExpressionType_typevar_1185962758265 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    final SNode leftExpressionType_typevar_1185962769627 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable(false);
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(binOp, "rightExpression", true), "jetbrains.mps.baseLanguage.helgins", "1185962985524", true), SLinkOperations.getTarget(binOp, "rightExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1185962983223");
    TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(binOp, "leftExpression", true), "jetbrains.mps.baseLanguage.helgins", "1185963005725", true), SLinkOperations.getTarget(binOp, "leftExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1185963003424");
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265), SLinkOperations.getTarget(new QuotationClass_29().createNode(), "descriptor", false), SLinkOperations.getTarget(binOp, "rightExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1176908856117");
    TypeChecker.getInstance().getRuntimeSupport().createLessThanInequation(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), SLinkOperations.getTarget(new QuotationClass_30().createNode(), "descriptor", false), SLinkOperations.getTarget(binOp, "leftExpression", true), null, "jetbrains.mps.baseLanguage.helgins", "1176908902743");
    TypeChecker.getInstance().getRuntimeSupport().whenConcrete(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), new Runnable() {

      public void run() {
        TypeChecker.getInstance().getRuntimeSupport().whenConcrete(TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265), new Runnable() {

          public void run() {
            TypeChecker.getInstance().getRuntimeSupport().givetype(Queries.getBinaryOperationType(TypeChecker.getInstance().getEquationManager().getRepresentator(leftExpressionType_typevar_1185962769627), TypeChecker.getInstance().getEquationManager().getRepresentator(rightExpressionType_typevar_1185962758265)), binOp, "jetbrains.mps.baseLanguage.helgins", "1185963109700");
          }

        }, "jetbrains.mps.baseLanguage.helgins", "1185963100352");
      }

    }, "jetbrains.mps.baseLanguage.helgins", "1185963072800");
  }

  public static Iterable<SNode> collectReturnStatements(SNode node) {
    Iterable<SNode> returnStatements = SequenceOperations.map(SNodeOperations.getChildren(node), new zMapper(null, null));
    return returnStatements;
  }

  public static SNode concreteTypeFromGenericType(SNode type, SNode genericClassifier, SNode instanceType) {
    SNode returnType = SNodeOperations.copyNode(type);
    if(genericClassifier == null) {
      return returnType;
    }
    {
      Pattern_1 pattern_1181217694220 = new Pattern_1(genericClassifier);
      SNode coercedNode_1181217694219 = TypeChecker.getInstance().getRuntimeSupport().coerce(instanceType, pattern_1181217694220);
      if(coercedNode_1181217694219 != null) {
        List<SNode> actualParams = pattern_1181217694220.PatternVar;
        for(SNode child : SNodeOperations.getDescendants(returnType, null, true)) {
          if(SNodeOperations.isInstanceOf(child, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")) {
            SNode tvr = child;
            SNode tvd = SLinkOperations.getTarget(tvr, "typeVariableDeclaration", false);
            int index = SequenceOperations.indexOf(SLinkOperations.getTargets(genericClassifier, "typeVariableDeclaration", true), tvd);
            SNode actualParam = (index < actualParams.size() && index >= 0 ?
              actualParams.get(index) :
              new QuotationClass_31().createNode()
            );
            if(returnType == tvr) {
              returnType = SNodeOperations.copyNode(actualParam, TypeChecker.getInstance().getRuntimeTypesModel());
            } else
            {
              // in this code the 'tvr' is not necessarily *child* of the 'returnType'.
              // in this case the replaceChild(old,new) fails with assertion.
              // new code is safe but might be not correct
              // returnType . replaceChild ( tvr , actualParam . copy ) ;
              SNodeOperations.replaceWithAnother(tvr, SNodeOperations.copyNode(actualParam));
            }
          }
        }
      }
    }
    return returnType;
  }

  public static Set<BasicBlock> findLastBlocks(IControlFlowGraph controlFlowGraph) {
    BasicBlock exit = controlFlowGraph.getExitBlock();
    Set<BasicBlock> lastBlocks = new HashSet<BasicBlock>();
    Set<BasicBlock> newLastBlocks = new HashSet<BasicBlock>();
    Set<BasicBlock> foundBlocks = new HashSet<BasicBlock>();
    Set<BasicBlock> passed = new HashSet<BasicBlock>();
    lastBlocks.add(exit);
    while(!(lastBlocks.isEmpty())) {
      for(BasicBlock lastBlock : lastBlocks) {
        passed.add(lastBlock);
        if(lastBlock.isFake()) {
          for(BasicBlock entry : lastBlock.getEntryStar()) {
            if(!(passed.contains(entry))) {
              newLastBlocks.add(entry);
            }
          }
        } else
        {
          foundBlocks.add(lastBlock);
        }
      }
      lastBlocks = newLastBlocks;
      newLastBlocks = new HashSet<BasicBlock>();
    }
    return foundBlocks;
  }

  public static boolean isWithinStatic(SNode node) {
    SNode staticAncestor = SNodeOperations.getAncestorWhereConceptInList(node, new String[]{"jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration","jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration"}, false, false);
    if(staticAncestor != null) {
      return true;
    }
    SNode statementList = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
    SNode prevStatementList = null;
    while((statementList != null)) {
      prevStatementList = statementList;
      statementList = SNodeOperations.getAncestor(statementList, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
    }
    if((prevStatementList != null)) {
      do {
        SNode matchedNode_1201700829805 = SNodeOperations.getParent(prevStatementList, null, false, false);
        {
          boolean matches_1201700829807 = false;
          matches_1201700829807 = SModelUtil_new.isAssignableConcept(SNodeOperations.getParent(prevStatementList, null, false, false).getConceptFqName(), "jetbrains.mps.baseLanguage.structure.ClassConcept");
          if(matches_1201700829807) {
            return SLinkOperations.getTarget(matchedNode_1201700829805, "staticInitializer", true) == prevStatementList;
          }
        }
      } while(false);
    }
    return false;
  }

}
