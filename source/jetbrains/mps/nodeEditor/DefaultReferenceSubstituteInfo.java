package jetbrains.mps.nodeEditor;

/*Generated by MPS*/


import jetbrains.mps.bootstrap.structureLanguage.Cardinality;
import jetbrains.mps.bootstrap.structureLanguage.LinkMetaclass;
import jetbrains.mps.bootstrap.structureLanguage.SemanticLinkDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.SemanticTypeDeclaration;
import jetbrains.mps.generator.JavaNameUtil;
import jetbrains.mps.semanticModel.SemanticModel;
import jetbrains.mps.semanticModel.SemanticModelUtil;
import jetbrains.mps.semanticModel.SemanticNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DefaultReferenceSubstituteInfo extends AbstractNodeSubstituteInfo {

  private SemanticNode mySourceNode;
  private SemanticLinkDeclaration myLinkDeclaration;

  public DefaultReferenceSubstituteInfo(SemanticNode sourceNode, SemanticLinkDeclaration linkDeclaration) {
    mySourceNode = sourceNode;
    myLinkDeclaration = linkDeclaration;
    if (linkDeclaration.getMetaClass() == LinkMetaclass.aggregation) {
      throw new RuntimeException("Only reference links are allowed here.");
    }
  }

  public List<INodeSubstituteItem> createActions() {
    List<INodeSubstituteItem> list = new LinkedList<INodeSubstituteItem>();

    List<SemanticNode> targetSemanticNodes = createTargetNodesList();
    for (final SemanticNode targetNode : targetSemanticNodes) {
      list.add(new AbstractNodeSubstituteItem() {
        public String getMatchingText(String pattern) {
//          if(targetNode instanceof SemanticTypeDeclaration) {
//            return EditorUtil.matchingTextForType((SemanticTypeDeclaration)targetNode);
//          }
          return targetNode.getName();
        }

        public String getDescriptionText(String pattern) {
//          if (targetNode instanceof SemanticTypeDeclaration) {
//            return EditorUtil.presentableNameForType((SemanticTypeDeclaration) targetNode);
//          }
//          return JavaNameUtil.shortName(targetNode.getClass().getName());
          return targetNode.getSemanticModel().getFQName();
        }

        public SemanticNode doSubstitute(String pattern) {
          Cardinality sourceCardinality = myLinkDeclaration.getSourceCardinality();
          if (sourceCardinality == Cardinality._1 || sourceCardinality == Cardinality._0_1) {
            mySourceNode.setReferent(myLinkDeclaration.getRole(), targetNode);
          }
          return null;
        }
      });
    }

    return list;
  }

  private List<SemanticNode> createTargetNodesList() {
    List<SemanticNode> list = new LinkedList<SemanticNode>();
    SemanticTypeDeclaration targetType = myLinkDeclaration.getTarget();

    // look through all node declared in parent
    SemanticNode parentNode = mySourceNode;
    while (parentNode != null && parentNode.getParent() != null) {
      parentNode = parentNode.getParent();
    }
    Iterator<SemanticNode> iterator = parentNode.depthFirstChildren();
    while (iterator.hasNext()) {
      SemanticNode node = iterator.next();
      if (SemanticModelUtil.isInstanceOfType(node, targetType)) {
        list.add(node);
      }
    }

//    // look through roots in current model
//    SemanticModel sourceModel = mySourceNode.getSemanticModel();
//    Iterator roots = sourceModel.roots();
//    while (roots.hasNext()) {
//      SemanticNode node = (SemanticNode) roots.next();
//      if (!list.contains(node) && SemanticModelUtil.isInstanceOfType(node, targetType)) {
//        list.add(node);
//      }
//    }
//    // look through imported models
//    Iterator importedModels = sourceModel.importedModels();
//    while (importedModels.hasNext()) {
//      SemanticModel importedModel = (SemanticModel) importedModels.next();
//      Iterator importedRoots = importedModel.roots();
//      while (importedRoots.hasNext()) {
//        SemanticNode importedRoot = (SemanticNode) importedRoots.next();
//        if (!list.contains(importedRoot) && SemanticModelUtil.isInstanceOfType(importedRoot, targetType)) {
//          list.add(importedRoot);
//        }
//      }
//    }

    list.addAll(SemanticModelUtil.allInstancesOfType(targetType, mySourceNode.getSemanticModel()));
    return list;
  }
}
