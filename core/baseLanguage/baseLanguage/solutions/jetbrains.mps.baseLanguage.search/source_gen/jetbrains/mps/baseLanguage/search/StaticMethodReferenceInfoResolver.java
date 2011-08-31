package jetbrains.mps.baseLanguage.search;

/*Generated by MPS */

import jetbrains.mps.smodel.search.IReferenceInfoResolver;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Map;

/*package*/ class StaticMethodReferenceInfoResolver implements IReferenceInfoResolver {
  private SNode myClass;
  private List<SNode> myActualArguments;
  private ClassifierAndSuperClassifiersScope mySearchScope;

  public StaticMethodReferenceInfoResolver(ClassifierAndSuperClassifiersScope searchScope, SNode class_, List<SNode> actualArguments) {
    this.myClass = class_;
    this.myActualArguments = actualArguments;
    this.mySearchScope = searchScope;
  }

  public SNode resolve(String referenceInfo, SModelReference targetModelReference) {
    if (referenceInfo == null) {
      return null;
    }
    List<SNode> methods = this.mySearchScope.getMethodsByName(referenceInfo);
    if (methods.isEmpty()) {
      return null;
    }
    if (methods.size() == 1) {
      return ListSequence.<SNode>fromList(methods).first();
    }
    methods = MethodResolveUtil.selectByParmCount(methods, this.myActualArguments);
    if (methods.size() == 1) {
      return ListSequence.<SNode>fromList(methods).first();
    }
    Map<SNode, SNode> typeByTypeVar = ClassifierAndSuperClassifiersCache.getInstance(this.myClass).getTypeByTypeVariableMap();
    return MethodResolveUtil.chooseByParameterType(methods, this.myActualArguments, typeByTypeVar);
  }
}
