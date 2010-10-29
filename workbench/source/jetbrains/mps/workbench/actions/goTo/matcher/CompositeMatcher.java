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
package jetbrains.mps.workbench.actions.goTo.matcher;

import com.intellij.ide.util.gotoByName.matchers.EntityMatcher;
import com.intellij.openapi.util.Computable;

import java.util.List;
import java.util.Set;

public class CompositeMatcher implements EntityMatcher {
  private EntityMatcher[] myMatcher;

  public CompositeMatcher(EntityMatcher... matcher) {
    myMatcher = matcher;
  }

  public boolean nameMatches(String pattern, String name) {
    for (EntityMatcher matcher : myMatcher) {
      if (matcher.nameMatches(pattern,name)) return true;
    }
    return false;
  }

  public boolean addElementsByPattern(Set<Object> result, String pattern, String[] names, boolean checkboxState, int maxCount, Computable<Boolean> isCancelled) {
    boolean overflow = false;
    for (EntityMatcher matcher : myMatcher) {
      overflow |= matcher.addElementsByPattern(result, pattern, names, checkboxState, maxCount, isCancelled);
    }
    return overflow;
  }
}
