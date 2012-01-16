package jetbrains.mps.uiLanguage.samples.dialogs;

/*Generated by MPS */

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import java.awt.BorderLayout;
import org.jdesktop.beansbinding.Property;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import java.awt.GridBagLayout;
import jetbrains.mps.uiLanguage.runtime.ValueWrapper;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogDemo extends JDialog {
  public DialogDemo myThis;
  private JPanel myComponent_b0;
  private JLabel myComponent_b1a;
  private JLabel myComponent_c1a;
  private JTextField myComponent_d1a;
  private JTextField myComponent_e1a;
  private JPanel myComponent_f1a;
  private JPanel myComponent_c0;
  private JPanel myComponent_c2a;
  private JPanel myComponent_c2c0;
  private JPanel myComponent_d2c0;
  private JButton myComponent_c3c2a;
  private JButton myComponent_d3c2a;
  private String myName;
  private String myLastName;
  public List<AutoBinding> myBindings = ListSequence.fromList(new ArrayList<AutoBinding>());
  private Events myEvents = new Events(null) {
    {
    }

    public void initialize() {
    }
  };

  public DialogDemo() {
    this.myThis = this;
    DialogDemo component = this;
    component.setLayout(new BorderLayout());
    component.add(this.createComponent_50z451_b0(), BorderLayout.CENTER);
    component.add(this.createComponent_50z451_c0(), BorderLayout.SOUTH);
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
      Property sourceProperty = BeanProperty.create("name");
      Object targetObject = this.myComponent_d1a;
      Property targetProperty = BeanProperty.create("text");
      AutoBinding binding = Bindings.createAutoBinding(AutoBinding.UpdateStrategy.READ_WRITE, sourceObject, sourceProperty, targetObject, targetProperty);
      binding.bind();
      ListSequence.fromList(this.myBindings).addElement(binding);
    }
    {
      Object sourceObject = myThis;
      Property sourceProperty = BeanProperty.create("lastName");
      Object targetObject = this.myComponent_e1a;
      Property targetProperty = BeanProperty.create("text");
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

  private JPanel createComponent_50z451_b0() {
    JPanel component = new JPanel();
    this.myComponent_b0 = component;
    component.setLayout(new GridBagLayout());
    component.add(this.createComponent_50z451_b1a(), new ValueWrapper<GridBagConstraints>() {
      public GridBagConstraints value() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        return c;
      }
    }.value());
    component.add(this.createComponent_50z451_c1a(), new ValueWrapper<GridBagConstraints>() {
      public GridBagConstraints value() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        return c;
      }
    }.value());
    component.add(this.createComponent_50z451_d1a(), new ValueWrapper<GridBagConstraints>() {
      public GridBagConstraints value() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 0;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 1;
        return c;
      }
    }.value());
    component.add(this.createComponent_50z451_e1a(), new ValueWrapper<GridBagConstraints>() {
      public GridBagConstraints value() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 1;
        c.gridy = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 1;
        return c;
      }
    }.value());
    component.add(this.createComponent_50z451_f1a(), new ValueWrapper<GridBagConstraints>() {
      public GridBagConstraints value() {
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.weighty = 1;
        return c;
      }
    }.value());
    return component;
  }

  private JLabel createComponent_50z451_b1a() {
    JLabel component = new JLabel();
    this.myComponent_b1a = component;
    component.setText("Name");
    return component;
  }

  private JLabel createComponent_50z451_c1a() {
    JLabel component = new JLabel();
    this.myComponent_c1a = component;
    component.setText("LastName");
    return component;
  }

  private JTextField createComponent_50z451_d1a() {
    JTextField component = new JTextField();
    this.myComponent_d1a = component;
    component.setColumns(20);
    return component;
  }

  private JTextField createComponent_50z451_e1a() {
    JTextField component = new JTextField();
    this.myComponent_e1a = component;
    return component;
  }

  private JPanel createComponent_50z451_f1a() {
    JPanel component = new JPanel();
    this.myComponent_f1a = component;
    return component;
  }

  private JPanel createComponent_50z451_c0() {
    JPanel component = new JPanel();
    this.myComponent_c0 = component;
    component.setLayout(new BorderLayout());
    component.add(this.createComponent_50z451_c2a(), BorderLayout.CENTER);
    return component;
  }

  private JPanel createComponent_50z451_c2a() {
    JPanel component = new JPanel();
    this.myComponent_c2a = component;
    component.setLayout(new BorderLayout());
    component.add(this.createComponent_50z451_c2c0(), BorderLayout.CENTER);
    component.add(this.createComponent_50z451_d2c0(), BorderLayout.EAST);
    return component;
  }

  private JPanel createComponent_50z451_c2c0() {
    JPanel component = new JPanel();
    this.myComponent_c2c0 = component;
    return component;
  }

  private JPanel createComponent_50z451_d2c0() {
    JPanel component = new JPanel();
    this.myComponent_d2c0 = component;
    component.setLayout(new GridLayout(1, 0));
    component.add(this.createComponent_50z451_c3c2a());
    component.add(this.createComponent_50z451_d3c2a());
    return component;
  }

  private JButton createComponent_50z451_c3c2a() {
    JButton component = new JButton();
    this.myComponent_c3c2a = component;
    component.setText("OK");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onOk();
      }
    });
    return component;
  }

  private JButton createComponent_50z451_d3c2a() {
    JButton component = new JButton();
    this.myComponent_d3c2a = component;
    component.setText("Cancel");
    component.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        myThis.onCancel();
      }
    });
    return component;
  }

  public String getName() {
    return this.myName;
  }

  public String getLastName() {
    return this.myLastName;
  }

  public void setName(String newValue) {
    String oldValue = this.myName;
    this.myName = newValue;
    this.firePropertyChange("name", oldValue, newValue);
  }

  public void setLastName(String newValue) {
    String oldValue = this.myLastName;
    this.myLastName = newValue;
    this.firePropertyChange("lastName", oldValue, newValue);
  }

  /*package*/ void onOk() {
    myThis.dispose();
  }

  /*package*/ void onCancel() {
    System.out.println("Cancel");
    myThis.dispose();
  }
}
