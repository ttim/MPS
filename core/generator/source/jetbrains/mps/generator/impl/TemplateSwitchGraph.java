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
package jetbrains.mps.generator.impl;

import jetbrains.mps.lang.generator.structure.TemplateSwitch;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TemplateSwitchGraph {

  private Map<TemplateSwitch, Node> mySwitchToNode = new HashMap<TemplateSwitch, Node>();

  public TemplateSwitchGraph(List<SModelDescriptor> templateModels) {
    for (SModelDescriptor templateModel : templateModels) {
      for (SNode root : templateModel.getSModel().roots()) {
        if (!(root.getAdapter() instanceof TemplateSwitch)) continue;

        TemplateSwitch adapter = (TemplateSwitch) root.getAdapter();
        mySwitchToNode.put(adapter, new Node(adapter));
      }
    }
    for (Node node : mySwitchToNode.values()) {
      TemplateSwitch modifiedSwitch = node.mySwitch.getModifiedSwitch();
      if(modifiedSwitch != null) {
        node.myModified = mySwitchToNode.get(modifiedSwitch);
      }
      if(node.myModified == null) {
        node.myRules = new LinkedList<TemplateSwitch>();
      }
    }
    for (Node node : mySwitchToNode.values()) {
      Node bottom = node;
      int i = 256;
      while(bottom.myModified != null && --i > 0) {
        bottom = bottom.myModified;
      }
      if(node != bottom) {
        node.myModified = bottom;
        if(i == 0) {
          throw new RuntimeException("Template switch loop in: " + node);     // TODO handle correctly
        }
      }
      bottom.myRules.add(node.mySwitch);
    }
  }

  public List<TemplateSwitch> getSubgraphAsList(TemplateSwitch baseSwitch) {
    Node bottom = mySwitchToNode.get(baseSwitch);
    while (bottom.myModified != null) {
      bottom = bottom.myModified;
    }
    return bottom.myRules;
  }

  private static class Node {
    final TemplateSwitch mySwitch;
    Node myModified;
    List<TemplateSwitch> myRules;

    public Node(TemplateSwitch switch_) {
      this.mySwitch = switch_;
    }
  }
}
