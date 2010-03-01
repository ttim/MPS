package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.custom.BaseCustomApplicationPlugin;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.debug.DebugInfoManager;
import jetbrains.mps.util.Mapper;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class DebugInfoInitializer_CustomApplicationPlugin extends BaseCustomApplicationPlugin {
  private static Logger LOG = Logger.getLogger(DebugInfoInitializer_CustomApplicationPlugin.class);

  public DebugInfoInitializer_CustomApplicationPlugin() {
  }

  public void doInit() {
    DebugInfoManager manager = DebugInfoManager.getInstance();
    manager.addDebuggableConcept("jetbrains.mps.baseLanguage.structure.Statement");
    manager.addDebuggableConcept("jetbrains.mps.baseLanguage.structure.FieldDeclaration");
    manager.addDebuggableConcept("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration");
    manager.addDebuggableConcept("jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration");
    manager.addVariableConcept("jetbrains.mps.baseLanguage.structure.LocalVariableReference", new Mapper<SNode, SNode>() {
      public SNode value(SNode key) {
        return SLinkOperations.getTarget(key, "variableDeclaration", false);
      }
    });
    manager.addVariableConcept("jetbrains.mps.baseLanguage.structure.ParameterReference", new Mapper<SNode, SNode>() {
      public SNode value(SNode key) {
        return SLinkOperations.getTarget(key, "variableDeclaration", false);
      }
    });
  }
}
