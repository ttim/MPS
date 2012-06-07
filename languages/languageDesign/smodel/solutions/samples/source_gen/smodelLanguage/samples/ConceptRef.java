package smodelLanguage.samples;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;

public class ConceptRef {
  public void concept_ref_1(SNode node) {
    SNode concept1 = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.IfStatement");
    SNode concept2 = SNodeOperations.getConceptDeclaration(node);
    if (SConceptOperations.isSuperConceptOf(concept1, NameUtil.nodeFQName(concept2))) {
    }
    boolean b2 = SConceptOperations.isExactly(concept1, "jetbrains.mps.baseLanguage.structure.IfStatement");
    boolean b3 = SConceptOperations.isExactly(concept1, NameUtil.nodeFQName(concept2));
  }

  public void instanceOf_1(SNode node, SNode concept1, SNode concept2) {
    SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.IfStatement");
    SNodeOperations.isInstanceOf(node, NameUtil.nodeFQName(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.IfStatement")));
    SNodeOperations.isInstanceOf(node, NameUtil.nodeFQName(SNodeOperations.getConceptDeclaration(node)));
    SNodeOperations.isInstanceOf(node, NameUtil.nodeFQName(concept1));
    SNodeOperations.isInstanceOf(node, NameUtil.nodeFQName(concept2));
    SNodeOperations.isInstanceOf(node, NameUtil.nodeFQName(concept2));
  }

  public void concept_conceptProperties(SNode exprConcept) {
    boolean b = SConceptPropertyOperations.getBoolean(exprConcept, "lvalue");
  }

  public void concept_conceptLinkTargets(SNode conceptFunctionConcept) {
    List<SNode> applicableParams = SLinkOperations.getConceptLinkTargets(conceptFunctionConcept, "applicableConceptFunctionParameter");
  }

  public void concept_types() {
    SNode exprConcept = SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression");
    SNode c1 = exprConcept;
    SNode c2 = (SNode) c1;
    // ====== to node 
    // - ok - 
    SNode n1 = exprConcept;
    SNode n2 = exprConcept;
    // -- not ok -- 
    SNode n3 = exprConcept;
    exprConcept = n1;
    exprConcept = n2;
    // ====== to concept 
    // - ok - 
    SNode exprConc = SNodeOperations.castConcept(c1, "jetbrains.mps.baseLanguage.structure.Expression");
    SNode bExprConc = SNodeOperations.castConcept(exprConcept, "jetbrains.mps.baseLanguage.structure.BinaryOperation");
    exprConc = bExprConc;
    // -- not ok -- 
    bExprConc = exprConc;
  }

  public void concept_hierarchy1(SNode concept) {
    // concept and all its supers 
    List<SNode> hierarchy = SConceptOperations.getConceptHierarchy(concept);
    // supers 
    List<SNode> supers_all = SConceptOperations.getAllSuperConcepts(concept, false);
    List<SNode> supers_all_inclusive = SConceptOperations.getAllSuperConcepts(concept, true);
    // direct supers 
    List<SNode> supers_direct = SConceptOperations.getDirectSuperConcepts(concept, false);
    List<SNode> supers_direct_inclusive = SConceptOperations.getDirectSuperConcepts(concept, true);
    // ====== 
    boolean yes1 = SConceptOperations.isSuperConceptOf(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression"), "jetbrains.mps.baseLanguage.structure.BinaryOperation");
    boolean yes2 = SConceptOperations.isSuperConceptOf(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression"), NameUtil.nodeFQName(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BinaryOperation")));
    boolean yes3 = SConceptOperations.isSubConceptOf(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BinaryOperation"), "jetbrains.mps.baseLanguage.structure.Expression");
    boolean yes4 = SConceptOperations.isSubConceptOf(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BinaryOperation"), NameUtil.nodeFQName(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Expression")));
    SConceptOperations.isSubConceptOf(concept, NameUtil.nodeFQName(concept));
    SConceptOperations.isSuperConceptOf(concept, NameUtil.nodeFQName(concept));
  }

  public void concept_hierarchy2(SModel model, IScope scope) {
    List<SNode> subConcepts = SConceptOperations.getAllSubConcepts(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.BinaryOperation"), model, scope);
    SNode n = null;
    List<SNode> subConcepts1 = SConceptOperations.getAllSubConcepts(SNodeOperations.getConceptDeclaration(n), model, scope);
  }
}
