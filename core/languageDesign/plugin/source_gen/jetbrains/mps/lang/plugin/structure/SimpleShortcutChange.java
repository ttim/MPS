package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SimpleShortcutChange extends BaseConcept implements ShortcutChange {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.SimpleShortcutChange";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ACTION = "action";
  public static final String KEYSTROKE = "keystroke";

  public SimpleShortcutChange(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(SimpleShortcutChange.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(SimpleShortcutChange.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(SimpleShortcutChange.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(SimpleShortcutChange.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(SimpleShortcutChange.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(SimpleShortcutChange.VIRTUAL_PACKAGE, value);
  }

  public ActionDeclaration getAction() {
    return (ActionDeclaration) this.getReferent(ActionDeclaration.class, SimpleShortcutChange.ACTION);
  }

  public void setAction(ActionDeclaration node) {
    super.setReferent(SimpleShortcutChange.ACTION, node);
  }

  public int getKeystrokesCount() {
    return this.getChildCount(SimpleShortcutChange.KEYSTROKE);
  }

  public Iterator<KeyMapKeystroke> keystrokes() {
    return this.children(KeyMapKeystroke.class, SimpleShortcutChange.KEYSTROKE);
  }

  public List<KeyMapKeystroke> getKeystrokes() {
    return this.getChildren(KeyMapKeystroke.class, SimpleShortcutChange.KEYSTROKE);
  }

  public void addKeystroke(KeyMapKeystroke node) {
    this.addChild(SimpleShortcutChange.KEYSTROKE, node);
  }

  public void insertKeystroke(KeyMapKeystroke prev, KeyMapKeystroke node) {
    this.insertChild(prev, SimpleShortcutChange.KEYSTROKE, node);
  }

  public static SimpleShortcutChange newInstance(SModel sm, boolean init) {
    return (SimpleShortcutChange) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.SimpleShortcutChange", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SimpleShortcutChange newInstance(SModel sm) {
    return SimpleShortcutChange.newInstance(sm, false);
  }
}
