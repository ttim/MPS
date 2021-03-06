package jetbrains.mps.lang.typesystem.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import java.util.Map;
import jetbrains.mps.smodel.runtime.ReferenceConstraintsDescriptor;
import java.util.HashMap;
import jetbrains.mps.smodel.runtime.base.BaseReferenceConstraintsDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.ReferenceScopeProvider;
import jetbrains.mps.smodel.runtime.base.BaseScopeProvider;

public class ConceptReference_Constraints extends BaseConstraintsDescriptor {
  public ConceptReference_Constraints() {
    super("jetbrains.mps.lang.typesystem.structure.ConceptReference");
  }

  @Override
  protected Map<String, ReferenceConstraintsDescriptor> getNotDefaultReferences() {
    Map<String, ReferenceConstraintsDescriptor> references = new HashMap();
    references.put("concept", new BaseReferenceConstraintsDescriptor("concept", this) {
      @Override
      public boolean hasOwnOnReferenceSetHandler() {
        return true;
      }

      @Override
      public boolean validate(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode, final IScope scope) {
        return true;
      }

      @Override
      public void onReferenceSet(final SNode referenceNode, final SNode oldReferentNode, final SNode newReferentNode, final IScope scope) {
        if ((newReferentNode != null) && newReferentNode != oldReferentNode) {
          SPropertyOperations.set(referenceNode, "name", NameUtil.decapitalize(SPropertyOperations.getString(newReferentNode, "name")));
          if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(referenceNode), "jetbrains.mps.lang.typesystem.structure.InferenceRule")) {
            SPropertyOperations.set(SNodeOperations.cast(SNodeOperations.getParent(referenceNode), "jetbrains.mps.lang.typesystem.structure.InferenceRule"), "name", "typeof_" + SPropertyOperations.getString(newReferentNode, "name"));
          }
        }
      }

      @Nullable
      @Override
      public ReferenceScopeProvider getScopeProvider() {
        return new BaseScopeProvider();
      }
    });
    return references;
  }
}
