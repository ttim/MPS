package jetbrains.mps.junit;

import org.apache.log4j.Logger;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

import java.io.PrintStream;

/**
* Created by IntelliJ IDEA.
* User: fyodor
* Date: Aug 18, 2010
* Time: 2:50:50 PM
* To change this template use File | Settings | File Templates.
*/
class DelegatingRunNotifier extends RunNotifier {
  private final RunNotifier delegate;

  DelegatingRunNotifier(RunNotifier delegate){
    this.delegate = delegate;
  }

  @Override
  public void addListener(RunListener listener) {
    delegate.addListener(listener);
  }

  @Override
  public void removeListener(RunListener listener) {
    delegate.removeListener(listener);
  }

  @Override
  public void fireTestRunStarted(Description description) {
    delegate.fireTestRunStarted(description);
  }

  @Override
  public void fireTestRunFinished(Result result) {
    delegate.fireTestRunFinished(result);
  }

  @Override
  public void fireTestStarted(Description description) throws StoppedByUserException {
    delegate.fireTestStarted(description);
  }

  @Override
  public void fireTestFinished(Description description) {
    delegate.fireTestFinished(description);
  }

  @Override
  public void fireTestFailure(Failure failure) {
    delegate.fireTestFailure(failure);
  }

  @Override
  public void fireTestAssumptionFailed(Failure failure) {
    delegate.fireTestAssumptionFailed(failure);
  }

  @Override
  public void fireTestIgnored(Description description) {
    delegate.fireTestIgnored(description);
  }

  @Override
  public void pleaseStop() {
    delegate.pleaseStop();
  }

  @Override
  public void addFirstListener(RunListener listener) {
    delegate.addFirstListener(listener);
  }

}
