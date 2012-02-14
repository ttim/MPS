package jetbrains.mps.vcs;

/*Generated by MPS */

import jetbrains.mps.ide.editor.warningPanel.EditorWarningsProvider;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.ide.editor.warningPanel.WarningPanel;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SModelDescriptor;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.vcs.util.ConflictsUtil;
import jetbrains.mps.util.NameUtil;
import com.intellij.openapi.vcs.AbstractVcsHelper;
import java.util.Arrays;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.SModel;

public class ConflictingModelsWarnings implements EditorWarningsProvider {
  public ConflictingModelsWarnings() {
  }

  @Nullable
  public WarningPanel getWarningPanel(@NotNull SNode node, @NotNull final Project project) {
    SModelDescriptor md = check_bmsafs_a0a0a(node.getModel());
    final VirtualFile modelFile = ConflictsUtil.getModelFileIfConflicting(md, project);
    final VirtualFile moduleFile = ConflictsUtil.getModuleFileIfConflicting(check_bmsafs_a0a2a0(md), project);
    if (moduleFile != null) {
      String type = getModuleType(md.getModule());
      assert type != null;
      if (modelFile != null) {
        // conflicting model and module 
        return new WarningPanel(this, String.format("You are viewing model which is not merged yet. It is owned by %s, which is merged neither." + " You need to merge %s and model (this order is important).", type, type), String.format("Merge %s and Model", NameUtil.capitalize(type)), new Runnable() {
          public void run() {
            invokeMergeDialog(project, moduleFile, modelFile);
          }
        });
      } else {
        // conflicting module 
        return new WarningPanel(this, String.format("You are viewing model owned by %s which is not merged yet. You need to merge it before editing.", type), "Merge " + NameUtil.capitalize(type), new Runnable() {
          public void run() {
            invokeMergeDialog(project, moduleFile);
          }
        });
      }
    } else {
      if (modelFile != null) {
        // conflicting model 
        return new WarningPanel(this, "You are viewing model which is not merged yet. You may see very old version of it." + " You need to merge it before editing, otherwise your changes will be lost.", "Merge Model", new Runnable() {
          public void run() {
            invokeMergeDialog(project, modelFile);
          }
        });
      } else {
        return null;
      }
    }
  }

  private void invokeMergeDialog(Project project, VirtualFile... interestingFiles) {
    AbstractVcsHelper.getInstance(project).showMergeDialog(Arrays.asList(interestingFiles));
  }

  @Nullable
  private static String getModuleType(@NotNull IModule module) {
    if (module instanceof Language) {
      return "language";
    } else if (module instanceof Solution) {
      return "solution";
    } else if (module instanceof Generator) {
      return "generator";
    }
    return null;
  }

  private static SModelDescriptor check_bmsafs_a0a0a(SModel checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModelDescriptor();
    }
    return null;
  }

  private static IModule check_bmsafs_a0a2a0(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }
}
