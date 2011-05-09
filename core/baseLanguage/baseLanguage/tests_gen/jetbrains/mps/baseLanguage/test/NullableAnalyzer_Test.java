package jetbrains.mps.baseLanguage.test;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.util.plugin.run.MPSLaunch;
import jetbrains.mps.lang.test.runtime.BaseTransformationTest;
import org.junit.Test;
import jetbrains.mps.lang.test.runtime.BaseTestBody;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

@MPSLaunch
public class NullableAnalyzer_Test extends BaseTransformationTest {
  @Test
  public void testDot() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testDot", true);
  }

  @Test
  public void testIf() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testIf", true);
  }

  @Test
  public void testWhile() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testWhile", true);
  }

  @Test
  public void testWrite() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testWrite", true);
  }

  @Test
  public void testForLoop() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testForLoop", true);
  }

  @Test
  public void testReturnNotNull() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testReturnNotNull", true);
  }

  @Test
  public void testAnnotationParam() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testAnnotationParam", true);
  }

  @Test
  public void testTernaryOperation() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testTernaryOperation", true);
  }

  @Test
  public void testContinue() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testContinue", true);
  }

  @Test
  public void testIfNullNew() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testIfNullNew", true);
  }

  @Test
  public void testIfNullReturnNotEmpty() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testIfNullReturnNotEmpty", true);
  }

  @Test
  public void testMPS10935() throws Throwable {
    this.initTest("${mps_home}/MPS.mpr", "r:00000000-0000-4000-0000-011c895902c7(jetbrains.mps.baseLanguage.test)");
    this.runTest("jetbrains.mps.baseLanguage.test.NullableAnalyzer_Test$TestBody", "testMPS10935", true);
  }

  @MPSLaunch
  public static class TestBody extends BaseTestBody {
    public void testDot() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("6011730950863071516"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("6011730950863071458"));
    }

    public void testIf() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("1228615757308491250"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("1228615757308491192"));
    }

    public void testWhile() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("6011730950863071627"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("6011730950863071583"));
    }

    public void testWrite() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("6011730950863071665"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("6011730950863071629"));
    }

    public void testForLoop() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("6689253151531890256"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("6689253151531885669"));
    }

    public void testReturnNotNull() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("5899025696847062708"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("5899025696847062681"));
    }

    public void testAnnotationParam() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("6011730950863071781"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("6011730950863071727"));
    }

    public void testTernaryOperation() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("3383816410303507497"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("3383816410303507422"));
    }

    public void testContinue() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("8673157736019176311"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("8673157736019176263"));
    }

    public void testIfNullNew() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("8673157736019186600"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("8673157736019186552"));
    }

    public void testIfNullReturnNotEmpty() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("8673157736019186652"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("8673157736019186604"));
    }

    public void testMPS10935() throws Exception {
      SNode operation = SNodeOperations.cast(this.getRealNodeById("3613402085300515297"), "jetbrains.mps.lang.test.structure.NodeOperation");
      BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(operation, "jetbrains.mps.lang.test.structure.NodeOperation"), "virtual_perform_1215601182156", new Class[]{SNode.class, SNode.class}, this.getRealNodeById("3613402085300515269"));
    }
  }
}
