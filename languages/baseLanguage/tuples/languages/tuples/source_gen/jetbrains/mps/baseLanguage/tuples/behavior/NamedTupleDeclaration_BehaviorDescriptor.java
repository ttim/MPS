package jetbrains.mps.baseLanguage.tuples.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.Classifier_BehaviorDescriptor;
import java.util.List;
import jetbrains.mps.smodel.SNode;

public class NamedTupleDeclaration_BehaviorDescriptor extends Classifier_BehaviorDescriptor {
  public NamedTupleDeclaration_BehaviorDescriptor() {
  }

  public List<SNode> virtual_getExtendedClassifiers_2201875424516179426(SNode thisNode) {
    return NamedTupleDeclaration_Behavior.virtual_getExtendedClassifiers_2201875424516179426(thisNode);
  }

  public Iterable<SNode> virtual_doOverride_7343816061617019844(SNode thisNode, SNode kind, List<SNode> equalSignatureMembers) {
    return NamedTupleDeclaration_Behavior.virtual_doOverride_7343816061617019844(thisNode, kind, equalSignatureMembers);
  }

  public String virtual_getPresentation_1213877396640(SNode thisNode) {
    return NamedTupleDeclaration_Behavior.virtual_getPresentation_1213877396640(thisNode);
  }

  public SNode virtual_getThisType_3305065273710880775(SNode thisNode) {
    return NamedTupleDeclaration_Behavior.virtual_getThisType_3305065273710880775(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration";
  }
}
