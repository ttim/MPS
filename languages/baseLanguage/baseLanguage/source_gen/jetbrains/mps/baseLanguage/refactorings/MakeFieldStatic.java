package jetbrains.mps.baseLanguage.refactorings;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.BaseRefactoring;
import jetbrains.mps.refactoring.framework.IRefactoringTarget;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class MakeFieldStatic extends BaseRefactoring {
  public MakeFieldStatic() {
    this.addTransientParameter("declaration");
    this.addTransientParameter("hasExternalUsages");
    this.addTransientParameter("usages");
  }

  public String getUserFriendlyName() {
    return "Make field static";
  }

  public IRefactoringTarget getRefactoringTarget() {
    return new MakeFieldStatic_Target();
  }

  public boolean init(final RefactoringContext refactoringContext) {
    final SNode node = refactoringContext.getSelectedNode();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.FieldDeclaration")) {
          refactoringContext.setParameter("declaration", SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.FieldDeclaration"));
        } else {
          refactoringContext.setParameter("declaration", SNodeOperations.cast(Sequence.fromIterable(SNodeOperations.getReferences(node)).first().getTargetNode(), "jetbrains.mps.baseLanguage.structure.FieldDeclaration"));
        }
        refactoringContext.setParameter("usages", FindUtils.getSearchResults(new EmptyProgressMonitor(), ((SNode) refactoringContext.getParameter("declaration")), GlobalScope.getInstance(), "jetbrains.mps.baseLanguage.findUsages.FieldUsages_Finder"));
        refactoringContext.setParameter("hasExternalUsages", false);
        for (SearchResult<SNode> result : ListSequence.fromList(((SearchResults<SNode>) refactoringContext.getParameter("usages")).getSearchResults())) {
          if (SNodeOperations.getContainingRoot(result.getObject()) != SNodeOperations.getContainingRoot(((SNode) refactoringContext.getParameter("declaration")))) {
            refactoringContext.setParameter("hasExternalUsages", true);
          }
        }
      }
    });
    return true;
  }

  public void refactor(final RefactoringContext refactoringContext) {
    SNode newDeclaration = new MakeFieldStatic.QuotationClass_so6etp_a0a0a3().createNode(SNodeOperations.copyNode(SLinkOperations.getTarget(((SNode) refactoringContext.getParameter("declaration")), "visibility", true)), SNodeOperations.copyNode(SLinkOperations.getTarget(((SNode) refactoringContext.getParameter("declaration")), "type", true)), SPropertyOperations.getString(((SNode) refactoringContext.getParameter("declaration")), "name"));
    SNode declarationClassifier = SNodeOperations.getAncestor(((SNode) refactoringContext.getParameter("declaration")), "jetbrains.mps.baseLanguage.structure.Classifier", false, false);
    ListSequence.fromList(SLinkOperations.getTargets(declarationClassifier, "staticField", true)).addElement(newDeclaration);
    for (SearchResult<SNode> result : ListSequence.fromList(((SearchResults<SNode>) refactoringContext.getParameter("usages")).getSearchResults())) {
      SNode usage = result.getObject();
      SNode replacing;
      if (SNodeOperations.isInstanceOf(usage, "jetbrains.mps.baseLanguage.structure.FieldReferenceOperation")) {
        replacing = SNodeOperations.getParent(usage);
      } else {
        replacing = usage;
      }
      SNode newReference;
      if (SNodeOperations.getAncestor(usage, "jetbrains.mps.baseLanguage.structure.Classifier", false, false) != declarationClassifier) {
        newReference = new MakeFieldStatic.QuotationClass_so6etp_a0a0a4a3a3().createNode(declarationClassifier, newDeclaration);
      } else {
        newReference = new MakeFieldStatic.QuotationClass_so6etp_a0a0a0e0d0d().createNode(newDeclaration);
      }
      SNodeOperations.replaceWithAnother(replacing, newReference);
    }
    SNodeOperations.deleteNode(((SNode) refactoringContext.getParameter("declaration")));
  }

  public SearchResults getAffectedNodes(final RefactoringContext refactoringContext) {
    if (!(((Boolean) refactoringContext.getParameter("hasExternalUsages")))) {
      return null;
    }
    return ((SearchResults<SNode>) refactoringContext.getParameter("usages"));
  }

  public static class QuotationClass_so6etp_a0a0a3 {
    public QuotationClass_so6etp_a0a0a3() {
    }

    public SNode createNode(Object parameter_7, Object parameter_8, Object parameter_9) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        quotedNode1_4.setProperty("name", (String) parameter_9);
        {
          quotedNode_2 = (SNode) parameter_7;
          SNode quotedNode1_5;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_5 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_5 = quotedNode_2;
          }
          if (quotedNode1_5 != null) {
            quotedNode_1.addChild("visibility", HUtil.copyIfNecessary(quotedNode1_5));
          }
        }
        {
          quotedNode_3 = (SNode) parameter_8;
          SNode quotedNode1_6;
          if (_parameterValues_129834374.contains(quotedNode_3)) {
            quotedNode1_6 = HUtil.copyIfNecessary(quotedNode_3);
          } else {
            _parameterValues_129834374.add(quotedNode_3);
            quotedNode1_6 = quotedNode_3;
          }
          if (quotedNode1_6 != null) {
            quotedNode_1.addChild("type", HUtil.copyIfNecessary(quotedNode1_6));
          }
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_so6etp_a0a0a4a3a3 {
    public QuotationClass_so6etp_a0a0a4a3a3() {
    }

    public SNode createNode(Object parameter_3, Object parameter_4) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        quotedNode1_2.setReferent("variableDeclaration", (SNode) parameter_4);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_so6etp_a0a0a0e0d0d {
    public QuotationClass_so6etp_a0a0a0e0d0d() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("variableDeclaration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
