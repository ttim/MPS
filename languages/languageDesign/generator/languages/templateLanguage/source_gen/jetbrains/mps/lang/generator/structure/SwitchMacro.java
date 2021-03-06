package jetbrains.mps.lang.generator.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SwitchMacro extends SourceSubstituteMacro {
  public static final String concept = "jetbrains.mps.lang.generator.structure.SwitchMacro";
  public static final String TEMPLATE_SWITCH = "templateSwitch";
  public static final String SOURCE_NODE_QUERY = "sourceNodeQuery";

  public SwitchMacro(SNode node) {
    super(node);
  }

  public TemplateSwitch getTemplateSwitch() {
    return (TemplateSwitch) this.getReferent(TemplateSwitch.class, SwitchMacro.TEMPLATE_SWITCH);
  }

  public void setTemplateSwitch(TemplateSwitch node) {
    super.setReferent(SwitchMacro.TEMPLATE_SWITCH, node);
  }

  public SourceSubstituteMacro_SourceNodeQuery getSourceNodeQuery() {
    return (SourceSubstituteMacro_SourceNodeQuery) this.getChild(SourceSubstituteMacro_SourceNodeQuery.class, SwitchMacro.SOURCE_NODE_QUERY);
  }

  public void setSourceNodeQuery(SourceSubstituteMacro_SourceNodeQuery node) {
    super.setChild(SwitchMacro.SOURCE_NODE_QUERY, node);
  }

  public static SwitchMacro newInstance(SModel sm, boolean init) {
    return (SwitchMacro) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.structure.SwitchMacro", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SwitchMacro newInstance(SModel sm) {
    return SwitchMacro.newInstance(sm, false);
  }
}
