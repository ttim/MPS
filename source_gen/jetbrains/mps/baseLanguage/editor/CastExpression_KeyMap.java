package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS 04.04.2006 14:01:52 */


import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;

public class CastExpression_KeyMap extends EditorCellKeyMap {

  public CastExpression_KeyMap() {
    EditorCellKeyMapAction action;
    this.putAction("ctrl", "VK_DELETE", new CastExpression_KeyMap_Action0());
    this.putAction("ctrl+shift", "VK_SPACE", new CastExpression_KeyMap_Action1());
    this.putAction("ctrl+shift", "VK_SPACE", new CastExpression_KeyMap_Action2());
    this.putAction("ctrl+shift", "VK_SPACE", new CastExpression_KeyMap_Action3());
  }
}
