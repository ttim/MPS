package jetbrains.mps.internalCollections.test.basicOperations;

/*Generated by MPS */

import jetbrains.mps.internalCollections.test.closures.Util_Test;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.LinkedHashMap;
import junit.framework.Assert;
import java.util.Arrays;

public class LinkedMap_Test extends Util_Test {
  public void test_insertOrder() throws Exception {
    Map<Integer, String> map = MapSequence.fromMap(new LinkedHashMap<Integer, String>(16, (float) 0.75, false));
    MapSequence.fromMap(map).put(7, "A");
    MapSequence.fromMap(map).put(5, "B");
    MapSequence.fromMap(map).put(2, "C");
    this.assertIterableEquals(this.inputABC(), MapSequence.fromMap(map).values());
    MapSequence.fromMap(map).put(3, "D");
    MapSequence.fromMap(map).put(4, "E");
    MapSequence.fromMap(map).put(6, "F");
    this.assertIterableEquals(this.inputABCDEF(), MapSequence.fromMap(map).values());
  }

  public void test_accessOrder() throws Exception {
    Map<String, Integer> map = MapSequence.<String, Integer>fromMapAndKeysArray(new LinkedHashMap<String, Integer>(16, (float) 0.75, true), "A", "B", "C", "D", "E").withValues(1, 2, 3, 4, 5);
    this.assertIterableEquals(this.input5(), MapSequence.fromMap(map).values());
    Assert.assertSame(5, MapSequence.fromMap(map).get("E"));
    Assert.assertSame(4, MapSequence.fromMap(map).get("D"));
    Assert.assertSame(3, MapSequence.fromMap(map).get("C"));
    Assert.assertSame(2, MapSequence.fromMap(map).get("B"));
    Assert.assertSame(1, MapSequence.fromMap(map).get("A"));
    this.assertIterableEquals(Arrays.asList(5, 4, 3, 2, 1), MapSequence.fromMap(map).values());
  }
}
