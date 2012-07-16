package jetbrains.mps.execution.configurations.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.relations.RelationDescriptor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class Executor_TabDescriptor extends RelationDescriptor {
  public Executor_TabDescriptor() {
  }

  public String getTitle() {
    return "Executor";
  }

  public void startListening() {
    throw new RuntimeException("NOT IMPLEMENTED");
  }

  public SNode getBaseNode(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor"), "configuration", false);
    }
    return null;
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(node, "jetbrains.mps.execution.configurations.structure.RunConfiguration");
  }

  public List<SNode> getNodes(SNode node) {
    List<SNode> list = ListSequence.fromList(new ArrayList<SNode>());
    SNode n = getNode(node);
    if (n == null) {
      return list;
    }
    ListSequence.fromList(list).addElement(n);
    return list;
  }

  public boolean isSingle() {
    return true;
  }

  public SNode getNode(SNode node) {
    final SNode nodeFinal = node;
    return ListSequence.fromList(SModelOperations.getRoots(SNodeOperations.getModel(node), "jetbrains.mps.execution.configurations.structure.AbstractRunConfigurationExecutor")).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SLinkOperations.getTarget(it, "configuration", false) == nodeFinal;
      }
    });
  }

  public List<SNode> getConcepts(final SNode node) {
    return ListSequence.fromListAndArray(new ArrayList<SNode>(), SConceptOperations.findConceptDeclaration("jetbrains.mps.execution.configurations.structure.RunConfigurationExecutor"));
  }

  public SNode createNode(final SNode node, final SNode concept) {
    SNode executor = SConceptOperations.createNewNode("jetbrains.mps.execution.configurations.structure.RunConfigurationExecutor", null);
    SLinkOperations.setTarget(executor, "configuration", node, false);
    SModelOperations.addRootNode(SNodeOperations.getModel(node), executor);
    return executor;
  }
}
