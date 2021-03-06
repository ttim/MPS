package jetbrains.mps.baseLanguage.dates.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ConvertToDateTimeOperation_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:00000000-0000-4000-0000-011c895903cf(jetbrains.mps.baseLanguage.dates.constraints)", "1213107437401");

  public ConvertToDateTimeOperation_Constraints() {
    super("jetbrains.mps.baseLanguage.dates.structure.ConvertToDateTimeOperation");
  }

  @Override
  public boolean hasOwnCanBeChildMethod() {
    return true;
  }

  @Override
  public boolean canBeChild(@Nullable SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext, @Nullable final CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAChild(node, parentNode, link, childConcept, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeChildBreakingPoint);
    }

    return result;
  }

  public static boolean static_canBeAChild(SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext) {
    boolean can = false;
    if (SNodeOperations.isInstanceOf(parentNode, "jetbrains.mps.baseLanguage.structure.DotExpression")) {
      SNode operandType = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SNodeOperations.cast(parentNode, "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true));
      can = TypeChecker.getInstance().getSubtypingManager().isSubtype(operandType, new ConvertToDateTimeOperation_Constraints.QuotationClass_i6v6x6_a1a0a1a1a0().createNode());
      can = can || TypeChecker.getInstance().getSubtypingManager().isSubtype(operandType, new ConvertToDateTimeOperation_Constraints.QuotationClass_i6v6x6_a1a0a0c0b0a().createNode());
      can = can || TypeChecker.getInstance().getSubtypingManager().isSubtype(operandType, new ConvertToDateTimeOperation_Constraints.QuotationClass_i6v6x6_a1a0a0d0b0a().createNode());
      can = can || TypeChecker.getInstance().getSubtypingManager().isSubtype(operandType, new ConvertToDateTimeOperation_Constraints.QuotationClass_i6v6x6_a1a0a0e0b0a().createNode());
      can = can || TypeChecker.getInstance().getSubtypingManager().isSubtype(operandType, new ConvertToDateTimeOperation_Constraints.QuotationClass_i6v6x6_a1a0a0f0b0a().createNode());
      can = can || TypeChecker.getInstance().getSubtypingManager().isSubtype(operandType, new ConvertToDateTimeOperation_Constraints.QuotationClass_i6v6x6_a1a0a0g0b0a().createNode());
    }
    return can;
  }

  public static class QuotationClass_i6v6x6_a1a0a1a1a0 {
    public QuotationClass_i6v6x6_a1a0a1a1a0() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#2ebbb458-8ebb-481e-a5d7-9e27903323d4#org.joda.time.base(jetbrains.mps.baseLanguage.dates.runtime/org.joda.time.base@java_stub)"), SNodeId.fromString("~AbstractInstant")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_i6v6x6_a1a0a0c0b0a {
    public QuotationClass_i6v6x6_a1a0a0c0b0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.util(JDK/java.util@java_stub)"), SNodeId.fromString("~Date")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_i6v6x6_a1a0a0d0b0a {
    public QuotationClass_i6v6x6_a1a0a0d0b0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.util(JDK/java.util@java_stub)"), SNodeId.fromString("~Calendar")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_i6v6x6_a1a0a0e0b0a {
    public QuotationClass_i6v6x6_a1a0a0e0b0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.PeriodType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_i6v6x6_a1a0a0f0b0a {
    public QuotationClass_i6v6x6_a1a0a0f0b0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DurationType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_i6v6x6_a1a0a0g0b0a {
    public QuotationClass_i6v6x6_a1a0a0g0b0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DateTimeWithTZType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
