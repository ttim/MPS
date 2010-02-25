package jetbrains.mps.baseLanguage.collections.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
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

public class typeof_SubMapOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_SubMapOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    final SNode KEY_TYPE_typevar_1240240358091 = typeCheckingContext.createNewRuntimeTypesVariable();
    final SNode VALUE_TYPE_typevar_1240240358092 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = IOperation_Behavior.call_getOperand_1213877410070(operation);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358093", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358104", true), (SNode) new typeof_SubMapOperation_InferenceRule.QuotationClass_4083_l523emneb60g().createNode(typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), typeCheckingContext.getEquationManager().getRepresentator(VALUE_TYPE_typevar_1240240358092), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(operation, "fromKey", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358108", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358112", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(operation, "toKey", true);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240364211", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240364215", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = operation;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358116", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c8959032b(jetbrains.mps.baseLanguage.collections.typesystem)", "1240240358118", true), (SNode) new typeof_SubMapOperation_InferenceRule.QuotationClass_4083_l523emneb65a().createNode(typeCheckingContext.getEquationManager().getRepresentator(KEY_TYPE_typevar_1240240358091), typeCheckingContext.getEquationManager().getRepresentator(VALUE_TYPE_typevar_1240240358092), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.collections.structure.SubMapOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_4083_l523emneb60g {
    public QuotationClass_4083_l523emneb60g() {
    }

    public SNode createNode(Object parameter_4083_l523emneapj7, Object parameter_4083_l523emneapje, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_4083_l523emneaphy = null;
      SNode quotedNode_4083_l523emneaphz = null;
      SNode quotedNode_4083_l523emneapi1 = null;
      {
        quotedNode_4083_l523emneaphy = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_4083_l523emneaphy = quotedNode_4083_l523emneaphy;
        {
          quotedNode_4083_l523emneaphz = (SNode) parameter_4083_l523emneapj7;
          SNode quotedNode1_4083_l523emneaphz;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneaphz)) {
            quotedNode1_4083_l523emneaphz = CopyUtil.copy(quotedNode_4083_l523emneaphz);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneaphz);
            quotedNode1_4083_l523emneaphz = quotedNode_4083_l523emneaphz;
          }
          if (quotedNode1_4083_l523emneaphz != null) {
            quotedNode_4083_l523emneaphy.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneaphz, typeCheckingContext));
          }
        }
        {
          quotedNode_4083_l523emneapi1 = (SNode) parameter_4083_l523emneapje;
          SNode quotedNode1_4083_l523emneapi1;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneapi1)) {
            quotedNode1_4083_l523emneapi1 = CopyUtil.copy(quotedNode_4083_l523emneapi1);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneapi1);
            quotedNode1_4083_l523emneapi1 = quotedNode_4083_l523emneapi1;
          }
          if (quotedNode1_4083_l523emneapi1 != null) {
            quotedNode_4083_l523emneaphy.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneapi1, typeCheckingContext));
          }
        }
        result = quotedNode1_4083_l523emneaphy;
      }
      return result;
    }

    public SNode createNode(Object parameter_4083_l523emneapj7, Object parameter_4083_l523emneapje) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_4083_l523emneaphy = null;
      SNode quotedNode_4083_l523emneaphz = null;
      SNode quotedNode_4083_l523emneapi1 = null;
      {
        quotedNode_4083_l523emneaphy = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_4083_l523emneaphy = quotedNode_4083_l523emneaphy;
        {
          quotedNode_4083_l523emneaphz = (SNode) parameter_4083_l523emneapj7;
          SNode quotedNode1_4083_l523emneaphz;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneaphz)) {
            quotedNode1_4083_l523emneaphz = CopyUtil.copy(quotedNode_4083_l523emneaphz);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneaphz);
            quotedNode1_4083_l523emneaphz = quotedNode_4083_l523emneaphz;
          }
          if (quotedNode1_4083_l523emneaphz != null) {
            quotedNode_4083_l523emneaphy.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneaphz));
          }
        }
        {
          quotedNode_4083_l523emneapi1 = (SNode) parameter_4083_l523emneapje;
          SNode quotedNode1_4083_l523emneapi1;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneapi1)) {
            quotedNode1_4083_l523emneapi1 = CopyUtil.copy(quotedNode_4083_l523emneapi1);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneapi1);
            quotedNode1_4083_l523emneapi1 = quotedNode_4083_l523emneapi1;
          }
          if (quotedNode1_4083_l523emneapi1 != null) {
            quotedNode_4083_l523emneaphy.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneapi1));
          }
        }
        result = quotedNode1_4083_l523emneaphy;
      }
      return result;
    }
  }

  public static class QuotationClass_4083_l523emneb65a {
    public QuotationClass_4083_l523emneb65a() {
    }

    public SNode createNode(Object parameter_4083_l523emneapk8, Object parameter_4083_l523emneapkf, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_4083_l523emneapie = null;
      SNode quotedNode_4083_l523emneapif = null;
      SNode quotedNode_4083_l523emneapih = null;
      {
        quotedNode_4083_l523emneapie = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_4083_l523emneapie = quotedNode_4083_l523emneapie;
        {
          quotedNode_4083_l523emneapif = (SNode) parameter_4083_l523emneapk8;
          SNode quotedNode1_4083_l523emneapif;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneapif)) {
            quotedNode1_4083_l523emneapif = CopyUtil.copy(quotedNode_4083_l523emneapif);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneapif);
            quotedNode1_4083_l523emneapif = quotedNode_4083_l523emneapif;
          }
          if (quotedNode1_4083_l523emneapif != null) {
            quotedNode_4083_l523emneapie.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneapif, typeCheckingContext));
          }
        }
        {
          quotedNode_4083_l523emneapih = (SNode) parameter_4083_l523emneapkf;
          SNode quotedNode1_4083_l523emneapih;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneapih)) {
            quotedNode1_4083_l523emneapih = CopyUtil.copy(quotedNode_4083_l523emneapih);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneapih);
            quotedNode1_4083_l523emneapih = quotedNode_4083_l523emneapih;
          }
          if (quotedNode1_4083_l523emneapih != null) {
            quotedNode_4083_l523emneapie.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneapih, typeCheckingContext));
          }
        }
        result = quotedNode1_4083_l523emneapie;
      }
      return result;
    }

    public SNode createNode(Object parameter_4083_l523emneapk8, Object parameter_4083_l523emneapkf) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_4083_l523emneapie = null;
      SNode quotedNode_4083_l523emneapif = null;
      SNode quotedNode_4083_l523emneapih = null;
      {
        quotedNode_4083_l523emneapie = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.SortedMapType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_4083_l523emneapie = quotedNode_4083_l523emneapie;
        {
          quotedNode_4083_l523emneapif = (SNode) parameter_4083_l523emneapk8;
          SNode quotedNode1_4083_l523emneapif;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneapif)) {
            quotedNode1_4083_l523emneapif = CopyUtil.copy(quotedNode_4083_l523emneapif);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneapif);
            quotedNode1_4083_l523emneapif = quotedNode_4083_l523emneapif;
          }
          if (quotedNode1_4083_l523emneapif != null) {
            quotedNode_4083_l523emneapie.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneapif));
          }
        }
        {
          quotedNode_4083_l523emneapih = (SNode) parameter_4083_l523emneapkf;
          SNode quotedNode1_4083_l523emneapih;
          if (_parameterValues_129834374.contains(quotedNode_4083_l523emneapih)) {
            quotedNode1_4083_l523emneapih = CopyUtil.copy(quotedNode_4083_l523emneapih);
          } else {
            _parameterValues_129834374.add(quotedNode_4083_l523emneapih);
            quotedNode1_4083_l523emneapih = quotedNode_4083_l523emneapih;
          }
          if (quotedNode1_4083_l523emneapih != null) {
            quotedNode_4083_l523emneapie.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_4083_l523emneapih));
          }
        }
        result = quotedNode1_4083_l523emneapie;
      }
      return result;
    }
  }
}
