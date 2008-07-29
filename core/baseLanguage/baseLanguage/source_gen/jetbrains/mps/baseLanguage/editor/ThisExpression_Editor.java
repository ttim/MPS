package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;

public class ThisExpression_Editor extends DefaultNodeEditor {

  private static void setupBasic_Alternation_11829549607811182954960781(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Alternation_1182954960781");
  }

  private static void setupBasic_Constant_11829549637481182954963748(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1182954963748");
    BaseLanguageStyle_StyleSheet.KEY_WORD.apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, true);
          this.set(StyleAttributes.EDITABLE, true);
          this.set(StyleAttributes.PADDING_LEFT, 0.0);
        }

      };
      inlineStyle.apply(editorCell);
    }
    editorCell.addKeyMap(new ThisExpression_KeyMap());
  }

  private static void setupBasic_Collection_11829549691911182954969191(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1182954969191");
  }

  private static void setupBasic_Constant_11829549706161182954970616(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1182954970616");
    BaseLanguageStyle_StyleSheet.KEY_WORD.apply(editorCell);
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, true);
          this.set(StyleAttributes.EDITABLE, true);
          this.set(StyleAttributes.PADDING_LEFT, 0.0);
          this.set(StyleAttributes.PADDING_RIGHT, 0.0);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refCell_classConcept1182955053205(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_classConcept");
    ThisExpression_ClassConcept_Actions.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_Constant_11829550753191182955075319(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1182955075319");
    BaseLanguageStyle_StyleSheet.DOT.apply(editorCell);
  }

  private static void setupLabel_Constant_1182954963748_1182954963748(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1182954970616_1182954970616(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refCell_classConcept_1182955053205(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1182955075319_1182955075319(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition24(SNode node, EditorContext editorContext, IScope scope) {
    return (SLinkOperations.getTarget(node, "classConcept", false) != null);
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createAlternation1182954960781(context, node);
  }

  public EditorCell createAlternation1182954960781(EditorContext context, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = ThisExpression_Editor.renderingCondition24(node, context, context.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.createCollection1182954969191(context, node);
    } else
    {
      editorCell = this.createConstant1182954963748(context, node, "this");
    }
    setupBasic_Alternation_11829549607811182954960781(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createCollection1182954969191(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11829549691911182954969191(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefCell1182955053205(context, node));
    editorCell.addEditorCell(this.createConstant1182955075319(context, node, "."));
    editorCell.addEditorCell(this.createConstant1182954970616(context, node, "this"));
    return editorCell;
  }

  public EditorCell createConstant1182954963748(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11829549637481182954963748(editorCell, node, context);
    setupLabel_Constant_1182954963748_1182954963748(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1182954970616(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11829549706161182954970616(editorCell, node, context);
    setupLabel_Constant_1182954970616_1182954970616(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1182955075319(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11829550753191182955075319(editorCell, node, context);
    setupLabel_Constant_1182955075319_1182955075319(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefCell1182955053205_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new ThisExpression_Editor._Inline17());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_classConcept1182955053205(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_classConcept_1182955053205((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1182955053205(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("classConcept");
    provider.setNoTargetText("<no classConcept>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1182955053205_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public static class _Inline17 extends AbstractCellProvider {

    public _Inline17() {
      super();
    }

    private static void setupBasic_property_name1182955065205(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, "property_name");
      BaseLanguageStyle_StyleSheet.CLASS_NAME.apply(editorCell);
    }

    private static void setupLabel_property_name_1182955065205(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }


    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1182955065205(context, node);
    }

    public EditorCell createProperty1182955065205_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1182955065205(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1182955065205((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1182955065205(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(false);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1182955065205_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }

}

}
