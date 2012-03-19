package jetbrains.mps.ide.actions.nodes;

/*Generated by MPS */

import java.awt.Frame;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.openapi.navigation.NavigationSupport;
import jetbrains.mps.smodel.Language;
import java.util.ArrayList;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.util.Condition;
import jetbrains.mps.util.ConditionalIterable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.kernel.model.SModelUtil;
import javax.swing.JPopupMenu;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;
import jetbrains.mps.ide.icons.IconManager;
import java.awt.event.ActionEvent;

public class GoToRulesHelper {
  public GoToRulesHelper() {
  }

  public static void go(Frame frame, EditorCell cell, IOperationContext context, SNode concept) {
    List<SNode> rules = getRules(concept, false);
    if (rules.size() == 1) {
      SNode nodeToSelect = rules.get(0);
      if ((nodeToSelect != null)) {
        NavigationSupport.getInstance().openNode(context, nodeToSelect, true, !(nodeToSelect.isRoot()));
      }
      return;
    }
    GoToRulesHelper.MyMenu m = new GoToRulesHelper.MyMenu(rules, context);
    int x = 0;
    int y = 0;
    if (cell != null) {
      x = cell.getX();
      y = cell.getY();
    }
    m.show(frame, x, y);
  }

  public static List<SNode> getRules(final SNode conceptDeclaration, final boolean exactConcept) {
    Language language = getDeclaringLanguage(conceptDeclaration);
    List<SNode> rules = new ArrayList<SNode>();
    List<SNode> overriding = new ArrayList<SNode>();
    if (language != null && LanguageAspect.TYPESYSTEM.get(language) != null) {
      SModelDescriptor helginsDescriptor = LanguageAspect.TYPESYSTEM.get(language);
      if (helginsDescriptor != null) {
        Condition<SNode> cond = new Condition<SNode>() {
          public boolean met(SNode n) {
            return GoToRulesHelper.isApplicable(n, conceptDeclaration, false);
          }
        };
        Iterable<SNode> iter = new ConditionalIterable<SNode>(helginsDescriptor.getSModel().roots(), cond);
        for (SNode node : iter) {
          rules.add(node);
          SNode inferenceRule = SNodeOperations.as(node, "jetbrains.mps.lang.typesystem.structure.InferenceRule");
          if ((inferenceRule != null) && SPropertyOperations.getBoolean(inferenceRule, "overrides")) {
            overriding.add(inferenceRule);
          }
        }
      }
    }
    for (SNode overridingRule : overriding) {
      SNode subConcept = getApplicableConcept(SLinkOperations.getTarget(overridingRule, "applicableNode", true));
      for (SNode ruleNode : new ArrayList<SNode>(rules)) {
        if (SNodeOperations.getConceptDeclaration(ruleNode) == SNodeOperations.getConceptDeclaration(overridingRule) && isApplicable(ruleNode, subConcept, true)) {
          rules.remove(ruleNode);
        }
      }
    }
    return rules;
  }

  private static Language getDeclaringLanguage(SNode concept) {
    String languageFqName = NameUtil.namespaceFromConceptFQName(NameUtil.nodeFQName(concept));
    if (languageFqName == null) {
      return null;
    }
    return ModuleRepositoryFacade.getInstance().getModule(languageFqName, Language.class);
  }

  private static boolean isApplicable(SNode ruleNode, SNode conceptDeclaration, boolean skipExact) {
    SNode rule = SNodeOperations.as(ruleNode, "jetbrains.mps.lang.typesystem.structure.AbstractRule");
    if ((rule == null) || (conceptDeclaration == null)) {
      return false;
    }
    SNode applicableConcept = getApplicableConcept(SLinkOperations.getTarget(rule, "applicableNode", true));
    if (applicableConcept == null) {
      return false;
    }
    if (skipExact && conceptDeclaration == applicableConcept) {
      return false;
    }
    return SModelUtil.isAssignableConcept(conceptDeclaration, applicableConcept);
  }

  private static SNode getApplicableConcept(SNode applicableNode) {
    if (SNodeOperations.isInstanceOf(applicableNode, "jetbrains.mps.lang.typesystem.structure.ConceptReference")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(applicableNode, "jetbrains.mps.lang.typesystem.structure.ConceptReference"), "concept", false);
    } else
    if (SNodeOperations.isInstanceOf(applicableNode, "jetbrains.mps.lang.typesystem.structure.PatternCondition")) {
      return SNodeOperations.getConceptDeclaration(SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.cast(applicableNode, "jetbrains.mps.lang.typesystem.structure.PatternCondition"), "pattern", true), "patternNode", true));
    } else {
      return null;
    }
  }

  private static class MyMenu extends JPopupMenu {
    public MyMenu(List<SNode> list, final IOperationContext operationContext) {
      setBackground(Color.WHITE);
      String caption = (list.isEmpty() ?
        "No Rules" :
        "Rules :"
      );
      JLabel label = new JLabel(caption, SwingConstants.CENTER);
      label.setBorder(new EmptyBorder(0, 20, 0, 0));
      label.setBackground(Color.LIGHT_GRAY);
      add(label);
      for (final SNode node : list) {
        if (node == null) {
          continue;
        }
        String nodeName = node.getName();
        if (nodeName == null || nodeName.equals("")) {
          nodeName = node.getConceptShortName();
        }
        add(new AbstractAction(nodeName + " (" + node.getModel() + ")") {
          {
            putValue(Action.SMALL_ICON, IconManager.getIconFor(node));
          }

          public void actionPerformed(ActionEvent e) {
            NavigationSupport.getInstance().openNode(operationContext, node, true, !(node.isRoot()));
          }
        }).setBackground(Color.WHITE);
      }
    }
  }
}
