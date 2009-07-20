package jetbrains.mps.lang.editor.editorTest.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InspectorBlock extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.editor.editorTest.structure.InspectorBlock";
  public static final String BLOCK = "block";

  public InspectorBlock(SNode node) {
    super(node);
  }

  public IBaseTestBlock getBlock() {
    return (IBaseTestBlock)this.getChild(IBaseTestBlock.class, InspectorBlock.BLOCK);
  }

  public void setBlock(IBaseTestBlock node) {
    super.setChild(InspectorBlock.BLOCK, node);
  }


  public static InspectorBlock newInstance(SModel sm, boolean init) {
    return (InspectorBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.editorTest.structure.InspectorBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InspectorBlock newInstance(SModel sm) {
    return InspectorBlock.newInstance(sm, false);
  }

}
