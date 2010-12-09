package jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceOneToMany;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.TemplateSwitchMapping;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.generator.runtime.TemplateReductionRule;
import jetbrains.mps.generator.runtime.TemplateUtil;
import java.util.Collection;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.impl.AbandonRuleInputException;
import java.util.Collections;

public class Switchswitch_InputNode_A implements TemplateSwitchMapping {
  private static SNodePointer reductionRule_lzrtm3_a0a2a = new SNodePointer("r:eca8e1c7-93fd-4ddf-9db6-91f9c2320691(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceOneToMany@generator)", "1892993302480310367");
  private static SNodePointer conseq_lzrtm3_a0a0a4a = new SNodePointer("r:eca8e1c7-93fd-4ddf-9db6-91f9c2320691(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceOneToMany@generator)", "1892993302480311962");

  private final Iterable<TemplateReductionRule> rules;

  public Switchswitch_InputNode_A() {
    rules = TemplateUtil.<TemplateReductionRule>asIterable(new Switchswitch_InputNode_A.ReductionRule0());
  }

  public SNodePointer getSwitchNode() {
    return new SNodePointer("r:eca8e1c7-93fd-4ddf-9db6-91f9c2320691(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceOneToMany@generator)", "1892993302480310366");
  }

  public SNodePointer getModifiesSwitch() {
    return null;
  }

  public Iterable<TemplateReductionRule> getReductionRules() {
    return rules;
  }

  public Collection<SNode> applyDefault(final TemplateExecutionEnvironment environment, SNodePointer templateSwitch, String mappingLabel, final TemplateContext context) {
    return null;
  }

  public void processNull(TemplateExecutionEnvironment environment, SNodePointer templateSwitch, TemplateContext context) {
  }

  public class ReductionRule0 implements TemplateReductionRule {
    public ReductionRule0() {
    }

    public boolean applyToInheritors() {
      return false;
    }

    public String getApplicableConcept() {
      return "jetbrains.mps.transformation.test.inputLang.structure.InputNode_A";
    }

    public SNodePointer getRuleNode() {
      return reductionRule_lzrtm3_a0a2a;
    }

    public Collection<SNode> tryToApply(final TemplateExecutionEnvironment environment, final TemplateContext context) throws GenerationException {

      environment.getTracer().pushRule(reductionRule_lzrtm3_a0a2a);
      try {
        return apply(context, environment.getEnvironment(context.getInput(), this));
      } catch (AbandonRuleInputException e) {
        return Collections.emptyList();
      } finally {
        environment.getTracer().closeRule(reductionRule_lzrtm3_a0a2a);
      }

    }

    private Collection<SNode> apply(final TemplateContext context, final TemplateExecutionEnvironment environment) throws GenerationException {
      environment.getTracer().pushRuleConsequence(conseq_lzrtm3_a0a0a4a);
      Collection<SNode> tlist1 = new Templatereduce_InputNode_A_switch().apply(environment, context);
      return tlist1;
    }
  }
}
