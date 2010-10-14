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
package jetbrains.mps.newTypesystem.differences;

import jetbrains.mps.newTypesystem.states.State;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Sep 10, 2010
 * Time: 6:11:49 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Difference {
  protected List<Difference> myChildren;

  public void addChildDifference(Difference diff) {
    if (myChildren == null) {
      myChildren = new LinkedList<Difference>();
    }
    myChildren.add(diff);
  }

  public List<Difference> getChildren() {
    return myChildren;
  }

  public abstract void rollBack();

  public String getPresentation() {
    return "";
  }
}
