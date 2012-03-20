package jetbrains.mps.debug.api;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.debug.api.programState.IStackFrame;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.debug.api.programState.ILocation;

public interface IDebuggableFramesSelector {
  @Nullable
  public IStackFrame findDeepestDebuggableFrame(List<IStackFrame> frames);
  public int findDeepestDebuggableFrameIndex(List<IStackFrame> frames);
  public boolean isDebuggableFrame(@NotNull IStackFrame frame);
  public boolean isDebuggablePosition(@NonNls String unitName, @NonNls String fileName, int position);
  /**
   * * Tells if two position in code correspond to the same node.
   */
  public boolean isSamePosition(String lastUnitName, String lastFileName, int lastLineNumber, int lastFrameCount, String nextUnitName, String nextFileName, int nextLineNumber, int nextFrameCount);
  public SNode getNode(ILocation location);
  public SNode getNode(@NonNls String unitName, @NonNls String fileName, int position);
}
