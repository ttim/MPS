package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.pattern.util.MatchingUtil;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_ForeachWithErasure_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_ForeachWithErasure_NonTypesystemRule() {
  }

  public void applyRule(final SNode foreachStatement, final TypeCheckingContext typeCheckingContext) {
    SNode iterableType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(foreachStatement, "iterable", true));
    {
      _Patterns.Pattern_11 pattern_0 = new _Patterns.Pattern_11();
      SNode coercedNode_0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(iterableType, pattern_0, typeCheckingContext);
      if (coercedNode_0 != null) {
      } else {
        // not an iterable or an erasure
        if (!(MatchingUtil.matchNodes(SLinkOperations.getTarget(SLinkOperations.getTarget(foreachStatement, "variable", true), "type", true), new _Quotations.QuotationClass_126().createNode(typeCheckingContext)))) {
          {
            BaseIntentionProvider intentionProvider = null;
            IErrorTarget errorTarget = new NodeErrorTarget();
            typeCheckingContext.reportTypeError(SLinkOperations.getTarget(SLinkOperations.getTarget(foreachStatement, "variable", true), "type", true), "java.lang.Object expected", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "4312449433287189198", intentionProvider, errorTarget);
          }
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ForeachStatement";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
