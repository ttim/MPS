package jetbrains.mps.build.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.datatransfer.PasteWrapper;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.datatransfer.PasteWrapperContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class PasteWrappers {
  public static List<PasteWrapper> createPasteWrappers() {
    List<PasteWrapper> result = ListSequence.fromList(new ArrayList<PasteWrapper>());
    ListSequence.fromList(result).addElement(new PasteWrapper() {
      public String getSourceConceptFqName() {
        return "jetbrains.mps.build.structure.BuildInputFileSet";
      }

      public String getTargetConceptFqName() {
        return "jetbrains.mps.build.structure.BuildLayout_Node";
      }

      public SNode wrap(PasteWrapperContext _context) {
        SNode cp = SModelOperations.createNewNode(SNodeOperations.getModel(_context.getSourceNode()), "jetbrains.mps.build.structure.BuildLayout_Copy", null);
        SLinkOperations.setTarget(cp, "fileset", _context.getSourceNode(), true);
        return cp;
      }
    });
    ListSequence.fromList(result).addElement(new PasteWrapper() {
      public String getSourceConceptFqName() {
        return "jetbrains.mps.build.structure.BuildInputSingleFolder";
      }

      public String getTargetConceptFqName() {
        return "jetbrains.mps.build.structure.BuildSource_JavaFiles";
      }

      public SNode wrap(PasteWrapperContext _context) {
        SNode nn = SModelOperations.createNewNode(SNodeOperations.getModel(_context.getSourceNode()), "jetbrains.mps.build.structure.BuildSource_JavaFiles", null);
        SLinkOperations.setTarget(nn, "resset", _context.getSourceNode(), true);
        return nn;
      }
    });
    ListSequence.fromList(result).addElement(new PasteWrapper() {
      public String getSourceConceptFqName() {
        return "jetbrains.mps.build.structure.BuildSource_JavaJar";
      }

      public String getTargetConceptFqName() {
        return "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar";
      }

      public SNode wrap(PasteWrapperContext _context) {
        SNode nn = SModelOperations.createNewNode(SNodeOperations.getModel(_context.getSourceNode()), "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar", null);
        SLinkOperations.setTarget(nn, "jar", _context.getSourceNode(), true);
        return nn;
      }
    });
    ListSequence.fromList(result).addElement(new PasteWrapper() {
      public String getSourceConceptFqName() {
        return "jetbrains.mps.build.structure.BuildSource_JavaCP";
      }

      public String getTargetConceptFqName() {
        return "jetbrains.mps.build.structure.BuildSource_JavaLibraryCP";
      }

      public SNode wrap(PasteWrapperContext _context) {
        SNode nn = SModelOperations.createNewNode(SNodeOperations.getModel(_context.getSourceNode()), "jetbrains.mps.build.structure.BuildSource_JavaLibraryCP", null);
        SLinkOperations.setTarget(nn, "classpath", _context.getSourceNode(), true);
        return nn;
      }
    });
    return result;
  }
}
