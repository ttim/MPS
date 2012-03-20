package jetbrains.mps.ide.java.platform.index;

/*Generated by MPS */

import com.intellij.util.indexing.FileBasedIndexExtension;
import java.util.List;
import com.intellij.util.indexing.ID;
import com.intellij.util.indexing.FileBasedIndex;
import com.intellij.util.io.KeyDescriptor;
import com.intellij.util.io.DataExternalizer;
import com.intellij.util.indexing.DataIndexer;
import com.intellij.util.indexing.FileContent;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.fileTypes.MPSFileTypeFactory;
import org.jetbrains.annotations.NotNull;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.workbench.actions.goTo.index.BaseSNodeDescriptorIndex;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SReference;
import java.util.ArrayList;

public class ClassifierSuccessorsIndexer extends FileBasedIndexExtension<GlobalSNodeId, List<GlobalSNodeId>> {
  public static final ID<GlobalSNodeId, List<GlobalSNodeId>> NAME = ID.create("jetbrains.mps.ClassifierSuccessorsIndexer");

  private FileBasedIndex.InputFilter myInputFilter = new ClassifierSuccessorsIndexer.InputFilter();
  private KeyDescriptor<GlobalSNodeId> myKeyDescriptor = new GlobalSNodeIdDescriptor();
  private DataExternalizer<List<GlobalSNodeId>> myDataExternalizer = new ListExternalizer(myKeyDescriptor);
  private DataIndexer<GlobalSNodeId, List<GlobalSNodeId>, FileContent> myIndexer = new ClassifierSuccessorsIndexer.Indexer();

  public ClassifierSuccessorsIndexer() {
  }

  public ID<GlobalSNodeId, List<GlobalSNodeId>> getName() {
    return NAME;
  }

  public int getVersion() {
    return 4;
  }

  public boolean dependsOnFileContent() {
    return true;
  }

  public FileBasedIndex.InputFilter getInputFilter() {
    return myInputFilter;
  }

  public KeyDescriptor<GlobalSNodeId> getKeyDescriptor() {
    return myKeyDescriptor;
  }

  public DataExternalizer<List<GlobalSNodeId>> getValueExternalizer() {
    return myDataExternalizer;
  }

  public DataIndexer<GlobalSNodeId, List<GlobalSNodeId>, FileContent> getIndexer() {
    return myIndexer;
  }

  private static class InputFilter implements FileBasedIndex.InputFilter {
    private InputFilter() {
    }

    public boolean acceptInput(VirtualFile file) {
      return MPSFileTypeFactory.MODEL_FILE_TYPE.equals(file.getFileType());
    }
  }

  private static class Indexer implements DataIndexer<GlobalSNodeId, List<GlobalSNodeId>, FileContent> {
    private Indexer() {
    }

    @NotNull
    public Map<GlobalSNodeId, List<GlobalSNodeId>> map(final FileContent inputData) {
      final Map<GlobalSNodeId, List<GlobalSNodeId>> result = MapSequence.fromMap(new HashMap<GlobalSNodeId, List<GlobalSNodeId>>());
      ModelAccess.instance().runIndexing(new Runnable() {
        public void run() {
          SModel sModel = BaseSNodeDescriptorIndex.doModelParsing(inputData);
          for (final SNode nextNode : sModel.nodes()) {
            if (isInstanceOfClassConcept(nextNode)) {
              SNode classNode = (SNode) nextNode;
              if (SLinkOperations.getTarget(classNode, "superclass", true) != null) {
                safeMap(SLinkOperations.getTarget(classNode, "superclass", true), classNode);
              }
              for (SNode implementedInterface : ListSequence.fromList(SLinkOperations.getTargets(classNode, "implementedInterface", true))) {
                safeMap(implementedInterface, classNode);
              }
              if (isInstanceOfAnonymousClassConcept(classNode)) {
                safeMap(classNode.getReference("classifier"), classNode);
              }
            } else if (isInstanceOfInterfaceConcept(nextNode)) {
              SNode interfaceNode = (SNode) nextNode;
              for (SNode extendedInterface : ListSequence.fromList(SLinkOperations.getTargets(interfaceNode, "extendedInterface", true))) {
                safeMap(extendedInterface, interfaceNode);
              }
            }
          }
        }

        private void safeMap(SNode classifierType, SNode node) {
          safeMap(classifierType.getReference("classifier"), node);
        }

        private void safeMap(SReference reference, SNode node) {
          GlobalSNodeId key = GlobalSNodeId.createSNodeId(reference);
          if (key == null) {
            return;
          }
          List<GlobalSNodeId> successors = MapSequence.fromMap(result).get(key);
          if (successors == null) {
            successors = ListSequence.fromList(new ArrayList<GlobalSNodeId>());
            MapSequence.fromMap(result).put(key, successors);
          }
          ListSequence.fromList(successors).addElement(new GlobalSNodeId(node));
        }

        private boolean isInstanceOfClassConcept(SNode node) {
          String conceptFQName = node.getConceptFqName();
          return "jetbrains.mps.baseLanguage.structure.ClassConcept".equals(conceptFQName) || "jetbrains.mps.baseLanguage.structure.AnonymousClass".equals(conceptFQName) || "jetbrains.mps.baseLanguage.structure.EnumClass".equals(conceptFQName) || "jetbrains.mps.baseLanguageInternal.structure.ExtractStaticInnerClassConcept".equals(conceptFQName) || "jetbrains.mps.baseLanguage.unitTest.structure.BTestCase".equals(conceptFQName);
        }

        private boolean isInstanceOfAnonymousClassConcept(SNode node) {
          return "jetbrains.mps.baseLanguage.structure.AnonymousClass".equals(node.getConceptFqName());
        }

        private boolean isInstanceOfInterfaceConcept(SNode node) {
          String conceptFQName = node.getConceptFqName();
          return "jetbrains.mps.baseLanguage.structure.Interface".equals(conceptFQName) || "jetbrains.mps.baseLanguage.structure.Annotation".equals(conceptFQName);
        }
      });
      return result;
    }
  }
}
