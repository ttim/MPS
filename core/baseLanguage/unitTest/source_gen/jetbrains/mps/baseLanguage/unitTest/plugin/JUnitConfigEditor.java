package jetbrains.mps.baseLanguage.unitTest.plugin;

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
import javax.swing.JRadioButton;
import org.jdesktop.beansbinding.AutoBinding;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import com.intellij.openapi.wm.IdeFocusManager;
import java.awt.GridBagLayout;
import jetbrains.mps.baseLanguage.util.plugin.run.LayoutUtil;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.ide.DataManager;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

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
        myThis.setProjectName(myThis.getProject().getProject().getName());
        if (myThis.myProjectName_d3c0 != null) {
          myThis.myProjectName_d3c0.setText(myThis.getProjectName());
        }
      }
    });
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_b0(), LayoutUtil.createFieldConstraints(0));
    component.add(this.createComponent_c0(), LayoutUtil.createPanelConstraints(1));
    component.add(this.createComponent_d0(), LayoutUtil.createPanelConstraints(1));
    component.add(this.createComponent_e0(), LayoutUtil.createPanelConstraints(1));
    this.myEvents.initialize();
    myThis.myTestCases_d0.init(myThis.getNodes(), false);
    myThis.myTestMethods_e0.init(myThis.getMethods(), true);
    myThis.setButtons(new JRadioButton[JUnitRunTypes.values().length]);
    myThis.getButtons()[JUnitRunTypes.METHOD.ordinal()] = myThis.myIsMethod_h1a;
    myThis.getButtons()[JUnitRunTypes.MODEL.ordinal()] = myThis.myIsModel_f1a;
    myThis.getButtons()[JUnitRunTypes.MODULE.ordinal()] = myThis.myIsModule_e1a;
    myThis.getButtons()[JUnitRunTypes.NODE.ordinal()] = myThis.myIsClass_g1a;
    myThis.getButtons()[JUnitRunTypes.PROJECT.ordinal()] = myThis.myIsProject_d1a;
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

  private JPanel createComponent_b0() {
    JPanel component = new JPanel();
    this.myComponent_b0 = component;
    component.setLayout(new FlowLayout(FlowLayout.LEFT));
    component.add(this.createComponent_c1a());
    component.add(this.createComponent_d1a());
    component.add(this.createComponent_e1a());
    component.add(this.createComponent_f1a());
    component.add(this.createComponent_g1a());
    component.add(this.createComponent_h1a());
    return component;
  }

  private JLabel createComponent_c1a() {
    JLabel component = new JLabel();
    this.myComponent_c1a = component;
    component.setText("Test:");
    return component;
  }

  private JbRadioButton createComponent_d1a() {
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

  private JbRadioButton createComponent_e1a() {
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

  private JbRadioButton createComponent_f1a() {
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

  private JbRadioButton createComponent_g1a() {
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

  private JbRadioButton createComponent_h1a() {
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

  private JPanel createComponent_c0() {
    JPanel component = new JPanel();
    this.myMainPanel_c0 = component;
    component.setBorder(new TitledBorder("Test"));
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_d2a(), LayoutUtil.createPanelConstraints(0));
    component.add(this.createComponent_e2a(), LayoutUtil.createPanelConstraints(0));
    component.add(this.createComponent_f2a(), LayoutUtil.createPanelConstraints(0));
    return component;
  }

  private JPanel createComponent_d2a() {
    JPanel component = new JPanel();
    this.myProjectPanel_d2a = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_c3c0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_d3c0(), LayoutUtil.createPanelConstraints(1));
    return component;
  }

  private JLabel createComponent_c3c0() {
    JLabel component = new JLabel();
    this.myComponent_c3c0 = component;
    component.setText("Project:");
    return component;
  }

  private JTextField createComponent_d3c0() {
    JTextField component = new JTextField();
    this.myProjectName_d3c0 = component;
    component.setText(myThis.getProjectName());
    component.setEditable(false);
    return component;
  }

  private JPanel createComponent_e2a() {
    JPanel component = new JPanel();
    this.myModulePanel_e2a = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_c4c0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_d4c0(), LayoutUtil.createPanelConstraints(1));
    return component;
  }

  private JLabel createComponent_c4c0() {
    JLabel component = new JLabel();
    this.myComponent_c4c0 = component;
    component.setText("Module:");
    return component;
  }

  private ModuleChooserComponent createComponent_d4c0() {
    ModuleChooserComponent component = new ModuleChooserComponent();
    this.myModuleName_d4c0 = component;
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onModuleChange();
      }
    });
    return component;
  }

  private JPanel createComponent_f2a() {
    JPanel component = new JPanel();
    this.myModelPanel_f2a = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_c5c0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_d5c0(), LayoutUtil.createPanelConstraints(1));
    return component;
  }

  private JLabel createComponent_c5c0() {
    JLabel component = new JLabel();
    this.myComponent_c5c0 = component;
    component.setText("Model:");
    return component;
  }

  private ModelChooserComponent createComponent_d5c0() {
    ModelChooserComponent component = new ModelChooserComponent();
    this.myModelName_d5c0 = component;
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onModelChange();
      }
    });
    return component;
  }

  private ListPanel createComponent_d0() {
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

  private ListPanel createComponent_e0() {
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
    return MPSDataKeys.MPS_PROJECT.getData(DataManager.getInstance().getDataContext());
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

  private void addNodeValue(final String nodeName) {
    // also some legacy botva, remove it after 2.0 
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ITestNodeWrapper testCase = TestUtils.getTestCase(nodeName);
        if (testCase == null) {
          return;
        }
        ListSequence.fromList(myThis.getNodes()).addElement(testCase);
        myThis.myTestCases_d0.addItem(testCase);
      }
    });
  }

  private void addMethodValue(final String nodeName, final String methodName) {
    // here we have some legacy botva which should be removed after 2.0 
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ITestNodeWrapper testMethod = TestUtils.getTestMethod(nodeName, methodName);
        if (testMethod == null) {
          return;
        }
        ListSequence.fromList(myThis.getMethods()).addElement(testMethod);
        myThis.myTestMethods_e0.addItem(testMethod);
      }
    });
  }

  public void apply(final DefaultJUnit_Configuration config) {
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        // five of them, so we do not mind going twice 
        int index = Sequence.fromIterable(Sequence.fromArray(myThis.getButtons())).indexOf(Sequence.fromIterable(Sequence.fromArray(myThis.getButtons())).findFirst(new IWhereFilter<JRadioButton>() {
          public boolean accept(JRadioButton it) {
            return it.isSelected();
          }
        }));
        if (index >= 0) {
          config.getStateObject().type = JUnitRunTypes.values()[index];
        }

        // set legacy stuff to null 
        config.getStateObject().fullMethodNames = null;
        config.getStateObject().nodes = null;

        config.getStateObject().testMethods = new ClonableList<String>();
        for (ITestNodeWrapper testMethod : myThis.getMethods()) {
          config.getStateObject().testMethods.add(TestUtils.pointerToString(new SNodePointer(testMethod.getNode())));
        }

        config.getStateObject().testCases = new ClonableList<String>();
        for (ITestNodeWrapper testCase : myThis.getNodes()) {
          config.getStateObject().testCases.add(TestUtils.pointerToString(new SNodePointer(testCase.getNode())));
        }

        if (myThis.getModel() != null) {
          config.getStateObject().model = myThis.getModel().getSModelFqName().toString();
        } else {
          config.getStateObject().model = null;
        }
        if (myThis.getModule() != null) {
          config.getStateObject().module = myThis.getModule().getModuleFqName();
        } else {
          config.getStateObject().module = null;
        }
      }
    });
  }

  public void reset(final DefaultJUnit_Configuration config) {
    if (config.getStateObject().type != null) {
      myThis.getButtons()[config.getStateObject().type.ordinal()].setSelected(true);
    } else {
      myThis.myIsProject_d1a.setSelected(true);
    }

    // nodes 
    myThis.setNodes(ListSequence.fromList(new ArrayList<ITestNodeWrapper>()));
    myThis.myTestCases_d0.clear();
    // legacy code (config.nodes should be removed) 
    if (config.getStateObject().nodes != null) {
      for (String nodeName : config.getStateObject().nodes) {
        myThis.addNodeValue(nodeName);
      }
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        Sequence.fromIterable(TestUtils.wrapPointerStrings(config.getStateObject().testCases)).visitAll(new IVisitor<ITestNodeWrapper>() {
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
    // legacy code (config.fullMethodNames should be removed) 
    if (config.getStateObject().fullMethodNames != null) {
      for (String methodName : ListSequence.fromList(config.getStateObject().fullMethodNames)) {
        int separatorIndex = methodName.lastIndexOf(TestUtils.SEPARATOR);
        myThis.addMethodValue(methodName.substring(0, separatorIndex), methodName.substring(separatorIndex + 1));
      }
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        Sequence.fromIterable(TestUtils.wrapPointerStrings(config.getStateObject().testMethods)).visitAll(new IVisitor<ITestNodeWrapper>() {
          public void visit(ITestNodeWrapper it) {
            myThis.myTestMethods_e0.addItem(it);
            ListSequence.fromList(myThis.getMethods()).addElement(it);
          }
        });
      }
    });

    // models 
    if (config.getStateObject().model != null) {
      myThis.resetEditorModelWith(config.getStateObject().model);
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
            myThis.resetEditorModelWith(SNodeOperations.getModel(wrapperToTakeModelFrom.value.getNode()).getSModelFqName().toString());
          }
        });
      }
    }

    // modules 
    if (config.getStateObject().module != null) {
      myThis.setModuleValue(config.getStateObject().module);
      myThis.myModuleName_d4c0.setText(config.getStateObject().module);
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
