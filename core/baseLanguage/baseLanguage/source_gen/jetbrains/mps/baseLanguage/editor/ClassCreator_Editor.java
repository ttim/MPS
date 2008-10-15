package jetbrains.mps.baseLanguage.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Horizontal;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.style.AttributeCalculator;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.IDeprecatable_Behavior;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class ClassCreator_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myIMethodCall_actualArguments9368_0;
  /* package */AbstractCellListHandler myListHandler_1212699852039;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1212699852032(context, node);
  }

  public EditorCell createCollection1212699852032(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12126998520321212699852032(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createRefCell1212699852034(context, node));
    if (renderingCondition9368_0(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection1212699852037(context, node));
    }
    editorCell.addEditorCell(this.createComponent1212699852051(context, node));
    return editorCell;
  }

  public EditorCell createCollection1212699852037(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12126998520371212699852037(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1212699852038(context, node, "<"));
    editorCell.addEditorCell(this.createRefNodeList1212699852039(context, node));
    editorCell.addEditorCell(this.createConstant1212699852040(context, node, ">"));
    return editorCell;
  }

  public EditorCell createComponent1212699852051(EditorContext context, SNode node) {
    if (this.myIMethodCall_actualArguments9368_0 == null) {
      this.myIMethodCall_actualArguments9368_0 = new IMethodCall_actualArguments(node);
    }
    EditorCell editorCell = this.myIMethodCall_actualArguments9368_0.createEditorCell(context);
    setupBasic_component_IMethodCall_actualArguments1212699852051(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant1212699852038(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12126998520381212699852038(editorCell, node, context);
    setupLabel_Constant_1212699852038_1212699852038(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1212699852040(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12126998520401212699852040(editorCell, node, context);
    setupLabel_Constant_1212699852040_1212699852040(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNodeList1212699852039(EditorContext context, SNode node) {
    if (this.myListHandler_1212699852039 == null) {
      this.myListHandler_1212699852039 = new ClassCreator_Editor.typeParameterListHandler_9368_0(node, "typeParameter", context);
    }
    EditorCell_Collection editorCell = this.myListHandler_1212699852039.createCells(context, new CellLayout_Horizontal(), false);
    setupBasic_refNodeList_typeParameter1212699852039(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.putUserObject(EditorCell.ROLE, this.myListHandler_1212699852039.getElementRole());
    return editorCell;
  }

  public EditorCell createRefCell1212699852034_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new ClassCreator_Editor._Inline9368_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_constructorDeclaration1212699852034(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_constructorDeclaration_1212699852034((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1212699852034(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("constructorDeclaration");
    provider.setNoTargetText("<no constructor declaration>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1212699852034_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_12126998520321212699852032(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1212699852032");
  }

  private static void setupBasic_refCell_constructorDeclaration1212699852034(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refCell_constructorDeclaration");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.STRIKE_OUT, new AttributeCalculator <Boolean>() {

            public Boolean calculate(EditorCell cell) {
              return ClassCreator_Editor._StyleParameter_QueryFunction_1223909271642((cell == null ?
                null :
                cell.getSNode()
              ), (cell == null ?
                null :
                cell.getEditorContext()
              ));
            }

          });
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_12126998520371212699852037(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Collection_1212699852037");
  }

  private static void setupBasic_Constant_12126998520381212699852038(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1212699852038");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PADDING_RIGHT, 0.0);
          this.set(StyleAttributes.FIRST_POSITION_ALLOWED, false);
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNodeList_typeParameter1212699852039(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "refNodeList_typeParameter");
  }

  private static void setupBasic_Constant_12126998520401212699852040(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "Constant_1212699852040");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.PADDING_RIGHT, 0.0);
          this.set(StyleAttributes.FIRST_POSITION_ALLOWED, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_component_IMethodCall_actualArguments1212699852051(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, "component_IMethodCall_actualArguments");
  }

  private static void setupLabel_refCell_constructorDeclaration_1212699852034(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1212699852038_1212699852038(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNodeList_typeParameter_1212699852039(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1212699852040_1212699852040(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean renderingCondition9368_0(SNode node, EditorContext editorContext, IScope scope) {
    return SLinkOperations.getCount(node, "typeParameter") > 0;
  }

  public static boolean _StyleParameter_QueryFunction_1223909271642(SNode node, EditorContext editorContext) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(SLinkOperations.getTarget(node, "baseMethodDeclaration", false)), "jetbrains.mps.baseLanguage.structure.Interface")) {
      if (IDeprecatable_Behavior.call_isDeprecated_1223639666632(SNodeOperations.getParent(SLinkOperations.getTarget(node, "baseMethodDeclaration", false)))) {
        return true;
      }
    } else if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(SLinkOperations.getTarget(node, "baseMethodDeclaration", false)), "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      if (IDeprecatable_Behavior.call_isDeprecated_1223639666632(SNodeOperations.getParent(SLinkOperations.getTarget(node, "baseMethodDeclaration", false)))) {
        return true;
      }
    }
    return IDeprecatable_Behavior.call_isDeprecated_1223639666632(SNodeOperations.getParent(SLinkOperations.getTarget(node, "baseMethodDeclaration", false)));
  }

  public static class _Inline9368_0 extends AbstractCellProvider {

    public _Inline9368_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1212700054374(context, node);
    }

    public EditorCell createProperty1212700054374_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_resolveInfo1212700054374(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_resolveInfo_1212700054374((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1212700054374(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("resolveInfo");
      provider.setNoTargetText("<no resolveInfo>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1212700054374_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_resolveInfo1212700054374(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, "property_resolveInfo");
      BaseLanguageStyle_StyleSheet.getMethodName(editorCell).apply(editorCell);
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.RT_ANCHOR_TAG, "ext_1_RTransform");
            this.set(StyleAttributes.STRIKE_OUT, new AttributeCalculator <Boolean>() {

              public Boolean calculate(EditorCell cell) {
                return ClassCreator_Editor._Inline9368_0._StyleParameter_QueryFunction_1223912104287((cell == null ?
                  null :
                  cell.getSNode()
                ), (cell == null ?
                  null :
                  cell.getEditorContext()
                ));
              }

            });
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_property_resolveInfo_1212700054374(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

    public static boolean _StyleParameter_QueryFunction_1223912104287(SNode node, EditorContext editorContext) {
      if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.Interface")) {
        if (IDeprecatable_Behavior.call_isDeprecated_1223639666632(node)) {
          return true;
        }
      } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
        if (IDeprecatable_Behavior.call_isDeprecated_1223639666632(node)) {
          return true;
        }
      }
      return IDeprecatable_Behavior.call_isDeprecated_1223639666632(node);
    }

}
  public static class typeParameterListHandler_9368_0 extends RefNodeListHandler {

    public typeParameterListHandler_9368_0(SNode ownerNode, String childRole, EditorContext context) {
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
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
          elementCell.addKeyMap(new RefNodeListHandlerElementKeyMap(this, ","));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), context));
        }
      }
    }

    public EditorCell createSeparatorCell(EditorContext context) {
      {
        EditorCell_Constant editorCell = new EditorCell_Constant(context, this.getOwner(), ",");
        editorCell.setSelectable(false);
        return editorCell;
      }
    }

}

}
