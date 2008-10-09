package jetbrains.mps.lang.plugin.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.plugin.generator.baseLanguage.template.util.PluginNameUtils;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;

public class FileGeneratorDeclaration_Behavior {

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_createType_1213877527970(SNode thisNode) {
    SNode type = SConceptOperations.createNewNode("jetbrains.mps.lang.plugin.structure.FileGeneratorType", null);
    SLinkOperations.setTarget(type, "generator", thisNode, false);
    return type;
  }

  public static String call_getGeneratedName_1218038748102(SNode thisNode) {
    return PluginNameUtils.getModuleShortName(SModelUtil_new.getDeclaringLanguage(thisNode.getConceptDeclarationAdapter(), GlobalScope.getInstance())) + "_FileGenerator";
  }

  public static String call_getGeneratedClassFQName_1218038748112(SNode thisNode) {
    return ((SModel)SNodeOperations.getModel(thisNode)).getLongName() + "." + FileGeneratorDeclaration_Behavior.call_getGeneratedName_1218038748102(thisNode);
  }

}
