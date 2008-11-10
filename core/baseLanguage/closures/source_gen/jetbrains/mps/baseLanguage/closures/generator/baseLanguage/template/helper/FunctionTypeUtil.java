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
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.text.Collator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.closures.util.Constants;
import jetbrains.mps.baseLanguage.closures.constraints.ClassifierTypeUtil;
import java.util.Comparator;

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
    List<SNode> targets = FunctionTypeUtil.getAdaptableClassifierTypeTargets(ntype, generator);
    String trgFQname = (String)FunctionTypeUtil.getPrepData(expr, generator);
    SNode trg = null;
    for(SNode ct : targets) {
      if (trgFQname.equals(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ct, "classifier", false)))) {
        trg = ct;
        break;
      }
    }
    return trg;
  }

  public static List<SNode> getAllFunctionTypes(SModel sourceModel) {
    List<SNode> cls = SModelOperations.getNodes(sourceModel, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral");
    List<SNode> typesList = new ArrayList<SNode>();
    for(SNode cl : cls) {
      typesList.add(TypeChecker.getInstance().getTypeOf(cl));
    }
    List<SNode> funTypes = SModelOperations.getNodes(sourceModel, "jetbrains.mps.baseLanguage.closures.structure.FunctionType");
    typesList.addAll(funTypes);
    Collections.sort(typesList, new FunctionTypeUtil.FunctionTypeComparator());
    SNode prev = null;
    for(Iterator it = typesList.iterator() ; it.hasNext() ; ) {
      SNode next = ((SNode)it.next());
      if (prev != null) {
        if (Collator.getInstance().compare(FunctionType_Behavior.call_getSignature_1213877405047(((SNode)prev)), FunctionType_Behavior.call_getSignature_1213877405047(((SNode)next))) == 0) {
          it.remove();
          continue;
        }
      }
      prev = next;
    }
    return typesList;
  }

  public static SNode unmeet(SNode possiblyMeet) {
    if (SNodeOperations.isInstanceOf(possiblyMeet, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
      SNode last = null;
      for(SNode arg : SLinkOperations.getTargets(possiblyMeet, "argument", true)) {
        if (!(SNodeOperations.isInstanceOf(arg, "jetbrains.mps.baseLanguage.structure.VoidType"))) {
          for(SNode dsc : SNodeOperations.getDescendants(arg, null, false)) {
            if (SNodeOperations.isInstanceOf(dsc, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
              return unmeetRecursively(SNodeOperations.copyNode(arg));
            }
          }
          return arg;
        }
        last = arg;
      }
      return last;
    }
    if (SNodeOperations.isInstanceOf(possiblyMeet, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      List<SNode> params = SLinkOperations.getTargets(possiblyMeet, "parameter", true);
      for(SNode p : params) {
        SNode up = unmeet(p);
        if (up != p) {
          SNodeOperations.replaceWithAnother(p, up);
        }
      }
    }
    return possiblyMeet;
  }

  public static SNode unmeetRecursively(SNode nodeWithMeetDescendants) {
    for(SNode dsc : SNodeOperations.getDescendants(nodeWithMeetDescendants, null, false)) {
      if (SNodeOperations.isInstanceOf(dsc, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
        SNodeOperations.replaceWithAnother(dsc, SNodeOperations.copyNode(unmeet(dsc)));
      }
    }
    return nodeWithMeetDescendants;
  }

  public static void prepAdaptations(SNode ltype, SNode rexpr, ITemplateGenerator generator) {
    SNode lCType = (SNodeOperations.isInstanceOf(ltype, "jetbrains.mps.baseLanguage.structure.ClassifierType") ?
      ltype :
      null
    );
    SNode lFType = (SNodeOperations.isInstanceOf(ltype, "jetbrains.mps.baseLanguage.closures.structure.FunctionType") ?
      ltype :
      null
    );
    if ((lFType == null) && (lCType == null)) {
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
      rtype :
      null
    );
    SNode rCType = (SNodeOperations.isInstanceOf(rtype, "jetbrains.mps.baseLanguage.structure.ClassifierType") ?
      rtype :
      null
    );
    if ((lCType != null) && (rFType != null)) {
      if (SNodeOperations.isInstanceOf(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) {
        ClosureLiteralUtil.addAdaptableClosureLiteralTarget(rexpr, lCType, generator);
      } else
      {
        FunctionTypeUtil.addAdaptableClassifierTypeTarget(ClassifierTypeUtil.getDeclarationClassifierType(rFType), lCType, generator);
        FunctionTypeUtil.putPrepData(rexpr, INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(lCType, "classifier", false)), generator);
      }
    } else
    if ((lFType != null) && (rCType != null)) {
      FunctionTypeUtil.addAdaptableClassifierTypeTarget(rCType, ClassifierTypeUtil.getDeclarationClassifierType(lFType), generator);
      FunctionTypeUtil.putPrepData(rexpr, INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ClassifierTypeUtil.getDeclarationClassifierType(lFType), "classifier", false)), generator);
    } else
    if ((lFType != null) && (rFType != null)) {
      if (SNodeOperations.isInstanceOf(rexpr, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral")) {
        ClosureLiteralUtil.addAdaptableClosureLiteralTarget(rexpr, ClassifierTypeUtil.getClassifierType(lFType, SLinkOperations.getTargets(rFType, "parameterType", true)), generator);
      } else if (SLinkOperations.getCount(lFType, "throwsType") != SLinkOperations.getCount(rFType, "throwsType")) {
        FunctionTypeUtil.addAdaptableClassifierTypeTarget(ClassifierTypeUtil.getDeclarationClassifierType(rFType), ClassifierTypeUtil.getDeclarationClassifierType(lFType), generator);
        FunctionTypeUtil.putPrepData(rexpr, INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ClassifierTypeUtil.getDeclarationClassifierType(lFType), "classifier", false)), generator);
      }
    }
  }

  public static void addAdaptableClassifierTypeTarget(SNode adaptable, SNode target, ITemplateGenerator generator) {
    List<SNode> allAdaptable = getAllAdaptableClassifierTypes(generator);
    if (allAdaptable == null) {
      allAdaptable = new ArrayList<SNode>();
      generator.getGeneratorSessionContext().putStepObject("all_needs_adapted", allAdaptable);
    }
    if (!(allAdaptable.contains(adaptable))) {
      allAdaptable.add(adaptable);
    }
    List<SNode> trgList = (List<SNode>)generator.getGeneratorSessionContext().getStepObject("needs_adapted_" + INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(adaptable, "classifier", false)));
    if (trgList == null) {
      trgList = new ArrayList<SNode>();
      generator.getGeneratorSessionContext().putStepObject("needs_adapted_" + INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(adaptable, "classifier", false)), trgList);
    }
    boolean hasOneAlready = false;
    for(SNode ct : trgList) {
      if (INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(target, "classifier", false)).equals(INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(ct, "classifier", false)))) {
        hasOneAlready = true;
        break;
      }
    }
    if (!(hasOneAlready)) {
      SNode trg = SNodeOperations.copyNode(target);
      trgList.add(trg);
      ((SNode)trg).putUserObject("adaptable", adaptable);
    }
  }

  public static List<SNode> getAllAdaptableClassifierTypes(ITemplateGenerator generator) {
    return (List<SNode>)generator.getGeneratorSessionContext().getStepObject("all_needs_adapted");
  }

  public static List<SNode> getAdaptableClassifierTypeTargets(SNode adaptable, ITemplateGenerator generator) {
    return (List<SNode>)generator.getGeneratorSessionContext().getStepObject("needs_adapted_" + INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(adaptable, "classifier", false)));
  }

  public static void putPrepData(SNode sn, Object data, ITemplateGenerator generator) {
    generator.getGeneratorSessionContext().putStepObject("classifierType_prepdata_" + ((SNode)sn).getId(), data);
  }

  public static Object getPrepData(SNode sn, ITemplateGenerator generator) {
    return generator.getGeneratorSessionContext().getStepObject("classifierType_prepdata_" + ((SNode)sn).getId());
  }

  public static void putPostData(SNode sn, Object data, ITemplateGenerator generator) {
    generator.getGeneratorSessionContext().putStepObject("classifierType_postData_" + ((SNode)sn).getId(), data);
  }

  public static Object getPostData(SNode sn, ITemplateGenerator generator) {
    return generator.getGeneratorSessionContext().getStepObject("classifierType_postData_" + ((SNode)sn).getId());
  }

  public static class FunctionTypeComparator implements Comparator<SNode> {

    public FunctionTypeComparator() {
    }

    public int compare(SNode x, SNode y) {
      return Collator.getInstance().compare(FunctionType_Behavior.call_getSignature_1213877405047(((SNode)x)), FunctionType_Behavior.call_getSignature_1213877405047(((SNode)y)));
    }

}

}
