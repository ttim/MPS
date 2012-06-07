package jetbrains.mps.baseLanguage.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.LinkedHashSet;

public class OverridingMethodsFinder {
  private Map<SNode, Set<Tuples._2<SNode, SNode>>> myOverridingToOverridenMethodsMap = MapSequence.fromMap(new HashMap<SNode, Set<Tuples._2<SNode, SNode>>>());

  public OverridingMethodsFinder(SNode container) {
    this(container, getInstanceMethods(container));
  }

  public OverridingMethodsFinder(SNode container, Iterable<SNode> methods) {
    Map<String, Set<SNode>> nameToMethodsMap = MapSequence.fromMap(new HashMap<String, Set<SNode>>());
    for (SNode methodToCheck : Sequence.fromIterable(methods).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return canOverride(it);
      }
    })) {
      SetSequence.fromSet(safeGet(nameToMethodsMap, SPropertyOperations.getString(methodToCheck, "name"))).addElement(methodToCheck);
    }
    if (MapSequence.fromMap(nameToMethodsMap).isNotEmpty()) {
      collectOverridingMethodsInClassifierHierarchy(container, nameToMethodsMap, SetSequence.fromSet(new HashSet<SNode>()));
    }
  }

  public Set<SNode> getOverridingMethods() {
    return MapSequence.fromMap(this.myOverridingToOverridenMethodsMap).keySet();
  }

  public Set<Tuples._2<SNode, SNode>> getOverridenMethods(SNode overridingMethod) {
    return MapSequence.fromMap(this.myOverridingToOverridenMethodsMap).get(overridingMethod);
  }

  private void collectOverridingMethodsInClassifierHierarchy(SNode classifier, final Map<String, Set<SNode>> nameToMethodsMap, final Set<SNode> visitedClassifiers) {
    if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      SNode clazz = SNodeOperations.cast(classifier, "jetbrains.mps.baseLanguage.structure.ClassConcept");
      SNode superClass = ((SLinkOperations.getTarget(clazz, "superclass", true) != null) ?
        SLinkOperations.getTarget(SLinkOperations.getTarget(clazz, "superclass", true), "classifier", false) :
        SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Object")
      );
      if (addIfNotContains(visitedClassifiers, superClass)) {
        collectOverridingMethods(superClass, nameToMethodsMap, visitedClassifiers);
      }
      ListSequence.fromList(SLinkOperations.getTargets(clazz, "implementedInterface", true)).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "classifier", false);
        }
      }).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return addIfNotContains(visitedClassifiers, it);
        }
      }).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          collectOverridingMethods(it, nameToMethodsMap, visitedClassifiers);
        }
      });
      if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
        SNode superClassifier = SLinkOperations.getTarget(SNodeOperations.cast(classifier, "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "classifier", false);
        if (addIfNotContains(visitedClassifiers, superClassifier)) {
          collectOverridingMethods(superClassifier, nameToMethodsMap, visitedClassifiers);
        }
      }
    } else if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.Interface")) {
      ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(classifier, "jetbrains.mps.baseLanguage.structure.Interface"), "extendedInterface", true)).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SLinkOperations.getTarget(it, "classifier", false);
        }
      }).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return addIfNotContains(visitedClassifiers, it);
        }
      }).visitAll(new IVisitor<SNode>() {
        public void visit(SNode it) {
          collectOverridingMethods(it, nameToMethodsMap, visitedClassifiers);
        }
      });
    }
  }

  private void collectOverridingMethods(SNode classifier, Map<String, Set<SNode>> nameToMethodsMap, Set<SNode> visitedClassifiers) {
    Map<String, Set<SNode>> methodNameToMethodMapCopy = MapSequence.fromMap(new HashMap<String, Set<SNode>>());
    for (String methodName : SetSequence.fromSet(MapSequence.fromMap(nameToMethodsMap).keySet())) {
      SetSequence.fromSet(safeGet(methodNameToMethodMapCopy, methodName)).addSequence(SetSequence.fromSet(MapSequence.fromMap(nameToMethodsMap).get(methodName)));
    }
    for (final SNode classifierMethod : ListSequence.fromList(SLinkOperations.getTargets(classifier, "method", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return canBeOverriden(it);
      }
    })) {
      Set<SNode> similarMethods = MapSequence.fromMap(methodNameToMethodMapCopy).get(SPropertyOperations.getString(classifierMethod, "name"));
      if (similarMethods == null) {
        continue;
      }
      List<SNode> overridingMethods = new ArrayList<SNode>();
      for (SNode overridingMethod : SetSequence.fromSet(similarMethods).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return ((Boolean) BehaviorManager.getInstance().invoke(Boolean.class, classifierMethod, "call_hasSameSignature_1213877350435", new Class[]{SNode.class, SNode.class}, it));
        }
      })) {
        SetSequence.fromSet(safeGet(this.myOverridingToOverridenMethodsMap, overridingMethod)).addElement(MultiTuple.<SNode,SNode>from(classifierMethod, classifier));
        ListSequence.fromList(overridingMethods).addElement(overridingMethod);
      }
      SetSequence.fromSet(similarMethods).removeSequence(ListSequence.fromList(overridingMethods));
      if (SetSequence.fromSet(similarMethods).isEmpty()) {
        MapSequence.fromMap(methodNameToMethodMapCopy).removeKey(SPropertyOperations.getString(classifierMethod, "name"));
      }
    }
    if (!(MapSequence.fromMap(methodNameToMethodMapCopy).isEmpty())) {
      collectOverridingMethodsInClassifierHierarchy(classifier, methodNameToMethodMapCopy, visitedClassifiers);
    }
  }

  public static Iterable<SNode> getInstanceMethods(final SNode containingClassifier) {
    Iterable<SNode> result = Sequence.fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        return SLinkOperations.getTargets(containingClassifier, "method", true);
      }
    });
    if (SNodeOperations.isInstanceOf(containingClassifier, "jetbrains.mps.baseLanguage.structure.EnumClass")) {
      for (SNode enumConstant : ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(containingClassifier, "jetbrains.mps.baseLanguage.structure.EnumClass"), "enumConstant", true))) {
        result = Sequence.fromIterable(result).concat(ListSequence.fromList(SLinkOperations.getTargets(enumConstant, "method", true)));
      }
    }
    return result;
  }

  public static boolean canOverride(SNode method) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PrivateVisibility")) && isNotEmpty_cdkq07_a0a0a1(SPropertyOperations.getString(method, "name"));
  }

  public static boolean canBeOverriden(SNode method) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PrivateVisibility")) && isNotEmpty_cdkq07_a0a0a2(SPropertyOperations.getString(method, "name"));
  }

  public static <K, V> Set<V> safeGet(Map<K, Set<V>> map, K key) {
    if (!(MapSequence.fromMap(map).containsKey(key))) {
      MapSequence.fromMap(map).put(key, SetSequence.fromSet(new LinkedHashSet<V>()));
    }
    return MapSequence.fromMap(map).get(key);
  }

  private static boolean addIfNotContains(Set<SNode> classifierSet, SNode classifier) {
    if (!(SetSequence.fromSet(classifierSet).contains(classifier))) {
      SetSequence.fromSet(classifierSet).addElement(classifier);
      return true;
    }
    return false;
  }

  public static boolean isNotEmpty_cdkq07_a0a0a1(String str) {
    return str != null && str.length() > 0;
  }

  public static boolean isNotEmpty_cdkq07_a0a0a2(String str) {
    return str != null && str.length() > 0;
  }
}
