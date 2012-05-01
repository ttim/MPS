package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.scope.Scope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.scope.EmptyScope;
import jetbrains.mps.lang.scopes.runtime.ScopeUtils;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ConceptFunction_Behavior {
  private static Class[] PARAMETERS_1213877374432 = {SNode.class, SNode.class};
  private static Class[] PARAMETERS_1213877374441 = {SNode.class};
  private static Class[] PARAMETERS_1213877374450 = {SNode.class};
  private static Class[] PARAMETERS_1216468837268 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_usesParameterObjectFor_1213877374432(SNode thisNode, SNode parameter) {
    return SConceptPropertyOperations.getBoolean(thisNode, "usesParameterObject");
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    return ListSequence.fromList(SLinkOperations.getConceptLinkTargets(thisNode, "conceptFunctionReturnType")).first();
  }

  public static List<SNode> virtual_getThrowableTypes_6204026822016975623(SNode thisNode) {
    return SLinkOperations.getConceptLinkTargets(thisNode, "conceptFunctionThrowsType");
  }

  public static SNode virtual_getExpectedRetType_1239354342632(SNode thisNode) {
    return ConceptFunction_Behavior.call_getExpectedReturnType_1213877374441(thisNode);
  }

  public static SNode virtual_getBody_1239354440022(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "body", true);
  }

  public static List<SNode> virtual_getParameters_1213877374450(SNode thisNode) {
    if (thisNode == null) {
      return ListSequence.fromList(new ArrayList<SNode>());
    }
    List<SNode> result = new ArrayList<SNode>();
    ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getConceptLinkTargets(thisNode, "conceptFunctionParameter")));
    ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getConceptLinkTargets(thisNode, "applicableConceptFunctionParameter")));
    return (List<SNode>) result;
  }

  public static boolean call_isReturnOnly_3745452943050787634(SNode thisNode) {
    if (!(StatementList_Behavior.call_isOneLiner_1237538811451(SLinkOperations.getTarget(thisNode, "body", true)))) {
      return false;
    }
    SNode stmt = ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "body", true), "statement", true)).first();
    return SNodeOperations.isInstanceOf(stmt, "jetbrains.mps.baseLanguage.structure.ExpressionStatement") || SNodeOperations.isInstanceOf(stmt, "jetbrains.mps.baseLanguage.structure.ReturnStatement");
  }

  public static String virtual_getName_1216468837268(SNode thisNode) {
    return SConceptPropertyOperations.getString(thisNode, "alias");
  }

  public static String call_getHeader_2866018809101862250(SNode thisNode) {
    StringBuilder result = new StringBuilder();
    // by default 'alias' is not shown. 
    // if you need presentation like alias(...)->.. 
    // then use the ConceptFunctionAliased_Component 
    if (SConceptPropertyOperations.getBoolean(thisNode, "showName")) {
      result.append(ConceptFunction_Behavior.call_getName_1216468837268(thisNode));
    }
    return ConceptFunction_Behavior.call_appendHeader_2866018809101869378(thisNode, result);
  }

  public static String call_getHeaderForAliasedEditor_2866018809101869089(SNode thisNode) {
    StringBuilder result = new StringBuilder();
    return ConceptFunction_Behavior.call_appendHeader_2866018809101869378(thisNode, result);
  }

  public static String call_appendHeader_2866018809101869378(SNode thisNode, StringBuilder result) {
    result.append("(");
    List<SNode> parameters = ConceptFunction_Behavior.call_getParameters_1213877374450(thisNode);
    boolean isFirst = true;
    for (SNode cfp : parameters) {
      if (!(isFirst)) {
        result.append(", ");
      }
      isFirst = false;
      result.append(SConceptPropertyOperations.getString(cfp, "alias"));
    }
    result.append(")->");
    SNode expectedReturnType = ConceptFunction_Behavior.call_getExpectedReturnType_1213877374441(thisNode);
    if (expectedReturnType == null) {
      result.append("void");
    } else {
      result.append(BaseConcept_Behavior.call_getPresentation_1213877396640(expectedReturnType));
    }
    if (ListSequence.fromList(SLinkOperations.getConceptLinkTargets(thisNode, "conceptFunctionThrowsType")).isNotEmpty()) {
      result.append(" throws ");
      boolean isFirstThrowable = true;
      for (SNode throwableType : SLinkOperations.getConceptLinkTargets(thisNode, "conceptFunctionThrowsType")) {
        if (!(isFirstThrowable)) {
          result.append(", ");
        }
        isFirstThrowable = false;
        result.append(BaseConcept_Behavior.call_getPresentation_1213877396640(throwableType));
      }
    }
    return result.toString();
  }

  public static Scope virtual_getScope_3734116213129936182(SNode thisNode, SNode kind, SNode child) {
    // todo: rewrite using filtering scope 
    {
      SNode concept_b0l;
      concept_b0l = kind;
      if (SConceptOperations.isSubConceptOf(concept_b0l, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
        return new EmptyScope();
      }
      if (SConceptOperations.isSubConceptOf(concept_b0l, "jetbrains.mps.baseLanguage.structure.ParameterDeclaration")) {
        return new EmptyScope();
      }
    }
    return ScopeUtils.lazyParentScope(thisNode, kind);
  }

  public static boolean call_usesParameterObjectFor_1213877374432(SNode thisNode, SNode parameter) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), "virtual_usesParameterObjectFor_1213877374432", PARAMETERS_1213877374432, parameter);
  }

  public static SNode call_getExpectedReturnType_1213877374441(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), "virtual_getExpectedReturnType_1213877374441", PARAMETERS_1213877374441);
  }

  public static List<SNode> call_getParameters_1213877374450(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), "virtual_getParameters_1213877374450", PARAMETERS_1213877374450);
  }

  public static String call_getName_1216468837268(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), "virtual_getName_1216468837268", PARAMETERS_1216468837268);
  }

  public static boolean callSuper_usesParameterObjectFor_1213877374432(SNode thisNode, String callerConceptFqName, SNode parameter) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), callerConceptFqName, "virtual_usesParameterObjectFor_1213877374432", PARAMETERS_1213877374432, parameter);
  }

  public static SNode callSuper_getExpectedReturnType_1213877374441(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), callerConceptFqName, "virtual_getExpectedReturnType_1213877374441", PARAMETERS_1213877374441);
  }

  public static List<SNode> callSuper_getParameters_1213877374450(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), callerConceptFqName, "virtual_getParameters_1213877374450", PARAMETERS_1213877374450);
  }

  public static String callSuper_getName_1216468837268(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction"), callerConceptFqName, "virtual_getName_1216468837268", PARAMETERS_1216468837268);
  }
}
