package jetbrains.mps.xmlSchema.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.Set;

public class Extension_BehaviorDescriptor extends ContentItem_BehaviorDescriptor {
  public Extension_BehaviorDescriptor() {
  }

  public void virtual_checkAttributes_1213877413538(SNode thisNode, List<SNode> attributeDeclarations) {
    Extension_Behavior.virtual_checkAttributes_1213877413538(thisNode, attributeDeclarations);
  }

  public boolean virtual_isMixed_1213877413548(SNode thisNode) {
    return Extension_Behavior.virtual_isMixed_1213877413548(thisNode);
  }

  public void virtual_checkElements_1213877413543(SNode thisNode, Set<SNode> elementDeclarations) {
    Extension_Behavior.virtual_checkElements_1213877413543(thisNode, elementDeclarations);
  }

  @Override
  public String getConceptFqName() {
    return "jetbrains.mps.xmlSchema.structure.Extension";
  }
}
