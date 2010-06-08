package jetbrains.mps.uiLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tabbedEditor.BaseTabbedEditor;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.plugins.pluginparts.tabbedEditor.BaseSingleTab;
import jetbrains.mps.ide.tabbedEditor.TabbedEditor;
import jetbrains.mps.uiLanguage.behavior.ComponentDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;

public class ComponentEditor_TabbedEditor extends BaseTabbedEditor {
  public ComponentEditor_TabbedEditor(IOperationContext operationContext, SNode node) {
    super(operationContext, node);
    this.addTab(new ComponentEditor_TabbedEditor.Component_Tab(this, node), null);
    this.addTab(new ComponentEditor_TabbedEditor.Controller_Tab(this, node), null);
  }

  public static class Component_Tab extends BaseSingleTab {
    public Component_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
    }

    public String getTitle() {
      return "Component";
    }

    public String getNullText() {
      return "";
    }

    public SNode getNode(SNode node) {
      return node;
    }

    public boolean canCreate() {
      return false;
    }

    public SNode createNode(final SNode node) {
      throw new IllegalArgumentException();
    }
  }

  public static class Controller_Tab extends BaseSingleTab {
    public Controller_Tab(TabbedEditor tabbedEditor, SNode baseNode) {
      super(tabbedEditor, baseNode);
    }

    public String getTitle() {
      return "Controller";
    }

    public String getNullText() {
      return "No Controller";
    }

    public SNode getNode(SNode node) {
      return ComponentDeclaration_Behavior.call_getController_1213877495364(node);
    }

    public boolean canCreate() {
      return true;
    }

    public SNode createNode(final SNode node) {
      SNode controller = SConceptOperations.createNewNode("jetbrains.mps.uiLanguage.structure.ComponentController", null);
      SLinkOperations.setTarget(controller, "component", node, false);
      SModelOperations.addRootNode(SNodeOperations.getModel(node), controller);
      String virtualPackage = node.getProperty(SModelTreeNode.PACK);
      controller.setProperty(SModelTreeNode.PACK, virtualPackage);
      return controller;
    }
  }
}
