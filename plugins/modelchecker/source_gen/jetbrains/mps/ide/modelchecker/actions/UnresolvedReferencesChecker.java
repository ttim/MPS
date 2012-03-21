package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.resolve.Resolver;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.structure.modules.ModuleReference;

public class UnresolvedReferencesChecker extends SpecificChecker {
  public UnresolvedReferencesChecker() {
  }

  public List<SearchResult<ModelCheckerIssue>> checkModel(final SModel model, ProgressMonitor monitor, final IOperationContext operationContext) {
    List<SearchResult<ModelCheckerIssue>> results = ListSequence.fromList(new ArrayList<SearchResult<ModelCheckerIssue>>());
    if (model == null || model.getModelDescriptor() == null || model.getModelDescriptor().getModule() == null) {
      return results;
    }
    final IScope scope = model.getModelDescriptor().getModule().getScope();
    String title = "Checking " + SModelOperations.getModelName(model) + " for unresolved references...";
    monitor.start(title, 1);

    for (SNode node : ListSequence.fromList(SModelOperations.getNodes(model, null))) {
      if (monitor.isCanceled()) {
        break;
      }
      // Check for unresolved references 
      for (final SReference ref : Sequence.fromIterable(SNodeOperations.getReferences(node))) {
        if ((AttributeOperations.getAttribute(node, new IAttributeDescriptor.LinkAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.generator.structure.ReferenceMacro"), SLinkOperations.getRole(ref))) != null)) {
          continue;
        }
        if (ref.getTargetNodeSilently() == null) {
          addIssue(results, node, "Unresolved reference: " + SLinkOperations.getResolveInfo(ref), ModelChecker.SEVERITY_ERROR, "unresolved reference", new IModelCheckerFix() {
            public boolean doFix() {
              return Resolver.resolve1(ref, operationContext);
            }
          });
        }
        final SModelReference uid = ref.getTargetSModelReference();
        if (uid == null) {
          continue;
        }
        SModelDescriptor descriptor = GlobalScope.getInstance().getModelDescriptor(uid);
        if (scope.getModelDescriptor(uid) == null && descriptor != null) {
          addIssue(results, node, "Target module " + descriptor.getModule() + " should be imported", ModelChecker.SEVERITY_ERROR, "target module not imported", new IModelCheckerFix() {
            public boolean doFix() {
              if (scope.getModelDescriptor(uid) == null && GlobalScope.getInstance().getModelDescriptor(uid) != null) {
                SModelDescriptor sm = GlobalScope.getInstance().getModelDescriptor(uid);
                check_xiru3y_a1a0a5a0a5a2a6a0(check_xiru3y_a0b0a0f0a0f0c0g0a(model.getModelDescriptor()), sm);
                return true;
              }
              return false;
            }
          });
        }
      }
    }
    monitor.done();
    return results;
  }

  private static void check_xiru3y_a1a0a5a0a5a2a6a0(IModule checkedDotOperand, SModelDescriptor sm) {
    if (null != checkedDotOperand) {
      checkedDotOperand.addDependency(check_xiru3y_a0a1a0a5a0a5a2a6a0(check_xiru3y_a0a0b0a0f0a0f0c0g0a(sm)), false);
    }

  }

  private static ModuleReference check_xiru3y_a0a1a0a5a0a5a2a6a0(IModule checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModuleReference();
    }
    return null;
  }

  private static IModule check_xiru3y_a0a0b0a0f0a0f0c0g0a(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static IModule check_xiru3y_a0b0a0f0a0f0c0g0a(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }
}
