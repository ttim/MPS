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
package jetbrains.mps.newTypesystem.differences.equation;

import jetbrains.mps.newTypesystem.states.Equations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;

import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 15, 2010
 * Time: 12:54:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class EquationAdded extends EquationDifference {
  private SNode myChild;
  private SNode myParent;

  public EquationAdded(SNode child, SNode parent, Equations equations, EquationInfo info) {
    super(equations);
    myChild = child;
    myParent = parent;
    myEquationInfo = info;
  }

  @Override
  public void rollBack() {
    myEquations.remove(myChild);
  }

  public SNode getChild() {
    return myChild;
  }

  public SNode getParent() {
    return myParent;
  }

  @Override
  public String getPresentation() {
    return "Equation added " + myChild + " = " + myParent; 
  }

  @Override
  public Color getColor() {
    return new Color(0x670365);
  }
}
