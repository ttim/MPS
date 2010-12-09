package jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.TemplateDeclaration;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Collection;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import java.util.Collections;
import jetbrains.mps.generator.runtime.TemplateUtil;

public class Templateout_class implements TemplateDeclaration {
  private static SNodePointer template_b1jp4m_a0a0 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150125542");
  private static SNodePointer templateNode_b1jp4m_a0a0a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150125542");
  private static SNodePointer templateNode_b1jp4m_a0a0a1a4a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150155196");
  private static SNodePointer templateNode_b1jp4m_a0a0a1a4a1a4a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150155197");
  private static SNodePointer templateNode_b1jp4m_a0a0a1a5a1a4a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150155198");
  private static SNodePointer copySrcMacro_b1jp4m_a0a0a1a6a1a4a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150187920");
  private static SNodePointer templateNode_b1jp4m_a0a0a1a5a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c895905f8(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement@generator)", "1209150125543");

  public Templateout_class() {
  }

  public SNodePointer getTemplateNode() {
    return template_b1jp4m_a0a0;
  }

  public Collection<SNode> apply(@NotNull final TemplateExecutionEnvironment environment, @NotNull final TemplateContext context) throws GenerationException {
    final SNode tnode1 = new SNode(environment.getOutputModel(), "jetbrains.mps.baseLanguage.structure.ClassConcept", false);
    try {
      environment.getTracer().pushTemplateNode(templateNode_b1jp4m_a0a0a1a1);
      environment.nodeCopied(context, tnode1, "tpl/r:00000000-0000-4000-0000-011c895905f8/1209150125542");
      tnode1.setProperty("name", "out_class");

      {
        final SNode tnode2 = new SNode(environment.getOutputModel(), "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration", false);
        try {
          environment.getTracer().pushTemplateNode(templateNode_b1jp4m_a0a0a1a4a1a1);
          environment.nodeCopied(context, tnode2, "tpl/r:00000000-0000-4000-0000-011c895905f8/1209150155196");
          tnode2.setProperty("name", "method");

          {
            final SNode tnode3 = new SNode(environment.getOutputModel(), "jetbrains.mps.baseLanguage.structure.VoidType", false);
            try {
              environment.getTracer().pushTemplateNode(templateNode_b1jp4m_a0a0a1a4a1a4a1a1);
              environment.nodeCopied(context, tnode3, "tpl/r:00000000-0000-4000-0000-011c895905f8/1209150155197");

            } finally {
              environment.getTracer().pushOutputNode(tnode3);
              environment.getTracer().closeTemplateNode(templateNode_b1jp4m_a0a0a1a4a1a4a1a1);
            }
            tnode2.addChild("returnType", tnode3);
            // TODO validate child 
          }
          {
            final SNode tnode4 = new SNode(environment.getOutputModel(), "jetbrains.mps.baseLanguage.structure.PublicVisibility", false);
            try {
              environment.getTracer().pushTemplateNode(templateNode_b1jp4m_a0a0a1a5a1a4a1a1);
              environment.nodeCopied(context, tnode4, "tpl/r:00000000-0000-4000-0000-011c895905f8/1209150155198");

            } finally {
              environment.getTracer().pushOutputNode(tnode4);
              environment.getTracer().closeTemplateNode(templateNode_b1jp4m_a0a0a1a5a1a4a1a1);
            }
            tnode2.addChild("visibility", tnode4);
            // TODO validate child 
          }
          {
            Collection<SNode> tlist5 = null;
            try {
              environment.getTracer().pushMacro(copySrcMacro_b1jp4m_a0a0a1a6a1a4a1a1);
              final SNode copySrcInput5 = QueriesGenerated.sourceNodeQuery_1209150187921(environment.getOperationContext(), new SourceSubstituteMacroNodeContext(context.getInput(), copySrcMacro_b1jp4m_a0a0a1a6a1a4a1a1, context, environment.getGenerator()));
              tlist5 = environment.copyNodes(Collections.singletonList(copySrcInput5), copySrcMacro_b1jp4m_a0a0a1a6a1a4a1a1, null, context);
            } finally {
              environment.getTracer().closeMacro(copySrcMacro_b1jp4m_a0a0a1a6a1a4a1a1);
            }
            for (SNode child6 : tlist5) {
              tnode2.addChild("body", child6);
            }
            // TODO validate child 
          }
        } finally {
          environment.getTracer().pushOutputNode(tnode2);
          environment.getTracer().closeTemplateNode(templateNode_b1jp4m_a0a0a1a4a1a1);
        }
        tnode1.addChild("method", tnode2);
        // TODO validate child 
      }
      {
        final SNode tnode7 = new SNode(environment.getOutputModel(), "jetbrains.mps.baseLanguage.structure.PublicVisibility", false);
        try {
          environment.getTracer().pushTemplateNode(templateNode_b1jp4m_a0a0a1a5a1a1);
          environment.nodeCopied(context, tnode7, "tpl/r:00000000-0000-4000-0000-011c895905f8/1209150125543");

        } finally {
          environment.getTracer().pushOutputNode(tnode7);
          environment.getTracer().closeTemplateNode(templateNode_b1jp4m_a0a0a1a5a1a1);
        }
        tnode1.addChild("visibility", tnode7);
        // TODO validate child 
      }
    } finally {
      environment.getTracer().pushOutputNode(tnode1);
      environment.getTracer().closeTemplateNode(templateNode_b1jp4m_a0a0a1a1);
    }
    return TemplateUtil.singletonList(tnode1);

  }

  public Collection<SNode> weave(@NotNull TemplateExecutionEnvironment environment, @NotNull TemplateContext context, @NotNull SNode node) throws GenerationException {
    return null;
  }
}
