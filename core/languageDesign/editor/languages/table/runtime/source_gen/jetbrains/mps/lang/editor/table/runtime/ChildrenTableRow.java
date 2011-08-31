package jetbrains.mps.lang.editor.table.runtime;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.ArrayList;

public class ChildrenTableRow extends AbstractTableRow {
  private SNode myChildLinkDeclaration;
  private SNode myParentNode;
  private List<SNode> myChildNodes;

  public ChildrenTableRow(@NotNull SNode parentNode, @NotNull SNode childLinkDeclaration, int rowNumber) {
    super(rowNumber);
    myParentNode = parentNode;
    myChildLinkDeclaration = childLinkDeclaration;
  }

  public void removeCell(int index) {
    SNodeOperations.deleteNode(ListSequence.<SNode>fromList(getChildren()).getElement(index));
  }

  public void createNewCell(int index) {
    assert index <= ListSequence.<SNode>fromList(getChildren()).count();
    SNode newCellNode = SConceptOperations.createNewNode(NameUtil.nodeFQName(SLinkOperations.getTarget(myChildLinkDeclaration, "target", false)), null);
    insertNewCell(newCellNode, index);
  }

  protected void insertNewCell(SNode newCellNode, int index) {
    // subclasses may implement this method in a different way 
    if (index == ListSequence.<SNode>fromList(getChildren()).count()) {
      myParentNode.addChild(SPropertyOperations.getString(myChildLinkDeclaration, "role"), newCellNode);
    } else {
      SNodeOperations.insertPrevSiblingChild(ListSequence.<SNode>fromList(getChildren()).getElement(index), newCellNode);
    }
  }

  public int getColumnCount() {
    return ListSequence.<SNode>fromList(getChildren()).count();
  }

  public SNode getCell(int index) {
    return ListSequence.<SNode>fromList(getChildren()).getElement(index);
  }

  protected List<SNode> filterChildren(List<SNode> children) {
    // Dummy filter subclasses may implement some filtering here. 
    // Returned list can contain nulls representing not existing cells. 
    List<SNode> result = new ArrayList<SNode>();
    return ListSequence.<SNode>fromList(result).addSequence(ListSequence.<SNode>fromList(children));
  }

  private List<SNode> getChildren() {
    if (myChildNodes == null) {
      myChildNodes = filterChildren(SNodeOperations.getChildren(myParentNode, myChildLinkDeclaration));
    }
    return myChildNodes;
  }
}
