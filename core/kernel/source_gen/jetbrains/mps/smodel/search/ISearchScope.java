package jetbrains.mps.smodel.search;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;

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
}
