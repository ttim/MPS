package jetbrains.mps.build.util;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class JavaExportUtil {
  public JavaExportUtil() {
  }

  public static Iterable<SNode> requireLibrary(VisibleArtifacts artifacts, SNode library, SNode contextNode) {
    if (SNodeOperations.getContainingRoot(library) == SNodeOperations.getContainingRoot(contextNode)) {
      return null;
    }

    SNode target = SNodeOperations.as(artifacts.toOriginalNode(library), "jetbrains.mps.build.structure.BuildSource_JavaLibrary");
    SNode artifact = SNodeOperations.as(artifacts.findArtifact(target), "jetbrains.mps.build.structure.BuildLayout_Node");
    if (artifact != null) {
      artifacts.needsFetch(contextNode);
      if (SNodeOperations.isInstanceOf(artifact, "jetbrains.mps.build.structure.BuildLayout_ExportAsJavaLibrary")) {
        return SLinkOperations.getTargets(SNodeOperations.cast(artifact, "jetbrains.mps.build.structure.BuildLayout_ExportAsJavaLibrary"), "children", true);
      } else {
        return Sequence.<SNode>singleton(artifact);
      }
    }
    return null;
  }

  public static Iterable<SNode> requireModule(VisibleArtifacts artifacts, SNode module, SNode contextNode) {
    if (SNodeOperations.getContainingRoot(module) == SNodeOperations.getContainingRoot(contextNode)) {
      return null;
    }

    SNode target = SNodeOperations.as(artifacts.toOriginalNode(module), "jetbrains.mps.build.structure.BuildSource_JavaModule");

    // dependencies closure 
    JavaModulesClosure closure = new JavaModulesClosure(artifacts.getGenContext(), target).closure(true);

    // searh for artifacts 
    Iterable<SNode> required = Sequence.fromIterable(((Iterable<SNode>) closure.getModules())).concat(Sequence.fromIterable(((Iterable<SNode>) closure.getLibraries()))).concat(Sequence.fromIterable(((Iterable<SNode>) closure.getJars())).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(it, "path", true);
      }
    })).concat(Sequence.fromIterable(Sequence.<SNode>singleton(target)));
    List<SNode> result = new ArrayList<SNode>();
    for (SNode n : Sequence.fromIterable(required)) {
      if (SNodeOperations.getContainingRoot(n) == SNodeOperations.getContainingRoot(contextNode)) {
        continue;
      }

      SNode artifact = SNodeOperations.as(artifacts.findArtifact(n), "jetbrains.mps.build.structure.BuildLayout_Node");
      if (artifact != null) {
        ListSequence.fromList(result).addElement(artifact);
      }
    }

    if (ListSequence.fromList(result).isNotEmpty()) {
      artifacts.needsFetch(contextNode);
      return result;
    }

    return null;
  }
}
