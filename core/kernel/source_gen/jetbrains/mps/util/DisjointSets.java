package jetbrains.mps.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import java.util.HashSet;

public class DisjointSets<T> {
  private Map<T, T> myParent = MapSequence.<T,T>fromMap(new HashMap<T, T>());
  private Map<T, Integer> myRank = MapSequence.<T,Integer>fromMap(new HashMap<T, Integer>());

  public DisjointSets(Iterable<T> elements) {
    for (T e : Sequence.<T>fromIterable(elements)) {
      MapSequence.<T,T>fromMap(myParent).put(e, e);
      MapSequence.<T,Integer>fromMap(myRank).put(e, 0);
    }
  }

  private T getRoot(T x) {
    if (MapSequence.<T,T>fromMap(myParent).get(x) != x) {
      MapSequence.<T,T>fromMap(myParent).put(x, getRoot(MapSequence.<T,T>fromMap(myParent).get(x)));
    }
    return MapSequence.<T,T>fromMap(myParent).get(x);
  }

  public void unite(T a, T b) {
    a = getRoot(a);
    b = getRoot(b);
    if (MapSequence.<T,Integer>fromMap(myRank).get(a) < MapSequence.<T,Integer>fromMap(myRank).get(b)) {
      MapSequence.<T,T>fromMap(myParent).put(a, b);
    } else {
      MapSequence.<T,T>fromMap(myParent).put(b, a);
      if (MapSequence.<T,Integer>fromMap(myRank).get(a) - MapSequence.<T,Integer>fromMap(myRank).get(b) == 0) {
        MapSequence.<T,Integer>fromMap(myRank).put(a, MapSequence.<T,Integer>fromMap(myRank).get(a) + 1);
      }
    }
  }

  public Iterable<Set<T>> getSets() {
    final Map<T, Set<T>> rootToSet = MapSequence.<T,Set<T>>fromMap(new HashMap<T, Set<T>>());
    SetSequence.<T>fromSet(MapSequence.fromMap(myParent).keySet()).visitAll(new IVisitor<T>() {
      public void visit(T x) {
        T r = getRoot(x);
        if (MapSequence.<T,Set<T>>fromMap(rootToSet).get(r) == null) {
          MapSequence.<T,Set<T>>fromMap(rootToSet).put(r, SetSequence.<T>fromSet(new HashSet<T>()));
        }
        SetSequence.fromSet(MapSequence.<T,Set<T>>fromMap(rootToSet).get(r)).addElement(x);
      }
    });
    return MapSequence.fromMap(rootToSet).values();
  }
}
