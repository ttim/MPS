package jetbrains.mps.debug.api.source;

/*Generated by MPS */

import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.debug.api.programState.ILocation;
import jetbrains.mps.debug.api.programState.NullLocation;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.actions.FileOpenUtil;
import jetbrains.mps.generator.traceInfo.TraceInfoUtil;

public class PositionProvider {
  private Project myProject;

  public PositionProvider(Project project) {
    myProject = project;
  }

  @Nullable
  public SourcePosition getPosition(@Nullable ILocation location) {
    if (location == null || location instanceof NullLocation) {
      return null;
    }
    SNodePointer node = getSNodePointer(location);
    if (node != null) {
      return new NodeSourcePosition(node);
    }
    VirtualFile file = getFile(location);
    if (file != null) {
      return new TextSourcePosition(file, location.getLineNumber());
    }
    return null;
  }

  @Nullable
  public SourcePosition getPosition(@NonNls String unitName, @NonNls String fileName, int lineNumber) {
    SNodePointer node = getSNodePointer(unitName, fileName, lineNumber);
    if (node != null) {
      return new NodeSourcePosition(node);
    }
    VirtualFile file = getFile(unitName, fileName);
    if (file != null) {
      return new TextSourcePosition(file, lineNumber);
    }
    return null;
  }

  @Nullable
  public SNodePointer getSNodePointer(@Nullable ILocation location) {
    if (location == null || location instanceof NullLocation) {
      return null;
    }
    return getSNodePointer(location.getUnitName(), location.getFileName(), location.getLineNumber());
  }

  @Nullable
  public SNodePointer getSNodePointer(@NonNls final String unitName, @NonNls final String fileName, final int position) {
    return ModelAccess.instance().runReadAction(new Computable<SNodePointer>() {
      public SNodePointer compute() {
        SNode node = getNode(unitName, fileName, position);
        if (node == null) {
          return null;
        }
        return new SNodePointer(node);
      }
    });
  }

  @Nullable
  public VirtualFile getFile(@Nullable ILocation location) {
    if (location == null || location instanceof NullLocation) {
      return null;
    }
    return FileOpenUtil.findFile(myProject, location.getUnitName(), location.getFileName());
  }

  @Nullable
  public VirtualFile getFile(@NonNls String unitName, @NonNls String fileName) {
    return FileOpenUtil.findFile(myProject, unitName, fileName);
  }

  @Nullable
  public SNode getNode(@Nullable ILocation location) {
    if (location == null || location instanceof NullLocation) {
      return null;
    }
    return getNode(location.getUnitName(), location.getFileName(), location.getLineNumber());
  }

  @Nullable
  public SNode getNode(@NonNls String unitName, @NonNls String fileName, int position) {
    return TraceInfoUtil.getNode(unitName, fileName, position);
  }
}
