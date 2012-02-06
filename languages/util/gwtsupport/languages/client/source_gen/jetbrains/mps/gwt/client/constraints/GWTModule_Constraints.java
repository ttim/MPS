package jetbrains.mps.gwt.client.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class GWTModule_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeParentBreakingPoint = new SNodePointer("r:89cc78ad-43cd-4987-b5dd-bcde38d4fbd9(jetbrains.mps.gwt.client.constraints)", "2968360207538671956");

  public GWTModule_Constraints() {
    super("jetbrains.mps.gwt.client.structure.GWTModule");
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

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("resolveInfo", new BasePropertyConstraintsDescriptor("resolveInfo", this) {
      @Override
      public boolean hasOwnGetter() {
        return true;
      }

      @Override
      public Object getValue(SNode node, IScope scope) {
        String propertyName = "resolveInfo";
        return node.getName();
      }
    });
    return properties;
  }

  public static boolean static_canBeAParent(SNode node, SNode childNode, SNode childConcept, SNode link, final IOperationContext operationContext) {
    if (SLinkOperations.findLinkDeclaration("jetbrains.mps.gwt.client.structure.GWTModule", "element") == link) {
      return ListSequence.fromList(ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.EntryPoint"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.Inherits"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.Public"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.Source"), SConceptOperations.findConceptDeclaration("jetbrains.mps.gwt.client.structure.SuperSource"))).contains(childConcept);
    }
    return true;
  }
}
