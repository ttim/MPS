package jetbrains.mps.workbench.dataExtraction;

import com.intellij.ide.impl.dataRules.GetDataRule;
import com.intellij.openapi.actionSystem.DataProvider;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.workbench.MPSDataKeys;
import org.jetbrains.annotations.Nullable;

public class ScopeRule implements GetDataRule {
  @Nullable
  public Object getData(DataProvider dataProvider) {
    IOperationContext context = (IOperationContext) dataProvider.getData(MPSDataKeys.OPERATION_CONTEXT.getName());
    if (context == null) return null;
    IScope scope = context.getScope();
    if (scope != null) return scope;

    MPSProject project = (MPSProject) dataProvider.getData(MPSDataKeys.MPS_PROJECT.getName());
    if (project != null) return project.getScope();
    return GlobalScope.getInstance();
  }
}