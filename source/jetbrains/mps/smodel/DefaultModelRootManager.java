package jetbrains.mps.smodel;

import jetbrains.mps.projectLanguage.ModelRoot;
import jetbrains.mps.util.PathManager;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.event.SModelsMulticaster;

import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Kostik
 */
public class DefaultModelRootManager implements IModelRootManager {
  private static final Logger LOG = Logger.getLogger(DefaultModelRootManager.class);

  public Set<SModelDescriptor> read(ModelRoot root, ModelOwner owner) {
    Set<SModelDescriptor> result = new HashSet<SModelDescriptor>();
    readModelDescriptors(result, new File(root.getPath()), root, owner);
    return result;
  }

  public SModel loadModel(SModelDescriptor modelDescriptor) {
    File file = modelDescriptor.getModelFile();
    SModel model = ModelPersistence.readModel(file);
    LOG.assertLog(model.getUID().equals(modelDescriptor.getModelUID()),
            "\nError loading model from file: \"" + file + "\"\n" +
                    "expected model UID     : \"" + modelDescriptor.getModelUID() + "\"\n" +
                    "but was UID            : \"" + model.getUID() + "\"\n" +
                    "the model will not be available.\n" +
                    "Make sure that all project's roots and/or the model namespace is correct");
    return model;
  }

  public SModel refresh(SModelDescriptor modelDescriptor) {
    return ModelPersistence.refreshModel(modelDescriptor.getSModel());
  }


  public void saveModel(SModelDescriptor modelDescriptor) {
    ModelPersistence.saveModel(modelDescriptor.getSModel(), modelDescriptor.getModelFile());
  }

  private void readModelDescriptors(Set<SModelDescriptor> modelDescriptors, File dir, ModelRoot modelRoot, ModelOwner owner) {
    if (!dir.isDirectory()) {
      return;
    }
    File[] files = dir.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        return name.endsWith(".mps");
      }
    });
    for (int i = 0; i < files.length; i++) {
      File file = files[i];
     /* String modelFQName = PathManager.getModelFQName(file, new File(modelRoot.getPath()), modelRoot.getPrefix());
      String stereotype = PathManager.getModelStereotype(file, new File(modelRoot.getPath()), modelRoot.getPrefix());*/
 /*     if (modelFQName.equals("jetbrains.mps.baseLanguage.generator.java")) {
        System.out.println();
      }*/
      SModelUID modelUID = PathManager.getModelUID(file, new File(modelRoot.getPath()), modelRoot.getPrefix());//new SModelUID(modelFQName, stereotype);
      SModelDescriptor modelDescriptor = getInstance(this, file.getAbsolutePath(), modelUID, owner);
      LOG.debug("I've read model descriptor " + modelDescriptor.getModelUID() + "\n" + "Model root is " + modelRoot.getPath() + " " + modelRoot.getPrefix());
      modelDescriptors.add(modelDescriptor);
    }
    File[] dirs = dir.listFiles();
    for (int i = 0; i < dirs.length; i++) {
      File childDir = dirs[i];
      if (childDir.isDirectory()) {
        readModelDescriptors(modelDescriptors, childDir, modelRoot, owner);
      }
    }
  }

  public static SModelDescriptor getInstance(IModelRootManager manager, String fileName, SModelUID modelUID, ModelOwner owner) {
    MPSFileModelDescriptor.LOG.debug("Getting model " + modelUID + " from " + fileName + " with owner " + owner);

    SModelRepository modelRepository = SModelRepository.getInstance();
    SModelDescriptor modelDescriptor = modelRepository.getModelDescriptor(modelUID);
    if (modelDescriptor != null) {
      if (!(modelDescriptor instanceof MPSFileModelDescriptor)) {
        MPSFileModelDescriptor.LOG.error("get descriptor for model \"" + modelUID + "\" : requred MPSFileModelDescriptor but was: " + modelDescriptor.getClass().getName());
      }
      modelRepository.addOwnerForDescriptor(modelDescriptor, owner);
      return modelDescriptor;
    } else {
      modelDescriptor = new MPSFileModelDescriptor(manager, fileName, modelUID);
      modelRepository.registerModelDescriptor(modelDescriptor, owner);
      return modelDescriptor;
    }
  }

  public static MPSFileModelDescriptor createModel(IModelRootManager manager, String fileName, SModelUID modelUID, ModelOwner owner) {
    MPSFileModelDescriptor.LOG.debug("create model uid=\"" + modelUID + "\" file=\"" + fileName + "\" owner: " + owner);

    SModelRepository modelRepository = SModelRepository.getInstance();
    if (modelRepository.getModelDescriptor(modelUID) != null) {
      MPSFileModelDescriptor.LOG.error("Couldn't create new model \"" + modelUID + "\" because such model exists");
    }

    MPSFileModelDescriptor modelDescriptor = new MPSFileModelDescriptor(manager, fileName, modelUID);
    modelRepository.registerModelDescriptor(modelDescriptor, owner);
    modelRepository.markChanged(modelDescriptor, true);
    SModelsMulticaster.getInstance().fireModelCreatedEvent(modelDescriptor);
    return modelDescriptor;
  }
}
