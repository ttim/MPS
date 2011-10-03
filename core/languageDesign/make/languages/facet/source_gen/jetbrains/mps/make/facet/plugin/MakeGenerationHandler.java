package jetbrains.mps.make.facet.plugin;

/*Generated by MPS */

import jetbrains.mps.generator.generationTypes.GenerationHandlerBase;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.resources.GResource;
import jetbrains.mps.smodel.IOperationContext;
import java.util.List;
import jetbrains.mps.util.Pair;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.generator.GenerationCanceledException;
import java.io.IOException;
import jetbrains.mps.generator.GenerationStatus;
import jetbrains.mps.smodel.ProjectModels;
import jetbrains.mps.smodel.SModelStereotype;

public class MakeGenerationHandler extends GenerationHandlerBase {
  private _FunctionTypes._return_P1_E0<? extends Boolean, ? super GResource> resourceHandler;

  public MakeGenerationHandler(_FunctionTypes._return_P1_E0<? extends Boolean, ? super GResource> resourceHandler) {
    this.resourceHandler = resourceHandler;
  }

  public boolean compile(IOperationContext context, List<Pair<IModule, List<SModelDescriptor>>> list, boolean b, ProgressMonitor helper) throws GenerationCanceledException, IOException {
    return true;
  }

  public int estimateCompilationMillis() {
    return 0;
  }

  public boolean handleOutput(IModule module, SModelDescriptor descriptor, GenerationStatus status, IOperationContext context, ProgressMonitor helper) {
    return resourceHandler.invoke(new GResource(module, descriptor, null, status));
  }

  public boolean canHandle(SModelDescriptor descriptor) {
    return descriptor != null && (ProjectModels.isProjectModel(descriptor.getSModelReference()) || SModelStereotype.isUserModel(descriptor));
  }
}
