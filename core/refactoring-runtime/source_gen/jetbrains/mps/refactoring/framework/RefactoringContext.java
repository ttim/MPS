package jetbrains.mps.refactoring.framework;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.refactoring.StructureModification;
import java.util.Map;
import java.util.HashMap;
import jetbrains.mps.findUsages.UsagesList;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.project.Project;
import jetbrains.mps.project.IModule;
import jetbrains.mps.refactoring.StructureModificationData;
import jetbrains.mps.smodel.SNodeId;
import java.util.Collection;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.DefaultSModelDescriptor;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.HackSNodeUtil;
import jetbrains.mps.smodel.LanguageHierarchyCache;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.smodel.StaticReference;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.structure.modules.ModuleReference;
import java.lang.reflect.Constructor;
import jetbrains.mps.project.ProjectOperationContext;

public class RefactoringContext {
  private static final Logger LOG = Logger.getLogger(RefactoringContext.class);

  private IRefactoring myRefactoring;
  private StructureModification myLoggedData = new StructureModification();
  private Map<String, Object> myParametersMap = new HashMap<String, Object>();
  private UsagesList myUsages;
  private Set<String> myTransientParameters = new HashSet<String>();
  private boolean myIsLocal = false;
  private boolean myDoesGenerateModels = true;
  private SModelDescriptor mySelectedModel;
  private SNode mySelectedNode;
  private List<SNode> mySelectedNodes = new ArrayList<SNode>();
  private IOperationContext myCurrentOperationContext;
  private IScope myCurrentScope;
  private Project mySelectedProject;
  private IModule mySelectedModule;
  private List<SModelDescriptor> mySelectedModels;
  private List<IModule> mySelectedModules;
  private Map<StructureModificationData.ConceptFeature, StructureModificationData.ConceptFeature> myConceptFeatureMap = new HashMap<StructureModificationData.ConceptFeature, StructureModificationData.ConceptFeature>();
  private Map<StructureModificationData.FullNodeId, StructureModificationData.FullNodeId> myMoveMap = new HashMap<StructureModificationData.FullNodeId, StructureModificationData.FullNodeId>();
  private Map<String, Set<StructureModificationData.ConceptFeature>> myFQNamesToConceptFeaturesCache = new HashMap<String, Set<StructureModificationData.ConceptFeature>>();
  private Map<SNodeId, Set<StructureModificationData.FullNodeId>> myNodeIdsToFullNodeIdsCache = new HashMap<SNodeId, Set<StructureModificationData.FullNodeId>>();
  private boolean myCachesAreUpToDate = false;

  public RefactoringContext(IRefactoring refactoring) {
    setRefactoring(refactoring);
  }

  public StructureModification getStructureModification() {
    return myLoggedData;
  }

  public void addAdditionalParameters(Map<String, Object> parameters) {
    myParametersMap.putAll(parameters);
  }

  public Map<String, Object> getAdditionalParameters() {
    return new HashMap<String, Object>(myParametersMap);
  }

  public void markTransient(String parameterName) {
    myTransientParameters.add(parameterName);
  }

  public void markTransient(Collection<String> parameterNames) {
    myTransientParameters.addAll(parameterNames);
  }

  public boolean isTransient(String parameterName) {
    return myTransientParameters.contains(parameterName);
  }

  public Object getParameter(String parameterName) {
    return myParametersMap.get(parameterName);
  }

  public void setParameter(String parameterName, Object parameter) {
    myParametersMap.put(parameterName, parameter);
  }

  public void setParameters(List<Object> names, List<Object> parameters) {
    Iterator<Object> name_it = ListSequence.fromList(names).iterator();
    Iterator<Object> param_it = ListSequence.fromList(parameters).iterator();
    Object name_var;
    Object param_var;
    while (name_it.hasNext() && param_it.hasNext()) {
      name_var = name_it.next();
      param_var = param_it.next();
      setParameter((String) name_var, param_var);
    }
  }

  public void clearParameters() {
    myParametersMap.clear();
  }

  @Nullable
  public UsagesList getUsages() {
    return myUsages;
  }

  public void setUsages(UsagesList usages) {
    myUsages = usages;
  }

  public boolean isLocal() {
    return myIsLocal;
  }

  public void setLocal(boolean local) {
    myIsLocal = local;
  }

  public List<SModel> getModelsFromUsages(SModel firstModel) {
    List<SModel> result = new ArrayList<SModel>();
    if (firstModel != null) {
      result.add(firstModel);
    }
    if (myUsages != null) {
      for (SModel m : myUsages.getAffectedModels()) {
        if (m != firstModel) {
          result.add(m);
        }
      }
    }
    return result;
  }

  public SNode moveNodeToNode(SNode sourceNode, String role, SNode targetNode) {
    List<SNode> nodes = new ArrayList<SNode>();
    nodes.add(sourceNode);
    List<SNode> result = moveNodesToNode(nodes, role, targetNode);
    return result.get(0);
  }

  public List<SNode> moveNodesToNode(List<SNode> sourceNodes, String role, SNode targetNode) {
    HashMap<SNode, SNode> mapping = new HashMap<SNode, SNode>();
    List<SNode> targetNodes = CopyUtil.copy(sourceNodes, mapping);
    for (SNode node : targetNodes) {
      targetNode.addChild(role, node);
    }
    SNode oldParent = null;
    for (SNode node : sourceNodes) {
      if (oldParent == null) {
        oldParent = node.getParent();
      } else {
        assert node.getParent() == oldParent;
      }
    }
    for (SNode key : mapping.keySet()) {
      SNode target = mapping.get(key);
      myMoveMap.put(new StructureModificationData.FullNodeId(key), new StructureModificationData.FullNodeId(target));
      myCachesAreUpToDate = false;

      ListSequence.fromList(myLoggedData.getData()).addElement(new StructureModification.MoveNode(new SNodePointer(key), new SNodePointer(target)));
    }
    for (SNode node : sourceNodes) {
      node.delete();
    }
    return targetNodes;
  }

  public void replaceRefsToNodeWithNode(SNode whatNode, SNode withNode) {
    myMoveMap.put(new StructureModificationData.FullNodeId(whatNode), new StructureModificationData.FullNodeId(withNode));
    myCachesAreUpToDate = false;

    ListSequence.fromList(myLoggedData.getData()).addElement(new StructureModification.MoveNode(new SNodePointer(whatNode), new SNodePointer(withNode)));
    whatNode.delete();
  }

  public SNode moveNodeToModel(SNode sourceNode, SModel targetModel) {
    List<SNode> nodes = new ArrayList<SNode>();
    nodes.add(sourceNode);
    List<SNode> result = moveNodesToModel(nodes, targetModel);
    return result.get(0);
  }

  public List<SNode> moveNodesToModel(List<SNode> sourceNodes, SModel targetModel) {
    if (sourceNodes.isEmpty()) {
      return new ArrayList<SNode>();
    }
    HashMap<SNode, SNode> mapping = new HashMap<SNode, SNode>();
    List<SNode> targetNodes = CopyUtil.copy(sourceNodes, mapping);
    for (SNode node : targetNodes) {
      targetModel.addRoot(node);
    }
    for (SNode key : mapping.keySet()) {
      SNode target = mapping.get(key);
      myMoveMap.put(new StructureModificationData.FullNodeId(key), new StructureModificationData.FullNodeId(target));
      myCachesAreUpToDate = false;

      ListSequence.fromList(myLoggedData.getData()).addElement(new StructureModification.MoveNode(new SNodePointer(key), new SNodePointer(target)));
    }
    for (SNode node : sourceNodes) {
      node.delete();
    }
    SModelOperations.validateLanguagesAndImports(targetModel, true, true);
    return targetNodes;
  }

  public void deleteFeature(SNode feature) {
    doChangeFeatureName(feature, null, null, true);
  }

  public void changeFeatureName(SNode feature, @Nullable String newConceptFQName, @Nullable String newFeatureName) {
    doChangeFeatureName(feature, newConceptFQName, newFeatureName, false);
  }

  private void doChangeFeatureName(SNode feature, @Nullable String newConceptFQName, @Nullable String newFeatureName, boolean delete) {
    String oldConceptFQName = "";
    String oldFeatureName = "";
    StructureModificationData.ConceptFeatureKind kind = StructureModificationData.ConceptFeatureKind.NONE;
    StructureModification.RenameNode.RenameType renameType = null;
    if (SNodeOperations.isInstanceOf(feature, "jetbrains.mps.lang.structure.structure.LinkDeclaration")) {
      SNode linkDeclaration = SNodeOperations.cast(feature, "jetbrains.mps.lang.structure.structure.LinkDeclaration");
      oldConceptFQName = NameUtil.nodeFQName(SNodeOperations.getParent(linkDeclaration));
      oldFeatureName = SPropertyOperations.getString(linkDeclaration, "role");
      if (SPropertyOperations.hasValue(linkDeclaration, "metaClass", "aggregation", "reference")) {
        kind = StructureModificationData.ConceptFeatureKind.CHILD;
        renameType = StructureModification.RenameNode.RenameType.CHILD;
      } else {
        kind = StructureModificationData.ConceptFeatureKind.REFERENCE;
        renameType = StructureModification.RenameNode.RenameType.REFERENCE;
      }
      if (delete) {
        SNodeOperations.deleteNode(linkDeclaration);
      } else {
        if (newFeatureName != null && !(newFeatureName.equals(oldFeatureName))) {
          SPropertyOperations.set(linkDeclaration, "role", newFeatureName);
        }
      }
    }
    if (SNodeOperations.isInstanceOf(feature, "jetbrains.mps.lang.structure.structure.PropertyDeclaration")) {
      oldConceptFQName = NameUtil.nodeFQName(SNodeOperations.getParent(feature));
      oldFeatureName = feature.getName();
      kind = StructureModificationData.ConceptFeatureKind.PROPERTY;
      renameType = StructureModification.RenameNode.RenameType.PROPERTY;
      if (delete) {
        SNodeOperations.deleteNode(feature);
      } else {
        if (newFeatureName != null && !(newFeatureName.equals(oldFeatureName))) {
          feature.setName(newFeatureName);
        }
      }
    }
    if (SNodeOperations.isInstanceOf(feature, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration")) {
      oldConceptFQName = NameUtil.nodeFQName(feature);
      oldFeatureName = feature.getName();
      kind = StructureModificationData.ConceptFeatureKind.CONCEPT;
      renameType = StructureModification.RenameNode.RenameType.CONCEPT;
      if (delete) {
        SNodeOperations.deleteNode(feature);
      } else {
        if (newFeatureName != null && !(newFeatureName.equals(oldFeatureName))) {
          feature.setName(newFeatureName);
        }
      }
    }
    if (kind != StructureModificationData.ConceptFeatureKind.NONE) {
      myConceptFeatureMap.put(new StructureModificationData.ConceptFeature(oldConceptFQName, kind, oldFeatureName), (delete ?
        null :
        new StructureModificationData.ConceptFeature(newConceptFQName, kind, newFeatureName)
      ));
      myCachesAreUpToDate = false;
      if (newFeatureName == null) {
        return;
      }

      if (!(newFeatureName.equals(oldFeatureName))) {
        ListSequence.fromList(myLoggedData.getData()).addElement(new StructureModification.RenameNode(new SNodePointer(feature), renameType, newFeatureName, oldFeatureName));
      } else
      if (kind == StructureModificationData.ConceptFeatureKind.CONCEPT && !(oldConceptFQName.equals(newConceptFQName))) {
      }
    }
  }

  public void changeModelName(DefaultSModelDescriptor model, String newName) {
    if (LanguageAspect.STRUCTURE.is(model)) {
      for (SNode concept : ListSequence.fromList(jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.getNodes(((SModel) model.getSModel()), "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"))) {
        this.changeFeatureName(concept, NameUtil.longNameFromNamespaceAndShortName(newName, SPropertyOperations.getString(concept, "name")), SPropertyOperations.getString(concept, "name"));
      }
    }

    SModelReference oldModelRef = model.getSModelReference();
    model.rename(SModelFqName.fromString(newName), false);
    ListSequence.fromList(myLoggedData.getData()).addElement(new StructureModification.RenameModel(oldModelRef, model.getSModelReference()));
  }

  public void updateByDefault(SModel model) {
    updateModelWithMaps(model);
  }

  public void computeCaches() {
    myFQNamesToConceptFeaturesCache.clear();
    myNodeIdsToFullNodeIdsCache.clear();
    for (StructureModificationData.FullNodeId fullNodeId : myMoveMap.keySet()) {
      SNodeId nodeId = fullNodeId.getNodeId();
      Set<StructureModificationData.FullNodeId> ids = myNodeIdsToFullNodeIdsCache.get(nodeId);
      if (ids == null) {
        ids = new HashSet<StructureModificationData.FullNodeId>();
        myNodeIdsToFullNodeIdsCache.put(nodeId, ids);
      }
      ids.add(fullNodeId);
    }
    for (StructureModificationData.ConceptFeature conceptFeature : myConceptFeatureMap.keySet()) {
      String conceptFQName = conceptFeature.getConceptFQName();
      Set<StructureModificationData.ConceptFeature> conceptFeatures = myFQNamesToConceptFeaturesCache.get(conceptFQName);
      if (conceptFeatures == null) {
        conceptFeatures = new HashSet<StructureModificationData.ConceptFeature>();
        myFQNamesToConceptFeaturesCache.put(conceptFQName, conceptFeatures);
      }
      conceptFeatures.add(conceptFeature);
    }
    myCachesAreUpToDate = true;
  }

  public void updateModelWithMaps(SModel model) {
    if (!(myCachesAreUpToDate)) {
      computeCaches();
    }

    for (SNode node : model.nodes()) {
      String conceptFQName = node.getConceptFqName();
      Set<StructureModificationData.ConceptFeature> exactConceptFeatures = myFQNamesToConceptFeaturesCache.get(conceptFQName);
      if (exactConceptFeatures != null) {
        for (StructureModificationData.ConceptFeature conceptFeature : exactConceptFeatures) {
          StructureModificationData.ConceptFeature newConceptFeature = myConceptFeatureMap.get(conceptFeature);
          StructureModificationData.ConceptFeatureKind kind = conceptFeature.getConceptFeatureKind();
          if (kind == StructureModificationData.ConceptFeatureKind.CONCEPT) {
            if (newConceptFeature == null) {
              node.delete();
            } else {
              String newConceptFQName = newConceptFeature.getConceptFQName();
              HackSNodeUtil.setConceptFqName(node, newConceptFQName);
            }
          }
        }
      }
      Set<StructureModificationData.ConceptFeature> allConceptFeatures = new HashSet<StructureModificationData.ConceptFeature>();
      if (exactConceptFeatures != null) {
        allConceptFeatures.addAll(exactConceptFeatures);
      }
      for (String parentConceptFQName : LanguageHierarchyCache.getAncestorsNames(conceptFQName)) {
        Set<StructureModificationData.ConceptFeature> conceptFeatures = myFQNamesToConceptFeaturesCache.get(parentConceptFQName);
        if (conceptFeatures != null) {
          allConceptFeatures.addAll(conceptFeatures);
        }
      }
      for (StructureModificationData.ConceptFeature conceptFeature : allConceptFeatures) {
        StructureModificationData.ConceptFeature newConceptFeature = myConceptFeatureMap.get(conceptFeature);
        boolean delete = newConceptFeature == null;
        StructureModificationData.ConceptFeatureKind kind = conceptFeature.getConceptFeatureKind();
        if (kind == StructureModificationData.ConceptFeatureKind.REFERENCE) {
          String oldRole = conceptFeature.getFeatureName();
          String newRole = null;
          if (!(delete)) {
            newRole = newConceptFeature.getFeatureName();
          }
          for (SReference reference : node.getReferences()) {
            if (reference.getRole().equals(oldRole)) {
              if (delete) {
                node.removeReference(reference);
              } else {
                reference.setRole(newRole);
              }
            }
          }
          for (SNode linkAttribute : AttributeOperations.getLinkAttributeForLinkRole(node, oldRole)) {
            if (delete) {
              linkAttribute.delete();
            } else {
              String linkAttributeRole = AttributesRolesUtil.getFeatureAttributeRoleFromChildRole(linkAttribute.getRole_());
              linkAttribute.setRoleInParent(AttributesRolesUtil.childRoleFromLinkAttributeRole(linkAttributeRole, newRole));
            }
          }
        }
        if (kind == StructureModificationData.ConceptFeatureKind.CHILD) {
          String oldRole = conceptFeature.getFeatureName();
          String newRole = null;
          if (!(delete)) {
            newRole = newConceptFeature.getFeatureName();
          }
          for (SNode child : new ArrayList<SNode>(node.getChildren())) {
            String childRole = child.getRole_();
            if (childRole != null && childRole.equals(oldRole)) {
              if (delete) {
                child.delete();
              } else {
                child.setRoleInParent(newRole);
              }
            }
          }
        }
        if (kind == StructureModificationData.ConceptFeatureKind.PROPERTY) {
          String oldName = conceptFeature.getFeatureName();
          String newName = null;
          if (!(delete)) {
            newName = newConceptFeature.getFeatureName();
            HackSNodeUtil.changePropertyName(node, oldName, newName);
          } else {
            node.setProperty(oldName, null, false);
          }
          for (SNode propertyAttribute : AttributeOperations.getPropertyAttributeForPropertyName(node, oldName)) {
            if (delete) {
              propertyAttribute.delete();
            } else {
              String propertyAttributeRole = AttributesRolesUtil.getFeatureAttributeRoleFromChildRole(propertyAttribute.getRole_());
              propertyAttribute.setRoleInParent(AttributesRolesUtil.childRoleFromPropertyAttributeRole(propertyAttributeRole, newName));
            }
          }
        }
      }
      for (SReference reference : node.getReferences()) {
        if (reference instanceof StaticReference) {
          StaticReference staticReference = (StaticReference) reference;
          SNodeId id = staticReference.getTargetNodeId();
          Set<StructureModificationData.FullNodeId> ids = myNodeIdsToFullNodeIdsCache.get(id);
          if (ids != null) {
            for (StructureModificationData.FullNodeId fullNodeId : ids) {
              StructureModificationData.FullNodeId newFullNodeId = myMoveMap.get(fullNodeId);
              if (fullNodeId.getModelUID().equals(staticReference.getTargetSModelReference())) {
                staticReference.setTargetSModelReference(newFullNodeId.getModelUID());
                staticReference.setTargetNodeId(newFullNodeId.getNodeId());
              }
            }
          }
        }
      }
    }
    SModelOperations.validateLanguagesAndImports(model, true, true);
  }

  public void setUpMembersAccessModifier(RefactoringNodeMembersAccessModifier modifier) {
    for (StructureModification.Entry entry : myLoggedData.getData()) {
      if (!((entry instanceof StructureModification.RenameNode))) {
        continue;
      }
      StructureModification.RenameNode data = (StructureModification.RenameNode) entry;
      if (data.type == StructureModification.RenameNode.RenameType.CONCEPT) {
        continue;
      }
      SNode oldNode = data.oldID.getNode();
      if (oldNode == null || oldNode.getParent() == null) {
        continue;
      }
      String conceptFQName = oldNode.getParent().getConceptFqName();
      switch (data.type) {
        case CHILD:
          modifier.addChildRoleChange(conceptFQName, data.oldValue, data.newValue);
          break;
        case REFERENCE:
          modifier.addReferentRoleChange(conceptFQName, data.oldValue, data.newValue);
          break;
        case PROPERTY:
          modifier.addPropertyNameChange(conceptFQName, data.oldValue, data.newValue);
          break;
        default:
      }
    }
  }

  public void setRefactoring(IRefactoring refactoring) {
    myRefactoring = refactoring;
  }

  public IRefactoring getRefactoring() {
    return myRefactoring;
  }

  public SNode getSelectedNode() {
    return mySelectedNode;
  }

  public void setSelectedNode(SNode selectedNode) {
    mySelectedNode = selectedNode;
  }

  public List<SNode> getSelectedNodes() {
    return new ArrayList<SNode>(mySelectedNodes);
  }

  public void setSelectedNodes(List<SNode> selectedNodes) {
    mySelectedNodes = selectedNodes;
  }

  public SModelDescriptor getSelectedModel() {
    return mySelectedModel;
  }

  public void setSelectedModel(SModelDescriptor selectedModel) {
    mySelectedModel = selectedModel;
  }

  public List<SModelDescriptor> getSelectedModels() {
    return mySelectedModels;
  }

  public void setSelectedModels(List<SModelDescriptor> selectedModels) {
    mySelectedModels = selectedModels;
  }

  public IModule getSelectedModule() {
    return mySelectedModule;
  }

  public void setSelectedModule(IModule selectedModule) {
    mySelectedModule = selectedModule;
  }

  public List<IModule> getSelectedModules() {
    return mySelectedModules;
  }

  public void setSelectedModules(List<IModule> modules) {
    mySelectedModules = modules;
  }

  public void setSelectedProject(Project selectedProject) {
    mySelectedProject = selectedProject;
  }

  public void setCurrentScope(IScope currentScope) {
    myCurrentScope = currentScope;
  }

  public void setCurrentOperationContext(IOperationContext currentOperationContext) {
    myCurrentOperationContext = currentOperationContext;
  }

  public Project getSelectedProject() {
    return mySelectedProject;
  }

  public IScope getCurrentScope() {
    return myCurrentScope;
  }

  public IOperationContext getCurrentOperationContext() {
    return myCurrentOperationContext;
  }

  public void setDoesGenerateModels(boolean b) {
    myDoesGenerateModels = b;
  }

  public boolean getDoesGenerateModels() {
    return myDoesGenerateModels;
  }

  private void setTarget(Object target) {
    IRefactoringTarget refTarget = myRefactoring.getRefactoringTarget();
    if (!(refTarget.allowMultipleTargets())) {
      switch (myRefactoring.getRefactoringTarget().getTarget()) {
        case NODE:
          setSelectedNode((SNode) target);
          break;
        case MODEL:
          setSelectedModel(((SModel) target).getModelDescriptor());
          break;
        case MODULE:
          setSelectedModule((IModule) target);
          break;
        default:
          throw new IllegalArgumentException("Wrong refactoring type " + refTarget.getTarget().getClass().getName());
      }
    } else {
      switch (myRefactoring.getRefactoringTarget().getTarget()) {
        case NODE:
          setSelectedNodes((List) target);
          break;
        case MODEL:
          setSelectedModels((List) target);
          break;
        case MODULE:
          setSelectedModules((List) target);
          break;
        default:
          throw new IllegalArgumentException("Wrong refactoring type " + refTarget.getTarget().getClass().getName());
      }
    }
  }

  private static String getRefactoringClassName(IRefactoring refactoring) {
    if (refactoring instanceof OldRefactoringAdapter) {
      return ((OldRefactoringAdapter) refactoring).getRefactoringClassName();
    }
    return refactoring.getClass().getName();
  }

  private static IRefactoring getRefactoring(String className) {
    IRefactoring result = null;
    try {
      String namespace = NameUtil.namespaceFromLongName(NameUtil.namespaceFromLongName(className));
      Language l = MPSModuleRepository.getInstance().getLanguage(namespace);
      if (l == null) {
        l = MPSModuleRepository.getInstance().getLanguage(ModuleReference.fromString("3ecd7c84-cde3-45de-886c-135ecc69b742(jetbrains.mps.lang.refactoring)"));
      }
      if (l == null) {
        LOG.errorWithTrace("can't find a language " + namespace);
      } else {
        Class refactoringClass = l.getClass(className);
        if (refactoringClass == null) {
          LOG.errorWithTrace("can't find a class " + className + " in a language " + namespace);
        } else {
          Constructor constructor = refactoringClass.getConstructor();
          Object refactoring = constructor.newInstance();
          if (refactoring instanceof AbstractLoggableRefactoring) {
            result = OldRefactoringAdapter.createAdapterFor(((AbstractLoggableRefactoring) refactoring));
          } else {
            result = (IRefactoring) refactoring;
          }
          if (!((result instanceof ILoggableRefactoring))) {
            LOG.error("Non-loggable refactoring was logged: " + result.getUserFriendlyName());
          }
        }
      }
    } catch (Throwable t) {
      LOG.error(t);
    }
    if (result == null) {
      LOG.error("refactoring for " + className + " was not loaded");
    }
    return result;
  }

  public static RefactoringContext createRefactoringContext(IRefactoring refactoring, List names, List parameters, Object target, Project project) {

    RefactoringContext result = new RefactoringContext(refactoring);
    result.setSelectedProject(project);
    result.setCurrentOperationContext(new ProjectOperationContext(project));

    result.setParameters(names, parameters);
    result.setTarget(target);
    return result;
  }
}
