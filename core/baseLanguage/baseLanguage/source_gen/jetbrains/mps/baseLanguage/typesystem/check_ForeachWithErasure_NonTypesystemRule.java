package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.pattern.util.MatchingUtil;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class check_ForeachWithErasure_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_ForeachWithErasure_NonTypesystemRule() {
  }

  public void applyRule(final SNode foreachStatement, final TypeCheckingContext typeCheckingContext) {
    SNode iterableType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(foreachStatement, "iterable", true));
    if (SNodeOperations.isInstanceOf(iterableType, "jetbrains.mps.baseLanguage.structure.ArrayType")) {
      return;
    }
    {
      _Patterns.Pattern_11 pattern_0 = new _Patterns.Pattern_11();
      SNode coercedNode_0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(iterableType, pattern_0, typeCheckingContext);
      if (coercedNode_0 != null) {
      } else {
        // not an iterable or an erasure 
        if (!(MatchingUtil.matchNodes(SLinkOperations.getTarget(SLinkOperations.getTarget(foreachStatement, "variable", true), "type", true), new check_ForeachWithErasure_NonTypesystemRule.QuotationClass_9843_0().createNode(typeCheckingContext)))) {
          {
            BaseIntentionProvider intentionProvider = null;
            IErrorTarget errorTarget = new NodeErrorTarget();
            IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(SLinkOperations.getTarget(foreachStatement, "variable", true), "type", true), "java.lang.Object expected", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "4312449433287189198", intentionProvider, errorTarget);
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

  public static class QuotationClass_9843_0 {
    public QuotationClass_9843_0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_130 = null;
      {
        quotedNode_130 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_126 = quotedNode_130;
        quotedNode1_126.addReference(SReference.create("classifier", quotedNode1_126, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_126;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_130 = null;
      {
        quotedNode_130 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_126 = quotedNode_130;
        quotedNode1_126.addReference(SReference.create("classifier", quotedNode1_126, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_126;
      }
      return result;
    }
  }
}
