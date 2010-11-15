/*
 * Copyright 2003-2010 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jetbrains.mps.vcs.diff;

import com.intellij.openapi.util.Pair;
import jetbrains.mps.lang.structure.structure.Cardinality;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.vcs.diff.changes.*;

import java.util.*;

public class Merger {
  private final SModel[] mySourceModels = new SModel[Version.values().length];
  private SModel myResultModel;

  private List<Change> myBaseMineChanges;
  private Map<Change, SNode> myChangeGroups = new HashMap<Change, SNode>();
  private List<Change> myBaseRepoChanges;

  private Set<Change> myExcludedChanges = new HashSet<Change>();
  private Set<Change> myAppliedChanges = new HashSet<Change>();
  private List<Conflict> myConflicts = new ArrayList<Conflict>();
  private List<Warning> myWarnings = new ArrayList<Warning>();
  private Set<Change> myUnresolvedConflictingChanges;
  private Set<Change> myConflictingChanges = new HashSet<Change>();
  private Set<Change> mySymmetricChanges = new HashSet<Change>();
  private boolean myPreviewMode = false;

  public Merger(SModel base, SModel mine, SModel repo) {
    mySourceModels[Version.BASE.ordinal()] = base;
    mySourceModels[Version.MINE.ordinal()] = mine;
    mySourceModels[Version.REPO.ordinal()] = repo;

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        DiffBuilder mineDiffBuilder = new DiffBuilder(getBase(mySourceModels), getMine(mySourceModels));
        myBaseMineChanges = mineDiffBuilder.getChanges();
        myChangeGroups.putAll(mineDiffBuilder.getChangeGroups());
        DiffBuilder repoDiffBuilder = new DiffBuilder(getBase(mySourceModels), getRepo(mySourceModels));
        myBaseRepoChanges = repoDiffBuilder.getChanges();
        myChangeGroups.putAll(repoDiffBuilder.getChangeGroups());
      }
    });
  }

  public SModel getResultModel() {
    return myResultModel;
  }

  public Set<Change> getExcludedChanges() {
    return Collections.unmodifiableSet(myExcludedChanges);
  }

  public List<Warning> getWarnings() {
    return Collections.unmodifiableList(myWarnings);
  }

  public List<Conflict> getConflicts() {
    return Collections.unmodifiableList(myConflicts);
  }

  public List<Conflict> getUnresolvedConflicts() {
    ArrayList<Conflict> result = new ArrayList<Conflict>();
    for (Conflict conflict : myConflicts) {
      if (!getExcludedChanges().contains(conflict.getChange1()) && !getExcludedChanges().contains(conflict.getChange2())) {
        result.add(conflict);
      }
    }
    return result;
  }

  public void includeChange(Change change) {
    myExcludedChanges.remove(change);
  }

  public void excludeChange(Change change) {
    myExcludedChanges.add(change);
  }

  public void doRebuild(final Runnable afterRebuild) {
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        collectConflicts();
        collectWarnings();

        rebuldResultModel();

        afterRebuild.run();
      }
    });
  }

  public List<Change> getBaseMineChanges() {
    return myBaseMineChanges;
  }

  public List<Change> getBaseRepoChanges() {
    return myBaseRepoChanges;
  }

  private SModel getRepo(SModel[] models) {
    return models[Version.REPO.ordinal()];
  }

  private SModel getMine(SModel[] models) {
    return models[Version.MINE.ordinal()];
  }

  private SModel getBase(SModel[] models) {
    return models[Version.BASE.ordinal()];
  }

  private void collectConflicts() {
    myConflicts.clear();
    myConflictingChanges.clear();

    collectConflictsByClass(AddLanguageAspectChange.class);
    collectConflictsByClass(SetPropertyChange.class);
    collectConflictsByClass(SetReferenceChange.class);
    collectSetNodeConflicts();
    collectConflictsByClass(DeleteNodeChange.class);
    collectConflictsByClass(AddNodeChange.class);
    collectConflictsByClass(AddRootChange.class);
    collectDeleteDependencyConflicts();
    collectConflictsByClass(MoveNodeChange.class);
    collectConflictsByClass(ChangeConceptChange.class);

    for (Change change : new ArrayList<Change>(myConflictingChanges)) {
      myConflictingChanges.addAll(getChangeGroupOf(change));
    }
  }

  public List<Change> getChangeGroupOf(Change change) {
    List<Change> result = new ArrayList<Change>();
    if (myChangeGroups.get(change) != null) {
      SNode group = myChangeGroups.get(change);
      for (Map.Entry<Change, SNode> e : myChangeGroups.entrySet()) {
        if (e.getValue().equals(group)) {
          result.add(e.getKey());
        }
      }
    }
    return result;
  }

  public Set<Change> getConflictingChanges() {
    return myConflictingChanges;
  }

  private void collectWarnings() {
    myWarnings.clear();
    for (SetReferenceChange srf : getChanges(SetReferenceChange.class)) {
      if (srf.isBrokenReference()) {
        myWarnings.add(new Warning(srf.getAffectedNodeId(), "Maybe broken reference to " + srf.getResolveInfo() + " at " + srf.getAffectedNodeId()));
      }
    }

    for (ChangeConceptChange ch : getChanges(ChangeConceptChange.class)) {
      myWarnings.add(new Warning(ch.getAffectedNodeId(), "Concept changed to " + ch.getConceptFqName() + " for node " + ch.getAffectedNodeId()));
    }
  }

  private <C extends Change> void collectConflictsByClass(Class<C> changeClass) {
    Map<Object, List<C>> changesMap = new HashMap<Object, List<C>>();

    List<C> changes = getChanges(changeClass);

    for (C change : changes) {
      Object key = change.getChangeKey();
      if (changesMap.get(key) == null) {
        changesMap.put(key, new ArrayList<C>());
      }

      changesMap.get(key).add(change);
    }

    for (Object k : changesMap.keySet()) {
      handlePossibleConflictOrSymmetry(changesMap.get(k));
    }
  }

  private <C extends Change> void handlePossibleConflictOrSymmetry(List<C> changesPair) {
    if (changesPair.size() <= 1) {
      return; // Ignore
    }

    assert changesPair.size() == 2;

    C first = changesPair.get(0);
    C second = changesPair.get(1);

    if (first.isSameChange(second)) {
      mySymmetricChanges.add(first);
      mySymmetricChanges.add(second);
      myAppliedChanges.add(first);
      myExcludedChanges.add(second);
    } else {
      myConflicts.add(new Conflict(first, second));
      myConflictingChanges.add(first);
      myConflictingChanges.add(second);
    }
  }

  private void collectSetNodeConflicts() {
    Map<Pair<SNodeId, String>, List<SetNodeChange>> changes = new HashMap<Pair<SNodeId, String>, List<SetNodeChange>>();

    List<SetNodeChange> sets = getChanges(SetNodeChange.class);

    for (SetNodeChange spc : sets) {
      if (isOneOrZeroCardinality(getNodeByIdAndChange(spc, spc.getNodeParent()), spc.getNodeRole())) {
        if (changes.get(new Pair<SNodeId, String>(spc.getNodeParent(), spc.getNodeRole())) == null) {
          changes.put(new Pair<SNodeId, String>(spc.getNodeParent(), spc.getNodeRole()), new ArrayList<SetNodeChange>());
        }

        changes.get(new Pair<SNodeId, String>(spc.getNodeParent(), spc.getNodeRole())).add(spc);
      }
    }

    for (MoveNodeChange mnc : getChanges(MoveNodeChange.class)) {
      String newRole = mnc.getNewRole();

      for (SNode newParent : CollectionUtil.set(getMine(mySourceModels).getNodeById(mnc.getNewParent()),
        getMine(mySourceModels).getNodeById(mnc.getNewParent()))) {
        while (newParent != null) {
          if (changes.containsKey(new Pair(newParent.getId(), newRole))) {
            List<SetNodeChange> cs = new ArrayList<SetNodeChange>(changes.get(new Pair(newParent.getId(), newRole)));
            myConflicts.add(new Conflict(cs.get(0), mnc));
            myConflictingChanges.add(cs.get(0));
            myConflictingChanges.add(mnc);
          }
          newRole = newParent.getRole_();
          newParent = newParent.getParent();
        }
      }
    }

    for (Pair<SNodeId, String> p : changes.keySet()) {
      handlePossibleConflictOrSymmetry(changes.get(p));
    }
  }

  private SNode getNodeByIdAndChange(SetNodeChange spc, SNodeId nodeId) {
    return isMine(spc) ? getMine(mySourceModels).getNodeById(nodeId) :
      getRepo(mySourceModels).getNodeById(nodeId);
  }

  private boolean isOneOrZeroCardinality(SNode parent, String role) {
    LinkDeclaration ld = SModelSearchUtil.findLinkDeclaration(SModelUtil_new.findConceptDeclaration(parent.getConceptFqName(), GlobalScope.getInstance()), role);
    if (ld == null) {
      return false;
    }
    return ld.getSourceCardinality() == Cardinality._0__1 || ld.getSourceCardinality() == Cardinality._1;
  }

  private void collectDeleteDependencyConflicts() {
    collectDeleteDependencyConflicts(myBaseMineChanges, myBaseRepoChanges);
    collectDeleteDependencyConflicts(myBaseRepoChanges, myBaseMineChanges);
  }

  private void collectDeleteDependencyConflicts(List<Change> list1, List<Change> list2) {
    for (Change c : list1) {
      if (!mySymmetricChanges.contains(c)) {
        for (DeleteNodeChange d : CollectionUtil.filter(DeleteNodeChange.class, list2)) {
          if (!mySymmetricChanges.contains(d) && c.getDependencies().contains(d.getAffectedNodeId())) {
            myConflicts.add(new Conflict(c, d));
            myConflictingChanges.add(c);
            myConflictingChanges.add(d);
          }
        }
      }
    }
  }

  private <C extends Change> List<C> getChanges(Class<C> changeClass) {
    List<C> result = new ArrayList<C>();
    result.addAll(CollectionUtil.filter(changeClass, myBaseMineChanges));
    result.addAll(CollectionUtil.filter(changeClass, myBaseRepoChanges));
    return result;
  }

  public void rebuldResultModel() {
    myResultModel = ModelPersistence.copyModel(getBase(mySourceModels));
    boolean wasLoading = myResultModel.setLoading(true);

    try {
      ModuleReference languageNamespace = ModuleReference.fromString("jetbrains.mps.core");
      SNode tmp = new SNode(myResultModel, NameUtil.conceptFQNameFromNamespaceAndShortName(languageNamespace.getModuleFqName(), "BaseConcept"));
      boolean notRemoveLanguage = false;
      if (myResultModel.getExplicitlyImportedLanguages().contains(languageNamespace)) {
        notRemoveLanguage = true;
      }
      myResultModel.addRoot(tmp);

      // collect changes which are involved in unresolved conflicts
      myUnresolvedConflictingChanges = new LinkedHashSet<Change>();
      for (Conflict conflict : myConflicts) {
        if (!myExcludedChanges.contains(conflict.getChange1()) && !myExcludedChanges.contains(conflict.getChange2())) {
          myUnresolvedConflictingChanges.add(conflict.getChange1());
          myUnresolvedConflictingChanges.add(conflict.getChange2());
        }
      }
      for (Change change : new ArrayList<Change>(myUnresolvedConflictingChanges)) {
        myUnresolvedConflictingChanges.addAll(getChangeGroupOf(change));
      }

      applyChangesByClass(UsedLanguagesChange.class);
      applyChangesByClass(ModelImportChange.class);
      applyChangesByClass(AddLanguageAspectChange.class);

      applyStructuralChanges();

      applyChangesByClass(ChangeConceptChange.class);
      applyChangesByClass(SetPropertyChange.class);
      applyChangesByClass(SetReferenceChange.class);

      myResultModel.removeRoot(tmp);
      if (!notRemoveLanguage) myResultModel.deleteLanguage(languageNamespace);
    } finally {
      myResultModel.setLoading(wasLoading);
    }
  }

  private boolean isChangeApplicable(Change change) {
    if (myPreviewMode && !myAppliedChanges.contains(change)) return false;
    if (myExcludedChanges.contains(change)) return false;
    if (isChangeUnresolved(change)) return false;
    return true;
  }

  private <C extends Change> List<C> getApplicableChanges(Class<C> changeClass) {
    List<C> result = new ArrayList<C>();
    for (C change : getChanges(changeClass)) {
      if (isChangeApplicable(change)) {
        result.add(change);
      }
    }
    return result;
  }

  private void applyChangesByClass(Class<? extends Change> changeClass) {
    for (Change change : getApplicableChanges(changeClass)) {
      if (change.apply(myResultModel)) {
        myAppliedChanges.add(change);
      }
    }
  }

  private void applyStructuralChanges() {
    List<Change> structuralChanges = new ArrayList<Change>();
    structuralChanges.addAll(getApplicableChanges(NewNodeChange.class));
    structuralChanges.addAll(getApplicableChanges(DeleteNodeChange.class));
    structuralChanges.addAll(getApplicableChanges(MoveNodeChange.class));
    Map<SNodeId, Change> nodeIdToChangeMap = new HashMap<SNodeId, Change>();
    for (Change structuralChange : structuralChanges) {
      SNodeId nodeId = structuralChange.getAffectedNodeId();

      // This is a hack
      Change sameChange = nodeIdToChangeMap.get(nodeId);
      if (sameChange != null) {
        if (structuralChange instanceof DeleteNodeChange && sameChange instanceof DeleteNodeChange) {
        } else {
          assert false;
        }
      }
      nodeIdToChangeMap.put(nodeId, structuralChange);
    }

    Set<Change> alreadyApplied = new HashSet<Change>();
    for (Change change : structuralChanges) {
      applyStructurualChange(nodeIdToChangeMap, alreadyApplied, change);
    }
  }

  private List<SNodeId> getRealDependencies(Map<SNodeId, Change> nodeIdToChangeMap, Change change) {
    if (change instanceof DeleteNodeChange) {
      ArrayList<SNodeId> result = new ArrayList<SNodeId>();
      for (SNodeId nodeId : change.getDependencies()) {
        if (nodeIdToChangeMap.get(nodeId) instanceof DeleteNodeChange) {
          result.add(nodeId);
        }
      }
      return result;
    } else {
      return change.getDependencies();
    }
  }

  private boolean applyStructurualChange(Map<SNodeId, Change> nodeIdToChangeMap, Set<Change> alreadyApplied, Change change) {
    if (myPreviewMode && !myAppliedChanges.contains(change)) { return false; }
    if (myExcludedChanges.contains(change) || isChangeUnresolved(change)) { return false; }
    if (alreadyApplied.contains(change)) { return true; }

    for (SNodeId dependency : getRealDependencies(nodeIdToChangeMap, change)) {
      if (!nodeIdToChangeMap.containsKey(dependency)) {
        continue;
      }
      if (!applyStructurualChange(nodeIdToChangeMap, alreadyApplied, nodeIdToChangeMap.get(dependency))) {
        return false;
      }
    }
    boolean applied = change.apply(myResultModel);
    if (applied) {
      alreadyApplied.add(change);
    }
    return applied;
  }

  private boolean isChangeUnresolved(Change ch) {
    // we allow changes which are not involved in unresolved conflicts
    // or, if involved, are outgoing changes
    if (myPreviewMode) {
      return myConflictingChanges.contains(ch) && myUnresolvedConflictingChanges.contains(ch);
    } else {
      return myConflictingChanges.contains(ch) && myUnresolvedConflictingChanges.contains(ch) && myBaseRepoChanges.contains(ch);
    }
  }

  public boolean isResolved() {
    return myUnresolvedConflictingChanges.isEmpty();
  }

  public boolean isMine(Change change) {
    return myBaseMineChanges.contains(change);
  }

  public void setPreviewMode(boolean b) {
    myPreviewMode = b;
  }

  public Set<Change> getAppliedChanges() {
    return myAppliedChanges;
  }

  public Set<Change> getConflictedWith(Change change) {
    Set<Change> result = new HashSet<Change>();
    if (!myConflictingChanges.contains(change)) {
      return result;
    }
    for (Conflict c : myConflicts) {
      if (c.getChange1() == change) {
        result.add(c.getChange2());
        result.addAll(getChangeGroupOf(c.getChange2()));
      }
      if (c.getChange2() == change) {
        result.add(c.getChange1());
        result.addAll(getChangeGroupOf(c.getChange1()));
      }
    }
    return result;
  }

  public Set<Change> getUnresolvedConflictingChanges() {
    return myUnresolvedConflictingChanges;
  }

  private enum Version {
    MINE,
    BASE,
    REPO
  }
}
