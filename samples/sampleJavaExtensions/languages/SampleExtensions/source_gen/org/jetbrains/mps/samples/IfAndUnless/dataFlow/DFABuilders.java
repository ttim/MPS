package org.jetbrains.mps.samples.IfAndUnless.dataFlow;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.DataFlowBuilders;
import jetbrains.mps.lang.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {
  public void install(DataFlowManager manager) {
    manager.register("org.jetbrains.mps.samples.IfAndUnless.structure.UnlessStatement", new UnlessStatement_DataFlow());
  }
}
