package jetbrains.mps.workbench.dialogs.project.components.parts.renderers;

/*Generated by MPS */

import javax.swing.DefaultListCellRenderer;
import java.awt.Component;
import javax.swing.JList;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.vfs.VFileSystem;
import java.awt.Color;

public class StringPathRenderer extends DefaultListCellRenderer {
  public StringPathRenderer() {
  }

  public Component getListCellRendererComponent(JList list, final Object value, int index, boolean isSelected, boolean cellHasFocus) {
    String path = (String) value;
    Component result = super.getListCellRendererComponent(list, path, index, isSelected, cellHasFocus);
    if (path == null) {
      return result;
    }
    if (isSelected) {
      return result;
    }
    VirtualFile file = VFileSystem.getFile(path);
    if (file == null || !(file.exists())) {
      this.setForeground(Color.RED);
    }
    return result;
  }
}
