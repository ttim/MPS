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
package jetbrains.mps.generator.template;

import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;

public class MapSrcMacroPostProcContext extends TemplateQueryContext {
  private SNode myMacro;
  private SNode myOutputNode;

  public MapSrcMacroPostProcContext(SNode node, SNode macroNode, SNode outputNode, @NotNull TemplateContext context, ITemplateGenerator generator) {
    super(node, macroNode.getParent(), context, generator);
    myMacro = macroNode;
    myOutputNode = outputNode;
  }

  /**
   * 'outputNode' mapping
   */
  public SNode getOutputNode() {
    return myOutputNode;
  }

  public SNode getTemplateNodeForLogging() {
    return myMacro;
  }
}
