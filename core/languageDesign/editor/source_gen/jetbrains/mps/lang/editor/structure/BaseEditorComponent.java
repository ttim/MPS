package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.editor.structure.EditorCellModel;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BaseEditorComponent extends jetbrains.mps.lang.editor.structure.AbstractComponent {
  public static final String concept = "jetbrains.mps.lang.editor.structure.BaseEditorComponent";
  public static final String CELL_MODEL = "cellModel";

  public BaseEditorComponent(SNode node) {
    super(node);
  }

  public jetbrains.mps.lang.editor.structure.EditorCellModel getCellModel() {
    return (jetbrains.mps.lang.editor.structure.EditorCellModel)this.getChild(EditorCellModel.class, BaseEditorComponent.CELL_MODEL);
  }

  public void setCellModel(jetbrains.mps.lang.editor.structure.EditorCellModel node) {
    super.setChild(BaseEditorComponent.CELL_MODEL, node);
  }


  public static BaseEditorComponent newInstance(SModel sm, boolean init) {
    return (BaseEditorComponent)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.BaseEditorComponent", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BaseEditorComponent newInstance(SModel sm) {
    return BaseEditorComponent.newInstance(sm, false);
  }

}
