package jetbrains.mps.baseLanguage.findUsages;

/*Generated by MPS */

import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.behavior.BaseMethodDeclaration_Behavior;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;

public class OverridingMethods_Finder extends GeneratedFinder {
  public static Logger LOG = Logger.getLogger("jetbrains.mps.baseLanguage.findUsages.OverridingMethods_Finder");

  public String getDescription() {
    return "Overriding Methods";
  }

  public String getLongDescription() {
    return "";
  }

  public String getConcept() {
    return "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration";
  }

  public boolean isApplicable(SNode node) {
    if (SNodeOperations.getParent(node, null, false, false) == null || !(SNodeOperations.isInstanceOf(SNodeOperations.getParent(node, null, false, false), "jetbrains.mps.baseLanguage.structure.ClassConcept"))) {
      return false;
    }
    if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration")) && !(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration"))) {
      return false;
    }
    return true;
  }

  protected void doFind(SNode node, IScope scope, List<SNode> _results, ProgressIndicator indicator) {
    for(SNode classNode : FindUtils.executeFinder("jetbrains.mps.baseLanguage.findUsages.DerivedClasses_Finder", SNodeOperations.getParent(node, null, false, false), scope, indicator)) {
      Iterable<SNode> methodsOfSameKind;
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration")) {
        methodsOfSameKind = SLinkOperations.getTargets(classNode, "method", true);
      } else
      {
        methodsOfSameKind = SLinkOperations.getTargets(classNode, "staticMethod", true);
      }
      for(SNode sMethod : methodsOfSameKind) {
        if (SPropertyOperations.getString(sMethod, "name").equals(SPropertyOperations.getString(node, "name")) && SLinkOperations.getCount(sMethod, "parameter") == SLinkOperations.getCount(node, "parameter")) {
          if (BaseMethodDeclaration_Behavior.call_hasSameSignature_1213877350435(sMethod, node)) {
            ListOperations.addElement(_results, sMethod);
          }
        }
      }
    }
  }

  public void getSearchedNodes(SNode node, IScope scope, List<SNode> _results) {
    ListOperations.addElement(_results, node);
  }

  public String getNodeCategory(SNode node) {
    return "Overriding Methods";
  }

}
