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
package jetbrains.mps.smodel.structure;

import java.util.Collections;

/**
* Created by IntelliJ IDEA.
* User: fyodor
* Date: 1/23/12
* Time: 11:18 AM
* To change this template use File | Settings | File Templates.
*/
public class DefaultExtensionDescriptor implements ExtensionDescriptor {
  public Iterable<? extends ExtensionPoint> getExtensionPoints() {
      return Collections.emptyList();
  }

  public Iterable<? extends Extension> getExtensions() {
    return Collections.emptyList();
  }
}
