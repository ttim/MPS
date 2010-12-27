package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseKeymapChanges;
import com.intellij.openapi.actionSystem.Shortcut;
import com.intellij.openapi.actionSystem.KeyboardShortcut;
import javax.swing.KeyStroke;

public class Mac_KeymapChanges extends BaseKeymapChanges {
  public Mac_KeymapChanges() {
    // simple 
    addSimpleShortcut("jetbrains.mps.ide.actions.End_Action", getShortcut(" END"), getShortcut("meta RIGHT"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GenerationIntentions_Action", getShortcut("ctrl N"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark0_Action", getShortcut("ctrl 0"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark1_Action", getShortcut("ctrl 1"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark2_Action", getShortcut("ctrl 2"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark3_Action", getShortcut("ctrl 3"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark4_Action", getShortcut("ctrl 4"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark5_Action", getShortcut("ctrl 5"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark6_Action", getShortcut("ctrl 6"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark7_Action", getShortcut("ctrl 7"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark8_Action", getShortcut("ctrl 8"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToBookmark9_Action", getShortcut("ctrl 9"));
    addSimpleShortcut("jetbrains.mps.ide.actions.GoToDevkit_Action", getShortcut("ctrl alt shift E"));
    addSimpleShortcut("jetbrains.mps.ide.actions.Home_Action", getShortcut(" HOME"), getShortcut("meta LEFT"));
    addSimpleShortcut("jetbrains.mps.ide.actions.LocalEnd_Action", getShortcut("alt RIGHT"));
    addSimpleShortcut("jetbrains.mps.ide.actions.LocalHome_Action", getShortcut("alt LEFT"));
    addSimpleShortcut("jetbrains.mps.ide.actions.QuickCreate_Action", getShortcut("ctrl N"), getShortcut("ctrl ENTER"));
    addSimpleShortcut("jetbrains.mps.ide.actions.SelectDown_Action", getShortcut("ctrl DOWN"), getShortcut("ctrl shift W"));
    addSimpleShortcut("jetbrains.mps.ide.actions.SelectLocalEnd_Action", getShortcut("alt shift RIGHT"));
    addSimpleShortcut("jetbrains.mps.ide.actions.SelectLocalHome_Action", getShortcut("alt shift LEFT"));
    addSimpleShortcut("jetbrains.mps.ide.actions.SelectUp_Action", getShortcut("ctrl UP"), getShortcut("ctrl W"));
    addSimpleShortcut("jetbrains.mps.ide.actions.ShowClassInHierarchy_Action", getShortcut("ctrl H"));
    addSimpleShortcut("jetbrains.mps.ide.actions.ShowConceptInHierarchy_Action", getShortcut("ctrl H"));
    addSimpleShortcut("jetbrains.mps.ide.actions.ShowNodeInfo_Action", getShortcut("ctrl Q"));
    // complex 
  }

  public String getScheme() {
    return "Mac OS X";
  }

  public static Shortcut getShortcut(String stroke) {
    return new KeyboardShortcut(KeyStroke.getKeyStroke(stroke), null);
  }
}
