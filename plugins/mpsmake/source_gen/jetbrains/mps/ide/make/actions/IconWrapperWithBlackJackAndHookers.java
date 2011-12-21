package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import javax.swing.JComponent;
import javax.swing.Icon;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.util.ui.UIUtil;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.Dimension;

public class IconWrapperWithBlackJackAndHookers extends JComponent {
  private Icon myIcon;
  private final StatusBarWidget.IconPresentation myPresentation;

  public IconWrapperWithBlackJackAndHookers(StatusBarWidget.IconPresentation presentation) {
    myPresentation = presentation;
    myIcon = myPresentation.getIcon();

    putClientProperty(UIUtil.CENTER_TOOLTIP, Boolean.TRUE);
    setToolTipText(myPresentation.getTooltipText());
    addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(final MouseEvent e) {
        myPresentation.getClickConsumer().consume(e);
      }
    });
    setOpaque(false);
  }

  public void update() {
    myIcon = myPresentation.getIcon();
  }

  @Override
  protected void paintComponent(Graphics graphics) {
    final Rectangle bounds = getBounds();
    final Insets insets = getInsets();
    if (myIcon != null) {
      final int iconWidth = myIcon.getIconWidth();
      final int iconHeight = myIcon.getIconHeight();
      myIcon.paintIcon(this, graphics, insets.left + (bounds.width - insets.left - insets.right - iconWidth) / 2, insets.top + (bounds.height - insets.top - insets.bottom - iconHeight) / 2);
    }
  }

  @Override
  public String getToolTipText() {
    return myPresentation.getTooltipText();
  }

  @Override
  public Dimension getMinimumSize() {
    return new Dimension(24, 18);
  }

  @Override
  public Dimension getPreferredSize() {
    return getMinimumSize();
  }
}
