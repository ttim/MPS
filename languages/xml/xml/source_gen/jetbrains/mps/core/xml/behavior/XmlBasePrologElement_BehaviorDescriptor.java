package jetbrains.mps.core.xml.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;

public abstract class XmlBasePrologElement_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor implements XmlPrologElement_BehaviorDescriptor {
  public XmlBasePrologElement_BehaviorDescriptor() {
  }

  public boolean virtual_isOneLineBlock_2133624044437631438(SNode thisNode) {
    return XmlBasePrologElement_Behavior.virtual_isOneLineBlock_2133624044437631438(thisNode);
  }

  public boolean virtual_onNewLine_2133624044437631588(SNode thisNode) {
    return XmlBasePrologElement_Behavior.virtual_onNewLine_2133624044437631588(thisNode);
  }

  public boolean virtual_isFirstPositionAllowed_2133624044437631446(SNode thisNode) {
    return XmlBasePrologElement_Behavior.virtual_isFirstPositionAllowed_2133624044437631446(thisNode);
  }

  public boolean virtual_isLastPositionAllowed_2133624044437631519(SNode thisNode) {
    return XmlBasePrologElement_Behavior.virtual_isLastPositionAllowed_2133624044437631519(thisNode);
  }

  public boolean virtual_hasNewLineAfter_2133624044437631594(SNode thisNode) {
    return XmlBasePrologElement_Behavior.virtual_hasNewLineAfter_2133624044437631594(thisNode);
  }

  public boolean virtual_isTextLike_2133624044437631604(SNode thisNode) {
    return XmlBasePrologElement_Behavior.virtual_isTextLike_2133624044437631604(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.core.xml.structure.XmlBasePrologElement";
  }
}
