/*
 * Created Oct 19, 2007 at 12:59:00 PM
 */
package jetbrains.mps.ypath.design;

import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.SNode;


/**
 * @author fyodor
 */
public interface IGenericParameterizedFeatureDesign<T> extends IParameterizedFeatureDesign<T> {

    SNode getterExpression (SNode srcExpr, T param, ITemplateGenerator generator);
    
    boolean isSingleTargetCardinality (T param);
}
