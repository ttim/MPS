package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class GenericTypesUtil {
  public GenericTypesUtil() {
  }

  public static SNode getTypeWithResolvedTypeVars(SNode type, Map<SNode, SNode> typeByTypeVar) {
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")) {
      return GenericTypesUtil.getTypeByTypeVariable(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.TypeVariableReference"), typeByTypeVar);
    } else
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      return GenericTypesUtil.createClassifierTypeWithResolvedTypeVars(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), typeByTypeVar);
    }
    return type;
  }

  private static SNode getTypeByTypeVariable(SNode typeVariableRef, Map<SNode, SNode> typeByTypeVar) {
    SNode result = typeVariableRef;
    SNode typeVar = SLinkOperations.getTarget(typeVariableRef, "typeVariableDeclaration", false);
    while ((typeVar != null)) {
      SNode typeVarValue = typeByTypeVar.get(typeVar);
      if ((typeVarValue == null)) {
        break;
      }
      result = typeVarValue;
      if (SNodeOperations.isInstanceOf(result, "jetbrains.mps.baseLanguage.structure.TypeVariableReference")) {
        SNode newTypeVar = SLinkOperations.getTarget(SNodeOperations.cast(result, "jetbrains.mps.baseLanguage.structure.TypeVariableReference"), "typeVariableDeclaration", false);
        if (typeVar == newTypeVar) {
          break;
        }
        typeVar = newTypeVar;
      } else {
        break;
      }
    }
    return result;
  }

  private static SNode createClassifierTypeWithResolvedTypeVars(SNode type, Map<SNode, SNode> typeByTypeVar) {
    SNode typeCopy = SNodeOperations.copyNode(type);
    for (SNode typeVariableRef : ListSequence.<SNode>fromList(SNodeOperations.getDescendants(typeCopy, "jetbrains.mps.baseLanguage.structure.TypeVariableReference", false, new String[]{}))) {
      SNode resolvedType = GenericTypesUtil.getTypeByTypeVariable(typeVariableRef, typeByTypeVar);
      if (resolvedType != typeVariableRef) {
        SNodeOperations.replaceWithAnother(typeVariableRef, SNodeOperations.copyNode(resolvedType));
      }
    }
    return typeCopy;
  }
}
