package jetbrains.mps.ide.script.plugin.migrationtool;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.ide.ThreadUtils;
import java.awt.Frame;
import com.intellij.openapi.progress.TaskInfo;
import jetbrains.mps.smodel.ModelAccess;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.NonNls;
import java.util.Collections;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.ide.script.plugin.AbstractMigrationScriptHelper;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.progress.ProgressMonitorAdapter;
import com.intellij.openapi.command.CommandProcessorEx;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.command.UndoConfirmationPolicy;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import javax.swing.SwingUtilities;
import jetbrains.mps.project.MPSProject;

public class MigrationScriptExecutor {
  private Project project;
  private SNodePointer script;
  private IOperationContext context;
  private String title;

  public MigrationScriptExecutor(SNodePointer script, String title, IOperationContext context, Project project) {
    this.project = project;
    this.script = script;
    this.context = context;
    this.title = title;
  }

  public void execImmediately(ProgressMonitor promon) {
    ThreadUtils.assertEDT();
    Runnable process = createProcess(false, promon);
    process.run();
  }

  public void execAsCommand(Frame frame) {
    ThreadUtils.assertEDT();
    TaskInfo task = createTaskInfo();
    final Object cmd = startCommand(task);
    Runnable process = createProcess(true, null);
    Runnable afterFinish = new Runnable() {
      public void run() {
        ModelAccess.instance().runCommandInEDT(new Runnable() {
          public void run() {
            finishCommand(cmd);
          }
        }, getMPSProject());
      }
    };
    primExec(task, process, afterFinish, frame);
  }

  private TaskInfo createTaskInfo() {
    return new TaskInfo() {
      @NotNull
      public String getTitle() {
        return title;
      }

      public String getCancelText() {
        return null;
      }

      public String getCancelTooltipText() {
        return null;
      }

      public boolean isCancellable() {
        return false;
      }

      @NonNls
      public String getProcessId() {
        return "script";
      }
    };
  }

  private Runnable createProcess(final boolean spawnCommands, final ProgressMonitor monitor) {
    return new Runnable() {
      public void run() {
        final MigrationScriptFinder finder = new MigrationScriptFinder(Collections.singletonList(script), context);
        final MigrationScriptsController controller = new MigrationScriptsController(finder) {
          public void runCommand(Runnable cmd) {
            if (spawnCommands) {
              ModelAccess.instance().runCommandInEDT(cmd, getMPSProject());
            } else {
              cmd.run();
            }
          }
        };
        final ProgressMonitor promon = getOrCreateProgressMonitor(monitor);
        promon.start("Executing \"" + title + "\"", 200);

        final List<SearchResult<SNode>>[] searchResults = ((List<SearchResult<SNode>>[]) new List[1]);
        // can this be done? 
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            IScope scope = AbstractMigrationScriptHelper.createMigrationScope(Collections.<SModelDescriptor>emptyList(), getMPSProject().getModules());
            SearchResults results = finder.find(new SearchQuery(scope), promon.subTask(100));
            searchResults[0] = (List<SearchResult<SNode>>) results.getSearchResults();
          }
        });

        controller.process(promon.subTask(100), searchResults[0]);
      }
    };
  }

  private ProgressMonitor getOrCreateProgressMonitor(ProgressMonitor promon) {
    if (promon != null) {
      return promon;
    }
    ProgressIndicator prind = ProgressManager.getInstance().getProgressIndicator();
    prind = (prind != null ?
      prind :
      new EmptyProgressIndicator()
    );
    return new ProgressMonitorAdapter(prind);
  }

  private void primExec(TaskInfo task, final Runnable proc, final Runnable afterFinish, Frame frame) {
    Runnable process = new Runnable() {
      public void run() {
        proc.run();
        if (afterFinish != null) {
          afterFinish.run();
        }
      }
    };
    execAsync(process, task, frame);
  }

  private Object startCommand(TaskInfo task) {
    return ((CommandProcessorEx) CommandProcessor.getInstance()).startCommand(project, task.getTitle(), null, UndoConfirmationPolicy.REQUEST_CONFIRMATION);
  }

  private void finishCommand(Object cmd) {
    ((CommandProcessorEx) CommandProcessor.getInstance()).finishCommand(project, cmd, null);
  }

  private void execAsync(Runnable process, TaskInfo task, Frame frame) {
    ApplicationManagerEx.getApplicationEx().runProcessWithProgressSynchronously(process, task.getTitle(), task.isCancellable(), project, SwingUtilities.getRootPane(frame));
  }

  private MPSProject getMPSProject() {
    return project.getComponent(MPSProject.class);
  }
}
