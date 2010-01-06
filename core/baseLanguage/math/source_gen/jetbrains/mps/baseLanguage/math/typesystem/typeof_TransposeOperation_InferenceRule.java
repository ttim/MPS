package jetbrains.mps.baseLanguage.math.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_TransposeOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_TransposeOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    {
      final SNode t = typeCheckingContext.typeOf(SLinkOperations.getTarget(operation, "expr", true), "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229121", true);
      typeCheckingContext.whenConcrete(t, new Runnable() {
        public void run() {
          if (SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.MatrixType")) {
            SNode result = new typeof_TransposeOperation_InferenceRule.QuotationClass_4526_0().createNode(MathTypeUtil.getElementType(typeCheckingContext.getEquationManager().getRepresentator(t)), typeCheckingContext);
            SPropertyOperations.set(result, "columns", "" + SPropertyOperations.getInteger(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.MatrixType"), "rows"));
            SPropertyOperations.set(result, "rows", "" + SPropertyOperations.getInteger(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.MatrixType"), "columns"));
            {
              SNode _nodeToCheck_1029348928467 = operation;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229140", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229137", true), (SNode) result, false, _info_12389875345);
            }
          } else if (SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.VectorType")) {
            SNode result = new typeof_TransposeOperation_InferenceRule.QuotationClass_4526_1().createNode(MathTypeUtil.getElementType(typeCheckingContext.getEquationManager().getRepresentator(t)), typeCheckingContext);
            SPropertyOperations.set(result, "columns", "" + SPropertyOperations.getInteger(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.VectorType"), "height"));
            SPropertyOperations.set(result, "rows", "" + 1);
            {
              SNode _nodeToCheck_1029348928467 = operation;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229259", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229264", true), (SNode) result, false, _info_12389875345);
            }
          } else {
            {
              BaseIntentionProvider intentionProvider = null;
              IErrorTarget errorTarget = new NodeErrorTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(operation, "Operation defined for matrices/vectors only", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229219", intentionProvider, errorTarget);
            }
          }
        }
      }, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632227872", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.TransposeOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_4526_0 {
    public QuotationClass_4526_0() {
    }

    public SNode createNode(Object parameter_4526_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_45 = null;
      SNode quotedNode_46 = null;
      {
        quotedNode_45 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_45 = quotedNode_45;
        {
          quotedNode_46 = (SNode) parameter_4526_0;
          SNode quotedNode1_46;
          if (_parameterValues_129834374.contains(quotedNode_46)) {
            quotedNode1_46 = CopyUtil.copy(quotedNode_46);
          } else {
            _parameterValues_129834374.add(quotedNode_46);
            quotedNode1_46 = quotedNode_46;
          }
          if (quotedNode1_46 != null) {
            quotedNode_45.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_46, typeCheckingContext));
          }
        }
        result = quotedNode1_45;
      }
      return result;
    }

    public SNode createNode(Object parameter_4526_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_45 = null;
      SNode quotedNode_46 = null;
      {
        quotedNode_45 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_45 = quotedNode_45;
        {
          quotedNode_46 = (SNode) parameter_4526_0;
          SNode quotedNode1_46;
          if (_parameterValues_129834374.contains(quotedNode_46)) {
            quotedNode1_46 = CopyUtil.copy(quotedNode_46);
          } else {
            _parameterValues_129834374.add(quotedNode_46);
            quotedNode1_46 = quotedNode_46;
          }
          if (quotedNode1_46 != null) {
            quotedNode_45.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_46));
          }
        }
        result = quotedNode1_45;
      }
      return result;
    }
  }

  public static class QuotationClass_4526_1 {
    public QuotationClass_4526_1() {
    }

    public SNode createNode(Object parameter_4526_1, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_47 = null;
      SNode quotedNode_48 = null;
      {
        quotedNode_47 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_47 = quotedNode_47;
        {
          quotedNode_48 = (SNode) parameter_4526_1;
          SNode quotedNode1_48;
          if (_parameterValues_129834374.contains(quotedNode_48)) {
            quotedNode1_48 = CopyUtil.copy(quotedNode_48);
          } else {
            _parameterValues_129834374.add(quotedNode_48);
            quotedNode1_48 = quotedNode_48;
          }
          if (quotedNode1_48 != null) {
            quotedNode_47.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_48, typeCheckingContext));
          }
        }
        result = quotedNode1_47;
      }
      return result;
    }

    public SNode createNode(Object parameter_4526_1) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_47 = null;
      SNode quotedNode_48 = null;
      {
        quotedNode_47 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_47 = quotedNode_47;
        {
          quotedNode_48 = (SNode) parameter_4526_1;
          SNode quotedNode1_48;
          if (_parameterValues_129834374.contains(quotedNode_48)) {
            quotedNode1_48 = CopyUtil.copy(quotedNode_48);
          } else {
            _parameterValues_129834374.add(quotedNode_48);
            quotedNode1_48 = quotedNode_48;
          }
          if (quotedNode1_48 != null) {
            quotedNode_47.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_48));
          }
        }
        result = quotedNode1_47;
      }
      return result;
    }
  }
}
