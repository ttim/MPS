package jetbrains.mps.samples.matrixLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class typeof_MatrixLiteral_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_MatrixLiteral_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    /*
      {
        SNode _nodeToCheck_1029348928467 = nodeToCheck;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210001196874", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210001192695", true), (SNode) new typeof_MatrixLiteral_InferenceRule.QuotationClass_5610_0().createNode(SLinkOperations.getTarget(nodeToCheck, "scalarType", true), typeCheckingContext), _info_12389875345);
      }
    */
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210167980571", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210167980581", true), (SNode) new typeof_MatrixLiteral_InferenceRule.QuotationClass_5610_1().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.samples.matrixLanguage.structure.MatrixLiteral";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_5610_0 {
    public QuotationClass_5610_0() {
    }

    public SNode createNode(Object parameter_5610_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_5610_0 = null;
      SNode quotedNode_5610_1 = null;
      {
        quotedNode_5610_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_5610_0 = quotedNode_5610_0;
        {
          quotedNode_5610_1 = (SNode) parameter_5610_0;
          SNode quotedNode1_0;
          if (_parameterValues_129834374.contains(quotedNode_5610_1)) {
            quotedNode1_0 = CopyUtil.copy(quotedNode_5610_1);
          } else {
            _parameterValues_129834374.add(quotedNode_5610_1);
            quotedNode1_0 = quotedNode_5610_1;
          }
          if (quotedNode1_0 != null) {
            quotedNode_5610_0.addChild("scalarType", HUtil.copyIfNecessary(quotedNode1_0, typeCheckingContext));
          }
        }
        result = quotedNode1_5610_0;
      }
      return result;
    }

    public SNode createNode(Object parameter_5610_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_5610_0 = null;
      SNode quotedNode_5610_1 = null;
      {
        quotedNode_5610_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_5610_0 = quotedNode_5610_0;
        {
          quotedNode_5610_1 = (SNode) parameter_5610_0;
          SNode quotedNode1_0;
          if (_parameterValues_129834374.contains(quotedNode_5610_1)) {
            quotedNode1_0 = CopyUtil.copy(quotedNode_5610_1);
          } else {
            _parameterValues_129834374.add(quotedNode_5610_1);
            quotedNode1_0 = quotedNode_5610_1;
          }
          if (quotedNode1_0 != null) {
            quotedNode_5610_0.addChild("scalarType", HUtil.copyIfNecessary(quotedNode1_0));
          }
        }
        result = quotedNode1_5610_0;
      }
      return result;
    }
  }

  public static class QuotationClass_5610_1 {
    public QuotationClass_5610_1() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_5610_2 = null;
      SNode quotedNode_5610_3 = null;
      {
        quotedNode_5610_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_5610_1 = quotedNode_5610_2;
        {
          quotedNode_5610_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_5610_2 = quotedNode_5610_3;
          quotedNode1_5610_2.addReference(SReference.create("classifier", quotedNode1_5610_2, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Double")));
          quotedNode_5610_2.addChild("scalarType", quotedNode1_5610_2);
        }
        result = quotedNode1_5610_1;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_5610_2 = null;
      SNode quotedNode_5610_3 = null;
      {
        quotedNode_5610_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_5610_1 = quotedNode_5610_2;
        {
          quotedNode_5610_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_5610_2 = quotedNode_5610_3;
          quotedNode1_5610_2.addReference(SReference.create("classifier", quotedNode1_5610_2, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Double")));
          quotedNode_5610_2.addChild("scalarType", quotedNode1_5610_2);
        }
        result = quotedNode1_5610_1;
      }
      return result;
    }
  }
}
