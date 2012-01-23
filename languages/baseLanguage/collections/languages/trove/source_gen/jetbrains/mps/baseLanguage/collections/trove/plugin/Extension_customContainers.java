/*
 * Copyright 2003-2012 JetBrains s.r.o.
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
package jetbrains.mps.baseLanguage.collections.trove.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.Extension;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class Extension_customContainers extends Extension.Default<_FunctionTypes._return_P0_E0<? extends List<SNode>>> {
  public Extension_customContainers() {
    super("jetbrains.mps.baseLanguage.collections.customContainers");
  }

  public _FunctionTypes._return_P0_E0<? extends List<SNode>> get() {
    return new _FunctionTypes._return_P0_E0<List<SNode>>() {
      public List<SNode> invoke() {
        List<SNode> res = new ArrayList<SNode>();
        // Find the model(s) with custom container declarations 
        SModelDescriptor desc = GlobalScope.getInstance().getModelDescriptor(SModelFqName.fromString("jetbrains.mps.baseLanguage.collections.custom"));
        SModel mdl = desc.getSModel();
        if (mdl != null) {
          ListSequence.fromList(res).addSequence(ListSequence.fromList(SModelOperations.getNodes(mdl, "jetbrains.mps.baseLanguage.collections.structure.CustomContainers")));
        }
        return res;
      }
    };
  }

  public void activate() {
  }

  public void deactivate() {
  }
}
