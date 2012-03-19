package jetbrains.mps.lang.descriptor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.lang.project.behavior.Module_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class LanguageDescriptor_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean call_isLanguageAspectEmpty_3064888218669923940(SNode thisNode, LanguageAspect languageAspect, TemplateQueryContext genContext) {
    ModuleReference ref = ModuleReference.fromString(Module_Behavior.call_getModuleReference_9020561928507315628(SLinkOperations.getTarget(thisNode, "language", true)));
    Language l = ModuleRepositoryFacade.getInstance().getModule(ref, Language.class);
    if (l == null) {
      genContext.showErrorMessage(SLinkOperations.getTarget(thisNode, "language", true), "No language in repository: " + SPropertyOperations.getString(SLinkOperations.getTarget(thisNode, "language", true), "namespace"));
      return true;
    }
    SModelDescriptor ts = languageAspect.get(l);
    if (ts == null) {
      return true;
    }
    SModel m = ts.getSModel();
    if (m == null) {
      genContext.showErrorMessage(SLinkOperations.getTarget(thisNode, "language", true), "Cannot load model: " + ts.getLongName());
      return true;
    }
    return ListSequence.fromList(SModelOperations.getRoots(m, null)).isEmpty();
  }
}
