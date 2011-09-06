package buildtest;

/*Generated by MPS */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.dom.client.Style;
import jetbrains.mps.internal.collections.runtime.backports.Deque;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import com.google.gwt.user.client.ui.Label;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.DequeSequence;
import jetbrains.mps.internal.collections.runtime.LinkedListSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.internal.collections.runtime.IVisitor;

public class SampleModule implements EntryPoint {
  public SampleModule() {
  }

  public void onModuleLoad() {
    Widget cmp = this.createComponent();
    RootLayoutPanel.get().add(cmp);
  }

  private Widget createComponent() {
    DockLayoutPanel lp = new DockLayoutPanel(Style.Unit.EM);
    Deque<Widget> widgets = createWidgets(new _FunctionTypes._return_P1_E0<Label, Integer>() {
      public Label invoke(Integer i) {
        Label label = new Label();
        label.setText("Label #" + i);
        return label;
      }
    }, Sequence.fromClosure(new ISequenceClosure<Integer>() {
      public Iterable<Integer> iterable() {
        return new Iterable<Integer>() {
          public Iterator<Integer> iterator() {
            return new YieldingIterator<Integer>() {
              private int __CP__ = 0;
              private int _2_i;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_i = 1;
                    case 3:
                      if (!(_2_i <= 10)) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _2_i++;
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(_2_i);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    }));
    while (DequeSequence.fromDeque(widgets).isNotEmpty()) {
      lp.add(DequeSequence.fromDeque(widgets).removeLastElement());
    }
    return lp;
  }

  public Deque<Widget> createWidgets(final _FunctionTypes._return_P1_E0<? extends Widget, ? super Integer> f, Iterable<Integer> ints) {
    final Deque<Widget> widgets = LinkedListSequence.fromLinkedList(new LinkedList<Widget>());
    Sequence.fromIterable(ints).visitAll(new IVisitor<Integer>() {
      public void visit(Integer i) {
        LinkedListSequence.fromLinkedList(widgets).insertElement(0, f.invoke(i));
      }
    });
    return widgets;
  }
}
