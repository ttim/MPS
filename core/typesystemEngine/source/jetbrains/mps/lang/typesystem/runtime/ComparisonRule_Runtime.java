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
package jetbrains.mps.lang.typesystem.runtime;

import jetbrains.mps.smodel.SNode;

public abstract class ComparisonRule_Runtime implements IRuleWithTwoApplicableNodes {
  public abstract boolean areComparable(SNode type1, SNode type2);

  public boolean isWeak() {
    return false;
  }

  @Deprecated
  public boolean isApplicable(SNode node1, SNode node2) {
    return isApplicable1(node1) && isApplicable2(node2);
  }

  public IsApplicable2Status isApplicableAndPatterns(SNode node1, SNode node2) {
    boolean b = isApplicable1(node1) && isApplicable2(node2);
    return new IsApplicable2Status(b, null, null);
  }
}
