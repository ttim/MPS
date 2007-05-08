package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;
import jetbrains.mps.baseLanguage.editor.OpenParenthesis_KeyMap_Action0;
import jetbrains.mps.baseLanguage.editor.OpenParenthesis_KeyMap_Action1;

public class OpenParenthesis_KeyMap extends EditorCellKeyMap {

  public  OpenParenthesis_KeyMap() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    this.putAction("ctrl+shift", "VK_LEFT", new OpenParenthesis_KeyMap_Action0());
    this.putAction("ctrl+shift", "VK_RIGHT", new OpenParenthesis_KeyMap_Action1());
  }
}
