package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorMessageIconRenderer;
import jetbrains.mps.util.MacrosUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.ActionManager;

public class OverridenMethodEditorMessage extends AbstractOverrideEditorMessage {
  private static final EditorMessageIconRenderer.IconRendererType TYPE = new EditorMessageIconRenderer.IconRendererType(2);
  private static String myOverridenIconPath = MacrosUtil.expandPath("${language_descriptor}/icons/gutter/overridenMethod.png", "jetbrains.mps.baseLanguage");
  private static String myImplementedIconPath = MacrosUtil.expandPath("${language_descriptor}/icons/gutter/implementedMethod.png", "jetbrains.mps.baseLanguage");

  private boolean isOverriden;

  public OverridenMethodEditorMessage(SNode node, EditorMessageOwner ovner, String tooltip, boolean overriden) {
    super(node, ovner, tooltip);
    this.isOverriden = overriden;
  }

  public Icon getIcon() {
    return IconManager.loadIcon((this.isOverriden ?
      myOverridenIconPath :
      myImplementedIconPath
    ), true);
  }

  public EditorMessageIconRenderer.IconRendererType getType() {
    return TYPE;
  }

  public AnAction getClickAction() {
    return ActionManager.getInstance().getAction("jetbrains.mps.baseLanguage.pluginSolution.plugin.GoToOverridingMethod_Action#jetbrains.mps.baseLanguage.findUsages.DerivedMethods_Finder!");
  }
}
