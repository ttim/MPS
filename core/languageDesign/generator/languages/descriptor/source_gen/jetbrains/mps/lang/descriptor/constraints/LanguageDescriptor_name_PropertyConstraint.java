package jetbrains.mps.lang.descriptor.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodePropertyGetter;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;

public class LanguageDescriptor_name_PropertyConstraint implements IModelConstraints, INodePropertyGetter {
  public LanguageDescriptor_name_PropertyConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodePropertyGetter("jetbrains.mps.lang.descriptor.structure.LanguageDescriptor", "name", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodePropertyGetter("jetbrains.mps.lang.descriptor.structure.LanguageDescriptor", "name");
  }

  public Object execPropertyGet(SNode node, String propertyName, IScope scope) {
    return "descriptor";
  }
}
