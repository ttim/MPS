package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.project.IModule;
import jetbrains.mps.reloading.ReflectionUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class Type_Behavior {
  public static Class[] PARAMETERS_1213877337304 = {SNode.class};
  public static Class[] PARAMETERS_1213877337313 = {SNode.class};
  public static Class[] PARAMETERS_1213877337320 = {SNode.class};
  public static Class[] PARAMETERS_1213877337340 = {SNode.class};
  public static Class[] PARAMETERS_1213877337345 = {SNode.class};
  public static Class[] PARAMETERS_1213877337352 = {SNode.class};
  public static Class[] PARAMETERS_1213877337357 = {SNode.class};
  public static Class[] PARAMETERS_1220438914705 = {SNode.class ,SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<String> virtual_getVariableSuffixes_1213877337304(SNode thisNode) {
    return NameUtil.splitByCamels(BaseConcept_Behavior.call_getPresentation_1213877396640(thisNode));
  }

  public static String virtual_getErasureSignature_1213877337313(SNode thisNode) {
    return BaseConcept_Behavior.call_getPresentation_1213877396640(thisNode);
  }

  public static SNode virtual_getUnboxedType_1213877337320(SNode thisNode) {
    return SNodeOperations.copyNode(thisNode);
  }

  public static Class call_getClass_1213877337327(SNode thisNode, IModule module) {
    return ReflectionUtil.forName(module, SLinkOperations.getTarget(TypeChecker.getInstance().getRuntimeSupport().coerce(thisNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true), "classifier", false));
  }

  public static SNode virtual_getAbstractCreator_1213877337340(SNode thisNode) {
    return null;
  }

  public static SNode virtual_getJavaType_1213877337345(SNode thisNode) {
    return TypeChecker.getInstance().getRuntimeSupport().coerce(thisNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
  }

  public static boolean virtual_selectOnVariableCreation_1213877337352(SNode thisNode) {
    return false;
  }

  public static boolean virtual_isSupersetOf_1220438914705(SNode thisNode, SNode t) {
    {
      _Patterns.Pattern_2 pattern_1 = new _Patterns.Pattern_2(thisNode);
      SNode coercedNode_1 = TypeChecker.getInstance().getRuntimeSupport().coerce(t, pattern_1);
      if (coercedNode_1 != null) {
        return true;
      } else
      {
      }
    }
    return false;
  }

  public static List<String> call_getVariableSuffixes_1213877337304(SNode thisNode) {
    return (List<String>)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getVariableSuffixes_1213877337304", PARAMETERS_1213877337304);
  }

  public static String call_getErasureSignature_1213877337313(SNode thisNode) {
    return (String)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getErasureSignature_1213877337313", PARAMETERS_1213877337313);
  }

  public static SNode call_getUnboxedType_1213877337320(SNode thisNode) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getUnboxedType_1213877337320", PARAMETERS_1213877337320);
  }

  public static SNode call_getAbstractCreator_1213877337340(SNode thisNode) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getAbstractCreator_1213877337340", PARAMETERS_1213877337340);
  }

  public static SNode call_getJavaType_1213877337345(SNode thisNode) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getJavaType_1213877337345", PARAMETERS_1213877337345);
  }

  public static boolean call_selectOnVariableCreation_1213877337352(SNode thisNode) {
    return (Boolean)BehaviorManager.getInstance().invoke(Boolean.class, thisNode, "virtual_selectOnVariableCreation_1213877337352", PARAMETERS_1213877337352);
  }

  public static SNode call_getClassExpression_1213877337357(SNode thisNode) {
    return (SNode)BehaviorManager.getInstance().invoke(Object.class, thisNode, "virtual_getClassExpression_1213877337357", PARAMETERS_1213877337357);
  }

  public static boolean call_isSupersetOf_1220438914705(SNode thisNode, SNode t) {
    return (Boolean)BehaviorManager.getInstance().invoke(Boolean.class, thisNode, "virtual_isSupersetOf_1220438914705", PARAMETERS_1220438914705, t);
  }

  public static List<String> callSuper_getVariableSuffixes_1213877337304(SNode thisNode, String callerConceptFqName) {
    return (List<String>)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getVariableSuffixes_1213877337304", PARAMETERS_1213877337304);
  }

  public static String callSuper_getErasureSignature_1213877337313(SNode thisNode, String callerConceptFqName) {
    return (String)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getErasureSignature_1213877337313", PARAMETERS_1213877337313);
  }

  public static SNode callSuper_getUnboxedType_1213877337320(SNode thisNode, String callerConceptFqName) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getUnboxedType_1213877337320", PARAMETERS_1213877337320);
  }

  public static SNode callSuper_getAbstractCreator_1213877337340(SNode thisNode, String callerConceptFqName) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getAbstractCreator_1213877337340", PARAMETERS_1213877337340);
  }

  public static SNode callSuper_getJavaType_1213877337345(SNode thisNode, String callerConceptFqName) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getJavaType_1213877337345", PARAMETERS_1213877337345);
  }

  public static boolean callSuper_selectOnVariableCreation_1213877337352(SNode thisNode, String callerConceptFqName) {
    return (Boolean)BehaviorManager.getInstance().invokeSuper(Boolean.class, thisNode, callerConceptFqName, "virtual_selectOnVariableCreation_1213877337352", PARAMETERS_1213877337352);
  }

  public static SNode callSuper_getClassExpression_1213877337357(SNode thisNode, String callerConceptFqName) {
    return (SNode)BehaviorManager.getInstance().invokeSuper(Object.class, thisNode, callerConceptFqName, "virtual_getClassExpression_1213877337357", PARAMETERS_1213877337357);
  }

  public static boolean callSuper_isSupersetOf_1220438914705(SNode thisNode, String callerConceptFqName, SNode t) {
    return (Boolean)BehaviorManager.getInstance().invokeSuper(Boolean.class, thisNode, callerConceptFqName, "virtual_isSupersetOf_1220438914705", PARAMETERS_1220438914705, t);
  }

}
