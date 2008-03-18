package jetbrains.mps.ide.newDevkitDialog;

/*Generated by MPS */

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import jetbrains.mps.ide.common.PathField;
import jetbrains.mps.project.MPSProject;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import java.util.ArrayList;
import java.awt.GridLayout;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import java.io.File;
import jetbrains.mps.util.DirectoryUtil;
import java.awt.Frame;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.projectLanguage.DescriptorsPersistence;
import jetbrains.mps.projectLanguage.structure.DevKitDescriptor;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.vfs.FileSystemFile;

public class NewDevKitDialogContentPane extends JPanel {

  public NewDevKitDialogContentPane myThis;
  private JLabel myComponent;
  private JTextField myComponent1;
  private JLabel myComponent2;
  private PathField myComponent3;
  private String myDevkitName;
  private String myDevkitDir;
  private MPSProject myProject;
  private NewDevKitDialog myDialog;
  public List<AutoBinding> myBindings = new ArrayList<AutoBinding>();

  public  NewDevKitDialogContentPane() {
    this.myThis = this;
    myThis.setDevkitName("");
    myThis.setDevkitDir("");
    NewDevKitDialogContentPane component = this;
    component.setLayout(new GridLayout(4, 1));
    component.add(this.createComponent());
    component.add(this.createComponent1());
    component.add(this.createComponent2());
    component.add(this.createComponent3());
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
      Object targetObject = this.myComponent1;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      this.myBindings.add(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("devkitDir");
      Object targetObject = this.myComponent3;
      Property targetProperty = BeanProperty.create("path");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      this.myBindings.add(binding);
    }
  }

  private void unbind() {
    for(AutoBinding binding : this.myBindings) {
      if(binding.isBound()) {
        binding.unbind();
      }
    }
  }

  private JLabel createComponent() {
    JLabel component = new JLabel();
    this.myComponent = component;
    component.setText("Devkit Name:");
    return component;
  }

  private JTextField createComponent1() {
    JTextField component = new JTextField();
    this.myComponent1 = component;
    return component;
  }

  private JLabel createComponent2() {
    JLabel component = new JLabel();
    this.myComponent2 = component;
    component.setText("Devkit Path:");
    return component;
  }

  private PathField createComponent3() {
    PathField component = new PathField();
    this.myComponent3 = component;
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

  public void setDialog(NewDevKitDialog newValue) {
    NewDevKitDialog oldValue = this.myDialog;
    this.myDialog = newValue;
    this.firePropertyChange("dialog", oldValue, newValue);
  }

  /* package */void onOk() {
    if(myThis.getDevkitDir().length() == 0) {
      myThis.getDialog().setErrorText("Enter DevKit Directory");
      return;
    }
    if(myThis.getDevkitName().length() == 0) {
      myThis.getDialog().setErrorText("Enter DevKit Name");
      return;
    }
    final String devkitPath = myThis.getDevkitDir() + File.separator + myThis.getDevkitName() + ".devkit";
    if(new File(devkitPath).exists()) {
      myThis.getDialog().setErrorText("File " + devkitPath + " already exists");
      return;
    }
    if(!(new File(devkitPath).isAbsolute())) {
      myThis.getDialog().setErrorText("Path should be absolute");
      return;
    }
    File dir = new File(myThis.getDevkitDir());
    if(!(dir.exists())) {
      if(!(DirectoryUtil.askToCreateNewDirectory(((Frame)myThis.getDialog().getOwner()), dir))) {
        myThis.getDialog().setErrorText("Enter correct path");
        return;
      }
    }
    CommandProcessor.instance().executeCommand(new Runnable() {

      public void run() {
        myThis.createNewDevKit(new File(devkitPath));
      }

    });
    myThis.getDialog().dispose();
  }

  /* package */void onCancel() {
    myThis.getDialog().dispose();
  }

  /* package */void updateSolutionPath() {
    if(myThis.getProject() == null) {
      return;
    }
    String path = FileUtil.getCanonicalPath(myThis.getProject().getProjectFile().getParentFile());
    String prefix = path + File.separator + "devkits" + File.separator;
    if(myThis.getDevkitDir().length() == 0 || myThis.getDevkitDir().startsWith(prefix)) {
      myThis.setDevkitDir(prefix + myThis.getDevkitName());
    }
  }

  /* package */void createNewDevKit(File devkitPath) {
    SNode descriptor = SConceptOperations.createNewNode("jetbrains.mps.projectLanguage.structure.DevKitDescriptor", null);
    SPropertyOperations.set(descriptor, "name", myThis.getDevkitName());
    DescriptorsPersistence.saveDevKitDescriptor((((DevKitDescriptor)SNodeOperations.getAdapter(descriptor))), new FileSystemFile(devkitPath));
    myThis.getProject().addProjectDevKit(new FileSystemFile(devkitPath));
  }

}
