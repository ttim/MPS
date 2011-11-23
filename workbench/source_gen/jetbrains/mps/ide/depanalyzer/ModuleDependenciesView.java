package jetbrains.mps.ide.depanalyzer;

/*Generated by MPS */

import javax.swing.JPanel;
import jetbrains.mps.workbench.tools.BaseTool;
import com.intellij.openapi.project.Project;
import java.awt.BorderLayout;
import com.intellij.openapi.actionSystem.ActionGroup;
import jetbrains.mps.workbench.action.ActionUtils;
import jetbrains.mps.workbench.tools.CloseAction;
import jetbrains.mps.ide.moduleDependencies.icons.Icons;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import javax.swing.JComponent;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.ui.Splitter;
import com.intellij.ui.components.JBScrollPane;
import javax.swing.event.TreeSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import java.util.List;
import jetbrains.mps.project.IModule;
import javax.swing.tree.TreePath;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import com.intellij.openapi.actionSystem.ToggleAction;
import javax.swing.Icon;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class ModuleDependenciesView extends JPanel {
  private DependencyTree myLeftTree;
  private DependencyPathTree myRightTree;

  public ModuleDependenciesView(BaseTool tool, Project project) {
    super(new BorderLayout());
    myLeftTree = new DependencyTree(project);
    myRightTree = new DependencyPathTree(project);

    ActionGroup group = ActionUtils.groupFromActions(new CloseAction(tool), new ModuleDependenciesView.MyToggleAction("Show Runtime Dependencies", Icons.RUNTIME, false, new _FunctionTypes._void_P1_E0<Boolean>() {
      public void invoke(Boolean b) {
        setShowRuntime(b);
      }
    }), new ModuleDependenciesView.MyToggleAction("Show Used Languages", Icons.USED_LANGUAGES_ICON, true, new _FunctionTypes._void_P1_E0<Boolean>() {
      public void invoke(Boolean b) {
        setShowUsedLanguages(b);
      }
    }), new ModuleDependenciesView.MyToggleAction("Show cycles", Icons.CYCLE_ICON, false, new _FunctionTypes._void_P1_E0<Boolean>() {
      public void invoke(Boolean b) {
        setShowCycles(b);
      }
    }), new ModuleDependenciesView.MyToggleAction("Show all paths", jetbrains.mps.ide.projectPane.Icons.DEFAULT_ICON, false, new _FunctionTypes._void_P1_E0<Boolean>() {
      public void invoke(Boolean b) {
        setShowAllPaths(b);
      }
    }));

    JComponent toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, true).getComponent();
    add(toolbar, BorderLayout.NORTH);

    Splitter splitter = new Splitter();
    add(splitter, BorderLayout.CENTER);
    splitter.setFirstComponent(new JBScrollPane(myLeftTree));
    splitter.setSecondComponent(new JBScrollPane(myRightTree));

    myLeftTree.addTreeSelectionListener(new TreeSelectionListener() {
      public void valueChanged(TreeSelectionEvent e) {
        rebuildDependencies();
      }
    });
  }

  public void setModules(List<IModule> modules) {
    myLeftTree.setModules(modules);
    resetAll();
  }

  public void rebuildDependencies() {
    // rebuild right tree based on selection in the left 
    myRightTree.resetDependencies();
    TreePath[] paths = myLeftTree.getSelectionPaths();
    if (paths != null) {
      Map<List<IModule>, List<IModule>> dependencies = MapSequence.fromMap(new HashMap<List<IModule>, List<IModule>>());
      Map<List<IModule>, List<IModule>> usedlanguages = MapSequence.fromMap(new HashMap<List<IModule>, List<IModule>>());
      for (TreePath path : paths) {
        Object o = path.getLastPathComponent();
        if (o instanceof ModuleDependencyNode) {
          ModuleDependencyNode node = (ModuleDependencyNode) o;
          List<IModule> from = check_jxc64t_a0b0b0c0d0b(node.getFromNode());
          if (from != null) {
            Map<List<IModule>, List<IModule>> collection = (node.isUsedLanguage() ?
              usedlanguages :
              dependencies
            );
            if (!(MapSequence.fromMap(collection).containsKey(from))) {
              MapSequence.fromMap(collection).put(from, ListSequence.fromList(new ArrayList<IModule>()));
            }
            ListSequence.fromList(MapSequence.fromMap(collection).get(from)).addSequence(ListSequence.fromList(node.getModules()));
          }
        }
      }
      for (List<IModule> key : SetSequence.fromSet(MapSequence.fromMap(dependencies).keySet()).union(SetSequence.fromSet(MapSequence.fromMap(usedlanguages).keySet()))) {
        myRightTree.addDependency(key, MapSequence.fromMap(dependencies).get(key), MapSequence.fromMap(usedlanguages).get(key));
      }
    }
    myRightTree.rebuildNow();
    myRightTree.expandAll();
  }

  public void setShowRuntime(boolean b) {
    myLeftTree.setShowRuntime(b);
    myRightTree.setShowRuntime(b);
    resetAll();
  }

  public void setShowUsedLanguages(boolean b) {
    myLeftTree.setShowUsedLanguage(b);
    resetAll();
  }

  public void setShowCycles(boolean b) {
    myLeftTree.rebuildLater();
    myRightTree.rebuildLater();
  }

  public void setShowAllPaths(boolean b) {
    myRightTree.setShowAllPaths(b);
    myRightTree.rebuildLater();
  }

  public void resetAll() {
    myLeftTree.rebuildLater();
    rebuildDependencies();
  }

  private static List<IModule> check_jxc64t_a0b0b0c0d0b(ModuleDependencyNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModules();
    }
    return null;
  }

  public static class MyToggleAction extends ToggleAction {
    private boolean myValue;
    private _FunctionTypes._void_P1_E0<? super Boolean> mySetValue;

    public MyToggleAction(String title, Icon icon, boolean value, _FunctionTypes._void_P1_E0<? super Boolean> setValue) {
      super(title, title, icon);
      myValue = value;
      mySetValue = setValue;
    }

    public void setSelected(AnActionEvent event, boolean b) {
      mySetValue.invoke(myValue = b);
    }

    public boolean isSelected(AnActionEvent event) {
      return myValue;
    }
  }
}
