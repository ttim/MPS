package jetbrains.mps.buildScript.util;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.TemplateQueryContext;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class VisibleArtifacts {
  private final SNode project;
  private final TemplateQueryContext genContext;
  private final Map<SNode, SNode> parentMap = new HashMap<SNode, SNode>();
  private final List<SNode> visibleArtifacts = new ArrayList<SNode>();
  private DependenciesHelper dependenciesHelper;

  public VisibleArtifacts(SNode project, @Nullable TemplateQueryContext genContext) {
    this.project = project;
    this.genContext = genContext;
    this.dependenciesHelper = (genContext != null ?
      new DependenciesHelper(genContext, project) :
      null
    );
    if (genContext == null && SNodeOperations.getModel(project).isTransient()) {
      throw new IllegalArgumentException("cannot instantiate VisibleArtifacts for transient model without generation context");
    }
  }

  public void collect() {
    for (SNode dep : SLinkOperations.getTargets(project, "dependencies", true)) {
      SNode projectDependency = SNodeOperations.as(dep, "jetbrains.mps.buildScript.structure.BuildProjectDependency");
      if (projectDependency == null) {
        continue;
      }

      SNode target = SLinkOperations.getTarget(projectDependency, "script", false);
      collectInScript(projectDependency, target);
    }
  }

  private void collectInScript(SNode parent, SNode target) {
    target = SNodeOperations.as(toOriginalNode(target), "jetbrains.mps.buildScript.structure.BuildProject");
    if (target == null) {
      return;
    }

    for (SNode node : SLinkOperations.getTargets(SLinkOperations.getTarget(target, "layout", true), "children", true)) {
      collectInLayout(parent, node);
    }
  }

  private void collectInLayout(SNode parent, SNode node) {
    if (parentMap.containsKey(node)) {
      return;
    }
    assert !(SNodeOperations.getModel(node).isTransient());

    ListSequence.fromList(visibleArtifacts).addElement(node);
    parentMap.put(node, parent);

    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer")) {
      for (SNode child : SLinkOperations.getTargets(SNodeOperations.cast(node, "jetbrains.mps.buildScript.structure.BuildLayout_AbstractContainer"), "children", true)) {
        collectInLayout(node, child);
      }
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.buildScript.structure.BuildLayout_Import")) {
      SNode target = SNodeOperations.as(toOriginalNode(SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.buildScript.structure.BuildLayout_Import"), "target", false)), "jetbrains.mps.buildScript.structure.BuildLayout_NamedContainer");
      if (target != null) {
        collectInLayout(parent, target);
      }
    }
  }

  public SNode toOriginalNode(SNode node) {
    return DependenciesHelper.getOriginalNode(node, genContext);
  }

  public SNode getProject() {
    return project;
  }

  public Iterable<SNode> getArtifacts() {
    return ListSequence.fromList(visibleArtifacts).asUnmodifiable();
  }

  public boolean contains(SNode node) {
    return parentMap.containsKey(node);
  }

  public SNode parent(SNode node) {
    return parentMap.get(node);
  }

  public void needsFetch(SNode node) {
    if ((node == null)) {
      return;
    }
    node = toOriginalNode(node);
    if ((node == null)) {
      return;
    }
    if (dependenciesHelper == null) {
      throw new IllegalStateException("needsFetch() should be called in generation context only");
    }
    dependenciesHelper.requiresFetch().put(node, "");
  }

  public void registerEntity(Object id, SNode location) {
    if (dependenciesHelper == null) {
      throw new IllegalStateException("registerEntity() should be called in generation context only");
    }
    dependenciesHelper.artifacts().put(id, location);
  }
}
