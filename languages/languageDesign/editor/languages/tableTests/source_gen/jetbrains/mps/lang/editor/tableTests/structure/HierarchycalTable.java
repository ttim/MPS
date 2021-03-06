package jetbrains.mps.lang.editor.tableTests.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class HierarchycalTable extends Table {
  public static final String concept = "jetbrains.mps.lang.editor.tableTests.structure.HierarchycalTable";
  public static final String HEADERS = "headers";

  public HierarchycalTable(SNode node) {
    super(node);
  }

  public int getHeadersesCount() {
    return this.getChildCount(HierarchycalTable.HEADERS);
  }

  public Iterator<DataCell> headerses() {
    return this.children(DataCell.class, HierarchycalTable.HEADERS);
  }

  public List<DataCell> getHeaderses() {
    return this.getChildren(DataCell.class, HierarchycalTable.HEADERS);
  }

  public void addHeaders(DataCell node) {
    this.addChild(HierarchycalTable.HEADERS, node);
  }

  public void insertHeaders(DataCell prev, DataCell node) {
    this.insertChild(prev, HierarchycalTable.HEADERS, node);
  }

  public static HierarchycalTable newInstance(SModel sm, boolean init) {
    return (HierarchycalTable) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.tableTests.structure.HierarchycalTable", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static HierarchycalTable newInstance(SModel sm) {
    return HierarchycalTable.newInstance(sm, false);
  }
}
