package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorMessageIconRenderer;
import jetbrains.mps.plugins.MacrosUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import com.intellij.openapi.actionSystem.AnAction;

public class OverridingMethodEditorMessage extends AbstractOverrideEditorMessage {
  private static EditorMessageIconRenderer.IconRendererType TYPE = new EditorMessageIconRenderer.IconRendererType(1);
  private static String myOverridingIconPath = MacrosUtil.expandPath("${language_descriptor}/icons/gutter/overridingMethod.png", "jetbrains.mps.baseLanguage");
  private static String myImplementingIconPath = MacrosUtil.expandPath("${language_descriptor}/icons/gutter/implementingMethod.png", "jetbrains.mps.baseLanguage");

  private boolean isOverriding;

  public OverridingMethodEditorMessage(SNode node, EditorMessageOwner ovner, String tooltip, boolean overriding) {
    super(node, ovner, tooltip);
    this.isOverriding = overriding;
  }

  public Icon getIcon() {
    return IconManager.loadIcon((this.isOverriding ?
      myOverridingIconPath :
      myImplementingIconPath
    ), true);
  }

  public EditorMessageIconRenderer.IconRendererType getType() {
    return TYPE;
  }

  public AnAction getClickAction() {
    return null;
  }
}
