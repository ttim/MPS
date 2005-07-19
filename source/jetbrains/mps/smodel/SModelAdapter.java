package jetbrains.mps.smodel;

import jetbrains.mps.smodel.event.*;

/**
 * @author Kostik
 */
public class SModelAdapter implements SModelListener {
  public void rootAdded(SModelRootEvent event) {
    modelChangedDramatically(event.getModel());
  }

  public void rootRemoved(SModelRootEvent event) {
    modelChangedDramatically(event.getModel());
  }

  public void propertyChanged(SModelPropertyEvent event) {
    modelChanged(event.getModel());
  }

  public void childAdded(SModelChildEvent event) {
    modelChangedDramatically(event.getModel());
  }

  public void childRemoved(SModelChildEvent event) {
    modelChangedDramatically(event.getModel());
  }

  public void referenceAdded(SModelReferenceEvent event) {
    modelChangedDramatically(event.getModel());
  }

  public void referenceRemoved(SModelReferenceEvent event) {
    modelChangedDramatically(event.getModel());
  }

  public void modelChanged(SModel model) {
  }

  public void modelChangedDramatically(SModel model) {
  }
}
