package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.navigation.NavigationSupport;

public class NodeNavigationItem {
  private SNode myNode;
  private IOperationContext myContext;

  public NodeNavigationItem(SNode node, IOperationContext context, Project project) {
    myNode = node;
    myContext = context;
  }

  public SNode getNode() {
    return myNode;
  }

  public void navigate() {
    NavigationSupport.getInstance().openNode(myContext, myNode, true, true);
  }
}
