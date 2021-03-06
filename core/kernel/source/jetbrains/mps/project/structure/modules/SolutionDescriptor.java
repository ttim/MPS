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
package jetbrains.mps.project.structure.modules;

public class SolutionDescriptor extends ModuleDescriptor {

  private String myOutputPath;
  private SolutionKind myKind = SolutionKind.NONE;
  private boolean myCompileInMPS = true;

  public String getOutputPath() {
    return myOutputPath;
  }

  public void setOutputPath(String outputPath) {
    myOutputPath = outputPath;
  }

  public SolutionKind getKind() {
    return myKind;
  }

  public void setKind(SolutionKind kind) {
    myKind = kind;
  }

  @Override
  public boolean getCompileInMPS() {
    return myCompileInMPS;
  }

  @Override
  public void setCompileInMPS(boolean compileInMPS) {
    myCompileInMPS = compileInMPS;
  }
}
