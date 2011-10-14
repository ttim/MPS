package jetbrains.mps.datatransfer;

/*Generated by MPS */

import jetbrains.mps.components.CoreComponent;
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
import jetbrains.mps.util.ConditionalIterable;
import jetbrains.mps.util.Condition;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class CopyPasteManager extends AbstractManager implements CoreComponent {
  private static final Logger LOG = Logger.getLogger(CopyPasteManager.class);
  private static CopyPasteManager INSTANCE;

  private Map<SNode, AbstractManager.Descriptor<PastePostProcessor>> myPostProcessors = null;
  private Map<SNode, AbstractManager.Descriptor<CopyPreProcessor>> myPreProcessors = null;
  private boolean myLoaded = false;

  public CopyPasteManager(ClassLoaderManager classLoaderManager) {
  }

  public void init() {
    if (INSTANCE != null) {
      throw new IllegalStateException("double initialization");
    }

    INSTANCE = this;
    super.init();
  }

  public void dispose() {
    super.dispose();
    INSTANCE = null;
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
      if (actionsModelDescriptor == null) {
        continue;
      }
      Iterable<SNode> roots = new ConditionalIterable<SNode>(actionsModelDescriptor.getSModel().roots(), new Condition<SNode>() {
        public boolean met(SNode node) {
          return SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.actions.structure.CopyPasteHandlers");
        }
      });
      for (SNode root : roots) {
        for (SNode preProcessor : ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(root, "jetbrains.mps.lang.actions.structure.CopyPasteHandlers"), "preProcessor", true))) {
          MapSequence.fromMap(myPreProcessors).put(SLinkOperations.getTarget(preProcessor, "concept", false), new AbstractManager.Descriptor<CopyPreProcessor>(language.getModuleFqName() + "." + LanguageAspect.ACTIONS.getName() + "." + ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(preProcessor, "jetbrains.mps.lang.actions.structure.CopyPreProcessor"), "call_getClassName_5948027493682347861", new Class[]{SNode.class})), language, LOG));
        }
        for (SNode postProcessor : ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(root, "jetbrains.mps.lang.actions.structure.CopyPasteHandlers"), "postProcessor", true))) {
          MapSequence.fromMap(myPostProcessors).put(SLinkOperations.getTarget(postProcessor, "concept", false), new AbstractManager.Descriptor<PastePostProcessor>(language.getModuleFqName() + "." + LanguageAspect.ACTIONS.getName() + "." + ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(postProcessor, "jetbrains.mps.lang.actions.structure.PastePostProcessor"), "call_getClassName_5457641811177522085", new Class[]{SNode.class})), language, LOG));
        }

      }
    }
    myLoaded = true;
  }

  public void clearCaches() {
    myPostProcessors = null;
    myPreProcessors = null;
    myLoaded = false;
  }

  public static CopyPasteManager getInstance() {
    return INSTANCE;
  }
}
