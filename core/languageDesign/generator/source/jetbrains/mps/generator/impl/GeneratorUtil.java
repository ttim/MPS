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
package jetbrains.mps.generator.impl;

import jetbrains.mps.generator.GenerationFailureException;
import jetbrains.mps.generator.IGeneratorLogger;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.generator.plugin.debug.IGenerationTracer;
import jetbrains.mps.lang.generator.structure.*;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import jetbrains.mps.util.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class GeneratorUtil {
  private static final Logger LOG = Logger.getLogger(GeneratorUtil.class);

  public static boolean isTemplateLanguageElement(INodeAdapter n) {
    return n instanceof NodeMacro ||
      n instanceof ReferenceMacro ||
      n instanceof PropertyMacro ||
      n instanceof TemplateFragment ||
      n instanceof RootTemplateAnnotation;
  }

  public static String getMappingName(INodeAdapter node, String defaultValue) {
    String mappingName = null;
    if (node instanceof CreateRootRule) {
      MappingLabelDeclaration mappingLabel = ((CreateRootRule) node).getLabel();
      if (mappingLabel != null) {
        mappingName = mappingLabel.getName();
      }
    } else if (node instanceof BaseMappingRule) {
      MappingLabelDeclaration mappingLabel = ((BaseMappingRule) node).getLabelDeclaration();
      if (mappingLabel != null) {
        mappingName = mappingLabel.getName();
      }
    } else if (node instanceof TemplateFragment) {
      MappingLabelDeclaration mappingLabel = ((TemplateFragment) node).getLabelDeclaration();
      if (mappingLabel != null) {
        mappingName = mappingLabel.getName();
      }
    } else if (node instanceof NodeMacro) {
      MappingLabelDeclaration mappingLabel = ((NodeMacro) node).getMappingLabel();
      if (mappingLabel != null) {
        mappingName = mappingLabel.getName();
      }
    } else {
      LOG.errorWithTrace("unexpected input " + node.getDebugText());
    }

    if (mappingName == null) {
      return defaultValue;
    }
    return mappingName;
  }

  /*package*/

  static List<TemplateFragment> getTemplateFragments(TemplateDeclaration template) {
    List<TemplateFragment> templateFragments = new LinkedList<TemplateFragment>();
    for (INodeAdapter subnode : template.getDescendants()) {
      if (subnode instanceof TemplateFragment) {
        templateFragments.add((TemplateFragment) subnode);
      }
    }
    return templateFragments;
  }

  /*package*/
/*
  static TemplateFragment getFragmentFromTemplate(TemplateDeclaration template, SNode inputNode, SNode ruleNode, ITemplateGenerator generator) {
    List<TemplateFragment> templateFragments = getTemplateFragments(template);
    if (templateFragments.isEmpty()) {
      generator.showErrorMessage(inputNode, BaseAdapter.fromAdapter(template), ruleNode, "couldn't process template: no template fragments found");
      return null;
    }
    if (templateFragments.size() > 1) {
      generator.showErrorMessage(inputNode, BaseAdapter.fromAdapter(template), ruleNode, "couldn't process template: more than one (" + templateFragments.size() + ") fragments found");
      return null;
    }
    return templateFragments.get(0);
  }
*/

  /*package*/

  static boolean checkIfOneOrMaryAdjacentFragments(List<TemplateFragment> fragments, TemplateDeclaration template, SNode inputNode, SNode ruleNode, ITemplateGenerator generator) {
    if (fragments.isEmpty()) {
      generator.showErrorMessage(inputNode, BaseAdapter.fromAdapter(template), ruleNode, "couldn't process template: no template fragments found");
      return false;
    }
    if (fragments.size() > 1) {
      // check if all fragment nodes have the same parent node (same context) and same role in parent
      INodeAdapter templateNode = fragments.get(0).getParent();
      INodeAdapter parent = templateNode.getParent();
      String role = templateNode.getRole_();
      for (TemplateFragment fragment : fragments) {
        templateNode = fragment.getParent();
        if (!(parent == templateNode.getParent() && role.equals(templateNode.getRole_()))) {
          generator.showErrorMessage(inputNode, BaseAdapter.fromAdapter(template), ruleNode, "couldn't process template: all template fragments must reside in the same parent node");
          return false;
        }
      }
    }
    return true;
  }

  @Nullable
  static List<Pair<SNode, String>> getTemplateNodesFromRuleConsequence(RuleConsequence ruleConsequence, SNode inputNode, SNode ruleNode, TemplateGenerator generator)
    throws DismissTopMappingRuleException, AbandonRuleInputException, GenerationFailureException {

    if (ruleConsequence == null) {
      generator.showErrorMessage(inputNode, null, ruleNode, "no rule consequence");
      return null;
    }
    generator.getGenerationTracer().pushRuleConsequence(ruleConsequence.getNode());

    if (ruleConsequence instanceof DismissTopMappingRule) {
      GeneratorMessage message = ((DismissTopMappingRule) ruleConsequence).getGeneratorMessage();
      GeneratorMessageType messageType = processGeneratorMessage(message, inputNode, null, ruleNode, generator);
      throw new DismissTopMappingRuleException(messageType);

    } else if (ruleConsequence instanceof AbandonInput_RuleConsequence) {
      throw new AbandonRuleInputException();

    } else if (ruleConsequence instanceof TemplateDeclarationReference) {
      TemplateDeclaration template = ((TemplateDeclarationReference) ruleConsequence).getTemplate();
/*
      TemplateFragment fragment = getFragmentFromTemplate(template, inputNode, ruleNode, generator);
      if (fragment != null) {
        return new Pair<SNode, String>(fragment.getParent().getNode(), fragment.getName());
      }
*/
      List<TemplateFragment> fragments = getTemplateFragments(template);
      if (checkIfOneOrMaryAdjacentFragments(fragments, template, inputNode, ruleNode, generator)) {
        List<Pair<SNode, String>> result = new ArrayList<Pair<SNode, String>>(fragments.size());
        for (TemplateFragment fragment : fragments) {
          result.add(new Pair<SNode, String>(fragment.getParent().getNode(), getMappingName(fragment, null)));
        }
        return result;
      }

    } else if (ruleConsequence instanceof InlineTemplate_RuleConsequence) {
      BaseConcept templateNode = ((InlineTemplate_RuleConsequence) ruleConsequence).getTemplateNode();
      if (templateNode != null) {
        return Collections.singletonList(new Pair<SNode, String>(templateNode.getNode(), null));
      } else {
        generator.showErrorMessage(inputNode, null, ruleConsequence.getNode(), "no template node");
      }

    } else if (ruleConsequence instanceof InlineSwitch_RuleConsequence) {
      InlineSwitch_RuleConsequence inlineSwitch = (InlineSwitch_RuleConsequence) ruleConsequence;
      for (InlineSwitch_Case switchCase : inlineSwitch.getCases()) {
        if (generator.getExecutor().checkCondition(switchCase.getConditionFunction(), true, inputNode, switchCase.getNode())) {
          return getTemplateNodesFromRuleConsequence(switchCase.getCaseConsequence(), inputNode, switchCase.getNode(), generator);
        }
      }
      RuleConsequence defaultConsequence = inlineSwitch.getDefaultConsequence();
      if (defaultConsequence == null) {
        generator.showErrorMessage(inputNode, null, inlineSwitch.getNode(), "no default consequence in switch");
      } else {
        return getTemplateNodesFromRuleConsequence(defaultConsequence, inputNode, defaultConsequence.getNode(), generator);
      }

    } else {
      generator.showErrorMessage(inputNode, null, ruleConsequence.getNode(), "unsupported rule consequence");
    }

    return null;
  }

  /**
   * @return message type or null if no message have been sent
   */
  /*package*/
  @Nullable
  static GeneratorMessageType processGeneratorMessage(GeneratorMessage message, SNode inputNode, SNode templateNode, SNode ruleNode, ITemplateGenerator generator) {
    GeneratorMessageType messageType = null;
    if (message != null) {
      messageType = message.getMessageType();
      String text = message.getMessageText();
      if (messageType == GeneratorMessageType.error) {
        generator.showErrorMessage(inputNode, templateNode, ruleNode, text);
      } else if (messageType == GeneratorMessageType.warning) {
        generator.showWarningMessage(inputNode, text);
      } else {
        generator.showInformationMessage(inputNode, text);
      }
    }
    return messageType;
  }

  static boolean checkChild(SNode parent, String role, SNode child) {
    return checkLinkTarget(parent, role, child, true, false);
  }

  static boolean checkReferent(SNode reference, String role, SNode referent) {
    return checkLinkTarget(reference, role, referent, false, true);
  }

  private static boolean checkLinkTarget(SNode sourceNode, String role, SNode targetNode, boolean child, boolean riseError) {
    if (child && AttributesRolesUtil.isAttributeRole(role)) {
      //unnecessary warning removed
      return true; //todo maybe add check for attribule links
    }
    String relationKind = child ? "child" : "referent";
    AbstractConceptDeclaration concept = sourceNode.getConceptDeclarationAdapter();
    if (concept == null) {
      // error logging is in the 'getConceptDeclarationAdapter()'
      return false;
    }
    LinkDeclaration link = SModelSearchUtil.findMostSpecificLinkDeclaration(concept, role);
    if (link == null) {
      reportProblem("concept '" + concept.getName() + "' can't have " + relationKind + " with role '" + role + "'", sourceNode, riseError);
      reportProblem(" -- was " + relationKind + (child ? ": " : " (hidden in editor): ") + targetNode.getDebugText(), targetNode, riseError);
      return false;
    }
    if (!SModelUtil_new.isAcceptableTarget(link, targetNode)) {
      String expected = link.getTarget().getName();
      String was = targetNode.getConceptShortName();
      reportProblem(relationKind + " '" + expected + "' is expected for role '" + role + "' but was '" + was + "'", sourceNode, riseError);
      reportProblem(" -- was " + relationKind + ": " + targetNode.getDebugText(), targetNode, riseError);
      return false;
    }

    return true;
  }

  private static void reportProblem(String message, SNode node, boolean error) {
    if (error) {
      LOG.error(message, node);
    } else {
      LOG.warning(message, node);
    }
  }

  public static void logCurrentGenerationBranch(IGeneratorLogger logger, IGenerationTracer generationTracer, boolean error) {
    List<Pair<SNode, String>> pairs = generationTracer.getNodesWithTextFromCurrentBranch();
    StringBuilder indent = new StringBuilder();
    boolean indentInc = true;
    for (Pair<SNode, String> pair : pairs) {
      String logMessage = indent + pair.o2 + (pair.o1 != null ? ": " + pair.o1.getDebugText() : "");
      if (error) {
        logger.error(pair.o1, logMessage);
      } else {
        logger.info(pair.o1, logMessage);
      }
      if (indentInc && indent.length() >= 80) {
        indentInc = false;
      } else if (indent.length() == 0) {
        indentInc = true;
      }

      if (indentInc) {
        indent.append(".");
      } else {
        indent.deleteCharAt(indent.length() - 1);
      }
    }
  }
}
