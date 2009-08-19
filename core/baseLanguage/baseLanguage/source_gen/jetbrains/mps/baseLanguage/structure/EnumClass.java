package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class EnumClass extends ClassConcept {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.EnumClass";
  public static final String ENUM_CONSTANT = "enumConstant";

  public EnumClass(SNode node) {
    super(node);
  }

  public int getEnumConstantsCount() {
    return this.getChildCount(EnumClass.ENUM_CONSTANT);
  }

  public Iterator<EnumConstantDeclaration> enumConstants() {
    return this.children(EnumConstantDeclaration.class, EnumClass.ENUM_CONSTANT);
  }

  public List<EnumConstantDeclaration> getEnumConstants() {
    return this.getChildren(EnumConstantDeclaration.class, EnumClass.ENUM_CONSTANT);
  }

  public void addEnumConstant(EnumConstantDeclaration node) {
    this.addChild(EnumClass.ENUM_CONSTANT, node);
  }

  public void insertEnumConstant(EnumConstantDeclaration prev, EnumConstantDeclaration node) {
    this.insertChild(prev, EnumClass.ENUM_CONSTANT, node);
  }

  public static EnumClass newInstance(SModel sm, boolean init) {
    return (EnumClass)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.EnumClass", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static EnumClass newInstance(SModel sm) {
    return EnumClass.newInstance(sm, false);
  }
}
