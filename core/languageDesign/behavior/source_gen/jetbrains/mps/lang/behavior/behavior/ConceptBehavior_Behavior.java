package jetbrains.mps.lang.behavior.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.IExtractMethodRefactoringProcessor;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.AbstractExtractMethodRefactoringProcessor;
import jetbrains.mps.baseLanguage.util.plugin.refactorings.AbstractStaticContainerProcessor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.structure.behavior.IConceptAspect_Behavior;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class ConceptBehavior_Behavior {
  private static Class[] PARAMETERS_6261424444345978650 = {SNode.class ,SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getMembers_1213877531970(SNode thisNode) {
    List<SNode> members = new ArrayList<SNode>();
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "properties", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "references", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "method", true)));
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "staticMethod", true)));
    return members;
  }

  public static List<SNode> call_getVisibleStaticMethods_1225194243338(SNode thisNode, SNode contextNode) {
    List<SNode> result = new ArrayList<SNode>();
    for (SNode method : SLinkOperations.getTargets(thisNode, "staticMethod", true)) {
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PublicVisibility")) {
        ListSequence.fromList(result).addElement(method);
      }
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PrivateVisibility")) {
        if (SNodeOperations.getAncestor(contextNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false) == thisNode) {
          ListSequence.fromList(result).addElement(method);
        }
      }
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.ProtectedVisibility")) {
        SNode contextConcept = SLinkOperations.getTarget(SNodeOperations.getAncestor(contextNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false), "concept", false);
        SNode methodConcept = SLinkOperations.getTarget(SNodeOperations.getAncestor(method, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false), "concept", false);
        if (SConceptOperations.isSubConceptOf(contextConcept, NameUtil.nodeFQName(methodConcept))) {
          ListSequence.fromList(result).addElement(method);
        }
      }
      if ((SLinkOperations.getTarget(method, "visibility", true) == null)) {
        if (SNodeOperations.getModel(method) == SNodeOperations.getModel(contextNode)) {
          ListSequence.fromList(result).addElement(method);
        }
      }
    }
    return result;
  }

  public static IExtractMethodRefactoringProcessor virtual_getExtractMethodRefactoringProcessor_1221393367929(SNode thisNode, List<SNode> nodesToExtract) {
    AbstractExtractMethodRefactoringProcessor result = new AbstractExtractMethodRefactoringProcessor(thisNode, nodesToExtract) {
      public SNode createMethodCall(SNode declaration, List<SNode> arguments) {
        if (SNodeOperations.isInstanceOf(declaration, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration")) {
          SNode call = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall", null);
          SLinkOperations.setTarget(call, "baseMethodDeclaration", SNodeOperations.cast(declaration, "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), false);
          ListSequence.fromList(SLinkOperations.getTargets(call, "actualArgument", true)).addSequence(ListSequence.fromList(arguments));
          SNode result = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.DotExpression", null);
          SLinkOperations.setTarget(result, "operand", SConceptOperations.createNewNode("jetbrains.mps.lang.behavior.structure.ThisNodeExpression", null), true);
          SLinkOperations.setTarget(result, "operation", call, true);
          return result;
        }
        if (SNodeOperations.isInstanceOf(declaration, "jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration")) {
          SNode call = SConceptOperations.createNewNode("jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall", null);
          SLinkOperations.setTarget(call, "baseMethodDeclaration", SNodeOperations.cast(declaration, "jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration"), false);
          ListSequence.fromList(SLinkOperations.getTargets(call, "actualArgument", true)).addSequence(ListSequence.fromList(arguments));
          SLinkOperations.setTarget(call, "concept", SLinkOperations.getTarget(SNodeOperations.cast(this.myNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "concept", false), false);
          return call;
        }
        return null;
      }

      @Override
      public SNode createNewMethod() {
        SNode container = this.getContainerMethod();
        return SConceptOperations.createNewNode(NameUtil.nodeFQName(SNodeOperations.getConceptDeclaration(container)), null);
      }
    };
    return result;
  }

  public static AbstractStaticContainerProcessor virtual_getStaticContainerProcessor_1222174378300(SNode thisNode, SNode node) {
    return new AbstractStaticContainerProcessor(node) {
      public SNode createNewMethod() {
        return SConceptOperations.createNewNode("jetbrains.mps.lang.behavior.structure.StaticConceptMethodDeclaration", null);
      }

      public SNode createMethodCall(SNode method, List<SNode> arguments) {
        return new ConceptBehavior_Behavior.QuotationClass_xahq23_a0a0b0a0a0e().createNode(SLinkOperations.getTarget(SNodeOperations.cast(this.myStaticContainer, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "concept", false), method, arguments);
      }
    };
  }

  public static List<SNode> virtual_getMethodsToOverride_5418393554803767537(SNode thisNode) {
    List<SNode> methods = new ArrayList<SNode>();
    for (SNode method : ConceptBehavior_Behavior.call_getConceptMethods_5466054087443746043(thisNode, GlobalScope.getInstance())) {
      if (SPropertyOperations.getBoolean(method, "isFinal")) {
        continue;
      }
      if (!(SPropertyOperations.getBoolean(method, "isVirtual"))) {
        continue;
      }
      if (SPropertyOperations.getBoolean(method, "isAbstract")) {
        continue;
      }
      SNode container = SNodeOperations.getAncestor(method, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", false, false);
      if (container == thisNode || container == null) {
        continue;
      }

      ListSequence.fromList(methods).addElement(method);
    }
    return methods;
  }

  public static List<SNode> virtual_getMethodsToImplement_5418393554803775106(SNode thisNode) {
    SNode baseNode = IConceptAspect_Behavior.call_getBaseConcept_2621449412040133768(thisNode);
    if ((baseNode == null)) {
      return new ArrayList<SNode>();
    }
    return AbstractConceptDeclaration_Behavior.call_getNotImplementedConceptMethods_1213877394339(baseNode, GlobalScope.getInstance());
  }

  public static List<SNode> call_getConceptMethods_5466054087443746043(SNode thisNode, IScope scope) {
    List<SNode> methods = new ArrayList<SNode>();
    for (SNode concept : SConceptOperations.getAllSuperConcepts(SLinkOperations.getTarget(thisNode, "concept", false), false)) {
      SNode behaviour = SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(concept, scope, LanguageAspect.BEHAVIOR), "jetbrains.mps.lang.behavior.structure.ConceptBehavior");
      if (behaviour != null) {
        for (SNode method : SLinkOperations.getTargets(behaviour, "method", true)) {
          ListSequence.fromList(methods).addElement(method);
        }
      }
    }
    return methods;
  }

  public static SNode virtual_getBaseConcept_2621449412040133768(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "concept", false);
  }

  public static void virtual_setBaseConcept_6261424444345963020(SNode thisNode, SNode baseConcept) {
    SLinkOperations.setTarget(thisNode, "concept", baseConcept, false);
  }

  public static void call_setBaseConcept_6261424444345978650(SNode thisNode, SNode baseConcept) {
    BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345978650, baseConcept);
  }

  public static void callSuper_setBaseConcept_6261424444345978650(SNode thisNode, String callerConceptFqName, SNode baseConcept) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), callerConceptFqName, "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345978650, baseConcept);
  }

  public static class QuotationClass_xahq23_a0a0b0a0a0e {
    public QuotationClass_xahq23_a0a0b0a0a0e() {
    }

    public SNode createNode(Object parameter_4, Object parameter_5, Object parameter_6) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.StaticConceptMethodCall", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        quotedNode1_3.setReferent("baseMethodDeclaration", (SNode) parameter_5);
        quotedNode1_3.setReferent("concept", (SNode) parameter_4);
        {
          List<SNode> nodes = (List<SNode>) parameter_6;
          for (SNode child : nodes) {
            quotedNode_1.addChild("actualArgument", HUtil.copyIfNecessary(child));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
