package jetbrains.mps.samples.quickFixTest.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.quickfix.QuickFix_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.EditorContext;

public class setVarRef_QuickFix extends QuickFix_Runtime {
  public setVarRef_QuickFix() {
  }

  public void execute(SNode node) {
    SNode newVar = SConceptOperations.createNewNode("jetbrains.mps.samples.quickFixTest.structure.FooVariableReference", null);
    setVarRef_QuickFix.this.getField("newVar")[0] = newVar;
    SLinkOperations.setTarget(newVar, "fooVar", ((SNode) setVarRef_QuickFix.this.getField("target")[0]), false);
    SNodeOperations.replaceWithAnother(((SNode) setVarRef_QuickFix.this.getField("oldVar")[0]), newVar);
  }

  public void setSelection(SNode node, EditorContext editorContext) {
    editorContext.select(((SNode) setVarRef_QuickFix.this.getField("newVar")[0]));
  }
}
