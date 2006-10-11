package jetbrains.mps.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataConstants;
import com.intellij.openapi.project.Project;
import com.intellij.psi.*;

public class FindClassUsagesInMPS extends AnAction {
  public void update(AnActionEvent anActionEvent) {
    super.update(anActionEvent);

    PsiElement element = PluginUtil.getCurrentElement(anActionEvent);
    PsiClass cls = getPsiClass(element);
    if (cls == null) {
      anActionEvent.getPresentation().setVisible(false);
      anActionEvent.getPresentation().setEnabled(false);
    } else {
      anActionEvent.getPresentation().setVisible(true);
      anActionEvent.getPresentation().setEnabled(true);
    }
  }

  private PsiClass getPsiClass(PsiElement element) {
    PsiClass cls = PluginUtil.getElement(element, PsiClass.class);
    if (PluginUtil.getElement(element, PsiMethod.class) != null || PluginUtil.getElement(element, PsiField.class) != null) {
      cls = null;
    }
    return cls;
  }

  public void actionPerformed(AnActionEvent anActionEvent) {
    PsiElement element = PluginUtil.getCurrentElement(anActionEvent);

    Project project = (Project) anActionEvent.getDataContext().getData(DataConstants.PROJECT);
    if (project == null) return;
    ProjectHandler projectHandler = project.getComponent(ProjectHandler.class);
    PsiClass cls = getPsiClass(element);
    projectHandler.showClassUsages(cls.getQualifiedName());
  }
}
