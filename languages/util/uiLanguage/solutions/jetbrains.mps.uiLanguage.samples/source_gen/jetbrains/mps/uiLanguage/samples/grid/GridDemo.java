package jetbrains.mps.uiLanguage.samples.grid;

/*Generated by MPS */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.util.List;
import org.jdesktop.beansbinding.AutoBinding;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.uiLanguage.runtime.events.Events;
import java.awt.Dimension;
import java.awt.GridLayout;

public class GridDemo extends JFrame {
  public GridDemo myThis;
  private JPanel myComponent_a0;
  private JLabel myComponent_b0a;
  private JLabel myComponent_c0a;
  private JPanel myComponent_d0a;
  private JLabel myComponent_e0a;
  private JLabel myComponent_f0a;
  private JLabel myComponent_g0a;
  public List<AutoBinding> myBindings = ListSequence.fromList(new ArrayList<AutoBinding>());
  private Events myEvents = new Events(null) {
    {
    }

    public void initialize() {
    }
  };

  public GridDemo() {
    this.myThis = this;
    GridDemo component = this;
    component.add(this.createComponent_35s7qs_a0());
    component.setSize(new Dimension(400, 300));
    component.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    component.setVisible(true);
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
  }

  private void unbind() {
    for (AutoBinding binding : this.myBindings) {
      if (binding.isBound()) {
        binding.unbind();
      }
    }
  }

  private JPanel createComponent_35s7qs_a0() {
    JPanel component = new JPanel();
    this.myComponent_a0 = component;
    component.setLayout(new GridLayout(2, 3));
    component.add(this.createComponent_35s7qs_b0a());
    component.add(this.createComponent_35s7qs_c0a());
    component.add(this.createComponent_35s7qs_d0a());
    component.add(this.createComponent_35s7qs_e0a());
    component.add(this.createComponent_35s7qs_f0a());
    component.add(this.createComponent_35s7qs_g0a());
    return component;
  }

  private JLabel createComponent_35s7qs_b0a() {
    JLabel component = new JLabel();
    this.myComponent_b0a = component;
    component.setText("1,1");
    return component;
  }

  private JLabel createComponent_35s7qs_c0a() {
    JLabel component = new JLabel();
    this.myComponent_c0a = component;
    component.setText("1,l2");
    return component;
  }

  private JPanel createComponent_35s7qs_d0a() {
    JPanel component = new JPanel();
    this.myComponent_d0a = component;
    return component;
  }

  private JLabel createComponent_35s7qs_e0a() {
    JLabel component = new JLabel();
    this.myComponent_e0a = component;
    component.setText("2,1");
    return component;
  }

  private JLabel createComponent_35s7qs_f0a() {
    JLabel component = new JLabel();
    this.myComponent_f0a = component;
    component.setText("2,2");
    return component;
  }

  private JLabel createComponent_35s7qs_g0a() {
    JLabel component = new JLabel();
    this.myComponent_g0a = component;
    component.setText("2,3");
    return component;
  }
}
