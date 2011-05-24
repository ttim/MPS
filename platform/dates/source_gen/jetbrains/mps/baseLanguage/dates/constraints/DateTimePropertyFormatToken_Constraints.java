package jetbrains.mps.baseLanguage.dates.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodeReferentSetEventHandler;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.INodeReferenceFullSetHandler;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNodePointer;

public class DateTimePropertyFormatToken_Constraints extends ConstraintsDataHolder {
  public DateTimePropertyFormatToken_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.dates.structure.DateTimePropertyFormatToken";
  }

  public Map<String, INodeReferentSetEventHandler> getNodeReferentSetEventHandlers() {
    HashMap<String, INodeReferentSetEventHandler> result = new HashMap<String, INodeReferentSetEventHandler>();
    result.put("dateTimePropertyFormatConfiguration", new INodeReferenceFullSetHandler() {
      public void processReferentSetEvent(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode, IScope scope) {
        if (newReferentNode != oldReferentNode) {
          SLinkOperations.setTarget(referenceNode, "dateTimePropertyFormatType", DateTimePropertFormatTokenUtil.getDefaultFormatType(referenceNode), false);
        }
      }

      public boolean keepsOriginalReference(SNode referenceNode, SNode oldReferentNode, final SNode newReferentNode, IScope scope) {
        return true;
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public void registerSelf(ModelConstraintsManager manager) {
      }
    });
    return result;
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("dateTimePropertyFormatConfiguration", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }
    });
    result.put("dateTimePropertyFormatType", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getReferenceNode(), "dateTimePropertyFormatConfiguration", false), "dateTimePropertyFormatType", true);
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c895903cf(jetbrains.mps.baseLanguage.dates.constraints)", "1213104846964");
      }
    });
    return result;
  }
}
