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

import jetbrains.mps.lang.core.structure.BaseConcept;

public class TestNode_AnnotationLink {
  public static final String TEST_NODE = "testNode";

  public static void setTestNode(BaseConcept source, INodeAnnotattion target) {
    source.setAttribute(TestNode_AnnotationLink.TEST_NODE, target);
  }

  public static INodeAnnotattion getTestNode(BaseConcept source) {
    return (INodeAnnotattion)source.getAttribute(TestNode_AnnotationLink.TEST_NODE);
  }

}
