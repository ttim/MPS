package jetbrains.mps.workbench.dialogs.project.components.parts.creators;

/*Generated by MPS */

import com.intellij.openapi.util.Computable;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;

public class LanguageChooser implements Computable<List<ModuleReference>> {
  private final IBindedDialog myOwner;

  public LanguageChooser(IBindedDialog owner) {
    myOwner = owner;
  }

  public List<ModuleReference> compute() {
    final Wrappers._T<List<ModuleReference>> langRefs = new Wrappers._T<List<ModuleReference>>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        List<Language> langs = GlobalScope.getInstance().getVisibleLanguages();
        langRefs.value = ListSequence.<Language>fromList(langs).<ModuleReference>select(new ISelector<Language, ModuleReference>() {
          public ModuleReference select(Language it) {
            return it.getModuleReference();
          }
        }).toListSequence();
      }
    });
    return CommonChoosers.showDialogModuleCollectionChooser(myOwner.getMainComponent(), "language", langRefs.value, null);
  }
}
