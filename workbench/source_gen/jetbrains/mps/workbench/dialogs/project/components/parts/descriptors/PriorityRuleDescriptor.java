package jetbrains.mps.workbench.dialogs.project.components.parts.descriptors;

/*Generated by MPS */

import jetbrains.mps.smodel.Generator;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import javax.swing.table.TableCellRenderer;
import jetbrains.mps.workbench.dialogs.project.components.parts.renderers.RuleOperandRenderer;
import javax.swing.table.TableCellEditor;
import jetbrains.mps.workbench.dialogs.project.components.parts.editors.RuleOperandEditor;

public class PriorityRuleDescriptor extends VoidColumnDescriptor {
  private final Generator myGenerator;
  private final List<ModuleReference> myDepGenerators;
  private final boolean myLeft;

  public PriorityRuleDescriptor(Generator generator, List<ModuleReference> depGenerators, boolean left, String name, String header, int width) {
    super(name, header, width);
    this.myGenerator = generator;
    this.myDepGenerators = depGenerators;
    this.myLeft = left;
  }

  public TableCellRenderer createRenderer() {
    return new RuleOperandRenderer();
  }

  public TableCellEditor createEditor() {
    return new RuleOperandEditor(this.myGenerator, this.myDepGenerators, this.myLeft);
  }
}
