package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import com.intellij.openapi.wm.StatusBar;

public class TransientModelsWidgetInstaller {
  private static TransientModelsWidgetInstaller INSTANCE;

  private StatusBar myStatusBar;
  private TransientModelsWidget myWidget;

  public TransientModelsWidgetInstaller() {
    INSTANCE = this;
  }

  public void init(StatusBar bar) {
    myStatusBar = bar;
    myWidget = new TransientModelsWidget(bar);
    if (SaveTransientModelsPreferences.isShowStatusBarIcon()) {
      installWidget();
    }
  }

  public void dispose() {
    uninstallWidget();
  }

  public void installWidget() {
    myStatusBar.addWidget(myWidget);
  }

  public void uninstallWidget() {
    myStatusBar.removeWidget(myWidget.ID());
  }

  public void updateWidget() {
    myWidget.update();
  }

  public TransientModelsWidget getWidget() {
    return myWidget;
  }

  public static TransientModelsWidgetInstaller getInstaller() {
    return INSTANCE;
  }
}
