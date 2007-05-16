package jetbrains.mps.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import jetbrains.mps.regexp.structure.RegexpDeclaration;
import java.util.List;

public class Regexps extends BaseConcept implements INamedConcept {
  public static String NAME = "name";
  public static String REGEXP = "regexp";

  public  Regexps(SNode node) {
    super(node);
  }

  public static Regexps newInstance(SModel sm, boolean init) {
    return (Regexps)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.Regexps", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Regexps newInstance(SModel sm) {
    return Regexps.newInstance(sm, false);
  }

  public String getName() {
    return this.getProperty(Regexps.NAME);
  }
  public void setName(String value) {
    this.setProperty(Regexps.NAME, value);
  }
  public int getRegexpsCount() {
    return this.getChildCount(Regexps.REGEXP);
  }
  public Iterator<RegexpDeclaration> regexps() {
    return this.children(Regexps.REGEXP);
  }
  public List<RegexpDeclaration> getRegexps() {
    return this.getChildren(Regexps.REGEXP);
  }
  public void addRegexp(RegexpDeclaration node) {
    this.addChild(Regexps.REGEXP, node);
  }
  public void insertRegexp(RegexpDeclaration prev, RegexpDeclaration node) {
    this.insertChild(prev, Regexps.REGEXP, node);
  }
}
