package jetbrains.mps.lang.typesystem.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilders;
import jetbrains.mps.lang.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {

  public void install(DataFlowManager manager) {
    manager.register("jetbrains.mps.lang.typesystem.structure.AbstractCheckingRule", new AbstractCheckingRule_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.AbstractSubtypingRule", new AbstractSubtypingRule_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.IsSubtypeExpression", new IsSubtypeExpression_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference", new ApplicableNodeReference_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.ApplicableNodeCondition", new ApplicableNodeCondition_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.AssertStatement", new AssertStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.ReportErrorStatement", new ReportErrorStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.TypeOfExpression", new TypeOfExpression_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.AbstractEquationStatement", new AbstractEquationStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.NormalTypeClause", new NormalTypeClause_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.TypeVarDeclaration", new TypeVarDeclaration_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.TypeVarReference", new TypeVarReference_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.InequationReplacementRule", new InequationReplacementRule_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.ComparisonRule", new ComparisonRule_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.PatternCondition", new PatternCondition_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.CoerceStatement", new CoerceStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.WhenConcreteStatement", new WhenConcreteStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop", new MultipleForeachLoop_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.ImmediateSupertypesExpression", new ImmediateSupertypesExpression_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.MatchStatement", new MatchStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.MatchStatementItem", new MatchStatementItem_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.GivetypeStatement", new GivetypeStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.CoerceExpression", new CoerceExpression_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.AddDependencyStatement", new AddDependencyStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.PropertyNameTarget", new PropertyNameTarget_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.ReferenceRoleTarget", new ReferenceRoleTarget_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.HelginsIntention", new HelginsIntention_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.HelginsIntentionArgument", new HelginsIntentionArgument_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.WarningStatement", new WarningStatement_DataFlow());
    manager.register("jetbrains.mps.lang.typesystem.structure.InfoStatement", new InfoStatement_DataFlow());
  }

}
