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

import java.awt.Color;

/**
 * Created by IntelliJ IDEA.
 * User: Ilya.Lintsbakh
 * Date: Oct 14, 2010
 * Time: 1:42:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringDifference extends Difference {
  private String myString;

  public StringDifference(String string) {
    myString = string;
  }

  @Override
  public String getPresentation() {
    return myString;
  }

  @Override
  public void rollBack() {
  }

  @Override
  public void play() {
    //To change body of implemented methods use File | Settings | File Templates.
  }

  public Color getColor() {
    return new Color(0x111177);
  }
}
