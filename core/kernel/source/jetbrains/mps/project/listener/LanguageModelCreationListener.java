package jetbrains.mps.project.listener;

import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.library.LanguageDesign_DevKit;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.util.CollectionUtil;

import java.util.List;

public class LanguageModelCreationListener extends ModelCreationListener {
  private List<String> getModelsToImport(Language language) {
    return CollectionUtil.list(
      language.getStructureModelDescriptor().getSModelReference().toString()
    );
  }

  public boolean isApplicable(SModelDescriptor m) {
    return m.getModule() instanceof Language;
  }

  public void onCreate(SModelDescriptor model) {
    Language language = (Language) model.getModule();
    model.getSModel().addLanguage(language);

    model.getSModel().addDevKit(LanguageDesign_DevKit.get());

    for (String modelUID : getModelsToImport(language)) {
      model.getSModel().addImportedModel(SModelReference.fromString(modelUID));
    }

    model.getSModel().addImportedModel(language.getStructureModelDescriptor().getSModelReference());
  }
}
