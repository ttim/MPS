package jetbrains.mps.generator.traceInfo;

/*Generated by MPS */

import jetbrains.mps.generator.cache.XmlBasedModelCache;
import jetbrains.mps.traceInfo.DebugInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.cleanup.CleanupManager;
import jetbrains.mps.cleanup.CleanupListener;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.generator.GenerationStatus;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.IModule;
import java.net.URL;
import jetbrains.mps.vfs.IFile;
import java.io.InputStream;
import java.io.IOException;
import jetbrains.mps.reloading.IClassPathItem;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.reloading.CommonPaths;
import org.jdom.Element;
import jetbrains.mps.vfs.FileSystem;

public class TraceInfoCache extends XmlBasedModelCache<DebugInfo> {
  public static final String TRACE_FILE_NAME = "trace.info";
  private static TraceInfoCache INSTANCE;
  private static final Object INSTANCE_LOCK = new Object();
  protected static Log log = LogFactory.getLog(TraceInfoCache.class);

  private List<TraceInfoCache.TraceInfoResourceProvider> myProviders = new CopyOnWriteArrayList<TraceInfoCache.TraceInfoResourceProvider>();

  public TraceInfoCache(SModelRepository modelRepository) {
    super(modelRepository);
  }

  @Override
  public void init() {
    synchronized (INSTANCE_LOCK) {
      if (INSTANCE != null) {
        throw new IllegalStateException("double initialization");
      }
      INSTANCE = this;
    }
    super.init();
    CleanupManager.getInstance().addCleanupListener(new CleanupListener() {
      public void performCleanup() {
        cleanup();
      }
    });
  }

  @Override
  public void dispose() {
    super.dispose();
    synchronized (INSTANCE_LOCK) {
      INSTANCE = null;
    }
  }

  @NotNull
  public String getCacheFileName() {
    return TRACE_FILE_NAME;
  }

  protected DebugInfo generateCache(GenerationStatus status) {
    return status.getDebugInfo();
  }

  @Nullable
  public DebugInfo get(@NotNull SModelDescriptor modelDescriptor) {
    //  we do not want to acquire myModelsLock inside of myCache lock, so we get module here 
    //  see MPS-13899 
    final IModule module = modelDescriptor.getModule();
    synchronized (myCache) {
      if (myCache.containsKey(modelDescriptor)) {
        return myCache.get(modelDescriptor);
      }
      DebugInfo cache = readCache(modelDescriptor, module);
      myCache.put(modelDescriptor, cache);
      return cache;
    }
  }

  @Override
  protected DebugInfo readCache(SModelDescriptor sm) {
    if (log.isWarnEnabled()) {
      log.warn("Should not use readCache method since it may cause a deadlock.\nSee MPS-13899", new RuntimeException());
    }
    return readCache(sm, sm.getModule());
  }

  protected DebugInfo readCache(SModelDescriptor sm, IModule module) {
    return loadCacheFromUrl(getCacheUrl(sm, module), sm);
  }

  @Nullable
  private DebugInfo loadCacheFromUrl(@Nullable URL url, @NotNull SModelDescriptor sm) {
    if (url == null) {
      return null;
    }
    IFile file = TraceInfoCache.getFileByURL(url);
    if (file != null) {
      myFilesToModels.put(file, sm);
    }
    InputStream stream = null;
    try {
      stream = url.openStream();
      if (stream == null) {
        return null;
      }
      return load(stream);
    } catch (IOException e) {
      return null;
    } finally {
      try {
        if (stream != null) {
          stream.close();
        }
      } catch (IOException e) {
        if (log.isErrorEnabled()) {
          log.error("", e);
        }
      }
    }
  }

  @Nullable
  private URL getCacheUrl(@NotNull SModelDescriptor sm, IModule module) {
    IClassPathItem classPathItem;
    ModuleDescriptor descriptor = module.getModuleDescriptor();
    if (module.isCompileInMPS() || descriptor != null && !(descriptor.getStubModelEntries().isEmpty())) {
      classPathItem = module.getClassPathItem();
    } else {
      classPathItem = CommonPaths.getMPSClassPath();
    }
    if (classPathItem == null) {
      return null;
    }
    String resourceName = traceInfoResourceName(sm);
    URL url = classPathItem.getResource(resourceName);
    if (url == null) {
      for (TraceInfoCache.TraceInfoResourceProvider provider : myProviders) {
        url = provider.getResource(module, resourceName);
        if (url != null) {
          return url;
        }
      }
    }
    return url;
  }

  @Override
  @Nullable
  protected IFile getCacheFile(@NotNull SModelDescriptor modelDescriptor) {
    URL cacheUrl = getCacheUrl(modelDescriptor, modelDescriptor.getModule());
    if (cacheUrl == null) {
      return null;
    }
    return TraceInfoCache.getFileByURL(cacheUrl);
  }

  private String traceInfoResourceName(SModelDescriptor sm) {
    return sm.getLongName().replace(".", "/") + "/" + TRACE_FILE_NAME;
  }

  @Override
  protected boolean isCache() {
    return false;
  }

  @Override
  protected Element toXml(DebugInfo debugInfo) {
    return debugInfo.toXml();
  }

  @Override
  protected DebugInfo fromXml(Element e) {
    return DebugInfo.fromXml(e);
  }

  public void addResourceProvider(TraceInfoCache.TraceInfoResourceProvider provider) {
    myProviders.add(provider);
  }

  public void removeResourceProvider(TraceInfoCache.TraceInfoResourceProvider provider) {
    myProviders.remove(provider);
  }

  public static TraceInfoCache getInstance() {
    synchronized (INSTANCE_LOCK) {
      return INSTANCE;
    }
  }

  @Nullable
  private static IFile getFileByURL(@NotNull URL url) {
    String file = url.getFile();
    if (file.isEmpty()) {
      return null;
    }
    //  if this is a jar, it starts with file:, so we remove the prefix 
    String prefix = "file:";
    if (file.startsWith(prefix)) {
      file = file.substring(prefix.length());
    }
    return FileSystem.getInstance().getFileByPath(file);
  }

  public static interface TraceInfoResourceProvider {
    public URL getResource(IModule module, String resourceName);
  }
}
