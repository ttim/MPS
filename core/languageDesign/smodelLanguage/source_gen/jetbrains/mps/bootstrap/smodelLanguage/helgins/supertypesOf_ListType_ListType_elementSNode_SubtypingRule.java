package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.SubtypingRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.ISubtypingRule_Runtime;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.helgins.inference.TypeChecker;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.helgins.runtime.HUtil;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelUtil_new;

public class supertypesOf_ListType_ListType_elementSNode_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  public supertypesOf_ListType_ListType_elementSNode_SubtypingRule() {
  }

  public List<SNode> getSubOrSuperTypes(SNode listType) {
    List<SNode> result = new ArrayList<SNode>();
    SNode classifierType = TypeChecker.getInstance().getRuntimeSupport().coerce(SLinkOperations.getTarget(listType, "elementType", true), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
    if (SLinkOperations.getTarget(classifierType, "classifier", false) == SLinkOperations.getTarget(new QuotationClass_60().createNode(), "classifier", false)) {
      ListSequence.fromList(result).addElement(new QuotationClass_59().createNode());
    }
    return result;
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return true;
  }

}
