package jetbrains.mps.execution.configurations.implementation.plugin.plugin;

/*Generated by MPS */

import java.util.List;
import com.intellij.execution.junit.RuntimeConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationType;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.plugins.pluginparts.runconfigs.BaseConfigCreator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.plugins.runconfigs.MPSPsiElement;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class BuildLanguageProject_Producer {
  private static String CONFIGURATION_FACTORY_CLASS_NAME = "jetbrains.mps.execution.configurations.implementation.plugin.plugin.BuildLanguageProject_Configuration_Factory";

  public BuildLanguageProject_Producer() {
  }

  public static List<RuntimeConfigurationProducer> getProducers(ConfigurationType configurationType) {
    List<RuntimeConfigurationProducer> creators = ListSequence.fromList(new ArrayList<RuntimeConfigurationProducer>());
    ListSequence.fromList(creators).addElement(new BuildLanguageProject_Producer.ProducerPart_NodeProject_bfnvl3_a(configurationType, CONFIGURATION_FACTORY_CLASS_NAME));
    return creators;
  }

  public static class ProducerPart_NodeProject_bfnvl3_a extends BaseConfigCreator<SNode> {
    public ProducerPart_NodeProject_bfnvl3_a(ConfigurationType configurationType, String factoryName) {
      super(configurationType, factoryName);
    }

    protected boolean isApplicable(Object source) {
      return source instanceof SNode && SNodeOperations.isInstanceOf(((SNode) source), "jetbrains.mps.buildlanguage.structure.Project");
    }

    protected BuildLanguageProject_Configuration doCreateConfiguration(final SNode source) {
      setSourceElement(new MPSPsiElement(source));
      BuildLanguageProject_Configuration configuration = new BuildLanguageProject_Configuration(getContext().getProject(), (BuildLanguageProject_Configuration_Factory) getConfigurationFactory(), "Build Script " + SPropertyOperations.getString(source, "name"));
      configuration.getNode().setNode(source);
      return configuration;
    }

    @Override
    public BuildLanguageProject_Producer.ProducerPart_NodeProject_bfnvl3_a clone() {
      return (BuildLanguageProject_Producer.ProducerPart_NodeProject_bfnvl3_a) super.clone();
    }
  }
}
