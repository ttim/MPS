package jetbrains.mps.lang.textGen.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.INodePropertyGetter;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class OperationDeclaration_operationName_PropertyConstraint implements IModelConstraints, INodePropertyGetter {

  public OperationDeclaration_operationName_PropertyConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodePropertyGetter("jetbrains.mps.lang.textGen.structure.OperationDeclaration", "operationName", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodePropertyGetter("jetbrains.mps.lang.textGen.structure.OperationDeclaration", "operationName");
  }

  public Object execPropertyGet(SNode node, String propertyName, IScope scope) {
    String name = SPropertyOperations.getString(node, "name");
    if (name == null) {
      return null;
    }
    StringBuilder result = new StringBuilder();
    for(int i = 0 ; i < name.length() ; i++ ) {
      if (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') {
        result.append(' ');
        result.append(name.toLowerCase().charAt(i));
      } else
      {
        result.append(name.charAt(i));
      }
    }
    return result.toString();
  }

}
