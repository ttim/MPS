package jetbrains.mps.smodel;

import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.ide.messages.Message;
import jetbrains.mps.ide.messages.MessageKind;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.ApplicationComponents;
import jetbrains.mps.projectLanguage.ModelRoot;
import jetbrains.mps.reloading.ClassLoaderManager;

import java.io.File;
import java.util.*;

/**
 * Author: Sergey Dmitriev
 * Created Jan 29, 2004
 */
public class SModelRepository extends SModelAdapter {
  private static final Logger LOG = Logger.getLogger(SModelRepository.class);

  private ArrayList<SModelDescriptor> myModelDescriptors = new ArrayList<SModelDescriptor>();
  private HashMap<SModelDescriptor, Long> myChangedModels = new HashMap<SModelDescriptor, Long>();
  private HashMap<SModelUID, SModelDescriptor> myUIDToModelDescriptorMap = new HashMap<SModelUID, SModelDescriptor>();
  private HashMap<SModelDescriptor, HashSet<ModelOwner>> myModelToOwnerMap = new HashMap<SModelDescriptor, HashSet<ModelOwner>>();
  private IdeMain myIde;
  private List<RepositoryListener> myListeners = new ArrayList<RepositoryListener>();

  public SModelRepository(IdeMain ide) {
    myIde = ide;
  }


  public static SModelRepository getInstance() {
    return ApplicationComponents.getInstance().getComponent(SModelRepository.class);
  }

  public void refreshModels(boolean updateNodeStatuses, IOperationContext operationContext) {
    for (SModelDescriptor m : myUIDToModelDescriptorMap.values()) {
      m.refresh();
    }

    if (updateNodeStatuses) {
      for (SModelDescriptor m : myUIDToModelDescriptorMap.values()) {
        if (m.isInitialized()) {
          m.getSModel().updateNodeStatuses(operationContext);
        }
      }
    }
  }

  public void addRepositoryListener(RepositoryListener l) {
    myListeners.add(l);
  }

  public void removeRepositoryListener(RepositoryListener l) {
    myListeners.remove(l);
  }

  void fireRepositoryChanged() {
    for (RepositoryListener l : myListeners) {
      l.repositoryChanged();
    }
  }

  public List<SModelDescriptor> getAllModelDescriptors() {
    return Collections.unmodifiableList(myModelDescriptors);
  }

  public List<SModelDescriptor> getModelDescriptorsByStereotype(String stereotype) {
    List<SModelDescriptor> result = new ArrayList<SModelDescriptor>();
    for (SModelDescriptor d : getAllModelDescriptors()) {
      if (stereotype.equals(d.getStereotype())) {
        result.add(d);
      }
    }
    return result;
  }

  public void addOwnerForDescriptor(SModelDescriptor modelDescriptor, ModelOwner owner) {
    HashSet<ModelOwner> owners = myModelToOwnerMap.get(modelDescriptor);
    if (owners == null) {
      owners = new HashSet<ModelOwner>();
      myModelToOwnerMap.put(modelDescriptor, owners);
    }
    owners.add(owner);
    fireRepositoryChanged();
  }

  public void registerModelDescriptor(SModelDescriptor modelDescriptor, ModelOwner owner) {
    SModelUID modelUID = modelDescriptor.getModelUID();
    SModelDescriptor registeredModel = myUIDToModelDescriptorMap.get(modelUID);
    LOG.assertLog(registeredModel == null || registeredModel == modelDescriptor,
            "Another model \"" + modelUID + "\" is already registered!");
    HashSet<ModelOwner> owners = myModelToOwnerMap.get(modelDescriptor);
    LOG.assertLog(owners == null ||
            !owners.contains(owner),
            "Another model \"" + modelUID + "\" is already registered!");
    myUIDToModelDescriptorMap.put(modelUID, modelDescriptor);
    myModelDescriptors.add(modelDescriptor);
    if (owners == null) {
      owners = new HashSet<ModelOwner>();
      myModelToOwnerMap.put(modelDescriptor, owners);
    }
    owners.add(owner);
    modelDescriptor.addSModelListener(this);
    fireRepositoryChanged();
  }

  public void unRegisterModelDescriptor(SModelDescriptor modelDescriptor, ModelOwner owner) {
    HashSet<ModelOwner> modelOwners = myModelToOwnerMap.get(modelDescriptor);
    if(modelOwners == null) {
      removeModelDescriptor_internal(modelDescriptor);
      return;
    }

    if (modelOwners.contains(owner)) {
      modelOwners.remove(owner);
      if (modelOwners.isEmpty()) {
        removeModelDescriptor_internal(modelDescriptor);
      }
    }

    fireRepositoryChanged();
  }

  public void unRegisterModelDescriptors(ModelOwner owner) {
    ArrayList<SModelUID> modelsToRemove = new ArrayList<SModelUID>();
    for (SModelUID fqName : myUIDToModelDescriptorMap.keySet()) {
      SModelDescriptor modelDescriptor = myUIDToModelDescriptorMap.get(fqName);
      HashSet<ModelOwner> locators = myModelToOwnerMap.get(modelDescriptor);
      if (locators != null) {
        locators.remove(owner);
        if (locators.size() == 0) {
          modelsToRemove.add(fqName);
        }
      }
    }
    for (SModelUID modelUID : modelsToRemove) {
      SModelDescriptor modelDescriptor = myUIDToModelDescriptorMap.get(modelUID);
      removeModelDescriptor_internal(modelDescriptor);
    }

    fireRepositoryChanged();
  }

  void removeModelDescriptor(SModelDescriptor modelDescriptor) {
    removeModelDescriptor_internal(modelDescriptor);
    fireRepositoryChanged();
  }

  /*package*/ void removeModelDescriptor_internal(SModelDescriptor modelDescriptor) {
    myModelDescriptors.remove(modelDescriptor);
    myUIDToModelDescriptorMap.remove(modelDescriptor.getModelUID());
    myChangedModels.remove(modelDescriptor);
    myModelToOwnerMap.remove(modelDescriptor);
    modelDescriptor.removeSModelListener(this);

   // fireRepositoryChanged(); don't fire it twice
  }

  public SModelDescriptor getModelDescriptor(SModel model) {
    return myUIDToModelDescriptorMap.get(model.getUID());
  }

  /**
   * @deprecated
   */
  public SModelDescriptor getModelDescriptor(SModelUID modelUID) {
    SModelDescriptor descriptor = myUIDToModelDescriptorMap.get(modelUID);
    if (descriptor != null) {
      return descriptor;
    }

    if (modelUID.getStereotype().length() > 0) {
//      LOG.error("No model descriptors found for uid \"" + modelUID.toString() + "\"");
      return null;
    }

    // todo: tmp solution
    List<SModelDescriptor> descriptors = getModelDescriptors(modelUID.getLongName());
    if (descriptors.size() == 1) {
      return descriptors.get(0);
    }
    if (descriptors.size() == 0) {
//      LOG.error("No model descriptors found for name \"" + modelUID.getLongName() + "\"");
      return null;
    }

    LOG.error(descriptors.size() + " model descriptors found for name \"" + modelUID.getLongName() + "\"");
    return null;
  }

  /**
   * @deprecated
   */
  public List<SModelDescriptor> getModelDescriptors(String modelName) {
    List<SModelDescriptor> list = new LinkedList<SModelDescriptor>();
    SModelUID modelUID = SModelUID.fromString(modelName);
    List<SModelUID> uidList = new LinkedList<SModelUID>();
    if (modelUID.hasStereotype()) {
      uidList.add(modelUID);
    } else {
      for (String stereotype : SModelStereotype.values) {
        uidList.add(new SModelUID(modelName, stereotype));
      }
    }

    for (SModelUID uid : uidList) {
      SModelDescriptor descriptor = myUIDToModelDescriptorMap.get(uid);
      if (descriptor != null) {
        list.add(descriptor);
      }
    }
    return list;
  }

  public SModelDescriptor getModelDescriptor(SModelUID modelUID, ModelOwner owner) {
    SModelDescriptor descriptor = myUIDToModelDescriptorMap.get(modelUID);
//    // tmp
//    return descriptor;
    if (descriptor == null) {
      return null;
    }
    HashSet<ModelOwner> modelOwners = myModelToOwnerMap.get(descriptor);
    ModelOwner testOwner = owner;
    while (testOwner != null) {
      if (modelOwners.contains(testOwner)) {
        return descriptor;
      }
      testOwner = testOwner.getParentModelOwner();
    }
    return null;
  }

  public List<SModelDescriptor> getModelDescriptors(String modelName, ModelOwner owner) {
    List<SModelDescriptor> list = new LinkedList<SModelDescriptor>();
    SModelUID modelUID = SModelUID.fromString(modelName);
    List<SModelUID> uidList = new LinkedList<SModelUID>();
    if (modelUID.hasStereotype()) {
      uidList.add(modelUID);
    } else {
      for (String stereotype : SModelStereotype.values) {
        uidList.add(new SModelUID(modelName, stereotype));
      }
    }

    for (SModelUID uid : uidList) {
      SModelDescriptor descriptor = getModelDescriptor(uid, owner);
      if (descriptor != null) {
        list.add(descriptor);
      }
    }
    return list;
  }

  public List<SModelDescriptor> getModelDescriptors(ModelOwner modelOwner) {
    List<SModelDescriptor> list = new LinkedList<SModelDescriptor>();
    Iterator<Map.Entry<SModelUID, SModelDescriptor>> entries = myUIDToModelDescriptorMap.entrySet().iterator();
    while (entries.hasNext()) {
      Map.Entry<SModelUID, SModelDescriptor> entry = entries.next();
      SModelDescriptor descriptor = entry.getValue();
      HashSet<ModelOwner> modelOwners = myModelToOwnerMap.get(descriptor);

      ModelOwner testOwner = modelOwner;
      while (testOwner != null) {
        if (modelOwners.contains(testOwner)) {
          list.add(descriptor);
          break;
        }
        testOwner = testOwner.getParentModelOwner();
      }
    }
    return list;
  }

  public void modelChanged(SModel model) {
    markChanged(model);
  }

  public void modelChangedDramatically(SModel model) {
    markChanged(model);
  }

  public void markChanged(SModel model) {
    SModelDescriptor modelDescriptor = myUIDToModelDescriptorMap.get(model.getUID());
    if (modelDescriptor != null) { //i.e project model
      markChanged(modelDescriptor);
    }
  }

  public void markChanged(SModelDescriptor descriptor) {
    myChangedModels.put(descriptor, System.currentTimeMillis());
  }

  public boolean isChanged(SModel model) {
    for (SModelDescriptor m : myChangedModels.keySet()) {
      if (m.getSModel() == model) return true;
    }
    return false;
  }

  public boolean isChanged(SModelDescriptor descriptor) {
    return myChangedModels.keySet().contains(descriptor);
  }

  public long getLastChangeTime(SModelDescriptor descriptor) {
    if (myChangedModels.containsKey(descriptor)) {
      return myChangedModels.get(descriptor);
    } else if (descriptor != null) {
      return descriptor.timestamp();
    } else {
      return 0;
    }
  }

  public boolean wereChanges() {
    return getChangedModels().size() > 0;
  }

  public Set<SModelDescriptor> getChangedModels() {
    Set<SModelDescriptor> result = new HashSet<SModelDescriptor>();
    for (SModelDescriptor md : myChangedModels.keySet()) {
      if (md.getModelFile() != null) result.add(md);
    }
    return result;
  }

  public void saveAll() {
    for (SModelDescriptor modelDescriptor : myChangedModels.keySet()) {
      modelDescriptor.save();
    }
    myChangedModels.clear();
  }

  public void reloadAll() {
    for (SModelDescriptor modelDescriptor : new HashSet<SModelDescriptor>(myModelToOwnerMap.keySet())) {
      modelDescriptor.reloadFromDisk();
    }
  }

  public List<SModelDescriptor> readModelDescriptors(Iterable<ModelRoot> modelRoots, ModelOwner owner) {
    return readModelDescriptors(modelRoots.iterator(), owner);
  }

  public List<SModelDescriptor> readModelDescriptors(Iterator<ModelRoot> modelRoots, ModelOwner owner) {
    List<SModelDescriptor> list = new LinkedList<SModelDescriptor>();
    while (modelRoots.hasNext()) {
      ModelRoot modelRoot = modelRoots.next();
      File dir = new File(modelRoot.getPath());
      if (dir.exists()) {
        ModelRootManager manager = getManagerFor(modelRoot);
        list.addAll(manager.read(modelRoot, owner));
      } else {
        String error = "Couldn't load modelDescriptors from " + dir.getAbsolutePath() +
                "\nDirectory doesn't exist: " + dir.getAbsolutePath();
        LOG.error(error);
        myIde.getMessageView().add(new Message(MessageKind.ERROR, error));
      }
    }

    return list;
  }

  private ModelRootManager getManagerFor(ModelRoot modelRoot) {
    if (modelRoot.getHandlerClass() == null) return new DefaultModelRootManager();
    String fqName = modelRoot.getHandlerClass();
    try {
      Class cls = Class.forName(fqName, true, ClassLoaderManager.getInstance().getClassLoader());
      return (ModelRootManager) cls.newInstance();
    } catch (Exception e) {
      LOG.error(e);
      return null;
    }
  }

  public Set<ModelOwner> getOwners(SModelDescriptor modelDescriptor) {
    return Collections.unmodifiableSet(myModelToOwnerMap.get(modelDescriptor));
  }
}