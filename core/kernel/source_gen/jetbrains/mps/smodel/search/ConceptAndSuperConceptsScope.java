package jetbrains.mps.smodel.search;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import jetbrains.mps.smodel.NodeReadAccessCasterInEditor;
import jetbrains.mps.util.Computable;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import java.util.ArrayList;

public class ConceptAndSuperConceptsScope extends AbstractSearchScope {
  private SNode myTopConcept;

  public ConceptAndSuperConceptsScope(@Nullable SNode topConcept) {
    myTopConcept = topConcept;
  }

  public List<SNode> getConcepts() {
    if (myTopConcept == null) {
      return Collections.emptyList();
    }
    return Arrays.asList(ConceptAndSuperConceptsCache.getInstance(myTopConcept).getConcepts());
  }

  public SNode getPropertyDeclarationByName(final String name) {
    if (myTopConcept == null) {
      return null;
    }
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<SNode>() {
      public SNode compute() {
        return ConceptAndSuperConceptsCache.getInstance(myTopConcept).getPropertyDeclarationByName(name);
      }
    });
  }

  public List<SNode> getPropertyDeclarations() {
    if (myTopConcept == null) {
      return Collections.emptyList();
    }
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<List<SNode>>() {
      public List<SNode> compute() {
        return ConceptAndSuperConceptsCache.getInstance(myTopConcept).getPropertyDeclarations();
      }
    });
  }

  public SNode getLinkDeclarationByRole(final String role) {
    if (myTopConcept == null) {
      return null;
    }
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<SNode>() {
      public SNode compute() {
        return ConceptAndSuperConceptsCache.getInstance(myTopConcept).getLinkDeclarationByRole(role);
      }
    });
  }

  public SNode getMostSpecificLinkDeclarationByRole(final String role) {
    if (myTopConcept == null) {
      return null;
    }
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<SNode>() {
      public SNode compute() {
        return ConceptAndSuperConceptsCache.getInstance(myTopConcept).getMostSpecificLinkDeclarationByRole(role);
      }
    });
  }

  public List<SNode> getLinkDeclarationsExcludingOverridden() {
    if (myTopConcept == null) {
      return Collections.emptyList();
    }
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<List<SNode>>() {
      public List<SNode> compute() {
        return ConceptAndSuperConceptsCache.getInstance(myTopConcept).getLinkDeclarationsExcludingOverridden();
      }
    });
  }

  public SNode getConceptPropertyByName(final String name) {
    if (myTopConcept == null) {
      return null;
    }
    return NodeReadAccessCasterInEditor.runReadTransparentAction(new Computable<SNode>() {
      public SNode compute() {
        return ConceptAndSuperConceptsCache.getInstance(myTopConcept).getConceptPropertyByName(name);
      }
    });
  }

  @NotNull
  public List<SNode> getNodes(Condition<SNode> condition) {
    if (myTopConcept == null) {
      return Collections.emptyList();
    }
    List<SNode> result = new ArrayList<SNode>();
    //  filter by condition 
    for (SNode node : getConcepts()) {
      if (node == null) {
        continue;
      }
      for (SNode n : node.getDescendantsIterable(condition, true)) {
        result.add(n);
      }
    }
    return result;
  }
}
