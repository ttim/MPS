package jetbrains.mps.lang.generator.editor;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.AttributesRolesUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.nodeEditor.cells.PropertyAccessor;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.lang.structure.behavior.LinkDeclaration_Behavior;

public class QueriesUtil {

  public static boolean isNodeMacroApplicable(SNode node) {
    return isAnyMacroApplicable(node);
  }

  public static boolean isPropertyMacroApplicable(SNode node, EditorCell cell) {
    if (!(isAnyMacroApplicable(node))) {
      return false;
    }
    // -----
    // it can be 'ref.cell->{name}'. in this case both are 'applicable'. but link has priority
    String linkRole = QueriesUtil.getEditedLinkRole(cell);
    if (linkRole != null) {
      return false;
    }
    String propertyName = QueriesUtil.getEditedPropertyName(cell);
    if (propertyName == null) {
      return false;
    }
    return SLinkOperations.getTarget(node, AttributesRolesUtil.childRoleFromPropertyAttributeRole("propertyMacro", propertyName), true) == null;
  }

  public static boolean isReferenceMacroApplicable(SNode node, EditorCell cell) {
    if (!(isAnyMacroApplicable(node))) {
      return false;
    }
    String linkRole = QueriesUtil.getEditedLinkRole(cell);
    if (linkRole == null) {
      return false;
    }
    SNode referentNode = QueriesUtil.getEditedLinkReferentNode(cell);
    return SLinkOperations.getTarget(referentNode, AttributesRolesUtil.childRoleFromLinkAttributeRole("referenceMacro", linkRole), true) == null;
  }

  private static boolean isAnyMacroApplicable(SNode node) {
    //  not inside any kind of macro (code shown in inspector) but OK on a macro node itself
    if (SNodeOperations.getAncestorWhereConceptInList(node, new String[]{"jetbrains.mps.lang.generator.structure.NodeMacro","jetbrains.mps.lang.generator.structure.PropertyMacro","jetbrains.mps.lang.generator.structure.ReferenceMacro"}, false, false) != null) {
      return false;
    }
    // not inside 'root template annotation'
    if (SNodeOperations.getAncestor(node, "jetbrains.mps.lang.generator.structure.RootTemplateAnnotation", true, false) != null) {
      return false;
    }
    // inside 'root template'
    if (SLinkOperations.getTarget(SNodeOperations.getContainingRoot(node), AttributesRolesUtil.childRoleFromAttributeRole("rootTemplateAnnotation"), true) != null) {
      return true;
    }
    //  inside template declaration 
    if (SNodeOperations.getAncestorWhereConceptInList(node, new String[]{"jetbrains.mps.lang.generator.structure.TemplateDeclaration","jetbrains.mps.lang.generator.structure.InlineTemplate_RuleConsequence"}, false, false) != null) {
      return true;
    }
    return false;
  }

  public static SNode addNodeMacro(SNode node) {
    // do not hang $$ on other attributes
    SNode applyToNode = ListSequence.fromList(SNodeOperations.getAncestors(node, null, true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return !(SNodeOperations.isAttribute(it));
      }

    }).first();
    // surround with <TF> if necessary
    if (SNodeOperations.getAncestor(applyToNode, "jetbrains.mps.lang.generator.structure.TemplateDeclaration", false, false) != null) {
      if (!(QueriesUtil.isInsideTemplateFragment(applyToNode))) {
        QueriesUtil.createTemplateFragment(applyToNode);
      }
    }
    if (SNodeOperations.getAncestor(node, "jetbrains.mps.lang.generator.structure.TemplateDeclaration", false, false) != null) {
    }
    SNode nodeMacro = SConceptOperations.createNewNode("jetbrains.mps.lang.generator.structure.NodeMacro", null);
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.generator.structure.NodeMacro") && ListSequence.fromList(SNodeOperations.getChildren(applyToNode)).contains(node)) {
      SNodeOperations.insertPrevSiblingChild(node, nodeMacro);
    } else
    {
      SLinkOperations.addChild(applyToNode, AttributesRolesUtil.childRoleFromAttributeRole("nodeMacro"), nodeMacro);
    }
    return nodeMacro;
  }

  public static SNode addPropertyMacro(SNode node, EditorCell cell) {
    // surround with <TF> if necessary
    if (SNodeOperations.getAncestor(node, "jetbrains.mps.lang.generator.structure.TemplateDeclaration", false, false) != null) {
      if (!(QueriesUtil.isInsideTemplateFragment(node))) {
        QueriesUtil.createTemplateFragment(node);
      }
    }
    String propertyName = QueriesUtil.getEditedPropertyName(cell);
    SNode propertyMacro = SLinkOperations.setNewChild(node, AttributesRolesUtil.childRoleFromPropertyAttributeRole("propertyMacro", propertyName), "jetbrains.mps.lang.generator.structure.PropertyMacro");
    return propertyMacro;
  }

  public static SNode addReferenceMacro(SNode node, EditorCell cell) {
    String linkRole = QueriesUtil.getEditedLinkRole(cell);
    SNode referentNode = QueriesUtil.getEditedLinkReferentNode(cell);
    // surround with <TF> if necessary
    if (SNodeOperations.getAncestor(referentNode, "jetbrains.mps.lang.generator.structure.TemplateDeclaration", false, false) != null) {
      if (!(QueriesUtil.isInsideTemplateFragment(referentNode))) {
        QueriesUtil.createTemplateFragment(referentNode);
      }
    }
    SNode referenceMacro = SLinkOperations.setNewChild(referentNode, AttributesRolesUtil.childRoleFromLinkAttributeRole("referenceMacro", linkRole), "jetbrains.mps.lang.generator.structure.ReferenceMacro");
    return referenceMacro;
  }

  public static boolean isInsideTemplateFragment(SNode node) {
    Iterable<SNode> ancestorTFs = ListSequence.fromList(SNodeOperations.getAncestors(node, null, true)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return SLinkOperations.getTarget(it, AttributesRolesUtil.childRoleFromAttributeRole("templateFragment"), true) != null;
      }

    });
    return Sequence.fromIterable(ancestorTFs).count() > 0;
  }

  public static void createTemplateFragment(final SNode node) {
    SLinkOperations.setNewChild(node, AttributesRolesUtil.childRoleFromAttributeRole("templateFragment"), "jetbrains.mps.lang.generator.structure.TemplateFragment");
    // remove subordinate template fragments
    Iterable<SNode> children = ListSequence.fromList(SNodeOperations.getChildren(node)).where(new IWhereFilter <SNode>() {

      public boolean accept(SNode it) {
        return !(SNodeOperations.isAttribute(it));
      }

    });
    for(SNode child : children) {
      ListSequence.fromList(SNodeOperations.getDescendants(child, "jetbrains.mps.lang.generator.structure.TemplateFragment", false)).visitAll(new IVisitor <SNode>() {

        public void visit(SNode it) {
          SNodeOperations.deleteNode(it);
        }

      });
    }
    // re append all macros to make them go 'after' the <TF>
    ListSequence.fromList(SLinkOperations.getTargets(node, AttributesRolesUtil.childRoleFromAttributeRole("nodeMacro"), true)).visitAll(new IVisitor <SNode>() {

      public void visit(SNode it) {
        SLinkOperations.addChild(node, AttributesRolesUtil.childRoleFromAttributeRole("nodeMacro"), it);
      }

    });
  }

  public static String getEditedPropertyName(EditorCell cell) {
    if (cell instanceof EditorCell_Property) {
      ModelAccessor modelAccessor = ((EditorCell_Property)cell).getModelAccessor();
      if (modelAccessor instanceof PropertyAccessor) {
        String propertyName = ((PropertyAccessor)modelAccessor).getPropertyName();
        return propertyName;
      }
    }
    return null;
  }

  public static String getEditedLinkRole(EditorCell cell) {
    LinkDeclaration linkDeclaration = cell.getLinkDeclaration();
    SNode referentNode = cell.getRefNode();
    if (referentNode == null || linkDeclaration == null) {
      return null;
    }
    SNode link = (SNode)BaseAdapter.fromAdapter(linkDeclaration);
    return LinkDeclaration_Behavior.call_getGenuineRole_1213877254542(link);
  }

  public static SNode getEditedLinkReferentNode(EditorCell cell) {
    return cell.getRefNode();
  }

}
