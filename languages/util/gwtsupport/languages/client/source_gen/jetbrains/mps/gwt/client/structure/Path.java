package jetbrains.mps.gwt.client.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Path extends BaseConcept {
  public static final String concept = "jetbrains.mps.gwt.client.structure.Path";
  public static final String VALUE = "value";

  public Path(SNode node) {
    super(node);
  }

  public String getValue() {
    return this.getProperty(Path.VALUE);
  }

  public void setValue(String value) {
    this.setProperty(Path.VALUE, value);
  }

  public static Path newInstance(SModel sm, boolean init) {
    return (Path) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.gwt.client.structure.Path", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Path newInstance(SModel sm) {
    return Path.newInstance(sm, false);
  }
}
