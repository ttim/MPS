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
package jetbrains.mps.workbench.actions.goTo.matcher;

import com.intellij.ide.util.gotoByName.ChooseByNameBase;
import com.intellij.ide.util.gotoByName.ChooseByNameItemProvider;
import com.intellij.util.Processor;

import java.util.ArrayList;
import java.util.List;

public class CompositeItemProvider implements ChooseByNameItemProvider {
  private ChooseByNameItemProvider[] myProviders;

  public CompositeItemProvider(ChooseByNameItemProvider... providers) {
    myProviders = providers;
  }

  public List<String> filterNames(ChooseByNameBase base, String[] names, String pattern) {
    List<String> res = new ArrayList<String>();
    for (ChooseByNameItemProvider matcher : myProviders) {
      res.addAll(matcher.filterNames(base, names, pattern));
    }
    return res;
  }

  public void filterElements(ChooseByNameBase base, String pattern, boolean everywhere, com.intellij.openapi.util.Computable<Boolean> cancelled, Processor<Object> consumer) {
    List<Object> res = new ArrayList<Object>();
    for (ChooseByNameItemProvider matcher : myProviders) {
      matcher.filterElements(base,pattern, everywhere, cancelled, consumer);
    }
  }
}
