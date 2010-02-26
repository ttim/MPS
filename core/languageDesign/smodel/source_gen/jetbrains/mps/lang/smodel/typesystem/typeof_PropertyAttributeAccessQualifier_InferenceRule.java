package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_PropertyAttributeAccessQualifier_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_PropertyAttributeAccessQualifier_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    SNode annotationLink = SLinkOperations.getTarget(nodeToCheck, "annotationLink", false);
    if (annotationLink == null) {
      return;
    }
    // assign type 
    if (SPropertyOperations.hasValue(annotationLink, "sourceCardinality", "0..1", "0..1")) {
      {
        SNode _nodeToCheck_1029348928467 = nodeToCheck;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "5458013232459741184", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "5458013232459741186", true), (SNode) new typeof_PropertyAttributeAccessQualifier_InferenceRule.QuotationClass_iup6w1_a0a0a3a0().createNode(SLinkOperations.getTarget(annotationLink, "target", false), typeCheckingContext), _info_12389875345);
      }
    } else {
      {
        SNode _nodeToCheck_1029348928467 = nodeToCheck;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "5458013232459741203", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "5458013232459741212", true), (SNode) new typeof_PropertyAttributeAccessQualifier_InferenceRule.QuotationClass_iup6w1_a0a0a0d0a().createNode(SLinkOperations.getTarget(annotationLink, "target", false), typeCheckingContext), _info_12389875345);
      }
    }
    // --- 
    if (!(SPropertyOperations.hasValue(annotationLink, "stereotype", "property", "node"))) {
      BaseIntentionProvider intentionProvider = null;
      IErrorTarget errorTarget = new NodeErrorTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(nodeToCheck, "property annotation link is expected", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204832870610", intentionProvider, errorTarget);
    }
    final SNode propQ = SLinkOperations.getTarget(nodeToCheck, "propertyQualifier", true);
    if (SNodeOperations.isInstanceOf(propQ, "jetbrains.mps.lang.smodel.structure.PoundExpression")) {
      // # property name 
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(SNodeOperations.cast(propQ, "jetbrains.mps.lang.smodel.structure.PoundExpression"), "expression", true);
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204835998060", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1204835998062", false), (SNode) new typeof_PropertyAttributeAccessQualifier_InferenceRule.QuotationClass_iup6w1_a0a1a7a0().createNode(typeCheckingContext), false, _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.PropertyAttributeAccessQualifier";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_iup6w1_a0a0a3a0 {
    public QuotationClass_iup6w1_a0a0a3a0() {
    }

    public SNode createNode(Object parameter_iup6w1_a0a0a0a3a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_iup6w1_a0a0a3a0 = null;
      {
        quotedNode_iup6w1_a0a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_iup6w1_a0a0a3a0 = quotedNode_iup6w1_a0a0a3a0;
        quotedNode1_iup6w1_a0a0a3a0.setReferent("concept", (SNode) parameter_iup6w1_a0a0a0a3a0);
        result = quotedNode1_iup6w1_a0a0a3a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_iup6w1_a0a0a0a3a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_iup6w1_a0a0a3a0 = null;
      {
        quotedNode_iup6w1_a0a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_iup6w1_a0a0a3a0 = quotedNode_iup6w1_a0a0a3a0;
        quotedNode1_iup6w1_a0a0a3a0.setReferent("concept", (SNode) parameter_iup6w1_a0a0a0a3a0);
        result = quotedNode1_iup6w1_a0a0a3a0;
      }
      return result;
    }
  }

  public static class QuotationClass_iup6w1_a0a0a0d0a {
    public QuotationClass_iup6w1_a0a0a0d0a() {
    }

    public SNode createNode(Object parameter_iup6w1_a0a0a0a0d0a, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_iup6w1_a0a0a0d0a = null;
      {
        quotedNode_iup6w1_a0a0a0d0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_iup6w1_a0a0a0d0a = quotedNode_iup6w1_a0a0a0d0a;
        quotedNode1_iup6w1_a0a0a0d0a.setReferent("elementConcept", (SNode) parameter_iup6w1_a0a0a0a0d0a);
        result = quotedNode1_iup6w1_a0a0a0d0a;
      }
      return result;
    }

    public SNode createNode(Object parameter_iup6w1_a0a0a0a0d0a) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_iup6w1_a0a0a0d0a = null;
      {
        quotedNode_iup6w1_a0a0a0d0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeListType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_iup6w1_a0a0a0d0a = quotedNode_iup6w1_a0a0a0d0a;
        quotedNode1_iup6w1_a0a0a0d0a.setReferent("elementConcept", (SNode) parameter_iup6w1_a0a0a0a0d0a);
        result = quotedNode1_iup6w1_a0a0a0d0a;
      }
      return result;
    }
  }

  public static class QuotationClass_iup6w1_a0a1a7a0 {
    public QuotationClass_iup6w1_a0a1a7a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_iup6w1_a0a1a7a0 = null;
      {
        quotedNode_iup6w1_a0a1a7a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_iup6w1_a0a1a7a0 = quotedNode_iup6w1_a0a1a7a0;
        result = quotedNode1_iup6w1_a0a1a7a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_iup6w1_a0a1a7a0 = null;
      {
        quotedNode_iup6w1_a0a1a7a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_iup6w1_a0a1a7a0 = quotedNode_iup6w1_a0a1a7a0;
        result = quotedNode1_iup6w1_a0a1a7a0;
      }
      return result;
    }
  }
}
