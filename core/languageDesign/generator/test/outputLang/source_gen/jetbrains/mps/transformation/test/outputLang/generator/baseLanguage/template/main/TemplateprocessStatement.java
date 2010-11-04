package jetbrains.mps.transformation.test.outputLang.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.TemplateDeclaration;
import java.util.Collection;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import java.util.Collections;
import jetbrains.mps.generator.runtime.TemplateUtil;

public class TemplateprocessStatement implements TemplateDeclaration {
  public TemplateprocessStatement() {
  }

  public Collection<SNode> apply(@NotNull final TemplateExecutionEnvironment environment, @NotNull TemplateContext context, String mappingName) throws GenerationException {
    final SNode tnode1 = new SNode(null, "jetbrains.mps.baseLanguage.structure.BlockStatement", false);
    // TODO notify environment 
    {
      final SNode tnode2 = new SNode(null, "jetbrains.mps.baseLanguage.structure.StatementList", false);
      // TODO notify environment 
      {
        final SNode tnode3 = new SNode(null, "jetbrains.mps.baseLanguage.structure.SingleLineComment", false);
        // TODO notify environment 
        {
          final SNode tnode4 = new SNode(null, "jetbrains.mps.baseLanguage.structure.TextCommentPart", false);
          // TODO notify environment 
          tnode4.setProperty("text", (String) QueriesGenerated.propertyMacro_GetPropertyValue_2681305894288695070(null, new PropertyMacroContext(context.getInput(), null, null, context, null)));
          tnode3.addChild("commentPart", tnode4);
        }
        {
          final SNode tnode5 = new SNode(null, "jetbrains.mps.baseLanguage.structure.TextCommentPart", false);
          // TODO notify environment 
          tnode5.setProperty("text", (String) QueriesGenerated.propertyMacro_GetPropertyValue_2163819695913280744(null, new PropertyMacroContext(context.getInput(), null, null, context, null)));
          tnode3.addChild("commentPart", tnode5);
        }
        tnode2.addChild("statement", tnode3);
      }
      {
        final SNode tnode6 = new SNode(null, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement", false);
        // TODO notify environment 
        {
          final SNode tnode7 = new SNode(null, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", false);
          // TODO notify environment 
          tnode7.setProperty("name", (String) QueriesGenerated.propertyMacro_GetPropertyValue_2681305894288695040(null, new PropertyMacroContext(context.getInput(), null, null, context, null)));
          {
            final SNode tnode8 = new SNode(null, "jetbrains.mps.baseLanguage.structure.IntegerType", false);
            // TODO notify environment 
            tnode7.addChild("type", tnode8);
          }
          {
            final SNode sourcenode9 = QueriesGenerated.sourceNodeQuery_2681305894288695056(null, new SourceSubstituteMacroNodeContext(context.getInput(), null, context, null));
            Collection<SNode> tlist10 = environment.copyNodes(Collections.singletonList(sourcenode9), null);
            for (SNode child11 : tlist10) {
              tnode7.addChild("initializer", child11);
            }
          }
          tnode6.addChild("localVariableDeclaration", tnode7);
        }
        tnode2.addChild("statement", tnode6);
      }
      tnode1.addChild("statements", tnode2);
    }
    final SNode tnode12 = new SNode(null, "jetbrains.mps.baseLanguage.structure.BlockStatement", false);
    // TODO notify environment 
    {
      final SNode tnode13 = new SNode(null, "jetbrains.mps.baseLanguage.structure.StatementList", false);
      // TODO notify environment 
      {
        final SNode tnode14 = new SNode(null, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement", false);
        // TODO notify environment 
        {
          final SNode tnode15 = new SNode(null, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", false);
          // TODO notify environment 
          tnode15.setProperty("name", "e");
          {
            final SNode tnode16 = new SNode(null, "jetbrains.mps.baseLanguage.structure.IntegerType", false);
            // TODO notify environment 
            tnode15.addChild("type", tnode16);
          }
          tnode14.addChild("localVariableDeclaration", tnode15);
        }
        tnode13.addChild("statement", tnode14);
      }
      {
        final SNode tnode17 = new SNode(null, "jetbrains.mps.baseLanguage.structure.ExpressionStatement", false);
        // TODO notify environment 
        {
          final SNode tnode18 = new SNode(null, "jetbrains.mps.baseLanguage.structure.AssignmentExpression", false);
          // TODO notify environment 
          {
            final SNode tnode19 = new SNode(null, "jetbrains.mps.baseLanguage.structure.LocalVariableReference", false);
            // TODO notify environment 
            environment.resolveInTemplateLater(tnode19, "variableDeclaration", "tpl/r:00000000-0000-4000-0000-011c89590606/3392060900980649133", context);
            tnode18.addChild("lValue", tnode19);
          }
          {
            final SNode tnode20 = new SNode(null, "jetbrains.mps.baseLanguage.structure.IntegerConstant", false);
            // TODO notify environment 
            tnode20.setProperty("value", "5");
            tnode18.addChild("rValue", tnode20);
          }
          tnode17.addChild("expression", tnode18);
        }
        tnode13.addChild("statement", tnode17);
      }
      tnode12.addChild("statements", tnode13);
    }
    return TemplateUtil.asList(tnode1, tnode12);
  }
}
