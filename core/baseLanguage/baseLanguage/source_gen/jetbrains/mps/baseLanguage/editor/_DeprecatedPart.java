package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class _DeprecatedPart extends AbstractCellProvider {

  public _DeprecatedPart(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext context) {
    return this.createEditorCell(context, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1223637228887(context, node);
  }

  public EditorCell createCollection1223637228887(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_12236372288871223637228887(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    if (renderingCondition0235_1(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection1223637231686(context, node));
    }
    return editorCell;
  }

  public EditorCell createCollection1223637231686(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_12236372316861223637231686(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    if (renderingCondition0235_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstant1223637237097(context, node, "/**"));
    }
    editorCell.addEditorCell(this.createCollection1223649498363(context, node));
    editorCell.addEditorCell(this.createConstant1223637237105(context, node, " */"));
    return editorCell;
  }

  public EditorCell createCollection1223649498363(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12236494983631223649498363(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1223649502258(context, node, " * "));
    editorCell.addEditorCell(this.createConstant1223649511776(context, node, "@deprecated"));
    return editorCell;
  }

  public EditorCell createConstant1223637237097(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12236372370971223637237097(editorCell, node, context);
    setupLabel_Constant_1223637237097_1223637237097(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1223637237105(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12236372371051223637237105(editorCell, node, context);
    setupLabel_Constant_1223637237105_1223637237105(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1223649502258(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12236495022581223649502258(editorCell, node, context);
    setupLabel_Constant_1223649502258_1223649502258(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1223649511776(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12236495117761223649511776(editorCell, node, context);
    setupLabel_Constant_1223649511776_1223649511776(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }


  private static void setupBasic_Collection_12236372288871223637228887(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1223637228887");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_12236372316861223637231686(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1223637231686");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_12236372370971223637237097(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1223637237097");
    BaseLanguageStyle_StyleSheet.getComment(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_12236372371051223637237105(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1223637237105");
    BaseLanguageStyle_StyleSheet.getComment(editorCell).apply(editorCell);
  }

  private static void setupBasic_Collection_12236494983631223649498363(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1223649498363");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_12236495022581223649502258(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1223649502258");
    BaseLanguageStyle_StyleSheet.getComment(editorCell).apply(editorCell);
  }

  private static void setupBasic_Constant_12236495117761223649511776(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1223649511776");
    BaseLanguageStyle_StyleSheet.getJavaDoc(editorCell).apply(editorCell);
  }

  private static void setupLabel_Constant_1223637237097_1223637237097(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1223637237105_1223637237105(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1223649502258_1223649502258(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1223649511776_1223649511776(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition0235_0(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "isDeprecated");
  }

  public static boolean renderingCondition0235_1(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "isDeprecated");
  }

}
