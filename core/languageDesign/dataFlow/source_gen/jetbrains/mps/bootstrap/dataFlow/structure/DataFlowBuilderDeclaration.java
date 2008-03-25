package jetbrains.mps.bootstrap.dataFlow.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;

public class DataFlowBuilderDeclaration extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.bootstrap.dataFlow.structure.DataFlowBuilderDeclaration";
  public static String BUILDER_BLOCK = "builderBlock";
  public static String NAME = "name";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String CONCEPT_DECLARATION = "conceptDeclaration";

  public  DataFlowBuilderDeclaration(SNode node) {
    super(node);
  }

  public static DataFlowBuilderDeclaration newInstance(SModel sm, boolean init) {
    return (DataFlowBuilderDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.dataFlow.structure.DataFlowBuilderDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DataFlowBuilderDeclaration newInstance(SModel sm) {
    return DataFlowBuilderDeclaration.newInstance(sm, false);
  }


  public BuilderBlock getBuilderBlock() {
    return (BuilderBlock)this.getChild(DataFlowBuilderDeclaration.BUILDER_BLOCK);
  }

  public void setBuilderBlock(BuilderBlock node) {
    super.setChild(DataFlowBuilderDeclaration.BUILDER_BLOCK, node);
  }

  public String getName() {
    return this.getProperty(DataFlowBuilderDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(DataFlowBuilderDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(DataFlowBuilderDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(DataFlowBuilderDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(DataFlowBuilderDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(DataFlowBuilderDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(DataFlowBuilderDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(DataFlowBuilderDeclaration.VIRTUAL_PACKAGE, value);
  }

  public AbstractConceptDeclaration getConceptDeclaration() {
    return (AbstractConceptDeclaration)this.getReferent(DataFlowBuilderDeclaration.CONCEPT_DECLARATION);
  }

  public void setConceptDeclaration(AbstractConceptDeclaration node) {
    super.setReferent(DataFlowBuilderDeclaration.CONCEPT_DECLARATION, node);
  }

}
