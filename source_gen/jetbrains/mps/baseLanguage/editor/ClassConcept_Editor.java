package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS Apr 26, 2006 12:53:42 PM */


import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import java.awt.Color;
import jetbrains.mps.nodeEditor.EditorCell_Basic;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.nodeEditor.CellLayout_Vertical;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;

public class ClassConcept_Editor extends DefaultNodeEditor {

  public AbstractCellProvider my_GenericDeclaration_TypeVariables_Component;
  public AbstractCellListHandler myImplementedInterfaceListHandler;
  public AbstractCellListHandler myStaticFieldListHandler;
  public AbstractCellListHandler myFieldListHandler;
  public AbstractCellListHandler myMethodListHandler;
  public AbstractCellListHandler myStaticMethodListHandler;
  public AbstractCellListHandler myConstructorListHandler;

  public static boolean _QueryFunction_NodeCondition_1145916139208(SNode node, IScope scope) {
    return SLinkOperations.getCount(node, "typeVariableDeclaration") > 0;
  }

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createClassBox(context, node);
  }
  public EditorCell createClassBox(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createHeaderRow(context, node));
    editorCell.addEditorCell(this.createRowCell(context, node));
    editorCell.addEditorCell(this.createFieldsArea(context, node));
    editorCell.addEditorCell(this.createConstantCell8(context, node, ""));
    editorCell.addEditorCell(this.createConstructorsArea(context, node));
    editorCell.addEditorCell(this.createConstantCell10(context, node, ""));
    editorCell.addEditorCell(this.createMethodsArea(context, node));
    editorCell.addEditorCell(this.createConstantCell12(context, node, ""));
    editorCell.addEditorCell(this.createRowCell1(context, node));
    editorCell.addEditorCell(this.createConstantCell14(context, node, "}"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1074794490344");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstructorsArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createConstructorsIndentCell(context, node, "    "));
    editorCell.addEditorCell(this.createConstructorsList(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1074867634394");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createHeaderRow(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createConstantCell(context, node, "class"));
    editorCell.addEditorCell(this.createNameCell(context, node));
    if(ClassConcept_Editor._QueryFunction_NodeCondition_1145916139208(node, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.create_GenericDeclaration_TypeVariables_ComponentCell(context, node));
    }
    editorCell.addEditorCell(this.createConstantCell1(context, node, "extends"));
    editorCell.addEditorCell(this.createExtendedClassReferenceCell(context, node));
    editorCell.addEditorCell(this.createConstantCell2(context, node, "implements"));
    editorCell.addEditorCell(this.createImplementedInterfaceList(context, node));
    editorCell.addEditorCell(this.createConstantCell4(context, node, "{"));
    editorCell.putUserObject(EditorCell.CELL_ID, "1074794604361");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createRowCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createMethodsIndentCell1(context, node, "    "));
    editorCell.addEditorCell(this.createStaticMethodList(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1080825388968");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createConstantCell5(context, node, "    "));
    editorCell.addEditorCell(this.createStaticFieldList(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1128555992206");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createMethodsArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createMethodsIndentCell(context, node, "    "));
    editorCell.addEditorCell(this.createMethodsList(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1074867682195");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createFieldsArea(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.addEditorCell(this.createFieldsIndentCell(context, node, "    "));
    editorCell.addEditorCell(this.createFieldsList(context, node));
    editorCell.putUserObject(EditorCell.CELL_ID, "1074866421484");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell create_GenericDeclaration_TypeVariables_ComponentCell(EditorContext context, SNode node) {
    if(this.my_GenericDeclaration_TypeVariables_Component == null) {
      this.my_GenericDeclaration_TypeVariables_Component = new _GenericDeclaration_TypeVariables_Component(node);
    }
    EditorCell editorCell = this.my_GenericDeclaration_TypeVariables_Component.createEditorCell(context);
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1109281144581");
    editorCell.setLayoutConstraint("");
    return editorCell;
  }
  public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    editorCell.putUserObject(EditorCell.CELL_ID, "1107798989515");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    editorCell.putUserObject(EditorCell.CELL_ID, "1080648716828");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell12(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1104451669405");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell10(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1104451665639");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell4(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1074794745224");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.getTextLine().setTextColor(MPSColors.DARK_BLUE);
    editorCell.putUserObject(EditorCell.CELL_ID, "1074794604362");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createMethodsIndentCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1074868243546");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell8(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1104451658934");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createMethodsIndentCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1080825768015");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstructorsIndentCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1074867634395");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createFieldsIndentCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1074866421485");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell14(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1074794745225");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstantCell5(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = EditorCell_Constant.create(context, node, text, false);
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setEditable(false);
    editorCell.setDefaultText("");
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.putUserObject(EditorCell.CELL_ID, "1128555992207");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createImplementedInterfaceList(EditorContext context, SNode node) {
    if(this.myImplementedInterfaceListHandler == null) {
      this.myImplementedInterfaceListHandler = new ClassConcept_Editor_ImplementedInterfaceListHandler(node, "implementedInterface", context);
    }
    EditorCell_Collection editorCell = this.myImplementedInterfaceListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myImplementedInterfaceListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createStaticFieldList(EditorContext context, SNode node) {
    if(this.myStaticFieldListHandler == null) {
      this.myStaticFieldListHandler = new ClassConcept_Editor_StaticFieldListHandler(node, "staticField", context);
    }
    EditorCell_Collection editorCell = this.myStaticFieldListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(true);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myStaticFieldListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createFieldsList(EditorContext context, SNode node) {
    if(this.myFieldListHandler == null) {
      this.myFieldListHandler = new ClassConcept_Editor_FieldListHandler(node, "field", context);
    }
    EditorCell_Collection editorCell = this.myFieldListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myFieldListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createMethodsList(EditorContext context, SNode node) {
    if(this.myMethodListHandler == null) {
      this.myMethodListHandler = new ClassConcept_Editor_MethodListHandler(node, "method", context);
    }
    EditorCell_Collection editorCell = this.myMethodListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myMethodListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createStaticMethodList(EditorContext context, SNode node) {
    if(this.myStaticMethodListHandler == null) {
      this.myStaticMethodListHandler = new ClassConcept_Editor_StaticMethodListHandler(node, "staticMethod", context);
    }
    EditorCell_Collection editorCell = this.myStaticMethodListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myStaticMethodListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createConstructorsList(EditorContext context, SNode node) {
    if(this.myConstructorListHandler == null) {
      this.myConstructorListHandler = new ClassConcept_Editor_ConstructorListHandler(node, "constructor", context);
    }
    EditorCell_Collection editorCell = this.myConstructorListHandler.createCells(context, new CellLayout_Vertical());
    editorCell.setSelectable(false);
    editorCell.setDrawBorder(false);
    editorCell.setGridLayout(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    editorCell.setUsesBraces(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myConstructorListHandler.getElementRole());
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createNameCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1074794745222");
    editorCell.setLayoutConstraint("");
    editorCell.setRightTransformAnchorTag("default_RTransform");
    ((EditorCell_Basic)editorCell).setParseable(false);
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
  public EditorCell createExtendedClassReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new ClassConcept_Editor_extendedClass_InlineComponent());
    EditorCell editorCell = provider.createEditorCell(context);
    editorCell.setDrawBorder(false);
    editorCell.setDrawBrackets(false);
    editorCell.setBracketsColor(Color.black);
    if(editorCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label)editorCell;
      editorCellLabel.setEditable(true);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    editorCell.putUserObject(EditorCell.CELL_ID, "1088354561031");
    editorCell.setLayoutConstraint("");
    ((EditorCell_Basic)editorCell).setParseable(false);
    return editorCell;
  }
  public EditorCell createExtendedClassReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("extendedClass");
    provider.setNoTargetText("<none>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createExtendedClassReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else 
    return cellWithRole;
  }
}
