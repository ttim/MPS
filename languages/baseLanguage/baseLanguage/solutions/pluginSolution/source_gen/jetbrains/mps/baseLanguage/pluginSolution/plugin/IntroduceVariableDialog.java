package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.platform.refactoring.RefactoringDialog;
import jetbrains.mps.nodeEditor.EditorContext;
import javax.swing.JPanel;
import jetbrains.mps.smodel.SNode;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import com.intellij.openapi.project.Project;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.IntroduceVariableRefactoring;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MoveRefactoringUtils;
import java.awt.Insets;

public abstract class IntroduceVariableDialog extends RefactoringDialog {
  protected EditorContext myEditorContext;
  protected JPanel myPanel;
  protected SNode myResult;
  protected JCheckBox myReplaceAll = null;
  protected JCheckBox myIsFinal = null;
  protected VisibilityPanel myVisibilityPanel = null;
  private JComboBox myName;

  public IntroduceVariableDialog(Project project, String name, EditorContext editorContext) {
    super(project, true);
    setTitle(name);
    myEditorContext = editorContext;
  }

  private JPanel createNamePanel() {
    JPanel result = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    result.add(new JLabel("Name: "), c);
    c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1;
    c.gridx = 1;
    List<String> expectedNames = this.getRefactoring().getExpectedNames();
    this.myName = new JComboBox(ListSequence.fromList(expectedNames).toGenericArray(String.class));
    this.myName.setEditable(true);
    result.add(this.myName, c);
    this.myName.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent p0) {
        IntroduceVariableDialog.this.getRefactoring().setName(((String) IntroduceVariableDialog.this.myName.getSelectedItem()));
      }
    });
    this.myName.setSelectedItem(ListSequence.fromList(expectedNames).first());
    JTextField textField = ((JTextField) this.myName.getEditor().getEditorComponent());
    textField.setSelectionStart(0);
    textField.setSelectionEnd(ListSequence.fromList(expectedNames).first().length());
    textField.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent p0) {
        if (p0.getKeyCode() == KeyEvent.VK_ENTER && !(IntroduceVariableDialog.this.myName.isPopupVisible())) {
          doRefactoringAction();
        }
      }
    });
    return result;
  }

  public void addReplacingAll(int gridy) {
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = gridy;
    this.myReplaceAll = new JCheckBox("replace duplicates (" + ListSequence.fromList(getRefactoring().getDuplicates()).count() + " found)");
    this.myPanel.add(this.myReplaceAll, c);
  }

  public void addIsFinal(GridBagConstraints c) {
    myIsFinal = new JCheckBox("declare final");
    myPanel.add(myIsFinal, c);
  }

  public void addVisibilityPanel(final GridBagConstraints c) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        IntroduceVariableDialog.this.myVisibilityPanel = new VisibilityPanel();
        IntroduceVariableDialog.this.myPanel.add(IntroduceVariableDialog.this.myVisibilityPanel, c);
      }
    });
  }

  public abstract IntroduceVariableRefactoring getRefactoring();

  protected void doRefactoring() {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        IntroduceVariableDialog.this.myResult = IntroduceVariableDialog.this.getRefactoring().doRefactoring();
        MoveRefactoringUtils.fixImportsFromNode(IntroduceVariableDialog.this.myResult);
      }
    });
    this.myEditorContext.select(this.myResult);
  }

  public SNode getResult() {
    return this.myResult;
  }

  protected void initPanel() {
    this.myPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.insets = new Insets(3, 3, 3, 3);
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 1;
    c.weighty = 0;
    this.myPanel.add(this.createNamePanel(), c);
  }

  /**
   * This method will be called on pressing "Refactor" button in dialog.
   * 
   */
  protected void doRefactoringAction() {
    String name = (String) this.myName.getEditor().getItem();
    IntroduceVariableDialog.this.getRefactoring().setName(name);
    if (myVisibilityPanel != null) {
      getRefactoring().setVisibilityLevel(this.myVisibilityPanel.getResult());
    }
    if (myReplaceAll != null) {
      getRefactoring().setReplacingAll(this.myReplaceAll.isSelected());
    }
    if (myIsFinal != null) {
      getRefactoring().setIsFinal(myIsFinal.isSelected());
    }
    super.doRefactoringAction();
    this.doRefactoring();
  }
}
