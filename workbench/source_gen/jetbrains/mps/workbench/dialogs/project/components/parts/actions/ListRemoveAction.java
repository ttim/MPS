package jetbrains.mps.workbench.dialogs.project.components.parts.actions;

/*Generated by MPS */

import javax.swing.JList;
import jetbrains.mps.workbench.dialogs.project.components.parts.actions.icons.Icons;
import com.intellij.openapi.actionSystem.AnActionEvent;

public abstract class ListRemoveAction extends BaseValidatedAction {
  private JList myList;

  public ListRemoveAction(JList list) {
    super("Remove", "Remove", Icons.REMOVE);
    myList = list;
  }

  @Override
  public void update(AnActionEvent e) {
    super.update(e);
    e.getPresentation().setEnabled(myList.getSelectedIndices().length != 0);
  }

  public final void doPerform(AnActionEvent e) {
    int index = myList.getSelectedIndex();
    for (int i : myList.getSelectedIndices()) {
      if (i < index) {
        index = i;
      }
    }
    this.doRemove(e);
    int listSize = myList.getModel().getSize();
    if (index >= listSize) {
      index--;
    } else
    if (index < 0 && listSize > 0) {
      index = 0;
    }
    if (index > -1) {
      myList.setSelectedIndex(index);
    }
  }

  protected abstract void doRemove(AnActionEvent e);
}
