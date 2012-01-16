package jetbrains.mps.ide.devkit.newDevkitDialog;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jetbrains.mps.ide.common.PathField;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.project.DevKit;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import java.awt.GridLayout;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import jetbrains.mps.ide.newSolutionDialog.NewModuleUtil;
import jetbrains.mps.project.MPSExtentions;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.progress.Progressive;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import java.io.File;

public class NewDevKitDialogContentPane extends JPanel {
  public NewDevKitDialogContentPane myThis;
  private JLabel myComponent_t9qnp8_b0;
  private JTextField myName_t9qnp8_c0;
  private JLabel myComponent_t9qnp8_d0;
  private PathField myPath_t9qnp8_e0;
  private String myDevkitName;
  private String myDevkitDir;
  private MPSProject myProject;
  private DevKit myResult;
  private NewDevKitDialog myDialog;
  public List<AutoBinding> myBindings = ListSequence.fromList(new ArrayList<AutoBinding>());
  private Events myEvents = new Events(null) {
    {
    }

    public void initialize() {
    }
  };

  public NewDevKitDialogContentPane() {
    this.myThis = this;
    NewDevKitDialogContentPane component = this;
    component.setLayout(new GridLayout(4, 1));
    component.add(this.createComponent_t9qnp8_b0());
    component.add(this.createComponent_t9qnp8_c0());
    component.add(this.createComponent_t9qnp8_d0());
    component.add(this.createComponent_t9qnp8_e0());
    this.myEvents.initialize();
    myThis.setDevkitName("");
    myThis.setDevkitDir("");
    myThis.myName_t9qnp8_c0.setName("Name");
    myThis.myPath_t9qnp8_e0.setName("Path");
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
      Property sourceProperty = BeanProperty.create("devkitName");
      Object targetObject = this.myName_t9qnp8_c0;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("devkitDir");
      Object targetObject = this.myPath_t9qnp8_e0;
      Property targetProperty = BeanProperty.create("path");
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

  private JLabel createComponent_t9qnp8_b0() {
    JLabel component = new JLabel();
    this.myComponent_t9qnp8_b0 = component;
    component.setText("Devkit Name:");
    return component;
  }

  private JTextField createComponent_t9qnp8_c0() {
    JTextField component = new JTextField();
    this.myName_t9qnp8_c0 = component;
    return component;
  }

  private JLabel createComponent_t9qnp8_d0() {
    JLabel component = new JLabel();
    this.myComponent_t9qnp8_d0 = component;
    component.setText("Devkit Path:");
    return component;
  }

  private PathField createComponent_t9qnp8_e0() {
    PathField component = new PathField();
    this.myPath_t9qnp8_e0 = component;
    return component;
  }

  public String getDevkitName() {
    return this.myDevkitName;
  }

  public String getDevkitDir() {
    return this.myDevkitDir;
  }

  public MPSProject getProject() {
    return this.myProject;
  }

  public DevKit getResult() {
    return this.myResult;
  }

  public NewDevKitDialog getDialog() {
    return this.myDialog;
  }

  public void setDevkitName(String newValue) {
    String oldValue = this.myDevkitName;
    this.myDevkitName = newValue;
    this.firePropertyChange("devkitName", oldValue, newValue);
    myThis.updateSolutionPath();
  }

  public void setDevkitDir(String newValue) {
    String oldValue = this.myDevkitDir;
    this.myDevkitDir = newValue;
    this.firePropertyChange("devkitDir", oldValue, newValue);
  }

  public void setProject(MPSProject newValue) {
    MPSProject oldValue = this.myProject;
    this.myProject = newValue;
    this.firePropertyChange("project", oldValue, newValue);
    myThis.updateSolutionPath();
  }

  public void setResult(DevKit newValue) {
    DevKit oldValue = this.myResult;
    this.myResult = newValue;
    this.firePropertyChange("result", oldValue, newValue);
  }

  public void setDialog(NewDevKitDialog newValue) {
    NewDevKitDialog oldValue = this.myDialog;
    this.myDialog = newValue;
    this.firePropertyChange("dialog", oldValue, newValue);
  }

  /*package*/ void onOk() {
    String message = NewModuleUtil.check(MPSExtentions.DOT_SOLUTION, myThis.getDevkitName(), myThis.getDevkitDir());
    if (message != null) {
      myThis.getDialog().setErrorText(message);
      return;
    }

    myThis.getDialog().dispose();
    Project ideaProject = myThis.getProject().getProject();
    ModelAccess.instance().runWriteActionWithProgressSynchronously(new Progressive() {
      public void run(ProgressIndicator indicator) {
        indicator.setIndeterminate(true);
        myThis.setResult(NewModuleUtil.createModule(MPSExtentions.DOT_DEVKIT, myThis.getDevkitName(), myThis.getDevkitDir(), myThis.getProject(), new _FunctionTypes._return_P3_E0<DevKit, String, IFile, MPSProject>() {
          public DevKit invoke(String s, IFile f, MPSProject p) {
            return DevKit.createDevkit(s, f, p);
          }
        }, new _FunctionTypes._void_P1_E0<ModuleDescriptor>() {
          public void invoke(ModuleDescriptor d) {
          }
        }));
      }
    }, "Creating", false, ideaProject);
  }

  /*package*/ void onCancel() {
    myThis.getDialog().dispose();
  }

  /*package*/ void updateSolutionPath() {
    if (myThis.getProject() == null) {
      return;
    }
    String path = myThis.getProject().getProjectFile().getParentFile().getAbsolutePath();
    String prefix = path + File.separator + "devkits" + File.separator;
    if (myThis.getDevkitDir().length() == 0 || myThis.getDevkitDir().startsWith(prefix)) {
      myThis.setDevkitDir(prefix + myThis.getDevkitName());
    }
  }
}
