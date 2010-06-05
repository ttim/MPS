package jetbrains.mps.ide.properties;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;

public class SolutionProperties extends ModuleProperties {
  public static final String EXTERNALLY_VISIBLE = "externallyVisible";
  public static final String OUTPUT_PATH = "outputPath";
  public static final String DONT_LOAD_CLASSPATH = "dontLoadClasses";

  private boolean myExternallyVisible;
  private boolean myDontLoadClasses;
  private String myOutputPath;

  public SolutionProperties() {
  }

  public boolean isExternallyVisible() {
    return myExternallyVisible;
  }

  public void setExternallyVisible(boolean externallyVisible) {
    myExternallyVisible = externallyVisible;
  }

  public boolean isDontLoadClasses() {
    return myDontLoadClasses;
  }

  public void setDontLoadClasses(boolean dontLoadClasses) {
    myDontLoadClasses = dontLoadClasses;
  }

  public String getOutputPath() {
    return myOutputPath;
  }

  public void setOutputPath(String outputPath) {
    myOutputPath = outputPath;
  }

  @Override
  public void loadFrom(ModuleDescriptor descriptor) {
    assert descriptor instanceof SolutionDescriptor;
    super.loadFrom(descriptor);
    SolutionDescriptor d = (SolutionDescriptor) descriptor;
    myExternallyVisible = d.isExternallyVisible();
    myDontLoadClasses = d.isDontLoadClasses();
    myOutputPath = d.getOutputPath();
  }

  @Override
  public void saveTo(ModuleDescriptor descriptor) {
    assert descriptor instanceof SolutionDescriptor;
    super.saveTo(descriptor);
    SolutionDescriptor d = (SolutionDescriptor) descriptor;
    d.setExternallyVisible(myExternallyVisible);
    d.setDontLoadClasses(myDontLoadClasses);
    d.setOutputPath(myOutputPath);
  }
}
