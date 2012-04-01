package jetbrains.mps.nanoc.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.custom.BaseCustomApplicationPlugin;
import java.util.List;
import com.intellij.execution.configurations.ConfigurationType;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.junit.RuntimeConfigurationProducer;
import com.intellij.openapi.extensions.ExtensionPoint;
import com.intellij.openapi.extensions.Extensions;

public class RunConfigurationsInitializer_CustomApplicationPlugin extends BaseCustomApplicationPlugin {
  private List<ConfigurationType> myRegisteredKinds = ListSequence.fromList(new ArrayList<ConfigurationType>());
  private List<RuntimeConfigurationProducer> myRegisteredProducers = ListSequence.fromList(new ArrayList<RuntimeConfigurationProducer>());

  public RunConfigurationsInitializer_CustomApplicationPlugin() {
  }

  public void doInit() {
    // register kinds 
    ExtensionPoint<ConfigurationType> configurationExtensionPoint = Extensions.getArea(null).getExtensionPoint(ConfigurationType.CONFIGURATION_TYPE_EP);
    {
      ExecutableFile_Kind runConfigurationKind = new ExecutableFile_Kind();
      ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredKinds).addElement(runConfigurationKind);
      configurationExtensionPoint.registerExtension(runConfigurationKind);
    }

    // add foreign factories 

    // register creators 
  }

  public void doDispose() {
    ExtensionPoint<ConfigurationType> configurationExtensionPoint = Extensions.getArea(null).getExtensionPoint(ConfigurationType.CONFIGURATION_TYPE_EP);
    for (ConfigurationType configurationKind : ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredKinds).reversedList()) {
      configurationExtensionPoint.unregisterExtension(configurationKind);
    }
    ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredKinds).clear();

    ExtensionPoint<RuntimeConfigurationProducer> producerExtensionPoint = Extensions.getArea(null).getExtensionPoint(RuntimeConfigurationProducer.RUNTIME_CONFIGURATION_PRODUCER);
    for (RuntimeConfigurationProducer producer : ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredProducers)) {
      producerExtensionPoint.unregisterExtension(producer);
    }
    ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredProducers).clear();
  }
}
