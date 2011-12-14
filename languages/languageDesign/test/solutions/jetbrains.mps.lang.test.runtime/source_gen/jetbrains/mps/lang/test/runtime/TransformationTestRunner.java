package jetbrains.mps.lang.test.runtime;

/*Generated by MPS */

import java.awt.datatransfer.StringSelection;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.IdeMain;
import jetbrains.mps.TestMain;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import org.apache.commons.lang.StringUtils;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ex.ProjectManagerEx;
import jetbrains.mps.project.MPSProject;
import junit.framework.Assert;
import jetbrains.mps.util.MacrosFactory;
import jetbrains.mps.vfs.IFile;
import javax.swing.SwingUtilities;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.awt.Toolkit;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import com.intellij.util.PathUtil;
import java.io.File;
import com.intellij.openapi.application.PathMacros;
import java.lang.reflect.InvocationTargetException;

public class TransformationTestRunner {
  private static StringSelection EMPTY_CLIPBOARD_CONTENT = new StringSelection("");

  public TransformationTestRunner() {
  }

  public void initTest(final BaseTransformationTest btt, @NotNull String projectName, final String model) throws Exception {
    IdeMain.setTestMode(IdeMain.TestMode.CORE_TEST);
    TestMain.configureMPS();
    // we do not want to save our project, see MPS-13352 
    ApplicationManagerEx.getApplicationEx().doNotSave();
    clearSystemClipboard();
    // see MPS-10568 
    readSystemMacro();
    if (StringUtils.isEmpty(projectName)) {
      for (Project project : ProjectManagerEx.getInstanceEx().getOpenProjects()) {
        btt.setMyProject(project.getComponent(MPSProject.class));
        if ((btt.getMyProject()) != null) {
          break;
        }
      }
      if (btt.getMyProject() == null) {
        Assert.fail("MPS Project was not specfied in test class, no currently open project was not found");
      }
    } else {
      btt.setMyProject(TestMain.PROJECT_CONTAINER.getProject(MacrosFactory.mpsHomeMacros().expandPath(projectName, ((IFile) null))));
    }
    SwingUtilities.invokeAndWait(new Runnable() {
      public void run() {
        ModelAccess.instance().runWriteActionInCommand(new Runnable() {
          public void run() {
            SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(SModelReference.fromString(model));
            btt.setModelDescriptor(modelDescriptor);
          }
        });
      }
    });
    ModelAccess.instance().flushEventQueue();
  }

  public void runTest(final BaseTransformationTest btt, final String className, final String methodName, final boolean runInCommand) throws Throwable {
    final Wrappers._T<Class> clazz = new Wrappers._T<Class>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        clazz.value = btt.getMyModel().getModule().getClass(className);
        String classloader = clazz.value.getClassLoader().toString();
        String module = btt.getMyModel().getModule().getModuleFqName();
        assert classloader.contains(module) : "class: " + clazz.value + "; classloader: " + classloader + "; module: " + module;
      }
    });
    final Object obj = clazz.value.newInstance();
    clazz.value.getField("myModel").set(obj, btt.getMyTransidentModel());
    clazz.value.getField("myProject").set(obj, btt.getMyProject());
    final Throwable[] exception = new Throwable[1];
    if (runInCommand) {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          ModelAccess.instance().runWriteActionInCommand(new Runnable() {
            public void run() {
              exception[0] = TransformationTestRunner.this.tryToRunTest(clazz.value, methodName, obj);
            }
          });
        }
      });
    } else {
      exception[0] = TransformationTestRunner.this.tryToRunTest(clazz.value, methodName, obj);
    }
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        SModelRepository.getInstance().removeModelDescriptor(btt.getMyTransidentModel());
        btt.getMyModelOwner().unregisterModelOwner();
      }
    });
    if (exception[0] != null) {
      throw exception[0];
    }
  }

  private void clearSystemClipboard() {
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(TransformationTestRunner.EMPTY_CLIPBOARD_CONTENT, TransformationTestRunner.EMPTY_CLIPBOARD_CONTENT);
  }

  private void readSystemMacro() {
    for (IMapping<Object, Object> property : MapSequence.fromMap(System.getProperties())) {
      if (property.key() instanceof String) {
        String key = (((String) property.key()));
        if (StringUtils.isNotEmpty(key) && key.startsWith(BaseTransformationTest.PATH_MACRO_PREFIX)) {
          if (property.value() instanceof String) {
            String canonicalPath = PathUtil.getCanonicalPath(((String) property.value()));
            File file = new File(canonicalPath);
            if (file.exists() && file.isDirectory()) {
              PathMacros.getInstance().setMacro(key.substring(BaseTransformationTest.PATH_MACRO_PREFIX.length()), canonicalPath);
            }
          }
        }
      }
    }
  }

  private Throwable tryToRunTest(Class clazz, String methodName, Object obj) {
    Throwable exception = null;
    try {
      clazz.getMethod(methodName).invoke(obj);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      exception = e.getTargetException();
    }
    return exception;
  }
}
