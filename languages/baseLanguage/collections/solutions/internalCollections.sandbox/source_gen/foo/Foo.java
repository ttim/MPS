package foo;

/*Generated by MPS */

import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Collections;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.SortedSetSequence;
import java.util.TreeSet;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import java.util.Set;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import java.util.PriorityQueue;
import jetbrains.mps.internal.collections.runtime.backports.Deque;
import jetbrains.mps.internal.collections.runtime.DequeSequence;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import gnu.trove.decorator.TByteObjectHashMapDecorator;
import gnu.trove.TByteObjectHashMap;
import gnu.trove.decorator.TObjectIntHashMapDecorator;
import gnu.trove.TObjectIntHashMap;
import java.util.Collection;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.smodel.SNode;

public class Foo {
  public Foo() {
  }

  public Iterable<Object> abc(final int j) {
    return Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
              private int __CP__ = 0;
              private int _3_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 4:
                      if (j == 0) {
                        this.__CP__ = 5;
                        break;
                      }
                      this.__CP__ = 8;
                      break;
                    case 6:
                      this.__CP__ = 1;
                      this.yield(_3_i);
                      return true;
                    case 0:
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _3_i = 2;
                      this.__CP__ = 6;
                      break;
                    case 8:
                      _3_i = 3;
                      this.__CP__ = 6;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    });
  }

  public static void main(String[] args) {
    final Iterable<Integer> seq = Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
              private int __CP__ = 0;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this.__CP__ = 1;
                      this.yield(2);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    });
    _FunctionTypes._return_P0_E0<? extends Iterable<Integer>> function = new _FunctionTypes._return_P0_E0<Iterable<Integer>>() {
      public Iterable<Integer> invoke() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
              private int __CP__ = 0;
              private Integer _3__yield_rbn_b0a0b0a;
              private Iterator<Integer> _3__yield_rbn_b0a0b0a_it;
              private Integer _8__yield_rbn_d0a0b0a;
              private Iterator<Integer> _8__yield_rbn_d0a0b0a_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 3:
                      this._3__yield_rbn_b0a0b0a_it = Sequence.fromIterable(seq).iterator();
                    case 4:
                      if (!(this._3__yield_rbn_b0a0b0a_it.hasNext())) {
                        this.__CP__ = 6;
                        break;
                      }
                      this._3__yield_rbn_b0a0b0a = this._3__yield_rbn_b0a0b0a_it.next();
                      this.__CP__ = 5;
                      break;
                    case 8:
                      this._8__yield_rbn_d0a0b0a_it = Sequence.fromIterable(seq).iterator();
                    case 9:
                      if (!(this._8__yield_rbn_d0a0b0a_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._8__yield_rbn_d0a0b0a = this._8__yield_rbn_d0a0b0a_it.next();
                      this.__CP__ = 10;
                      break;
                    case 7:
                      this.__CP__ = 4;
                      this.yield(_3__yield_rbn_b0a0b0a);
                      return true;
                    case 6:
                      this.__CP__ = 8;
                      this.yield(1);
                      return true;
                    case 11:
                      this.__CP__ = 9;
                      this.yield(_8__yield_rbn_d0a0b0a);
                      return true;
                    case 0:
                      /*/* error: statement w/o textGen:yield */
                      */
                      this.__CP__ = 3;
                      break;
                    case 5:
                      this.__CP__ = 7;
                      break;
                    case 10:
                      this.__CP__ = 11;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    };
  }

  public static Iterable<String> getSeq() {
    boolean b = true;
    if (b) {
      return Sequence.fromIterable(Collections.<String>emptyList());
      Sequence.fromIterable(Collections.<String>emptyList());
    } else if (b || b) {
      return SetSequence.fromSet(new HashSet<String>());
    } else if (!(b)) {
      return ListSequence.fromList(new ArrayList<String>());
    } else {
      return SortedSetSequence.fromSet(new TreeSet<String>());
    }
  }

  public static List<String> getList() {
    boolean b = true;
    if (b) {
      return ListSequence.fromList(new LinkedList<String>());
    } else {
      return ListSequence.fromList(new ArrayList<String>());
    }
  }

  public static Set<String> getSet() {
    boolean b = true;
    if (b) {
      return SetSequence.fromSet(new TreeSet<String>());
    } else {
      return SetSequence.fromSet(new HashSet<String>());
    }
  }

  public static void asd() {
    List<Integer> l = null;
    ListSequence.fromList(l).addSequence(ListSequence.fromList(l));
    ListSequence.fromList(l).insertElement(0, 1);
    Queue<Integer> q = QueueSequence.fromQueue(new PriorityQueue<Integer>());
    QueueSequence.fromQueue(q).addSequence(ListSequence.fromList(l));
    QueueSequence.fromQueue(q).addSequence(QueueSequence.fromQueue(q));
    Deque<Integer> d = DequeSequence.fromDeque(new LinkedList<Integer>());
    DequeSequence.fromDeque(d).addSequence(DequeSequence.fromDeque(d));
    DequeSequence.fromDeque(d).addFirstElement(1);
    DequeSequence.fromDeque(d).addLastElement(1);
    Deque<Integer> s = DequeSequence.fromDeque(new LinkedList<Integer>());
    DequeSequence.fromDeque(s).addFirstElement(1);
    DequeSequence.fromDeque(s).popElement();
    DequeSequence.fromDeque(s).pushElement(1);
  }

  public static void asf() {
    Map<Byte, Foo> mmm = MapSequence.fromMap(new TByteObjectHashMapDecorator(new TByteObjectHashMap<Foo>()));
    Map<Object, Integer> moi = MapSequence.fromMap(new TObjectIntHashMapDecorator(new TObjectIntHashMap<Object>()));

  }

  public static void asdqe() {
    List<String> ll = ListSequence.fromList(new ArrayList<String>());
    Iterator<String> mit = ListSequence.fromList(ll).iterator();
    for (Iterator<String> mm = ListSequence.fromList(ll).iterator(); mm.hasNext();) {

    }

  }

  public static void collection() {
    Collection<Integer> ci = CollectionSequence.fromCollection(new ArrayList<Integer>());
    CollectionSequence.fromCollection(ci).addElement(1);
    CollectionSequence.fromCollection(ci).removeElement(2);
    CollectionSequence.fromCollection(ci).removeSequence(null);
    CollectionSequence.fromCollection(ci).addSequence(CollectionSequence.fromCollection(ci));
    CollectionSequence.fromCollection(ci).asUnmodifiable();
    Set<Integer> si = SetSequence.fromSet(new HashSet<Integer>());
    SetSequence.fromSet(si).addElement(1);
    SetSequence.fromSet(si).addElement(2);
    SetSequence.fromSet(si).removeElement(1);
    SetSequence.fromSet(si).removeSequence(CollectionSequence.fromCollection(ci));
    SetSequence.fromSet(si).addSequence(CollectionSequence.fromCollection(ci));
    SetSequence.fromSet(si).asUnmodifiable();
    Set<Integer> is = SetSequence.fromSet(si).addSequence(SetSequence.fromSet(si));
    SetSequence.fromSet(si).addSequence(SetSequence.fromSet(si));
    SetSequence.fromSet(si).removeSequence(CollectionSequence.fromCollection(ci));
    SetSequence.fromSet(si).removeSequence(SetSequence.fromSet(si));
    List<Integer> li = ListSequence.fromList(new ArrayList<Integer>());
    ListSequence.fromList(li).addElement(1);
    ListSequence.fromList(li).removeElement(1);
    ListSequence.fromList(li).removeSequence(SetSequence.fromSet(si));
    ListSequence.fromList(li).asUnmodifiable();
    ci = si;
    Iterable<Integer> sqi = si;
    sqi = si;
    CollectionSequence.fromCollection(ci).addElement(2);
    Queue<Integer> qi = QueueSequence.fromQueue(new LinkedList<Integer>());
    QueueSequence.fromQueue(qi).removeElement(3);
    QueueSequence.fromQueue(qi).removeElement(1);
    QueueSequence.fromQueue(qi).addLastElement(3);
    QueueSequence.fromQueue(qi).removeSequence(ListSequence.fromList(li));
    Deque<Integer> sti = DequeSequence.fromDeque(new LinkedList<Integer>());
    DequeSequence.fromDeque(sti).pushElement(2);
    DequeSequence.fromDeque(sti).removeElement(1);
    DequeSequence.fromDeque(sti).addSequence(QueueSequence.fromQueue(qi));
    DequeSequence.fromDeque(sti).ofType(String.class);
    DequeSequence.fromDeque(sti).ofType(List.class);
  }

  public static void setofnodes() {
    Set<SNode> son = SetSequence.fromSet(new HashSet<SNode>());
    Set<SNode> csosn = new HashSet<SNode>();
    Set<SNode> cson = new HashSet<SNode>();
    son = csosn;
    csosn = son;
    son = cson;
    cson = son;
    csosn = cson;
    cson = csosn;
  }
}
