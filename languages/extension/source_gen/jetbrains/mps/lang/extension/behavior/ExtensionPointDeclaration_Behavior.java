package jetbrains.mps.lang.extension.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class ExtensionPointDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String call_getId_63012922130945363(SNode thisNode) {
    IModule module = SNodeOperations.getModel(thisNode).getModelDescriptor().getModule();
    String moduleFqName = module.getModuleFqName();
    int atIdx = moduleFqName.indexOf("@");
    if (atIdx >= 0) {
      moduleFqName = moduleFqName.substring(0, atIdx);
    }
    return moduleFqName + "." + SPropertyOperations.getString(thisNode, "name");
  }

  public static SNode call_getObjectClassifierType_6778078592468845406(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "objectType", true), "jetbrains.mps.baseLanguageInternal.structure.InternalClassifierType")) {
      return SNodeOperations.cast(SLinkOperations.getTarget(thisNode, "objectType", true), "jetbrains.mps.baseLanguage.structure.ClassifierType");
    } else {
      return TypeChecker.getInstance().getRuntimeSupport().coerce_(SLinkOperations.getTarget(thisNode, "objectType", true), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
    }
  }
}
