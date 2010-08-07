/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.generator;

import com.intellij.ide.IdeEventQueue;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task.Modal;
import com.intellij.openapi.project.DumbService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.cleanup.CleanupManager;
import jetbrains.mps.generator.generationTypes.IGenerationHandler;
import jetbrains.mps.generator.generationTypes.JavaGenerationHandler;
import jetbrains.mps.generator.impl.GenerationController;
import jetbrains.mps.generator.plan.GenerationPartitioningUtil;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.IdeMain.TestMode;
import jetbrains.mps.ide.messages.*;
import jetbrains.mps.lang.generator.plugin.debug.GenerationTracer;
import jetbrains.mps.lang.generator.plugin.debug.IGenerationTracer;
import jetbrains.mps.lang.generator.plugin.debug.NullGenerationTracer;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.descriptor.RegularSModelDescriptor;
import jetbrains.mps.util.Pair;

import org.jetbrains.annotations.NotNull;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;


@State(
  name = "GenerationManager",
  storages = {
    @Storage(
      id = "other",
      file = "$WORKSPACE_FILE$"
    )
  }
)
public class GeneratorManager {
  public static final int AMOUNT_PER_MODEL = 100;
  public static final int AMOUNT_PER_COMPILATION = 100;

  public static final Logger LOG = Logger.getLogger(GeneratorManager.class);

  private final List<GenerationListener> myGenerationListeners = new ArrayList<GenerationListener>();
  private final List<CompilationListener> myCompilationListeners = new ArrayList<CompilationListener>();

  private GenerationSettings mySettings;
  private Project myProject;
  private boolean myGeneratingRequirements;

  public GeneratorManager(Project project, GenerationSettings settings) {
    myProject = project;
    mySettings = settings;
  }

  public IGenerationHandler getDefaultGenerationHandler() {
    return new JavaGenerationHandler();
  }

  @Deprecated
  public void generateModelsFromDifferentModules(final IOperationContext operationContext,
                                                 final List<RegularSModelDescriptor> inputModels,
                                                 final IGenerationHandler generationHandler) {
    generateModelsFromDifferentModules(operationContext, inputModels, generationHandler, true);
  }


  public void generateModelsFromDifferentModules(final IOperationContext operationContext,
                                                 final List<RegularSModelDescriptor> inputModels,
                                                 final IGenerationHandler generationHandler,
                                                 boolean rebuildAll) {
    try {
      GeneratorManager generatorManager = operationContext.getComponent(GeneratorManager.class);
      List<Pair<RegularSModelDescriptor, IOperationContext>> modelsWithContext = new ArrayList<Pair<RegularSModelDescriptor, IOperationContext>>();
      MessagesViewTool messagesTool = operationContext.getProject().getComponent(MessagesViewTool.class);
      messagesTool.resetAutoscrollOption();
      for (RegularSModelDescriptor model : inputModels) {
        assert model != null;
        ModuleContext moduleContext = ModuleContext.create(model, operationContext.getProject(), false);
        if (moduleContext == null) {
          messagesTool.add(new Message(MessageKind.WARNING, GeneratorManager.class, "Model " + model.getLongName() + " won't be generated"));
          continue;
        }
        modelsWithContext.add(new Pair<RegularSModelDescriptor, IOperationContext>(model, moduleContext));
      }

      generatorManager.generateModelsWithProgressWindow(
        modelsWithContext,
        generationHandler,
        rebuildAll
      );
    } catch (Throwable t) {
      LOG.error(t);
    }
  }

  @Deprecated
  public boolean generateModelsWithProgressWindow(final List<RegularSModelDescriptor> inputModels,
                                                  final IOperationContext invocationContext,
                                                  final IGenerationHandler generationHandler,
                                                  boolean closeOnExit) {
    return generateModelsWithProgressWindow(inputModels, invocationContext, generationHandler, closeOnExit, true);
  }
  /**
   * @return false if canceled
   */
  public boolean generateModelsWithProgressWindow(final List<RegularSModelDescriptor> inputModels,
                                                  final IOperationContext invocationContext,
                                                  final IGenerationHandler generationHandler,
                                                  boolean closeOnExit, boolean rebuildAll) {
    List<Pair<RegularSModelDescriptor, IOperationContext>> inputModelPairs = new ArrayList<Pair<RegularSModelDescriptor, IOperationContext>>();

    for (RegularSModelDescriptor model : inputModels) {
      inputModelPairs.add(new Pair<RegularSModelDescriptor, IOperationContext>(model, invocationContext));
    }

    return generateModelsWithProgressWindow(
      inputModelPairs,
      generationHandler,
      rebuildAll
    );
  }

  /**
   * @return false if canceled
   */
  private boolean generateModelsWithProgressWindow(final List<Pair<RegularSModelDescriptor, IOperationContext>> inputModels,
                                                   final IGenerationHandler generationHandler,
                                                   final boolean rebuildAll
  ) {
    if (inputModels.isEmpty()) {
      return true;
    }

    final IOperationContext invocationContext = inputModels.get(0).o2;
    final DefaultMessageHandler messages = new DefaultMessageHandler(invocationContext.getProject());

    // confirm saving transient models
    final boolean saveTransientModels;
    if (mySettings.isSaveTransientModels()) {
      Object[] options = {
        "Save Transient Models",
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

      if (option == 0) {
        saveTransientModels = true;
      } else {
        saveTransientModels = false;
        if (option == 2) {
          mySettings.setSaveTransientModels(false);
        }
        if (option == -1) {
          return false;
        }
      }
    } else {
      saveTransientModels = false;
    }

    if (DumbService.getInstance(myProject).isDumb()) {
      DumbService.getInstance(myProject).showDumbModeNotification("Generation is not available until indices are built.");
      return false;
    }

    if (generateRequirements()) {
      boolean wasSaveTransientModels = mySettings.isSaveTransientModels();
      myGeneratingRequirements = true;
      try {
        final Set<RegularSModelDescriptor> requirements = new LinkedHashSet<RegularSModelDescriptor>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            for (Pair<RegularSModelDescriptor, IOperationContext> inputModel : inputModels) {
              requirements.addAll(getModelsToGenerateBeforeGeneration(inputModel.o1, inputModel.o2));
            }
          }
        });

        for (Pair<RegularSModelDescriptor, IOperationContext> inputModel : inputModels) {
          requirements.remove(inputModel.o1);
        }

        if (!requirements.isEmpty()) {
          String message = "The following models might be required for generation\n" +
            "but aren't generated. Do you want to generate them?\n";
          for (SModelDescriptor sm : requirements) {
            message += "\n" + sm.getSModelFqName();
          }

          int result = 1;
          if (IdeMain.getTestMode()!=TestMode.CORE_TEST){
            result = Messages.showYesNoCancelDialog(myProject, message, "Generate Required Models", Messages.getWarningIcon());
          }

          //idea don't have constants for YES/NO
          if (result == -1 || result == 2) return false;
          if (result == 0) {
            generateModelsFromDifferentModules(invocationContext, new ArrayList<RegularSModelDescriptor>(requirements), new JavaGenerationHandler());
          }
        }
      } finally {
        mySettings.setSaveTransientModels(wasSaveTransientModels);
        myGeneratingRequirements = false;
      }
    }

    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        SModelRepository.getInstance().saveAll();
      }
    });

    showMessageView();
    IdeEventQueue.getInstance().flushQueue();

    final boolean[] result = new boolean[]{false};
    ProgressManager.getInstance().run(new Modal(invocationContext.getProject(), "Generation", true) {
      public void run(@NotNull ProgressIndicator progress) {
        result[0] = generateModels(inputModels, generationHandler, progress, messages, saveTransientModels, rebuildAll);
      }
    });
    return result[0];
  }

  private void showMessageView() {
    MessagesViewTool messagesView = myProject.getComponent(MessagesViewTool.class);
    if (messagesView != null) {
      messagesView.openToolLater(false);
    }
  }

  protected boolean generateRequirements() {
    return !myGeneratingRequirements && mySettings.isGenerateRequirements();
  }

  private List<RegularSModelDescriptor> getModelsToGenerateBeforeGeneration(SModelDescriptor model, IOperationContext context) {
    List<RegularSModelDescriptor> result = new ArrayList<RegularSModelDescriptor>();

    ModelGenerationStatusManager statusManager = ModelGenerationStatusManager.getInstance();
    for (Generator g : GenerationPartitioningUtil.getAllPossiblyEngagedGenerators(model.getSModel(), context.getScope())) {
      for (SModelDescriptor sm : g.getOwnModelDescriptors()) {
        if (SModelStereotype.isUserModel(sm) && statusManager.generationRequired(sm, context.getProject(), NoCachesStrategy.createBuildCachesStrategy())) {
          result.add(((RegularSModelDescriptor) sm));
        }
      }

      for (SModelDescriptor sm : g.getSourceLanguage().getAspectModelDescriptors()) {
        if (statusManager.generationRequired(sm, context.getProject(), NoCachesStrategy.createBuildCachesStrategy())) {
          result.add(((RegularSModelDescriptor) sm));
        }
      }
    }

    return result;
  }

  /**
   * @return false if canceled
   */
  public boolean generateModels(final List<RegularSModelDescriptor> inputModels,
                                final IOperationContext invocationContext,
                                final IGenerationHandler generationHandler,
                                final ProgressIndicator progress,
                                final IMessageHandler messages) {
    return generateModels(inputModels, invocationContext, generationHandler, progress, messages, false, true);
  }

  /**
   * @return false if canceled
   */
  @Deprecated
  public boolean generateModels(final List<RegularSModelDescriptor> inputModels,
                                final IOperationContext invocationContext,
                                final IGenerationHandler generationHandler,
                                final ProgressIndicator progress,
                                final IMessageHandler messages,
                                boolean saveTransientModels) {
    return generateModels(inputModels, invocationContext, generationHandler, progress, messages, saveTransientModels, true);
  }

  /**
   * @return false if canceled
   */
  public boolean generateModels(final List<RegularSModelDescriptor> inputModels,
                                final IOperationContext invocationContext,
                                final IGenerationHandler generationHandler,
                                final ProgressIndicator progress,
                                final IMessageHandler messages,
                                boolean saveTransientModels,
                                boolean rebuildAll) {
    List<Pair<RegularSModelDescriptor, IOperationContext>> inputModelPairs = new ArrayList<Pair<RegularSModelDescriptor, IOperationContext>>();
    for (RegularSModelDescriptor model : inputModels) {
      inputModelPairs.add(new Pair<RegularSModelDescriptor, IOperationContext>(model, invocationContext));
    }
    return generateModels(
      inputModelPairs,
      generationHandler,
      progress,
      messages,
      saveTransientModels,
      rebuildAll);
  }

  @Deprecated
  public boolean generateModels(final List<Pair<RegularSModelDescriptor, IOperationContext>> inputModels,
                                final IGenerationHandler generationHandler,
                                final ProgressIndicator progress,
                                final IMessageHandler messages,
                                final boolean saveTransientModels) {
    return generateModels(inputModels, generationHandler, progress, messages, saveTransientModels, true);
  }

  /**
   * @return false if canceled
   */
  public boolean generateModels(final List<Pair<RegularSModelDescriptor, IOperationContext>> inputModels,
                                final IGenerationHandler generationHandler,
                                final ProgressIndicator progress,
                                final IMessageHandler messages,
                                final boolean saveTransientModels,
                                final boolean rebuildAll
  ) {
    final boolean[] result = new boolean[1];
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        final Project project = inputModels.get(0).o2.getProject();
        project.getComponent(TransientModelsModule.class).clearAll();
        if (!saveTransientModels) {
          project.getComponent(GenerationTracer.class).discardTracing();
        }

        IGenerationTracer tracer = saveTransientModels
          ? project.getComponent(GenerationTracer.class)
          : new NullGenerationTracer();
        tracer.startTracing();

        fireBeforeGeneration(inputModels);
        GenerationController gc = new GenerationController(new GeneratorNotifierHelper(), mySettings, inputModels, generationHandler, tracer, progress, messages, saveTransientModels, rebuildAll);
        result[0] = gc.generate();
        tracer.finishTracing();
        fireAfterGeneration(inputModels);

        project.getComponent(TransientModelsModule.class).publishAll();
        CleanupManager.getInstance().cleanup();
      }
    });
    return result[0];
  }

  private void fireBeforeGeneration(List<Pair<RegularSModelDescriptor, IOperationContext>> inputModels) {
    for (GenerationListener l : myGenerationListeners) {
      try {
        l.beforeGeneration(inputModels);
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
  }

  private void fireAfterGeneration(List<Pair<RegularSModelDescriptor, IOperationContext>> inputModels) {
    for (GenerationListener l : myGenerationListeners) {
      try {
        l.afterGeneration(inputModels);
      } catch (Throwable t) {
        LOG.error(t);
      }
    }
  }

  public class GeneratorNotifierHelper {

    public void fireModelsGenerated(List<Pair<RegularSModelDescriptor, IOperationContext>> models, boolean success) {
      for (GenerationListener l : myGenerationListeners) {
        try {
          l.modelsGenerated(models, success);
        } catch (Throwable t) {
          LOG.error(t);
        }
      }
    }

    public void fireBeforeModelsCompiled(List<Pair<RegularSModelDescriptor, IOperationContext>> models, boolean success) {
      for (CompilationListener l : myCompilationListeners) {
        try {
          l.beforeModelsCompiled(models, success);
        } catch (Throwable t) {
          LOG.error(t);
        }
      }
    }

    public void fireAfterModelsCompiled(List<Pair<RegularSModelDescriptor, IOperationContext>> models, boolean success) {
      for (CompilationListener l : myCompilationListeners) {
        try {
          l.afterModelsCompiled(models, success);
        } catch (Throwable t) {
          LOG.error(t);
        }
      }
    }
  }

  public void addGenerationListener(GenerationListener l) {
    myGenerationListeners.add(l);
  }

  public void removeGenerationListener(GenerationListener l) {
    myGenerationListeners.remove(l);
  }

  public void addCompilationListener(CompilationListener l) {
    myCompilationListeners.add(l);
  }

  public void removeCompilationListener(CompilationListener l) {
    myCompilationListeners.remove(l);
  }
}
