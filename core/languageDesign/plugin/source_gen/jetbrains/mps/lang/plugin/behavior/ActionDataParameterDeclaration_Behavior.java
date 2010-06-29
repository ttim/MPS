package jetbrains.mps.lang.plugin.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ActionDataParameterDeclaration_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getType_1171743928471337193(SNode thisNode) {
    return ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(SLinkOperations.getTarget(SLinkOperations.getTarget(thisNode, "key", false), "type", true), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "parameter", true)).first();
  }

  public static SNode virtual_getFieldDeclaration_1171743928471867409(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "key", false);
  }

  public static List<SNode> getVariants_1227641865136() {
    List<SNode> dataKeys = new ArrayList<SNode>();
    ListSequence.fromList(dataKeys).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(SLinkOperations.getTarget(new ActionDataParameterDeclaration_Behavior.QuotationClass_6xp2og_a0a0a0a0b0d().createNode(), "classifier", false), "jetbrains.mps.baseLanguage.structure.ClassConcept"), "staticField", true)));
    ListSequence.fromList(dataKeys).addSequence(ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(SLinkOperations.getTarget(new ActionDataParameterDeclaration_Behavior.QuotationClass_6xp2og_a0a0a0a0c0d().createNode(), "classifier", false), "jetbrains.mps.baseLanguage.structure.ClassConcept"), "staticField", true)));
    ListSequence.fromList(dataKeys).removeElement(SLinkOperations.getTarget(new ActionDataParameterDeclaration_Behavior.QuotationClass_6xp2og_a0a0a3a3().createNode(), "variableDeclaration", false));
    ListSequence.fromList(dataKeys).removeElement(SLinkOperations.getTarget(new ActionDataParameterDeclaration_Behavior.QuotationClass_6xp2og_a0a0a4a3().createNode(), "variableDeclaration", false));
    return dataKeys;
  }

  public static String getDescription_47694270442103157(SNode parameterObject) {
    SNode annotation = ListSequence.fromList(SLinkOperations.getTargets(parameterObject, "annotation", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.getString(SLinkOperations.getTarget(it, "annotation", false), "name").equals(SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(new ActionDataParameterDeclaration_Behavior.QuotationClass_6xp2og_a0a0a0a0a0a0a0a0e().createNode(), "classifier", false), "jetbrains.mps.baseLanguage.structure.Annotation"), "name"));
      }
    }).first();
    if (annotation == null) {
      return "";
    }
    SNode value = ListSequence.fromList(SLinkOperations.getTargets(annotation, "value", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.getString(SLinkOperations.getTarget(it, "key", false), "name").equals("description");
      }
    }).first();
    if (value == null) {
      return "";
    }
    return SPropertyOperations.getString(SNodeOperations.cast(SLinkOperations.getTarget(value, "value", true), "jetbrains.mps.baseLanguage.structure.StringLiteral"), "value");
  }

  public static class QuotationClass_6xp2og_a0a0a0a0b0d {
    public QuotationClass_6xp2og_a0a0a0a0b0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.workbench(jetbrains.mps.workbench@java_stub)"), SNodeId.fromString("~MPSDataKeys")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_6xp2og_a0a0a0a0c0d {
    public QuotationClass_6xp2og_a0a0a0a0c0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#com.intellij.openapi.actionSystem(com.intellij.openapi.actionSystem@java_stub)"), SNodeId.fromString("~PlatformDataKeys")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_6xp2og_a0a0a3a3 {
    public QuotationClass_6xp2og_a0a0a3a3() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.workbench(jetbrains.mps.workbench@java_stub)"), SNodeId.fromString("~MPSDataKeys")));
        quotedNode1_2.addReference(SReference.create("variableDeclaration", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.workbench(jetbrains.mps.workbench@java_stub)"), SNodeId.fromString("~MPSDataKeys.SNODE")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_6xp2og_a0a0a4a3 {
    public QuotationClass_6xp2og_a0a0a4a3() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.workbench(jetbrains.mps.workbench@java_stub)"), SNodeId.fromString("~MPSDataKeys")));
        quotedNode1_2.addReference(SReference.create("variableDeclaration", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.workbench(jetbrains.mps.workbench@java_stub)"), SNodeId.fromString("~MPSDataKeys.SNODES")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_6xp2og_a0a0a0a0a0a0a0a0e {
    public QuotationClass_6xp2og_a0a0a0a0a0a0a0a0e() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.workbench(jetbrains.mps.workbench@java_stub)"), SNodeId.fromString("~MPSDataKeys$Description")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
