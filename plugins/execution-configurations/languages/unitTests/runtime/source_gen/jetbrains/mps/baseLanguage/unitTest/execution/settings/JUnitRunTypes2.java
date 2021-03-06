package jetbrains.mps.baseLanguage.unitTest.execution.settings;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.unitTest.execution.client.ITestNodeWrapper;
import jetbrains.mps.project.Project;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.baseLanguage.unitTest.execution.client.TestNodeWrapperFactory;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Collections;
import jetbrains.mps.project.IModule;

public enum JUnitRunTypes2 {
  METHOD() {

    public Iterable<ITestNodeWrapper> collect(JUnitSettings_Configuration configuration, Project project) {
      return TestUtils.wrapPointerStrings(configuration.getTestMethods());
    }

    public String check(JUnitSettings_Configuration configuration, Project project) {
      if ((configuration.getTestMethods() == null || configuration.getTestMethods().isEmpty())) {
        return "Methods list is empty.";
      }
      if (configuration.getTestMethods() != null) {
        for (String method : ListSequence.fromList(configuration.getTestMethods())) {
          SNodePointer pointer = TestUtils.stringToPointer(method);
          if (pointer == null || pointer.getNode() == null || TestNodeWrapperFactory.tryToWrap(pointer.getNode()) == null) {
            return "Could not find test method for id " + method + ".";
          }
        }
      }
      return null;
    }

  },
  NODE() {

    public Iterable<ITestNodeWrapper> collect(JUnitSettings_Configuration configuration, Project project) {
      return TestUtils.wrapPointerStrings(configuration.getTestCases());
    }

    public String check(JUnitSettings_Configuration configuration, Project project) {
      if ((configuration.getTestCases() == null || configuration.getTestCases().isEmpty())) {
        return "Classes list is empty.";
      }
      if (configuration.getTestCases() != null) {
        for (String testCase : ListSequence.fromList(configuration.getTestCases())) {
          SNodePointer pointer = TestUtils.stringToPointer(testCase);
          if (pointer == null || pointer.getNode() == null || TestNodeWrapperFactory.tryToWrap(pointer.getNode()) == null) {
            return "Could not find test case for id " + testCase + ".";
          }
        }
      }
      return null;
    }

  },
  MODEL() {

    public Iterable<ITestNodeWrapper> collect(JUnitSettings_Configuration configuration, Project project) {
      SModel model = TestUtils.getModel(configuration.getModel());
      if (model == null) {
        return Sequence.fromIterable(Collections.<ITestNodeWrapper>emptyList());
      }
      return TestUtils.getModelTests(model);
    }

    public String check(JUnitSettings_Configuration configuration, Project project) {
      if (configuration.getModel() == null) {
        return "Model is not selected.";
      }
      SModel model = TestUtils.getModel(configuration.getModel());
      if (model == null) {
        return "Could not find model " + configuration.getModel();
      }
      if (Sequence.fromIterable(TestUtils.getModelTests(model)).isEmpty()) {
        return "No tests found in model " + configuration.getModel() + ".";
      }
      return null;
    }

  },
  MODULE() {

    public Iterable<ITestNodeWrapper> collect(JUnitSettings_Configuration configuration, Project project) {
      IModule module = TestUtils.getModule(configuration.getModule());
      if (module == null) {
        return Sequence.fromIterable(Collections.<ITestNodeWrapper>emptyList());
      }
      return TestUtils.getModuleTests(module);
    }

    public String check(JUnitSettings_Configuration configuration, Project project) {
      if (isEmpty_torbaz_a0a0b3(configuration.getModule())) {
        return "Module is not selected.";
      }
      IModule module = TestUtils.getModule(configuration.getModule());
      if (module == null) {
        return "Module " + configuration.getModule() + " does not exist.";
      }
      if (Sequence.fromIterable(TestUtils.getModuleTests(module)).isEmpty()) {
        return "No tests found in module " + configuration.getModule() + "";
      }
      return null;
    }

  },
  PROJECT() {

    public Iterable<ITestNodeWrapper> collect(JUnitSettings_Configuration configuration, Project project) {
      if (project == null) {
        return Sequence.fromIterable(Collections.<ITestNodeWrapper>emptyList());
      }
      return TestUtils.getProjectTests(project);
    }

    public String check(JUnitSettings_Configuration configuration, Project project) {
      if (project == null) {
        return null;
      }
      if (Sequence.fromIterable(TestUtils.getProjectTests(project)).isEmpty()) {
        return "Project does not contain tests.";
      }
      return null;
    }

  };

  JUnitRunTypes2() {
  }

  public abstract Iterable<ITestNodeWrapper> collect(JUnitSettings_Configuration configuration, Project project);

  public abstract String check(JUnitSettings_Configuration cofiguration, Project project);

  public static boolean isEmpty_torbaz_a0a0b3(String str) {
    return str == null || str.length() == 0;
  }
}
