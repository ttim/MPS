package jetbrains.mps.baseLanguage.closures.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class typeof_InvokeExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_InvokeExpression_InferenceRule() {
  }

  public void applyRule(final SNode invoke, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    final SNode cl = SNodeOperations.getAncestor(invoke, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral", false, false);
    if (!((cl != null))) {
      MessageTarget errorTarget = new NodeMessageTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(invoke, "Must be within ClosureLiteral", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1199711581032", null, errorTarget);
    }
    List<SNode> ptypes = ListSequence.fromList(new ArrayList<SNode>());
    for (SNode p : SLinkOperations.getTargets(invoke, "parameter", true)) {
      final SNode ClosureFormalParamType_typevar_7073484723012007681 = typeCheckingContext.createNewRuntimeTypesVariable();
      if (!(typeCheckingContext.isSingleTypeComputation())) { {
          SNode _nodeToCheck_1029348928467 = p;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "7073484723012007685", 0, null);
          typeCheckingContext.createGreaterThanInequality((SNode) typeCheckingContext.getRepresentative(ClosureFormalParamType_typevar_7073484723012007681), (SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "7073484723012007691", true), true, true, _info_12389875345);
        }
      }
      ListSequence.fromList(ptypes).addElement(typeCheckingContext.getRepresentative(ClosureFormalParamType_typevar_7073484723012007681));
    }
    final SNode ret_typevar_1225469708846 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = cl;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "7073484723012007695", 0, null);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "7073484723012007697", true), (SNode) new typeof_InvokeExpression_InferenceRule.QuotationClass_9tk0iy_a0a5a0().createNode(ptypes, typeCheckingContext.getRepresentative(ret_typevar_1225469708846), typeCheckingContext), _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = invoke;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1225469813196", 0, null);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1225469808572", true), (SNode) typeCheckingContext.getRepresentative(ret_typevar_1225469708846), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.closures.structure.InvokeExpression";
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

  public static class QuotationClass_9tk0iy_a0a5a0 {
    public QuotationClass_9tk0iy_a0a5a0() {
    }

    public SNode createNode(Object parameter_6, Object parameter_7, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.FunctionType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          List<SNode> nodes = (List<SNode>) parameter_6;
          for (SNode child : nodes) {
            quotedNode_1.addChild("parameterType", HUtil.copyIfNecessary(child, typeCheckingContext));
          }
        }
        {
          quotedNode_3 = (SNode) parameter_7;
          SNode quotedNode1_5;
          if (_parameterValues_129834374.contains(quotedNode_3)) {
            quotedNode1_5 = HUtil.copyIfNecessary(quotedNode_3, typeCheckingContext);
          } else {
            _parameterValues_129834374.add(quotedNode_3);
            quotedNode1_5 = quotedNode_3;
          }
          if (quotedNode1_5 != null) {
            quotedNode_1.addChild("resultType", HUtil.copyIfNecessary(quotedNode1_5, typeCheckingContext));
          }
        }
        result = quotedNode1_4;
      }
      return result;
    }

    public SNode createNode(Object parameter_6, Object parameter_7) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.closures.structure.FunctionType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          List<SNode> nodes = (List<SNode>) parameter_6;
          for (SNode child : nodes) {
            quotedNode_1.addChild("parameterType", HUtil.copyIfNecessary(child));
          }
        }
        {
          quotedNode_3 = (SNode) parameter_7;
          SNode quotedNode1_5;
          if (_parameterValues_129834374.contains(quotedNode_3)) {
            quotedNode1_5 = HUtil.copyIfNecessary(quotedNode_3);
          } else {
            _parameterValues_129834374.add(quotedNode_3);
            quotedNode1_5 = quotedNode_3;
          }
          if (quotedNode1_5 != null) {
            quotedNode_1.addChild("resultType", HUtil.copyIfNecessary(quotedNode1_5));
          }
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }
}
