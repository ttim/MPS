package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JList;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.project.GlobalScope;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.awt.BorderLayout;
import com.intellij.openapi.actionSystem.AnAction;
import jetbrains.mps.workbench.dialogs.project.components.parts.actions.ListAddAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.workbench.dialogs.project.components.parts.actions.ListRemoveAction;
import javax.swing.border.TitledBorder;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import com.intellij.openapi.actionSystem.ActionToolbar;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;

public class ListPanel extends JPanel {
  private JList myListComponent;
  private List<ITestNodeWrapper> myValues = ListSequence.fromList(new ArrayList<ITestNodeWrapper>());
  private List<ITestNodeWrapper> myCandidates;
  private boolean myIsTestMethods;
  private ActionListener myListener;
  private ListPanel.MyAbstractListModel myListModel;

  public ListPanel() {
  }

  private void collectCandidates() {
    final List<SNode> nodesList = new ArrayList<SNode>();
    for (final SNode concept : Sequence.fromIterable(TestNodeWrapperFactory.getWrappedConcepts(!(myIsTestMethods)))) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          // todo be smarter 
          ListSequence.fromList(nodesList).addSequence(SetSequence.fromSet(FindUsagesManager.getInstance().findInstances(((AbstractConceptDeclaration) SNodeOperations.getAdapter(concept)), GlobalScope.getInstance(), new FindUsagesManager.ProgressAdapter(new EmptyProgressIndicator()), false)));
        }
      });
    }
    if (this.myIsTestMethods) {
      final List<ITestNodeWrapper> methodsList = ListSequence.fromList(new ArrayList<ITestNodeWrapper>());
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          for (SNode testCase : nodesList) {
            ITestNodeWrapper wrapper = TestNodeWrapperFactory.tryToWrap(testCase);
            if (wrapper == null) {
              continue;
            }
            ListSequence.fromList(methodsList).addSequence(Sequence.fromIterable(wrapper.getTestMethods()));
          }
        }
      });
      this.myCandidates = methodsList;
    } else {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          ListPanel.this.myCandidates = ListSequence.fromList(nodesList).select(new ISelector<SNode, ITestNodeWrapper>() {
            public ITestNodeWrapper select(SNode it) {
              return TestNodeWrapperFactory.tryToWrap(it);
            }
          }).where(new IWhereFilter<ITestNodeWrapper>() {
            public boolean accept(ITestNodeWrapper it) {
              return it != null;
            }
          }).toListSequence();
        }
      });
    }
  }

  public void addItem(ITestNodeWrapper item) {
    ListSequence.fromList(this.myValues).addElement(item);
    this.myListComponent.updateUI();
  }

  public void addActionListener(ActionListener listener) {
    this.myListener = listener;
  }

  public Object getItems() {
    return this.myValues;
  }

  public void clear() {
    ListSequence.fromList(this.myValues).removeSequence(ListSequence.fromList(this.myValues));
    this.myListComponent.updateUI();
  }

  public void init(List<ITestNodeWrapper> nodes, final boolean isTestMethods) {
    this.myIsTestMethods = isTestMethods;
    this.setLayout(new BorderLayout());
    this.myValues = nodes;
    this.myListModel = new ListPanel.MyAbstractListModel();
    this.myListComponent = new JList(this.myListModel);
    AnAction add = new ListAddAction(this.myListComponent) {
      protected int doAdd(AnActionEvent p0) {
        if (ListPanel.this.myCandidates == null) {
          ListPanel.this.collectCandidates();
        }
        ListSequence.fromList(ListPanel.this.myCandidates).removeSequence(ListSequence.fromList(ListPanel.this.myValues));
        final SNode resultNode = CommonChoosers.showDialogNodeChooser(ListPanel.this, ListSequence.fromList(ListPanel.this.myCandidates).select(new ISelector<ITestNodeWrapper, SNode>() {
          public SNode select(ITestNodeWrapper it) {
            return it.getNode();
          }
        }).toListSequence());
        if (resultNode == null) {
          return -1;
        }
        final Wrappers._T<ITestNodeWrapper> wrapper = new Wrappers._T<ITestNodeWrapper>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            wrapper.value = TestNodeWrapperFactory.tryToWrap(resultNode);
          }
        });
        if (wrapper.value == null) {
          return -1;
        }
        ListSequence.fromList(ListPanel.this.myValues).addElement(wrapper.value);
        if (ListPanel.this.myListener != null) {
          ListPanel.this.myListener.actionPerformed(null);
        }
        ListPanel.this.myListComponent.updateUI();
        ListPanel.this.myListModel.fireSomethingChanged();
        return ListSequence.fromList(ListPanel.this.myValues).indexOf(wrapper.value);
      }
    };
    AnAction remove = new ListRemoveAction(this.myListComponent) {
      protected void doRemove(AnActionEvent p0) {
        for (Object value : ListPanel.this.myListComponent.getSelectedValues()) {
          for (final ITestNodeWrapper node : ListPanel.this.myValues) {
            final Wrappers._T<String> fqName = new Wrappers._T<String>();
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                fqName.value = node.getFqName();
              }
            });
            if (fqName.value.equals(value)) {
              ListSequence.fromList(ListPanel.this.myValues).removeElement(node);
              break;
            }
          }
        }
        if (ListPanel.this.myListener != null) {
          ListPanel.this.myListener.actionPerformed(null);
        }
        ListPanel.this.myListComponent.updateUI();
        ListPanel.this.myListModel.fireSomethingChanged();
      }
    };

    this.setBorder(new TitledBorder("Test"));

    DefaultActionGroup group = ActionUtils.groupFromActions(add, remove);
    ActionToolbar toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, false);
    this.add(toolbar.getComponent(), BorderLayout.WEST);

    JScrollPane comp = new JScrollPane(this.myListComponent);
    comp.doLayout();
    this.add(comp, BorderLayout.CENTER);

    this.add(new JLabel((this.myIsTestMethods ?
      "Methods" :
      "Classes"
    )), BorderLayout.PAGE_START);
    this.myListComponent.updateUI();
  }

  private class MyAbstractListModel extends AbstractListModel {
    public MyAbstractListModel() {
    }

    public Object getElementAt(final int p0) {
      final Wrappers._T<String> name = new Wrappers._T<String>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          name.value = ListSequence.fromList(ListPanel.this.myValues).getElement(p0).getFqName();
        }
      });
      return name.value;
    }

    public int getSize() {
      return ListSequence.fromList(ListPanel.this.myValues).count();
    }

    public void fireSomethingChanged() {
      fireContentsChanged(this, 0, ListSequence.fromList(myValues).count());
    }
  }
}
