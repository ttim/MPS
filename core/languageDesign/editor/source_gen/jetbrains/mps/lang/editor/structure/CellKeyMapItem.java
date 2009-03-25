package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.editor.structure.CellKeyMapCaretPolicy;
import jetbrains.mps.lang.editor.structure.CellKeyMap_IsApplicableFunction;
import jetbrains.mps.lang.editor.structure.CellKeyMap_ExecuteFunction;
import java.util.Iterator;
import jetbrains.mps.lang.editor.structure.CellKeyMapKeystroke;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellKeyMapItem extends jetbrains.mps.lang.core.structure.BaseConcept {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellKeyMapItem";
  public static final String DESCRIPTION = "description";
  public static final String SHOW_IN_POPUP = "showInPopup";
  public static final String MENU_ALWAYS_SHOWN = "menuAlwaysShown";
  public static final String CARET_POLICY = "caretPolicy";
  public static final String IS_APPLICABLE_FUNCTION = "isApplicableFunction";
  public static final String EXECUTE_FUNCTION = "executeFunction";
  public static final String KEYSTROKE = "keystroke";

  public CellKeyMapItem(SNode node) {
    super(node);
  }

  public String getDescription() {
    return this.getProperty(CellKeyMapItem.DESCRIPTION);
  }

  public void setDescription(String value) {
    this.setProperty(CellKeyMapItem.DESCRIPTION, value);
  }

  public boolean getShowInPopup() {
    return this.getBooleanProperty(CellKeyMapItem.SHOW_IN_POPUP);
  }

  public void setShowInPopup(boolean value) {
    this.setBooleanProperty(CellKeyMapItem.SHOW_IN_POPUP, value);
  }

  public boolean getMenuAlwaysShown() {
    return this.getBooleanProperty(CellKeyMapItem.MENU_ALWAYS_SHOWN);
  }

  public void setMenuAlwaysShown(boolean value) {
    this.setBooleanProperty(CellKeyMapItem.MENU_ALWAYS_SHOWN, value);
  }

  public CellKeyMapCaretPolicy getCaretPolicy() {
    String value = super.getProperty(CellKeyMapItem.CARET_POLICY);
    return CellKeyMapCaretPolicy.parseValue(value);
  }

  public void setCaretPolicy(CellKeyMapCaretPolicy value) {
    super.setProperty(CellKeyMapItem.CARET_POLICY, value.getValueAsString());
  }

  public jetbrains.mps.lang.editor.structure.CellKeyMap_IsApplicableFunction getIsApplicableFunction() {
    return (jetbrains.mps.lang.editor.structure.CellKeyMap_IsApplicableFunction)this.getChild(CellKeyMap_IsApplicableFunction.class, CellKeyMapItem.IS_APPLICABLE_FUNCTION);
  }

  public void setIsApplicableFunction(jetbrains.mps.lang.editor.structure.CellKeyMap_IsApplicableFunction node) {
    super.setChild(CellKeyMapItem.IS_APPLICABLE_FUNCTION, node);
  }

  public jetbrains.mps.lang.editor.structure.CellKeyMap_ExecuteFunction getExecuteFunction() {
    return (jetbrains.mps.lang.editor.structure.CellKeyMap_ExecuteFunction)this.getChild(CellKeyMap_ExecuteFunction.class, CellKeyMapItem.EXECUTE_FUNCTION);
  }

  public void setExecuteFunction(jetbrains.mps.lang.editor.structure.CellKeyMap_ExecuteFunction node) {
    super.setChild(CellKeyMapItem.EXECUTE_FUNCTION, node);
  }

  public int getKeystrokesCount() {
    return this.getChildCount(CellKeyMapItem.KEYSTROKE);
  }

  public Iterator<jetbrains.mps.lang.editor.structure.CellKeyMapKeystroke> keystrokes() {
    return this.children(CellKeyMapKeystroke.class, CellKeyMapItem.KEYSTROKE);
  }

  public List<jetbrains.mps.lang.editor.structure.CellKeyMapKeystroke> getKeystrokes() {
    return this.getChildren(CellKeyMapKeystroke.class, CellKeyMapItem.KEYSTROKE);
  }

  public void addKeystroke(jetbrains.mps.lang.editor.structure.CellKeyMapKeystroke node) {
    this.addChild(CellKeyMapItem.KEYSTROKE, node);
  }

  public void insertKeystroke(jetbrains.mps.lang.editor.structure.CellKeyMapKeystroke prev, jetbrains.mps.lang.editor.structure.CellKeyMapKeystroke node) {
    this.insertChild(prev, CellKeyMapItem.KEYSTROKE, node);
  }


  public static CellKeyMapItem newInstance(SModel sm, boolean init) {
    return (CellKeyMapItem)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellKeyMapItem", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellKeyMapItem newInstance(SModel sm) {
    return CellKeyMapItem.newInstance(sm, false);
  }

}
