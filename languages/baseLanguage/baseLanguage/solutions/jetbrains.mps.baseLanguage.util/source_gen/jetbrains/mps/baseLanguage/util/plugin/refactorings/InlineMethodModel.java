package jetbrains.mps.baseLanguage.util.plugin.refactorings;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.dataFlow.framework.Program;
import jetbrains.mps.lang.dataFlow.DataFlowManager;
import jetbrains.mps.lang.dataFlow.framework.instructions.Instruction;
import jetbrains.mps.lang.dataFlow.framework.instructions.RetInstruction;
import jetbrains.mps.lang.dataFlow.framework.instructions.NopInstruction;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class InlineMethodModel {
  private SNode myMethod;
  private MethodCallAdapter myCall;
  private boolean myIsContainsSelfCalls;
  private String myMethodPresentation;

  public InlineMethodModel(final SNode node) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")) {
          myMethod = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
        } else {
          myCall = new MethodCallAdapter(node);
          myMethod = myCall.getMethodDeclaration();
        }
        myMethodPresentation = ((String) BehaviorManager.getInstance().invoke(Object.class, myMethod, "virtual_getPresentation_1213877396640", new Class[]{SNode.class}));
        myIsContainsSelfCalls = isContainsSelfCalls();
      }
    });
  }

  public boolean isRecusive() {
    return myIsContainsSelfCalls;
  }

  public String getMethodPresentation() {
    return myMethodPresentation;
  }

  public MethodCallAdapter getMethodCall() {
    return myCall;
  }

  public SNode getMethod() {
    return myMethod;
  }

  public String getErrors() {
    if ((SLinkOperations.getTarget(getMethod(), "body", true) == null) || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(getMethod(), "body", true), "jetbrains.mps.baseLanguage.structure.StubStatementList")) {
      return "No sources attached";
    }
    if (myCall == null && isRecusive()) {
      return "Method is recursive";
    }
    if (isReturnBreaksExecitionFlow()) {
      return "Return breaks execution flow";
    }
    return null;
  }

  private boolean isContainsSelfCalls() {
    for (SNode call : ListSequence.fromList(SNodeOperations.getDescendants(getMethod(), null, false, new String[]{}))) {
      if (MethodCallAdapter.isMethodCall(call)) {
        if (new MethodCallAdapter(call).getMethodDeclaration() == getMethod()) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean isReturnBreaksExecitionFlow() {
    Program program = DataFlowManager.getInstance().buildProgramFor(SLinkOperations.getTarget(getMethod(), "body", true));
    for (Instruction instruction : ListSequence.fromList(program.getInstructions())) {
      if (instruction instanceof RetInstruction) {
        Instruction next = program.get(instruction.getIndex() + 1);
        while (!(next.equals(program.getEnd()))) {
          if (next instanceof NopInstruction) {
            return true;
          }
          Set<Instruction> succ = next.succ();
          if (SetSequence.fromSet(succ).count() != 1) {
            return true;
          }
          next = SetSequence.fromSet(succ).first();
        }
      }
    }
    return false;
  }
}
