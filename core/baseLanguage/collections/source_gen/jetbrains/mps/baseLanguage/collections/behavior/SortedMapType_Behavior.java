package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.CopyUtil;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class SortedMapType_Behavior {
  private static Class[] PARAMETERS_7602110602933345941 = {SNode.class ,SModel.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getAbstractCreators_7602110602933317830(SNode thisNode, SModel targetModel) {
    List<SNode> result = new ArrayList<SNode>();
    ListSequence.fromList(result).addElement(new SortedMapType_Behavior.QuotationClass_7768_l523emne7wlv().createNode(SLinkOperations.getTarget(thisNode, "keyType", true), SLinkOperations.getTarget(thisNode, "valueType", true)));
    ListSequence.fromList(result).addSequence(Sequence.fromIterable(CustomContainersUtil.containerCreators(targetModel, thisNode)));
    return result;
  }

  public static SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    return new SortedMapType_Behavior.QuotationClass_7768_l523emne7ua2().createNode();
  }

  public static List<SNode> call_getAbstractCreators_7602110602933345941(SNode thisNode, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.SortedMapType"), "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933345941, targetModel);
  }

  public static List<SNode> callSuper_getAbstractCreators_7602110602933345941(SNode thisNode, String callerConceptFqName, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.SortedMapType"), callerConceptFqName, "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933345941, targetModel);
  }

  public static class QuotationClass_7768_l523emne7ua2 {
    public QuotationClass_7768_l523emne7ua2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7768_ne2j6ic5udgr = null;
      {
        quotedNode_7768_ne2j6ic5udgr = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7768_ne2j6ic5udgr = quotedNode_7768_ne2j6ic5udgr;
        quotedNode1_7768_ne2j6ic5udgr.addReference(SReference.create("classifier", quotedNode1_7768_ne2j6ic5udgr, SModelReference.fromString("f:java_stub#java.util(java.util@java_stub)"), SNodeId.fromString("~SortedMap")));
        result = quotedNode1_7768_ne2j6ic5udgr;
      }
      return result;
    }
  }

  public static class QuotationClass_7768_l523emne7wlv {
    public QuotationClass_7768_l523emne7wlv() {
    }

    public SNode createNode(Object parameter_7768_ftrbv2j7, Object parameter_7768_ftrbv2je) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_7768_ftrbv2j3 = null;
      SNode quotedNode_7768_ftrbv2j4 = null;
      SNode quotedNode_7768_ftrbv2jb = null;
      {
        quotedNode_7768_ftrbv2j3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.TreeMapCreator", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_7768_ftrbv2j3 = quotedNode_7768_ftrbv2j3;
        {
          quotedNode_7768_ftrbv2j4 = (SNode) parameter_7768_ftrbv2j7;
          SNode quotedNode1_7768_ftrbv2j4;
          if (_parameterValues_129834374.contains(quotedNode_7768_ftrbv2j4)) {
            quotedNode1_7768_ftrbv2j4 = CopyUtil.copy(quotedNode_7768_ftrbv2j4);
          } else {
            _parameterValues_129834374.add(quotedNode_7768_ftrbv2j4);
            quotedNode1_7768_ftrbv2j4 = quotedNode_7768_ftrbv2j4;
          }
          if (quotedNode1_7768_ftrbv2j4 != null) {
            quotedNode_7768_ftrbv2j3.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_7768_ftrbv2j4));
          }
        }
        {
          quotedNode_7768_ftrbv2jb = (SNode) parameter_7768_ftrbv2je;
          SNode quotedNode1_7768_ftrbv2jb;
          if (_parameterValues_129834374.contains(quotedNode_7768_ftrbv2jb)) {
            quotedNode1_7768_ftrbv2jb = CopyUtil.copy(quotedNode_7768_ftrbv2jb);
          } else {
            _parameterValues_129834374.add(quotedNode_7768_ftrbv2jb);
            quotedNode1_7768_ftrbv2jb = quotedNode_7768_ftrbv2jb;
          }
          if (quotedNode1_7768_ftrbv2jb != null) {
            quotedNode_7768_ftrbv2j3.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_7768_ftrbv2jb));
          }
        }
        result = quotedNode1_7768_ftrbv2j3;
      }
      return result;
    }
  }
}
