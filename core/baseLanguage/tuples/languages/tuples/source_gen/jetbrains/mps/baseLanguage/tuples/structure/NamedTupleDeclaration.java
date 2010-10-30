package jetbrains.mps.baseLanguage.tuples.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Classifier;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NamedTupleDeclaration extends Classifier {
  public static final String concept = "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration";
  public static final String CPR_LeftBracket = "leftBracket";
  public static final String CPR_RightBracket = "rightBracket";
  public static final String COMPONENT = "component";

  public NamedTupleDeclaration(SNode node) {
    super(node);
  }

  public int getComponentsCount() {
    return this.getChildCount(NamedTupleDeclaration.COMPONENT);
  }

  public Iterator<NamedTupleComponentDeclaration> components() {
    return this.children(NamedTupleComponentDeclaration.class, NamedTupleDeclaration.COMPONENT);
  }

  public List<NamedTupleComponentDeclaration> getComponents() {
    return this.getChildren(NamedTupleComponentDeclaration.class, NamedTupleDeclaration.COMPONENT);
  }

  public void addComponent(NamedTupleComponentDeclaration node) {
    this.addChild(NamedTupleDeclaration.COMPONENT, node);
  }

  public void insertComponent(NamedTupleComponentDeclaration prev, NamedTupleComponentDeclaration node) {
    this.insertChild(prev, NamedTupleDeclaration.COMPONENT, node);
  }

  public static NamedTupleDeclaration newInstance(SModel sm, boolean init) {
    return (NamedTupleDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NamedTupleDeclaration newInstance(SModel sm) {
    return NamedTupleDeclaration.newInstance(sm, false);
  }
}
