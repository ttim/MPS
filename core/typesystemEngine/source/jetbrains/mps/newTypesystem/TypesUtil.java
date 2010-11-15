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
package jetbrains.mps.newTypesystem;

import jetbrains.mps.lang.pattern.util.IMatchModifier;
import jetbrains.mps.lang.pattern.util.MatchingUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.typesystem.structure.RuntimeTypeVariable;
import jetbrains.mps.newTypesystem.states.Equations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.util.Pair;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 24, 2010
 * Time: 12:42:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TypesUtil {

  public SNode leastCommonSuperType(SNode left, SNode right) {
    //left.isInstanceOfConcept()
    //if ()

    return left;
  }

  public static boolean isVariable(SNode node) {
    return node != null && RuntimeTypeVariable.concept.equals(node.getConceptFqName());
  }

  public static boolean isType(SNode node) {
    return !isVariable(node);
  }

  public static int getDegree(SNode node) {
    if (isVariable(node)) return 0;
    return 1;
  }

  public static boolean match(SNode left, SNode right, Equations equations, @Nullable EquationInfo info, boolean checkOnly) {
    if (left == right) {
      return true;
    }
    if (left == null || right == null) {
      return false;
    }
    if (TypesUtil.isVariable(left) || TypesUtil.isVariable(right)) {
      if (!checkOnly) {
        equations.addEquation(left, right, info);
      }
      return true;
    }
    TypeMatchModifier typeMatchModifier = new TypeMatchModifier();
    boolean result = MatchingUtil.matchNodes(left, right, typeMatchModifier, false);
    if (!checkOnly && result) {
      if (equations != null) {
        equations.addEquations(typeMatchModifier.getChildEqs(), info);
      }
    }
    return result;
  }

  private static class TypeMatchModifier implements IMatchModifier {
    final Set<Pair<SNode, SNode>> childEQs = new HashSet<Pair<SNode, SNode>>();

    public boolean accept(SNode node1, SNode node2) {
      return HUtil.isRuntimeTypeVariable(node1) || HUtil.isRuntimeTypeVariable(node2);
    }

    public boolean acceptList(List<SNode> nodes1, List<SNode> nodes2) {
      return false;
    }

    public void performAction(SNode node1, SNode node2) {
      childEQs.add(new Pair<SNode, SNode>(node1, node2));
    }

    public void performGroupAction(List<SNode> nodes1, List<SNode> nodes2) {
    }

    public Set<Pair<SNode, SNode>> getChildEqs() {
      return childEQs;
    }

    public void clear() {
      childEQs.clear();
    }
  }
}

