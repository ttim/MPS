package jetbrains.mps.workbench.dialogs.project.components.parts.creators;

/*Generated by MPS */

import com.intellij.openapi.util.Computable;
import jetbrains.mps.project.structure.modules.StubSolution;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import javax.swing.JOptionPane;
import jetbrains.mps.project.ModuleId;

public class StubSolutionChooser implements Computable<StubSolution> {
  private final IBindedDialog myOwner;

  public StubSolutionChooser(IBindedDialog owner) {
    this.myOwner = owner;
  }

  public StubSolution compute() {
    String name = JOptionPane.showInputDialog(null, "Name:");
    if (name == null) {
      return null;
    }
    StubSolution solution = new StubSolution();
    solution.setName(name);
    solution.setId(ModuleId.generate());
    return solution;
  }
}
