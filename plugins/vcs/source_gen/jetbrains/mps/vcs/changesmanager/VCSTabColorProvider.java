package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import jetbrains.mps.ide.tabbedEditor.TabColorProvider;
import java.util.Map;
import jetbrains.mps.ide.tabbedEditor.ILazyTab;
import java.util.HashMap;
import java.awt.Color;
import com.intellij.openapi.project.Project;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.vcs.FileStatus;
import jetbrains.mps.ide.tabbedEditor.AbstractLazyTab;
import jetbrains.mps.ide.tabbedEditor.tabs.BaseSingletabbedTab;
import jetbrains.mps.ide.tabbedEditor.tabs.BaseMultitabbedTab;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNodePointer;
import org.apache.commons.lang.ObjectUtils;

public class VCSTabColorProvider implements TabColorProvider {
  private Map<ILazyTab, NodeFileStatusListener> myTabListeners = new HashMap<ILazyTab, NodeFileStatusListener>();

  public VCSTabColorProvider() {
  }

  public Color getColor(Project project, ILazyTab tab) {
    RootNodeFileStatusManager statusManager = RootNodeFileStatusManager.getInstance(project);
    if (statusManager == null) {
      return Color.BLACK;
    }
    boolean hasNotChanged = false;
    boolean hasModified = false;
    boolean hasAdded = false;
    for (EditorComponent editorComponent : tab.getEditorComponents()) {
      SNode node = editorComponent.getEditedNode();
      if (node == null) {
        continue;
      }
      FileStatus status = statusManager.getStatus(node);
      if (status == FileStatus.ADDED) {
        hasAdded = true;
      } else
      if (status == FileStatus.MODIFIED) {
        hasModified = true;
      } else {
        hasNotChanged = true;
      }
    }
    FileStatus status = FileStatus.NOT_CHANGED;
    if (hasModified) {
      status = FileStatus.MODIFIED;
    } else
    if (hasAdded) {
      if (hasNotChanged) {
        status = FileStatus.MODIFIED;
      } else {
        status = FileStatus.ADDED;
      }
    }
    return status.getColor();
  }

  public void tabOpened(AbstractLazyTab tab) {
    RootNodeFileStatusManager statusManager = RootNodeFileStatusManager.getInstance(getTabProject(tab));
    if (statusManager == null) {
      return;
    }
    myTabListeners.put(tab, createFileStatusListener(tab));
    statusManager.addNodeFileStatusListener(myTabListeners.get(tab));
  }

  public void tabClosed(AbstractLazyTab tab) {
    RootNodeFileStatusManager statusManager = RootNodeFileStatusManager.getInstance(getTabProject(tab));
    if (statusManager == null) {
      return;
    }
    statusManager.removeNodeFileStatusListener(myTabListeners.remove(tab));
  }

  private Project getTabProject(AbstractLazyTab tab) {
    return tab.getTabbedEditor().getOperationContext().getProject();
  }

  protected NodeFileStatusListener createFileStatusListener(final AbstractLazyTab tab) {
    if (tab instanceof BaseSingletabbedTab) {
      final BaseSingletabbedTab st = (BaseSingletabbedTab) tab;
      return new VCSTabColorProvider.SingletabbedStatusListener(st);
    } else
    if (tab instanceof BaseMultitabbedTab) {
      return new VCSTabColorProvider.MultitabbedStatusListener(tab);
    } else
    throw new IllegalArgumentException("wrong tab type");
  }

  private void updateTabColor(int tabIndex, BaseMultitabbedTab mt) {
    RootNodeFileStatusManager statusManager = RootNodeFileStatusManager.getInstance(getTabProject(mt));
    if (statusManager == null) {
      return;
    }
    FileStatus fileStatus = statusManager.getStatus(mt.getEditorComponents().get(tabIndex).getEditedNode());
    if (fileStatus == null) {
      fileStatus = FileStatus.NOT_CHANGED;
    }
    Color color = fileStatus.getColor();
    if (color == null) {
      color = Color.BLACK;
    }
    mt.myInnerTabbedPane.setForegroundAt(tabIndex, color);
    mt.getTabbedEditor().updateTabColor(mt, mt.getBaseNodeVirtualFile());
  }

  private static class SingletabbedStatusListener implements NodeFileStatusListener {
    private final BaseSingletabbedTab mySt;

    public SingletabbedStatusListener(BaseSingletabbedTab st) {
      mySt = st;
    }

    public void fileStatusChanged(@NotNull final SNode node) {
      SNodePointer nodePointer = new SNodePointer(node);
      if (ObjectUtils.equals(mySt.getLoadableNodePointer(), nodePointer)) {
        mySt.getTabbedEditor().updateTabColor(mySt, mySt.getBaseNodeVirtualFile());
      }
    }
  }

  private class MultitabbedStatusListener implements NodeFileStatusListener {
    private final AbstractLazyTab myTab;

    public MultitabbedStatusListener(AbstractLazyTab tab) {
      myTab = tab;
    }

    public void fileStatusChanged(@NotNull final SNode node) {
      SNodePointer nodePointer = new SNodePointer(node);
      BaseMultitabbedTab mt = (BaseMultitabbedTab) myTab;
      if (mt.getLoadableNodePointers().contains(nodePointer)) {
        int index = mt.getIndexOfTabFor(nodePointer);
        assert index >= 0 : "tab for node not found";
        updateTabColor(index, mt);
      }
    }
  }
}
