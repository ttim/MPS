package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.lang.core.behavior.BaseConcept_BehaviorDescriptor;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.build.util.MacroHelper;

public abstract class BuildSourcePath_BehaviorDescriptor extends BaseConcept_BehaviorDescriptor {
  public BuildSourcePath_BehaviorDescriptor() {
  }

  public String virtual_getRelativePath_5481553824944787371(SNode thisNode) {
    return BuildSourcePath_Behavior.virtual_getRelativePath_5481553824944787371(thisNode);
  }

  @Nullable
  public String virtual_getLocalPath_5481553824944787364(SNode thisNode, Context context) {
    return BuildSourcePath_Behavior.virtual_getLocalPath_5481553824944787364(thisNode, context);
  }

  public String virtual_getLastSegment_1368030936106771141(SNode thisNode, MacroHelper helper) {
    return BuildSourcePath_Behavior.virtual_getLastSegment_1368030936106771141(thisNode, helper);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.build.structure.BuildSourcePath";
  }
}
