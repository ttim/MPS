package jetbrains.mps.generator;

import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.projectLanguage.ModelRoot;
import jetbrains.mps.smodel.*;
import jetbrains.mps.ide.BootstrapLanguages;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Sep 19, 2005
 * Time: 7:20:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class GeneratorContext implements IOperationContext {
  private static final Logger LOG = Logger.getLogger(GeneratorContext.class);

  private Generator myGeneratorModule;
  private IOperationContext myInvocationContext;
  private TransientModule myTransientModule;
  private String mySessionId;

  public GeneratorContext(Generator generatorModule, IOperationContext invocationContext) {
    myGeneratorModule = generatorModule;
    myInvocationContext = invocationContext;
    myTransientModule = new TransientModule(generatorModule, invocationContext.getModule());
  }

  public <T> T getComponent(Class<T> clazz) {
    return myInvocationContext.getComponent(clazz);
  }

  public IModule getModule() {
    return myTransientModule;
  }

  public MPSProject getProject() {
    return myInvocationContext.getProject();
  }

  public IScope getScope() {
    return myTransientModule;
  }

  public Generator getGeneratorModule() {
    return myGeneratorModule;
  }

  public IOperationContext getInvocationContext() {
    return myInvocationContext;
  }

  public String toString() {
    return getClass().getName() + ": " + myGeneratorModule + "\ninvoked from: " + myInvocationContext;
  }

  public String getSessionId() {
    if (mySessionId == null) {
      mySessionId = "" + System.currentTimeMillis();
    }
    return mySessionId;
  }

  public static class TransientModule extends AbstractModule {
    private List<IModule> myDependOnModules;
    private Generator myGenerator;
    private IModule myInvocationModule;
    private IModule mySessionModule;

    TransientModule(Generator generator, IModule invocationModule) {
      myGenerator = generator;
      myInvocationModule = invocationModule;
      myDependOnModules = new LinkedList<IModule>();
      myDependOnModules.add(generator);
      myDependOnModules.add(invocationModule);
    }

    public void setSessionModule(IModule sessionModule) {
      mySessionModule = sessionModule;
    }

    public List<ModelRoot> getModelRoots() {
      return Collections.EMPTY_LIST;
    }

    public List<IModule> getDependOnModules() {
      if (mySessionModule != null) {
        return mySessionModule.getDependOnModules();
      }
      return myDependOnModules;
    }

    public Language getLanguage(String languageNamespace) {
      if (mySessionModule != null) {
        return mySessionModule.getLanguage(languageNamespace);
      }

      if (myInvocationModule instanceof Language) {
        if (languageNamespace.equals(((Language) myInvocationModule).getNamespace())) {
          return (Language) myInvocationModule;
        }
      }

      Language language = LanguageRepository.getInstance().getLanguage(languageNamespace, BootstrapLanguages.getInstance());
      if (language == null) {
        language = LanguageRepository.getInstance().getLanguage(languageNamespace, myGenerator);
      }
      if (language == null && myInvocationModule instanceof LanguageOwner) {
        language = LanguageRepository.getInstance().getLanguage(languageNamespace, (LanguageOwner) myInvocationModule);
      }
      if (language == null) {
        LOG.error("Couldn't find language: \"" + languageNamespace + "\" in scope: " + this);
      }
      return language;
    }

    public void dispose() {
      LanguageRepository.getInstance().unRegisterLanguages(this);

      // force removing transient models from repository
      List<SModelDescriptor> ownModelDescriptors = getOwnModelDescriptors();
      for (SModelDescriptor descriptor : ownModelDescriptors) {
        SModelRepository.getInstance().unRegisterModelDescriptor(descriptor, this);
        if (descriptor instanceof TransientModelDescriptor) {
          SModelRepository.getInstance().deleteModelDescriptor(descriptor);
        }
      }
    }

    public String toString() {
      return "TransientModule " + (mySessionModule != null ? "(persisted)" : "") + "for " + myGenerator + " invoked in: " + myInvocationModule;
    }

    public SModelDescriptor getModelDescriptor(SModelUID modelUID) {
      if (mySessionModule != null) {
        return mySessionModule.getModelDescriptor(modelUID);
      }
      return super.getModelDescriptor(modelUID);
    }
  }
}
