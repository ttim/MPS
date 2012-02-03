package jetbrains.mps.buildScript.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.custom.BaseCustomApplicationPlugin;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import com.intellij.execution.configurations.ConfigurationType;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.execution.junit.RuntimeConfigurationProducer;
import com.intellij.openapi.extensions.ExtensionPoint;
import com.intellij.openapi.extensions.Extensions;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.intellij.util.containers.ContainerUtil;

public class RunConfigurationsInitializer_CustomApplicationPlugin extends BaseCustomApplicationPlugin {
  protected static Log log = LogFactory.getLog(RunConfigurationsInitializer_CustomApplicationPlugin.class);

  private List<ConfigurationType> myRegisteredKinds = ListSequence.fromList(new ArrayList<ConfigurationType>());
  private List<RuntimeConfigurationProducer> myRegisteredProducers = ListSequence.fromList(new ArrayList<RuntimeConfigurationProducer>());

  public RunConfigurationsInitializer_CustomApplicationPlugin() {
  }

  public void doInit() {
    // register kinds 
    ExtensionPoint<ConfigurationType> configurationExtensionPoint = Extensions.getArea(null).getExtensionPoint(ConfigurationType.CONFIGURATION_TYPE_EP);
    {
      BuildScript_Kind runConfigurationKind = new BuildScript_Kind();
      ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredKinds).addElement(runConfigurationKind);
      configurationExtensionPoint.registerExtension(runConfigurationKind);
    }

    // add foreign factories 
    _FunctionTypes._return_P1_E0<? extends Class<ConfigurationType>, ? super String> getClassFunction = new _FunctionTypes._return_P1_E0<Class<ConfigurationType>, String>() {
      public Class<ConfigurationType> invoke(String className) {
        try {
          return (Class<ConfigurationType>) getClass().getClassLoader().loadClass(className);
        } catch (ClassNotFoundException cl) {
          if (log.isErrorEnabled()) {
            log.error("Can not find configuration type " + className + ". Check languages dependency.", cl);
          }
          return (Class<ConfigurationType>) null;
        }
      }
    };

    // register creators 
    ExtensionPoint<RuntimeConfigurationProducer> producerExtensionPoint = Extensions.getArea(null).getExtensionPoint(RuntimeConfigurationProducer.RUNTIME_CONFIGURATION_PRODUCER);
    {
      ConfigurationType configurationType = ContainerUtil.findInstance(configurationExtensionPoint.getExtensions(), getClassFunction.invoke("jetbrains.mps.buildScript.pluginSolution.plugin.BuildScript_Kind"));
      if (configurationType != null) {
        List<RuntimeConfigurationProducer> configurationProducers = BuildScript_Producer.getProducers(configurationType);
        ListSequence.fromList(RunConfigurationsInitializer_CustomApplicationPlugin.this.myRegisteredProducers).addSequence(ListSequence.fromList(configurationProducers));
        for (RuntimeConfigurationProducer producer : ListSequence.fromList(configurationProducers)) {
          producerExtensionPoint.registerExtension(producer);
        }
      }
    }
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
