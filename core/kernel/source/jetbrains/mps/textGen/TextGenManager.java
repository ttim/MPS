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
package jetbrains.mps.textGen;

import jetbrains.mps.debug.DebugInfoManager;
import jetbrains.mps.debug.info.PositionInfo;
import jetbrains.mps.debug.info.ScopePositionInfo;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.structure.structure.ConceptDeclaration;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.util.misc.hash.HashMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Dmitriev.
 * Date: Dec 22, 2003
 */
public class TextGenManager {
  private static final Logger LOG = Logger.getLogger(TextGenManager.class);
  private static TextGenManager ourInstance;
  public static final String PACKAGE_NAME = "PACKAGE_NAME";
  public static final String DEPENDENCY = "DEPENDENCY";
  public static final String EXTENDS = "EXTENDS";
  public static final String IMPORT = "IMPORT";

  public static void reset() {
    ourInstance = null;
  }

  public static TextGenManager instance() {
    if (ourInstance == null) {
      ourInstance = new TextGenManager();
    }
    return ourInstance;
  }

  private HashMap<SNode, PositionInfo> myPositions;
  private HashMap<SNode, ScopePositionInfo> myScopePositions;

  public TextGenerationResult generateText(IOperationContext context, SNode node) {
    myPositions = new HashMap<SNode, PositionInfo>();
    myScopePositions = new HashMap<SNode, ScopePositionInfo>();
    TextGenBuffer buffer = new TextGenBuffer();
    buffer.putUserObject(PACKAGE_NAME, node.getModel().getLongName());
    appendNodeText(context, buffer, node, null);
    int topLength = buffer.getTopBufferText().split(buffer.getLineSeparator(), -1).length + 2;
    for (PositionInfo position : myPositions.values()) {
      position.setStartLine(position.getStartLine() + topLength);
      position.setEndLine(position.getEndLine() + topLength);
    }
    for (PositionInfo position : myScopePositions.values()) {
      position.setStartLine(position.getStartLine() + topLength);
      position.setEndLine(position.getEndLine() + topLength);
    }
    List<String> dependencies = getUserObjectCollection(DEPENDENCY, node, buffer);
    List<String> extend = getUserObjectCollection(EXTENDS, node, buffer);
    return new TextGenerationResult(buffer.getText(), buffer.hasErrors(), myPositions, myScopePositions, dependencies, extend);
  }

  public boolean canGenerateTextFor(SNode node) {
    return !(loadNodeTextGen(null, node) instanceof DefaultTextGen);
  }

  public String getExtension(SNode node) {
    return loadNodeTextGen(null, node).getExtension(node);
  }

  public void appendNodeText(IOperationContext context, TextGenBuffer buffer, SNode node, SNode contextNode) {
    if (node == null) {
      buffer.append("???");

      if (contextNode != null) {
        LOG.error("possible broken reference", contextNode);
      }

      return;
    }

    SNodeTextGen nodeTextGen = loadNodeTextGen(context, node);
    if (nodeTextGen == null) {
      LOG.error("couldn't find text generator for " + node.getDebugText(), node);
    }
    assert nodeTextGen != null;

    nodeTextGen.setBuffer(buffer);
    try {
      PositionInfo info = new PositionInfo();
      info.setStartLine(buffer.getLineNumber());
      info.setStartPosition(buffer.getPosition());
      nodeTextGen.setSNode(node);
      nodeTextGen.doGenerateText(node);
      nodeTextGen.setSNode(null);
      info.setEndLine(buffer.getLineNumber());
      info.setEndPosition(buffer.getPosition());

      if (DebugInfoManager.getInstance().isDebuggableNode(node)) {
        myPositions.put(node, info);
      }
      if (DebugInfoManager.getInstance().isScopeNode(node)) {
        ScopePositionInfo scopePositionInfo = new ScopePositionInfo();
        scopePositionInfo.fillFrom(info);
        List<SNode> vars = DebugInfoManager.getInstance().getVarsInScope(node);
        for (SNode var : vars) {
          scopePositionInfo.addVarInfo(var);
        }
        myScopePositions.put(node, scopePositionInfo);
      }
    } catch (Exception e) {
      buffer.foundError();
      LOG.error("failed to generate text for " + node.getDebugText(), e, node);
    }
  }

  private SNodeTextGen loadNodeTextGen(IOperationContext context, SNode node) {
    SNode cd = node.getConceptDeclarationNode();

    SNode baseConcept = SModelUtil.getBaseConcept();
    while (cd != baseConcept) {
      Language l = SModelUtil.getDeclaringLanguage(cd, GlobalScope.getInstance());

      String packageName = NameUtil.namespaceFromConceptFQName(NameUtil.nodeFQName(cd));
      String className = cd.getName();
      String textgenClassname = packageName + ".textGen." + className + "_TextGen";
      try {
        Class textgenClass = l.getClass(textgenClassname);
        if (textgenClass != null) {
          SNodeTextGen result = (SNodeTextGen) textgenClass.newInstance();
          result.setContext(context);
          return result;
        }
      } catch (InstantiationException e) {
        LOG.error(e, node);
      } catch (IllegalAccessException e) {
        LOG.error(e, node);
      }

      cd = cd.getReferent(ConceptDeclaration.EXTENDS);
      if (cd == null) cd = baseConcept;
    }
    DefaultTextGen result = new DefaultTextGen();
    result.setContext(context);
    return result;
  }

  private List<String> getUserObjectCollection(String key, SNode node, TextGenBuffer buffer) {
    Object dependenciesObject = buffer.getUserObject(key);
    List<String> dependencies = new ArrayList<String>();
    if (dependenciesObject != null) {
      for (Object dependObj : (SetSequence) dependenciesObject) {
        if (dependObj == null) {
          continue;
        }
        if (NameUtil.nodeFQName(node).equals(dependObj)) {
          continue;
        }
        dependencies.add((String) dependObj);
      }
    }
    return dependencies;
  }

  public static class TextGenerationResult {
    private String myText;
    private boolean myContainErrors;
    private HashMap<SNode, PositionInfo> myPositions;
    private HashMap<SNode, ScopePositionInfo> myScopePositions;
    private Map<String, String> myDependencies;

    private TextGenerationResult(String text,
                                 boolean containErrors,
                                 HashMap<SNode, PositionInfo> positions,
                                 HashMap<SNode, ScopePositionInfo> scopePositions,
                                 List<String> dependencies,
                                 List<String> extend) {
      myText = text;
      myContainErrors = containErrors;
      myPositions = positions;
      myScopePositions = scopePositions;
      myDependencies = new HashMap<String, String>(dependencies.size() + extend.size());
      for (String s : dependencies) {
        myDependencies.put(s, DEPENDENCY);
      }
      for (String s : extend) {
        myDependencies.put(s, EXTENDS);
      }
    }

    public String getText() {
      return myText;
    }

    public boolean hasErrors() {
      return myContainErrors;
    }

    public Map<SNode, PositionInfo> getPositions() {
      return myPositions;
    }

    public Map<SNode, ScopePositionInfo> getScopePositions() {
      return myScopePositions;
    }

    public Map<String, String> getDependencies() {
      return myDependencies;
    }
  }
}
