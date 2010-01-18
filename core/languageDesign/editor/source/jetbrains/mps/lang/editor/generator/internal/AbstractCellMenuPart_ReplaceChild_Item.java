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
package jetbrains.mps.lang.editor.generator.internal;

import jetbrains.mps.lang.editor.cellProviders.AggregationCellContext;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.CellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.action.*;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.structure.structure.ConceptDeclaration;

import java.util.LinkedList;
import java.util.List;

/**
 * Igor Alshannikov
 * Date: Nov 29, 2006
 */
public abstract class AbstractCellMenuPart_ReplaceChild_Item implements SubstituteInfoPart {

  public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
    final SNode parentNode = (SNode) cellContext.get(BasicCellContext.EDITED_NODE);
    LinkDeclaration linkDeclaration = (LinkDeclaration) BaseAdapter.fromNode((SNode) cellContext.get(AggregationCellContext.LINK_DECLARATION));
    IChildNodeSetter setter = new DefaultChildNodeSetter(linkDeclaration);
    final AbstractConceptDeclaration defaultConceptOfChild = linkDeclaration.getTarget();
    final SNode currentChild = (SNode) cellContext.getOpt(AggregationCellContext.CURRENT_CHILD_NODE);

    final IOperationContext context = editorContext.getOperationContext();
    List<INodeSubstituteAction> actions = new LinkedList<INodeSubstituteAction>();
    actions.add(new DefaultChildNodeSubstituteAction(defaultConceptOfChild, parentNode, currentChild, setter, context.getScope()) {
      protected String getMatchingText(String pattern, boolean referent_presentation, boolean visible) {
        return AbstractCellMenuPart_ReplaceChild_Item.this.getMatchingText();
      }

      public String getDescriptionText(String pattern) {
        return AbstractCellMenuPart_ReplaceChild_Item.this.getDescriptionText();
      }

      public SNode createChildNode(Object parameterConcept, SModel model, String pattern) {
        if (isCustomCreateChildNode()) {
          SNode newChild = AbstractCellMenuPart_ReplaceChild_Item.this.customCreateChildNode(parentNode, currentChild, defaultConceptOfChild.getNode(), parentNode.getModel(), getScope(), context);
          if (newChild != null) {
            NodeFactoryManager.setupNode((ConceptDeclaration) parameterConcept, newChild, currentChild, parentNode, model, getScope());
          }
          return newChild;
        }
        return NodeFactoryManager.createNode((ConceptDeclaration) BaseAdapter.fromNode((SNode) parameterConcept), currentChild, parentNode, parentNode.getModel(), getScope());
      }
    });
    return actions;
  }

  protected boolean isCustomCreateChildNode() {
    return false;
  }

  protected SNode customCreateChildNode(SNode node, SNode currentChild, SNode defaultConceptOfChild, SModel model, IScope scope, IOperationContext operationContext) {
    return null;
  }

  protected abstract String getMatchingText();

  protected String getDescriptionText() {
    return null;
  }
}
