package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.behavior.SNodeOperation_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.lang.structure.behavior.DataTypeDeclaration_Behavior;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_Property_SetOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_Property_SetOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    SNode leftOperation = SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op);
    if (!(SNodeOperations.isInstanceOf(leftOperation, "jetbrains.mps.lang.smodel.structure.SPropertyAccess"))) {
      return;
    }
    SNode propertyAccessOp = SNodeOperations.cast(leftOperation, "jetbrains.mps.lang.smodel.structure.SPropertyAccess");
    SNode dataType = SLinkOperations.getTarget(SLinkOperations.getTarget(propertyAccessOp, "property", false), "dataType", false);
    if (!((dataType != null))) {
      BaseIntentionProvider intentionProvider = null;
      IErrorTarget errorTarget = new NodeErrorTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(op, "couldn't define accessed property datatype", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059295963", intentionProvider, errorTarget);
    }
    SNode value = SLinkOperations.getTarget(op, "value", true);
    if ((value != null)) {
      if (DataTypeDeclaration_Behavior.call_isSimpleString_1220268704138(dataType)) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059295979", 0, intentionProvider);
          _info_12389875345.setInequationGroup("default");
          typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059295984", true), (SNode) new typeof_Property_SetOperation_InferenceRule.QuotationClass_txyj5n_a0a0a0a6a0().createNode(typeCheckingContext), false, _info_12389875345);
        }
      } else
      if (DataTypeDeclaration_Behavior.call_isSimpleInteger_1220268868375(dataType)) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059295992", 0, intentionProvider);
          _info_12389875345.setInequationGroup("default");
          typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059295997", true), (SNode) new typeof_Property_SetOperation_InferenceRule.QuotationClass_txyj5n_a0a0a0a0g0a().createNode(typeCheckingContext), false, _info_12389875345);
        }
      } else
      if (DataTypeDeclaration_Behavior.call_isSimpleBoolean_1220268891062(dataType)) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059296005", 0, intentionProvider);
          _info_12389875345.setInequationGroup("default");
          typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059296010", true), (SNode) new typeof_Property_SetOperation_InferenceRule.QuotationClass_txyj5n_a0a0a0a0a6a0().createNode(typeCheckingContext), false, _info_12389875345);
        }
      } else
      if (DataTypeDeclaration_Behavior.call_isEnum_1220268692373(dataType)) {
        if (!(SNodeOperations.isInstanceOf(value, "jetbrains.mps.lang.smodel.structure.EnumMemberReference"))) {
          if (DataTypeDeclaration_Behavior.call_isEnumOfInteger_1220268950942(dataType)) {
            {
              SNode _nodeToCheck_1029348928467 = value;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1214430014537", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1214430014542", true), (SNode) new typeof_Property_SetOperation_InferenceRule.QuotationClass_txyj5n_a0a0a0a0a0a0a0g0a().createNode(typeCheckingContext), false, _info_12389875345);
            }
          } else
          if (DataTypeDeclaration_Behavior.call_isEnumOfBoolean_1220268971570(dataType)) {
            {
              SNode _nodeToCheck_1029348928467 = value;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1214430042913", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1214430042918", true), (SNode) new typeof_Property_SetOperation_InferenceRule.QuotationClass_txyj5n_a0a0a0a0a0a0a0a6a0().createNode(typeCheckingContext), false, _info_12389875345);
            }
          } else {
            {
              SNode _nodeToCheck_1029348928467 = value;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059478770", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059478775", true), (SNode) new typeof_Property_SetOperation_InferenceRule.QuotationClass_txyj5n_a0a0a0a0a0a0a0a0g0a().createNode(typeCheckingContext), false, _info_12389875345);
            }
          }
        }
      } else {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(op, "unknown property datatype: " + dataType, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186059296043", intentionProvider, errorTarget);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.Property_SetOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

  public static class QuotationClass_txyj5n_a0a0a0a6a0 {
    public QuotationClass_txyj5n_a0a0a0a6a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a6a0 = null;
      {
        quotedNode_txyj5n_a0a0a0a6a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a6a0 = quotedNode_txyj5n_a0a0a0a6a0;
        result = quotedNode1_txyj5n_a0a0a0a6a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a6a0 = null;
      {
        quotedNode_txyj5n_a0a0a0a6a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a6a0 = quotedNode_txyj5n_a0a0a0a6a0;
        result = quotedNode1_txyj5n_a0a0a0a6a0;
      }
      return result;
    }
  }

  public static class QuotationClass_txyj5n_a0a0a0a0g0a {
    public QuotationClass_txyj5n_a0a0a0a0g0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0g0a = null;
      {
        quotedNode_txyj5n_a0a0a0a0g0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0g0a = quotedNode_txyj5n_a0a0a0a0g0a;
        result = quotedNode1_txyj5n_a0a0a0a0g0a;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0g0a = null;
      {
        quotedNode_txyj5n_a0a0a0a0g0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0g0a = quotedNode_txyj5n_a0a0a0a0g0a;
        result = quotedNode1_txyj5n_a0a0a0a0g0a;
      }
      return result;
    }
  }

  public static class QuotationClass_txyj5n_a0a0a0a0a6a0 {
    public QuotationClass_txyj5n_a0a0a0a0a6a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a6a0 = null;
      {
        quotedNode_txyj5n_a0a0a0a0a6a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a6a0 = quotedNode_txyj5n_a0a0a0a0a6a0;
        result = quotedNode1_txyj5n_a0a0a0a0a6a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a6a0 = null;
      {
        quotedNode_txyj5n_a0a0a0a0a6a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a6a0 = quotedNode_txyj5n_a0a0a0a0a6a0;
        result = quotedNode1_txyj5n_a0a0a0a0a6a0;
      }
      return result;
    }
  }

  public static class QuotationClass_txyj5n_a0a0a0a0a0a0a0g0a {
    public QuotationClass_txyj5n_a0a0a0a0a0a0a0g0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a0a0a0g0a = null;
      {
        quotedNode_txyj5n_a0a0a0a0a0a0a0g0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a0a0a0g0a = quotedNode_txyj5n_a0a0a0a0a0a0a0g0a;
        result = quotedNode1_txyj5n_a0a0a0a0a0a0a0g0a;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a0a0a0g0a = null;
      {
        quotedNode_txyj5n_a0a0a0a0a0a0a0g0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.IntegerType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a0a0a0g0a = quotedNode_txyj5n_a0a0a0a0a0a0a0g0a;
        result = quotedNode1_txyj5n_a0a0a0a0a0a0a0g0a;
      }
      return result;
    }
  }

  public static class QuotationClass_txyj5n_a0a0a0a0a0a0a0a6a0 {
    public QuotationClass_txyj5n_a0a0a0a0a0a0a0a6a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a0a0a0a6a0 = null;
      {
        quotedNode_txyj5n_a0a0a0a0a0a0a0a6a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a0a0a0a6a0 = quotedNode_txyj5n_a0a0a0a0a0a0a0a6a0;
        result = quotedNode1_txyj5n_a0a0a0a0a0a0a0a6a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a0a0a0a6a0 = null;
      {
        quotedNode_txyj5n_a0a0a0a0a0a0a0a6a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.BooleanType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a0a0a0a6a0 = quotedNode_txyj5n_a0a0a0a0a0a0a0a6a0;
        result = quotedNode1_txyj5n_a0a0a0a0a0a0a0a6a0;
      }
      return result;
    }
  }

  public static class QuotationClass_txyj5n_a0a0a0a0a0a0a0a0g0a {
    public QuotationClass_txyj5n_a0a0a0a0a0a0a0a0g0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a0a0a0a0g0a = null;
      {
        quotedNode_txyj5n_a0a0a0a0a0a0a0a0g0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a0a0a0a0g0a = quotedNode_txyj5n_a0a0a0a0a0a0a0a0g0a;
        result = quotedNode1_txyj5n_a0a0a0a0a0a0a0a0g0a;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_txyj5n_a0a0a0a0a0a0a0a0g0a = null;
      {
        quotedNode_txyj5n_a0a0a0a0a0a0a0a0g0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_txyj5n_a0a0a0a0a0a0a0a0g0a = quotedNode_txyj5n_a0a0a0a0a0a0a0a0g0a;
        result = quotedNode1_txyj5n_a0a0a0a0a0a0a0a0g0a;
      }
      return result;
    }
  }
}
