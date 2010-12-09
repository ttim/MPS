package jetbrains.mps.baseLanguage.tuples.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class NamedTupleDeclaration_Behavior {
  private static Class[] PARAMETERS_6742265879766289824 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    StringBuilder sb = new StringBuilder(SConceptPropertyOperations.getString(thisNode, "leftBracket"));
    String sep = "";
    for (SNode cmp : ListSequence.fromList(NamedTupleDeclaration_Behavior.call_allExtends_3142843783245461132(thisNode)).reversedList().<SNode>translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode ntd) {
        return SLinkOperations.getTargets(ntd, "component", true);
      }
    })) {
      sb.append(sep).append(SPropertyOperations.getString(cmp, "name"));
      sep = ", ";
    }
    return sb.append(SConceptPropertyOperations.getString(thisNode, "rightBracket")).append(" ").append(SPropertyOperations.getString(thisNode, "nestedName")).toString();
  }

  public static List<SNode> call_allExtends_3142843783245461132(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    SNode ntd = thisNode;
    while ((ntd != null) && !(ListSequence.fromList(result).contains(ntd))) {
      ListSequence.fromList(result).addElement(ntd);
      ntd = SLinkOperations.getTarget(SLinkOperations.getTarget(ntd, "extended", true), "classifier", false);
    }
    return result;
  }

  public static SNode virtual_getThisType_3305065273710880775(SNode thisNode) {
    _FunctionTypes._return_P1_E0<? extends SNode, ? super SNode> tvd2tvr = new _FunctionTypes._return_P1_E0<SNode, Object>() {
      public SNode invoke(Object tvr) {
        return new NamedTupleDeclaration_Behavior.QuotationClass_ds5lpv_a0a0a0a0d().createNode(tvr);
      }
    };
    return new NamedTupleDeclaration_Behavior.QuotationClass_ds5lpv_a0b0d().createNode(thisNode, ListSequence.fromList(SLinkOperations.getTargets(thisNode, "typeVariableDeclaration", true)).<SNode>select(tvd2tvr).toListSequence());
  }

  public static SNode call_getThisType_6742265879766289824(SNode thisNode) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration"), "virtual_getThisType_3305065273710880775", PARAMETERS_6742265879766289824);
  }

  public static SNode callSuper_getThisType_6742265879766289824(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.tuples.structure.NamedTupleDeclaration"), callerConceptFqName, "virtual_getThisType_3305065273710880775", PARAMETERS_6742265879766289824);
  }

  public static class QuotationClass_ds5lpv_a0a0a0a0d {
    public QuotationClass_ds5lpv_a0a0a0a0d() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.TypeVariableReference", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("typeVariableDeclaration", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_ds5lpv_a0b0d {
    public QuotationClass_ds5lpv_a0b0d() {
    }

    public SNode createNode(Object parameter_4, Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        quotedNode1_3.setReferent("classifier", (SNode) parameter_4);
        {
          List<SNode> nodes = (List<SNode>) parameter_5;
          for (SNode child : nodes) {
            quotedNode_1.addChild("parameter", HUtil.copyIfNecessary(child));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
