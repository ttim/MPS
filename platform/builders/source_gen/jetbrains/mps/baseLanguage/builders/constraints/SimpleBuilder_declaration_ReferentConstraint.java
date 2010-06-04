package jetbrains.mps.baseLanguage.builders.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.builders.behavior.Builder_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.builders.behavior.SimpleBuilder_Behavior;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.builders.behavior.SimpleBuilderDeclaration_Behavior;
import jetbrains.mps.smodel.search.ISearchScope;
import jetbrains.mps.smodel.search.AbstractSearchScope;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Condition;
import jetbrains.mps.smodel.SNodePointer;

public class SimpleBuilder_declaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public SimpleBuilder_declaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.builders.structure.SimpleBuilder", "declaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.baseLanguage.builders.structure.SimpleBuilder", "declaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    SNode contextBuilder = Builder_Behavior.getContextBuilder_7057666463730366732(_context.getEnclosingNode());
    if (SNodeOperations.isInstanceOf(contextBuilder, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilder")) {
      return SimpleBuilder_Behavior.call_getPossibleChildren_8969040284892300232(SNodeOperations.cast(contextBuilder, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilder"), _context.getModel(), operationContext.getScope());
    } else if (contextBuilder == null && (SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.structure.GenericNewExpression") || SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.builders.structure.AsBuilderStatement") || SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.baseLanguage.builders.structure.BuilderCreator"))) {

      List<SNode> result = new ArrayList<SNode>();

      for (SNode dcl : ListSequence.fromList(SModelOperations.getRootsIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilders")).translate(new ITranslator2<SNode, SNode>() {
        public Iterable<SNode> translate(SNode it) {
          return SLinkOperations.getTargets(it, "builder", true);
        }
      })) {
        if (SNodeOperations.isInstanceOf(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderDeclaration") && SimpleBuilderDeclaration_Behavior.call_isRoot_8969040284892403078(SNodeOperations.cast(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderDeclaration"))) {
          ListSequence.fromList(result).addElement(SNodeOperations.cast(dcl, "jetbrains.mps.baseLanguage.builders.structure.SimpleBuilderDeclaration"));
        }
      }

      return result;
    } else {
      return new ArrayList<SNode>();
    }
  }

  public ISearchScope createNodeReferentSearchScope(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    return new AbstractSearchScope() {
      @NotNull
      public List<SNode> getNodes(Condition<SNode> condition) {
        Iterable<SNode> seq = (Iterable<SNode>) createSearchScopeOrListOfNodes(operationContext, _context);
        List<SNode> result = new ArrayList<SNode>();
        if (seq != null) {
          for (SNode node : seq) {
            if (condition.met(node)) {
              result.add(node);
            }
          }
        }
        return result;
      }
    };
  }

  public SNodePointer getSearchScopeValidatorNodePointer() {
    return new SNodePointer("r:971d5c35-6139-4f76-9019-ac96d9713d41(jetbrains.mps.baseLanguage.builders.constraints)", "7288041816793179321");
  }
}
