package jetbrains.mps.datatransfer;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.List;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.actions.behavior.CopyPreProcessor_Behavior;
import jetbrains.mps.lang.actions.behavior.PastePostProcessor_Behavior;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.application.ApplicationManager;

public class CopyPasteManager extends AbstractManager {
  private static final Logger LOG = Logger.getLogger(CopyPasteManager.class);

  private Map<SNode, AbstractManager.Descriptor<PastePostProcessor>> myPostProcessors = null;
  private Map<SNode, AbstractManager.Descriptor<CopyPreProcessor>> myPreProcessors = null;
  private boolean myLoaded = false;

  public CopyPasteManager(ClassLoaderManager classLoaderManager) {
    super(classLoaderManager);
  }

  public void preProcessNode(SNode copy, final Map<SNode, SNode> newNodesToSourceNodes) {
    SNode sourceNode = newNodesToSourceNodes.get(copy);
    CopyPreProcessor preProcessor = getPreProcessor(SNodeOperations.getConceptDeclaration(copy));
    if (preProcessor != null && sourceNode != null) {
      preProcessor.preProcesNode(copy, sourceNode);
    } else {
      ListSequence.fromList(SNodeOperations.getChildren(copy)).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          preProcessNode(it, newNodesToSourceNodes);
        }
      });
    }
  }

  public void postProcessNode(SNode node) {
    PastePostProcessor postProcessor = getPostProcessor(SNodeOperations.getConceptDeclaration(node));
    if (postProcessor != null) {
      postProcessor.postProcesNode(node);
    } else {
      ListSequence.fromList(SNodeOperations.getChildren(node)).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          postProcessNode(it);
        }
      });
    }
  }

  public CopyPreProcessor getPreProcessor(SNode concept) {
    load();
    AbstractManager.Descriptor<CopyPreProcessor> descriptor = MapSequence.fromMap(myPreProcessors).get(concept);
    return (descriptor == null ?
      (CopyPreProcessor) null :
      descriptor.getInstance()
    );
  }

  private PastePostProcessor getPostProcessor(SNode concept) {
    load();
    AbstractManager.Descriptor<PastePostProcessor> descriptor = MapSequence.fromMap(myPostProcessors).get(concept);
    return (descriptor == null ?
      (PastePostProcessor) null :
      descriptor.getInstance()
    );
  }

  private void load() {
    if (myLoaded) {
      return;
    }
    myPostProcessors = MapSequence.fromMap(new HashMap<SNode, AbstractManager.Descriptor<PastePostProcessor>>());
    myPreProcessors = MapSequence.fromMap(new HashMap<SNode, AbstractManager.Descriptor<CopyPreProcessor>>());
    for (Language language : MPSModuleRepository.getInstance().getAllLanguages()) {
      SModelDescriptor actionsModelDescriptor = language.getActionsModelDescriptor();
      if (actionsModelDescriptor != null) {
        List<SNode> rootNodes = BaseAdapter.toNodes(actionsModelDescriptor.getSModel().getRootsAdapters());
        for (SNode copyPasteHandlers : ListSequence.fromList(rootNodes).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.lang.actions.structure.CopyPasteHandlers");
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SNodeOperations.as(it, "jetbrains.mps.lang.actions.structure.CopyPasteHandlers");
          }
        })) {
          for (SNode preProcessor : ListSequence.fromList(SLinkOperations.getTargets(copyPasteHandlers, "preProcessor", true))) {
            MapSequence.fromMap(myPreProcessors).put(SLinkOperations.getTarget(preProcessor, "concept", false), new AbstractManager.Descriptor<CopyPreProcessor>(language.getNamespace() + "." + LanguageAspect.ACTIONS.getName() + "." + CopyPreProcessor_Behavior.call_getClassName_5948027493682347861(preProcessor), language, LOG));
          }
          for (SNode postProcessor : ListSequence.fromList(SLinkOperations.getTargets(copyPasteHandlers, "postProcessor", true))) {
            MapSequence.fromMap(myPostProcessors).put(SLinkOperations.getTarget(postProcessor, "concept", false), new AbstractManager.Descriptor<PastePostProcessor>(language.getNamespace() + "." + LanguageAspect.ACTIONS.getName() + "." + PastePostProcessor_Behavior.call_getClassName_5457641811177522085(postProcessor), language, LOG));
          }
        }
      }
    }
    myLoaded = true;
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Copy Paste Registry";
  }

  public void clearCaches() {
    myPostProcessors = null;
    myPreProcessors = null;
    myLoaded = false;
  }

  public static CopyPasteManager getInstance() {
    return ApplicationManager.getApplication().getComponent(CopyPasteManager.class);
  }
}
