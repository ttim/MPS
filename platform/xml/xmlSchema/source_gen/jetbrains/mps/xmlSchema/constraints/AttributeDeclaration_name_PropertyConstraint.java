package jetbrains.mps.xmlSchema.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodePropertyGetter;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class AttributeDeclaration_name_PropertyConstraint implements IModelConstraints, INodePropertyGetter {
  public AttributeDeclaration_name_PropertyConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodePropertyGetter("jetbrains.mps.xmlSchema.structure.AttributeDeclaration", "name", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodePropertyGetter("jetbrains.mps.xmlSchema.structure.AttributeDeclaration", "name");
  }

  public Object execPropertyGet(SNode node, String propertyName, IScope scope) {
    return SPropertyOperations.getString(node, "attributeName");
  }
}
