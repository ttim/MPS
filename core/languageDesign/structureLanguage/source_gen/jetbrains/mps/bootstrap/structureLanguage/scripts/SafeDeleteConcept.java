package jetbrains.mps.bootstrap.structureLanguage.scripts;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.AbstractLoggableRefactoring;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.core.scripts.SafeDelete;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.action.ActionContext;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.ide.findusages.model.result.SearchResults;
import jetbrains.mps.ide.findusages.model.searchquery.SearchQuery;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.ide.findusages.findalgorithm.resultproviders.TreeBuilder;
import jetbrains.mps.bootstrap.structureLanguage.findUsages.ConceptInstances_Finder;
import jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeAndDescendantsUsages_Finder;
import jetbrains.mps.ide.IDEProjectFrame;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration;
import jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior;
import java.util.List;
import jetbrains.mps.ide.findusages.model.result.SearchResult;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModel;
import java.util.HashMap;
import java.util.ArrayList;

public class SafeDeleteConcept extends AbstractLoggableRefactoring {
  public static final String sourceLanguage = "sourceLanguage";
  public static final String conceptBehavior = "conceptBehavior";
  public static final String conceptEditorDeclaration = "conceptEditorDeclaration";

  private Set<String> myTransientParameters = new HashSet<String>();

  public  SafeDeleteConcept() {
    this.myTransientParameters.add("sourceLanguage");
    this.myTransientParameters.add("conceptBehavior");
    this.myTransientParameters.add("conceptEditorDeclaration");
  }

  public static String getKeyStroke_static() {
    return SafeDelete.getKeyStroke_static();
  }

  public static Class getClass_static() {
    return SafeDeleteConcept.class;
  }

  public static boolean isApplicableWRTConcept_static(SNode node) {
    if(SModelUtil_new.isAssignableConcept(((AbstractConceptDeclaration)SNodeOperations.getAdapter(SNodeOperations.getConceptDeclaration(node))), "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration")) {
      return true;
    } else
    {
      return SafeDelete.isApplicableWRTConcept_static(node);
    }
  }


  public String getUserFriendlyName() {
    return "Safe Delete Concept";
  }

  public Set<String> getTransientParameters() {
    return new HashSet<String>(this.myTransientParameters);
  }

  public String getKeyStroke() {
    return SafeDeleteConcept.getKeyStroke_static();
  }

  public boolean isApplicableWRTConcept(SNode node) {
    return SafeDeleteConcept.isApplicableWRTConcept_static(node);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration";
  }

  public Class getOverridenRefactoringClass() {
    return SafeDelete.getClass_static();
  }

  public boolean isApplicable(ActionContext actionContext, RefactoringContext refactoringContext) {
    return true;
  }

  public boolean showsAffectedNodes() {
    return true;
  }

  public SearchResults getAffectedNodes(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      SNode node = actionContext.getNode();
      SearchQuery searchQuery = new SearchQuery(new SNodePointer(node), actionContext.getScope());
      IResultProvider resultProvider = TreeBuilder.forFinders(new ConceptInstances_Finder(), new NodeAndDescendantsUsages_Finder());
      IDEProjectFrame projectFrame = (IDEProjectFrame)actionContext.get(IDEProjectFrame.class);
      SearchResults searchResults = resultProvider.getResults(searchQuery, projectFrame.createAdaptiveProgressMonitor());
      refactoringContext.setParameter("sourceLanguage", Language.getLanguageFor(SNodeOperations.getModel(node).getModelDescriptor()));
      if(((Language)refactoringContext.getParameter("sourceLanguage")) != null) {
        SModelDescriptor editorModelDescriptor = ((Language)refactoringContext.getParameter("sourceLanguage")).getEditorModelDescriptor();
        if(editorModelDescriptor != null) {
          refactoringContext.setParameter("conceptEditorDeclaration", SModelUtil_new.findEditorDeclaration(editorModelDescriptor.getSModel(), ((ConceptDeclaration)SNodeOperations.getAdapter(node))));
          searchResults.remove(((ConceptEditorDeclaration)refactoringContext.getParameter("conceptEditorDeclaration")).getNode());
        }
        SModelDescriptor constraintsModelDescriptor = ((Language)refactoringContext.getParameter("sourceLanguage")).getConstraintsModelDescriptor();
        if(constraintsModelDescriptor != null) {
          refactoringContext.setParameter("conceptBehavior", SModelUtil_new.findBehaviorDeclaration(constraintsModelDescriptor.getSModel(), ((ConceptDeclaration)SNodeOperations.getAdapter(node))));
          searchResults.remove(((ConceptBehavior)refactoringContext.getParameter("conceptBehavior")).getNode());
        }
      }
      List<SearchResult> aliveResults = searchResults.getAliveResults();
      if(!(aliveResults.isEmpty())) {
        return searchResults;
      }
      return null;
    }
  }

  public void doRefactor(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      SNode node = actionContext.getNode();
      if(((ConceptBehavior)refactoringContext.getParameter("conceptBehavior")) != null) {
        ((ConceptBehavior)refactoringContext.getParameter("conceptBehavior")).delete();
      }
      if(((ConceptEditorDeclaration)refactoringContext.getParameter("conceptEditorDeclaration")) != null) {
        ((ConceptEditorDeclaration)refactoringContext.getParameter("conceptEditorDeclaration")).delete();
      }
      SNodeOperations.deleteNode(node);
    }
  }

  public Map<IModule, List<SModel>> getModelsToGenerate(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      Map<IModule, List<SModel>> result = new HashMap<IModule, List<SModel>>();
      if(((Language)refactoringContext.getParameter("sourceLanguage")) == null) {
        return result;
      }
      ArrayList<SModel> list = new ArrayList<SModel>();
      result.put(((Language)refactoringContext.getParameter("sourceLanguage")), list);
      list.add(((Language)refactoringContext.getParameter("sourceLanguage")).getStructureModelDescriptor().getSModel());
      SModelDescriptor editorModelDescriptor = ((Language)refactoringContext.getParameter("sourceLanguage")).getEditorModelDescriptor();
      if(editorModelDescriptor != null) {
        list.add(editorModelDescriptor.getSModel());
      }
      SModelDescriptor constraintsModelDescriptor = ((Language)refactoringContext.getParameter("sourceLanguage")).getConstraintsModelDescriptor();
      if(constraintsModelDescriptor != null) {
        list.add(constraintsModelDescriptor.getSModel());
      }
      return result;
    }
  }

  public void updateModel(SModel model, RefactoringContext refactoringContext) {
  }

  public boolean doesUpdateModel() {
    return false;
  }

  public boolean askForInfo(ActionContext actionContext, RefactoringContext refactoringContext) {
    return this.isApplicable(actionContext, refactoringContext);
  }

}
