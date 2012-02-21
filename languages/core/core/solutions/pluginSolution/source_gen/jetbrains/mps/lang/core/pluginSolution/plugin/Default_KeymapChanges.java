package jetbrains.mps.lang.core.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseKeymapChanges;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.openapi.actionSystem.KeyboardShortcut;
import javax.swing.KeyStroke;

public class Default_KeymapChanges extends BaseKeymapChanges {
  public Default_KeymapChanges() {
    // simple 
    addSimpleShortcut("jetbrains.mps.lang.core.pluginSolution.plugin.FindModelUsages_Action", getShortcut("alt F7"));
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
