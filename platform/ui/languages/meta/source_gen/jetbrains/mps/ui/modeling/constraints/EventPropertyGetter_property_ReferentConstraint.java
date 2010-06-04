package jetbrains.mps.ui.modeling.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ui.modeling.behavior.Event_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.constraints.PresentationReferentConstraintContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class EventPropertyGetter_property_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public EventPropertyGetter_property_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.ui.modeling.structure.EventPropertyGetter", "property", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.ui.modeling.structure.EventPropertyGetter", "property");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return Sequence.fromIterable(Event_Behavior.call_allExtends_5224413709454845737(SLinkOperations.getTarget(SNodeOperations.cast(_context.getEnclosingNode(), "jetbrains.mps.ui.modeling.structure.EventHandlerTemplate"), "event", false))).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode e) {
        return SLinkOperations.getTargets(e, "property", true);
      }
    });
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new AbstractSearchScope() {
      @NotNull
      public List<SNode> getNodes(Condition<SNode> condition) {
        Iterable<SNode> seq = (Iterable<SNode>) createSearchScopeOrListOfNodes(operationContext, _context);
        List<SNode> result = new ArrayList<SNode>();
        if (seq != null) {
          for (SNode node : seq) {
            if (condition.met(node)) {
              result.add(node);
            }
          }
        }
        return result;
      }
    };
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:3cad8b0f-ef3c-442c-8c6f-1ab422f65805(jetbrains.mps.ui.modeling.constraints)", "5263857617434470704");
  }

  public boolean hasPresentation() {
    return true;
  }

  public String getPresentation(final IOperationContext operationContext, final PresentationReferentConstraintContext _context) {
    return SPropertyOperations.getString(_context.getParameterNode(), "name");
  }
}
