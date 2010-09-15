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
package jetbrains.mps.generator.generationTypes;

import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.MPSCore;
import jetbrains.mps.baseLanguage.textGen.BLDependenciesCache;
import jetbrains.mps.debug.api.info.BLDebugInfoCache;
import jetbrains.mps.generator.GenerationCanceledException;
import jetbrains.mps.generator.GenerationStatus;
import jetbrains.mps.generator.IGeneratorLogger;
import jetbrains.mps.generator.ModelGenerationStatusManager;
import jetbrains.mps.generator.fileGenerator.JavaGenerationManager;
import jetbrains.mps.generator.impl.dependencies.GenerationDependenciesCache;
import jetbrains.mps.ide.progress.ITaskProgressHelper;
import jetbrains.mps.ide.progress.util.ModelsProgressUtil;
import jetbrains.mps.make.CompilationResult;
import jetbrains.mps.make.ModuleMaker;
import jetbrains.mps.project.IModule;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.Pair;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Stores files on disk, compiles and reloads classes.
 * <p/>
 * Evgeny Gryaznov, Jan 21, 2010
 */
public class JavaGenerationHandler extends GenerationHandlerBase {
  @Override
  public boolean canHandle(SModelDescriptor inputModel) {
    return SModelStereotype.isUserModel(inputModel);
  }

  @Override
  public void startGeneration(IGeneratorLogger logger) {
    super.startGeneration(logger);
    info("generating files");
  }

  @Override
  public boolean handleOutput(IModule module, SModelDescriptor inputModel, GenerationStatus status, IOperationContext invocationContext, ITaskProgressHelper progressHelper) {
    info("handling output...");
    String targetDir = module.getOutputFor(inputModel);

    long startJobTime = System.currentTimeMillis();
    boolean result = new JavaGenerationManager(
      ModelGenerationStatusManager.getInstance().getCacheGenerator(),
      BLDependenciesCache.getInstance().getGenerator(),
      BLDebugInfoCache.getInstance().getGenerator(),
      GenerationDependenciesCache.getInstance().getGenerator()
      ).handleOutput(invocationContext, status, new File(targetDir));

    if (!result) {
      info("there were errors.");
      return false;
    }
    if (myLogger.needsInfo()) {
      myLogger.info("output generated in " + (System.currentTimeMillis() - startJobTime) + " ms");
    }
    return true;
  }

  public void startModule(IModule module, List<SModelDescriptor> inputModels, IOperationContext operationContext, ITaskProgressHelper progressHelper) {
    progressHelper.setText2("module " + module);

    String outputFolder = module != null ? module.getGeneratorOutputPath() : null;
    prepareOutputFolder(outputFolder);

    if (containsTestModels(inputModels)) {
      String testsOutputFolder = module != null ? module.getTestsGeneratorOutputPath() : null;
      prepareOutputFolder(testsOutputFolder);
    }

    if (myLogger.needsInfo()) {
      myLogger.info("module " + module + "; folder = " + outputFolder + "");
    }
  }

  @Override
  public boolean compile(IOperationContext operationContext, List<Pair<IModule, List<SModelDescriptor>>> input, boolean generationOK, ITaskProgressHelper progressHelper) throws IOException, GenerationCanceledException {
    boolean compiledSuccessfully = generationOK;

    if (generationOK) {
      long compilationStart = System.currentTimeMillis();
      boolean needToReload = false;

      Set<SModelDescriptor> toInvalidate = new HashSet<SModelDescriptor>();
      for (Pair<IModule, List<SModelDescriptor>> moduleListPair : input) {
        IModule module = moduleListPair.o1;
        if (module != null && module.reloadClassesAfterGeneration()) {
          needToReload = true;
        }
        boolean compilationResult = compileModuleInMPS(module, progressHelper);
        compiledSuccessfully = compiledSuccessfully && compilationResult;
        toInvalidate.addAll(moduleListPair.o2);
      }
      for (SModelDescriptor sm : toInvalidate) {
        ModelGenerationStatusManager.getInstance().invalidateData(sm);
      }
      if (compiledSuccessfully && needToReload) {
        reloadClasses(progressHelper);
      }

      info("Compilation finished in " + (System.currentTimeMillis() - compilationStart) + " ms");
    }
    return compiledSuccessfully;
  }

  protected boolean compileModuleInMPS(IModule module, ITaskProgressHelper progressHelper) throws IOException, GenerationCanceledException {
    boolean compiledSuccessfully = true;

    if (module != null) {
      if (!module.isCompileInMPS()) {
        error("Module is compiled in IntelliJ IDEA, can't compile it.");
        compiledSuccessfully = false;
      } else {
        checkMonitorCanceled(progressHelper);
        progressHelper.startLeafTask(ModelsProgressUtil.TASK_NAME_COMPILE_IN_MPS);
        String info = "compiling in JetBrains MPS...";
        progressHelper.setText2(info);
        info(info);
        CompilationResult compilationResult = new ModuleMaker().make(CollectionUtil.set(module), new EmptyProgressIndicator());
        progressHelper.finishTask();
        if (compilationResult == null || compilationResult.getErrors() > 0) {
          compiledSuccessfully = false;
        }

        if (compilationResult != null) {
          if (compilationResult.getErrors() > 0) {
            error("" + compilationResult);
          } else if (compilationResult.getWarnings() > 0) {
            warning("" + compilationResult);
          } else {
            info("" + compilationResult);
          }
        }
      }

      progressHelper.setText2("");
      checkMonitorCanceled(progressHelper);
    }
    return compiledSuccessfully;
  }

  protected void reloadClasses(ITaskProgressHelper progressHelper) {
    if (MPSCore.getInstance().isTestMode()) {
      return;
    }

    long start = System.currentTimeMillis();

    info("");
    String info = "reloading MPS classes...";
    info(info);

    progressHelper.setText2(info);
    progressHelper.startLeafTask(ModelsProgressUtil.TASK_NAME_RELOAD_ALL);
    ClassLoaderManager.getInstance().reloadAll(new EmptyProgressIndicator());
    progressHelper.finishTask();
    progressHelper.setText2("");

    info("Reloaded in " + (System.currentTimeMillis() - start) + " ms");
  }

  @Override
  public long estimateCompilationMillis(List<Pair<IModule, List<SModelDescriptor>>> input) {
    long totalJob = 0;
    for (Pair<IModule, List<SModelDescriptor>> pair : input) {
      IModule module = pair.o1;
      if (module != null) {
        long jobTime = ModelsProgressUtil.estimateCompilationMillis(!module.isCompileInMPS());
        totalJob += jobTime;
      }
    }
    totalJob += ModelsProgressUtil.estimateReloadAllTimeMillis();
    return totalJob;
  }

  protected final boolean containsTestModels(List<SModelDescriptor> sms) {
    for (SModelDescriptor sm : sms) {
      if (SModelStereotype.isTestModel(sm)) return true;
    }
    return false;
  }

  protected final void prepareOutputFolder(String outputFolder) {
    if (outputFolder != null && !new File(outputFolder).exists()) {
      new File(outputFolder).mkdirs();
    }
  }

  @Override
  public String toString() {
    return "Generate Files";
  }
}
