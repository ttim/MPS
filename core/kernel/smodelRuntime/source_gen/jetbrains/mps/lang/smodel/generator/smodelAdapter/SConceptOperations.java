package jetbrains.mps.lang.smodel.generator.smodelAdapter;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.kernel.model.SModelUtil;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.GlobalScope;
import java.util.List;
import jetbrains.mps.smodel.SNodeUtil;
import java.util.Collections;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import java.util.Set;
import jetbrains.mps.smodel.LanguageHierarchyCache;
import jetbrains.mps.smodel.Language;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.project.AuxilaryRuntimeModel;

public final class SConceptOperations {
  private SConceptOperations() {
  }

  public static boolean isExactly(SNode conceptDeclarationNode, String conceptFqName) {
    if (conceptDeclarationNode == null) {
      return false;
    }
    return NameUtil.nodeFQName(conceptDeclarationNode).equals(conceptFqName);
  }

  @Deprecated
  public static boolean isAssignableFrom(SNode conceptDeclarationNode, SNode fromConceptDeclarationNode) {
    if (conceptDeclarationNode == null || fromConceptDeclarationNode == null) {
      return false;
    }
    return SModelUtil.isAssignableConcept(NameUtil.nodeFQName(fromConceptDeclarationNode), NameUtil.nodeFQName(conceptDeclarationNode));
  }

  public static boolean isSuperConceptOf(SNode superConcept, String subConceptFQName) {
    if (superConcept == null) {
      return false;
    }
    String superConceptFQName = NameUtil.nodeFQName(superConcept);
    return SModelUtil.isAssignableConcept(subConceptFQName, superConceptFQName);
  }

  public static boolean isSubConceptOf(SNode subConcept, String superConceptFQName) {
    if (subConcept == null) {
      return false;
    }
    String subConceptFQName = NameUtil.nodeFQName(subConcept);
    return SModelUtil.isAssignableConcept(subConceptFQName, superConceptFQName);
  }

  public static SNode findConceptDeclaration(@NotNull String conceptFqName) {
    return SModelUtil.findConceptDeclaration(conceptFqName, GlobalScope.getInstance());
  }

  @Deprecated
  public static List<SNode> getDirectSuperConcepts(SNode conceptDeclarationNode) {
    return getDirectSuperConcepts(conceptDeclarationNode, false);
  }

  public static List<SNode> getDirectSuperConcepts(SNode conceptDeclarationNode, boolean inclusion) {
    if (conceptDeclarationNode == null || !(SNodeUtil.isInstanceOfAbstractConceptDeclaration(conceptDeclarationNode))) {
      return Collections.emptyList();
    }
    List<SNode> result = (List<SNode>) SModelUtil.getDirectSuperConcepts((SNode) conceptDeclarationNode);
    if (inclusion) {
      result = new ArrayList<SNode>(result);
      result.add(0, conceptDeclarationNode);
    }
    return Collections.unmodifiableList(result);
  }

  @Deprecated
  public static List<SNode> getAllSuperConcepts(SNode conceptDeclarationNode) {
    return getAllSuperConcepts(conceptDeclarationNode, false);
  }

  public static List<SNode> getAllSuperConcepts(SNode conceptDeclarationNode, boolean inclusion) {
    if (conceptDeclarationNode == null) {
      return new ArrayList<SNode>();
    }
    List<SNode> result = SModelUtil_new.getConceptAndSuperConcepts(conceptDeclarationNode);
    if (!(inclusion)) {
      result = new ArrayList<SNode>(result);
      result.remove(conceptDeclarationNode);
    }
    return result;
  }

  public static List<SNode> getConceptHierarchy(SNode conceptDeclarationNode) {
    if (conceptDeclarationNode == null) {
      return new ArrayList<SNode>();
    }
    return SModelUtil_new.getConceptAndSuperConcepts(conceptDeclarationNode);
  }

  public static List<SNode> getAllSubConcepts(SNode conceptDeclarationNode, SModel model, IScope scope) {
    if (conceptDeclarationNode == null) {
      return new ArrayList<SNode>();
    }
    Set<String> descendants = LanguageHierarchyCache.getInstance().getAllDescendantsOfConcept(NameUtil.nodeFQName(conceptDeclarationNode));
    Set<Language> availableLanguages = new HashSet<Language>(SModelOperations.getLanguages(model, scope));
    List<SNode> result = new ArrayList<SNode>();
    for (String descendant : descendants) {
      SNode declaration = SModelUtil.findConceptDeclaration(descendant, GlobalScope.getInstance());
      Language lang = SModelUtil.getDeclaringLanguage(declaration);
      if (availableLanguages.contains(lang)) {
        result.add(declaration);
      }
    }
    return result;
  }

  public static List<SNode> findConceptInstances(SNode conceptDeclarationNode, IScope scope) {
    if (conceptDeclarationNode == null) {
      return new ArrayList<SNode>();
    }
    if (scope == null) {
      scope = GlobalScope.getInstance();
    }
    return FindUsagesManager.getInstance().findInstances(conceptDeclarationNode, scope);
  }

  public static SNode createNewNode(String conceptFqName) {
    return jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.createNewNode(AuxilaryRuntimeModel.getDescriptor().getSModel(), conceptFqName);
  }

  @Deprecated
  public static SNode createNewNode(String conceptFqName, SNode prototypeNode) {
    return jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations.createNewNode(AuxilaryRuntimeModel.getDescriptor().getSModel(), conceptFqName);
  }
}
