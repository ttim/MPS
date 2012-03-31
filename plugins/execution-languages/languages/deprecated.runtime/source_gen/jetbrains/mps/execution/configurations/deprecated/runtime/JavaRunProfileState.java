package jetbrains.mps.execution.configurations.deprecated.runtime;

/*Generated by MPS */

import jetbrains.mps.util.annotation.ToRemove;
import jetbrains.mps.debug.BaseRunProfileState;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.debug.api.AbstractDebugSessionCreator;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.IDebugger;
import jetbrains.mps.debug.api.Debuggers;


/**
 * Use execution.configurations language
 */
@Deprecated
@ToRemove(version = 2.0)
public abstract class JavaRunProfileState extends BaseRunProfileState {
  @Deprecated
  public JavaRunProfileState() {
  }

  @NotNull
  public AbstractDebugSessionCreator createDebugSessionCreator(Project project) {
    return ((IDebugger) Debuggers.getInstance().getDebuggerByName("Java")).createDebugSessionCreator(project);
  }
}
