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
package jetbrains.mps.newTypesystem.states;

import jetbrains.mps.newTypesystem.SubTyping;
import jetbrains.mps.newTypesystem.TypesUtil;
import jetbrains.mps.newTypesystem.differences.inequality.SubTypingRemoved;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 13, 2010
 * Time: 5:56:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class InequalityMapPair {
  protected State myState;
  private boolean isWeak;
  private boolean checkOnly;
  private Map<SNode, Map<SNode, EquationInfo>> mySubToSuper = new HashMap<SNode, Map<SNode, EquationInfo>>();
  private Map<SNode, Map<SNode, EquationInfo>> mySuperToSub = new HashMap<SNode, Map<SNode, EquationInfo>>();

  public InequalityMapPair(State state, boolean weak, boolean checkOnly) {
    myState = state;
    isWeak = weak;
    this.checkOnly = checkOnly;
  }

  public boolean contains(SNode key, SNode value) {
    Map<SNode, EquationInfo> map = mySubToSuper.get(key);
    return (map != null && map.containsKey(value));
  }

  private void removeAndDelete(Map<SNode, Map<SNode, EquationInfo>> map, SNode key, SNode toRemove) {
    Map<SNode, EquationInfo> value = map.get(key);
    if (value != null) {
      value.remove(toRemove);
      if (value.isEmpty()) {
        map.remove(key);
      }
    }
  }

  private Map<SNode, EquationInfo> getMap(Map<SNode, Map<SNode, EquationInfo>> baseMap, SNode key) {
    Map<SNode, EquationInfo> result = baseMap.get(key);
    if (result == null) {
      result = new HashMap<SNode, EquationInfo>();
      baseMap.put(key, result);
    }
    return result;
  }

  public void add(SNode subType, SNode superType, EquationInfo info) {
    getMap(mySubToSuper, subType).put(superType, info);
    getMap(mySuperToSub, superType).put(subType, info);
  }

  public void remove(SNode subType, SNode superType) {
    removeAndDelete(mySubToSuper, subType, superType);
    removeAndDelete(mySuperToSub, superType, subType);
  }

  public void substituteInMap(Map<SNode, Map<SNode, EquationInfo>> baseMap,
                              Map<SNode, Map<SNode, EquationInfo>> pairMap,
                              SNode var, SNode type, boolean reversed) {
    Map<SNode, EquationInfo> values = baseMap.remove(var);
    if (values == null) return;
    for (final SNode value : values.keySet()) {
      Map<SNode, EquationInfo> map = pairMap.get(value);
      EquationInfo info = map.get(var);
      if (reversed) {
        myState.addDifference(new SubTypingRemoved(var, value, info, this), false);
        myState.addInequality(type, value, isWeak, checkOnly, info);
      } else {
        myState.addDifference(new SubTypingRemoved(value, var, info, this), false);
        myState.addInequality(value, type, isWeak, checkOnly, info);
      }
    }
  }

  public void substitute(SNode var, SNode type) {
    substituteInMap(mySubToSuper, mySuperToSub, var, type, true);
    substituteInMap(mySuperToSub, mySubToSuper, var, type, false);
  }

  public void print() {
    for (SNode key : mySubToSuper.keySet()) {
      for (SNode value : mySubToSuper.get(key).keySet()) {
        System.out.println(key + (isWeak ? " <= " : " < ") + value + (checkOnly ? " check only" : ""));
      }
    }
  }

  public Set<SNode> getVertices() {
    Set<SNode> result = new HashSet<SNode>(mySubToSuper.keySet());
    result.addAll(mySuperToSub.keySet());
    return result;
  }

  public void clear() {
    clearMap(mySubToSuper);
    clearMap(mySuperToSub);
  }

  private void clearMap(Map<SNode, Map<SNode, EquationInfo>> map) {
    for (SNode key : map.keySet()) {
      map.get(key).clear();
    }
    map.clear();
  }

  public boolean isWeak() {
    return isWeak;
  }

  public Map<SNode, EquationInfo> getSubTypes(SNode node) {
    return mySuperToSub.get(node);
  }

  public Map<SNode, EquationInfo> getSuperTypes(SNode node) {
    return mySubToSuper.get(node);
  }

  public List<String> getListPresentation() {
    List<String> result = new LinkedList<String>();
    for (SNode key : mySubToSuper.keySet()) {
      for (SNode value : mySubToSuper.get(key).keySet()) {
        result.add(key + (isWeak ? " <= " : " < ") + value + (checkOnly ? " check only" : ""));
      }
    }
    return result;
  }

  private void expandKeySet(Map<SNode, Map<SNode, EquationInfo>> map) {
    for (SNode node : new HashSet<SNode>(map.keySet())) {
      SNode expanded = myState.getEquations().expandNode(node);
      if (expanded != node) {
        substitute(node, expanded);
      }
    }
  }

  public void expand() {
    expandKeySet(mySuperToSub);
    expandKeySet(mySubToSuper);
  }

  public void check() {
    expand();
    SubTyping subTyping = myState.getTypeCheckingContext().getSubTyping();
    for (SNode subType : mySubToSuper.keySet()) {
      if (TypesUtil.isVariable(subType)) {
        continue;
      }
      Map<SNode, EquationInfo> map = mySubToSuper.get(subType);
      for (SNode superType : map.keySet()) {
        if (TypesUtil.isVariable(superType)) {
          continue;
        }
        EquationInfo info = map.get(superType);
        if (!subTyping.isSubType(subType, superType, info, isWeak, checkOnly)) {
          myState.getNodeMaps().reportSubTypeError(subType, superType, info, isWeak);
        }
      }
    }
  }

  public Set<SNode> getConcrete(Set<SNode> set, boolean shallow) {
    Set<SNode> result = new HashSet<SNode>();
    for (SNode node : set) {
      if (myState.isConcrete(node, shallow)) {
        result.add(node);
      }
    }
    return result;
  }

  public void solve() {
    solve(false);
    solve(true);
  }

  public void solve(boolean shallow) {
    iteration(shallow, true);
    iteration(shallow, false);
  }


  /*
    Solving iteration
  
  */
  private boolean iteration(boolean shallow, boolean sub) {
    Map<SNode, Map<SNode, EquationInfo>> map = sub ? mySubToSuper : mySuperToSub;
    SubTyping subTyping = new SubTyping(myState);
    boolean stateChanged = false;
    for (SNode node : new HashSet<SNode>(map.keySet())) {
      Set<SNode> concreteTypes = getConcrete(map.get(node).keySet(), shallow);

      if (concreteTypes == null || concreteTypes.isEmpty()) {
        continue;
      }
      if (TypesUtil.isVariable(node)) {
        SNode type = sub ? subTyping.createMeet(concreteTypes) : subTyping.createLCS(concreteTypes);
        myState.addEquation(node, type, null);
      } else if (myState.isConcrete(node, shallow)) {
        for (SNode concreteType : concreteTypes) {
          EquationInfo info = map.get(node).get(concreteType);
          if (sub) {
            myState.addInequality(node, concreteType, isWeak, checkOnly, info);
            remove(node, concreteType);
          } else {
            myState.addInequality(concreteType, node, isWeak, checkOnly, info);
            remove(concreteType, node);
          }
        }
      }
      stateChanged = true;
    }
    return stateChanged;
  }

}
