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

public class DefaultChildSubstituteInfo extends AbstractNodeSubstituteInfo {

  private SemanticNode mySourceNode;
  private LinkDeclaration myLinkDeclaration;

  public DefaultChildSubstituteInfo(SemanticNode sourceNode, LinkDeclaration linkDeclaration) {
    mySourceNode = sourceNode;
    myLinkDeclaration = linkDeclaration;
    if (linkDeclaration.getMetaClass() != LinkMetaclass.aggregation) {
      throw new RuntimeException("Only aggregation links are allowed here.");
    }
    Cardinality sourceCardinality = myLinkDeclaration.getSourceCardinality();
    if (!(sourceCardinality == Cardinality._1 || sourceCardinality == Cardinality._0_1)) {
      throw new RuntimeException("Only cardinalities 1 or 0..1 are allowed here.");
    }
  }

  public List<INodeSubstituteItem> createActions() {
    List<INodeSubstituteItem> list = new LinkedList<INodeSubstituteItem>();

    List<ConceptDeclaration> childTypes = createChildTypesList();
    for (final ConceptDeclaration childType : childTypes) {
      list.add(new AbstractNodeSubstituteItem() {
        public String getMatchingText(String pattern) {
          return childType.getName();
        }

        public String getDescriptionText(String pattern) {
          return childType.getModel().getFQName();
        }

        public SemanticNode doSubstitute(String pattern) {
          SemanticNode childNode = SModelUtil.instantiateConceptDeclaration(childType, mySourceNode.getModel());
          String role = myLinkDeclaration.getRole();
          SemanticNode oldChild = mySourceNode.getChild(role);
          if (oldChild != null) {
            oldChild.delete();
          }
          mySourceNode.setChild(role, childNode);
          return childNode;
        }
      });
    }

    return list;
  }

  private List<ConceptDeclaration> createChildTypesList() {
    final ConceptDeclaration targetType = myLinkDeclaration.getTarget();
    List<ConceptDeclaration> list = SModelUtil.allConceptDeclarations(mySourceNode.getModel(), new Condition<ConceptDeclaration>() {
      public boolean met(ConceptDeclaration node) {
        return SModelUtil.isAssignableType(targetType, node);
      }
    });
    return list;
  }
}
