package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;
import jetbrains.mps.util.NameUtil;

public class SetType_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    return SConceptPropertyOperations.getString(thisNode, "alias") + "<" + BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(thisNode, "elementType", true)) + ">";
  }

  public static List<String> virtual_getVariableSuffixes_1213877337304(SNode thisNode) {
    List<String> variableSuffixes = ListSequence.fromListAndArray(new ArrayList<String>(), "set");
    if ((SLinkOperations.getTarget(thisNode, "elementType", true) != null)) {
      for (String suffix : ListSequence.fromList(Type_Behavior.call_getVariableSuffixes_1213877337304(SLinkOperations.getTarget(thisNode, "elementType", true)))) {
        ListSequence.fromList(variableSuffixes).addElement(NameUtil.pluralize(suffix));
      }
    }
    return variableSuffixes;
  }

  public static SNode virtual_getAbstractCreator_1213877337340(SNode thisNode) {
    return null;
  }

  public static List<SNode> virtual_getAbstractCreators_1226945293888(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    ListSequence.fromList(result).addElement(new _Quotations.QuotationClass_5().createNode(SLinkOperations.getTarget(thisNode, "elementType", true)));
    ListSequence.fromList(result).addElement(new _Quotations.QuotationClass_6().createNode(SLinkOperations.getTarget(thisNode, "elementType", true)));
    return result;
  }

  public static SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    return new _Quotations.QuotationClass_10().createNode();
  }
}
