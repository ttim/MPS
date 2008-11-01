package jetbrains.mps.lang.pattern.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;
import java.awt.event.KeyEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.lang.pattern.util.PatternAddingUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.pattern.structure.AsPattern_AnnotationLink;
import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.pattern.structure.AsPattern;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.PropertyAccessor;
import jetbrains.mps.lang.pattern.structure.ListPattern;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.quotation.structure.Antiquotation_AnnotationLink;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.lang.quotation.structure.ListAntiquotation;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation_AnnotationLink;
import jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation;

public class _PatternExpression_KeyMap extends EditorCellKeyMap {

  public _PatternExpression_KeyMap() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action0();
    this.putAction("any", "_", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action1();
    this.putAction("any", "@", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action2();
    this.putAction("any", "#", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action3();
    this.putAction("any", "$", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action4();
    this.putAction("any", "*", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action5();
    this.putAction("any", "%", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action6();
    this.putAction("any", "*", action);
    action = new _PatternExpression_KeyMap._PatternExpression_KeyMap_Action7();
    this.putAction("any", "^", action);
  }
  public static class _PatternExpression_KeyMap_Action0 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action0() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "create wildcard";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return PatternAddingUtil.isPatternApplicable(editorContext);
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      node.setAttribute(SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.pattern.structure.WildcardPattern", null));
    }

    public String getKeyStroke() {
      return " _";
    }

}
  public static class _PatternExpression_KeyMap_Action1 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action1() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "create as-pattern";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return PatternAddingUtil.isPatternApplicable(editorContext);
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      AsPattern_AnnotationLink.setAsPattern((BaseConcept)((BaseConcept)SNodeOperations.getAdapter(node)), ((AsPattern)SNodeOperations.getAdapter(SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.pattern.structure.AsPattern", null))));
    }

    public String getKeyStroke() {
      return " @";
    }

}
  public static class _PatternExpression_KeyMap_Action2 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action2() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "create variable pattern";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return PatternAddingUtil.isPatternApplicable(editorContext);
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      PatternAddingUtil.addVariablePattern(editorContext);
    }

    public String getKeyStroke() {
      return " #";
    }

}
  public static class _PatternExpression_KeyMap_Action3 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action3() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "create property var pattern";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return (editorContext.getSelectedCell() instanceof EditorCell_Property) && PatternAddingUtil.isPatternApplicable(editorContext);
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      EditorCell_Property cell = (EditorCell_Property)editorContext.getSelectedCell();
      String propertyName = ((PropertyAccessor)cell.getModelAccessor()).getPropertyName();
      node.setPropertyAttribute(propertyName, SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.pattern.structure.PropertyPatternVariableDeclaration", null));
    }

    public String getKeyStroke() {
      return " $";
    }

}
  public static class _PatternExpression_KeyMap_Action4 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action4() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "create list pattern";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return PatternAddingUtil.isPatternApplicable(editorContext) && SNodeOperations.getParent(node) != null;
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      List<SNode> siblings = SNodeOperations.getAllSiblings(node, false);
      AsPattern_AnnotationLink.setAsPattern((BaseConcept)((BaseConcept)SNodeOperations.getAdapter(node)), ((ListPattern)SNodeOperations.getAdapter(SModelOperations.createNewNode(SNodeOperations.getModel(node), "jetbrains.mps.lang.pattern.structure.ListPattern", null))));
      for(SNode sibling : siblings) {
        SNodeOperations.deleteNode(sibling);
      }
    }

    public String getKeyStroke() {
      return " *";
    }

}
  public static class _PatternExpression_KeyMap_Action5 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action5() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "antiquotation";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return true;
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      SNode contextNode = editorContext.getSelectedCell().getSNode();
      if (contextNode == null) {
        return;
      }
      if (SNodeOperations.isInstanceOf(contextNode, "jetbrains.mps.lang.annotations.structure.AttributeConcept")) {
        SNode attributedNode = SLinkOperations.getTarget((contextNode), "attributedNode", false);
        attributedNode.setAttribute(null);
        return;
      }
      SModel model = SNodeOperations.getModel(contextNode);
      if (Antiquotation_AnnotationLink.getAntiquotation(((BaseConcept)SNodeOperations.getAdapter(contextNode))) != null) {
        contextNode.setAttribute(null);
      } else
      contextNode.setAttribute(SModelOperations.createNewNode(model, "jetbrains.mps.lang.quotation.structure.Antiquotation", null));
    }

    public String getKeyStroke() {
      return " %";
    }

}
  public static class _PatternExpression_KeyMap_Action6 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action6() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "list antiquotation";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return true;
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      SNode contextNode = editorContext.getSelectedCell().getSNode();
      if (contextNode == null) {
        return;
      }
      if (SNodeOperations.isInstanceOf(contextNode, "jetbrains.mps.lang.quotation.structure.ListAntiquotation")) {
        SNode attributedNode = SNodeOperations.getParent(contextNode);
        assert attributedNode != null;
        attributedNode.setAttribute(null);
        return;
      }
      SModel model = SNodeOperations.getModel(contextNode);
      if (BaseAdapter.isInstance(contextNode.getAttribute(), ListAntiquotation.class)) {
        contextNode.setAttribute(null);
      } else
      contextNode.setAttribute(SModelOperations.createNewNode(model, "jetbrains.mps.lang.quotation.structure.ListAntiquotation", null));
    }

    public String getKeyStroke() {
      return " *";
    }

}
  public static class _PatternExpression_KeyMap_Action7 extends EditorCellKeyMapAction {

    public _PatternExpression_KeyMap_Action7() {
      this.setShownInPopupMenu(false);
    }

    public String getDescriptionText() {
      return "reference antiquotation";
    }

    public boolean isMenuAlwaysShown() {
      return false;
    }

    public boolean canExecute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      if ((contextCell == null)) {
        return false;
      }
      SNode contextNode = contextCell.getSNode();
      if (contextNode == null) {
        return false;
      }
      return this.canExecute_internal(keyEvent, editorContext, contextNode, this.getSelectedNodes(editorContext));
    }

    public void execute(final KeyEvent keyEvent, final EditorContext editorContext) {
      EditorCell contextCell = editorContext.getContextCell();
      this.execute_internal(keyEvent, editorContext, contextCell.getSNode(), this.getSelectedNodes(editorContext));
    }

    private boolean canExecute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      return true;
    }

    private void execute_internal(final KeyEvent keyEvent, final EditorContext editorContext, final SNode node, final List<SNode> selectedNodes) {
      EditorCell selectedCell = editorContext.getSelectedCell();
      SNode contextNode = selectedCell.getSNode();
      SNode linkNode = BaseAdapter.fromAdapter(selectedCell.getLinkDeclaration());
      if (!(BaseAdapter.isInstance(linkNode, LinkDeclaration.class))) {
        return;
      }
      if (contextNode == null) {
        return;
      }
      SNode link = linkNode;
      if (SPropertyOperations.hasValue(link, "metaClass", "aggregation", "reference")) {
        return;
      }
      String role = SPropertyOperations.getString(link, "role");
      if (SNodeOperations.isInstanceOf(contextNode, "jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation")) {
        SNode attributedNode = SNodeOperations.getParent(contextNode);
        assert attributedNode != null;
        ReferenceAntiquotation_AnnotationLink.setReferenceAntiquotation(((BaseConcept)SNodeOperations.getAdapter(attributedNode)), role, null);
        attributedNode.setAttribute(null);
        return;
      }
      SModel model = SNodeOperations.getModel(contextNode);
      if (ReferenceAntiquotation_AnnotationLink.getReferenceAntiquotation(((BaseConcept)SNodeOperations.getAdapter(contextNode)), role) != null) {
        ReferenceAntiquotation_AnnotationLink.setReferenceAntiquotation(((BaseConcept)SNodeOperations.getAdapter(contextNode)), role, null);
      } else
      {
        ReferenceAntiquotation_AnnotationLink.setReferenceAntiquotation(((BaseConcept)SNodeOperations.getAdapter(contextNode)), role, ((ReferenceAntiquotation)SNodeOperations.getAdapter(SModelOperations.createNewNode(model, "jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation", null))));
      }
    }

    public String getKeyStroke() {
      return " ^";
    }

}

}
