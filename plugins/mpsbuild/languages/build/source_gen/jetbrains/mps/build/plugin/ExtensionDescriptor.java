package jetbrains.mps.build.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DefaultExtensionDescriptor;
import jetbrains.mps.smodel.structure.ExtensionPoint;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Arrays;

public class ExtensionDescriptor extends DefaultExtensionDescriptor {
  private ExtensionPoint[] extensionPoints = new ExtensionPoint[]{new ExtensionPoint("jetbrains.mps.build.CanEditBaseDir", _FunctionTypes._return_P1_E0.class)};

  public ExtensionDescriptor() {
  }

  @Override
  public Iterable<? extends ExtensionPoint> getExtensionPoints() {
    return Arrays.asList(extensionPoints);
  }
}
