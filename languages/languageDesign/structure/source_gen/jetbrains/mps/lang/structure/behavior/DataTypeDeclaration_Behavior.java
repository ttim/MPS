package jetbrains.mps.lang.structure.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DataTypeDeclaration_Behavior {
  private static Class[] PARAMETERS_1213877229718 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_toBaseLanguageType_1213877229718(SNode thisNode) {
    return new DataTypeDeclaration_Behavior.QuotationClass_47r3zh_a0a0b().createNode();
  }

  public static boolean call_isSimple_1220268671473(SNode thisNode) {
    return SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration") || SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.ConstrainedDataTypeDeclaration");
  }

  public static boolean call_isEnum_1220268692373(SNode thisNode) {
    return SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration");
  }

  public static boolean call_isSimpleString_1220268704138(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration")) {
      return PrimitiveDataTypeDeclaration_Behavior.call_isString_1220268752134(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"));
    } else if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.ConstrainedDataTypeDeclaration")) {
      return true;
    }
    return false;
  }

  public static boolean call_isSimpleInteger_1220268868375(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration")) {
      return PrimitiveDataTypeDeclaration_Behavior.call_isInteger_1220268780075(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"));
    }
    return false;
  }

  public static boolean call_isSimpleBoolean_1220268891062(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration")) {
      return PrimitiveDataTypeDeclaration_Behavior.call_isBoolean_1220268791641(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration"));
    }
    return false;
  }

  public static boolean call_isEnumOfString_1220268917296(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration")) {
      return PrimitiveDataTypeDeclaration_Behavior.call_isString_1220268752134(SLinkOperations.getTarget(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"), "memberDataType", false));
    }
    return false;
  }

  public static boolean call_isEnumOfInteger_1220268950942(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration")) {
      return PrimitiveDataTypeDeclaration_Behavior.call_isInteger_1220268780075(SLinkOperations.getTarget(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"), "memberDataType", false));
    }
    return false;
  }

  public static boolean call_isEnumOfBoolean_1220268971570(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration")) {
      return PrimitiveDataTypeDeclaration_Behavior.call_isBoolean_1220268791641(SLinkOperations.getTarget(SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"), "memberDataType", false));
    }
    return false;
  }

  public static boolean call_isSimpleStringOrEnumOfString_1220269005341(SNode thisNode) {
    return DataTypeDeclaration_Behavior.call_isEnumOfString_1220268917296(thisNode) || DataTypeDeclaration_Behavior.call_isSimpleString_1220268704138(thisNode);
  }

  public static boolean call_isSimpleIntegerOrEnumOfInteger_1220269023223(SNode thisNode) {
    return DataTypeDeclaration_Behavior.call_isEnumOfInteger_1220268950942(thisNode) || DataTypeDeclaration_Behavior.call_isSimpleInteger_1220268868375(thisNode);
  }

  public static boolean call_isSimpleBooleanOrEnumOfBoolean_1220269039824(SNode thisNode) {
    return DataTypeDeclaration_Behavior.call_isEnumOfBoolean_1220268971570(thisNode) || DataTypeDeclaration_Behavior.call_isSimpleBoolean_1220268891062(thisNode);
  }

  public static SNode call_toBaseLanguageType_1213877229718(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.DataTypeDeclaration"), "virtual_toBaseLanguageType_1213877229718", PARAMETERS_1213877229718);
  }

  public static SNode callSuper_toBaseLanguageType_1213877229718(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.DataTypeDeclaration"), callerConceptFqName, "virtual_toBaseLanguageType_1213877229718", PARAMETERS_1213877229718);
  }

  public static class QuotationClass_47r3zh_a0a0b {
    public QuotationClass_47r3zh_a0a0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
