package jetbrains.mps.platform.conf.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.cells.EditorCell_Component;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import javax.swing.JComponent;
import jetbrains.mps.internal.collections.runtime.ILeftCombinator;
import javax.swing.JTextArea;
import java.awt.Font;
import jetbrains.mps.nodeEditor.EditorSettings;
import java.awt.Color;

public class BaseConcept_brokenRefs extends AbstractCellProvider {
  public BaseConcept_brokenRefs(SNode node) {
    super(node);
  }

  public EditorCell createEditorCell(EditorContext editorContext) {
    return this.createEditorCell(editorContext, this.getSNode());
  }

  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_bx3ota_a(editorContext, node);
  }

  private EditorCell createCollection_bx3ota_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_bx3ota_a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    if (renderingCondition_bx3ota_a0a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_bx3ota_a0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_bx3ota_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_bx3ota_a0");
    editorCell.addEditorCell(this.createCollection_bx3ota_a0a(editorContext, node));
    editorCell.addEditorCell(this.createCollection_bx3ota_b0a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_bx3ota_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
    editorCell.setCellId("Collection_bx3ota_a0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createConstant_bx3ota_a0a0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_bx3ota_b0a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(editorContext, node);
    editorCell.setCellId("Collection_bx3ota_b0a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createJComponent_bx3ota_a1a0(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_bx3ota_a0a0(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "Broken references:");
    editorCell.setCellId("Constant_bx3ota_a0a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.pink);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createJComponent_bx3ota_a1a0(EditorContext editorContext, SNode node) {
    EditorCell editorCell = EditorCell_Component.createComponentCell(editorContext, node, BaseConcept_brokenRefs._QueryFunction_JComponent_bx3ota_a0b0a(node, editorContext), "_bx3ota_a1a0");
    editorCell.setCellId("JComponent_bx3ota_a1a0");
    return editorCell;
  }

  private static boolean renderingCondition_bx3ota_a0a(SNode node, EditorContext editorContext, IScope scope) {
    return Sequence.fromIterable(((Iterable<SReference>) node.getReferencesIterable())).any(new IWhereFilter<SReference>() {
      public boolean accept(SReference ref) {
        return ref.getTargetNode() == null;
      }
    });
  }

  private static JComponent _QueryFunction_JComponent_bx3ota_a0b0a(final SNode node, final EditorContext editorContext) {
    String txt = Sequence.fromIterable(((Iterable<SReference>) node.getReferencesIterable())).where(new IWhereFilter<SReference>() {
      public boolean accept(SReference ref) {
        return ref.getTargetNode() == null;
      }
    }).foldLeft(new StringBuffer(), new ILeftCombinator<SReference, StringBuffer>() {
      public StringBuffer combine(StringBuffer sb, SReference ref) {
        sb = sb.append(ref.getRole()).append("\n      model ref: ").append(ref.getTargetSModelReference().toString());
        sb = sb.append("\n         nodeId: ").append(ref.getTargetNodeId());
        sb = (ref.getResolveInfo() != null ?
          sb.append("\n    resolveInfo: \"").append(ref.getResolveInfo()).append("\"\n") :
          sb.append("\n no resolveInfo\n")
        );
        return sb;
      }
    }).toString();
    JTextArea ta = new JTextArea(txt);
    Font font = EditorSettings.getInstance().getDefaultEditorFont();
    if (font != null) {
      ta.setFont(font);
    }
    ta.setBackground(Color.PINK);
    return ta;
  }
}
