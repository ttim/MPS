package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_TreeSetCreator_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_TreeSetCreator_InferenceRule() {
  }

  public void applyRule(final SNode treeSetCreator, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if ((SLinkOperations.getTarget(treeSetCreator, "comparator", true) != null)) {
      final SNode ELEMENT_typevar_2261417478149018313 = typeCheckingContext.createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = treeSetCreator;
        BaseQuickFixProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "2261417478149018326", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "2261417478149018323", true), (SNode) new typeof_TreeSetCreator_InferenceRule.QuotationClass_3g5uu_a0a1a0a0().createNode(typeCheckingContext.getRepresentative(ELEMENT_typevar_2261417478149018313), typeCheckingContext), false, _info_12389875345);
      }
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(treeSetCreator, "comparator", true);
        BaseQuickFixProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "2261417478149018298", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "2261417478149018290", true), (SNode) new typeof_TreeSetCreator_InferenceRule.QuotationClass_3g5uu_a0a2a0a0().createNode(typeCheckingContext.getRepresentative(ELEMENT_typevar_2261417478149018313), typeCheckingContext.getRepresentative(ELEMENT_typevar_2261417478149018313), typeCheckingContext), false, _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.TreeSetCreator";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_3g5uu_a0a1a0a0 {
    public QuotationClass_3g5uu_a0a1a0a0() {
    }

    public SNode createNode(Object parameter_5, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedSetType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = CopyUtil.copy(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_4, typeCheckingContext));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedSetType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = CopyUtil.copy(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_3g5uu_a0a2a0a0 {
    public QuotationClass_3g5uu_a0a2a0a0() {
    }

    public SNode createNode(Object parameter_9, Object parameter_10, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.FunctionType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_9;
          SNode quotedNode1_6;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_6 = CopyUtil.copy(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_6 = quotedNode_2;
          }
          if (quotedNode1_6 != null) {
            quotedNode_1.addChild("parameterType", HUtil.copyIfNecessary(quotedNode1_6, typeCheckingContext));
          }
        }
        {
          quotedNode_3 = (SNode) parameter_10;
          SNode quotedNode1_7;
          if (_parameterValues_129834374.contains(quotedNode_3)) {
            quotedNode1_7 = CopyUtil.copy(quotedNode_3);
          } else {
            _parameterValues_129834374.add(quotedNode_3);
            quotedNode1_7 = quotedNode_3;
          }
          if (quotedNode1_7 != null) {
            quotedNode_1.addChild("parameterType", HUtil.copyIfNecessary(quotedNode1_7, typeCheckingContext));
          }
        }
        {
          quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_8 = quotedNode_4;
          quotedNode_1.addChild("resultType", quotedNode1_8);
        }
        result = quotedNode1_5;
      }
      return result;
    }

    public SNode createNode(Object parameter_9, Object parameter_10) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      SNode quotedNode_4 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.FunctionType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_5 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_9;
          SNode quotedNode1_6;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_6 = CopyUtil.copy(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_6 = quotedNode_2;
          }
          if (quotedNode1_6 != null) {
            quotedNode_1.addChild("parameterType", HUtil.copyIfNecessary(quotedNode1_6));
          }
        }
        {
          quotedNode_3 = (SNode) parameter_10;
          SNode quotedNode1_7;
          if (_parameterValues_129834374.contains(quotedNode_3)) {
            quotedNode1_7 = CopyUtil.copy(quotedNode_3);
          } else {
            _parameterValues_129834374.add(quotedNode_3);
            quotedNode1_7 = quotedNode_3;
          }
          if (quotedNode1_7 != null) {
            quotedNode_1.addChild("parameterType", HUtil.copyIfNecessary(quotedNode1_7));
          }
        }
        {
          quotedNode_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_8 = quotedNode_4;
          quotedNode_1.addChild("resultType", quotedNode1_8);
        }
        result = quotedNode1_5;
      }
      return result;
    }
  }
}
