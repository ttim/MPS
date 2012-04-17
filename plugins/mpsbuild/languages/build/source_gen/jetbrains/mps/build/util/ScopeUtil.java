package jetbrains.mps.build.util;

/*Generated by MPS */

import jetbrains.mps.scope.Scope;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.scope.SimpleRoleScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.scope.DelegatingScope;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;
import jetbrains.mps.project.IModule;
import jetbrains.mps.scope.ModelPlusImportedScope;
import jetbrains.mps.build.behavior.BuildLayout_Node_Behavior;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;
import jetbrains.mps.build.behavior.BuildLayout_PathElement_Behavior;

public class ScopeUtil {
  public ScopeUtil() {
  }

  public static Scope simpleRoleScope(SNode node, SNode link) {
    return new SimpleRoleScope(node, link) {
      public String getName(SNode child) {
        return SPropertyOperations.getString(SNodeOperations.cast(child, "jetbrains.mps.lang.core.structure.INamedConcept"), "name");
      }
    };
  }

  public static Scope where(Scope scope, final _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> filter) {
    return new DelegatingScope(scope) {
      public Iterable<SNode> getAvailableElements(@Nullable String prefix) {
        return Sequence.fromIterable(wrapped.getAvailableElements(prefix)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return filter.invoke(it);
          }
        }).toListSequence();
      }
    };
  }

  public static Iterable<Scope> imported(List<SNode> importDeclarations, final SNode concept, final SNode child) {
    return ListSequence.fromList(importDeclarations).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        // searching for smart references 
        return (int) Sequence.fromIterable(SNodeOperations.getReferences(it)).count() == 1 && SNodeOperations.isInstanceOf(SLinkOperations.getTargetNode(Sequence.fromIterable(SNodeOperations.getReferences(it)).first()), "jetbrains.mps.lang.core.structure.ScopeProvider");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        // that references providers 
        return SNodeOperations.cast(SLinkOperations.getTargetNode(Sequence.fromIterable(SNodeOperations.getReferences(it)).first()), "jetbrains.mps.lang.core.structure.ScopeProvider");
      }
    }).select(new ISelector<SNode, Scope>() {
      public Scope select(SNode it) {
        return ScopeProvider_Behavior.call_getScope_3734116213129936182(it, concept, child);
      }
    });
  }

  public static Scope getVisibleArtifactsScope(SNode project) {
    if (SNodeOperations.getModel(project).isTransient()) {
      IModule transientModule = SNodeOperations.getModel(project).getModelDescriptor().getModule();
      return new ModelPlusImportedScope(SNodeOperations.getModel(project), false, transientModule.getScope(), "jetbrains.mps.build.structure.BuildLayout_Node");
    }
    VisibleArtifacts artifacts = new VisibleArtifacts(project, null);
    artifacts.collect();
    return new ScopeUtil.VisibleArtifactsScope(artifacts);
  }

  public static Scope getVisibleJarsScope(SNode project) {
    if (SNodeOperations.getModel(project).isTransient()) {
      IModule transientModule = SNodeOperations.getModel(project).getModelDescriptor().getModule();
      return new ModelPlusImportedScope(SNodeOperations.getModel(project), false, transientModule.getScope(), "jetbrains.mps.build.structure.BuildSource_SingleFile");
    }
    VisibleArtifacts artifacts = new VisibleArtifacts(project, null);
    artifacts.collect();
    return new ScopeUtil.VisibleJarsScope(artifacts);
  }

  public static Scope getVisibleJarFoldersScope(SNode project) {
    if (SNodeOperations.getModel(project).isTransient()) {
      IModule transientModule = SNodeOperations.getModel(project).getModelDescriptor().getModule();
      return new ModelPlusImportedScope(SNodeOperations.getModel(project), false, transientModule.getScope(), "jetbrains.mps.build.structure.BuildSource_SingleFolder");
    }
    VisibleArtifacts artifacts = new VisibleArtifacts(project, null);
    artifacts.collect();
    return new ScopeUtil.VisibleJarFoldersScope(artifacts);
  }

  private static class VisibleArtifactsScope extends Scope {
    private VisibleArtifacts artifacts;

    public VisibleArtifactsScope(VisibleArtifacts artifacts) {
      this.artifacts = artifacts;
    }

    private Iterable<SNode> getAllNodes() {
      return Sequence.fromIterable(artifacts.getArtifacts()).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return BuildLayout_Node_Behavior.call_isFile_1368030936106753986(it) || BuildLayout_Node_Behavior.call_isFolder_1368030936106753980(it);
        }
      });
    }

    public Iterable<SNode> getAvailableElements(@Nullable String prefix) {
      if (StringUtils.isEmpty(prefix)) {
        return Sequence.fromIterable(getAllNodes()).toListSequence();
      }
      List<SNode> result = new ArrayList<SNode>();
      for (SNode n : getAllNodes()) {
        String name = getName(n);
        if (prefix == null || name.startsWith(prefix)) {
          ListSequence.fromList(result).addElement(n);
        }
      }
      return result;
    }

    public SNode resolve(SNode contextNode, String refText) {
      SNode result = null;
      for (SNode n : getAllNodes()) {
        String name = getName(n);
        if (name.equals(refText)) {
          if (result == null) {
            result = n;
          } else {
            return null;
          }
        }
      }
      return result;
    }

    public String getReferenceText(SNode contextNode, SNode node) {
      if (node == null || !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildLayout_Node"))) {
        return null;
      }

      String result = getName(SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildLayout_Node"));
      for (SNode n : getAllNodes()) {
        if (n == node) {
          continue;
        }
        String name = getName(n);
        if (name.equals(result)) {
          // ambiguity 
          return null;
        }
      }
      return result;
    }

    private String getName(SNode node) {
      StringBuilder sb = new StringBuilder();
      appendName(node, sb);
      return sb.toString();
    }

    private void appendName(SNode node, StringBuilder sb) {
      SNode parent = artifacts.parent(node);
      if ((parent != null)) {
        appendName(parent, sb);
      }
      BuildLayout_PathElement_Behavior.call_appendName_1368030936106665465(node, parent, sb);
    }
  }

  public static abstract class TransformingScope extends Scope {
    protected Scope wrapped;

    public TransformingScope(Scope wrapped) {
      this.wrapped = wrapped;
    }

    public SNode resolve(SNode contextNode, String refText) {
      SNode resolve = wrapped.resolve(contextNode, refText);
      if (resolve == null) {
        return null;
      }
      return unwrap(resolve);
    }

    public Iterable<SNode> getAvailableElements(@Nullable String prefix) {
      return Sequence.fromIterable(wrapped.getAvailableElements(prefix)).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return unwrap(it);
        }
      }).toListSequence();
    }

    public String getReferenceText(SNode contextNode, SNode node) {
      node = wrap(node);
      if (node == null) {
        return null;
      }
      return wrapped.getReferenceText(contextNode, node);
    }

    @Override
    public boolean contains(SNode node) {
      node = wrap(node);
      if (node == null) {
        return false;
      }
      return wrapped.contains(node);
    }

    public abstract SNode wrap(SNode node);

    public abstract SNode unwrap(SNode node);
  }

  public static class VisibleJarFoldersScope extends ScopeUtil.TransformingScope {
    public VisibleJarFoldersScope(VisibleArtifacts artifacts) {
      super(new ScopeUtil.VisibleArtifactsScope(artifacts));
    }

    public SNode wrap(SNode node) {
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildLayout_Node")) {
        return SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildLayout_Node");
      } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildInputSingleFolder") && SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.build.structure.BuildLayout_Copy")) {
        return SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.build.structure.BuildLayout_Node");
      }
      return null;
    }

    public SNode unwrap(SNode node) {
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildSource_SingleFolder")) {
        return SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildSource_SingleFolder");
      } else {
        SNode copyNode = SNodeOperations.as(node, "jetbrains.mps.build.structure.BuildLayout_Copy");
        if ((copyNode != null) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(copyNode, "fileset", true), "jetbrains.mps.build.structure.BuildSource_SingleFolder")) {
          return SNodeOperations.cast(SLinkOperations.getTarget(copyNode, "fileset", true), "jetbrains.mps.build.structure.BuildSource_SingleFolder");
        }
      }
      return null;
    }
  }

  public static class VisibleJarsScope extends ScopeUtil.TransformingScope {
    public VisibleJarsScope(VisibleArtifacts artifacts) {
      super(new ScopeUtil.VisibleArtifactsScope(artifacts));
    }

    public SNode wrap(SNode node) {
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildLayout_Node")) {
        return SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildLayout_Node");
      } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildInputSingleFile") && SNodeOperations.isInstanceOf(SNodeOperations.getParent(node), "jetbrains.mps.build.structure.BuildLayout_Copy")) {
        return SNodeOperations.cast(SNodeOperations.getParent(node), "jetbrains.mps.build.structure.BuildLayout_Node");
      }
      return null;
    }

    public SNode unwrap(SNode node) {
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.build.structure.BuildSource_SingleFile")) {
        return SNodeOperations.cast(node, "jetbrains.mps.build.structure.BuildSource_SingleFile");
      } else {
        SNode copyNode = SNodeOperations.as(node, "jetbrains.mps.build.structure.BuildLayout_Copy");
        if ((copyNode != null) && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(copyNode, "fileset", true), "jetbrains.mps.build.structure.BuildSource_SingleFile")) {
          return SNodeOperations.cast(SLinkOperations.getTarget(copyNode, "fileset", true), "jetbrains.mps.build.structure.BuildSource_SingleFile");
        }
      }
      return null;
    }
  }
}
