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
package jetbrains.mps.refactoring;

import com.intellij.ide.DataManager;
import jetbrains.mps.ide.findusages.findalgorithm.finders.specific.ConstantFinder;
import jetbrains.mps.ide.findusages.findalgorithm.finders.specific.ConstantFinder.ConstantHolder;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.ide.findusages.view.UsagesView;
import jetbrains.mps.ide.findusages.view.UsagesView.ButtonConfiguration;
import jetbrains.mps.ide.findusages.view.treeholder.treeview.ViewOptions;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.workbench.MPSDataKeys;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

public class RefactoringViewItem {
  private RefactoringViewAction myRefactoringViewAction;
  private SearchResults mySearchResults;
  private UsagesView myUsagesView;
  private JPanel myPanel;
  private JPanel myButtonsPanel;
  private JButton myDoRefactorButton;
  private JButton myCancelButton;
  private NewRefactoringView myNewRefactoringView;

  public RefactoringViewItem(
    @NotNull RefactoringViewAction refactoringViewAction,
    SearchResults searchResults,
    NewRefactoringView refactoringView) {
    myNewRefactoringView = refactoringView;
    myRefactoringViewAction = refactoringViewAction;
    mySearchResults = searchResults;
    if (mySearchResults == null) {
      throw new IllegalArgumentException("search result is null");
    }
    myPanel = new JPanel(new BorderLayout());
    myUsagesView = new UsagesView(MPSDataKeys.MPS_PROJECT.getData(DataManager.getInstance().getDataContext()), new ViewOptions()) {
      public void close() {
        cancel();
      }

      public String getCaption() {
        return "";
      }

      public Icon getIcon() {
        return null;
      }

      public void read(Element element, MPSProject project) {
      }

      public void write(Element element, MPSProject project) {
      }
    };
    myButtonsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    myDoRefactorButton = new JButton(new AbstractAction("Do Refactor") {
      public void actionPerformed(ActionEvent e) {
        doRefactor();
      }
    });
    myCancelButton = new JButton(new AbstractAction("Cancel") {
      public void actionPerformed(ActionEvent e) {
        cancel();
      }
    });
    myButtonsPanel.add(myDoRefactorButton);
    myButtonsPanel.add(myCancelButton);

    myPanel.add(myUsagesView.getComponent(), BorderLayout.CENTER);
    myPanel.add(myButtonsPanel, BorderLayout.SOUTH);
  }

  public JComponent getComponent() {
    return myPanel;
  }

  public UsagesView getUsagesView() {
    return myUsagesView;
  }

  /*package*/ void initUsagesView() {
    Thread thread = new Thread() {
      public void run() {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            myUsagesView.setRunOptions(FindUtils.makeProvider(new ConstantFinder()),
              new SearchQuery(new ConstantHolder(mySearchResults), GlobalScope.getInstance()),
              new ButtonConfiguration(false, false, true),
              mySearchResults);
          }
        });
      }
    };
    thread.start();
  }

  private void cancel() {
    close();
  }


  private void doRefactor() {
    myRefactoringViewAction.performAction(this);
  }

  public NewRefactoringView getRefactoringView() {
    return myNewRefactoringView;
  }

  public void close() {
    myNewRefactoringView.closeRefactoringView(this);
  }

  public void requestFocus() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        myDoRefactorButton.requestFocus();
      }
    });
  }
}
