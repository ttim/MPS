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
package jetbrains.mps.project;

import com.intellij.openapi.components.*;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.MPSProjectVersion.MyState;

@State(
  name = "ProjectVersion",
  storages = {
    @Storage(
      id = "other",
      file = "$PROJECT_FILE$"
    )
  }
)
public class MPSProjectVersion extends AbstractProjectComponent implements PersistentStateComponent<MyState>{
  public static final Version CURRENT = Version.fromString("2.5");
  private static final Version DEFAULT = Version.fromString("1.5");
  private Version myVersion = DEFAULT;

  protected MPSProjectVersion(Project project) {
    super(project);
  }

  public MyState getState() {
    MyState res = new MyState();
    res.version = myVersion.toString();
    return res;
  }

  public void loadState(MyState state) {
    try {
      myVersion = Version.fromString(state.version);
    }
    catch (IllegalArgumentException e) {
      myVersion = DEFAULT;
    }
  }

  public Version getVersion() {
    return myVersion;
  }

  public void setVersion(Version version) {
    myVersion = version;
  }

  public static class MyState{
    public String version;
  }
}
