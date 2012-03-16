package jetbrains.mps.debugger.java.runtime;

/*Generated by MPS */

import jetbrains.mps.debug.api.source.NodePositionProvider;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.generator.traceInfo.TraceInfoUtil;

public class JavaNodePositionProvider extends NodePositionProvider {
  public JavaNodePositionProvider() {
  }

  @Nullable
  @Override
  public SNode getNode(@NonNls String unitName, @NonNls String fileName, int position) {
    return TraceInfoUtil.getJavaNode(unitName, fileName, position);
  }
}
