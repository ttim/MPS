package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellKeyMap_FunctionParm_keyEvent extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellKeyMap_FunctionParm_keyEvent";

  public CellKeyMap_FunctionParm_keyEvent(SNode node) {
    super(node);
  }

  public static CellKeyMap_FunctionParm_keyEvent newInstance(SModel sm, boolean init) {
    return (CellKeyMap_FunctionParm_keyEvent)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellKeyMap_FunctionParm_keyEvent", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellKeyMap_FunctionParm_keyEvent newInstance(SModel sm) {
    return CellKeyMap_FunctionParm_keyEvent.newInstance(sm, false);
  }

}
