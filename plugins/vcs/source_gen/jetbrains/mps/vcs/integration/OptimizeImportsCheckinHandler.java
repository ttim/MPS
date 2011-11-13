package jetbrains.mps.vcs.integration;

/*Generated by MPS */

import com.intellij.openapi.vcs.changes.CommitContext;
import com.intellij.openapi.vcs.checkin.CheckinHandler;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.ide.ThreadUtils;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.CheckinProjectPanel;
import com.intellij.openapi.vcs.VcsConfiguration;
import com.intellij.openapi.vcs.ui.RefreshableOnComponent;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.Collection;
import java.io.File;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.OptimizeImportsHelper;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import com.intellij.openapi.vcs.checkin.CheckinHandlerFactory;
import org.jetbrains.annotations.NotNull;

public class OptimizeImportsCheckinHandler extends CheckinHandler {
  private static final Logger LOG = Logger.getLogger(ThreadUtils.class);

  private Project myProject;
  private CheckinProjectPanel myPanel;

  public OptimizeImportsCheckinHandler(Project project, CheckinProjectPanel panel) {
    this.myProject = project;
    this.myPanel = panel;
  }

  protected VcsConfiguration getSettings() {
    return VcsConfiguration.getInstance(myProject);
  }

  @Override
  public RefreshableOnComponent getBeforeCheckinConfigurationPanel() {
    final JCheckBox optimizeImportsCheckBox = new JCheckBox("Optimize model imports");
    return new RefreshableOnComponent() {
      public JComponent getComponent() {
        JPanel panel = new JPanel(new GridLayout(1, 0));
        panel.add(optimizeImportsCheckBox);
        return panel;
      }

      public void restoreState() {
        optimizeImportsCheckBox.setSelected(getSettings().OPTIMIZE_IMPORTS_BEFORE_PROJECT_COMMIT);
      }

      public void saveState() {
        getSettings().OPTIMIZE_IMPORTS_BEFORE_PROJECT_COMMIT = optimizeImportsCheckBox.isSelected();
      }

      public void refresh() {
      }
    };
  }

  @Override
  public CheckinHandler.ReturnResult beforeCheckin() {
    if (getSettings().OPTIMIZE_IMPORTS_BEFORE_PROJECT_COMMIT) {
      Collection<File> affectedFiles = myPanel.getFiles();
      final List<SModelDescriptor> affectedModels = new ArrayList<SModelDescriptor>();
      SModelRepository modelRepository = SModelRepository.getInstance();
      for (File file : affectedFiles) {
        SModelDescriptor model = modelRepository.findModel(FileSystem.getInstance().getFileByPath(file.getAbsolutePath()));
        if (model == null) {
          continue;
        }
        affectedModels.add(model);
      }
      final IOperationContext operationContext = new ProjectOperationContext(ProjectHelper.toMPSProject(myProject));
      ThreadUtils.assertEDT();
      try {
        jetbrains.mps.project.Project project = operationContext.getProject();
        if (project != null) {
          ModelAccess.instance().runCommandInEDT(new Runnable() {
            public void run() {
              new OptimizeImportsHelper(operationContext).optimizeModelsImports(affectedModels);
              for (SModelDescriptor affectedModel : affectedModels) {
                ((EditableSModelDescriptor) affectedModel).save();
              }
            }
          }, project);
        }
      } catch (Throwable e) {
        LOG.error("Couldn't optimize imports before commit", e);
      }
    }
    return CheckinHandler.ReturnResult.COMMIT;
  }

  public static class OptimizeImportsCheckinHandlerFactory extends CheckinHandlerFactory {
    public OptimizeImportsCheckinHandlerFactory() {
    }

    @NotNull
    @Override
    public CheckinHandler createHandler(CheckinProjectPanel panel, CommitContext commitContext) {
      return new OptimizeImportsCheckinHandler(panel.getProject(), panel);
    }
  }
}
