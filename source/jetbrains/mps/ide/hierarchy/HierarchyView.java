package jetbrains.mps.ide.hierarchy;

import jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.icons.Icons;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.ide.*;
import jetbrains.mps.ide.navigation.EditorNavigationCommand;
import jetbrains.mps.ide.navigation.NavigationActionProcessor;
import jetbrains.mps.ide.toolsPane.DefaultTool;
import jetbrains.mps.ide.ui.MPSTree;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.ide.ui.TreeTextUtil;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.smodel.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 15.08.2005
 * Time: 19:26:52
 * To change this template use File | Settings | File Templates.
 */
public class HierarchyView extends DefaultTool {

  private static Logger LOG = Logger.getLogger(HierarchyView.class);


  private ConceptHierarchyTree myHierarchyTree = new ConceptHierarchyTree();
  private ConceptHierarchyTreeNode myTreeNode;
  private JPanel myComponent = new JPanel(new BorderLayout());
  private IOperationContext myContext;
  private IDEProjectFrame myIde;



  public HierarchyView(IDEProjectFrame ide) {
    myIde = ide;
    myHierarchyTree.setRootVisible(true);
    myComponent.add(new JScrollPane(myHierarchyTree), BorderLayout.CENTER);
    showConceptInHierarchy(null, null);
  }



  public void showConceptInHierarchy(ConceptDeclaration node, IOperationContext context) {
    myHierarchyTree.setOperationContext(context);
    myContext = context;
    myHierarchyTree.myConceptDeclaration = node;
    myHierarchyTree.rebuildTree();
    if (myTreeNode != null) myHierarchyTree.selectNode(myTreeNode);
  }

  public void activate() {
    myIde.showHierarchyView();
  }


  private JPopupMenu showHierarchyForFoundConceptPopupMenu() {
    JPopupMenu result = new JPopupMenu();
    result.add(new AbstractActionWithEmptyIcon("Show Hierarchy For Concept") {
      public void actionPerformed(ActionEvent e) {
        java.util.List<SNode> nodes = new ArrayList<SNode>();
        for (SModelDescriptor modelDescriptor : myContext.getScope().getModelDescriptors()) {
          if (modelDescriptor.getStereotype().equals(SModelStereotype.JAVA_STUB)) continue;
          for (SNode node : modelDescriptor.getSModel().getRoots()) {
            if (node instanceof ConceptDeclaration) nodes.add(node);
          }
        }

        new GoToNodeWindow(myIde, nodes.toArray(new SNode[0])) {
          protected void doChoose(final SNode node) {
            final IOperationContext operationContext = ModuleContext.create(node, myIde);
            showConceptInHierarchy((ConceptDeclaration) node, operationContext);
          }
        };
      }
    }).setBorder(null);
    return result;
  }

  private class ConceptHierarchyTree extends MPSTree {

    private ConceptDeclaration myConceptDeclaration;
    private IOperationContext myOperationContext;
    private FindUsagesManager myUsagesManager;

    public void setOperationContext(IOperationContext operationContext) {
      if (operationContext != null) {
        myOperationContext = operationContext;
        myUsagesManager = operationContext.getComponent(FindUsagesManager.class);
      }
    }

    protected MPSTreeNode rebuildParentHierarchy() {
      ArrayList<ConceptDeclaration> parentHierarchy = new ArrayList<ConceptDeclaration>();
      ConceptDeclaration parentDeclaration = myConceptDeclaration;
      while (parentDeclaration != null ) {
        parentHierarchy.add(parentDeclaration);
        parentDeclaration = parentDeclaration.getExtends();
      }

      ConceptHierarchyTreeNode parentTreeNode = null;
      ConceptHierarchyTreeNode hierarchyTreeNode = null;
      ConceptHierarchyTreeNode rootNode = null;
      for (int i = parentHierarchy.size()-1 ; i >= 0; i--) {
        hierarchyTreeNode = i>0?( new ConceptHierarchyTreeNode(parentHierarchy.get(i), myOperationContext)) : new ChildConceptHierarchyTreeNode(parentHierarchy.get(i), myOperationContext);
        if (i == parentHierarchy.size()-1) rootNode = hierarchyTreeNode;
        if (parentTreeNode != null) {
          parentTreeNode.add(hierarchyTreeNode);
          //myUsagesManager.addDescendant(parentHierarchy.get(i+1), parentHierarchy.get(i));
        }
        parentTreeNode = hierarchyTreeNode;
      }
      myTreeNode = hierarchyTreeNode;
      assert myTreeNode != null;
      TextTreeNode textRootNode = new RootTextTreeNode("<html>Hierarchy for concept <font color=\"#400090\"><b>" + TreeTextUtil.toHtml(((ConceptDeclaration) myTreeNode.getUserObject()).getName()) + "</b></font>");
      textRootNode.add(rootNode);
      return textRootNode;
    }

    private void rebuildChildrenHierarchy_internal(ConceptHierarchyTreeNode hierarchyTreeNode) {
      Set<ConceptDeclaration> descendants = myUsagesManager.findDescendants((ConceptDeclaration) hierarchyTreeNode.getUserObject(), myOperationContext.getScope());
      for (ConceptDeclaration descendant : descendants) {
        ConceptHierarchyTreeNode childHierarchyTreeNode = new ConceptHierarchyTreeNode(descendant, myOperationContext);
        hierarchyTreeNode.add(childHierarchyTreeNode);
        rebuildChildrenHierarchy_internal(childHierarchyTreeNode);
      }
    }

    protected void rebuildChildrenHierarchy() {
      rebuildChildrenHierarchy_internal(myTreeNode);
    }


    protected MPSTreeNode rebuild() {

      if (myConceptDeclaration == null) return new RootTextTreeNode("(no concept)");

      //rebuildChildrenHierarchy();
      return rebuildParentHierarchy();
    }


    public void rebuildTree() {
       DefaultTreeModel model = new DefaultTreeModel(rebuild());
       setModel(model);
    }
  }

  private class RootTextTreeNode extends TextTreeNode {

    public RootTextTreeNode(String s) {
      super(s);
    }

    public Icon getIcon(boolean expanded) {
      return jetbrains.mps.ide.projectPane.Icons.HIERARCHY_ICON;
    }

    public JPopupMenu getPopupMenu() {
      return showHierarchyForFoundConceptPopupMenu();
    }
  }

  private class ConceptHierarchyTreeNode extends MPSTreeNode {

    private SNodeProxy myNodeProxy;

    public ConceptHierarchyTreeNode(ConceptDeclaration declaration, IOperationContext operationContext) {
      super(operationContext);
      LOG.assertLog(declaration != null);
      myNodeProxy = new SNodeProxy(declaration);
      setUserObject(declaration);
    }

    public int getToggleClickCount() {
      return -1;
    }

    public ConceptDeclaration getConceptDeclaration() {
      return (ConceptDeclaration) myNodeProxy.getNode();
    }

    public String getNodeIdentifier() {
      if (getConceptDeclaration() == null) return "null";
      Language language = SModelUtil.getDeclaringLanguage(getConceptDeclaration(), getOperationContext().getScope());
      String namespace;
      if (language == null) namespace = " ? "; else namespace = language.getModuleUID();
      return getConceptDeclaration().getName() + "  (" + namespace + ")";
    }

    public JPopupMenu getPopupMenu() {
      JPopupMenu result = new JPopupMenu();
      result.add(new AbstractActionWithEmptyIcon("Show Hierarchy For This Concept") {
        public void actionPerformed(ActionEvent e) {
          final SNode node = myNodeProxy.getNode();
          showConceptInHierarchy((ConceptDeclaration) node, getOperationContext());
        }
      }).setBorder(null);
      return result;
    }

    public void doubleClick() {
      final SNode node = myNodeProxy.getNode();

      final EditorsPane editorsPane = myIde.getEditorsPane();
      final IEditor currentEditor = editorsPane.getCurrentEditor();

      NavigationActionProcessor.executeNavigationAction(new EditorNavigationCommand(node, currentEditor, editorsPane), getOperationContext());

    }

    public Icon getIcon(boolean expanded) {
      return Icons.CONCEPT_DECLARATION_ICON;
    }

  }


  private class ChildConceptHierarchyTreeNode extends ConceptHierarchyTreeNode {

    private boolean myInitialized = false;

    public boolean isInitialized() {
      return myInitialized;
    }

    public void init() {
      List<ConceptDeclaration> descendants = new ArrayList<ConceptDeclaration>(HierarchyView.this.myHierarchyTree.myUsagesManager.findDescendants((ConceptDeclaration) this.getUserObject(), myContext.getScope()));
      Collections.sort(descendants, new Comparator<ConceptDeclaration>() {
        public int compare(ConceptDeclaration o1, ConceptDeclaration o2) {                    
          return ("" + o1.getName()).compareTo(o2.getName());
        }
      });
      
      for (ConceptDeclaration descendant : descendants) {
        ChildConceptHierarchyTreeNode childHierarchyTreeNode = new ChildConceptHierarchyTreeNode(descendant, getOperationContext());
        this.add(childHierarchyTreeNode);
       // rebuildChildrenHierarchy_internal(childHierarchyTreeNode);
      }

      myInitialized = true;
    }

    public void update() {
      this.removeAllChildren();
      myInitialized = false;
    }

    public ChildConceptHierarchyTreeNode(ConceptDeclaration declaration, IOperationContext operationContext) {
      super(declaration, operationContext);
    }

    public Color getColor() {
      return new Color(0x40, 0x00, 0x90);
    }

    public String toString() {
      String name = super.toString();
      if (this == myTreeNode) {
        name = TreeTextUtil.toHtml(name);
      }
      return name;
    }


  }


  public String getName() {
    return "Hierarchy View";
  }

  public Icon getIcon() {
    return jetbrains.mps.ide.projectPane.Icons.HIERARCHY_ICON;
  }

  public JComponent getComponent() {
    return myComponent;
  }


  public int getNumber() {
    return 8;
  }
}
