package jetbrains.mps.vcs.mergedriver;

/*Generated by MPS */

import com.intellij.openapi.ui.DialogWrapper;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import com.intellij.openapi.project.Project;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Dimension;
import com.intellij.openapi.util.DimensionService;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import jetbrains.mps.smodel.ModelAccess;
import javax.swing.Action;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import javax.swing.JCheckBox;

public class MergeDriverOptionsDialog extends DialogWrapper {
  private JPanel myPanel = new JPanel(new GridLayout(0, 1));
  private JPanel myMainPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
  private Project myProject;
  private MergeDriverOptionsDialog.InstallerCheckBox<GitGlobalConfigFixesInstaller> myGitFixes;
  private MergeDriverOptionsDialog.InstallerCheckBox<GitGlobalInstaller> myGitGlobal;
  private MergeDriverOptionsDialog.InstallerCheckBox<GitRepositoriesInstaller> myGitRepos;
  private MergeDriverOptionsDialog.InstallerCheckBox<SvnInstaller> myCommonSvn;
  private MergeDriverOptionsDialog.InstallerCheckBox<SvnInstaller> myIdeSvn;

  public MergeDriverOptionsDialog(Project project) {
    super(project);
    setTitle("MPS VCS Add-ons");
    // TODO get rid of code duplication 
    myProject = project;
    myGitFixes = new MergeDriverOptionsDialog.InstallerCheckBox<GitGlobalConfigFixesInstaller>(new GitGlobalConfigFixesInstaller(myProject));
    myGitGlobal = new MergeDriverOptionsDialog.InstallerCheckBox<GitGlobalInstaller>(new GitGlobalInstaller(myProject));
    myGitRepos = new MergeDriverOptionsDialog.InstallerCheckBox<GitRepositoriesInstaller>(new GitRepositoriesInstaller(myProject));
    myCommonSvn = new MergeDriverOptionsDialog.InstallerCheckBox<SvnInstaller>(new SvnInstaller(myProject, false));
    myIdeSvn = new MergeDriverOptionsDialog.InstallerCheckBox<SvnInstaller>(new SvnInstaller(myProject, true));
    if (myCommonSvn.myInstaller.sameAs(myIdeSvn.myInstaller)) {
      myIdeSvn = null;
    }

    myGitFixes.adIfNeeded();
    myGitGlobal.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        myGitRepos.setEnabled(myGitGlobal.isSelected());
      }
    });
    myGitGlobal.adIfNeeded();
    myGitRepos.adIfNeeded();
    myCommonSvn.adIfNeeded();
    if (myIdeSvn != null) {
      myIdeSvn.adIfNeeded();
    }
    myMainPanel.add(myPanel);
    final Dimension size = DimensionService.getInstance().getSize(getDimensionServiceKey());
    if (size == null) {
      DimensionService.getInstance().setSize(getDimensionServiceKey(), new Dimension(600, 200));
    }

    init();
  }

  @Nullable
  protected JComponent createCenterPanel() {
    return myMainPanel;
  }

  public String getDimensionServiceKey() {
    return "#jetbrains.mps.vcs.mergedriver.MergeDriverOptionDialog";
  }

  protected void doOKAction() {
    ModelAccess.instance().runWriteInEDT(new Runnable() {
      public void run() {
        myGitFixes.installIfNeeded();
        myGitGlobal.installIfNeeded();
        if (myGitGlobal.myInstaller.getCurrentState() == AbstractInstaller.State.INSTALLED) {
          myGitRepos.installIfNeeded();
        }
        myCommonSvn.installIfNeeded();
        if (myIdeSvn != null) {
          myIdeSvn.installIfNeeded();
        }
        close(DialogWrapper.OK_EXIT_CODE);
      }
    });
  }

  protected Action[] createActions() {
    List<Action> actions = ListSequence.fromList(new ArrayList<Action>());
    ListSequence.fromList(actions).addElement(getOKAction());
    ListSequence.fromList(actions).addElement(getCancelAction());
    return ListSequence.fromList(actions).toGenericArray(Action.class);
  }

  private class InstallerCheckBox<I extends AbstractInstaller> extends JCheckBox {
    private I myInstaller;

    public InstallerCheckBox(I installer) {
      super(installer.getActionTitle() + ((installer.getCurrentState() == AbstractInstaller.State.OUTDATED ?
        " (update)" :
        ""
      )));
      myInstaller = installer;
    }

    private void adIfNeeded() {
      AbstractInstaller.State currentState = myInstaller.getCurrentState();
      if (currentState != AbstractInstaller.State.INSTALLED) {
        myPanel.add(this);
        setText(myInstaller.getActionTitle() + ((currentState == AbstractInstaller.State.OUTDATED ?
          " (update)" :
          ""
        )));
        setToolTipText(myInstaller.getActionTooltip());
        setSelected(true);
      }
    }

    private void installIfNeeded() {
      if (isSelected() && isEnabled()) {
        myInstaller.install();
        MergeDriverNotification.getInstance(myProject).setNotificationsSuppressed(false);
      }
    }
  }
}
