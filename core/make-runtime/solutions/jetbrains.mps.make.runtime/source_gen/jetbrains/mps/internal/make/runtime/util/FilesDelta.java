package jetbrains.mps.internal.make.runtime.util;

/*Generated by MPS */

import jetbrains.mps.make.delta.IDelta;
import jetbrains.mps.logging.Logger;
import java.util.regex.Pattern;
import jetbrains.mps.vfs.IFile;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.io.File;

public class FilesDelta implements IDelta {
  private static Logger LOG = Logger.getLogger(FilesDelta.class);
  private static Pattern URL = Pattern.compile("[a-zA-Z]://(.*)");

  private IFile rootDir;
  private Map<IFile, FilesDelta.Status> files = MapSequence.fromMap(new HashMap<IFile, FilesDelta.Status>());
  private String key;

  public FilesDelta(IFile dir) {
    this.rootDir = dir;
    this.key = "(IFile)" + straighten(urlToPath(dir.getAbsolutePath()));
  }

  private FilesDelta(FilesDelta copyFrom) {
    this.rootDir = copyFrom.rootDir;
    this.key = copyFrom.key;
    copy(copyFrom);
  }

  public void written(IFile file) {
    LOG.debug("Written " + file);
    MapSequence.fromMap(files).put(file, FilesDelta.Status.WRITTEN);
  }

  public void kept(IFile file) {
    LOG.debug("Kept " + file);
    MapSequence.fromMap(files).put(file, FilesDelta.Status.KEPT);
  }

  public void deleted(IFile file) {
    LOG.debug("Deleted " + file);
    MapSequence.fromMap(files).put(file, FilesDelta.Status.DELETED);
  }

  public boolean reconcile() {
    String[] pathsToKeep = MapSequence.fromMap(files).where(new IWhereFilter<IMapping<IFile, FilesDelta.Status>>() {
      public boolean accept(IMapping<IFile, FilesDelta.Status> f) {
        return f.value() != FilesDelta.Status.DELETED;
      }
    }).<String>select(new ISelector<IMapping<IFile, FilesDelta.Status>, String>() {
      public String select(IMapping<IFile, FilesDelta.Status> f) {
        return straighten(urlToPath(f.key().getAbsolutePath()));
      }
    }).sort(new ISelector<String, Comparable<?>>() {
      public Comparable<?> select(String p) {
        return p;
      }
    }, true).toListSequence().toGenericArray(String.class);

    List<IFile> toDelete = ListSequence.fromList(new ArrayList<IFile>());
    Queue<IFile> dirs = QueueSequence.fromQueueAndArray(new LinkedList<IFile>(), rootDir);
    while (QueueSequence.fromQueue(dirs).isNotEmpty()) {
      IFile dir = QueueSequence.fromQueue(dirs).removeFirstElement();
      for (Tuples._2<IFile, String> fp : Sequence.fromIterable(((Iterable<IFile>) dir.list())).<Tuples._2<IFile, String>>select(new ISelector<IFile, Tuples._2<IFile, String>>() {
        public Tuples._2<IFile, String> select(IFile f) {
          return MultiTuple.<IFile,String>from(f, straighten(urlToPath(f.getAbsolutePath())));
        }
      }).sort(new ISelector<Tuples._2<IFile, String>, Comparable<?>>() {
        public Comparable<?> select(Tuples._2<IFile, String> t) {
          return t._1();
        }
      }, true)) {
        int idx = Arrays.binarySearch(pathsToKeep, fp._1());
        if (fp._0().isDirectory()) {
          idx = (idx < 0 ?
            -1 - idx :
            idx
          );
          if (idx >= pathsToKeep.length || !(startsWith(pathsToKeep[idx], fp._1()))) {
            ListSequence.fromList(toDelete).addElement(fp._0());
            if (idx >= pathsToKeep.length) {
              break;
            }
          } else if (idx < pathsToKeep.length && !(startsWith(fp._1(), pathsToKeep[idx]))) {
            QueueSequence.fromQueue(dirs).addLastElement(fp._0());
          }
        } else if (idx < 0) {
          ListSequence.fromList(toDelete).addElement(fp._0());
        }
      }
    }
    boolean res = true;
    for (IFile td : toDelete) {
      LOG.debug("Reconciled: deleting " + td);
      res &= td.delete();
    }
    return res;
  }

  public IDelta merge(IDelta toMerge) {
    if (!(toMerge instanceof FilesDelta)) {
      throw new IllegalArgumentException();
    }
    if (!(this.contains(toMerge))) {
      throw new IllegalArgumentException();
    }
    return new FilesDelta((FilesDelta) this).copy((FilesDelta) toMerge);
  }

  private String urlToPath(String maybeUrl) {
    Matcher m = URL.matcher(maybeUrl);
    return (m.matches() ?
      m.group(1) :
      maybeUrl
    );
  }

  private String straighten(String path) {
    return path.replaceAll("\\" + File.separatorChar, "/");
  }

  private FilesDelta copy(FilesDelta that) {
    if (startsWith(this.key, that.key)) {
      this.key = that.key;
      this.rootDir = that.rootDir;
    } else if (!(startsWith(that.key, this.key))) {
      throw new IllegalArgumentException();
    }
    MapSequence.fromMap(files).putAll(that.files);
    return this;
  }

  public boolean contains(IDelta other) {
    if (!(other instanceof FilesDelta)) {
      return false;
    }
    FilesDelta that = (FilesDelta) other;
    if (that.key.equals(this.key)) {
      return true;
    }
    return startsWith(that.key, this.key);
  }

  private boolean startsWith(String path, String prefix) {
    return path.startsWith(prefix) && (path.length() == prefix.length() || path.charAt(prefix.length()) == File.separatorChar);
  }

  public static   enum Status {
    WRITTEN(),
    KEPT(),
    DELETED();

    Status() {
    }
  }
}
