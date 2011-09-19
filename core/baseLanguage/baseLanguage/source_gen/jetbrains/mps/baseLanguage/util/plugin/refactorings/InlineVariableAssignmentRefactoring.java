package jetbrains.mps.baseLanguage.util.plugin.refactorings;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.framework.Program;
import java.util.Set;
import jetbrains.mps.lang.dataFlow.framework.instructions.ReadInstruction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.dataFlow.DataFlowManager;
import jetbrains.mps.lang.dataFlow.framework.AnalysisResult;
import jetbrains.mps.lang.dataFlow.framework.analyzers.ReachingReadsAnalyzer;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.dataFlow.framework.instructions.Instruction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.awt.Frame;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.util.NameUtil;
import java.util.List;
import java.util.ArrayList;

public class InlineVariableAssignmentRefactoring extends InlineVariableRefactoring {
  private Program myProgram;
  private Set<ReadInstruction> myReadInstructions;
  private SNode myVariable;

  public InlineVariableAssignmentRefactoring(SNode node) {
    this.myVariable = node;
    SNode body = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
    while (SNodeOperations.getAncestor(body, "jetbrains.mps.baseLanguage.structure.StatementList", false, false) != null) {
      body = SNodeOperations.getAncestor(body, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
    }
    this.myProgram = DataFlowManager.getInstance().buildProgramFor(body);
    AnalysisResult<Set<ReadInstruction>> reachingReads = this.myProgram.analyze(new ReachingReadsAnalyzer());
    this.myReadInstructions = SetSequence.fromSet(new HashSet<ReadInstruction>());
    for (Instruction instruction : ListSequence.fromList(this.myProgram.getInstructionsFor(node))) {
      for (Instruction next : SetSequence.fromSet(instruction.succ())) {
        for (ReadInstruction read : reachingReads.get(next)) {
          if (read.getVariable() == node) {
            SetSequence.fromSet(this.myReadInstructions).addElement(read);
          }
        }
      }
    }
  }

  public boolean checkRefactoring(Frame frame) {
    final Wrappers._boolean isLocalVariable = new Wrappers._boolean();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        isLocalVariable.value = SNodeOperations.isInstanceOf(InlineVariableAssignmentRefactoring.this.myVariable, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration");
      }
    });
    if (isLocalVariable.value) {
      final Wrappers._T<String> variableName = new Wrappers._T<String>();
      final Wrappers._boolean notInitialized = new Wrappers._boolean();
      final Wrappers._int nodesCount = new Wrappers._int();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          variableName.value = myVariable + "";
          notInitialized.value = (SLinkOperations.getTarget(SNodeOperations.cast(InlineVariableAssignmentRefactoring.this.myVariable, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "initializer", true) == null);
          nodesCount.value = ListSequence.fromList(getNodesToRefactor()).count();
        }
      });
      if (notInitialized.value) {
        return false;
      }
      if (nodesCount.value == 0) {
        Messages.showInfoMessage(frame, "Variable " + variableName.value + " is never used", "Inline Variable");
        return false;
      } else {
        int code = Messages.showYesNoDialog(frame, "Inline local variable '" + variableName.value + "'? (" + NameUtil.formatNumericalString(nodesCount.value, "occurence") + ")", "Inline Variable", null);
        if (code != 0) {
          return false;
        }
      }
    }
    return true;
  }

  public SNode doRefactoring() {
    SNode newSelection = null;
    for (SNode sourceNode : this.getNodesToRefactor()) {
      // <node> 
      for (SNode reference : ListSequence.fromList(SNodeOperations.getDescendants(sourceNode, "jetbrains.mps.baseLanguage.structure.VariableReference", true, new String[]{}))) {
        if (SLinkOperations.getTarget(reference, "variableDeclaration", false) == myVariable) {
          SNodeOperations.replaceWithAnother(reference, SNodeOperations.copyNode(SLinkOperations.getTarget(myVariable, "initializer", true)));
        }
      }
    }
    this.optimizeDeclaration(this.myVariable);
    return newSelection;
  }

  private List<SNode> getNodesToRefactor() {
    List<SNode> result = new ArrayList<SNode>();
    for (ReadInstruction read : SetSequence.fromSet(this.myReadInstructions)) {
      ListSequence.fromList(result).addElement(((SNode) read.getSource()));
    }
    return result;
  }
}
