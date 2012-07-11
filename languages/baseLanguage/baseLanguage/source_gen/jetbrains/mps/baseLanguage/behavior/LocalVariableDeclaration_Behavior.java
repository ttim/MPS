package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.Project;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.util.CodeStyleSettings;
import jetbrains.mps.baseLanguage.util.CodeStyleSettingsRegistry;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class LocalVariableDeclaration_Behavior {
  private static Class[] PARAMETERS_3012473318495506424 = {SNode.class, Project.class};
  private static Class[] PARAMETERS_3012473318495506430 = {SNode.class, Project.class};
  private static Class[] PARAMETERS_4163393263914882931 = {SNode.class};

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
      Iterator<SNode> ref_it = ListSequence.fromList(SNodeOperations.getDescendants(container, "jetbrains.mps.baseLanguage.structure.LocalVariableReference", false, new String[]{})).iterator();
      SNode ref_var;
      while (ref_it.hasNext()) {
        ref_var = ref_it.next();
        if (SLinkOperations.getTarget(ref_var, "variableDeclaration", false) == thisNode) {
          SNode referenceContainer = SNodeOperations.getAncestor(ref_var, "jetbrains.mps.baseLanguage.structure.IStatementListContainer", false, false);
          if (referenceContainer != container && SNodeOperations.isInstanceOf(referenceContainer, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static String virtual_getPrefix_3012473318495495520(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettingsRegistry.getSettings(project);
    if (settings == null) {
      return "";
    }
    return (settings.getLocalVariablePrefix() == null ?
      "" :
      settings.getLocalVariablePrefix()
    );
  }

  public static String virtual_getSuffix_3012473318495499856(SNode thisNode, Project project) {
    CodeStyleSettings settings = CodeStyleSettingsRegistry.getSettings(project);
    if (settings == null) {
      return "";
    }
    return (settings.getLocalVariableSuffix() == null ?
      "" :
      settings.getLocalVariableSuffix()
    );
  }

  public static SNode virtual_getValue_1224857430232(SNode thisNode) {
    throw new UnsupportedOperationException();
  }

  public static String call_getPrefix_3012473318495506424(SNode thisNode, Project project) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506424, new Object[]{project});
  }

  public static String call_getSuffix_3012473318495506430(SNode thisNode, Project project) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506430, new Object[]{project});
  }

  public static SNode call_getValue_4163393263914882931(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), "virtual_getValue_1224857430232", PARAMETERS_4163393263914882931, new Object[]{});
  }

  public static String callSuper_getPrefix_3012473318495506424(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), callerConceptFqName, "virtual_getPrefix_3012473318495495520", PARAMETERS_3012473318495506424, new Object[]{project});
  }

  public static String callSuper_getSuffix_3012473318495506430(SNode thisNode, String callerConceptFqName, Project project) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), callerConceptFqName, "virtual_getSuffix_3012473318495499856", PARAMETERS_3012473318495506430, new Object[]{project});
  }

  public static SNode callSuper_getValue_4163393263914882931(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"), callerConceptFqName, "virtual_getValue_1224857430232", PARAMETERS_4163393263914882931, new Object[]{});
  }
}
