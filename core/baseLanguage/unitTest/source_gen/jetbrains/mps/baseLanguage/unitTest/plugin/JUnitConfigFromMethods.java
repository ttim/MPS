package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.runconfigs.BaseConfigCreator;
import java.util.List;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.util.containers.ContainerUtil;
import com.intellij.openapi.extensions.Extensions;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.plugins.pluginparts.runconfigs.MPSPsiElement;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.unitTest.behavior.ITestMethod_Behavior;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;

public class JUnitConfigFromMethods extends BaseConfigCreator<List> implements Cloneable {
  private RunConfiguration myConfig;

  public JUnitConfigFromMethods() {
    super(ContainerUtil.findInstance(Extensions.getExtensions(JUnit_ConfigurationType.CONFIGURATION_TYPE_EP), JUnit_ConfigurationType.class));
  }

  protected RunConfiguration doCreateConfiguration(List node) {
    this.createConfig(node);
    return this.myConfig;
  }

  private void createConfig(final List<SNode> parameter) {
    JUnitConfigFromMethods.this.setSourceElement(new MPSPsiElement<List>(parameter));

    List<String> methodNames = ListSequence.fromList(new ArrayList<String>());
    List<String> nodeNames = ListSequence.fromList(new ArrayList<String>());
    for (SNode method : parameter) {
      ListSequence.fromList(methodNames).addElement(ITestMethod_Behavior.call_getTestName_1216136419751(method));
      if (ListSequence.fromList(nodeNames).contains(INamedConcept_Behavior.call_getFqName_1213877404258(ITestMethod_Behavior.call_getTestCase_1216134500045(method)))) {
        continue;
      }
      ListSequence.fromList(nodeNames).addElement(INamedConcept_Behavior.call_getFqName_1213877404258(ITestMethod_Behavior.call_getTestCase_1216134500045(method)));
    }

    boolean isCompileInMPS = SNodeOperations.getModel(Sequence.fromIterable(parameter).first()).getModelDescriptor().getModule().isCompileInMPS();
    {
      JUnit_ConfigurationType configType = ContainerUtil.findInstance(Extensions.getExtensions(JUnit_ConfigurationType.CONFIGURATION_TYPE_EP), JUnit_ConfigurationType.class);
      DefaultJUnit_Configuration _config = new DefaultJUnit_Configuration(JUnitConfigFromMethods.this.getContext().getProject(), configType.getConfigurationFactories()[0], "NewConfig") {
        @Override
        public String suggestedName() {
          return "Several Test Methods";
        }
      };
      _config.setName(ITestMethod_Behavior.call_getTestName_1216136419751(Sequence.fromIterable(parameter).first()) + ",...");
      _config.getStateObject().type = JUnitRunTypes.METHOD;
      _config.getStateObject().methods = methodNames;
      _config.getStateObject().nodes = nodeNames;
      _config.getStateObject().compileInMPS = isCompileInMPS;
      JUnitConfigFromMethods.this.myConfig = _config;
    }
  }

  @Override
  public JUnitConfigFromMethods clone() {
    return ((JUnitConfigFromMethods) super.clone());
  }

  protected boolean isApplicable(final Object element) {
    if (!(element instanceof List)) {
      return false;
    }
    for (Object obj : (List) element) {
      if (!(obj instanceof SNode && SNodeOperations.isInstanceOf(((SNode) obj), "jetbrains.mps.baseLanguage.unitTest.structure.ITestMethod"))) {
        return false;
      }
    }
    return true;
  }
}
