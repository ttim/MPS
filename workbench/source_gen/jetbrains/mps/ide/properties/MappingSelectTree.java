package jetbrains.mps.ide.properties;

/*Generated by MPS */

import javax.swing.JTree;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Component;
import java.awt.Color;
import javax.swing.tree.DefaultMutableTreeNode;
import jetbrains.mps.smodel.ModelAccess;
import javax.swing.AbstractCellEditor;
import javax.swing.tree.TreeCellEditor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodePointer;

public class MappingSelectTree extends JTree {
  public MappingSelectTree(boolean isLeft) {
    super();
    this.setCellRenderer(new MappingSelectTree.CheckBoxNodeRenderer());
    this.setCellEditor(new MappingSelectTree.CheckBoxNodeEditor());
    this.setEditable(true);
    this.setRootVisible(!(isLeft));
    if (isLeft) {
      this.setShowsRootHandles(true);
    }
  }

  private class CheckBoxNodeRenderer implements TreeCellRenderer {
    private JCheckBox myRenderer = new JCheckBox();

    public CheckBoxNodeRenderer() {
      Font font = UIManager.getFont("Tree.font");
      if (font != null) {
        myRenderer.setFont(font);
      }
      Boolean iconBorder = (Boolean) UIManager.get("Tree.drawsFocusBorderAroundIcon");
      myRenderer.setFocusPainted((iconBorder != null) && iconBorder);
    }

    public JCheckBox getRenderer() {
      return myRenderer;
    }

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
      Color selectionForeground = UIManager.getColor("Tree.selectionForeground");
      Color selectionBackground = UIManager.getColor("Tree.selectionBackground");
      Color textForeground = UIManager.getColor("Tree.textForeground");
      Color textBackground = UIManager.getColor("Tree.textBackground");
      myRenderer.setEnabled(tree.isEnabled());
      if (selected) {
        myRenderer.setForeground(selectionForeground);
        myRenderer.setBackground(selectionBackground);
      } else {
        myRenderer.setForeground(textForeground);
        myRenderer.setBackground(textBackground);
      }
      final DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
      final String text = tree.convertValueToText(value, selected, expanded, leaf, row, hasFocus);
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          if (node.getUserObject() instanceof MappingSelectTree.NodeData) {
            MappingSelectTree.NodeData data = (MappingSelectTree.NodeData) node.getUserObject();
            myRenderer.setText(data.getText());
            myRenderer.setSelected(data.isSelected());
          } else {
            myRenderer.setText(text);
            myRenderer.setSelected(false);
          }
        }
      });
      return myRenderer;
    }
  }

  private class CheckBoxNodeEditor extends AbstractCellEditor implements TreeCellEditor {
    private MappingSelectTree.CheckBoxNodeRenderer myRenderer = new MappingSelectTree.CheckBoxNodeRenderer();
    private MappingSelectTree.NodeData myObject;

    public CheckBoxNodeEditor() {
    }

    public Object getCellEditorValue() {
      JCheckBox checkbox = myRenderer.getRenderer();
      MappingSelectTree.NodeData data;
      if (myObject instanceof MappingSelectTree.RootNodeData) {
        data = new MappingSelectTree.RootNodeData(myObject.getText());
      } else
      if (myObject instanceof MappingSelectTree.GenRefNodeData) {
        data = new MappingSelectTree.GenRefNodeData(((MappingSelectTree.GenRefNodeData) myObject).getObject());
      } else
      if (myObject instanceof MappingSelectTree.ModelRefNodeData) {
        data = new MappingSelectTree.ModelRefNodeData(((MappingSelectTree.ModelRefNodeData) myObject).getObject());
      } else
      if (myObject instanceof MappingSelectTree.NodeRefNodeData) {
        data = new MappingSelectTree.NodeRefNodeData(((MappingSelectTree.NodeRefNodeData) myObject).getObject());
      } else {
        throw new RuntimeException("Wrong type of parameter: " + myObject.getClass().getName());
      }
      data.setSelected(checkbox.isSelected());
      return data;
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row) {
      Component editor = myRenderer.getTreeCellRendererComponent(tree, value, true, expanded, leaf, row, true);
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
      myObject = (MappingSelectTree.NodeData) node.getUserObject();
      ItemListener itemListener = new ItemListener() {
        public void itemStateChanged(ItemEvent itemEvent) {
          if (CheckBoxNodeEditor.this.stopCellEditing()) {
            CheckBoxNodeEditor.this.fireEditingStopped();
          }
        }
      };
      if (editor instanceof JCheckBox) {
        ((JCheckBox) editor).addItemListener(itemListener);
      }
      return editor;
    }
  }

  public static class RootNodeData extends MappingSelectTree.NodeData {
    private String myText;

    public RootNodeData(String text) {
      super(null);
      myText = text;
    }

    public String getText() {
      return myText;
    }
  }

  public static class GenRefNodeData extends MappingSelectTree.NodeData {
    public GenRefNodeData(ModuleReference ref) {
      super(ref);
    }

    public ModuleReference getObject() {
      return (ModuleReference) super.getObject();
    }

    public String getText() {
      Generator generator = (Generator) MPSModuleRepository.getInstance().getModule(this.getObject());
      if (generator == null) {
        return "unknown generator";
      }
      return generator.getAlias();
    }
  }

  public static class ModelRefNodeData extends MappingSelectTree.NodeData {
    public ModelRefNodeData(SModelReference reference) {
      super(reference);
    }

    public SModelReference getObject() {
      return (SModelReference) super.getObject();
    }

    public String getText() {
      return this.getObject().getShortName();
    }
  }

  public static class NodeRefNodeData extends MappingSelectTree.NodeData {
    public NodeRefNodeData(SNodePointer ref) {
      super(ref);
    }

    public SNodePointer getObject() {
      return (SNodePointer) super.getObject();
    }

    public String getText() {
      return this.getObject().getNode().getName();
    }
  }

  public static abstract class NodeData {
    private boolean mySelected;
    private Object myObject;
    private boolean myChecksUnder;

    public NodeData(Object object) {
      myObject = object;
      myChecksUnder = false;
    }

    public Object getObject() {
      return myObject;
    }

    public boolean isChecksUnder() {
      return myChecksUnder;
    }

    public void setChecksUnder(boolean checksUnder) {
      myChecksUnder = checksUnder;
    }

    public boolean isSelected() {
      return mySelected;
    }

    public void setSelected(boolean newValue) {
      mySelected = newValue;
    }

    public abstract String getText();
  }
}
