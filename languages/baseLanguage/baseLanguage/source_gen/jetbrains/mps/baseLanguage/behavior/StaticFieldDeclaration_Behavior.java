package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.Project;
import java.util.List;
import javax.swing.Icon;
import java.util.ArrayList;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.baseLanguage.plugin.IconResourceBundle_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.util.CodeStyleSettings;
import jetbrains.mps.baseLanguage.util.CodeStyleSettingsRegistry;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopeUtils;
import jetbrains.mps.scope.EmptyScope;
import jetbrains.mps.lang.scopes.runtime.LazyScope;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.scopes.StaticFieldDeclarationScope;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class StaticFieldDeclaration_Behavior {
  private static Class[] PARAMETERS_5039675756633082276 = {SNode.class};
  private static Class[] PARAMETERS_4025276038182459921 = {SNode.class};
  private static Class[] PARAMETERS_8986964027630472415 = {SNode.class};
  private static Class[] PARAMETERS_8884554759541381553 = {SNode.class};
  private static Class[] PARAMETERS_3012473318495506818 = {SNode.class, Project.class};
  private static Class[] PARAMETERS_3012473318495506812 = {SNode.class, Project.class};
  private static Class[] PARAMETERS_2496361171403550872 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    List<Icon> markIcons = new ArrayList<Icon>(BaseConcept_Behavior.callSuper_getMarkIcons_3923831204883340393(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"));
    markIcons.add(IconResourceBundle_Behavior.getInstance().getResource("STATICMARK"));
    return markIcons;
  }

  public static boolean virtual_isInitializable_1213877517488(SNode thisNode) {
    return true;
  }

  public static List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
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
    CodeStyleSettings settings = CodeStyleSettingsRegistry.getSettings(project);
    if (settings == null) {
      return "";
    }
    return (settings.getStaticFieldSuffix() == null ?
      "" :
      settings.getStaticFieldSuffix()
    );
  }

  public static String virtual_getPrefix_3012473318495495520(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettingsRegistry.getSettings(project);
    if (settings == null) {
      return "";
    }
    return (settings.getStaticFieldPrefix() == null ?
      "" :
      settings.getStaticFieldPrefix()
    );
  }

  @Nullable
  public static String virtual_getTraceableProperty_5067982036267369901(SNode thisNode) {
    return SPropertyOperations.getString(thisNode, "name");
  }

  public static Scope virtual_getScopeForInterface_1251851371723365208(SNode thisNode, final SNode interfaceNode, SNode[] extendsInterfaces) {
    if (ClassifierScopeUtils.isHierarchyCyclic(interfaceNode)) {
      return new EmptyScope();
    }

    List<Scope> extendsScopes = ListSequence.fromList(new ArrayList<Scope>());
    for (final SNode extendsClassifier : extendsInterfaces) {
      if ((extendsClassifier != null)) {
        ListSequence.fromList(extendsScopes).addElement(new LazyScope(new _FunctionTypes._return_P0_E0<Scope>() {
          public Scope invoke() {
            return ((Scope) BehaviorManager.getInstance().invoke(Object.class, extendsClassifier, "virtual_getVisibleMembers_8083692786967356611", new Class[]{SNode.class, SNode.class, SNode.class}, interfaceNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration")));
          }
        }));
      }
    }
    // todo: staticField??? 
    return new StaticFieldDeclarationScope(SLinkOperations.getTargets(interfaceNode, "staticField", true), extendsScopes);
  }

  public static Scope virtual_getScopeForClass_1251851371723365193(SNode thisNode, final SNode classNode, @Nullable final SNode extendsClass, SNode[] implementsInterfaces) {
    if (ClassifierScopeUtils.isHierarchyCyclic(classNode)) {
      return new EmptyScope();
    }

    List<Scope> extendsScopes = ListSequence.fromList(new ArrayList<Scope>());
    if ((extendsClass != null)) {
      ListSequence.fromList(extendsScopes).addElement(new LazyScope(new _FunctionTypes._return_P0_E0<Scope>() {
        public Scope invoke() {
          return ((Scope) BehaviorManager.getInstance().invoke(Object.class, extendsClass, "virtual_getVisibleMembers_8083692786967356611", new Class[]{SNode.class, SNode.class, SNode.class}, classNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration")));
        }
      }));
    }
    for (final SNode extendsClassifier : implementsInterfaces) {
      if ((extendsClassifier != null)) {
        ListSequence.fromList(extendsScopes).addElement(new LazyScope(new _FunctionTypes._return_P0_E0<Scope>() {
          public Scope invoke() {
            return ((Scope) BehaviorManager.getInstance().invoke(Object.class, extendsClassifier, "virtual_getVisibleMembers_8083692786967356611", new Class[]{SNode.class, SNode.class, SNode.class}, classNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration")));
          }
        }));
      }
    }
    // todo: staticField??? 
    return new StaticFieldDeclarationScope(SLinkOperations.getTargets(classNode, "staticField", true), extendsScopes);
  }

  public static List<Icon> call_getMarkIcons_5039675756633082276(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<Icon>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633082276);
  }

  public static List<SNode> call_getChildrenToDisplayIntention_4025276038182459921(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182459921);
  }

  public static boolean call_isStatic_8986964027630472415(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_isStatic_8986964027630462944", PARAMETERS_8986964027630472415);
  }

  public static Icon call_getAdditionalIcon_8884554759541381553(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Icon) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381553);
  }

  public static String call_getSuffix_3012473318495506818(SNode thisNode, Project project) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506818, project);
  }

  public static String call_getPrefix_3012473318495506812(SNode thisNode, Project project) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506812, project);
  }

  public static String call_getTraceableProperty_2496361171403550872(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), "virtual_getTraceableProperty_5067982036267369901", PARAMETERS_2496361171403550872);
  }

  public static List<Icon> callSuper_getMarkIcons_5039675756633082276(SNode thisNode, String callerConceptFqName) {
    return (List<Icon>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756633082276);
  }

  public static List<SNode> callSuper_getChildrenToDisplayIntention_4025276038182459921(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182459921);
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
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration"), callerConceptFqName, "virtual_getTraceableProperty_5067982036267369901", PARAMETERS_2496361171403550872);
  }
}
