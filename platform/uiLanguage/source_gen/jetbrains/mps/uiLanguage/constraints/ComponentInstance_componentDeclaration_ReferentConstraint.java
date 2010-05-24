package jetbrains.mps.uiLanguage.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SNodePointer;

public class ComponentInstance_componentDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public ComponentInstance_componentDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.uiLanguage.structure.ComponentInstance", "componentDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.uiLanguage.structure.ComponentInstance", "componentDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> components = new ArrayList<SNode>();
    ListSequence.fromList(components).addSequence(ListSequence.fromList(SModelOperations.getRootsIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.uiLanguage.structure.ComponentDeclaration")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return !(SPropertyOperations.getBoolean(it, "abstract"));
      }
    }));
    return components;
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c8959054e(jetbrains.mps.uiLanguage.constraints)", "1213104846154");
  }
}
