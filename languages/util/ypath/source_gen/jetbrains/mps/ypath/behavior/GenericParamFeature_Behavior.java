package jetbrains.mps.ypath.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class GenericParamFeature_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getterExpression_1213877249152(SNode thisNode, SNode srcExpr, SNode param, ITemplateGenerator generator) {
    return FeatureUtil.getterExpression(thisNode, srcExpr, ((SLinkOperations.getTarget(param, "paramRef", false) != null) ?
      SLinkOperations.getTarget(param, "paramRef", false) :
      SPropertyOperations.getString(param, "paramValue")
    ), generator);
  }

  public static boolean virtual_isSingleCardinality_1213877249147(SNode thisNode, SNode param) {
    return FeatureUtil.isSingleTargetCardinality(thisNode, ((SLinkOperations.getTarget(param, "paramRef", false) != null) ?
      SLinkOperations.getTarget(param, "paramRef", false) :
      SPropertyOperations.getString(param, "paramValue")
    ));
  }
}
