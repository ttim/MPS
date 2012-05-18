package jetbrains.mps.baseLanguage.javastub;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.reloading.IClassPathItem;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.project.IModule;

public class ASMModelLoader {
  private static final Logger LOG = Logger.getLogger(ASMModelLoader.class);

  private final IClassPathItem myCpItem;
  private final SModel myModel;
  private final IModule myModule;
  private final boolean mySkipPrivate;

  public ASMModelLoader(IModule module, IClassPathItem classPathItem, SModel model, boolean skipPrivate) {
    myModule = module;
    myCpItem = classPathItem;
    myModel = model;
    mySkipPrivate = skipPrivate;
  }

  public void updateModel() {
    try {
      String pack = myModel.getLongName();
      ClassifierUpdater updater = new ClassifierUpdater(mySkipPrivate, new SReferenceCreator(myModule, myModel));
      ClassifierLoader loader = new ClassifierLoader(myModel, myCpItem, updater);

      for (String name : myCpItem.getRootClasses(pack)) {
        if (myModel.getNodeById(ASMNodeId.createId(name)) != null) {
          continue;
        }
        loader.loadRootClassifier(name);
      }
    } catch (Exception e) {
      LOG.error("Exception", e);
    }
  }
}
