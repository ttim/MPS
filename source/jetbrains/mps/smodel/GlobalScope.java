package jetbrains.mps.smodel;

import jetbrains.mps.ide.BootstrapLanguages;
import jetbrains.mps.logging.Logger;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Sep 9, 2005
 * Time: 2:41:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class GlobalScope implements IScope {
  private final Logger LOG = Logger.getLogger(GlobalScope.class);

  private static GlobalScope myInstance;

  public static GlobalScope getInstance() {
    if (myInstance == null) {
      myInstance = new GlobalScope();
    }
    return myInstance;
  }

  private GlobalScope() {
  }

  public Language getLanguage(String languageNamespace) {
    Language language = LanguageRepository.getInstance().getLanguage(languageNamespace, BootstrapLanguages.getInstance());
    if (language == null) {
      LOG.error("Couldn't find language for namespace: \"" + languageNamespace + "\" in: " + this);
    }
    return language;
  }

  public List<Language> getLanguages() {
    return LanguageRepository.getInstance().getLanguages(BootstrapLanguages.getInstance());
  }

  public SModelDescriptor getModelDescriptor(SModelUID modelUID) {
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelUID);
    if (modelDescriptor == null) {
      LOG.warning("Couldn't find model descriptor for uid: \"" + modelUID + "\" in: " + this);
    }
    return modelDescriptor;
  }

  public List<SModelDescriptor> getModelDescriptors(String modelName) {
    return SModelRepository.getInstance().getModelDescriptors(modelName);
  }

  public List<SModelDescriptor> getVisibleModelDescriptors() {
    return SModelRepository.getInstance().getAllModelDescriptors();
  }
}
