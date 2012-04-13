package jetbrains.mps.build.util;

/*Generated by MPS */

import java.util.Set;
import jetbrains.mps.smodel.SNode;
import java.util.LinkedHashSet;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Collection;

public class JavaModulesClosure {
  private Set<SNode> modules = new LinkedHashSet<SNode>();
  private Set<SNode> libraries = new LinkedHashSet<SNode>();
  private Set<SNode> jars = new LinkedHashSet<SNode>();
  private Set<SNode> importedJars = new LinkedHashSet<SNode>();
  private TemplateQueryContext genContext;
  private SNode initial;

  public JavaModulesClosure(TemplateQueryContext genContext, SNode initial) {
    this.genContext = genContext;
    this.initial = initial;
  }

  public JavaModulesClosure closure(boolean reexportOnly) {
    moduleClosure(initial, reexportOnly);
    modules.remove(initial);
    return this;
  }

  private void moduleClosure(SNode module, boolean reexportOnly) {
    for (SNode dep : SLinkOperations.getTargets(module, "dependencies", true)) {
      if (SNodeOperations.isInstanceOf(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyModule")) {
        SNode moduleDep = SNodeOperations.cast(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyModule");
        if (reexportOnly && !(SPropertyOperations.getBoolean(moduleDep, "reexport"))) {
          continue;
        }
        SNode depModule = SNodeOperations.as(toOriginalNode(SLinkOperations.getTarget(moduleDep, "module", false)), "jetbrains.mps.build.structure.BuildSource_JavaModule");
        if (depModule == null) {
          continue;
        }

        if (modules.add(depModule)) {
          moduleClosure(depModule, true);
          // re-add to move to the end of the list 
          modules.remove(depModule);
          modules.add(depModule);
        }
      } else if (SNodeOperations.isInstanceOf(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary")) {
        SNode libraryDep = SNodeOperations.cast(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyLibrary");
        if (reexportOnly && !(SPropertyOperations.getBoolean(libraryDep, "reexport"))) {
          continue;
        }


        SNode library = SNodeOperations.as(toOriginalNode(SLinkOperations.getTarget(libraryDep, "library", false)), "jetbrains.mps.build.structure.BuildSource_JavaLibrary");
        if (library != null) {
          libraries.add(library);
        }
      } else if (SNodeOperations.isInstanceOf(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar")) {
        SNode jarDep = SNodeOperations.cast(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyJar");
        if (reexportOnly && !(SPropertyOperations.getBoolean(jarDep, "reexport"))) {
          continue;
        }

        jars.add(SLinkOperations.getTarget(jarDep, "jar", true));
      } else if (SNodeOperations.isInstanceOf(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyExternalJar")) {
        SNode jarDep = SNodeOperations.cast(dep, "jetbrains.mps.build.structure.BuildSource_JavaDependencyExternalJar");
        if (reexportOnly && !(SPropertyOperations.getBoolean(jarDep, "reexport"))) {
          continue;
        }

        importedJars.add(SLinkOperations.getTarget(SLinkOperations.getTarget(jarDep, "extJar", true), "jar", false));
      }
    }
  }

  private SNode toOriginalNode(SNode node) {
    if (node == null) {
      return null;
    }
    if (SNodeOperations.getContainingRoot(node) == SNodeOperations.getContainingRoot(initial)) {
      return node;
    }
    return DependenciesHelper.getOriginalNode(node, genContext);
  }

  public Collection<SNode> getModules() {
    return modules;
  }

  public Collection<SNode> getLibraries() {
    return libraries;
  }

  public Collection<SNode> getJars() {
    return jars;
  }

  public Set<SNode> getImportedJars() {
    return importedJars;
  }

  public SNode getInitial() {
    return initial;
  }
}
