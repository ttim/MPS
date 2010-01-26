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
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_ConjugateOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ConjugateOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    {
      final SNode t = typeCheckingContext.typeOf(SLinkOperations.getTarget(operation, "expr", true), "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229357", true);
      typeCheckingContext.whenConcrete(t, new Runnable() {
        public void run() {
          if (SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.MatrixType")) {
            SNode result = new typeof_ConjugateOperation_InferenceRule.QuotationClass_8755_0().createNode(MathTypeUtil.getElementType(typeCheckingContext.getEquationManager().getRepresentator(t)), typeCheckingContext);
            SPropertyOperations.set(result, "columns", "" + SPropertyOperations.getInteger(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.MatrixType"), "rows"));
            SPropertyOperations.set(result, "rows", "" + SPropertyOperations.getInteger(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.MatrixType"), "columns"));
            {
              SNode _nodeToCheck_1029348928467 = operation;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229309", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229314", true), (SNode) result, false, _info_12389875345);
            }
          } else if (SNodeOperations.isInstanceOf(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.VectorType")) {
            SNode result = new typeof_ConjugateOperation_InferenceRule.QuotationClass_8755_1().createNode(MathTypeUtil.getElementType(typeCheckingContext.getEquationManager().getRepresentator(t)), typeCheckingContext);
            SPropertyOperations.set(result, "columns", "" + SPropertyOperations.getInteger(SNodeOperations.cast(typeCheckingContext.getEquationManager().getRepresentator(t), "jetbrains.mps.baseLanguage.math.structure.VectorType"), "height"));
            SPropertyOperations.set(result, "rows", "" + 1);
            {
              SNode _nodeToCheck_1029348928467 = operation;
              BaseIntentionProvider intentionProvider = null;
              EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229345", 0, intentionProvider);
              _info_12389875345.setInequationGroup("default");
              typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229350", true), (SNode) result, false, _info_12389875345);
            }
          } else {
            {
              BaseIntentionProvider intentionProvider = null;
              IErrorTarget errorTarget = new NodeErrorTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(operation, "Operation defined for matrices/vectors only", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229354", intentionProvider, errorTarget);
            }
          }
          if (!(TypeChecker.getInstance().getSubtypingManager().isSubtype(MathTypeUtil.qComplex, typeCheckingContext.getEquationManager().getRepresentator(t)))) {
            {
              BaseIntentionProvider intentionProvider = null;
              IErrorTarget errorTarget = new NodeErrorTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportWarning(operation, "Usage of conjugation instead of transposition only makes sense for complex matrices", "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229387", intentionProvider, errorTarget);
            }
          }
        }
      }, "r:47d0f24b-df34-4ea0-aa7e-7c2eb0f88f31(jetbrains.mps.baseLanguage.math.typesystem)", "7388416617632229275", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.math.structure.ConjugateOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_8755_0 {
    public QuotationClass_8755_0() {
    }

    public SNode createNode(Object parameter_8755_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8755_0 = null;
      SNode quotedNode_8755_1 = null;
      {
        quotedNode_8755_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8755_0 = quotedNode_8755_0;
        {
          quotedNode_8755_1 = (SNode) parameter_8755_0;
          SNode quotedNode1_8755_1;
          if (_parameterValues_129834374.contains(quotedNode_8755_1)) {
            quotedNode1_8755_1 = CopyUtil.copy(quotedNode_8755_1);
          } else {
            _parameterValues_129834374.add(quotedNode_8755_1);
            quotedNode1_8755_1 = quotedNode_8755_1;
          }
          if (quotedNode1_8755_1 != null) {
            quotedNode_8755_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_8755_1, typeCheckingContext));
          }
        }
        result = quotedNode1_8755_0;
      }
      return result;
    }

    public SNode createNode(Object parameter_8755_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8755_0 = null;
      SNode quotedNode_8755_1 = null;
      {
        quotedNode_8755_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8755_0 = quotedNode_8755_0;
        {
          quotedNode_8755_1 = (SNode) parameter_8755_0;
          SNode quotedNode1_8755_1;
          if (_parameterValues_129834374.contains(quotedNode_8755_1)) {
            quotedNode1_8755_1 = CopyUtil.copy(quotedNode_8755_1);
          } else {
            _parameterValues_129834374.add(quotedNode_8755_1);
            quotedNode1_8755_1 = quotedNode_8755_1;
          }
          if (quotedNode1_8755_1 != null) {
            quotedNode_8755_0.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_8755_1));
          }
        }
        result = quotedNode1_8755_0;
      }
      return result;
    }
  }

  public static class QuotationClass_8755_1 {
    public QuotationClass_8755_1() {
    }

    public SNode createNode(Object parameter_8755_1, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8755_2 = null;
      SNode quotedNode_8755_3 = null;
      {
        quotedNode_8755_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8755_2 = quotedNode_8755_2;
        {
          quotedNode_8755_3 = (SNode) parameter_8755_1;
          SNode quotedNode1_8755_3;
          if (_parameterValues_129834374.contains(quotedNode_8755_3)) {
            quotedNode1_8755_3 = CopyUtil.copy(quotedNode_8755_3);
          } else {
            _parameterValues_129834374.add(quotedNode_8755_3);
            quotedNode1_8755_3 = quotedNode_8755_3;
          }
          if (quotedNode1_8755_3 != null) {
            quotedNode_8755_2.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_8755_3, typeCheckingContext));
          }
        }
        result = quotedNode1_8755_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_8755_1) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8755_2 = null;
      SNode quotedNode_8755_3 = null;
      {
        quotedNode_8755_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.math.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8755_2 = quotedNode_8755_2;
        {
          quotedNode_8755_3 = (SNode) parameter_8755_1;
          SNode quotedNode1_8755_3;
          if (_parameterValues_129834374.contains(quotedNode_8755_3)) {
            quotedNode1_8755_3 = CopyUtil.copy(quotedNode_8755_3);
          } else {
            _parameterValues_129834374.add(quotedNode_8755_3);
            quotedNode1_8755_3 = quotedNode_8755_3;
          }
          if (quotedNode1_8755_3 != null) {
            quotedNode_8755_2.addChild("elementType", HUtil.copyIfNecessary(quotedNode1_8755_3));
          }
        }
        result = quotedNode1_8755_2;
      }
      return result;
    }
  }
}
