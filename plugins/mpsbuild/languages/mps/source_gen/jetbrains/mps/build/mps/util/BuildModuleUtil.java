package jetbrains.mps.build.mps.util;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.util.IterableUtil;
import jetbrains.mps.util.iterable.RecursiveIterator;
import java.util.Iterator;
import java.util.Set;
import java.util.LinkedHashSet;

public class BuildModuleUtil {
  public BuildModuleUtil() {
  }

  private static Iterable<SNode> getDependencies(SNode module, final boolean reexport) {
    Iterable<SNode> dependencies = ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule") && SPropertyOperations.getBoolean(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule"), "reexport") == reexport;
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnModule"), "module", false);
      }
    });

    if (reexport) {
      return dependencies;
    }

    Iterable<SNode> solutionsFromDevkits = Sequence.fromIterable(includingExtended(usedDevkits(module))).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode it) {
        return ListSequence.fromList(SLinkOperations.getTargets(it, "exports", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode iit) {
            return SNodeOperations.isInstanceOf(iit, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution");
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode iit) {
            return SLinkOperations.getTarget(SNodeOperations.cast(iit, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportSolution"), "solution", false);
          }
        });
      }
    });
    // "core" language is added in loadModules pre-script 
    return IterableUtil.distinct(IterableUtil.merge(dependencies, solutionsFromDevkits));
  }

  private static Iterable<SNode> getUsedLanguages(SNode module) {
    Iterable<SNode> usedLangs = ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyUseLanguage");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyUseLanguage"), "language", false);
      }
    });

    Iterable<SNode> languagesFromDevkits = Sequence.fromIterable(includingExtended(usedDevkits(module))).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode it) {
        return ListSequence.fromList(SLinkOperations.getTargets(it, "exports", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode iit) {
            return SNodeOperations.isInstanceOf(iit, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage");
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode iit) {
            return SLinkOperations.getTarget(SNodeOperations.cast(iit, "jetbrains.mps.build.mps.structure.BuildMps_DevKitExportLanguage"), "language", false);
          }
        });
      }
    });

    // use "core" language is added in loadModules pre-script 
    return includingExtendedLanguages(IterableUtil.merge(usedLangs, languagesFromDevkits));
  }

  private static Iterable<SNode> usedDevkits(SNode module) {
    return ListSequence.fromList(SLinkOperations.getTargets(module, "dependencies", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnDevKit");
      }
    }).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode it) {
        return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyOnDevKit"), "devkit", false);
      }
    });
  }

  private static Iterable<SNode> includingExtended(Iterable<SNode> devkits) {
    return new RecursiveIterator<SNode>(Sequence.fromIterable(devkits).iterator(), false) {
      protected Iterator<SNode> children(SNode node) {
        return ListSequence.fromList(SLinkOperations.getTargets(node, "extends", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return (SLinkOperations.getTarget(it, "devkit", false) != null);
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(it, "devkit", false);
          }
        }).iterator();
      }
    };
  }

  private static Iterable<SNode> includingExtendedLanguages(Iterable<SNode> langs) {
    return new RecursiveIterator<SNode>(Sequence.fromIterable(langs).iterator(), false) {
      protected Iterator<SNode> children(SNode node) {
        return ListSequence.fromList(SLinkOperations.getTargets(node, "dependencies", true)).where(new IWhereFilter<SNode>() {
          public boolean accept(SNode it) {
            return SNodeOperations.isInstanceOf(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage");
          }
        }).select(new ISelector<SNode, SNode>() {
          public SNode select(SNode it) {
            return SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.build.mps.structure.BuildMps_ModuleDependencyExtendLanguage"), "language", false);
          }
        }).iterator();
      }
    };
  }

  public static void collectAllCompileTimeDependencies(SNode module, Set<SNode> dependencies, Set<SNode> languagesWithRuntime) {
    Set<SNode> nonreexportDeps = new LinkedHashSet<SNode>();
    collectAllCompileTimeDependencies(module, false, dependencies, nonreexportDeps, languagesWithRuntime);
    dependencies.addAll(nonreexportDeps);
    dependencies.remove(module);
  }

  private static void collectAllCompileTimeDependencies(SNode module, boolean reexportOnly, Set<SNode> dependencies, Set<SNode> nonreexportDeps, Set<SNode> languagesWithRuntime) {
    // copy of ModuleDependenciesManager.collectAllCompileTimeDependencies (ignoring "core" language) 
    dependencies.add(module);
    for (SNode m : getDependencies(module, true)) {
      if (!(dependencies.contains(m))) {
        collectAllCompileTimeDependencies(m, true, dependencies, nonreexportDeps, languagesWithRuntime);
      }
    }

    if (reexportOnly) {
      return;
    }
    for (SNode m : getDependencies(module, false)) {
      nonreexportDeps.add(m);
    }

    // NOTE: generator dependencies are imported into language in ModuleLoader.collectDependencies() 

    for (SNode language : getUsedLanguages(module)) {
      boolean hasRuntime = false;
      for (SNode rdep : SLinkOperations.getTargets(language, "runtime", true)) {
        if (!(SNodeOperations.isInstanceOf(rdep, "jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime"))) {
          hasRuntime = true;
          continue;
        }
        SNode runtimeSolution = SLinkOperations.getTarget(SNodeOperations.cast(rdep, "jetbrains.mps.build.mps.structure.BuildMps_ModuleSolutionRuntime"), "solution", false);
        if (!(dependencies.contains(runtimeSolution))) {
          collectAllCompileTimeDependencies(runtimeSolution, true, dependencies, nonreexportDeps, languagesWithRuntime);
        }

      }
      if (hasRuntime) {
        languagesWithRuntime.add(language);
      }
    }
  }
}
