package jetbrains.mps.internalCollections.test.nullHacks;

/*Generated by MPS */

import jetbrains.mps.internalCollections.test.closures.Util_Test;
import org.junit.Test;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Collections;
import junit.framework.Assert;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class NullEmpty_Test extends Util_Test {

  @Test()
  public void test_nullFirstLast() throws Exception {
    if (Sequence.NULL_WHEN_EMPTY) {
      Iterable<Integer> emptySeq = Sequence.fromIterable(Collections.<Integer>emptyList());
      Assert.assertNull(Sequence.fromIterable(emptySeq).first());
      Assert.assertNull(Sequence.fromIterable(emptySeq).last());
      List<Integer> emptyList = ListSequence.<Integer>fromArray();
      Assert.assertNull(ListSequence.fromList(emptyList).first());
      Assert.assertNull(ListSequence.fromList(emptyList).last());
      Assert.assertNull(ListSequence.fromList(emptyList).first());
      Assert.assertNull(ListSequence.fromList(emptyList).getElement(-1));
    }
  }

}
