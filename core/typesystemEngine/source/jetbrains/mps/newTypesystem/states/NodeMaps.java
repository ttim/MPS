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

import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.errors.QuickFixProvider;
import jetbrains.mps.errors.SimpleErrorReporter;
import jetbrains.mps.newTypesystem.EquationErrorReporterNew;
import jetbrains.mps.newTypesystem.differences.ErrorDifference;
import jetbrains.mps.newTypesystem.differences.TypeDifference;
import jetbrains.mps.newTypesystem.differences.TypeExpanded;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.util.Pair;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 10, 2010
 * Time: 6:38:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeMaps {
  private final Map<SNode, SNode> myNodesToTypes = new HashMap<SNode, SNode>();
  private final Map<SNode, SNode> myTypesToNodes = new HashMap<SNode, SNode>();
  private final Map<SNode, List<IErrorReporter>> myNodesToErrors = new HashMap<SNode, List<IErrorReporter>>();
  private final State myState;

  public NodeMaps(State state) {
    myState = state;
  }

  public void addNodeToType(SNode node, SNode type, EquationInfo info) {
    myTypesToNodes.put(type, node);
    myState.addDifference(new TypeDifference(node, type, info), false);
  }

  public void updateNodeToType(SNode node, SNode type, EquationInfo info) {
    SNode oldType = myNodesToTypes.get(node);
    myState.addDifference(new TypeExpanded(node, type, info, oldType), false);
  }

  public SNode typeOf(SNode node, EquationInfo info) {
    SNode type = myNodesToTypes.get(node);
    if (type == null) {
      type = myState.createNewRuntimeTypesVariable();
      addNodeToType(node, type, info);
    }
    return type;
  }

  public void addNodeToError(SNode node, IErrorReporter error, EquationInfo info) {
    myState.addDifference(new ErrorDifference(node, error, info), false);
  }

  public List<IErrorReporter> getNodeErrors(SNode node) {
    List<IErrorReporter> result = myNodesToErrors.get(node);
    if (result == null) {
      result = new LinkedList<IErrorReporter>();
    }
    return result;
  }

  public Set<Pair<SNode, List<IErrorReporter>>> getNodesWithErrors() {
    Set<Pair<SNode, List<IErrorReporter>>> result = new HashSet<Pair<SNode, List<IErrorReporter>>>();
    for (SNode key : myNodesToErrors.keySet()) {
      List<IErrorReporter> reporter = getNodeErrors(key);
      if (key != null && !reporter.isEmpty()) {
        result.add(new Pair<SNode, List<IErrorReporter>>(key, reporter));
      }
    }
    return result;
  }

  public void clear() {
    myNodesToErrors.clear();
    myNodesToTypes.clear();
    myTypesToNodes.clear();
  }

  public SNode getType(SNode node) {
    SNode type = myNodesToTypes.get(node);
    return myState.getRepresentative(type);
  }

  public List<String> getErrorListPresentation() {
    List<String> result = new LinkedList<String>();
    for (Map.Entry<SNode, List<IErrorReporter>> entry : myNodesToErrors.entrySet()) {
      for (IErrorReporter error : entry.getValue()) {
        result.add(entry.getKey() + " " + error.reportError());
      }
    }
    return result;
  }

  public List<String> getTypeListPresentation() {
    List<String> result = new LinkedList<String>();
    for (Map.Entry<SNode, SNode> entry : myNodesToTypes.entrySet()) {
      result.add(entry.getKey() + " : " + entry.getValue() + " ---> " + myState.getRepresentative(entry.getValue()));
    }
    return result;
  }

  public void expandAll() {
    for (SNode node : myNodesToTypes.keySet()) {
      SNode var = myNodesToTypes.get(node);
      SNode type = myState.getEquations().expandNode(var);
      updateNodeToType(node, type, null);
    }
  }

  public SNode getNode(SNode type) {
    return myTypesToNodes.get(type);
  }

  /*package*/ Map<SNode, List<IErrorReporter>> getErrors() {
    return myNodesToErrors;
  }

  /*package*/ Map<SNode, SNode> getNodeToTypeMap() {
    return myNodesToTypes;
  }

  public void reportEquationBroken(EquationInfo info, SNode left, SNode right) {
    IErrorReporter errorReporter;
    SNode nodeWithError = null;
    QuickFixProvider intentionProvider = null;
    String errorString = null;
    String ruleModel = null;
    String ruleId = null;
    if (info != null) {
      nodeWithError = info.getNodeWithError();
      intentionProvider = info.getIntentionProvider();
      errorString = info.getErrorString();
      ruleModel = info.getRuleModel();
      ruleId = info.getRuleId();
    }
    if (errorString != null) {
      errorReporter = new SimpleErrorReporter(nodeWithError, errorString, ruleModel, ruleId);
    } else {
      errorReporter = new EquationErrorReporterNew(nodeWithError, myState, "incompatible types: ",
        right, " and ", left, "", ruleModel, ruleId);
    }
    errorReporter.setIntentionProvider(intentionProvider);
    if (info != null) {
      errorReporter.setAdditionalRulesIds(info.getAdditionalRulesIds());
    }
    addNodeToError(nodeWithError, errorReporter, info);
  }

  public void reportSubTypeError(SNode subType, SNode superType, EquationInfo equationInfo, boolean isWeak) {
    IErrorReporter errorReporter;
    String errorString = equationInfo.getErrorString();
    String ruleModel = equationInfo.getRuleModel();
    String ruleId = equationInfo.getRuleId();
    SNode nodeWithError = equationInfo.getNodeWithError();
    if (errorString == null) {
      String strongString = isWeak ? "" : " strong";
      errorReporter = new EquationErrorReporterNew(nodeWithError, myState, "type ", subType,
        " is not a" + strongString + " subtype of ", superType, "", ruleModel, ruleId);
    } else {
      errorReporter = new SimpleErrorReporter(nodeWithError, errorString, ruleModel, ruleId);
    }
    errorReporter.setIntentionProvider(equationInfo.getIntentionProvider());
    errorReporter.setAdditionalRulesIds(equationInfo.getAdditionalRulesIds());
    // myState.getTypeCheckingContext().reportMessage(nodeWithError, errorReporter);
    myState.addError(nodeWithError, errorReporter, equationInfo);
  }

  public void reportComparableError(SNode subType, SNode superType, EquationInfo equationInfo, boolean isWeak) {
    IErrorReporter errorReporter;
    String errorString = equationInfo.getErrorString();
    String ruleModel = equationInfo.getRuleModel();
    String ruleId = equationInfo.getRuleId();
    SNode nodeWithError = equationInfo.getNodeWithError();
    if (errorString == null) {
      String strongString = isWeak ? "" : " strongly";
      errorReporter = new EquationErrorReporterNew(nodeWithError, myState, "type ", subType, " is not" + strongString + " comparable with ",
        superType, "", ruleModel, ruleId);
    } else {
      errorReporter = new SimpleErrorReporter(nodeWithError, errorString, ruleModel, ruleId);
    }
    errorReporter.setIntentionProvider(equationInfo.getIntentionProvider());
    errorReporter.setAdditionalRulesIds(equationInfo.getAdditionalRulesIds());
    // myState.getTypeCheckingContext().reportMessage(nodeWithError, errorReporter);
    myState.addError(nodeWithError, errorReporter, equationInfo);
  }
}
