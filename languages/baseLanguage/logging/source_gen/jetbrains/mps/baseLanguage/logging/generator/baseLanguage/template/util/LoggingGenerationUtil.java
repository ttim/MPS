package jetbrains.mps.baseLanguage.logging.generator.baseLanguage.template.util;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.Language;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class LoggingGenerationUtil {
  public LoggingGenerationUtil() {
  }

  public static SNode toPlus(List<SNode> textExpressions) {
    SNode result = null;
    if (ListSequence.fromList(textExpressions).isNotEmpty()) {
      result = SNodeOperations.copyNode(ListSequence.fromList(textExpressions).first());
      for (SNode textExpression : ListSequence.fromList(textExpressions).skip(1)) {
        result = new LoggingGenerationUtil.QuotationClass_gd2srw_a0a0a1a1a0().createNode(SNodeOperations.copyNode(textExpression), result);
      }
    }
    return result;
  }

  public static boolean isDesignTimeModel(SModel sm) {
    return Language.getLanguageFor(sm.getModelDescriptor()) != null;
  }

  public static class QuotationClass_gd2srw_a0a0a1a1a0 {
    public QuotationClass_gd2srw_a0a0a1a1a0() {
    }

    public SNode createNode(Object parameter_7, Object parameter_8) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.PlusExpression", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_7;
          SNode quotedNode1_5;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_5 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_5 = quotedNode_2;
          }
          if (quotedNode1_5 != null) {
            quotedNode_1.addChild("rightExpression", HUtil.copyIfNecessary(quotedNode1_5));
          }
        }
        {
          quotedNode_3 = (SNode) parameter_8;
          SNode quotedNode1_6;
          if (_parameterValues_129834374.contains(quotedNode_3)) {
            quotedNode1_6 = HUtil.copyIfNecessary(quotedNode_3);
          } else {
            _parameterValues_129834374.add(quotedNode_3);
            quotedNode1_6 = quotedNode_3;
          }
          if (quotedNode1_6 != null) {
            quotedNode_1.addChild("leftExpression", HUtil.copyIfNecessary(quotedNode1_6));
          }
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }
}
