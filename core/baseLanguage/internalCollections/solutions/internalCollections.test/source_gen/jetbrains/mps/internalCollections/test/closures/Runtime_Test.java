package jetbrains.mps.internalCollections.test.closures;

/*Generated by MPS */

import jetbrains.mps.internal.collections.runtime.Sequence;

public class Runtime_Test extends Util_Test {

  public void test_fromIterable() throws Exception {
    Sequence<Integer> seq = Sequence.fromIterable(this.input5());
    this.assertIterableEquals(this.input5(), seq.toIterable());
  }

}
