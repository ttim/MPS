package jetbrains.mps.lang.plugin.scripts;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.smodel.SModelStereotype;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.StaticReference;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModelDescriptor;

/*package*/ class StubRefUtil {
  private static boolean isReferenceToJavaStub(@NotNull SReference reference) {
    return reference.getTargetNodeId() instanceof SNodeId.Foreign && check_4tnolf_a0a0a(check_4tnolf_a0a0a0(reference.getTargetSModelReference()), SModelStereotype.STUB_SUFFIX);
  }

  private static String getTargetStringFromReference(@NotNull SReference reference) {
    String targetPackage = check_4tnolf_a0a0b(check_4tnolf_a0a0a1(check_4tnolf_a0a0a0b(reference)));
    String targetName = reference.getTargetNodeId().toString();
    return targetPackage + "/" + targetName;
  }

  /*package*/ static boolean isReferenceToClass(@Nullable SReference reference, @NotNull String classFqName) {
    if (reference == null || !(isReferenceToJavaStub(reference))) {
      return false;
    }
    String expectedString = NameUtil.namespaceFromLongName(classFqName) + "/~" + NameUtil.shortNameFromLongName(classFqName);
    return getTargetStringFromReference(reference).equals(expectedString);
  }

  /*package*/ static boolean isReferenceToMethod(@Nullable SReference reference, @NotNull String methodSignature) {
    if (reference == null || !(isReferenceToJavaStub(reference))) {
      return false;
    }
    int packageClassDot = methodSignature.lastIndexOf(".", methodSignature.lastIndexOf(".", methodSignature.indexOf("(")) - 1);
    String expectedString = methodSignature.substring(0, packageClassDot) + "/~" + methodSignature.substring(packageClassDot + 1);
    return expectedString.equals(getTargetStringFromReference(reference));
  }

  /*package*/ static boolean isStaticMethodCall(SNode staticMethodCall, @NotNull String methodSignature) {
    String classFqName = NameUtil.namespaceFromLongName(methodSignature.substring(0, methodSignature.indexOf("(")));
    return isReferenceToClass(SNodeOperations.getReference(staticMethodCall, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodCall", "classConcept")), classFqName) && isReferenceToMethod(SNodeOperations.getReference(staticMethodCall, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodCall", "staticMethodDeclaration")), methodSignature);
  }

  private static boolean isReferenceTo(@Nullable SReference ref, @NotNull SModelReference targetModel, @NotNull SNodeId targetId) {
    return ref != null && targetId.equals(ref.getTargetNodeId()) && targetModel.equals(ref.getTargetSModelReference());
  }

  /*package*/ static boolean isStaticMethodCall(SNode staticMethodCall, @NotNull SModelReference targetModel, @NotNull String classId, @NotNull String methodId) {
    return isReferenceTo(SNodeOperations.getReference(staticMethodCall, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodCall", "classConcept")), targetModel, SNodeId.fromString(classId)) && isReferenceTo(SNodeOperations.getReference(staticMethodCall, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.StaticMethodCall", "staticMethodDeclaration")), targetModel, SNodeId.fromString(methodId));
  }

  /*package*/ static boolean isClassifierType(SNode classifierType, @NotNull SModelReference targetModel, @NotNull String classId) {
    return isReferenceTo(SNodeOperations.getReference(classifierType, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", "classifier")), targetModel, SNodeId.fromString(classId));
  }

  /*package*/ static boolean isInstanceMethodCall(SNode methodCallOperation, @NotNull String methodSignature) {
    return isReferenceToMethod(SNodeOperations.getReference(methodCallOperation, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation", "instanceMethodDeclaration")), methodSignature);
  }

  /*package*/ static boolean isInstanceMethodCall(SNode methodCallOperation, @NotNull SModelReference targetModel, @NotNull String methodId) {
    return isReferenceTo(SNodeOperations.getReference(methodCallOperation, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation", "instanceMethodDeclaration")), targetModel, SNodeId.fromString(methodId));
  }

  /*package*/ static boolean isClassCreator(SNode creator, @NotNull String creatorSignature) {
    return isReferenceToMethod(SNodeOperations.getReference(creator, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassCreator", "constructorDeclaration")), creatorSignature);
  }

  /*package*/ static boolean isClassCreator(SNode creator, @NotNull SModelReference creatorModel, @NotNull String creatorId) {
    return isReferenceTo(SNodeOperations.getReference(creator, SLinkOperations.findLinkDeclaration("jetbrains.mps.baseLanguage.structure.ClassCreator", "constructorDeclaration")), creatorModel, SNodeId.fromString(creatorId));
  }

  /*package*/ static void addRequiredImports(SModel model, SNode newNode) {
    for (SReference ref : ListSequence.fromList(SNodeOperations.getDescendants(newNode, null, true, new String[]{})).translate(new ITranslator2<SNode, SReference>() {
      public Iterable<SReference> translate(SNode n) {
        return SNodeOperations.getReferences(n);
      }
    })) {
      SModelReference targetModelRef = ref.getTargetSModelReference();
      model.addModelImport(targetModelRef, false);

      IModule sourceModule = check_4tnolf_a0d0a0m(model.getModelDescriptor());
      IModule targetModule = check_4tnolf_a0e0a0m(SModelRepository.getInstance().getModelDescriptor(targetModelRef));
      if (sourceModule != null && targetModule != null) {
        if (!(sourceModule.getDependenciesManager().getAllVisibleModules().contains(targetModule))) {
          sourceModule.addDependency(targetModule.getModuleReference(), false);
        }
      }
    }
  }

  /*package*/ static void replaceNode(SNode oldNode, SNode newNode) {
    StubRefUtil.addRequiredImports(SNodeOperations.getModel(oldNode), newNode);
    SNodeOperations.replaceWithAnother(oldNode, newNode);
  }

  /*package*/ static void replaceRefs(SNode oldNode, SNode newNode) {
    for (SReference newRef : ListSequence.fromList(newNode.getReferences())) {
      oldNode.removeReference(oldNode.getReference(newRef.getRole()));
      oldNode.addReference(new StaticReference(newRef.getRole(), oldNode, newRef.getTargetSModelReference(), newRef.getTargetNodeId(), newRef.getResolveInfo()));
    }
    StubRefUtil.addRequiredImports(oldNode.getModel(), newNode);
  }

  private static boolean check_4tnolf_a0a0a(String checkedDotOperand, String STUB_SUFFIX) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.endsWith(SModelStereotype.STUB_SUFFIX);
    }
    return false;
  }

  private static String check_4tnolf_a0a0a0(SModelReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getStereotype();
    }
    return null;
  }

  private static String check_4tnolf_a0a0b(SModelFqName checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getLongName();
    }
    return null;
  }

  private static SModelFqName check_4tnolf_a0a0a1(SModelReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getSModelFqName();
    }
    return null;
  }

  private static SModelReference check_4tnolf_a0a0a0b(SReference checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getTargetSModelReference();
    }
    return null;
  }

  private static IModule check_4tnolf_a0d0a0m(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }

  private static IModule check_4tnolf_a0e0a0m(SModelDescriptor checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getModule();
    }
    return null;
  }
}
