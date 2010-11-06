package jetbrains.mps.lang.editor.table.runtime;

/*Generated by MPS */

import java.util.List;

public interface TableModel_optimized {
  public int getColumnCount();
  public int getRowCount();
  public List<TableRow> getRows();
  public TableRow getRow(int index);
  public void createNewRow(int index);
  public void removeRow(int index);
  public void createNewColumn(int index);
  public void removeColumn(int index);
}
