package jetbrains.mps.ui.sandbox;

/*Generated by MPS */

import java.util.Iterator;
import com.google.gwt.user.client.ui.Widget;
import java.util.NoSuchElementException;

public class WidgetIterator implements Iterator<Widget> {
  private Iterator<Widget> deleg;
  private Widget nextWidget = null;

  public WidgetIterator(Iterator<Widget> deleg) {
    this.deleg = deleg;
  }

  public boolean hasNext() {
    if (this.nextWidget == null) {
      this.moveToNext();
    }
    return this.nextWidget != null;
  }

  public Widget next() {
    if (this.nextWidget != null) {
      return this.clearNext();
    }
    this.moveToNext();
    if (this.nextWidget == null) {
      throw new NoSuchElementException();
    }
    return this.clearNext();
  }

  public void remove() {
    if (this.nextWidget != null) {
      throw new IllegalStateException();
    }
    this.deleg.remove();
  }

  protected boolean accept(Widget w) {
    return true;
  }

  private void moveToNext() {
    this.nextWidget = null;
    while (this.deleg.hasNext()) {
      Widget w = this.deleg.next();
      if (this.accept(w)) {
        this.nextWidget = w;
        break;
      }
    }
  }

  private Widget clearNext() {
    Widget tmp = this.nextWidget;
    this.nextWidget = null;
    return tmp;
  }
}
