package jetbrains.mps.make.runtime.internal.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class CycleDetector<V> {
  private Map<V, CycleDetector.Data> dataMap = MapSequence.fromMap(new HashMap<V, CycleDetector.Data>());

  public CycleDetector() {
  }

  public abstract Iterable<V> forwardEdges(V v);

  public abstract Iterable<V> backwardEdges(V v);

  public List<List<V>> findCycles(Iterable<V> vertices) {
    MapSequence.fromMap(dataMap).clear();
    Sequence.fromIterable(vertices).visitAll(new IVisitor<V>() {
      public void visit(V v) {
        MapSequence.fromMap(dataMap).put(v, new CycleDetector.Data());
      }
    });
    final Wrappers._int time = new Wrappers._int(0);
    Sequence.fromIterable(vertices).visitAll(new IVisitor<V>() {
      public void visit(V v) {
        if (CycleDetector.Color.WHITE == MapSequence.fromMap(dataMap).get(v).color) {
          time.value = visitForward(v, time.value);
        }
      }
    });
    final List<List<V>> cycles = ListSequence.fromList(new ArrayList<List<V>>());
    Sequence.fromIterable(vertices).sort(new Comparator<V>() {
      public int compare(V a, V b) {
        return MapSequence.fromMap(dataMap).get(b).endTime - MapSequence.fromMap(dataMap).get(a).endTime;
      }
    }, true).visitAll(new IVisitor<V>() {
      public void visit(V v) {
        if (CycleDetector.Color.BLACK == MapSequence.fromMap(dataMap).get(v).color) {
          visitBackward(v);
          if (ListSequence.fromList(MapSequence.fromMap(dataMap).get(v).successors).isNotEmpty()) {
            List<V> cycle = ListSequence.fromListAndArray(new ArrayList<V>(), v);
            addSuccessors(v, cycle);
            ListSequence.fromList(cycles).addElement(cycle);
          }
        }
      }
    });
    return cycles;
  }

  private void addSuccessors(V v, final List<V> list) {
    List<V> successors = MapSequence.fromMap(dataMap).get(v).successors;
    ListSequence.fromList(list).addSequence(ListSequence.fromList(successors));
    ListSequence.fromList(successors).visitAll(new IVisitor<V>() {
      public void visit(V succ) {
        addSuccessors(succ, list);
      }
    });
  }

  private int visitForward(V v, int time) {
    final Wrappers._int _time = new Wrappers._int(time);
    CycleDetector.Data data = MapSequence.fromMap(dataMap).get(v);
    data.color = CycleDetector.Color.GRAY;
    data.startTime = ++_time.value;
    Sequence.fromIterable(forwardEdges(v)).visitAll(new IVisitor<V>() {
      public void visit(V next) {
        if (CycleDetector.Color.WHITE == MapSequence.fromMap(dataMap).get(next).color) {
          _time.value = visitForward(next, _time.value);
        }
      }
    });
    data.color = CycleDetector.Color.BLACK;
    data.endTime = ++_time.value;
    return _time.value;
  }

  private void visitBackward(final V v) {
    CycleDetector.Data data = MapSequence.fromMap(dataMap).get(v);
    data.color = CycleDetector.Color.GRAY;
    Sequence.fromIterable(backwardEdges(v)).sort(new Comparator<V>() {
      public int compare(V a, V b) {
        return MapSequence.fromMap(dataMap).get(b).endTime - MapSequence.fromMap(dataMap).get(a).endTime;
      }
    }, true).visitAll(new IVisitor<V>() {
      public void visit(V prev) {
        if (CycleDetector.Color.BLACK == MapSequence.fromMap(dataMap).get(prev).color) {
          MapSequence.fromMap(dataMap).get(v).addSuccessor(prev);
          visitBackward(prev);
        }
      }
    });
    data.color = CycleDetector.Color.WHITE;
  }

  private static   enum Color {
    WHITE(),
    GRAY(),
    BLACK();

    Color() {
    }
  }

  private class Data {
    private CycleDetector.Color color = CycleDetector.Color.WHITE;
    private int startTime = 0;
    private int endTime = 0;
    private List<V> successors;

    private Data() {
    }

    private void addSuccessor(V next) {
      if (successors == null) {
        this.successors = ListSequence.fromList(new ArrayList<V>());
      }
      ListSequence.fromList(successors).addElement(next);
    }
  }
}
