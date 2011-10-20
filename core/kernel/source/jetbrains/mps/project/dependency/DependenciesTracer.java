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
package jetbrains.mps.project.dependency;

import jetbrains.mps.util.misc.hash.HashMap;
import jetbrains.mps.util.misc.hash.HashSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependenciesTracer<T> {
  private Map<T, Set<List<T>>>  myTraces = new HashMap<T, Set<List<T>>>();
  private List<T> myCurrentTrace = new ArrayList<T>();

  public void track(T node) {
    myCurrentTrace.add(node);
    if (myCurrentTrace.size() == 1) return;
    Set<List<T>> traces = myTraces.get(node);
    if (traces == null) {
      traces = new HashSet<List<T>>();
      myTraces.put(node, traces);
    }
    traces.add(new ArrayList<T>(myCurrentTrace));
  }

  public void unTrack() {
    myCurrentTrace.remove(myCurrentTrace.size()-1);
  }

  public Set<List<T>> getTraces(T node) {
    return myTraces.get(node);
  }
}
