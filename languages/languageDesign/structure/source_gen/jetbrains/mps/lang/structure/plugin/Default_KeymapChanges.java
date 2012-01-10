package jetbrains.mps.lang.structure.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseKeymapChanges;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.openapi.actionSystem.KeyboardShortcut;
import javax.swing.KeyStroke;

public class Default_KeymapChanges extends BaseKeymapChanges {
  public Default_KeymapChanges() {
    // simple 
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.MoveConcepts_Action", getShortcut(" F6"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.MoveLinkUp_Action", getShortcut(" F6"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.MoveProperyUp_Action", getShortcut(" F6"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.RenameConcept_Action", getShortcut("shift F6"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.RenameLink_Action", getShortcut("shift F6"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.RenameProperty_Action", getShortcut("shift F6"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.SafeDeleteConcept_Action", getShortcut("alt DELETE"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.SafeDeleteLink_Action", getShortcut("alt DELETE"));
    addSimpleShortcut("jetbrains.mps.lang.structure.plugin.ShowDefaultHelp_Action", getShortcut(" F1"));
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
