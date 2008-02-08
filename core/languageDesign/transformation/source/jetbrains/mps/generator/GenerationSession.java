package jetbrains.mps.generator;

import jetbrains.mps.generator.template.CloneUtil;
import jetbrains.mps.generator.plan.AbstractGenerationStepController;
import jetbrains.mps.generator.plan.GenerationPartitioningUtil;
import jetbrains.mps.generator.plan.GenerationStepController;
import jetbrains.mps.generator.template.*;
import jetbrains.mps.generator.template.GeneratorUtil;
import jetbrains.mps.ide.messages.IMessageHandler;
import jetbrains.mps.ide.messages.Message;
import jetbrains.mps.ide.messages.MessageKind;
import jetbrains.mps.ide.messages.NodeWithContext;
import jetbrains.mps.ide.progress.IAdaptiveProgressMonitor;
import jetbrains.mps.logging.ILoggingHandler;
import jetbrains.mps.logging.LogEntry;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.logging.LoggingHandlerAdapter;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.IModule;
import jetbrains.mps.projectLanguage.DescriptorsPersistence;
import jetbrains.mps.projectLanguage.structure.ModelRoot;
import jetbrains.mps.projectLanguage.structure.ModuleReference;
import jetbrains.mps.projectLanguage.structure.SolutionDescriptor;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.transformation.TLBase.structure.MappingConfiguration;
import jetbrains.mps.transformation.TLBase.structure.MappingScript;
import jetbrains.mps.transformation.TLBase.structure.MappingScriptKind;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.vfs.FileSystem;
import org.jetbrains.annotations.NotNull;

import javax.swing.JOptionPane;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Igor Alshannikov
 * Oct 26, 2005
 */
public class GenerationSession implements IGenerationSession {
  public static final Logger LOG = Logger.getLogger(GenerationSession.class);

  private IOperationContext myInvocationContext;
  private boolean myDiscardTransients;
  private IAdaptiveProgressMonitor myProgressMonitor;
  private IMessageHandler myMessagesHandler;
  private GeneratorLogger myGeneratorLogger;
  private ILoggingHandler myLoggingHandler;

  private String mySessionId;
  private GenerationSessionContext myCurrentContext;
  private List<GenerationSessionContext> mySavedContexts = new LinkedList<GenerationSessionContext>();

  private int myInvocationCount = 0;
  private int myTransientModelsCount = 0;


  public GenerationSession(IOperationContext invocationContext, boolean saveTransientModels, IAdaptiveProgressMonitor progressMonitor, final IMessageHandler messagesHandler) {
    myInvocationContext = invocationContext;
    myDiscardTransients = !saveTransientModels;
    myProgressMonitor = progressMonitor;
    mySessionId = "" + System.currentTimeMillis();
    myMessagesHandler = new IMessageHandler() {
      public void handle(Message msg) {
        messagesHandler.handle(msg);
        Object o = msg.getHintObject();
        if (o instanceof NodeWithContext) {
          SNode node = ((NodeWithContext) o).getNode();
          if (node != null) {
            myCurrentContext.addTransientModelToKeep(node.getModel());
          }
        }
      }
    };
    myGeneratorLogger = new GeneratorLogger(myMessagesHandler);
  }

  public ILoggingHandler getLoggingHandler() {
    if (myLoggingHandler == null) {
      myLoggingHandler = new LoggingHandlerAdapter() {
        public void addLogEntry(LogEntry e) {
          Object o = e.getHintObject();
          if (o instanceof SNode) {
            if (myCurrentContext != null) {
              myCurrentContext.addTransientModelToKeep(((SNode) o).getModel());
            } else {
              LOG.error("current context is null");
            }
          }
        }
      };
    }
    return myLoggingHandler;
  }

  public String getSessionId() {
    return mySessionId;
  }

  public void discardTransients() {
    GenerationSessionContext lastContext = myCurrentContext;
    setGenerationSessionContext(null);
    if (myDiscardTransients) {
      for (GenerationSessionContext savedContext : mySavedContexts) {
        IModule module = savedContext.getModule();
        if (!lastContext.isTransientModuleToKeep(module)) {
          module.dispose(); // unregister transient models and module
        }
      }
      mySavedContexts.clear();
    }
  }

  private void setGenerationSessionContext(GenerationSessionContext context) {
    if (myCurrentContext != null) {
      mySavedContexts.add(myCurrentContext);
    }
    myCurrentContext = context;
  }

  public GenerationStatus generateModel(final SModelDescriptor inputModel,
                                        final Language targetLanguage,
                                        final IGenerationScript script) throws Exception {
    return generateModel(inputModel, targetLanguage, script, new GenerationStepController(inputModel.getSModel()));
  }

  public GenerationStatus generateModel(final SModelDescriptor inputModel,
                                        final Language targetLanguage,
                                        final IGenerationScript script,
                                        final AbstractGenerationStepController generationStepController) throws Exception {
    Statistics.clearAll();
    GenerationStatus status = script.doGenerate(new IGenerationScriptContext() {
      public GenerationStatus doGenerate(@NotNull SModelDescriptor inputModel,
                                         Language targetLanguage,
                                         Set<MappingConfiguration> confs) throws Exception {
        if (targetLanguage != null) {
          // old
          return generateModel_internal(inputModel.getSModel(), targetLanguage, confs, null);
        }

        // auto-plan
        SModelDescriptor inputModel1 = inputModel;
        GenerationStatus status1;
        boolean wasErrors = false;
        boolean wasWarnings = false;
        int stepCount = 1;
        while (true) {
          addMessage(new Message(MessageKind.INFORMATION, "execute step " + (stepCount++)));
          status1 = generateModel_internal(inputModel1.getSModel(), targetLanguage, confs, generationStepController);
          wasErrors |= status1.isError();
          wasWarnings |= status1.hasWarnings();
          if (status1.isCanceled()) {
            break;
          }

          // need more steps?
          if (!generationStepController.advanceStep()) {
            // generation complete
            break;
          }
          if (generationStepController.getCurrentMappings().isEmpty()) {
            break;
          }
          if (status1.getOutputModel() == null) {
            break;
          }
          inputModel1 = status1.getOutputModel().getModelDescriptor();
        }

        return new GenerationStatus(status1.getSourceModel(), status1.getOutputModel(), status1.getTraceMap(), wasErrors, wasWarnings, status1.isCanceled());
      }

      public SModelDescriptor getSourceModelDescriptor() {
        return inputModel;
      }


      public Language getTargetLanguage() {
        return targetLanguage;
      }

      public IOperationContext getOperationContext() {
        return myInvocationContext;
      }

      public IMessageHandler getHandler() {
        return myMessagesHandler;
      }
    }); // script.doGenerate()

//    if (status.isError() || status.hasWarnings()) {
//      // if ERROR - keep transient models: we need them to navigate to from error messages
//      myDiscardTransients = false;
//    }

    return status;
  }


  private GenerationStatus generateModel_internal(SModel inputModel,
                                                  Language targetLanguage,
                                                  Set<MappingConfiguration> mappings,
                                                  AbstractGenerationStepController generationStepController)
    throws ClassNotFoundException,
    NoSuchMethodException,
    IllegalAccessException,
    InvocationTargetException,
    InstantiationException {

    myInvocationCount++;
    myTransientModelsCount = 0;
    addProgressMessage(MessageKind.INFORMATION, "generating model \"" + inputModel.getUID() + "\"");

    // -- replace context
    GenerationSessionContext context = new GenerationSessionContext(targetLanguage, inputModel, myInvocationContext, mappings, generationStepController, myCurrentContext);
    if (generationStepController != null) {
      // auto-plan
      if (!checkGenerationStep(generationStepController)) {
        throw new GenerationCanceledException();
      }
//      if (generationStepController.getCurrentMappings().isEmpty()) {
//        addProgressMessage(MessageKind.WARNING, "skip model \"" + inputModel.getUID() + "\" : no generator avalable");
//        return new GenerationStatus(inputModel, null, null, false, false, false);
//      }
      printGenerationStepData(generationStepController, inputModel);

    } else {
      // old
      List<Generator> generators = context.getGeneratorModules();
      if (generators.isEmpty()) {
        addProgressMessage(MessageKind.WARNING, "skip model \"" + inputModel.getUID() + "\" : no generator avalable");
        return new GenerationStatus(inputModel, null, null, false, false, false);
      }
    }

    setGenerationSessionContext(context);

    // -- replace generator
    myGeneratorLogger.setOperationContext(context);
    ITemplateGenerator generator = new TemplateGenerator(context, myProgressMonitor, myGeneratorLogger);
    GenerationStatus status;
    try {
      SModel outputModel = generateModel(inputModel, generator);
      boolean wasErrors = generator.getErrorCount() > 0;
      boolean wasWarnigns = generator.getWarningCount() > 0;
      status = new GenerationStatus(inputModel, outputModel, context.getTraceMap(), wasErrors, wasWarnigns, false);
      addMessage(status.isError() ? MessageKind.WARNING : MessageKind.INFORMATION, "model \"" + inputModel.getUID() + "\" has been generated " + (status.isError() ? "with errors" : "successfully"));
    } catch (GenerationCanceledException gce) {
      throw gce;//rethrow it for not to be caught in the last catch block
    } catch (GenerationFailedException gfe) {
      LOG.error(gfe);
      myProgressMonitor.addText(gfe.toString());
      GenerationFailueInfo failueInfo = gfe.getFailueInfo();
      if (failueInfo != null) {
        for (Message message : failueInfo.createMessages()) {
          addMessage(message);
        }
      }
      addMessage(MessageKind.ERROR, "model \"" + inputModel.getUID() + "\" generation failed : " + gfe);
      status = new GenerationStatus.ERROR(inputModel);
    } catch (Throwable e) {
      LOG.error(e);
      myProgressMonitor.addText(e.toString());
      addMessage(MessageKind.ERROR, "model \"" + inputModel.getUID() + "\" generation failed : " + e);
      status = new GenerationStatus.ERROR(inputModel);
    }

    return status;
  }

  private SModel generateModel(SModel inputModel, ITemplateGenerator generator) {
    GenerationSessionContext generationContext = generator.getGeneratorSessionContext();
    if (generationContext.getGenerationStepController() == null) {
      // old
      return generateModel(inputModel, generator, generationContext);
    }

    // auto-plan
    return generateModel(inputModel, generator, generationContext);
  }

  private SModel generateModel(SModel inputModel, ITemplateGenerator generator, GenerationSessionContext generationContext) {
    IModule module = generationContext.getModule();
    String modelsLongName = inputModel.getLongName();
    SModel currentInputModel = inputModel;

    // -----------------------
    // run pre-processing scripts
    // -----------------------
    List<MappingScript> preMappingScripts = generationContext.getPreMappingScripts();
    if (!preMappingScripts.isEmpty()) {
      // need to clone input model?
      boolean needToCloneInputMode = !myDiscardTransients;  // clone model if save transients (needed for tracing)
      if (!needToCloneInputMode) {
        for (MappingScript preMappingScript : preMappingScripts) {
          if (preMappingScript.getScriptKind() == MappingScriptKind.pre_process_input_model) {
            if (preMappingScript.getModifiesModel()) {
              needToCloneInputMode = true;
              break;
            }
          }
        }
      }
      if (needToCloneInputMode) {
        SModel currentInputModel_clone = createTransientModel(modelsLongName, module);
        addMessage(MessageKind.INFORMATION, "clone model '" + currentInputModel.getUID() + "' --> '" + currentInputModel_clone.getUID() + "'");
        CloneUtil.cloneModel(currentInputModel, currentInputModel_clone, generator.getScope());

        if (!myDiscardTransients) { // tracing
          generationContext.getGenerationTracer().registerPreMappingScripts(currentInputModel, currentInputModel_clone, preMappingScripts);
        }

        // probably we can forget about former input model here
        recycleWasteModel(currentInputModel);
        currentInputModel = currentInputModel_clone;
      }
    }

    for (MappingScript preMappingScript : preMappingScripts) {
      if (preMappingScript.getScriptKind() != MappingScriptKind.pre_process_input_model) {
        addMessage(MessageKind.WARNING, "skip script '" + preMappingScript + "' (" + preMappingScript.getModel().getUID() + ") - wrong script kind");
        continue;
      }
      addMessage(MessageKind.INFORMATION, "pre-process '" + preMappingScript + "' (" + preMappingScript.getModel().getUID() + ")");
      GeneratorUtil.executeMappingScript(preMappingScript, currentInputModel, generator);
    }

    SModel currentOutputModel = createTransientModel(modelsLongName, module);
    generationContext.getGenerationTracer().startTracing(currentInputModel, currentOutputModel);

    // -----------------------
    // primary mapping
    // -----------------------
    currentInputModel.setLoading(false);
    boolean somethingHasBeenGenerated = generator.doPrimaryMapping(currentInputModel, currentOutputModel);
    if (!somethingHasBeenGenerated) {
      currentOutputModel.validateLanguagesAndImports();
      recycleWasteModel(currentInputModel);
      return currentOutputModel;
    }

    // -----------------------
    // secondary mapping (infinite cycle untill 'exit condition' is true)
    // -----------------------
    int secondaryMappingRepeatCount = 1;
    while (true) {
      currentOutputModel.validateLanguagesAndImports();

      // apply mapping to the output model
      addMessage(MessageKind.INFORMATION, "generating model '" + currentOutputModel.getUID() + "'");
      generationContext.replaceInputModel(currentOutputModel);
      SModel transientModel = createTransientModel(modelsLongName, module);
      // probably we can forget about former input model here
      recycleWasteModel(currentInputModel);
      currentInputModel = currentOutputModel;
      currentInputModel.setLoading(false);
      generationContext.getGenerationTracer().startTracing(currentInputModel, transientModel);
      if (!generator.doSecondaryMapping(currentInputModel, transientModel)) {
        // nothing has been generated
        generationContext.getGenerationTracer().discardTracing(currentInputModel, transientModel);
        addMessage(MessageKind.INFORMATION, "remove empty model '" + transientModel.getUID() + "'");
        SModelRepository.getInstance().removeModelDescriptor(transientModel.getModelDescriptor());
        myTransientModelsCount--;
        break;
      }

      if (++secondaryMappingRepeatCount > 10) {
        generator.showErrorMessage(null, "Failed to generate output after 10 repeated mappings");
        throw new GenerationFailedException("Failed to generate output after 10 repeated mappings");
      }

      // next iteration ...
      currentOutputModel = transientModel;
    }
    currentOutputModel.setLoading(true);

    // -----------------------
    // run post-processing scripts
    // -----------------------
    List<MappingScript> postMappingScripts = generationContext.getPostMappingScripts();
    if (!postMappingScripts.isEmpty() &&
      !myDiscardTransients) {  // clone model - needed for tracing
      SModel currentOutputModel_clone = createTransientModel(modelsLongName, module);
      addMessage(MessageKind.INFORMATION, "clone model '" + currentOutputModel.getUID() + "' --> '" + currentOutputModel_clone.getUID() + "'");
      CloneUtil.cloneModel(currentOutputModel, currentOutputModel_clone, generator.getScope());

      generationContext.getGenerationTracer().registerPostMappingScripts(currentOutputModel, currentOutputModel_clone, postMappingScripts);
      currentOutputModel = currentOutputModel_clone;
    }


    for (MappingScript postMappingScript : postMappingScripts) {
      if (postMappingScript.getScriptKind() != MappingScriptKind.post_process_output_model) {
        addMessage(MessageKind.WARNING, "skip script '" + postMappingScript + "' (" + postMappingScript.getModel().getUID() + ") - wrong script kind");
        continue;
      }
      addMessage(MessageKind.INFORMATION, "post-process '" + postMappingScript + "' (" + postMappingScript.getModel().getLongName() + ")");
      GeneratorUtil.executeMappingScript(postMappingScript, currentOutputModel, generator);
    }

    return currentOutputModel;
  }

  private SModel createTransientModel(String longName, ModelOwner modelOwner) {
    String stereotype = "" + myInvocationCount + "_" + myTransientModelsCount/* + "_" + getSessionId()*/;
    while (SModelRepository.getInstance().getModelDescriptor(new SModelUID(longName, stereotype)) != null) {
      stereotype += "_";
    }
    SModelDescriptor transientModel = TransientModels.createTransientModel(modelOwner, longName, stereotype);
    myTransientModelsCount++;
    transientModel.getSModel().setLoading(true); // we dont need any events to be casted
    return transientModel.getSModel();
  }

  private void recycleWasteModel(SModel model) {
    SModelDescriptor md = model.getModelDescriptor();
    if (md != null) {
      if (myDiscardTransients && md.isTransient() && !myCurrentContext.isTransientModelToKeep(model)) {
        addMessage(MessageKind.INFORMATION, "remove spent model '" + model.getUID() + "'");
        SModelRepository.getInstance().removeModelDescriptor(md);
      }
    }
  }

  private void addMessage(final Message message) {
    myMessagesHandler.handle(message);
  }

  private void addMessage(final MessageKind kind, final String text) {
    addMessage(new Message(kind, text));
  }

  private void addProgressMessage(final MessageKind kind, final String text) {
    myProgressMonitor.addText(text);
    addMessage(new Message(kind, text));
  }


  /**
   * creates new solution in current project and saves all transient models there.
   *
   * @return descriptor file for just created solution module
   */
  public File saveTransientModels() {
    // define solution dir
    String projectDir = myInvocationContext.getProject().getProjectFile().getParentFile().getAbsolutePath();
    String solutionDir = projectDir + File.separatorChar + "outputModels";

    FileUtil.delete(new File(solutionDir));

    addProgressMessage(MessageKind.INFORMATION, "saving transient models to \"" + solutionDir + "\"");

    List<IModule> transientModules = new LinkedList<IModule>();
    for (GenerationSessionContext context : mySavedContexts) {
      transientModules.add(context.getModule());
    }

    // collect all transient models
    List<SModelDescriptor> transientModels = new LinkedList<SModelDescriptor>();
    for (IModule module : transientModules) {
      List<SModelDescriptor> descriptors = module.getOwnModelDescriptors();
      for (SModelDescriptor descriptor : descriptors) {
        if (descriptor.isTransient()) {
          transientModels.add(descriptor);
        }
      }
    }

    // save all model files in the solution dir
    for (SModelDescriptor descriptor : transientModels) {
      String modelFqName = descriptor.getModelUID().toString();
      String modelFileName = modelFqName.replace('.', File.separatorChar) + ".mps";
      File modelFile = new File(solutionDir, modelFileName);
      ModelPersistence.saveModel(descriptor.getSModel(), FileSystem.getFile(modelFile));
    }

    // create the solution descriptor
    ModelOwner tmpOwner = new ModelOwner() {
    };
    SModel solutionDescriptorModel = ProjectModels.createDescriptorFor(tmpOwner).getSModel();
    assert solutionDescriptorModel != null;
    SolutionDescriptor solutionDescriptor = SolutionDescriptor.newInstance(solutionDescriptorModel);
    solutionDescriptorModel.setLoading(true);
    solutionDescriptor.setName("outputModels");
    // add root where transient models were saved
    addModelRoot("", solutionDir, solutionDescriptor);

    // for all languages that really used add the LanguageRoot to the solution descriptor

    Set<String> uidsToAdd = new LinkedHashSet<String>();

    SModel sm = solutionDescriptor.getModel();
    for (SModelDescriptor descriptor : transientModels) {
      uidsToAdd.addAll(descriptor.getSModel().getLanguageNamespaces(GlobalScope.getInstance()));
      uidsToAdd.addAll(descriptor.getSModel().getDevKitNamespaces());
    }

    // add models accessible from used generators should be accessible from our solution - add all model roots
    for (GenerationSessionContext context : mySavedContexts) {
      List<Generator> generatorModules = context.getGeneratorModules();
      for (Generator generator : generatorModules) {
        uidsToAdd.add(generator.getModuleUID());
      }
    }

    // add models accessible from the invokation contextshould be accessible from our solution - add all model roots
    IModule invocationModule = myInvocationContext.getModule();
    if (invocationModule != null) {
      uidsToAdd.add(invocationModule.getModuleUID());
    }

    for (String uid : uidsToAdd) {
      ModuleReference mr = ModuleReference.newInstance(sm);
      mr.setName(uid);
      solutionDescriptor.addDependency(mr);
    }

    // discard all transient modules (and models)
    // we have to remove transient models from repository because we need to update they root-managers
    for (IModule module : transientModules) {
      module.dispose();
    }

    // save, add to project and reload all
    File solutionDescriptorFile = new File(solutionDir, "outputModels.msd");
    DescriptorsPersistence.saveSolutionDescriptor(FileSystem.getFile(solutionDescriptorFile), solutionDescriptor);
    SModelDescriptor modelDescriptor = solutionDescriptorModel.getModelDescriptor();
    assert modelDescriptor != null;
    SModelRepository.getInstance().unRegisterModelDescriptor(modelDescriptor, tmpOwner);

    return solutionDescriptorFile;
  }

  private void addModelRoot(String prefix, String path, SolutionDescriptor descriptor) {
    Iterator<ModelRoot> iterator = descriptor.modelRoots();
    while (iterator.hasNext()) {
      ModelRoot modelRoot = iterator.next();
      if (prefix.equals(modelRoot.getPrefix()) && path.equals(modelRoot.getPath())) {
        return;
      }
    }
    ModelRoot modelRoot = ModelRoot.newInstance(descriptor.getModel());
    modelRoot.setPrefix(prefix);
    modelRoot.setPath(path);
    descriptor.addModelRoot(modelRoot);
  }

  public String getSessionModuleName() {
    return "generationSession_" + getSessionId();
  }

  private boolean checkGenerationStep(AbstractGenerationStepController stepController) {
    if (stepController.hasConflictingPriorityRules()) {
      List<String> errors = stepController.getConflictingPriorityRulesAsStrings();
      for (String error : errors) {
        addMessage(new Message(MessageKind.ERROR, "conflicting rule: " + error));
      }

      int option = JOptionPane.showConfirmDialog(null,
        "Conflicting mapping priority rules encountered.\nContinue generation?",
        "", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
      return option == JOptionPane.YES_OPTION;
    }
    return true;
  }

  private void printGenerationStepData(AbstractGenerationStepController stepController, SModel inputModel) {
    List<String> namespaces = GenerationPartitioningUtil.getUsedLanguageNamespaces(inputModel, false);
    Collections.sort(namespaces);
    addMessage(new Message(MessageKind.INFORMATION, "languages used:"));
    for (String namespace : namespaces) {
      addMessage(new Message(MessageKind.INFORMATION, "    " + namespace));
    }
//    List<Generator> generators = stepController.getGenerators();
//    Collections.sort(generators, new Comparator<Generator>() {
//      public int compare(Generator o1, Generator o2) {
//        if (o1 == o2) return 0;
//        return o1.getAlias().compareTo(o2.getAlias());
//      }
//    });
//    addMessage(new Message(MessageKind.INFORMATION, "engaged generators:"));
//    for (Generator generator : generators) {
//      addMessage(new Message(MessageKind.INFORMATION, "    " + generator.getAlias()));
//    }

    addMessage(new Message(MessageKind.INFORMATION, "apply mapping configurations:"));
    List<String> messages = GenerationPartitioningUtil.toStrings(stepController.getCurrentMappings());
    for (String message : messages) {
      addMessage(new Message(MessageKind.INFORMATION, "    " + message));
    }
  }
}
