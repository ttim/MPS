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
package jetbrains.mps.lang.test.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SimpleNodeTest extends NodesTestMethod {
  public static final String concept = "jetbrains.mps.lang.test.structure.SimpleNodeTest";

  public SimpleNodeTest(SNode node) {
    super(node);
  }

  public static SimpleNodeTest newInstance(SModel sm, boolean init) {
    return (SimpleNodeTest)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.test.structure.SimpleNodeTest", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SimpleNodeTest newInstance(SModel sm) {
    return SimpleNodeTest.newInstance(sm, false);
  }

}
