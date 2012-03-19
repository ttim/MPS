/*
 * Copyright 2003-2012 JetBrains s.r.o.
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
package jetbrains.mps.ide.migration.assistant;

import com.intellij.ide.wizard.AbstractWizardEx;
import com.intellij.ide.wizard.AbstractWizardStepEx;
import com.intellij.ide.wizard.AbstractWizardStepEx.Listener;
import com.intellij.ide.wizard.CommitStepException;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ex.ApplicationEx;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.Task.Modal;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.impl.status.InlineProgressIndicator;
import com.intellij.ui.components.JBList;
import com.intellij.ui.components.JBScrollPane;
import jetbrains.mps.ide.migration.assistant.MigrationProcessor.Callback;
import jetbrains.mps.project.MPSProjectMigrationState;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fyodor
 * Date: 16.03.2012
 * Time: 10:10
 * To change this template use File | Settings | File Templates.
 */
public class MigrationAssistantWizard extends AbstractWizardEx {

  private static final List<String> STEP_IDS = new ArrayList<String>();

  private static Icon ICON = new ImageIcon(MigrationAssistantWizard.class.getResource("newProject.png"));
  private static Icon EXCLUDE = new ImageIcon(MigrationAssistantWizard.class.getResource("cross.png"));
  private static Icon CHECK = new ImageIcon(MigrationAssistantWizard.class.getResource("check.png"));
  private static Icon EMPTY = new Icon() {
    @Override
    public void paintIcon(Component component, Graphics graphics, int i, int i1) {
    }

    @Override
    public int getIconWidth() {
      return 12;
    }

    @Override
    public int getIconHeight() {
      return 12;
    }
  };

  
  public MigrationAssistantWizard(String title, Project project) {
    super(title, project, Arrays.asList(
      new InitialStep(project),
      new MigrationsActionsStep(project),
      new MigrationsProgressStep(project),
      new MigrationsFinishedStep((project))));
  }

  @Override
  public void addStep(AbstractWizardStepEx step) {
    super.addStep(step);
    step.addStepListener(new Listener() {
      @Override
      public void doNextAction() {}

      @Override
      public void stateChanged() {
        updateStep();
      }
    });
  }

  @Override
  protected void updateStep() {
    super.updateStep();
    getCancelAction().setEnabled(canCancel());
  }

  protected boolean canCancel () {
    for (AbstractWizardStepEx step : mySteps) {
      if (((MyStep)step).isPostComplete()) {
        return false;
      }
    }
    return true;
  }

  private static abstract class MyStep extends  AbstractWizardStepEx {

    protected Project myProject;
    protected JComponent myComponent;
    private String myId;

    public MyStep(Project project, String title, String id) {
      super(title);
      myProject = project;
      myId = id;
      STEP_IDS.add(myId);
    }

    @Override
    public Object getStepId() {
      return myId;
    }

    @Override
    public Object getNextStepId() {
      int idx = STEP_IDS.indexOf(myId) + 1;
      return idx < STEP_IDS.size() ? STEP_IDS.get(idx) : null;
    }

    @Override
    public Object getPreviousStepId() {
      int idx = STEP_IDS.indexOf(myId) - 1;
      return idx >= 0 ? STEP_IDS.get(idx) : null;
    }

    @Override
    public Icon getIcon() {
      return ICON;
    }

    @Override
    public JComponent getComponent() {
      return myComponent;
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
      return null;
    }

    @Override
    public void commit(CommitType commitType) throws CommitStepException {

    }

    @Override
    public boolean isComplete() {
      return false;
    }

    public boolean isPostComplete() {
      return false;
    }

    protected void createComponent() {
      this.myComponent = new JPanel(new BorderLayout(5,5));
      myComponent.setBorder(BorderFactory.createEtchedBorder());
    }

  }
  
  private static class InitialStep extends MyStep {

    private final JLabel myComponent;


    public InitialStep(Project project) {
      super(project, "Migration Required", "initial");
      myComponent = new JLabel("Step component");
    }

    @Override
    public JComponent getComponent() {
      return myComponent;
    }

    @Override
    public boolean isComplete() {
      return true;
    }


  }

  private static class MigrationsActionsStep extends MyStep {

    private JBList myList;
    private JButton myIncludeBtn;
    private JButton myExcludeBtn;
    private JButton mySelectAllBtn;
    private JButton myInvertBtn;
    private final Set<Object> myExcludedActions = Collections.synchronizedSet(new HashSet<Object>());
    private final Set<Object> myAllActions = Collections.synchronizedSet(new HashSet<Object>());

    public MigrationsActionsStep(Project project) {
      super(project, "List Of Migration Actions", "actionsList");
      createComponent();

    }

    protected final void createComponent() {
      super.createComponent();
      MigrationProcessor processor = myProject.getComponent(MigrationProcessor.class);
      myAllActions.addAll(processor.getActions());
      myExcludedActions.addAll(processor.getActions());
      myExcludedActions.removeAll(processor.getSelectedActions());

      JLabel label = new JLabel("List of migrations");
      myComponent.add(label, BorderLayout.NORTH);

      myList = new JBList(processor.getActions());
      myList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
          updateButtons();
        }
      });
      myList.setCellRenderer(new MyListCellRenderer(myExcludedActions, Collections.emptySet()));

      JPanel listPanel = new JPanel(new BorderLayout(5,5));
      listPanel.add(new JBScrollPane(myList), BorderLayout.CENTER);

      JPanel buttonsPanel = createButtonsPanel();
      listPanel.add(buttonsPanel, BorderLayout.EAST);
      myComponent.add(listPanel, BorderLayout.CENTER);
    }

    private JPanel createButtonsPanel() {
      GridBagLayout layout = new GridBagLayout();
      JPanel buttonsPanel = new JPanel(layout);

      GridBagConstraints gbc = new GridBagConstraints(0, 0,1,1,1.,0.,GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, new Insets(0,0,0,0), 0, 0);

      myIncludeBtn = new JButton("Include");
      myIncludeBtn.setMnemonic('I');
      myIncludeBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          handleInclude();
        }
      });
      buttonsPanel.add(myIncludeBtn);
      layout.setConstraints(myIncludeBtn, gbc);

      gbc.gridy++;
      gbc.anchor = GridBagConstraints.LINE_START;
      myExcludeBtn = new JButton("Exclude");
      myExcludeBtn.setMnemonic('x');
      myExcludeBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          handleExclude();
        }
      });
      buttonsPanel.add(myExcludeBtn);
      layout.setConstraints(myExcludeBtn, gbc);

      gbc.gridy++;
      gbc.weighty = 1.;
      gbc.fill = GridBagConstraints.BOTH;
      JLabel emptyLabel = new JLabel("");
      buttonsPanel.add(emptyLabel);
      layout.setConstraints(emptyLabel, gbc);

      mySelectAllBtn = new JButton("Select All");
      mySelectAllBtn.setMnemonic('A');
      mySelectAllBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          handleSelectAll();
        }
      });
      gbc.gridy++;
      gbc.weighty = 0.;
      gbc.fill = GridBagConstraints.HORIZONTAL;
      buttonsPanel.add(mySelectAllBtn);
      layout.setConstraints(mySelectAllBtn, gbc);

      myInvertBtn = new JButton("Invert Selection");
      myInvertBtn.setMnemonic('v');
      myInvertBtn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          handleInvertSelection();
        }
      });
      gbc.gridy++;
      buttonsPanel.add(myInvertBtn);
      gbc.anchor = GridBagConstraints.LAST_LINE_START;
      layout.setConstraints(myInvertBtn, gbc);
      return buttonsPanel;
    }

    private void handleInvertSelection() {
      int[] selectedIndices = myList.getSelectedIndices();
      int[] newSelectedIndices = new int[myList.getModel().getSize() - selectedIndices.length];
      for (int i = 0, j = 0; i < myList.getModel().getSize(); i++) {
        if (Arrays.binarySearch(selectedIndices, i) < 0) {
          newSelectedIndices[j++] = i;
        }
      }
      myList.setSelectedIndices(newSelectedIndices);
      updateButtons();
    }

    private void handleSelectAll() {
      if (myList.getModel().getSize() > 0) {
        myList.getSelectionModel().setSelectionInterval(0, myList.getModel().getSize()-1);
        updateButtons();
      }
    }

    private void handleExclude() {
      List<Object> selectedValues = Arrays.asList(myList.getSelectedValues());
      myExcludedActions.addAll(selectedValues);
      updateList();
      updateButtons();
      fireStateChanged();
    }

    private void handleInclude() {
      List<Object> selectedValues = Arrays.asList(myList.getSelectedValues());
      myExcludedActions.removeAll(selectedValues);
      updateList();
      updateButtons();
      fireStateChanged();
    }

    private void updateButtons () {
      List<Object> selectedValues = Arrays.asList(myList.getSelectedValues());
      if (selectedValues.isEmpty()) {
        myIncludeBtn.setEnabled(false);
        myExcludeBtn.setEnabled(false);
      }
      boolean anyExcluded = false;
      for (Object selectedValue : selectedValues) {
        anyExcluded |= myExcludedActions.contains(selectedValue);
      }
      if (!anyExcluded) {
        myIncludeBtn.setEnabled(false);
        myExcludeBtn.setEnabled(true);
      }
      else if (myExcludedActions.containsAll(selectedValues)){
        myIncludeBtn.setEnabled(true);
        myExcludeBtn.setEnabled(false);
      }
      else {
        myIncludeBtn.setEnabled(true);
        myExcludeBtn.setEnabled(true);
      }
    }

    private void updateList() {
      myList.repaint();
    }

    @Override
    public boolean isComplete() {
      return !myExcludedActions.containsAll(myAllActions);
    }

    @Override
    public void _init() {
      super._init();
      updateButtons();
    }

    @Override
    public void commit(CommitType commitType) throws CommitStepException {
      if (CommitType.Next == commitType) {
        if (myExcludedActions.containsAll(myAllActions)) throw new CommitStepException("No actions selected");
        MigrationProcessor processor = myProject.getComponent(MigrationProcessor.class);
        List<?> actions = new ArrayList<Object>(processor.getActions());
        actions.removeAll(myExcludedActions);
        processor.setSelectedActions(actions);
      }
    }
  }

  private static class MigrationsProgressStep extends MyStep {

    private boolean myStarted;
    private boolean myFinished;
    private final Task myTask;
    private InlineProgressIndicator myProgressIndicator;
    private final Set<Object> myMarked = Collections.synchronizedSet(new HashSet<Object>());;
    private final Set<Object> myExcluded = Collections.synchronizedSet(new HashSet<Object>());
    private JBList myList;

    public MigrationsProgressStep(Project project) {
      super(project, "Migration progress", "progress");
      myTask = createTask();
      myProgressIndicator = new InlineProgressIndicator(true, myTask);
      createComponent();
    }

    @Override
    protected final void createComponent() {
      super.createComponent();
      MigrationProcessor processor = myProject.getComponent(MigrationProcessor.class);

      myComponent.add(new JLabel("Migration progress"), BorderLayout.NORTH);
      myList = new JBList(processor.getActions());
      myList.setCellRenderer(new MyListCellRenderer(myExcluded, myMarked));
      myComponent.add(new JBScrollPane(myList), BorderLayout.CENTER);
      myComponent.add(myProgressIndicator.getComponent(), BorderLayout.SOUTH);
    }

    private Task createTask() {
      return new Modal(myProject, "executing", false) {
        @Override
        public void run(final ProgressIndicator indicator) {
          final MigrationProcessor processor = myProject.getComponent(MigrationProcessor.class);
          final List<?> actions = processor.getActions();
          myExcluded.addAll(actions);
          myExcluded.removeAll(processor.getSelectedActions());
          processor.addCallback(new Callback() {
            @Override
            public void startingAction(Object action) {
              indicator.setIndeterminate(false);
            }

            @Override
            public void finishedAction(Object action) {
              indicator.setFraction((double) (actions.indexOf(action)+1) / actions.size());
              myMarked.add(action);
              myList.ensureIndexIsVisible(actions.indexOf(action));
              myList.repaint();
            }

            @Override
            public void finishedAll() {
              processor.removeCallback(this);
              indicator.setFraction(1.0);
              myFinished = true;
              fireStateChanged();
            }
          });
          indicator.setIndeterminate(true);
          processor.startProcessing();
        }
      };
    }

    @Override
    public void _init() {
      super._init();
      if (!myStarted) {
        // launch migration
        MPSProjectMigrationState migrationState = myProject.getComponent(MPSProjectMigrationState.class);
        migrationState.migrationStarted();
        this.myStarted = true;
        runProcessWithProgressSynchronously(myTask, myProgressIndicator);
      }
    }

    private void runProcessWithProgressSynchronously(final Task task, final ProgressIndicator progressIndicator) {
      final boolean result = ((ApplicationEx) ApplicationManager.getApplication())
        .runProcessWithProgressSynchronously(new Runnable() {
          public void run() {
            task.run(progressIndicator);
          }
        }, task.getTitle(), task.isCancellable(), task.getProject(), getComponent(), task.getCancelText());
    }

    @Override
    public Object getPreviousStepId() {
      // can't go back now
      return null;
    }

    @Override
    public boolean isComplete() {
      return myStarted && myFinished;
    }

    @Override
    public boolean isPostComplete() {
      return myStarted && myFinished;
    }
  }

  private static class MigrationsFinishedStep extends MyStep {

    private final JLabel myComponent;
    private boolean myShown;

    public MigrationsFinishedStep(Project project) {
      super(project, "Migration finished", "finished");
      myComponent = new JLabel("Congratulations!");
    }

    @Override
    public JComponent getComponent() {
      return myComponent;
    }

    @Override
    public void _init() {
      super._init();
      this.myShown = true;
    }

    @Override
    public Object getPreviousStepId() {
      // too late for that
      return null;
    }

    @Override
    public boolean isComplete() {
      return myShown;
    }

    @Override
    public boolean isPostComplete() {
      return myShown;
    }
  }

  private static class MyListCellRenderer extends DefaultListCellRenderer {

    private Font myStrikeFont;
    private Font myFont;
    private final Set<?> myExcluded;
    private final Set<?> myMarked;

    public MyListCellRenderer(Set<?> excluded, Set<?> marked) {
      myExcluded = excluded;
      myMarked = marked;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean iss, boolean chf) {
      super.getListCellRendererComponent(list, value, index, iss, chf);
      if (myExcluded.contains(value)) {
        setIcon(EXCLUDE);
        setEnabled(false);
        setFont(getStrikeFont());
      }
      else if (myMarked.contains(value)) {
        setIcon(CHECK);
        setEnabled(true);
        setFont(getOriginalFont());
      }
      else {
        setIcon(EMPTY);
        setEnabled(true);
        setFont(getOriginalFont());
      }
      return this;
    }

    private Font getStrikeFont() {
      if (myStrikeFont == null) {
        Map<TextAttribute,Object> attributes = new HashMap<TextAttribute, Object>(getFont().getAttributes());
        attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
        myFont = getFont();
        myStrikeFont = myFont.deriveFont(attributes);
      }
      return myStrikeFont;
    }

    private Font getOriginalFont () {
      if (myFont == null) {
        this.myFont = getFont();
      }
      return myFont;
    }
  }

}
