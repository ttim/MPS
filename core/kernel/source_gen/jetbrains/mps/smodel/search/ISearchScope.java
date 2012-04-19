package jetbrains.mps.smodel.search;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;
import jetbrains.mps.scope.Scope;
import org.jetbrains.annotations.Nullable;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

@Deprecated
public 
/**
 * @Deprecated
 */
interface ISearchScope {
  @NotNull
  public List<SNode> getNodes(Condition<SNode> condition);
  public boolean isInScope(SNode node);
  @NotNull
  public List<SNode> getNodes();
  public IReferenceInfoResolver getReferenceInfoResolver(SNode referenceNode, SNode targetConcept);
  public static class Adapter extends Scope {
    protected final ISearchScope searchScope;

    public Adapter(ISearchScope searchScope) {
      this.searchScope = searchScope;
    }

    public SNode resolve(SNode anchor, String refText) {
      return null;
    }

    public Iterable<SNode> getAvailableElements(@Nullable final String prefix) {
      if (StringUtils.isEmpty(prefix)) {
        return searchScope.getNodes();
      }
      return searchScope.getNodes(new Condition<SNode>() {
        public boolean met(SNode p0) {
          if (p0 == null) {
            return false;
          }
          String presentation = getReferenceText(null, p0);
          return presentation != null && presentation.startsWith(prefix);
        }
      });
    }

    public String getReferenceText(SNode anchor, SNode target) {
      String resolveInfo = target.getResolveInfo();
      if (StringUtils.isNotEmpty(resolveInfo)) {
        return resolveInfo;
      }
      return target.getPresentation();
    }

    public ISearchScope getSearchScope() {
      return searchScope;
    }

    @Override
    public boolean contains(SNode node) {
      return this.searchScope.isInScope(node);
    }
  }

  public static class RefAdapter extends ISearchScope.Adapter {
    @Nullable
    private final SReference reference;

    public RefAdapter(ISearchScope searchScope, @NotNull SReference reference) {
      super(searchScope);
      this.reference = reference;
    }

    @Override
    public SNode resolve(SNode anchor, String refText) {
      SNode sourceNode = reference.getSourceNode();
      String role = reference.getRole();

      SNode mostSpecificLink = new ConceptAndSuperConceptsScope(SNodeOperations.getConceptDeclaration(sourceNode)).getMostSpecificLinkDeclarationByRole(role);
      if (mostSpecificLink == null) {
        return null;
      }

      IReferenceInfoResolver infoResolver = searchScope.getReferenceInfoResolver(sourceNode, SLinkOperations.getTarget(SNodeOperations.cast(mostSpecificLink, "jetbrains.mps.lang.structure.structure.LinkDeclaration"), "target", false));
      if (infoResolver == null) {
        return null;
      }

      return infoResolver.resolve(refText, reference.getTargetSModelReference());
    }
  }

}
