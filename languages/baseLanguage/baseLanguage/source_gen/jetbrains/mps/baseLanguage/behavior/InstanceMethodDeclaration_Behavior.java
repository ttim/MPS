package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import javax.swing.Icon;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.smodel.search.IsInstanceCondition;
import jetbrains.mps.scope.Scope;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.baseLanguage.scopes.ClassifierScopeUtils;
import jetbrains.mps.scope.EmptyScope;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.baseLanguage.scopes.InstanceMethodDeclarationScope;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class InstanceMethodDeclaration_Behavior {
  private static Class[] PARAMETERS_8884554759541381512 = {SNode.class};
  private static Class[] PARAMETERS_4025276038182459792 = {SNode.class};
  private static Class[] PARAMETERS_5014346297260520665 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isDataFlowChecked_1227714048980(SNode thisNode) {
    return !(SPropertyOperations.getBoolean(thisNode, "isAbstract"));
  }

  public static boolean virtual_canBeAnnotated_1233076312117(SNode thisNode) {
    return true;
  }

  public static Icon virtual_getAdditionalIcon_5017341185733863694(SNode thisNode) {
    return IVisible_Behavior.call_getVisibilityIcon_5017341185733869581(thisNode);
  }

  public static boolean virtual_isAbstract_1232982539764(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "isAbstract");
  }

  public static List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
    List<SNode> result = HasAnnotation_Behavior.callSuper_getChildrenToDisplayIntention_4025276038182319200(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration");
    ListSequence.fromList(result).addElement(SLinkOperations.getTarget(thisNode, "visibility", true));
    return result;
  }

  public static SNode virtual_getNearestOverriddenMethod_5358895268254685434(SNode thisNode) {
    SNode parent = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
      parent = SLinkOperations.getTarget(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "classifier", false);
    } else if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      parent = ((SLinkOperations.getTarget(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "superclass", true) == null) ?
        SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object") :
        SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "superclass", true), "classifier", false)
      );
    }
    ClassifierAndSuperClassifiersScope scope = new ClassifierAndSuperClassifiersScope(parent, IClassifiersSearchScope.INSTANCE_METHOD);
    List<SNode> methodDeclarations = (List<SNode>) scope.getNodes(new IsInstanceCondition("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
    for (SNode methodCandidate : methodDeclarations) {
      if (methodCandidate != thisNode && eq_4b3xw6_a0a0a0e0g(SPropertyOperations.getString(methodCandidate, "name"), SPropertyOperations.getString(thisNode, "name")) && (int) ListSequence.fromList(SLinkOperations.getTargets(methodCandidate, "parameter", true)).count() == (int) ListSequence.fromList(SLinkOperations.getTargets(thisNode, "parameter", true)).count()) {
        if (BaseMethodDeclaration_Behavior.call_hasSameSignature_1213877350435(methodCandidate, thisNode)) {
          return methodCandidate;
        }
      }
    }
    return null;
  }

  public static Scope virtual_getScopeForClass_1251851371723365193(SNode thisNode, SNode classNode, @Nullable SNode extendsClass, SNode[] implementsInterfaces) {
    if (ClassifierScopeUtils.isHierarchyCyclic(classNode)) {
      return new EmptyScope();
    }

    // collect extended classifiers 
    List<SNode> extendedClassifiers = ListSequence.fromList(new ArrayList<SNode>());
    if ((extendsClass != null)) {
      ListSequence.fromList(extendedClassifiers).addElement(extendsClass);
    }
    ListSequence.fromList(extendedClassifiers).addSequence(Sequence.fromIterable(Sequence.fromArray(implementsInterfaces)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return (it != null);
      }
    }));
    return new InstanceMethodDeclarationScope(classNode, extendedClassifiers);
  }

  public static Scope virtual_getScopeForInterface_1251851371723365208(SNode thisNode, SNode interfaceNode, SNode[] extendsInterfaces) {
    if (ClassifierScopeUtils.isHierarchyCyclic(interfaceNode)) {
      return new EmptyScope();
    }

    return new InstanceMethodDeclarationScope(interfaceNode, Sequence.fromIterable(Sequence.fromArray(extendsInterfaces)).concat(Sequence.fromIterable(Sequence.fromArray(new SNode[]{SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object")}))));
  }

  public static Icon call_getAdditionalIcon_8884554759541381512(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Icon) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381512, new Object[]{});
  }

  public static List<SNode> call_getChildrenToDisplayIntention_4025276038182459792(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182459792, new Object[]{});
  }

  public static SNode call_getNearestOverriddenMethod_5014346297260520665(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), "virtual_getNearestOverriddenMethod_5358895268254685434", PARAMETERS_5014346297260520665, new Object[]{});
  }

  public static Icon callSuper_getAdditionalIcon_8884554759541381512(SNode thisNode, String callerConceptFqName) {
    return (Icon) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), callerConceptFqName, "virtual_getAdditionalIcon_5017341185733863694", PARAMETERS_8884554759541381512, new Object[]{});
  }

  public static List<SNode> callSuper_getChildrenToDisplayIntention_4025276038182459792(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), callerConceptFqName, "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182459792, new Object[]{});
  }

  public static SNode callSuper_getNearestOverriddenMethod_5014346297260520665(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), callerConceptFqName, "virtual_getNearestOverriddenMethod_5358895268254685434", PARAMETERS_5014346297260520665, new Object[]{});
  }

  private static boolean eq_4b3xw6_a0a0a0e0g(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
