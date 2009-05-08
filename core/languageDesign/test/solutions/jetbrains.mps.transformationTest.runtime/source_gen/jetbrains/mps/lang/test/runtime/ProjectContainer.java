/*
 * Copyright 2003-2009 JetBrains s.r.o.
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
package jetbrains.mps.lang.test.runtime;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import javax.swing.SwingUtilities;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.TestMain;
import java.io.File;

public class ProjectContainer {

  private Map<String, MPSProject> myProjects = MapSequence.fromMap(new HashMap<String, MPSProject>());

  public ProjectContainer() {
  }

  public void clear() {
    final Map<String, MPSProject> projects = MapSequence.fromMap(new HashMap<String, MPSProject>());
    try {
      SwingUtilities.invokeAndWait(new Runnable() {

        public void run() {
          for(MPSProject project : Sequence.fromIterable(MapSequence.fromMap(projects).values())) {
            project.dispose();
          }
          MapSequence.fromMap(projects).clear();
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public MPSProject getProject(String name) {
    IdeMain.setTestMode(IdeMain.TestMode.CORE_TEST);
    if (MapSequence.fromMap(this.myProjects).containsKey(name)) {
      return MapSequence.fromMap(this.myProjects).get(name);
    } else
    {
      TestMain.configureMPS();
      MPSProject p = TestMain.loadProject(new File(name));
      MapSequence.fromMap(this.myProjects).put(name, p);
      return p;
    }
  }

}
