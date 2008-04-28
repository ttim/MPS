package jetbrains.mps.core.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelUID;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModelDescriptor;

public class AddMissingDependency_Intention extends BaseIntention implements Intention {

  public String getConcept() {
    return "jetbrains.mps.core.structure.BaseConcept";
  }

  public boolean isErrorIntention() {
    return true;
  }

  public String getDescription(SNode node, EditorContext editorContext) {
    IScope scope = editorContext.getScope();
    for(SReference ref : node.getReferences()) {
      SModelUID uid = ref.getTargetModelUID();
      if (scope.getModelDescriptor(uid) == null && GlobalScope.getInstance().getModelDescriptor(uid) != null) {
        SModelDescriptor sm = GlobalScope.getInstance().getModelDescriptor(uid);
        return "Add dependency on module " + sm.getModule();
      }
    }
    throw new RuntimeException();
  }

  public boolean isApplicable(SNode node, EditorContext editorContext) {
    IScope scope = editorContext.getScope();
    for(SReference ref : node.getReferences()) {
      SModelUID uid = ref.getTargetModelUID();
      if (scope.getModelDescriptor(uid) == null && GlobalScope.getInstance().getModelDescriptor(uid) != null) {
        return true;
      }
    }
    return false;
  }

  public void execute(SNode node, EditorContext editorContext) {
    IScope scope = editorContext.getScope();
    for(SReference ref : node.getReferences()) {
      SModelUID uid = ref.getTargetModelUID();
      if (scope.getModelDescriptor(uid) == null && GlobalScope.getInstance().getModelDescriptor(uid) != null) {
        SModelDescriptor sm = GlobalScope.getInstance().getModelDescriptor(uid);
        editorContext.getOperationContext().getModule().addDependency(sm.getModule().getModuleUID(), false);
      }
    }
  }

}
