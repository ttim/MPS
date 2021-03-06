package jetbrains.mps.ui.modeling.editor;

/*Generated by MPS */

import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuComponent;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_Generic_Item;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class VerticalAlignment_Chooser extends AbstractCellMenuComponent {
  public VerticalAlignment_Chooser() {
    super(new SubstituteInfoPart[]{new VerticalAlignment_Chooser.VerticalAlignment_generic_cellMenu_a0(), new VerticalAlignment_Chooser.VerticalAlignment_generic_cellMenu_b0(), new VerticalAlignment_Chooser.VerticalAlignment_generic_cellMenu_c0(), new VerticalAlignment_Chooser.VerticalAlignment_generic_cellMenu_d0()});
  }

  public static class VerticalAlignment_generic_cellMenu_a0 extends AbstractCellMenuPart_Generic_Item {
    public VerticalAlignment_generic_cellMenu_a0() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SPropertyOperations.set(node, "value", "TOP");
    }

    public String getMatchingText() {
      return "<-";
    }
  }

  public static class VerticalAlignment_generic_cellMenu_b0 extends AbstractCellMenuPart_Generic_Item {
    public VerticalAlignment_generic_cellMenu_b0() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SPropertyOperations.set(node, "value", "BOTTOM");
    }

    public String getMatchingText() {
      return "->";
    }
  }

  public static class VerticalAlignment_generic_cellMenu_c0 extends AbstractCellMenuPart_Generic_Item {
    public VerticalAlignment_generic_cellMenu_c0() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SPropertyOperations.set(node, "value", "MIDDLE");
    }

    public String getMatchingText() {
      return "-";
    }
  }

  public static class VerticalAlignment_generic_cellMenu_d0 extends AbstractCellMenuPart_Generic_Item {
    public VerticalAlignment_generic_cellMenu_d0() {
    }

    public void handleAction(SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SPropertyOperations.set(node, "value", "FILL");
    }

    public String getMatchingText() {
      return "<->";
    }
  }
}
