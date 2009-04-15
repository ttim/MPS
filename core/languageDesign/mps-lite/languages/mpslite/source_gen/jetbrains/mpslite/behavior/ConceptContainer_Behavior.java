package jetbrains.mpslite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class ConceptContainer_Behavior {

  public static void init(SNode thisNode) {
  }

  public static List<SNode> call_getAllConcepts_1239801518275(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "mpsLiteConcept", true)));
    return result;
  }

  public static List<SNode> call_getSimpleMPSliteConcepts_1239802881890(SNode thisNode) {
    Iterable<SNode> mpsLiteConcepts = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "mpsLiteConcept", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mpslite.structure.MPSLiteConceptDeclaration");
      }
    });
    List<SNode> result = ListOperations.<SNode>createList();
    for(SNode n : Sequence.fromIterable(mpsLiteConcepts)) {
      ListSequence.fromList(result).addElement(SNodeOperations.cast(n, "jetbrains.mpslite.structure.MPSLiteConceptDeclaration"));
    }
    return result;
  }

  public static List<SNode> call_getBinaryOperationConcepts_1239806149720(SNode thisNode) {
    Iterable<SNode> mpsLiteConcepts = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "mpsLiteConcept", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mpslite.structure.BinaryOperationConcept");
      }
    });
    List<SNode> result = ListOperations.<SNode>createList();
    for(SNode n : Sequence.fromIterable(mpsLiteConcepts)) {
      ListSequence.fromList(result).addElement(SNodeOperations.cast(n, "jetbrains.mpslite.structure.BinaryOperationConcept"));
    }
    return result;
  }

  public static List<SNode> call_getVariableConcepts_1239806150736(SNode thisNode) {
    Iterable<SNode> mpsLiteConcepts = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "mpsLiteConcept", true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mpslite.structure.MPSLiteConceptDeclaration");
      }
    });
    List<SNode> result = ListOperations.<SNode>createList();
    for(SNode n : Sequence.fromIterable(mpsLiteConcepts)) {
      ListSequence.fromList(result).addElement(SNodeOperations.cast(n, "jetbrains.mpslite.structure.VariableConcept"));
    }
    return result;
  }

}
