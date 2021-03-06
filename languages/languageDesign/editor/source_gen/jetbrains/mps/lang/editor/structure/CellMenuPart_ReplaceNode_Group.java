package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellMenuPart_ReplaceNode_Group extends CellMenuPart_AbstractGroup {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellMenuPart_ReplaceNode_Group";
  public static final String PARAMETERS_FUNCTION = "parametersFunction";
  public static final String CREATE_FUNCTION = "createFunction";

  public CellMenuPart_ReplaceNode_Group(SNode node) {
    super(node);
  }

  public CellMenuPart_AbstractGroup_Query getParametersFunction() {
    return (CellMenuPart_AbstractGroup_Query) this.getChild(CellMenuPart_AbstractGroup_Query.class, CellMenuPart_ReplaceNode_Group.PARAMETERS_FUNCTION);
  }

  public void setParametersFunction(CellMenuPart_AbstractGroup_Query node) {
    super.setChild(CellMenuPart_ReplaceNode_Group.PARAMETERS_FUNCTION, node);
  }

  public CellMenuPart_ReplaceNode_Group_Create getCreateFunction() {
    return (CellMenuPart_ReplaceNode_Group_Create) this.getChild(CellMenuPart_ReplaceNode_Group_Create.class, CellMenuPart_ReplaceNode_Group.CREATE_FUNCTION);
  }

  public void setCreateFunction(CellMenuPart_ReplaceNode_Group_Create node) {
    super.setChild(CellMenuPart_ReplaceNode_Group.CREATE_FUNCTION, node);
  }

  public static CellMenuPart_ReplaceNode_Group newInstance(SModel sm, boolean init) {
    return (CellMenuPart_ReplaceNode_Group) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellMenuPart_ReplaceNode_Group", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellMenuPart_ReplaceNode_Group newInstance(SModel sm) {
    return CellMenuPart_ReplaceNode_Group.newInstance(sm, false);
  }
}
