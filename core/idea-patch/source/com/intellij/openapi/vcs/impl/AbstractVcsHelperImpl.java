/*
 * Copyright 2000-2010 JetBrains s.r.o.
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
package com.intellij.openapi.vcs.impl;

import com.intellij.ide.actions.CloseTabToolbarAction;
import com.intellij.ide.errorTreeView.ErrorTreeElementKind;
import com.intellij.ide.errorTreeView.HotfixData;
import com.intellij.ide.errorTreeView.SimpleErrorData;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.application.Application;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.application.PathManager;
import com.intellij.openapi.command.CommandProcessor;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.diff.*;
import com.intellij.openapi.fileEditor.FileDocumentManager;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeManager;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.util.Getter;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vcs.*;
import com.intellij.openapi.vcs.annotate.Annotater;
import com.intellij.openapi.vcs.annotate.AnnotationProvider;
import com.intellij.openapi.vcs.annotate.FileAnnotation;
import com.intellij.openapi.vcs.changes.BackgroundFromStartOption;
import com.intellij.openapi.vcs.changes.Change;
import com.intellij.openapi.vcs.changes.committed.*;
import com.intellij.openapi.vcs.changes.ui.*;
import com.intellij.openapi.vcs.ex.ProjectLevelVcsManagerEx;
import com.intellij.openapi.vcs.history.*;
import com.intellij.openapi.vcs.merge.MergeData;
import com.intellij.openapi.vcs.merge.MergeProvider;
import com.intellij.openapi.vcs.merge.MultipleFileMergeDialog;
import com.intellij.openapi.vcs.versionBrowser.ChangeBrowserSettings;
import com.intellij.openapi.vcs.versionBrowser.ChangesBrowserSettingsEditor;
import com.intellij.openapi.vcs.versionBrowser.CommittedChangeList;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowId;
import com.intellij.openapi.wm.ToolWindowManager;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.intellij.ui.content.ContentManager;
import com.intellij.ui.content.MessageView;
import com.intellij.util.AsynchConsumer;
import com.intellij.util.BufferedListConsumer;
import com.intellij.util.Consumer;
import com.intellij.util.ContentsUtil;
import com.intellij.util.io.ZipUtil;
import com.intellij.util.ui.ConfirmationDialog;
import com.intellij.util.ui.ErrorTreeView;
import com.intellij.util.ui.MessageCategory;
import jetbrains.mps.fileTypes.MPSFileTypeFactory;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.util.annotation.Patch;
import jetbrains.mps.vcs.ApplicationLevelVcsManager;
import jetbrains.mps.vcs.ModelUtils;
import jetbrains.mps.vcs.VcsHelper.VcsMergeVersion;
import jetbrains.mps.vcs.diff.MPSDiffRequestFactory.ModelMergeRequest;
import jetbrains.mps.vfs.VFileSystem;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.awt.Component;
import java.io.*;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import java.util.*;

/**
 * This class was patched by MPS in order to add backup of conflicted filas before conflict resolving.
 * Changes were made in showMergeDialog method.
 * It was also patched in order to fix multiple merge dialog problem,
 * when MPS and IDEA both displayed merge dialog for the same file.
 * see showMergeDialog method for more details
 * <p/>
 * Third patch was performed in order to fix problem with two message views
 * MessageView.SERVICE.getInstance(myProject)
 * was replaced with
 * myProject.getComponent(jetbrains.mps.ide.messages.MessagesViewTool.class)
 * everywhere in this file
 */
public class AbstractVcsHelperImpl extends AbstractVcsHelper {
  private static final Logger LOG = Logger.getInstance("#com.intellij.openapi.vcs.impl.AbstractVcsHelperImpl");
  private static final jetbrains.mps.logging.Logger MPS_LOG = jetbrains.mps.logging.Logger.getLogger(AbstractVcsHelperImpl.class);

  private final Project myProject;

  public AbstractVcsHelperImpl(Project project) {
    myProject = project;
  }

  @Patch
  public void openMessagesView(final VcsErrorViewPanel errorTreeView, final String tabDisplayName) {
    CommandProcessor commandProcessor = CommandProcessor.getInstance();
    commandProcessor.executeCommand(myProject, new Runnable() {
      @Patch
      public void run() {
        // MPS Patch Start
        final MessageView messageView = myProject.getComponent(jetbrains.mps.ide.messages.MessagesViewTool.class);
        // MPS Patch End
        messageView.runWhenInitialized(new Runnable() {
          public void run() {
            final Content content =
              ContentFactory.SERVICE.getInstance().createContent(errorTreeView, tabDisplayName, true);
            messageView.getContentManager().addContent(content);
            Disposer.register(content, errorTreeView);
            messageView.getContentManager().setSelectedContent(content);
            removeContents(content, tabDisplayName);

            // MPS Patch Start
            myProject.getComponent(jetbrains.mps.ide.messages.MessagesViewTool.class).getToolWindow().activate(null);
            // MPS Patch End
          }
        });
      }
    }, VcsBundle.message("command.name.open.error.message.view"), null);
  }

  public void showFileHistory(final VcsHistoryProvider vcsHistoryProvider, final FilePath path, final AbstractVcs vcs,
                              final String repositoryPath) {
    showFileHistory(vcsHistoryProvider, null, path, repositoryPath, vcs);
  }

  private static class MyVcsAppendableHistorySessionPartner implements VcsAppendableHistorySessionPartner {
    private FileHistoryPanelImpl myFileHistoryPanel;
    private final VcsHistoryProvider myVcsHistoryProvider;
    private final AnnotationProvider myAnnotationProvider;
    private final FilePath myPath;
    private final String myRepositoryPath;
    private final AbstractVcs myVcs;
    private final Runnable myRefresher;
    private VcsAbstractHistorySession mySession;
    private BufferedListConsumer<VcsFileRevision> myBuffer;

    private MyVcsAppendableHistorySessionPartner(final VcsHistoryProvider vcsHistoryProvider, final AnnotationProvider annotationProvider,
                                                 final FilePath path,
                                                 final String repositoryPath,
                                                 final AbstractVcs vcs,
                                                 final Runnable refresher) {
      myVcsHistoryProvider = vcsHistoryProvider;
      myAnnotationProvider = annotationProvider;
      myPath = path;
      myRepositoryPath = repositoryPath;
      myVcs = vcs;
      myRefresher = refresher;
      myBuffer = new BufferedListConsumer<VcsFileRevision>(5, new Consumer<List<VcsFileRevision>>() {
        public void consume(List<VcsFileRevision> vcsFileRevisions) {
          mySession.getRevisionList().addAll(vcsFileRevisions);
          ApplicationManager.getApplication().invokeLater(new Runnable() {
            public void run() {
              myFileHistoryPanel.getHistoryPanelRefresh().consume(mySession);
            }
          });
        }
      }, 1000);
    }

    public void acceptRevision(VcsFileRevision revision) {
      myBuffer.consumeOne(revision);
    }

    public void reportCreatedEmptySession(final VcsAbstractHistorySession session) {
      mySession = session;
      if (myFileHistoryPanel != null) {
        ApplicationManager.getApplication().invokeLater(new Runnable() {
          public void run() {
            myFileHistoryPanel.getHistoryPanelRefresh().consume(mySession);
          }
        });
        return;
      }
      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          String actionName = VcsBundle.message("action.name.file.history", myPath.getName());
          ContentManager contentManager = ProjectLevelVcsManagerEx.getInstanceEx(myVcs.getProject()).getContentManager();

          myFileHistoryPanel = new FileHistoryPanelImpl(myVcs.getProject(), myPath, myRepositoryPath, session, myVcsHistoryProvider,
            myAnnotationProvider, contentManager, myRefresher);
          Content content = ContentFactory.SERVICE.getInstance().createContent(myFileHistoryPanel, actionName, true);
          ContentsUtil.addOrReplaceContent(contentManager, content, true);

          ToolWindow toolWindow = ToolWindowManager.getInstance(myVcs.getProject()).getToolWindow(ToolWindowId.VCS);
          toolWindow.activate(null);
        }
      });
    }

    public void reportException(VcsException exception) {
      ChangesViewBalloonProblemNotifier.showMe(myVcs.getProject(), VcsBundle.message("message.title.could.not.load.file.history") + ": " +
        exception.getMessage(), MessageType.ERROR);
    }

    public void finished() {
      myBuffer.flush();
      ApplicationManager.getApplication().invokeLater(new Runnable() {
        public void run() {
          if (myFileHistoryPanel != null) {
            myFileHistoryPanel.getHistoryPanelRefresh().finished();
          }
        }
      });
    }
  }

  private static class MyRefresher implements Runnable {
    private MyVcsAppendableHistorySessionPartner mySessionPartner;
    private final VcsHistoryProvider myVcsHistoryProvider;
    private final FilePath myPath;
    private final AbstractVcs myVcs;

    private MyRefresher(final VcsHistoryProvider vcsHistoryProvider, final AnnotationProvider annotationProvider, final FilePath path,
                        final String repositoryPath, final AbstractVcs vcs) {
      myVcsHistoryProvider = vcsHistoryProvider;
      myPath = path;
      myVcs = vcs;
      mySessionPartner = new MyVcsAppendableHistorySessionPartner(vcsHistoryProvider, annotationProvider, path, repositoryPath, vcs, this);
    }

    public void run() {
      final VcsHistoryProviderBackgroundableProxy proxy = new VcsHistoryProviderBackgroundableProxy(myVcs.getProject(), myVcsHistoryProvider);
      proxy.executeAppendableSession(myPath, mySessionPartner, null, false);
    }
  }

  public void showFileHistory(final VcsHistoryProvider vcsHistoryProvider, final AnnotationProvider annotationProvider, final FilePath path,
                              final String repositoryPath, final AbstractVcs vcs) {
    final MyRefresher refresher = new MyRefresher(vcsHistoryProvider, annotationProvider, path, repositoryPath, vcs);
    refresher.run();
  }

  public void showRollbackChangesDialog(List<Change> changes) {
    RollbackChangesDialog.rollbackChanges(myProject, changes);
  }

  @Nullable
  public Collection<VirtualFile> selectFilesToProcess(final List<VirtualFile> files,
                                                      final String title,
                                                      @Nullable final String prompt,
                                                      final String singleFileTitle,
                                                      final String singleFilePromptTemplate,
                                                      final VcsShowConfirmationOption confirmationOption) {
    if (files.size() == 1 && singleFilePromptTemplate != null) {
      String filePrompt = MessageFormat.format(singleFilePromptTemplate, files.get(0).getPresentableUrl());
      if (ConfirmationDialog
        .requestForConfirmation(confirmationOption, myProject, filePrompt, singleFileTitle, Messages.getQuestionIcon())) {
        return files;
      }
      return null;
    }

    SelectFilesDialog dlg = new SelectFilesDialog(myProject, files, prompt, confirmationOption);
    dlg.setTitle(title);
    dlg.show();
    if (dlg.isOK()) {
      final Collection<VirtualFile> selection = dlg.getSelectedFiles();
      // return items in the same order as they were passed to us
      final List<VirtualFile> result = new ArrayList<VirtualFile>();
      for (VirtualFile file : files) {
        if (selection.contains(file)) {
          result.add(file);
        }
      }
      return result;
    }
    return null;
  }

  @Nullable
  public Collection<FilePath> selectFilePathsToProcess(final List<FilePath> files,
                                                       final String title,
                                                       @Nullable final String prompt,
                                                       final String singleFileTitle,
                                                       final String singleFilePromptTemplate,
                                                       final VcsShowConfirmationOption confirmationOption) {
    if (files.size() == 1 && singleFilePromptTemplate != null) {
      String filePrompt = MessageFormat.format(singleFilePromptTemplate, files.get(0).getPresentableUrl());
      if (ConfirmationDialog
        .requestForConfirmation(confirmationOption, myProject, filePrompt, singleFileTitle, Messages.getQuestionIcon())) {
        return files;
      }
      return null;
    }

    SelectFilePathsDialog dlg = new SelectFilePathsDialog(myProject, files, prompt, confirmationOption);
    dlg.setTitle(title);
    dlg.show();
    return dlg.isOK() ? dlg.getSelectedFiles() : null;
  }

  protected void reportError(Exception exception) {
    LOG.info(exception);
    Messages.showMessageDialog(exception.getLocalizedMessage(), VcsBundle.message("message.title.could.not.load.file.history"),
      Messages.getErrorIcon());
  }

  public void showErrors(final List<VcsException> abstractVcsExceptions, @NotNull final String tabDisplayName) {
    showErrorsImpl(abstractVcsExceptions.isEmpty(), new Getter<VcsException>() {
      public VcsException get() {
        return abstractVcsExceptions.get(0);
      }
    }, tabDisplayName, new Consumer<VcsErrorViewPanel>() {
      public void consume(VcsErrorViewPanel vcsErrorViewPanel) {
        addDirectMessages(vcsErrorViewPanel, abstractVcsExceptions);
      }
    });
  }

  private void addDirectMessages(VcsErrorViewPanel vcsErrorViewPanel, List<VcsException> abstractVcsExceptions) {
    for (final VcsException exception : abstractVcsExceptions) {
      String[] messages = getExceptionMessages(exception);
      vcsErrorViewPanel.addMessage(getErrorCategory(exception), messages, exception.getVirtualFile(), -1, -1, null);
    }
  }

  private String[] getExceptionMessages(VcsException exception) {
    String[] messages = exception.getMessages();
    if (messages.length == 0) messages = new String[]{VcsBundle.message("exception.text.unknown.error")};
    return messages;
  }

  private void showErrorsImpl(final boolean isEmpty, final Getter<VcsException> firstGetter, @NotNull final String tabDisplayName,
                              final Consumer<VcsErrorViewPanel> viewFiller) {
    if (ApplicationManager.getApplication().isUnitTestMode() && !isEmpty) {
      throw new RuntimeException(firstGetter.get());
    } else if (ApplicationManager.getApplication().isUnitTestMode()) {
      return;
    }
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      public void run() {
        if (myProject.isDisposed()) return;
        if (isEmpty) {
          removeContents(null, tabDisplayName);
          return;
        }

        final VcsErrorViewPanel errorTreeView = new VcsErrorViewPanel(myProject);
        openMessagesView(errorTreeView, tabDisplayName);

        viewFiller.consume(errorTreeView);
      }
    });
  }

  @Override
  public void showErrors(final Map<HotfixData, List<VcsException>> exceptionGroups, @NotNull final String tabDisplayName) {
    showErrorsImpl(exceptionGroups.isEmpty(), new Getter<VcsException>() {
      public VcsException get() {
        final List<VcsException> exceptionList = exceptionGroups.values().iterator().next();
        return exceptionList == null ? null : (exceptionList.isEmpty() ? null : exceptionList.get(0));
      }
    }, tabDisplayName, new Consumer<VcsErrorViewPanel>() {
      public void consume(VcsErrorViewPanel vcsErrorViewPanel) {
        for (Map.Entry<HotfixData, List<VcsException>> entry : exceptionGroups.entrySet()) {
          if (entry.getKey() == null) {
            addDirectMessages(vcsErrorViewPanel, entry.getValue());
          } else {
            final List<VcsException> exceptionList = entry.getValue();
            final List<SimpleErrorData> list = new ArrayList<SimpleErrorData>(exceptionList.size());
            for (VcsException exception : exceptionList) {
              final String[] messages = getExceptionMessages(exception);
              list.add(new SimpleErrorData(
                ErrorTreeElementKind.convertMessageFromCompilerErrorType(getErrorCategory(exception)), messages, exception.getVirtualFile()));
            }

            vcsErrorViewPanel.addHotfixGroup(entry.getKey(), list);
          }
        }
      }
    });
  }

  private static int getErrorCategory(VcsException exception) {
    if (exception.isWarning()) {
      return MessageCategory.WARNING;
    } else {
      return MessageCategory.ERROR;
    }
  }

  @Patch
  protected void removeContents(Content notToRemove, final String tabDisplayName) {
    // MPS Patch Start
    MessageView messageView = myProject.getComponent(jetbrains.mps.ide.messages.MessagesViewTool.class);
    // MPS Patch End
    Content[] contents = messageView.getContentManager().getContents();
    for (Content content : contents) {
      LOG.assertTrue(content != null);
      if (content.isPinned()) continue;
      if (tabDisplayName.equals(content.getDisplayName()) && content != notToRemove) {
        ErrorTreeView listErrorView = (ErrorTreeView) content.getComponent();
        if (listErrorView != null) {
          if (messageView.getContentManager().removeContent(content, true)) {
            content.release();
          }
        }
      }
    }
  }

  public List<VcsException> runTransactionRunnable(AbstractVcs vcs, TransactionRunnable runnable, Object vcsParameters) {
    List<VcsException> exceptions = new ArrayList<VcsException>();

    TransactionProvider transactionProvider = vcs.getTransactionProvider();
    boolean transactionSupported = transactionProvider != null;

    if (transactionSupported) {
      try {
        transactionProvider.startTransaction(vcsParameters);
      }
      catch (VcsException e) {
        return Collections.singletonList(e);
      }
    }

    runnable.run(exceptions);

    if (transactionSupported) {
      if (exceptions.isEmpty()) {
        try {
          transactionProvider.commitTransaction(vcsParameters);
        }
        catch (VcsException e) {
          exceptions.add(e);
          transactionProvider.rollbackTransaction(vcsParameters);
        }
      } else {
        transactionProvider.rollbackTransaction(vcsParameters);
      }
    }

    return exceptions;
  }

  public void showAnnotation(FileAnnotation annotation, VirtualFile file) {
    new Annotater(annotation, myProject, file).showAnnotation();
  }

  public void showDifferences(final VcsFileRevision version1, final VcsFileRevision version2, final File file) {
    try {
      version1.loadContent();
      version2.loadContent();

      if (Comparing.equal(version1.getContent(), version2.getContent())) {
        Messages.showInfoMessage(VcsBundle.message("message.text.versions.are.identical"), VcsBundle.message("message.title.diff"));
      }

      final SimpleDiffRequest request = new SimpleDiffRequest(myProject, file.getAbsolutePath());

      final FileType fileType = FileTypeManager.getInstance().getFileTypeByFileName(file.getName());
      if (fileType.isBinary()) {
        Messages.showInfoMessage(VcsBundle.message("message.text.binary.versions.differ"), VcsBundle.message("message.title.diff"));

        return;
      }

      final DiffContent content1 = getContentForVersion(version1, file);
      final DiffContent content2 = getContentForVersion(version2, file);

      if (version2.getRevisionNumber().compareTo(version1.getRevisionNumber()) > 0) {
        request.setContents(content2, content1);
        request.setContentTitles(version2.getRevisionNumber().asString(), version1.getRevisionNumber().asString());
      } else {
        request.setContents(content1, content2);
        request.setContentTitles(version1.getRevisionNumber().asString(), version2.getRevisionNumber().asString());
      }

      DiffManager.getInstance().getDiffTool().show(request);
    }
    catch (VcsException e) {
      showError(e, VcsBundle.message("message.title.diff"));
    }
    catch (IOException e) {
      showError(new VcsException(e), VcsBundle.message("message.title.diff"));
    }

  }

  public void showChangesBrowser(List<CommittedChangeList> changelists) {
    showChangesBrowser(changelists, null);
  }

  public void showChangesBrowser(List<CommittedChangeList> changelists, @Nls String title) {
    showChangesBrowser(new CommittedChangesTableModel(changelists, false), title, false, null);
  }

  private ChangesBrowserDialog createChangesBrowserDialog(CommittedChangesTableModel changelists,
                                                          String title,
                                                          boolean showSearchAgain,
                                                          @Nullable final Component parent) {
    final ChangesBrowserDialog.Mode mode = showSearchAgain ? ChangesBrowserDialog.Mode.Browse : ChangesBrowserDialog.Mode.Simple;
    final ChangesBrowserDialog dlg = parent != null
      ? new ChangesBrowserDialog(myProject, parent, changelists, mode)
      : new ChangesBrowserDialog(myProject, changelists, mode);
    if (title != null) {
      dlg.setTitle(title);
    }
    return dlg;
  }

  private void showChangesBrowser(CommittedChangesTableModel changelists,
                                  String title,
                                  boolean showSearchAgain,
                                  @Nullable final Component parent) {
    final ChangesBrowserDialog.Mode mode = showSearchAgain ? ChangesBrowserDialog.Mode.Browse : ChangesBrowserDialog.Mode.Simple;
    final ChangesBrowserDialog dlg = parent != null
      ? new ChangesBrowserDialog(myProject, parent, changelists, mode)
      : new ChangesBrowserDialog(myProject, changelists, mode);
    if (title != null) {
      dlg.setTitle(title);
    }
    dlg.show();
  }

  public void showChangesListBrowser(CommittedChangeList changelist, @Nls String title) {
    final ChangeListViewerDialog dlg = new ChangeListViewerDialog(myProject, changelist);
    if (title != null) {
      dlg.setTitle(title);
    }
    dlg.show();
  }

  public void showWhatDiffersBrowser(final Component parent, final Collection<Change> changes, @Nls final String title) {
    final ChangeListViewerDialog dlg;
    if (parent != null) {
      dlg = new ChangeListViewerDialog(parent, myProject, changes, false);
    } else {
      dlg = new ChangeListViewerDialog(myProject, changes, false);
    }
    if (title != null) {
      dlg.setTitle(title);
    }
    dlg.show();
  }

  public void showChangesBrowser(final CommittedChangesProvider provider,
                                 final RepositoryLocation location,
                                 @Nls String title,
                                 Component parent) {
    final ChangesBrowserSettingsEditor filterUI = provider.createFilterUI(true);
    ChangeBrowserSettings settings = provider.createDefaultSettings();
    boolean ok;
    if (filterUI != null) {
      final CommittedChangesFilterDialog dlg = new CommittedChangesFilterDialog(myProject, filterUI, settings);
      dlg.show();
      ok = dlg.getExitCode() == DialogWrapper.OK_EXIT_CODE;
      settings = dlg.getSettings();
    } else {
      ok = true;
    }

    if (ok) {
      if (myProject.isDefault() || (ProjectLevelVcsManager.getInstance(myProject).getAllActiveVcss().length == 0) ||
        (!ModalityState.NON_MODAL.equals(ModalityState.current()))) {
        final List<CommittedChangeList> versions = new ArrayList<CommittedChangeList>();

        if (parent == null || !parent.isValid()) {
          parent = WindowManager.getInstance().suggestParentWindow(myProject);
        }
        final CommittedChangesTableModel model = new CommittedChangesTableModel(versions, true);
        final ChangesBrowserDialog dlg = createChangesBrowserDialog(model, title, filterUI != null, parent);

        final AsynchronousListsLoader task = new AsynchronousListsLoader(myProject, provider, location, settings, dlg);
        ProgressManager.getInstance().run(task);
        dlg.show();
        dlg.startLoading();
        task.cancel();

        final List<VcsException> exceptions = task.getExceptions();
        if (!exceptions.isEmpty()) {
          Messages.showErrorDialog(myProject, VcsBundle.message("browse.changes.error.message", exceptions.get(0).getMessage()),
            VcsBundle.message("browse.changes.error.title"));
          return;
        }

        if (!task.isRevisionsReturned()) {
          Messages.showInfoMessage(myProject, VcsBundle.message("browse.changes.nothing.found"),
            VcsBundle.message("browse.changes.nothing.found.title"));
        }
      } else {
        openCommittedChangesTab(provider, location, settings, 0, title);
      }
    }
  }

  @Nullable
  public <T extends CommittedChangeList, U extends ChangeBrowserSettings> T chooseCommittedChangeList(CommittedChangesProvider<T, U> provider,
                                                                                                      RepositoryLocation location) {
    final List<T> changes;
    try {
      changes = provider.getCommittedChanges(provider.createDefaultSettings(), location, 0);
    }
    catch (VcsException e) {
      return null;
    }
    final ChangesBrowserDialog dlg = new ChangesBrowserDialog(myProject, new CommittedChangesTableModel((List<CommittedChangeList>) changes,
      provider.getColumns(), false),
      ChangesBrowserDialog.Mode.Choose);
    dlg.show();
    if (dlg.isOK()) {
      return (T) dlg.getSelectedChangeList();
    } else {
      return null;
    }
  }

  /**
   * Patch by MPS in order to backup model before conflict resolution
   */
  @Patch
  @NotNull
  public List<VirtualFile> showMergeDialog(List<VirtualFile> files, final MergeProvider provider) {
    return showMergeDialog(files, provider, true);
  }

  /**
   * Severely patched by MPS
   */
  public List<VirtualFile> showMergeDialog(List<VirtualFile> files, final MergeProvider provider, boolean doStatusRecheck) {
    if (files.isEmpty()) return Collections.emptyList();
    // MPS Patch Start
    // we create providerDecorator which does actual backup
    MergeProvider providerDecorator = new MergeProvider() {
      private File myBackup;

      @NotNull
      public MergeData loadRevisions(VirtualFile file) throws VcsException {
        MergeData mergeData = provider.loadRevisions(file);
        if (file.getFileType().equals(MPSFileTypeFactory.MODEL_FILE_TYPE)) {
          String leftText = decodeContent(file, mergeData.CURRENT);
          String rightText = decodeContent(file, mergeData.LAST);
          String originalText = decodeContent(file, mergeData.ORIGINAL);
          DiffRequestFactory diffRequestFactory = DiffRequestFactory.getInstance();
          MergeRequest request = diffRequestFactory.createMergeRequest(leftText, rightText, originalText, file, myProject, ActionButtonPresentation.createApplyButton());
          try {
            myBackup = zipModel(mergeData, request.getContents(), file);
          } catch (IOException e) {
            LOG.error(e);
          }
        }
        return mergeData;
      }

      public void conflictResolvedForFile(VirtualFile file) {
        provider.conflictResolvedForFile(file);
        if (myBackup.exists()) {
          try {
            File tmp = FileUtil.createTmpDir();
            ZipUtil.extract(myBackup, tmp, null);

            // copy merge result
            FileUtil.copyFile(new File(file.getPath()), new File(tmp + File.separator + file.getName() + ".result"));

            // copy logfiles
            File logsDir = new File(PathManager.getLogPath());
            File[] logfiles = logsDir.listFiles(new FilenameFilter() {
              public boolean accept(File dir, String name) {
                return name.matches("mpsvcs\\.log(\\.1)*") || name.matches("idea\\.log(\\.1)*");
              }
            });
            File tmpLogDir = new File(tmp + File.separator + "logs");
            tmpLogDir.mkdir();
            for (File logfile : logfiles) {
              FileUtil.copyFile(logfile, new File(tmpLogDir + File.separator + logfile.getName()));
            }

            FileUtil.zip(tmp, myBackup);
            FileUtil.delete(tmp);
          } catch (IOException e) {
            LOG.error(e);
          }
        }
      }

      public boolean isBinary(VirtualFile file) {
        return provider.isBinary(file);
      }
    };

    // recheck files status
    List<VirtualFile> toMerge = new ArrayList<VirtualFile>();
    List<VirtualFile> alreadyResolved = new ArrayList<VirtualFile>();
    for (VirtualFile f : files) {
      // TODO FIXME this is a hack for Git, because Git plugin says that conflicting files are just modified,
      AbstractVcs vcs = ApplicationLevelVcsManager.instance().getVcsForFile(f);
      boolean isGit = vcs != null && "Git".equals(vcs.getDisplayName());
      // hack ends
      if (!doStatusRecheck || ApplicationLevelVcsManager.instance().isInConflict(VFileSystem.toIFile(f), true) || isGit) {
        toMerge.add(f);
      } else {
        alreadyResolved.add(f);
      }
    }
    if (toMerge.isEmpty()) {
      MPS_LOG.debug("It seems that all files were already resolved " + alreadyResolved);
      return alreadyResolved;
    }
    MPS_LOG.debug("Showing merge for files " + toMerge);
    // on the next line originally provider were passed instead of provider decorator
    final MultipleFileMergeDialog fileMergeDialog = new MultipleFileMergeDialog(myProject, toMerge, providerDecorator);
    fileMergeDialog.show();
    List<VirtualFile> resolved = CollectionUtil.union(fileMergeDialog.getProcessedFiles(), alreadyResolved);
    MPS_LOG.debug("Merge finished with resolved files " + resolved);
    return resolved;
  }

  // MPS Patch Start: several new helper methods for our new showMergeDialog

  @Patch
  public static File zipModel(MergeData request, DiffContent[] contents, VirtualFile file) throws IOException {
    File tmp = FileUtil.createTmpDir();
    writeContentsToFile(contents[ModelMergeRequest.ORIGINAL], file, tmp, VcsMergeVersion.BASE.getSuffix());
    writeContentsToFile(contents[ModelMergeRequest.CURRENT], file, tmp, VcsMergeVersion.MINE.getSuffix());
    writeContentsToFile(contents[ModelMergeRequest.LAST_REVISION], file, tmp, VcsMergeVersion.THEIRS.getSuffix());
    writeMetaInformation(request, file, tmp);
    File zipfile = ModelUtils.chooseZipFileNameForModelFile(file.getPath());
    FileUtil.zip(tmp, zipfile);

    FileUtil.delete(tmp);

    return zipfile;
  }

  @Patch
  private static void writeMetaInformation(MergeData mergeData, VirtualFile file, File tmpDir) throws IOException {
    File baseFile = new File(tmpDir.getAbsolutePath() + File.separator + "info.txt");
    baseFile.createNewFile();
    PrintWriter stream = new PrintWriter(new FileOutputStream(baseFile));
    stream.print("File: ");
    stream.println(file.getPath());
    stream.print("Date: ");
    stream.println(Calendar.getInstance().getTime());
    stream.print("Last Revision: ");
    stream.println(mergeData.LAST_REVISION_NUMBER);
    stream.close();
  }

  @Patch
  private static void writeContentsToFile(DiffContent contents, VirtualFile file, File tmpDir, String suffix) throws IOException {
    writeContentsToFile(contents.getBytes(), file.getName(), tmpDir, suffix);
  }

  @Patch
  public static void writeContentsToFile(byte[] contents, String name, File tmpDir, String suffix) throws IOException {
    File baseFile = new File(tmpDir.getAbsolutePath() + File.separator + name + "." + suffix);
    baseFile.createNewFile();
    OutputStream stream = new FileOutputStream(baseFile);
    stream.write(contents);
    stream.close();
  }


  @Patch
  private static String decodeContent(final VirtualFile file, final byte[] content) {
    return StringUtil.convertLineSeparators(file.getCharset().decode(ByteBuffer.wrap(content)).toString());
  }
  // MPS Patch End

  @NotNull
  public List<VirtualFile> showMergeDialog(final List<VirtualFile> files) {
    if (files.isEmpty()) return Collections.emptyList();
    MergeProvider provider = null;
    for (VirtualFile virtualFile : files) {
      final AbstractVcs vcs = ProjectLevelVcsManager.getInstance(myProject).getVcsFor(virtualFile);
      if (vcs != null) {
        provider = vcs.getMergeProvider();
        if (provider != null) break;
      }
    }
    if (provider == null) return Collections.emptyList();
    return showMergeDialog(files, provider);
  }

  private static DiffContent getContentForVersion(final VcsFileRevision version, final File file) throws IOException {
    VirtualFile vFile = LocalFileSystem.getInstance().findFileByIoFile(file);
    if (vFile != null && (version instanceof CurrentRevision) && !vFile.getFileType().isBinary()) {
      return new DocumentContent(FileDocumentManager.getInstance().getDocument(vFile), vFile.getFileType());
    } else {
      return new SimpleContent(new String(version.getContent()), FileTypeManager.getInstance().getFileTypeByFileName(file.getName()));
    }
  }

  public void openCommittedChangesTab(final AbstractVcs vcs,
                                      final VirtualFile root,
                                      final ChangeBrowserSettings settings,
                                      final int maxCount,
                                      String title) {
    final RepositoryLocation location = CommittedChangesCache.getInstance(myProject).getLocationCache().getLocation(vcs, new FilePathImpl(root),
      false);
    openCommittedChangesTab(vcs.getCommittedChangesProvider(), location, settings, maxCount, title);
  }

  public void openCommittedChangesTab(final CommittedChangesProvider provider,
                                      final RepositoryLocation location,
                                      final ChangeBrowserSettings settings,
                                      final int maxCount,
                                      String title) {
    DefaultActionGroup extraActions = new DefaultActionGroup();
    CommittedChangesPanel panel = new CommittedChangesPanel(myProject, provider, settings, location, extraActions);
    panel.setMaxCount(maxCount);
    panel.refreshChanges(false);
    final ContentFactory factory = ContentFactory.SERVICE.getInstance();
    if (title == null && location != null) {
      title = VcsBundle.message("browse.changes.content.title", location.toPresentableString());
    }
    final Content content = factory.createContent(panel, title, false);
    final ChangesViewContentManager contentManager = ChangesViewContentManager.getInstance(myProject);
    contentManager.addContent(content);
    contentManager.setSelectedContent(content);

    extraActions.add(new CloseTabToolbarAction() {
      public void actionPerformed(final AnActionEvent e) {
        contentManager.removeContent(content);
      }
    });

    ToolWindow window = ToolWindowManager.getInstance(myProject).getToolWindow(ChangesViewContentManager.TOOLWINDOW_ID);
    if (!window.isVisible()) {
      window.activate(null);
    }
  }

  private static class AsynchronousListsLoader extends Task.Backgroundable {
    private final CommittedChangesProvider myProvider;
    private final RepositoryLocation myLocation;
    private final ChangeBrowserSettings mySettings;
    private final ChangesBrowserDialog myDlg;
    private final List<VcsException> myExceptions;
    private volatile boolean myCanceled;
    private boolean myRevisionsReturned;

    private AsynchronousListsLoader(@Nullable Project project, final CommittedChangesProvider provider,
                                    final RepositoryLocation location, final ChangeBrowserSettings settings, final ChangesBrowserDialog dlg) {
      super(project, VcsBundle.message("browse.changes.progress.title"), true, BackgroundFromStartOption.getInstance());
      myProvider = provider;
      myLocation = location;
      mySettings = settings;
      myDlg = dlg;
      myExceptions = new LinkedList<VcsException>();
    }

    public void cancel() {
      myCanceled = true;
    }

    @Override
    public void run(@NotNull final ProgressIndicator indicator) {
      final AsynchConsumer<List<CommittedChangeList>> appender = myDlg.getAppender();
      final BufferedListConsumer<CommittedChangeList> bufferedListConsumer = new BufferedListConsumer<CommittedChangeList>(10, appender, -1);

      final Application application = ApplicationManager.getApplication();
      try {
        myProvider.loadCommittedChanges(mySettings, myLocation, 0, new AsynchConsumer<CommittedChangeList>() {
          public void consume(CommittedChangeList committedChangeList) {
            myRevisionsReturned = true;
            bufferedListConsumer.consumeOne(committedChangeList);
            if (myCanceled) {
              indicator.cancel();
            }
          }

          public void finished() {
            bufferedListConsumer.flush();
            appender.finished();

            if (!myRevisionsReturned) {
              application.invokeLater(new Runnable() {
                public void run() {
                  myDlg.close(-1);
                }
              }, ModalityState.stateForComponent(myDlg.getWindow()));
            }
          }
        });
      }
      catch (VcsException e) {
        myExceptions.add(e);
        application.invokeLater(new Runnable() {
          public void run() {
            myDlg.close(-1);
          }
        }, ModalityState.stateForComponent(myDlg.getWindow()));
      }
    }

    public List<VcsException> getExceptions() {
      return myExceptions;
    }

    public boolean isRevisionsReturned() {
      return myRevisionsReturned;
    }
  }
}
