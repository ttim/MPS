package jetbrains.mps.ide.projectPane;

import jetbrains.mps.ide.action.ActionContext;
import jetbrains.mps.ide.action.ActionManager;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.project.Solution;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.util.NameUtil;

import javax.swing.Icon;
import javax.swing.JPopupMenu;

class ProjectSolutionTreeNode extends ProjectModuleTreeNode {
  private Solution mySolution;
  private boolean myShortNameOnly;

  public ProjectSolutionTreeNode(Solution solution, MPSProject project) {
    this(solution, project, false);
  }

  public ProjectSolutionTreeNode(Solution solution, MPSProject project, boolean shortNameOnly) {
    super(new ModuleContext(solution, project));
    myShortNameOnly = shortNameOnly;
    mySolution = solution;
    populate();

    updatePresentation();
  }

  protected void updatePresentation() {
    super.updatePresentation();
    setIcon(Icons.SOLUTION_ICON);

    IFile descriptorFile = mySolution.getDescriptorFile();
    assert descriptorFile != null;

    setNodeIdentifier(descriptorFile.getAbsolutePath());
  }

  public IModule getModule() {
    return mySolution;
  }

  public Solution getSolution() {
    return mySolution;
  }

  public JPopupMenu getQuickCreatePopupMenu() {
    JPopupMenu result = new JPopupMenu();
    Solution solution = getSolution();
    ActionContext context = new ActionContext(getOperationContext());
    context.put(Solution.class, solution);
    ActionManager.instance().getGroup(ProjectPane.SOLUTION_NEW).add(result, context);
    return result;
  }

  public JPopupMenu getPopupMenu() {
    JPopupMenu result = new JPopupMenu();
    Solution solution = getSolution();
    ActionContext context = new ActionContext(getOperationContext());
    context.put(Solution.class, solution);
    ActionManager.instance().getGroup(ProjectPane.PROJECT_PANE_PROJECT_SOLUTION_ACTIONS).add(result, context);
    return result;
  }

  protected String getModulePresentation() {
    String name = mySolution.getSolutionDescriptor().getName();

    if (myShortNameOnly) {
      name = NameUtil.shortNameFromLongName(name);
    }

    if(name != null) {
      return name;
    }
    return "solution";
  }
 
  private void populate() {
    SModelsSubtree.create(this, getOperationContext());
  }
}
