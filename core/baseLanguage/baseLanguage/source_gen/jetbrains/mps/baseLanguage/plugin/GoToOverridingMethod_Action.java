package jetbrains.mps.baseLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.IOperationContext;
import java.awt.Frame;
import com.intellij.openapi.project.Project;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.ide.findusages.findalgorithm.finders.GeneratedFinder;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.project.GlobalScope;
import com.intellij.ui.awt.RelativePoint;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import java.awt.Point;

public class GoToOverridingMethod_Action extends GeneratedAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(GoToOverridingMethod_Action.class);

  private SNode methodNode;
  private EditorComponent editorComponent;
  private EditorContext editorContext;
  private IOperationContext context;
  private Frame frame;
  private Project project;
  private List<String> finderClasses;

  public GoToOverridingMethod_Action(List<String> finderClasses_par) {
    super("Go to Overriding Methods", "", ICON);
    this.finderClasses = finderClasses_par;
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @NotNull
  public String getKeyStroke() {
    return "";
  }

  public boolean isApplicable(AnActionEvent event) {
    for (String finderClass : GoToOverridingMethod_Action.this.finderClasses) {
      if (FindUtils.getFinderByClassName(finderClass).isApplicable(GoToOverridingMethod_Action.this.methodNode)) {
        return true;
      }
    }
    return false;
  }

  public void doUpdate(@NotNull AnActionEvent event) {
    try {
      {
        boolean enabled = this.isApplicable(event);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "GoToOverridingMethod", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event) {
    if (!(super.collectActionData(event))) {
      return false;
    }
    {
      SNode node = event.getData(MPSDataKeys.NODE);
      if (node != null) {
        if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"))) {
          node = null;
        }
      }
      this.methodNode = node;
    }
    if (this.methodNode == null) {
      return false;
    }
    this.editorComponent = event.getData(MPSDataKeys.EDITOR_COMPONENT);
    if (this.editorComponent == null) {
      return false;
    }
    this.editorContext = event.getData(MPSDataKeys.EDITOR_CONTEXT);
    if (this.editorContext == null) {
      return false;
    }
    this.context = event.getData(MPSDataKeys.OPERATION_CONTEXT);
    if (this.context == null) {
      return false;
    }
    this.frame = event.getData(MPSDataKeys.FRAME);
    if (this.frame == null) {
      return false;
    }
    this.project = event.getData(MPSDataKeys.PROJECT);
    if (this.project == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event) {
    try {
      final List<String> finders = ListSequence.fromList(new ArrayList<String>());
      final String[] methodName = new String[1];
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          methodName[0] = SPropertyOperations.getString(GoToOverridingMethod_Action.this.methodNode, "name");
          for (String finderClass : GoToOverridingMethod_Action.this.finderClasses) {
            GeneratedFinder finder = FindUtils.getFinderByClassName(finderClass);
            if (finder.isApplicable(GoToOverridingMethod_Action.this.methodNode)) {
              ListSequence.fromList(finders).addElement(finderClass);
            }
          }
        }
      });

      final Set<SNode> nodes = SetSequence.fromSet(new HashSet<SNode>());
      ProgressManager.getInstance().run(new Task.Modal(GoToOverridingMethod_Action.this.project, "Searching...", true) {
        public void run(@NotNull final ProgressIndicator p) {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              for (String finder : ListSequence.fromList(finders)) {
                SetSequence.fromSet(nodes).addSequence(ListSequence.fromList(FindUtils.executeFinder(finder, GoToOverridingMethod_Action.this.methodNode, GlobalScope.getInstance(), p)));
              }
            }
          });
        }
      });

      RelativePoint relativePoint;
      if (event.getInputEvent() instanceof MouseEvent) {
        relativePoint = new RelativePoint((MouseEvent) event.getInputEvent());
      } else {
        Rectangle cellBounds = GoToOverridingMethod_Action.this.editorContext.getSelectedCell().getBounds();
        Point point = new Point(((int) cellBounds.getMinX()), ((int) cellBounds.getMaxY()));
        relativePoint = new RelativePoint(GoToOverridingMethod_Action.this.editorComponent, point);
      }
      GoToHelper.showOverridingMethodsMenu(SetSequence.fromSet(nodes).toListSequence(), relativePoint, GoToOverridingMethod_Action.this.project, methodName[0]);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "GoToOverridingMethod", t);
    }
  }

  @NotNull
  public String getActionId() {
    StringBuilder res = new StringBuilder();
    res.append(super.getActionId());
    res.append("#");
    res.append(finderClasses_State((List<String>) this.finderClasses));
    res.append("!");
    return res.toString();
  }

  public static String finderClasses_State(List<String> object) {
    StringBuilder result = new StringBuilder();
    for (String str : object) {
      result.append(str).append('+');
    }
    result.deleteCharAt(result.length() - 1);
    return result.toString();
  }
}
