package jetbrains.mps.ypath.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.EditorCell;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.EditorCell_Label;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.EditorCell_Collection;
import jetbrains.mps.nodeEditor.EditorCell_Constant;
import jetbrains.mps.nodeEditor.ModelAccessor;
import jetbrains.mps.nodeEditor.EditorCell_Property;
import jetbrains.mps.nodeEditor.EditorCellAction;
import jetbrains.mps.nodeEditor.CellAction_Empty;
import jetbrains.mps.nodeEditor.cellMenu.CompositeSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.BasicCellContext;
import jetbrains.mps.nodeEditor.cellMenu.ISubstituteInfoPart;
import jetbrains.mps.ypath.constraints.IterateOperation_Behavior;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.RefNodeCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.generator.internal.AbstractCellMenuPart_Generic_Group;
import java.util.List;
import jetbrains.mps.ypath.structure.TraversalAxis;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.ypath.actions.TraversalAxisUtil;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.bootstrap.editorLanguage.cellProviders.PropertyCellProvider;

public class IterateOperation_Editor extends DefaultNodeEditor {

  private static void setupBasic_CellModel_ModelAccess(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1178981885129");
  }

  private static void setupBasic_ConstantCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184097777346");
  }

  private static void setupBasic_ConstantCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184097796290");
  }

  private static void setupBasic_UsedFeatureReferenceCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184148227201");
  }

  private static void setupBasic_ConstantCell2(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184764917105");
  }

  private static void setupBasic_ParamObjectCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184776090885");
  }

  private static void setupBasic_ConstantCell3(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184097827075");
  }

  private static void setupBasic_RowCell1(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184097790446");
  }

  private static void setupBasic_CellAlternation(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184097745865");
  }

  private static void setupBasic_RowCell(EditorCell editorCell, SNode node, EditorContext context) {
    editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1178981885128");
    editorCell.setSelectable(false);
    editorCell.addKeyMap(new keymap_IterateOperation());
  }

  private static void setupLabel_CellModel_ModelAccess(EditorCell_Label editorCell, SNode node, EditorContext context) {
    editorCell.setEditable(false);
  }

  private static void setupLabel_ConstantCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell1(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_UsedFeatureReferenceCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell2(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ParamObjectCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  private static void setupLabel_ConstantCell3(EditorCell_Label editorCell, SNode node, EditorContext context) {
  }

  public static boolean _QueryFunction_NodeCondition_1184097745867(SNode node, EditorContext editorContext, IScope scope) {
    return SPropertyOperations.getBoolean(node, "useDefault");
  }

  public static boolean _QueryFunction_NodeCondition_1184764924426(SNode node, EditorContext editorContext, IScope scope) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "usedFeature", false), "jetbrains.mps.ypath.structure.IParamFeature");
  }

  public static boolean _QueryFunction_NodeCondition_1184776110519(SNode node, EditorContext editorContext, IScope scope) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(node, "usedFeature", false), "jetbrains.mps.ypath.structure.IParamFeature");
  }


  public EditorCell createEditorCell(EditorContext context, SNode node) {
    return this.createRowCell(context, node);
  }

  public EditorCell createCellAlternation(EditorContext context, SNode node) {
    boolean alternationCondition = true;
    alternationCondition = IterateOperation_Editor._QueryFunction_NodeCondition_1184097745867(node, context, context.getOperationContext().getScope());
    EditorCell editorCell = null;
    if(alternationCondition) {
      editorCell = this.createConstantCell(context, node, "!");
    } else
    {
      editorCell = this.createRowCell1(context, node);
    }
    IterateOperation_Editor.setupBasic_CellAlternation(editorCell, node, context);
    return editorCell;
  }

  public EditorCell createRowCell1(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    IterateOperation_Editor.setupBasic_RowCell1(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createConstantCell1(context, node, "("));
    editorCell.addEditorCell(this.createUsedFeatureReferenceCell(context, node));
    if(IterateOperation_Editor._QueryFunction_NodeCondition_1184764924426(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createConstantCell2(context, node, "/"));
    }
    if(IterateOperation_Editor._QueryFunction_NodeCondition_1184776110519(node, context, context.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createParamObjectCell(context, node));
    }
    editorCell.addEditorCell(this.createConstantCell3(context, node, ")"));
    return editorCell;
  }

  public EditorCell createRowCell(EditorContext context, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(context, node);
    IterateOperation_Editor.setupBasic_RowCell(editorCell, node, context);
    editorCell.setGridLayout(false);
    editorCell.setUsesBraces(false);
    editorCell.setCanBeFolded(false);
    editorCell.addEditorCell(this.createCellModel_ModelAccess(context, node));
    editorCell.addEditorCell(this.createCellAlternation(context, node));
    return editorCell;
  }

  public EditorCell createConstantCell(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    IterateOperation_Editor.setupBasic_ConstantCell(editorCell, node, context);
    IterateOperation_Editor.setupLabel_ConstantCell(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell1(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    IterateOperation_Editor.setupBasic_ConstantCell1(editorCell, node, context);
    IterateOperation_Editor.setupLabel_ConstantCell1(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell2(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    IterateOperation_Editor.setupBasic_ConstantCell2(editorCell, node, context);
    IterateOperation_Editor.setupLabel_ConstantCell2(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createConstantCell3(EditorContext context, SNode node, String text) {
    EditorCell_Constant editorCell = new EditorCell_Constant(context, node, text);
    IterateOperation_Editor.setupBasic_ConstantCell3(editorCell, node, context);
    IterateOperation_Editor.setupLabel_ConstantCell3(editorCell, node, context);
    editorCell.setDefaultText("");
    return editorCell;
  }

  public EditorCell createCellModel_ModelAccess(EditorContext context, SNode node) {
    ModelAccessor modelAccessor = this._modelAcessorFactory_1178981885129(context, node);
    EditorCell_Property editorCell = EditorCell_Property.create(context, modelAccessor, node);
    IterateOperation_Editor.setupBasic_CellModel_ModelAccess(editorCell, node, context);
    IterateOperation_Editor.setupLabel_CellModel_ModelAccess(editorCell, node, context);
    editorCell.setDefaultText("");
    editorCell.setAction(EditorCellAction.DELETE, new CellAction_Empty());
    editorCell.setSubstituteInfo(new CompositeSubstituteInfo(context, new BasicCellContext(node), new ISubstituteInfoPart[]{new IterateOperation_Editor.IterateOperation_generic_cellMenu()}));
    return editorCell;
  }

  public ModelAccessor _modelAcessorFactory_1178981885129(final EditorContext editorContext, final SNode node) {
    return new ModelAccessor() {

      public String getText() {
        return IterateOperation_Behavior.call_getAxisInternalValue_1178980580496(node);
      }

      public void setText(String text) {
      }

      public boolean isValidText(String text) {
        return IterateOperation_Behavior.call_getAxisInternalValue_1178980580496(node).equals(text);
      }

    };
  }

  public EditorCell createUsedFeatureReferenceCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(new IterateOperation_Editor._Inline());
    EditorCell editorCell = provider.createEditorCell(context);
    IterateOperation_Editor.setupBasic_UsedFeatureReferenceCell(editorCell, node, context);
    if(editorCell instanceof EditorCell_Label) {
      IterateOperation_Editor.setupLabel_UsedFeatureReferenceCell((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createUsedFeatureReferenceCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, context);
    provider.setRole("usedFeature");
    provider.setNoTargetText("*");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createUsedFeatureReferenceCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public EditorCell createParamObjectCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
    CellProviderWithRole provider = aProvider;
    provider.setAuxiliaryCellProvider(null);
    EditorCell editorCell = provider.createEditorCell(context);
    IterateOperation_Editor.setupBasic_ParamObjectCell(editorCell, node, context);
    if(editorCell instanceof EditorCell_Label) {
      IterateOperation_Editor.setupLabel_ParamObjectCell((EditorCell_Label)editorCell, node, context);
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    return editorCell;
  }

  public EditorCell createParamObjectCell(EditorContext context, SNode node) {
    CellProviderWithRole provider = new RefNodeCellProvider(node, context);
    provider.setRole("paramObject");
    provider.setNoTargetText("");
    provider.setReadOnly(false);
    provider.setAllowsEmptyTarget(false);
    EditorCell cellWithRole = this.createParamObjectCellinternal(context, node, provider);
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if(attributeConcept != null) {
      IOperationContext opContext = context.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(context, attributeConcept, attributeKind, cellWithRole);
    } else
    return cellWithRole;
  }

  public static class IterateOperation_generic_cellMenu extends AbstractCellMenuPart_Generic_Group {

    public  IterateOperation_generic_cellMenu() {
    }

    public List createParameterObjects(SNode node, IScope scope, IOperationContext operationContext) {
      return TraversalAxis.getConstants();
    }

    public void handleAction(Object parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      this.handleAction_impl((jetbrains.mps.ypath.runtime.TraversalAxis)parameterObject, node, model, scope, operationContext);
    }

    public void handleAction_impl(jetbrains.mps.ypath.runtime.TraversalAxis parameterObject, SNode node, SModel model, IScope scope, IOperationContext operationContext) {
      SPropertyOperations.set(node, "axis", parameterObject.getValue());
    }

    public boolean isReferentPresentation() {
      return false;
    }

    public String getMatchingText(Object parameterObject) {
      return this.getMatchingText_internal((jetbrains.mps.ypath.runtime.TraversalAxis)parameterObject);
    }

    public String getMatchingText_internal(jetbrains.mps.ypath.runtime.TraversalAxis parameterObject) {
      return TraversalAxisUtil.getOperationSign(parameterObject);
    }

    public String getDescriptionText(Object parameterObject) {
      return this.getDescriptionText_internal((jetbrains.mps.ypath.runtime.TraversalAxis)parameterObject);
    }

    public String getDescriptionText_internal(jetbrains.mps.ypath.runtime.TraversalAxis parameterObject) {
      return parameterObject.getName();
    }

}
  public static class _Inline extends AbstractCellProvider {

    public  _Inline() {
      super();
    }

    private static void setupBasic_NameCell(EditorCell editorCell, SNode node, EditorContext context) {
      editorCell.putUserObject(EditorCell.CELL_ID, node.getId() + "_1184148231079");
    }

    private static void setupLabel_NameCell(EditorCell_Label editorCell, SNode node, EditorContext context) {
    }


    public EditorCell createEditorCell(EditorContext context) {
      return this.createEditorCell(context, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext context, SNode node) {
      return this.createNameCell(context, node);
    }

    public EditorCell createNameCellinternal(EditorContext context, SNode node, CellProviderWithRole aProvider) {
      CellProviderWithRole provider = aProvider;
      provider.setAuxiliaryCellProvider(null);
      EditorCell editorCell = provider.createEditorCell(context);
      IterateOperation_Editor._Inline.setupBasic_NameCell(editorCell, node, context);
      if(editorCell instanceof EditorCell_Label) {
        IterateOperation_Editor._Inline.setupLabel_NameCell((EditorCell_Label)editorCell, node, context);
      }
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      return editorCell;
    }

    public EditorCell createNameCell(EditorContext context, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, context);
      provider.setRole("name");
      provider.setNoTargetText("");
      provider.setReadOnly(true);
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

}

}
