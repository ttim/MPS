package jetbrains.mps.transformation.generationContext.dataFlow;

/*Generated by MPS */

import jetbrains.mps.dataFlow.DataFlowBuilders;
import jetbrains.mps.dataFlow.DataFlowManager;

public class DFABuilders extends DataFlowBuilders {

  public void install(DataFlowManager manager) {
    manager.register("jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_GetOutputByLabelAndInput", new GenerationContextOp_GetOutputByLabelAndInput_DataFlow());
    manager.register("jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_GetCopiedOutputByInput", new GenerationContextOp_GetCopiedOutputByInput_DataFlow());
    manager.register("jetbrains.mps.transformation.generationContext.structure.GenerationContextOp_UserObjectAccessBase", new GenerationContextOp_UserObjectAccessBase_DataFlow());
  }

}
