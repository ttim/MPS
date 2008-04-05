package jetbrains.mps.bootstrap.smodelLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.bootstrap.helgins.runtime.SubtypingRule_Runtime;
import jetbrains.mps.bootstrap.helgins.runtime.ISubtypingRule_Runtime;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.ListOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;
import jetbrains.mps.smodel.SModelUtil_new;

public class supertypesOf_SConceptTypeType_SConceptTypeType_SubtypingRule extends SubtypingRule_Runtime implements ISubtypingRule_Runtime {

  public  supertypesOf_SConceptTypeType_SConceptTypeType_SubtypingRule() {
  }

  public List<SNode> getSubOrSuperTypes(SNode type) {
    List<SNode> list = ListOperations.<SNode>createList();
    SNode concept = SLinkOperations.getTarget(type, "conceptDeclaraton", false);
    if (SNodeOperations.isInstanceOf(concept, "jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration")) {
      List<SNode> superConcepts = SConceptOperations.getDirectSuperConcepts(concept, false);
      {
        ICursor<SNode> _zCursor2 = CursorFactory.createCursor(superConcepts);
        try {
          while(_zCursor2.moveToNext()) {
            SNode superConcept = _zCursor2.getCurrent();
            ListOperations.addElement(list, new QuotationClass_54().createNode(superConcept));
          }
        } finally {
          _zCursor2.release();
        }
      }
      ListOperations.addElement(list, new QuotationClass_55().createNode());
    }
    return list;
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean isWeak() {
    return false;
  }

}
