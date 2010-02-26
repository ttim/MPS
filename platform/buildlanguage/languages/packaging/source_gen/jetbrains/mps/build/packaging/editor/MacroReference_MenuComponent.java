package jetbrains.mps.build.packaging.editor;

/*Generated by MPS */

import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuComponent;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Group;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.build.packaging.behavior.IMacroHolder_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class MacroReference_MenuComponent extends AbstractCellMenuComponent {
  public MacroReference_MenuComponent() {
    super(new SubstituteInfoPart[]{new MacroReference_MenuComponent.MacroReference_generic_cellMenu_a0()});
  }

  public static class MacroReference_generic_cellMenu_a0 extends AbstractCellMenuPart_Generic_Group {
    public MacroReference_generic_cellMenu_a0() {
    }

    public List<?> createParameterObjects(SNode node, IScope scope, IOperationContext operationContext) {
      List<String> allMacroNames = IMacroHolder_Behavior.call_getAllMacroNames_1234975567387(SNodeOperations.getAncestor(node, "jetbrains.mps.build.packaging.structure.IMacroHolder", true, false), SConceptPropertyOperations.getBoolean(SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.build.packaging.structure.IPath"), "canStartFromBasedir"));
      ListSequence.fromList(allMacroNames).addElement("no macro");
      return allMacroNames;
    }

    public void handleAction(Object parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      this.handleAction_impl((String) parameterObject, node, model, scope, operationContext);
    }

    public void handleAction_impl(String parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      if (parameterObject.equals("no macro")) {
        SPropertyOperations.set(node, "name", "");
      } else {
        SPropertyOperations.set(node, "name", parameterObject);
      }
    }

    public boolean isReferentPresentation() {
      return false;
    }
  }
}
