package jetbrains.mps.gwt.client.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class Source_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeParentBreakingPoint = new SNodePointer("r:89cc78ad-43cd-4987-b5dd-bcde38d4fbd9(jetbrains.mps.gwt.client.constraints)", "2968360207538563895");

  public Source_Constraints() {
    super("jetbrains.mps.gwt.client.structure.Source");
  }

  @Override
  public boolean hasOwnCanBeParentMethod() {
    return true;
  }

  @Override
  public boolean canBeParent(SNode node, @Nullable SNode childNode, SNode childConcept, SNode link, IOperationContext operationContext, @Nullable CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAParent(node, childNode, childConcept, link, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeParentBreakingPoint);
    }

    return result;
  }

  public static boolean static_canBeAParent(SNode node, SNode childNode, SNode childConcept, SNode link, final IOperationContext operationContext) {
    if (SLinkOperations.findLinkDeclaration("jetbrains.mps.gwt.client.structure.PatternFilter", "pattern") == link) {
      return SConceptOperations.isSubConceptOf(childConcept, "jetbrains.mps.gwt.client.structure.PatternHolder");
    }
    if (SLinkOperations.findLinkDeclaration("jetbrains.mps.gwt.client.structure.PatternFilter", "attr") == link) {
      return ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.CaseSensitive"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.DefaultExcludes"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.Includes"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.Excludes"))).contains(childConcept);
    }
    if (SLinkOperations.findLinkDeclaration("jetbrains.mps.gwt.client.structure.PatternFilter", "path") == link) {
      return SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.Path") == childConcept;
    }
    return false;
  }
}
