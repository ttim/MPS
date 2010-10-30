package jetbrains.mps.baseLanguage.tuples.editor;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.DefaultNodeEditor;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.cells.EditorCell_Collection;
import jetbrains.mps.nodeEditor.style.Style;
import jetbrains.mps.nodeEditor.style.StyleAttributes;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;
import jetbrains.mps.baseLanguage.editor.BaseLanguageStyle_StyleSheet;
import jetbrains.mps.nodeEditor.cellProviders.AbstractCellListHandler;
import jetbrains.mps.nodeEditor.cellLayout.CellLayout_Indent;
import jetbrains.mps.nodeEditor.cellProviders.CellProviderWithRole;
import jetbrains.mps.lang.editor.cellProviders.RefCellCellProvider;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.nodeEditor.EditorManager;
import jetbrains.mps.lang.editor.cellProviders.ConceptPropertyCellProvider;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.nodeEditor.InlineCellProvider;
import jetbrains.mps.nodeEditor.cells.EditorCell_Property;
import jetbrains.mps.nodeEditor.cells.ModelAccessor;
import jetbrains.mps.baseLanguage.tuples.behavior.NamedTupleDeclaration_Behavior;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.EqualUtil;
import jetbrains.mps.nodeEditor.CellActionType;
import jetbrains.mps.nodeEditor.cellActions.CellAction_Empty;
import jetbrains.mps.lang.editor.cellProviders.PropertyCellProvider;
import jetbrains.mps.nodeEditor.AbstractCellProvider;
import jetbrains.mps.baseLanguage.editor._GenericDeclaration_TypeVariables_Component;
import jetbrains.mps.internal.collections.runtime.IterableUtils;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandler;
import jetbrains.mps.smodel.action.NodeFactoryManager;
import jetbrains.mps.nodeEditor.cellActions.CellAction_DeleteNode;
import jetbrains.mps.lang.editor.cellProviders.RefNodeListHandlerElementKeyMap;
import jetbrains.mps.nodeEditor.cellMenu.DefaultReferenceSubstituteInfo;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;

public class NamedTupleType_Editor extends DefaultNodeEditor {
  public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
    return this.createCollection_2ojjgh_a(editorContext, node);
  }

  public EditorCell createInspectedCell(EditorContext editorContext, SNode node) {
    return this.createCollection_2ojjgh_a_0(editorContext, node);
  }

  private EditorCell createCollection_2ojjgh_a(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_2ojjgh_a");
    editorCell.addEditorCell(this.createConceptProperty_2ojjgh_a0(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_2ojjgh_b0(editorContext, node));
    editorCell.addEditorCell(this.createConceptProperty_2ojjgh_c0(editorContext, node));
    if (renderingCondition_2ojjgh_a3a(node, editorContext, editorContext.getOperationContext().getScope())) {
      editorCell.addEditorCell(this.createCollection_2ojjgh_d0(editorContext, node));
    }
    return editorCell;
  }

  private EditorCell createCollection_2ojjgh_d0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_2ojjgh_d0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.addEditorCell(this.createConstant_2ojjgh_a3a(editorContext, node));
    editorCell.addEditorCell(this.createRefNodeList_2ojjgh_b3a(editorContext, node));
    editorCell.addEditorCell(this.createConstant_2ojjgh_c3a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_2ojjgh_a_0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_2ojjgh_a_0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.SELECTABLE, false);
    }
    editorCell.addEditorCell(this.createCollection_2ojjgh_a0(editorContext, node));
    editorCell.addEditorCell(this.createCollection_2ojjgh_b0(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_2ojjgh_a0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_2ojjgh_a0");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
    editorCell.addEditorCell(this.createConstant_2ojjgh_a0a(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_2ojjgh_b0a(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_2ojjgh_c0a(editorContext, node));
    return editorCell;
  }

  private EditorCell createCollection_2ojjgh_b0(EditorContext editorContext, SNode node) {
    EditorCell_Collection editorCell = EditorCell_Collection.createIndent2(editorContext, node);
    editorCell.setCellId("Collection_2ojjgh_b0");
    editorCell.addEditorCell(this.createConstant_2ojjgh_a1a(editorContext, node));
    editorCell.addEditorCell(this.createRefCell_2ojjgh_b1a(editorContext, node));
    return editorCell;
  }

  private EditorCell createConstant_2ojjgh_a3a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "<");
    editorCell.setCellId("Constant_2ojjgh_a3a");
    BaseLanguageStyle_StyleSheet.getBaseAngleBracket(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_RIGHT, true);
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_2ojjgh_c3a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, ">");
    editorCell.setCellId("Constant_2ojjgh_c3a");
    BaseLanguageStyle_StyleSheet.getBaseAngleBracket(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.PUNCTUATION_LEFT, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_2ojjgh_a0a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "declaration:");
    editorCell.setCellId("Constant_2ojjgh_a0a");
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createConstant_2ojjgh_a1a(EditorContext editorContext, SNode node) {
    EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, node, "components:");
    editorCell.setCellId("Constant_2ojjgh_a1a");
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.INDENT_LAYOUT_NEW_LINE, true);
    }
    editorCell.setDefaultText("");
    return editorCell;
  }

  private EditorCell createRefNodeList_2ojjgh_b3a(EditorContext editorContext, SNode node) {
    AbstractCellListHandler handler = new NamedTupleType_Editor.parameterTypeListHandler_2ojjgh_b3a(node, "parameterType", editorContext);
    EditorCell_Collection editorCell = handler.createCells(editorContext, new CellLayout_Indent(), false);
    editorCell.setCellId("refNodeList_parameterType");
    editorCell.setRole(handler.getElementRole());
    return editorCell;
  }

  private EditorCell createRefCell_2ojjgh_b0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("tupleDeclaration");
    provider.setNoTargetText("<no tupleDeclaration>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new NamedTupleType_Editor._Inline_2ojjgh_a1a());
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefCell_2ojjgh_b0a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("tupleDeclaration");
    provider.setNoTargetText("<no tupleDeclaration>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new NamedTupleType_Editor._Inline_2ojjgh_a1a0());
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefCell_2ojjgh_c0a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("tupleDeclaration");
    provider.setNoTargetText("<no tupleDeclaration>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new NamedTupleType_Editor._Inline_2ojjgh_a2a0());
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createRefCell_2ojjgh_b1a(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new RefCellCellProvider(node, editorContext);
    provider.setRole("tupleDeclaration");
    provider.setNoTargetText("<no tupleDeclaration>");
    EditorCell editorCell;
    provider.setAuxiliaryCellProvider(new NamedTupleType_Editor._Inline_2ojjgh_a1b0());
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createConceptProperty_2ojjgh_a0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new ConceptPropertyCellProvider(node, editorContext);
    provider.setRole("leftBracket");
    provider.setNoTargetText("<no leftBracket>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("conceptProperty_leftBracket");
    BaseLanguageStyle_StyleSheet.getLeftBracket(editorCell).apply(editorCell);
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private EditorCell createConceptProperty_2ojjgh_c0(EditorContext editorContext, SNode node) {
    CellProviderWithRole provider = new ConceptPropertyCellProvider(node, editorContext);
    provider.setRole("rightBracket");
    provider.setNoTargetText("<no rightBracket>");
    EditorCell editorCell;
    editorCell = provider.createEditorCell(editorContext);
    editorCell.setCellId("conceptProperty_rightBracket");
    BaseLanguageStyle_StyleSheet.getRightBracket(editorCell).apply(editorCell);
    {
      Style style = editorCell.getStyle();
      style.set(StyleAttributes.RT_ANCHOR_TAG, "default_RTransform");
    }
    editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
    SNode attributeConcept = provider.getRoleAttribute();
    Class attributeKind = provider.getRoleAttributeClass();
    if (attributeConcept != null) {
      IOperationContext opContext = editorContext.getOperationContext();
      EditorManager manager = EditorManager.getInstanceFromContext(opContext);
      return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
    } else
    return editorCell;
  }

  private static boolean renderingCondition_2ojjgh_a3a(SNode node, EditorContext editorContext, IScope scope) {
    return ListSequence.fromList(SLinkOperations.getTargets(node, "parameter", true)).count() > 0;
  }

  public static class _Inline_2ojjgh_a1a extends InlineCellProvider {
    public _Inline_2ojjgh_a1a() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createReadOnlyModelAccessor_2ojjgh_a0b0(editorContext, node);
    }

    private EditorCell createReadOnlyModelAccessor_2ojjgh_a0b0(final EditorContext editorContext, final SNode node) {
      EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {
        public String getText() {
          StringBuilder sb = new StringBuilder();
          String sep = "";
          for (SNode ntcd : ListSequence.fromList(NamedTupleDeclaration_Behavior.call_allExtends_3142843783245461132(node)).reversedList().translate(new ITranslator2<SNode, SNode>() {
            public Iterable<SNode> translate(SNode ntd) {
              return SLinkOperations.getTargets(ntd, "component", true);
            }
          })) {
            sb.append(sep).append(SPropertyOperations.getString(ntcd, "name"));
            sep = ", ";
          }
          return sb.toString();
        }

        public void setText(String s) {
        }

        public boolean isValidText(String s) {
          return EqualUtil.equals(s, this.getText());
        }
      }, node);
      editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
      editorCell.setCellId("ReadOnlyModelAccessor_2ojjgh_a0b0");
      {
        Style style = editorCell.getStyle();
        style.set(StyleAttributes.EDITABLE, false);
      }
      return editorCell;
    }
  }

  public static class _Inline_2ojjgh_a1a0 extends InlineCellProvider {
    public _Inline_2ojjgh_a1a0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createProperty_2ojjgh_a0b0a(editorContext, node);
    }

    private EditorCell createProperty_2ojjgh_a0b0a(EditorContext editorContext, SNode node) {
      CellProviderWithRole provider = new PropertyCellProvider(node, editorContext);
      provider.setRole("nestedName");
      provider.setNoTargetText("<no nestedName>");
      provider.setReadOnly(true);
      EditorCell editorCell;
      editorCell = provider.createEditorCell(editorContext);
      editorCell.setCellId("property_nestedName");
      editorCell.setSubstituteInfo(provider.createDefaultSubstituteInfo());
      SNode attributeConcept = provider.getRoleAttribute();
      Class attributeKind = provider.getRoleAttributeClass();
      if (attributeConcept != null) {
        IOperationContext opContext = editorContext.getOperationContext();
        EditorManager manager = EditorManager.getInstanceFromContext(opContext);
        return manager.createRoleAttributeCell(editorContext, attributeConcept, attributeKind, editorCell);
      } else
      return editorCell;
    }
  }

  public static class _Inline_2ojjgh_a2a0 extends InlineCellProvider {
    public _Inline_2ojjgh_a2a0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createCollection_2ojjgh_a0c0a(editorContext, node);
    }

    private EditorCell createCollection_2ojjgh_a0c0a(EditorContext editorContext, SNode node) {
      EditorCell_Collection editorCell = EditorCell_Collection.createHorizontal(editorContext, node);
      editorCell.setCellId("Collection_2ojjgh_a0c0a");
      if (renderingCondition_2ojjgh_a0a0c0a(node, editorContext, editorContext.getOperationContext().getScope())) {
        editorCell.addEditorCell(this.createComponent_2ojjgh_a0a2a0(editorContext, node));
      }
      return editorCell;
    }

    private EditorCell createComponent_2ojjgh_a0a2a0(EditorContext editorContext, SNode node) {
      AbstractCellProvider provider = new _GenericDeclaration_TypeVariables_Component(node);
      EditorCell editorCell = provider.createEditorCell(editorContext);
      return editorCell;
    }

    private static boolean renderingCondition_2ojjgh_a0a0c0a(SNode node, EditorContext editorContext, IScope scope) {
      return ListSequence.fromList(SLinkOperations.getTargets(node, "typeVariableDeclaration", true)).count() > 0;
    }
  }

  public static class _Inline_2ojjgh_a1b0 extends InlineCellProvider {
    public _Inline_2ojjgh_a1b0() {
      super();
    }

    public EditorCell createEditorCell(EditorContext editorContext) {
      return this.createEditorCell(editorContext, this.getSNode());
    }

    public EditorCell createEditorCell(EditorContext editorContext, SNode node) {
      return this.createReadOnlyModelAccessor_2ojjgh_a0b1a(editorContext, node);
    }

    private EditorCell createReadOnlyModelAccessor_2ojjgh_a0b1a(final EditorContext editorContext, final SNode node) {
      EditorCell_Property editorCell = EditorCell_Property.create(editorContext, new ModelAccessor() {
        public String getText() {
          return IterableUtils.join(ListSequence.fromList(NamedTupleDeclaration_Behavior.call_allExtends_3142843783245461132(node)).reversedList().translate(new ITranslator2<SNode, SNode>() {
            public Iterable<SNode> translate(SNode ntd) {
              return SLinkOperations.getTargets(ntd, "component", true);
            }
          }).select(new ISelector<SNode, String>() {
            public String select(SNode c) {
              return ((SPropertyOperations.getBoolean(c, "final") ?
                "final " :
                ""
              )) + BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(c, "type", true)) + " " + SPropertyOperations.getString(c, "name") + ";";
            }
          }), "\n");
        }

        public void setText(String s) {
        }

        public boolean isValidText(String s) {
          return EqualUtil.equals(s, this.getText());
        }
      }, node);
      editorCell.setAction(CellActionType.DELETE, new CellAction_Empty());
      editorCell.setCellId("ReadOnlyModelAccessor_2ojjgh_a0b1a");
      return editorCell;
    }
  }

  private static class parameterTypeListHandler_2ojjgh_b3a extends RefNodeListHandler {
    public parameterTypeListHandler_2ojjgh_b3a(SNode ownerNode, String childRole, EditorContext context) {
      super(ownerNode, childRole, context, false);
    }

    public SNode createNodeToInsert(EditorContext editorContext) {
      SNode listOwner = super.getOwner();
      return NodeFactoryManager.createNode(listOwner, editorContext, super.getElementRole());
    }

    public EditorCell createNodeCell(EditorContext editorContext, SNode elementNode) {
      EditorCell elementCell = super.createNodeCell(editorContext, elementNode);
      this.installElementCellActions(this.getOwner(), elementNode, elementCell, editorContext);
      return elementCell;
    }

    public EditorCell createEmptyCell(EditorContext editorContext) {
      EditorCell emptyCell = null;
      emptyCell = super.createEmptyCell(editorContext);
      this.installElementCellActions(super.getOwner(), null, emptyCell, editorContext);
      return emptyCell;
    }

    public void installElementCellActions(SNode listOwner, SNode elementNode, EditorCell elementCell, EditorContext editorContext) {
      if (elementCell.getUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET) == null) {
        elementCell.putUserObject(AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET, AbstractCellListHandler.ELEMENT_CELL_ACTIONS_SET);
        SNode substituteInfoNode = listOwner;
        if (elementNode != null) {
          substituteInfoNode = elementNode;
          elementCell.setAction(CellActionType.DELETE, new CellAction_DeleteNode(elementNode));
          elementCell.addKeyMap(new RefNodeListHandlerElementKeyMap(this, ","));
        }
        if (elementCell.getSubstituteInfo() == null || elementCell.getSubstituteInfo() instanceof DefaultReferenceSubstituteInfo) {
          elementCell.setSubstituteInfo(new DefaultChildSubstituteInfo(listOwner, elementNode, super.getLinkDeclaration(), editorContext));
        }
      }
    }

    @Override
    public EditorCell createSeparatorCell(EditorContext editorContext, SNode node) {
      EditorCell_Constant editorCell = new EditorCell_Constant(editorContext, this.getOwner(), ",");
      editorCell.setSelectable(false);
      editorCell.getStyle().set(StyleAttributes.LAYOUT_CONSTRAINT, "");
      editorCell.getStyle().set(StyleAttributes.PUNCTUATION_LEFT, true);
      return editorCell;
    }
  }
}
