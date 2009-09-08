package jetbrains.mps.baseLanguage.textGen;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.TreeSet;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.watching.ModelChangesWatcher;
import org.jdom.Element;
import jetbrains.mps.util.JDOMUtil;
import org.jdom.Document;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import java.io.File;
import jetbrains.mps.vfs.FileSystem;

public class ModelDependencies {
  private static final String DEPENDENCY = "dependency";
  private static final String DEPENDENCIES_ROOT = "dependenciesRoot";
  private static final Logger LOG = Logger.getLogger(ModelDependencies.class);

  private Set<RootDependencies> myDependencies = SetSequence.fromSet(new TreeSet<RootDependencies>());
  private SModel myModel;

  public ModelDependencies() {
  }

  public void addDependencies(RootDependencies newDependency) {
    SetSequence.fromSet(this.myDependencies).addElement(newDependency);
  }

  public Set<RootDependencies> getDependencies() {
    return this.myDependencies;
  }

  public void setModel(SModel model) {
    this.myModel = model;
  }

  public SModel getModel() {
    return this.myModel;
  }

  public boolean saveTo(IFile file) {
    if (!(file.exists())) {
      file.createNewFile();
      ModelChangesWatcher.instance().fireDataFileCreated(file);
    }
    Element root = new Element(DEPENDENCIES_ROOT);
    for (RootDependencies dependency : this.myDependencies) {
      Element e = new Element(DEPENDENCY);
      dependency.saveTo(e);
      root.addContent(e);
    }
    try {
      JDOMUtil.writeDocument(new Document(root), file);
      return true;
    } catch (Exception e) {
      LOG.error(e);
      return false;
    }
  }

  public static ModelDependencies load(IFile file) {
    try {
      Document document = JDOMUtil.loadDocument(file);
      Element root = document.getRootElement();
      ModelDependencies result = new ModelDependencies();
      for (Element e : ((List<Element>)root.getChildren(DEPENDENCY))) {
        result.addDependencies(new RootDependencies(e));
      }
      return result;
    } catch (Exception e) {
      LOG.error(e);
    }
    return null;
  }

  public static IFile getOutputFileOfModel(String outputDir, SModelDescriptor model) {
    String modelName = model.getLongName().replace(".", File.separator);
    String path = modelName.substring(0, modelName.length()) + File.separator + ".dependencies";
    return FileSystem.getFile(outputDir + File.separator + path);
  }
}
