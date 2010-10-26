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
package jetbrains.mps.nodeEditor.cellMenu;

import com.intellij.util.containers.HashMap;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.structure.structure.Cardinality;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.lang.structure.structure.LinkMetaclass;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.project.AuxilaryRuntimeModel;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.action.DefaultChildNodeSetter;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import jetbrains.mps.typesystem.inference.InequationSystem;
import jetbrains.mps.typesystem.inference.TypeChecker;

import java.util.Arrays;
import java.util.List;

public class DefaultChildSubstituteInfo extends AbstractNodeSubstituteInfo {
  private static final Logger LOG = Logger.getLogger(DefaultChildSubstituteInfo.class);

  private SNode myParentNode;
  private SNode myCurrentChild;
  private LinkDeclaration myLinkDeclaration;

  public DefaultChildSubstituteInfo(final SNode sourceNode, final LinkDeclaration linkDeclaration, final EditorContext editorContext) {
    super(editorContext);
    NodeReadAccessCasterInEditor.runReadTransparentAction(new Runnable() {
      public void run() {
        if (isNotAggregation(linkDeclaration)) {
          LOG.error("only aggregation links are allowed here", linkDeclaration.getNode());
        }
        Cardinality sourceCardinality = SModelUtil_new.getGenuineLinkSourceCardinality(linkDeclaration);
        if (!(sourceCardinality == Cardinality._1 || sourceCardinality == Cardinality._0__1)) {
          LOG.error("only cardinalities 1 or 0..1 are allowed here", linkDeclaration.getNode());
        }

        myParentNode = sourceNode;
        LinkDeclaration mostSpecificLinkDeclaration = SModelSearchUtil.findMostSpecificLinkDeclaration(myParentNode.getConceptDeclarationAdapter(), linkDeclaration.getRole());
        myLinkDeclaration = mostSpecificLinkDeclaration;
        myCurrentChild = sourceNode.getChild(SModelUtil_new.getGenuineLinkRole(linkDeclaration));
      }
    });
  }

  public DefaultChildSubstituteInfo(final SNode parentNode, final SNode currChildNode, final LinkDeclaration linkDeclaration, final EditorContext editorContext) {
    super(editorContext);
    NodeReadAccessCasterInEditor.runReadTransparentAction(new Runnable() {
      public void run() {
        if (linkDeclaration == null) {
          LOG.error("link declaration is null", new IllegalArgumentException("link declaration is null"));
        } else if (isNotAggregation(linkDeclaration)) {
          LOG.error("only aggregation links are allowed here", new RuntimeException("only aggregation links are allowed here"), linkDeclaration.getNode());
        }
        myParentNode = parentNode;
        LinkDeclaration mostSpecificLinkDeclaration = SModelSearchUtil.findMostSpecificLinkDeclaration(myParentNode.getConceptDeclarationAdapter(), linkDeclaration.getRole());
        myLinkDeclaration = mostSpecificLinkDeclaration;
        myCurrentChild = currChildNode;
      }
    });
  }

  public List<INodeSubstituteAction> createActions() {
    List<INodeSubstituteAction> actions = ModelActions.createChildSubstituteActions(myParentNode, myCurrentChild,
      (AbstractConceptDeclaration) myLinkDeclaration.getTarget(),
      createDefaultNodeSetter(),
      getOperationContext());
    return actions;
  }

  public InequationSystem getInequationSystem(EditorCell contextCell) {
    HashMap<SNode, SNode> mapping = new HashMap<SNode, SNode>();
    SModel auxModel = AuxilaryRuntimeModel.getDescriptor().getSModel();
    boolean wasLoading = auxModel.isLoading();
    auxModel.setLoading(true);
    try {
      SNode nodeCopyRoot = CopyUtil.copy(Arrays.asList(myParentNode.getContainingRoot()), mapping).get(0);
      if (!nodeCopyRoot.isRoot()) {
        auxModel.addRoot(nodeCopyRoot);
      }

      boolean holeIsAType = SModelUtil_new.isAssignableConcept(myLinkDeclaration.getTarget(), "jetbrains.mps.lang.core.structure.IType");
      SNode hole = null;
      SNode parent = mapping.get(myParentNode);
      if (myCurrentChild != null) {
        SNode child = mapping.get(myCurrentChild);
        parent.removeChild(child);
      }
      String role = SModelUtil_new.getGenuineLinkRole(myLinkDeclaration);
      hole = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept", auxModel, GlobalScope.getInstance());
      parent.setChild(role, hole);
      InequationSystem inequationsForHole = TypeChecker.getInstance().getInequationsForHole(hole, holeIsAType);
      auxModel.removeRoot(nodeCopyRoot);
      return inequationsForHole;
    } finally {
      auxModel.setLoading(wasLoading);
    }
  }

  protected DefaultChildNodeSetter createDefaultNodeSetter() {
    return new DefaultChildNodeSetter(myLinkDeclaration);
  }

  protected LinkDeclaration getLinkDeclaration() {
    return myLinkDeclaration;
  }

  public static boolean isNotAggregation(LinkDeclaration linkDeclaration) {
    return SModelUtil_new.getGenuineLinkMetaclass(linkDeclaration) != LinkMetaclass.aggregation;
  }

}
