package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.packaging.structure.Module;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NewModuleReference extends BaseConcept {
  public static final String concept = "jetbrains.mps.build.packaging.structure.NewModuleReference";
  public static final String MODULE = "module";

  public NewModuleReference(SNode node) {
    super(node);
  }

  public Module getModule() {
    return (Module)this.getReferent(Module.class, NewModuleReference.MODULE);
  }

  public void setModule(Module node) {
    super.setReferent(NewModuleReference.MODULE, node);
  }


  public static NewModuleReference newInstance(SModel sm, boolean init) {
    return (NewModuleReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.NewModuleReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NewModuleReference newInstance(SModel sm) {
    return NewModuleReference.newInstance(sm, false);
  }

}
