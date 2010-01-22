package jetbrains.mps.samples.matrixLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.CopyUtil;

public class typeof_MatrixMulExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_MatrixMulExpression_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    {
      final SNode left = typeCheckingContext.typeOf(SLinkOperations.getTarget(nodeToCheck, "leftExpression", true), "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210005562793", true);
      typeCheckingContext.whenConcrete(left, new Runnable() {
        public void run() {
          {
            final SNode right = typeCheckingContext.typeOf(SLinkOperations.getTarget(nodeToCheck, "rightExpression", true), "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210005567145", true);
            typeCheckingContext.whenConcrete(right, new Runnable() {
              public void run() {
                boolean done = false;
                if (TypeChecker.getInstance().getSubtypingManager().isSubtype(typeCheckingContext.getEquationManager().getRepresentator(left), new typeof_MatrixMulExpression_InferenceRule.QuotationClass_1357_1().createNode(typeCheckingContext))) {
                  {
                    IMatchingPattern pattern_0 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.samples.matrixLanguage.structure.MatrixType");
                    SNode coercedNode_0 = TypeChecker.getInstance().getRuntimeSupport().coerce_(typeCheckingContext.getEquationManager().getRepresentator(right), pattern_0, typeCheckingContext);
                    if (coercedNode_0 != null) {
                      {
                        SNode _nodeToCheck_1029348928467 = nodeToCheck;
                        BaseIntentionProvider intentionProvider = null;
                        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210171765353", 0, intentionProvider);
                        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210171765363", true), (SNode) new typeof_MatrixMulExpression_InferenceRule.QuotationClass_1357_0().createNode(SLinkOperations.getTarget(coercedNode_0, "scalarType", true), typeCheckingContext), _info_12389875345);
                      }
                      done = true;
                    } else {
                    }
                  }
                  if (!(done)) {
                    {
                      BaseIntentionProvider intentionProvider = null;
                      IErrorTarget errorTarget = new NodeErrorTarget();
                      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(nodeToCheck, "rightExpression", true), "Type must be Matrix but " + SNodeOperations.getConceptDeclaration(typeCheckingContext.getEquationManager().getRepresentator(right)), "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210175930104", intentionProvider, errorTarget);
                    }
                  }
                } else
                if (TypeChecker.getInstance().getSubtypingManager().isSubtype(typeCheckingContext.getEquationManager().getRepresentator(right), new typeof_MatrixMulExpression_InferenceRule.QuotationClass_1357_3().createNode(typeCheckingContext))) {
                  {
                    IMatchingPattern pattern_1 = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.samples.matrixLanguage.structure.MatrixType");
                    SNode coercedNode_1 = TypeChecker.getInstance().getRuntimeSupport().coerce_(typeCheckingContext.getEquationManager().getRepresentator(left), pattern_1, typeCheckingContext);
                    if (coercedNode_1 != null) {
                      {
                        SNode _nodeToCheck_1029348928467 = nodeToCheck;
                        BaseIntentionProvider intentionProvider = null;
                        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174269263", 0, intentionProvider);
                        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174269273", true), (SNode) new typeof_MatrixMulExpression_InferenceRule.QuotationClass_1357_2().createNode(SLinkOperations.getTarget(coercedNode_1, "scalarType", true), typeCheckingContext), _info_12389875345);
                      }
                      done = true;
                    } else {
                    }
                  }
                  if (!(done)) {
                    {
                      BaseIntentionProvider intentionProvider = null;
                      IErrorTarget errorTarget = new NodeErrorTarget();
                      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(nodeToCheck, "leftExpression", true), "Type must be Matrix but " + SNodeOperations.getConceptDeclaration(typeCheckingContext.getEquationManager().getRepresentator(left)), "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210176257229", intentionProvider, errorTarget);
                    }
                  }
                } else {
                  final SNode v_typevar_1210174591724 = typeCheckingContext.createNewRuntimeTypesVariable();
                  {
                    SNode _nodeToCheck_1029348928467 = nodeToCheck;
                    BaseIntentionProvider intentionProvider = null;
                    EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174591725", 0, intentionProvider);
                    typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174591729", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(v_typevar_1210174591724), _info_12389875345);
                  }
                  {
                    SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(nodeToCheck, "leftExpression", true);
                    BaseIntentionProvider intentionProvider = null;
                    EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174591731", 0, intentionProvider);
                    typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174591735", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(v_typevar_1210174591724), _info_12389875345);
                  }
                  {
                    SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(nodeToCheck, "rightExpression", true);
                    BaseIntentionProvider intentionProvider = null;
                    EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174591739", 0, intentionProvider);
                    typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210174591743", true), (SNode) typeCheckingContext.getEquationManager().getRepresentator(v_typevar_1210174591724), _info_12389875345);
                  }
                  done = true;
                }
              }
            }, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210004912543", false, false);
          }
        }
      }, "r:00000000-0000-4000-0000-011c89590452(jetbrains.mps.samples.matrixLanguage.typesystem)", "1210004689795", false, false);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.samples.matrixLanguage.structure.MatrixMultExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_1357_0 {
    public QuotationClass_1357_0() {
    }

    public SNode createNode(Object parameter_1357_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_0 = null;
      SNode quotedNode_1357_1 = null;
      {
        quotedNode_1357_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_0 = quotedNode_1357_0;
        {
          quotedNode_1357_1 = (SNode) parameter_1357_0;
          SNode quotedNode1_2;
          if (_parameterValues_129834374.contains(quotedNode_1357_1)) {
            quotedNode1_2 = CopyUtil.copy(quotedNode_1357_1);
          } else {
            _parameterValues_129834374.add(quotedNode_1357_1);
            quotedNode1_2 = quotedNode_1357_1;
          }
          if (quotedNode1_2 != null) {
            quotedNode_1357_0.addChild("scalarType", HUtil.copyIfNecessary(quotedNode1_2, typeCheckingContext));
          }
        }
        result = quotedNode1_1357_0;
      }
      return result;
    }

    public SNode createNode(Object parameter_1357_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_0 = null;
      SNode quotedNode_1357_1 = null;
      {
        quotedNode_1357_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_0 = quotedNode_1357_0;
        {
          quotedNode_1357_1 = (SNode) parameter_1357_0;
          SNode quotedNode1_2;
          if (_parameterValues_129834374.contains(quotedNode_1357_1)) {
            quotedNode1_2 = CopyUtil.copy(quotedNode_1357_1);
          } else {
            _parameterValues_129834374.add(quotedNode_1357_1);
            quotedNode1_2 = quotedNode_1357_1;
          }
          if (quotedNode1_2 != null) {
            quotedNode_1357_0.addChild("scalarType", HUtil.copyIfNecessary(quotedNode1_2));
          }
        }
        result = quotedNode1_1357_0;
      }
      return result;
    }
  }

  public static class QuotationClass_1357_1 {
    public QuotationClass_1357_1() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_2 = null;
      {
        quotedNode_1357_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_1 = quotedNode_1357_2;
        result = quotedNode1_1357_1;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_2 = null;
      {
        quotedNode_1357_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_1 = quotedNode_1357_2;
        result = quotedNode1_1357_1;
      }
      return result;
    }
  }

  public static class QuotationClass_1357_2 {
    public QuotationClass_1357_2() {
    }

    public SNode createNode(Object parameter_1357_1, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_3 = null;
      SNode quotedNode_1357_4 = null;
      {
        quotedNode_1357_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_2 = quotedNode_1357_3;
        {
          quotedNode_1357_4 = (SNode) parameter_1357_1;
          SNode quotedNode1_3;
          if (_parameterValues_129834374.contains(quotedNode_1357_4)) {
            quotedNode1_3 = CopyUtil.copy(quotedNode_1357_4);
          } else {
            _parameterValues_129834374.add(quotedNode_1357_4);
            quotedNode1_3 = quotedNode_1357_4;
          }
          if (quotedNode1_3 != null) {
            quotedNode_1357_3.addChild("scalarType", HUtil.copyIfNecessary(quotedNode1_3, typeCheckingContext));
          }
        }
        result = quotedNode1_1357_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_1357_1) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_3 = null;
      SNode quotedNode_1357_4 = null;
      {
        quotedNode_1357_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.matrixLanguage.structure.MatrixType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_2 = quotedNode_1357_3;
        {
          quotedNode_1357_4 = (SNode) parameter_1357_1;
          SNode quotedNode1_3;
          if (_parameterValues_129834374.contains(quotedNode_1357_4)) {
            quotedNode1_3 = CopyUtil.copy(quotedNode_1357_4);
          } else {
            _parameterValues_129834374.add(quotedNode_1357_4);
            quotedNode1_3 = quotedNode_1357_4;
          }
          if (quotedNode1_3 != null) {
            quotedNode_1357_3.addChild("scalarType", HUtil.copyIfNecessary(quotedNode1_3));
          }
        }
        result = quotedNode1_1357_2;
      }
      return result;
    }
  }

  public static class QuotationClass_1357_3 {
    public QuotationClass_1357_3() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_5 = null;
      {
        quotedNode_1357_5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_3 = quotedNode_1357_5;
        result = quotedNode1_1357_3;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1357_5 = null;
      {
        quotedNode_1357_5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.DoubleType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1357_3 = quotedNode_1357_5;
        result = quotedNode1_1357_3;
      }
      return result;
    }
  }
}
