package jetbrains.mps.ide.projectPane;

import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.action.ActionContext;
import jetbrains.mps.ide.action.ActionManager;
import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.*;

import javax.swing.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Aug 25, 2005
 * Time: 5:16:43 PM
 * To change this template use File | Settings | File Templates.
 */
class GeneratorTreeNode extends TextTreeNode {
  private Generator myGenerator;
  private IdeMain myIDE;
  private MPSProject myProject;
  private IOperationContext myOperationContext;

  public GeneratorTreeNode(String text, Generator generator, IdeMain ide, MPSProject project, IOperationContext operationContext) {
    super(text);
    myGenerator = generator;
    myIDE = ide;
    myProject = project;
    myOperationContext = new GeneratorTreeNodeOperationContext(generator, operationContext);
    populate();
  }

  public Icon getIcon(boolean expanded) {
    return Icons.GENERATORS_ICON;
  }

  protected JPopupMenu getPopupMenu() {
    JPopupMenu result = new JPopupMenu();
    ActionContext context = new ActionContext(myIDE, myOperationContext);
    context.put(Generator.class, myGenerator);
    ActionManager.instance().getGroup(ProjectPane.PROJECT_PANE_GENERATOR_ACTIONS).add(result, context);
    return result;
  }


  private void populate() {
    List<GeneratorModelsTreeNode> modelTreeNodes = GeneratorModelsTreeNode.createModelsTreeNodes(myIDE, myOperationContext);
    for (GeneratorModelsTreeNode modelsTreeNode : modelTreeNodes) {
      this.add(modelsTreeNode);
    }
    
    LanguagesTreeNode languagesNode = new LanguagesTreeNode(myIDE, myProject, myOperationContext);
    this.add(languagesNode);
  }

  private static class GeneratorTreeNodeOperationContext extends DelegatingOperationContext {
    public GeneratorTreeNodeOperationContext(Generator generator, IOperationContext upperOperationContext) {
      super(upperOperationContext, generator, generator);
    }
  }
}
