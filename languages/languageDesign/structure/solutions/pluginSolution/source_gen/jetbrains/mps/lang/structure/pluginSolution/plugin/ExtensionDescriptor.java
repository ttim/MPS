package jetbrains.mps.lang.structure.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.DefaultExtensionDescriptor;
import jetbrains.mps.smodel.structure.Extension;
import java.util.Arrays;

public class ExtensionDescriptor extends DefaultExtensionDescriptor {
  private Extension[] extensions = new Extension[]{new Extension_NodeRenamer7972144475523791621_()};

  public ExtensionDescriptor() {
  }

  @Override
  public Iterable<? extends Extension> getExtensions() {
    return Arrays.asList(extensions);
  }
}
