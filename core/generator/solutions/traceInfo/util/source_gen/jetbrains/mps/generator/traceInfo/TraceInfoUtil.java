package jetbrains.mps.generator.traceInfo;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.util.Mapper2;
import jetbrains.mps.traceInfo.DebugInfo;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.traceInfo.PositionInfo;
import jetbrains.mps.traceInfo.UnitPositionInfo;
import java.util.List;
import jetbrains.mps.util.Mapper;
import jetbrains.mps.traceInfo.DebugInfoRoot;
import java.util.Set;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.ArrayList;
import jetbrains.mps.traceInfo.TraceablePositionInfo;
import jetbrains.mps.traceInfo.ScopePositionInfo;

public class TraceInfoUtil {
  public TraceInfoUtil() {
  }

  @Nullable
  public static <T> T findInDebugInfo(@NotNull String className, @NotNull final Mapper2<? super DebugInfo, ? super SModelDescriptor, ? extends T> nodeGetter) {
    int lastDot = className.lastIndexOf(".");
    String pkg = ((lastDot == -1 ?
      "" :
      className.substring(0, lastDot)
    ));
    for (String stereotype : SModelStereotype.values) {
      final SModelDescriptor descriptor = SModelRepository.getInstance().getModelDescriptor(new SModelFqName(pkg, stereotype));
      if (descriptor == null) {
        continue;
      }
      if (SModelStereotype.isStubModelStereotype(descriptor.getStereotype())) {
        continue;
      }
      final DebugInfo info = TraceInfoCache.getInstance().get(descriptor);
      if (info == null) {
        continue;
      }
      //  todo tryRead does really fit here(?) 
      T result = ModelAccess.instance().tryRead(new Computable<T>() {
        @Override
        public T compute() {
          return nodeGetter.value(info, descriptor);
        }
      });
      if (result != null) {
        return result;
      }
    }
    return null;
  }

  @Nullable
  public static String getUnitName(@NotNull String className, final String file, final int position) {
    return TraceInfoUtil.findInDebugInfo(className, new Mapper2<DebugInfo, SModelDescriptor, String>() {
      public String value(DebugInfo info, SModelDescriptor descriptor) {
        return info.getUnitNameForLine(file, position);
      }
    });
  }

  @Nullable
  public static SNode getUnitNode(@NotNull String className, final String file, final int position) {
    return TraceInfoUtil.findInDebugInfo(className, new Mapper2<DebugInfo, SModelDescriptor, SNode>() {
      public SNode value(DebugInfo result, SModelDescriptor descriptor) {
        return result.getUnitNodeForLine(file, position, descriptor.getSModel());
      }
    });
  }

  @Nullable
  public static SNode getNode(@NotNull String className, final String file, final int position) {
    return TraceInfoUtil.findInDebugInfo(className, new Mapper2<DebugInfo, SModelDescriptor, SNode>() {
      public SNode value(DebugInfo result, SModelDescriptor descriptor) {
        return result.getNodeForLine(file, position, descriptor.getSModel());
      }
    });
  }

  @Nullable
  public static SNode getVar(@NotNull String className, final String file, final int position, @NotNull final String varName) {
    return TraceInfoUtil.findInDebugInfo(className, new Mapper2<DebugInfo, SModelDescriptor, SNode>() {
      public SNode value(DebugInfo result, SModelDescriptor descriptor) {
        return result.getVarForLine(file, position, descriptor.getSModel(), varName);
      }
    });
  }

  @Nullable
  public static SNode getNodes(String stacktraceLine, String position) {
    int lastDot = stacktraceLine.lastIndexOf(".");
    String pkg = ((lastDot == -1 ?
      "" :
      stacktraceLine.substring(0, lastDot)
    ));
    String[] split = position.split(":");
    if (split.length >= 2) {
      return TraceInfoUtil.getNode(pkg, split[0], Integer.parseInt(split[1]));
    }
    return null;
  }

  @Nullable
  public static String getGeneratedFileName(SNode node) {
    SModel model = node.getModel();
    DebugInfo debugInfo = TraceInfoCache.getInstance().get(model.getModelDescriptor());
    if (debugInfo == null) {
      return null;
    }
    PositionInfo positionInfo = debugInfo.getPositionForNode(node.getId());
    if (positionInfo != null) {
      return model.getLongName() + "." + positionInfo.getFileName();
    }
    UnitPositionInfo unitForNode = debugInfo.getUnitForNode(node.getId());
    if (unitForNode != null) {
      return model.getLongName() + "." + unitForNode.getFileName();
    }
    return null;
  }

  public static String getUnitName(SNode node) {
    SModel model = node.getModel();
    DebugInfo debugInfo = TraceInfoCache.getInstance().get(model.getModelDescriptor());
    if (debugInfo == null) {
      return null;
    }
    UnitPositionInfo unitForNode = debugInfo.getUnitForNode(node.getId());
    if (unitForNode != null) {
      return unitForNode.getUnitName();
    }
    return null;
  }

  @Nullable
  public static <T extends PositionInfo> List<SNode> getAllNodes(@NotNull String className, final String file, final int position, final Mapper<DebugInfoRoot, ? extends Set<T>> positionsGetter) {
    return findInDebugInfo(className, new Mapper2<DebugInfo, SModelDescriptor, List<SNode>>() {
      public List<SNode> value(DebugInfo result, SModelDescriptor descriptor) {
        List<T> infoForPosition = result.getInfoForPosition(file, position, new _FunctionTypes._return_P1_E0<Set<T>, DebugInfoRoot>() {
          public Set<T> invoke(DebugInfoRoot root) {
            return positionsGetter.value(root);
          }
        });
        List<SNode> nodes = new ArrayList<SNode>();
        if (infoForPosition.isEmpty()) {
          return null;
        }
        for (T info : infoForPosition) {
          nodes.add(descriptor.getSModel().getNodeById(info.getNodeId()));
        }
        return nodes;
      }
    });
  }

  @Nullable
  public static List<SNode> getAllTraceableNodes(@NotNull String className, final String file, final int position) {
    return TraceInfoUtil.getAllNodes(className, file, position, new Mapper<DebugInfoRoot, Set<TraceablePositionInfo>>() {
      @Override
      public Set<TraceablePositionInfo> value(DebugInfoRoot key) {
        return key.getPositions();
      }
    });
  }

  @Nullable
  public static List<SNode> getAllScopeNodes(@NotNull String className, final String file, final int position) {
    return TraceInfoUtil.getAllNodes(className, file, position, new Mapper<DebugInfoRoot, Set<ScopePositionInfo>>() {
      @Override
      public Set<ScopePositionInfo> value(DebugInfoRoot key) {
        return key.getScopePositions();
      }
    });
  }

  @Nullable
  public static List<SNode> getAllUnitNodes(@NotNull String className, final String file, final int position) {
    return TraceInfoUtil.getAllNodes(className, file, position, new Mapper<DebugInfoRoot, Set<UnitPositionInfo>>() {
      @Override
      public Set<UnitPositionInfo> value(DebugInfoRoot key) {
        return key.getUnitPositions();
      }
    });
  }
}
