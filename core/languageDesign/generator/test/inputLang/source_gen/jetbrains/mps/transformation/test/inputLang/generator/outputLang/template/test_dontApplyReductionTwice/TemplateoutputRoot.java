package jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_dontApplyReductionTwice;

/*Generated by MPS */

import jetbrains.mps.generator.runtime.TemplateDeclaration;
import java.util.Collection;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.generator.runtime.TemplateExecutionEnvironment;
import jetbrains.mps.generator.runtime.TemplateContext;
import jetbrains.mps.generator.runtime.GenerationException;
import jetbrains.mps.generator.runtime.TemplateUtil;

public class TemplateoutputRoot implements TemplateDeclaration {
  public TemplateoutputRoot() {
  }

  public Collection<SNode> apply(@NotNull final TemplateExecutionEnvironment environment, @NotNull TemplateContext context, String mappingName) throws GenerationException {
    final SNode tnode1 = new SNode(null, "jetbrains.mps.transformation.test.outputLang.structure.OutputRoot", false);
    // TODO notify environment 
    tnode1.setProperty("name", "outputRoot");
    tnode1.setProperty("text", "output for 'don't apply reduction rule twice' test");
    {
      final SNode tnode2 = new SNode(null, "jetbrains.mps.transformation.test.outputLang.structure.OutputNode_forDontApplyReductionTwice_test", false);
      // TODO notify environment 
      tnode2.setProperty("text", "this is OutputNode_forDontApplyReductionTwice_test actually");
      tnode1.addChild("outputChild", tnode2);
    }
    return TemplateUtil.singletonList(tnode1);

  }
}
