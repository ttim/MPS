package jetbrains.mps.watching;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.List;
import jetbrains.mps.generator.cache.BaseModelCache;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.generator.traceInfo.TraceInfoCache;
import jetbrains.mps.make.java.BLDependenciesCache;
import jetbrains.mps.generator.impl.dependencies.GenerationDependenciesCache;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.vfs.VirtualFileEvent;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelDescriptor;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileMoveEvent;

public class ModelCacheReloader implements ApplicationComponent {
  private VirtualFileManager myVirtualFileManager;
  private ModelCacheReloader.CacheFileListener myFileListener = new ModelCacheReloader.CacheFileListener();
  private List<BaseModelCache> myCaches = ListSequence.<BaseModelCache>fromList(new ArrayList<BaseModelCache>());

  public ModelCacheReloader(VirtualFileManager virtualFileManager, TraceInfoCache traceInfoCache, BLDependenciesCache blDependenciesCache, GenerationDependenciesCache generationDependenciesCache) {
    myVirtualFileManager = virtualFileManager;
    ListSequence.<BaseModelCache>fromList(myCaches).addElement(traceInfoCache);
    ListSequence.<BaseModelCache>fromList(myCaches).addElement(blDependenciesCache);
    ListSequence.<BaseModelCache>fromList(myCaches).addElement(generationDependenciesCache);
  }

  public void initComponent() {
    myVirtualFileManager.addVirtualFileListener(myFileListener);
  }

  public void disposeComponent() {
    myVirtualFileManager.removeVirtualFileListener(myFileListener);
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return getClass().getName();
  }

  private void invalidateForFile(VirtualFileEvent event) {
    final IFile file = VirtualFileUtils.toIFile(event.getFile());
    check_hmm83z_a1a3(ListSequence.<BaseModelCache>fromList(myCaches).findFirst(new IWhereFilter<BaseModelCache>() {
      public boolean accept(BaseModelCache c) {
        return c.getCacheFileName().equalsIgnoreCase(file.getName());
      }
    }), file);
  }

  private static SModelDescriptor check_hmm83z_a1a3(BaseModelCache checkedDotOperand, IFile file) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.invalidateCacheForFile(file);
    }
    return null;
  }

  private class CacheFileListener extends VirtualFileAdapter {
    private CacheFileListener() {
    }

    @Override
    public void beforeFileMovement(VirtualFileMoveEvent event) {
      invalidateForFile(event);
    }

    @Override
    public void beforeFileDeletion(VirtualFileEvent event) {
      invalidateForFile(event);
    }

    @Override
    public void fileCreated(VirtualFileEvent event) {
      invalidateForFile(event);
    }

    @Override
    public void contentsChanged(VirtualFileEvent event) {
      invalidateForFile(event);
    }
  }
}
