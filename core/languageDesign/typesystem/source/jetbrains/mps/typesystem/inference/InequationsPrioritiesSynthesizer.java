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
package jetbrains.mps.typesystem.inference;

import jetbrains.mps.util.Pair;
import jetbrains.mps.logging.Logger;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: User
 * Date: 21.10.2009
 * Time: 18:47:48
 * To change this template use File | Settings | File Templates.
 */
public class InequationsPrioritiesSynthesizer {
  private static final Logger LOG = Logger.getLogger(InequationsPrioritiesSynthesizer.class);

  private Map<EquationInfo, Pair<IWrapper, IWrapper>> myAllInequations = new HashMap<EquationInfo, Pair<IWrapper, IWrapper>>();
  private EquationManager myEquationManager;
  // private List<Set<EquationInfo>> myInequationsLayers = new ArrayList<Set<EquationInfo>>(6);
  Map<EquationInfo, Integer> mySyntheticRanks = new HashMap<EquationInfo, Integer>();

  public InequationsPrioritiesSynthesizer(EquationManager equationManager) {
    myEquationManager = equationManager;
  }

  public void fillAllInequations(Map<IWrapper, Map<IWrapper, EquationInfo>> subtypesToSupertypesMap,
                                 Map<IWrapper, Map<IWrapper, EquationInfo>> subtypesToSupertypesMapStrong,
                                 Map<IWrapper, Map<IWrapper, EquationInfo>> supertypesToSubtypesMap,
                                 Map<IWrapper, Map<IWrapper, EquationInfo>> supertypesToSubtypesMapStrong) {
    for (IWrapper subWrapper : subtypesToSupertypesMap.keySet()) {
      Map<IWrapper, EquationInfo> supers = subtypesToSupertypesMap.get(subWrapper);
      if (supers != null) {
        for (IWrapper superWrapper : supers.keySet()) {
          EquationInfo info = supers.get(superWrapper);
          if (info != null) {
            myAllInequations.put(info, new Pair<IWrapper, IWrapper>(subWrapper, superWrapper));
          }
        }
      }
    }
    for (IWrapper subWrapper : subtypesToSupertypesMapStrong.keySet()) {
      Map<IWrapper, EquationInfo> supers = subtypesToSupertypesMapStrong.get(subWrapper);
      if (supers != null) {
        for (IWrapper superWrapper : supers.keySet()) {
          EquationInfo info = supers.get(superWrapper);
          if (info != null) {
            info.setStrong();
            myAllInequations.put(info, new Pair<IWrapper, IWrapper>(subWrapper, superWrapper));
          }
        }
      }
    }
    for (IWrapper superWrapper : supertypesToSubtypesMap.keySet()) {
      Map<IWrapper, EquationInfo> subs = supertypesToSubtypesMap.get(superWrapper);
      if (subs != null) {
        for (IWrapper subWrapper : subs.keySet()) {
          EquationInfo info = subs.get(subWrapper);
          if (info != null) {
            myAllInequations.put(info, new Pair<IWrapper, IWrapper>(subWrapper, superWrapper));
          }
        }
      }
    }
    for (IWrapper superWrapper : supertypesToSubtypesMapStrong.keySet()) {
      Map<IWrapper, EquationInfo> subs = supertypesToSubtypesMapStrong.get(superWrapper);
      if (subs != null) {
        for (IWrapper subWrapper : subs.keySet()) {
          EquationInfo info = subs.get(subWrapper);
          if (info != null) {
            info.setStrong();
            myAllInequations.put(info, new Pair<IWrapper, IWrapper>(subWrapper, superWrapper));
          }
        }
      }
    }
  }

  public void splitByLayers() {
    List<EquationInfo> allEqInfos = new ArrayList<EquationInfo>(myAllInequations.keySet());

    //creating map by id
    Map<Pair<String, String>, Set<EquationInfo>> ineqIdsToIneqs = new HashMap<Pair<String, String>, Set<EquationInfo>>();
    Map<String, Set<EquationInfo>> ineqGroupsToIneqs = new HashMap<String, Set<EquationInfo>>();
    for (EquationInfo equationInfo : allEqInfos) {
      Pair<String, String> id = new Pair<String, String>(equationInfo.getRuleModel(), equationInfo.getRuleId());
      Set<EquationInfo> equationInfos = ineqIdsToIneqs.get(id);
      if (equationInfos == null) {
        equationInfos = new HashSet<EquationInfo>();
        ineqIdsToIneqs.put(id, equationInfos);
      }
      equationInfos.add(equationInfo);
      String groupId = equationInfo.getInequationGroup();
      equationInfos = ineqGroupsToIneqs.get(groupId);
      if (equationInfos == null) {
        equationInfos = new HashSet<EquationInfo>();
        ineqGroupsToIneqs.put(groupId, equationInfos);
      }
      equationInfos.add(equationInfo);
    }

    //creating a graph; needed to set all back references
    Map<EquationInfo, Set<EquationInfo>> references = new HashMap<EquationInfo, Set<EquationInfo>>();
    Map<EquationInfo, Set<EquationInfo>> backReferences = new HashMap<EquationInfo, Set<EquationInfo>>();
    for (EquationInfo equationInfo : allEqInfos) {
      Set<EquationInfo> nextEquationsInfos = new HashSet<EquationInfo>();
      for (Pair<String, String> ineqsAfter : equationInfo.getInequationIdsAfter()) {
        Set<EquationInfo> equationInfos = ineqIdsToIneqs.get(ineqsAfter);
        if (equationInfos != null) {
          nextEquationsInfos.addAll(equationInfos);
        }
      }
      for (String groupId : equationInfo.getInequationGroupsAfter()) {
        Set<EquationInfo> equationInfos = ineqGroupsToIneqs.get(groupId);
        if (equationInfos != null) {
          nextEquationsInfos.addAll(equationInfos);
        }
      }
      Set<EquationInfo> prevEquationsInfos = new HashSet<EquationInfo>();
      for (Pair<String, String> ineqsBefore : equationInfo.getInequationIdsBefore()) {
        Set<EquationInfo> equationInfos = ineqIdsToIneqs.get(ineqsBefore);
        if (equationInfos != null) {
          prevEquationsInfos.addAll(equationInfos);
        }
      }
      for (String groupId : equationInfo.getInequationGroupsBefore()) {
        Set<EquationInfo> equationInfos = ineqGroupsToIneqs.get(groupId);
        if (equationInfos != null) {
          prevEquationsInfos.addAll(equationInfos);
        }
      }
      for (EquationInfo nextInfo : nextEquationsInfos) {
        Set<EquationInfo> equationInfos = references.get(equationInfo);
        if (equationInfos == null) {
          equationInfos = new HashSet<EquationInfo>();
          references.put(equationInfo, equationInfos);
        }
        equationInfos.add(nextInfo);
        equationInfos = backReferences.get(nextInfo);
        if (equationInfos == null) {
          equationInfos = new HashSet<EquationInfo>();
          backReferences.put(nextInfo, equationInfos);
        }
        equationInfos.add(equationInfo);
      }
      for (EquationInfo prevInfo : prevEquationsInfos) {
        Set<EquationInfo> equationInfos = references.get(prevInfo);
        if (equationInfos == null) {
          equationInfos = new HashSet<EquationInfo>();
          references.put(prevInfo, equationInfos);
        }
        equationInfos.add(equationInfo);
        equationInfos = backReferences.get(equationInfo);
        if (equationInfos == null) {
          equationInfos = new HashSet<EquationInfo>();
          backReferences.put(equationInfo, equationInfos);
        }
        equationInfos.add(prevInfo);
      }
    }

    List<Set<EquationInfo>> byRanks = new ArrayList<Set<EquationInfo>>(4);

    //graph created, lets split it by ranks
    while (!allEqInfos.isEmpty()) {
      Set<EquationInfo> nextLayer = new HashSet<EquationInfo>();
      for (EquationInfo equationInfo : new HashSet<EquationInfo>(allEqInfos)) {
        Set<EquationInfo> prevEquationInfos = backReferences.get(equationInfo);
        if (prevEquationInfos == null || prevEquationInfos.isEmpty()) {
          nextLayer.add(equationInfo);
        }
      }
      if (nextLayer.isEmpty()) {
        LOG.error("cyclic priorities found, single priority group will be created");
        // myInequationsLayers = new ArrayList<Set<EquationInfo>>(1);
        // myInequationsLayers.set(0, new HashSet<EquationInfo>(myAllInequations.keySet()));
        for (EquationInfo equationInfo : myAllInequations.keySet()) {
          mySyntheticRanks.put(equationInfo, 0);
        }
        return;
      }
      byRanks.add(nextLayer);
      for (EquationInfo equationInfo : nextLayer) {
        Set<EquationInfo> nextEquationInfos = references.get(equationInfo);
        if (nextEquationInfos != null) {
          for (EquationInfo nextEquationInfo : nextEquationInfos) {
            Set<EquationInfo> backRefs = backReferences.get(nextEquationInfo);
            if (backRefs != null) {
              backRefs.remove(equationInfo);
            }
          }
        }
        allEqInfos.remove(equationInfo);
      }
    }

    //then group by priorities
    int syntheticRank = 0;
    for (Set<EquationInfo> equationInfosSameRank : byRanks) {
      //priorities are: 0, 1, 2, 3, 500
      Set<EquationInfo>[] byPriorities = new Set[5];
      for (EquationInfo equationInfo : equationInfosSameRank) {
        int priority = equationInfo.getInequationPriority();
        if (priority == 500) {
          priority = 4;
        }
        Set<EquationInfo> equationInfos = byPriorities[priority];
        if (equationInfos == null) {
          equationInfos = new HashSet<EquationInfo>();
          byPriorities[priority] = equationInfos;
        }
        equationInfos.add(equationInfo);
      }
      for (Set<EquationInfo> equationInfos : byPriorities) {
        if (equationInfos != null && !equationInfos.isEmpty()) {
          for (EquationInfo equationInfo : equationInfos) {
            mySyntheticRanks.put(equationInfo, syntheticRank);
          }
          // myInequationsLayers.add(equationInfos);
          syntheticRank++;
        }
      }
    }
  }

  public int getInequationSyntheticRank(EquationInfo equationInfo) {
    Integer syntheticRank = mySyntheticRanks.get(equationInfo);
    if (syntheticRank == null) {
      return 0;
    }
    return syntheticRank;
  }

}
