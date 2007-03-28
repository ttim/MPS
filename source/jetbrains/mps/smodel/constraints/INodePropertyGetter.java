package jetbrains.mps.smodel.constraints;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: May 11, 2006
 * Time: 8:11:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface INodePropertyGetter extends IModelConstraints {
  Object execPropertyGet(SNode node, String propertyName, IScope scope);
}
