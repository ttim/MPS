package jetbrains.mps.baseLanguage.collections.unittest.simple_operations;

/*Generated by MPS */

import junit.framework.TestCase;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import junit.framework.Assert;

public class Map_Test extends TestCase {
  public void test_simple() throws Exception {
    Map<String, String> map = MapSequence.fromMap(new HashMap<String, String>());
    MapSequence.fromMap(map).put("key1", "value1");
    Assert.assertEquals("value1", MapSequence.fromMap(map).get("key1"));
    Assert.assertTrue(MapSequence.fromMap(map).containsKey("key1"));
  }

  public void test__null() throws Exception {
    /*
      Map<String, String> map = null;
      MapSequence.fromMap(map).put("key1", "value1");
      Assert.assertEquals(null, MapSequence.fromMap(map).get("key1"));
      Assert.assertFalse(MapSequence.fromMap(map).containsKey("key1"));
    */
  }

  public void test_initializer() throws Exception {
    Map<String, String> map = MapSequence.<String, String>fromMapAndKeysArray(new HashMap<String, String>(), "key1").withValues("value1");
    Assert.assertEquals("value1", MapSequence.fromMap(map).get("key1"));
  }
}
