package jetbrains.mps.lang.smodel.generator.baseLanguage.util;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.baseLanguage.util.SModelLanguageUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.structure.behavior.PrimitiveDataTypeDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.baseLanguage.util.DataTypeUtil;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.lang.structure.behavior.EnumerationDataTypeDeclaration_Behavior;
import jetbrains.mps.util.NameUtil;

public class QueriesUtil {

  public static List<SNode> getNodeOperation_ConceptList_concepts(SNode operation) {
    SNode parm_ConceptList = SNodeOperations.cast(SModelLanguageUtil.findNodeOperationParameter(operation, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList")), "jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList");
    List<SNode> result = ListOperations.<SNode>createList();
    for(SNode cRef : ListSequence.fromList(SLinkOperations.getTargets(parm_ConceptList, "concept", true))) {
      if (SLinkOperations.getTarget(cRef, "concept", false) != null) {
        ListSequence.fromList(result).addElement(SLinkOperations.getTarget(cRef, "concept", false));
      }
    }
    return result;
  }

  public static boolean operationHasParm_Inclusion(SNode inputNode) {
    return SModelLanguageUtil.findNodeOperationParameter(inputNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_Inclusion")) != null;
  }

  public static boolean operationHasParm_Root(SNode inputNode) {
    return SModelLanguageUtil.findNodeOperationParameter(inputNode, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_Root")) != null;
  }

  public static SNode get_SConceptPropertyAccess_GetMethod(SNode operation, IScope scope) {
    String methodName = "getString";
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(operation, "conceptProperty", false), "jetbrains.mps.lang.structure.structure.IntegerConceptPropertyDeclaration")) {
      methodName = "getInteger";
    } else if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(operation, "conceptProperty", false), "jetbrains.mps.lang.structure.structure.BooleanConceptPropertyDeclaration")) {
      methodName = "getBoolean";
    }
    SNode operationClass = SNodeOperations.cast(SModelUtil.findNodeByFQName("jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations", SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept"), scope), "jetbrains.mps.baseLanguage.structure.ClassConcept");
    for(SNode method : ListSequence.fromList(SLinkOperations.getTargets(operationClass, "staticMethod", true))) {
      if (methodName.equals(SPropertyOperations.getString(method, "name"))) {
        return method;
      }
    }
    return null;
  }

  public static SNode get_SPropertyAccess_simple_getterMethod(SNode operation, IScope scope) {
    SNode datatype = SLinkOperations.getTarget(SLinkOperations.getTarget(operation, "property", false), "dataType", false);
    String methodName = "getString";
    if (SNodeOperations.isInstanceOf(datatype, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration")) {
      SNode primitiveDatatype = SNodeOperations.cast(datatype, "jetbrains.mps.lang.structure.structure.PrimitiveDataTypeDeclaration");
      if (PrimitiveDataTypeDeclaration_Behavior.call_isInteger_1220268780075(primitiveDatatype)) {
        methodName = "getInteger";
      } else if (PrimitiveDataTypeDeclaration_Behavior.call_isBoolean_1220268791641(primitiveDatatype)) {
        methodName = "getBoolean";
      }
    }
    SNode operationClass = SNodeOperations.cast(SModelUtil.findNodeByFQName("jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations", SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept"), scope), "jetbrains.mps.baseLanguage.structure.ClassConcept");
    for(SNode method : ListSequence.fromList(SLinkOperations.getTargets(operationClass, "staticMethod", true))) {
      if (methodName.equals(SPropertyOperations.getString(method, "name"))) {
        return method;
      }
    }
    return null;
  }

  public static SNode get_SPropertyAccess_enum_getterMethod(SNode operation, IScope scope) {
    SNode datatype = SLinkOperations.getTarget(SLinkOperations.getTarget(operation, "property", false), "dataType", false);
    SNode primitiveDatatype = SLinkOperations.getTarget((SNodeOperations.cast(datatype, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration")), "memberDataType", false);
    String methodName = "getString_def";
    if (PrimitiveDataTypeDeclaration_Behavior.call_isInteger_1220268780075(primitiveDatatype)) {
      methodName = "getInteger_def";
    } else if (PrimitiveDataTypeDeclaration_Behavior.call_isBoolean_1220268791641(primitiveDatatype)) {
      methodName = "getBoolean_def";
    }
    SNode operationClass = SNodeOperations.cast(SModelUtil.findNodeByFQName("jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations", SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept"), scope), "jetbrains.mps.baseLanguage.structure.ClassConcept");
    for(SNode method : ListSequence.fromList(SLinkOperations.getTargets(operationClass, "staticMethod", true))) {
      if (methodName.equals(SPropertyOperations.getString(method, "name"))) {
        return method;
      }
    }
    return null;
  }

  public static String get_SPropertyAccess_enum_defaultValue(SNode operation) {
    return SPropertyOperations.getString(DataTypeUtil.getDefaultMember(SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(operation, "property", false), "dataType", false), "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration")), "internalValue");
  }

  public static boolean nodeOp_noParm_conceptList(SNode op) {
    SNode parm = SModelLanguageUtil.findNodeOperationParameter(op, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList"));
    if (parm != null) {
      return true;
    }
    parm = SModelLanguageUtil.findNodeOperationParameter(op, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList"));
    return parm == null;
  }

  public static boolean nodeOp_hasParm_conceptList(SNode op) {
    SNode parm = SModelLanguageUtil.findNodeOperationParameter(op, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_Concept"));
    if (parm != null) {
      return false;
    }
    parm = SModelLanguageUtil.findNodeOperationParameter(op, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList"));
    return parm != null;
  }

  public static boolean isProperty_hasValueEnum_notNullDefaultValue(SNode op, ITemplateGenerator generator) {
    SNode dataTypeDeclaration = jetbrains.mps.lang.smodel.behavior.SModelLanguageUtil.getDatatypeFromLeft_SPropertyAccess(op);
    SNode defMember = EnumerationDataTypeDeclaration_Behavior.call_getDefaultMember_1213877397785(SNodeOperations.cast(dataTypeDeclaration, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"));
    return SPropertyOperations.getString(defMember, "internalValue") != null;
  }

  public static boolean isProperty_hasValueEnum_nullDefaultValue(SNode op, ITemplateGenerator generator) {
    SNode datatype = jetbrains.mps.lang.smodel.behavior.SModelLanguageUtil.getDatatypeFromLeft_SPropertyAccess(op);
    SNode defMemberNode = EnumerationDataTypeDeclaration_Behavior.call_getDefaultMember_1213877397785(SNodeOperations.cast(datatype, "jetbrains.mps.lang.structure.structure.EnumerationDataTypeDeclaration"));
    return SPropertyOperations.getString(defMemberNode, "internalValue") == null;
  }

  public static String getConceptFqName(SNode concept) {
    return NameUtil.nodeFQName(concept);
  }

}
