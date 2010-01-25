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
package jetbrains.mps.refactoring.framework;

import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.smodel.SModel;

public class OldLoggableRefactoringAdapter extends OldRefactoringAdapter implements ILoggableRefactoring {
  public OldLoggableRefactoringAdapter(AbstractLoggableRefactoring oldRefactoring) {
    super(oldRefactoring);
  }

  public SearchResults getAffectedNodes(RefactoringContext refactoringContext) {
    return myOldRefactoring.getAffectedNodes(refactoringContext);
  }

  public void updateModel(SModel model, RefactoringContext refactoringContext) {
    myOldRefactoring.updateModel(model, refactoringContext);
  }
}
