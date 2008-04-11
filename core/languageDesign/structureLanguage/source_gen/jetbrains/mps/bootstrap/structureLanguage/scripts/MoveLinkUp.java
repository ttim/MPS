package jetbrains.mps.bootstrap.structureLanguage.scripts;

/*Generated by MPS */

import jetbrains.mps.refactoring.framework.AbstractLoggableRefactoring;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.core.scripts.MoveNodes;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.action.ActionContext;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.ide.findusages.model.result.SearchResults;
import jetbrains.mps.ide.findusages.model.searchquery.SearchQuery;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.ide.findusages.findalgorithm.resultproviders.TreeBuilder;
import jetbrains.mps.bootstrap.structureLanguage.findUsages.NodeAndDescendantsUsages_Finder;
import jetbrains.mps.ide.IDEProjectFrame;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import java.util.Map;
import jetbrains.mps.project.IModule;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import java.util.HashMap;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.ArrayList;
import jetbrains.mps.refactoring.framework.IChooseComponent;
import jetbrains.mps.refactoring.framework.HierarchicalChooseNodeComponent;
import jetbrains.mps.refactoring.framework.ConceptAncestorsProvider;
import jetbrains.mps.refactoring.framework.ChooseRefactoringInputDataDialog;

public class MoveLinkUp extends AbstractLoggableRefactoring {
  public static final String targetConcept = "targetConcept";

  private Set<String> myTransientParameters = new HashSet<String>();

  public  MoveLinkUp() {
    this.myTransientParameters.add("targetConcept");
  }

  public static String getKeyStroke_static() {
    return MoveNodes.getKeyStroke_static();
  }

  public static Class getClass_static() {
    return MoveLinkUp.class;
  }

  public static boolean isApplicableWRTConcept_static(SNode node) {
    if (SModelUtil_new.isAssignableConcept(((AbstractConceptDeclaration)SNodeOperations.getAdapter(SNodeOperations.getConceptDeclaration(node))), "jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration")) {
      return true;
    } else
    {
      return MoveNodes.isApplicableWRTConcept_static(node);
    }
  }


  public String getUserFriendlyName() {
    return "Move Link Up";
  }

  public Set<String> getTransientParameters() {
    return new HashSet<String>(this.myTransientParameters);
  }

  public String getKeyStroke() {
    return MoveLinkUp.getKeyStroke_static();
  }

  public boolean isApplicableWRTConcept(SNode node) {
    return MoveLinkUp.isApplicableWRTConcept_static(node);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration";
  }

  public Class getOverridenRefactoringClass() {
    return MoveNodes.getClass_static();
  }

  public boolean isApplicable(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      SNode node = actionContext.getNode();
      if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration"))) {
        return false;
      }
      SNode concept = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration", false, false);
      if (concept == null) {
        return false;
      }
      return ((SNode)refactoringContext.getParameter("targetConcept")) != concept && SConceptOperations.isSuperConceptOf(((SNode)refactoringContext.getParameter("targetConcept")), NameUtil.nodeFQName(concept));
    }
  }

  public boolean showsAffectedNodes() {
    return true;
  }

  public SearchResults getAffectedNodes(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      SNode node = actionContext.getNode();
      SearchQuery searchQuery = new SearchQuery(new SNodePointer(node), GlobalScope.getInstance());
      IResultProvider resultProvider = TreeBuilder.forFinders(new NodeAndDescendantsUsages_Finder());
      IDEProjectFrame projectFrame = (IDEProjectFrame)actionContext.get(IDEProjectFrame.class);
      SearchResults searchResults = resultProvider.getResults(searchQuery, projectFrame.createAdaptiveProgressMonitor());
      return searchResults;
    }
  }

  public void doRefactor(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      SNode linkDeclaration = (SNode)actionContext.getNode();
      refactoringContext.moveNodeToNode(linkDeclaration, linkDeclaration.getRole_(), ((SNode)refactoringContext.getParameter("targetConcept")));
      refactoringContext.changeFeatureName(linkDeclaration, SNodeOperations.getModel(((SNode)refactoringContext.getParameter("targetConcept"))) + "." + SPropertyOperations.getString(((SNode)refactoringContext.getParameter("targetConcept")), "name"), SPropertyOperations.getString(linkDeclaration, "role"));
    }
  }

  public Map<IModule, List<SModel>> getModelsToGenerate(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      Map<IModule, List<SModel>> result = new HashMap<IModule, List<SModel>>();
      SModel model = actionContext.getNode().getModel();
      SModel targetModel = SNodeOperations.getModel(((SNode)refactoringContext.getParameter("targetConcept")));
      Language language = Language.getLanguageFor(model.getModelDescriptor());
      Language targetLanguage = Language.getLanguageFor(targetModel.getModelDescriptor());
      if (language != null) {
        List<SModel> aspectList = SequenceOperations.toList(SequenceOperations.select(((List<SModelDescriptor>)new ArrayList<SModelDescriptor>(language.getAspectModelDescriptors())), new zSelector4(null, null)));
        result.put(language, aspectList);
      }
      if (targetLanguage != null && targetLanguage != language) {
        List<SModel> aspectList = SequenceOperations.toList(SequenceOperations.select(((List<SModelDescriptor>)new ArrayList<SModelDescriptor>(targetLanguage.getAspectModelDescriptors())), new zSelector6(null, null)));
        result.put(targetLanguage, aspectList);
      }
      return result;
    }
  }

  public void updateModel(SModel model, RefactoringContext refactoringContext) {
    refactoringContext.updateModelWithMaps(model);
  }

  public boolean doesUpdateModel() {
    return true;
  }

  public IChooseComponent<SNode> targetConcept_componentCreator(ActionContext actionContext) {
    SNode node = actionContext.getNode();
    SNode abstractConceptDeclaration = SNodeOperations.getAncestor(node, "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration", false, false);
    return new HierarchicalChooseNodeComponent("choose target concept", "targetConcept", actionContext, new ConceptAncestorsProvider(), abstractConceptDeclaration);
  }

  public boolean askForInfo(ActionContext actionContext, RefactoringContext refactoringContext) {
    {
      boolean result = false;
      List<IChooseComponent> components = new ArrayList<IChooseComponent>();
      {
        IChooseComponent<SNode> chooseComponent;
        chooseComponent = this.targetConcept_componentCreator(actionContext);
        chooseComponent.setPropertyName("targetConcept");
        components.add(chooseComponent);
      }
      ChooseRefactoringInputDataDialog dialog = new ChooseRefactoringInputDataDialog(this, actionContext, refactoringContext, components);
      dialog.showDialog();
      result = dialog.getResult();
      return result;
    }
  }

}
