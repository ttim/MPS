package jetbrains.mps.typesystem.debug;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.*;
import jetbrains.mps.util.CollectionUtil;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 09.12.2008
 * Time: 19:16:55
 * To change this template use File | Settings | File Templates.
 */
public class SlicerImpl implements ISlicer {
  private List<SliceInfo> mySliceInfos = new ArrayList<SliceInfo>();

  public List<SNode> getNodesToSliceWith()  {
    return new ArrayList<SNode>();
  }

  public List<SliceInfo> getSliceInfos() {
    return new ArrayList<SliceInfo>(mySliceInfos);
  }

  public List<SliceInfo> beforeUserEquationAdded(SNode type1, SNode type2, TypeCheckingContext typeCheckingContext, EquationInfo equationInfo) {
    return beforeEquationAdded(type1, type2, typeCheckingContext, equationInfo, "user equation added");
  }

  public List<SliceInfo> beforeInequationTriggeredEquationAdded(SNode type1, SNode type2, TypeCheckingContext typeCheckingContext, EquationInfo equationInfo) {
    return beforeEquationAdded(type1, type2, typeCheckingContext, equationInfo, "inequation triggered equation added");
  }

  public List<SliceInfo> beforeChildEquationAdded(SNode type1, SNode type2, TypeCheckingContext typeCheckingContext, EquationInfo equationInfo) {
    return beforeEquationAdded(type1, type2, typeCheckingContext, equationInfo, "child equation added");
  }

  private List<SliceInfo> beforeEquationAdded(SNode type1, SNode type2, TypeCheckingContext typeCheckingContext, EquationInfo equationInfo, String reason) {
    List<SliceInfo> result = new ArrayList<SliceInfo>();
  /*  EquationManager equationManager = typeCheckingContext.getEquationManager();
    IWrapper representator1 = equationManager.getRepresentatorWrapper(NodeWrapper.fromNode(type1, equationManager));
    IWrapper representator2 = equationManager.getRepresentatorWrapper(NodeWrapper.fromNode(type2, equationManager));

      SNode type = typeCheckingContext.getMainContext().get(node);
      if (type != null) {
        NodeWrapper typeWrapper = NodeWrapper.fromNode(type, equationManager);
        IWrapper representatorWrapper = equationManager.getRepresentatorWrapper(typeWrapper);
        if (representatorWrapper.equals(representator1)) {
          SliceInfo sliceInfo = new SliceInfo(node, type1, equationInfo.getRuleModel(), equationInfo.getRuleId(), reason, CollectionUtil.list(equationInfo));
          mySliceInfos.add(sliceInfo);
          result.add(sliceInfo);
        }
        if (representatorWrapper.equals(representator2)) {
          SliceInfo sliceInfo = new SliceInfo(node, type2, equationInfo.getRuleModel(), equationInfo.getRuleId(), reason, CollectionUtil.list(equationInfo));
          mySliceInfos.add(sliceInfo);
          result.add(sliceInfo);
        }
      }*/
    return result;
  }

  public List<SliceInfo> beforeInequationsSolvedForType(SNode type, TypeCheckingContext typeCheckingContext, List<EquationInfo> inequations) {
    List<SliceInfo> result = new ArrayList<SliceInfo>();
  /*  EquationManager equationManager = typeCheckingContext.getEquationManager();
    IWrapper representator = equationManager.getRepresentatorWrapper(NodeWrapper.fromNode(type, equationManager));

      SNode nodeType = typeCheckingContext.getMainContext().get(node);
      if (nodeType != null) {
        NodeWrapper typeWrapper = NodeWrapper.fromNode(nodeType, equationManager);
        IWrapper representatorWrapper = equationManager.getRepresentatorWrapper(typeWrapper);
        if (representatorWrapper.equals(representator)) {
          SliceInfo sliceInfo = new SliceInfo(node, representatorWrapper.getNode(), null, null, "inequations solved", inequations);
          mySliceInfos.add(sliceInfo);
          result.add(sliceInfo);
        }
      }*/
    return result;
  }

  public void afterEquationAdded(List<SliceInfo> sliceInfos, TypeCheckingContext typeCheckingContext) {
    for (SliceInfo sliceInfo : sliceInfos) {
      sliceInfo.completeResultType(typeCheckingContext);
    }
  }
}
