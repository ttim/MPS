/*
 * Copyright 2003-2011 JetBrains s.r.o.
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
package jetbrains.mps.lang.script.runtime;

import java.util.ArrayList;
import java.util.List;

/**
 * Igor Alshannikov
 * Date: Apr 24, 2007
 */
public class BaseMigrationScript {
  private List<AbstractMigrationRefactoring> myRefactorings = new ArrayList<AbstractMigrationRefactoring>();
  private String myName;

  
  public BaseMigrationScript(String name) {
    myName = name;
  }

  public String getName() {
    return myName;
  }

  public void addRefactoring(AbstractMigrationRefactoring refactoring) {
    myRefactorings.add(refactoring);
  }

  public List<AbstractMigrationRefactoring> getRefactorings() {
    return myRefactorings;
  }
}
