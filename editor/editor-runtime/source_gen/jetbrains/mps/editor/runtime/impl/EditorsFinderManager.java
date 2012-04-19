package jetbrains.mps.editor.runtime.impl;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.reloading.ReloadListener;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.reloading.ClassLoaderManager;
import java.util.Map;
import java.lang.reflect.Constructor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.ide.MPSCoreComponents;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.nodeEditor.INodeEditor;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.ErrorNodeEditor;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.lang.reflect.InvocationTargetException;
import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.smodel.NodeReadAccessCasterInEditor;
import jetbrains.mps.util.Computable;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.cells.EditorCell_Error;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;

public class EditorsFinderManager implements ApplicationComponent {
  private static Logger LOG = Logger.getLogger(EditorsFinderManager.class);

  private ReloadListener myReloadListener = new ReloadAdapter() {
    @Override
    public void unload() {
      clearCaches();
    }
  };
  private ClassLoaderManager myClassLoaderManager;
  private Map<String, Constructor> myCachedEditors = MapSequence.fromMap(new HashMap<String, Constructor>());

  public EditorsFinderManager(MPSCoreComponents coreComponents) {
    myClassLoaderManager = coreComponents.getClassLoaderManager();
  }

  public void initComponent() {
    myClassLoaderManager.addReloadHandler(myReloadListener);
  }

  public void disposeComponent() {
    myClassLoaderManager.removeReloadHandler(myReloadListener);
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Editors Finder Manager";
  }

  public synchronized INodeEditor loadEditor(EditorContext context, SNode node) {
    assert context.getOperationContext().getModule() != null || context.getOperationContext().isTestMode() : "Illegal state, node: " + node.getId() + ", model: " + SNodeOperations.getModel(node) + ", operationContext: " + context.getOperationContext();

    if (node.getLanguage() == null) {
      return new ErrorNodeEditor();
    }
    String key = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.getConceptDeclaration(node), "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
    if (MapSequence.fromMap(myCachedEditors).containsKey(key)) {
      Constructor constructor = MapSequence.fromMap(myCachedEditors).get(key);
      if (constructor != null) {
        try {
          return (INodeEditor) constructor.newInstance();
        } catch (InstantiationException e) {
          LOG.error(e);
        } catch (IllegalAccessException e) {
          LOG.error(e);
        } catch (InvocationTargetException e) {
          LOG.error(e);
        }
      }
      return new DefaultNodeEditor();
    }
    INodeEditor result = findEditor(node);
    if (result == null) {
      MapSequence.fromMap(myCachedEditors).put(key, null);
    } else {
      try {
        Constructor c = result.getClass().getConstructor();
        c.setAccessible(true);
        MapSequence.fromMap(myCachedEditors).put(key, c);
      } catch (NoSuchMethodException e) {
        LOG.error(e);
        return new DefaultNodeEditor();
      } catch (NoClassDefFoundError e) {
        LOG.error(e);
        return new DefaultNodeEditor();
      }
    }
    return result;
  }

  private INodeEditor findEditor(final SNode nodeToEdit) {
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<INodeEditor>() {
      public INodeEditor compute() {
        SNode nodeConcept = SNodeOperations.getConceptDeclaration(nodeToEdit);
        if (nodeConcept == null) {
          EditorsFinderManager.LOG.error("error loading editor for node " + nodeToEdit.getDebugText() + "\n" + "couldn't find node concept");
          return null;
        }
        if (SNodeOperations.isInstanceOf(nodeConcept, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration")) {
          // todo what is this special case for? 
          return new EditorsFinderManager.DefaultInterfaceEditor();
        }
        final Queue<SNode> conceptQueue = QueueSequence.fromQueue(new LinkedList<SNode>());
        Set<SNode> processedConcepts = SetSequence.fromSet(new HashSet<SNode>());
        QueueSequence.fromQueue(conceptQueue).addLastElement(nodeConcept);
        while (!(QueueSequence.fromQueue(conceptQueue).isEmpty())) {
          SNode abstractConceptDeclaration = QueueSequence.fromQueue(conceptQueue).removeFirstElement();
          if (SetSequence.fromSet(processedConcepts).contains(abstractConceptDeclaration)) {
            continue;
          } else {
            SetSequence.fromSet(processedConcepts).addElement(abstractConceptDeclaration);
          }
          INodeEditor nodeEditor = findEditorByConcept(abstractConceptDeclaration);
          if (nodeEditor != null) {
            return nodeEditor;
          }
          if (SNodeOperations.isInstanceOf(abstractConceptDeclaration, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
            SNode conceptDeclaration = SNodeOperations.cast(abstractConceptDeclaration, "jetbrains.mps.lang.structure.structure.ConceptDeclaration");
            if (SLinkOperations.getTarget(conceptDeclaration, "extends", false) != null && SLinkOperations.getTarget(conceptDeclaration, "extends", false) != SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept")) {
              QueueSequence.fromQueue(conceptQueue).addLastElement(SLinkOperations.getTarget(conceptDeclaration, "extends", false));
            }
            ListSequence.fromList(SLinkOperations.getTargets(conceptDeclaration, "implements", true)).visitAll(new IVisitor<SNode>() {
              public void visit(SNode it) {
                QueueSequence.fromQueue(conceptQueue).addLastElement(SLinkOperations.getTarget(it, "intfc", false));
              }
            });
          } else if (SNodeOperations.isInstanceOf(abstractConceptDeclaration, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration")) {
            ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(abstractConceptDeclaration, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration"), "implements", true)).visitAll(new IVisitor<SNode>() {
              public void visit(SNode it) {
                QueueSequence.fromQueue(conceptQueue).addLastElement(SLinkOperations.getTarget(it, "intfc", false));
              }
            });
          }
        }
        return findEditorByConcept(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept"));
      }
    });
  }

  private INodeEditor findEditorByConcept(SNode conceptDeclaration) {
    Language language = SModelUtil.getDeclaringLanguage(conceptDeclaration);
    if (language == null) {
      return null;
    }
    SModelDescriptor editorModelDescriptor = LanguageAspect.EDITOR.get(language);
    String editorUID = null;
    if (editorModelDescriptor != null) {
      editorUID = editorModelDescriptor.getSModelReference().getSModelFqName().toString();
    }
    try {
      String editorClassName = editorUID + "." + SPropertyOperations.getString(conceptDeclaration, "name") + "_Editor";
      Class editorClass = language.getClass(editorClassName);
      if (editorClass == null) {
        return null;
      }
      Constructor cons = editorClass.getConstructor();
      cons.setAccessible(true);
      return (INodeEditor) cons.newInstance();
    } catch (InstantiationException e) {
      LOG.error(e);
    } catch (IllegalAccessException e) {
      LOG.error(e);
    } catch (Throwable t) {
      LOG.error(t);
    }
    return null;
  }

  public synchronized void clearCaches() {
    MapSequence.fromMap(myCachedEditors).clear();
  }

  public static EditorsFinderManager getInstance() {
    return ApplicationManager.getApplication().getComponent(EditorsFinderManager.class);
  }

  public static class DefaultInterfaceEditor implements INodeEditor {
    public DefaultInterfaceEditor() {
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return new EditorCell_Error(context, node, "    ");
    }

    public EditorCell createInspectedCell(EditorContext context, SNode node) {
      return new EditorCell_Constant(context, node, node.getDebugText());
    }
  }
}
