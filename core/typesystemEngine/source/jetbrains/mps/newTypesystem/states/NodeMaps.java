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
package jetbrains.mps.newTypesystem.states;

import jetbrains.mps.newTypesystem.differences.ErrorDifference;
import jetbrains.mps.newTypesystem.differences.NodeMapDifference;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.smodel.SNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 10, 2010
 * Time: 6:38:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeMaps {
  private Map<SNode, SNode> myNodeToTypes = new HashMap<SNode, SNode>();
  private Map<SNode, List<IErrorReporter>> myNodesToErrors = new HashMap<SNode, List<IErrorReporter>>();
  private State myState;

  public NodeMaps(State state) {
    myState = state;
  }

  public void addNodeToType(SNode node, SNode type) {
    myNodeToTypes.put(node, type);
    myState.addDifference(new NodeMapDifference(node, myNodeToTypes), false);
  }

  public void addNodeToError(SNode node, IErrorReporter error) {
    List<IErrorReporter> errors = myNodesToErrors.get(node);
    if (errors == null) {
      errors = new LinkedList<IErrorReporter>();
      myNodesToErrors.put(node, errors);
    }
    errors.add(error);
    myState.addDifference(new ErrorDifference(node, error, myNodesToErrors), false);
  }

  public Map<SNode, List<IErrorReporter>> getNodesToErrors() {
    return myNodesToErrors;
  }

  public Map<SNode, SNode> getNodeToTypes() {
    return myNodeToTypes;
  }
}
