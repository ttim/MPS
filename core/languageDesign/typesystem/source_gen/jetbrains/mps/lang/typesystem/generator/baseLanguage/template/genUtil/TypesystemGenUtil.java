package jetbrains.mps.lang.typesystem.generator.baseLanguage.template.genUtil;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.typesystem.inference.TypeChecker;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class TypesystemGenUtil {
  public TypesystemGenUtil() {
  }

  public static boolean isInCheckEquation(SNode node) {
    SNode current = node;
    SNode oldCurrent = null;
    while (current != null) {
      oldCurrent = current;
      current = SNodeOperations.getAncestor(current, "jetbrains.mps.baseLanguage.structure.AnonymousClass", false, false);
    }
    return "checkInequation".equals(SPropertyOperations.getString(SNodeOperations.getAncestor(oldCurrent, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false), "name"));
  }

  public static boolean isInRuleWithContext(SNode node) {
    SNode root = SNodeOperations.getContainingRoot(node);
    if (SNodeOperations.isInstanceOf(root, "jetbrains.mps.lang.typesystem.structure.AbstractCheckingRule")) {
      return true;
    }
    SNode baseMethodDeclaration = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false);
    if ((baseMethodDeclaration != null)) {
      for (SNode annotationInstance : SLinkOperations.getTargets(baseMethodDeclaration, "annotation", true)) {
        SNode annotation = SLinkOperations.getTarget(annotationInstance, "annotation", false);
        if (annotation == SLinkOperations.getTarget(new TypesystemGenUtil.QuotationClass_6023_l523emnfc4et().createNode(), "classifier", false) || annotation == SLinkOperations.getTarget(new TypesystemGenUtil.QuotationClass_6023_l523emnfc4d0().createNode(), "classifier", false)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean returnsNode(SNode subtypingRule) {
    List<SNode> returnStatements = SNodeOperations.getDescendants(subtypingRule, "jetbrains.mps.baseLanguage.structure.ReturnStatement", false, new String[]{"jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral","jetbrains.mps.baseLanguage.structure.AnonymousClass","jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"});
    for (SNode retSt : returnStatements) {
      if (!(TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(retSt, "expression", true)), new TypesystemGenUtil.QuotationClass_6023_l523emnfc4gm().createNode()))) {
        return false;
      }
    }
    return true;
  }

  public static class QuotationClass_6023_l523emnfc4d0 {
    public QuotationClass_6023_l523emnfc4d0() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6023_fmdedctm = null;
      {
        quotedNode_6023_fmdedctm = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6023_fmdedctm = quotedNode_6023_fmdedctm;
        quotedNode1_6023_fmdedctm.addReference(SReference.create("classifier", quotedNode1_6023_fmdedctm, SModelReference.fromString("r:00000000-0000-4000-0000-011c895902b5(jetbrains.mps.lang.typesystem.dependencies)"), SNodeId.fromString("1223644778913")));
        result = quotedNode1_6023_fmdedctm;
      }
      return result;
    }
  }

  public static class QuotationClass_6023_l523emnfc4et {
    public QuotationClass_6023_l523emnfc4et() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6023_fmdecpp4 = null;
      {
        quotedNode_6023_fmdecpp4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6023_fmdecpp4 = quotedNode_6023_fmdecpp4;
        quotedNode1_6023_fmdecpp4.addReference(SReference.create("classifier", quotedNode1_6023_fmdecpp4, SModelReference.fromString("r:00000000-0000-4000-0000-011c895902b5(jetbrains.mps.lang.typesystem.dependencies)"), SNodeId.fromString("1196177069451")));
        result = quotedNode1_6023_fmdecpp4;
      }
      return result;
    }
  }

  public static class QuotationClass_6023_l523emnfc4gm {
    public QuotationClass_6023_l523emnfc4gm() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6023_l523emnfc4cm = null;
      {
        quotedNode_6023_l523emnfc4cm = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6023_l523emnfc4cm = quotedNode_6023_l523emnfc4cm;
        result = quotedNode1_6023_l523emnfc4cm;
      }
      return result;
    }
  }
}
