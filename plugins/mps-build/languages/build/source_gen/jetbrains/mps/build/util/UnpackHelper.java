package jetbrains.mps.build.util;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.Collection;
import java.util.HashMap;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.LinkedHashSet;
import jetbrains.mps.build.behavior.BuildLayout_PathElement_Behavior;
import java.util.Collections;

public class UnpackHelper extends DependenciesHelper {
  private final VisibleArtifacts visible;
  private final List<SNode> required = new ArrayList<SNode>();
  private final Set<SNode> requiredSet = new HashSet<SNode>();
  private final Set<SNode> requiredWithContent = new HashSet<SNode>();
  private final Map<SNode, Collection<Object>> artifactIds = new HashMap<SNode, Collection<Object>>();
  private boolean evaluated = false;
  private final List<SNode> statements = new ArrayList<SNode>();
  private PathProvider myPathProvider;
  private TemplateQueryContext genContext;

  public UnpackHelper(VisibleArtifacts visible, TemplateQueryContext genContext) {
    super(genContext, visible.getProject());
    this.visible = visible;
    this.myPathProvider = new PathProvider(genContext, visible.getProject());
    this.genContext = genContext;
  }

  /*package*/ void add(SNode n, boolean withContent, Object artifactId) {
    if (withContent) {
      requiredWithContent.add(n);
    }
    if (artifactId != null) {
      mapArtifactId(n, artifactId);
    }
    if (!(requiredSet.add(n))) {
      return;
    }

    SNode parent = visible.parent(n);
    if (parent != null) {
      add(parent, true, null);
    }
    ListSequence.fromList(required).addElement(n);
  }

  private void mapArtifactId(SNode n, Object artifactId) {
    Collection<Object> collection = artifactIds.get(n);
    if (collection == null) {
      collection = new LinkedHashSet<Object>();
      artifactIds.put(n, collection);
    }
    collection.add(artifactId);
  }

  public void eval() {
    if (evaluated) {
      return;
    }
    evaluated = true;

    for (SNode n : required) {
      Collection<Object> artifacts = artifactIds.get(n);
      BuildLayout_PathElement_Behavior.call_unpack_7128123785277710736(n, this, (artifacts != null ?
        artifacts :
        Collections.emptyList()
      ));
    }
  }

  public boolean isRequired(SNode n) {
    return requiredSet.contains(n);
  }

  public boolean isContentRequired(SNode n) {
    return requiredWithContent.contains(n);
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
