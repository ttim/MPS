package jetbrains.mps.baseLanguage.closures.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import java.util.LinkedList;
import jetbrains.mps.lang.pattern.util.MatchingUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ClosureLiteral_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_ClosureLiteral_InferenceRule() {
  }

  public void applyRule(final SNode closure, final TypeCheckingContext typeCheckingContext) {
    List<SNode> paramTypes = new ArrayList<SNode>();
    for(SNode param : SLinkOperations.getTargets(closure, "parameter", true)) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(param, "type", true), "jetbrains.mps.baseLanguage.structure.WildCardType")) {
        final SNode pt_typevar_1221579075465 = typeCheckingContext.createNewRuntimeTypesVariable();
        {
          SNode _nodeToCheck_1029348928467 = closure;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createEquation(typeCheckingContext.getEquationManager().getRepresentator(pt_typevar_1221579075465), typeCheckingContext.typeOf(param, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075470", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075466", intentionProvider);
        }
        paramTypes.add(typeCheckingContext.getEquationManager().getRepresentator(pt_typevar_1221579075465));
      } else
      {
        paramTypes.add(SLinkOperations.getTarget(param, "type", true));
      }
    }
    List<SNode> allRets = new ArrayList<SNode>();
    List<SNode> allYlds = new ArrayList<SNode>();
    LinkedList<SNode> allStmts = new LinkedList<SNode>();
    List<SNode> allThrows = new ArrayList<SNode>();
    for(SNode c : SNodeOperations.getChildren(SLinkOperations.getTarget(closure, "body", true))) {
      if (SNodeOperations.isInstanceOf(c, "jetbrains.mps.baseLanguage.structure.ReturnStatement")) {
        allRets.add(c);
      } else
      if (SNodeOperations.isInstanceOf(c, "jetbrains.mps.baseLanguage.closures.structure.YieldStatement")) {
        allYlds.add(c);
      } else
      if (!(SNodeOperations.isInstanceOf(c, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock")) && !(SNodeOperations.isInstanceOf(c, "jetbrains.mps.baseLanguage.structure.IStatementListContainer"))) {
        allStmts.addLast(c);
      }
    }
    while (!(allStmts.isEmpty())) {
      SNode stmt = allStmts.removeFirst();
      if (SNodeOperations.isInstanceOf(stmt, "jetbrains.mps.baseLanguage.structure.ReturnStatement")) {
        allRets.add(stmt);
      } else
      if (SNodeOperations.isInstanceOf(stmt, "jetbrains.mps.baseLanguage.closures.structure.YieldStatement")) {
        allYlds.add(stmt);
      } else
      {
        if (SNodeOperations.isInstanceOf(stmt, "jetbrains.mps.baseLanguage.structure.ThrowStatement")) {
          final SNode tt_typevar_1221579075612 = typeCheckingContext.createNewRuntimeTypesVariable();
          {
            SNode _nodeToCheck_1029348928467 = closure;
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.createEquation(typeCheckingContext.getEquationManager().getRepresentator(tt_typevar_1221579075612), typeCheckingContext.typeOf(SLinkOperations.getTarget(stmt, "throwable", true), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075617", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075613", intentionProvider);
          }
          allThrows.add(typeCheckingContext.getEquationManager().getRepresentator(tt_typevar_1221579075612));
        } else
        if (SNodeOperations.isInstanceOf(stmt, "jetbrains.mps.baseLanguage.structure.IMethodCall")) {
          for(SNode thr : SLinkOperations.getTargets(SLinkOperations.getTarget(stmt, "baseMethodDeclaration", false), "throwsItem", true)) {
            allThrows.add(SNodeOperations.copyNode(thr));
          }
        }
        for(SNode c : SNodeOperations.getChildren(stmt)) {
          if (SNodeOperations.isInstanceOf(c, "jetbrains.mps.baseLanguage.structure.StatementList")) {
            for(SNode cstmt : SLinkOperations.getTargets(c, "statement", true)) {
              if (!(SNodeOperations.isInstanceOf(cstmt, "jetbrains.mps.baseLanguage.structure.CommentedStatementsBlock")) && !(SNodeOperations.isInstanceOf(cstmt, "jetbrains.mps.baseLanguage.structure.IStatementListContainer"))) {
                allStmts.addLast(cstmt);
              }
            }
          }
        }
      }
    }
    final SNode RLCS_typevar_1221579075692 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode YLCS_typevar_1221579075693 = typeCheckingContext.createNewRuntimeTypesVariable();
    boolean returnsValue = !(allRets.isEmpty());
    boolean yieldsValue = !(allYlds.isEmpty());
    for(SNode rs : allRets) {
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createGreaterThanInequation(typeCheckingContext.getEquationManager().getRepresentator(RLCS_typevar_1221579075692), typeCheckingContext.typeOf(SLinkOperations.getTarget(rs, "expression", true), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075714", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075710", false, 0, intentionProvider);
      }
    }
    for(SNode ys : allYlds) {
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createGreaterThanInequation(typeCheckingContext.getEquationManager().getRepresentator(YLCS_typevar_1221579075693), typeCheckingContext.typeOf(SLinkOperations.getTarget(ys, "expression", true), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075728", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075724", false, 0, intentionProvider);
      }
    }
    List<SNode> stmts = SLinkOperations.getTargets(SLinkOperations.getTarget(closure, "body", true), "statement", true);
    SNode lastStmt = (stmts != null && stmts.size() > 0 ?
      stmts.get(stmts.size() - 1) :
      null
    );
    final SNode RESULT_typevar_1221579592331 = typeCheckingContext.createNewRuntimeTypesVariable();
    if (SNodeOperations.isInstanceOf(lastStmt, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createGreaterThanInequation(typeCheckingContext.getEquationManager().getRepresentator(RLCS_typevar_1221579075692), typeCheckingContext.typeOf(SLinkOperations.getTarget(lastStmt, "expression", true), "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075774", true), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075770", false, 0, intentionProvider);
      }
      if (returnsValue) {
        {
          SNode _nodeToCheck_1029348928467 = closure;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createEquation(typeCheckingContext.getEquationManager().getRepresentator(RESULT_typevar_1221579592331), typeCheckingContext.getEquationManager().getRepresentator(RLCS_typevar_1221579075692), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221663085197", intentionProvider);
        }
      } else
      {
        {
          SNode _nodeToCheck_1029348928467 = closure;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createEquation(typeCheckingContext.getEquationManager().getRepresentator(RESULT_typevar_1221579592331), new _Quotations.QuotationClass_5().createNode(typeCheckingContext.getEquationManager().getRepresentator(RLCS_typevar_1221579075692), typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579747323", intentionProvider);
        }
      }
      returnsValue = true;
    } else
    {
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.getEquationManager().getRepresentator(RESULT_typevar_1221579592331), typeCheckingContext.getEquationManager().getRepresentator(RLCS_typevar_1221579075692), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221663751995", intentionProvider);
      }
    }
    List<SNode> realThrows = new ArrayList<SNode>();
with_allThrows:
    for(SNode another : allThrows) {
      for(SNode one : realThrows) {
        if (SNodeOperations.isInstanceOf(one, "jetbrains.mps.baseLanguage.structure.ClassifierType") && SNodeOperations.isInstanceOf(another, "jetbrains.mps.baseLanguage.structure.ClassifierType") && SLinkOperations.getTarget(one, "classifier", false) == SLinkOperations.getTarget(another, "classifier", false)) {
          continue with_allThrows;
        }
        if (MatchingUtil.matchNodes(one, another)) {
          continue with_allThrows;
        }
      }
      realThrows.add(another);
    }
    if (returnsValue && yieldsValue) {
      if (!(false)) {
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.reportTypeError(closure, "closure must either return or yield value", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075859", intentionProvider);
      }
    } else
    if (returnsValue) {
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.typeOf(closure, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075870", true), new _Quotations.QuotationClass_6().createNode(paramTypes, typeCheckingContext.getEquationManager().getRepresentator(RESULT_typevar_1221579592331), realThrows, typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075868", intentionProvider);
      }
    } else
    if (yieldsValue) {
      SNode st = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.collections.structure.SequenceType", null);
      SLinkOperations.setTarget(st, "elementType", typeCheckingContext.getEquationManager().getRepresentator(YLCS_typevar_1221579075693), true);
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.typeOf(closure, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075903", true), new _Quotations.QuotationClass_7().createNode(paramTypes, st, realThrows, typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075901", intentionProvider);
      }
    } else
    {
      {
        SNode _nodeToCheck_1029348928467 = closure;
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.createEquation(typeCheckingContext.typeOf(closure, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075922", true), new _Quotations.QuotationClass_8().createNode(paramTypes, realThrows, typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1221579075920", intentionProvider);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
