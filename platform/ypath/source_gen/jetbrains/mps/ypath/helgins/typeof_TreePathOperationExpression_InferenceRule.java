package jetbrains.mps.ypath.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.ypath.constraints.FeatureTargetTypeUtil;
import jetbrains.mps.ypath.behavior.ParameterWrapper_Behavior;
import jetbrains.mps.ypath.behavior.ITreePathExpression_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_TreePathOperationExpression_InferenceRule implements InferenceRule_Runtime {

  public typeof_TreePathOperationExpression_InferenceRule() {
  }

  public void applyRule(final SNode tpoe) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(tpoe, "operation", true), "jetbrains.mps.ypath.structure.IterateOperation")) {
      final SNode op = SLinkOperations.getTarget(tpoe, "operation", true);
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(op, "usedFeature", false), "jetbrains.mps.ypath.structure.IParamFeature")) {
        if (SPropertyOperations.getString(SLinkOperations.getTarget(op, "paramObject", true), "name") != null) {
          final SNode SourceType_typevar_1186145333005 = TypeChecker.getInstance().getRuntimeSupport().createNewRuntimeTypesVariable();
          {
            SNode _nodeToCheck_1029348928467 = tpoe;
            BaseIntentionProvider intentionProvider = null;
            TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getEquationManager().getRepresentator(SourceType_typevar_1186145333005), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(tpoe, "expression", true), "r:1222075024810(jetbrains.mps.ypath.helgins)", "1186145352982", true), _nodeToCheck_1029348928467, null, "r:1222075024810(jetbrains.mps.ypath.helgins)", "1186145347351", intentionProvider);
          }
          {
            final SNode _representatorVar1 = TypeChecker.getInstance().getEquationManager().getRepresentator(SourceType_typevar_1186145333005);
            TypeChecker.getInstance().getRuntimeSupport().whenConcrete(_representatorVar1, new Runnable() {

              public void run() {
                SNode targetType = FeatureTargetTypeUtil.getTargetType(SLinkOperations.getTarget(op, "usedFeature", false), SLinkOperations.getTarget(TypeChecker.getInstance().getEquationManager().getRepresentator(SourceType_typevar_1186145333005), "nodeType", true), ParameterWrapper_Behavior.call_getParameterValue_1213877312166(SLinkOperations.getTarget(op, "paramObject", true)));
                if (!((targetType != null))) {
                  TypeChecker.getInstance().reportTypeError(tpoe, "Received null target type", "r:1222075024810(jetbrains.mps.ypath.helgins)", "1196269826366");
                }
                if ((targetType != null)) {
                  TypeChecker.getInstance().getRuntimeSupport().givetype(new QuotationClass_1().createNode(targetType), tpoe, "r:1222075024810(jetbrains.mps.ypath.helgins)", "1196269933858");
                }
              }

            }, "r:1222075024810(jetbrains.mps.ypath.helgins)", "1186145326892");
          }
        }
      } else
      {
        SNode treePath = ITreePathExpression_Behavior.call_getTreePath_1213877496973(tpoe);
        if (treePath != null) {
          TypeChecker.getInstance().getRuntimeSupport().givetype(SLinkOperations.getTarget(treePath, "treePathType", true), tpoe, "r:1222075024810(jetbrains.mps.ypath.helgins)", "1196942474384");
        } else
        if (!(false)) {
          TypeChecker.getInstance().reportTypeError(tpoe, "No treepath found", "r:1222075024810(jetbrains.mps.ypath.helgins)", "1196942498551");
        }
      }
    } else
    {
      {
        SNode _nodeToCheck_1029348928467 = tpoe;
        BaseIntentionProvider intentionProvider = null;
        TypeChecker.getInstance().getRuntimeSupport().createEquation(TypeChecker.getInstance().getRuntimeSupport().typeOf(tpoe, "r:1222075024810(jetbrains.mps.ypath.helgins)", "1184588387870", true), TypeChecker.getInstance().getRuntimeSupport().typeOf(SLinkOperations.getTarget(tpoe, "expression", true), "r:1222075024810(jetbrains.mps.ypath.helgins)", "1184588395631", true), _nodeToCheck_1029348928467, null, "r:1222075024810(jetbrains.mps.ypath.helgins)", "1184588384882", intentionProvider);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.ypath.structure.TreePathOperationExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
