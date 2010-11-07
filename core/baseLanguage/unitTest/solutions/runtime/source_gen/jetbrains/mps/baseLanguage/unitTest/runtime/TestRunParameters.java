package jetbrains.mps.baseLanguage.unitTest.runtime;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;

public class TestRunParameters {
  private String myTestRunner;
  private List<String> myVmParameters;
  private List<String> myClassPath;

  public TestRunParameters() {
    this.myTestRunner = ModernTestRunner.class.getName();
    this.myVmParameters = ListSequence.fromList(new ArrayList<String>());
    this.myClassPath = ListSequence.fromList(new ArrayList<String>());
  }

  public void setTestRunner(String name) {
    this.myTestRunner = name;
  }

  public String getTestRunner() {
    return this.myTestRunner;
  }

  public void setVmParameters(List<String> parameters) {
    this.myVmParameters = parameters;
  }

  public List<String> getVmParameters() {
    return this.myVmParameters;
  }

  public void setClassPath(List<String> classPath) {
    this.myClassPath = classPath;
  }

  public List<String> getClassPath() {
    return this.myClassPath;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof TestRunParameters)) {
      return false;
    }
    TestRunParameters parameters = (TestRunParameters) obj;
    boolean result = eq_mls2ap_a0a2a6(this.myTestRunner, parameters.myTestRunner);
    result = result && eq_mls2ap_a0a0d0g(this.myVmParameters, parameters.myVmParameters);
    result = result && eq_mls2ap_a0a0e0g(this.myClassPath, parameters.myClassPath);
    return result;
  }

  public int hashCode() {
    return this.myTestRunner.hashCode() + this.myClassPath.hashCode() + this.myVmParameters.hashCode();
  }

  private static boolean eq_mls2ap_a0a2a6(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_mls2ap_a0a0d0g(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_mls2ap_a0a0e0g(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
