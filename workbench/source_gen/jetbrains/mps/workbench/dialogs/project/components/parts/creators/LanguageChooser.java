package jetbrains.mps.workbench.dialogs.project.components.parts.creators;

/*Generated by MPS */

import com.intellij.openapi.util.Computable;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;
import java.util.ArrayList;

public class LanguageChooser implements Computable<List<ModuleReference>> {
  private final IBindedDialog myOwner;

  public LanguageChooser(IBindedDialog owner) {
    myOwner = owner;
  }

  public List<ModuleReference> compute() {
    List<Language> languages = ModelAccess.instance().runReadAction(new Computable<List<Language>>() {
      public List<Language> compute() {
        return GlobalScope.getInstance().getVisibleLanguages();
      }
    });
    List<Language> language = CommonChoosers.showDialogModuleCollectionChooser(myOwner.getMainComponent(), "language", languages, null);
    if (language == null) {
      return null;
    }
    List<ModuleReference> references = new ArrayList<ModuleReference>();
    for (Language l : language) {
      references.add(l.getModuleReference());
    }
    return references;
  }
}
