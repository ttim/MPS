package jetbrains.mps.baseLanguage.javastub;

/*Generated by MPS */

import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodeId;

public interface SReferenceHandler {
  public SReference createSReference(SNode source, SNodeId targetNodeId, String role, String resolveInfo, String rootPresentation);
}
