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

import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.MPSProject;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class BaseTestBody {

  public SModelDescriptor myModel;
  public MPSProject myProject;
  public Map<SNode, SNode> myMap;
  public List<SNode> myCopyes;

  public BaseTestBody() {
    this.myMap = MapSequence.fromMap(new HashMap<SNode, SNode>());
    this.myCopyes = ListSequence.fromList(new ArrayList<SNode>());
  }

  public void addNodeById(final String id) throws Exception {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {

      public void run() {
        SNode node = BaseTestBody.this.myModel.getSModel().getNodeById(id);
        SNode copy = CopyUtil.copy(node, BaseTestBody.this.myMap, true);
        for(SNode a : ListSequence.fromList(SNodeOperations.getDescendants(copy, "jetbrains.mps.lang.test.structure.INodeAnnotattion", false))) {
          SNodeOperations.deleteNode(a);
        }
        BaseTestBody.this.myModel.getSModel().addRoot(copy);
        ListSequence.fromList(BaseTestBody.this.myCopyes).addElement(copy);
      }
    });
  }

  public SNode getNodeById(String id) {
    return MapSequence.fromMap(this.myMap).get(this.myModel.getSModel().getNodeById(id));
  }

  public SNode getRealNodeById(String id) {
    return this.myModel.getSModel().getNodeById(id);
  }

}
