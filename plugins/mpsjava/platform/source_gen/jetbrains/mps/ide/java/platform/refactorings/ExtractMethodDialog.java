package jetbrains.mps.ide.java.platform.refactorings;

/*Generated by MPS */

import jetbrains.mps.ide.platform.refactoring.RefactoringDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoringParameters;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.ExtractMethodFactory;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.TableModelEvent;
import javax.swing.JLabel;
import com.intellij.ui.DocumentAdapter;
import javax.swing.event.DocumentEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.jetbrains.annotations.NonNls;
import javax.swing.JOptionPane;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.MethodMatch;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExtractMethodDialog extends RefactoringDialog {
  private JPanel myPanel;
  private boolean myCanRefactor;
  private JTextArea myPreviewArea = new JTextArea();
  private JTextArea myMessagesArea = new JTextArea();
  private JTextField myNameField;
  private JCheckBox myDeclareStaticCheckBox;
  private VisibilityPanel myVisibilityPanel;
  private ExtractMethodDialog.ChooseContainerPanel myChooseContainerPanel;
  private ExtractMethodRefactoringParameters myParameters;
  private EditorContext myContext;
  private ExtractMethodRefactoring myRefactoring;
  private SNode myStaticTarget;
  private SModel myRefactoringModel;
  private boolean myExtractIntoOuterContainer;
  private boolean myStaticSelected;
  private boolean myStaticSelectedByUser;
  private boolean myStaticEnabled;
  private String myAnalyzeErrors;
  private String myErrors;

  public ExtractMethodDialog(Project project, EditorContext context, ExtractMethodRefactoringParameters params, ExtractMethodRefactoring refactoring) {
    super(project, true);
    setTitle("Extract Method");

    myContext = context;
    myParameters = params;
    myRefactoring = refactoring;
    myExtractIntoOuterContainer = this.myParameters.getAnalyzer().shouldChooseOuterContainer();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myAnalyzeErrors = ExtractMethodFactory.getErrors(ExtractMethodDialog.this.myParameters.getNodesToRefactor());
        init();
      }
    });
    this.update();
  }

  private void update() {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ExtractMethodDialog.this.myErrors = ExtractMethodDialog.this.getMessagesText();
        ExtractMethodDialog.this.myMessagesArea.setText(ExtractMethodDialog.this.myErrors);
        ExtractMethodDialog.this.myPreviewArea.setText(ExtractMethodDialog.this.myParameters.getMethodText());
      }
    });
    this.repaint();
  }

  private String getMessagesText() {
    this.myCanRefactor = true;
    StringBuffer buff = new StringBuffer();
    String methodName = this.myParameters.getName();
    if (methodName.length() == 0) {
      buff.append("Method name is empty.\n");
      this.myCanRefactor = false;
    } else {
      boolean nameIsGood = Character.isJavaIdentifierStart(methodName.charAt(0));
      for (int i = 1; i < methodName.length(); i++) {
        nameIsGood = nameIsGood && Character.isJavaIdentifierPart(methodName.charAt(i));
      }
      if (!(nameIsGood)) {
        buff.append("Method name is incorrect.");
        this.myCanRefactor = false;
      }
    }
    if (this.myAnalyzeErrors != null) {
      buff.append(this.myAnalyzeErrors);
      this.myCanRefactor = false;
    }
    SNode overrides = this.myParameters.getOverridingMethodClass();
    if (overrides != null && !(this.myExtractIntoOuterContainer)) {
      if ((overrides == SNodeOperations.getAncestor(this.myParameters.getContainerMethod(), "jetbrains.mps.baseLanguage.structure.Classifier", false, false))) {
        buff.append("Such method already exists.\n");
      } else {
        buff.append("Method overrides method from class ").append(SPropertyOperations.getString(overrides, "name")).append("\n");
      }
      this.myCanRefactor = false;
    }
    if (buff.length() == 0) {
      buff.append("\n");
    }
    return buff.toString();
  }

  @Nullable
  protected JComponent createCenterPanel() {
    myPanel = new JPanel(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.BOTH;
    c.anchor = GridBagConstraints.NORTHWEST;
    c.insets = new Insets(3, 5, 3, 5);

    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 1;
    c.weighty = 0;
    c.gridwidth = 2;
    myPanel.add(createMethodPanel(), c);

    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1;
    c.weighty = 1;
    c.gridwidth = 1;
    myPanel.add(createParametersPanel(), c);

    c.gridx = 1;
    c.gridy = 1;
    c.weightx = 0;
    c.weighty = 1;
    c.gridwidth = 1;
    myVisibilityPanel = new VisibilityPanel();
    myVisibilityPanel.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        ExtractMethodDialog.this.myParameters.setVisibilityLevel(ExtractMethodDialog.this.myVisibilityPanel.getResult());
        ExtractMethodDialog.this.update();
      }
    });
    myPanel.add(myVisibilityPanel, c);

    c.gridx = 0;
    c.gridy = 2;
    c.weightx = 1;
    c.weighty = 0;
    c.gridwidth = 2;
    myPanel.add(createPreviewPanel(), c);

    c.gridx = 0;
    c.gridy = 3;
    c.weightx = 1;
    c.weighty = 0;
    c.gridwidth = 2;
    myChooseContainerPanel = new ExtractMethodDialog.ChooseContainerPanel();
    myChooseContainerPanel.setBorder(this.createBorder("Choose container"));
    myPanel.add(myChooseContainerPanel, c);

    c.gridx = 0;
    c.gridy = 4;
    c.weightx = 1;
    c.weighty = 0;
    c.gridwidth = 2;
    myPanel.add(createMessagesComponent(), c);

    return myPanel;
  }

  private JComponent createPreviewPanel() {
    this.myPreviewArea.setEditable(false);
    this.myPreviewArea.setBackground(this.myPanel.getBackground());
    this.myPreviewArea.setBorder(this.createBorder("Signature Preview"));
    return this.myPreviewArea;
  }

  private JComponent createMessagesComponent() {
    this.myMessagesArea.setEditable(false);
    this.myMessagesArea.setBackground(this.myPanel.getBackground());
    this.myMessagesArea.setBorder(this.createBorder("Messages"));
    return this.myMessagesArea;
  }

  private JComponent createParametersPanel() {
    ParametersPanel parametersPanel = new ParametersPanel(this.myParameters);
    parametersPanel.setBorder(this.createBorder("Parameters"));
    ParametersTableModel tableModel = parametersPanel.getTableModel();
    tableModel.addTableModelListener(new TableModelListener() {
      public void tableChanged(TableModelEvent p0) {
        ExtractMethodDialog.this.update();
      }
    });


    return parametersPanel;
  }

  private JComponent createMethodPanel() {
    JPanel methodPanel = new JPanel(new GridBagLayout());
    methodPanel.setBorder(this.createBorder("Method"));
    GridBagConstraints c = new GridBagConstraints();
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 0;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    methodPanel.add(new JLabel("Name:"), c);
    c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    c.weightx = 1;
    c.weighty = 1;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myNameField = new JTextField(20);
    methodPanel.add(myNameField, c);
    myNameField.getDocument().addDocumentListener(new DocumentAdapter() {
      protected void textChanged(DocumentEvent p0) {
        ExtractMethodDialog.this.myParameters.setName(myNameField.getText());
        ExtractMethodDialog.this.update();
      }
    });

    c.fill = GridBagConstraints.NONE;
    c.gridx = 0;
    c.gridy = 2;
    c.weightx = 1;
    c.weighty = 1;
    c.anchor = GridBagConstraints.FIRST_LINE_START;
    myDeclareStaticCheckBox = createDeclareStaticCheckBox();
    methodPanel.add(this.myDeclareStaticCheckBox, c);

    return methodPanel;
  }

  public JComponent getPreferredFocusedComponent() {
    return myNameField;
  }

  private JCheckBox createDeclareStaticCheckBox() {
    final JCheckBox result = new JCheckBox("Declare static");
    boolean canBeStatic = myRefactoring.canBeStatic();
    boolean shouldBeStatic = myRefactoring.shouldBeStatic();
    this.myStaticSelected = shouldBeStatic;
    this.myStaticEnabled = canBeStatic && !(shouldBeStatic);
    setCheckBox(result, this.myStaticSelected, this.myStaticEnabled);
    result.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        myStaticSelected = result.isSelected();
        ExtractMethodDialog.this.myParameters.setStatic(myStaticSelected);
        ExtractMethodDialog.this.update();
      }
    });
    return result;
  }

  private void setCheckBox(JCheckBox checkBox, boolean selected, boolean enabled) {
    checkBox.setSelected(selected);
    checkBox.setEnabled(enabled);
  }

  private Border createBorder(String title) {
    return new CompoundBorder(new TitledBorder(title), new EmptyBorder(5, 5, 5, 5));
  }

  private void setStaticContainer() {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ExtractMethodDialog.this.myRefactoring.setStaticContainer(ExtractMethodDialog.this.myStaticTarget);
      }
    });
  }

  public void chooseStaticContainer() {
    final Wrappers._T<SModelDescriptor> model = new Wrappers._T<SModelDescriptor>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myRefactoringModel = SNodeOperations.getModel(ListSequence.fromList(ExtractMethodDialog.this.myParameters.getNodesToRefactor()).first());
        model.value = myRefactoringModel.getModelDescriptor();
      }
    });

    final BaseChooseNodeDialog dialog = new BaseChooseNodeDialog(myProject, myContext.getOperationContext(), model.value, "Choose class") {
      protected boolean isAcceptable(SNode node) {
        return SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ClassConcept") || SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.IStaticContainerForMethods");
      }
    };
    dialog.show();

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myStaticTarget = (dialog.getResult() != null ?
          dialog.getResult().getNode() :
          null
        );
      }
    });
    if (myStaticTarget == null) {
      myRefactoringModel = null;
    }
  }

  @Nullable
  @NonNls
  @Override
  protected String getDimensionServiceKey() {
    return getClass().getName();
  }

  /**
   * This method will be called on pressing "Refactor" button in dialog.
   * 
   */
  protected void doRefactoringAction() {
    final Wrappers._T<SNode> result = new Wrappers._T<SNode>(null);
    if (!(myCanRefactor)) {
      JOptionPane.showMessageDialog(myPanel, "Can't refactor\n" + this.myErrors, "Can't perform refactoring", JOptionPane.ERROR_MESSAGE);
      return;
    } else {
      if (myExtractIntoOuterContainer) {
        if (myStaticTarget == null) {
          chooseStaticContainer();
        }
        if (myStaticTarget != null) {
          setStaticContainer();
        } else {
          return;
        }
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          result.value = myRefactoring.doRefactor();
          myContext.select(result.value);
          if ((myRefactoringModel != null) && myExtractIntoOuterContainer) {
            SModelReference ref = SNodeOperations.getModel(myStaticTarget).getSModelReference();
            myRefactoringModel.addModelImport(ref, false);
          }
        }
      });
    }
    super.doRefactoringAction();
    if ((result.value != null)) {
      new ExtractMethodDialog.MyMethodDuplicatesProcessor(myContext, result.value).process(this.myRefactoring.getMatches(), myProject);
    }
  }

  public class MyMethodDuplicatesProcessor extends MethodDuplicatesProcessor {
    private SNode myMethod;

    public MyMethodDuplicatesProcessor(EditorContext context, SNode method) {
      super(context);
      this.myMethod = method;
    }

    public void substitute(MethodMatch duplicate) {
      duplicate.getRefactoring().replaceMatch(duplicate, this.myMethod);
    }
  }

  private class ChooseContainerPanel extends JPanel {
    {
      myOuterContainerCheckBox = new JCheckBox("Extract into outer container");
      myChooseContainerButton = new JButton("Choose Container");
    }

    private JButton myChooseContainerButton;
    private JCheckBox myOuterContainerCheckBox;

    public ChooseContainerPanel() {
      super(new GridBagLayout());
      this.initPanel();
    }

    private void initPanel() {
      ExtractMethodDialog.this.setCheckBox(this.myOuterContainerCheckBox, ExtractMethodDialog.this.myExtractIntoOuterContainer, !(ExtractMethodDialog.this.myExtractIntoOuterContainer));
      myOuterContainerCheckBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent p0) {
          ExtractMethodDialog.this.myExtractIntoOuterContainer = myOuterContainerCheckBox.isSelected();
          myChooseContainerButton.setEnabled(ExtractMethodDialog.this.myExtractIntoOuterContainer);
          if (ExtractMethodDialog.this.myExtractIntoOuterContainer) {
            ExtractMethodDialog.this.myStaticSelectedByUser = ExtractMethodDialog.this.myStaticSelected;
          }

          setCheckBox(ExtractMethodDialog.this.myDeclareStaticCheckBox, ExtractMethodDialog.this.myExtractIntoOuterContainer || ExtractMethodDialog.this.myStaticSelectedByUser, !(ExtractMethodDialog.this.myExtractIntoOuterContainer) && ExtractMethodDialog.this.myStaticEnabled);
        }
      });

      myChooseContainerButton.setEnabled(ExtractMethodDialog.this.myExtractIntoOuterContainer);
      myChooseContainerButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent p0) {
          chooseStaticContainer();
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              if (ExtractMethodDialog.this.myStaticTarget != null) {
                if (SNodeOperations.isInstanceOf(ExtractMethodDialog.this.myStaticTarget, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
                  myChooseContainerButton.setIcon(IconResourceBundle_ExtractMethodIcons.getInstance().getResource("CLASS"));
                } else if (SNodeOperations.isInstanceOf(ExtractMethodDialog.this.myStaticTarget, "jetbrains.mps.lang.behavior.structure.ConceptBehavior")) {
                  myChooseContainerButton.setIcon(IconResourceBundle_ExtractMethodIcons.getInstance().getResource("INTERFACE"));
                }
                if (SNodeOperations.isInstanceOf(ExtractMethodDialog.this.myStaticTarget, "jetbrains.mps.lang.core.structure.INamedConcept")) {
                  myChooseContainerButton.setText(SPropertyOperations.getString((SNodeOperations.cast(ExtractMethodDialog.this.myStaticTarget, "jetbrains.mps.lang.core.structure.INamedConcept")), "name"));
                }

              }
              ExtractMethodDialog.this.update();
            }
          });
        }
      });

      GridBagConstraints c = new GridBagConstraints();
      c.gridx = 0;
      c.gridy = 0;
      c.weightx = 3;
      c.anchor = GridBagConstraints.FIRST_LINE_START;
      add(myOuterContainerCheckBox, c);

      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 1;
      c.anchor = GridBagConstraints.FIRST_LINE_END;
      add(myChooseContainerButton, c);

    }
  }
}
