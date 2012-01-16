package jetbrains.mps.debugger.api.lang.scripts;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Map;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.DynamicReference;

public class ScriptsUtil {
  private static Logger LOG = Logger.getLogger(ScriptsUtil.class);

  public ScriptsUtil() {
  }

  public static Iterable<SModel.ImportElement> getStubImports(final SModel model, final String longName) {
    return Sequence.fromIterable(Sequence.fromClosure(new ISequenceClosure<SModel.ImportElement>() {
      public Iterable<SModel.ImportElement> iterable() {
        return model.importedModels();
      }
    })).where(new IWhereFilter<SModel.ImportElement>() {
      public boolean accept(SModel.ImportElement it) {
        if (eq_bb8vid_a0a0a0a0a0a0a(SModelStereotype.JAVA_STUB, it.getModelReference().getStereotype())) {
          return it.getModelReference().getLongName().startsWith(longName);
        }
        return false;
      }
    });
  }

  public static void updateReferencesToPrefix(SNode node, String prefix) {
    SModel model = SNodeOperations.getModel(node);

    List<SReference> references = ListSequence.fromList(new ArrayList<SReference>());
    Map<SModelReference, SModelReference> modelsMap = MapSequence.fromMap(new HashMap<SModelReference, SModelReference>());
    for (SNode snode : ListSequence.fromList(SNodeOperations.getDescendants(node, null, true, new String[]{}))) {
      for (SReference ref : ListSequence.fromList(SNodeOperations.getReferences(snode))) {
        SModelReference targetSModelReference = ref.getTargetSModelReference();

        if (MapSequence.fromMap(modelsMap).get(targetSModelReference) != null) {
          ListSequence.fromList(references).addElement(ref);
          continue;
        }

        if (eq_bb8vid_a0e0a0e0b(targetSModelReference.getStereotype(), SModelStereotype.JAVA_STUB)) {
          if (targetSModelReference.getLongName().startsWith(prefix)) {
            SModelDescriptor descriptor = SModelRepository.getInstance().getModelDescriptor(new SModelFqName(targetSModelReference.getLongName(), null));
            ListSequence.fromList(references).addElement(ref);
            MapSequence.fromMap(modelsMap).put(targetSModelReference, descriptor.getSModelReference());
          }
        }
      }
    }

    for (IMapping<SModelReference, SModelReference> pair : MapSequence.fromMap(modelsMap)) {
      model.deleteModelImport(pair.key());
      model.addModelImport(pair.value(), false);
    }

    for (IModule newModule : Sequence.fromIterable(MapSequence.fromMap(modelsMap).values()).select(new ISelector<SModelReference, IModule>() {
      public IModule select(SModelReference it) {
        return SModelRepository.getInstance().getModelDescriptor(it).getModule();
      }
    })) {
      model.getModelDescriptor().getModule().addDependency(newModule.getModuleReference(), false);
    }

    // <node> 

    for (SReference ref : ListSequence.fromList(references)) {
      SModelReference oldModelReference = ref.getTargetSModelReference();
      final SModelReference newModelReference = MapSequence.fromMap(modelsMap).get(oldModelReference);
      LOG.info("replacing reference to " + oldModelReference + " with " + newModelReference);

      final String resolveInfo = SLinkOperations.getResolveInfo(ref);
      String role = SLinkOperations.getRole(ref);
      SNode sourceNode = ref.getSourceNode();
      DynamicReference dynamicReference = new DynamicReference(role, sourceNode, newModelReference, resolveInfo);
      sourceNode.removeReferent(role);
      sourceNode.addReference(dynamicReference);


      // <node> 
      // <node> 
      // <node> 
      // <node> 

      SNode targetNode = dynamicReference.getTargetNode();
      if (targetNode != null) {
        sourceNode.setReferent(role, targetNode);
      }

    }
  }

  private static boolean eq_bb8vid_a0a0a0a0a0a0a(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_bb8vid_a0e0a0e0b(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
