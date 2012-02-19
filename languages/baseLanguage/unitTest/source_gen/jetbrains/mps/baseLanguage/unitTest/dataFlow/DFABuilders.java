package jetbrains.mps.baseLanguage.unitTest.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilders;
import jetbrains.mps.lang.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {
  public void install(DataFlowManager manager) {
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertEquals", new AssertEquals_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertFalse", new AssertFalse_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertInNotNull", new AssertInNotNull_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertIsNull", new AssertIsNull_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertSame", new AssertSame_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertThrows", new AssertThrows_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.AssertTrue", new AssertTrue_DataFlow());
    manager.register("jetbrains.mps.baseLanguage.unitTest.structure.Message", new Message_DataFlow());
  }
}
