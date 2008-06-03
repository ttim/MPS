package jetbrains.mps.baseLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.ArrayList;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.constraints.BaseMethodDeclaration_Behavior;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import org.jetbrains.annotations.Nullable;

public class InterfaceMethodImplementations_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.baseLanguage.findUsages.InterfaceMethodImplementations_Finder");

  public boolean isVisible() {
    return true;
  }

  public String getDescription() {
    return "Interface Method Implementations";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration";
  }

  public boolean isApplicable(SNode node) {
    return SNodeOperations.isInstanceOf(SNodeOperations.getParent(node, null, false, false), "jetbrains.mps.baseLanguage.structure.Interface") && SNodeOperations.hasRole(node, "jetbrains.mps.baseLanguage.structure.Interface", "method");
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    List<SNode> implementorsAndAncestorsList = new ArrayList<SNode>();
    for(SNode implementor : FindUtils.executeFinder("jetbrains.mps.baseLanguage.findUsages.ImplementingClasses_Finder", SNodeOperations.getParent(node, null, false, false), scope, indicator)) {
      ListSequence.fromList(implementorsAndAncestorsList).addElement(implementor);
      ListSequence.fromList(implementorsAndAncestorsList).addSequence(ListSequence.fromList(FindUtils.executeFinder("jetbrains.mps.baseLanguage.findUsages.ClassAncestors_Finder", implementor, scope, indicator)));
    }
    // 
    Set<SNode> implementorsAndAncestorsNodes = new HashSet<SNode>();
    for(SNode implementorOrAncestor : implementorsAndAncestorsList) {
      implementorsAndAncestorsNodes.add(implementorOrAncestor);
    }
    // 
    for(SNode classNode : implementorsAndAncestorsNodes) {
      for(SNode sMethod : SLinkOperations.getTargets(classNode, "method", true)) {
        if (BaseMethodDeclaration_Behavior.call_hasSameSignature_1204901126405(sMethod, node)) {
          ListOperations.addElement(_results, sMethod);
        }
      }
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListOperations.addElement(_results, node);
  }

  public String getNodeCategory(SNode node) {
    return "Method Implementation";
  }

  @Nullable()
  public String getNodePresentation(SNode node) {
    return null;
  }

}
