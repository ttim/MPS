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
package jetbrains.mps.debug;

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.AbstractDebugSessionCreator;
import jetbrains.mps.debug.api.AbstractDebugger;
import jetbrains.mps.debug.api.Debuggers;
import jetbrains.mps.debug.api.breakpoints.BreakpointProvidersManager;
import jetbrains.mps.debug.api.breakpoints.IBreakpointsProvider;
import jetbrains.mps.debug.breakpoints.JavaBreakpointsProvider;
import jetbrains.mps.debug.runtime.VMCreator;
import org.jetbrains.annotations.NotNull;

public class JavaDebugger extends AbstractDebugger implements ApplicationComponent {
  private final JavaBreakpointsProvider myJavaBreakpointsProvider = new JavaBreakpointsProvider();

  public JavaDebugger(Debuggers debuggers, BreakpointProvidersManager breakpointsProviderManager) {
    super("Java", debuggers, breakpointsProviderManager);
  }

  @NotNull
  @Override
  public AbstractDebugSessionCreator createDebugSessionCreator(@NotNull Project project) {
    return new VMCreator(project);
  }

  @NotNull
  @Override
  public IBreakpointsProvider getBreakpointsProvider() {
    return myJavaBreakpointsProvider;
  }

  @NotNull
  @Override
  public String getComponentName() {
    return getName() + " Debugger";
  }

  @Override
  public void initComponent() {
    super.init();
  }

  @Override
  public void disposeComponent() {
    super.dispose();
  }
}
