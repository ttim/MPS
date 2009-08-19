package jetbrains.mps.baseLanguage.closures.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.SubtypingRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.ISubtypingRule_Runtime;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.constraints.ClassifierTypeUtil;
import jetbrains.mps.smodel.SModelUtil_new;

public class supertypesOf_ClassifierType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {
  public supertypesOf_ClassifierType_SubtypingRule() {
  }

  public List<SNode> getSubOrSuperTypes(SNode ct, TypeCheckingContext typeCheckingContext) {
    List<SNode> supertypes = ListSequence.fromList(new ArrayList<SNode>());
    SNode classifier = SLinkOperations.getTarget(ct, "classifier", false);
    if (SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.Interface")) {
      List<SNode> methods = SLinkOperations.getTargets(classifier, "method", true);
      if (methods != null && ListSequence.fromList(methods).count() == 1) {
        SNode md = ListSequence.fromList(methods).getElement(0);
        List<SNode> paramTypes = ListSequence.fromList(new ArrayList<SNode>());
        for (SNode p : SLinkOperations.getTargets(md, "parameter", true)) {
          ListSequence.fromList(paramTypes).addElement(ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(p, "type", true), ct));
        }
        SNode resType = ClassifierTypeUtil.resolveType(SLinkOperations.getTarget(md, "returnType", true), ct);
        supertypes = ListSequence.fromListAndArray(new ArrayList<SNode>(), new _Quotations.QuotationClass_14().createNode(paramTypes, resType, typeCheckingContext));
      }
    }
    return supertypes;
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ClassifierType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return true;
  }
}
