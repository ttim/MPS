package jetbrains.mps.ide.platform.refactoring;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.refactoring.framework.IRefactoring;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import com.intellij.openapi.project.Project;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import jetbrains.mps.refactoring.framework.ILoggableRefactoring;
import java.awt.Dimension;
import javax.swing.JLabel;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;

public class RefactoringOptionsDialog extends DialogWrapper {
  private RefactoringContext myRefactoringContext;
  private IRefactoring myRefactoring;
  private JCheckBox myIsLocalCheckBox;
  private JCheckBox myGenerateModelsCheckBox;
  private JPanel myInnerPanel;
  private boolean myNeedToBeShown = false;
  private boolean myHasModelsToGenerate;
  private boolean myIsCancelled = true;

  public RefactoringOptionsDialog(Project project, RefactoringContext refactoringContext, IRefactoring refactoring, boolean hasModelsToGenerate) {
    super(project, true);
    initDialog(refactoringContext, refactoring, hasModelsToGenerate);
  }

  protected JComponent createCenterPanel() {
    myInnerPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = GridBagConstraints.RELATIVE;
    c.weightx = 1;
    c.weighty = 0;
    c.anchor = GridBagConstraints.NORTHWEST;
    c.insets = new Insets(0, 3, 0, 0);
    if (myRefactoring instanceof ILoggableRefactoring) {
      myIsLocalCheckBox = new JCheckBox("is local (write refactoring history into log)");
      myIsLocalCheckBox.setSelected(myRefactoringContext.isLocal());
      myInnerPanel.add(myIsLocalCheckBox, c);
      myNeedToBeShown = true;
    }
    if (myHasModelsToGenerate) {
      myGenerateModelsCheckBox = new JCheckBox("rebuild affected models after refactoring");
      myInnerPanel.add(myGenerateModelsCheckBox, c);
      myGenerateModelsCheckBox.setSelected(true);
      myNeedToBeShown = true;
    }
    c.weighty = 1;
    myInnerPanel.add(new JPanel(), c);
    myInnerPanel.setPreferredSize(new Dimension(300, 250));
    return myInnerPanel;
  }

  protected JComponent createNorthPanel() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = GridBagConstraints.RELATIVE;
    c.weightx = 1;
    c.weighty = 0;
    c.anchor = GridBagConstraints.NORTHWEST;
    panel.add(new JLabel("Set refactoring options"));
    return panel;
  }

  public boolean isCancelled() {
    return myIsCancelled;
  }

  protected void doOKAction() {
    myIsCancelled = false;
    if (myRefactoring instanceof ILoggableRefactoring) {
      myRefactoringContext.setLocal(myIsLocalCheckBox.isSelected());
    }
    if (myGenerateModelsCheckBox != null) {
      myRefactoringContext.setDoesGenerateModels(myGenerateModelsCheckBox.isSelected());
    } else {
      myRefactoringContext.setDoesGenerateModels(false);
    }
    close(OK_EXIT_CODE);
  }

  public boolean needToBeShown() {
    return myNeedToBeShown;
  }

  @Nullable
  @NonNls
  @Override
  protected String getDimensionServiceKey() {
    return getClass().getName();
  }

  private void initDialog(RefactoringContext refactoringContext, IRefactoring refactoring, boolean hasModelsToGenerate) {
    setTitle("Refactoring Options");
    myRefactoringContext = refactoringContext;
    myRefactoring = refactoring;
    myHasModelsToGenerate = hasModelsToGenerate;
    init();
  }
}
