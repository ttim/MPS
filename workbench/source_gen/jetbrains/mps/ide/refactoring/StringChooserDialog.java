package jetbrains.mps.ide.refactoring;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import com.intellij.util.ui.UIUtil;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class StringChooserDialog extends RefactoringDialog {
  protected JPanel myPanel;
  private JLabel myLabel = new JLabel();
  private JTextField myTextField = new JTextField();
  protected String myResultString;

  public StringChooserDialog(@NotNull Project project, String title, String labelText, String initialValue) {
    super(project, true);
    setTitle(title);
    init();
    myTextField.setText(initialValue);
    myTextField.setSelectionStart(0);
    myTextField.setSelectionEnd(initialValue.length());
    myLabel.setText(labelText);
    setHorizontalStretch(2.0f);

  }

  @Nullable
  protected JComponent createCenterPanel() {
    return null;
  }

  @Override
  protected JComponent createNorthPanel() {
    this.myPanel = new JPanel(new GridBagLayout());
    myPanel.setBorder(BorderFactory.createLineBorder(UIUtil.getBorderColor()));

    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    c.insets = new Insets(4, 8, 8, 8);
    myPanel.add(myLabel, c);

    c = new GridBagConstraints();

    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1;
    c.weighty = 1;
    c.insets = new Insets(4, 8, 4, 8);

    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myPanel.add(myTextField, c);

    return myPanel;

  }

  public String getResultString() {
    return myResultString;
  }

  protected void doRefactoringAction() {
    myResultString = this.myTextField.getText();
    this.dispose();
  }

  public static String getString(Project project, String title, String labelText, String initialValue) {
    StringChooserDialog dialog = new StringChooserDialog(project, title, labelText, initialValue);
    dialog.show();
    return dialog.myResultString;
  }
}
