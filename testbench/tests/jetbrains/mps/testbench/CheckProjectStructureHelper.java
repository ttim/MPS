/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.testbench;

import com.intellij.ide.IdeEventQueue;
import com.intellij.openapi.project.ProjectManager;
import jetbrains.mps.TestMain;
import jetbrains.mps.checkers.LanguageChecker;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.errors.MessageStatus;
import jetbrains.mps.generator.ModelGenerationStatusManager;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.IdeMain.TestMode;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.StandaloneMPSProject;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.project.ProjectDescriptor;
import jetbrains.mps.project.validation.ModelValidator;
import jetbrains.mps.project.validation.ModuleValidatorFactory;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.*;
import jetbrains.mps.typesystemEngine.checker.TypesystemChecker;
import jetbrains.mps.util.Computable;
import jetbrains.mps.util.FileUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import javax.swing.SwingUtilities;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;

public class CheckProjectStructureHelper {

  private static long myErrors;
  private static long myWarnings;
  private MPSProject myProject;

  public CheckProjectStructureHelper() {
  }

  public static void loadModules(final Collection<ModulesMiner.ModuleHandle> handles) {
    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        @Override
        public void run() {
          ModelAccess.instance().runWriteAction(new Runnable() {
            public void run() {
              MPSModuleOwner mpsModuleOwner = new BaseMPSModuleOwner() {
              };

              for (ModulesMiner.ModuleHandle handle : handles) {
                if (handle.getFile().getName().endsWith(".iml")) {
                  // temporary ignore .iml files
                  continue;
                }

                ModuleRepositoryFacade.createModule(handle, mpsModuleOwner);
              }

              ClassLoaderManager.getInstance().reloadAll(new EmptyProgressMonitor());
            }
          });
        }
      });
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public List<String> check(ModulesMiner.ModuleHandle moduleHandle) {
    ModuleReference moduleReference = moduleHandle.getDescriptor().getModuleReference();
    IModule module = MPSModuleRepository.getInstance().getModule(moduleReference);
    assertNotNull("module " + moduleHandle.getFile().getPath() + " was not loaded", module);

    Collection<SModelDescriptor> models = new ModelsExtractor(module, false).includingGenerators().getModels();

    return checkModels(models);
  }

  public List<String> checkStructure(ModulesMiner.ModuleHandle moduleHandle) {
    ModuleReference moduleReference = moduleHandle.getDescriptor().getModuleReference();
    IModule module = MPSModuleRepository.getInstance().getModule(moduleReference);
    assertNotNull("module " + moduleHandle.getFile().getPath() + " was not loaded", module);

    Collection<SModelDescriptor> models = new ModelsExtractor(module, true).includingGenerators().getModels();

    return checkStructure(models);
  }

  public List<String> checkGenerationStatus(ModulesMiner.ModuleHandle moduleHandle) {
    ModuleReference moduleReference = moduleHandle.getDescriptor().getModuleReference();
    IModule module = MPSModuleRepository.getInstance().getModule(moduleReference);
    assertNotNull("module " + moduleHandle.getFile().getPath() + " was not loaded", module);

    Collection<SModelDescriptor> models = new ModelsExtractor(module, false).includingGenerators().getModels();

    return checkModelsGenerationStatus(models);
  }

  public List<String> checkModule(ModulesMiner.ModuleHandle moduleHandle) {
    ModuleReference moduleReference = moduleHandle.getDescriptor().getModuleReference();
    IModule module = MPSModuleRepository.getInstance().getModule(moduleReference);
    assertNotNull("module " + moduleHandle.getFile().getPath() + " was not loaded", module);

    List<IModule> modules = new ArrayList<IModule>();
    modules.add(module);
    if (module instanceof Language) {
      modules.addAll(((Language) module).getGenerators());
    }

    return checkModules(modules);
  }

  public List<String> checkTypeSystem(ModulesMiner.ModuleHandle moduleHandle) {
    ModuleReference moduleReference = moduleHandle.getDescriptor().getModuleReference();
    IModule module = MPSModuleRepository.getInstance().getModule(moduleReference);
    assertNotNull("module " + moduleHandle.getFile().getPath() + " was not loaded", module);

    Collection<SModelDescriptor> models = new ModelsExtractor(module, false).getModels();
    return applyChecker(new TypesystemChecker(), models);
  }

  public List<String> checkConstraints(ModulesMiner.ModuleHandle moduleHandle) {
    ModuleReference moduleReference = moduleHandle.getDescriptor().getModuleReference();
    IModule module = MPSModuleRepository.getInstance().getModule(moduleReference);
    assertNotNull("module " + moduleHandle.getFile().getPath() + " was not loaded", module);

    Collection<SModelDescriptor> models = new ModelsExtractor(module, false).getModels();
    return applyChecker(new LanguageChecker(), models);
  }

  public void cleanUp() {
    doCleanUp(myProject);
  }

  public String formatErrors(List<String> errors) {
    StringBuilder sb = new StringBuilder();
    String sep = "";
    for (String er : errors) {
      sb.append(sep).append(er);
      sep = "\n";
    }
    return sb.toString();
  }

  public void init(String[][] macros) {
    BasicConfigurator.configure();
    Logger.getRootLogger().setLevel(Level.INFO);
    Testbench.initLogging();

    IdeMain.setTestMode(TestMode.CORE_TEST);
    TestMain.configureMPS(new String[0]);

    for (String[] macro : macros) {
      Testbench.setMacro(macro[0], macro[1]);
    }
    Testbench.initLibs();
    Testbench.makeAll();
    Testbench.reloadAll();

    com.intellij.openapi.project.Project ideaProject = ProjectManager.getInstance().getDefaultProject();
    File projectFile = FileUtil.createTmpFile();
    StandaloneMPSProject project = new StandaloneMPSProject(ideaProject);
    project.setProjectFile(projectFile);
    project.init(new ProjectDescriptor());
    myErrors = 0;
    myWarnings = 0;
    myProject = project;
  }

  public void dispose() {
    TestMain.disposeMPS();
  }

  // Private

  private void doCleanUp(final MPSProject project) {
    ThreadUtils.runInUIThreadAndWait(new Runnable() {
      public void run() {
        project.dispose(false);
        IdeEventQueue.getInstance().flushQueue();
        System.gc();
      }
    });
  }

  private List<String> checkModelsGenerationStatus(final Iterable<SModelDescriptor> models) {
    final List<String> errors = new ArrayList<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (SModelDescriptor sm : models) {
          if (!sm.isGeneratable()) continue;

          IModule module = sm.getModule();
          if (module == null) {
            errors.add("Model without a module: " + sm.getSModelReference().toString());
            continue;
          }
          String genHash = ModelGenerationStatusManager.getLastGenerationHash(sm);
          if (genHash == null) {
            errors.add("No generated hash for " + sm.getSModelReference().toString());
            continue;
          }
          String realHash = sm.getModelHash();
          if (realHash == null) {
            errors.add("cannot gen cache for " + sm.getSModelReference().toString());
            continue;
          }
          if (!realHash.equals(genHash)) {
            errors.add("model requires generation: " + sm.getSModelReference().toString() + " last genHash:" + genHash + " modelHash:" + realHash);
          }
        }
      }
    });
    return errors;
  }

  private List<String> checkStructure(final Iterable<SModelDescriptor> models) {
    final List<String> errors = new ArrayList<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (SModelDescriptor sm : models) {
          if (!SModelStereotype.isUserModel(sm)) continue;
          checkModelNodes(sm.getSModel(), errors);
        }
      }
    });
    return errors;
  }

  private List<String> checkModels(final Iterable<SModelDescriptor> models) {
    final List<String> errors = new ArrayList<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (SModelDescriptor sm : models) {
          if (!SModelStereotype.isUserModel(sm)) continue;
          StringBuilder errorMessages = checkModel(sm);

          if (errorMessages.length() > 0) {
            errors.add("Broken References: " + errorMessages.toString());
          }
        }
      }
    });
    return errors;
  }

  private List<String> checkModules(final Iterable<IModule> modules) {
    final List<String> errors = new ArrayList<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (IModule sm : modules) {
          StringBuilder errorMessages = checkModule(sm);
          if (errorMessages.length() > 0) {
            errors.add("Error in module " + sm.getModuleFqName() + ": " + errorMessages.toString());
          }
        }
      }
    });
    return errors;
  }

  private static void checkModelNodes(@NotNull SModel model, @NotNull List<String> result) {
    for (SNode node : model.nodes()) {
      for (String propname : node.getProperties().keySet()) {
        SNode decl = node.getPropertyDeclaration(propname);
        if (decl == null) {
          result.add("unknown property: `" + propname + "' in node " + node.getDebugText());
        }
      }
      for (SReference ref : node.getReferencesIterable()) {
        SNode decl = node.getLinkDeclaration(ref.getRole());
        if (decl == null) {
          result.add("unknown link role: `" + ref.getRole() + "' in node " + node.getDebugText());
        }
      }
      for (SNode child : node.getChildren()) {
        SNode decl = child.getRoleLink();
        if (decl == null) {
          result.add("unknown child role: `" + child.getRole_() + "' in node " + node.getDebugText());
        }
      }
    }
  }

  private List<String> applyChecker(final jetbrains.mps.checkers.INodeChecker checker, final Iterable<SModelDescriptor> models) {
    final List<String> errors = new ArrayList<String>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (SModelDescriptor sm : models) {
          if (!SModelStereotype.isUserModel(sm)) continue;
          if (SModelStereotype.isGeneratorModel(sm)) continue;
          ModuleOperationContext operationContext = new ModuleOperationContext(sm.getModule());
          for (SNode root : jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.getRoots(sm.getSModel(), null)) {
            Set<IErrorReporter> errorReporters = null;
            try {
              errorReporters = checker.getErrors(root, operationContext);
            } catch (IllegalStateException e) {
              errors.add(e.getMessage());
            }
            for (IErrorReporter reporter : errorReporters) {
              if (reporter.getMessageStatus().equals(MessageStatus.ERROR)) {
                if (reporter.reportError().startsWith("a class should have")) continue;
                SNode node = reporter.getSNode();
                if (!CheckProjectStructureUtil.filterIssue(node)) continue;
                myErrors++;
                errors.add("Error message: " + reporter.reportError() + "   model: " + node.getModel().getLongName() + " root: " + node.getContainingRoot() + " node: " + node);
              }
              if (reporter.getMessageStatus().equals(MessageStatus.WARNING)) {
                myWarnings++;
              }
            }
          }

        }
      }
    });
    return errors;
  }

  private StringBuilder checkModel(final SModelDescriptor sm) {
    final IScope scope = sm.getModule().getScope();
    StringBuilder errorMessages = new StringBuilder();
    List<String> validationResult = ModelAccess.instance().runReadAction(new Computable<List<String>>() {
      public List<String> compute() {
        return new ModelValidator(sm.getSModel()).validate(scope);
      }
    });
    if (!validationResult.isEmpty()) {
      errorMessages.append("errors in model: ").append(sm.getSModelReference().toString()).append("\n");
      for (String item : validationResult) {
        errorMessages.append("\t");
        errorMessages.append(item);
        errorMessages.append("\n");
      }
    }

    for (SNode node : sm.getSModel().nodes()) {
      Testbench.LOG.debug("Checking node " + node);
      if (SModelUtil.findConceptDeclaration(node.getConceptFqName(), GlobalScope.getInstance()) == null) {
        errorMessages.append("Unknown concept ");
        errorMessages.append(node.getConceptFqName());
        errorMessages.append("\n");
      }
    }

    for (SNode node : sm.getSModel().nodes()) {
      for (SReference ref : node.getReferences()) {
        if (SNodeUtil.hasReferenceMacro(node, ref.getRole())) {
          continue;
        }

        if (ref.getTargetNodeSilently() == null) {
          errorMessages.
            append("Broken reference in model {").
            append(node.getModel().getLongName()).
            append("}").
            append(" node ").
            append(node.getId()).
            append("(").
            append(node).
            append(")\n");
        }
      }
    }
    return errorMessages;
  }

  private StringBuilder checkModule(final IModule module) {
    StringBuilder errorMessages = new StringBuilder();
    List<String> validationResult = ModelAccess.instance().runReadAction(new Computable<List<String>>() {
      public List<String> compute() {
        return ModuleValidatorFactory.createValidator(module).getErrors();
      }
    });
    if (!validationResult.isEmpty()) {
      for (String item : validationResult) {
        errorMessages.append("\t");
        errorMessages.append(item);
        errorMessages.append("\n");
      }
    }
    return errorMessages;
  }

  public long getNumErrors() {
    return myErrors;
  }

  public long getNumWarnings() {
    return myWarnings;
  }

}