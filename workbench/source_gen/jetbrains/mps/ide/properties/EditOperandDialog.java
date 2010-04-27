package jetbrains.mps.ide.properties;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_AbstractRef;
import javax.swing.JComponent;
import javax.swing.JTree;
import jetbrains.mps.smodel.Generator;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.MPSDataKeys;
import com.intellij.ide.DataManager;
import javax.swing.tree.DefaultMutableTreeNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.MPSModuleRepository;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;
import javax.swing.tree.TreePath;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.lang.generator.structure.MappingConfiguration;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.ide.dialogs.DialogDimensionsSettings;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefAllGlobal;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_ExternalRef;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefSet;
import java.util.Enumeration;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefAllLocal;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_SimpleRef;
import jetbrains.mps.smodel.SModelReference;
import java.util.ArrayList;
import com.intellij.openapi.util.Computable;

public class EditOperandDialog extends BaseDialog {
  private MappingConfig_AbstractRef myResult;
  private JComponent myMainComponent;
  private JTree myTree;

  public EditOperandDialog(final Generator currentGen, final List<ModuleReference> depGenerators, MappingConfig_AbstractRef operand, final boolean isLeft) {
    super(MPSDataKeys.FRAME.getData(DataManager.getInstance().getDataContext()), "Choose Mappings");
    final DefaultMutableTreeNode root = new DefaultMutableTreeNode(new MappingSelectTree.RootNodeData("All generators"));
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (isLeft) {
          EditOperandDialog.this.addGeneratorModels(currentGen, root);
        } else {
          EditOperandDialog.this.addGeneratorModels(currentGen, root);
          for (ModuleReference ref : depGenerators) {
            Generator gen = (Generator) MPSModuleRepository.getInstance().getModule(ref);
            if (gen != null) {
              EditOperandDialog.this.addGeneratorModels(gen, root);
            }
          }
        }
      }
    });
    this.setRootMappingRef(root, operand, isLeft);
    this.myTree = new MappingSelectTree(isLeft);
    this.myTree.setModel(new DefaultTreeModel(root, false));
    this.setCheckedUnder(root);
    this.expandCheckedUnder(this.myTree, root);
    this.myMainComponent = new JScrollPane(this.myTree);
  }

  public void expandCheckedUnder(JTree tree, DefaultMutableTreeNode node) {
    MappingSelectTree.NodeData nodeData = (MappingSelectTree.NodeData) node.getUserObject();
    if (nodeData.isChecksUnder()) {
      DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
      if (parent != null) {
        tree.expandPath(new TreePath(parent.getPath()));
      }
    }
    for (int i = 0; i < node.getChildCount(); i++) {
      this.expandCheckedUnder(tree, (DefaultMutableTreeNode) node.getChildAt(i));
    }
  }

  private void addGeneratorModels(Generator gen, DefaultMutableTreeNode root) {
    MappingSelectTree.GenRefNodeData genData = new MappingSelectTree.GenRefNodeData(gen.getModuleReference());
    DefaultMutableTreeNode genNode = new DefaultMutableTreeNode(genData);
    root.add(genNode);
    for (SModelDescriptor templateModel : gen.getOwnTemplateModels()) {
      MappingSelectTree.ModelRefNodeData modelData = new MappingSelectTree.ModelRefNodeData(templateModel.getSModelReference());
      DefaultMutableTreeNode modelNode = new DefaultMutableTreeNode(modelData);
      genNode.add(modelNode);
      for (MappingConfiguration mapping : templateModel.getSModel().getRootsAdapters(MappingConfiguration.class)) {
        SNodePointer np = new SNodePointer(mapping.getNode());
        MappingSelectTree.NodeRefNodeData nodeData = new MappingSelectTree.NodeRefNodeData(np);
        DefaultMutableTreeNode nodeNode = new DefaultMutableTreeNode(nodeData);
        modelNode.add(nodeNode);
      }
    }
  }

  protected JComponent getMainComponent() {
    return this.myMainComponent;
  }

  @Override
  public DialogDimensionsSettings.DialogDimensions getDefaultDimensionSettings() {
    return new DialogDimensionsSettings.DialogDimensions(100, 100, 400, 600);
  }

  public MappingConfig_AbstractRef getResult() {
    return this.myResult;
  }

  private void setRootMappingRef(DefaultMutableTreeNode root, MappingConfig_AbstractRef operand, boolean isLeft) {
    MappingSelectTree.NodeData rootData = (MappingSelectTree.NodeData) root.getUserObject();
    if (operand instanceof MappingConfig_RefAllGlobal) {
      if (isLeft) {
        for (int i = 0; i < root.getChildCount(); i++) {
          DefaultMutableTreeNode child = (DefaultMutableTreeNode) root.getChildAt(i);
          MappingSelectTree.NodeData childData = (MappingSelectTree.NodeData) child.getUserObject();
          childData.setSelected(true);
        }
      } else {
        rootData.setSelected(true);
      }
    } else
    if (operand instanceof MappingConfig_ExternalRef) {
      this.setGenMappingRef(root, (MappingConfig_ExternalRef) operand);
    } else
    if (operand instanceof MappingConfig_RefSet) {
      for (MappingConfig_AbstractRef ref : ((MappingConfig_RefSet) operand).getMappingConfigs()) {
        this.setGenMappingRef(root, (MappingConfig_ExternalRef) ref);
      }
    }
  }

  private void setGenMappingRef(DefaultMutableTreeNode root, MappingConfig_ExternalRef operand) {
    ModuleReference modRef = operand.getGenerator();
    Enumeration children = root.children();
    while (children.hasMoreElements()) {
      DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
      MappingSelectTree.GenRefNodeData childData = (MappingSelectTree.GenRefNodeData) child.getUserObject();
      if (childData.getObject().equals(modRef)) {
        MappingConfig_AbstractRef innerOperand = operand.getMappingConfig();
        MappingSelectTree.NodeData rootData = (MappingSelectTree.NodeData) child.getUserObject();
        if (innerOperand instanceof MappingConfig_RefAllLocal) {
          rootData.setSelected(true);
        } else
        if (innerOperand instanceof MappingConfig_SimpleRef) {
          this.setModelMappingRef(child, (MappingConfig_SimpleRef) innerOperand);
        } else
        if (innerOperand instanceof MappingConfig_RefSet) {
          for (MappingConfig_AbstractRef ref : ((MappingConfig_RefSet) innerOperand).getMappingConfigs()) {
            this.setModelMappingRef(child, (MappingConfig_SimpleRef) ref);
          }
        }
      }
    }
  }

  private void setModelMappingRef(DefaultMutableTreeNode root, MappingConfig_SimpleRef operand) {
    SModelReference modRef = SModelReference.fromString(operand.getModelUID());
    modRef.update();
    Enumeration children = root.children();
    while (children.hasMoreElements()) {
      DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
      MappingSelectTree.ModelRefNodeData childData = (MappingSelectTree.ModelRefNodeData) child.getUserObject();
      childData.getObject().update();
      if (childData.getObject().equals(modRef)) {
        if (operand.getNodeID().equals("*")) {
          childData.setSelected(true);
        } else {
          this.setNodeMappingRef(child, operand);
        }
      }
    }
  }

  private void setNodeMappingRef(DefaultMutableTreeNode root, MappingConfig_SimpleRef operand) {
    SNodePointer nodeRef = new SNodePointer(operand.getModelUID(), operand.getNodeID());
    Enumeration children = root.children();
    while (children.hasMoreElements()) {
      DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
      MappingSelectTree.NodeRefNodeData childData = (MappingSelectTree.NodeRefNodeData) child.getUserObject();
      if (childData.getObject().equals(nodeRef)) {
        childData.setSelected(true);
      }
    }
  }

  private MappingConfig_AbstractRef getRootMappingRef(DefaultMutableTreeNode root) {
    MappingSelectTree.NodeData rootData = (MappingSelectTree.NodeData) root.getUserObject();
    if (!(rootData.isChecksUnder())) {
      return new MappingConfig_AbstractRef();
    }
    if (rootData.isSelected()) {
      return new MappingConfig_RefAllGlobal();
    }
    List<DefaultMutableTreeNode> chChildren = this.getChildrenWithChecks(root);
    if (chChildren.size() == 1) {
      return this.getGeneratorMappingRef(chChildren.get(0));
    } else {
      MappingConfig_RefSet result = new MappingConfig_RefSet();
      for (DefaultMutableTreeNode child : chChildren) {
        result.getMappingConfigs().add(this.getGeneratorMappingRef(child));
      }
      return result;
    }
  }

  private MappingConfig_AbstractRef getGeneratorMappingRef(DefaultMutableTreeNode gRoot) {
    MappingConfig_ExternalRef result = new MappingConfig_ExternalRef();
    MappingSelectTree.GenRefNodeData rootData = (MappingSelectTree.GenRefNodeData) gRoot.getUserObject();
    result.setGenerator(rootData.getObject());
    if (rootData.isSelected()) {
      result.setMappingConfig(new MappingConfig_RefAllLocal());
    } else {
      List<DefaultMutableTreeNode> chChildren = this.getChildrenWithChecks(gRoot);
      if (chChildren.size() == 1) {
        result.setMappingConfig(this.getModelMappingRef(chChildren.get(0)));
      } else {
        MappingConfig_RefSet modelsResult = new MappingConfig_RefSet();
        for (DefaultMutableTreeNode child : chChildren) {
          modelsResult.getMappingConfigs().add(this.getModelMappingRef(child));
        }
        result.setMappingConfig(modelsResult);
      }
    }
    return result;
  }

  private MappingConfig_AbstractRef getModelMappingRef(DefaultMutableTreeNode mRoot) {
    MappingSelectTree.ModelRefNodeData rootData = (MappingSelectTree.ModelRefNodeData) mRoot.getUserObject();
    if (!(rootData.isChecksUnder())) {
      return new MappingConfig_AbstractRef();
    }
    if (rootData.isSelected()) {
      MappingConfig_SimpleRef result = new MappingConfig_SimpleRef();
      result.setModelUID(rootData.getObject().toString());
      result.setNodeID("*");
      return result;
    }
    List<DefaultMutableTreeNode> chChildren = this.getChildrenWithChecks(mRoot);
    if (chChildren.size() == 1) {
      return this.getNodeMappingRef(chChildren.get(0));
    } else {
      MappingConfig_RefSet result = new MappingConfig_RefSet();
      for (DefaultMutableTreeNode child : chChildren) {
        result.getMappingConfigs().add(this.getNodeMappingRef(child));
      }
      return result;
    }
  }

  private MappingConfig_AbstractRef getNodeMappingRef(DefaultMutableTreeNode nRoot) {
    MappingSelectTree.NodeRefNodeData rootData = (MappingSelectTree.NodeRefNodeData) nRoot.getUserObject();
    MappingConfig_SimpleRef result = new MappingConfig_SimpleRef();
    result.setModelUID(rootData.getObject().getModelReference().toString());
    result.setNodeID(rootData.getObject().getNode().getId());
    return result;
  }

  private List<DefaultMutableTreeNode> getChildrenWithChecks(DefaultMutableTreeNode root) {
    List<DefaultMutableTreeNode> result = new ArrayList<DefaultMutableTreeNode>();
    Enumeration children = root.children();
    while (children.hasMoreElements()) {
      DefaultMutableTreeNode child = (DefaultMutableTreeNode) children.nextElement();
      MappingSelectTree.NodeData childData = (MappingSelectTree.NodeData) child.getUserObject();
      if (childData.isChecksUnder()) {
        result.add(child);
      }
    }
    return result;
  }

  private boolean setCheckedUnder(DefaultMutableTreeNode root) {
    boolean childChecks = false;
    Enumeration<DefaultMutableTreeNode> children = root.children();
    while (children.hasMoreElements()) {
      DefaultMutableTreeNode child = children.nextElement();
      childChecks = childChecks | this.setCheckedUnder(child);
    }
    MappingSelectTree.NodeData rootData = (MappingSelectTree.NodeData) root.getUserObject();
    boolean checksUnder = rootData.isSelected() || childChecks;
    rootData.setChecksUnder(checksUnder);
    return checksUnder;
  }

  @BaseDialog.Button(position = 0, name = "OK", mnemonic = 'O', defaultButton = true)
  public void buttonOK() {
    final DefaultMutableTreeNode root = (DefaultMutableTreeNode) this.myTree.getModel().getRoot();
    this.setCheckedUnder(root);
    this.myResult = ModelAccess.instance().runReadAction(new Computable<MappingConfig_AbstractRef>() {
      public MappingConfig_AbstractRef compute() {
        return EditOperandDialog.this.getRootMappingRef(root);
      }
    });
    this.dispose();
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C')
  public void buttonCancel() {
    this.myResult = null;
    this.dispose();
  }
}
