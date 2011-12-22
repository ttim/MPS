package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.CustomStatusBarWidget;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.wm.StatusBar;
import javax.swing.Icon;
import org.jetbrains.annotations.Nullable;
import com.intellij.util.Consumer;
import java.awt.event.MouseEvent;
import jetbrains.mps.ide.generator.GenerationSettings;
import java.awt.Dimension;
import java.awt.Point;
import com.intellij.ui.awt.RelativePoint;
import javax.swing.UIManager;
import javax.swing.JComponent;

/*package*/ class TransientModelsWidget implements StatusBarWidget, CustomStatusBarWidget, StatusBarWidget.IconPresentation, StatusBarWidget.WidgetPresentation {
  public static final String WIDGET_ID = "TransientModelsWidget";

  @NotNull
  private final StatusBar myStatusBar;
  private final Icon myIcon = IconContainer.ICON_a1;
  private CustomIconWrapper myComponent;

  public TransientModelsWidget(StatusBar bar) {
    myStatusBar = bar;
    myComponent = new CustomIconWrapper(this);
  }

  public void install(@NotNull StatusBar bar) {
  }

  @Nullable
  public String getTooltipText() {
    if (isSaveTransientModels()) {
      return "Stop saving transient models.";
    }
    return "Save transient models.";
  }

  @Nullable
  public Consumer<MouseEvent> getClickConsumer() {
    return new Consumer<MouseEvent>() {
      public void consume(MouseEvent e) {
        if (!(e.isPopupTrigger()) && MouseEvent.BUTTON1 == e.getButton()) {
          boolean saveTransientModels = GenerationSettings.getInstance().isSaveTransientModels();
          GenerationSettings.getInstance().setSaveTransientModels(!(saveTransientModels));
          TransientModelsWidgetInstaller.updateWidgets();
        } else if (e.isPopupTrigger()) {
          WidgetSettingsPanel panel = new WidgetSettingsPanel();
          Dimension dimension = panel.getPreferredSize();
          Point point = new Point(0, 0);
          point = new Point(point.x - dimension.width, point.y - dimension.height);
          panel.showComponent(new RelativePoint(e.getComponent(), point));
        }
      }
    };
  }

  public void update() {
    myComponent.update();
    myStatusBar.updateWidget(ID());
  }

  @Nullable
  public StatusBarWidget.WidgetPresentation getPresentation(@NotNull StatusBarWidget.PlatformType type) {
    return this;
  }

  public void dispose() {
  }

  @NotNull
  public Icon getIcon() {
    if (isSaveTransientModels()) {
      return myIcon;
    }
    return UIManager.getLookAndFeel().getDisabledIcon(myStatusBar.getComponent(), myIcon);
  }

  @NotNull
  public String ID() {
    return WIDGET_ID;
  }

  public boolean isSaveTransientModels() {
    return GenerationSettings.getInstance().isSaveTransientModels();
  }

  public JComponent getComponent() {
    return this.myComponent;
  }
}
