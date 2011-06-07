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
package jetbrains.mps.ide.editorTabs.tabfactory.tabs.plaintabs;

import com.intellij.ide.DataManager;
import com.intellij.openapi.Disposable;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.IdeActions;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.actionSystem.impl.ActionButton;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Pair;
import com.intellij.ui.PrevNextActionsDescriptor;
import com.intellij.ui.TabbedPaneWrapper.AsJBTabs;
import com.intellij.ui.tabs.JBTabs;
import jetbrains.mps.ide.editorTabs.EditorTabDescriptor;
import jetbrains.mps.ide.editorTabs.tabfactory.NodeChangeCallback;
import jetbrains.mps.ide.editorTabs.tabfactory.tabs.AddAspectAction;
import jetbrains.mps.ide.editorTabs.tabfactory.tabs.BaseTabsComponent;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SNodePointer;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlainTabsComponent extends BaseTabsComponent {
  private List<PlainEditorTab> myRealTabs = new ArrayList<PlainEditorTab>();
  private AsJBTabs myJbTabs;

/*
  private final NodeChangeCallback myNodeChangeCallback = new NodeChangeCallback() {
    public void changeNode(SNode newNode) {
      onNodeChange(newNode);
    }
  };
*/

  public PlainTabsComponent(SNodePointer baseNode, Set<EditorTabDescriptor> possibleTabs, JComponent editor, NodeChangeCallback callback, boolean showGrayed) {
    super(baseNode, possibleTabs, editor, callback, showGrayed);

    DataContext dataContext = DataManager.getInstance().getDataContext(myEditor);
    Project project = PlatformDataKeys.PROJECT.getData(dataContext);

    PrevNextActionsDescriptor navigation = new PrevNextActionsDescriptor(IdeActions.ACTION_NEXT_EDITOR_TAB, IdeActions.ACTION_PREVIOUS_EDITOR_TAB);
    myJbTabs = new AsJBTabs(project, SwingConstants.BOTTOM, navigation, new Disposable() {
      public void dispose() {
        //todo
      }
    });
    decorate(myJbTabs.getTabs());

    getComponent().add(createAddNodeComponent(), BorderLayout.WEST);
    getComponent().add(myJbTabs.getTabs().getComponent(), BorderLayout.CENTER);

    updateTabs();

    myJbTabs.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            int index = myJbTabs.getSelectedIndex();

            //todo show grayed
            SNode node = myRealTabs.get(index).getNode();
            if (node != null) {
              myCallback.changeNode(node);
            }
          }
        });
      }
    });
  }

  private void decorate(JBTabs jbTabs) {
    jbTabs.getPresentation()
      .setPaintBorder(0, 0, 0, 0)
      .setAdjustBorders(true)
      .setGhostsAlwaysVisible(true);
  }

  private JComponent createAddNodeComponent() {
    AddAspectAction action = new AddAspectAction(myBaseNode, myPossibleTabs, myCallback) {
      protected SNode getCurrentAspect() {
        return null;//todo
      }
    };
    return new ActionButton(action, action.getTemplatePresentation(), ActionPlaces.UNKNOWN, new Dimension(23, 23));
  }

  protected void updateTabs() {
    myJbTabs.removeAll();

    List<Pair<EditorTabDescriptor, List<SNode>>> newContent = updateDocumentsAndNodes();

    //todo sort
    JLabel fill = new JLabel("");
    for (Pair<EditorTabDescriptor, List<SNode>> p : newContent) {
      for (SNode node : p.second) {
        myRealTabs.add(new PlainEditorTab(node));
        myJbTabs.addTab(node.getPresentation(), fill);
      }
    }

/*
    myRealTabs.clear();

    for (EditorTabDescriptor key : newContent.keySet()) {
      myRealTabs.add(new EditorTab(this, myNodeChangeCallback, myRealTabs.size(), key, myBaseNode));
    }

    DefaultActionGroup group = new DefaultActionGroup();
    group.add(myAddAction);
    for (EditorTab tab : myRealTabs) {
      group.add(tab.getAction(myEditor));
    }
*/
  }

  protected void nextTab() {
    int i = myJbTabs.getSelectedIndex();
    if (i < myJbTabs.getTabCount() - 1) {
      myJbTabs.setSelectedIndex(i + 1);
    }
  }

  protected void prevTab() {
    int i = myJbTabs.getSelectedIndex();
    if (i > 0) {
      myJbTabs.setSelectedIndex(i - 1);
    }
  }

  protected boolean checkNodeAdded() {
/*
    outer:
    for (EditorTabDescriptor d : myPossibleTabs) {
      for (EditorTab tab : myRealTabs) {
        if (tab.getDescriptor() == d) continue outer;
      }

      if (!d.getNodes(myBaseNode.getNode()).isEmpty()) return true;
    }
    return false;
*/
    return false;
  }

  protected boolean checkNodeRemoved(SNodePointer node) {
/*
    if (myBaseNode.equals(node)) return false; //will be closed by idea

    if (getLastNode().equals(node)) {
      onNodeChange(myBaseNode.getNode());
    }

    return false;
*/
    return false;
  }
}
