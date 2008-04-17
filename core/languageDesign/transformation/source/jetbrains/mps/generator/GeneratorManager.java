package jetbrains.mps.generator;

import jetbrains.mps.components.IExternalizableComponent;
import jetbrains.mps.generator.fileGenerator.IFileGenerator;
import jetbrains.mps.generator.generationTypes.GenerateFilesGenerationType;
import jetbrains.mps.generator.template.Statistics;
import jetbrains.mps.helgins.inference.NodeTypesComponentsRepository;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.helgins.inference.TypeCheckingMode;
import jetbrains.mps.ide.AbstractProjectFrame;
import jetbrains.mps.ide.IDEProjectFrame;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.ide.messages.*;
import jetbrains.mps.ide.preferences.IComponentWithPreferences;
import jetbrains.mps.ide.preferences.IPreferencesPage;
import jetbrains.mps.ide.progress.AdaptiveProgressMonitor;
import jetbrains.mps.ide.progress.IAdaptiveProgressMonitor;
import jetbrains.mps.ide.progress.MessagesOnlyAdaptiveProgressMonitorWrapper;
import jetbrains.mps.ide.progress.util.ModelsProgressUtil;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.make.ModuleMaker;
import jetbrains.mps.plugin.CompilationResult;
import jetbrains.mps.plugin.IProjectHandler;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import jetbrains.mps.transformation.TLBase.plugin.debug.GenerationTracer;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.Mapper;
import jetbrains.mps.util.Pair;
import org.jdom.Element;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.*;
import java.util.concurrent.*;


public class GeneratorManager implements IExternalizableComponent, IComponentWithPreferences {
  public static final int AMOUNT_PER_MODEL = 100;
  public static final int AMOUNT_PER_COMPILATION = 100;

  public static final Logger LOG = Logger.getLogger(GeneratorManager.class);

  private static final String SAVE_TRANSIENT_MODELS = "save-transient-models-on-generation";
  private static final String DUMP_STATISTICS = "dump-staticstics-on-generation";
  private static final String SHOW_ERRORS_ONLY = "show-errors-only";

  private boolean mySaveTransientModels;
  private boolean myDumpStatistics = false;
  private boolean myShowErrorsOnly;
  private List<IFileGenerator> myFileGenerators = new LinkedList<IFileGenerator>();

  private ExecutorService myExecutorService = Executors.newCachedThreadPool();

  public GeneratorManager() {
  }

  public void addFileGenerator(IFileGenerator fileGenerator) {
    myFileGenerators.add(fileGenerator);
  }

  public void removeFileGenerator(IFileGenerator fileGenerator) {
    myFileGenerators.remove(fileGenerator);
  }

  public void read(Element element, MPSProject project) {
    if (element.getAttribute(SAVE_TRANSIENT_MODELS) != null) {
      mySaveTransientModels = Boolean.parseBoolean(element.getAttributeValue(SAVE_TRANSIENT_MODELS));
    }
    if (element.getAttribute(DUMP_STATISTICS) != null) {
      myDumpStatistics = Boolean.parseBoolean(element.getAttributeValue(DUMP_STATISTICS));
    }
    if (element.getAttribute(SHOW_ERRORS_ONLY) != null) {
      myShowErrorsOnly = Boolean.parseBoolean(element.getAttributeValue(SHOW_ERRORS_ONLY));
    }
  }

  public void write(Element element, MPSProject project) {
    element.setAttribute(SAVE_TRANSIENT_MODELS, "" + mySaveTransientModels);
    element.setAttribute(DUMP_STATISTICS, "" + myDumpStatistics);
    element.setAttribute(SHOW_ERRORS_ONLY, "" + myShowErrorsOnly);
  }

  public boolean isSaveTransientModels() {
    return mySaveTransientModels;
  }

  public void setSaveTransientModels(boolean saveTransientModels) {
    mySaveTransientModels = saveTransientModels;
  }

  public boolean isShowErrorsOnly() {
    return myShowErrorsOnly;
  }

  public void setShowErrorsOnly(boolean showErrorsOnly) {
    myShowErrorsOnly = showErrorsOnly;
  }

  public boolean isDumpStatistics() {
    return myDumpStatistics;
  }

  public void setDumpStatistics(boolean dumpStatistics) {
    myDumpStatistics = dumpStatistics;
  }

  public List<IPreferencesPage> createPreferencesPages() {
    return CollectionUtil.asList((IPreferencesPage) new GeneratorManagerPreferencesPage(this));
  }

  public IGenerationType getDefaultModuleGenerationType() {
    return IGenerationType.FILES;
  }

  private void clearMessageVew(MPSProject project) {
    MessageView messageView = project.getComponent(MessageView.class);
    if (messageView != null) {
      messageView.clear();
    }
  }

  private void showMessageView(MPSProject project) {
    MessageView messageView = project.getComponent(MessageView.class);
    if (messageView != null) {
      messageView.show(true);
    }
  }

  public IFileGenerator chooseFileGenerator(SNode outputRootNode, SNode originalInputNode) {
    for (IFileGenerator fileGenerator : myFileGenerators) {
      try {
        if (fileGenerator.overridesDefault(outputRootNode, originalInputNode)) {
          return fileGenerator;
        }
      } catch (Throwable t) {
        LOG.error(t);
      }
    }

    for (IFileGenerator fileGenerator : myFileGenerators) {
      try {
        if (fileGenerator.isDefault(outputRootNode)) {
          return fileGenerator;
        }
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
    return null;
  }

  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public void generateModelsFromDifferentModules(final IOperationContext operationContext, final List<SModelDescriptor> inputModels, final IGenerationType generationType) {
    new Thread() {
      public void run() {
        AbstractProjectFrame projectFrame = operationContext.getComponent(AbstractProjectFrame.class);
        try {
          GeneratorManager generatorManager = operationContext.getComponent(GeneratorManager.class);
          List<Pair<SModelDescriptor, IOperationContext>> modelsWithContext = new ArrayList<Pair<SModelDescriptor, IOperationContext>>();
          for (SModelDescriptor model : inputModels) {
            assert model != null;
            ModuleContext moduleContext = ModuleContext.create(model, projectFrame, false);
            modelsWithContext.add(new Pair<SModelDescriptor, IOperationContext>(model, moduleContext));
          }

          Future<Boolean> f = generatorManager.generateModelsWithProgressWindow(
            modelsWithContext,
            generationType,
            false);
          f.get();
        } catch (InterruptedException e) {
          LOG.error(e);
        } catch (ExecutionException e) {
          LOG.error(e);
        }
      }
    }.start();
  }

  /**
   * @return false if canceled
   */
  public Future<Boolean> generateModelsWithProgressWindow(final List<SModelDescriptor> inputModels,
                                                          final IOperationContext invocationContext,
                                                          final IGenerationType generationType,
                                                          boolean closeOnExit) {
    return generateModelsWithProgressWindow(
      CollectionUtil.map(
        inputModels,
        new Mapper<SModelDescriptor, Pair<SModelDescriptor, IOperationContext>>() {
          public Pair<SModelDescriptor, IOperationContext> map(SModelDescriptor model) {
            assert model != null;
            return new Pair<SModelDescriptor, IOperationContext>(model, invocationContext);
          }
        }),
      generationType,
      closeOnExit);
  }

  /**
   * @return false if canceled
   */
  private Future<Boolean> generateModelsWithProgressWindow(final List<Pair<SModelDescriptor, IOperationContext>> inputModels,
                                                           final IGenerationType generationType,
                                                           boolean closeOnExit) {
    if (inputModels.isEmpty()) {
      return myExecutorService.submit(new Callable<Boolean>() {
        public Boolean call() throws Exception {
          return true;
        }
      });
    }

    final IOperationContext invocationContext = inputModels.get(0).o2;
    final IAdaptiveProgressMonitor progress = new AdaptiveProgressMonitor(invocationContext.getComponent(IDEProjectFrame.class), closeOnExit);
    final DefaultMessageHandler messages = new DefaultMessageHandler(invocationContext.getProject());

    // confirm saving transient models
    final boolean saveTransientModels;
    if (isSaveTransientModels()) {
      Object[] options = {"Yes",
        "Not this time",
        "No, and cancel saving"};
      int option = JOptionPane.showOptionDialog(invocationContext.getMainFrame(),
        "Would you like to save transient models?",
        "",
        JOptionPane.YES_NO_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        options,
        options[0]);

      if (option == JOptionPane.YES_OPTION) {
        saveTransientModels = true;
      } else {
        saveTransientModels = false;
        if (option == JOptionPane.CANCEL_OPTION) {
          setSaveTransientModels(false);
        }
      }
    } else {
      saveTransientModels = false;
    }

    return myExecutorService.submit(new Callable<Boolean>() {
      public Boolean call() throws Exception {
        if (saveTransientModels) {
          invocationContext.getProject().getComponentSafe(GenerationTracer.class).startTracing();
        }
        boolean result = generateModels(inputModels, generationType, progress, messages, saveTransientModels);
        invocationContext.getProject().getComponentSafe(GenerationTracer.class).finishTracing();
        return result;
      }
    });
  }

  /**
   * @return false if canceled
   */
  public boolean generateModels(final List<SModelDescriptor> inputModels,
                                final IOperationContext invocationContext,
                                final IGenerationType generationType,
                                final IAdaptiveProgressMonitor progress,
                                final IMessageHandler messages,
                                final boolean saveTransientModels
  ) {
    return generateModels(
      CollectionUtil.map(
        inputModels,
        new Mapper<SModelDescriptor, Pair<SModelDescriptor, IOperationContext>>() {
          public Pair<SModelDescriptor, IOperationContext> map(SModelDescriptor model) {
            assert model != null;
            return new Pair<SModelDescriptor, IOperationContext>(model, invocationContext);
          }
        }),
      generationType,
      progress,
      messages,
      saveTransientModels);
  }

  /**
   * @return false if canceled
   */
  private boolean generateModels(final List<Pair<SModelDescriptor, IOperationContext>> inputModels,
                                 final IGenerationType generationType,
                                 final IAdaptiveProgressMonitor progress,
                                 final IMessageHandler messages,
                                 final boolean saveTransientModels
  ) {
    final boolean[] result = new boolean[1];
    CommandProcessor.instance().executeGenerationCommand(new Runnable() {
      public void run() {
        result[0] = generateModels_internal(inputModels, generationType, progress, messages, saveTransientModels);
      }
    });
    return result[0];
  }

  /**
   * @return false if canceled
   */
  private boolean generateModels_internal(List<Pair<SModelDescriptor, IOperationContext>> _inputModels,
                                          IGenerationType generationType,
                                          IAdaptiveProgressMonitor progress,
                                          IMessageHandler messages,
                                          boolean saveTransientModels) {

    IOperationContext firstContext = _inputModels.get(0).o2;

    //module partition
    Map<SModelDescriptor, IOperationContext> modelsToContexts = new HashMap<SModelDescriptor, IOperationContext>();
    for (Pair<SModelDescriptor, IOperationContext> modelPair : _inputModels) {
      modelsToContexts.put(modelPair.o1, modelPair.o2);
    }
    List<Pair<IModule, List<SModelDescriptor>>> moduleSequence = new ArrayList<Pair<IModule, List<SModelDescriptor>>>();
    Map<IModule, IOperationContext> modulesToContexts = new HashMap<IModule, IOperationContext>();
    {
      IModule current = null;
      ArrayList<SModelDescriptor> currentList = null;
      for (Pair<SModelDescriptor, IOperationContext> inputModel : _inputModels) {
        IModule newModule = inputModel.o2.getModule();
        if (current == null || newModule != current) {
          current = newModule;
          currentList = new ArrayList<SModelDescriptor>();
          moduleSequence.add(new Pair<IModule, List<SModelDescriptor>>(current, currentList));
          modulesToContexts.put(current, inputModel.o2);
        }
        currentList.add(inputModel.o1);
      }
    }

    // time estimation
    boolean compile = (
      generationType.requiresCompilationInIDEAfterGeneration() || generationType.requiresCompilationInIDEABeforeGeneration());
    long totalJob = 0;
    Map<IModule, Long> modulesToGenerationTimes = new HashMap<IModule, Long>();
    Map<IModule, Long> modulesToResidualTimes = new HashMap<IModule, Long>();
    for (Pair<IModule, List<SModelDescriptor>> pair : moduleSequence) { //todo
      IModule module = pair.o1;
      if (module != null) {
        long jobTime = ModelsProgressUtil.estimateTotalGenerationJobMillis(compile, module != null && !module.isCompileInMPS(), pair.o2);
        long generationTime = ModelsProgressUtil.estimateTotalGenerationJobMillis(false, false, pair.o2);
        totalJob += jobTime;
        modulesToGenerationTimes.put(module, jobTime);
        modulesToResidualTimes.put(module, jobTime - generationTime);
      }
    }
    if (totalJob == 0) {
      totalJob = 1000; //todo we need it for build file generation
    }

    progress.start("generating", totalJob);

    MPSModuleRepository.getInstance().removeTransientModules();
    MPSProject project = firstContext.getProject();
    IProjectHandler projectHandler = project.getProjectHandler();
    showMessageView(project);

    project.saveModels();

    clearMessageVew(project);
    messages.handle(new Message(MessageKind.INFORMATION, generationType.getStartText()));

    boolean ideaPresent = projectHandler != null;
    Map<IModule, String> outputFolders = new HashMap<IModule, String>();

    try {
      boolean generationOK = true;
      boolean generationERROR = false;
      for (Pair<IModule, List<SModelDescriptor>> moduleAndDescriptors : moduleSequence) {
        IModule currentModule = moduleAndDescriptors.o1;

        IOperationContext invocationContext = modulesToContexts.get(currentModule);
        Long estimated = modulesToGenerationTimes.get(currentModule);
        if (estimated == null) {
          estimated = (long) 1000;
        }
        progress.startTask("generating in module " + currentModule, estimated);
        String outputFolder = currentModule != null ? currentModule.getGeneratorOutputPath() : null;
        if (outputFolder != null && !new File(outputFolder).exists()) {
          new File(outputFolder).mkdirs();

          try {
            projectHandler.addSourceRoot(outputFolder);
          } catch (Exception e) {
            messages.handle(new Message(MessageKind.WARNING, "Can't add output folder to IDEA as sources"));
          }
        }

        messages.handle(new Message(MessageKind.INFORMATION, "    target root folder: \"" + outputFolder + "\""));
        outputFolders.put(currentModule, outputFolder);

        //++ generation
        Statistics.setEnabled(Statistics.TPL, isDumpStatistics());
        String wasLoggingThreshold = null;
        IGenerationSession generationSession = new GenerationSession(invocationContext, saveTransientModels, progress, messages);
        try {
          if (isShowErrorsOnly()) {
            wasLoggingThreshold = Logger.setThreshold("ERROR");
          }
          Logger.addLoggingHandler(generationSession.getLoggingHandler());
          TypeChecker.getInstance().setIncrementalMode(false);
          TypeChecker.getInstance().setTypeCheckingMode(TypeCheckingMode.GENERATION);
          for (SModelDescriptor inputModel : moduleAndDescriptors.o2) {
            progress.addText("");

            String taskName = ModelsProgressUtil.generationModelTaskName(inputModel);
            progress.startLeafTask(taskName, ModelsProgressUtil.TASK_KIND_GENERATION);

            GenerationStatus status = generationSession.generateModel(inputModel);
            generationOK = generationOK && status.isOk();
            generationERROR = generationERROR || status.isError();
            if (isDumpStatistics()) {
              Statistics.dumpAll();
            }

            progress.addText("handling output...");
            checkMonitorCanceled(progress);
            if (status.getOutputModel() != null) {
              boolean result = generationType.handleOutput(status, outputFolder, invocationContext, progress, messages);

              if (!result) {
                progress.addText("there were errors.");
                generationOK = false;
              }
            } else if (!(status.isCanceled() || status.isError())) {
              generationType.handleEmptyOutput(status, outputFolder, invocationContext, progress, messages);
            }
            generationSession.discardTransients();
            progress.finishTask(taskName);
          }
        } finally {
          if (wasLoggingThreshold != null) {
            Logger.setThreshold(wasLoggingThreshold);
          }
          generationSession.discardTransients();
          Logger.removeLoggingHandler(generationSession.getLoggingHandler());
          TypeChecker.getInstance().setIncrementalMode(true);
          TypeChecker.getInstance().resetTypeCheckingMode();

          if (firstContext.getMainFrame() != null) {
            SModelRepository.getInstance().tryToReloadModelsFromDisk((JFrame) firstContext.getMainFrame());
          }
        }

        checkMonitorCanceled(progress);
        progress.addText("");
        progress.finishTask("generating in module " + currentModule);
      }


      if (generationOK) {
        boolean generatedAndCompiledSuccessfully = true;
        boolean needToReload = false;

        for (Pair<IModule, List<SModelDescriptor>> moduleListPair : moduleSequence) {
          IModule module = moduleListPair.o1;

          if (module != null && module.reloadClassesAfterGeneration()) {
            needToReload = true;
          }

          if (module != null && (!ideaPresent && !module.isCompileInMPS()) || !generationType.requiresCompilationInIDEAfterGeneration()) {
            generatedAndCompiledSuccessfully = false;
          } else {
            checkMonitorCanceled(progress);
            progress.startTask(ModelsProgressUtil.TASK_NAME_COMPILE_ON_GENERATION);
            CompilationResult compilationResult;
            if (!module.isCompileInMPS()) {
              progress.startLeafTask(ModelsProgressUtil.TASK_NAME_REFRESH_FS);
              projectHandler.refreshFS();
              progress.finishTask(ModelsProgressUtil.TASK_NAME_REFRESH_FS);
              progress.addText("compiling in IntelliJ IDEA...");
              progress.startLeafTask(ModelsProgressUtil.TASK_NAME_COMPILE_IN_IDEA);
              compilationResult = projectHandler.buildModule(outputFolders.get(module));
              progress.finishTask(ModelsProgressUtil.TASK_NAME_COMPILE_IN_IDEA);
            } else {
              progress.startLeafTask(ModelsProgressUtil.TASK_NAME_COMPILE_IN_MPS);
              progress.addText("compiling in JetBrains MPS...");

              if (!ModuleMaker.isMakeTurnedOff()) {
                compilationResult = new ModuleMaker().make(CollectionUtil.asSet(module), new MessagesOnlyAdaptiveProgressMonitorWrapper(progress));
              } else {
                compilationResult = new CompilationResult(0, 0, false);
              }

              progress.finishTask(ModelsProgressUtil.TASK_NAME_COMPILE_IN_MPS);
            }

            if (compilationResult.getErrors() > 0) {
              generatedAndCompiledSuccessfully = false;
            }

            progress.addText("" + compilationResult);
            progress.finishTask(ModelsProgressUtil.TASK_NAME_COMPILE_ON_GENERATION);
            checkMonitorCanceled(progress);
          }
        }

        for (SModelDescriptor sm : modelsToContexts.keySet()) {
          ModelGenerationStatusManager.getInstance().invalidateData(sm);
        }

        if (generatedAndCompiledSuccessfully && needToReload) {
          progress.addText("");
          progress.addText("reloading MPS classes...");
          progress.startLeafTask(ModelsProgressUtil.TASK_NAME_RELOAD_ALL);
          ClassLoaderManager.getInstance().reloadAll();
          progress.finishTask(ModelsProgressUtil.TASK_NAME_RELOAD_ALL);
        }

        if (generationOK) {
          progress.addText("generation completed successfully");
          messages.handle(new Message(MessageKind.INFORMATION, "generation completed successfully"));
        } else {
          progress.addText("generation completed with errors");
          messages.handle(new Message(MessageKind.INFORMATION, "generation completed with errors"));
        }
        //  progress.finishSomehow();
      } else if (generationERROR) {
        progress.addText("generation finished with errors");
        messages.handle(new Message(MessageKind.WARNING, "generation finished with errors"));
        // progress.finishSomehow();
      }

      if (generationType instanceof GenerateFilesGenerationType && ideaPresent &&
        !generationType.requiresCompilationInIDEAfterGeneration()) {
        projectHandler.refreshFS();
      }

    } catch (GenerationCanceledException gce) {
      progress.addText("generation canceled");
      messages.handle(new Message(MessageKind.WARNING, "generation canceled"));

      progress.finishAnyway();
      showMessageView(project);

      return false;
    } catch (Throwable t) {
      LOG.error(t);
      final String text = t.toString();
      progress.addText(text);
      messages.handle(new Message(MessageKind.ERROR, text));
      //  progress.finishSomehow();
    } finally {

      TypeChecker.getInstance().clearForReload();
      NodeTypesComponentsRepository.getInstance().clear();

      if (ideaPresent && generationType.requiresCompilationInIDEAfterGeneration()) {
        SModelRepository.getInstance().refreshModels();
        System.gc();
      }
      progress.finishAnyway();
    }

    return true;
  }

  private void checkMonitorCanceled(IAdaptiveProgressMonitor progressMonitor) {
    if (progressMonitor.isCanceled()) throw new GenerationCanceledException();
  }

  public boolean willCompile(boolean ideaPresent, IGenerationType generationType) {
    return ideaPresent && generationType.requiresCompilationInIDEABeforeGeneration();
  }
}
