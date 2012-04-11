package jetbrains.mps.lang.plugin.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSFonts;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cells.EditorCell_Image;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.nodeEditor.cells.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cells.EditorCell_Component;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.style.Padding;
import jetbrains.mps.nodeEditor.style.Measure;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.nodeEditor.BlockCells;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.MacrosUtil;
import jetbrains.mps.vfs.FileSystem;
import javax.swing.JComponent;
import jetbrains.mps.ide.editor.util.EditorUtil;

public class PreferencePage_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_fl5ndt_a(editorContext, node);
  }

  private EditorCell createAlternation_fl5ndt_c1b1a(EditorContext editorContext, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = PreferencePage_Editor.renderingCondition_fl5ndt_a2b1b0(node, editorContext, editorContext.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createCollection_fl5ndt_a2b1b0(editorContext, node);
    } else {
      editorCell = this.createConstant_fl5ndt_a2b1b0(editorContext, node);
    }
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_fl5ndt_a0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_fl5ndt_b0(editorContext, node));
    if (renderingCondition_fl5ndt_a2a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_fl5ndt_c0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_fl5ndt_a0a(editorContext, node));
    if (renderingCondition_fl5ndt_a1a0(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant_fl5ndt_b0a(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_a0a");
    editorCell.addEditorCell(this.createConstant_fl5ndt_a0a0(editorContext, node));
    editorCell.addEditorCell(this.createProperty_fl5ndt_b0a0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createIndentCell_fl5ndt_a1a(editorContext, node));
    editorCell.addEditorCell(this.createCollection_fl5ndt_b1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_b1a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_b1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_fl5ndt_a1b0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_fl5ndt_b1b0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_fl5ndt_c1b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_fl5ndt_d1b0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_fl5ndt_e1b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_fl5ndt_f1b0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_fl5ndt_g1b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_fl5ndt_h1b0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_fl5ndt_i1b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_a1b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_a1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_fl5ndt_a0b1a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_fl5ndt_b0b1a(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_fl5ndt_c0b1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_b1b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_b1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_fl5ndt_a1b1a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_fl5ndt_b1b1a(editorContext, node));
    editorCell.addEditorCell(this.createAlternation_fl5ndt_c1b1a(editorContext, node));
    editorCell.addEditorCell(this.createJComponent_fl5ndt_d1b1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_a2b1b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_a2b1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createImage_fl5ndt_a0c1b1a(editorContext, node));
    editorCell.addEditorCell(this.createProperty_fl5ndt_b0c1b1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_fl5ndt_c1b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_fl5ndt_c1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_fl5ndt_a2b1a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_fl5ndt_b2b1a(editorContext, node));
    editorCell.addEditorCell(this.createProperty_fl5ndt_c2b1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_a0a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "page");
    editorCell.setCellId("Constant_fl5ndt_a0a0");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_b0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "{");
    editorCell.setCellId("Constant_fl5ndt_b0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.MATCHING_LABEL, "brace");
      style.set(StyleAttributes.INDENT_LAYOUT_NO_WRAP, true);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_a0b1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "component");
    editorCell.setCellId("Constant_fl5ndt_a0b1a");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_b0b1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ":");
    editorCell.setCellId("Constant_fl5ndt_b0b1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.LAYOUT_CONSTRAINT, "punctuation");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_a1b1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "icon");
    editorCell.setCellId("Constant_fl5ndt_a1b1a");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_b1b1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ":");
    editorCell.setCellId("Constant_fl5ndt_b1b1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.LAYOUT_CONSTRAINT, "punctuation");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_a2b1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<no icon>");
    editorCell.setCellId("Constant_fl5ndt_a2b1b0");
    BaseLanguageStyle_StyleSheet.getEmptyCell(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, MPSColors.gray);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_a2b1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "help topic");
    editorCell.setCellId("Constant_fl5ndt_a2b1a");
    BaseLanguageStyle_StyleSheet.getKeyWord(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_b2b1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ":");
    editorCell.setCellId("Constant_fl5ndt_b2b1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.LAYOUT_CONSTRAINT, "punctuation");
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_d1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_fl5ndt_d1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_f1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_fl5ndt_f1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_h1b0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_fl5ndt_h1b0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_fl5ndt_c0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "}");
    editorCell.setCellId("Constant_fl5ndt_c0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.MATCHING_LABEL, "brace");
      style.set(StyleAttributes.INDENT_LAYOUT_NO_WRAP, true);
      style.set(StyleAttributes.FONT_STYLE, MPSFonts.PLAIN);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createImage_fl5ndt_a0c1b1a(final EditorContext editorContext, final SNode node) {
    EditorCell_Image editorCell;
    editorCell = EditorCell_Image.createImageCell(editorContext, node, new _FunctionTypes._return_P0_E0<String>() {
      public String invoke() {
        return SPropertyOperations.getString(node, "icon");
      }
    }.invoke());
    editorCell.setCellId("Image_fl5ndt_a0c1b1a");
    editorCell.setDescent(0);
    return editorCell;
  }

  private EditorCell createIndentCell_fl5ndt_a1a(EditorContext editorContext, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(editorContext, node);
    return result;
  }

  private EditorCell createJComponent_fl5ndt_d1b1a(EditorContext editorContext, SNode node) {
    EditorCell editorCell = EditorCell_Component.createComponentCell(editorContext, node, PreferencePage_Editor._QueryFunction_JComponent_fl5ndt_a3b1b0(node, editorContext), "_fl5ndt_d1b1a");
    editorCell.setCellId("JComponent_fl5ndt_d1b1a");
    return editorCell;
  }

  private EditorCell createRefNode_fl5ndt_c0b1a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("component");
    provider.setNoTargetText("<no component>");
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

  private EditorCell createRefNode_fl5ndt_e1b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("resetBlock");
    provider.setNoTargetText("<no resetBlock>");
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

  private EditorCell createRefNode_fl5ndt_g1b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("commitBlock");
    provider.setNoTargetText("<no commitBlock>");
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

  private EditorCell createRefNode_fl5ndt_i1b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("isModifiedBlock");
    provider.setNoTargetText("<no isModifiedBlock>");
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

  private EditorCell createProperty_fl5ndt_b0a0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_name");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PADDING_RIGHT, new Padding(0.0, Measure.SPACES));
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

  private EditorCell createProperty_fl5ndt_b0c1b1a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("icon");
    provider.setNoTargetText("<no icon>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_icon");
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

  private EditorCell createProperty_fl5ndt_c2b1a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("helpTopic");
    provider.setNoTargetText("<default help topic>");
    provider.setAllowsEmptyTarget(true);
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_helpTopic");
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

  private static boolean renderingCondition_fl5ndt_a1a0(SNode node, EditorContext editorContext, IScope scope) {
    return BlockCells.useBraces();
  }

  private static boolean renderingCondition_fl5ndt_a2b1b0(SNode node, EditorContext editorContext, IScope scope) {
    String path = null;
    IModule module = SNodeOperations.getModel(node).getModelDescriptor().getModule();
    if (module != null) {
      path = MacrosUtil.expandPath(SPropertyOperations.getString(node, "icon"), module.getModuleFqName());
    }
    return path != null && FileSystem.getInstance().getFileByPath(path).exists();
  }

  private static boolean renderingCondition_fl5ndt_a2a(SNode node, EditorContext editorContext, IScope scope) {
    return BlockCells.useBraces();
  }

  private static JComponent _QueryFunction_JComponent_fl5ndt_a3b1b0(final SNode node, final EditorContext editorContext) {
    return EditorUtil.createSelectIconButton(node, "icon", editorContext);
  }
}
