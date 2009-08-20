package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ModuleCycle extends BaseConcept {
  public static final String concept = "jetbrains.mps.build.packaging.structure.ModuleCycle";
  public static final String MODULE_REFERENCE = "moduleReference";

  public ModuleCycle(SNode node) {
    super(node);
  }


  public int getModuleReferencesCount() {
    return this.getChildCount(ModuleCycle.MODULE_REFERENCE);
  }

  public Iterator<NewModuleReference> moduleReferences() {
    return this.children(NewModuleReference.class, ModuleCycle.MODULE_REFERENCE);
  }

  public List<NewModuleReference> getModuleReferences() {
    return this.getChildren(NewModuleReference.class, ModuleCycle.MODULE_REFERENCE);
  }

  public void addModuleReference(NewModuleReference node) {
    this.addChild(ModuleCycle.MODULE_REFERENCE, node);
  }

  public void insertModuleReference(NewModuleReference prev, NewModuleReference node) {
    this.insertChild(prev, ModuleCycle.MODULE_REFERENCE, node);
  }

  public static ModuleCycle newInstance(SModel sm, boolean init) {
    return (ModuleCycle)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.ModuleCycle", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ModuleCycle newInstance(SModel sm) {
    return ModuleCycle.newInstance(sm, false);
  }
}
