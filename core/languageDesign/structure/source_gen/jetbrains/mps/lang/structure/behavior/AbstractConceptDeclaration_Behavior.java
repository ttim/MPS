package jetbrains.mps.lang.structure.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.search.SModelSearchUtil;
import jetbrains.mps.util.IterableUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class AbstractConceptDeclaration_Behavior {
  private static Class[] PARAMETERS_1222430305282 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SModel call_getAspectModel_8360039740498072707(SNode thisNode, LanguageAspect aspect) {
    Language language = SModelUtil.getDeclaringLanguage(thisNode);
    if (language == null) {
      return null;
    }
    SModelDescriptor md = aspect.get(language);
    if (md == null) {
      return null;
    }
    return md.getSModel();
  }

  public static List<SNode> call_findConceptAspectCollection_1567570417158062208(SNode thisNode, LanguageAspect aspect) {
    List<SNode> result = new ArrayList<SNode>();
    SModel model = AbstractConceptDeclaration_Behavior.call_getAspectModel_8360039740498072707(thisNode, aspect);
    AbstractConceptDeclaration_Behavior.call_findConceptAspectCollection_8360039740498071686(thisNode, model, result);
    return result;
  }

  public static SNode call_findConceptAspect_8360039740498068384(SNode thisNode, LanguageAspect aspect) {
    SModel model = AbstractConceptDeclaration_Behavior.call_getAspectModel_8360039740498072707(thisNode, aspect);
    return AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498069412(thisNode, model);
  }

  public static SNode call_findConceptAspect_8360039740498069412(SNode thisNode, SModel model) {
    if (model == null) {
      return null;
    }
    for (SNode aspectConcept : SModelOperations.getRoots(model, "jetbrains.mps.lang.structure.structure.IConceptAspect")) {
      if ((IConceptAspect_Behavior.call_getBaseConcept_2621449412040133768(aspectConcept) != null) && IConceptAspect_Behavior.call_getBaseConcept_2621449412040133768(aspectConcept) == thisNode) {
        return aspectConcept;
      }
    }
    return null;
  }

  public static void call_findConceptAspectCollection_8360039740498071686(SNode thisNode, SModel model, List<SNode> collection) {
    if (model == null) {
      return;
    }
    for (SNode aspectConcept : SModelOperations.getRoots(model, "jetbrains.mps.lang.structure.structure.IConceptAspect")) {
      if (ListSequence.fromList(IConceptAspect_Behavior.call_getBaseConceptCollection_5270353093116013036(aspectConcept)).contains(thisNode)) {
        ListSequence.fromList(collection).addElement(aspectConcept);
      }
    }
  }

  public static List<SNode> call_findGeneratorFragments_6409339300305625383(final SNode thisNode) {
    Language language = SModelUtil.getDeclaringLanguage(thisNode);
    List<SNode> result = new ArrayList<SNode>();
    if (language == null) {
      return result;
    }
    for (Generator g : language.getGenerators()) {
      for (SModelDescriptor sd : g.getOwnTemplateModels()) {
        SModel m = sd.getSModel();
        for (SNode node : ListSequence.fromList(SModelOperations.getRoots(m, null))) {
          if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.generator.structure.TemplateDeclaration") && SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.generator.structure.TemplateDeclaration"), "applicableConcept", false) == thisNode || SLinkOperations.getTarget(SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromAttributeRole("rootTemplateAnnotation"), true), "applicableConcept", false) == thisNode) {
            ListSequence.fromList(result).addElement(node);
          }
          // generator rules 
          ListSequence.fromList(result).addSequence(ListSequence.fromList(SNodeOperations.getChildren(node)).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return SNodeOperations.isInstanceOf(it, "jetbrains.mps.lang.generator.structure.BaseMappingRule") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.lang.generator.structure.BaseMappingRule"), "applicableConcept", false) == thisNode || SNodeOperations.isInstanceOf(it, "jetbrains.mps.lang.generator.structure.DropRootRule") && SLinkOperations.getTarget(SNodeOperations.cast(it, "jetbrains.mps.lang.generator.structure.DropRootRule"), "applicableConcept", false) == thisNode;
            }
          }));
        }
      }
    }
    return result;
  }

  public static List<SNode> call_findAllAspects_7754459869734028917(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    for (LanguageAspect aspect : LanguageAspect.values()) {
      ListSequence.fromList(result).addElement(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(thisNode, aspect));
    }
    ListSequence.fromList(result).addSequence(ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_findGeneratorFragments_6409339300305625383(thisNode)));

    while (ListSequence.fromList(result).contains(null)) {
      ListSequence.fromList(result).removeElement(null);
    }

    return result;
  }

  public static List<SNode> call_getAvailableConceptMethods_1213877394200(SNode thisNode, SNode context) {
    List<SNode> methods = new ArrayList<SNode>();
    if (thisNode == null) {
      return methods;
    }
    SNode contextBehaviour = SNodeOperations.getAncestor(context, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false);
    for (SNode concept : SConceptOperations.getConceptHierarchy(thisNode)) {
      SNode behaviour = SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(concept, LanguageAspect.BEHAVIOR), "jetbrains.mps.lang.behavior.structure.ConceptBehavior");
      if (behaviour != null) {
        for (SNode method : SLinkOperations.getTargets(behaviour, "method", true)) {
          if (SLinkOperations.getTarget(method, "overriddenMethod", false) != null) {
            continue;
          }
          if (SLinkOperations.getTarget(method, "visibility", true) == null) {
            if (SNodeOperations.getModel(contextBehaviour) == SNodeOperations.getModel(method)) {
              ListSequence.fromList(methods).addElement(method);
            }
          }
          if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PrivateVisibility")) {
            if (SNodeOperations.getAncestor(method, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false) == contextBehaviour) {
              ListSequence.fromList(methods).addElement(method);
            }
          }
          if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.PublicVisibility")) {
            ListSequence.fromList(methods).addElement(method);
          }
          if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(method, "visibility", true), "jetbrains.mps.baseLanguage.structure.ProtectedVisibility")) {
            if (SConceptOperations.isSubConceptOf(SLinkOperations.getTarget(contextBehaviour, "concept", false), NameUtil.nodeFQName(SLinkOperations.getTarget(SNodeOperations.getAncestor(method, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false), "concept", false)))) {
              ListSequence.fromList(methods).addElement(method);
            }
          }
        }
      }
    }
    return methods;
  }

  public static List<SNode> call_getVirtualConceptMethods_1213877394290(SNode thisNode, IScope scope) {
    List<SNode> methods = new ArrayList<SNode>();
    for (SNode concept : SConceptOperations.getAllSuperConcepts(thisNode, false)) {
      SNode behaviour = SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(concept, LanguageAspect.BEHAVIOR), "jetbrains.mps.lang.behavior.structure.ConceptBehavior");
      if (behaviour != null) {
        for (SNode method : SLinkOperations.getTargets(behaviour, "method", true)) {
          if (SPropertyOperations.getBoolean(method, "isVirtual")) {
            ListSequence.fromList(methods).addElement(method);
          }
        }
      }
    }
    return methods;
  }

  public static List<SNode> call_getNotImplementedConceptMethods_1213877394339(SNode thisNode, IScope scope) {
    List<SNode> abstractMethods = new ArrayList<SNode>();
    List<SNode> implementedMethods = new ArrayList<SNode>();
    List<SNode> concepts = SConceptOperations.getAllSuperConcepts(thisNode, false);
    ListSequence.fromList(concepts).addElement(thisNode);
    for (SNode concept : concepts) {
      SNode behavior = SNodeOperations.cast(AbstractConceptDeclaration_Behavior.call_findConceptAspect_8360039740498068384(concept, LanguageAspect.BEHAVIOR), "jetbrains.mps.lang.behavior.structure.ConceptBehavior");
      for (SNode method : SLinkOperations.getTargets(behavior, "method", true)) {
        if (SPropertyOperations.getBoolean(method, "isAbstract")) {
          ListSequence.fromList(abstractMethods).addElement(method);
        }
        if (SLinkOperations.getTarget(method, "overriddenMethod", false) != null && !(SPropertyOperations.getBoolean(method, "isAbstract"))) {
          ListSequence.fromList(implementedMethods).addElement(SLinkOperations.getTarget(method, "overriddenMethod", false));
        }
      }
    }
    ListSequence.fromList(abstractMethods).removeSequence(ListSequence.fromList(implementedMethods));
    return abstractMethods;
  }

  public static SNode call_getAdapterType_1213877394418(SNode thisNode) {
    if (thisNode == null) {
      return new AbstractConceptDeclaration_Behavior.QuotationClass_8dqsla_a0a0a0l().createNode();
    }
    String adapterClassFqName = NameUtil.nodeFQName(thisNode);
    SNode classifier = SNodeOperations.cast(SModelUtil.findNodeByFQName(adapterClassFqName, SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.Classifier"), GlobalScope.getInstance()), "jetbrains.mps.baseLanguage.structure.Classifier");
    SNode adapterClassType = SModelOperations.createNewNode(SNodeOperations.getModel(new AbstractConceptDeclaration_Behavior.QuotationClass_8dqsla_a0a0a3a11().createNode()), "jetbrains.mps.baseLanguage.structure.ClassifierType", null);
    SLinkOperations.setTarget(adapterClassType, "classifier", classifier, false);
    return adapterClassType;
  }

  public static SNode call_findLinkDeclaration_1213877394467(SNode thisNode, String role) {
    return SNodeOperations.cast(SModelSearchUtil.findLinkDeclaration(thisNode, role), "jetbrains.mps.lang.structure.structure.LinkDeclaration");
  }

  public static List<SNode> call_getLinkDeclarations_1213877394480(SNode thisNode) {
    return (List<SNode>) SModelSearchUtil.getLinkDeclarations(thisNode);
  }

  public static List<SNode> call_getReferenceLinkDeclarations_1213877394496(SNode thisNode) {
    List<SNode> links = AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(thisNode);
    return ListSequence.fromList(links).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.hasValue(it, "metaClass", "reference", "reference");
      }
    }).toListSequence();
  }

  public static List<SNode> call_getAggregationLinkDeclarations_1213877394521(SNode thisNode) {
    List<SNode> links = AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(thisNode);
    return ListSequence.fromList(links).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.hasValue(it, "metaClass", "aggregation", "reference");
      }
    }).toListSequence();
  }

  public static List<SNode> call_getPropertyDeclarations_1213877394546(SNode thisNode) {
    List<SNode> properties = SModelSearchUtil.getPropertyDeclarations(thisNode);
    return (List<SNode>) properties;
  }

  public static SNode call_findPropertyDeclaration_1219835742593(SNode thisNode, String name) {
    SNode p = SModelSearchUtil.findPropertyDeclaration(thisNode, name);
    return SNodeOperations.cast(p, "jetbrains.mps.lang.structure.structure.PropertyDeclaration");
  }

  public static List<SNode> call_getConceptPropertyDeclarations_1213877394562(SNode thisNode) {
    return (List<SNode>) SModelSearchUtil.getConceptPropertyDeclarations(thisNode);
  }

  public static List<SNode> call_getConceptLinkDeclarations_1213877394578(SNode thisNode) {
    return (List<SNode>) IterableUtil.asList(SModelSearchUtil.getConceptLinkDeclarations(thisNode));
  }

  public static SNode call_specializeLink_4304720797559012132(SNode thisNode, SNode link, SNode targetConcept) {
    if (ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_getLinkDeclarations_1213877394480(thisNode)).contains(link) && !(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "linkDeclaration", true)).contains(link))) {
      for (SNode linkDeclarationOfMine : SLinkOperations.getTargets(thisNode, "linkDeclaration", true)) {
        if (SLinkOperations.getTarget(linkDeclarationOfMine, "specializedLink", false) == link) {
          return null;
        }
      }
      if (SConceptOperations.isSuperConceptOf(SLinkOperations.getTarget(link, "target", false), NameUtil.nodeFQName(targetConcept))) {
        SNode result = SLinkOperations.addNewChild(thisNode, "linkDeclaration", "jetbrains.mps.lang.structure.structure.LinkDeclaration");
        SLinkOperations.setTarget(result, "target", targetConcept, false);
        SLinkOperations.setTarget(result, "specializedLink", link, false);
        SPropertyOperations.set(result, "metaClass", SPropertyOperations.getString_def(link, "metaClass", "reference"));
        SPropertyOperations.set(result, "role", SPropertyOperations.getString(link, "role"));
        return result;
      }
    }
    return null;
  }

  public static boolean call_isDefaultSubstitutable_7429110134803670673(SNode thisNode) {
    return !(SConceptPropertyOperations.getBoolean(thisNode, "abstract")) && !(SConceptPropertyOperations.getBoolean(thisNode, "dontSubstituteByDefault"));
  }

  public static boolean call_isDefaultSubstitutableConcept_1213877394594(SNode thisNode, SNode expectedConcept, IScope scope) {
    if (AbstractConceptDeclaration_Behavior.call_isDefaultSubstitutable_7429110134803670673(thisNode)) {
      return SConceptOperations.isSuperConceptOf(expectedConcept, NameUtil.nodeFQName(thisNode));
    }
    return false;
  }

  public static List<SNode> call_getImmediateSuperconcepts_1222430305282(SNode thisNode) {
    return (List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), "virtual_getImmediateSuperconcepts_1222430305282", PARAMETERS_1222430305282);
  }

  public static List<SNode> callSuper_getImmediateSuperconcepts_1222430305282(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), callerConceptFqName, "virtual_getImmediateSuperconcepts_1222430305282", PARAMETERS_1222430305282);
  }

  public static class QuotationClass_8dqsla_a0a0a0l {
    public QuotationClass_8dqsla_a0a0a0l() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)"), SNodeId.fromString("~INodeAdapter")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_8dqsla_a0a0a3a11 {
    public QuotationClass_8dqsla_a0a0a3a11() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)"), SNodeId.fromString("~INodeAdapter")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
