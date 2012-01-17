package jetbrains.mps.baseLanguage.unitTest.execution.settings;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JLabel;
import jetbrains.mps.uiLanguage.runtime.JbRadioButton;
import javax.swing.JTextField;
import jetbrains.mps.project.MPSProject;
import javax.swing.ButtonGroup;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.project.IModule;
import java.util.List;
import jetbrains.mps.baseLanguage.unitTest.execution.client.ITestNodeWrapper;
import javax.swing.JRadioButton;
import org.jdesktop.beansbinding.AutoBinding;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import com.intellij.openapi.wm.IdeFocusManager;
import java.awt.GridBagLayout;
import jetbrains.mps.ide.common.LayoutUtil;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import com.intellij.ide.DataManager;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import com.intellij.openapi.application.ApplicationManager;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class JUnitConfigEditor extends JPanel {
  public JUnitConfigEditor myThis;
  private JPanel myComponent_b0;
  private JLabel myComponent_c1a;
  private JbRadioButton myIsProject_d1a;
  private JbRadioButton myIsModule_e1a;
  private JbRadioButton myIsModel_f1a;
  private JbRadioButton myIsClass_g1a;
  private JbRadioButton myIsMethod_h1a;
  private JPanel myMainPanel_c0;
  private JPanel myProjectPanel_d2a;
  private JLabel myComponent_c3c0;
  private JTextField myProjectName_d3c0;
  private JPanel myModulePanel_e2a;
  private JLabel myComponent_c4c0;
  private ModuleChooserComponent myModuleName_d4c0;
  private JPanel myModelPanel_f2a;
  private JLabel myComponent_c5c0;
  private ModelChooserComponent myModelName_d5c0;
  private ListPanel myTestCases_d0;
  private ListPanel myTestMethods_e0;
  private MPSProject myProject;
  private String myProjectName;
  private ButtonGroup myGroup;
  private SModel myModel;
  private IModule myModule;
  private List<ITestNodeWrapper> myNodes;
  private List<ITestNodeWrapper> myMethods;
  private JRadioButton[] myButtons;
  public List<AutoBinding> myBindings = ListSequence.fromList(new ArrayList<AutoBinding>());
  private Events myEvents = new Events(null) {
    {
    }

    public void initialize() {
    }
  };

  public JUnitConfigEditor() {
    this.myThis = this;
    JUnitConfigEditor component = this;
    myThis.setGroup(new ButtonGroup());
    myThis.setNodes(ListSequence.fromList(new ArrayList<ITestNodeWrapper>()));
    myThis.setMethods(ListSequence.fromList(new ArrayList<ITestNodeWrapper>()));
    IdeFocusManager.getGlobalInstance().doWhenFocusSettlesDown(new Runnable() {
      public void run() {
        myThis.setProject(myThis.findProjectFromContext());
        if (myThis.getProject() != null && myThis.getProject().getProject() != null) {
          myThis.setProjectName(myThis.getProject().getProject().getName());
          if (myThis.myProjectName_d3c0 != null) {
            myThis.myProjectName_d3c0.setText(myThis.getProjectName());
          }
          if (myThis.myTestCases_d0 != null) {
            myThis.myTestCases_d0.setProject(myThis.getProject().getProject());
          }
          if (myThis.myTestMethods_e0 != null) {
            myThis.myTestMethods_e0.setProject(myThis.getProject().getProject());
          }
        }
      }
    });
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_iqjve6_b0(), LayoutUtil.createFieldConstraints(0));
    component.add(this.createComponent_iqjve6_c0(), LayoutUtil.createPanelConstraints(1));
    component.add(this.createComponent_iqjve6_d0(), LayoutUtil.createPanelConstraints(1));
    component.add(this.createComponent_iqjve6_e0(), LayoutUtil.createPanelConstraints(1));
    this.myEvents.initialize();
    if (myThis.getProject() != null) {
      myThis.myTestCases_d0.setProject(myThis.getProject().getProject());
      myThis.myTestMethods_e0.setProject(myThis.getProject().getProject());
    }
    myThis.myTestCases_d0.init(myThis.getNodes(), false);
    myThis.myTestMethods_e0.init(myThis.getMethods(), true);
    myThis.setButtons(new JRadioButton[JUnitRunTypes2.values().length]);
    myThis.getButtons()[JUnitRunTypes2.METHOD.ordinal()] = myThis.myIsMethod_h1a;
    myThis.getButtons()[JUnitRunTypes2.MODEL.ordinal()] = myThis.myIsModel_f1a;
    myThis.getButtons()[JUnitRunTypes2.MODULE.ordinal()] = myThis.myIsModule_e1a;
    myThis.getButtons()[JUnitRunTypes2.NODE.ordinal()] = myThis.myIsClass_g1a;
    myThis.getButtons()[JUnitRunTypes2.PROJECT.ordinal()] = myThis.myIsProject_d1a;
  }

  public Events getEvents() {
    return this.myEvents;
  }

  public void addNotify() {
    super.addNotify();
    this.bind();
  }

  public void removeNotify() {
    this.unbind();
    super.removeNotify();
  }

  private void bind() {
  }

  private void unbind() {
    for (AutoBinding binding : this.myBindings) {
      if (binding.isBound()) {
        binding.unbind();
      }
    }
  }

  private JPanel createComponent_iqjve6_b0() {
    JPanel component = new JPanel();
    this.myComponent_b0 = component;
    component.setLayout(new FlowLayout(FlowLayout.LEFT));
    component.add(this.createComponent_iqjve6_c1a());
    component.add(this.createComponent_iqjve6_d1a());
    component.add(this.createComponent_iqjve6_e1a());
    component.add(this.createComponent_iqjve6_f1a());
    component.add(this.createComponent_iqjve6_g1a());
    component.add(this.createComponent_iqjve6_h1a());
    return component;
  }

  private JLabel createComponent_iqjve6_c1a() {
    JLabel component = new JLabel();
    this.myComponent_c1a = component;
    component.setText("Test:");
    return component;
  }

  private JbRadioButton createComponent_iqjve6_d1a() {
    JbRadioButton component = new JbRadioButton();
    this.myIsProject_d1a = component;
    component.setText("All in Project");
    component.setGroup(myThis.getGroup());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onSelect();
      }
    });
    return component;
  }

  private JbRadioButton createComponent_iqjve6_e1a() {
    JbRadioButton component = new JbRadioButton();
    this.myIsModule_e1a = component;
    component.setText("All in Module");
    component.setGroup(myThis.getGroup());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onSelect();
      }
    });
    return component;
  }

  private JbRadioButton createComponent_iqjve6_f1a() {
    JbRadioButton component = new JbRadioButton();
    this.myIsModel_f1a = component;
    component.setText("All in Model");
    component.setGroup(myThis.getGroup());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onSelect();
      }
    });
    return component;
  }

  private JbRadioButton createComponent_iqjve6_g1a() {
    JbRadioButton component = new JbRadioButton();
    this.myIsClass_g1a = component;
    component.setText("Class");
    component.setGroup(myThis.getGroup());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onSelect();
      }
    });
    return component;
  }

  private JbRadioButton createComponent_iqjve6_h1a() {
    JbRadioButton component = new JbRadioButton();
    this.myIsMethod_h1a = component;
    component.setText("Method");
    component.setGroup(myThis.getGroup());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onSelect();
      }
    });
    return component;
  }

  private JPanel createComponent_iqjve6_c0() {
    JPanel component = new JPanel();
    this.myMainPanel_c0 = component;
    component.setBorder(new TitledBorder("Test"));
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_iqjve6_d2a(), LayoutUtil.createPanelConstraints(0));
    component.add(this.createComponent_iqjve6_e2a(), LayoutUtil.createPanelConstraints(0));
    component.add(this.createComponent_iqjve6_f2a(), LayoutUtil.createPanelConstraints(0));
    return component;
  }

  private JPanel createComponent_iqjve6_d2a() {
    JPanel component = new JPanel();
    this.myProjectPanel_d2a = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_iqjve6_c3c0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_iqjve6_d3c0(), LayoutUtil.createPanelConstraints(1));
    return component;
  }

  private JLabel createComponent_iqjve6_c3c0() {
    JLabel component = new JLabel();
    this.myComponent_c3c0 = component;
    component.setText("Project:");
    return component;
  }

  private JTextField createComponent_iqjve6_d3c0() {
    JTextField component = new JTextField();
    this.myProjectName_d3c0 = component;
    component.setText(myThis.getProjectName());
    component.setEditable(false);
    return component;
  }

  private JPanel createComponent_iqjve6_e2a() {
    JPanel component = new JPanel();
    this.myModulePanel_e2a = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_iqjve6_c4c0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_iqjve6_d4c0(), LayoutUtil.createPanelConstraints(1));
    return component;
  }

  private JLabel createComponent_iqjve6_c4c0() {
    JLabel component = new JLabel();
    this.myComponent_c4c0 = component;
    component.setText("Module:");
    return component;
  }

  private ModuleChooserComponent createComponent_iqjve6_d4c0() {
    ModuleChooserComponent component = new ModuleChooserComponent();
    this.myModuleName_d4c0 = component;
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onModuleChange();
      }
    });
    return component;
  }

  private JPanel createComponent_iqjve6_f2a() {
    JPanel component = new JPanel();
    this.myModelPanel_f2a = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_iqjve6_c5c0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_iqjve6_d5c0(), LayoutUtil.createPanelConstraints(1));
    return component;
  }

  private JLabel createComponent_iqjve6_c5c0() {
    JLabel component = new JLabel();
    this.myComponent_c5c0 = component;
    component.setText("Model:");
    return component;
  }

  private ModelChooserComponent createComponent_iqjve6_d5c0() {
    ModelChooserComponent component = new ModelChooserComponent();
    this.myModelName_d5c0 = component;
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onModelChange();
      }
    });
    return component;
  }

  private ListPanel createComponent_iqjve6_d0() {
    ListPanel component = new ListPanel();
    this.myTestCases_d0 = component;
    component.setLayout(new GridBagLayout());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onNodeChange();
      }
    });
    return component;
  }

  private ListPanel createComponent_iqjve6_e0() {
    ListPanel component = new ListPanel();
    this.myTestMethods_e0 = component;
    component.setLayout(new GridBagLayout());
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onMethodChange();
      }
    });
    return component;
  }

  public MPSProject getProject() {
    return this.myProject;
  }

  public String getProjectName() {
    return this.myProjectName;
  }

  public ButtonGroup getGroup() {
    return this.myGroup;
  }

  public SModel getModel() {
    return this.myModel;
  }

  public IModule getModule() {
    return this.myModule;
  }

  public List<ITestNodeWrapper> getNodes() {
    return this.myNodes;
  }

  public List<ITestNodeWrapper> getMethods() {
    return this.myMethods;
  }

  public JRadioButton[] getButtons() {
    return this.myButtons;
  }

  public void setProject(MPSProject newValue) {
    MPSProject oldValue = this.myProject;
    this.myProject = newValue;
    this.firePropertyChange("project", oldValue, newValue);
  }

  public void setProjectName(String newValue) {
    String oldValue = this.myProjectName;
    this.myProjectName = newValue;
    this.firePropertyChange("projectName", oldValue, newValue);
  }

  public void setGroup(ButtonGroup newValue) {
    ButtonGroup oldValue = this.myGroup;
    this.myGroup = newValue;
    this.firePropertyChange("group", oldValue, newValue);
  }

  public void setModel(SModel newValue) {
    SModel oldValue = this.myModel;
    this.myModel = newValue;
    this.firePropertyChange("model", oldValue, newValue);
  }

  public void setModule(IModule newValue) {
    IModule oldValue = this.myModule;
    this.myModule = newValue;
    this.firePropertyChange("module", oldValue, newValue);
  }

  public void setNodes(List<ITestNodeWrapper> newValue) {
    List<ITestNodeWrapper> oldValue = this.myNodes;
    this.myNodes = newValue;
    this.firePropertyChange("nodes", oldValue, newValue);
  }

  public void setMethods(List<ITestNodeWrapper> newValue) {
    List<ITestNodeWrapper> oldValue = this.myMethods;
    this.myMethods = newValue;
    this.firePropertyChange("methods", oldValue, newValue);
  }

  public void setButtons(JRadioButton[] newValue) {
    JRadioButton[] oldValue = this.myButtons;
    this.myButtons = newValue;
    this.firePropertyChange("buttons", oldValue, newValue);
  }

  private MPSProject findProjectFromContext() {
    return MPSCommonDataKeys.MPS_PROJECT.getData(DataManager.getInstance().getDataContext());
  }

  private void setModuleValue(final String moduleName) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myThis.setModule(TestUtils.getModule(moduleName));
      }
    });
  }

  private void setModelValue(final String modelName) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        myThis.setModel(TestUtils.getModel(modelName));
      }
    });
  }

  public void apply(JUnitSettings_Configuration config) {
    myThis.apply(config, new _FunctionTypes._void_P6_E0<JUnitSettings_Configuration, Integer, ClonableList<String>, ClonableList<String>, String, String>() {
      public void invoke(JUnitSettings_Configuration c, Integer configurationIndex, ClonableList<String> testMethods, ClonableList<String> testCases, String model, String module) {
        myThis.applyInternal(c, configurationIndex, testMethods, testCases, model, module);
        return;
      }
    });
  }

  private void apply(final JUnitSettings_Configuration configuration, final _FunctionTypes._void_P6_E0<? super JUnitSettings_Configuration, ? super Integer, ? super ClonableList<String>, ? super ClonableList<String>, ? super String, ? super String> applyInternal) {
    // read our fields in UI thread 
    final List<ITestNodeWrapper> editorMethodList = myThis.getMethods();
    final List<ITestNodeWrapper> editorTestCasesList = myThis.getNodes();
    final SModel editorModel = myThis.getModel();
    final IModule editorModule = myThis.getModule();
    // five of them, so we do not mind going twice 
    final int configTypeIndex = Sequence.fromIterable(Sequence.fromArray(myThis.getButtons())).indexOf(Sequence.fromIterable(Sequence.fromArray(myThis.getButtons())).findFirst(new IWhereFilter<JRadioButton>() {
      public boolean accept(JRadioButton it) {
        return it.isSelected();
      }
    }));

    // perform everything else outside 
    ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
      public void run() {
        final ClonableList<String> testMethods = new ClonableList<String>();
        final ClonableList<String> testCases = new ClonableList<String>();
        final Wrappers._T<String> model = new Wrappers._T<String>();
        final Wrappers._T<String> module = new Wrappers._T<String>();

        // we have to do all processing in read action 
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            for (ITestNodeWrapper testMethod : editorMethodList) {
              testMethods.add(TestUtils.pointerToString(testMethod.getNodePointer()));
            }

            for (ITestNodeWrapper testCase : editorTestCasesList) {
              testCases.add(TestUtils.pointerToString(testCase.getNodePointer()));
            }

            if (editorModel != null) {
              model.value = editorModel.getSModelFqName().toString();
            }
            if (editorModule != null) {
              module.value = editorModule.getModuleFqName();
            }
          }
        });

        final String modelFinal = model.value;
        final String moduleFinal = module.value;
        // we neeed to set run config fields so we have to go into UI thread again 
        ApplicationManager.getApplication().invokeLater(new Runnable() {
          public void run() {
            applyInternal.invoke(configuration, configTypeIndex, testMethods, testCases, modelFinal, moduleFinal);
          }
        });

      }
    });
  }

  private void applyInternal(JUnitSettings_Configuration configuration, int configurationIndex, ClonableList<String> testMethods, ClonableList<String> testCases, String model, String module) {
    if (configurationIndex >= 0) {
      configuration.setRunType(JUnitRunTypes2.values()[configurationIndex]);
    }

    configuration.setTestMethods(testMethods);
    configuration.setTestCases(testCases);
    configuration.setModel(model);
    configuration.setModule(module);
  }

  public void reset(final JUnitSettings_Configuration configuration) {
    if (configuration.getRunType() != null) {
      myThis.getButtons()[configuration.getRunType().ordinal()].setSelected(true);
    } else {
      myThis.myIsProject_d1a.setSelected(true);
    }

    // nodes 
    myThis.setNodes(ListSequence.fromList(new ArrayList<ITestNodeWrapper>()));
    myThis.myTestCases_d0.clear();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        Sequence.fromIterable(TestUtils.wrapPointerStrings(configuration.getTestCases())).visitAll(new IVisitor<ITestNodeWrapper>() {
          public void visit(ITestNodeWrapper it) {
            myThis.myTestCases_d0.addItem(it);
            ListSequence.fromList(myThis.getNodes()).addElement(it);
          }
        });
      }
    });

    // methods 
    myThis.setMethods(ListSequence.fromList(new ArrayList<ITestNodeWrapper>()));
    myThis.myTestMethods_e0.clear();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        Sequence.fromIterable(TestUtils.wrapPointerStrings(configuration.getTestMethods())).visitAll(new IVisitor<ITestNodeWrapper>() {
          public void visit(ITestNodeWrapper it) {
            myThis.myTestMethods_e0.addItem(it);
            ListSequence.fromList(myThis.getMethods()).addElement(it);
          }
        });
      }
    });

    // models 
    if (configuration.getModel() != null) {
      myThis.resetEditorModelWith(configuration.getModel());
    } else {
      // if model is null, it is convenient to take model from the first node 
      final Wrappers._T<ITestNodeWrapper> wrapperToTakeModelFrom = new Wrappers._T<ITestNodeWrapper>(null);
      if (myThis.getNodes() != null && ListSequence.fromList(myThis.getNodes()).isNotEmpty()) {
        wrapperToTakeModelFrom.value = ListSequence.fromList(myThis.getNodes()).first();
      }
      if (myThis.getMethods() != null && ListSequence.fromList(myThis.getMethods()).isNotEmpty()) {
        wrapperToTakeModelFrom.value = ListSequence.fromList(myThis.getMethods()).first();
      }
      if (wrapperToTakeModelFrom.value != null) {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            myThis.resetEditorModelWith(wrapperToTakeModelFrom.value.getNodePointer().getModelReference().getSModelFqName().toString());
          }
        });
      }
    }

    // modules 
    if (configuration.getModule() != null) {
      myThis.setModuleValue(configuration.getModule());
      myThis.myModuleName_d4c0.setText(configuration.getModule());
    }

    // on select?? 
    myThis.onSelect();
  }

  private void resetEditorModelWith(final String modelName) {
    myThis.setModelValue(modelName);
    if (myThis.getModel() != null && myThis.getModel().getModelDescriptor() != null && myThis.getModel().getModelDescriptor().getModule() != null) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          myThis.myModelName_d5c0.setText(modelName);
          String moduleName = myThis.getModel().getModelDescriptor().getModule().getModuleFqName();
          myThis.setModuleValue(moduleName);
          myThis.myModuleName_d4c0.setText(moduleName);
        }
      });
    }
  }

  public void dispose() {
    myThis.myModelName_d5c0.dispose();
    myThis.myModuleName_d4c0.dispose();
  }

  public void onSelect() {
    myThis.myProjectPanel_d2a.setVisible(false);
    myThis.myModulePanel_e2a.setVisible(false);
    myThis.myModelPanel_f2a.setVisible(false);
    myThis.myTestCases_d0.setVisible(false);
    myThis.myTestMethods_e0.setVisible(false);
    myThis.myMainPanel_c0.setVisible(true);
    if (myThis.myIsModule_e1a.isSelected()) {
      myThis.myModulePanel_e2a.setVisible(true);
    } else if (myThis.myIsModel_f1a.isSelected()) {
      myThis.myModelPanel_f2a.setVisible(true);
    } else if (myThis.myIsClass_g1a.isSelected()) {
      myThis.myTestCases_d0.setVisible(true);
      myThis.myMainPanel_c0.setVisible(false);
    } else if (myThis.myIsMethod_h1a.isSelected()) {
      myThis.myTestMethods_e0.setVisible(true);
      myThis.myMainPanel_c0.setVisible(false);
    } else if (myThis.myIsProject_d1a.isSelected()) {
      myThis.myProjectPanel_d2a.setVisible(true);
    }
  }

  public void onModelChange() {
    myThis.setModelValue(myThis.myModelName_d5c0.getText());
  }

  public void onModuleChange() {
    myThis.setModuleValue(myThis.myModuleName_d4c0.getText());
  }

  public void onNodeChange() {
    myThis.setNodes((List<ITestNodeWrapper>) myThis.myTestCases_d0.getItems());
  }

  public void onMethodChange() {
    myThis.setMethods((List<ITestNodeWrapper>) myThis.myTestMethods_e0.getItems());
  }
}
