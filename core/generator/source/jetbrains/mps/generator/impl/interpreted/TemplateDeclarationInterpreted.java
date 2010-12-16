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
package jetbrains.mps.generator.impl.interpreted;

import jetbrains.mps.generator.impl.GeneratorUtil;
import jetbrains.mps.generator.impl.TemplateProcessor;
import jetbrains.mps.generator.impl.TemplateProcessor.TemplateProcessingFailureException;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.TemplateDeclaration;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import jetbrains.mps.lang.generator.structure.TemplateFragment;
import jetbrains.mps.lang.generator.structure.TemplateParameterDeclaration;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Evgeny Gryaznov, 12/13/10
 */
public class TemplateDeclarationInterpreted implements TemplateDeclaration {

  private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

  private final SNode myTemplateNode;
  private final Object[] myArguments;
  private final String[] myParameterNames;

  private TemplateDeclarationInterpreted(@NotNull SNode templateNode, @NotNull String[] parameterNames, @NotNull Object[] arguments) {
    assert arguments.length == parameterNames.length;
    myTemplateNode = templateNode;
    myArguments = arguments;
    myParameterNames = parameterNames;
  }

  @Override
  public SNodePointer getTemplateNode() {
    return new SNodePointer(myTemplateNode);
  }

  private Map<String, Object> getArgumentsAsMap() {
    Map<String,Object> result = new HashMap<String, Object>();
    for(int i = 0; i < myParameterNames.length; i++) {
      result.put(myParameterNames[i], myArguments[i]);
    }
    return result;
  }

  @Override
  public Collection<SNode> apply(@NotNull TemplateExecutionEnvironment environment, @NotNull TemplateContext context) throws GenerationException {
    TemplateContext applyContext = myArguments.length == 0 ? context : context.subContext(getArgumentsAsMap());

    if(myTemplateNode.isInstanceOfConcept(jetbrains.mps.lang.generator.structure.TemplateDeclaration.concept)) {
      List<TemplateFragment> fragments = GeneratorUtil.getTemplateFragments((jetbrains.mps.lang.generator.structure.TemplateDeclaration) myTemplateNode.getAdapter());
      if (!GeneratorUtil.checkIfOneOrMaryAdjacentFragments(fragments, myTemplateNode, context.getInput(), null, environment.getGenerator())) {
        environment.getGenerator().showErrorMessage(context.getInput(), myTemplateNode, "error processing template declaration");
        return null;
      }

      environment.getTracer().pushTemplateNode(new SNodePointer(myTemplateNode));

      Collection<SNode> outputNodes = new ArrayList<SNode>();
      for (TemplateFragment fragment : fragments) {
        SNode templateForInclude = fragment.getParent().getNode();
        String mappingName = GeneratorUtil.getMappingName(fragment, null);
        TemplateProcessor p = new TemplateProcessor(environment.getGenerator(), environment.getReductionContext());
        try {
          outputNodes.addAll(p.processTemplateNode(mappingName, templateForInclude, context.subContext(mappingName)));
        } catch(TemplateProcessingFailureException ex) {
          /* ignore */
        }
      }
      return outputNodes;
    } else {
      return new TemplateProcessor(environment.getGenerator(), environment.getReductionContext())
        .processTemplateNode(null, myTemplateNode, applyContext);
    }
  }

  public static TemplateDeclaration create(SNode templateNode, Object[] arguments) {
    if(arguments == null) {
      arguments = EMPTY_OBJECT_ARRAY;
    }

    String[] parameterNames = getParameterNames(templateNode);
    if(parameterNames == null || parameterNames.length != arguments.length) {
      return null;
    }

    return new TemplateDeclarationInterpreted(templateNode, parameterNames, arguments);
  }

  private static String[] getParameterNames(SNode templateNode) {
    List<SNode> params = templateNode.getChildren(jetbrains.mps.lang.generator.structure.TemplateDeclaration.PARAMETER);
    String[] result = new String[params.size()];
    for(int i = 0; i < result.length; i++) {
      SNode node = params.get(i);
      if(node == null) {
        return null;  /* bad template */
      }
      result[i] = node.getProperty(TemplateParameterDeclaration.NAME);
      if(result[i] == null) {
        return null;  /* bad template */
      }
    }
    return result;
  }
}
