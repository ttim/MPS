package jetbrains.mps.vcs.actions;

/*Generated by MPS */

import com.intellij.openapi.vcs.actions.AbstractVcsAction;
import com.intellij.openapi.vcs.actions.VcsContext;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.workbench.make.WorkbenchMakeService;
import jetbrains.mps.smodel.resources.ModelsToResources;
import jetbrains.mps.generator.generationTypes.IGenerationHandler;
import java.util.Collection;
import com.intellij.openapi.vfs.VirtualFile;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.AnActionEvent;

public abstract class GenerateFromChangeListAction extends AbstractVcsAction {
  public GenerateFromChangeListAction() {
  }

  protected void actionPerformed(VcsContext vcsContext) {
    List<SModelDescriptor> modelsToGenerate = getModelsToGenerate(vcsContext);
    Project project = vcsContext.getProject();
    IOperationContext context = ProjectOperationContext.get(project);
    new WorkbenchMakeService(context, true).make(new ModelsToResources(context, modelsToGenerate).resources(false));
    // <node> 
  }

  protected abstract IGenerationHandler getGenerationHandler();

  protected List<SModelDescriptor> getModelsToGenerate(VcsContext vcsContext) {
    Collection<VirtualFile> filesCollection = vcsContext.getSelectedFilesCollection();
    List<SModelDescriptor> modelsToGenerate = new ArrayList<SModelDescriptor>();
    for (VirtualFile f : filesCollection) {
      if (f.exists() && !(f.isDirectory())) {
        SModelDescriptor model = SModelRepository.getInstance().findModel(VirtualFileUtils.toIFile(f));
        if (model != null) {
          modelsToGenerate.add(model);
        }
      }
    }
    return modelsToGenerate;
  }

  protected void update(VcsContext vcsContext, Presentation presentation) {
    List<SModelDescriptor> modelsToGenerate = getModelsToGenerate(vcsContext);
    if (modelsToGenerate.isEmpty()) {
      enable(presentation, false);
      presentation.setText("Generate " + getWhatToGenerateName());
    } else
    if (modelsToGenerate.size() == 1) {
      enable(presentation, true);
      presentation.setText("Generate " + getWhatToGenerateName() + " From Model");
    } else {
      enable(presentation, true);
      presentation.setText("Generate " + getWhatToGenerateName() + " From Models");
    }
  }

  @Override
  protected boolean forceSyncUpdate(AnActionEvent e) {
    return true;
  }

  private void enable(Presentation presentation, boolean enable) {
    presentation.setVisible(enable);
    presentation.setEnabled(enable);
  }

  protected abstract String getWhatToGenerateName();
}
