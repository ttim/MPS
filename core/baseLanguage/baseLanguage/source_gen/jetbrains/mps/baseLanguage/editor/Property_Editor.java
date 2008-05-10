package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.EditorCell_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;

public class Property_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_Component_Visibility8;
  /* package */AbstractCellProvider my_Component_Visibility9;

  private static void setupBasic_AlternationCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_AlternationCell15789_0");
  }

  private static void setupBasic_CollectionCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell15789_0");
  }

  private static void setupBasic__Component_VisibilityComponentCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "__Component_VisibilityComponentCell15789_0");
  }

  private static void setupBasic_typeRefNodeCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_typeRefNodeCell15789_0");
  }

  private static void setupBasic_propertyNamePropertyCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_propertyNamePropertyCell15789_0");
    BaseLanguageStyle_StyleSheet.FIELD.apply(editorCell);
  }

  private static void setupBasic_ConstantCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15789_0");
  }

  private static void setupBasic_propertyImplementationRefNodeCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_propertyImplementationRefNodeCell15789_0");
  }

  private static void setupBasic_ConstantCell15789_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15789_01");
  }

  private static void setupBasic_CollectionCell15789_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell15789_01");
  }

  private static void setupBasic_CollectionCell15789_02(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell15789_02");
  }

  private static void setupBasic__Component_VisibilityComponentCell15789_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "__Component_VisibilityComponentCell15789_01");
  }

  private static void setupBasic_typeRefNodeCell15789_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_typeRefNodeCell15789_01");
  }

  private static void setupBasic_propertyNamePropertyCell15789_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_propertyNamePropertyCell15789_01");
    BaseLanguageStyle_StyleSheet.FIELD.apply(editorCell);
  }

  private static void setupBasic_ConstantCell15789_02(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15789_02");
  }

  private static void setupBasic_ConstantCell15789_03(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_ConstantCell15789_03");
  }

  private static void setupBasic_CollectionCell15789_03(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_CollectionCell15789_03");
    editorCell.setSelectable(false);
  }

  private static void setupBasic_IndentCell15789_0(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_IndentCell15789_0");
    editorCell.setSelectable(false);
  }

  private static void setupBasic_propertyImplementationRefNodeCell15789_01(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_propertyImplementationRefNodeCell15789_01");
  }

  private static void setupLabel_typeRefNodeCell15789_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_propertyNamePropertyCell15789_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15789_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_propertyImplementationRefNodeCell15789_0(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15789_01(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_typeRefNodeCell15789_01(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_propertyNamePropertyCell15789_01(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15789_02(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell15789_03(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_propertyImplementationRefNodeCell15789_01(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition15789_0(SNode node, EditorContext editorContext, IScope scope) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "propertyImplementation", true), "jetbrains.mps.baseLanguage.structure.CustomPropertyImplementation"));
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.create_AlternationCell15789_0(context, node);
  }

  public EditorCell create_AlternationCell15789_0(EditorContext context, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = Property_Editor.renderingCondition15789_0(node, context, context.getOperationContext().getScope());
    EditorCell editorCell = null;
    if (alternationCondition) {
      editorCell = this.create_CollectionCell15789_0(context, node);
    } else
    {
      editorCell = this.create_CollectionCell15789_01(context, node);
    }
    setupBasic_AlternationCell15789_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell create_CollectionCell15789_0(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CollectionCell15789_0(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create__Component_VisibilityComponentCell15789_0(context, node));
    editorCell.addEditorCell(this.create_typeRefNodeCell15789_0(context, node));
    editorCell.addEditorCell(this.create_propertyNamePropertyCell15789_0(context, node));
    editorCell.addEditorCell(this.create_ConstantCell15789_0(context, node, "{"));
    editorCell.addEditorCell(this.create_propertyImplementationRefNodeCell15789_0(context, node));
    editorCell.addEditorCell(this.create_ConstantCell15789_01(context, node, "}"));
    return editorCell;
  }

  public EditorCell create_CollectionCell15789_01(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_CollectionCell15789_01(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create_CollectionCell15789_02(context, node));
    editorCell.addEditorCell(this.create_CollectionCell15789_03(context, node));
    editorCell.addEditorCell(this.create_ConstantCell15789_03(context, node, "}"));
    return editorCell;
  }

  public EditorCell create_CollectionCell15789_02(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CollectionCell15789_02(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create__Component_VisibilityComponentCell15789_01(context, node));
    editorCell.addEditorCell(this.create_typeRefNodeCell15789_01(context, node));
    editorCell.addEditorCell(this.create_propertyNamePropertyCell15789_01(context, node));
    editorCell.addEditorCell(this.create_ConstantCell15789_02(context, node, "{"));
    return editorCell;
  }

  public EditorCell create_CollectionCell15789_03(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_CollectionCell15789_03(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createIndentCell(context, node));
    editorCell.addEditorCell(this.create_propertyImplementationRefNodeCell15789_01(context, node));
    return editorCell;
  }

  public EditorCell create__Component_VisibilityComponentCell15789_0(EditorContext context, SNode node) {
    if (this.my_Component_Visibility8 == null) {
      this.my_Component_Visibility8 = new _Component_Visibility(node);
    }
    EditorCell editorCell = this.my_Component_Visibility8.createEditorCell(context);
    setupBasic__Component_VisibilityComponentCell15789_0(editorCell, node, context);
    return editorCell;
  }

  public EditorCell create__Component_VisibilityComponentCell15789_01(EditorContext context, SNode node) {
    if (this.my_Component_Visibility9 == null) {
      this.my_Component_Visibility9 = new _Component_Visibility(node);
    }
    EditorCell editorCell = this.my_Component_Visibility9.createEditorCell(context);
    setupBasic__Component_VisibilityComponentCell15789_01(editorCell, node, context);
    return editorCell;
  }

  public EditorCell create_ConstantCell15789_0(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15789_0(editorCell, node, context);
    setupLabel_ConstantCell15789_0(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell15789_01(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15789_01(editorCell, node, context);
    setupLabel_ConstantCell15789_01(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell15789_02(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15789_02(editorCell, node, context);
    setupLabel_ConstantCell15789_02(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell create_ConstantCell15789_03(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_ConstantCell15789_03(editorCell, node, context);
    setupLabel_ConstantCell15789_03(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createIndentCell(EditorContext context, SNode node) {
    EditorCell_Indent result = new EditorCell_Indent(context, node);
    return result;
  }

  public EditorCell create_typeRefNodeCell15789_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_typeRefNodeCell15789_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_typeRefNodeCell15789_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_typeRefNodeCell15789_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("type");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_typeRefNodeCell15789_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_propertyNamePropertyCell15789_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_propertyNamePropertyCell15789_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_propertyNamePropertyCell15789_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_propertyNamePropertyCell15789_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("propertyName");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_propertyNamePropertyCell15789_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_propertyImplementationRefNodeCell15789_0_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_propertyImplementationRefNodeCell15789_0(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_propertyImplementationRefNodeCell15789_0((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_propertyImplementationRefNodeCell15789_0(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("propertyImplementation");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_propertyImplementationRefNodeCell15789_0_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_typeRefNodeCell15789_01_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_typeRefNodeCell15789_01(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_typeRefNodeCell15789_01((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_typeRefNodeCell15789_01(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("type");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_typeRefNodeCell15789_01_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_propertyNamePropertyCell15789_01_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_propertyNamePropertyCell15789_01(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_propertyNamePropertyCell15789_01((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_propertyNamePropertyCell15789_01(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("propertyName");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_propertyNamePropertyCell15789_01_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell create_propertyImplementationRefNodeCell15789_01_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_propertyImplementationRefNodeCell15789_01(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_propertyImplementationRefNodeCell15789_01((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell create_propertyImplementationRefNodeCell15789_01(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("propertyImplementation");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.create_propertyImplementationRefNodeCell15789_01_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

}
