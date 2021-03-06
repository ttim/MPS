package jetbrains.mps.lang.textGen.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NodeParameter extends AbstractTextGenParameter {
  public static final String concept = "jetbrains.mps.lang.textGen.structure.NodeParameter";

  public NodeParameter(SNode node) {
    super(node);
  }

  public static NodeParameter newInstance(SModel sm, boolean init) {
    return (NodeParameter) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.textGen.structure.NodeParameter", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NodeParameter newInstance(SModel sm) {
    return NodeParameter.newInstance(sm, false);
  }
}
