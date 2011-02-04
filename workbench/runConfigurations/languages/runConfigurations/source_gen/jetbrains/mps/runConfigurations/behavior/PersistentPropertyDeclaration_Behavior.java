package jetbrains.mps.runConfigurations.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PersistentPropertyDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static boolean call_isSmart_77193491200360813(SNode thisNode) {
    return TypeChecker.getInstance().getSubtypingManager().isSubtype(SLinkOperations.getTarget(thisNode, "type", true), new PersistentPropertyDeclaration_Behavior.QuotationClass_ex141d_a1a0a0b().createNode());
  }

  public static String call_getAccessorName_6458115119415160800(SNode thisNode) {
    String prefix = "my";
    String accesorName = SPropertyOperations.getString(thisNode, "name");
    if (accesorName.startsWith(prefix) && accesorName.length() > 2) {
      accesorName = accesorName.substring(prefix.length());
    }
    return accesorName.substring(0, 1).toUpperCase() + accesorName.substring(1);
  }

  public static class QuotationClass_ex141d_a1a0a0b {
    public QuotationClass_ex141d_a1a0a0b() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.SmartPersistentPropertyType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
