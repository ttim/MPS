package jetbrains.mps.core.xml.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;

public abstract class XmlValuePart_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor {
  public XmlValuePart_BehaviorDescriptor() {
  }

  public boolean virtual_isLastPositionAllowed_3080189811177340441(SNode thisNode) {
    return XmlValuePart_Behavior.virtual_isLastPositionAllowed_3080189811177340441(thisNode);
  }

  public boolean virtual_isFirstPositionAllowed_3080189811177340436(SNode thisNode) {
    return XmlValuePart_Behavior.virtual_isFirstPositionAllowed_3080189811177340436(thisNode);
  }

  public boolean virtual_onNewLine_3080189811177340422(SNode thisNode) {
    return XmlValuePart_Behavior.virtual_onNewLine_3080189811177340422(thisNode);
  }

  public boolean virtual_hasNewLineAfter_3080189811177340429(SNode thisNode) {
    return XmlValuePart_Behavior.virtual_hasNewLineAfter_3080189811177340429(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.core.xml.structure.XmlValuePart";
  }
}
