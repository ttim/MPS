package jetbrains.mps.ui.swing.runtime;

/*Generated by MPS */

import org.jdesktop.swingx.JXTaskPane;

public class JXSingleTaskPane extends JXTaskPane {
  public JXSingleTaskPane() {
    super();
  }

  @Override
  public void setCollapsed(boolean collapsed) {
    JXSingleTaskPaneContainer cnt = (JXSingleTaskPaneContainer) this.getParent();
    if (cnt.proceedSetCollapsed(this, collapsed)) {
      super.setCollapsed(collapsed);
    }
  }

  @Override
  public String toString() {
    return "JXSingleTaskPane@" + this.hashCode();
  }
}
