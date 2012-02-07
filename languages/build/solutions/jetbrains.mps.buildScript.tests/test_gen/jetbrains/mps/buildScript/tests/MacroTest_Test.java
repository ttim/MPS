package jetbrains.mps.buildScript.tests;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.buildScript.util.Context;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.PathManager;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import junit.framework.Assert;
import jetbrains.mps.lang.test.matcher.NodesMatcher;
import jetbrains.mps.lang.core.behavior.ScopeProvider_Behavior;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

@MPSLaunch
public class MacroTest_Test extends BaseTransformationTest {
  @Test
  public void test_exportedMacro() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:361d93bd-9223-4768-9e37-bcd7b8db1f40(jetbrains.mps.buildScript.tests@tests)");
    this.runTest("jetbrains.mps.buildScript.tests.MacroTest_Test$TestBody", "test_exportedMacro", true);
  }

  @Test
  public void test_normalScope() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:361d93bd-9223-4768-9e37-bcd7b8db1f40(jetbrains.mps.buildScript.tests@tests)");
    this.runTest("jetbrains.mps.buildScript.tests.MacroTest_Test$TestBody", "test_normalScope", true);
  }

  @Test
  public void test_onlySeePreviouslyDeclaredMacro() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:361d93bd-9223-4768-9e37-bcd7b8db1f40(jetbrains.mps.buildScript.tests@tests)");
    this.runTest("jetbrains.mps.buildScript.tests.MacroTest_Test$TestBody", "test_onlySeePreviouslyDeclaredMacro", true);
  }

  @Test
  public void test_doNotSeeItsefl() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:361d93bd-9223-4768-9e37-bcd7b8db1f40(jetbrains.mps.buildScript.tests@tests)");
    this.runTest("jetbrains.mps.buildScript.tests.MacroTest_Test$TestBody", "test_doNotSeeItsefl", true);
  }

  @Test
  public void test_doNotSeeImported() throws Throwable {
    this.initTest("${mps_home}/MPS.ipr", "r:361d93bd-9223-4768-9e37-bcd7b8db1f40(jetbrains.mps.buildScript.tests@tests)");
    this.runTest("jetbrains.mps.buildScript.tests.MacroTest_Test$TestBody", "test_doNotSeeImported", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void test_exportedMacro() throws Exception {
      this.addNodeById("193602448594327347");
      this.addNodeById("763409143595572699");
      Context context = new Context() {
        @Override
        public String getBasePath_Local(SNode node) {
          return PathManager.getHomePath();
        }
      };
      List<SNode> exportedMacro = context.getExportedMacro(SNodeOperations.cast(this.getNodeById("193602448594327348"), "jetbrains.mps.buildScript.structure.BuildProject"));

      List<SNode> expected = new ArrayList<SNode>();
      ListSequence.fromList(expected).addElement(new MacroTest_Test.TestBody.QuotationClass_oxxkhl_a0a0g0a0().createNode("${build.dir}/tmp/project.tmp"));
      ListSequence.fromList(expected).addElement(new MacroTest_Test.TestBody.QuotationClass_oxxkhl_a0a0h0a0().createNode("${build.dir}/artifacts/project.artifacts"));

      for (int i = 0; i < ListSequence.fromList(expected).count(); i++) {
        Assert.assertEquals(null, NodesMatcher.matchNodes(ListSequence.fromListAndArray(new ArrayList<SNode>(), expected.get(i)), ListSequence.fromListAndArray(new ArrayList<SNode>(), exportedMacro.get(i))));
      }
    }

    public void test_normalScope() throws Exception {
      this.addNodeById("193602448594327347");
      this.addNodeById("763409143595572699");
      Assert.assertTrue(ListSequence.fromList(ScopeProvider_Behavior.call_getScope_3734116213129936182(SNodeOperations.cast(this.getNodeById("193602448594327348"), "jetbrains.mps.buildScript.structure.BuildProject"), ModelAccess.instance().runReadAction(new Computable<SNode>() {
        public SNode compute() {
          return SConceptOperations.findConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro");
        }
      }), SNodeOperations.cast(this.getNodeById("193602448594330636"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")).getAvailableElements("")).contains(SNodeOperations.cast(this.getNodeById("193602448594330632"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")));
    }

    public void test_onlySeePreviouslyDeclaredMacro() throws Exception {
      this.addNodeById("193602448594327347");
      this.addNodeById("763409143595572699");
      Assert.assertFalse(ListSequence.fromList(ScopeProvider_Behavior.call_getScope_3734116213129936182(SNodeOperations.cast(this.getNodeById("193602448594327348"), "jetbrains.mps.buildScript.structure.BuildProject"), ModelAccess.instance().runReadAction(new Computable<SNode>() {
        public SNode compute() {
          return SConceptOperations.findConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro");
        }
      }), SNodeOperations.cast(this.getNodeById("193602448594330632"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")).getAvailableElements("")).contains(SNodeOperations.cast(this.getNodeById("193602448594330636"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")));
    }

    public void test_doNotSeeItsefl() throws Exception {
      this.addNodeById("193602448594327347");
      this.addNodeById("763409143595572699");
      Assert.assertFalse(ListSequence.fromList(ScopeProvider_Behavior.call_getScope_3734116213129936182(SNodeOperations.cast(this.getNodeById("763409143595572700"), "jetbrains.mps.buildScript.structure.BuildProject"), ModelAccess.instance().runReadAction(new Computable<SNode>() {
        public SNode compute() {
          return SConceptOperations.findConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro");
        }
      }), SNodeOperations.cast(this.getNodeById("763409143595572705"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")).getAvailableElements("")).contains(SNodeOperations.cast(this.getNodeById("763409143595572705"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")));
    }

    public void test_doNotSeeImported() throws Exception {
      this.addNodeById("193602448594327347");
      this.addNodeById("763409143595572699");
      Assert.assertFalse(ListSequence.fromList(ScopeProvider_Behavior.call_getScope_3734116213129936182(SNodeOperations.cast(this.getNodeById("763409143595572700"), "jetbrains.mps.buildScript.structure.BuildProject"), ModelAccess.instance().runReadAction(new Computable<SNode>() {
        public SNode compute() {
          return SConceptOperations.findConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro");
        }
      }), SNodeOperations.cast(this.getNodeById("763409143595572705"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")).getAvailableElements("")).contains(SNodeOperations.cast(this.getNodeById("193602448594330632"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")));
      Assert.assertFalse(ListSequence.fromList(ScopeProvider_Behavior.call_getScope_3734116213129936182(SNodeOperations.cast(this.getNodeById("763409143595572700"), "jetbrains.mps.buildScript.structure.BuildProject"), ModelAccess.instance().runReadAction(new Computable<SNode>() {
        public SNode compute() {
          return SConceptOperations.findConceptDeclaration("jetbrains.mps.buildScript.structure.BuildMacro");
        }
      }), SNodeOperations.cast(this.getNodeById("763409143595572705"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")).getAvailableElements("")).contains(SNodeOperations.cast(this.getNodeById("193602448594330636"), "jetbrains.mps.buildScript.structure.BuildFolderMacro")));
    }

    public static class QuotationClass_oxxkhl_a0a0g0a0 {
      public QuotationClass_oxxkhl_a0a0g0a0() {
      }

      public SNode createNode(Object parameter_3) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.ExportedMacroInternal", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          quotedNode1_2.setProperty("name", "project.tmp");
          quotedNode1_2.setProperty("defaultPath", (String) parameter_3);
          result = quotedNode1_2;
        }
        return result;
      }
    }

    public static class QuotationClass_oxxkhl_a0a0h0a0 {
      public QuotationClass_oxxkhl_a0a0h0a0() {
      }

      public SNode createNode(Object parameter_3) {
        SNode result = null;
        Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
        SNode quotedNode_1 = null;
        {
          quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildScript.structure.ExportedMacroInternal", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_2 = quotedNode_1;
          quotedNode1_2.setProperty("name", "project.deploy.dir");
          quotedNode1_2.setProperty("defaultPath", (String) parameter_3);
          result = quotedNode1_2;
        }
        return result;
      }
    }
  }
}
