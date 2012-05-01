package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.logging.Logger;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import javax.swing.Icon;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.baseLanguage.plugin.IconResourceBundle_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.search.IsInstanceCondition;
import java.util.HashSet;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.scopes.MemberScopes;
import jetbrains.mps.lang.scopes.runtime.NamedElementsScope;
import jetbrains.mps.scope.EmptyScope;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ClassConcept_Behavior {
  private static Class[] PARAMETERS_7941158526576616766 = {SNode.class};
  private static Class[] PARAMETERS_5039675756632924553 = {SNode.class};
  private static Class[] PARAMETERS_1240936569950 = {SNode.class};
  private static Class[] PARAMETERS_2496361171403551057 = {SNode.class};
  private static Logger LOG = Logger.getLogger(ClassConcept_Behavior.class);

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getMembers_1213877531970(SNode thisNode) {
    List<SNode> members = IMemberContainer_Behavior.callSuper_getMembers_1213877531970(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept");
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "field", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "constructor", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticInnerClassifiers", true)));
    return members;
  }

  public static List<SNode> virtual_getExtendedClassifierTypes_2201875424516179426(SNode thisNode) {
    List<SNode> extendsClassifiers = new ArrayList<SNode>();
    if (!(Classifier_Behavior.call_isSame_4855996797771684010(SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object"), thisNode))) {
      SNode superClassifier = SLinkOperations.getTarget(thisNode, "superclass", true);
      ListSequence.fromList(extendsClassifiers).addElement(((SLinkOperations.getTarget(superClassifier, "classifier", false) != null) ?
        superClassifier :
        Classifier_Behavior.call_getThisType_3305065273710880775(SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object"))
      ));
    }
    ListSequence.fromList(extendsClassifiers).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "implementedInterface", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return (SLinkOperations.getTarget(it, "classifier", false) != null);
      }
    }));
    return extendsClassifiers;
  }

  public static boolean virtual_isRunnable_7941158526576616752(SNode thisNode) {
    return (ClassConcept_Behavior.call_getMainMethod_1213877355884(thisNode) != null);
  }

  public static List<Icon> virtual_getMarkIcons_3923831204883340393(SNode thisNode) {
    List<Icon> markIcons = new ArrayList<Icon>(BaseConcept_Behavior.callSuper_getMarkIcons_3923831204883340393(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"));
    if ((ClassConcept_Behavior.call_getMainMethod_1213877355884(thisNode) != null)) {
      markIcons.add(IconResourceBundle_Behavior.getInstance().getResource("RUNNABLEMARK"));
    }
    if (SPropertyOperations.getBoolean(thisNode, "isFinal")) {
      markIcons.add(IconResourceBundle_Behavior.getInstance().getResource("FINALMARK"));
    }
    return markIcons;
  }

  public static boolean virtual_isDescendant_checkLoops_7165541881557222950(SNode thisNode, SNode nodeToCompare, Set<SNode> visited) {
    if (Classifier_Behavior.call_isSame_4855996797771684010(nodeToCompare, SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object"))) {
      return true;
    }
    if (SetSequence.fromSet(visited).contains(thisNode)) {
      LOG.error("circular hierarchy in class " + INamedConcept_Behavior.call_getFqName_1213877404258(thisNode));
      return false;
    }
    if (Classifier_Behavior.call_isSame_4855996797771684010(thisNode, nodeToCompare)) {
      return true;
    }
    if (SLinkOperations.getTarget(thisNode, "superclass", true) == null) {
      return false;
    }
    SetSequence.fromSet(visited).addElement(thisNode);
    return Classifier_Behavior.call_isDescendant_checkLoops_7165541881557222950(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "superclass", true), "classifier", false), nodeToCompare, visited);
  }

  public static boolean virtual_checkLoops_3980490811621705349(SNode thisNode, Set<SNode> visited) {
    if (SetSequence.fromSet(visited).contains(thisNode)) {
      LOG.error("circular hierarchy in class " + INamedConcept_Behavior.call_getFqName_1213877404258(thisNode));
      return false;
    }
    if (SLinkOperations.getTarget(thisNode, "superclass", true) == null) {
      return true;
    }
    SetSequence.fromSet(visited).addElement(thisNode);
    // todo: not only superclass 
    return Classifier_Behavior.call_checkLoops_3980490811621705349(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "superclass", true), "classifier", false), visited);
  }

  public static SNode call_getMainMethod_1213877355884(SNode thisNode) {
    return ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return StaticMethodDeclaration_Behavior.call_isMainMethod_1213877536670(it);
      }
    }).first();
  }

  public static boolean virtual_hasStaticMemebers_1214840444586(SNode thisNode) {
    return Classifier_Behavior.callSuper_hasStaticMemebers_1214840444586(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept") || ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)).count() > 0;
  }

  public static List<SNode> virtual_getMethodsToImplement_5418393554803775106(SNode thisNode) {
    List<SNode> methods = new ArrayList<SNode>();
    ClassifierAndSuperClassifiersScope scope = new ClassifierAndSuperClassifiersScope(thisNode, IClassifiersSearchScope.INSTANCE_METHOD);
    // todo do not show already implemented methods 
    for (SNode method : ((List<SNode>) scope.getNodes())) {
      boolean isOverridden = false;
      List<SNode> overridenMethods = scope.getOverriddenMethods(method);
      for (SNode overridingMethod : overridenMethods) {
        isOverridden = isOverridden || (SNodeOperations.isInstanceOf(overridingMethod, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration") && SConceptPropertyOperations.getBoolean(SNodeOperations.cast(overridingMethod, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), "abstract"));
      }
      if (isOverridden) {
        continue;
      }

      SNode container = SNodeOperations.getAncestor(method, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
      if (container == thisNode || container == null) {
        continue;
      }
      if (SNodeOperations.isInstanceOf(container, "jetbrains.mps.baseLanguage.structure.Interface") || SPropertyOperations.getBoolean(method, "isAbstract")) {
        ListSequence.fromList(methods).addElement(method);
      }
    }
    return methods;
  }

  public static List<SNode> virtual_getMethodsToOverride_5418393554803767537(SNode thisNode) {
    List<SNode> methods = new ArrayList<SNode>();
    ClassifierAndSuperClassifiersScope scope = new ClassifierAndSuperClassifiersScope(thisNode, IClassifiersSearchScope.INSTANCE_METHOD);
    List<SNode> methodDeclarations = (List<SNode>) scope.getNodes(new IsInstanceCondition("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"));
    for (SNode method : methodDeclarations) {
      SNode cls = SNodeOperations.getAncestor(method, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
      if (cls == thisNode) {
        continue;
      }
      if (!(SNodeOperations.isInstanceOf(cls, "jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
        continue;
      }
      if (SPropertyOperations.getBoolean(method, "isFinal")) {
        continue;
      }
      if (SPropertyOperations.getBoolean(method, "isAbstract")) {
        continue;
      }
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PrivateVisibility")) {
        continue;
      }
      ListSequence.fromList(methods).addElement(method);
    }
    return methods;
  }

  public static SNode virtual_getSuperclass_1240936569950(SNode thisNode) {
    if (Classifier_Behavior.call_isSame_4855996797771684010(SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object"), thisNode)) {
      return null;
    }
    return (SLinkOperations.getTarget(thisNode, "superclass", true) != null ?
      SLinkOperations.getTarget(thisNode, "superclass", true) :
      new ClassConcept_Behavior.QuotationClass_xjj00_a0a1a11().createNode()
    );
  }

  public static List<SNode> virtual_getOwnMethods_1906502351318572840(SNode thisNode) {
    List<SNode> baseMethodDeclarations = new ArrayList<SNode>();
    ListSequence.fromList(baseMethodDeclarations).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "method", true)));
    ListSequence.fromList(baseMethodDeclarations).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)));
    return baseMethodDeclarations;
  }

  public static String virtual_getUnitName_5067982036267369911(SNode thisNode) {
    String fqName = INamedConcept_Behavior.call_getFqName_1213877404258(thisNode);
    if (SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.Classifier", false, false) == null) {
      return fqName;
    }
    int index = fqName.lastIndexOf(".");
    if (index <= 0) {
      return fqName;
    }
    return fqName.substring(0, index) + "$" + fqName.substring(index + 1);
  }

  public static List<SNode> call_getAllSuperClassifiers_4892662966716545618(SNode thisNode) {
    Set<SNode> seen = SetSequence.fromSet(new HashSet<SNode>());
    List<SNode> result = new ArrayList<SNode>();
    Queue<SNode> q = QueueSequence.fromQueue(new LinkedList<SNode>());
    QueueSequence.fromQueue(q).addLastElement(thisNode);
    while (QueueSequence.fromQueue(q).isNotEmpty()) {
      SNode qn = QueueSequence.fromQueue(q).removeFirstElement();
      ListSequence.fromList(result).addElement(qn);
      if (SNodeOperations.isInstanceOf(qn, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
        if ((SLinkOperations.getTarget(SNodeOperations.cast(qn, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "superclass", true) != null)) {
          SNode cl = SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(qn, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "superclass", true), "classifier", false);
          if (seen.add(cl)) {
            QueueSequence.fromQueue(q).addLastElement(cl);
          }
        }
        for (SNode i : SLinkOperations.getTargets(SNodeOperations.cast(qn, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "implementedInterface", true)) {
          SNode cl = SLinkOperations.getTarget(i, "classifier", false);
          if (seen.add(cl)) {
            QueueSequence.fromQueue(q).addLastElement(cl);
          }
        }
      } else if (SNodeOperations.isInstanceOf(qn, "jetbrains.mps.baseLanguage.structure.Interface")) {
        for (SNode i : SLinkOperations.getTargets(SNodeOperations.cast(qn, "jetbrains.mps.baseLanguage.structure.Interface"), "extendedInterface", true)) {
          SNode cl = SLinkOperations.getTarget(i, "classifier", false);
          if (seen.add(cl)) {
            QueueSequence.fromQueue(q).addLastElement(cl);
          }
        }
      }
    }
    SNode obj = new ClassConcept_Behavior.QuotationClass_xjj00_a0a5a41().createNode();
    if (seen.add(SLinkOperations.getTarget(obj, "classifier", false))) {
      ListSequence.fromList(result).addElement(SLinkOperations.getTarget(obj, "classifier", false));
    }
    return result;
  }

  public static Scope virtual_getMembers_2201875424515824604(SNode thisNode, SNode kind) {
    SNode superClass = SLinkOperations.getTarget(ClassConcept_Behavior.call_getSuperclass_1240936569950(thisNode), "classifier", false);
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.ClassifierMember")) {
      Iterable<SNode> implementedInterfaces = ListSequence.fromList(SLinkOperations.getTargets(thisNode, "implementedInterface", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (SLinkOperations.getTarget(it, "classifier", false) != null);
        }
      }).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "classifier", false);
        }
      }).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return (it != null);
        }
      });
      if (!(SNodeOperations.isInstanceOf(superClass, "jetbrains.mps.baseLanguage.structure.ClassConcept") || (superClass == null)) || Sequence.fromIterable(implementedInterfaces).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return !(SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Interface"));
        }
      })) {
        // todo: wtf? 
        LOG.warning("Illegal ClassConcept: " + thisNode);
        // <node> 
      }
      return MemberScopes.forClass(SNodeOperations.castConcept(kind, "jetbrains.mps.baseLanguage.structure.ClassifierMember"), thisNode, (SNodeOperations.isInstanceOf(superClass, "jetbrains.mps.baseLanguage.structure.ClassConcept") ?
        SNodeOperations.cast(superClass, "jetbrains.mps.baseLanguage.structure.ClassConcept") :
        null
      ), Sequence.fromIterable(implementedInterfaces).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.baseLanguage.structure.Interface");
        }
      }).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SNodeOperations.cast(it, "jetbrains.mps.baseLanguage.structure.Interface");
        }
      }).toGenericArray(SNode.class));
    }

    // todo: remove this code from getMembers to getScope? 
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.ThisConstructorKind")) {
      return new NamedElementsScope(SLinkOperations.getTargets(thisNode, "constructor", true));
    }
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.SuperConstructorKind") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.SuperMethodKind")) {
      if (Classifier_Behavior.call_isSame_4855996797771684010(thisNode, SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object"))) {
        return new EmptyScope();
      }

      if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.SuperConstructorKind")) {
        return MemberScopes.visibleClassifierMembers(superClass, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ThisConstructorKind"), thisNode);
      }
      if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.SuperMethodKind")) {
        return MemberScopes.nonAbstractMethods(MemberScopes.visibleClassifierMembers(superClass, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"), thisNode));
      }
    }

    return Classifier_Behavior.callSuper_getMembers_2201875424515824604(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", kind);
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.ThisConstructorKind") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.SuperConstructorKind") || SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.SuperMethodKind")) {
      return Classifier_Behavior.call_getVisibleMembers_8083692786967356611(thisNode, child, kind);
    }
    return ScopeProvider_Behavior.callSuper_getScope_3734116213129936182(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", kind, child);
  }

  public static boolean call_isRunnable_7941158526576616766(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "virtual_isRunnable_7941158526576616752", PARAMETERS_7941158526576616766);
  }

  public static List<Icon> call_getMarkIcons_5039675756632924553(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<Icon>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756632924553);
  }

  public static SNode call_getSuperclass_1240936569950(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "virtual_getSuperclass_1240936569950", PARAMETERS_1240936569950);
  }

  public static String call_getUnitName_2496361171403551057(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), "virtual_getUnitName_5067982036267369911", PARAMETERS_2496361171403551057);
  }

  public static boolean callSuper_isRunnable_7941158526576616766(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), callerConceptFqName, "virtual_isRunnable_7941158526576616752", PARAMETERS_7941158526576616766);
  }

  public static List<Icon> callSuper_getMarkIcons_5039675756632924553(SNode thisNode, String callerConceptFqName) {
    return (List<Icon>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), callerConceptFqName, "virtual_getMarkIcons_3923831204883340393", PARAMETERS_5039675756632924553);
  }

  public static SNode callSuper_getSuperclass_1240936569950(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), callerConceptFqName, "virtual_getSuperclass_1240936569950", PARAMETERS_1240936569950);
  }

  public static String callSuper_getUnitName_2496361171403551057(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ClassConcept"), callerConceptFqName, "virtual_getUnitName_5067982036267369911", PARAMETERS_2496361171403551057);
  }

  public static SNode getContextClass_8008512149545173402(SNode expr) {
    SNode contextNode = expr;
    SNode parent = SNodeOperations.getAncestor(expr, "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    if (SNodeOperations.isInstanceOf(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
      List<SNode> args = new ArrayList<SNode>();
      ListSequence.fromList(args).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "parameter", true)));
      ListSequence.fromList(args).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(parent, "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "actualArgument", true)));
      for (SNode param : args) {
        if (ListSequence.fromList(SNodeOperations.getDescendants(param, null, true, new String[]{})).contains(expr)) {
          contextNode = parent;
          break;
        }
      }
    }
    return SNodeOperations.getAncestor(contextNode, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
  }

  public static class QuotationClass_xjj00_a0a1a11 {
    public QuotationClass_xjj00_a0a1a11() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_xjj00_a0a5a41 {
    public QuotationClass_xjj00_a0a5a41() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
