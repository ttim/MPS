package jetbrains.mps.project.io;

/*Generated by MPS */

import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.project.persistence.SolutionDescriptorPersistence;
import jetbrains.mps.project.persistence.ModuleReadException;
import jetbrains.mps.project.persistence.ModuleDescriptorPersistence;
import org.jdom.Element;
import jetbrains.mps.project.persistence.LanguageDescriptorPersistence;
import jetbrains.mps.project.persistence.GeneratorDescriptorPersistence;
import jetbrains.mps.util.MacrosFactory;
import jetbrains.mps.project.persistence.DevkitDescriptorPersistence;

public class StandardDescriptorIOProvider implements DescriptorIOProvider {
  private static final StandardDescriptorIOProvider.SolutionDescriptorIO SOLUTION = new StandardDescriptorIOProvider.SolutionDescriptorIO();
  private static final StandardDescriptorIOProvider.LanguageDescriptorIO LANGUAGE = new StandardDescriptorIOProvider.LanguageDescriptorIO();
  private static final StandardDescriptorIOProvider.GeneratorDescriptorIO GENERATOR = new StandardDescriptorIOProvider.GeneratorDescriptorIO();
  private static final StandardDescriptorIOProvider.DevkitDescriptorIO DEVKIT = new StandardDescriptorIOProvider.DevkitDescriptorIO();

  /*package*/ StandardDescriptorIOProvider() {
  }

  public DescriptorIO<SolutionDescriptor> solutionDescriptorIO() {
    return SOLUTION;
  }

  public DescriptorIO<LanguageDescriptor> languageDescriptorIO() {
    return LANGUAGE;
  }

  public DescriptorIO<GeneratorDescriptor> generatorDescriptorIO() {
    return GENERATOR;
  }

  public DescriptorIO<DevkitDescriptor> devkitDescriptorIO() {
    return DEVKIT;
  }

  public static class SolutionDescriptorIO implements DescriptorIO<SolutionDescriptor> {
    public SolutionDescriptorIO() {
    }

    public SolutionDescriptor readFromFile(IFile file) throws DescriptorIOException {
      try {
        return SolutionDescriptorPersistence.loadSolutionDescriptor(file);
      } catch (ModuleReadException ex) {
        SolutionDescriptor sd = new SolutionDescriptor();
        ModuleDescriptorPersistence.loadBrokenModule(sd, file, ex);
        return sd;
      }
    }

    public void writeToFile(SolutionDescriptor sd, IFile file) {
      SolutionDescriptorPersistence.saveSolutionDescriptor(file, sd);
    }

    public void writeToXml(SolutionDescriptor sd, Element element, IFile anchorFile) {
      throw new UnsupportedOperationException();
    }

    public SolutionDescriptor readFromXml(Element element, IFile anchorFile) {
      throw new UnsupportedOperationException();
    }
  }

  public static class LanguageDescriptorIO implements DescriptorIO<LanguageDescriptor> {
    public LanguageDescriptorIO() {
    }

    public LanguageDescriptor readFromFile(IFile file) throws DescriptorIOException {
      try {
        return LanguageDescriptorPersistence.loadLanguageDescriptor(file);
      } catch (ModuleReadException ex) {
        LanguageDescriptor ld = new LanguageDescriptor();
        ModuleDescriptorPersistence.loadBrokenModule(ld, file, ex);
        return ld;
      }
    }

    public void writeToFile(LanguageDescriptor ld, IFile file) {
      LanguageDescriptorPersistence.saveLanguageDescriptor(file, ld);
    }

    public void writeToXml(LanguageDescriptor ld, Element element, IFile anchorFile) {
      throw new UnsupportedOperationException();
    }

    public LanguageDescriptor readFromXml(Element element, IFile anchorFile) {
      throw new UnsupportedOperationException();
    }
  }

  public static class GeneratorDescriptorIO implements DescriptorIO<GeneratorDescriptor> {
    public GeneratorDescriptorIO() {
    }

    public GeneratorDescriptor readFromFile(IFile file) {
      throw new UnsupportedOperationException();
    }

    public void writeToFile(GeneratorDescriptor gd, IFile file) {
      throw new UnsupportedOperationException();
    }

    public void writeToXml(GeneratorDescriptor gd, Element element, IFile anchorFile) {
      GeneratorDescriptorPersistence.saveGeneratorDescriptor(element, gd, anchorFile, MacrosFactory.languageDescriptor());
    }

    public GeneratorDescriptor readFromXml(Element element, IFile anchorFile) {
      return GeneratorDescriptorPersistence.loadGeneratorDescriptor(element, anchorFile, MacrosFactory.languageDescriptor());
    }
  }

  public static class DevkitDescriptorIO implements DescriptorIO<DevkitDescriptor> {
    public DevkitDescriptorIO() {
    }

    public DevkitDescriptor readFromFile(IFile file) throws DescriptorIOException {
      try {
        return DevkitDescriptorPersistence.loadDevKitDescriptor(file);
      } catch (ModuleReadException ex) {
        DevkitDescriptor dd = new DevkitDescriptor();
        ModuleDescriptorPersistence.loadBrokenModule(dd, file, ex);
        return dd;
      }
    }

    public void writeToFile(DevkitDescriptor dd, IFile file) {
      DevkitDescriptorPersistence.saveDevKitDescriptor(dd, file);
    }

    public DevkitDescriptor readFromXml(Element element, IFile anchorFile) {
      throw new UnsupportedOperationException();
    }

    public void writeToXml(DevkitDescriptor t, Element element, IFile anchorFile) {
      throw new UnsupportedOperationException();
    }
  }
}
