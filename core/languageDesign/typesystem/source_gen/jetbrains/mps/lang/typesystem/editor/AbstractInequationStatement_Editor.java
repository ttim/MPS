package jetbrains.mps.lang.typesystem.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.ConceptPropertyCellProvider;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import java.awt.Color;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;

public class AbstractInequationStatement_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_9248_0(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createCollection_9248_1(editorContext, node);
  }

  private EditorCell createCollection_9248_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_9248_0");
    editorCell.addEditorCell(this.createRefNode_9248_0(editorContext, node));
    editorCell.addEditorCell(this.createConceptProperty_9248_0(editorContext, node));
    if (node.hasProperty("inequationPriority")) {
      editorCell.addEditorCell(this.createNonEmptyProperty_9248_0(editorContext, node));
    }
    editorCell.addEditorCell(this.createRefNode_9248_1(editorContext, node));
    editorCell.addEditorCell(this.createConstant_9248_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_9248_1(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_9248_1");
    editorCell.addEditorCell(this.createComponent_9248_0(editorContext, node));
    editorCell.addEditorCell(this.createConstant_9248_1(editorContext, node));
    editorCell.addEditorCell(this.createProperty_9248_0(editorContext, node));
    return editorCell;
  }

  private EditorCell createComponent_9248_0(EditorContext editorContext, SNode node) {
    AbstractCellProvider provider = new AbstractEquationInspector(node);
    EditorCell editorCell = provider.createEditorCell(editorContext);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
    return editorCell;
  }

  private EditorCell createConstant_9248_0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ";");
    editorCell.setCellId("Constant_9248_0");
    BaseLanguageStyle_StyleSheet.getSemicolon(editorCell).apply(editorCell);
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_9248_1(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "priority:");
    editorCell.setCellId("Constant_9248_1");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNode_9248_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("leftExpression");
    provider.setNoTargetText("<no leftExpression>");
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

  private EditorCell createConceptProperty_9248_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new ConceptPropertyCellProvider(node, editorContext);
    provider.setRole("alias");
    provider.setNoTargetText("<no alias>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("conceptProperty_alias");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_COLOR, new AttributeCalculator<Color>() {
        public Color calculate(EditorCell cell) {
          return AbstractInequationStatement_Editor._StyleParameter_QueryFunction_9248_0((cell == null ?
            null :
            cell.getSNode()
          ), (cell == null ?
            null :
            cell.getEditorContext()
          ));
        }
      });
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(editorContext, provider.getCellContext(), new SubstituteInfoPart[]{new AbstractInequationStatement_Editor.AbstractInequationStatement_Editor_replaceWith_AbstractEquationStatement_cellMenu0()}));
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefNode_9248_1(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, editorContext);
    provider.setRole("rightExpression");
    provider.setNoTargetText("<no rightExpression>");
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

  private EditorCell createNonEmptyProperty_9248_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("inequationPriority");
    provider.setNoTargetText("<no inequationPriority>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_inequationPriority");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.FONT_SIZE, 6);
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

  private EditorCell createProperty_9248_0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
    provider.setRole("inequationPriority");
    provider.setNoTargetText("<no inequationPriority>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("property_inequationPriority_1");
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

  private static Color _StyleParameter_QueryFunction_9248_0(SNode node, EditorContext editorContext) {
    if (SPropertyOperations.getBoolean(node, "checkOnly")) {
      return Color.GRAY;
    } else {
      return Color.BLACK;
    }
  }

  public static class AbstractInequationStatement_Editor_replaceWith_AbstractEquationStatement_cellMenu0 extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {
    public AbstractInequationStatement_Editor_replaceWith_AbstractEquationStatement_cellMenu0() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement";
    }
  }
}
