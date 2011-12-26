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

import com.intellij.ide.util.gotoByName.ChooseByNameItemProvider;
import com.intellij.ide.util.gotoByName.ChooseByNameModel;
import com.intellij.ide.util.gotoByName.ChooseByNamePopup;
import com.intellij.ide.util.gotoByName.DefaultChooseByNameItemProvider;
import com.intellij.openapi.project.Project;
import jetbrains.mps.workbench.choose.base.FakePsiContext;

public abstract class MpsPopupFactory {
  private static final FakePsiContext CONTEXT = new FakePsiContext();

  public static ChooseByNamePopup createNodePopup(Project p, ChooseByNameModel m) {
    return ChooseByNamePopup.createPopup(p, m, nodeProvider());
  }

  public static ChooseByNamePopup createNodePopup(Project p, ChooseByNameModel m, String initialText) {
    return ChooseByNamePopup.createPopup(p, m, nodeProvider(), initialText);
  }

  public static ChooseByNamePopup createPackagePopup(Project p, ChooseByNameModel m) {
    return ChooseByNamePopup.createPopup(p, m, packageProvider());
  }

  public static ChooseByNamePanel createPanelForNode(ChooseByNameModel model, boolean checkboxVisible) {
    return new ChooseByNamePanel(model, checkboxVisible, nodeProvider());
  }

  public static ChooseByNamePanel createPanelForPackage(ChooseByNameModel model, boolean checkboxVisible) {
    return new ChooseByNamePanel(model, checkboxVisible, packageProvider());
  }

  private static ChooseByNameItemProvider nodeProvider() {
    return new CompositeItemProvider(new MPSNodeItemProvider(CONTEXT), new DefaultChooseByNameItemProvider(CONTEXT));
  }

  private static ChooseByNameItemProvider packageProvider() {
    return new CompositeItemProvider(new DefaultChooseByNameItemProvider(CONTEXT), new MPSPackageItemProvider(CONTEXT));
  }
}
