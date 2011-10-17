package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.project.AuxilaryRuntimeModel;
import java.util.Set;
import jetbrains.mps.util.CollectionUtil;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class Queries {
  public Queries() {
  }

  public static SNode getBinaryOperationType(SNode leftType, SNode rightType) {
    return getBinaryOperationType(leftType, rightType, false);
  }

  public static SNode getBinaryOperationType(SNode leftType, SNode rightType, boolean mayBeString) {
    SModel runtimeTypesModel = AuxilaryRuntimeModel.getDescriptor().getSModel();
    Set<SNode> types = CollectionUtil.set((SNode) leftType, rightType);
    Set<SNode> leastCommonSupertypes = TypeChecker.getInstance().getSubtypingManager().leastCommonSupertypes(types, true);
    if (mayBeString) {
      SModelDescriptor javaLangJavaStubModelDescriptor = SModelRepository.getInstance().getModelDescriptor(SModelReference.fromString("java.lang@java_stub"));
      assert javaLangJavaStubModelDescriptor != null;
      SModel javaLang = javaLangJavaStubModelDescriptor.getSModel();
      SNode stringClass = SModelOperations.getRootByName(javaLang, "String");
      if (SNodeOperations.isInstanceOf(leftType, "jetbrains.mps.baseLanguage.structure.ClassifierType") && SLinkOperations.getTarget((SNodeOperations.cast(leftType, "jetbrains.mps.baseLanguage.structure.ClassifierType")), "classifier", false) == stringClass || SNodeOperations.isInstanceOf(rightType, "jetbrains.mps.baseLanguage.structure.ClassifierType") && SLinkOperations.getTarget((SNodeOperations.cast(rightType, "jetbrains.mps.baseLanguage.structure.ClassifierType")), "classifier", false) == stringClass) {
        SNode classifierType = jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.createNewNode(runtimeTypesModel, "jetbrains.mps.baseLanguage.structure.ClassifierType", null);
        SLinkOperations.setTarget(classifierType, "classifier", SNodeOperations.cast(stringClass, "jetbrains.mps.baseLanguage.structure.Classifier"), false);
        return classifierType;
      }
    }
    if (leastCommonSupertypes.isEmpty()) {
      SNode runtimeErrorType = jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.createNewNode(runtimeTypesModel, "jetbrains.mps.lang.typesystem.structure.RuntimeErrorType", null);
      SPropertyOperations.set(runtimeErrorType, "errorText", "incompatible types");
      return runtimeErrorType;
    }
    SNode type = leastCommonSupertypes.iterator().next();
    {
      IMatchingPattern pattern_j6k1pf_g0b = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.PrimitiveType");
      SNode coercedNode_j6k1pf_g0b = TypeChecker.getInstance().getRuntimeSupport().coerce_(type, pattern_j6k1pf_g0b);
      if (coercedNode_j6k1pf_g0b != null) {
        return coercedNode_j6k1pf_g0b;
      } else {
        return type;
      }
    }
  }
}
