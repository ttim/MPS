package jetbrains.mps.ide.newLanguageDialog;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.ide.newLanguageDialog.NewLanguageDialogContentPane;
import java.awt.Frame;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import javax.swing.JComponent;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.Language;

public class NewLanguageDialog extends BaseDialog {

  public NewLanguageDialogContentPane myContentPane;

  public NewLanguageDialog(Frame frame) {
    super(frame, "New Language");
  }

  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensionsSettings.DialogDimensions(100, 100, 600, 200);
  }

  public JComponent getMainComponent() {
    if (this.myContentPane == null) {
      this.myContentPane = new NewLanguageDialogContentPane();
      this.myContentPane.setDialog(this);
    }
    return this.myContentPane;
  }

  public boolean stretchMainComponent() {
    return false;
  }

  public String getLanguageNamespace() {
    this.getMainComponent();
    return this.myContentPane.getLanguageNamespace();
  }

  public String getLanguagePath() {
    this.getMainComponent();
    return this.myContentPane.getLanguagePath();
  }

  public MPSProject getProject() {
    this.getMainComponent();
    return this.myContentPane.getProject();
  }

  public boolean getCompileInMPS() {
    this.getMainComponent();
    return this.myContentPane.getCompileInMPS();
  }

  public Language getResult() {
    this.getMainComponent();
    return this.myContentPane.getResult();
  }

  public void setLanguageNamespace(String newValue) {
    this.getMainComponent();
    this.myContentPane.setLanguageNamespace(newValue);
  }

  public void setLanguagePath(String newValue) {
    this.getMainComponent();
    this.myContentPane.setLanguagePath(newValue);
  }

  public void setProject(MPSProject newValue) {
    this.getMainComponent();
    this.myContentPane.setProject(newValue);
  }

  public void setCompileInMPS(boolean newValue) {
    this.getMainComponent();
    this.myContentPane.setCompileInMPS(newValue);
  }

  public void setResult(Language newValue) {
    this.getMainComponent();
    this.myContentPane.setResult(newValue);
  }

  @BaseDialog.Button(name = "OK", position = 0, defaultButton = true)
  public void buttonMethod0() {
    myContentPane.onOk();
  }

  @BaseDialog.Button(name = "Cancel", position = 1, defaultButton = false)
  public void buttonMethod1() {
    myContentPane.onCancel();
  }

}
