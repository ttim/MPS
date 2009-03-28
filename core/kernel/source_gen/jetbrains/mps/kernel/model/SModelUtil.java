package jetbrains.mps.kernel.model;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.smodel.SNode;
import java.util.HashMap;
import jetbrains.mps.smodel.Language;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.nodeEditor.NodeReadAccessCaster;
import com.intellij.openapi.util.Computable;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.smodel.search.ConceptAndSuperConceptsScope;
import jetbrains.mps.smodel.LanguageHierarchyCache;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.structure.structure.Cardinality;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;

public class SModelUtil {
  private static Map<String, SNode> myFQNameToConcepDecl = new HashMap<String, SNode>();
  private static Map<SNode, Language> myConceptToLanguage = new HashMap<SNode, Language>();
  protected static Log log = LogFactory.getLog(SModelUtil.class);

  public static void invalidateCaches() {
    myFQNameToConcepDecl.clear();
    myConceptToLanguage.clear();
  }

  public static SNode findNodeByFQName(String nodeFQName, SNode concept, IScope scope) {
    String modelName = NameUtil.namespaceFromLongName(nodeFQName);
    String name = NameUtil.shortNameFromLongName(nodeFQName);
    for(SModelDescriptor descriptor : ListSequence.fromList(scope.getModelDescriptors())) {
      if (!(modelName.equals(descriptor.getLongName()))) {
        continue;
      }
      SModel model = descriptor.getSModel();
      for(SNode root : ListSequence.fromList(SModelOperations.getRoots(model, null))) {
        if (name.equals(root.getName()) && SNodeOperations.isInstanceOf(root, NameUtil.nodeFQName(concept))) {
          return root;
        }
      }
    }
    if (log.isWarnEnabled()) {
      log.warn("couldn't find node by fqname: " + nodeFQName);
    }
    return null;
  }

  public static SNode findConceptDeclaration(final String conceptFQName, final IScope scope) {
    SNode cd = myFQNameToConcepDecl.get(conceptFQName);
    if (cd != null) {
      return cd;
    }
    if (conceptFQName.equals("jetbrains.mps.smodel.structure.ModelPersistence$UnknownSNode")) {
      return null;
    }
    return NodeReadAccessCaster.runReadTransparentAction(new Computable <SNode>() {

      public SNode compute() {
        String languageNamespace = NameUtil.namespaceFromConceptFQName(conceptFQName);
        Language language = scope.getLanguage(languageNamespace);
        if (language == null) {
          return null;
        }
        String conceptName = NameUtil.shortNameFromLongName(conceptFQName);
        AbstractConceptDeclaration resultAdapter = language.findConceptDeclaration(conceptName);
        SNode result = (resultAdapter == null ?
          null :
          ((SNode)resultAdapter.getNode())
        );
        myFQNameToConcepDecl.put(conceptFQName, result);
        return result;
      }
    });
  }

  public static SNode getConceptLinkTarget(SNode link) {
    if (SNodeOperations.isInstanceOf(link, "jetbrains.mps.lang.structure.structure.ReferenceConceptLink")) {
      return SLinkOperations.getTarget(((SNode)link), "target", false);
    }
    return SLinkOperations.getTarget(((SNode)link), "target", true);
  }

  public static SNode getBaseConcept() {
    return SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept");
  }

  public static Language getDeclaringLanguage(SNode concept, @NotNull() IScope scope) {
    Language l = myConceptToLanguage.get(concept);
    if (l != null) {
      return l;
    }
    String languageNamespace = NameUtil.namespaceFromConcept(((AbstractConceptDeclaration)SNodeOperations.getAdapter(concept)));
    if (languageNamespace == null) {
      return null;
    }
    l = scope.getLanguage(languageNamespace);
    if (l != null) {
      myConceptToLanguage.put(concept, l);
    }
    return l;
  }

  public static SNode getGenuineLinkDeclaration(SNode linkDeclaration) {
    while (linkDeclaration != null && SLinkOperations.getTarget(linkDeclaration, "specializedLink", false) != null) {
      linkDeclaration = SLinkOperations.getTarget(linkDeclaration, "specializedLink", false);
    }
    return linkDeclaration;
  }

  public static String getGenuineLinkRole(SNode linkDecl) {
    SNode genLinkDecl = getGenuineLinkDeclaration(linkDecl);
    if (genLinkDecl == null) {
      return null;
    }
    return SPropertyOperations.getString(genLinkDecl, "role");
  }

  public static List<SNode> getDirectSuperInterfacesAndTheirSupers(SNode concept) {
    Set<SNode> result = SetSequence.<SNode>fromArray();
    for(SNode superConcept : ListSequence.fromList(getDirectSuperConcepts(concept))) {
      if (SNodeOperations.isInstanceOf(superConcept, "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration") && !(SetSequence.fromSet(result).contains(superConcept))) {
        for(AbstractConceptDeclaration adapter : ListSequence.fromList(new ConceptAndSuperConceptsScope(((AbstractConceptDeclaration)SNodeOperations.getAdapter(superConcept))).getConcepts())) {
          SetSequence.fromSet(result).addElement(adapter.getNode());
        }
      }
    }
    return ListSequence.fromList(ListSequence.<SNode>fromArray()).addSequence(SetSequence.fromSet(result));
  }

  public static List<SNode> getDirectSuperConcepts(SNode concept) {
    List<SNode> result = ListSequence.<SNode>fromArray();
    if (SNodeOperations.isInstanceOf(concept, "jetbrains.mps.lang.structure.structure.ConceptDeclaration")) {
      SNode conceptDecl = (SNode)concept;
      SNode extended = SLinkOperations.getTarget(conceptDecl, "extends", false);
      if (extended != null) {
        ListSequence.fromList(result).addElement(extended);
      }
      for(SNode ref : ListSequence.fromList(SLinkOperations.getTargets(conceptDecl, "implements", true))) {
        if (SLinkOperations.getTarget(ref, "intfc", false) != null) {
          ListSequence.fromList(result).addElement(SLinkOperations.getTarget(ref, "intfc", false));
        }
      }
    } else
    {
      SNode intConceptDecl = (SNode)concept;
      for(SNode ref : ListSequence.fromList(SLinkOperations.getTargets(intConceptDecl, "extends", true))) {
        if (SLinkOperations.getTarget(ref, "intfc", false) != null) {
          ListSequence.fromList(result).addElement(SLinkOperations.getTarget(ref, "intfc", false));
        }
      }
    }
    return result;
  }

  public static boolean isAssignableConcept(SNode from, SNode to) {
    if (from == to) {
      return true;
    }
    if (from == null || to == null) {
      return false;
    }
    if (to == SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept")) {
      return true;
    }
    return LanguageHierarchyCache.getInstance().getAncestorsNames(INamedConcept_Behavior.call_getFqName_1213877404258(from)).contains(INamedConcept_Behavior.call_getFqName_1213877404258(to));
  }

  public static Cardinality getGenuineLinkSourceCardinality(SNode linkDecl) {
    return ((LinkDeclaration)SNodeOperations.getAdapter(getGenuineLinkDeclaration(linkDecl))).getSourceCardinality();
  }

  public static SNode findEditorDeclaration(SModel editorModel, SNode concept) {
    for(SNode root : ListSequence.fromList(SModelOperations.getRoots(editorModel, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration"))) {
      if (concept == SLinkOperations.getTarget(root, "conceptDeclaration", false)) {
        return root;
      }
    }
    return null;
  }

  public static SNode findBehaviorDeclaration(SModel behaviorModel, SNode concept) {
    for(SNode root : ListSequence.fromList(SModelOperations.getRoots(behaviorModel, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"))) {
      if (concept == SLinkOperations.getTarget(root, "concept", false)) {
        return root;
      }
    }
    return null;
  }

  public static SNode findConstraintsDeclaration(SModel constraintsModel, SNode concept) {
    for(SNode root : ListSequence.fromList(SModelOperations.getRoots(constraintsModel, "jetbrains.mps.lang.constraints.structure.ConceptConstraints"))) {
      if (concept == SLinkOperations.getTarget(root, "concept", false)) {
        return root;
      }
    }
    return null;
  }

  public static SNode findDataFlowDeclaration(SModel dataFlowModel, SNode concept) {
    for(SNode root : ListSequence.fromList(SModelOperations.getRoots(dataFlowModel, "jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration"))) {
      if (concept == SLinkOperations.getTarget(root, "conceptDeclaration", false)) {
        return root;
      }
    }
    return null;
  }

}
