package jetbrains.mps.workbench.dialogs.project.components.parts.boundpanels;

/*Generated by MPS */

import javax.swing.JTable;
import java.util.List;
import jetbrains.mps.workbench.dialogs.project.components.parts.descriptors.ColumnDescriptor;
import java.util.ArrayList;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.workbench.dialogs.project.components.parts.actions.BaseValidatedAction;
import javax.swing.JComponent;
import jetbrains.mps.workbench.dialogs.project.components.parts.diffrowtable.DiffRowTable;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.JTextField;
import javax.swing.DefaultCellEditor;
import java.util.EventObject;
import javax.swing.ListSelectionModel;
import jetbrains.mps.workbench.dialogs.project.components.parts.actions.TableRemoveAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Arrays;
import jetbrains.mps.workbench.dialogs.project.components.parts.actions.TableAddAction;

public class BoundTablePanel<T> extends ValidateableBoundPanel<T> {
  private JTable myTable;
  private boolean myDiffRow;
  private List<ColumnDescriptor> myColumns = new ArrayList<ColumnDescriptor>();
  private Boolean myMultipleChooser = null;

  public BoundTablePanel(IBindedDialog owner, String caption, @NotNull List<T> ts) {
    super(owner, caption, ts);
  }

  public void addColumn(ColumnDescriptor d) {
    this.myColumns.add(d);
  }

  public void setDiffRow(boolean isDiffRow) {
    this.myDiffRow = isDiffRow;
  }

  public void setChooser(Computable<T> chooser) {
    this.myMultipleChooser = false;
    super.setChooser(chooser);
  }

  public void setMultipleChooser(Computable<List<T>> chooser) {
    this.myMultipleChooser = true;
    super.setMultipleChooser(chooser);
  }

  protected BaseValidatedAction createAddAction(final Computable<List<T>> chooser) {
    if (this.myMultipleChooser == null) {
      return null;
    }
    return new BoundTablePanel.MyTableAddAction(chooser);
  }

  protected BaseValidatedAction createRemoveAction() {
    if (this.myMultipleChooser == null) {
      return null;
    }
    return new BoundTablePanel.MyTableRemoveAction(this.myTable);
  }

  protected JComponent initUIComponentAndBinding() {
    this.myTable = (this.myDiffRow ?
      new DiffRowTable() :
      new JTable()
    );
    JTableBinding<T, List<T>, JTable> tableBinding = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE, this.myList, this.myTable);
    for (final ColumnDescriptor d : this.myColumns) {
      tableBinding.addColumnBinding((Property<T, ?>) BeanProperty.create(d.getName()));
    }
    tableBinding.bind();
    this.myOwner.addBinding(tableBinding);
    int i = 0;
    for (final ColumnDescriptor d : this.myColumns) {
      TableColumn column = this.myTable.getColumnModel().getColumn(i);
      column.setHeaderValue(d.getHeader());
      if (d.getWidth() > 0) {
        column.setWidth(d.getWidth());
        column.setMaxWidth(d.getWidth());
      }
      column.setResizable(true);
      TableCellRenderer renderer = d.createRenderer();
      if (renderer != null) {
        column.setCellRenderer(renderer);
      }
      TableCellEditor editor = d.createEditor();
      if (editor != null) {
        column.setCellEditor(editor);
      } else {
        JTextField text = new JTextField();
        text.setOpaque(true);
        text.setEditable(false);
        column.setCellEditor(new DefaultCellEditor(text) {
          public boolean isCellEditable(EventObject anEvent) {
            return false;
          }
        });
      }
      i++;
    }
    this.myTable.setSelectionMode((this.myMultipleChooser ?
      ListSelectionModel.MULTIPLE_INTERVAL_SELECTION :
      ListSelectionModel.SINGLE_INTERVAL_SELECTION
    ));
    return this.myTable;
  }

  private class MyTableRemoveAction extends TableRemoveAction {
    private final JTable myTable;

    public MyTableRemoveAction(JTable table) {
      super(table);
      this.myTable = table;
    }

    protected void doRemove(AnActionEvent e) {
      int[] indices = this.myTable.getSelectedRows();
      Arrays.sort(indices);
      for (int i = indices.length - 1; i >= 0; i--) {
        BoundTablePanel.this.myList.remove(indices[i]);
      }
    }
  }

  private class MyTableAddAction<T> extends TableAddAction {
    private final Computable<List<T>> myChooser;

    public MyTableAddAction(Computable<List<T>> chooser) {
      super(BoundTablePanel.this.myTable);
      this.myChooser = chooser;
    }

    protected int doAdd(AnActionEvent e) {
      List<T> chosen = this.myChooser.compute();
      if (chosen == null) {
        return -1;
      }
      BoundTablePanel.this.myList.addAll((List) chosen);
      super.doAdd(e);
      T first = ((chosen.isEmpty() ?
        null :
        chosen.get(0)
      ));
      return ((first == null) ?
        -1 :
        BoundTablePanel.this.myList.indexOf(first)
      );
    }
  }
}
