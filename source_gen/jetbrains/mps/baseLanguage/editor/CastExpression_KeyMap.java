package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS 19.10.2006 16:35:54 */

import jetbrains.mps.nodeEditor.EditorCellKeyMap;
import jetbrains.mps.nodeEditor.EditorCellKeyMapAction;

public class CastExpression_KeyMap extends EditorCellKeyMap {

  public  CastExpression_KeyMap() {
    this.setApplicableToEveryModel(false);
    EditorCellKeyMapAction action;
    this.putAction("ctrl+shift", "VK_SPACE", new CastExpression_KeyMap_Action0());
  }
}
