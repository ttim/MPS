package jetbrains.mps.make.facet.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.LinkedHashSet;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class FacetDeclaration_Behavior {
  private static Class[] PARAMETERS_8853708281362019178 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> call_allExtends_7854369758457864780(SNode thisNode) {
    Set<SNode> result = SetSequence.fromSet(new LinkedHashSet<SNode>());
    Queue<SNode> queue = QueueSequence.fromQueueAndArray(new LinkedList<SNode>(), thisNode);
    while (QueueSequence.fromQueue(queue).isNotEmpty()) {
      SNode fd = QueueSequence.fromQueue(queue).removeFirstElement();
      if (!(SetSequence.fromSet(result).contains(fd))) {
        SetSequence.fromSet(result).addElement(fd);
        QueueSequence.fromQueue(queue).addSequence(ListSequence.fromList(SLinkOperations.getTargets(fd, "extended", true)).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(it, "facet", false);
          }
        }));
      }
    }
    return result;
  }

  public static Iterable<SNode> call_allRelated_8351679702044331818(SNode thisNode) {
    Set<SNode> result = SetSequence.fromSet(new LinkedHashSet<SNode>());
    Queue<SNode> queue = QueueSequence.fromQueueAndArray(new LinkedList<SNode>(), thisNode);
    while (QueueSequence.fromQueue(queue).isNotEmpty()) {
      SNode fd = QueueSequence.fromQueue(queue).removeFirstElement();
      if (!(SetSequence.fromSet(result).contains(fd))) {
        SetSequence.fromSet(result).addElement(fd);
        QueueSequence.fromQueue(queue).addSequence(ListSequence.fromList(SLinkOperations.getTargets(fd, "required", true)).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(it, "facet", false);
          }
        }));
        QueueSequence.fromQueue(queue).addSequence(ListSequence.fromList(SLinkOperations.getTargets(fd, "optional", true)).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(it, "facet", false);
          }
        }));
      }
    }
    return result;
  }

  public static String virtual_classifierName_4609636120081351397(SNode thisNode) {
    return NameUtil.toValidIdentifier(SPropertyOperations.getString(thisNode, "name")) + "_" + SConceptPropertyOperations.getString(thisNode, "alias");
  }

  public static String call_getFacetFqName_1919086248986828221(SNode thisNode) {
    SNode mod = SModelOperations.getModuleStub(SNodeOperations.getModel(thisNode));
    return (SNodeOperations.isInstanceOf(mod, "jetbrains.mps.lang.project.structure.Language") ?
      SPropertyOperations.getString(SNodeOperations.cast(mod, "jetbrains.mps.lang.project.structure.Language"), "namespace") + "." + SPropertyOperations.getString(thisNode, "name") :
      SPropertyOperations.getString(thisNode, "name")
    );
  }

  public static String call_classifierName_8853708281362019178(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.make.facet.structure.FacetDeclaration"), "virtual_classifierName_4609636120081351397", PARAMETERS_8853708281362019178, new Object[]{});
  }

  public static String callSuper_classifierName_8853708281362019178(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.make.facet.structure.FacetDeclaration"), callerConceptFqName, "virtual_classifierName_4609636120081351397", PARAMETERS_8853708281362019178, new Object[]{});
  }
}
