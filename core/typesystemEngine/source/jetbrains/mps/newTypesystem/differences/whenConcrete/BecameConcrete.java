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
package jetbrains.mps.newTypesystem.differences.whenConcrete;

import jetbrains.mps.newTypesystem.differences.Difference;
import jetbrains.mps.newTypesystem.states.State;
import jetbrains.mps.newTypesystem.states.WhenConcreteEntry;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;

import java.util.Map;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Oct 20, 2010
 * Time: 5:16:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class BecameConcrete extends Difference {
  private WhenConcreteEntry myEntry;
  private boolean myIsShallow;

  public BecameConcrete(boolean isShallow, WhenConcreteEntry entry) {
    myIsShallow = isShallow;
    myEntry = entry;
    myEquationInfo = new EquationInfo(null, " ", entry.getNodeModel(), entry.getNodeId());
  }

  @Override
  public void rollBack(State state) {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public String getPresentation() {
    return "Became concrete";
  }

  @Override
  public void play(State state) {
    state.getNonConcrete().removeWhenConcrete(myEntry, myIsShallow);
    //todo it seems that from "var -> WC" it is not removed
  }
}
