/*
 * Copyright 2003-2012 JetBrains s.r.o.
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
package jetbrains.mps.newTypesystem.state.blocks;

import com.intellij.openapi.util.Pair;
import jetbrains.mps.newTypesystem.TypesUtil;
import jetbrains.mps.newTypesystem.state.State;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.CollectionUtil;

import java.util.List;
import java.util.Set;

public class TargetBlock extends Block {
  private SNode myNode;

  public TargetBlock(State state, SNode node) {
    super(state, node.getModel().getLongName(), node.getId());
    myNode = node;
  }

  @Override
  public List<SNode> getVariables(State state) {
    return TypesUtil.getVariables(myNode, state);
  }

  @Override
  public BlockKind getBlockKind() {
    return BlockKind.TARGET;
  }

  @Override
  public String getPresentation() {
    return "Target node " + myNode;
  }

  @Override
  public String getShortPresentation() {
    return "Target node" + myNode;
  }

  @Override
  public void performAction() {
    myState.expandTargetNode();
    myState.setTargetTypeCalculated();

  }

  @Override
  public Set<SNode> getInputs() {
    return CollectionUtil.set(myNode);
  }

  @Override
  public Set<Pair<SNode, ConditionKind>> getInitialInputs() {
    return CollectionUtil.set(new Pair<SNode, ConditionKind>(myNode, ConditionKind.CONCRETE));
  }
}
