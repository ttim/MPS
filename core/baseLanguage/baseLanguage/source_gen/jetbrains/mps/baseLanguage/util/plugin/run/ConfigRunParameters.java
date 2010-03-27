package jetbrains.mps.baseLanguage.util.plugin.run;

/*Generated by MPS */

import java.io.File;

public class ConfigRunParameters implements Cloneable {
  private String myVmParam;
  private String myProgramParam;
  private String myWorkingDir;
  private String myAlternativeJRE;
  private boolean myUseAlternativeJRE = false;
  private boolean myMake = false;

  public ConfigRunParameters() {
  }

  public ConfigRunParameters(boolean makeBeforeRun) {
    this.myMake = makeBeforeRun;
  }

  public String getErrorReport() {
    if (this.myUseAlternativeJRE) {
      if (this.myAlternativeJRE != null) {
        File file = new File(BaseRunner.getJavaCommand(this.myAlternativeJRE));
        if (file.exists()) {
          return null;
        }
        return "not valid JRE home";
      }
    }
    return null;
  }

  public void setVMParameters(String value) {
    this.myVmParam = value;
  }

  public void setProgramParameters(String value) {
    this.myProgramParam = value;
  }

  public void setWorkingDirectory(String value) {
    this.myWorkingDir = value;
  }

  public void setMake(boolean value) {
    this.myMake = value;
  }

  public void setAlternativeJRE(String value) {
    this.myAlternativeJRE = value;
  }

  public void setUseAlternativeJRE(boolean value) {
    this.myUseAlternativeJRE = value;
  }

  public boolean getUseAlternativeJRE() {
    return this.myUseAlternativeJRE;
  }

  public String getVMParameters() {
    return this.myVmParam;
  }

  public String getProgramParameters() {
    return this.myProgramParam;
  }

  public String getWorkingDirectory() {
    return this.myWorkingDir;
  }

  public boolean getMake() {
    return this.myMake;
  }

  public String getAlternativeJRE() {
    return this.myAlternativeJRE;
  }

  public ConfigRunParameters copy() {
    try {
      return (ConfigRunParameters) this.clone();
    } catch (CloneNotSupportedException ignored) {
    }
    return null;
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}
