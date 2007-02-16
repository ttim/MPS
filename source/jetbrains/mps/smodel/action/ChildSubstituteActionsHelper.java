package jetbrains.mps.smodel.action;

import jetbrains.mps.bootstrap.actionsLanguage.structure.NodeSubstituteActions;
import jetbrains.mps.bootstrap.actionsLanguage.structure.NodeSubstituteActionsBuilder;
import jetbrains.mps.bootstrap.actionsLanguage.structure.NodeSubstitutePreconditionFunction;
import jetbrains.mps.bootstrap.structureLanguage.structure.Cardinality;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration;
import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.ide.IStatus;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.constraints.ModelConstraintsUtil;
import jetbrains.mps.smodel.presentation.NodePresentationUtil;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.SModelSearchUtil_new;
import jetbrains.mps.util.Condition;
import jetbrains.mps.util.QueryMethod;
import jetbrains.mps.util.QueryMethodGenerated;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.reloading.MPSClassLoader;
import jetbrains.mps.reloading.ClassLoaderManager;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Igor Alshannikov
 * Jan 24, 2006
 */
public class ChildSubstituteActionsHelper {
  private static final Logger LOG = Logger.getLogger(ChildSubstituteActionsHelper.class);

  public static final String DONT_SUBSTITUTE_BY_DEFAULT = "dontSubstituteByDefault";
  public static final String ABSTRACT = "abstract";

  public static final Condition<SNode> TRUE_CONDITION = new Condition<SNode>() {
    public boolean met(SNode object) {
      return true;
    }
  };

  public static boolean isDefaultSubstitutableConcept(ConceptDeclaration concept, ConceptDeclaration expectedConcept, IScope scope) {
    if (!concept.getNode().hasConceptProperty(ABSTRACT, scope) &&
            !concept.hasConceptProperty(DONT_SUBSTITUTE_BY_DEFAULT, scope)) {
      return SModelUtil_new.isAssignableConcept(concept, expectedConcept);
    }
    return false;
  }

  public static List<INodeSubstituteAction> createActions(SNode parentNode, SNode currentChild, ConceptDeclaration childConcept, IChildNodeSetter childSetter, IOperationContext context) {
    List<INodeSubstituteAction> resultActions = new LinkedList<INodeSubstituteAction>();
    if (childConcept == null) {
      return resultActions;
    }
    IScope scope = context.getScope();
    Language primaryLanguage = SModelUtil_new.getDeclaringLanguage(childConcept, scope);
    if (primaryLanguage == null) {
      LOG.error("Couldn't build actions : couldn't get declaring language for concept " + childConcept.getDebugText());
      return resultActions;
    }

    // add actions from 'primary' language
    List<NodeSubstituteActionsBuilder> primaryBuilders = getActionBuilders(parentNode, primaryLanguage, childConcept, context);
    if (primaryBuilders.isEmpty()) {
      // if 'primary' language hasn't defined actions for that target - create 'default' actions
      resultActions = createPrimaryChildSubstituteActions(parentNode, currentChild, childConcept, childSetter, TRUE_CONDITION, context);
    } else {
      for (NodeSubstituteActionsBuilder builder : primaryBuilders) {
        resultActions.addAll(invokeActionFactory(builder, parentNode, currentChild, childConcept, childSetter, context));
      }
    }

    // search 'extending' builders
    List<NodeSubstituteActionsBuilder> extendedBuilders = new LinkedList<NodeSubstituteActionsBuilder>();
    List<Language> languages = parentNode.getModel().getLanguages(scope);
    for (Language language : languages) {
      if (language == primaryLanguage) {
        continue;
      }
      extendedBuilders.addAll(getActionBuilders(parentNode, language, childConcept, context));
    }

    // for each builder create actions and apply all filters
    for (NodeSubstituteActionsBuilder builder : extendedBuilders) {
      List<INodeSubstituteAction> addActions = invokeActionFactory(builder, parentNode, currentChild, childConcept, childSetter, context);
      resultActions.addAll(addActions);
    }

    // apply all filters
    primaryBuilders.addAll(extendedBuilders);
    for (NodeSubstituteActionsBuilder builder : primaryBuilders) {
      resultActions = applyActionFilter(builder, resultActions, context);
    }

    return resultActions;
  }

  public static List<INodeSubstituteAction> createPrimaryChildSubstituteActions(
          SNode parentNode,
          SNode currentChild,
          final ConceptDeclaration childConcept,
          IChildNodeSetter childSetter,
          final Condition<SNode> filter,
          IOperationContext context) {

    if (childConcept == null) {
      return Collections.emptyList();
    }
    final IScope scope = context.getScope();

    // create search scope that only includes root concepts.
    // case: concept-function-parameters declared as child-concepts are not added to substitute menue by default
    ISearchScope conceptsSearchScope = SModelSearchUtil_new.createConceptsFromModelLanguagesScope(parentNode.getModel(), true, scope);
    List<SNode> applicableConcepts = conceptsSearchScope.getNodes(new Condition<SNode>() {
      public boolean met(SNode object) {
        return isDefaultSubstitutableConcept((ConceptDeclaration) BaseAdapter.fromNode(object), childConcept, scope) &&
                filter.met(object);
      }
    });

    List<INodeSubstituteAction> actions = new LinkedList<INodeSubstituteAction>();
    for (SNode applicableConcept : applicableConcepts) {
      // first try to create 'smart reference' actions for this concept
      LinkDeclaration smartReference = getSmartReference((ConceptDeclaration) BaseAdapter.fromNode(applicableConcept), scope);
      if (smartReference != null) {
        List<INodeSubstituteAction> smartActions = createSmartReferenceActions((ConceptDeclaration) BaseAdapter.fromNode(applicableConcept), smartReference, parentNode, currentChild, childSetter, scope);
        if (smartActions != null) {
          actions.addAll(smartActions);
        }
      } else {
        // apply default 'child substitute'
        actions.add(new DefaultChildNodeSubstituteAction(applicableConcept, parentNode, currentChild, childSetter, scope));
      }
    }

    return actions;
  }

  private static List<INodeSubstituteAction> createSmartReferenceActions(
          final ConceptDeclaration referenceNodeConcept,
          LinkDeclaration smartReference,
          final SNode parentNode,
          final SNode currentChild,
          IChildNodeSetter childSetter,
          final IScope scope) {

    // try to create referent-search-scope
    IStatus status = ModelConstraintsUtil.getReferentSearchScope(parentNode, null, referenceNodeConcept, smartReference, scope);
    if (status.isError()) return null;

    // create smart actions
    List<INodeSubstituteAction> actions = new LinkedList<INodeSubstituteAction>();
    final LinkDeclaration referenceLink_final = smartReference;
    ISearchScope searchScope = (ISearchScope) status.getUserObject();
    final ConceptDeclaration targetConcept = smartReference.getTarget();

    List<SNode> referentNodes = searchScope.getNodes();

    Class adapterClass = getAdapterClass(targetConcept);
    String conceptFqName = NameUtil.conceptFqName(targetConcept);

    if (adapterClass == null) {
      for (SNode referentNode : referentNodes) {
        if (referentNode.isInstanceOfConcept(targetConcept, scope)) {
          actions.add(new SmartRefChildNodeSubstituteAction(referentNode, parentNode, currentChild, childSetter, scope, referenceNodeConcept, referenceLink_final));
        }
      }
    } else { //fast way
      for (SNode referentNode : referentNodes) {

        String rcfqn = referentNode.getConceptFqName();

        if (rcfqn.equals(conceptFqName) ||
                adapterClass.isInstance(referentNode.getAdapter())) {
          actions.add(new SmartRefChildNodeSubstituteAction(referentNode, parentNode, currentChild, childSetter, scope, referenceNodeConcept, referenceLink_final));
        }
      }
    }

    return actions;
  }

  private static Class getAdapterClass(ConceptDeclaration cd) {
    String fqName = NameUtil.nodeFQName(cd);
    try {
      return Class.forName(fqName, true, ClassLoaderManager.getInstance().getClassLoader());
    } catch (ClassNotFoundException e) {
      return null;
    }
  }

  /**
   * @return reference link declaration which is used to populate auto-completion menu with possible referent nodes.
   *         Smart actions are no applicable if:
   *         1. matching text is customized (except case when pattern '<{_referent_role_}>' is used).
   *         2. pattern '<{_referent_role_}>' is used but no ref.link with this role is declared.
   *         3. no ref.links with cardinality '1' is declared (no patten, no customized matching text)
   *         4. several ref.links with cardinality '1' is declared (no patten, no customized matching text)
   */
  private static LinkDeclaration getSmartReference(ConceptDeclaration referenceDeclaringConcept, IScope scope) {
    // trick : should be no custom 'matching text'
    String expectedReferentRole = null;
    String alias = referenceDeclaringConcept.getNode().getConceptProperty("alias", scope);
    if (alias != null) {
      // handle pattern 'xxx <{_referent_role_}> yyy'
      if (!alias.matches(".*<\\{.+\\}>.*")) {
        return null;
      }
      String[] matches = alias.split("<\\{|\\}>");
      expectedReferentRole = matches[1];
    }

    List<LinkDeclaration> links = SModelSearchUtil_new.getReferenceLinkDeclarationsExcludingOverridden(referenceDeclaringConcept);
    if (expectedReferentRole != null) {
      for (LinkDeclaration linkDeclaration : links) {
        if (expectedReferentRole.equals(linkDeclaration.getRole())) {
          return linkDeclaration;
        }
      }
      LOG.warning("The '" + alias + "' doesn't match any link in " + referenceDeclaringConcept.getDebugText());
      for (LinkDeclaration linkDeclaration : links) {
        if (expectedReferentRole.equals(linkDeclaration.getRole())) {
          return linkDeclaration;
        }
      }
    } else {
      // if concept has only one REQUIRED reference link...
      if (links.size() == 1) {
        if (SModelUtil_new.getGenuineLinkSourceCardinality(links.get(0)) == Cardinality._1) {
          return links.get(0);
        }
      }
    }
    return null;
  }

  private static String getSmartMatchingText(ConceptDeclaration referenceNodeConcept, SNode referentNode, IScope scope) {
    String referentMatchingText = NodePresentationUtil.matchingText(referentNode, true);
    String referenceAlias = referenceNodeConcept.getConceptProperty("alias", scope);
    // handle pattern 'xxx <{_referent_role_}> yyy'
    if (referenceAlias == null || !referenceAlias.matches(".*<\\{.+\\}>.*")) {

      return referentMatchingText;
    }
    String[] matches = referenceAlias.split("<\\{|\\}>");
    matches[1] = referentMatchingText;
    StringBuffer sb = new StringBuffer();
    for (String segment : matches) {
      sb.append(segment);
    }
    return sb.toString();
  }

  private static List<NodeSubstituteActionsBuilder> getActionBuilders(SNode parentNode, Language language, ConceptDeclaration childConcept, IOperationContext context) {
    List<NodeSubstituteActionsBuilder> actionsBuilders = new LinkedList<NodeSubstituteActionsBuilder>();
    SModelDescriptor actionsModelDescr = language.getActionsModelDescriptor();
    if (actionsModelDescr != null) {
      // find appropriate actions builder
      List<BaseAdapter> roots = actionsModelDescr.getSModel().getRootsAdapters();
      for (BaseAdapter root : roots) {
        if (root instanceof NodeSubstituteActions) {
          Iterator<NodeSubstituteActionsBuilder> iterator = ((NodeSubstituteActions) root).actionsBuilders();
          while (iterator.hasNext()) {
            NodeSubstituteActionsBuilder actionsBuilder = iterator.next();
            // is applicable ?
            ConceptDeclaration applicableConcept = actionsBuilder.getApplicableConcept();

            //and think better about of the order of arguments of "isAssignableConcept" - this is correct: 
            if (SModelUtil_new.isAssignableConcept(applicableConcept, childConcept) &&
                    satisfiesPrecondition(actionsBuilder, parentNode, context)) {
              actionsBuilders.add(actionsBuilder);
            }
          }
        }
      }
    }
    return actionsBuilders;
  }

  // --------------------------------
  // Query methods invocation...
  // --------------------------------

  private static boolean satisfiesPrecondition(NodeSubstituteActionsBuilder actionsBuilder, SNode parentNode, IOperationContext context) {
    // try generatred query method
    NodeSubstitutePreconditionFunction precondition = actionsBuilder.getPrecondition();
    // precondition is optional
    if (precondition != null) {
      String methodName = ActionQueryMethodName.nodeSubstituteActionsBuilder_Precondition(actionsBuilder);
      Object[] args = new Object[]{parentNode, context.getScope(), context};
      SModel model = actionsBuilder.getModel();
      try {
        return (Boolean) QueryMethodGenerated.invoke(methodName, args, model);
      } catch (Exception e) {
        return false;
      }
    }

    // try old query method
    String preconditionQueryMethodId = actionsBuilder.getPreconditionAspectId();
    // precondition is optional
    if (preconditionQueryMethodId == null) {
      return true;
    }

    Object[] args1 = new Object[]{parentNode, context};
    Object[] args2 = new Object[]{parentNode, context.getScope()};
    String methodName = "nodeSubstituteActionsBuilder_Precondition_" + preconditionQueryMethodId;
    SModel model = actionsBuilder.getModel();
    return (Boolean) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }


  private static List<INodeSubstituteAction> applyActionFilter(NodeSubstituteActionsBuilder substituteActionsBuilder, List<INodeSubstituteAction> actions, IOperationContext context) {
    String filterQueryMethodId = substituteActionsBuilder.getActionsFilterAspectId();
    // filter is optional
    if (filterQueryMethodId == null) {
      return actions;
    }

    Object[] args1 = new Object[]{actions, context};
    Object[] args2 = new Object[]{actions, context.getScope()};
    String methodName = "nodeSubstituteActionsBuilder_ActionsFilter_" + filterQueryMethodId;
    SModel model = substituteActionsBuilder.getModel();
    return (List<INodeSubstituteAction>) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }

  private static List<INodeSubstituteAction> invokeActionFactory(NodeSubstituteActionsBuilder builder, SNode parentNode, SNode currentChild, ConceptDeclaration childConcept, IChildNodeSetter childSetter, IOperationContext context) {
    String factoryQueryMethodId = builder.getActionsFactoryAspectId();
    // factory is optional
    if (factoryQueryMethodId == null) {
      return Collections.emptyList();
    }

    Object[] args1 = new Object[]{parentNode,
            currentChild,
            childConcept.getNode(),
            childSetter,
            context};
    Object[] args2 = new Object[]{parentNode,
            currentChild,
            childConcept.getNode(),
            childSetter,
            context.getScope()};
    String methodName = "nodeSubstituteActionsBuilder_ActionsFactory_" + factoryQueryMethodId;
    SModel model = builder.getModel();
    return (List<INodeSubstituteAction>) QueryMethod.invoke_alternativeArguments(methodName, args1, args2, model);
  }

  private static class SmartRefChildNodeSubstituteAction extends DefaultChildNodeSubstituteAction {
    String myMatchingText;
    private final SNode myParentNode;
    private final SNode myCurrentChild;
    private final ConceptDeclaration myReferenceNodeConcept;
    private final LinkDeclaration myReferenceLink_final;

    public SmartRefChildNodeSubstituteAction(SNode referentNode, SNode parentNode, SNode currentChild, IChildNodeSetter childSetter, IScope scope, ConceptDeclaration referenceNodeConcept, LinkDeclaration referenceLink_final) {
      super(referentNode, parentNode, currentChild, childSetter, scope);
      myParentNode = parentNode;
      myCurrentChild = currentChild;
      myReferenceNodeConcept = referenceNodeConcept;
      myReferenceLink_final = referenceLink_final;
      myMatchingText = null;
    }

    public String getMatchingText(String pattern) {
      if (myMatchingText == null) {
        myMatchingText = getSmartMatchingText(myReferenceNodeConcept, (SNode) getParameterObject(), getScope());
      }
      return myMatchingText;
    }

    public String getDescriptionText(String pattern) {
      BaseConcept parameterNode = (BaseConcept) BaseAdapter.fromNode((SNode) getParameterObject());
      if (parameterNode.getShortDescription() == null) {
        return "(smart ref:" + myReferenceNodeConcept.getName() + ") " + NodePresentationUtil.descriptionText(parameterNode, true);
      }

      return "(smart ref:" + NodePresentationUtil.descriptionText(parameterNode, true) + ")";
    }

    public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
      SNode childNode = SModelUtil_new.instantiateConceptDeclaration((ConceptDeclaration) myReferenceNodeConcept, model).getNode();
      String referentRole = SModelUtil_new.getGenuineLinkRole(myReferenceLink_final);
      childNode.setReferent(referentRole, (SNode) parameterObject);
      NodeFactoryManager.setupNode(myReferenceNodeConcept, childNode, myCurrentChild, myParentNode, model, getScope());
      return childNode;
    }
  }
}
