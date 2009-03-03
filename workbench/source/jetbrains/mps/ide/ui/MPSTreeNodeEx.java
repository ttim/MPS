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
package jetbrains.mps.ide.ui;

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Aug 25, 2005
 * Time: 5:22:56 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class MPSTreeNodeEx extends MPSTreeNode {
  protected MPSTreeNodeEx(IOperationContext operationContext) {
    super(operationContext);
  }

  public SNode getSNode() {
    return null;
  }
}
