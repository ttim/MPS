package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.analyzers.runtime.framework.CustomAnalyzerRunner;
import java.util.Map;
import jetbrains.mps.baseLanguage.dataFlow.NullableState;
import jetbrains.mps.baseLanguage.dataFlow.NullableAnalyzerRunner;
import jetbrains.mps.lang.dataFlow.framework.AnalysisResult;
import jetbrains.mps.lang.dataFlow.framework.Program;
import jetbrains.mps.lang.dataFlow.framework.instructions.Instruction;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.dataFlow.framework.instructions.IfJumpInstruction;
import jetbrains.mps.baseLanguage.behavior.IOperation_Behavior;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.lang.dataFlow.framework.instructions.ReadInstruction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.dataFlow.framework.instructions.WriteInstruction;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_NullableStates_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_NullableStates_NonTypesystemRule() {
  }

  public void applyRule(final SNode iMethodLike, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    // Find possible NPE 
    CustomAnalyzerRunner<Map<SNode, NullableState>> nullableRunner = new NullableAnalyzerRunner(iMethodLike);
    AnalysisResult<Map<SNode, NullableState>> result = nullableRunner.analyze();
    Program program = nullableRunner.getProgram();
    if (DataFlowUtil.tooComplex(program)) {
      return;
    }
    for (Instruction instruction : program.getInstructions()) {
      SNode source = (SNode) instruction.getSource();
      SNode variable = source;
      if (SNodeOperations.isInstanceOf(source, "jetbrains.mps.baseLanguage.structure.VariableReference")) {
        variable = SLinkOperations.getTarget(SNodeOperations.cast(source, "jetbrains.mps.baseLanguage.structure.VariableReference"), "variableDeclaration", false);
      }
      NullableState varState = result.get(instruction).get(variable);
      SNode parent = SNodeOperations.getParent(source);
      if (!(instruction instanceof IfJumpInstruction) && SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.DotExpression") && !(SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.checkedDots.structure.CheckedDotExpression"))) {
        SNode dot = SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.DotExpression");
        if (SLinkOperations.getTarget(dot, "operand", true) == source && !(IOperation_Behavior.call_operandCanBeNull_323410281720656291(SLinkOperations.getTarget(dot, "operation", true))) && !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(dot, "operation", true), "jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation"))) {
          if (NullableState.canBeNull(varState)) {
            {
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(dot, "This operation can produce 'java.lang.NullPointerException'", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "3791846458263577277", null, errorTarget);
            }
          }
        }
      }
      // Test equals and not equals is always true or false 
      if (instruction instanceof ReadInstruction && (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.EqualsExpression") || SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.NotEqualsExpression"))) {
        boolean inCondition = false;
        boolean equals = SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.EqualsExpression");
        boolean isNull = NullableState.NULL.equals(varState);
        boolean isNotNull = NullableState.NOTNULL.equals(varState);
        if (ListSequence.fromList(SNodeOperations.getDescendants(SNodeOperations.getParent(source), "jetbrains.mps.baseLanguage.structure.NullLiteral", false, new String[]{})).isNotEmpty()) {
          if (SNodeOperations.getAncestor(source, "jetbrains.mps.baseLanguage.structure.IfStatement", false, false) != null && ListSequence.fromList(SNodeOperations.getAncestors(source, null, false)).contains(SLinkOperations.getTarget(SNodeOperations.getAncestor(source, "jetbrains.mps.baseLanguage.structure.IfStatement", false, false), "condition", true))) {
            inCondition = true;
          }
          if (SNodeOperations.getAncestor(source, "jetbrains.mps.baseLanguage.structure.WhileStatement", false, false) != null && ListSequence.fromList(SNodeOperations.getAncestors(source, null, false)).contains(SLinkOperations.getTarget(SNodeOperations.getAncestor(source, "jetbrains.mps.baseLanguage.structure.WhileStatement", false, false), "condition", true))) {
            inCondition = true;
          }
          if (inCondition) {
            if (equals && isNotNull || !(equals) && isNull) {
              {
                MessageTarget errorTarget = new NodeMessageTarget();
                IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(parent, "This condition is always false", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "3791846458263577391", null, errorTarget);
              }
            }
            if (equals && isNull || !(equals) && isNotNull) {
              {
                MessageTarget errorTarget = new NodeMessageTarget();
                IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(parent, "This condition is always true", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "3791846458263577404", null, errorTarget);
              }
            }
          }
        }
      }
      // Find Nullable assignements to NotNull variables 
      if (instruction instanceof WriteInstruction) {
        WriteInstruction write = (WriteInstruction) instruction;
        List<SNode> annotation = SLinkOperations.getTargets(((SNode) write.getVariable()), "annotation", true);
        if (annotation != null && ListSequence.fromList(annotation).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return (SLinkOperations.getTarget(it, "annotation", false) != null);
          }
        }).<SNode>select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(it, "annotation", false);
          }
        }).contains(SNodeOperations.getNode("f:java_stub#37a3367b-1fb2-44d8-aa6b-18075e74e003#org.jetbrains.annotations(MPS.Classpath/org.jetbrains.annotations@java_stub)", "~NotNull"))) {
          SNode value = (SNode) write.getValue();
          if (SNodeOperations.isInstanceOf(value, "jetbrains.mps.baseLanguage.structure.VariableReference")) {
            value = SLinkOperations.getTarget(SNodeOperations.cast(value, "jetbrains.mps.baseLanguage.structure.VariableReference"), "variableDeclaration", false);
          }
          if (NullableState.canBeNull(result.get(instruction).get(value))) {
            {
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError((SNode) write.getValue(), "This expression might evaluate to null but is assigned to a variable that is annotated with @NotNull", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "3791846458263577483", null, errorTarget);
            }
          }
        }
      }
    }
    // Find Nullable returns of NotNull methods 
    if (SNodeOperations.isInstanceOf(iMethodLike, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")) {
      SNode method = SNodeOperations.cast(iMethodLike, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
      if (ListSequence.fromList(SLinkOperations.getTargets(method, "annotation", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "annotation", false) != null);
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "annotation", false);
        }
      }).contains(SNodeOperations.getNode("f:java_stub#37a3367b-1fb2-44d8-aa6b-18075e74e003#org.jetbrains.annotations(MPS.Classpath/org.jetbrains.annotations@java_stub)", "~NotNull"))) {
        for (SNode returnStatement : SNodeOperations.getDescendants(method, "jetbrains.mps.baseLanguage.structure.ReturnStatement", false, new String[]{})) {
          SNode expression = SLinkOperations.getTarget(returnStatement, "expression", true);
          if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.VariableReference")) {
            SNode variable = SLinkOperations.getTarget(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.VariableReference"), "variableDeclaration", false);
            List<Instruction> instructions = program.getInstructionsFor(returnStatement);
            if (!(instructions.isEmpty())) {
              if (NullableState.canBeNull(result.get(instructions.get(instructions.size() - 1)).get(variable))) {
                {
                  MessageTarget errorTarget = new NodeMessageTarget();
                  IErrorReporter _reporter_2309309498 = typeCheckingContext.reportWarning(expression, "Expression " + expression + " might evaluate to null but is returned from method declared @NotNull", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "5899025696847223994", null, errorTarget);
                }
              }
            }
          } else if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.NullLiteral")) {
            {
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportWarning(expression, "Null is returned from method declared @NotNull", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "4658387821817544361", null, errorTarget);
            }
          }
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.IMethodLike";
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
}
