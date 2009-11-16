package jetbrains.mps.ide.actions;

/*Generated by MPS */

import javax.swing.JPanel;
import jetbrains.mps.ide.findusages.INavigator;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.findusages.view.UsagesView;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import jetbrains.mps.ide.findusages.view.treeholder.treeview.ViewOptions;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.ide.findusages.findalgorithm.finders.IFinder;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.ide.icons.IconManager;
import java.util.List;
import jetbrains.mps.ide.projectPane.Icons;
import jetbrains.mps.project.IModule;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.view.treeholder.treeview.INodeRepresentator;
import jetbrains.mps.nodeEditor.MessageStatus;
import jetbrains.mps.ide.findusages.view.treeholder.tree.TextOptions;
import org.apache.commons.lang.StringEscapeUtils;
import org.jdom.Element;
import jetbrains.mps.ide.findusages.CantSaveSomethingException;
import jetbrains.mps.ide.findusages.CantLoadSomethingException;

public abstract class ModelCheckerViewer extends JPanel implements INavigator {
  private MPSProject myProject;
  private IOperationContext myOperationContext;
  private UsagesView myUsagesView;
  private String myTabTitle;
  private Icon myTabIcon;
  private Runnable myGenerateRunnable;
  private Runnable myRecheckRunnable;
  private JButton myGenerateButton;
  private JButton myRecheckButton;
  private JButton myFixButton;
  private boolean myAlreadyCheckedSomething;

  public ModelCheckerViewer(MPSProject mpsProject, IOperationContext operationContext) {
    this.myProject = mpsProject;
    this.myOperationContext = operationContext;

    this.setLayout(new BorderLayout());
    ViewOptions viewOptions = new ViewOptions(true, false, false, false, false);
    viewOptions.myCategory = true;
    viewOptions.myShowPopupMenu = false;

    this.myUsagesView = new UsagesView(mpsProject, viewOptions) {
      public void close() {
        ModelCheckerViewer.this.close();
      }
    };
    this.myUsagesView.setCustomNodeRepresentator(new ModelCheckerViewer.MyNodeRepresentator());
    this.add(this.myUsagesView.getComponent(), BorderLayout.CENTER);

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    this.myGenerateButton = new JButton("Generate");
    this.myGenerateButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        assert ModelCheckerViewer.this.myGenerateRunnable != null;
        ModelCheckerViewer.this.myGenerateRunnable.run();
      }
    });
    this.myGenerateButton.setVisible(false);

    this.myRecheckButton = new JButton("Recheck");
    this.myRecheckButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        assert ModelCheckerViewer.this.myRecheckRunnable != null;
        ModelCheckerViewer.this.myRecheckRunnable.run();
      }
    });
    this.myRecheckButton.setVisible(false);

    this.myFixButton = new JButton("Perform Quick Fixes");
    this.myFixButton.setToolTipText("Remove all undeclared children and undeclared references");
    this.myFixButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        ModelCheckerViewer.this.performQuickFixes();
      }
    });

    buttonPanel.add(this.myGenerateButton);
    buttonPanel.add(this.myRecheckButton);
    buttonPanel.add(this.myFixButton);
    this.add(buttonPanel, BorderLayout.SOUTH);
  }

  protected abstract void close();

  public void performQuickFixes() {
    // Ask if need to fix 
    int dialogAnswer = Messages.showYesNoDialog(this.myOperationContext.getProject(), "You are going to remove undeclared properties and children from nodes. " + "You may not be able to undo it. Are you sure?", "Warning", null);
    if (dialogAnswer != 0) {
      return;
    }

    // Perform quick fixes 
    final Wrappers._int fixedTotal = new Wrappers._int(0);
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        for (SearchResult<ModelCheckerIssue> result : ListSequence.fromList(ModelCheckerViewer.this.getSearchResults().getSearchResults())) {
          ModelCheckerIssue issue = result.getObject();
          if (issue.isFixable() && issue.fix()) {
            fixedTotal.value++;
          }
        }
      }
    });

    // Perform recheck if needed 
    if (fixedTotal.value != 0) {
      int dialogAnswer1 = Messages.showYesNoDialog(this.myOperationContext.getProject(), "Model checker fixed " + fixedTotal.value + " issues. Do you wish to recheck?", "Recheck", null);
      if (dialogAnswer1 != 0) {
        return;
      }
      assert ModelCheckerViewer.this.myRecheckRunnable != null;
      ModelCheckerViewer.this.myRecheckRunnable.run();
    }
  }

  private void checkSomething(final IFinder finder, String taskTitle) {
    if (!(this.myAlreadyCheckedSomething)) {
      IResultProvider resultProvider = FindUtils.makeProvider(finder);
      SearchQuery searchQuery = new SearchQuery(ModelCheckerViewer.this.myProject.getScope());
      ModelCheckerViewer.this.myUsagesView.setRunOptions(resultProvider, searchQuery, new UsagesView.ButtonConfiguration(false, false, true));
    }

    this.myAlreadyCheckedSomething = true;

    ProgressManager.getInstance().run(new Task.Modal(this.myProject.getComponent(Project.class), taskTitle, true) {
      public void run(@NotNull ProgressIndicator indicator) {
        ModelCheckerViewer.this.myUsagesView.run(indicator);
      }
    });
  }

  private void setTabProperties(String title, Icon icon) {
    this.myTabTitle = title;
    this.myTabIcon = icon;
  }

  public void saveGenerationRunnable(Runnable runnable) {
    this.myGenerateRunnable = runnable;
    this.myGenerateButton.setVisible(runnable != null);
  }

  private void saveRecheckRunnable(Runnable runnable) {
    this.myRecheckRunnable = runnable;
    this.myRecheckButton.setVisible(runnable != null);
  }

  public void checkModel(final SModelDescriptor modelDescriptor) {
    this.saveRecheckRunnable(new Runnable() {
      public void run() {
        ModelCheckerViewer.this.checkModel(modelDescriptor);
      }
    });
    this.checkSomething(new ModelIssueFinder(this.myOperationContext, modelDescriptor), "Checking " + modelDescriptor.getLongName());
    this.setTabProperties(modelDescriptor.getName(), IconManager.getIconFor(modelDescriptor));
  }

  public void checkModels(final List<SModelDescriptor> modelDescriptors) {
    this.saveRecheckRunnable(new Runnable() {
      public void run() {
        ModelCheckerViewer.this.checkModels(modelDescriptors);
      }
    });
    this.checkSomething(new ModelsIssueFinder(this.myOperationContext, modelDescriptors), "Checking " + ListSequence.fromList(modelDescriptors).count() + " models");
    this.setTabProperties(ListSequence.fromList(modelDescriptors).count() + " models", Icons.MODEL_ICON);
  }

  public void checkModule(final IModule module) {
    this.saveRecheckRunnable(new Runnable() {
      public void run() {
        ModelCheckerViewer.this.checkModule(module);
      }
    });
    this.checkSomething(new ModuleIssueFinder(this.myOperationContext, module), "Checking " + module.getModuleFqName());
    this.setTabProperties(module.getModuleFqName(), IconManager.getIconFor(module));
  }

  public void checkModules(final List<IModule> modules) {
    this.saveRecheckRunnable(new Runnable() {
      public void run() {
        ModelCheckerViewer.this.checkModules(modules);
      }
    });
    this.checkSomething(new ModulesIssueFinder(this.myOperationContext, modules), "Checking " + ListSequence.fromList(modules).count() + " modules");
    this.setTabProperties(ListSequence.fromList(modules).count() + " modules", Icons.MODULE_GROUP_CLOSED);
  }

  public void checkProject(final MPSProject project) {
    this.saveRecheckRunnable(new Runnable() {
      public void run() {
        ModelCheckerViewer.this.checkProject(project);
      }
    });
    this.checkSomething(new ProjectIssueFinder(this.myOperationContext, project), "Checking " + project.getProjectDescriptor().getName());
    this.setTabProperties(project.getProjectDescriptor().getName(), Icons.PROJECT_ICON);
  }

  public UsagesView getUsagesView() {
    return this.myUsagesView;
  }

  public String getTabTitle() {
    return this.myTabTitle;
  }

  public Icon getTabIcon() {
    return this.myTabIcon;
  }

  public SearchResults<ModelCheckerIssue> getSearchResults() {
    return this.myUsagesView.getSearchResults();
  }

  public void goToPrevious() {
    this.myUsagesView.goToPrevious();
  }

  public void goToNext() {
    this.myUsagesView.goToNext();
  }

  public static class MyNodeRepresentator implements INodeRepresentator<ModelCheckerIssue> {
    public static final String CATEGORY_ERROR = MessageStatus.ERROR.toString();
    public static final String CATEGORY_WARNING = MessageStatus.WARNING.toString();
    public static final String CATEGORY_OK = MessageStatus.OK.toString();

    public MyNodeRepresentator() {
    }

    public String getResultsText(TextOptions options) {
      int size = options.mySubresultsCount;
      String sizeRepr = size + " issue" + ((size == 1 ?
        "" :
        "s"
      ));
      return "<strong>" + sizeRepr + " found</strong>";
    }

    public Icon getResultsIcon() {
      return Icons.CLOSED_FOLDER;
    }

    public String getCategoryText(TextOptions options, String category, boolean isResultsSection) {
      String counter = "";
      if (options.myCounters && isResultsSection) {
        int size = options.mySubresultsCount;
        counter = " (" + size + " issue" + ((size == 0 ?
          "" :
          "s"
        )) + ")";
      }
      String categoryRepr = "";
      if (CATEGORY_ERROR.equals(category)) {
        categoryRepr = "Errors";
      } else if (CATEGORY_WARNING.equals(category)) {
        categoryRepr = "Warnings";
      } else if (CATEGORY_OK.equals(category)) {
        categoryRepr = "Infos";
      }
      return "<strong>" + categoryRepr + counter + "</strong>";
    }

    public Icon getCategoryIcon(String category) {
      if (CATEGORY_ERROR.equals(category)) {
        return jetbrains.mps.ide.messages.Icons.ERROR_ICON;
      } else if (CATEGORY_WARNING.equals(category)) {
        return jetbrains.mps.ide.messages.Icons.WARNING_ICON;
      } else if (CATEGORY_OK.equals(category)) {
        return jetbrains.mps.ide.messages.Icons.INFORMATION_ICON;
      }
      return jetbrains.mps.ide.messages.Icons.ERROR_ICON;
    }

    public String getPresentation(ModelCheckerIssue issue) {
      return StringEscapeUtils.escapeHtml(issue.getMessage());
    }

    public void write(Element element, MPSProject project) throws CantSaveSomethingException {
    }

    public void read(Element element, MPSProject project) throws CantLoadSomethingException {
    }
  }
}
