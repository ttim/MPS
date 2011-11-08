package jetbrains.mps.lang.plugin.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.plugin.behavior.ActionParameter_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.smodel.IScope;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ActionParameter_Hint extends AbstractCellProvider {
  public ActionParameter_Hint(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext editorContext) {
    return this.createEditorCell(editorContext, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_xpsq7t_a(editorContext, node);
  }

  private EditorCell createCollection_xpsq7t_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_xpsq7t_a");
    if (renderingCondition_xpsq7t_a0a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_xpsq7t_a0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_xpsq7t_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_xpsq7t_a0");
    editorCell.addEditorCell(this.createReadOnlyModelAccessor_xpsq7t_a0a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_xpsq7t_b0a(editorContext, node));
    editorCell.addEditorCell(this.createReadOnlyModelAccessor_xpsq7t_c0a(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_xpsq7t_b0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "");
    editorCell.setCellId("Constant_xpsq7t_b0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_xpsq7t_a0a(final EditorContext editorContext, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {
      public String getText() {
        SNode annotation = ListSequence.fromList(SLinkOperations.getTargets(ActionParameter_Behavior.call_getFieldDeclaration_1171743928471867409(node), "annotation", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SPropertyOperations.getString(SLinkOperations.getTarget(it, "annotation", false), "name").equals(SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(new ActionParameter_Hint.QuotationClass_xpsq7t_a0a0a0a0a0a0a0a0a0a1a0a0f().createNode(), "classifier", false), "jetbrains.mps.baseLanguage.structure.Annotation"), "name"));
          }
        }).first();
        if (annotation == null) {
          return "";
        }
        SNode description = ListSequence.fromList(SLinkOperations.getTargets(annotation, "value", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SPropertyOperations.getString(SLinkOperations.getTarget(it, "key", false), "name").equals("description");
          }
        }).first();
        if (description == null) {
          return "";
        }
        String descriptionString = SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(description, "value", true), "jetbrains.mps.baseLanguage.structure.StringLiteral"), "value");
        return descriptionString;
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setCellId("ReadOnlyModelAccessor_xpsq7t_a0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    return editorCell;
  }

  private EditorCell createReadOnlyModelAccessor_xpsq7t_c0a(final EditorContext editorContext, final SNode node) {
    EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {
      public String getText() {
        SNode annotation = ListSequence.fromList(SLinkOperations.getTargets(ActionParameter_Behavior.call_getFieldDeclaration_1171743928471867409(node), "annotation", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SPropertyOperations.getString(SLinkOperations.getTarget(it, "annotation", false), "name").equals(SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(new ActionParameter_Hint.QuotationClass_xpsq7t_a0a0a0a0a0a0a0a0a0a1a0a0g().createNode(), "classifier", false), "jetbrains.mps.baseLanguage.structure.Annotation"), "name"));
          }
        }).first();
        if (annotation == null) {
          return "";
        }
        SNode longDescription = ListSequence.fromList(SLinkOperations.getTargets(annotation, "value", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SPropertyOperations.getString(SLinkOperations.getTarget(it, "key", false), "name").equals("longDescription");
          }
        }).last();
        if (longDescription == null) {
          return "";
        }
        String longDescriptionString = SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(longDescription, "value", true), "jetbrains.mps.baseLanguage.structure.StringLiteral"), "value");
        return longDescriptionString;
      }

      public void setText(String s) {
      }

      public boolean isValidText(String s) {
        return EqualUtil.equals(s, this.getText());
      }
    }, node);
    editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
    editorCell.setCellId("ReadOnlyModelAccessor_xpsq7t_c0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    return editorCell;
  }

  private static boolean renderingCondition_xpsq7t_a0a(SNode node, EditorContext editorContext, IScope scope) {
    return ActionParameter_Behavior.call_getFieldDeclaration_1171743928471867409(node) != null;
  }

  public static class QuotationClass_xpsq7t_a0a0a0a0a0a0a0a0a0a1a0a0f {
    public QuotationClass_xpsq7t_a0a0a0a0a0a0a0a0a0a1a0a0f() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#jetbrains.mps.ide.actions(MPS.Workbench/jetbrains.mps.ide.actions@java_stub)"), SNodeId.fromString("~MPSCommonDataKeys$Description")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_xpsq7t_a0a0a0a0a0a0a0a0a0a1a0a0g {
    public QuotationClass_xpsq7t_a0a0a0a0a0a0a0a0a0a1a0a0g() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#jetbrains.mps.ide.actions(MPS.Workbench/jetbrains.mps.ide.actions@java_stub)"), SNodeId.fromString("~MPSCommonDataKeys$Description")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
