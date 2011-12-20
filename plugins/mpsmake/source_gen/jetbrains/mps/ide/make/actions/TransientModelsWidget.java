package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import com.intellij.openapi.wm.StatusBarWidget;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.wm.StatusBar;
import javax.swing.Icon;
import org.jetbrains.annotations.Nullable;
import com.intellij.util.Consumer;
import java.awt.event.MouseEvent;
import jetbrains.mps.ide.generator.GenerationSettings;
import javax.swing.UIManager;

public class TransientModelsWidget implements StatusBarWidget, StatusBarWidget.IconPresentation {
  public static final String WIDGET_ID = "TransientModelsWidget";

  @NotNull
  private final StatusBar myStatusBar;
  private final Icon myIcon = IconContainer.ICON_a1;

  public TransientModelsWidget(StatusBar bar) {
    myStatusBar = bar;
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
        boolean saveTransientModels = GenerationSettings.getInstance().isSaveTransientModels();
        GenerationSettings.getInstance().setSaveTransientModels(!(saveTransientModels));
        myStatusBar.updateWidget(ID());
      }
    };
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
}
