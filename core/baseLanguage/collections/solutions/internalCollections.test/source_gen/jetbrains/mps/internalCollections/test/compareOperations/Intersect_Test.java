package jetbrains.mps.internalCollections.test.compareOperations;

/*Generated by MPS */

import jetbrains.mps.internalCollections.test.closures.Util_Test;
import jetbrains.mps.internal.collections.runtime.ISequence;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Iterator;
import java.util.ArrayList;
import junit.framework.Assert;
import java.util.NoSuchElementException;

public class Intersect_Test extends Util_Test {
  public void test_intersectMethod() throws Exception {
    ISequence<Integer> input = Sequence.fromArray(1, 2, 2, 3);
    ISequence<Integer> test = input.intersect(Sequence.fromArray(2, 3, 3, 4));
    this.assertIterableEqualsIgnoreOrder(Arrays.asList(2, 3), test);
  }

  public void test_intersectOperation() throws Exception {
    Iterable<Integer> input = Arrays.asList(1, 2, 2, 3, 4, 4);
    Iterable<Integer> test = Sequence.fromIterable(input).intersect(ListSequence.fromList(Arrays.asList(2, 3, 3, 4, 4, 5)));
    this.assertIterableEqualsIgnoreOrder(Arrays.asList(2, 3, 4, 4), test);
  }

  public void test_nextWithoutHasNext() throws Exception {
    Iterator<Integer> it = ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<Integer>(), 1, 2, 3, 4)).intersect(ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<Integer>(), 2, 3))).iterator();
    Assert.assertSame(2, it.next());
    Assert.assertSame(3, it.next());
    Assert.assertFalse(it.hasNext());
    try {
      it.next();
      Assert.fail();
    } catch (NoSuchElementException e) {
      // expected exception 
    }
  }
}
