package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
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

public class typeof_ToIteratorOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ToIteratorOperation_InferenceRule() {
  }

  public void applyRule(final SNode toIteratorOperation, final TypeCheckingContext typeCheckingContext) {
    SNode input = RulesFunctions_Collections.getInput(typeCheckingContext, toIteratorOperation);
    final SNode elementType_typevar_1207236221835 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = input;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207236221836", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207236221844", true), (SNode) new typeof_ToIteratorOperation_InferenceRule.QuotationClass_qlsgpf_a0a2a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1207236221835), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = toIteratorOperation;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207236274687", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1207236268944", true), (SNode) new typeof_ToIteratorOperation_InferenceRule.QuotationClass_qlsgpf_a0a3a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(elementType_typevar_1207236221835), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.ToIteratorOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_qlsgpf_a0a2a0 {
    public QuotationClass_qlsgpf_a0a2a0() {
    }

    public SNode createNode(Object parameter_qlsgpf_a0a0a0c0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_qlsgpf_a0a2a0 = null;
      SNode quotedNode_qlsgpf_a0a0c0a = null;
      {
        quotedNode_qlsgpf_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_qlsgpf_a0a2a0 = quotedNode_qlsgpf_a0a2a0;
        {
          quotedNode_qlsgpf_a0a0c0a = (SNode) parameter_qlsgpf_a0a0a0c0a;
          SNode quotedNode1_qlsgpf_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_qlsgpf_a0a0c0a)) {
            quotedNode1_qlsgpf_a0a0c0a = CopyUtil.copy(quotedNode_qlsgpf_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_qlsgpf_a0a0c0a);
            quotedNode1_qlsgpf_a0a0c0a = quotedNode_qlsgpf_a0a0c0a;
          }
          if (quotedNode1_qlsgpf_a0a0c0a != null) {
            quotedNode_qlsgpf_a0a2a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_qlsgpf_a0a0c0a, typeCheckingContext));
          }
        }
        result = quotedNode1_qlsgpf_a0a2a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_qlsgpf_a0a0a0c0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_qlsgpf_a0a2a0 = null;
      SNode quotedNode_qlsgpf_a0a0c0a = null;
      {
        quotedNode_qlsgpf_a0a2a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SequenceType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_qlsgpf_a0a2a0 = quotedNode_qlsgpf_a0a2a0;
        {
          quotedNode_qlsgpf_a0a0c0a = (SNode) parameter_qlsgpf_a0a0a0c0a;
          SNode quotedNode1_qlsgpf_a0a0c0a;
          if (_parameterValues_129834374.contains(quotedNode_qlsgpf_a0a0c0a)) {
            quotedNode1_qlsgpf_a0a0c0a = CopyUtil.copy(quotedNode_qlsgpf_a0a0c0a);
          } else {
            _parameterValues_129834374.add(quotedNode_qlsgpf_a0a0c0a);
            quotedNode1_qlsgpf_a0a0c0a = quotedNode_qlsgpf_a0a0c0a;
          }
          if (quotedNode1_qlsgpf_a0a0c0a != null) {
            quotedNode_qlsgpf_a0a2a0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_qlsgpf_a0a0c0a));
          }
        }
        result = quotedNode1_qlsgpf_a0a2a0;
      }
      return result;
    }
  }

  public static class QuotationClass_qlsgpf_a0a3a0 {
    public QuotationClass_qlsgpf_a0a3a0() {
    }

    public SNode createNode(Object parameter_qlsgpf_a0a0a0d0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_qlsgpf_a0a3a0 = null;
      SNode quotedNode_qlsgpf_a0a0d0a = null;
      {
        quotedNode_qlsgpf_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_qlsgpf_a0a3a0 = quotedNode_qlsgpf_a0a3a0;
        quotedNode1_qlsgpf_a0a3a0.addReference(SReference.create("classifier", quotedNode1_qlsgpf_a0a3a0, SModelReference.fromString("f:java_stub#java.util(java.util@java_stub)"), SNodeId.fromString("~Iterator")));
        {
          quotedNode_qlsgpf_a0a0d0a = (SNode) parameter_qlsgpf_a0a0a0d0a;
          SNode quotedNode1_qlsgpf_a0a0d0a;
          if (_parameterValues_129834374.contains(quotedNode_qlsgpf_a0a0d0a)) {
            quotedNode1_qlsgpf_a0a0d0a = CopyUtil.copy(quotedNode_qlsgpf_a0a0d0a);
          } else {
            _parameterValues_129834374.add(quotedNode_qlsgpf_a0a0d0a);
            quotedNode1_qlsgpf_a0a0d0a = quotedNode_qlsgpf_a0a0d0a;
          }
          if (quotedNode1_qlsgpf_a0a0d0a != null) {
            quotedNode_qlsgpf_a0a3a0.addChild("parameter", HUtil.copyIfNecessary(quotedNode1_qlsgpf_a0a0d0a, typeCheckingContext));
          }
        }
        result = quotedNode1_qlsgpf_a0a3a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_qlsgpf_a0a0a0d0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_qlsgpf_a0a3a0 = null;
      SNode quotedNode_qlsgpf_a0a0d0a = null;
      {
        quotedNode_qlsgpf_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_qlsgpf_a0a3a0 = quotedNode_qlsgpf_a0a3a0;
        quotedNode1_qlsgpf_a0a3a0.addReference(SReference.create("classifier", quotedNode1_qlsgpf_a0a3a0, SModelReference.fromString("f:java_stub#java.util(java.util@java_stub)"), SNodeId.fromString("~Iterator")));
        {
          quotedNode_qlsgpf_a0a0d0a = (SNode) parameter_qlsgpf_a0a0a0d0a;
          SNode quotedNode1_qlsgpf_a0a0d0a;
          if (_parameterValues_129834374.contains(quotedNode_qlsgpf_a0a0d0a)) {
            quotedNode1_qlsgpf_a0a0d0a = CopyUtil.copy(quotedNode_qlsgpf_a0a0d0a);
          } else {
            _parameterValues_129834374.add(quotedNode_qlsgpf_a0a0d0a);
            quotedNode1_qlsgpf_a0a0d0a = quotedNode_qlsgpf_a0a0d0a;
          }
          if (quotedNode1_qlsgpf_a0a0d0a != null) {
            quotedNode_qlsgpf_a0a3a0.addChild("parameter", HUtil.copyIfNecessary(quotedNode1_qlsgpf_a0a0d0a));
          }
        }
        result = quotedNode1_qlsgpf_a0a3a0;
      }
      return result;
    }
  }
}
