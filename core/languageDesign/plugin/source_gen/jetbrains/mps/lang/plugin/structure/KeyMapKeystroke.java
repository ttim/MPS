package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class KeyMapKeystroke extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.KeyMapKeystroke";
  public static final String MODIFIERS = "modifiers";
  public static final String KEYCODE = "keycode";

  public KeyMapKeystroke(SNode node) {
    super(node);
  }

  public String getModifiers() {
    return this.getProperty(KeyMapKeystroke.MODIFIERS);
  }

  public void setModifiers(String value) {
    this.setProperty(KeyMapKeystroke.MODIFIERS, value);
  }

  public String getKeycode() {
    return this.getProperty(KeyMapKeystroke.KEYCODE);
  }

  public void setKeycode(String value) {
    this.setProperty(KeyMapKeystroke.KEYCODE, value);
  }


  public static KeyMapKeystroke newInstance(SModel sm, boolean init) {
    return (KeyMapKeystroke)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.KeyMapKeystroke", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static KeyMapKeystroke newInstance(SModel sm) {
    return KeyMapKeystroke.newInstance(sm, false);
  }

}
