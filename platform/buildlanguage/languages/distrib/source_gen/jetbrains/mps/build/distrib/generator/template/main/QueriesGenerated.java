package jetbrains.mps.build.distrib.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.build.distrib.behavior.WindowsConfig_Behavior;
import jetbrains.mps.build.distrib.behavior.SystemSpecificConfig_Behavior;
import jetbrains.mps.build.distrib.behavior.AbstractPath_Behavior;
import jetbrains.mps.build.packaging.behavior.Configuration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.build.distrib.behavior.UnixConfig_Behavior;
import jetbrains.mps.build.distrib.behavior.DistribConfiguration_Behavior;
import jetbrains.mps.build.packaging.behavior.MPSLayout_Behavior;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.build.distrib.behavior.ArtifactReferenceCommandLinePart_Behavior;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.distrib.behavior.AbstractCommandLinePart_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1230234493429(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.build.distrib.structure.DistribConfiguration");
  }

  public static boolean baseMappingRule_Condition_1230293388595(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.build.distrib.structure.DistribConfiguration");
  }

  public static boolean baseMappingRule_Condition_1231694520855(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "useVMOptionsFile");
  }

  public static boolean baseMappingRule_Condition_1233940187535(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.build.distrib.structure.DistribConfiguration");
  }

  public static Object propertyMacro_GetPropertyValue_1230058399222(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return WindowsConfig_Behavior.call_getStartupFileName_1230208021944(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1230058633847(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupClass");
  }

  public static Object propertyMacro_GetPropertyValue_1230059665144(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(_context.getNode()).replace("/", "\\");
  }

  public static Object propertyMacro_GetPropertyValue_1230208124305(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return WindowsConfig_Behavior.call_getStartupFileExtension_1230208056584(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1230209186063(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Configuration_Behavior.call_getBuildFileName_1230217425313(SLinkOperations.getTarget(_context.getNode(), "buildScriptConfiguration", false)) + "-dist";
  }

  public static Object propertyMacro_GetPropertyValue_1230234630784(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SConceptPropertyOperations.getString(_context.getNode(), "operatingSystem") + ".dist";
  }

  public static Object propertyMacro_GetPropertyValue_1230292998920(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return UnixConfig_Behavior.call_getStartupScriptExtension_1230292961412(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1230293047562(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return UnixConfig_Behavior.call_getStartupScriptName_1230292766208(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1230293101910(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupClass");
  }

  public static Object propertyMacro_GetPropertyValue_1230293101928(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(_context.getNode()).replace("\\", "/");
  }

  public static Object propertyMacro_GetPropertyValue_1230293422263(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SConceptPropertyOperations.getString(_context.getNode(), "operatingSystem") + ".dist";
  }

  public static Object propertyMacro_GetPropertyValue_1230296315989(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return UnixConfig_Behavior.call_getStartupScriptName_1230292766208(_context.getNode()) + "." + UnixConfig_Behavior.call_getStartupScriptExtension_1230292961412(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1230565019437(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getProjectFolderAntName_1230295546376(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1230565061534(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getProjectName_1230292821821(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode())) + ".zip";
  }

  public static Object propertyMacro_GetPropertyValue_1230566262669(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getProjectFolderAntName_1230295546376(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1230566774446(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getProjectName_1230292821821(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode())) + "-windows.zip";
  }

  public static Object propertyMacro_GetPropertyValue_1230567611860(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getScriptsFolderSafe_1230566454921(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1230568551733(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return WindowsConfig_Behavior.call_getStartupFileName_1230208021944(_context.getNode()) + "." + WindowsConfig_Behavior.call_getStartupFileExtension_1230208056584(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1230570246891(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(_context.getNode(), "pathToNsisZipFile", true));
  }

  public static Object propertyMacro_GetPropertyValue_1230570281835(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(_context.getNode(), "pathToNsisConfigurationFile", true));
  }

  public static Object propertyMacro_GetPropertyValue_1230577742650(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "token");
  }

  public static Object propertyMacro_GetPropertyValue_1230577899453(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "value", false), "antName");
  }

  public static Object propertyMacro_GetPropertyValue_1230642371372(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return MPSLayout_Behavior.getMPSHomeName_1226508944077();
  }

  public static Object propertyMacro_GetPropertyValue_1230642678733(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getScriptsFolderSafe_1230566454921(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1230642844320(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "installNshName");
  }

  public static Object propertyMacro_GetPropertyValue_1230642855766(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "uninstallNshName");
  }

  public static Object propertyMacro_GetPropertyValue_1230650061631(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "${basedir}";
  }

  public static Object propertyMacro_GetPropertyValue_1230650823092(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return MPSLayout_Behavior.getMPSHomeName_1226508944077();
  }

  public static Object propertyMacro_GetPropertyValue_1230657768605(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "classPath", true), "classPathItem", true)).first()).replace("/", "\\");
  }

  public static Object propertyMacro_GetPropertyValue_1231683866212(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true)).replace("/", SConceptPropertyOperations.getString(_context.getNode(), "pathSeparator")).replace("\\", SConceptPropertyOperations.getString(_context.getNode(), "pathSeparator"));
  }

  public static Object propertyMacro_GetPropertyValue_1231685737416(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true));
  }

  public static Object propertyMacro_GetPropertyValue_1231685934125(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String startupDir = AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true));
    if (startupDir.endsWith("/")) {
      startupDir = startupDir.substring(0, startupDir.length() - 1);
    }
    String[] path = startupDir.split("/");
    String pathFromStartupDir = "..";
    for(int i = 0 ; i < path.length - 1 ; i++ ) {
      pathFromStartupDir += "/..";
    }
    return pathFromStartupDir;
  }

  public static Object propertyMacro_GetPropertyValue_1231692535562(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getVMOptionsExt_1231692561653(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231692592753(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getProjectName_1230292821821(_context.getNode()).toLowerCase();
  }

  public static Object propertyMacro_GetPropertyValue_1231748433201(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "defaultVMOptions");
  }

  public static Object propertyMacro_GetPropertyValue_1231748469358(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SystemSpecificConfig_Behavior.call_getVMOptionsFilePath_1231769123888(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231748819942(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getScriptsFolderSafe_1230566454921(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1231748903333(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SystemSpecificConfig_Behavior.call_getVMOptionfFileName_1231748960223(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231749507312(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "defaultVMOptions");
  }

  public static Object propertyMacro_GetPropertyValue_1231750861493(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SystemSpecificConfig_Behavior.call_getVMOptionsFilePath_1231769123888(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231760312435(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SystemSpecificConfig_Behavior.call_getVMOptionfFileName_1231748960223(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231769511901(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "vmOptionsDir", true)).replace("\\", "/");
  }

  public static Object propertyMacro_GetPropertyValue_1231782294388(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getScriptsFolderSafe_1230566454921(_context.getNode()) + "/" + DistribConfiguration_Behavior.call_getVMOptionsFileName_1231749012626(_context.getNode()) + "." + DistribConfiguration_Behavior.call_getVMOptionsExt_1231692561653(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231782344957(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return DistribConfiguration_Behavior.call_getProjectFolderAntName_1230295546376(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1231782395899(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(_context.getNode(), "vmOptionsDir", true));
  }

  public static Object propertyMacro_GetPropertyValue_1231864177374(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "signatureConfiguration", true), "pathToExecutable", true));
  }

  public static Object propertyMacro_GetPropertyValue_1231864483288(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ArtifactReferenceCommandLinePart_Behavior.getExecutableFilePropertyName_1231864298769();
  }

  public static Object propertyMacro_GetPropertyValue_1231869446305(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String commandLine = "";
    for(SNode commandLinePart : ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "signatureConfiguration", true), "commandLine", true))) {
      commandLine += AbstractCommandLinePart_Behavior.call_getText_1231864533228(commandLinePart) + " ";
    }
    return commandLine;
  }

  public static Object propertyMacro_GetPropertyValue_1233942760190(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "defaultVMOptions");
  }

  public static Object propertyMacro_GetPropertyValue_1233943028266(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true)).replace("/", SConceptPropertyOperations.getString(_context.getNode(), "pathSeparator")).replace("\\", SConceptPropertyOperations.getString(_context.getNode(), "pathSeparator"));
  }

  public static Object propertyMacro_GetPropertyValue_1233943254796(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupClass");
  }

  public static Object referenceMacro_GetReferent_1230221358801(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "buildScriptConfiguration", false);
  }

  public static Object referenceMacro_GetReferent_1230564502576(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "SystemSpecificConfigToTargetDeclaration");
  }

  public static Object referenceMacro_GetReferent_1230577930415(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "TokeValuePairToExternalPropertyDeclaration");
  }

  public static Object referenceMacro_GetReferent_1230650252582(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "NullToMPSHomePropertyDeclaration");
  }

  public static Object referenceMacro_GetReferent_1230650270986(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "NullToMPSHomePropertyDeclaration");
  }

  public static boolean ifMacro_Condition_1230567183522(final IOperationContext operationContext, final IfMacroContext _context) {
    return StringUtils.isNotEmpty(DistribConfiguration_Behavior.call_getScriptsFolder_1230570100269(_context.getNode()));
  }

  public static boolean ifMacro_Condition_1230642866220(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "generateInstallUninstallLists");
  }

  public static boolean ifMacro_Condition_1230645373261(final IOperationContext operationContext, final IfMacroContext _context) {
    Language distLanguage = MPSModuleRepository.getInstance().getLanguage("jetbrains.mps.build.distrib");
    return distLanguage.isPackaged();
  }

  public static boolean ifMacro_Condition_1230649526198(final IOperationContext operationContext, final IfMacroContext _context) {
    SNode baseDirectory = SLinkOperations.getTarget(Configuration_Behavior.call_getLayout_1213877261819(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "buildScriptConfiguration", false)), "baseDirectory", true);
    return !(SPropertyOperations.getString(SLinkOperations.getTarget(baseDirectory, "macro", true), "name").equals(MPSLayout_Behavior.getMPSHomeName_1226508944077()));
  }

  public static boolean ifMacro_Condition_1230661197597(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true)).equals("."));
  }

  public static boolean ifMacro_Condition_1231685674769(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true)).equals("."));
  }

  public static boolean ifMacro_Condition_1231748274955(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "useVMOptionsFile");
  }

  public static boolean ifMacro_Condition_1231749156422(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "useVMOptionsFile");
  }

  public static boolean ifMacro_Condition_1231749236301(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "useVMOptionsFile");
  }

  public static boolean ifMacro_Condition_1231749815449(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true)).equals("."));
  }

  public static boolean ifMacro_Condition_1231750627497(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "useVMOptionsFile");
  }

  public static boolean ifMacro_Condition_1231760206565(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "useVMOptionsFile");
  }

  public static boolean ifMacro_Condition_1231760326149(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "useVMOptionsFile");
  }

  public static boolean ifMacro_Condition_1231863969703(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "signatureConfiguration", true) != null);
  }

  public static boolean ifMacro_Condition_1231864147687(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "signatureConfiguration", true) != null);
  }

  public static boolean ifMacro_Condition_1233942926108(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(AbstractPath_Behavior.call_getFullPath_1230059208735(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "startupDirectory", true)).equals("."));
  }

  public static Iterable sourceNodesQuery_1230059665156(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "classPath", true), "classPathItem", true)).skip(1);
  }

  public static Iterable sourceNodesQuery_1230234413536(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "systemSpecificConfig", true);
  }

  public static Iterable sourceNodesQuery_1230293101939(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(SystemSpecificConfig_Behavior.call_getDistribConfiguration_1230207861621(_context.getNode()), "classPath", true), "classPathItem", true);
  }

  public static Iterable sourceNodesQuery_1230564253749(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "systemSpecificConfig", true);
  }

  public static Iterable sourceNodesQuery_1230577704795(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "tokenValuePair", true);
  }

  public static Iterable sourceNodesQuery_1230577870076(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "tokenValuePair", true);
  }

  public static Iterable sourceNodesQuery_1231694345955(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    String[] options = SPropertyOperations.getString(_context.getNode(), "defaultVMOptions").split("\\s");
    List<SNode> lines = new ArrayList<SNode>();
    for(String option : options) {
      SNode line = SConceptOperations.createNewNode("jetbrains.mps.gtext.structure.GLine", null);
      SNode text = SConceptOperations.createNewNode("jetbrains.mps.gtext.structure.GText", null);
      SPropertyOperations.set(text, "text", option);
      SLinkOperations.addChild(line, "item", text);
      ListSequence.fromList(lines).addElement(line);
    }
    return lines;
  }

}
