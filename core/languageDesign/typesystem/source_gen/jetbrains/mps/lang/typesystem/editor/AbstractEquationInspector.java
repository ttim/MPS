package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;

public class AbstractEquationInspector extends AbstractCellProvider {

  public AbstractEquationInspector(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext editorContext) {
    return this.createEditorCell(editorContext, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_4585_0(editorContext, node);
  }

  private EditorCell createCollection_4585_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_4585_0");
    editorCell.addEditorCell(this.createCollection_4585_1(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4585_2(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4585_2(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4585_3(editorContext, node));
    editorCell.addEditorCell(this.createConstant_4585_5(editorContext, node));
    editorCell.addEditorCell(this.createCollection_4585_4(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4585_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4585_1");
    editorCell.addEditorCell(this.createConstant_4585_0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_4585_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4585_2(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4585_2");
    editorCell.addEditorCell(this.createConstant_4585_1(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_4585_1(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4585_3(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4585_3");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_4585_3(editorContext, node));
    editorCell.addEditorCell(this.createProperty_4585_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_4585_4(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_4585_4");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_4585_4(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_4585_2(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_4585_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "node to check =");
    editorCell.setCellId("Constant_4585_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4585_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "error string =");
    editorCell.setCellId("Constant_4585_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4585_2(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4585_2");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4585_3(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "check only");
    editorCell.setCellId("Constant_4585_3");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4585_4(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "intention to fix error");
    editorCell.setCellId("Constant_4585_4");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_4585_5(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_4585_5");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_4585_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("nodeToCheck");
    provider.setNoTargetText("<auto>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
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

  private EditorCell createRefNode_4585_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("errorString");
    provider.setNoTargetText("<no errorString>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
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

  private EditorCell createProperty_4585_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("checkOnly");
    provider.setNoTargetText("<no checkOnly>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_checkOnly");
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

  private EditorCell createRefNode_4585_2(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("helginsIntention");
    provider.setNoTargetText("<no helginsIntention>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
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

}
