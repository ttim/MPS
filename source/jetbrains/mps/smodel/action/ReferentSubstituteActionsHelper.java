package jetbrains.mps.smodel.action;

import jetbrains.mps.bootstrap.actionsLanguage.ReferentSubstituteActions;
import jetbrains.mps.bootstrap.actionsLanguage.ReferentSubstituteActionsBuilder;
import jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import jetbrains.mps.util.Condition;
import jetbrains.mps.util.QueryMethod;
import jetbrains.mps.ide.IStatus;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Feb 28, 2006
 * Time: 7:33:58 PM
 * To change this template use File | Settings | File Templates.
 */
/*package*/ class ReferentSubstituteActionsHelper {
  private static final Logger LOG = Logger.getLogger(ReferentSubstituteActionsHelper.class);

  public static final Condition<SNode> TRUE_CONDITION = new Condition<SNode>() {
    public boolean met(SNode object) {
      return true;
    }
  };

  public static List<INodeSubstituteAction> createActions(SNode sourceNode, SNode currentReferent, LinkDeclaration linkDeclaration, IOperationContext context) {
    List<INodeSubstituteAction> resultActions = new LinkedList<INodeSubstituteAction>();
    IScope scope = context.getScope();
    ConceptDeclaration sourceConcept = SModelUtil.getConceptDeclaration(sourceNode, scope);
    if (sourceConcept == null) {
      LOG.error("Couldn't build actions : couldn't get concept for source node" + sourceNode.getDebugText());
      return resultActions;
    }
    Language primaryLanguage = SModelUtil.getDeclaringLanguage(sourceConcept, scope);
    if (primaryLanguage == null) {
      LOG.error("Couldn't build actions : couldn't get declaring language for concept " + sourceConcept.getDebugText());
      return resultActions;
    }

    // add actions from 'primary' language
    String referenceRole = linkDeclaration.getRole();
    List<ReferentSubstituteActionsBuilder> primaryBuilders = getActionBuilders(sourceNode, primaryLanguage, sourceConcept, referenceRole, context);
    if (primaryBuilders.isEmpty()) {
      // if 'primary' language hasn't defined actions for that target - create 'default' actions
      resultActions = createPrimaryReferentSubstituteActions(sourceNode, currentReferent, linkDeclaration, TRUE_CONDITION, scope);
    } else {
      for (ReferentSubstituteActionsBuilder builder : primaryBuilders) {
        resultActions.addAll(invokeActionBulder(builder, sourceNode, currentReferent, linkDeclaration, context));
      }
    }

    // search 'extending' builders
    List<ReferentSubstituteActionsBuilder> extendedBuilders = new LinkedList<ReferentSubstituteActionsBuilder>();
    List<Language> languages = sourceNode.getModel().getLanguages(scope);
    for (Language language : languages) {
      if (language == primaryLanguage) {
        continue;
      }
      extendedBuilders.addAll(getActionBuilders(sourceNode, language, sourceConcept, referenceRole, context));
    }

    // for each builder create actions and apply all filters
    for (ReferentSubstituteActionsBuilder builder : extendedBuilders) {
      List<INodeSubstituteAction> addActions = invokeActionBulder(builder, sourceNode, currentReferent, linkDeclaration, context);
      resultActions.addAll(addActions);
    }

    // apply all filters
    primaryBuilders.addAll(extendedBuilders);
    for (ReferentSubstituteActionsBuilder builder : primaryBuilders) {
      resultActions = applyActionFilter(builder, resultActions, context);
    }

    return resultActions;
  }

  private static List<ReferentSubstituteActionsBuilder> getActionBuilders(SNode sourceNode, Language language, ConceptDeclaration sourceConcept, String referenceRole, IOperationContext context) {
    List<ReferentSubstituteActionsBuilder> actionsBuilders = new LinkedList<ReferentSubstituteActionsBuilder>();
    SModelDescriptor actionsModelDescr = language.getActionsModelDescriptor();
    if (actionsModelDescr != null) {
      // find appropriate actions builder
      List<SNode> roots = actionsModelDescr.getSModel().getRoots();
      for (SNode root : roots) {
        if (root instanceof ReferentSubstituteActions) {
          Iterator<ReferentSubstituteActionsBuilder> iterator = ((ReferentSubstituteActions) root).actionsBuilders();
          while (iterator.hasNext()) {
            ReferentSubstituteActionsBuilder actionsBuilder = iterator.next();
            // is applicable ?
            if (isActionBuilderApplicable(actionsBuilder, sourceConcept, referenceRole) &&
                    satisfiesPrecondition(actionsBuilder, sourceNode, context)) {
              actionsBuilders.add(actionsBuilder);
            }
          }
        }
      }
    }
    return actionsBuilders;
  }

  /**
   * @return TRUE if the src concept assignable to the builder's 'applicable src concept' and
   *         reference role is exactly 'applicable link role'
   */
  private static boolean isActionBuilderApplicable(ReferentSubstituteActionsBuilder builder, ConceptDeclaration sourceConcept, String referenceRole) {
    ConceptDeclaration applicableSourceConcept = builder.getApplicableSourceConcept();
    LinkDeclaration applicableLink = builder.getApplicableLink();
    if (applicableLink == null) {
      return false;
    }
    return referenceRole.equals(applicableLink.getRole()) &&
            (applicableSourceConcept == null || SModelUtil.isAssignableConcept(sourceConcept, applicableSourceConcept));
  }

  private static List<INodeSubstituteAction> createPrimaryReferentSubstituteActions(SNode sourceNode, SNode currentReferent, LinkDeclaration linkDeclaration, final Condition<SNode> filterCondition, final IScope scope) {
    final ConceptDeclaration referentConcept = linkDeclaration.getTarget();
    if (referentConcept == null) {
      return Collections.emptyList();
    }

    // test
    {
      ConceptDeclaration referenceNodeConcept = SModelUtil.getConceptDeclaration(sourceNode, scope);
      INodeReferentSearchScopeProvider scopeProvider = ModelConstraintsManager.getInstance().getNodeReferentSearchScopeProvider(referenceNodeConcept, linkDeclaration.getRole());
      if (scopeProvider != null) {
        String errorDescr = scopeProvider.canCreateNodeReferentSearchScope(sourceNode.getModel(), sourceNode.getParent(), sourceNode, referenceNodeConcept, linkDeclaration.getRole(), scope);
        if (errorDescr != null) return Collections.emptyList();

        ISearchScope searchScope = scopeProvider.createNodeReferentSearchScope(sourceNode.getModel(), sourceNode.getParent(), sourceNode, referenceNodeConcept, linkDeclaration.getRole(), scope);
        return createDefaultReferentSubstituteActions(sourceNode, currentReferent, linkDeclaration, searchScope, filterCondition, scope);
      }
    }

    //todo i changed roots only to false because OWL and MSP4Web depends on this behaviour (kostik)
    ISearchScope searchScope = SModelSearchUtil.createModelAndImportedModelsScope(sourceNode.getModel(), false, scope);
    return createDefaultReferentSubstituteActions(sourceNode, currentReferent, linkDeclaration, searchScope, filterCondition, scope);
  }

  private static List<INodeSubstituteAction> createDefaultReferentSubstituteActions(SNode sourceNode, SNode currentReferent, LinkDeclaration linkDeclaration, ISearchScope searchScope, final Condition<SNode> filterCondition, final IScope scope) {
    final ConceptDeclaration referentConcept = linkDeclaration.getTarget();
    if (referentConcept == null) {
      return Collections.emptyList();
    }
    List<SNode> nodes = searchScope.getNodes(new Condition<SNode>() {
      public boolean met(SNode node) {
        return SModelUtil.isInstanceOfConcept(node, referentConcept, scope) &&
                filterCondition.met(node);
      }
    });

    List<INodeSubstituteAction> actions = new LinkedList<INodeSubstituteAction>();
    for (SNode node : nodes) {
      actions.add(new DefaultReferentNodeSubstituteAction(node, sourceNode, currentReferent, linkDeclaration, scope));
    }
    return actions;
  }

  // ----------------------------------

  private static List<INodeSubstituteAction> invokeActionBulder(ReferentSubstituteActionsBuilder builder, SNode sourceNode, SNode currentReferent, LinkDeclaration linkDeclaration, IOperationContext context) {
    ISearchScope searchScope = invokeSearchScopeProvider(builder, sourceNode, context);
    if (searchScope == null) {
      return Collections.emptyList();
    }
    return invokeActionFactory(builder, sourceNode, currentReferent, linkDeclaration, searchScope, context);
  }

  // --------------------------------
  // Query methods invocation...
  // --------------------------------

  private static boolean satisfiesPrecondition(ReferentSubstituteActionsBuilder actionsBuilder, SNode sourceNode, IOperationContext context) {
    String preconditionQueryMethodId = actionsBuilder.getPreconditionAspectId();
    // precondition is optional
    if (preconditionQueryMethodId == null) {
      return true;
    }

    Object[] args1 = new Object[]{sourceNode, context};
    Object[] args2 = new Object[]{sourceNode, context.getScope()};
    String methodName = "referentSubstituteActionsBuilder_Precondition_" + preconditionQueryMethodId;
    SModel model = actionsBuilder.getModel();
    return (Boolean) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }

  private static ISearchScope invokeSearchScopeProvider(ReferentSubstituteActionsBuilder builder, SNode sourceNode, IOperationContext context) {
    String searchScopeQueryMethodId = builder.getSearchScopeProviderAspectId();
    // search scope is optional
    if (searchScopeQueryMethodId == null) {
      return SModelSearchUtil.createModelAndImportedModelsScope(sourceNode.getModel(), true, context.getScope());
    }

    Object[] args1 = new Object[]{sourceNode, context};
    Object[] args2 = new Object[]{sourceNode, context.getScope()};
    String methodName = "referentSubstituteActionsBuilder_SearchScope_" + searchScopeQueryMethodId;
    SModel model = builder.getModel();
    return (ISearchScope) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }


  private static List<INodeSubstituteAction> applyActionFilter(ReferentSubstituteActionsBuilder builder, List<INodeSubstituteAction> actions, IOperationContext context) {
    String filterQueryMethodId = builder.getActionsFilterAspectId();
    // filter is optional
    if (filterQueryMethodId == null) {
      return actions;
    }

    Object[] args1 = new Object[]{actions, context};
    Object[] args2 = new Object[]{actions, context.getScope()};
    String methodName = "referentSubstituteActionsBuilder_ActionsFilter_" + filterQueryMethodId;
    SModel model = builder.getModel();
    return (List<INodeSubstituteAction>) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }

  private static List<INodeSubstituteAction> invokeActionFactory(ReferentSubstituteActionsBuilder builder, SNode sourceNode, SNode currentReferent, LinkDeclaration linkDeclaration, ISearchScope searchScope, IOperationContext context) {
    String factoryQueryMethodId = builder.getActionsFactoryAspectId();
    // factory is optional
    if (factoryQueryMethodId == null) {
      return createDefaultReferentSubstituteActions(sourceNode, currentReferent, linkDeclaration, searchScope, TRUE_CONDITION, context.getScope());
    }

    Object[] args1 = new Object[]{sourceNode, currentReferent, linkDeclaration, searchScope, context};
    Object[] args2 = new Object[]{sourceNode, currentReferent, linkDeclaration, searchScope, context.getScope()};
    String methodName = "referentSubstituteActionsBuilder_ActionsFactory_" + factoryQueryMethodId;
    SModel model = builder.getModel();
    return (List<INodeSubstituteAction>) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }
}
