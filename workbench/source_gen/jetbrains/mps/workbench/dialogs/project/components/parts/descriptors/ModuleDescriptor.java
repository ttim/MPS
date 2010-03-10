package jetbrains.mps.workbench.dialogs.project.components.parts.descriptors;

/*Generated by MPS */

import javax.swing.table.TableCellRenderer;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.ListRendererAdapter;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.ModuleRenderer;

public class ModuleDescriptor extends VoidColumnDescriptor {
  public ModuleDescriptor(String name, String header, int width) {
    super(name, header, width);
  }

  public TableCellRenderer createRenderer() {
    return new ListRendererAdapter(new ModuleRenderer(null, null));
  }
}
