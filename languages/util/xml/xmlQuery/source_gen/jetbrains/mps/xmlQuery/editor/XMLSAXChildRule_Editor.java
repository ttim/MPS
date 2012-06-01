package jetbrains.mps.xmlQuery.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.InlineCellProvider;
import jetbrains.mps.nodeEditor.MPSFonts;

public class XMLSAXChildRule_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_wbyfib_a(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createCollection_wbyfib_a_0(editorContext, node);
  }

  private EditorCell createCollection_wbyfib_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_wbyfib_a");
    editorCell.addEditorCell(this.createConstant_wbyfib_a0(editorContext, node));
    if (renderingCondition_wbyfib_a1a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_wbyfib_b0(editorContext, node));
    }
    editorCell.addEditorCell(this.createRefCell_wbyfib_c0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_wbyfib_d0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_wbyfib_b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_wbyfib_b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_wbyfib_a1a(editorContext, node));
    editorCell.addEditorCell(this.createProperty_wbyfib_b1a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_wbyfib_c1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_wbyfib_a_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_wbyfib_a_0");
    if (renderingCondition_wbyfib_a0a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_wbyfib_a0(editorContext, node));
    }
    if (renderingCondition_wbyfib_a1a_0(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_wbyfib_b0_0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_wbyfib_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_wbyfib_a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_wbyfib_a0a(editorContext, node));
    editorCell.addEditorCell(this.createProperty_wbyfib_b0a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_wbyfib_b0_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_wbyfib_b0_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_wbyfib_a1a_0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_wbyfib_b1a_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_wbyfib_a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "child");
    editorCell.setCellId("Constant_wbyfib_a0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_wbyfib_a1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "with tag");
    editorCell.setCellId("Constant_wbyfib_a1a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_wbyfib_c1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "=>");
    editorCell.setCellId("Constant_wbyfib_c1a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_wbyfib_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "tag:");
    editorCell.setCellId("Constant_wbyfib_a0a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_wbyfib_a1a_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "override tag:");
    editorCell.setCellId("Constant_wbyfib_a1a_0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefCell_wbyfib_c0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("rule");
    provider.setNoTargetText("<no rule>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new XMLSAXChildRule_Editor._Inline_wbyfib_a2a());
    editorCell = provider.createEditorCell(editorContext);
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

  private EditorCell createRefNode_wbyfib_d0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("handler");
    provider.setNoTargetText("<no handler>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_INDENT, true);
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

  private EditorCell createProperty_wbyfib_b1a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("tagName");
    provider.setNoTargetText("<no tagName>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_tagName");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_GREEN);
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

  private EditorCell createProperty_wbyfib_b0a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("tagName");
    provider.setNoTargetText("<no tagName>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_tagName_1");
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

  private EditorCell createProperty_wbyfib_b1a_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("overrideTag");
    provider.setNoTargetText("<no overrideTag>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_overrideTag");
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

  private static boolean renderingCondition_wbyfib_a1a(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "rule", false) != null) && (isEmpty_wbyfib_a0a0a0a0(SPropertyOperations.getString(SLinkOperations.getTarget(node, "rule", false), "tagName")) || SPropertyOperations.getBoolean(node, "overrideTag"));
  }

  private static boolean renderingCondition_wbyfib_a0a(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "rule", false) != null) && (isEmpty_wbyfib_a0a0a0a1(SPropertyOperations.getString(SLinkOperations.getTarget(node, "rule", false), "tagName")) || SPropertyOperations.getBoolean(node, "overrideTag"));
  }

  private static boolean renderingCondition_wbyfib_a1a_0(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "rule", false) != null) && isNotEmpty_wbyfib_a0a0a2(SPropertyOperations.getString(SLinkOperations.getTarget(node, "rule", false), "tagName"));
  }

  public static boolean isEmpty_wbyfib_a0a0a0a0(String str) {
    return str == null || str.length() == 0;
  }

  public static boolean isEmpty_wbyfib_a0a0a0a1(String str) {
    return str == null || str.length() == 0;
  }

  public static boolean isNotEmpty_wbyfib_a0a0a2(String str) {
    return str != null && str.length() > 0;
  }

  public static class _Inline_wbyfib_a2a extends InlineCellProvider {
    public _Inline_wbyfib_a2a() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createProperty_wbyfib_a0c0(editorContext, node);
    }

    private EditorCell createProperty_wbyfib_a0c0(EditorContext editorContext, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(editorContext);
      editorCell.setCellId("property_name");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_MAGENTA);
        style.set(StyleAttributes.FONT_STYLE, MPSFonts.BOLD);
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
  }
}
