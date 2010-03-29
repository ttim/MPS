package jetbrains.mps.plugins.pluginparts.tabbedEditor;

/*Generated by MPS */

import jetbrains.mps.ide.tabbedEditor.tabs.BaseMultitabbedTab;
import jetbrains.mps.smodel.SModelRepositoryListener;
import jetbrains.mps.ide.tabbedEditor.TabbedEditor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.util.annotation.Hack;
import java.util.List;
import jetbrains.mps.util.Pair;
import jetbrains.mps.smodel.IOperationContext;
import java.util.ArrayList;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.IModule;
import jetbrains.mps.project.ModuleContext;
import javax.swing.JOptionPane;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.SModelRepository;

public abstract class BaseMultiTab extends BaseMultitabbedTab {
  public SModelRepositoryListener myModelRepositoryListener = null;

  protected BaseMultiTab(TabbedEditor tabbedEditor, SNode baseNode, Class<? extends BaseAdapter> adapterClass) {
    super(tabbedEditor, baseNode, adapterClass);
  }

  @Hack
  protected List<Pair<SNode, IOperationContext>> tryToLoadNodes() {
    List<Pair<SNode, IOperationContext>> res = new ArrayList<Pair<SNode, IOperationContext>>();
    SNode baseNode = this.getBaseNode();
    if (baseNode == null) {
      return res;
    }
    for (SNode node : this.getNodes(baseNode)) {
      if (node == null) {
        continue;
      }
      MPSProject project = this.getOperationContext().getMPSProject();
      IModule module = node.getModel().getModelDescriptor().getModule();
      IOperationContext context = new ModuleContext(module, project);
      res.add(new Pair<SNode, IOperationContext>(node, context));
    }
    return res;
  }

  protected Pair<SNode, IOperationContext> createLoadableNode(boolean ask, SNode concept) {
    SNode node = this.createNode(this.getBaseNode(), ask, concept);
    if (node == null) {
      JOptionPane.showMessageDialog(this.getComponent(), "Node creation finished with errors.", "Error", JOptionPane.ERROR_MESSAGE);
      return null;
    }
    return new Pair<SNode, IOperationContext>(node, this.getOperationContext());
  }

  public boolean askCreate() {
    return this.askCreate(this.getBaseNode());
  }

  public boolean askCreate(SNode baseNode) {
    String entity = NameUtil.singularize(this.getTitle());
    return TabHelper.ask("Do you want to create a new " + NameUtil.decapitalize(entity) + "?", "Create New " + entity);
  }

  public void dispose() {
    if (this.myModelRepositoryListener != null) {
      SModelRepository.getInstance().removeModelRepositoryListener(this.myModelRepositoryListener);
    }
    super.dispose();
  }

  public abstract String getTitle();

  public abstract String getNullText();

  public abstract List<SNode> getNodes(SNode node);

  public abstract boolean canCreate();

  public abstract SNode createNode(SNode node, boolean ask, SNode concept);
}
