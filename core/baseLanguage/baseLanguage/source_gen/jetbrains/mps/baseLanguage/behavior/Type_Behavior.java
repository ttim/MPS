package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import java.util.List;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.project.IModule;
import jetbrains.mps.reloading.ReflectionUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.pattern.GeneratedMatchingPattern;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Type_Behavior {
  private static Class[] PARAMETERS_1213877337304 = {SNode.class};
  private static Class[] PARAMETERS_1213877337313 = {SNode.class};
  private static Class[] PARAMETERS_1213877337320 = {SNode.class};
  private static Class[] PARAMETERS_1213877337340 = {SNode.class};
  private static Class[] PARAMETERS_1226945293888 = {SNode.class};
  private static Class[] PARAMETERS_7602110602933317830 = {SNode.class ,SModel.class};
  private static Class[] PARAMETERS_1213877337345 = {SNode.class};
  private static Class[] PARAMETERS_1213877337352 = {SNode.class};
  private static Class[] PARAMETERS_1213877337357 = {SNode.class};
  private static Class[] PARAMETERS_1220438914705 = {SNode.class ,SNode.class};
  private static Class[] PARAMETERS_3359611512358152580 = {SNode.class};
  private static Class[] PARAMETERS_3508583411997314206 = {SNode.class};
  private static Class[] PARAMETERS_5744862332972792015 = {SNode.class};
  private static Class[] PARAMETERS_8847328628797633411 = {SNode.class};

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
    return ReflectionUtil.forName(module, SLinkOperations.getTarget(TypeChecker.getInstance().getRuntimeSupport().coerce_(thisNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true), "classifier", false));
  }

  public static SNode virtual_getAbstractCreator_1213877337340(SNode thisNode) {
    return null;
  }

  public static List<SNode> virtual_getAbstractCreators_1226945293888(SNode thisNode) {
    List<SNode> creators = new ArrayList<SNode>();
    SNode ac = Type_Behavior.call_getAbstractCreator_1213877337340(thisNode);
    if ((ac != null)) {
      ListSequence.fromList(creators).addElement(ac);
    }
    return creators;
  }

  public static List<SNode> virtual_getAbstractCreators_7602110602933317830(SNode thisNode, SModel targetModel) {
    return Type_Behavior.call_getAbstractCreators_1226945293888(thisNode);
  }

  public static SNode virtual_getJavaType_1213877337345(SNode thisNode) {
    return TypeChecker.getInstance().getRuntimeSupport().coerce_(thisNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
  }

  public static boolean virtual_selectOnVariableCreation_1213877337352(SNode thisNode) {
    return Type_Behavior.call_hasMissingParameters_3508583411997314206(thisNode);
  }

  public static SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    {
      IMatchingPattern pattern_smb55n_a0j = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType");
      SNode coercedNode_smb55n_a0j = TypeChecker.getInstance().getRuntimeSupport().coerce_(thisNode, pattern_smb55n_a0j);
      if (coercedNode_smb55n_a0j != null) {
        return new Type_Behavior.QuotationClass_smb55n_a0a0c0a0k().createNode(SLinkOperations.getTarget(coercedNode_smb55n_a0j, "classifier", false));
      } else {
        throw new UnsupportedOperationException();
      }
    }
  }

  public static boolean virtual_isSupersetOf_1220438914705(SNode thisNode, SNode t) {
    {
      GeneratedMatchingPattern pattern_smb55n_a0k = new Type_Behavior.Pattern_smb55n_a0a0a0a11(thisNode);
      SNode coercedNode_smb55n_a0k = TypeChecker.getInstance().getRuntimeSupport().coerce_(t, pattern_smb55n_a0k);
      if (coercedNode_smb55n_a0k != null) {
        return true;
      } else {
      }
    }
    return false;
  }

  public static SNode virtual_createDefaultTypeExpression_3359611512358152580(SNode thisNode) {
    return null;
  }

  public static boolean virtual_hasMissingParameters_3508583411997314206(SNode thisNode) {
    return false;
  }

  public static SNode virtual_getLooseType_5744862332972792015(SNode thisNode) {
    SNode looseType = SNodeOperations.copyNode(thisNode);
    for (SNode varRef : SNodeOperations.getDescendants(looseType, "jetbrains.mps.baseLanguage.structure.TypeVariableReference", false, new String[]{})) {
      SNodeOperations.replaceWithAnother(varRef, Type_Behavior.call_getLooseType_5744862332972792015(varRef));
    }
    return looseType;
  }

  public static String virtual_jniSignature_8847328628797633411(SNode thisNode) {
    return null;
  }

  public static List<String> call_getVariableSuffixes_1213877337304(SNode thisNode) {
    return (List<String>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getVariableSuffixes_1213877337304", PARAMETERS_1213877337304);
  }

  public static String call_getErasureSignature_1213877337313(SNode thisNode) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getErasureSignature_1213877337313", PARAMETERS_1213877337313);
  }

  public static SNode call_getUnboxedType_1213877337320(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getUnboxedType_1213877337320", PARAMETERS_1213877337320);
  }

  public static SNode call_getAbstractCreator_1213877337340(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getAbstractCreator_1213877337340", PARAMETERS_1213877337340);
  }

  public static List<SNode> call_getAbstractCreators_1226945293888(SNode thisNode) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getAbstractCreators_1226945293888", PARAMETERS_1226945293888);
  }

  public static List<SNode> call_getAbstractCreators_7602110602933317830(SNode thisNode, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933317830, targetModel);
  }

  public static SNode call_getJavaType_1213877337345(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getJavaType_1213877337345", PARAMETERS_1213877337345);
  }

  public static boolean call_selectOnVariableCreation_1213877337352(SNode thisNode) {
    return (Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_selectOnVariableCreation_1213877337352", PARAMETERS_1213877337352);
  }

  public static SNode call_getClassExpression_1213877337357(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getClassExpression_1213877337357", PARAMETERS_1213877337357);
  }

  public static boolean call_isSupersetOf_1220438914705(SNode thisNode, SNode t) {
    return (Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_isSupersetOf_1220438914705", PARAMETERS_1220438914705, t);
  }

  public static SNode call_createDefaultTypeExpression_3359611512358152580(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_createDefaultTypeExpression_3359611512358152580", PARAMETERS_3359611512358152580);
  }

  public static boolean call_hasMissingParameters_3508583411997314206(SNode thisNode) {
    return (Boolean) BehaviorManager.getInstance().invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_hasMissingParameters_3508583411997314206", PARAMETERS_3508583411997314206);
  }

  public static SNode call_getLooseType_5744862332972792015(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_getLooseType_5744862332972792015", PARAMETERS_5744862332972792015);
  }

  public static String call_jniSignature_8847328628797633411(SNode thisNode) {
    return (String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), "virtual_jniSignature_8847328628797633411", PARAMETERS_8847328628797633411);
  }

  public static List<String> callSuper_getVariableSuffixes_1213877337304(SNode thisNode, String callerConceptFqName) {
    return (List<String>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getVariableSuffixes_1213877337304", PARAMETERS_1213877337304);
  }

  public static String callSuper_getErasureSignature_1213877337313(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getErasureSignature_1213877337313", PARAMETERS_1213877337313);
  }

  public static SNode callSuper_getUnboxedType_1213877337320(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getUnboxedType_1213877337320", PARAMETERS_1213877337320);
  }

  public static SNode callSuper_getAbstractCreator_1213877337340(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getAbstractCreator_1213877337340", PARAMETERS_1213877337340);
  }

  public static List<SNode> callSuper_getAbstractCreators_1226945293888(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getAbstractCreators_1226945293888", PARAMETERS_1226945293888);
  }

  public static List<SNode> callSuper_getAbstractCreators_7602110602933317830(SNode thisNode, String callerConceptFqName, SModel targetModel) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getAbstractCreators_7602110602933317830", PARAMETERS_7602110602933317830, targetModel);
  }

  public static SNode callSuper_getJavaType_1213877337345(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getJavaType_1213877337345", PARAMETERS_1213877337345);
  }

  public static boolean callSuper_selectOnVariableCreation_1213877337352(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_selectOnVariableCreation_1213877337352", PARAMETERS_1213877337352);
  }

  public static SNode callSuper_getClassExpression_1213877337357(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getClassExpression_1213877337357", PARAMETERS_1213877337357);
  }

  public static boolean callSuper_isSupersetOf_1220438914705(SNode thisNode, String callerConceptFqName, SNode t) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_isSupersetOf_1220438914705", PARAMETERS_1220438914705, t);
  }

  public static SNode callSuper_createDefaultTypeExpression_3359611512358152580(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_createDefaultTypeExpression_3359611512358152580", PARAMETERS_3359611512358152580);
  }

  public static boolean callSuper_hasMissingParameters_3508583411997314206(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_hasMissingParameters_3508583411997314206", PARAMETERS_3508583411997314206);
  }

  public static SNode callSuper_getLooseType_5744862332972792015(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_getLooseType_5744862332972792015", PARAMETERS_5744862332972792015);
  }

  public static String callSuper_jniSignature_8847328628797633411(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Type"), callerConceptFqName, "virtual_jniSignature_8847328628797633411", PARAMETERS_8847328628797633411);
  }

  public static class QuotationClass_smb55n_a0a0c0a0k {
    public QuotationClass_smb55n_a0a0c0a0k() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierClassExpression", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("classifier", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class Pattern_smb55n_a0a0a0a11 extends GeneratedMatchingPattern implements IMatchingPattern {
    /*package*/ Object AntiquotationField_smb55n_a0a0a0a01;

    public Pattern_smb55n_a0a0a0a11(Object parameter_smb55n_a0a0a0a01) {
      this.AntiquotationField_smb55n_a0a0a0a01 = parameter_smb55n_a0a0a0a01;
    }

    public boolean match(SNode nodeToMatch) {
      {
        SNode nodeToMatch_smb55n_a0a0a01;
        nodeToMatch_smb55n_a0a0a01 = nodeToMatch;
        if (!("jetbrains.mps.lang.core.structure.BaseConcept".equals(nodeToMatch_smb55n_a0a0a01.getConceptFqName()))) {
          return false;
        }
      }
      return true;
    }

    public boolean hasAntiquotations() {
      return true;
    }

    public void fillFieldValuesFrom(GeneratedMatchingPattern pattern) {
    }

    public Object getFieldValue(String fieldName) {
      return null;
    }
  }
}
