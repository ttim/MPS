package jetbrains.mps.lang.constraints.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.PropertyDeclaration;
import jetbrains.mps.lang.constraints.structure.ConstraintFunction_PropertyGetter;
import jetbrains.mps.lang.constraints.structure.ConstraintFunction_PropertySetter;
import jetbrains.mps.lang.constraints.structure.ConstraintFunction_PropertyValidator;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NodePropertyConstraint extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.constraints.structure.NodePropertyConstraint";
  public static final String APPLICABLE_PROPERTY = "applicableProperty";
  public static final String PROPERTY_GETTER = "propertyGetter";
  public static final String PROPERTY_SETTER = "propertySetter";
  public static final String PROPERTY_VALIDATOR = "propertyValidator";

  public NodePropertyConstraint(SNode node) {
    super(node);
  }

  public PropertyDeclaration getApplicableProperty() {
    return (PropertyDeclaration)this.getReferent(PropertyDeclaration.class, NodePropertyConstraint.APPLICABLE_PROPERTY);
  }

  public void setApplicableProperty(PropertyDeclaration node) {
    super.setReferent(NodePropertyConstraint.APPLICABLE_PROPERTY, node);
  }

  public ConstraintFunction_PropertyGetter getPropertyGetter() {
    return (ConstraintFunction_PropertyGetter)this.getChild(ConstraintFunction_PropertyGetter.class, NodePropertyConstraint.PROPERTY_GETTER);
  }

  public void setPropertyGetter(ConstraintFunction_PropertyGetter node) {
    super.setChild(NodePropertyConstraint.PROPERTY_GETTER, node);
  }

  public ConstraintFunction_PropertySetter getPropertySetter() {
    return (ConstraintFunction_PropertySetter)this.getChild(ConstraintFunction_PropertySetter.class, NodePropertyConstraint.PROPERTY_SETTER);
  }

  public void setPropertySetter(ConstraintFunction_PropertySetter node) {
    super.setChild(NodePropertyConstraint.PROPERTY_SETTER, node);
  }

  public ConstraintFunction_PropertyValidator getPropertyValidator() {
    return (ConstraintFunction_PropertyValidator)this.getChild(ConstraintFunction_PropertyValidator.class, NodePropertyConstraint.PROPERTY_VALIDATOR);
  }

  public void setPropertyValidator(ConstraintFunction_PropertyValidator node) {
    super.setChild(NodePropertyConstraint.PROPERTY_VALIDATOR, node);
  }


  public static NodePropertyConstraint newInstance(SModel sm, boolean init) {
    return (NodePropertyConstraint)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.constraints.structure.NodePropertyConstraint", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NodePropertyConstraint newInstance(SModel sm) {
    return NodePropertyConstraint.newInstance(sm, false);
  }

}
