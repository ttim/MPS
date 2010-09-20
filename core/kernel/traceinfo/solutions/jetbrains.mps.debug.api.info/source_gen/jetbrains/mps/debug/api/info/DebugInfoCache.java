package jetbrains.mps.debug.api.info;

/*Generated by MPS */

import jetbrains.mps.generator.cache.BaseModelCache;
import jetbrains.mps.traceInfo.DebugInfo;
import jetbrains.mps.logging.Logger;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.generator.GenerationStatus;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.generator.generationTypes.StreamHandler;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.reloading.ClassLoaderManager;
import java.io.InputStream;
import org.jdom.Document;
import jetbrains.mps.util.JDOMUtil;
import java.io.IOException;
import org.jdom.JDOMException;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.project.IModule;
import jetbrains.mps.vfs.FileSystem;
import com.intellij.openapi.application.ApplicationManager;

public class DebugInfoCache extends BaseModelCache<DebugInfo> {
  private static final Logger LOG = Logger.getLogger(DebugInfoCache.class);
  public static final String TRACE_FILE_NAME = "trace.info";

  public DebugInfoCache() {
    super(null);
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Debug Info Cache";
  }

  protected String getCacheFileName() {
    return TRACE_FILE_NAME;
  }

  protected DebugInfo generateCache(GenerationStatus status) {
    return status.getDebugInfo();
  }

  protected void saveCache(@NotNull DebugInfo debugInfo, SModelDescriptor descriptor, StreamHandler handler) {
    handler.saveStream(TRACE_FILE_NAME, debugInfo.toXml(), false);
  }

  @Nullable
  protected DebugInfo readCache(SModelDescriptor descriptor) {
    ClassLoader classLoader = ClassLoaderManager.getInstance().getClassLoaderFor(descriptor.getModule());
    InputStream stream = check_4fn2v4_a0b0e(classLoader, descriptor, TRACE_FILE_NAME);
    if (stream == null) {
      return null;
    }
    try {
      Document document = JDOMUtil.loadDocument(stream);
      return DebugInfo.fromXml(document.getRootElement());
    } catch (IOException e) {
      LOG.error(e);
    } catch (JDOMException e) {
      LOG.error(e);
    }
    return null;
  }

  private static IFile getOutputDirForWriting(IModule module, String outputPath) {
    if (outputPath == null) {
      return null;
    }

    if (module.isPackaged()) {
      LOG.assertLog(false, "Can not generate trace info for a packaged module.");
    }

    return FileSystem.getFile(outputPath);
  }

  public static DebugInfoCache getInstance() {
    return ApplicationManager.getApplication().getComponent(DebugInfoCache.class);
  }

  private static InputStream check_4fn2v4_a0b0e(ClassLoader p, SModelDescriptor descriptor, String TRACE_FILE_NAME) {
    if (null == p) {
      return null;
    }
    return p.getResourceAsStream(descriptor.getLongName().replace(".", "/") + "/" + TRACE_FILE_NAME);
  }
}
