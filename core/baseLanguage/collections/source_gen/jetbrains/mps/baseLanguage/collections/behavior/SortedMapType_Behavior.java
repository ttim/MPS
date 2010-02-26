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
    ListSequence.fromList(result).addElement(new SortedMapType_Behavior.QuotationClass_zek8do_a0a0b0b().createNode(SLinkOperations.getTarget(thisNode, "keyType", true), SLinkOperations.getTarget(thisNode, "valueType", true)));
    ListSequence.fromList(result).addSequence(Sequence.fromIterable(CustomContainersUtil.containerCreators(targetModel, thisNode)));
    return result;
  }

  public static SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    return new SortedMapType_Behavior.QuotationClass_zek8do_a0a0c().createNode();
  }

  public static List<SNode> call_getAbstractCreators_7602110602933345941(SNode thisNode, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.SortedMapType"), "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933345941, targetModel);
  }

  public static List<SNode> callSuper_getAbstractCreators_7602110602933345941(SNode thisNode, String callerConceptFqName, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.SortedMapType"), callerConceptFqName, "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933345941, targetModel);
  }

  public static class QuotationClass_zek8do_a0a0c {
    public QuotationClass_zek8do_a0a0c() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_zek8do_a0a0b = null;
      {
        quotedNode_zek8do_a0a0b = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_zek8do_a0a0b = quotedNode_zek8do_a0a0b;
        quotedNode1_zek8do_a0a0b.addReference(SReference.create("classifier", quotedNode1_zek8do_a0a0b, SModelReference.fromString("f:java_stub#java.util(java.util@java_stub)"), SNodeId.fromString("~SortedMap")));
        result = quotedNode1_zek8do_a0a0b;
      }
      return result;
    }
  }

  public static class QuotationClass_zek8do_a0a0b0b {
    public QuotationClass_zek8do_a0a0b0b() {
    }

    public SNode createNode(Object parameter_zek8do_a0a0a0a1a0, Object parameter_zek8do_a0a0a0a1a0_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_zek8do_a0a0b0a = null;
      SNode quotedNode_zek8do_a0a0a1a0 = null;
      SNode quotedNode_zek8do_a0a0a1a0_0 = null;
      {
        quotedNode_zek8do_a0a0b0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.TreeMapCreator", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_zek8do_a0a0b0a = quotedNode_zek8do_a0a0b0a;
        {
          quotedNode_zek8do_a0a0a1a0 = (SNode) parameter_zek8do_a0a0a0a1a0;
          SNode quotedNode1_zek8do_a0a0a1a0;
          if (_parameterValues_129834374.contains(quotedNode_zek8do_a0a0a1a0)) {
            quotedNode1_zek8do_a0a0a1a0 = CopyUtil.copy(quotedNode_zek8do_a0a0a1a0);
          } else {
            _parameterValues_129834374.add(quotedNode_zek8do_a0a0a1a0);
            quotedNode1_zek8do_a0a0a1a0 = quotedNode_zek8do_a0a0a1a0;
          }
          if (quotedNode1_zek8do_a0a0a1a0 != null) {
            quotedNode_zek8do_a0a0b0a.addChild("keyType", HUtil.copyIfNecessary(quotedNode1_zek8do_a0a0a1a0));
          }
        }
        {
          quotedNode_zek8do_a0a0a1a0_0 = (SNode) parameter_zek8do_a0a0a0a1a0_0;
          SNode quotedNode1_zek8do_a0a0a1a0_0;
          if (_parameterValues_129834374.contains(quotedNode_zek8do_a0a0a1a0_0)) {
            quotedNode1_zek8do_a0a0a1a0_0 = CopyUtil.copy(quotedNode_zek8do_a0a0a1a0_0);
          } else {
            _parameterValues_129834374.add(quotedNode_zek8do_a0a0a1a0_0);
            quotedNode1_zek8do_a0a0a1a0_0 = quotedNode_zek8do_a0a0a1a0_0;
          }
          if (quotedNode1_zek8do_a0a0a1a0_0 != null) {
            quotedNode_zek8do_a0a0b0a.addChild("valueType", HUtil.copyIfNecessary(quotedNode1_zek8do_a0a0a1a0_0));
          }
        }
        result = quotedNode1_zek8do_a0a0b0a;
      }
      return result;
    }
  }
}
