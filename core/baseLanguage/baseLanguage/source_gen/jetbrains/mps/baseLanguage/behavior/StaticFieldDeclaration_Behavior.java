package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import javax.swing.Icon;
import java.util.ArrayList;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.baseLanguage.icons.Icons;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import com.intellij.openapi.project.Project;
import jetbrains.mps.codeStyle.CodeStyleSettings;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class StaticFieldDeclaration_Behavior {
  private static Class[] PARAMETERS_5039675756633082276 = {SNode.class};
  private static Class[] PARAMETERS_4025276038182459921 = {SNode.class};
  private static Class[] PARAMETERS_8986964027630472415 = {SNode.class};
  private static Class[] PARAMETERS_8884554759541381553 = {SNode.class};
  private static Class[] PARAMETERS_3012473318495506818 = {SNode.class ,Object.class};
  private static Class[] PARAMETERS_3012473318495506812 = {SNode.class ,Object.class};
  private static Class[] PARAMETERS_2496361171403550872 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    List<Icon> markIcons = new ArrayList<Icon>(BaseConcept_Behavior.callSuper_getMarkIcons_3923831204883340393(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"));
    markIcons.add(Icons.STATIC_MARK_ICON);
    return markIcons;
  }

  public static boolean virtual_isInitializable_1213877517488(SNode thisNode) {
    return true;
  }

  public static List<SNode> virtual_getChildrenToDisplayIntention_4025276038182325660(SNode thisNode) {
    List<SNode> result = HasAnnotation_Behavior.callSuper_getChildrenToDisplayIntention_4025276038182319200(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration");
    ListSequence.fromList(result).addElement(SLinkOperations.getTarget(thisNode, "visibility", true));
    return result;
  }

  public static boolean virtual_isStatic_8986964027630462944(SNode thisNode) {
    return true;
  }

  public static Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return IVisible_Behavior.call_getVisibilityIcon_5017341185733869581(thisNode);
  }

  public static String virtual_getSuffix_3012473318495499856(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettings.getInstance(project);
    if (settings == null) {
      return "";
    }
    return (settings.getStaticFieldSettings().o2 == null ?
      "" :
      settings.getStaticFieldSettings().o2
    );
  }

  public static String virtual_getPrefix_3012473318495495520(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettings.getInstance(project);
    if (settings == null) {
      return "";
    }
    return (settings.getStaticFieldSettings().o1 == null ?
      "" :
      settings.getStaticFieldSettings().o1
    );
  }

  @Nullable
  public static String virtual_getTraceableProperty_3822000666564591088(SNode thisNode) {
    return SPropertyOperations.getString(thisNode, "name");
  }

  public static List<Icon> call_getMarkIcons_5039675756633082276(SNode thisNode) {
    return (List<Icon>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633082276);
  }

  public static List<SNode> call_getChildrenToDisplayIntention_4025276038182459921(SNode thisNode) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getChildrenToDisplayIntention_4025276038182325660", PARAMETERS_4025276038182459921);
  }

  public static boolean call_isStatic_8986964027630472415(SNode thisNode) {
    return (Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_isStatic_8986964027630462944", PARAMETERS_8986964027630472415);
  }

  public static Icon call_getAdditionalIcon_8884554759541381553(SNode thisNode) {
    return (Icon) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381553);
  }

  public static String call_getSuffix_3012473318495506818(SNode thisNode, Project project) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506818, project);
  }

  public static String call_getPrefix_3012473318495506812(SNode thisNode, Project project) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506812, project);
  }

  public static String call_getTraceableProperty_2496361171403550872(SNode thisNode) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getTraceableProperty_3822000666564591088", PARAMETERS_2496361171403550872);
  }

  public static List<Icon> callSuper_getMarkIcons_5039675756633082276(SNode thisNode, String callerConceptFqName) {
    return (List<Icon>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633082276);
  }

  public static List<SNode> callSuper_getChildrenToDisplayIntention_4025276038182459921(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getChildrenToDisplayIntention_4025276038182325660", PARAMETERS_4025276038182459921);
  }

  public static boolean callSuper_isStatic_8986964027630472415(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_isStatic_8986964027630462944", PARAMETERS_8986964027630472415);
  }

  public static Icon callSuper_getAdditionalIcon_8884554759541381553(SNode thisNode, String callerConceptFqName) {
    return (Icon) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381553);
  }

  public static String callSuper_getSuffix_3012473318495506818(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506818, project);
  }

  public static String callSuper_getPrefix_3012473318495506812(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506812, project);
  }

  public static String callSuper_getTraceableProperty_2496361171403550872(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getTraceableProperty_3822000666564591088", PARAMETERS_2496361171403550872);
  }
}
