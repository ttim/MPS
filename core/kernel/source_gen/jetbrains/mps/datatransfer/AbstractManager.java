package jetbrains.mps.datatransfer;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.logging.Logger;

public abstract class AbstractManager implements ApplicationComponent {
  private ClassLoaderManager myClassLoaderManager;
  private AbstractManager.ReloadHelper myReloadHelper = new AbstractManager.ReloadHelper();

  public AbstractManager(ClassLoaderManager classLoaderManager) {
    this.myClassLoaderManager = classLoaderManager;
  }

  public void initComponent() {
    this.myClassLoaderManager.addReloadHandler(this.myReloadHelper);
  }

  public void disposeComponent() {
    this.myClassLoaderManager.removeReloadHandler(this.myReloadHelper);
  }

  public abstract void clearCaches();

  private class ReloadHelper extends ReloadAdapter {
    public ReloadHelper() {
    }

    @Override
    public void onReload() {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          AbstractManager.this.clearCaches();
        }
      });
    }
  }

  protected static class Descriptor<T> {
    private String myClassName;
    private Language myLanguage;
    private T myInstance;
    private boolean myWasInitialized;
    private Logger myLog;

    public Descriptor(String className, Language language, Logger log) {
      assert className != null;
      this.myClassName = className;
      assert language != null;
      this.myLanguage = language;
      assert log != null;
      this.myLog = log;
    }

    public T getInstance() {
      if (!(this.myWasInitialized)) {
        Class postProcessorClass = this.myLanguage.getClass(this.myClassName);
        if (postProcessorClass != null) {
          try {
            this.myInstance = (T) postProcessorClass.newInstance();
          } catch (InstantiationException ex) {
            this.myLog.error(ex);
          } catch (IllegalAccessException ex) {
            this.myLog.error(ex);
          }
        } else {
          this.myLog.warning("Class not found (probably code for corresponding model should be regenerated): " + this.myClassName);
        }
        this.myWasInitialized = true;
      }
      return this.myInstance;
    }
  }
}
