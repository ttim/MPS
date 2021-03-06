package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ConceptEditorDeclaration_Behavior {
  private static Class[] PARAMETERS_8952337903384629359 = {SNode.class};
  private static Class[] PARAMETERS_6261424444345979340 = {SNode.class, SNode.class};
  private static Class[] PARAMETERS_7839831476331825169 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getBaseConcept_2621449412040133768(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "conceptDeclaration", false);
  }

  public static void virtual_setBaseConcept_6261424444345963020(SNode thisNode, SNode baseConcept) {
    SLinkOperations.setTarget(thisNode, "conceptDeclaration", baseConcept, false);
  }

  public static boolean virtual_isApplicable_7839831476331657915(SNode thisNode, SNode candidate) {
    List<SNode> createdEditors = AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_1567570417158062208(candidate, LanguageAspect.EDITOR);
    for (SNode createdEditor : createdEditors) {
      if (SNodeOperations.isInstanceOf(createdEditor, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration")) {
        return false;
      }
    }
    return true;
  }

  public static void call_createDefaultEditor_2970389781192937380(SNode thisNode, boolean multiline) {
    if (multiline) {
      new DefaultEditorBuilder(thisNode).buildStatementLike();
    } else {
      new DefaultEditorBuilder(thisNode).buildExpressionLike();
    }
  }

  public static SNode call_getBaseConcept_8952337903384629359(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), "virtual_getBaseConcept_2621449412040133768", PARAMETERS_8952337903384629359, new Object[]{});
  }

  public static void call_setBaseConcept_6261424444345979340(SNode thisNode, SNode baseConcept) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345979340, new Object[]{baseConcept});
  }

  public static boolean call_isApplicable_7839831476331825169(SNode thisNode, SNode candidate) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), "virtual_isApplicable_7839831476331657915", PARAMETERS_7839831476331825169, new Object[]{candidate});
  }

  public static SNode callSuper_getBaseConcept_8952337903384629359(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), callerConceptFqName, "virtual_getBaseConcept_2621449412040133768", PARAMETERS_8952337903384629359, new Object[]{});
  }

  public static void callSuper_setBaseConcept_6261424444345979340(SNode thisNode, String callerConceptFqName, SNode baseConcept) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), callerConceptFqName, "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345979340, new Object[]{baseConcept});
  }

  public static boolean callSuper_isApplicable_7839831476331825169(SNode thisNode, String callerConceptFqName, SNode candidate) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"), callerConceptFqName, "virtual_isApplicable_7839831476331657915", PARAMETERS_7839831476331825169, new Object[]{candidate});
  }
}
