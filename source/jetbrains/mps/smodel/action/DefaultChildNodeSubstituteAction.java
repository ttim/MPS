package jetbrains.mps.smodel.action;

import jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration;
import jetbrains.mps.nodeEditor.AbstractNodeSubstituteItem;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.presentation.NodePresentationUtil;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Mar 29, 2005
 * Time: 2:06:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class DefaultChildNodeSubstituteAction extends AbstractNodeSubstituteItem implements INodeSubstituteAction {
  private SNode myParentNode;
  private SNode myCurrentChild;
  private IScope myScope;
  private IChildNodeSetter mySetter;

  public DefaultChildNodeSubstituteAction(SNode parameterNode, SNode parentNode, SNode currentChild, IChildNodeSetter setter, IScope scope) {
    super(parameterNode);
    myParentNode = parentNode;
    myCurrentChild = currentChild;
    myScope = scope;
    mySetter = setter;
  }

  public SNode getSourceNode() {
    return myParentNode;
  }

  public IScope getScope() {
    return myScope;
  }

  public String getMatchingText(String pattern) {
    return NodePresentationUtil.matchingText(getParameterNode(), myParentNode, NodePresentationUtil.CHILD_PRESENTATION, getScope());
  }

  public String getDescriptionText(String pattern) {
    return NodePresentationUtil.descriptionText(getParameterNode(), myParentNode, getScope());
  }

  public SNode doSubstitute(String pattern) {
    SNode newChild = createChildNode(getParameterNode(), myParentNode.getModel(), pattern);
    mySetter.execute(myParentNode, myCurrentChild, newChild, getScope());
    return newChild;
  }

  public SNode createChildNode(SNode parameterNode, SModel model, String pattern) {
    if (parameterNode instanceof ConceptDeclaration) {
      return NodeFactoryManager.initializeNode((ConceptDeclaration) parameterNode, model);
    }
    throw new RuntimeException("Couldn't create child node. Parameter node: " + parameterNode.getDebugText());
  }
}
