package jetbrains.mps.baseLanguage.closures.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.logging.Logger;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.pattern.IMatchingPattern;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class ClassifierTypeUtil {
  public static SNode getTypeCoercedToClassifierType(SNode type) {
    // cast is such to avoid exception if MeetType 
    SNode purified = (SNode) type;
    if (SNodeOperations.isInstanceOf(purified, "jetbrains.mps.baseLanguage.structure.TypeVariableReference") || SNodeOperations.isInstanceOf(purified, "jetbrains.mps.baseLanguage.structure.WildCardType")) {
      return purified;
    }
    if (SNodeOperations.isInstanceOf(purified, "jetbrains.mps.baseLanguage.structure.UpperBoundType")) {
      SNode res = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.UpperBoundType", null);
      SLinkOperations.setTarget(res, "bound", SNodeOperations.copyNode(getTypeCoercedToClassifierType(SLinkOperations.getTarget(SNodeOperations.cast(purified, "jetbrains.mps.baseLanguage.structure.UpperBoundType"), "bound", true))), true);
      return res;
    }
    if (SNodeOperations.isInstanceOf(purified, "jetbrains.mps.baseLanguage.structure.ArrayType")) {
      SNode at = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ArrayType", null);
      SLinkOperations.setTarget(at, "componentType", coerceToClassifierTypeOrPrimitive(SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(purified, "jetbrains.mps.baseLanguage.structure.ArrayType"), "componentType", true))), true);
      return at;
    }
    if (SNodeOperations.isInstanceOf(purified, "jetbrains.mps.baseLanguage.structure.NullType")) {
      return new ClassifierTypeUtil.QuotationClass_zgotlq_a0a0f0a().createNode();
    }
    if (SNodeOperations.isInstanceOf(purified, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
      SNode res = SConceptOperations.createNewNode("jetbrains.mps.lang.typesystem.structure.MeetType", null);
      for (SNode arg : SLinkOperations.getTargets(SNodeOperations.cast(purified, "jetbrains.mps.lang.typesystem.structure.MeetType"), "argument", true)) {
        if (SNodeOperations.isInstanceOf(arg, "jetbrains.mps.baseLanguage.structure.Type")) {
          ListSequence.fromList(SLinkOperations.getTargets(res, "argument", true)).addElement(SNodeOperations.copyNode(getTypeCoercedToClassifierType(SNodeOperations.cast(arg, "jetbrains.mps.baseLanguage.structure.Type"))));
        } else {
          Logger.getLogger(ClassifierTypeUtil.class).warning("Argument of an instance of MEET type is not a subconcept of Type");
        }
      }
      return res;
    }
    SNode coerced = coerceToClassifierType(purified);
    if (SNodeOperations.isInstanceOf(coerced, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      SNode classifierType = SNodeOperations.cast(coerced, "jetbrains.mps.baseLanguage.structure.ClassifierType");
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(classifierType, "classifier", false), "jetbrains.mps.baseLanguage.structure.AnonymousClass")) {
        classifierType = SNodeOperations.copyNode(classifierType);
        SLinkOperations.setTarget(classifierType, "classifier", SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(classifierType, "classifier", false), "jetbrains.mps.baseLanguage.structure.AnonymousClass"), "classifier", false), false);
        return classifierType;
      }
    }
    return coerced;
  }

  private static SNode coerceToClassifierType(SNode type) {
    SNode cType = ClassifierTypeUtil.coerceToClassifierTypeIgnoreParameters(type);
    if ((cType != null)) {
      List<SNode> params = SLinkOperations.getTargets(cType, "parameter", true);
      if (params != null && ListSequence.fromList(params).count() > 0) {
        SNode res = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
        SLinkOperations.setTarget(res, "classifier", SLinkOperations.getTarget(cType, "classifier", false), false);
        for (SNode p : params) {
          ListSequence.fromList(SLinkOperations.getTargets(res, "parameter", true)).addElement(SNodeOperations.copyNode(getTypeCoercedToClassifierType(p)));
        }
        return res;
      }
      return cType;
    }
    return type;
  }

  private static SNode coerceToClassifierTypeOrPrimitive(SNode type) {
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.PrimitiveType")) {
      return type;
    }
    SNode cType = ClassifierTypeUtil.coerceToClassifierTypeIgnoreParameters(type);
    if ((cType != null)) {
      List<SNode> params = SLinkOperations.getTargets(cType, "parameter", true);
      if (params != null && ListSequence.fromList(params).count() > 0) {
        SNode res = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
        SLinkOperations.setTarget(res, "classifier", SLinkOperations.getTarget(cType, "classifier", false), false);
        for (SNode p : params) {
          ListSequence.fromList(SLinkOperations.getTargets(res, "parameter", true)).addElement(SNodeOperations.copyNode(getTypeCoercedToClassifierType(p)));
        }
        return res;
      }
      return cType;
    }
    return type;
  }

  public static boolean isFunctionTypeClassifier(SNode classifier) {
    return SNodeOperations.isInstanceOf(classifier, "jetbrains.mps.baseLanguage.structure.Interface") && SNodeOperations.getModel(classifier) == SNodeOperations.getModel(SLinkOperations.getTarget(new ClassifierTypeUtil.QuotationClass_zgotlq_a0a0a0a0d().createNode(), "classifier", false));
  }

  public static boolean isFunctionTypeClassifierReturningValue(SNode classifier) {
    if (isFunctionTypeClassifier(classifier)) {
      String cname = SPropertyOperations.getString(classifier, "name");
      int ldi = cname.lastIndexOf(".");
      cname = (ldi >= 0 ?
        cname.substring(ldi + 1) :
        cname
      );
      return !(cname.startsWith("_void"));
    }
    return false;
  }

  public static SNode resolveTypeUsingSupertypes(SNode type, SNode concrete) {
    List<SNode> visitedClassifiers = ListSequence.fromList(new ArrayList<SNode>());
    List<SNode> concretes = ListSequence.fromList(new LinkedList<SNode>());
    ListSequence.fromList(concretes).addElement(concrete);
    SNode resType = type;
    while (!(ListSequence.fromList(concretes).isEmpty())) {
      SNode ct = SNodeOperations.as(ListSequence.fromList(concretes).removeElementAt(0), "jetbrains.mps.baseLanguage.structure.ClassifierType");
      if (ListSequence.fromList(visitedClassifiers).contains(SLinkOperations.getTarget(ct, "classifier", false)) || ListSequence.fromList(SLinkOperations.getTargets(ct, "parameter", true)).count() == 0) {
        continue;
      }
      ListSequence.fromList(visitedClassifiers).addElement(SLinkOperations.getTarget(ct, "classifier", false));
      for (SNode sup : TypeChecker.getInstance().getSubtypingManager().collectImmediateSupertypes(ct)) {
        {
          IMatchingPattern pattern_zgotlq_a0d0e0f = HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType");
          SNode coercedNode_zgotlq_a0d0e0f = TypeChecker.getInstance().getRuntimeSupport().coerce_(sup, pattern_zgotlq_a0d0e0f);
          if (coercedNode_zgotlq_a0d0e0f != null) {
            ListSequence.fromList(concretes).addElement(coercedNode_zgotlq_a0d0e0f);
          } else {
          }
        }
      }
      resType = resolveType(resType, ct);
      if (ListSequence.fromList(SNodeOperations.getDescendants(resType, "jetbrains.mps.baseLanguage.structure.TypeVariableReference", false, new String[]{})).isEmpty()) {
        break;
      }
    }
    return resType;
  }

  public static SNode resolveType(SNode type, SNode concrete) {
    List<SNode> ptypes = SLinkOperations.getTargets(concrete, "parameter", true);
    List<SNode> vars = SLinkOperations.getTargets(SLinkOperations.getTarget(concrete, "classifier", false), "typeVariableDeclaration", true);
    return resolveType(SNodeOperations.copyNode(type), ptypes, vars);
  }

  public static SNode resolveType(SNode type, List<SNode> actTypes, List<SNode> vars) {
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.TypeVariableReference") && ListSequence.fromList(actTypes).count() > 0) {
      int idx = 0;
      for (SNode tvd : vars) {
        if (tvd == SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.TypeVariableReference"), "typeVariableDeclaration", false) && idx < ListSequence.fromList(actTypes).count()) {
          return SNodeOperations.copyNode(getTypeCoercedToClassifierType(ListSequence.fromList(actTypes).getElement(idx)));
        }
        idx++;
      }
    } else
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      for (SNode pt : SLinkOperations.getTargets(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "parameter", true)) {
        SNode rt = resolveType(pt, actTypes, vars);
        if (pt != rt) {
          SNodeOperations.replaceWithAnother(pt, rt);
        }
      }
    }
    return type;
  }

  public static SNode copyTypeRecursively(SNode type, boolean covariant) {
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      SNode copy = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
      SLinkOperations.setTarget(copy, "classifier", SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false), false);
      boolean covariantParam = isFunctionTypeClassifierReturningValue(SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false));
      for (SNode pt : SLinkOperations.getTargets(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "parameter", true)) {
        ListSequence.fromList(SLinkOperations.getTargets(copy, "parameter", true)).addElement((isFunctionTypeClassifier(SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false)) ?
          copyTypeRecursively(pt, covariantParam) :
          copyTypeRecursively(pt)
        ));
        covariantParam = false;
      }
      if (covariant) {
        return (SNodeOperations.isInstanceOf(copy, "jetbrains.mps.baseLanguage.structure.UpperBoundType") ?
          copy :
          new ClassifierTypeUtil.QuotationClass_zgotlq_a0a0a4a0a8().createNode(copy)
        );
      } else {
        return (SNodeOperations.isInstanceOf(copy, "jetbrains.mps.baseLanguage.structure.LowerBoundType") ?
          copy :
          new ClassifierTypeUtil.QuotationClass_zgotlq_a0a0a0e0a0i().createNode(copy)
        );
      }
    } else if (covariant) {
      return (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.UpperBoundType") ?
        SNodeOperations.copyNode(type) :
        new ClassifierTypeUtil.QuotationClass_zgotlq_a0a0a0a0i().createNode(SNodeOperations.copyNode(type))
      );
    } else {
      return (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.LowerBoundType") ?
        SNodeOperations.copyNode(type) :
        new ClassifierTypeUtil.QuotationClass_zgotlq_a0a0a0a0i_0().createNode(SNodeOperations.copyNode(type))
      );
    }
  }

  public static SNode copyTypeRecursively(SNode type) {
    type = (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.UpperBoundType") ?
      SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.UpperBoundType"), "bound", true) :
      type
    );
    type = (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.LowerBoundType") ?
      SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.LowerBoundType"), "bound", true) :
      type
    );
    if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ClassifierType")) {
      SNode copy = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ClassifierType", null);
      SLinkOperations.setTarget(copy, "classifier", SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false), false);
      for (SNode pt : SLinkOperations.getTargets(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType"), "parameter", true)) {
        ListSequence.fromList(SLinkOperations.getTargets(copy, "parameter", true)).addElement(copyTypeRecursively(pt));
      }
      return copy;
    } else if (SNodeOperations.isInstanceOf(type, "jetbrains.mps.lang.typesystem.structure.MeetType")) {
      SNode copy = SConceptOperations.createNewNode("jetbrains.mps.lang.typesystem.structure.MeetType", null);
      for (SNode arg : SLinkOperations.getTargets(SNodeOperations.cast(type, "jetbrains.mps.lang.typesystem.structure.MeetType"), "argument", true)) {
        ListSequence.fromList(SLinkOperations.getTargets(copy, "argument", true)).addElement(copyTypeRecursively(SNodeOperations.cast(arg, "jetbrains.mps.baseLanguage.structure.Type")));
      }
      return copy;
    } else {
      return SNodeOperations.copyNode(type);
    }
  }

  private static SNode coerceToClassifierTypeIgnoreParameters(SNode type) {
    SNode cType = (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ClassifierType") ?
      SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ClassifierType") :
      null
    );
    if ((cType == null)) {
      SNode cts = TypeChecker.getInstance().getRuntimeSupport().coerce_(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), false);
      if ((cts != null)) {
        cType = cts;
      } else {
        cType = TypeChecker.getInstance().getRuntimeSupport().coerce_(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
      }
    }
    return cType;
  }

  public static class QuotationClass_zgotlq_a0a0f0a {
    public QuotationClass_zgotlq_a0a0f0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_zgotlq_a0a0a0a0d {
    public QuotationClass_zgotlq_a0a0a0a0d() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#4c6a28d1-2c60-478d-b36e-db9b3cbb21fb#jetbrains.mps.baseLanguage.closures.runtime(closures.runtime/jetbrains.mps.baseLanguage.closures.runtime@java_stub)"), SNodeId.fromString("~FunctionTypes")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_zgotlq_a0a0a4a0a8 {
    public QuotationClass_zgotlq_a0a0a4a0a8() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.UpperBoundType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("bound", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_zgotlq_a0a0a0e0a0i {
    public QuotationClass_zgotlq_a0a0a0e0a0i() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LowerBoundType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("bound", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_zgotlq_a0a0a0a0i {
    public QuotationClass_zgotlq_a0a0a0a0i() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.UpperBoundType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("bound", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }

  public static class QuotationClass_zgotlq_a0a0a0a0i_0 {
    public QuotationClass_zgotlq_a0a0a0a0i_0() {
    }

    public SNode createNode(Object parameter_5) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LowerBoundType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_3 = quotedNode_1;
        {
          quotedNode_2 = (SNode) parameter_5;
          SNode quotedNode1_4;
          if (_parameterValues_129834374.contains(quotedNode_2)) {
            quotedNode1_4 = HUtil.copyIfNecessary(quotedNode_2);
          } else {
            _parameterValues_129834374.add(quotedNode_2);
            quotedNode1_4 = quotedNode_2;
          }
          if (quotedNode1_4 != null) {
            quotedNode_1.addChild("bound", HUtil.copyIfNecessary(quotedNode1_4));
          }
        }
        result = quotedNode1_3;
      }
      return result;
    }
  }
}
