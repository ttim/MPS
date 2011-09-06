package jetbrains.mps.baseLanguage.collections.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import java.util.Map;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseReferenceScopeProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.collections.behavior.CustomContainersUtil;
import jetbrains.mps.baseLanguage.behavior.TypeDerivable_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.Collections;

public class CustomContainerCreator_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer breakingNode_tzy4hl_a0a1a0a0a1a0b0a1a1 = new SNodePointer("r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)", "9034802358628295001");

  public CustomContainerCreator_Constraints() {
    super("jetbrains.mps.baseLanguage.collections.structure.CustomContainerCreator");
  }

  @Override
  protected Map<String, PropertyConstraintsDescriptor> getNotDefaultProperties() {
    Map<String, PropertyConstraintsDescriptor> properties = new HashMap();
    properties.put("alias", new BasePropertyConstraintsDescriptor("alias", this) {
      @Override
      public boolean hasOwnGetter() {
        return true;
      }

      @Override
      public Object getValue(SNode node, IScope scope) {
        String propertyName = "alias";
        return SPropertyOperations.getString(SLinkOperations.getTarget(node, "containerDeclaration", false), "name");
      }
    });
    return properties;
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("containerDeclaration", new BaseReferenceConstraintsDescriptor("containerDeclaration", this) {
      @Override
      public boolean hasOwnScopeProvider() {
        return true;
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseReferenceScopeProvider() {
          @Override
          public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferenceConstraintsContext _context) {
            SNode expr = SNodeOperations.as(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.Expression");
            return ((expr != null) ?
              Sequence.fromIterable(CustomContainersUtil.containerDeclarations(SNodeOperations.getModel(expr), TypeDerivable_Behavior.call_deriveType_1213877435747(SNodeOperations.as(SNodeOperations.getParent(expr), "jetbrains.mps.baseLanguage.structure.TypeDerivable"), expr))).where(new IWhereFilter<SNode>() {
                public boolean accept(SNode it) {
                  return !(SConceptOperations.isSubConceptOf(SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(it, "containerType", true)), "jetbrains.mps.baseLanguage.collections.structure.MapType"));
                }
              }) :
              Sequence.fromIterable(Collections.<SNode>emptyList())
            );
          }

          @Override
          public SNodePointer getSearchScopeValidatorNode() {
            return breakingNode_tzy4hl_a0a1a0a0a1a0b0a1a1;
          }
        };
      }
    });
    return references;
  }
}
