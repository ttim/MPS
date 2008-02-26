package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.CellLayout_Vertical;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_DeleteNode;
import jetbrains.mps.nodeEditor.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.DefaultChildSubstituteInfo;

public class Interface_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider my_GenericDeclaration_TypeVariables_Component;
  /* package */AbstractCellProvider my_Component_Visibility4;
  /* package */AbstractCellListHandler myMethodListHandler_methodsList_;
  /* package */AbstractCellListHandler myExtendedInterfaceListHandler_extendedInterfaceList_;
  /* package */AbstractCellListHandler myStaticFieldListHandler_staticFieldList_;
  /* package */AbstractCellListHandler myAnnotationListHandler_annotationList_;
  /* package */AbstractCellListHandler myAnnotationListHandler_annotationList1_;

  private static void setupBasic_ClassBox(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852505");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_HeaderRow(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852507");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell6(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852512");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_MethodsArea(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852513");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell8(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852514");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell9(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852516");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852517");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_NameCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852518");
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setRightTransformAnchorTag("default_RTransform");
  }

  private static void setupBasic_ConstantCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852519");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852521");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_MethodsIndentCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852538");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_MethodsList(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852539");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ExtendedInterfaceList(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107797338699");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic__GenericDeclaration_TypeVariables_ComponentCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1109281106345");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_RowCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1128556090207");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_ConstantCell4(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1128556090208");
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic_StaticFieldList(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1128556090209");
    editorCell.setDrawBorder(false);
  }

  private static void setupBasic__Component_VisibilityCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1178550117011");
  }

  private static void setupBasic_ColumnCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1188208760860");
    editorCell.setSelectable(false);
  }

  private static void setupBasic_AnnotationList(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1188208760861");
  }

  private static void setupBasic_ColumnCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1188208780630");
  }

  private static void setupBasic_RowCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1188208781022");
    editorCell.setSelectable(false);
  }

  private static void setupBasic_ConstantCell10(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1188208781023");
  }

  private static void setupBasic_AnnotationList1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1188208781024");
  }

  private static void setupLabel_ConstantCell6(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell8(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell9(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
  }

  private static void setupLabel_NameCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell1(EditorCell_Label editorCell, SNode node, EditorContext context) {
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
  }

  private static void setupLabel_ConstantCell3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_MethodsIndentCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_MethodsList(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ExtendedInterfaceList(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell4(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_StaticFieldList(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_AnnotationList(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell10(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_AnnotationList1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean _QueryFunction_NodeCondition_1145916182768(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getCount(node, "typeVariableDeclaration") > 0;
  }

  public static boolean _QueryFunction_NodeCondition_1188208760862(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getCount(node, "annotation") > 0;
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createClassBox(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createColumnCell1(context, node);
  }

  public EditorCell createClassBox(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    Interface_Editor.setupBasic_ClassBox(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    if(Interface_Editor._QueryFunction_NodeCondition_1188208760862(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createColumnCell(context, node));
    }
    editorCell.addEditorCell(this.createHeaderRow(context, node));
    editorCell.addEditorCell(this.createRowCell(context, node));
    editorCell.addEditorCell(this.createConstantCell6(context, node, ""));
    editorCell.addEditorCell(this.createMethodsArea(context, node));
    editorCell.addEditorCell(this.createConstantCell8(context, node, ""));
    editorCell.addEditorCell(this.createConstantCell9(context, node, "}"));
    return editorCell;
  }

  public EditorCell createHeaderRow(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    Interface_Editor.setupBasic_HeaderRow(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.create_Component_VisibilityCell(context, node));
    editorCell.addEditorCell(this.createConstantCell(context, node, "interface"));
    editorCell.addEditorCell(this.createNameCell(context, node));
    if(Interface_Editor._QueryFunction_NodeCondition_1145916182768(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.create_GenericDeclaration_TypeVariables_ComponentCell(context, node));
    }
    editorCell.addEditorCell(this.createConstantCell1(context, node, "extends"));
    editorCell.addEditorCell(this.createExtendedInterfaceList(context, node));
    editorCell.addEditorCell(this.createConstantCell3(context, node, "{"));
    return editorCell;
  }

  public EditorCell createMethodsArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    Interface_Editor.setupBasic_MethodsArea(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createMethodsIndentCell(context, node, "    "));
    editorCell.addEditorCell(this.createMethodsList(context, node));
    return editorCell;
  }

  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    Interface_Editor.setupBasic_RowCell(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell4(context, node, "    "));
    editorCell.addEditorCell(this.createStaticFieldList(context, node));
    return editorCell;
  }

  public EditorCell createColumnCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    Interface_Editor.setupBasic_ColumnCell(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createAnnotationList(context, node));
    return editorCell;
  }

  public EditorCell createColumnCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    Interface_Editor.setupBasic_ColumnCell1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRowCell1(context, node));
    editorCell.addEditorCell(this.createAnnotationList1(context, node));
    return editorCell;
  }

  public EditorCell createRowCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    Interface_Editor.setupBasic_RowCell1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell10(context, node, "annotations:"));
    return editorCell;
  }

  public EditorCell create_GenericDeclaration_TypeVariables_ComponentCell(EditorContext context, SNode node) {
    if(this.my_GenericDeclaration_TypeVariables_Component == null) {
      this.my_GenericDeclaration_TypeVariables_Component = new _GenericDeclaration_TypeVariables_Component(node);
    }
    EditorCell componentCell = this.my_GenericDeclaration_TypeVariables_Component.createEditorCell(context);
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.addEditorCell(componentCell);
    Interface_Editor.setupBasic__GenericDeclaration_TypeVariables_ComponentCell(editorCell, node, context);
    return editorCell;
  }

  public EditorCell create_Component_VisibilityCell(EditorContext context, SNode node) {
    if(this.my_Component_Visibility4 == null) {
      this.my_Component_Visibility4 = new _Component_Visibility(node);
    }
    EditorCell componentCell = this.my_Component_Visibility4.createEditorCell(context);
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.addEditorCell(componentCell);
    Interface_Editor.setupBasic__Component_VisibilityCell(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstantCell6(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell6(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell6(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell8(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell8(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell8(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell9(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell9(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell9(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell1(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell3(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createMethodsIndentCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_MethodsIndentCell(editorCell, node, context);
    Interface_Editor.setupLabel_MethodsIndentCell(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell4(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell4(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell10(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    Interface_Editor.setupBasic_ConstantCell10(editorCell, node, context);
    Interface_Editor.setupLabel_ConstantCell10(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createMethodsList(EditorContext context, SNode node) {
    if(this.myMethodListHandler_methodsList_ == null) {
      this.myMethodListHandler_methodsList_ = new Interface_Editor._RefNodeListHandler12(node, "method", context);
    }
    EditorCell_Collection editorCell = this.myMethodListHandler_methodsList_.createCells(context, new CellLayout_Vertical(), false);
    Interface_Editor.setupBasic_MethodsList(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myMethodListHandler_methodsList_.getElementRole());
    return editorCell;
  }

  public EditorCell createExtendedInterfaceList(EditorContext context, SNode node) {
    if(this.myExtendedInterfaceListHandler_extendedInterfaceList_ == null) {
      this.myExtendedInterfaceListHandler_extendedInterfaceList_ = new Interface_Editor._RefNodeListHandler13(node, "extendedInterface", context);
    }
    EditorCell_Collection editorCell = this.myExtendedInterfaceListHandler_extendedInterfaceList_.createCells(context, new CellLayout_Vertical(), false);
    Interface_Editor.setupBasic_ExtendedInterfaceList(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myExtendedInterfaceListHandler_extendedInterfaceList_.getElementRole());
    return editorCell;
  }

  public EditorCell createStaticFieldList(EditorContext context, SNode node) {
    if(this.myStaticFieldListHandler_staticFieldList_ == null) {
      this.myStaticFieldListHandler_staticFieldList_ = new Interface_Editor._RefNodeListHandler16(node, "staticField", context);
    }
    EditorCell_Collection editorCell = this.myStaticFieldListHandler_staticFieldList_.createCells(context, new CellLayout_Vertical(), false);
    Interface_Editor.setupBasic_StaticFieldList(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myStaticFieldListHandler_staticFieldList_.getElementRole());
    return editorCell;
  }

  public EditorCell createAnnotationList(EditorContext context, SNode node) {
    if(this.myAnnotationListHandler_annotationList_ == null) {
      this.myAnnotationListHandler_annotationList_ = new Interface_Editor._RefNodeListHandler47(node, "annotation", context);
    }
    EditorCell_Collection editorCell = this.myAnnotationListHandler_annotationList_.createCells(context, new CellLayout_Vertical(), false);
    Interface_Editor.setupBasic_AnnotationList(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myAnnotationListHandler_annotationList_.getElementRole());
    return editorCell;
  }

  public EditorCell createAnnotationList1(EditorContext context, SNode node) {
    if(this.myAnnotationListHandler_annotationList1_ == null) {
      this.myAnnotationListHandler_annotationList1_ = new Interface_Editor._RefNodeListHandler48(node, "annotation", context);
    }
    EditorCell_Collection editorCell = this.myAnnotationListHandler_annotationList1_.createCells(context, new CellLayout_Vertical(), false);
    Interface_Editor.setupBasic_AnnotationList1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myAnnotationListHandler_annotationList1_.getElementRole());
    return editorCell;
  }

  public EditorCell createNameCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    Interface_Editor.setupBasic_NameCell(editorCell, node, context);
    if(editorCell instanceof EditorCell_Label) {
      Interface_Editor.setupLabel_NameCell((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createNameCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new PropertyCellProvider(node, context);
    provider.setRole("name");
    provider.setNoTargetText("<no name>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createNameCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public static class _RefNodeListHandler12 extends RefNodeListHandler {

    public  _RefNodeListHandler12(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    private static void setupBasic_ConstantCell7(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107796852540");
      editorCell.setSelectable(true);
      editorCell.setDrawBorder(false);
    }

    private static void setupLabel_ConstantCell7(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }


    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = this.createEmptyCell_internal(context, this.getOwner());
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public EditorCell createEmptyCell_internal(EditorContext context, SNode node) {
      return this.createConstantCell7(context, node, " << methods >>");
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if(elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if(elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if(elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

    public EditorCell createConstantCell7(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      Interface_Editor._RefNodeListHandler12.setupBasic_ConstantCell7(editorCell, node, context);
      Interface_Editor._RefNodeListHandler12.setupLabel_ConstantCell7(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }

}
  public static class _RefNodeListHandler13 extends RefNodeListHandler {

    public  _RefNodeListHandler13(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    private static void setupBasic_ConstantCell2(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1107797338700");
      editorCell.setDrawBorder(false);
    }

    private static void setupLabel_ConstantCell2(EditorCell_Label editorCell, SNode node, EditorContext context) {
      editorCell.setEditable(true);
    }


    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = this.createEmptyCell_internal(context, this.getOwner());
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public EditorCell createEmptyCell_internal(EditorContext context, SNode node) {
      return this.createConstantCell2(context, node, "");
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if(elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if(elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if(elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

    public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      Interface_Editor._RefNodeListHandler13.setupBasic_ConstantCell2(editorCell, node, context);
      Interface_Editor._RefNodeListHandler13.setupLabel_ConstantCell2(editorCell, node, context);
      editorCell.setDefaultText("<none>");
      return editorCell;
    }

}
  public static class _RefNodeListHandler16 extends RefNodeListHandler {

    public  _RefNodeListHandler16(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    private static void setupBasic_ConstantCell5(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1128556090210");
      editorCell.setSelectable(true);
      editorCell.setDrawBorder(false);
    }

    private static void setupLabel_ConstantCell5(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }


    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = this.createEmptyCell_internal(context, this.getOwner());
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public EditorCell createEmptyCell_internal(EditorContext context, SNode node) {
      return this.createConstantCell5(context, node, " << static fields>>");
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if(elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if(elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if(elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

    public EditorCell createConstantCell5(EditorContext context, SNode node, String text) {
      EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
      Interface_Editor._RefNodeListHandler16.setupBasic_ConstantCell5(editorCell, node, context);
      Interface_Editor._RefNodeListHandler16.setupLabel_ConstantCell5(editorCell, node, context);
      editorCell.setDefaultText("");
      return editorCell;
    }

}
  public static class _RefNodeListHandler47 extends RefNodeListHandler {

    public  _RefNodeListHandler47(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(context);
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if(elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if(elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if(elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

}
  public static class _RefNodeListHandler48 extends RefNodeListHandler {

    public  _RefNodeListHandler48(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext context) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, context, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext context, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(context, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, context);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext context) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(context);
      this.installElementCellActions(super.getOwner(), null, emptyCell, context);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext context) {
      if(elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if(elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(EditorCellAction.DELETE, new CellAction_DeleteNode(elementNode));
        }
        if(elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      return super.createSeparatorCell(context);
    }

}

}
