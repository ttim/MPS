package jetbrains.mps.quickQueryLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import javax.swing.Icon;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.ui.content.ContentManager;
import com.intellij.ui.content.Content;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.quickQueryLanguage.runtime.Query;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.ide.findusages.view.icons.IconManager;
import javax.swing.JComponent;

public class RunReplacement_Tool extends GeneratedTool {
  private static final Icon ICON = null;

  private List<ReplacementView> myViews = ListSequence.fromList(new ArrayList<ReplacementView>());

  public RunReplacement_Tool(Project project) {
    super(project, "Replacement", -1, ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public void closeTab(ReplacementView view) {
    view.dispose();
    int index = ListSequence.fromList(RunReplacement_Tool.this.myViews).indexOf(view);
    ListSequence.fromList(RunReplacement_Tool.this.myViews).removeElement(view);
    RunReplacement_Tool.this.closeTab(index);
  }

  private void closeTab(int index) {
    ContentManager manager = RunReplacement_Tool.this.getContentManager();
    Content content = manager.getContent(index);
    assert content != null;
    manager.removeContent(content, true);
  }

  public void addTab(final SearchQuery searchQuery, final Query query) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ReplacementView view = new ReplacementView(RunReplacement_Tool.this, RunReplacement_Tool.this.getProject(), FindUtils.makeProvider(new QueryFinder(query)), searchQuery, query);
        ListSequence.fromList(RunReplacement_Tool.this.myViews).addElement(view);
        String name = "Query ";
        if (ListSequence.fromList(RunReplacement_Tool.this.myViews).count() > 1) {
          name += String.valueOf(ListSequence.fromList(RunReplacement_Tool.this.myViews).count());
        }
        Content content = RunReplacement_Tool.this.addContent(view.getComponent(), name, IconManager.getIconForIHolder(searchQuery.getObjectHolder()), false);
        RunReplacement_Tool.this.setAvailable(true);
        RunReplacement_Tool.this.openTool(true);
        RunReplacement_Tool.this.getContentManager().setSelectedContent(content);
      }
    });
  }

  public JComponent getComponent() {
    return null;
  }
}
