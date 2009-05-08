/*
 * Copyright 2003-2009 JetBrains s.r.o.
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
package jetbrains.mps.lang.actions;

import javax.swing.JPanel;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 26.02.2009
 * Time: 13:04:23
 * To change this template use File | Settings | File Templates.
 */
public abstract class SmartActionUIPanel extends JPanel {
  private Runnable myOnOk = null;

  public abstract void fillActionContext();

  public void setOnOk(Runnable onOk) {
    myOnOk = onOk;
  }
  
  public void ok() {
    if (myOnOk != null) {
      myOnOk.run();
    }
  }
}
