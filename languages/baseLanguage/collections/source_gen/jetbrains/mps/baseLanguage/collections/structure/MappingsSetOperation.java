package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MappingsSetOperation extends MapOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.MappingsSetOperation";

  public MappingsSetOperation(SNode node) {
    super(node);
  }

  public static MappingsSetOperation newInstance(SModel sm, boolean init) {
    return (MappingsSetOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.MappingsSetOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MappingsSetOperation newInstance(SModel sm) {
    return MappingsSetOperation.newInstance(sm, false);
  }
}
