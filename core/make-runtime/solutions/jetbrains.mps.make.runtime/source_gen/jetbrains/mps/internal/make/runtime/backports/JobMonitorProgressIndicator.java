package jetbrains.mps.internal.make.runtime.backports;

/*Generated by MPS */

import jetbrains.mps.make.script.IJobMonitor;
import java.util.LinkedList;

public class JobMonitorProgressIndicator extends ProgressIndicatorAdapter {
  private static final int WORK_AMOUNT = 10000;

  private IJobMonitor jm;
  private LinkedList<String> workStack = new LinkedList<String>();

  public JobMonitorProgressIndicator(IJobMonitor jm) {
    this.jm = jm;
  }

  @Override
  public void pushState() {
    workStack.push(null);
  }

  @Override
  public void popState() {
    if (!(workStack.isEmpty())) {
      String text = workStack.pop();
      jm.currentProgress().finishWork(text);
    }
  }

  @Override
  public void setFraction(double frac) {
    if (!(workStack.isEmpty())) {
      jm.currentProgress().workLeft();
      double currFrac = 1. - (double) jm.currentProgress().workLeft() / WORK_AMOUNT;
      jm.currentProgress().advanceWork(workStack.peek(), (int) (WORK_AMOUNT * (Math.max(0., frac - currFrac))));
    }
  }

  @Override
  public String getText() {
    if (workStack.isEmpty()) {
      return null;
    }
    return workStack.peek();
  }

  @Override
  public void setText(String text) {
    if ("".equals(text)) {
      return;
    }
    if (workStack.isEmpty()) {
      workStack.push(null);
    } else if (workStack.peek() != null && neq_8r1isy_a0a0b0e(text, workStack.peek())) {
      popState();
      workStack.push(null);
    }
    if (!(workStack.isEmpty()) && workStack.peek() == null) {
      workStack.pop();
      workStack.push(text);
      jm.currentProgress().beginWork(text, WORK_AMOUNT, 0);
    }
  }

  @Override
  public String getText2() {
    return null;
  }

  @Override
  public void setText2(String string) {
  }

  @Override
  public void setIndeterminate(boolean b) {
  }

  @Override
  public boolean isIndeterminate() {
    return false;
  }

  @Override
  public boolean isCanceled() {
    return jm.stopRequested();
  }

  @Override
  public void cancel() {
  }

  private static boolean neq_8r1isy_a0a0b0e(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }
}
