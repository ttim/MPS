package jetbrains.mps.ide.editor.util;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.ui.awt.RelativePoint;
import jetbrains.mps.project.Project;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.navigation.NodeNavigatable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ListCellRenderer;
import jetbrains.mps.runtime.ModuleClassLoader;
import javax.swing.JList;
import com.intellij.ui.components.JBList;
import com.intellij.openapi.ui.popup.PopupChooserBuilder;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.progress.ProgressMonitorAdapter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.awt.Rectangle;
import java.awt.Point;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.presentation.NodePresentationUtil;
import javax.swing.Icon;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class GoToHelper {
  public GoToHelper() {
  }

  public static void showOverridingMethodsMenu(List<SNodePointer> nodes, RelativePoint point, Project project, String methodName) {
    String title = "Choose overriding method of " + methodName + "() to navigate to";
    GoToHelper.MethodCellRenderer renderer = new GoToHelper.MethodCellRenderer();
    GoToHelper.showMenu(point, project, title, nodes, renderer);
  }

  public static void showOverridenMethodsMenu(List<SNodePointer> nodes, RelativePoint point, Project project, String methodName) {
    String title = "Choose super method of" + methodName + "()";
    GoToHelper.MethodCellRenderer renderer = new GoToHelper.MethodCellRenderer();
    GoToHelper.showMenu(point, project, title, nodes, renderer);
  }

  public static void showInheritedClassesMenu(List<SNodePointer> nodes, RelativePoint point, Project project) {
    String title = "Choose inherited class to navigate to";
    GoToHelper.DefaultNodeNavigationItemCellRenderer renderer = new GoToHelper.DefaultNodeNavigationItemCellRenderer();
    GoToHelper.showMenu(point, project, title, nodes, renderer);
  }

  private static void showMenu(RelativePoint point, Project project, String title, List<SNodePointer> nodes, NodeListCellRenderer renderer) {
    if (ListSequence.fromList(nodes).isEmpty()) {
      return;
    }
    List<NodeNavigatable> navigatables = new ArrayList<NodeNavigatable>();
    for (SNodePointer node : nodes) {
      navigatables.add(new NodeNavigatable(project, node));
    }
    Collections.sort(navigatables, renderer.getComparator());
    GoToHelper.openTargets(point, navigatables, title, renderer);
  }

  private static void openTargets(RelativePoint p, List<NodeNavigatable> targets, String title, ListCellRenderer listRenderer) {
    assert !(GoToHelper.class.getClassLoader() instanceof ModuleClassLoader) : "if this class is loaded by a reloadable classloader, this will cause memleaks. See MPS-13481";
    if (targets.isEmpty()) {
      return;
    }
    if (targets.size() == 1) {
      targets.get(0).navigate(true);
    } else {
      final JList list = new JBList(targets.toArray());
      list.setCellRenderer(listRenderer);
      new PopupChooserBuilder(list).setTitle(title).setMovable(true).setItemChoosenCallback(new Runnable() {
        public void run() {
          int[] ids = list.getSelectedIndices();
          if (ids == null || ids.length == 0) {
            return;
          }
          Object[] selectedElements = list.getSelectedValues();
          for (Object element : selectedElements) {
            NodeNavigatable selected = (NodeNavigatable) element;
            selected.navigate(true);
          }
        }
      }).createPopup().show(p);
    }
  }

  public static boolean hasApplicableFinder(SNode node, String finderClassName) {
    return FindUtils.getFinderByClassName(finderClassName).isApplicable(node);
  }

  public static void executeFinders(final SNode method, EditorCell anchorCell, com.intellij.openapi.project.Project project, final String finderClassName) {
    final String[] methodName = new String[1];
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        methodName[0] = SPropertyOperations.getString(method, "name");
        assert FindUtils.getFinderByClassName(finderClassName).isApplicable(method);
      }
    });

    final Set<SNodePointer> nodes = SetSequence.fromSet(new HashSet<SNodePointer>());
    ProgressManager.getInstance().run(new Task.Modal(project, "Searching...", true) {
      public void run(@NotNull final ProgressIndicator p) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            List<SNode> list = FindUtils.executeFinder(finderClassName, method, GlobalScope.getInstance(), new ProgressMonitorAdapter(p));
            SetSequence.fromSet(nodes).addSequence(ListSequence.fromList(list).select(new ISelector<SNode, SNodePointer>() {
              public SNodePointer select(SNode it) {
                return new SNodePointer(it);
              }
            }));
          }
        });
      }
    });

    Rectangle cellBounds = anchorCell.getBounds();
    Point point = new Point(((int) cellBounds.getMinX()), ((int) cellBounds.getMaxY()));
    RelativePoint relPoint = new RelativePoint(anchorCell.getEditor(), point);

    GoToHelper.showOverridingMethodsMenu(SetSequence.fromSet(nodes).toListSequence(), relPoint, ProjectHelper.toMPSProject(project), methodName[0]);
  }

  public static class DefaultNodeNavigationItemCellRenderer extends NodeListCellRenderer<NodeNavigatable> {
    public DefaultNodeNavigationItemCellRenderer() {
    }

    public String getElementText(final NodeNavigatable element) {
      return ModelAccess.instance().runReadAction(new Computable<String>() {
        public String compute() {
          return getLabelNode(element).getPresentation();
        }
      });
    }

    protected String getContainerText(final NodeNavigatable element, String name) {
      return ModelAccess.instance().runReadAction(new Computable<String>() {
        public String compute() {
          return NodePresentationUtil.descriptionText(getContainerNode(element), false);
        }
      });
    }

    protected Icon getIcon(NodeNavigatable element) {
      return IconManager.getIconFor(getLabelNode(element));
    }

    protected SNode getLabelNode(NodeNavigatable element) {
      return element.getNodePointer().getNode();
    }

    protected SNode getContainerNode(NodeNavigatable element) {
      return getLabelNode(element).getTopmostAncestor();
    }
  }

  public static class MethodCellRenderer extends GoToHelper.DefaultNodeNavigationItemCellRenderer {
    public MethodCellRenderer() {
    }

    @Override
    public String getElementText(final NodeNavigatable element) {
      return ModelAccess.instance().runReadAction(new Computable<String>() {
        public String compute() {
          SNode labelNode = getLabelNode(element);
          if (SNodeOperations.isInstanceOf(labelNode, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration")) {
            if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(labelNode), "jetbrains.mps.baseLanguage.structure.EnumClass")) {
              return "Enum constant '" + labelNode.getName() + "' in " + SNodeOperations.getParent(labelNode).getPresentation();
            }
          }
          return labelNode.getPresentation();
        }
      });
    }

    protected SNode getLabelNode(NodeNavigatable element) {
      SNode node = element.getNodePointer().getNode();
      if (node == null) {
        return null;
      }
      SNode parentNode = SNodeOperations.getParent(node);
      return parentNode;
    }
  }
}
