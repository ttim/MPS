package jetbrains.mps.workbench.dialogs.project.components.parts.descriptors;

/*Generated by MPS */

import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import javax.swing.table.TableCellEditor;
import jetbrains.mps.workbench.dialogs.project.components.parts.editors.ManagerTableCellEditor;
import javax.swing.table.TableCellRenderer;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.ListRendererAdapter;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.ManagerRenderer;

public class ManagerDescriptor extends VoidColumnDescriptor {
  private final IBindedDialog myOwner;

  public ManagerDescriptor(IBindedDialog owner, String name, String header, int width) {
    super(name, header, width);
    this.myOwner = owner;
  }

  public TableCellEditor createEditor() {
    return new ManagerTableCellEditor(this.myOwner);
  }

  public TableCellRenderer createRenderer() {
    return new ListRendererAdapter(new ManagerRenderer());
  }
}
