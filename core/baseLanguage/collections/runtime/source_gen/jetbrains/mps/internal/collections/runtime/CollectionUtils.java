package jetbrains.mps.internal.collections.runtime;

/*Generated by MPS */

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.SortedSet;
import java.util.SortedMap;

public class CollectionUtils {
  public static <T> Collection synchronizedCollection(Collection<T> coll) {
    return Collections.synchronizedCollection(coll);
  }

  public static <T> List synchronizedList(List<T> list) {
    return Collections.synchronizedList(list);
  }

  public static <T> Set synchronizedSet(Set<T> set) {
    return Collections.synchronizedSet(set);
  }

  public static <K, V> Map synchronizedMap(Map<K, V> map) {
    return Collections.synchronizedMap(map);
  }

  public static <T> SortedSet synchronizedSortedSet(SortedSet<T> sset) {
    return Collections.synchronizedSortedSet(sset);
  }

  public static <K, V> Map synchronizedSortedMap(SortedMap<K, V> smap) {
    return Collections.synchronizedSortedMap(smap);
  }
}
