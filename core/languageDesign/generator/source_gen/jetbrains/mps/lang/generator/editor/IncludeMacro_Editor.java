package jetbrains.mps.lang.generator.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.SubstituteInfoPart;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.lang.editor.cellProviders.RefNodeCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.nodeEditor.FocusPolicy;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.MPSColors;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.lang.editor.generator.internal.AbstractCellMenuPart_ReplaceNode_CustomNodeConcept;

public class IncludeMacro_Editor extends DefaultNodeEditor {

  /* package */AbstractCellProvider myNodeMacro_postfix6568_0;

  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createCollection1194566483566(context, node);
  }

  public EditorCell createInspectedCell(EditorContext context, SNode node) {
    return this.createCollection1194566535681(context, node);
  }

  public EditorCell createCollection1194566483566(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11945664835661194566483566(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1194566483567(context, node, "$INCLUDE$"));
    editorCell.addEditorCell(this.createComponent1194566483585(context, node));
    return editorCell;
  }

  public EditorCell createCollection1194566535681(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11945665356811194566535681(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1194566535682(context, node, "include-macro"));
    editorCell.addEditorCell(this.createConstant1194566535683(context, node, ""));
    editorCell.addEditorCell(this.createCollection1194566535684(context, node));
    return editorCell;
  }

  public EditorCell createCollection1194566535684(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createVertical(context, node);
    setupBasic_Collection_11945665356841194566535684(editorCell, node, context);
    editorCell.setGridLayout(true);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCollection1200912281133(context, node));
    editorCell.addEditorCell(this.createCollection1194566535726(context, node));
    editorCell.addEditorCell(this.createConstant1194566535730(context, node, ""));
    editorCell.addEditorCell(this.createCollection1194566535731(context, node));
    return editorCell;
  }

  public EditorCell createCollection1194566535726(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11945665357261194566535726(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1194566535727(context, node, "mapped node"));
    editorCell.addEditorCell(this.createConstant1194566535728(context, node, ":"));
    editorCell.addEditorCell(this.createRefNode1194566535729(context, node));
    return editorCell;
  }

  public EditorCell createCollection1194566535731(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_11945665357311194566535731(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1194566535732(context, node, "include template"));
    editorCell.addEditorCell(this.createConstant1194566535733(context, node, ":"));
    editorCell.addEditorCell(this.createRefCell1194566535734(context, node));
    return editorCell;
  }

  public EditorCell createCollection1200912281133(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    setupBasic_Collection_12009122811331200912281133(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstant1200912281134(context, node, "mapping label"));
    editorCell.addEditorCell(this.createConstant1200912281135(context, node, ":"));
    editorCell.addEditorCell(this.createRefCell1200912281136(context, node));
    return editorCell;
  }

  public EditorCell createComponent1194566483585(EditorContext context, SNode node) {
    if (this.myNodeMacro_postfix6568_0 == null) {
      this.myNodeMacro_postfix6568_0 = new NodeMacro_postfix(node);
    }
    EditorCell editorCell = this.myNodeMacro_postfix6568_0.createEditorCell(context);
    setupBasic_component_NodeMacro_postfix1194566483585(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createConstant1194566483567(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945664835671194566483567(editorCell, node, context);
    setupLabel_Constant_1194566483567_1194566483567(editorCell, node, context);
    editorCell.setDefaultText("");
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, new BasicCellContext(node), new SubstituteInfoPart[]{new IncludeMacro_Editor.IncludeMacro_Editor_replaceWith_NodeMacro_cellMenu0()}));
    return editorCell;
  }

  public EditorCell createConstant1194566535682(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665356821194566535682(editorCell, node, context);
    setupLabel_Constant_1194566535682_1194566535682(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1194566535683(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665356831194566535683(editorCell, node, context);
    setupLabel_Constant_1194566535683_1194566535683(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1194566535727(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665357271194566535727(editorCell, node, context);
    setupLabel_Constant_1194566535727_1194566535727(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1194566535728(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665357281194566535728(editorCell, node, context);
    setupLabel_Constant_1194566535728_1194566535728(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1194566535730(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665357301194566535730(editorCell, node, context);
    setupLabel_Constant_1194566535730_1194566535730(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1194566535732(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665357321194566535732(editorCell, node, context);
    setupLabel_Constant_1194566535732_1194566535732(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1194566535733(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_11945665357331194566535733(editorCell, node, context);
    setupLabel_Constant_1194566535733_1194566535733(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1200912281134(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12009122811341200912281134(editorCell, node, context);
    setupLabel_Constant_1200912281134_1200912281134(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstant1200912281135(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    setupBasic_Constant_12009122811351200912281135(editorCell, node, context);
    setupLabel_Constant_1200912281135_1200912281135(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createRefNode1194566535729_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refNode_sourceNodeQuery1194566535729(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refNode_sourceNodeQuery_1194566535729((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefNode1194566535729(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("sourceNodeQuery");
    provider.setNoTargetText("<current source node>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefNode1194566535729_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefCell1194566535734_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new IncludeMacro_Editor._Inline6568_0());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_includeTemplate1194566535734(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_includeTemplate_1194566535734((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1194566535734(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("includeTemplate");
    provider.setNoTargetText("<choose template>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1194566535734_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createRefCell1200912281136_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new IncludeMacro_Editor._Inline6568_1());
    EditorCell editorCell = provider.createEditorCell(context);
    setupBasic_refCell_mappingLabel1200912281136(editorCell, node, context);
    if (editorCell instanceof EditorCell_Label) {
      setupLabel_refCell_mappingLabel_1200912281136((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createRefCell1200912281136(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("mappingLabel");
    provider.setNoTargetText("<no label>");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createRefCell1200912281136_internal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }


  private static void setupBasic_Collection_11945664835661194566483566(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1194566483566");
  }

  private static void setupBasic_Constant_11945664835671194566483567(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566483567");
    Styles_StyleSheet.getMacroStart(editorCell).apply(editorCell);
    if (true) {
      editorCell.setFocusPolicy(FocusPolicy.ATTRACTS_FOCUS);
    }
    MacroSymbol_Actions.setCellActions(editorCell, node, context);
  }

  private static void setupBasic_component_NodeMacro_postfix1194566483585(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("component_NodeMacro_postfix");
  }

  private static void setupBasic_Collection_11945665356811194566535681(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1194566535681");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11945665356821194566535682(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535682");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
          this.set(StyleAttributes.TEXT_COLOR, MPSColors.DARK_BLUE);
          this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.lightGray);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11945665356831194566535683(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535683");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11945665356841194566535684(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1194566535684");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11945665357261194566535726(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1194566535726");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11945665357271194566535727(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535727");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11945665357281194566535728(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535728");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refNode_sourceNodeQuery1194566535729(EditorCell editorCell, SNode node, EditorContext context) {
  }

  private static void setupBasic_Constant_11945665357301194566535730(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535730");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Collection_11945665357311194566535731(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1194566535731");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11945665357321194566535732(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535732");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_11945665357331194566535733(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1194566535733");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refCell_includeTemplate1194566535734(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refCell_includeTemplate");
  }

  private static void setupBasic_Collection_12009122811331200912281133(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Collection_1200912281133");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_Constant_12009122811341200912281134(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1200912281134");
  }

  private static void setupBasic_Constant_12009122811351200912281135(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("Constant_1200912281135");
    {
      Style inlineStyle = new Style(editorCell) {
        {
          this.set(StyleAttributes.SELECTABLE, false);
        }

      };
      inlineStyle.apply(editorCell);
    }
  }

  private static void setupBasic_refCell_mappingLabel1200912281136(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.setCellId("refCell_mappingLabel");
  }

  private static void setupLabel_Constant_1194566483567_1194566483567(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535682_1194566535682(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535683_1194566535683(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535727_1194566535727(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535728_1194566535728(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refNode_sourceNodeQuery_1194566535729(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535730_1194566535730(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535732_1194566535732(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1194566535733_1194566535733(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refCell_includeTemplate_1194566535734(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1200912281134_1200912281134(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_Constant_1200912281135_1200912281135(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_refCell_mappingLabel_1200912281136(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static class _Inline6568_0 extends AbstractCellProvider {

    public _Inline6568_0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1194566535736(context, node);
    }

    public EditorCell createProperty1194566535736_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1194566535736(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1194566535736((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1194566535736(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1194566535736_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1194566535736(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("property_name");
      Styles_StyleSheet.getReference(editorCell).apply(editorCell);
    }

    private static void setupLabel_property_name_1194566535736(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}
  public static class _Inline6568_1 extends AbstractCellProvider {

    public _Inline6568_1() {
      super();
    }

    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createProperty1200912281138(context, node);
    }

    public EditorCell createProperty1200912281138_internal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      setupBasic_property_name1200912281138(editorCell, node, context);
      if (editorCell instanceof EditorCell_Label) {
        setupLabel_property_name_1200912281138((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createProperty1200912281138(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("<no name>");
      provider.setReadOnly(true);
      provider.setAllowsEmptyTarget(false);
      EditorCell cellWithRole = this.createProperty1200912281138_internal(context, node, provider);
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = context.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
      } else
      return cellWithRole;
    }


    private static void setupBasic_property_name1200912281138(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.setCellId("property_name");
      {
        Style inlineStyle = new Style(editorCell) {
          {
            this.set(StyleAttributes.TEXT_BACKGROUND_COLOR, MPSColors.orange);
          }

        };
        inlineStyle.apply(editorCell);
      }
    }

    private static void setupLabel_property_name_1200912281138(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }

}
  public static class IncludeMacro_Editor_replaceWith_NodeMacro_cellMenu0 extends AbstractCellMenuPart_ReplaceNode_CustomNodeConcept {

    public IncludeMacro_Editor_replaceWith_NodeMacro_cellMenu0() {
    }

    public String getReplacementConceptName() {
      return "jetbrains.mps.lang.generator.structure.NodeMacro";
    }

}

}
