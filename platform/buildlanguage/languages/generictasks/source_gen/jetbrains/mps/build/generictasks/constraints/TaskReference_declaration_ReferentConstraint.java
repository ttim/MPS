package jetbrains.mps.build.generictasks.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.constraints.BaseNodeReferenceSearchScopeProvider;
import jetbrains.mps.smodel.constraints.IModelConstraints;
import jetbrains.mps.smodel.constraints.ModelConstraintsManager;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.constraints.ReferentConstraintContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.search.SimpleSearchScope;
import jetbrains.mps.smodel.SNodePointer;

public class TaskReference_declaration_ReferentConstraint extends BaseNodeReferenceSearchScopeProvider implements IModelConstraints {
  public TaskReference_declaration_ReferentConstraint() {
  }

  public void registerSelf(ModelConstraintsManager manager) {
    manager.registerNodeReferentSearchScopeProvider("jetbrains.mps.build.generictasks.structure.TaskReference", "declaration", this);
  }

  public void unRegisterSelf(ModelConstraintsManager manager) {
    manager.unRegisterNodeReferentSearchScopeProvider("jetbrains.mps.build.generictasks.structure.TaskReference", "declaration");
  }

  public Object createSearchScopeOrListOfNodes(final IOperationContext operationContext, final ReferentConstraintContext _context) {
    List<SNode> decls = SModelOperations.getNodesIncludingImported(_context.getModel(), operationContext.getScope(), "jetbrains.mps.buildlanguage.structure.IDeclaration");
    if (SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration") && SNodeOperations.hasRole(_context.getReferenceNode(), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration", "fakeDeclaration")) {
      List<SNode> newDecls = new ArrayList<SNode>();
      for (SNode decl : ListSequence.fromList(decls)) {
        if (SNodeOperations.isInstanceOf(decl, "jetbrains.mps.build.generictasks.structure.TaskInterfaceDeclaration")) {
          ListSequence.fromList(newDecls).addElement(decl);
        }
      }
      return new SimpleSearchScope(newDecls);
    } else
    if (SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration") && SNodeOperations.hasRole(_context.getReferenceNode(), "jetbrains.mps.build.generictasks.structure.BuiltInTaskDeclaration", "fakeDeclaration")) {
      List<SNode> newDecls = new ArrayList<SNode>();
      for (SNode decl : ListSequence.fromList(decls)) {
        if (!(SNodeOperations.isInstanceOf(decl, "jetbrains.mps.build.generictasks.structure.TaskInterfaceDeclaration"))) {
          ListSequence.fromList(newDecls).addElement(decl);
        }
      }
      return new SimpleSearchScope(newDecls);
    }
    return decls;
  }

  public SNodePointer getSearchScopeFactoryNodePointer() {
    return new SNodePointer("r:71eee63a-b16f-40f8-920d-8fd0fe7dc8a1(jetbrains.mps.build.generictasks.constraints)", "3037831562615764092");
  }
}
