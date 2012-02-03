package jetbrains.mps.checkers;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import jetbrains.mps.smodel.structure.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.search.ConceptAndSuperConceptsScope;
import java.util.List;
import jetbrains.mps.util.Condition;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.PropertySupport;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import jetbrains.mps.errors.messageTargets.PropertyMessageTarget;

public class ConstraintsChecker extends AbstractConstraintsChecker {
  protected static Log log = LogFactory.getLog(ConstraintsChecker.class);

  public ConstraintsChecker() {
  }

  public SNode getBreakingNodeAndClearContext(CheckingNodeContext checkingNodeContext) {
    SNodePointer breakingNodePointer = checkingNodeContext.getBreakingNode();
    if (breakingNodePointer == null) {
      return null;
    } else {
      SNode node = breakingNodePointer.getNode();
      checkingNodeContext.setBreakingNode(null);

      return node;
    }
  }

  public void checkNode(final SNode node, LanguageErrorsComponent component, final IOperationContext operationContext, IScope scope) {
    final ConstraintsDescriptor newDescriptor = ConceptRegistry.getInstance().getConstraintsDescriptorNew(node.getConceptFqName());

    final CheckingNodeContext checkingNodeContext = new jetbrains.mps.smodel.structure.CheckingNodeContext();

    if (SNodeOperations.getParent(node) != null) {
      component.addDependency(SNodeOperations.getParent(node));
    }
    if (SNodeOperations.getParent(node) != null && !(jetbrains.mps.smodel.SNodeOperations.isUnknown(SNodeOperations.getParent(node)))) {
      final SNode link = SNodeOperations.getContainingLinkDeclaration(node);
      if (link == null) {
        component.addError(node, "Child in a role with unknown link", null);
        return;
      }
      boolean canBeChild = component.runCheckingAction(new _FunctionTypes._return_P0_E0<Boolean>() {
        public Boolean invoke() {
          return ModelConstraintsManager.canBeChild(newDescriptor, node.getConceptFqName(), operationContext, SNodeOperations.getParent(node), link, node, checkingNodeContext);
        }
      });
      if (!(canBeChild)) {
        SNode rule = getBreakingNodeAndClearContext(checkingNodeContext);
        component.addError(node, "Node " + node + " cannot be child of node " + SNodeOperations.getParent(node), rule);
      }
    }

    if (node.isRoot()) {
      boolean canBeRoot = component.runCheckingAction(new _FunctionTypes._return_P0_E0<Boolean>() {
        public Boolean invoke() {
          return ModelConstraintsManager.canBeRoot(newDescriptor, operationContext, node.getConceptFqName(), SNodeOperations.getModel(node), checkingNodeContext);
        }
      });
      if (!(canBeRoot)) {
        SNode rule = getBreakingNodeAndClearContext(checkingNodeContext);
        component.addError(node, "Not rootable concept added as root", rule);
      }
    }

    for (final SNode child : SNodeOperations.getChildren(node)) {
      component.addDependency(child);
      final SNode childConcept = SNodeOperations.getConceptDeclaration(child);
      final SNode childLink = SNodeOperations.getContainingLinkDeclaration(child);
      if (childLink == null) {
        continue;
      }
      boolean canBeParent = component.runCheckingAction(new _FunctionTypes._return_P0_E0<Boolean>() {
        public Boolean invoke() {
          return ModelConstraintsManager.canBeParent(newDescriptor, node, childConcept, childLink, operationContext, child, checkingNodeContext);
        }
      });
      if (!(canBeParent)) {
        SNode rule = getBreakingNodeAndClearContext(checkingNodeContext);
        component.addError(node, "Node " + node + " cannot be parent of node " + child, rule);
      }

      // todo: do it right, with runCheckingAction! 
      if (!(ModelConstraintsManager.canBeAncestor(node, child, childConcept, operationContext, checkingNodeContext))) {
        SNode rule = SNodeOperations.cast(getBreakingNodeAndClearContext(checkingNodeContext), "jetbrains.mps.lang.constraints.structure.ConstraintFunction_CanBeAnAncestor");
        component.addError(child, "Concept " + SLinkOperations.getTarget(SNodeOperations.as(SNodeOperations.getParent(rule), "jetbrains.mps.lang.constraints.structure.ConceptConstraints"), "concept", false) + " cannot be ancestor of node " + child, rule);
      }
    }

    // Properties validation 
    SNode concept = SNodeOperations.getConceptDeclaration(node);
    component.addDependency(concept);
    ConceptAndSuperConceptsScope chs = new ConceptAndSuperConceptsScope(concept);
    for (SNode parentConcept : chs.getConcepts()) {
      component.addDependency(parentConcept);
    }
    List<SNode> props = ((List<SNode>) chs.getNodes(new Condition<SNode>() {
      public boolean met(SNode n) {
        return SNodeOperations.isInstanceOf(n, "jetbrains.mps.lang.structure.structure.PropertyDeclaration");
      }
    }));
    for (SNode p : ListSequence.fromList(props)) {
      final PropertySupport ps = PropertySupport.getPropertySupport(p);
      final String propertyName = SPropertyOperations.getString(p, "name");
      if (propertyName == null) {
        if (log.isErrorEnabled()) {
          log.error("Property declaration has a null name, declaration id: " + p.getSNodeId() + ", model: " + SNodeOperations.getModel(p).getSModelFqName());
        }
        continue;
      }
      final String value = ps.fromInternalValue(node.getProperty(propertyName));
      final PropertyConstraintsDescriptor propertyDescriptor = newDescriptor.getProperty(propertyName);
      boolean canSetValue = component.runCheckingAction(new _FunctionTypes._return_P0_E0<Boolean>() {
        public Boolean invoke() {
          return ps.canSetValue(propertyDescriptor, node, propertyName, value, operationContext.getScope());
        }
      });
      if (!(canSetValue)) {
        // TODO this is a hack for anonymous classes 
        if ("name".equals(SPropertyOperations.getString(p, "name")) && ("AnonymousClass".equals(SPropertyOperations.getString(concept, "name")) || "InternalAnonymousClass".equals(SPropertyOperations.getString(concept, "name")))) {
          continue;
        }
        // todo find a rule 
        component.addError(node, "Property constraint violation for property \"" + SPropertyOperations.getString(p, "name") + "\"", null, new PropertyMessageTarget(SPropertyOperations.getString(p, "name")));
      }
    }
  }
}
