package jetbrains.mps.stubs.util;

/*Generated by MPS */

import jetbrains.mps.stubs.BaseStubModelDescriptor;
import jetbrains.mps.smodel.descriptor.NodesNavigationContributor;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.project.IModule;
import java.util.Collection;
import jetbrains.mps.smodel.descriptor.NodeDescriptor;

public class JavaStubModelDescriptor extends BaseStubModelDescriptor implements NodesNavigationContributor {
  public JavaStubModelDescriptor(SModelReference modelReference, JavaStubModelDataSource source, IModule module) {
    super(modelReference, source, module);
  }

  public Collection<NodeDescriptor> getNodeDescriptors() {
    return ((JavaStubModelDataSource) getSource()).getNodeDescriptors(this);
  }
}
