package jetbrains.mps.lang.extension.tests.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DefaultExtensionDescriptor;
import jetbrains.mps.smodel.structure.ExtensionPoint;
import jetbrains.mps.smodel.structure.Extension;
import java.util.Arrays;

public class ExtensionDescriptor extends DefaultExtensionDescriptor {
  private ExtensionPoint[] extensionPoints = new ExtensionPoint[]{new ExtensionPoint("jetbrains.mps.lang.extension.tests.testExtensionPoint", TestObject.class), new ExtensionPoint("jetbrains.mps.lang.extension.tests.lazyTestExtensionPoint", LazyTestObject.class), new ExtensionPoint("jetbrains.mps.lang.extension.tests.multiExtensionPoint", String.class)};
  private Extension[] extensions = new Extension[]{new Extension_testExtensionPoint_(), new Extension_lazyTestExtensionPoint_(), new Extension_multiExtensionPoint__0(), new Extension_multiExtensionPoint_()};

  public ExtensionDescriptor() {
  }

  @Override
  public Iterable<? extends ExtensionPoint> getExtensionPoints() {
    return Arrays.asList(extensionPoints);
  }

  @Override
  public Iterable<? extends Extension> getExtensions() {
    return Arrays.asList(extensions);
  }
}
