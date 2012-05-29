package jetbrains.mps.build.mps.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.VisibleArtifacts;
import jetbrains.mps.build.util.RequiredDependenciesBuilder;
import jetbrains.mps.build.mps.util.MPSModulesClosure;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.build.behavior.BuildSource_JavaExternalJarRef_Behavior;
import jetbrains.mps.build.util.JavaExportUtil;

public class BuildMps_Module_Behavior {
  public static void init(SNode thisNode) {
  }

  public static void virtual_fetchDependencies_5908258303322131137(SNode thisNode, VisibleArtifacts artifacts, RequiredDependenciesBuilder builder) {
    MPSModulesClosure closure = new MPSModulesClosure(artifacts.getGenContext(), thisNode).closure();

    boolean needsFetch = false;
    List<SNode> requiredJars = new ArrayList<SNode>();
    for (SNode m : Sequence.fromIterable(closure.getModules())) {
      SNode artifact;
      if (SNodeOperations.getContainingRoot(m) != SNodeOperations.getContainingRoot(thisNode)) {
        artifact = SNodeOperations.as(artifacts.findArtifact(m), "jetbrains.mps.build.structure.BuildLayout_Node");
        if (artifact != null) {
          builder.add(artifact, m);
          needsFetch = true;
        }
      }

      for (SNode dep : ListSequence.fromList(SLinkOperations.getTargets(m, "dependencies", true)).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return (SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ExtractedModuleDependency") ?
            SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ExtractedModuleDependency"), "dependency", true) :
            it
          );
        }
      }).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyJar");
        }
      }).select(new ISelector<SNode, SNode>() {
        public SNode select(SNode it) {
          return SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyJar");
        }
      })) {
        if ((SLinkOperations.getTarget(dep, "customLocation", true) != null)) {
          artifact = BuildSource_JavaExternalJarRef_Behavior.call_getDependencyTarget_5610619299014309566(SLinkOperations.getTarget(dep, "customLocation", true), artifacts);
          if (artifact != null) {
            builder.add(artifact);
            needsFetch = true;
          }
        } else {
          if (SNodeOperations.getContainingRoot(m) == SNodeOperations.getContainingRoot(thisNode)) {
            continue;
          }

          ListSequence.fromList(requiredJars).addElement(SLinkOperations.getTarget(dep, "path", true));
        }
      }
    }

    for (SNode lr : Sequence.fromIterable(closure.getLanguagesWithRuntime())) {
      for (SNode runtime : SLinkOperations.getTargets(lr, "runtime", true)) {
        if (!(SNodeOperations.isInstanceOf(runtime, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime"))) {
          continue;
        }

        SNode jarRuntime = SNodeOperations.cast(runtime, "jetbrains.mps.build.mps.structure.BuildMps_ModuleJarRuntime");
        if ((SLinkOperations.getTarget(jarRuntime, "customLocation", true) != null)) {
          SNode artifact = BuildSource_JavaExternalJarRef_Behavior.call_getDependencyTarget_5610619299014309566(SLinkOperations.getTarget(jarRuntime, "customLocation", true), artifacts);
          if (artifact != null) {
            builder.add(artifact);
            needsFetch = true;
          }
        } else {
          if (SNodeOperations.getContainingRoot(lr) == SNodeOperations.getContainingRoot(thisNode)) {
            continue;
          }

          ListSequence.fromList(requiredJars).addElement(SLinkOperations.getTarget(jarRuntime, "path", true));
        }
      }
    }

    for (SNode path : ListSequence.fromList(requiredJars)) {
      SNode artifact = SNodeOperations.as(artifacts.findArtifact(path), "jetbrains.mps.build.structure.BuildLayout_Node");
      if (artifact != null) {
        builder.add(artifact);
        needsFetch = true;
        if (SNodeOperations.isInstanceOf(artifact, "jetbrains.mps.build.structure.BuildLayout_AbstractCopy")) {
          SNode file = SNodeOperations.as(SLinkOperations.getTarget(SNodeOperations.cast(artifact, "jetbrains.mps.build.structure.BuildLayout_AbstractCopy"), "fileset", true), "jetbrains.mps.build.structure.BuildInputSingleFile");
          if ((file != null)) {
            // again, register real path here to enable "import jar ...." construction 
            artifacts.findArtifact(SLinkOperations.getTarget(file, "path", true));
          }
        }
      }
    }

    MPSModulesClosure.RequiredJavaModules requiredJava = closure.getRequiredJava();
    for (SNode jm : Sequence.fromIterable(requiredJava.getModules())) {
      if (requiredJava.isReexported(jm)) {
        JavaExportUtil.requireModule(artifacts, jm, thisNode, builder);
      } else {
        if (SNodeOperations.getContainingRoot(jm) == SNodeOperations.getContainingRoot(thisNode)) {
          continue;
        }

        SNode artifact = SNodeOperations.as(artifacts.findArtifact(jm), "jetbrains.mps.build.structure.BuildLayout_Node");
        if (artifact != null) {
          needsFetch = true;
          builder.add(artifact, jm);
        }
      }
    }

    if (needsFetch) {
      artifacts.needsFetch(thisNode);
    }
  }
}
