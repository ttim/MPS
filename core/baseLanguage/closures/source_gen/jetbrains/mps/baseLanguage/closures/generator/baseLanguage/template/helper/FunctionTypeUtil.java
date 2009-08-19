package jetbrains.mps.baseLanguage.closures.generator.baseLanguage.template.helper;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.behavior.FunctionType_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Comparator;
import java.text.Collator;
import java.util.Iterator;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.baseLanguage.closures.util.Constants;
import jetbrains.mps.baseLanguage.closures.constraints.ClassifierTypeUtil;

public class FunctionTypeUtil {
  public static String getRuntimeSignature(SNode ft) {
    return FunctionType_Behavior.call_getRuntimeSignature_1213877404927(ft);
  }

  public static String getAdapterName(SNode adaptable, SNode target) {
    String aname = SPropertyOperations.getString(SLinkOperations.getTarget(adaptable, "classifier", false), "name");
    int aldidx = aname.lastIndexOf(".");
    aname = (aldidx >= 0 ?
      aname.substring(aldidx + 1) :
      aname
    );
    String tname = SPropertyOperations.getString(SLinkOperations.getTarget(target, "classifier", false), "name");
    int tldidx = tname.lastIndexOf(".");
    tname = (tldidx >= 0 ?
      tname.substring(tldidx + 1) :
      tname
    );
    return aname + "_to_" + tname + "_adapter";
  }

  public static SNode getAdaptableTarget(SNode expr, ITemplateGenerator generator) {
    SNode ntype = TypeChecker.getInstance().getRuntimeSupport().coerce_(TypeChecker.getInstance().getTypeOf(expr), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
    assert ntype != null;
    List<SNode> targets = FunctionTypeUtil.getAdaptableClassifierTypeTargets(SNodeOperations.cast(ntype, "jetbrains.mps.baseLanguage.structure.ClassifierType"), generator);
    String trgFQname = (String)Values.PREP_DATA.get(expr);
    SNode trg = null;
    for (SNode ct : targets) {
      if (trgFQname.equals(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ct, "classifier", false)))) {
        trg = ct;
        break;
      }
    }
    return trg;
  }

  public static List<SNode> getAllFunctionTypes(SModel sourceModel) {
    List<SNode> cls = SModelOperations.getNodes(sourceModel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    List<SNode> typesList = ListSequence.fromList(new ArrayList<SNode>());
    for (SNode cl : cls) {
      ListSequence.fromList(typesList).addElement(TypeChecker.getInstance().getTypeOf(cl));
    }
    List<SNode> funTypes = SModelOperations.getNodes(sourceModel, "jetbrains.mps.baseLanguage.closures.structure.FunctionType");
    ListSequence.fromList(typesList).addSequence(ListSequence.fromList(funTypes));
    ListSequence.fromList(typesList).sort(new Comparator<SNode>() {
      public int compare(SNode a, SNode b) {
        return Collator.getInstance().compare(FunctionType_Behavior.call_getSignature_1213877405047(SNodeOperations.cast(a, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")), FunctionType_Behavior.call_getSignature_1213877405047(SNodeOperations.cast(b, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")));
      }
    }, true);
    SNode prev = null;
    for (Iterator<SNode> it = ListSequence.fromList(typesList).iterator() ; it.hasNext() ; ) {
      SNode next = it.next();
      if (prev != null) {
        if (Collator.getInstance().compare(FunctionType_Behavior.call_getSignature_1213877405047(SNodeOperations.cast(prev, "jetbrains.mps.baseLanguage.closures.structure.FunctionType")), FunctionType_Behavior.call_getSignature_1213877405047(SNodeOperations.cast(next, "jetbrains.mps.baseLanguage.closures.structure.FunctionType"))) == 0) {
          it.remove();
          continue;
        }
      }
      prev = next;
    }
    return typesList;
  }

  public static SNode unmeet(SNode possiblyMeet) {
    SNode tmp = possiblyMeet;
with_meet:
    while (SNodeOperations.isInstanceOf(tmp, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
      for (SNode arg : SLinkOperations.getTargets(SNodeOperations.cast(tmp, "jetbrains.mps.lang.typesystem.structure.MeetType"), "argument", true)) {
        if (!(SNodeOperations.isInstanceOf(arg, "jetbrains.mps.baseLanguage.structure.VoidType"))) {
          tmp = arg;
          continue with_meet;
        }
      }
      return new _Quotations.QuotationClass_2().createNode();
    }
    if (SNodeOperations.isInstanceOf(tmp, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      List<SNode> params = SLinkOperations.getTargets(SNodeOperations.cast(tmp, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "parameter", true);
      for (SNode p : params) {
        SNode up = unmeet(p);
        if (up != p) {
          SNodeOperations.replaceWithAnother(p, up);
        }
      }
    }
    return tmp;
  }

  public static SNode unmeetRecursively(SNode nodeWithMeetDescendants) {
    for (SNode dsc : SNodeOperations.getDescendants(nodeWithMeetDescendants, null, false, new String[]{})) {
      if (SNodeOperations.isInstanceOf(dsc, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
        SNodeOperations.replaceWithAnother(dsc, SNodeOperations.copyNode(unmeet(dsc)));
      }
    }
    return nodeWithMeetDescendants;
  }

  public static void prepAdaptations(SNode ltype, SNode rexpr, TemplateQueryContext genContext) {
    SNode lCType = (SNodeOperations.isInstanceOf(ltype, "jetbrains.mps.baseLanguage.structure.ClassifierType") ?
      SNodeOperations.cast(ltype, "jetbrains.mps.baseLanguage.structure.ClassifierType") :
      null
    );
    SNode lFType = (SNodeOperations.isInstanceOf(ltype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType") ?
      SNodeOperations.cast(ltype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType") :
      null
    );
    if ((lFType == null) && (lCType == null)) {
      return;
    }
    if ((lCType != null) && !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(lCType, "classifier", false), "jetbrains.mps.baseLanguage.structure.Interface"))) {
      return;
    }
    if (Constants.ONLY_CLOSURE_LITERAL_AS_FUNCTION_TYPE) {
      //  TEMP HACK: proceed only if the "right" expression is a ClosureLiteral, balk otherwise
      //  This may cause unexpected results, so please disable in case of difficulties generating some code
      if (!(SNodeOperations.isInstanceOf(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"))) {
        return;
      }
    }
    SNode rtype = TypeChecker.getInstance().getTypeOf(rexpr);
    SNode rFType = (SNodeOperations.isInstanceOf(rtype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType") ?
      SNodeOperations.cast(rtype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType") :
      null
    );
    SNode rCType = (SNodeOperations.isInstanceOf(rtype, "jetbrains.mps.baseLanguage.structure.ClassifierType") ?
      SNodeOperations.cast(rtype, "jetbrains.mps.baseLanguage.structure.ClassifierType") :
      null
    );
    if ((lCType != null) && (rFType != null)) {
      if (SNodeOperations.isInstanceOf(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) {
        ClosureLiteralUtil.addAdaptableClosureLiteralTarget(SNodeOperations.cast(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), lCType, genContext);
      } else {
        FunctionTypeUtil.addAdaptableClassifierTypeTarget(ClassifierTypeUtil.getDeclarationClassifierType(rFType), lCType, genContext);
        Values.PREP_DATA.set(rexpr, INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(lCType, "classifier", false)));
      }
    } else
    if ((lFType != null) && (rCType != null)) {
      FunctionTypeUtil.addAdaptableClassifierTypeTarget(rCType, ClassifierTypeUtil.getDeclarationClassifierType(lFType), genContext);
      Values.PREP_DATA.set(rexpr, INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ClassifierTypeUtil.getDeclarationClassifierType(lFType), "classifier", false)));
    } else
    if ((lFType != null) && (rFType != null)) {
      if (SNodeOperations.isInstanceOf(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) {
        ClosureLiteralUtil.addAdaptableClosureLiteralTarget(SNodeOperations.cast(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), ClassifierTypeUtil.getClassifierType(lFType, SLinkOperations.getTargets(rFType, "parameterType", true)), genContext);
      } else if (SLinkOperations.getCount(lFType, "throwsType") != SLinkOperations.getCount(rFType, "throwsType")) {
        FunctionTypeUtil.addAdaptableClassifierTypeTarget(ClassifierTypeUtil.getDeclarationClassifierType(rFType), ClassifierTypeUtil.getDeclarationClassifierType(lFType), genContext);
        Values.PREP_DATA.set(rexpr, INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ClassifierTypeUtil.getDeclarationClassifierType(lFType), "classifier", false)));
      }
    }
  }

  public static void addAdaptableClassifierTypeTarget(SNode adaptable, SNode target, TemplateQueryContext genContext) {
    List<SNode> allAdaptable = getAllAdaptableClassifierTypes(genContext);
    if (allAdaptable == null) {
      allAdaptable = ListSequence.fromList(new ArrayList<SNode>());
      genContext.putStepObject(Keys.ALL_NEEDS_ADAPTED, allAdaptable);
    }
    if (!(ListSequence.fromList(allAdaptable).contains(adaptable))) {
      ListSequence.fromList(allAdaptable).addElement(adaptable);
    }
    List<SNode> trgList = (List<SNode>)genContext.getStepObject(Keys.NEEDS_ADAPTER.compose(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(adaptable, "classifier", false))));
    if (trgList == null) {
      trgList = ListSequence.fromList(new ArrayList<SNode>());
      genContext.putStepObject(Keys.NEEDS_ADAPTER.compose(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(adaptable, "classifier", false))), trgList);
    }
    boolean hasOneAlready = false;
    for (SNode ct : trgList) {
      if (INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(target, "classifier", false)).equals(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ct, "classifier", false)))) {
        hasOneAlready = true;
        break;
      }
    }
    if (!(hasOneAlready)) {
      SNode trg = SNodeOperations.copyNode(target);
      ListSequence.fromList(trgList).addElement(trg);
      Values.ADAPTABLE.set(trg, adaptable);
    }
  }

  public static List<SNode> getAllAdaptableClassifierTypes(TemplateQueryContext genContext) {
    return (List<SNode>)genContext.getStepObject(Keys.ALL_NEEDS_ADAPTED);
  }

  public static List<SNode> getAdaptableClassifierTypeTargets(SNode adaptable, ITemplateGenerator generator) {
    return (List<SNode>)generator.getGeneratorSessionContext().getStepObject(Keys.NEEDS_ADAPTER.compose(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(adaptable, "classifier", false))));
  }
}
