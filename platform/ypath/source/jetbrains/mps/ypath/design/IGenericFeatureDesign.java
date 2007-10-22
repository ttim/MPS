/*
 * Created Oct 19, 2007 at 12:59:00 PM
 */
package jetbrains.mps.ypath.design;

import jetbrains.mps.smodel.SNode;


/**
 * @author fyodor
 */
public interface IGenericFeatureDesign<T> extends IFeatureDesign<T> {

    SNode getterExpression (SNode srcExpr, T param);
    
    boolean isSingleTargetCardinality (T param);
}
