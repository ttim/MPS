package jetbrains.mps.baseLanguage.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import jetbrains.mps.project.MPSProject;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class TodoViewer_Tool extends GeneratedTool {
  private static final Icon ICON = loadIcon();
  protected static Log log = LogFactory.getLog(TodoViewer_Tool.class);

  private TodoViewer myComponent;

  public TodoViewer_Tool(Project project) {
    super(project, "TODO", -1, ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public void init(Project project) {
    super.init(project);
    TodoViewer_Tool.this.myComponent = new TodoViewer(project.getComponent(MPSProject.class), TodoViewer_Tool.this);
  }

  public void dispose() {
    Container container = TodoViewer_Tool.this.myComponent.getParent();
    if (container != null) {
      container.remove(TodoViewer_Tool.this.myComponent);
    }
    TodoViewer_Tool.this.myComponent.dispose();
    TodoViewer_Tool.this.myComponent = null;
    super.dispose();
  }

  public JComponent getComponent() {
    return TodoViewer_Tool.this.myComponent;
  }

  private static Icon loadIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(TodoViewer_Tool.class.getResource("todo.png"))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for TodoViewer", e);
      }
      return null;
    }
  }
}
