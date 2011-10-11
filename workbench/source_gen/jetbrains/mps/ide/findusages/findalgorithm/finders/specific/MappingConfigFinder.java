package jetbrains.mps.ide.findusages.findalgorithm.finders.specific;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.IFinder;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.progress.ProgressMonitor;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import java.util.ArrayList;
import jetbrains.mps.generator.GenerationFacade;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.util.CollectionUtil;

public class MappingConfigFinder implements IFinder {
  private Generator myGenerator;
  private SNode myNodeToFindUsages;

  public MappingConfigFinder(Generator generator, SNode nodeToFindUsages) {
    myGenerator = generator;
    myNodeToFindUsages = nodeToFindUsages;
  }

  public SearchResults<SNode> find(SearchQuery query, ProgressMonitor monitor) {
    List<SearchResult<SNode>> results = new ArrayList<SearchResult<SNode>>();
    List<SNode> mappingConfigs = (List<SNode>) GenerationFacade.getOwnMappings(myGenerator);
    List<SNode> nodesToCheck = new ArrayList<SNode>();
    for (SNode mappingConfig : mappingConfigs) {
      for (SNode rule : ListSequence.fromList(SNodeOperations.getChildren(mappingConfig)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.lang.generator.structure.BaseMappingRule");
        }
      })) {
        nodesToCheck.add(rule);
        collectChildrenThatMayHaveReferenceOnTemplate(rule, nodesToCheck);
      }
      nodesToCheck.addAll(SLinkOperations.getTargets(mappingConfig, "createRootRule", true));
    }
    for (SNode node : nodesToCheck) {
      List<SReference> references = node.getReferences();
      for (SReference reference : references) {
        if (myNodeToFindUsages.getSNodeId().equals(reference.getTargetNodeId())) {
          SearchResult<SNode> result = new SearchResult<SNode>(node, "");
          results.add(result);
          break;
        }
      }
    }
    return new SearchResults<SNode>(CollectionUtil.set(myNodeToFindUsages), results);
  }

  private void collectChildrenThatMayHaveReferenceOnTemplate(SNode parent, List<SNode> result) {
    List<SNode> children = parent.getChildren(false);
    for (SNode child : children) {
      if (SNodeOperations.isInstanceOf(child, "jetbrains.mps.baseLanguage.structure.ConceptFunction")) {
        continue;
      }
      result.add(child);
      collectChildrenThatMayHaveReferenceOnTemplate(child, result);
    }
  }
}
