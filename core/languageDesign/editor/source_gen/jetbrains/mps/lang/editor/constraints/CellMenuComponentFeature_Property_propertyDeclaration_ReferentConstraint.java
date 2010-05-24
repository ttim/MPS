package jetbrains.mps.lang.editor.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.editor.behavior.AbstractComponent_Behavior;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.SNodePointer;

public class CellMenuComponentFeature_Property_propertyDeclaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public CellMenuComponentFeature_Property_propertyDeclaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.lang.editor.structure.CellMenuComponentFeature_Property", "relationDeclaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.lang.editor.structure.CellMenuComponentFeature_Property", "relationDeclaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    // properties declared in edited concept' hierarchy and not overridden 
    SNode editorComponent = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.editor.structure.CellMenuComponent", true, false);
    SNode editedConcept = AbstractComponent_Behavior.call_getConceptDeclaration_7055725856388417603(editorComponent);
    return AbstractConceptDeclaration_Behavior.call_getPropertyDeclarations_1213877394546(editedConcept);
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:00000000-0000-4000-0000-011c89590298(jetbrains.mps.lang.editor.constraints)", "1213104855918");
  }
}
