package jetbrains.mps.nodeEditor;

/*Generated by MPS*/

import jetbrains.mps.bootstrap.structureLanguage.Cardinality;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.LinkMetaclass;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.DefaultChildNodeSetter;

import java.util.List;

public class DefaultChildSubstituteInfo extends AbstractNodeSubstituteInfo {
  private SNode myParentNode;
  private SNode myCurrentChild;
  private LinkDeclaration myLinkDeclaration;


  public DefaultChildSubstituteInfo(SNode sourceNode, LinkDeclaration linkDeclaration, EditorContext editorContext) {
    super(editorContext);
    if (SModelUtil.getGenuineLinkMetaclass(linkDeclaration) != LinkMetaclass.aggregation) {
      throw new RuntimeException("Only aggregation links are allowed here.");
    }
    Cardinality sourceCardinality = SModelUtil.getGenuineLinkSourceCardinality(linkDeclaration);
    if (!(sourceCardinality == Cardinality._1 || sourceCardinality == Cardinality._0_1)) {
      throw new RuntimeException("Only cardinalities 1 or 0..1 are allowed here.");
    }

    myParentNode = sourceNode;
    myLinkDeclaration = linkDeclaration;
    myCurrentChild = sourceNode.getChild(SModelUtil.getGenuineLinkRole(linkDeclaration));
  }

  public DefaultChildSubstituteInfo(SNode parentNode, SNode currChildNode, LinkDeclaration linkDeclaration, EditorContext editorContext) {
    super(editorContext);
    if (linkDeclaration == null) {
      throw new IllegalArgumentException("link declaration is null");
    }
    if (SModelUtil.getGenuineLinkMetaclass(linkDeclaration) != LinkMetaclass.aggregation) {
      throw new RuntimeException("Only aggregation links are allowed here.");
    }
    myParentNode = parentNode;
    myLinkDeclaration = linkDeclaration;
    myCurrentChild = currChildNode;
  }

  public List<INodeSubstituteItem> createActions() {
    List<INodeSubstituteAction> actions = ModelActions.createChildSubstituteActions(myParentNode, myCurrentChild,
            myLinkDeclaration.getTarget(),
            new DefaultChildNodeSetter(myLinkDeclaration),
            getOperationContext().getScope()
    );
    return (List<INodeSubstituteItem>) ((List) actions);
  }

}
