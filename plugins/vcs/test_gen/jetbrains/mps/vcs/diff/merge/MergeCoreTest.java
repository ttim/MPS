package jetbrains.mps.vcs.diff.merge;

/*Generated by MPS */

import java.io.File;
import org.junit.Test;
import org.junit.BeforeClass;
import jetbrains.mps.MPSCore;
import jetbrains.mps.smodel.persistence.RoleIdsComponent;
import jetbrains.mps.vcs.mergedriver.MergerRoleIdsHandler;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.junit.AfterClass;
import org.junit.Assert;
import java.io.IOException;
import jetbrains.mps.smodel.persistence.def.ModelReadException;

public class MergeCoreTest {
  private static final File TESTDATA_HOME = new File("testbench/modules/merge");
  private static String ourPlayRefactoringWas;
  private static boolean ourMergeDriverModeWas;
  private static final String PLAY_REFACTORINGS_PROPERTY = "mps.playRefactorings";

  public MergeCoreTest() {
  }

  @Test
  public void sandbox() {
    invokeTest("sandbox.mps.zip");
  }

  @Test
  public void tree() {
    invokeTest("tree.mps.zip");
  }

  @BeforeClass
  public static void setUpClass() {
    ourPlayRefactoringWas = System.getProperty(PLAY_REFACTORINGS_PROPERTY);
    ourMergeDriverModeWas = MPSCore.getInstance().isMergeDriverMode();

    System.setProperty(PLAY_REFACTORINGS_PROPERTY, "false");
    MPSCore.getInstance().setMergeDriverMode(true);
    RoleIdsComponent.setHandler(new MergerRoleIdsHandler());

    Properties p = new Properties();
    p.setProperty("log4j.rootLogger", "info, console");
    p.setProperty("log4j.appender.console", "org.apache.log4j.ConsoleAppender");
    p.setProperty("log4j.appender.console.layout", "org.apache.log4j.PatternLayout");
    p.setProperty("log4j.appender.console.layout.ConversionPattern", "%-4r [%t] %-5p %c %x - %m%n");
    p.setProperty("log4j.appender.console.target", "System.err");
    PropertyConfigurator.configure(p);
  }

  @AfterClass
  public static void tearDownClass() {
    if (ourPlayRefactoringWas == null) {
      System.getProperties().remove(PLAY_REFACTORINGS_PROPERTY);
    } else {
      System.setProperty(PLAY_REFACTORINGS_PROPERTY, ourPlayRefactoringWas);
    }
    MPSCore.getInstance().setMergeDriverMode(ourMergeDriverModeWas);
    RoleIdsComponent.setHandler(null);
  }

  private static void invokeTest(String zipFile) {
    try {
      Assert.assertTrue(new MergeData(new File(TESTDATA_HOME, zipFile)).check());
    } catch (Exception e) {
      e.printStackTrace();
      Assert.fail();
    }
  }

  public static void main(String[] args) throws IOException, ModelReadException {
    setUpClass();
    new MergeData(new File(TESTDATA_HOME, "sandbox.mps.zip")).generate();
  }
}
