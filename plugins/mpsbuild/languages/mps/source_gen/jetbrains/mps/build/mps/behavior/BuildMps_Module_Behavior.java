package jetbrains.mps.build.mps.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.VisibleArtifacts;
import jetbrains.mps.build.mps.util.MPSModulesClosure;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.build.util.JavaExportUtil;

public class BuildMps_Module_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> virtual_getDependencyTargets_841011766566205095(SNode thisNode, VisibleArtifacts artifacts) {
    MPSModulesClosure closure = new MPSModulesClosure(artifacts.getGenContext(), thisNode).closure();

    List<SNode> result = new ArrayList<SNode>();
    for (SNode m : Sequence.fromIterable(closure.getModules())) {
      if (SNodeOperations.getContainingRoot(m) == SNodeOperations.getContainingRoot(thisNode)) {
        continue;
      }

      SNode artifact = SNodeOperations.as(artifacts.findArtifact(m), "jetbrains.mps.build.structure.BuildLayout_Node");
      if (artifact != null) {
        ListSequence.fromList(result).addElement(artifact);
      }
    }

    for (SNode lr : Sequence.fromIterable(closure.getLanguagesWithRuntime())) {
      if (SNodeOperations.getContainingRoot(lr) == SNodeOperations.getContainingRoot(thisNode)) {
        continue;
      }

      for (SNode runtime : SLinkOperations.getTargets(lr, "runtime", true)) {
        if (!(SNodeOperations.isInstanceOf(runtime, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime"))) {
          continue;
        }
        SNode path = SLinkOperations.getTarget(SNodeOperations.cast(runtime, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime"), "path", true);
        SNode artifact = SNodeOperations.as(artifacts.findArtifact(path), "jetbrains.mps.build.structure.BuildLayout_Node");
        if (artifact != null) {
          ListSequence.fromList(result).addElement(artifact);
          if (SNodeOperations.isInstanceOf(artifact, "jetbrains.mps.build.structure.BuildLayout_Copy")) {
            SNode file = SNodeOperations.as(SLinkOperations.getTarget(SNodeOperations.cast(artifact, "jetbrains.mps.build.structure.BuildLayout_Copy"), "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile");
            if ((file != null)) {
              // again, register real path here to enable "import jar ...." construction 
              artifacts.findArtifact(SLinkOperations.getTarget(file, "path", true));
            }
          }
        }
      }
    }

    MPSModulesClosure.RequiredJavaModules requiredJava = closure.getRequiredJava();
    for (SNode jm : Sequence.fromIterable(requiredJava.getModules())) {
      if (requiredJava.isReexported(jm)) {
        ListSequence.fromList(result).addSequence(Sequence.fromIterable(JavaExportUtil.requireModule(artifacts, jm, thisNode)));
      } else {
        if (SNodeOperations.getContainingRoot(jm) == SNodeOperations.getContainingRoot(thisNode)) {
          continue;
        }

        SNode artifact = SNodeOperations.as(artifacts.findArtifact(jm), "jetbrains.mps.build.structure.BuildLayout_Node");
        if (artifact != null) {
          ListSequence.fromList(result).addElement(artifact);
        }
      }
    }

    if (ListSequence.fromList(result).isNotEmpty()) {
      artifacts.needsFetch(thisNode);
      return result;
    }
    return null;
  }
}
