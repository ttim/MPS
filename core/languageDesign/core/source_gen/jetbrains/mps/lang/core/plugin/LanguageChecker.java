package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.IEditorChecker;
import jetbrains.mps.logging.Logger;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SModelRepositoryAdapter;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.event.SModelListener;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.checking.TypesEditorChecker;
import java.util.List;
import jetbrains.mps.smodel.event.SModelEvent;
import jetbrains.mps.nodeEditor.EditorMessageOwner;
import jetbrains.mps.nodeEditor.EditorMessage;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponent;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.errors.MessageStatus;
import jetbrains.mps.nodeEditor.HighlighterMessage;
import jetbrains.mps.typesystem.checking.HighlightUtil;
import jetbrains.mps.util.NameUtil;

public class LanguageChecker implements IEditorChecker {
  private static Logger LOG = Logger.getLogger(LanguageChecker.class);

  private boolean myMessagesChanged = false;
  private Set<AbstractConstraintsChecker> myRules = SetSequence.fromSet(new HashSet<AbstractConstraintsChecker>());
  private Map<SNode, LanguageErrorsComponent> myRootsToComponents = MapSequence.fromMap(new HashMap<SNode, LanguageErrorsComponent>());
  private Set<EditorComponent> myEditorComponents = SetSequence.fromSet(new HashSet<EditorComponent>());
  private EditorComponent.EditorDisposeListener myDisposeListener = new EditorComponent.EditorDisposeListener() {
    public void editorWillBeDisposed(EditorComponent editorComponent) {
      SetSequence.fromSet(myEditorComponents).removeElement(editorComponent);
      MapSequence.fromMap(myRootsToComponents).removeKey(editorComponent.getEditedNode());
    }
  };
  private SModelRepositoryAdapter myRepositoryListener = new SModelRepositoryAdapter() {
    public void modelRemoved(SModelDescriptor descriptor) {
      modelDescriptorRemoved(descriptor);
    }

    public void modelDeleted(SModelDescriptor descriptor) {
      modelDescriptorRemoved(descriptor);
    }
  };
  private SModelListener myModelListener = new SModelAdapter() {
    public void beforeModelDisposed(SModel model) {
      clearForModel(model.getSModelReference());
    }
  };
  private Set<SModelDescriptor> myListenedModels = SetSequence.fromSet(new HashSet<SModelDescriptor>());
  private ReloadAdapter myReloadListener = new ReloadAdapter() {
    public void unload() {
      clearForUnload();
    }
  };

  public LanguageChecker() {
    SetSequence.fromSet(myRules).addElement(new ConstraintsChecker());
    SetSequence.fromSet(myRules).addElement(new RefScopeChecker());
    SetSequence.fromSet(myRules).addElement(new CardinalitiesChecker());
    SetSequence.fromSet(myRules).addElement(new TargetConceptChecker());

    ClassLoaderManager.getInstance().addReloadHandler(this.myReloadListener);
    SModelRepository.getInstance().addModelRepositoryListener(this.myRepositoryListener);
  }

  public void dispose() {
    for (SNode root : MapSequence.fromMap(myRootsToComponents).keySet()) {
      MapSequence.fromMap(myRootsToComponents).get(root).dispose();
    }
    for (EditorComponent component : myEditorComponents) {
      component.removeDisposeListener(myDisposeListener);
    }
    SModelRepository.getInstance().removeModelRepositoryListener(myRepositoryListener);
    for (SModelDescriptor modelDescriptor : SetSequence.fromSetWithValues(new HashSet<SModelDescriptor>(), myListenedModels)) {
      removeModelListener(modelDescriptor);
    }
    ClassLoaderManager.getInstance().removeReloadHandler(myReloadListener);
  }

  public void clearForUnload() {
    for (SNode root : MapSequence.fromMap(myRootsToComponents).keySet()) {
      MapSequence.fromMap(myRootsToComponents).get(root).dispose();
    }
    for (EditorComponent component : myEditorComponents) {
      component.removeDisposeListener(myDisposeListener);
    }
    for (SModelDescriptor modelDescriptor : SetSequence.fromSetWithValues(new HashSet<SModelDescriptor>(), myListenedModels)) {
      removeModelListener(modelDescriptor);
    }
    MapSequence.fromMap(myRootsToComponents).clear();
    SetSequence.fromSet(myEditorComponents).clear();
    SetSequence.fromSet(myListenedModels).clear();
  }

  private void modelDescriptorRemoved(SModelDescriptor modelDescriptor) {
    this.removeModelListener(modelDescriptor);
    this.clearForModel(modelDescriptor.getSModelReference());
  }

  private void removeModelListener(SModelDescriptor modelDescriptor) {
    if (SetSequence.fromSet(myListenedModels).contains(modelDescriptor)) {
      modelDescriptor.removeModelListener(myModelListener);
      SetSequence.fromSet(myListenedModels).removeElement(modelDescriptor);
    }
  }

  private void addModelListener(SModelDescriptor modelDescriptor) {
    if (!(SetSequence.fromSet(myListenedModels).contains(modelDescriptor))) {
      modelDescriptor.addModelListener(myModelListener);
      SetSequence.fromSet(myListenedModels).addElement(modelDescriptor);
    }
  }

  private void clearForModel(SModelReference modelReference) {
    for (SNode root : SetSequence.fromSetWithValues(new HashSet<SNode>(), MapSequence.fromMap(myRootsToComponents).keySet())) {
      if (SNodeOperations.getModel(root).getSModelReference().equals(modelReference)) {
        MapSequence.fromMap(myRootsToComponents).get(root).dispose();
        MapSequence.fromMap(myRootsToComponents).removeKey(root);
      }
    }
    for (EditorComponent component : SetSequence.fromSetWithValues(new HashSet<EditorComponent>(), myEditorComponents)) {
      if (component.getEditedNode().getModel().getSModelReference().equals(modelReference)) {
        component.removeDisposeListener(myDisposeListener);
        SetSequence.fromSet(myEditorComponents).removeElement(component);
      }
    }
  }

  public boolean messagesChanged() {
    return myMessagesChanged;
  }

  public boolean isLaterThan(IEditorChecker checker) {
    if (checker instanceof TypesEditorChecker) {
      return true;
    }
    return false;
  }

  public boolean isEarlierThan(IEditorChecker checker) {
    return false;
  }

  public boolean hasDramaticalEvent(List<SModelEvent> list) {
    return true;
  }

  public EditorMessageOwner getOwner(SNode node, EditorComponent component) {
    SNode editedNode = component.getEditedNode();
    SNode root = SNodeOperations.getContainingRoot(editedNode);
    LanguageErrorsComponent errorsComponent = MapSequence.fromMap(myRootsToComponents).get(root);
    if (errorsComponent == null) {
      return null;
    }
    return new LanguageChecker.Owner(errorsComponent, this);
  }

  public void checkingIterationFinished() {
    myMessagesChanged = false;
  }

  public Set<EditorMessage> createMessages(SNode node, IOperationContext operationContext, List<SModelEvent> list, boolean wasCheckedOnce, EditorContext editorContext) {
    EditorComponent editorComponent = editorContext.getNodeEditorComponent();
    SNode root = node.getContainingRoot();
    Set<EditorMessage> result = SetSequence.fromSet(new HashSet<EditorMessage>());
    if (root == null) {
      LOG.error("containing root for node " + node + " is null");
      return result;
    }
    SModelDescriptor descriptor = SNodeOperations.getModel(root).getModelDescriptor();
    if (descriptor == null) {
      // descriptor is null for a replaced model 
      // after model is replaced but before it is disposed (this can happen asyncronously) 
      return result;
    }
    LanguageErrorsComponent errorsComponent = MapSequence.fromMap(myRootsToComponents).get(root);

    if (errorsComponent == null) {
      errorsComponent = new LanguageErrorsComponent(editorComponent.getEditedNode());
      MapSequence.fromMap(myRootsToComponents).put(root, errorsComponent);
    }
    if (!(editorComponent instanceof InspectorEditorComponent) && !(SetSequence.fromSet(myEditorComponents).contains(editorComponent))) {
      SetSequence.fromSet(myEditorComponents).addElement(editorComponent);
      editorComponent.addDisposeListener(myDisposeListener);
    }
    addModelListener(descriptor);

    if (!(wasCheckedOnce)) {
      errorsComponent.clear();
    }
    boolean changed = errorsComponent.check(node, myRules, operationContext);
    myMessagesChanged = changed;
    for (IErrorReporter errorReporter : errorsComponent.getErrors()) {

      MessageStatus status = errorReporter.getMessageStatus();
      String errorString = errorReporter.reportError();
      HighlighterMessage message = HighlightUtil.createHighlighterMessage(errorReporter.getSNode(), NameUtil.capitalize(status.getPresentation()) + ": " + errorString, errorReporter, LanguageChecker.this, editorContext);
      SetSequence.fromSet(result).addElement(message);
    }
    return result;
  }

  public void clear(SNode node, EditorComponent component) {
    if (node == null) {
      return;
    }
    SNode containingRoot = node.getContainingRoot();
    if (containingRoot == null) {
      return;
    }
    LanguageErrorsComponent errorsComponent = MapSequence.fromMap(myRootsToComponents).get(containingRoot);
    if (errorsComponent == null) {
      return;
    }
    errorsComponent.clear();
  }

  public static class Owner implements EditorMessageOwner {
    private LanguageErrorsComponent myComponent;
    private LanguageChecker myChecker;

    public Owner(LanguageErrorsComponent component, LanguageChecker checker) {
      myComponent = component;
      myChecker = checker;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || this.getClass() != o.getClass()) {
        return false;
      }

      LanguageChecker.Owner that = (LanguageChecker.Owner) o;
      if (!(this.myComponent.equals(that.myComponent))) {
        return false;
      }
      if (!(this.myChecker.equals(that.myChecker))) {
        return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      int result = this.myComponent.hashCode();
      result = 31 * result + this.myChecker.hashCode();
      return result;
    }
  }
}
