package jetbrains.mps.baseLanguage.generator.java.closures.util;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class QueriesUtil {
  public QueriesUtil() {
  }

  public static SNode createClassType_forClosure_enclosingClass(SNode inputClosure, ITemplateGenerator generator) {
    SNode enclosingClass = SNodeOperations.getAncestor(inputClosure, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    if (enclosingClass == null) {
      // closure is not in class 
      enclosingClass = getJavaLangObject();
    }
    SModel outputModel = generator.getOutputModel();
    SNode outputClassType = SModelOperations.createNewNode(outputModel, "jetbrains.mps.baseLanguage.structure.ClassifierType", null);
    SLinkOperations.setTarget(outputClassType, "classifier", enclosingClass, false);
    for (SNode typeVar : ListSequence.fromList(SLinkOperations.getTargets(enclosingClass, "typeVariableDeclaration", true))) {
      SNode typeVarRef = SLinkOperations.addNewChild(outputClassType, "parameter", "jetbrains.mps.baseLanguage.structure.TypeVariableReference");
      SLinkOperations.setTarget(typeVarRef, "typeVariableDeclaration", typeVar, false);
    }
    return outputClassType;
  }

  public static List<SNode> getTypeVars_from_Closure_enclosingClass(SNode inputClosure, IScope scope) {
    SNode enclosingClass = SNodeOperations.getAncestor(inputClosure, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    if (enclosingClass == null) {
      // closure is not in class 
      enclosingClass = getJavaLangObject();
    }
    return SLinkOperations.getTargets(enclosingClass, "typeVariableDeclaration", true);
  }

  public static SNode create_enclosingClassObject(SNode nodeInsideClosure) {
    // 
    // must be invoked in $COPY-SRC$ because use ref on class in 'input model' 
    // 
    SNode enclosingClass = SNodeOperations.getAncestor(nodeInsideClosure, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
    if (enclosingClass == null) {
      return SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.NullLiteral", null);
    }
    SNode enclosingMethodOrClosure = SNodeOperations.getAncestorWhereConceptInList(nodeInsideClosure, new String[]{"jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", "jetbrains.mps.baseLanguage.structure.Closure"}, false, false);
    // --- in closure 
    if (SNodeOperations.isInstanceOf(enclosingMethodOrClosure, "jetbrains.mps.baseLanguage.structure.Closure")) {
      SNode fieldRef = new QueriesUtil.QuotationClass_w9106s_a0a0a7a2().createNode();
      SNode typeOfField = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
      SLinkOperations.setTarget(typeOfField, "classifier", enclosingClass, false);
      SLinkOperations.setTarget(fieldRef, "fieldType", typeOfField, true);
      return fieldRef;
    }
    // --- in instance method 
    if (SNodeOperations.isInstanceOf(enclosingMethodOrClosure, "jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration") || SNodeOperations.isInstanceOf(enclosingMethodOrClosure, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration")) {
      SNode thisExpr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ThisExpression", null);
      SLinkOperations.setTarget(thisExpr, "classConcept", enclosingClass, false);
      return thisExpr;
    }
    // --- none of above 
    return SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.NullLiteral", null);
  }

  private static SNode getJavaLangObject() {
    return SNodeOperations.cast(SLinkOperations.getTarget(new QueriesUtil.QuotationClass_w9106s_a0a0a0d().createNode(), "classifier", false), "jetbrains.mps.baseLanguage.structure.ClassConcept");
  }

  public static class QuotationClass_w9106s_a0a0a7a2 {
    public QuotationClass_w9106s_a0a0a7a2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguageInternal.structure.InternalPartialFieldReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        quotedNode1_4.setProperty("fieldName", "_enclosingClass");
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ThisExpression", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_5 = quotedNode_2;
          quotedNode_1.addChild("instance", quotedNode1_5);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.Type", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_3;
          quotedNode_1.addChild("fieldType", quotedNode1_6);
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_w9106s_a0a0a0d {
    public QuotationClass_w9106s_a0a0a0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
