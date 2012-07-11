package jetbrains.mps.baseLanguageInternal.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class InternalAnonymousClass_Behavior {
  private static Class[] PARAMETERS_3421461530438560389 = {SNode.class};
  private static Class[] PARAMETERS_3421461530438560275 = {SNode.class};
  private static Class[] PARAMETERS_3421461530438560303 = {SNode.class};

  public static void init(SNode thisNode) {
    SPropertyOperations.set(thisNode, "nonStatic", "" + true);
  }

  public static String virtual_getUnitName_5067982036267369911(SNode thisNode) {
    return InternalAnonymousClass_Behavior.call_getJavaName_3421461530438560397(thisNode);
  }

  public static String call_getJavaName_3421461530438560397(SNode thisNode) {
    SNode ancestor = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, true);
    if ((ancestor == null)) {
      return INamedConcept_Behavior.call_getFqName_1213877404258(thisNode);
    }
    return INamedConcept_Behavior.call_getFqName_1213877404258(ancestor) + "$" + InternalAnonymousClass_Behavior.call_getIndexInContainingClass_3421461530438560434(thisNode);
  }

  public static int call_getIndexInContainingClass_3421461530438560434(SNode thisNode) {
    final SNode ancestor = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    int index = ListSequence.fromList(SNodeOperations.getDescendantsWhereConceptInList(ancestor, new String[]{"jetbrains.mps.baseLanguage.structure.AnonymousClass", "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"}, false, new String[]{})).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.getAncestor(it, "jetbrains.mps.baseLanguage.structure.Classifier", false, false) == ancestor;
      }
    }).indexOf(thisNode) + 1;
    return index;
  }

  public static SNode virtual_getSuperclass_1240936569950(SNode thisNode) {
    return new InternalAnonymousClass_Behavior.QuotationClass_bwi1fo_a0a0e().createNode();
  }

  public static String virtual_getNestedName_8540045600162184125(SNode thisNode) {
    SNode containingClassifier = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    return (containingClassifier != null ?
      InternalAnonymousClass_Behavior.call_getAnonymousClassPresentation_3421461530438560331(thisNode, containingClassifier) + Classifier_Behavior.call_getNestedName_8540045600162184125(containingClassifier) :
      Classifier_Behavior.callSuper_getNestedName_8540045600162184125(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass")
    );
  }

  public static String virtual_getFqName_1213877404258(SNode thisNode) {
    SNode containingClassifier = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    return (containingClassifier != null ?
      InternalAnonymousClass_Behavior.call_getAnonymousClassPresentation_3421461530438560331(thisNode, containingClassifier) + INamedConcept_Behavior.call_getFqName_1213877404258(containingClassifier) :
      INamedConcept_Behavior.callSuper_getFqName_1213877404258(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass")
    );
  }

  public static String call_getAnonymousClassPresentation_3421461530438560331(SNode thisNode, SNode containingClassifier) {
    String result = "Anonymous in ";
    SNode containingMethod = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false);
    if (containingMethod != null && SNodeOperations.getParent(containingMethod) == containingClassifier) {
      result += SPropertyOperations.getString(containingMethod, "name") + "() in ";
    }
    return result;
  }

  public static String call_getUnitName_3421461530438560389(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"), "virtual_getUnitName_5067982036267369911", PARAMETERS_3421461530438560389, new Object[]{});
  }

  public static String call_getNestedName_3421461530438560275(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"), "virtual_getNestedName_8540045600162184125", PARAMETERS_3421461530438560275, new Object[]{});
  }

  public static String call_getFqName_3421461530438560303(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"), "virtual_getFqName_1213877404258", PARAMETERS_3421461530438560303, new Object[]{});
  }

  public static String callSuper_getUnitName_3421461530438560389(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"), callerConceptFqName, "virtual_getUnitName_5067982036267369911", PARAMETERS_3421461530438560389, new Object[]{});
  }

  public static String callSuper_getNestedName_3421461530438560275(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"), callerConceptFqName, "virtual_getNestedName_8540045600162184125", PARAMETERS_3421461530438560275, new Object[]{});
  }

  public static String callSuper_getFqName_3421461530438560303(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguageInternal.structure.InternalAnonymousClass"), callerConceptFqName, "virtual_getFqName_1213877404258", PARAMETERS_3421461530438560303, new Object[]{});
  }

  public static class QuotationClass_bwi1fo_a0a0e {
    public QuotationClass_bwi1fo_a0a0e() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
