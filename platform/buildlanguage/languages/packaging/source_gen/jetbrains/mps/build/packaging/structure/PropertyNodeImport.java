package jetbrains.mps.build.packaging.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.property.structure.PropertyNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PropertyNodeImport extends PropertiesImport {
  public static final String concept = "jetbrains.mps.build.packaging.structure.PropertyNodeImport";
  public static final String PROPERTY_NODE = "propertyNode";

  public PropertyNodeImport(SNode node) {
    super(node);
  }


  public PropertyNode getPropertyNode() {
    return (PropertyNode)this.getReferent(PropertyNode.class, PropertyNodeImport.PROPERTY_NODE);
  }

  public void setPropertyNode(PropertyNode node) {
    super.setReferent(PropertyNodeImport.PROPERTY_NODE, node);
  }

  public static PropertyNodeImport newInstance(SModel sm, boolean init) {
    return (PropertyNodeImport)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.packaging.structure.PropertyNodeImport", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PropertyNodeImport newInstance(SModel sm) {
    return PropertyNodeImport.newInstance(sm, false);
  }
}
