package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.MacroHelper;

public class BuildVarRefStringPart_BehaviorDescriptor extends BuildStringPart_BehaviorDescriptor {
  public BuildVarRefStringPart_BehaviorDescriptor() {
  }

  public boolean virtual_isLastPositionAllowed_624440001685490925(SNode thisNode) {
    return BuildVarRefStringPart_Behavior.virtual_isLastPositionAllowed_624440001685490925(thisNode);
  }

  public String virtual_getText_4380385936562037054(SNode thisNode, MacroHelper helper) {
    return BuildVarRefStringPart_Behavior.virtual_getText_4380385936562037054(thisNode, helper);
  }

  public boolean virtual_isFirstPositionAllowed_624440001685459414(SNode thisNode) {
    return BuildVarRefStringPart_Behavior.virtual_isFirstPositionAllowed_624440001685459414(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildVarRefStringPart";
  }
}
