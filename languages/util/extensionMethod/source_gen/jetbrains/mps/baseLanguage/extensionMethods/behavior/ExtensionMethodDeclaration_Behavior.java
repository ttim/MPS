package jetbrains.mps.baseLanguage.extensionMethods.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.scope.Scope;
import org.jetbrains.annotations.Nullable;

public class ExtensionMethodDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode call_getThisType_8022092943109893938(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.extensionMethods.structure.TypeExtension")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.extensionMethods.structure.TypeExtension"), "type", true);
    } else {
      return SLinkOperations.getTarget(thisNode, "extendedType", true);
    }
  }

  public static SNode call_getClassifier_7685333756920241018(SNode thisNode) {
    SNode type = ExtensionMethodDeclaration_Behavior.call_getThisType_8022092943109893938(thisNode);
    SNode classifierType;
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      classifierType = SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType");
    } else {
      classifierType = TypeChecker.getInstance().getRuntimeSupport().coerce_(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), false);
    }
    if (classifierType == null) {
      return null;
    }
    return SLinkOperations.getTarget(classifierType, "classifier", false);
  }

  public static Scope virtual_getScopeForInterface_1251851371723365208(SNode thisNode, SNode interfaceNode, SNode[] extendsInterfaces) {
    throw new UnsupportedOperationException();
  }

  public static Scope virtual_getScopeForClass_1251851371723365193(SNode thisNode, SNode classNode, @Nullable SNode extendsClass, SNode[] implementsInterfaces) {
    throw new UnsupportedOperationException();
  }
}
