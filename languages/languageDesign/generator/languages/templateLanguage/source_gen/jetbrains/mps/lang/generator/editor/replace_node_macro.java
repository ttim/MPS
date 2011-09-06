package jetbrains.mps.lang.generator.editor;

/*Generated by MPS */

import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuComponent;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Group;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.action.SNodeFactoryOperations;
import jetbrains.mps.util.NameUtil;

public class replace_node_macro extends AbstractCellMenuComponent {
  public replace_node_macro() {
    super(new SubstituteInfoPart[]{new replace_node_macro.NodeMacro_generic_cellMenu_a0()});
  }

  public static class NodeMacro_generic_cellMenu_a0 extends AbstractCellMenuPart_Generic_Group {
    public NodeMacro_generic_cellMenu_a0() {
    }

    public List<?> createParameterObjects(SNode node, IScope scope, IOperationContext operationContext) {
      return ListSequence.fromList(SConceptOperations.getAllSubConcepts(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.generator.structure.NodeMacro"), SNodeOperations.getModel(node), scope)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return !(SConceptPropertyOperations.getBoolean(it, "abstract"));
        }
      }).toListSequence();
    }

    protected void handleAction(Object parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext, EditorContext editorContext) {
      this.handleAction_impl((SNode) parameterObject, node, model, scope, operationContext, editorContext);
    }

    public void handleAction_impl(SNode parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext, EditorContext editorContext) {
      SNode macro = SNodeFactoryOperations.createNewNode(NameUtil.nodeFQName(parameterObject), node);
      SNodeOperations.replaceWithAnother(node, macro);
      editorContext.selectAndSetCaret(macro, 1);
      editorContext.openInspector();
    }

    public boolean isReferentPresentation() {
      return false;
    }

    public String getMatchingText(Object parameterObject) {
      return this.getMatchingText_internal((SNode) parameterObject);
    }

    public String getMatchingText_internal(SNode parameterObject) {
      return SConceptPropertyOperations.getString(parameterObject, "alias");
    }

    public String getDescriptionText(Object parameterObject) {
      return this.getDescriptionText_internal((SNode) parameterObject);
    }

    public String getDescriptionText_internal(SNode parameterObject) {
      return SConceptPropertyOperations.getString(parameterObject, "alias");
    }
  }
}
