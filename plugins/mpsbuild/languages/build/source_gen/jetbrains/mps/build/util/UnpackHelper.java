package jetbrains.mps.build.util;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.build.behavior.BuildLayout_PathElement_Behavior;

public class UnpackHelper extends DependenciesHelper {
  private final VisibleArtifacts visible;
  private final List<SNode> required = new ArrayList<SNode>();
  private final Set<SNode> requiredSet = new HashSet<SNode>();
  private boolean evaluated = false;
  private final List<SNode> statements = new ArrayList<SNode>();
  private PathProvider myPathProvider;
  private TemplateQueryContext genContext;

  public UnpackHelper(VisibleArtifacts visible, Iterable<SNode> required, TemplateQueryContext genContext) {
    super(genContext, visible.getProject());
    this.visible = visible;
    this.myPathProvider = new PathProvider(genContext, visible.getProject());

    for (SNode node : required) {
      add(node);
    }
    this.genContext = genContext;
  }

  private void add(SNode n) {
    if (!(requiredSet.add(n))) {
      return;
    }

    SNode parent = visible.parent(n);
    if (parent != null) {
      add(parent);
    }
    ListSequence.fromList(required).addElement(n);
  }

  public void eval() {
    if (evaluated) {
      return;
    }
    evaluated = true;

    for (SNode n : required) {
      BuildLayout_PathElement_Behavior.call_unpack_7128123785277710736(n, this);
    }
  }

  public boolean isRequired(SNode n) {
    return requiredSet.contains(n);
  }

  public void emit(SNode st) {
    ListSequence.fromList(statements).addElement(st);
  }

  public SNode parent(SNode node) {
    return visible.parent(node);
  }

  public List<SNode> getStatements() {
    return ListSequence.fromList(statements).asUnmodifiable();
  }

  public PathProvider getPathProvider() {
    return myPathProvider;
  }
}
