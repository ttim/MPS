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
package jetbrains.mps.lang.typesystem.runtime.incremental;

import jetbrains.mps.smodel.SNode;

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 27.09.2009
 * Time: 16:21:26
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractNodesReadListener implements INodesReadListener {
  public void propertyExistenceAccess(SNode node, String propertyName) {
    this.nodePropertyReadAccess(node, propertyName, null);
  }

  public void propertyDirtyReadAccess(SNode node, String propertyName) {
    this.nodePropertyReadAccess(node, propertyName, null);
  }

  public void propertyCleanReadAccess(SNode node, String propertyName) {
    this.nodePropertyReadAccess(node, propertyName, null);
  }
}
