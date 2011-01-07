package jetbrains.mps.lang.editor.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseKeymapChanges;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.openapi.actionSystem.KeyboardShortcut;
import javax.swing.KeyStroke;

public class Mac_KeymapChanges extends BaseKeymapChanges {
  public Mac_KeymapChanges() {
    // simple 
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.End_Action", getShortcut(" END"), getShortcut("meta RIGHT"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.Home_Action", getShortcut(" HOME"), getShortcut("meta LEFT"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.InsertBefore_Action", getShortcut("shift ENTER"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.Insert_Action", getShortcut(" ENTER"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.LocalEnd_Action", getShortcut("alt RIGHT"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.LocalHome_Action", getShortcut("alt LEFT"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.SelectDown_Action", getShortcut("ctrl DOWN"), getShortcut("ctrl shift W"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.SelectLocalEnd_Action", getShortcut("alt shift RIGHT"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.SelectLocalHome_Action", getShortcut("alt shift LEFT"));
    addSimpleShortcut("jetbrains.mps.lang.editor.plugin.SelectUp_Action", getShortcut("ctrl UP"), getShortcut("ctrl W"));
    // simple parameterized 
    // complex 
  }

  public String getScheme() {
    return "$default";
  }

  public static Shortcut getShortcut(String stroke) {
    return new KeyboardShortcut(KeyStroke.getKeyStroke(stroke), null);
  }
}
