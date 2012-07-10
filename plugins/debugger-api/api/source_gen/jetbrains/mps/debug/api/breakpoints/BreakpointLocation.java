package jetbrains.mps.debug.api.breakpoints;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.traceInfo.TraceablePositionInfo;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.traceInfo.DebugInfo;
import jetbrains.mps.generator.traceInfo.TraceInfoCache;
import jetbrains.mps.traceInfo.PositionInfo;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.SModelReference;

public class BreakpointLocation {
  private static final Logger LOG = Logger.getLogger(BreakpointLocation.class);

  private final SNodePointer myNodePointer;

  public BreakpointLocation(@NotNull SNodePointer nodePointer) {
    myNodePointer = nodePointer;
    LOG.assertLog(nodePointer.getModelReference() != null && nodePointer.getNodeId() != null);
  }

  public BreakpointLocation(@NotNull SNode node) {
    myNodePointer = new SNodePointer(node);
  }

  public SNodePointer getNodePointer() {
    return myNodePointer;
  }

  @Nullable
  public SNode getSNode() {
    return myNodePointer.getNode();
  }

  @Nullable
  public TraceablePositionInfo getTargetCodePosition() {
    SModelDescriptor model = myNodePointer.getModel();
    if (model == null) {
      return null;
    }
    DebugInfo debugInfo = TraceInfoCache.getInstance().get(model);
    if (debugInfo == null) {
      return null;
    }
    return debugInfo.getPositionForNode(myNodePointer.getNodeId().toString());
  }

  public String getTargetUnitName() {
    DebugInfo debugInfo = TraceInfoCache.getInstance().get(myNodePointer.getModel());
    if (debugInfo == null) {
      return null;
    }
    return debugInfo.getUnitNameForLine(getFileName(), getLineIndexInFile());
  }

  public boolean isValid() {
    return getTargetCodePosition() != null;
  }

  public int getLineIndexInFile() {
    PositionInfo position = getTargetCodePosition();
    if (position == null) {
      return -1;
    }
    return position.getStartLine() + 1;
  }

  public String getFileName() {
    PositionInfo positionInfo = getTargetCodePosition();
    if (positionInfo == null) {
      return null;
    }
    return positionInfo.getFileName();
  }

  public String getPresentation() {
    return ModelAccess.instance().runReadAction(new Computable<String>() {
      @Override
      public String compute() {
        SNode node = myNodePointer.getNode();
        if (node != null) {
          SNode root = node.getContainingRoot();
          return node + " in " + root + " (" + myNodePointer.getModel().getSModelReference().getSModelFqName() + ")";
        } else {
          return myNodePointer.getNodeId() + " (" + myNodePointer.getModel().getSModelReference().getSModelFqName() + ")";
        }
      }
    });
  }

  public SModelReference getModelReference() {
    return myNodePointer.getModelReference();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }

    return eq_ei108j_a0d0j(myNodePointer, ((BreakpointLocation) o).myNodePointer);
  }

  @Override
  public int hashCode() {
    int result = 0;
    result = 31 * result + ((myNodePointer != null ?
      ((Object) myNodePointer).hashCode() :
      0
    ));
    return result;
  }

  private static boolean eq_ei108j_a0d0j(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }
}
