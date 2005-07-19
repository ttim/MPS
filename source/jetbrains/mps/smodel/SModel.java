package jetbrains.mps.smodel;

import jetbrains.mps.ide.IStatus;
import jetbrains.mps.ide.Status;
import jetbrains.mps.ide.command.CommandEvent;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.ide.command.ICommandListener;
import jetbrains.mps.ide.command.undo.IUndoableAction;
import jetbrains.mps.ide.command.undo.UndoManager;
import jetbrains.mps.ide.command.undo.UnexpectedUndoException;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.event.*;
import jetbrains.mps.typesystem.ITypeChecker;
import jetbrains.mps.typesystem.TSStatus;
import jetbrains.mps.typesystem.TypeCheckerAccess;
import jetbrains.mps.util.NameUtil;

import java.util.*;

/**
 * Author: Sergey Dmitriev
 * Created Sep 16, 2003
 */
public class SModel implements Iterable<SNode> {
  private static final Logger LOG = Logger.getLogger(SModel.class);

  private List<SModelListener> myListeners = new ArrayList<SModelListener>();
  private List<SModelCommandListener> myCommandListeners = new ArrayList<SModelCommandListener>();
  private List<SNode> myRoots = new ArrayList<SNode>();
  private String myName = "unnamed";
  private String myNamespace = "";
  private String myStereotype;
  private boolean isLoading = false;

  private int myMaxReferenceID;
  private List<String> myLanguages = new ArrayList<String>();
  private List<ImportElement> myImports = new ArrayList<ImportElement>();
  private Map<String, SNode> myIdToNodeMap = new HashMap<String, SNode>();
  private SModelEventTranslator myEventTranslator = new SModelEventTranslator();

  private Set<String> myDescriptorNotFoundReportedFqNames = new HashSet<String>();

  public SModel(String name, String nameSpace) {
    this();
    myName = name;
    myNamespace = nameSpace;
  }

  public SModel(String fqName) {
    this();
    myName = NameUtil.nameFromFQName(fqName);
    myNamespace = NameUtil.namespaceFromFQName(fqName);
  }


  public SModel() {
    addSModelListener(myEventTranslator);
    CommandProcessor.instance().addCommandListener(myEventTranslator);
  }

  public String getName() {
    return myName;
  }

  public void setName(String name) {
    myName = name;
  }

  public String getNamespace() {
    return myNamespace;
  }

  public void runLoadingAction(Runnable runnable) {
    boolean wasLoading = isLoading();
    if (!wasLoading) setLoading(true);
    try {
      runnable.run();
    } finally {
      setLoading(wasLoading);
    }
  }

  public Iterator<SNode> iterator() {
    return roots();
  }

  public void setNamespace(String namespace) {
    myNamespace = namespace;
  }

  public String getStereotype() {
    return myStereotype;
  }

  public void setStereotype(String stereotype) {
    myStereotype = stereotype;
  }

  public Iterator<SNode> roots() {
    return myRoots.iterator();
  }

  public List<SNode> getRoots() {
    return new ArrayList<SNode>(myRoots);
  }

  public void addRoot(SNode rootNode) {
    LOG.assertLog(rootNode.getModel() == this, "Incorrect node model");
    if (myRoots.contains(rootNode)) return;
    myRoots.add(rootNode);
    if (!isLoading()) UndoManager.instance().undoableActionPerformed(new UndoRootAddOrDelete(rootNode, null, false));
    fireRootAddedEvent(rootNode);
  }

  public void deleteRoot(SNode semanticNode) {
    String id = semanticNode.getId();
    if (myRoots.remove(semanticNode)) {
      if (!isLoading()) UndoManager.instance().undoableActionPerformed(new UndoRootAddOrDelete(semanticNode, id, true));
      fireRootDeletedEvent(semanticNode);
    }
  }

  public void addSModelListener(SModelListener listener) {
    LOG.assertLog(!myListeners.contains(listener), "Duplicated listener");
    myListeners.add(listener);
  }

  public boolean hasSModelListener(SModelListener listener) {
    return myListeners.contains(listener);
  }

  public boolean hasSModelCommandListener(SModelCommandListener listener) {
    return myCommandListeners.contains(listener);
  }

  public void removeSModelListener(SModelListener listener) {
    myListeners.remove(listener);
  }

  public void setLoading(boolean loading) {
    isLoading = loading;
  }

  public boolean isLoading() {
    return isLoading;
  }

  public boolean hasImportedModel(String fqName) {
    for (int i = 0; i < myImports.size(); i++) {
      ImportElement importElement = (ImportElement) myImports.get(i);
      if (importElement.getModelFQName().equals(fqName)) {
        return true;
      }
    }
    return false;
  }

  public boolean customSave() {
    return false;
  }

  private boolean canFireEvent() {
    return !isLoading /*&& !UndoManager.instance().isUndoOrRedoInProgress() */;
  }

  void fireRootAddedEvent(SNode root) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.rootAdded(new SModelRootEvent(this, root, true));
    }
  }

  void fireRootDeletedEvent(SNode root) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.rootRemoved(new SModelRootEvent(this, root, false));
    }
  }

  void firePropertyChangedEvent(SNode node, String property) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.propertyChanged(new SModelPropertyEvent(this, property, node));
    }
  }

  void fireChildAddedEvent(SNode parent, String role, SNode child, int childIndex) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.childAdded(new SModelChildEvent(this, true, parent, role, childIndex, child));
    }
  }

  void fireChildRemovedEvent(SNode parent, String role, SNode child, int childIndex) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.childRemoved(new SModelChildEvent(this, false, parent, role, childIndex, child));
    }
  }

  void fireReferenceAddedEvent(SReference reference) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.referenceAdded(new SModelReferenceEvent(this, reference, true));
    }
  }

  void fireReferenceRemovedEvent(SReference reference) {
    if (!canFireEvent()) return;
    for (SModelListener sModelListener : copyListeners()) {
      sModelListener.referenceRemoved(new SModelReferenceEvent(this, reference, false));
    }
  }

  private void fireSModelChangedInCommandEvent(List<SModelEvent> events) {
    for (SModelCommandListener l : copyCommandListeners()) {
      l.modelChangedInCommand(events);
    }
  }


  private List<SModelListener> copyListeners() {
    return new LinkedList<SModelListener>(myListeners);
  }

  private List<SModelCommandListener> copyCommandListeners() {
    return new LinkedList<SModelCommandListener>(myCommandListeners);
  }

  public void addSModelCommandListener(SModelCommandListener listener) {
    LOG.assertLog(!myCommandListeners.contains(listener), "Duplicated listener");
    myCommandListeners.add(listener);
  }

  public void removeSModelCommandListener(SModelCommandListener listener) {
    myCommandListeners.remove(listener);
  }

  public boolean isRoot(SNode node) {
    return myRoots.contains(node);
  }

  public boolean importsLanguage(String languageNamespace) {
    for (String languageNamespase : myLanguages) {
      if (languageNamespase.equals(languageNamespace)) return true;
    }
    return false;
  }

  public void addLanguage(Language language) {
    assert language != null;
    addLanguage(language.getNamespace());
  }

  public void addLanguage(String languageNamespace) {
    assert languageNamespace != null;
    if (!myLanguages.contains(languageNamespace)) {
      myLanguages.add(languageNamespace);
    }
  }

  public SNode getNode(String path) {
    String[] pathElements = path.split("/");
    String first = pathElements[0];
    SNode current = null;
    for (SNode root : myRoots) {
      if (root.getId().equals(first)) {
        current = root;
        break;
      }
    }
    if (current == null) return null;
    for (int i = 1; i < pathElements.length; i++) {
      for (SNode node : current.getChildren()) {
        if (node.getId().equals(pathElements[i])) {
          current = node;
          break;
        }
      }
      if (current == null) return null;
    }
    return current;
  }

  /**
   * @deprecated use deleteLanguage(String nameSpace) instead
   */
  public void deleteLanguage(Language language) {
    myLanguages.remove(language.getNamespace());
  }

  public void deleteLanguage(String languageNamespace) {
    myLanguages.remove(languageNamespace);
  }

  public List<Language> getLanguages() {
    ArrayList<Language> languages = new ArrayList<Language>();
    for (String languageNamespace : myLanguages) {
      Language language = LanguageRepository.getInstance().getLanguage(languageNamespace);
      if (language != null) {
        languages.add(language);
      } else {
        LOG.error("Language \"" + languageNamespace + "\" was not loaded. Used by model \"" + getFQName() +
                "\"\nAdd this language to the LANGUAGES section of the project properties");
      }
    }
    if (languages.isEmpty()) {
      LOG.error("Model \"" + getFQName() + "\" has no languages !!!");
    }
    return languages;
  }

  public List<String> getLanguageNamespaces() {
    return new ArrayList<String>(myLanguages);
  }

  /**
   * @deprecated
   */
  public void addImportedModelDescriptor(SModelDescriptor modelDescriptor) {
    if (findImportElement(modelDescriptor.getFQName()) == null) {
      addImportedModelDescriptor(modelDescriptor, ++myMaxReferenceID);
    }
  }

  /**
   * @deprecated
   */
  public void addImportedModel(SModel semanticModel) {
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(semanticModel.getFQName());
    addImportedModelDescriptor(modelDescriptor, ++myMaxReferenceID);
  }

  /**
   * @deprecated
   */
  void addImportedModelDescriptor(SModelDescriptor modelDescriptor, int referenceId) {
    ImportElement importElement = new ImportElement(modelDescriptor.getFQName(), referenceId);
    myImports.add(importElement);
  }

  public void addImportedModel(String modelFqName) {
    addImportElement(modelFqName);
  }

  ImportElement addImportElement(String modelFqName) {
    ImportElement importElement = findImportElement(modelFqName);
    if (importElement != null) return importElement;
    importElement = new ImportElement(modelFqName, ++myMaxReferenceID);
    myImports.add(importElement);
    return importElement;
  }

  ImportElement addImportElement(String modelFqName, int referenceId) {
    ImportElement importElement = new ImportElement(modelFqName, referenceId);
    myImports.add(importElement);
    return importElement;
  }

  public void deleteImportedModel(String fqName) {
    ImportElement importElement = findImportElement(fqName);
    if (importElement != null) {
      myImports.remove(importElement);
    }
  }

  public void deleteImportedModel(SModel model) {
    ImportElement importElement = findImportElement(model.getFQName());
    if (importElement != null) {
      myImports.remove(importElement);
    }
  }

  public Collection<String> getImportedModelNames() {
    ArrayList<String> modelNames = new ArrayList<String>();
    for (ImportElement importElement : myImports) {
      modelNames.add(importElement.getModelFQName());
    }
    return modelNames;
  }

  String getImportedModelName(int referenceID) {
    Iterator<ImportElement> iterator = myImports.iterator();
    while (iterator.hasNext()) {
      ImportElement importElement = iterator.next();
      if (importElement.getReferenceID() == referenceID) {
        return importElement.getModelFQName();
      }
    }
    return null;
  }


  public Iterator<SModelDescriptor> importedModels() {
    List<SModelDescriptor> modelsList = new LinkedList<SModelDescriptor>();
    Iterator<ImportElement> iterator = myImports.iterator();
    while (iterator.hasNext()) {
      ImportElement importElement = iterator.next();
      String modelFQName = importElement.getModelFQName();
      if (!myDescriptorNotFoundReportedFqNames.contains(modelFQName)) {
        SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(modelFQName);
        if (modelDescriptor != null) {
          modelsList.add(modelDescriptor);
        } else {
          myDescriptorNotFoundReportedFqNames.add(modelFQName);
          LOG.errorWithTrace("Couldn't find model descriptor for imported model: \"" + modelFQName + "\"\n" +
                  "source model was: \"" + getFQName() + "\"");
        }
      }
    }
    return modelsList.iterator();
  }

  List<SModelListener> getListeners() {
    return new ArrayList<SModelListener>(myListeners);
  }

  List<SModelCommandListener> getCommandListeners() {
    return new ArrayList<SModelCommandListener>(myCommandListeners);
  }

  /*package*/
  Iterator<ImportElement> importElements() {
    return myImports.iterator();
  }

  public boolean isImported(SModel model) {
    return findImportElement(model.getFQName()) != null;
  }

  private ImportElement findImportElement(String fqName) {
    for (ImportElement importElement : myImports) {
      if (fqName.equals(importElement.getModelFQName())) {
        return importElement;
      }
    }
    return null;
  }

  public void setMaxReferenceID(int i) {
    myMaxReferenceID = i;
  }

  public int getMaxReferenceID() {
    return myMaxReferenceID;
  }

  public String toString() {
    if (getFQName() == null) return "";
    return this.getFQName();
  }

  public String getFQName() {
    if (myNamespace == null || myNamespace.length() == 0) {
      return myName;
    }
    return myNamespace + "." + myName;
  }

  public IStatus updateNodeStatuses() {
    LOG.debug("SModel updateNodeStatuses: " + getFQName());
    // clear
    Iterator<SNode> roots = roots();
    while (roots.hasNext()) {
      SNode rootNode = roots.next();
      rootNode.putUserObject(SNode.ERROR_STATUS, null);
      rootNode.putUserObject(SNode.CHILDREN_ERROR_STATUS, null);
      Iterator<SNode> children = rootNode.depthFirstChildren();
      while (children.hasNext()) {
        children.next().putUserObject(SNode.ERROR_STATUS, null);
        rootNode.putUserObject(SNode.CHILDREN_ERROR_STATUS, null);
      }
    }

    ITypeChecker typeChecker = TypeCheckerAccess.instance().getTypeChecker();

    List<Language> languages = getLanguages();
    for (Iterator<Language> iterator = languages.iterator(); iterator.hasNext();) {
      Language language = iterator.next();
      typeChecker.loadLanguage(language);
    }

    List<TSStatus> allErrors = new LinkedList<TSStatus>();
    roots = roots();
    while (roots.hasNext()) {
      SNode rootNode = roots.next();
      TSStatus status = typeChecker.checkNodeType(rootNode);
      if (status.isErrorComposite()) {
        List<TSStatus> errorList = status.getAllErrors();
        allErrors.addAll(errorList);
        rootNode.putUserObject(SNode.CHILDREN_ERROR_STATUS, new Status.ERROR(errorList.size() + " type violations"));
      } else if (status.isError()) {
        allErrors.add(status);
      }
    }
    if (allErrors.size() == 0) {
      LOG.debug("status : no errors");
      return new Status.OK("");
    }
    LOG.debug("status : " + allErrors.size() + " errors found!");
    for (int i = 0; i < allErrors.size(); i++) {
      TSStatus error = allErrors.get(i);
      SNode node = error.getSemanticNode();
      if (node == null) {
        LOG.error("ERROR: error status " + error + " has no *node*, message: " + error.getMessage());
        LOG.error("ERROR: Couldn't show the error status in model");
        continue;
      }
      error.getSemanticNode().putUserObject(SNode.ERROR_STATUS, error);
    }

    return new Status.ERROR(allErrors.size() + " error(s)");
  }

  public SNode getNodeById(String nodeId) {
    SNode node = myIdToNodeMap.get(nodeId);
    return node;
  }

  public void setNodeId(String id, SNode node) {
    if (id == null) {
      throw new IllegalArgumentException("try to set NULL id to node: " + node.getDebugText());
    }
    SNode existingNode = myIdToNodeMap.get(id);
    if (existingNode != null && existingNode != node) {
      LOG.error("couldn't set id=" + id + " to node: " + node.getDebugText() + "\nnode with this id exists: " + existingNode.getDebugText());
      return;
    }
    myIdToNodeMap.put(id, node);
  }

  public void removeNodeId(String id) {
    if (id != null) {
      myIdToNodeMap.remove(id);
    }
  }

  public Collection<? extends SNode> getAllNodes() {
    Collection<SNode> nodes = myIdToNodeMap.values();
    return Collections.unmodifiableCollection(nodes);
  }

  /*package*/
  static class ImportElement {
    private String myModelDescriptor;
    private int myReferenceID;

    public ImportElement(String modelDescriptor, int referenceID) {
      myModelDescriptor = modelDescriptor;
      myReferenceID = referenceID;
    }

    public String getModelFQName() {
      return myModelDescriptor;
    }

    public int getReferenceID() {
      return myReferenceID;
    }
  }

  private static class UndoRootAddOrDelete implements IUndoableAction {
    private SNode myRoot;
    private String myId;
    private boolean myAdd;

    UndoRootAddOrDelete(SNode root, String id, boolean isAdd) {
      myId = id;
      myRoot = root;
      myAdd = isAdd;
    }

    public void undo() throws UnexpectedUndoException {
      SModel semanticModel = myRoot.getModel();
      if (myAdd) {
        semanticModel.addRoot(myRoot);
        myRoot.setId(myId);
      } else {
        semanticModel.deleteRoot(myRoot);
      }
      UndoManager.instance().undoableActionPerformed(new UndoRootAddOrDelete(myRoot, null, !myAdd));
    }
  }

  private class SModelEventTranslator implements ICommandListener, SModelListener {
    private List<SModelEvent> myEvents = new ArrayList<SModelEvent>();

    public void commandStarted(CommandEvent event) {
      myEvents.clear();
    }

    public void rootAdded(SModelRootEvent event) {
      myEvents.add(event);
    }

    public void rootRemoved(SModelRootEvent event) {
      myEvents.add(event);
    }

    public void propertyChanged(SModelPropertyEvent event) {
      myEvents.add(event);
    }

    public void childAdded(SModelChildEvent event) {
      myEvents.add(event);
    }

    public void childRemoved(SModelChildEvent event) {
      myEvents.add(event);
    }

    public void referenceAdded(SModelReferenceEvent event) {
      myEvents.add(event);
    }

    public void referenceRemoved(SModelReferenceEvent event) {
      myEvents.add(event);
    }

    public void beforeCommandFinished(CommandEvent event) {
    }

    public void commandFinished(CommandEvent event) {
      if (myEvents.size() > 0) {
        fireSModelChangedInCommandEvent(new ArrayList<SModelEvent>(myEvents));
      }
    }

  }
}
