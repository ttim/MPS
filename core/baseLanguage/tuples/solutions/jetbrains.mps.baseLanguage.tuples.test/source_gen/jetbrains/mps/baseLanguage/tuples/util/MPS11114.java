package jetbrains.mps.baseLanguage.tuples.util;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ArrayUtils;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;

public class MPS11114 {
  public MPS11114() {
  }

  public static List<Tuples._2<Integer, String>> returnTuples() {
    return Sequence.<Tuples._2<Integer, String>>fromIterable(Sequence.fromArray(ArrayUtils.asArray(MultiTuple.<Integer,String>from(1, "foo"), MultiTuple.<Integer,String>from(2, "bar")))).toListSequence();
  }
}
