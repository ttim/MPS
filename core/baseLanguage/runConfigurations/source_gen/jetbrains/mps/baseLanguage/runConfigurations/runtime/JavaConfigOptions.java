package jetbrains.mps.baseLanguage.runConfigurations.runtime;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import java.awt.GridBagLayout;
import jetbrains.mps.ide.common.LayoutUtil;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jetbrains.mps.baseLanguage.util.plugin.run.ConfigRunParameters;

public class JavaConfigOptions extends JPanel {
  public JavaConfigOptions myThis;
  private JLabel myComponent_b0;
  private RawLineEditorComponent myVmParam_c0;
  private JLabel myComponent_d0;
  private RawLineEditorComponent myProgramParam_e0;
  private JLabel myComponent_f0;
  private FieldWithPathChooseDialog myWorkingDir_g0;
  private JCheckBox myComponent_h0;
  private FieldWithPathChooseDialog myJreHome_i0;
  private String myProgramParams;
  private String myVmParams;
  private String myWorkingDir;
  private String myAlternativeJRE;
  private boolean myUseAlternativeJRE;
  public List<AutoBinding> myBindings = ListSequence.fromList(new ArrayList<AutoBinding>());
  private Events myEvents = new Events(null) {
    {
    }

    public void initialize() {
    }
  };

  public JavaConfigOptions() {
    this.myThis = this;
    JavaConfigOptions component = this;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_b0(), LayoutUtil.createLabelConstraints(0));
    component.add(this.createComponent_c0(), LayoutUtil.createPanelConstraints(1));
    component.add(this.createComponent_d0(), LayoutUtil.createLabelConstraints(2));
    component.add(this.createComponent_e0(), LayoutUtil.createPanelConstraints(3));
    component.add(this.createComponent_f0(), LayoutUtil.createLabelConstraints(4));
    component.add(this.createComponent_g0(), LayoutUtil.createPanelConstraints(5));
    component.add(this.createComponent_h0(), LayoutUtil.createLabelConstraints(9));
    component.add(this.createComponent_i0(), LayoutUtil.createPanelConstraints(10));
    this.myEvents.initialize();
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
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("vmParams");
      Object targetObject = this.myVmParam_c0;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("programParams");
      Object targetObject = this.myProgramParam_e0;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("workingDir");
      Object targetObject = this.myWorkingDir_g0;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("useAlternativeJRE");
      Object targetObject = this.myComponent_h0;
      Property targetProperty = BeanProperty.create("selected");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("alternativeJRE");
      Object targetObject = this.myJreHome_i0;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("useAlternativeJRE");
      Object targetObject = this.myJreHome_i0;
      Property targetProperty = BeanProperty.create("editable");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
  }

  private void unbind() {
    for (AutoBinding binding : this.myBindings) {
      if (binding.isBound()) {
        binding.unbind();
      }
    }
  }

  private JLabel createComponent_b0() {
    JLabel component = new JLabel();
    this.myComponent_b0 = component;
    component.setText("VM Parameters:");
    return component;
  }

  private RawLineEditorComponent createComponent_c0() {
    RawLineEditorComponent component = new RawLineEditorComponent();
    this.myVmParam_c0 = component;
    component.setDialogCaption("VM Parameters");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onChangeVMParams();
      }
    });
    return component;
  }

  private JLabel createComponent_d0() {
    JLabel component = new JLabel();
    this.myComponent_d0 = component;
    component.setText("Program Parameters:");
    return component;
  }

  private RawLineEditorComponent createComponent_e0() {
    RawLineEditorComponent component = new RawLineEditorComponent();
    this.myProgramParam_e0 = component;
    component.setDialogCaption("Program Parameters");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onChangeProgramParams();
      }
    });
    return component;
  }

  private JLabel createComponent_f0() {
    JLabel component = new JLabel();
    this.myComponent_f0 = component;
    component.setText("Working Directory:");
    return component;
  }

  private FieldWithPathChooseDialog createComponent_g0() {
    FieldWithPathChooseDialog component = new FieldWithPathChooseDialog();
    this.myWorkingDir_g0 = component;
    component.setTitle("Select Working Directory");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onChangeWorkingDir();
      }
    });
    return component;
  }

  private JCheckBox createComponent_h0() {
    JCheckBox component = new JCheckBox();
    this.myComponent_h0 = component;
    component.setText("Use alternative JRE");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onCheckUseAlternativeJRE();
      }
    });
    return component;
  }

  private FieldWithPathChooseDialog createComponent_i0() {
    FieldWithPathChooseDialog component = new FieldWithPathChooseDialog();
    this.myJreHome_i0 = component;
    component.setTitle("Select Alternative JRE home");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onChangeAlternativeJRE();
      }
    });
    return component;
  }

  public String getProgramParams() {
    return this.myProgramParams;
  }

  public String getVmParams() {
    return this.myVmParams;
  }

  public String getWorkingDir() {
    return this.myWorkingDir;
  }

  public String getAlternativeJRE() {
    return this.myAlternativeJRE;
  }

  public boolean getUseAlternativeJRE() {
    return this.myUseAlternativeJRE;
  }

  public void setProgramParams(String newValue) {
    String oldValue = this.myProgramParams;
    this.myProgramParams = newValue;
    this.firePropertyChange("programParams", oldValue, newValue);
  }

  public void setVmParams(String newValue) {
    String oldValue = this.myVmParams;
    this.myVmParams = newValue;
    this.firePropertyChange("vmParams", oldValue, newValue);
  }

  public void setWorkingDir(String newValue) {
    String oldValue = this.myWorkingDir;
    this.myWorkingDir = newValue;
    this.firePropertyChange("workingDir", oldValue, newValue);
  }

  public void setAlternativeJRE(String newValue) {
    String oldValue = this.myAlternativeJRE;
    this.myAlternativeJRE = newValue;
    this.firePropertyChange("alternativeJRE", oldValue, newValue);
  }

  public void setUseAlternativeJRE(boolean newValue) {
    boolean oldValue = this.myUseAlternativeJRE;
    this.myUseAlternativeJRE = newValue;
    this.firePropertyChange("useAlternativeJRE", oldValue, newValue);
  }

  public void reset(ConfigRunParameters config) {
    if (config != null) {
      myThis.setProgramParams(config.getProgramParameters());
      myThis.setVmParams(config.getVMParameters());
      myThis.setWorkingDir(config.getWorkingDirectory());
      myThis.setAlternativeJRE(config.getAlternativeJRE());
      myThis.setUseAlternativeJRE(config.getUseAlternativeJRE());
    }
  }

  public void apply(ConfigRunParameters config) {
    if (config != null) {
      config.setVMParameters(myThis.getVmParams());
      config.setProgramParameters(myThis.getProgramParams());
      config.setWorkingDirectory(myThis.getWorkingDir());
      config.setAlternativeJRE(myThis.getAlternativeJRE());
      config.setUseAlternativeJRE(myThis.getUseAlternativeJRE());
    }
  }

  public void dispose() {
    myThis.myJreHome_i0.dispose();
    myThis.myWorkingDir_g0.dispose();
    myThis.myProgramParam_e0.dispose();
    myThis.myVmParam_c0.dispose();
  }

  public void onChangeAlternativeJRE() {
    myThis.setAlternativeJRE(myThis.myJreHome_i0.getText());
  }

  public void onCheckUseAlternativeJRE() {
    myThis.myJreHome_i0.setEditable(myThis.getUseAlternativeJRE());
  }

  public void onChangeWorkingDir() {
    myThis.setWorkingDir(myThis.myWorkingDir_g0.getText());
  }

  public void onChangeVMParams() {
    myThis.setVmParams(myThis.myVmParam_c0.getText());
  }

  public void onChangeProgramParams() {
    myThis.setProgramParams(myThis.myProgramParam_e0.getText());
  }
}
