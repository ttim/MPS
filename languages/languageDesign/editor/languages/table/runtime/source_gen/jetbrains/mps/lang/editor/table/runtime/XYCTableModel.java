package jetbrains.mps.lang.editor.table.runtime;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.cellMenu.NodeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class XYCTableModel implements TableModel {
  private SNode node;
  private SNode xlink;
  private SNode ylink;
  private SNode clink;
  private EditorContext editorCtx;

  public XYCTableModel(SNode node, SNode xlink, SNode ylink, SNode clink, EditorContext editorContext) {
    this.node = node;
    this.xlink = xlink;
    this.ylink = ylink;
    this.clink = clink;
    this.editorCtx = editorContext;
  }

  public List<SNode> x() {
    return SNodeOperations.getChildren(node, xlink);
  }

  public List<SNode> y() {
    return SNodeOperations.getChildren(node, ylink);
  }

  public List<SNode> c() {
    return SNodeOperations.getChildren(node, clink);
  }

  public int getRowCount() {
    return ListSequence.fromList(y()).count() + 1;
  }

  public int getColumnCount() {
    return ListSequence.fromList(x()).count() + 1;
  }

  public int dataidx(int row, int col) {
    return (row - 1) * (getColumnCount() - 1) + (col - 1);
  }

  public void insertColumn(int columnNumber) {
    Utils.insertElementAt(x(), SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(xlink, "target", false)), null), columnNumber - 1);
    for (int i = 0; i < getRowCount() - 1; i++) {
      int idx = dataidx(i + 1, columnNumber);
      Utils.insertElementAt(c(), SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(clink, "target", false)), null), idx);
    }
  }

  public void deleteColumn(int columnNumber) {
  }

  public void insertRow(int rowNumber) {
    if (rowNumber == 0) {
      rowNumber = 1;
    }
    Utils.insertElementAt(y(), SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(ylink, "target", false)), null), rowNumber - 1);
    for (int i = 0; i < getColumnCount() - 1; i++) {
      int idx = dataidx(rowNumber, i + 1);
      Utils.insertElementAt(c(), SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(clink, "target", false)), null), idx);
    }
  }

  public NodeSubstituteInfo getSubstituteInfo(int row, int column) {
    if (row == 0 && column == 0) {
      return null;
    }
    if (row == 0 && column > 0) {
      return new DefaultChildSubstituteInfo(node, getValueAt(row, column), xlink, editorCtx);
    }
    if (row > 0 && column == 0) {
      return new DefaultChildSubstituteInfo(node, getValueAt(row, column), ylink, editorCtx);
    }
    return new DefaultChildSubstituteInfo(node, getValueAt(row, column), clink, editorCtx);
  }

  public void createElement(int row, int column) {
    if (row == 0 && column == 0) {
      return;
    }
    if (row == 0) {
      x().set(column - 1, SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(xlink, "target", false)), null));
    }
    if (column == 0) {
      y().set(row - 1, SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(ylink, "target", false)), null));
    }
    int idx = dataidx(row, column);
    if (idx < ListSequence.fromList(c()).count()) {
      ListSequence.fromList(c()).setElement(idx, SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(clink, "target", false)), null));
    }
  }

  public SNode getValueAt(int row, int column) {
    if (row == 0 && column == 0) {
      return null;
    }
    if (row == 0) {
      return x().get(column - 1);
    }
    if (column == 0) {
      return y().get(row - 1);
    }
    int idx = dataidx(row, column);
    if (idx >= ListSequence.fromList(c()).count()) {
      return null;
    }
    return c().get(idx);
  }

  public void deleteRow(int rowNumber) {
    ListSequence.fromList(y()).removeElementAt(rowNumber - 1);
    for (int i = 0; i < getColumnCount() - 1; i++) {
      int idx = dataidx(rowNumber, 1);
      ListSequence.fromList(c()).removeElementAt((rowNumber - 1) * (getColumnCount() - 1));
    }
  }
}
