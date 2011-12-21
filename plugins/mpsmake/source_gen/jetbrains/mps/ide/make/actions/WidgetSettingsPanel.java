package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import javax.swing.border.EmptyBorder;
import jetbrains.mps.ide.common.LayoutUtil;
import com.intellij.ui.awt.RelativePoint;
import com.intellij.openapi.ui.popup.JBPopup;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.util.Computable;

/*package*/ class WidgetSettingsPanel extends JPanel {
  private final JCheckBox myShowPopupBox;
  private final JCheckBox myShowStatusBarIcon;

  public WidgetSettingsPanel() {
    super(new GridBagLayout());
    myShowPopupBox = new JCheckBox("Display popup on generation", SaveTransientModelsPreferences.isShowPopup());
    myShowStatusBarIcon = new JCheckBox("Show status bar icon", SaveTransientModelsPreferences.isShowStatusBarIcon());

    myShowPopupBox.setBorder(new EmptyBorder(2, 3, 0, 4));
    myShowStatusBarIcon.setBorder(new EmptyBorder(0, 2, 0, 4));

    add(myShowPopupBox, LayoutUtil.createFieldConstraints(1));
    add(myShowStatusBarIcon, LayoutUtil.createFieldConstraints(2));
  }

  public void showComponent(RelativePoint point) {
    final JBPopup popup = JBPopupFactory.getInstance().createComponentPopupBuilder(this, this).setRequestFocus(true).setMovable(true).setCancelCallback(new Computable<Boolean>() {
      public Boolean compute() {
        onClose();
        return Boolean.TRUE;
      }
    }).createPopup();
    popup.show(point);
  }

  private void onClose() {
    SaveTransientModelsPreferences.setShowPopup(myShowPopupBox.isSelected());
    SaveTransientModelsPreferences.setShowStatusBar(myShowStatusBarIcon.isSelected());
    TransientModelsWidgetInstaller.getInstaller().update();
  }
}
