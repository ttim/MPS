package jetbrains.mps.actions.runtime.impl;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.IChildNodeSetter;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.DefaultChildNodeSetter;
import java.util.ArrayList;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.util.QueryMethodGenerated;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.Collections;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.Iterator;
import jetbrains.mps.smodel.action.RemoveSubstituteActionByConditionContext;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;

public class ChildSubstituteActionsUtil {
  private static final Logger LOG = Logger.getLogger(ChildSubstituteActionsUtil.class);

  public ChildSubstituteActionsUtil() {
  }

  public static SNode getRefinedChildConcept(SNode currentChild) {
    SNode childConcept = SNodeOperations.getConceptDeclaration(currentChild);
    SNode baseConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept");
    if (SNodeOperations.isInstanceOf(childConcept, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
      SNode concreteChildConcept = SNodeOperations.cast(((SNode) childConcept), "jetbrains.mps.lang.structure.structure.ConceptDeclaration");
      while ((SLinkOperations.getTarget(concreteChildConcept, "extends", false) != null) && SLinkOperations.getTarget(concreteChildConcept, "extends", false) != baseConcept) {
        concreteChildConcept = SLinkOperations.getTarget(concreteChildConcept, "extends", false);
      }
      childConcept = concreteChildConcept;
    }
    return childConcept;
  }

  public static List<SNode> getActionsBuilders(SNode parentNode, SNode currentChild, SNode childConcept, IChildNodeSetter childSetter, IOperationContext context) {
    SNode link = null;
    if (childSetter instanceof DefaultChildNodeSetter) {
      link = SNodeOperations.cast(((DefaultChildNodeSetter) childSetter).getLinkDeclaration(), "jetbrains.mps.lang.structure.structure.LinkDeclaration");
    }

    List<SNode> allBuilders = new ArrayList<SNode>();
    List<Language> languages = SModelOperations.getLanguages(SNodeOperations.getModel(parentNode), context.getScope());
    boolean wrapped = !(childSetter instanceof DefaultChildNodeSetter);
    for (SNode actionsBuilder : ListSequence.fromList(getAllActionsBuilders(languages))) {
      SNode applicableConcept = SLinkOperations.getTarget(actionsBuilder, "applicableConcept", false);
      if (applicableConcept == null) {
        continue;
      }
      if (SConceptOperations.isSubConceptOf(applicableConcept, NameUtil.nodeFQName(childConcept)) || SConceptOperations.isSubConceptOf(childConcept, NameUtil.nodeFQName(applicableConcept))) {
        if (satisfiesPrecondition(actionsBuilder, parentNode, applicableConcept, link, currentChild, wrapped, context)) {
          ListSequence.fromList(allBuilders).addElement(actionsBuilder);
        }
      }
    }
    return allBuilders;
  }

  public static boolean containsRemoveDefaults(List<SNode> builders) {
    return ListSequence.fromList(builders).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return ListSequence.fromList(SNodeOperations.getDescendants(it, "jetbrains.mps.lang.actions.structure.RemoveDefaultsPart", false, new String[]{})).isNotEmpty();
      }
    }).isNotEmpty();
  }

  public static List<INodeSubstituteAction> invokeActionFactory(SNode builder, SNode parentNode, SNode currentChild, SNode childConcept, IChildNodeSetter childSetter, IOperationContext context) {

    String methodName = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(builder, "jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder"), "call_getBuilderQueryMethodName_1220278926652", new Class[]{SNode.class}));
    try {
      return (List<INodeSubstituteAction>) QueryMethodGenerated.invoke(methodName, context, new NodeSubstituteActionsFactoryContext(parentNode, currentChild, childConcept, childSetter), SNodeOperations.getModel(builder));
    } catch (Throwable t) {
      LOG.error(t);
      return Collections.emptyList();
    }
  }

  public static List<INodeSubstituteAction> applyActionFilter(SNode builder, List<INodeSubstituteAction> actions, SNode parentNode, SNode currentChild, SNode childConcept, IOperationContext context) {

    // remove banned concepts 
    Set<SNode> conceptsToRemove = SetSequence.fromSetWithValues(new HashSet<SNode>(), ListSequence.fromList(SNodeOperations.getDescendants(builder, "jetbrains.mps.lang.actions.structure.RemovePart", false, new String[]{})).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return (SLinkOperations.getTarget(it, "conceptToRemove", false) != null);
      }
    }).<SNode>select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(it, "conceptToRemove", false);
      }
    }));
    if (SetSequence.fromSet(conceptsToRemove).isNotEmpty()) {
      for (Iterator<INodeSubstituteAction> it = ListSequence.fromList(actions).iterator(); it.hasNext();) {
        INodeSubstituteAction action = it.next();
        if (SetSequence.fromSet(conceptsToRemove).contains(SNodeOperations.as(action.getOutputConcept(), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"))) {
          it.remove();
        }
      }
    }

    // apply custom filters 
    for (SNode removeByCondition : ListSequence.fromList(SNodeOperations.getDescendants(builder, "jetbrains.mps.lang.actions.structure.RemoveByConditionPart", false, new String[]{}))) {
      String methodName = "removeActionsByCondition_" + removeByCondition.getSNodeId();
      try {
        QueryMethodGenerated.invoke(methodName, context, new RemoveSubstituteActionByConditionContext(ListSequence.fromList(actions).iterator(), parentNode, currentChild, childConcept), SNodeOperations.getModel(builder));
      } catch (Throwable t) {
        LOG.error(t);
      }
    }

    return actions;
  }

  private static List<SNode> getAllActionsBuilders(List<Language> languages) {
    List<SNode> result = new ArrayList<SNode>();
    for (Language language : ListSequence.fromList(languages)) {
      SModelDescriptor actionsModelDescr = language.getActionsModelDescriptor();
      if (actionsModelDescr == null) {
        continue;
      }
      SModel sModel = actionsModelDescr.getSModel();
      ListSequence.fromList(result).addSequence(ListSequence.fromList(jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.getRoots(sModel, "jetbrains.mps.lang.actions.structure.NodeSubstituteActions")).<SNode>translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "actionsBuilder", true);
        }
      }));
    }
    return result;
  }

  private static boolean satisfiesPrecondition(SNode actionsBuilder, SNode parentNode, SNode concept, SNode link, SNode currentTarget, boolean wrapped, IOperationContext context) {

    SNode precondition = SLinkOperations.getTarget(actionsBuilder, "precondition", true);
    if (precondition != null) {
      String methodName = ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(actionsBuilder, "jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder"), "call_getPreconditionQueryMethodName_1220278671791", new Class[]{SNode.class}));
      try {
        return (Boolean) QueryMethodGenerated.invoke(methodName, context, new NodeSubstitutePreconditionContext(parentNode, concept, currentTarget, link, wrapped), SNodeOperations.getModel(actionsBuilder));
      } catch (Exception e) {
        LOG.error(e);
        return false;
      }
    }
    return true;
  }
}
