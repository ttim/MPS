package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.intellij.openapi.project.Project;
import jetbrains.mps.codeStyle.CodeStyleSettings;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class LocalVariableDeclaration_Behavior {
  private static Class[] PARAMETERS_3012473318495506424 = {SNode.class ,Object.class};
  private static Class[] PARAMETERS_3012473318495506430 = {SNode.class ,Object.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isInitializable_1213877517488(SNode thisNode) {
    SNode parent = SNodeOperations.getParent(thisNode);
    return SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement") || SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.ForStatement");
  }

  public static SNode virtual_createReference_1213877517482(SNode thisNode) {
    SNode ref = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.LocalVariableReference", null);
    SLinkOperations.setTarget(ref, "variableDeclaration", thisNode, false);
    return ref;
  }

  public static boolean call_isVariableReferencedInClosures_1229352990212(SNode thisNode) {
    SNode container = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.IStatementListContainer", false, false);
    {
      SNode ref;
      Iterator<SNode> ref_iterator = ListSequence.fromList(SNodeOperations.getDescendants(container, "jetbrains.mps.baseLanguage.structure.LocalVariableReference", false, new String[]{})).iterator();
      while (true) {
        if (!(ref_iterator.hasNext())) {
          break;
        }
        ref = ref_iterator.next();
        if (SLinkOperations.getTarget(ref, "variableDeclaration", false) == thisNode) {
          SNode referenceContainer = SNodeOperations.getAncestor(ref, "jetbrains.mps.baseLanguage.structure.IStatementListContainer", false, false);
          if (referenceContainer != container && SNodeOperations.isInstanceOf(referenceContainer, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static String virtual_getPrefix_3012473318495495520(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettings.getInstance(project);
    if (settings == null) {
      return "";
    }
    return (settings.getLocalVariableSettings().o1 == null ?
      "" :
      settings.getLocalVariableSettings().o1
    );
  }

  public static String virtual_getSuffix_3012473318495499856(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettings.getInstance(project);
    if (settings == null) {
      return "";
    }
    return (settings.getLocalVariableSettings().o2 == null ?
      "" :
      settings.getLocalVariableSettings().o2
    );
  }

  public static String call_getPrefix_3012473318495506424(SNode thisNode, Project project) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506424, project);
  }

  public static String call_getSuffix_3012473318495506430(SNode thisNode, Project project) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506430, project);
  }

  public static String callSuper_getPrefix_3012473318495506424(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), callerConceptFqName, "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506424, project);
  }

  public static String callSuper_getSuffix_3012473318495506430(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), callerConceptFqName, "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506430, project);
  }
}
