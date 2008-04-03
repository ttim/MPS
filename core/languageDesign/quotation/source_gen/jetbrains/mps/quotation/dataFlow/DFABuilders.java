package jetbrains.mps.quotation.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilders;
import jetbrains.mps.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {

  public void install(DataFlowManager manager) {
    manager.register("jetbrains.mps.quotation.structure.AbstractAntiquotation", new AbstractAntiquotation_DataFlow());
    manager.register("jetbrains.mps.quotation.structure.Quotation", new Quotation_DataFlow());
  }

}
