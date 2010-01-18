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
package jetbrains.mps.cleanup;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.command.CommandAdapter;
import com.intellij.openapi.command.CommandEvent;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.smodel.ModelAccess;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CleanupManager implements ApplicationComponent {
  public static CleanupManager getInstance() {
    return ApplicationManager.getApplication().getComponent(CleanupManager.class);
  }

  private final Object myLock = new Object();
  private List<CleanupListener> myCleanupListeners = new ArrayList<CleanupListener>();

  @NonNls
  @NotNull
  public String getComponentName() {
    return "MPS Cleanup Manager";
  }

  public void initComponent() {
    CommandProcessor.getInstance().addCommandListener(new CommandAdapter() {
      public void beforeCommandFinished(CommandEvent event) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            cleanup();
          }
        });
      }
    });
  }

  public void disposeComponent() {

  }

  public void addCleanupListener(CleanupListener l) {
    synchronized (myLock) {
      myCleanupListeners.add(l);
    }
  }

  public void removeCleanupListener(CleanupListener l) {
    synchronized (myLock) {
      myCleanupListeners.remove(l);
    }
  }

  public void cleanup() {
    List<CleanupListener> listenersToInvoke = new ArrayList<CleanupListener>();
    synchronized (myLock) {
      listenersToInvoke.addAll(myCleanupListeners);
    }
    for (CleanupListener l : listenersToInvoke) {
      l.performCleanup();
    }
  }
}
