package jetbrains.mps.nodeEditor;

/*Generated by MPS*/


import jetbrains.mps.bootstrap.structureLanguage.Cardinality;
import jetbrains.mps.bootstrap.structureLanguage.LinkMetaclass;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration;
import jetbrains.mps.semanticModel.SModelUtil;
import jetbrains.mps.semanticModel.SemanticNode;
import jetbrains.mps.util.Condition;

import java.util.LinkedList;
import java.util.List;

public class DefaultReferenceSubstituteInfo extends AbstractNodeSubstituteInfo {

  private SemanticNode mySourceNode;
  private LinkDeclaration myLinkDeclaration;
  private LinkDeclaration myGenuineLinkDeclaration;

  public DefaultReferenceSubstituteInfo(SemanticNode sourceNode, LinkDeclaration linkDeclaration) {
    mySourceNode = sourceNode;
    myLinkDeclaration = linkDeclaration;
    myGenuineLinkDeclaration = SModelUtil.getGenuineLinkDeclaration(linkDeclaration);
    if (linkDeclaration.getMetaClass() == LinkMetaclass.aggregation) {
      throw new RuntimeException("Only reference links are allowed here.");
    }
    Cardinality sourceCardinality = myGenuineLinkDeclaration.getSourceCardinality();
    if (!(sourceCardinality == Cardinality._1 || sourceCardinality == Cardinality._0_1)) {
      throw new RuntimeException("Only cardinalities 1 or 0..1 are allowed here.");
    }
  }

  public List<INodeSubstituteItem> createActions() {
    List<INodeSubstituteItem> list = new LinkedList<INodeSubstituteItem>();

    List<SemanticNode> targetSemanticNodes = createTargetNodesList();
    for (final SemanticNode targetNode : targetSemanticNodes) {
      list.add(new AbstractNodeSubstituteItem() {
        public String getMatchingText(String pattern) {
          return targetNode.getName();
        }

        public String getDescriptionText(String pattern) {
          return targetNode.getModel().getFQName();
        }

        public SemanticNode doSubstitute(String pattern) {
          mySourceNode.setReferent(myGenuineLinkDeclaration.getRole(), targetNode);
          return null;
        }
      });
    }

    return list;
  }

  private List<SemanticNode> createTargetNodesList() {
    final ConceptDeclaration targetType = myLinkDeclaration.getTarget();
    List<SemanticNode> list = SModelUtil.allNodes(mySourceNode.getModel(), true, new Condition<SemanticNode>() {
      public boolean met(SemanticNode node) {
        return SModelUtil.isInstanceOfType(node, targetType);
      }
    });
    return list;
  }
}
