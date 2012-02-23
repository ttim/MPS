package jetbrains.mps.lang.core.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.editor.runtime.AbstractLeftEditorHighlighterMessage;
import jetbrains.mps.nodeEditor.EditorMessageIconRenderer;
import jetbrains.mps.util.MacrosUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.workbench.action.BaseAction;
import com.intellij.openapi.actionSystem.ActionManager;
import javax.swing.JPopupMenu;

public class SuppressErrorsMessage extends AbstractLeftEditorHighlighterMessage {
  private static final EditorMessageIconRenderer.IconRendererType TYPE = new EditorMessageIconRenderer.IconRendererType(1);
  private static String ICON_PATH = MacrosUtil.expandPath("${language_descriptor}/icons/suppress.png", "jetbrains.mps.lang.core");

  public SuppressErrorsMessage(SNode node, EditorMessageOwner owner, String tooltip) {
    super(node, owner, tooltip);
  }

  public Icon getIcon() {
    return IconManager.loadIcon(ICON_PATH, true);
  }

  public EditorMessageIconRenderer.IconRendererType getType() {
    return TYPE;
  }

  public EditorCell getAnchorCell(EditorCell cell) {
    return cell;
  }

  public AnAction getClickAction() {
    return ((BaseAction) ActionManager.getInstance().getAction("jetbrains.mps.lang.core.pluginSolution.plugin.DoNotSuppressErrors_Action"));
  }

  public JPopupMenu getPopupMenu() {
    return null;
  }
}
