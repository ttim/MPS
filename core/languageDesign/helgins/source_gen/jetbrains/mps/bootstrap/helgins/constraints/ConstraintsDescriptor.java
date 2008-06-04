package jetbrains.mps.bootstrap.helgins.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;

public class ConstraintsDescriptor implements IModelConstraints {

  private List<IModelConstraints> myConstraints = new ArrayList<IModelConstraints>();

  public ConstraintsDescriptor() {
    this.myConstraints.add(new PropertyPatternVariableReference_patternVarDecl_ReferentConstraint());
    this.myConstraints.add(new PatternVariableReference_patternVarDecl_ReferentConstraint());
    this.myConstraints.add(new TypeVarReference_typeVarDeclaration_ReferentConstraint());
    this.myConstraints.add(new LinkPatternVariableReference_patternVarDecl_ReferentConstraint());
    this.myConstraints.add(new ApplicableNodeReference_applicableNode_ReferentConstraint());
    this.myConstraints.add(new ConceptReference_concept_ReferentConstraint());
    this.myConstraints.add(new ListVarReference_listVarDeclaration_ReferentConstraint());
    this.myConstraints.add(new WhenConcreteVariableReference_whenConcreteVar_ReferentConstraint());
    this.myConstraints.add(new HelginsIntentionArgument_intentionArgument_ReferentConstraint());
    this.myConstraints.add(new ChildTypeRestriction_childLinkDeclaration_ReferentConstraint());
  }

  public void unRegisterSelf(ModelConstraintsManager p0) {
    for(IModelConstraints c : this.myConstraints) {
      c.unRegisterSelf(p0);
    }
  }

  public void registerSelf(ModelConstraintsManager p0) {
    for(IModelConstraints c : this.myConstraints) {
      c.registerSelf(p0);
    }
  }

}
