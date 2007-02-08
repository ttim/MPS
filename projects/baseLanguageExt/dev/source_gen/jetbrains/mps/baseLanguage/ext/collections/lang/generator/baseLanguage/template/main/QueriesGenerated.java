package jetbrains.mps.baseLanguage.ext.collections.lang.generator.baseLanguage.template.main;

/*Generated by MPS  */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.baseLanguage.ext.collections.lang.ClosureWithInputElement;
import jetbrains.mps.baseLanguage.ExpressionStatement;
import jetbrains.mps.baseLanguage.ext.collections.lang.generator.baseLanguage.template.util.QueriesUtil;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1167777954975(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode creator = SLinkOperations.getTarget(node, "creator", true);
    return SNodeOperations.isInstanceOf(creator, "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListCreatorWithInit");
  }
  public static boolean baseMappingRule_Condition_1167380888941(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "operation", true), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.RemoveElementOperation");
  }
  public static boolean baseMappingRule_Condition_1168510756013(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "operation", true), "jetbrains.mps.baseLanguage.ext.collections.lang.structure.SortOperation");
  }
  public static boolean baseMappingRule_Condition_1170068093968(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getBoolean(SNodeOperations.getParent(node, null, false, false), "reverseOrder") == false;
  }
  public static boolean baseMappingRule_Condition_1170068164068(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getBoolean(SNodeOperations.getParent(node, null, false, false), "reverseOrder") == true;
  }
  public static String propertyMacro_GetPropertyValue_1170958681801(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.getGeneratorSessionContext().createUniqueName("zValueSupplier");
  }
  public static String propertyMacro_GetPropertyValue_1167778587376(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.getGeneratorSessionContext().createUniqueName("_zCursor");
  }
  public static String propertyMacro_GetPropertyValue_1168288151438(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(node, "variable", true), "name");
  }
  public static String propertyMacro_GetPropertyValue_1168509021319(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.getGeneratorSessionContext().createUniqueName("zComparator");
  }
  public static String propertyMacro_GetPropertyValue_1168512329638(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode c = node;
    return SPropertyOperations.getString(SLinkOperations.getTarget(c, "defaultInputElement", true), "name");
  }
  public static String propertyMacro_GetPropertyValue_1170067391915(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode c = node;
    return SPropertyOperations.getString(SLinkOperations.getTarget(c, "defaultInputElement", true), "name");
  }
  public static String propertyMacro_GetPropertyValue_1170067652651(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return generator.getGeneratorSessionContext().createUniqueName("zComparator");
  }
  public static List sourceNodesQuery_1168281040871(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode creator = SLinkOperations.getTarget(node, "creator", true);
    return SLinkOperations.getTargets(creator, "initValue", true);
  }
  public static SNode sourceNodeQuery_1170957296016(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168287937464(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "inputSequence", true);
  }
  public static SNode sourceNodeQuery_1168288186650(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168280933571(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    SNode creator = SLinkOperations.getTarget(node, "creator", true);
    return SLinkOperations.getTarget(creator, "elementType", true);
  }
  public static SNode sourceNodeQuery_1168512350251(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    ClosureWithInputElement c = (ClosureWithInputElement)node;
    ExpressionStatement es = (ExpressionStatement)c.getBody().getStatements().get(0);
    return es.getExpression();
  }
  public static SNode sourceNodeQuery_1168511702747(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "leftExpression", true);
  }
  public static SNode sourceNodeQuery_1168511753711(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(node, "operation", true), "comparable", true);
  }
  public static SNode sourceNodeQuery_1170067391889(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    ClosureWithInputElement c = (ClosureWithInputElement)node;
    ExpressionStatement es = (ExpressionStatement)c.getBody().getStatements().get(0);
    return es.getExpression();
  }
  public static SNode mapSrcMacro_mapper_1170957121880(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.create_Closure_returnedType(node, generator.getTargetModel(), generator.getTypeChecker());
  }
  public static SNode mapSrcMacro_mapper_1170957401571(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return QueriesUtil.create_Closure_returnedType(node, generator.getTargetModel(), generator.getTypeChecker());
  }
}
