package jetbrains.mps.baseLanguage.collections.unittest.simple_operations;

/*Generated by MPS */

import junit.framework.TestCase;
import org.junit.Test;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import junit.framework.Assert;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;

public class Distinct_Test extends TestCase {
  @Test
  public void test_distinct1() throws Exception {
    Iterable<Integer> source;
    source = ListSequence.fromListAndArray(new ArrayList<Integer>(), 1, 2, 2, 3, 4, 4, 5);
    source = Sequence.fromIterable(source).distinct();
    Assert.assertEquals(Sequence.fromIterable(source).where(new IWhereFilter<Integer>() {
      public boolean accept(Integer it) {
        return it == 2;
      }
    }).count(), 1);
    Assert.assertEquals(Sequence.fromIterable(source).where(new IWhereFilter<Integer>() {
      public boolean accept(Integer it) {
        return it == 4;
      }
    }).count(), 1);
    Assert.assertEquals(Sequence.fromIterable(source).count(), 5);
    source = Sequence.fromIterable(source).sort(new ISelector<Integer, Comparable<?>>() {
      public Comparable<?> select(Integer it) {
        return it;
      }
    }, true);
    Integer c = 1;
    for (Integer i : Sequence.fromIterable(source)) {
      Assert.assertEquals(i, c);
      c++ ;
    }
  }

  @Test
  public void test_distinct2() throws Exception {
    Iterable<Integer> source;
    source = Sequence.fromClosure(new ISequenceClosure<Integer>() {
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
                      this.__CP__ = 3;
                      this.yield(1);
                      return true;
                    case 3:
                      this.__CP__ = 4;
                      this.yield(2);
                      return true;
                    case 4:
                      this.__CP__ = 5;
                      this.yield(2);
                      return true;
                    case 5:
                      this.__CP__ = 6;
                      this.yield(3);
                      return true;
                    case 6:
                      this.__CP__ = 7;
                      this.yield(4);
                      return true;
                    case 7:
                      this.__CP__ = 8;
                      this.yield(4);
                      return true;
                    case 8:
                      this.__CP__ = 1;
                      this.yield(5);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    default:
                      break __loop__;
                  }
                } while(true);
                return false;
              }
            };
          }
        };
      }
    });
    source = Sequence.fromIterable(source).distinct();
    Assert.assertEquals(Sequence.fromIterable(source).where(new IWhereFilter<Integer>() {
      public boolean accept(Integer it) {
        return it == 2;
      }
    }).count(), 1);
    Assert.assertEquals(Sequence.fromIterable(source).where(new IWhereFilter<Integer>() {
      public boolean accept(Integer it) {
        return it == 4;
      }
    }).count(), 1);
    Assert.assertEquals(Sequence.fromIterable(source).count(), 5);
    source = Sequence.fromIterable(source).sort(new ISelector<Integer, Comparable<?>>() {
      public Comparable<?> select(Integer it) {
        return it;
      }
    }, true);
    Integer c = 1;
    for (Integer i : Sequence.fromIterable(source)) {
      Assert.assertEquals(i, c);
      c++ ;
    }
  }

  @Test
  public void test_null() throws Exception {
    Iterable<Integer> source = null;
    source = Sequence.fromIterable(source).distinct();
    Assert.assertTrue(Sequence.fromIterable(source).count() == 0);
  }
}
