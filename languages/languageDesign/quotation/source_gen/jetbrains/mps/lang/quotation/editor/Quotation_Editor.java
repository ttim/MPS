package jetbrains.mps.lang.quotation.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.style.Padding;
import jetbrains.mps.nodeEditor.style.Measure;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.nodeEditor.cellMenu.CellContext;

public class Quotation_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_29llnk_a(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createCollection_29llnk_a_0(editorContext, node);
  }

  private EditorCell createCollection_29llnk_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_29llnk_a");
    editorCell.addKeyMap(new _CreateAntiquotationKeyMap());
    editorCell.addEditorCell(this.createConstant_29llnk_a0(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_29llnk_b0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_29llnk_c0(editorContext, node));
    if (renderingCondition_29llnk_a3a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_29llnk_d0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_29llnk_d0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_29llnk_d0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_29llnk_a3a(editorContext, node));
    editorCell.addEditorCell(this.createRefNode_29llnk_b3a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_29llnk_c3a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_29llnk_a_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_29llnk_a_0");
    editorCell.addEditorCell(this.createCollection_29llnk_a0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_29llnk_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_29llnk_a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_29llnk_a0a(editorContext, node));
    if (renderingCondition_29llnk_a1a0(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createReadOnlyModelAccessor_29llnk_b0a(editorContext, node));
    }
    if (renderingCondition_29llnk_a2a0(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createError_29llnk_c0a(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createConstant_29llnk_a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<");
    editorCell.setCellId("Constant_29llnk_a0");
    BaseLanguageStyle_StyleSheet.getLeftParen(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, true);
      style.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.cyan);
      style.set(StyleAttributes.PADDING_RIGHT, new Padding(0.0, Measure.SPACES));
      style.set(StyleAttributes.MATCHING_LABEL, (String) null);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_29llnk_c0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ">");
    editorCell.setCellId("Constant_29llnk_c0");
    BaseLanguageStyle_StyleSheet.getRightParen(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, true);
      style.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.cyan);
      style.set(StyleAttributes.MATCHING_LABEL, (String) null);
    }
    editorCell.addKeyMap(new _Quotation_createModel());
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_29llnk_a3a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "[model =");
    editorCell.setCellId("Constant_29llnk_a3a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_29llnk_c3a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "]");
    editorCell.setCellId("Constant_29llnk_c3a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_29llnk_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "concept:");
    editorCell.setCellId("Constant_29llnk_a0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.EDITABLE, false);
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createError_29llnk_c0a(EditorContext editorContext, SNode node) {
    EditorCell_Error editorCell = new EditorCell_Error(editorContext, node, "<not specified>");
    editorCell.setCellId("Error_29llnk_c0a");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new Quotation_Editor.Quotation_component_cellMenu_a0c0a()}));
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_29llnk_b0a(final EditorContext editorContext, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {
      public String getText() {
        return (SLinkOperations.getTarget(node, "quotedNode", true) != null ?
          SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(node, "quotedNode", true)), "name") :
          "<not specitied>"
        );
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, new BasicCellContext(node), new SubstituteInfoPart[]{new Quotation_Editor.Quotation_component_cellMenu_a0b0a()}));
    editorCell.setCellId("ReadOnlyModelAccessor_29llnk_b0a");
    return editorCell;
  }

  private EditorCell createRefNode_29llnk_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("quotedNode");
    provider.setNoTargetText("<no quotedNode>");
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

  private EditorCell createRefNode_29llnk_b3a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("modelToCreate");
    provider.setNoTargetText("<no modelToCreate>");
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

  private static boolean renderingCondition_29llnk_a3a(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getTarget(node, "modelToCreate", true) != null;
  }

  private static boolean renderingCondition_29llnk_a1a0(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getTarget(node, "quotedNode", true) != null;
  }

  private static boolean renderingCondition_29llnk_a2a0(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getTarget(node, "quotedNode", true) == null;
  }

  public static class Quotation_component_cellMenu_a0b0a implements SubstituteInfoPart {
    private Quotation_quotedNode myComponent;

    public Quotation_component_cellMenu_a0b0a() {
      this.myComponent = new Quotation_quotedNode();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }
  }

  public static class Quotation_component_cellMenu_a0c0a implements SubstituteInfoPart {
    private Quotation_quotedNode myComponent;

    public Quotation_component_cellMenu_a0c0a() {
      this.myComponent = new Quotation_quotedNode();
    }

    public List<INodeSubstituteAction> createActions(CellContext cellContext, EditorContext editorContext) {
      return this.myComponent.createActions(cellContext, editorContext);
    }
  }
}
