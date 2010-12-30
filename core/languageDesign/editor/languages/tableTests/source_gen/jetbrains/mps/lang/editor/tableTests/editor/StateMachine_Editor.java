package jetbrains.mps.lang.editor.tableTests.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.table.runtime.TableModelCreator;
import jetbrains.mps.lang.editor.table.runtime.TableModel;
import jetbrains.mps.lang.editor.table.runtime.AbstractTableModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.editor.table.runtime.EditorCell_Table;

public class StateMachine_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_qpt50r_a(editorContext, node);
  }

  private EditorCell createCollection_qpt50r_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_qpt50r_a");
    editorCell.addEditorCell(this.createConstant_qpt50r_a0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_qpt50r_b0(editorContext, node));
    editorCell.addEditorCell(this.createTable_qpt50r_c0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_qpt50r_a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "StateMachine");
    editorCell.setCellId("Constant_qpt50r_a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD_ITALIC);
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createProperty_qpt50r_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_name");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createTable_qpt50r_c0(EditorContext editorContext, SNode node) {
    TableModelCreator creator = new TableModelCreator() {
      public TableModel getTable(final SNode node, EditorContext editorContext) {
        return new AbstractTableModel() {
          public int getColumnCount() {
            return 1 + ListSequence.fromList(SLinkOperations.getTargets(node, "events", true)).count();
          }

          public int getRowCount() {
            return 1 + ListSequence.fromList(SLinkOperations.getTargets(node, "states", true)).count();
          }

          public SNode getValueAt(int row, int column) {
            if (row == 0 && column > 0) {
              return ListSequence.fromList(SLinkOperations.getTargets(node, "events", true)).getElement(column - 1);
            }
            if (column == 0 && row > 0) {
              return ListSequence.fromList(SLinkOperations.getTargets(node, "states", true)).getElement(row - 1);
            }
            if (row > 0 && column > 0) {
              SNode event = ListSequence.fromList(SLinkOperations.getTargets(node, "events", true)).getElement(column - 1);
              SNode state = ListSequence.fromList(SLinkOperations.getTargets(node, "states", true)).getElement(row - 1);
              for (SNode transition : ListSequence.fromList(SLinkOperations.getTargets(node, "transitions", true))) {
                if (SLinkOperations.getTarget(SLinkOperations.getTarget(transition, "trigger", true), "event", false) == event && SLinkOperations.getTarget(SLinkOperations.getTarget(transition, "fromState", true), "state", false) == state) {
                  return transition;
                }
              }
            }
            return null;
          }

          @Override
          public void createElement(int row, int column) {
            if (row > 0 && column > 0) {
              SNode event = ListSequence.fromList(SLinkOperations.getTargets(node, "events", true)).getElement(column - 1);
              SNode state = ListSequence.fromList(SLinkOperations.getTargets(node, "states", true)).getElement(row - 1);
              SNode transition = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.tableTests.structure.Transition", null);
              SLinkOperations.setTarget(transition, "trigger", SConceptOperations.createNewNode("jetbrains.mps.lang.editor.tableTests.structure.EventReference", null), true);
              SLinkOperations.setTarget(SLinkOperations.getTarget(transition, "trigger", true), "event", event, false);
              SLinkOperations.setTarget(transition, "fromState", SConceptOperations.createNewNode("jetbrains.mps.lang.editor.tableTests.structure.StateReference", null), true);
              SLinkOperations.setTarget(SLinkOperations.getTarget(transition, "fromState", true), "state", state, false);
              ListSequence.fromList(SLinkOperations.getTargets(node, "transitions", true)).addElement(transition);
            }
          }

          @Override
          public void insertColumn(int columnNumber) {
            if (columnNumber <= 0) {
              return;
            }
            ListSequence.fromList(SLinkOperations.getTargets(node, "events", true)).insertElement(columnNumber - 1, SConceptOperations.createNewNode("jetbrains.mps.lang.editor.tableTests.structure.Event", null));
          }

          @Override
          public void insertRow(int rowNumber) {
            if (rowNumber <= 0) {
              return;
            }
            ListSequence.fromList(SLinkOperations.getTargets(node, "states", true)).insertElement(rowNumber - 1, SConceptOperations.createNewNode("jetbrains.mps.lang.editor.tableTests.structure.State", null));
          }

          @Override
          public void deleteColumn(int columnNumber) {
            if (columnNumber <= 0) {
              return;
            }
            SNode event = ListSequence.fromList(SLinkOperations.getTargets(node, "events", true)).removeElementAt(columnNumber - 1);
            for (SNode transition : ListSequence.fromList(SLinkOperations.getTargets(node, "transitions", true))) {
              if (SLinkOperations.getTarget(SLinkOperations.getTarget(transition, "trigger", true), "event", false) == event) {
                SNodeOperations.deleteNode(transition);
              }
            }
            SNodeOperations.deleteNode(event);
          }

          @Override
          public void deleteRow(int rowNumber) {
            if (rowNumber <= 0) {
              return;
            }
            SNode state = ListSequence.fromList(SLinkOperations.getTargets(node, "states", true)).removeElementAt(rowNumber - 1);
            for (SNode transition : ListSequence.fromList(SLinkOperations.getTargets(node, "transitions", true))) {
              if (SLinkOperations.getTarget(SLinkOperations.getTarget(transition, "fromState", true), "state", false) == state) {
                SNodeOperations.deleteNode(transition);
              } else if (SLinkOperations.getTarget(SLinkOperations.getTarget(transition, "toState", true), "state", false) == state) {
                SLinkOperations.setTarget(SLinkOperations.getTarget(transition, "toState", true), "state", null, false);
              }
            }
            SNodeOperations.deleteNode(state);
          }
        };
      }
    };
    EditorCell_Collection editorCell = EditorCell_Table.createTable(editorContext, node, creator.getTable(node, editorContext), "Table_qpt50r_c0");
    editorCell.setCellId("Table_qpt50r_c0_0");
    return editorCell;
  }
}
