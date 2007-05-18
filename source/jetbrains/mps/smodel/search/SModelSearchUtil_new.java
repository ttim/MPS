package jetbrains.mps.smodel.search;

import jetbrains.mps.bootstrap.structureLanguage.structure.*;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.util.AndCondition;
import jetbrains.mps.util.Condition;

import java.util.*;

/**
 * Igor Alshannikov
 * Jan 19, 2006
 */
public class SModelSearchUtil_new {
  private static final Logger LOG = Logger.getLogger(SModelSearchUtil_new.class);

  public static ISearchScope createModelAndImportedModelsScope(SModel model, IScope scope) {
    return createModelAndImportedModelsScope(model, false, scope);
  }

  public static ISearchScope createModelAndImportedModelsScope(SModel model, boolean rootsOnly, IScope scope) {
    return new SModelSearchUtil_new._ModelAndImportedModelsScope(model, rootsOnly, scope);
  }

  public static ISearchScope createConceptsFromModelLanguagesScope(SModel model, IScope scope) {
    return new SModelSearchUtil_new._ConceptsFromModelLanguagesScope(model, false, scope);
  }

  public static ISearchScope createConceptsFromModelLanguagesScope(SModel model, boolean rootsOnly, IScope scope) {
    return new SModelSearchUtil_new._ConceptsFromModelLanguagesScope(model, rootsOnly, scope);
  }

  public static IConceptHierarchyScope createConceptHierarchyScope(AbstractConceptDeclaration concept) {
    return new ConceptHierarchyScope(concept);
  }

  public static List<LinkDeclaration> getLinkDeclarationsExcludingOverridden(AbstractConceptDeclaration concept) {
    return new ConceptHierarchyScope(concept).getLinkDeclarationsExcludingOverridden();
  }

  public static List<LinkDeclaration> getAggregationLinkDeclarationsExcludingOverridden(AbstractConceptDeclaration concept) {
    return new ConceptHierarchyScope(concept).getAggregationLinkDeclarationsExcludingOverridden();
  }

  public static List<LinkDeclaration> getReferenceLinkDeclarationsExcludingOverridden(ConceptDeclaration concept) {
    return new ConceptHierarchyScope(concept).getReferenceLinkDeclarationsExcludingOverridden();
  }

  public static List<PropertyDeclaration> getPropertyDeclarationsExcludingOverridden(AbstractConceptDeclaration concept) {
    return new ConceptHierarchyScope(concept).getPropertyDeclarationsExcludingOverridden();
  }


  private static class _ConceptsFromModelLanguagesScope extends AbstractSearchScope {
    private SModel myModel;
    private boolean myRootsOnly;
    private IScope myScope;
    private List<ConceptDeclaration> myConcepts;

    public _ConceptsFromModelLanguagesScope(SModel model, boolean rootsOnly, IScope scope) {
      myModel = model;
      myRootsOnly = rootsOnly;
      myScope = scope;
    }

    public List<SNode> getOwnNodes(Condition<SNode> condition) {
      if (myConcepts == null) {
        myConcepts = new ArrayList<ConceptDeclaration>();
        List<Language> languages = myModel.getLanguages(myScope);
        for (Language language : languages) {
          if (myRootsOnly) {
            SModel structureModel = language.getStructureModelDescriptor().getSModel();
            myConcepts.addAll(structureModel.getRootsAdapters(ConceptDeclaration.class));
          } else {
            myConcepts.addAll(language.getConceptDeclarations());
          }
        }
      }

      List<SNode> concepts = new ArrayList<SNode>();
      for (ConceptDeclaration concept : myConcepts) {
        if (condition.met(concept.getNode())) {
          concepts.add(concept.getNode());
        }
      }

      return concepts;
    }
  }

  private static class _ModelAndImportedModelsScope extends AbstractSearchScope {
    private SModel myModel;
    private boolean myRootsOnly;
    private IScope myScope;

    private List<SModelDescriptor> myModels;

    public _ModelAndImportedModelsScope(SModel model, boolean rootsOnly, IScope scope) {
      myModel = model;
      myRootsOnly = rootsOnly;
      myScope = scope;
    }

    public List<SNode> getOwnNodes(Condition<SNode> condition) {
      if (myModels == null) {
        if (myModel == null) {
          myModels = Collections.EMPTY_LIST;
        } else {
          myModels = myModel.allImportedModels(myScope);
          myModels.add(0, myModel.getModelDescriptor());
        }
      }

      List<SNode> result = new ArrayList<SNode>();
      if (myRootsOnly) {
        for (SModelDescriptor model : myModels) {
          result.addAll(model.getSModel().getRoots(condition));
        }
      } else {
        for (SModelDescriptor model : myModels) {
          try {
            if (condition instanceof IsInstanceCondition
                    /* TODO following line was added because cache of FastNodeFinder currently doesn't
                     * support InterfaceConceptDeclaration and as a result
                     * fastNodeFinder.getNodes(abstractConceptDeclaration, true)
                     * always returns empty list for InstanceConceptDeclaration */
                    && ((IsInstanceCondition) condition).getConceptDeclaration() instanceof ConceptDeclaration) {
              IsInstanceCondition isInstance = (IsInstanceCondition) condition;
              result.addAll(model.getFastNodeFinder().getNodes(isInstance.getConceptDeclaration(), true));
            } else {
              result.addAll(model.getSModel().allNodes(condition));
            }
          } catch (Throwable t) {
            LOG.error("error collecting nodes form model " + model, t);
          }
        }
      }
      return result;
    }
  } // private static class _ModelAndImportedModelsScope
}
