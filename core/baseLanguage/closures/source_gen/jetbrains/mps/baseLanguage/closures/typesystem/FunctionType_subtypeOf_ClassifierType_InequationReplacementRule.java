package jetbrains.mps.baseLanguage.closures.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInequationReplacementRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.baseLanguage.closures.constraints.ClassifierTypeUtil;
import java.util.Iterator;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;

public class FunctionType_subtypeOf_ClassifierType_InequationReplacementRule extends AbstractInequationReplacementRule_Runtime {

  public FunctionType_subtypeOf_ClassifierType_InequationReplacementRule() {
  }

  public void processInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, final TypeCheckingContext typeCheckingContext) {
    SNode classifier = SLinkOperations.getTarget(supertype, "classifier", false);
    String errorMsg = "";
    if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.Interface")) {
      List<SNode> methods = SLinkOperations.getTargets(classifier, "method", true);
      if (methods != null) {
        if (methods.size() > 1) {
          //  dirty hack
          errorMsg = ": interface must have only one method";
          {
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.reportWarning(equationInfo.getNodeWithError(), BaseConcept_Behavior.call_getPresentation_1213877396640(subtype) + " is not a subtype of " + BaseConcept_Behavior.call_getPresentation_1213877396640(supertype) + errorMsg, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1225908155523", intentionProvider);
          }
        }
        SNode md = methods.get(0);
        if (SLinkOperations.getCount(subtype, "parameterType") == SLinkOperations.getCount(md, "parameter")) {
          {
            SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.createLessThanInequation(SLinkOperations.getTarget(subtype, "resultType", true), ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(md, "returnType", true), supertype), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1202742499735", false, 0, intentionProvider);
          }
          {
            SNode fpt;
            SNode mpt;
            Iterator<SNode> fpt_iterator = SLinkOperations.getTargets(subtype, "parameterType", true).iterator();
            Iterator<SNode> mpt_iterator = SLinkOperations.getTargets(md, "parameter", true).iterator();
            while (true) {
              if (!(fpt_iterator.hasNext())) {
                break;
              }
              if (!(mpt_iterator.hasNext())) {
                break;
              }
              fpt = fpt_iterator.next();
              mpt = mpt_iterator.next();
              {
                SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
                BaseIntentionProvider intentionProvider = null;
                typeCheckingContext.createLessThanInequation(ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(mpt, "type", true), supertype), fpt, _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1202746383183", false, 0, intentionProvider);
              }
            }
          }
          return;
        } else
        {
          errorMsg = ": wrong parameter number";
        }
      } else
      {
        errorMsg = ": interface must define a method";
      }
    } else
    {
      errorMsg = ": not an interface";
    }
    {
      BaseIntentionProvider intentionProvider = null;
      typeCheckingContext.reportTypeError(equationInfo.getNodeWithError(), BaseConcept_Behavior.call_getPresentation_1213877396640(subtype) + " is not a subtype of " + BaseConcept_Behavior.call_getPresentation_1213877396640(supertype) + errorMsg, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1202742336483", intentionProvider);
    }
  }

  public boolean checkInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo) {
    boolean result_14532009 = true;
    {
      SNode classifier = SLinkOperations.getTarget(supertype, "classifier", false);
      String errorMsg = "";
      if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.Interface")) {
        List<SNode> methods = SLinkOperations.getTargets(classifier, "method", true);
        if (methods != null) {
          if (methods.size() > 1) {
            //  dirty hack
            errorMsg = ": interface must have only one method";
            // generated from warning statement
          }
          SNode md = methods.get(0);
          if (SLinkOperations.getCount(subtype, "parameterType") == SLinkOperations.getCount(md, "parameter")) {
            result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype(SLinkOperations.getTarget(subtype, "resultType", true), ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(md, "returnType", true), supertype), true);
            {
              SNode fpt;
              SNode mpt;
              Iterator<SNode> fpt_iterator = SLinkOperations.getTargets(subtype, "parameterType", true).iterator();
              Iterator<SNode> mpt_iterator = SLinkOperations.getTargets(md, "parameter", true).iterator();
              while (true) {
                if (!(fpt_iterator.hasNext())) {
                  break;
                }
                if (!(mpt_iterator.hasNext())) {
                  break;
                }
                fpt = fpt_iterator.next();
                mpt = mpt_iterator.next();
                result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype(ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(mpt, "type", true), supertype), fpt, true);
              }
            }
            return result_14532009;
          } else
          {
            errorMsg = ": wrong parameter number";
          }
        } else
        {
          errorMsg = ": interface must define a method";
        }
      } else
      {
        errorMsg = ": not an interface";
      }
      result_14532009 = false;
    }
    return result_14532009;
  }

  public boolean isWeak() {
    return true;
  }

  public boolean isApplicableSubtype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSubtypeConceptFQName());
  }

  public boolean isApplicableSupertype(SNode node) {
    return SModelUtil_new.isAssignableConcept(node.getConceptFqName(), this.getApplicableSupertypeConceptFQName());
  }

  public String getApplicableSubtypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.closures.structure.FunctionType";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

}
