package jetbrains.mps.lang.structure.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodePropertyValidator;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.BaseNodePropertyValidator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SEnumOperations;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNodePointer;

public class LinkDeclaration_Constraints extends ConstraintsDataHolder {
  public LinkDeclaration_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.structure.structure.LinkDeclaration";
  }

  public Map<String, INodePropertyValidator> getNodePropertyValidators() {
    HashMap<String, INodePropertyValidator> result = new HashMap<String, INodePropertyValidator>();
    result.put("sourceCardinality", new BaseNodePropertyValidator() {
      public boolean checkPropertyValue(final SNode node, final String propertyName, final String propertyValue, final IScope scope) {
        return SPropertyOperations.hasValue(node, "metaClass", "aggregation", "reference") || SEnumOperations.getEnumMemberValue(SEnumOperations.getEnumMember(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)", "Cardinality"), "1")).equals((SPropertyOperations.getString(propertyValue))) || SEnumOperations.getEnumMemberValue(SEnumOperations.getEnumMember(SEnumOperations.getEnum("r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)", "Cardinality"), "0..1")).equals((SPropertyOperations.getString(propertyValue)));
      }
    });
    result.put("role", new BaseNodePropertyValidator() {
      public boolean checkPropertyValue(final SNode node, final String propertyName, final String propertyValue, final IScope scope) {
        return (SPropertyOperations.getString(propertyValue)).matches("[a-zA-Z[_]][a-zA-Z0-9$[_]]*");
      }
    });
    return result;
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    result.put("specializedLink", new BaseNodeReferenceSearchScopeProvider() {
      public void registerSelf(ModelConstraintsManager manager) {
      }

      public void unRegisterSelf(ModelConstraintsManager manager) {
      }

      public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
        // links declared in hierarchy of enclosing concept. 
        if (_context.getReferenceNode() == null) {
          return null;
        }
        final boolean aggregation = SPropertyOperations.hasValue(_context.getReferenceNode(), "metaClass", "aggregation", "reference");
        List<SNode> result = new ArrayList<SNode>();
        SNode enclosingConcept = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration", true, false);
        List<SNode> directSupers = SConceptOperations.getDirectSuperConcepts(enclosingConcept, false);
        for (SNode concept : ListSequence.fromList(directSupers)) {
          List<SNode> links = AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(concept);
          ListSequence.fromList(result).addSequence(ListSequence.fromList(links).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              if (aggregation) {
                return SPropertyOperations.hasValue(it, "metaClass", "aggregation", "reference");
              }
              return SPropertyOperations.hasValue(it, "metaClass", "reference", "reference");
            }
          }));
        }
        return result;
      }

      public SNodePointer getSearchScopeValidatorNodePointer() {
        return new SNodePointer("r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)", "1213104841302");
      }
    });
    return result;
  }
}
