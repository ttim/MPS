package jetbrains.mps.workbench.dialogs.newproject;

import com.intellij.ide.BrowserUtil;
import com.intellij.ide.wizard.CommitStepException;
import com.intellij.ide.wizard.StepAdapter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public abstract class BaseStep extends StepAdapter {
  private JPanel myComponent;

  public BaseStep() {
    GridBagLayout bagLayout = new GridBagLayout();
    myComponent = new JPanel(bagLayout);

    JComponent controlComponent = createControlComponent();

    JPanel imagePanel = createImagePanel();
    GridBagConstraints cImage = new GridBagConstraints(0, 0, 1, 2, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
    myComponent.add(imagePanel, cImage);

    JPanel commentPanel = createCommentPanel();
    GridBagConstraints cComment = new GridBagConstraints(1, 0, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    myComponent.add(commentPanel, cComment);

    Border outerBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
    Border innerBorder = BorderFactory.createEmptyBorder(3, 3, 3, 3);
    Border border = BorderFactory.createCompoundBorder(outerBorder, innerBorder);
    controlComponent.setBorder(border);
    GridBagConstraints cControl = new GridBagConstraints(1, 1, 1, 1, 1, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0);
    myComponent.add(controlComponent, cControl);

    GridBagConstraints cFillY = new GridBagConstraints(0, 2, 2, 1, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    JPanel yFillPanel = new JPanel();
    myComponent.add(yFillPanel, cFillY);

    int w = controlComponent.getPreferredSize().width + (imagePanel.getPreferredSize().width);
    int h = Math.max(300, imagePanel.getPreferredSize().height);
    myComponent.setPreferredSize(new Dimension(w, h));
  }

  private JPanel createCommentPanel() {
    GridBagLayout bagLayout = new GridBagLayout();
    JPanel commentPanel = new JPanel(bagLayout);
    commentPanel.setBorder(BorderFactory.createEmptyBorder(0, 3, 6, 3));

    String comment = getCommentString();
    JLabel commentLabel = new JLabel("<html>" + comment + "</html>");
    GridBagConstraints cComment = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
    commentPanel.add(commentLabel, cComment);

    if (comment != null) {
      final String url = getURL();
      if (url != null) {
        JLabel aLabel = new JLabel("<html><a href=\"\">Read more</a></html>");
        aLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        aLabel.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            launchBrowserAction(url, "");
          }
        });
        GridBagConstraints cAnchor = new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
        commentPanel.add(aLabel, cAnchor);
      }
    }

    return commentPanel;
  }

  private JPanel createImagePanel() {
    URL imageUrl = getImageURL();
    String imageText = getImageText();

    JLabel imageComponent = imageUrl == null ? null : new JLabel();
    GridBagLayout bagLayout = new GridBagLayout();
    JPanel imagePanel = new JPanel(bagLayout);

    if (imageUrl != null) {
      GridBagConstraints cImage = new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0);
      ImageIcon info = new ImageIcon(imageUrl);

      BufferedImage bim = null;
      try {
        bim = ImageIO.read(imageUrl);
      } catch (IOException e) {
        /*should not happen*/
      }
      assert bim != null;
      Graphics graphics = bim.getGraphics();
      graphics.setColor(Color.BLACK);
      graphics.setFont(new Font("Helvetica", Font.BOLD, 18));
      int textWidth = graphics.getFontMetrics().charsWidth(imageText.toCharArray(), 0, imageText.length());
      int x = (info.getIconWidth() - textWidth) / 2;
      int y = info.getIconHeight() * 4 / 5;
      graphics.drawChars(imageText.toCharArray(), 0, imageText.length(), x, y);

      imageComponent.setIcon(new ImageIcon(bim));
      imagePanel.add(imageComponent, cImage);
    }

    return imagePanel;
  }

  private static void launchBrowserAction(String cmd, String prefix) {
    if (cmd != null && cmd.trim().length() > 0) {
      try {
        BrowserUtil.launchBrowser(prefix + cmd.trim());
      }
      catch (IllegalThreadStateException ex) {/* not a problem */}
    }
  }

  public final JComponent getComponent() {
    return myComponent;
  }

  public abstract JComponent createControlComponent();

  @Nullable
  public URL getImageURL() {
    return null;
  }

  @NotNull
  public String getImageText() {
    return "";
  }

  @Nullable
  public String getCommentString() {
    return null;
  }

  @Nullable
  public String getURL() {
    return null;
  }

  @Nullable
  public Icon getIcon() {
    return null;
  }

  @Override
  public void _commit(boolean finishChosen) throws CommitStepException {
    if (finishChosen) {
      _check();
    }
    super._commit(finishChosen);
  }

  public abstract void _check() throws CommitStepException;
}
