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
package jetbrains.mps.ide.java.testMaterial5;

import java.util.List;

/**
 * Cyril.Konopko, 28.12.2009
 */
public class OrdinaryClassWithErasure {
  public void foobar() {
    Object value = null;
    if (value instanceof List) {
      List list = (List) value;
    }
    List list2 = (List) value;
  }
}
