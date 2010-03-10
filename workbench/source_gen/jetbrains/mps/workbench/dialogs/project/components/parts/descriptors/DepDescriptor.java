package jetbrains.mps.workbench.dialogs.project.components.parts.descriptors;

/*Generated by MPS */

import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import javax.swing.table.TableCellRenderer;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.ModuleRenderer;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.ListRendererAdapter;

public class DepDescriptor extends VoidColumnDescriptor {
  private final IBindedDialog myOwner;

  public DepDescriptor(IBindedDialog owner, String name, String header, int width) {
    super(name, header, width);
    this.myOwner = owner;
  }

  public TableCellRenderer createRenderer() {
    ModuleRenderer renderer = new ModuleRenderer(this.myOwner.getModuleScope(), this.myOwner.getProjectScope());
    return new ListRendererAdapter(renderer);
  }
}
