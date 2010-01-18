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
package jetbrains.mps.nodeEditor.cellMenu;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.action.DefaultChildNodeSetter;
import jetbrains.mps.smodel.action.DefaultAttributeNodeSetter;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import jetbrains.mps.nodeEditor.EditorContext;

public class DefaultAttributeSubstituteInfo extends DefaultChildSubstituteInfo {

  public DefaultAttributeSubstituteInfo(SNode parentNode, SNode currChildNode, LinkDeclaration linkDeclaration, EditorContext editorContext) {
    super(parentNode, currChildNode, linkDeclaration, editorContext);
  }

  protected DefaultChildNodeSetter createDefaultNodeSetter() {
    return new DefaultAttributeNodeSetter(getLinkDeclaration());
  }
}
