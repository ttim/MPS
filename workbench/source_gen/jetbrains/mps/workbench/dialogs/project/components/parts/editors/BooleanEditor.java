package jetbrains.mps.workbench.dialogs.project.components.parts.editors;

/*Generated by MPS */

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JComponent;

public class BooleanEditor extends DefaultCellEditor {
  public BooleanEditor() {
    super(new JCheckBox(""));
  }

  public boolean isEnabledFor(final JTable table, Object value, boolean isSelected, final int row, final int column) {
    return true;
  }

  public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, final int row, final int column) {
    JComponent component = (JComponent) super.getTableCellEditorComponent(table, value, isSelected, row, column);
    component.setBackground(table.getSelectionBackground());
    component.setForeground(table.getSelectionForeground());
    component.setEnabled(this.isEnabledFor(table, value, isSelected, row, column));
    return component;
  }
}
