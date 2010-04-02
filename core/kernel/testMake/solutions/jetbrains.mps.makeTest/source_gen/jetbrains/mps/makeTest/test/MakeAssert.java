package jetbrains.mps.makeTest.test;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import junit.framework.Assert;
import jetbrains.mps.generator.generationTypes.IGenerationHandler;
import jetbrains.mps.project.tester.TesterGenerationHandler;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.ide.progress.ITaskProgressHelper;
import java.lang.reflect.Method;
import java.io.File;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.TestMain;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.MPSProjectHolder;
import jetbrains.mps.ide.ThreadUtils;
import jetbrains.mps.generator.generationTypes.JavaGenerationHandler;

public class MakeAssert {
  private static final String MESSAGE_COMPILATION_FAILED = "Compilation failed";
  private static final String MESSAGE_DEPENDENCY_NOT_CHECKED = "Compilation finished with Unchecked Dependencies";
  private static final String PROJECT_FILE = "core/kernel/testMake/testMake.mpr";

  public static void assertNotMake(final String modelName, final ChangeModel changer) {
    Project project = launchProject();
    Assert.assertNotNull("project is not loaded", project);
    ChangeModelProcessor changeModelProcessor = new ChangeModelProcessor(project, modelName, changer);
    IGenerationHandler genType = getFilesGenHandler();
    boolean baseIsOk = changeModelProcessor.changeStep(genType);
    boolean newIsOk = changeModelProcessor.revertStep(genType);
    changeModelProcessor.getModelToChange().setLoading(false);
    changeModelProcessor.generateModelToChange(genType);
    disposeProject(project);
    assertNoProblems(baseIsOk);
    assertDependenciesChecked(newIsOk);
  }

  public static void assertDependenciesChecked(final String modelName, final ChangeModel changer) {
    final Project project = launchProject();
    Assert.assertNotNull("project is not loaded", project);
    final ChangeModelProcessor changeModelProcessor = new ChangeModelProcessor(project, modelName, changer);
    final IGenerationHandler filesGenHandler = getFilesGenHandler();
    changeModelProcessor.changeStep(filesGenHandler);
    final TesterGenerationHandler genHandler = new TesterGenerationHandler(true);
    changeModelProcessor.generateTestModel(genHandler);
    changeModelProcessor.generateModelToChange(genHandler);
    final Boolean[] returnValue = new Boolean[]{null};
    final SModel testModel = changeModelProcessor.getTestModel();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        try {
          SNode test = ListSequence.fromList(SModelOperations.getRoots(testModel, null)).first();
          String className = NameUtil.nodeFQName(test);
          genHandler.compile(ITaskProgressHelper.EMPTY);
          ClassLoader classLoader = genHandler.getCompiler().getClassLoader(MakeAssert.class.getClassLoader());
          Class testClass = classLoader.loadClass(className);
          Method method = testClass.getMethods()[0];
          returnValue[0] = (Boolean) method.invoke(null);
          System.out.println("Test " + className + "." + method.getName() + " return " + returnValue[0]);
          changeModelProcessor.revertStep(filesGenHandler);
          changeModelProcessor.generateModelToChange(filesGenHandler);
        } catch (Throwable t) {
          disposeProject(project);
          t.printStackTrace();
          Assert.fail("Exception: " + t);
        }
      }
    });
    disposeProject(project);
    Assert.assertFalse(MESSAGE_DEPENDENCY_NOT_CHECKED, returnValue[0]);
  }

  public static void assertDependenciesChecked(boolean isOk) {
    Assert.assertFalse(MESSAGE_DEPENDENCY_NOT_CHECKED, isOk);
  }

  public static void assertNoProblems(boolean isOk) {
    Assert.assertTrue(MESSAGE_COMPILATION_FAILED, isOk);
  }

  private static Project launchProject() {
    File projectFile = new File(PROJECT_FILE);
    IdeMain.setTestMode(IdeMain.TestMode.CORE_TEST);
    TestMain.configureMPS();
    if (!(projectFile.exists())) {
      return null;
    }
    System.out.println("Loading project");
    return TestMain.loadProject(projectFile).getProject();
  }

  private static void disposeProject(final Project project) {
    final MPSProject p = project.getComponent(MPSProjectHolder.class).getMPSProject();
    ThreadUtils.runInUIThreadAndWait(new Runnable() {
      public void run() {
        p.dispose();
      }
    });
  }

  private static JavaGenerationHandler getFilesGenHandler() {
    return new JavaGenerationHandler();
  }
}
