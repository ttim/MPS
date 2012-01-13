package jetbrains.mps.execution.lib.ui;

/*Generated by MPS */

import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class IconContainer {
  protected static Icon ICON_a0d0a = loadIcon("showViewer.png");
  protected static Log log = LogFactory.getLog(IconContainer.class);

  private static Icon loadIcon(String filename) {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(IconContainer.class.getResource(filename))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for " + filename, e);
      }
      return null;
    }
  }
}
