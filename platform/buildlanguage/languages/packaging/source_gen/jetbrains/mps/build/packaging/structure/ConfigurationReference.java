package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConfigurationReference extends BaseConcept {
  public static final String concept = "jetbrains.mps.build.packaging.structure.ConfigurationReference";
  public static final String CONFIGURATION = "configuration";

  public ConfigurationReference(SNode node) {
    super(node);
  }


  public Configuration getConfiguration() {
    return (Configuration)this.getReferent(Configuration.class, ConfigurationReference.CONFIGURATION);
  }

  public void setConfiguration(Configuration node) {
    super.setReferent(ConfigurationReference.CONFIGURATION, node);
  }

  public static ConfigurationReference newInstance(SModel sm, boolean init) {
    return (ConfigurationReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.ConfigurationReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConfigurationReference newInstance(SModel sm) {
    return ConfigurationReference.newInstance(sm, false);
  }
}
