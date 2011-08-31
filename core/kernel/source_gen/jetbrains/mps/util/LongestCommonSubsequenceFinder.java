package jetbrains.mps.util;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.apache.commons.lang.ObjectUtils;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class LongestCommonSubsequenceFinder<E> {
  private List<E> myA;
  private List<E> myB;
  private int[][] myCommonLengths;
  private List<Tuples._2<Integer, Integer>> myCommonIndices;
  private List<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>> myDifferentIndices;
  private List<Tuples._2<Iterable<E>, Iterable<E>>> myDifferentSubsequences;

  public LongestCommonSubsequenceFinder(@NotNull List<E> a, @NotNull List<E> b) {
    myA = a;
    myB = b;
  }

  @NotNull
  public int[][] getCommonLengths() {
    // This method finds lengths of longest common subsequence for each 
    // i first elements of a and j first elements of b. This lengths are in result 
    // two-dimensional array at [i][j] position 
    if (myCommonLengths == null) {
      myCommonLengths = new int[ListSequence.<E>fromList(myA).count() + 1][ListSequence.<E>fromList(myB).count() + 1];

      for (int i = 1; i < ListSequence.<E>fromList(myA).count() + 1; i++) {
        for (int j = 1; j < ListSequence.<E>fromList(myB).count() + 1; j++) {
          if (ObjectUtils.equals(ListSequence.<E>fromList(myA).getElement(i - 1), ListSequence.<E>fromList(myB).getElement(j - 1))) {
            myCommonLengths[i][j] = myCommonLengths[i - 1][j - 1] + 1;
          } else {
            myCommonLengths[i][j] = Math.max(myCommonLengths[i - 1][j], myCommonLengths[i][j - 1]);
          }
        }
      }
    }
    return myCommonLengths;
  }

  @NotNull
  public List<Tuples._2<Integer, Integer>> getCommonIndices() {
    // This method finds pairs of indices in a and b lists which are 
    // elements of longest common subsequence 
    if (myCommonIndices == null) {
      getCommonLengths();

      List<Tuples._2<Integer, Integer>> indices = ListSequence.<Tuples._2<Integer, Integer>>fromList(new ArrayList<Tuples._2<Integer, Integer>>());
      int i = ListSequence.<E>fromList(myA).count();
      int j = ListSequence.<E>fromList(myB).count();
      while (i > 0 && j > 0) {
        if (ObjectUtils.equals(ListSequence.<E>fromList(myA).getElement(i - 1), ListSequence.<E>fromList(myB).getElement(j - 1))) {
          ListSequence.<Tuples._2<Integer, Integer>>fromList(indices).addElement(MultiTuple.<Integer,Integer>from(i - 1, j - 1));
          i--;
          j--;
        } else {
          if (myCommonLengths[i][j - 1] == myCommonLengths[i][j]) {
            j--;
          } else {
            i--;
          }
        }
      }
      myCommonIndices = ListSequence.<Tuples._2<Integer, Integer>>fromList(indices).reversedList();
    }
    return myCommonIndices;
  }

  @NotNull
  public List<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>> getDifferentIndices() {
    // This methods finds pairs of begin-end pairs of original lists a and b 
    // which are not included into longest common subsequence 
    if (myDifferentIndices == null) {
      myDifferentIndices = ListSequence.<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>>fromList(new ArrayList<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>>());
      int i = 0;
      int j = 0;
      for (Tuples._2<Integer, Integer> f : ListSequence.<Tuples._2<Integer, Integer>>fromList(getCommonIndices()).concat(Sequence.<Tuples._2<Integer, Integer>>fromIterable(new _FunctionTypes._return_P0_E0<Iterable<Tuples._2<Integer, Integer>>>() {
        public Iterable<Tuples._2<Integer, Integer>> invoke() {
          return new Iterable<Tuples._2<Integer, Integer>>() {
            public Iterator<Tuples._2<Integer, Integer>> iterator() {
              return new YieldingIterator<Tuples._2<Integer, Integer>>() {
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
                        this.yield(MultiTuple.<Integer,Integer>from(ListSequence.<E>fromList(myA).count(), ListSequence.<E>fromList(myB).count()));
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
      }.invoke()))) {
        if (!(i == (int) f._0() && j == (int) f._1())) {
          ListSequence.<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>>fromList(myDifferentIndices).addElement(MultiTuple.<Tuples._2<Integer, Integer>,Tuples._2<Integer, Integer>>from(MultiTuple.<Integer,Integer>from(i, (int) f._0()), MultiTuple.<Integer,Integer>from(j, (int) f._1())));
        }
        i = (int) f._0() + 1;
        j = (int) f._1() + 1;
      }
    }
    return myDifferentIndices;
  }

  @NotNull
  public List<Tuples._2<Iterable<E>, Iterable<E>>> getDifferentSubsequences() {
    // This methods finds pairs of subsequences of original lists a and b 
    // which are not included into longest common subsequence 
    if (myDifferentSubsequences == null) {
      myDifferentSubsequences = ListSequence.<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>>fromList(getDifferentIndices()).<Tuples._2<Iterable<E>, Iterable<E>>>select(new ISelector<Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>>, Tuples._2<Iterable<E>, Iterable<E>>>() {
        public Tuples._2<Iterable<E>, Iterable<E>> select(Tuples._2<Tuples._2<Integer, Integer>, Tuples._2<Integer, Integer>> pair) {
          return MultiTuple.<Iterable<E>,Iterable<E>>from(ListSequence.<E>fromList(myA).page((int) pair._0()._0(), (int) pair._0()._1()), ListSequence.<E>fromList(myB).page((int) pair._1()._0(), (int) pair._1()._1()));
        }
      }).toListSequence();
    }
    return myDifferentSubsequences;
  }
}
