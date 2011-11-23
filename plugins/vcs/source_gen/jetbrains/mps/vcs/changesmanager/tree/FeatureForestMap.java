package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Map;
import jetbrains.mps.vcs.changesmanager.tree.features.Feature;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.util.CounterMap;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import org.jetbrains.annotations.Nullable;


/**
 * This is a map from 'Feature' to arbitrary value. Also it stores which features are ancestors of
 * features which are added in this map.
 * 
 * @param V map value
 */
public class FeatureForestMap<V> {
  protected static Log log = LogFactory.getLog(FeatureForestMap.class);

  private Map<Feature, V> myFeatureToValue = MapSequence.fromMap(new HashMap<Feature, V>());
  private Map<Feature, Feature[]> myFeatureToAncestors = MapSequence.fromMap(new HashMap<Feature, Feature[]>());
  private CounterMap<Feature> myFeaturesIsAncestorCounterMap = new CounterMap<Feature>(new FeatureForestMap.MyCounterMapHandler());
  private final List<FeatureForestMapListener> myListeners = ListSequence.fromList(new ArrayList<FeatureForestMapListener>());

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
    fireFeatureStateChanged(feature);
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
    fireFeatureStateChanged(feature);
  }

  @Nullable
  public V get(@NotNull Feature feature) {
    return MapSequence.fromMap(myFeatureToValue).get(feature);
  }

  public boolean isAncestorOfAddedFeature(@NotNull Feature feature) {
    return !(myFeaturesIsAncestorCounterMap.isZero(feature));
  }

  @Nullable
  public Feature getAddedAncestor(@NotNull Feature feature) {
    ModelAccess.assertLegalRead();
    return Sequence.fromIterable(Sequence.fromArray(feature.getAncestors())).findFirst(new IWhereFilter<Feature>() {
      public boolean accept(Feature a) {
        return MapSequence.fromMap(myFeatureToValue).containsKey(a);
      }
    });
  }

  @Nullable
  public V getAddedAncestorValue(@NotNull Feature feature) {
    return MapSequence.fromMap(myFeatureToValue).get(getAddedAncestor(feature));
  }

  public void addListener(@NotNull FeatureForestMapListener listener) {
    synchronized (myListeners) {
      ListSequence.fromList(myListeners).addElement(listener);
    }
  }

  public void removeListener(@NotNull FeatureForestMapListener listener) {
    synchronized (myListeners) {
      ListSequence.fromList(myListeners).removeElement(listener);
    }
  }

  @NotNull
  private List<FeatureForestMapListener> copyListeners() {
    synchronized (myListeners) {
      return ListSequence.fromListWithValues(new ArrayList<FeatureForestMapListener>(), myListeners);
    }
  }

  private void fireFeatureStateChanged(@NotNull Feature feature) {
    for (FeatureForestMapListener listener : ListSequence.fromList(copyListeners())) {
      try {
        listener.featureStateChanged(feature);
      } catch (Throwable t) {
        if (log.isErrorEnabled()) {
          log.error("Exception on firing featureStateChanged event", t);
        }
      }
    }
  }

  private class MyCounterMapHandler implements CounterMap.CounterMapHandler<Feature> {
    public MyCounterMapHandler() {
    }

    public void counterZero(@NotNull Feature feature) {
      fireFeatureStateChanged(feature);
    }

    public void counterNonZero(@NotNull Feature feature) {
      fireFeatureStateChanged(feature);
    }
  }
}
