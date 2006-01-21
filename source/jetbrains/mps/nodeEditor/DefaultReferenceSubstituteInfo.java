package jetbrains.mps.nodeEditor;

/*Generated by MPS*/

import jetbrains.mps.bootstrap.structureLanguage.Cardinality;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.LinkMetaclass;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.ModelActions;

import java.util.*;

public class DefaultReferenceSubstituteInfo extends AbstractNodeSubstituteInfo {
  private SNode mySourceNode;
  private LinkDeclaration myLinkDeclaration;
  private SNode myCurrentTargetNode;

  public DefaultReferenceSubstituteInfo(SNode sourceNode, LinkDeclaration linkDeclaration, EditorContext editorContext) {
    super(editorContext);
    LinkDeclaration genuineLink = SModelUtil.getGenuineLinkDeclaration(linkDeclaration);
    if (genuineLink.getMetaClass() != LinkMetaclass.reference) {
      throw new RuntimeException("Only reference links are allowed here.");
    }
    Cardinality sourceCardinality = genuineLink.getSourceCardinality();
    if (!(sourceCardinality == Cardinality._1 || sourceCardinality == Cardinality._0_1)) {
      throw new RuntimeException("Only cardinalities 1 or 0..1 are allowed here.");
    }

    mySourceNode = sourceNode;
    myLinkDeclaration = linkDeclaration;
    myCurrentTargetNode = sourceNode.getChild(SModelUtil.getGenuineLinkRole(linkDeclaration));
  }

  public List<INodeSubstituteItem> createActions() {
    List<INodeSubstituteAction> actions = ModelActions.createReferentNodeSubstituteActions(mySourceNode, myCurrentTargetNode, myLinkDeclaration, getOperationContext().getScope());
    return (List) actions;
  }
}
