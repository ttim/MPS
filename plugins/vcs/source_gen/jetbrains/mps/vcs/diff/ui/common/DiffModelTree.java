package jetbrains.mps.vcs.diff.ui.common;

/*Generated by MPS */

import com.intellij.ui.treeStructure.SimpleTree;
import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.openapi.actionSystem.DataKey;
import com.intellij.openapi.util.Ref;
import jetbrains.mps.smodel.SNodeId;
import java.util.List;
import jetbrains.mps.workbench.action.BaseAction;
import jetbrains.mps.smodel.IOperationContext;
import com.intellij.util.ui.tree.TreeUtil;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import com.intellij.ui.ColoredTreeCellRenderer;
import javax.swing.JTree;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.ActionPlaces;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.apache.commons.lang.StringUtils;
import java.util.Collections;
import jetbrains.mps.smodel.ModelAccess;
import javax.swing.tree.DefaultTreeModel;
import jetbrains.mps.smodel.SModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ActionManager;
import jetbrains.mps.ide.icons.IdeIcons;
import javax.swing.Icon;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.ide.projectPane.Icons;
import javax.swing.tree.DefaultMutableTreeNode;
import com.intellij.ui.SimpleTextAttributes;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class DiffModelTree extends SimpleTree implements DataProvider {
  public static DataKey<Ref<SNodeId>> NODE_ID_DATAKEY = DataKey.create("MPS_SNodeId");

  private List<DiffModelTree.RootTreeNode> myRootNodes;
  private Iterable<BaseAction> myActions;

  public DiffModelTree(IOperationContext operationContext) {
    rebuildNow();
    TreeUtil.expandAll(this);
    myActions = getRootActions();
    Sequence.fromIterable(myActions).visitAll(new IVisitor<BaseAction>() {
      public void visit(BaseAction a) {
        a.registerCustomShortcutSet(a.getShortcutSet(), DiffModelTree.this);
      }
    });
    setCellRenderer(new ColoredTreeCellRenderer() {
      public void customizeCellRenderer(JTree p0, Object value, boolean p2, boolean p3, boolean p4, int p5, boolean p6) {
        if (value instanceof DiffModelTree.TreeNode) {
          ((DiffModelTree.TreeNode) value).renderTreeNode(this);
        }
      }
    });
    setPopupGroup(ActionUtils.groupFromActions(Sequence.fromIterable(myActions).toGenericArray(BaseAction.class)), ActionPlaces.CHANGES_VIEW_POPUP);
    addMouseListener(new DiffModelTree.MyMouseListener());
  }

  protected DiffModelTree.TreeNode rebuild() {
    DiffModelTree.ModelTreeNode modelNode = new DiffModelTree.ModelTreeNode();
    myRootNodes = Sequence.fromIterable(getAffectedRoots()).where(new IWhereFilter<SNodeId>() {
      public boolean accept(SNodeId r) {
        return r != null;
      }
    }).select(new ISelector<SNodeId, DiffModelTree.RootTreeNode>() {
      public DiffModelTree.RootTreeNode select(SNodeId r) {
        return new DiffModelTree.RootTreeNode(r);
      }
    }).sort(new ISelector<DiffModelTree.RootTreeNode, Comparable<?>>() {
      public Comparable<?> select(DiffModelTree.RootTreeNode rtn) {
        return rtn.myVirtualPackage + "|" + rtn.myPresentation;
      }
    }, true).toListSequence();
    for (DiffModelTree.RootTreeNode rtn : ListSequence.fromList(myRootNodes)) {
      DiffModelTree.TreeNode parentNode = modelNode;
      if (StringUtils.isNotEmpty(rtn.myVirtualPackage)) {
        for (final String sub : Sequence.fromIterable(Sequence.fromArray(rtn.myVirtualPackage.split("\\.")))) {
          Iterable<DiffModelTree.TreeNode> children = Collections.list(parentNode.children());
          DiffModelTree.TreeNode child = Sequence.fromIterable(children).findFirst(new IWhereFilter<DiffModelTree.TreeNode>() {
            public boolean accept(DiffModelTree.TreeNode c) {
              return c instanceof DiffModelTree.PackageTreeNode && sub.equals(c.getText());
            }
          });
          if (child == null) {
            child = new DiffModelTree.PackageTreeNode(sub);
            parentNode.add(child);
          }
          parentNode = child;
        }
      }
      parentNode.add(rtn);
    }
    if (Sequence.fromIterable(getAffectedRoots()).any(new IWhereFilter<SNodeId>() {
      public boolean accept(SNodeId r) {
        return r == null;
      }
    })) {
      modelNode.add(new DiffModelTree.MetadataTreeNode());
    }
    return modelNode;
  }

  public void rebuildLater() {
    rebuildNow();
  }

  public void rebuildNow() {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        setModel(new DefaultTreeModel(rebuild()));
        setRootVisible(true);
        TreeUtil.expandAll(DiffModelTree.this);
      }
    });
  }

  protected abstract Iterable<SNodeId> getAffectedRoots();

  protected abstract Iterable<SModel> getModels();

  protected abstract void updateRootCustomPresentation(@NotNull DiffModelTree.RootTreeNode rootTreeNode);

  protected abstract Iterable<BaseAction> getRootActions();

  protected boolean isMultipleRootNames() {
    return false;
  }

  private DiffModelTree.RootTreeNode findRootNode(@NotNull final SNodeId nodeId) {
    return ListSequence.fromList(myRootNodes).findFirst(new IWhereFilter<DiffModelTree.RootTreeNode>() {
      public boolean accept(DiffModelTree.RootTreeNode r) {
        return nodeId.equals(r.myRootId);
      }
    });
  }

  @Nullable
  public SNodeId getNeighbourRoot(@NotNull SNodeId nodeId, boolean next) {
    int index = ListSequence.fromList(myRootNodes).indexOf(findRootNode(nodeId));
    if (index == -1) {
      return null;
    }
    index = (next ?
      index + 1 :
      index - 1
    );
    if (index == -1 || index == (int) ListSequence.fromList(myRootNodes).count()) {
      return null;
    } else {
      return ListSequence.fromList(myRootNodes).getElement(index).myRootId;
    }
  }

  public String getNameForRoot(@NotNull SNodeId nodeId) {
    return findRootNode(nodeId).myPresentation;
  }

  @Nullable
  public Object getData(@NonNls String dataId) {
    if (NODE_ID_DATAKEY.is(dataId)) {
      DiffModelTree.RootTreeNode[] selectedNodes = getSelectedNodes(DiffModelTree.RootTreeNode.class, null);
      if (selectedNodes != null && selectedNodes.length > 0) {
        return new Ref<SNodeId>(selectedNodes[0].getRootId());
      }
    }
    return null;
  }

  public void processDoubleClick() {
    if (Sequence.fromIterable(myActions).isEmpty()) {
      return;
    }
    ActionUtils.updateAndPerformAction(Sequence.fromIterable(myActions).first(), new AnActionEvent(null, DataManager.getInstance().getDataContext(DiffModelTree.this), ActionPlaces.UNKNOWN, new Presentation(), ActionManager.getInstance(), 0));
  }

  private class ModelTreeNode extends DiffModelTree.TreeNode {
    public ModelTreeNode() {
      setText("model");
      setText(Sequence.fromIterable(getModels()).first().getLongName());
      setIcon(IdeIcons.MODEL_ICON);
    }
  }

  private class PackageTreeNode extends DiffModelTree.TreeNode {
    private PackageTreeNode(String packageName) {
      setText(packageName);
    }
  }

  public class RootTreeNode extends DiffModelTree.TreeNode {
    private SNodeId myRootId;
    private String myPresentation = null;
    private String myVirtualPackage = null;

    public RootTreeNode(SNodeId rootId) {
      myRootId = rootId;
      setText("" + myRootId);
      doUpdatePresentation();
    }

    protected void doUpdatePresentation() {
      myPresentation = null;
      Icon icon = null;
      for (SModel model : Sequence.fromIterable(getModels())) {
        SNode root = model.getNodeById(myRootId);
        if (root != null && SNodeOperations.getParent(root) == null) {
          String presentation = root.getPresentation();
          if (myPresentation == null) {
            myPresentation = presentation;
          } else if (isMultipleRootNames()) {
            if (("/ " + myPresentation + " /").contains("/ " + presentation + " /")) {
            } else {
              myPresentation += " / " + presentation;
            }
          }

          if (myVirtualPackage == null) {
            myVirtualPackage = (SPropertyOperations.getString(root, "virtualPackage") == null ?
              "" :
              SPropertyOperations.getString(root, "virtualPackage")
            );
          }
          if (icon == null) {
            icon = IconManager.getIconFor(root);
          }
        }
      }
      setText(myPresentation);
      setIcon(icon);
      updateRootCustomPresentation(this);
    }

    @Nullable
    public SNodeId getRootId() {
      return myRootId;
    }
  }

  public class MetadataTreeNode extends DiffModelTree.RootTreeNode {
    public MetadataTreeNode() {
      super(null);
      setText("metadata");
      doUpdatePresentation();
    }

    @Override
    protected void doUpdatePresentation() {
      setText("Model Properties");
      setIcon(Icons.PROPERTIES_ICON);
      updateRootCustomPresentation(this);
    }
  }

  public class TreeNode extends DefaultMutableTreeNode {
    private String myText;
    private int myTextStyle = SimpleTextAttributes.STYLE_PLAIN;
    private String myAdditionalText;
    private String myTooltipText;
    private Icon myIcon;
    private Color myColor;

    public TreeNode() {
    }

    public void renderTreeNode(ColoredTreeCellRenderer coloredRenderer) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          doUpdatePresentation();
        }
      });
      coloredRenderer.append(getText(), new SimpleTextAttributes(myTextStyle, getColor()));
      if (StringUtils.isNotEmpty(myAdditionalText)) {
        coloredRenderer.append(" (" + myAdditionalText + ")", new SimpleTextAttributes(SimpleTextAttributes.STYLE_PLAIN, Color.GRAY));
      }
      coloredRenderer.setToolTipText(myTooltipText);
      coloredRenderer.setIcon(getIcon());
    }

    protected void doUpdatePresentation() {
    }

    public String getText() {
      return myText;
    }

    public void setText(String text) {
      myText = text;
    }

    public String getAdditionalText() {
      return myAdditionalText;
    }

    public void setAdditionalText(String additionalText) {
      myAdditionalText = additionalText;
    }

    public String getTooltipText() {
      return myTooltipText;
    }

    public void setTooltipText(String tooltipText) {
      myTooltipText = tooltipText;
    }

    public Icon getIcon() {
      return myIcon;
    }

    public void setIcon(Icon icon) {
      myIcon = icon;
    }

    public Color getColor() {
      return myColor;
    }

    public void setColor(Color color) {
      myColor = color;
    }

    public void setTextStyle(int textStyle) {
      myTextStyle = textStyle;
    }
  }

  private class MyMouseListener extends MouseAdapter {
    public MyMouseListener() {
    }

    @Override
    public void mousePressed(MouseEvent event) {
      if (event.getClickCount() == 2 && !(event.isPopupTrigger())) {
        processDoubleClick();
      }
    }
  }
}
