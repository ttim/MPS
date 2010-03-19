package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.baseLanguage.structure.Classifier;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.ClassifierType;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class ClassifierVisibleStaticMembersScope extends ClassifierVisibleMembersScope {
  public ClassifierVisibleStaticMembersScope(@Nullable Classifier classifier, @Nullable SNode contextNode, int constraint) {
    super(((ClassifierType) SNodeOperations.getAdapter(ClassifierVisibleStaticMembersScope.toClassifierType(classifier))), contextNode, constraint);
    if ((constraint & IClassifiersSearchScope.STATIC_MEMBER) != constraint) {
      throw new IllegalArgumentException("only static members are applicable");
    }
  }

  public ClassifierVisibleStaticMembersScope(@Nullable SNode classifier, @Nullable SNode contextNode, int constraint) {
    super(toClassifierType(classifier), contextNode, constraint);
  }

  private static SNode toClassifierType(SNode classifier) {
    if (classifier == null) {
      return null;
    }
    return new ClassifierVisibleStaticMembersScope.QuotationClass_ctg1ot_a0b0a().createNode(classifier);
  }

  private static SNode toClassifierType(Classifier classifier) {
    if (classifier == null) {
      return null;
    }
    return toClassifierType((SNode) classifier.getNode());
  }

  public static class QuotationClass_ctg1ot_a0b0a {
    public QuotationClass_ctg1ot_a0b0a() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
