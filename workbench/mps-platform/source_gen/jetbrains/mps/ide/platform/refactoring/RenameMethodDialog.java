package jetbrains.mps.ide.platform.refactoring;

/*Generated by MPS */

import javax.swing.JCheckBox;
import com.intellij.openapi.project.Project;
import javax.swing.JComponent;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class RenameMethodDialog extends RenameDialog {
  private JCheckBox myOverridingCheckBox;
  private boolean myIsOverriding;

  public RenameMethodDialog(Project project, String oldName, boolean myOverridingEnabled) {
    super(project, oldName, "method");
    myOverridingCheckBox.setEnabled(myOverridingEnabled);
  }

  public boolean getOverriding() {
    return myIsOverriding;
  }

  protected JComponent createNorthPanel() {
    super.createNorthPanel();
    myOverridingCheckBox = new JCheckBox("Overriding methods");
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 2;
    c.insets = new Insets(0, 8, 0, 8);
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myPanel.add(myOverridingCheckBox, c);
    return myPanel;
  }

  protected void doRefactoringAction() {
    myIsOverriding = myOverridingCheckBox.isSelected();
    super.doRefactoringAction();
  }
}
