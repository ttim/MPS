package jetbrains.mps.execution.settings.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.VariableReference;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class EditorPropertyReference extends VariableReference {
  public static final String concept = "jetbrains.mps.execution.settings.structure.EditorPropertyReference";

  public EditorPropertyReference(SNode node) {
    super(node);
  }

  public EditorPropertyDeclaration getEditorPropertyDeclaration() {
    return this.ensureAdapter(EditorPropertyDeclaration.class, "variableDeclaration", this.getVariableDeclaration());
  }

  public void setEditorPropertyDeclaration(EditorPropertyDeclaration node) {
    this.setVariableDeclaration(node);
  }

  public static EditorPropertyReference newInstance(SModel sm, boolean init) {
    return (EditorPropertyReference) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.execution.settings.structure.EditorPropertyReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static EditorPropertyReference newInstance(SModel sm) {
    return EditorPropertyReference.newInstance(sm, false);
  }
}
