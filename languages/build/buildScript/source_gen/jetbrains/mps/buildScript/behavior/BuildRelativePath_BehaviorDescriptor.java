package jetbrains.mps.buildScript.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.buildScript.util.Context;
import org.jetbrains.annotations.Nullable;

public abstract class BuildRelativePath_BehaviorDescriptor extends BuildSourcePath_BehaviorDescriptor {
  public BuildRelativePath_BehaviorDescriptor() {
  }

  public String virtual_getLocalPath_5481553824944787364(SNode thisNode, Context context) {
    return BuildRelativePath_Behavior.virtual_getLocalPath_5481553824944787364(thisNode, context);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.buildScript.structure.BuildRelativePath";
  }

  @Nullable
  public abstract String virtual_getBasePath_4959435991187140515(SNode thisNode, Context context);
}
