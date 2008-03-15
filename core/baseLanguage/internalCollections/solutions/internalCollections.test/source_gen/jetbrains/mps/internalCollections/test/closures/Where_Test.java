package jetbrains.mps.internalCollections.test.closures;

/*Generated by MPS */

import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Arrays;

public class Where_Test extends Util_Test {

  public void test_whereMethod() throws Exception {
    Sequence<Integer> seq = Sequence.fromIterable(this.input5());
    Sequence<Integer> test = seq.where(new IWhereFilter <Integer>() {

      public boolean accept(Integer it) {
        return it % 2 == 1;
      }

    });
    this.assertIterableEquals(this.expectOdd5(), test.toIterable());
  }

  public void test_whereFilterVar() throws Exception {
    Sequence<Integer> seq = Sequence.fromIterable(this.input5());
    IWhereFilter<Integer> filter = new IWhereFilter <Integer>() {

      public boolean accept(Integer it) {
        return it % 2 == 1;
      }

    };
    Sequence<Integer> test = seq.where(filter);
    this.assertIterableEquals(this.expectOdd5(), test.toIterable());
  }

  public void test_whereOperation() throws Exception {
    Iterable<Integer> seq = this.input5();
    Iterable<Integer> test = Sequence.fromIterable(seq).where(new IWhereFilter <Integer>() {

      public boolean accept(Integer it) {
        return it % 2 == 1;
      }

    });
    Iterable<Integer> expected = Arrays.asList(1, 3, 5);
    this.assertIterableEquals(expected, test);
  }

}
