package jetbrains.mps.bash.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class VariableNameDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static List<SNode> getDefinedBeforeNode_9034131902193864152(SNode node) {
    List<SNode> result = new ArrayList<SNode>();
    SNode script = SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.ShellScript", false, false);
    ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(script, "usedVars", true)));
    SNode to = SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.InputLine", false, false);
    for (SNode line : ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(script, "commands", true), "lines", true))) {
      if (line == to) {
        break;
      }
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(line, "jetbrains.mps.bash.structure.VariableNameDeclaration", false, new String[]{})));
    }
    if ((SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.ForCommand", false, false) != null)) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.ForCommand", false, false), "accord", true), "jetbrains.mps.bash.structure.VariableNameDeclaration", false, new String[]{})));
    }
    return result;
  }

  public static List<SNode> getDefinedInShell_9034131902194381915(SNode node) {
    List<SNode> result = new ArrayList<SNode>();
    SNode script = SNodeOperations.getAncestor(node, "jetbrains.mps.bash.structure.ShellScript", false, false);
    ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(script, "usedVars", true)));
    for (SNode line : ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(script, "commands", true), "lines", true))) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getDescendants(line, "jetbrains.mps.bash.structure.VariableNameDeclaration", false, new String[]{})));
    }
    return result;
  }

  public static SNode testName_9034131902194480300(SNode node, String name) {
    for (SNode v : ListSequence.fromList(VariableNameDeclaration_Behavior.getDefinedInShell_9034131902194381915(node))) {
      if (isNotEmpty_3wnjjz_a0a0a0a3(SPropertyOperations.getString(v, "name")) && SPropertyOperations.getString(v, "name").equals(name)) {
        return v;
      }
    }
    return null;
  }

  public static boolean isNotEmpty_3wnjjz_a0a0a0a3(String str) {
    return str != null && str.length() > 0;
  }
}
