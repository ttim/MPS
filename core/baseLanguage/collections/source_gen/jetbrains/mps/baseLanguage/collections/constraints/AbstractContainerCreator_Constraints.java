package jetbrains.mps.baseLanguage.collections.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.structure.CanBeASomethingMethod;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.structure.CheckingNodeContext;
import java.util.Map;
import jetbrains.mps.smodel.constraints.INodePropertyGetter;
import java.util.HashMap;
import jetbrains.mps.smodel.constraints.INodePropertySetter;
import jetbrains.mps.smodel.constraints.INodePropertyValidator;
import jetbrains.mps.smodel.constraints.INodeReferentSetEventHandler;
import jetbrains.mps.smodel.constraints.INodeReferentSearchScopeProvider;
import jetbrains.mps.baseLanguage.behavior.TypeDerivable_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.typesystem.inference.TypeChecker;

public class AbstractContainerCreator_Constraints extends ConstraintsDataHolder {
  public AbstractContainerCreator_Constraints() {
  }

  public String getAlternativeIcon(SNode node) {
    return null;
  }

  public boolean isAlternativeIcon() {
    return false;
  }

  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator";
  }

  public String getDefaultConcreteConceptFqName() {
    return "jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator";
  }

  @Override
  @Nullable
  public CanBeASomethingMethod<CanBeAChildContext> getCanBeAChildMethod() {
    return new CanBeASomethingMethod<CanBeAChildContext>() {
      private SNodePointer breakingNode = new SNodePointer("r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)", "3358009230509358977");

      public boolean canBe(IOperationContext operationContext, CanBeAChildContext _context, @Nullable CheckingNodeContext checkingNodeContext) {
        boolean result = canBeAChild(operationContext, _context);
        if (!(result) && checkingNodeContext != null) {
          checkingNodeContext.breakingNodePointer = breakingNode;
        }
        return result;
      }
    };
  }

  public Map<String, INodePropertyGetter> getNodePropertyGetters() {
    HashMap<String, INodePropertyGetter> result = new HashMap<String, INodePropertyGetter>();
    return result;
  }

  public Map<String, INodePropertySetter> getNodePropertySetters() {
    HashMap<String, INodePropertySetter> result = new HashMap<String, INodePropertySetter>();
    return result;
  }

  public Map<String, INodePropertyValidator> getNodePropertyValidators() {
    HashMap<String, INodePropertyValidator> result = new HashMap<String, INodePropertyValidator>();
    return result;
  }

  public Map<String, INodeReferentSetEventHandler> getNodeReferentSetEventHandlers() {
    HashMap<String, INodeReferentSetEventHandler> result = new HashMap<String, INodeReferentSetEventHandler>();
    return result;
  }

  public Map<String, INodeReferentSearchScopeProvider> getNodeNonDefaultSearchScopeProviders() {
    HashMap<String, INodeReferentSearchScopeProvider> result = new HashMap<String, INodeReferentSearchScopeProvider>();
    return result;
  }

  public static boolean canBeAChild(final IOperationContext operationContext, final CanBeAChildContext _context) {
    final SNode dtype = TypeDerivable_Behavior.call_deriveType_1213877435747(SNodeOperations.as(SNodeOperations.getParent(_context.getParentNode()), "jetbrains.mps.baseLanguage.structure.TypeDerivable"), SNodeOperations.as(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.Expression"));
    final SNode avlbForCLdecl = ListSequence.fromList(SLinkOperations.getTargets(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.AbstractContainerCreator"), "conceptLinkDeclaration", true)).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return "availableFor".equals(SPropertyOperations.getString(it, "name"));
      }
    });
    if ((dtype != null)) {
      Iterable<SNode> avlbFor = ListSequence.fromList(SLinkOperations.getTargets(_context.getChildConcept(), "conceptLink", true)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode cl) {
          return SLinkOperations.getTarget(cl, "conceptLinkDeclaration", false) == avlbForCLdecl;
        }
      }).<SNode>select(new ISelector<SNode, SNode>() {
        public SNode select(SNode cl) {
          return (SNode) SLinkOperations.getTarget(SNodeOperations.cast(cl, "jetbrains.mps.lang.structure.structure.ReferenceConceptLink"), "target", false);
        }
      });
      return Sequence.fromIterable(avlbFor).isEmpty() || Sequence.fromIterable(avlbFor).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode trg) {
          return SConceptOperations.isSuperConceptOf(SNodeOperations.getConceptDeclaration(dtype), NameUtil.nodeFQName(trg));
        }
      }) || (SNodeOperations.isInstanceOf(dtype, "jetbrains.mps.baseLanguage.structure.ClassifierType") && Sequence.fromIterable(avlbFor).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode trg) {
          return TypeChecker.getInstance().getSubtypingManager().isSubtype(SConceptOperations.createNewNode(NameUtil.nodeFQName(trg), dtype), dtype);
        }
      }));
    }
    return true;
  }
}
