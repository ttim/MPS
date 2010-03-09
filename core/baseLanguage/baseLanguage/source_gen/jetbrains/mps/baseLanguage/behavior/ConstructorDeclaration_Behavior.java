package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.core.behavior.IDeprecatable_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import javax.swing.Icon;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ConstructorDeclaration_Behavior {
  private static Class[] PARAMETERS_8884554759541375762 = {SNode.class};
  private static Class[] PARAMETERS_4025276038182459842 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isDeprecated_1224609060727(SNode thisNode) {
    return IDeprecatable_Behavior.callSuper_isDeprecated_1224609060727(thisNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration") || (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.lang.core.structure.IDeprecatable") && IDeprecatable_Behavior.call_isDeprecated_1224609060727(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.lang.core.structure.IDeprecatable")));
  }

  public static boolean virtual_canBeAnnotated_1233076312117(SNode thisNode) {
    return true;
  }

  public static Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return IVisible_Behavior.call_getVisibilityIcon_5017341185733869581(thisNode);
  }

  public static boolean virtual_isReturnsVoid_1234359555698(SNode thisNode) {
    return true;
  }

  public static List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319417(SNode thisNode) {
    List<SNode> result = HasAnnotation_Behavior.callSuper_getChildrenToDisplayIntention_4025276038182319200(thisNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration");
    ListSequence.fromList(result).addElement(SLinkOperations.getTarget(thisNode, "visibility", true));
    return result;
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    return ConstructorDeclaration_Behavior.call_getPresentationInContext_983626226385657373(thisNode, null);
  }

  public static String call_getPresentationInContext_983626226385657373(SNode thisNode, SNode context) {
    StringBuilder result = new StringBuilder();
    result.append(Classifier_Behavior.call_getNestedNameInContext_8540045600162183880(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.ClassConcept"), context));
    result.append("(");
    boolean first = true;
    for (SNode parm : SLinkOperations.getTargets(thisNode, "parameter", true)) {
      if (!(first)) {
        result.append(",");
      }
      first = false;
      if (SLinkOperations.getTarget(parm, "type", true) != null) {
        result.append(BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(parm, "type", true)));
      } else {
        result.append("???");
      }
    }
    result.append(")");
    return result.toString();
  }

  public static String virtual_jniSignature_8847328628797656446(SNode thisNode) {
    StringBuilder sb = new StringBuilder();
    sb.append("(");
    for (SNode p : SLinkOperations.getTargets(thisNode, "parameter", true)) {
      sb.append(Type_Behavior.call_jniSignature_8847328628797633411(SLinkOperations.getTarget(p, "type", true)));
    }
    sb.append(")");
    sb.append("V");
    return sb.toString();
  }

  public static Icon call_getAdditionalIcon_8884554759541375762(SNode thisNode) {
    return (Icon) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541375762);
  }

  public static List<SNode> call_getChildrenToDisplayIntention_4025276038182459842(SNode thisNode) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), "virtual_getChildrenToDisplayIntention_4025276038182319417", PARAMETERS_4025276038182459842);
  }

  public static Icon callSuper_getAdditionalIcon_8884554759541375762(SNode thisNode, String callerConceptFqName) {
    return (Icon) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), callerConceptFqName, "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541375762);
  }

  public static List<SNode> callSuper_getChildrenToDisplayIntention_4025276038182459842(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration"), callerConceptFqName, "virtual_getChildrenToDisplayIntention_4025276038182319417", PARAMETERS_4025276038182459842);
  }
}
