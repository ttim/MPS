package jetbrains.mps.kernel.tests.iotests;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.MPSLaunch;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.project.io.DescriptorIOProvider;
import jetbrains.mps.project.io.DescriptorIOFacade;
import junit.framework.Assert;
import jetbrains.mps.project.io.DescriptorIO;
import jetbrains.mps.project.structure.modules.SolutionDescriptor;
import jetbrains.mps.project.ModuleId;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.project.structure.modules.Dependency;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.io.DescriptorIOException;
import org.custommonkey.xmlunit.XMLAssert;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;

public class DescriptorsIO_Test extends TestCase {
  @MPSLaunch
  public void test_solutionRead() throws Exception {
    IFile solFile = TestUtils.dataFile("solution.msd");
    DescriptorIOProvider diof = DescriptorIOFacade.getInstance().standardProvider();
    Assert.assertNotNull(diof);
    DescriptorIO<SolutionDescriptor> sdio = diof.solutionDescriptorIO();
    Assert.assertSame(sdio, DescriptorIOFacade.getInstance().fromFileType(solFile));
    SolutionDescriptor sd = sdio.readFromFile(solFile);
    Assert.assertEquals("cd64bfb0-4c10-11e1-b5a0-6cf049e62fe5", sd.getUUID());
    Assert.assertTrue(sd.getCompileInMPS());
    Assert.assertSame(1, sd.getDependencies().size());
    Assert.assertEquals(ModuleId.fromString("6354ebe7-c22a-4a0f-ac54-50b52ab9b065"), Sequence.fromIterable(((Iterable<Dependency>) sd.getDependencies())).first().getModuleRef().getModuleId());
  }

  @MPSLaunch
  public void test_solutionWrite() throws Exception {
    final SolutionDescriptor sd = new SolutionDescriptor();
    sd.setUUID("ee551e28-4c19-11e1-b795-6cf049e62fe5");
    final IFile solFile = TestUtils.tmpFile("solution.msd");
    DescriptorIOProvider diof = DescriptorIOFacade.getInstance().standardProvider();
    final DescriptorIO<SolutionDescriptor> sdio = diof.solutionDescriptorIO();
    FileSystem.getInstance().runWriteTransaction(new Runnable() {
      public void run() {
        ModelAccess.instance().runWriteAction(new Runnable() {
          public void run() {
            try {
              sdio.writeToFile(sd, solFile);
            } catch (DescriptorIOException e) {
              throw new RuntimeException(e);
            }
          }
        });
      }
    });
    XMLAssert.assertXMLEqual("<solution uuid=\"ee551e28-4c19-11e1-b795-6cf049e62fe5\" compileInMPS=\"true\"><sourcePath /><models /></solution>", TestUtils.readXml(solFile));
  }

  @MPSLaunch
  public void test_languageRead() throws Exception {
    IFile langFile = TestUtils.dataFile("language.mpl");
    DescriptorIOProvider diof = DescriptorIOFacade.getInstance().standardProvider();
    Assert.assertNotNull(diof);
    DescriptorIO<LanguageDescriptor> ldio = diof.languageDescriptorIO();
    Assert.assertSame(ldio, DescriptorIOFacade.getInstance().fromFileType(langFile));
    LanguageDescriptor ld = ldio.readFromFile(langFile);
    Assert.assertEquals("8def2cb8-4c14-11e1-a9af-6cf049e62fe5", ld.getUUID());
    Assert.assertTrue(ld.getCompileInMPS());
    Assert.assertSame(1, ld.getDependencies().size());
    Assert.assertEquals(ModuleId.fromString("ceab5195-25ea-4f22-9b92-103b95ca8c0c"), Sequence.fromIterable(((Iterable<Dependency>) ld.getDependencies())).first().getModuleRef().getModuleId());
    Assert.assertSame(1, ld.getExtendedLanguages().size());
    Assert.assertEquals(ModuleId.fromString("f3061a53-9226-4cc5-a443-f952ceaf5816"), Sequence.fromIterable(((Iterable<ModuleReference>) ld.getExtendedLanguages())).first().getModuleId());
  }

  @MPSLaunch
  public void test_languageWrite() throws Exception {
    final LanguageDescriptor ld = new LanguageDescriptor();
    ld.setUUID("defe1a08-4c21-11e1-b31b-6cf049e62fe5");
    ld.setNamespace("jetbrains.mps.project.iotests.testLanguage");
    final IFile langFile = TestUtils.tmpFile("language.mpl");
    final DescriptorIOProvider diof = DescriptorIOFacade.getInstance().standardProvider();
    FileSystem.getInstance().runWriteTransaction(new Runnable() {
      public void run() {
        ModelAccess.instance().runWriteAction(new Runnable() {
          public void run() {
            try {
              diof.languageDescriptorIO().writeToFile(ld, langFile);
            } catch (DescriptorIOException e) {
              throw new RuntimeException(e);
            }
          }
        });
      }
    });

    XMLAssert.assertXMLEqual("<language namespace=\"jetbrains.mps.project.iotests.testLanguage\" uuid=\"defe1a08-4c21-11e1-b31b-6cf049e62fe5\" doNotGenerateAdapters=\"false\"><sourcePath /><models /><accessoryModels /><generators /><extendedLanguages /></language>", TestUtils.readXml(langFile));
  }

  @MPSLaunch
  public void test_devkitRead() throws Exception {
    IFile dkFile = TestUtils.dataFile("devkit.devkit");
    DescriptorIOProvider diof = DescriptorIOFacade.getInstance().standardProvider();
    Assert.assertNotNull(diof);
    DescriptorIO<DevkitDescriptor> dkdio = diof.devkitDescriptorIO();
    Assert.assertSame(dkdio, DescriptorIOFacade.getInstance().fromFileType(dkFile));
    DevkitDescriptor dkd = dkdio.readFromFile(dkFile);
    Assert.assertEquals("68036bba-4c17-11e1-9e4a-6cf049e62fe5", dkd.getUUID());
    Assert.assertSame(1, dkd.getExtendedDevkits().size());
    Assert.assertEquals(ModuleId.fromString("fbc25dd2-5da4-483a-8b19-70928e1b62d7"), Sequence.fromIterable(((Iterable<ModuleReference>) dkd.getExtendedDevkits())).first().getModuleId());
  }

  @MPSLaunch
  public void test_devkitWrite() throws Exception {
    final DevkitDescriptor dkd = new DevkitDescriptor();
    dkd.setUUID("2adf1480-4c23-11e1-ab94-6cf049e62fe5");
    dkd.setNamespace("jetbrains.mps.project.iotests.testDevkit");
    final IFile dkFile = TestUtils.tmpFile("devkit.devkit");
    final DescriptorIOProvider diof = DescriptorIOFacade.getInstance().standardProvider();
    FileSystem.getInstance().runWriteTransaction(new Runnable() {
      public void run() {
        ModelAccess.instance().runWriteAction(new Runnable() {
          public void run() {
            try {
              diof.devkitDescriptorIO().writeToFile(dkd, dkFile);
            } catch (DescriptorIOException e) {
              throw new RuntimeException(e);
            }
          }
        });
      }
    });
    XMLAssert.assertXMLEqual("<dev-kit name=\"jetbrains.mps.project.iotests.testDevkit\" uuid=\"2adf1480-4c23-11e1-ab94-6cf049e62fe5\" />", TestUtils.readXml(dkFile));
  }
}
