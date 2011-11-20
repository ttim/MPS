package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.util.CounterMap;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.IVisitor;


/**
 * This is a map from 'Feature' to arbitrary value. Also it stores which features are ancestors of
 * features which are added in this map.
 * 
 * @param V map value
 */
public class FeatureForestMap<V> {
  private Map<Feature, V> myFeatureToValue = MapSequence.fromMap(new HashMap<Feature, V>());
  private Map<Feature, Feature[]> myFeatureToAncestors = MapSequence.fromMap(new HashMap<Feature, Feature[]>());
  private CounterMap<Feature> myFeaturesIsAncestorCounterMap = new CounterMap<Feature>();

  public FeatureForestMap() {
  }

  public void put(@NotNull Feature feature, @NotNull V value) {
    ModelAccess.assertLegalRead();
    if (MapSequence.fromMap(myFeatureToValue).containsKey(feature)) {
      throw new IllegalArgumentException("Trying to put already present feature");
    }
    Feature[] ancestors = feature.getAncestors();
    if (Sequence.fromIterable(Sequence.fromArray(ancestors)).any(new IWhereFilter<Object>() {
      public boolean accept(Object a) {
        return MapSequence.fromMap(myFeatureToValue).containsKey(a);
      }
    })) {
      throw new IllegalAccessError("Trying to put feature which is ancestor of already added one");
    }

    MapSequence.fromMap(myFeatureToValue).put(feature, value);
    MapSequence.fromMap(myFeatureToAncestors).put(feature, ancestors);
    Sequence.fromIterable(Sequence.fromArray(ancestors)).visitAll(new IVisitor<Feature>() {
      public void visit(Feature a) {
        myFeaturesIsAncestorCounterMap.increment(a);
      }
    });
  }

  public void removeKey(@NotNull Feature feature) {
    if (!(MapSequence.fromMap(myFeatureToValue).containsKey(feature))) {
      throw new IllegalArgumentException("Trying to remove feature which is not added");
    }

    Feature[] ancestors = MapSequence.fromMap(myFeatureToAncestors).get(feature);

    MapSequence.fromMap(myFeatureToValue).removeKey(feature);
    MapSequence.fromMap(myFeatureToAncestors).removeKey(feature);
    Sequence.fromIterable(Sequence.fromArray(ancestors)).visitAll(new IVisitor<Feature>() {
      public void visit(Feature a) {
        myFeaturesIsAncestorCounterMap.decrement(a);
      }
    });
  }

  public V get(@NotNull Feature feature) {
    return MapSequence.fromMap(myFeatureToValue).get(feature);
  }
}
