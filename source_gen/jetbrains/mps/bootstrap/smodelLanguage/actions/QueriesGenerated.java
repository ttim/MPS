package jetbrains.mps.bootstrap.smodelLanguage.actions;

/*Generated by MPS Oct 24, 2006 11:59:52 AM */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.SModelUtil;
import jetbrains.mps.typesystem.ITypeObject;
import jetbrains.mps.typesystem.TypeCheckerAccess;
import jetbrains.mps.bootstrap.smodelLanguage.types.Snode_TypeObject;
import jetbrains.mps.bootstrap.smodelLanguage.types.Slink_TypeObject;

public class QueriesGenerated {

  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_SNodeOperation_1154637518825(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    boolean alreadyHasParms = SLinkOperations.getCount(sourceNode, "parameter") > 0;
    if(alreadyHasParms) {
      return false;
    }
    List<SNode> applicableParms = SModelUtil.getConceptLinkTargets(sourceNode, "applicableParameter", true, scope);
    return applicableParms.size() > 0;
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1154636612745(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    return ActionsUtil_mpsLoadable.isExpressionOfOurType(sourceNode);
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1154634535241(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    ITypeObject type = TypeCheckerAccess.getTypeChecker().getNodeType(sourceNode);
    return (type instanceof Snode_TypeObject) || (type instanceof Slink_TypeObject);
  }
  public static boolean rightTransformHintSubstituteActionsBuilder_Precondition_Expression_1154624855279(SNode sourceNode, IScope scope, IOperationContext operationContext) {
    return ActionsUtil_mpsLoadable.isExpressionOfOurType(sourceNode);
  }
}
