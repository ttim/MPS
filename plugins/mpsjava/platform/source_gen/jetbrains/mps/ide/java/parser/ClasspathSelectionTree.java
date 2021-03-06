package jetbrains.mps.ide.java.parser;

/*Generated by MPS */

import com.intellij.ui.treeStructure.Tree;
import jetbrains.mps.logging.Logger;
import java.util.Map;
import java.io.File;
import jetbrains.mps.reloading.IClassPathItem;
import java.util.HashMap;
import jetbrains.mps.ide.platform.ui.CheckBoxNodeRenderer;
import java.util.List;
import javax.swing.event.TreeWillExpandListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.tree.ExpandVetoException;
import javax.swing.tree.TreePath;
import jetbrains.mps.util.PathManager;
import javax.swing.tree.DefaultTreeModel;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.reloading.ClassPathFactory;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IdeIcons;
import java.awt.Color;
import jetbrains.mps.nodeEditor.MPSColors;
import javax.swing.tree.DefaultMutableTreeNode;

public class ClasspathSelectionTree extends Tree {
  private static Logger LOG = Logger.getLogger(ClasspathSelectionTree.class);

  private ClasspathObserver myClasspathObserver;
  private Map<File, IClassPathItem> myFilesToClasspaths = new HashMap<File, IClassPathItem>();

  public ClasspathSelectionTree(ClasspathObserver classpathObserver) {
    super();
    myClasspathObserver = classpathObserver;
    setCellRenderer(new CheckBoxNodeRenderer());
    setCellEditor(new CheckBoxNodeRenderer.CheckBoxNodeEditor<ClasspathSelectionTree.FileData>() {
      @Override
      protected ClasspathSelectionTree.FileData createNodeData(boolean selected) {
        ClasspathSelectionTree.FileData data = new ClasspathSelectionTree.FileData(getObject().getFile(), ClasspathSelectionTree.this);
        data.setSelected(selected);
        if (myClasspathObserver != null) {
          if (selected) {
            myClasspathObserver.classPathAdded(data.getClasspath());
          } else {
            myClasspathObserver.classPathRemoved(data.getClasspath());
          }
        }
        return data;
      }
    });
    setEditable(true);
    setShowsRootHandles(true);
    setRootVisible(true);
    setRowHeight(16);
  }

  public static ClasspathSelectionTree createClasspathSelectionTree(ClasspathObserver classpathObserver, List<File> sourceDirs) {
    ClasspathSelectionTree tree = new ClasspathSelectionTree(classpathObserver);
    tree.addTreeWillExpandListener(new TreeWillExpandListener() {
      public void treeWillExpand(TreeExpansionEvent event) throws ExpandVetoException {
        TreePath path = event.getPath();
        Object node = path.getLastPathComponent();
        ClasspathSelectionTree.ClasspathTreeNode treeNode = (ClasspathSelectionTree.ClasspathTreeNode) node;
        treeNode.init();
      }

      public void treeWillCollapse(TreeExpansionEvent event) throws ExpandVetoException {
      }
    });
    String mpsHomePath = PathManager.getHomePath();
    ClasspathSelectionTree.ClasspathTreeNode root = new ClasspathSelectionTree.ClasspathTreeNode(new File(mpsHomePath), tree);
    tree.setModel(new DefaultTreeModel(root, false));
    root.init();
    return tree;
  }

  public static class FileData implements CheckBoxNodeRenderer.NodeData {
    private File myFile;
    private ClasspathSelectionTree myTree;
    private boolean mySelected;

    public FileData(File file, ClasspathSelectionTree tree) {
      myFile = file;
      myTree = tree;
    }

    public File getFile() {
      return myFile;
    }

    public boolean isSelected() {
      return mySelected;
    }

    public void setSelected(boolean newValue) {
      mySelected = newValue;
    }

    public String getText() {
      return myFile.getName();
    }

    @Nullable
    public IClassPathItem getClasspath() {
      if (!(myTree.myFilesToClasspaths.containsKey(myFile))) {
        IClassPathItem classPath = classpathChosen();
        myTree.myFilesToClasspaths.put(myFile, classPath);
      }
      return myTree.myFilesToClasspaths.get(myFile);
    }

    private IClassPathItem classpathChosen() {
      try {
        return ClassPathFactory.getInstance().createFromPath(myFile.getAbsolutePath(), "ClasspathSelectionTree");
      } catch (Throwable ex) {
        ClasspathSelectionTree.LOG.error(ex);
        return null;
      }
    }

    public Icon getIcon(boolean expanded) {
      if (myFile.isDirectory()) {
        if (expanded) {
          return IdeIcons.OPENED_FOLDER;
        } else {
          return IdeIcons.CLOSED_FOLDER;
        }
      }
      return null;
    }

    @Nullable
    public Color getColor() {
      if (myFile.isDirectory()) {
        if (myFile.getName().startsWith("class")) {
          return MPSColors.DARK_BLUE;
        }
      } else
      if (myFile.getName().endsWith(".jar")) {
        return MPSColors.DARK_GREEN;
      }
      return null;
    }
  }

  public static class ClasspathTreeNode extends DefaultMutableTreeNode {
    private boolean myIsInitialized = false;
    private ClasspathSelectionTree myTree;

    public ClasspathTreeNode(File file, ClasspathSelectionTree tree) {
      super(new ClasspathSelectionTree.FileData(file, tree));
      myTree = tree;
    }

    public ClasspathSelectionTree.FileData getFileData() {
      return (ClasspathSelectionTree.FileData) getUserObject();
    }

    public void init() {
      if (myIsInitialized) {
        return;
      }
      try {
        ClasspathSelectionTree.FileData fileData = getFileData();
        File file = fileData.getFile();
        boolean somethingAdded = false;
        if (file != null && file.isDirectory()) {
          for (File childFile : file.listFiles()) {
            if (childFile.isDirectory() || childFile.getName().endsWith(".jar")) {
              add(new ClasspathSelectionTree.ClasspathTreeNode(childFile, myTree));
              somethingAdded = true;
            }
          }
        }
        if (somethingAdded) {
          ((DefaultTreeModel) myTree.getModel()).nodeStructureChanged(this);
        }
      } finally {
        myIsInitialized = true;
      }
    }

    @Override
    public boolean isLeaf() {
      return !(getFileData().getFile().isDirectory());
    }
  }
}
