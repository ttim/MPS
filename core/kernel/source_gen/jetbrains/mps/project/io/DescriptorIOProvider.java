package jetbrains.mps.project.io;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;

public interface DescriptorIOProvider {
  public DescriptorIO<SolutionDescriptor> solutionDescriptorIO();
  public DescriptorIO<LanguageDescriptor> languageDescriptorIO();
  public DescriptorIO<DevkitDescriptor> devkitDescriptorIO();
}
