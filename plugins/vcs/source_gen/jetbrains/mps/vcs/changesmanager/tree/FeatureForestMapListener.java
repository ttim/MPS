package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import java.util.EventListener;
import jetbrains.mps.vcs.changesmanager.tree.features.Feature;

public interface FeatureForestMapListener<V> extends EventListener {
  public void featureStateChanged(Feature feature);
}
