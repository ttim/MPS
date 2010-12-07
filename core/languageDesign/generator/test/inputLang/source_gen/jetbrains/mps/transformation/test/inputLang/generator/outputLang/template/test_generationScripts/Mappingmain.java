package jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts;

/*Generated by MPS */

import jetbrains.mps.generator.impl.GenerationFailureException;
import jetbrains.mps.generator.runtime.TemplateMappingConfiguration;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Collection;
import jetbrains.mps.generator.runtime.TemplateReductionRule;
import jetbrains.mps.generator.runtime.TemplateCreateRootRule;
import jetbrains.mps.generator.runtime.TemplateRootMappingRule;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.generator.runtime.TemplateUtil;
import jetbrains.mps.generator.runtime.TemplateWeavingRule;
import java.util.Collections;
import jetbrains.mps.generator.runtime.TemplateDropRootRule;
import jetbrains.mps.generator.runtime.TemplateMappingScript;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.generator.impl.AbandonRuleInputException;

public class Mappingmain implements TemplateMappingConfiguration {
  private static SNodePointer reductionRule_417xrn_a0a2a = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195170730024");
  private static SNodePointer rule_417xrn_b0b0c0e0 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195170730024");
  private static SNodePointer templateNode_417xrn_a0a0a2a2a4a = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195172462490");
  private static SNodePointer templateNode_417xrn_a0a0a2a0c0e0 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195172359599");
  private static SNodePointer reductionRule_417xrn_a0a2b = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1202780884290");
  private static SNodePointer rootMappingRule_417xrn_a0a0c = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195168895642");
  private static SNodePointer rootMappingRule_417xrn_b0b0a0a1c = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195168895642");
  private static SNodePointer createRootRule_417xrn_a0a0d = new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195165196524");

  private final Collection<TemplateReductionRule> rules;
  private final Collection<TemplateCreateRootRule> createRules;
  private final Collection<TemplateRootMappingRule> rootRules;
  private final TemplateModel myModel;

  public Mappingmain(TemplateModel model) {
    this.myModel = model;
    rules = TemplateUtil.<TemplateReductionRule>asCollection(new Mappingmain.ReductionRule0(), new Mappingmain.ReductionRule1());
    createRules = TemplateUtil.<TemplateCreateRootRule>asCollection(new Mappingmain.CreateRootRule0());
    rootRules = TemplateUtil.<TemplateRootMappingRule>asCollection(new Mappingmain.RootMappingRule0());
  }

  public String getName() {
    return null;
  }

  public TemplateModel getModel() {
    return null;
  }

  public SNodePointer getMappingNode() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195164863269");
  }

  public Collection<TemplateReductionRule> getReductionRules() {
    return rules;
  }

  public Collection<TemplateCreateRootRule> getCreateRules() {
    return createRules;
  }

  public Collection<TemplateRootMappingRule> getRootRules() {
    return rootRules;
  }

  public Collection<TemplateWeavingRule> getWeavingRules() {
    return Collections.emptySet();
  }

  public Collection<TemplateDropRootRule> getDropRules() {
    return Collections.emptySet();
  }

  public Collection<TemplateMappingScript> getPostScripts() {
    return null;
  }

  public Collection<TemplateMappingScript> getPreScripts() {
    return null;
  }

  public class ReductionRule0 implements TemplateReductionRule {
    public ReductionRule0() {
    }

    public boolean applyToInheritors() {
      return true;
    }

    public String getApplicableConcept() {
      return "jetbrains.mps.transformation.test.inputLang.structure.InputNode_A";
    }

    public SNodePointer getRuleNode() {
      return reductionRule_417xrn_a0a2a;
    }

    public Collection<SNode> tryToApply(final TemplateExecutionEnvironment environment, final TemplateContext context) throws GenerationException {
      if (!(QueriesGenerated.baseMappingRule_Condition_1202780919451(environment.getOperationContext(), new BaseMappingRuleContext(context.getInput(), reductionRule_417xrn_a0a2a, environment.getGenerator())))) {
        return null;
      }

      environment.getTracer().pushRule(reductionRule_417xrn_a0a2a);
      try {
        return apply(context, environment.getEnvironment(context.getInput(), this));
      } catch (AbandonRuleInputException e) {
        return Collections.emptyList();
      } finally {
        environment.getTracer().closeRule(reductionRule_417xrn_a0a2a);
      }

    }

    private Collection<SNode> apply(final TemplateContext context, final TemplateExecutionEnvironment environment) throws GenerationException {
      environment.getTracer().pushRuleConsequence(new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195172342079"));
      Collection<SNode> tlist1 = null;
      if (QueriesGenerated.baseMappingRule_Condition_1195172400866(environment.getOperationContext(), new BaseMappingRuleContext(context.getInput(), rule_417xrn_b0b0c0e0, environment.getGenerator()))) {
        environment.getTracer().pushRuleConsequence(new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195172456957"));
        final SNode tnode2 = new SNode(environment.getOutputModel(), "jetbrains.mps.transformation.test.outputLang.structure.OutputNode", false);
        try {
          environment.getTracer().pushTemplateNode(templateNode_417xrn_a0a0a2a2a4a);
          environment.nodeCopied(context, tnode2, "tpl/r:00000000-0000-4000-0000-011c895905f6/1195172462490");
          tnode2.setProperty("text", "<input option : 1>");

        } finally {
          environment.getTracer().pushOutputNode(tnode2);
          environment.getTracer().closeTemplateNode(templateNode_417xrn_a0a0a2a2a4a);
        }
        tlist1 = TemplateUtil.singletonList(tnode2);
      } else {
        environment.getTracer().pushRuleConsequence(new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1195172354175"));
        final SNode tnode3 = new SNode(environment.getOutputModel(), "jetbrains.mps.transformation.test.outputLang.structure.OutputNode", false);
        try {
          environment.getTracer().pushTemplateNode(templateNode_417xrn_a0a0a2a0c0e0);
          environment.nodeCopied(context, tnode3, "tpl/r:00000000-0000-4000-0000-011c895905f6/1195172359599");
          tnode3.setProperty("text", "<input option : default>");

        } finally {
          environment.getTracer().pushOutputNode(tnode3);
          environment.getTracer().closeTemplateNode(templateNode_417xrn_a0a0a2a0c0e0);
        }
        tlist1 = TemplateUtil.singletonList(tnode3);
      }
      return tlist1;
    }
  }

  public class ReductionRule1 implements TemplateReductionRule {
    public ReductionRule1() {
    }

    public boolean applyToInheritors() {
      return false;
    }

    public String getApplicableConcept() {
      return "jetbrains.mps.transformation.test.inputLang.structure.InputNode_A";
    }

    public SNodePointer getRuleNode() {
      return reductionRule_417xrn_a0a2b;
    }

    public Collection<SNode> tryToApply(final TemplateExecutionEnvironment environment, final TemplateContext context) throws GenerationException {
      if (!(QueriesGenerated.baseMappingRule_Condition_1202780894871(environment.getOperationContext(), new BaseMappingRuleContext(context.getInput(), reductionRule_417xrn_a0a2b, environment.getGenerator())))) {
        return null;
      }

      environment.getTracer().pushRule(reductionRule_417xrn_a0a2b);
      try {
        return apply(context, environment.getEnvironment(context.getInput(), this));
      } catch (AbandonRuleInputException e) {
        return Collections.emptyList();
      } finally {
        environment.getTracer().closeRule(reductionRule_417xrn_a0a2b);
      }

    }

    private Collection<SNode> apply(final TemplateContext context, final TemplateExecutionEnvironment environment) throws GenerationException {
      environment.getTracer().pushRuleConsequence(new SNodePointer("r:00000000-0000-4000-0000-011c895905f6(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_generationScripts@generator)", "1202781047034"));
      Collection<SNode> tlist1 = Collections.emptyList();
      return tlist1;
    }
  }

  public class RootMappingRule0 implements TemplateRootMappingRule {
    public RootMappingRule0() {
    }

    public SNodePointer getRuleNode() {
      return rootMappingRule_417xrn_a0a0c;
    }

    public Collection<SNode> apply(final TemplateExecutionEnvironment environment, final TemplateContext context) throws GenerationException {
      if (!(QueriesGenerated.baseMappingRule_Condition_1202243113773(environment.getOperationContext(), new BaseMappingRuleContext(context.getInput(), rootMappingRule_417xrn_b0b0a0a1c, environment.getGenerator())))) {
        return null;
      }
      return new TemplateOutputRoot_by_MappingRule().apply(environment, context);
    }

    public boolean applyToInheritors() {
      return false;
    }

    public String getApplicableConcept() {
      return "jetbrains.mps.transformation.test.inputLang.structure.InputRoot";
    }

    public boolean keepSourceRoot() {
      return false;
    }

    @Override
    public boolean isApplicable(TemplateExecutionEnvironment environment, TemplateContext context) throws GenerationFailureException {
      return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
  }

  public class CreateRootRule0 implements TemplateCreateRootRule {
    public CreateRootRule0() {
    }

    public SNodePointer getRuleNode() {
      return createRootRule_417xrn_a0a0d;
    }

    public Collection<SNode> apply(TemplateExecutionEnvironment environment) {
      return null;
    }

    @Override
    public boolean isApplicable(TemplateExecutionEnvironment environment, TemplateContext context) throws GenerationException {
      return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
  }
}
