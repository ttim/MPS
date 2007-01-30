package jetbrains.mps.nodeEditor;

import jetbrains.mps.annotations.AttributeConcept;
import jetbrains.mps.annotations.LinkAttributeConcept;
import jetbrains.mps.annotations.PropertyAttributeConcept;
import jetbrains.mps.bootstrap.structureLanguage.AnnotationLinkDeclaration;
import jetbrains.mps.ide.command.CommandProcessor;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.*;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.ModelActions;
import jetbrains.mps.smodel.action.NodeSubstituteActionWrapper;
import jetbrains.mps.smodel.event.SModelChildEvent;
import jetbrains.mps.smodel.event.SModelEvent;
import jetbrains.mps.smodel.event.SModelPropertyEvent;
import jetbrains.mps.smodel.event.SModelReferenceEvent;
import jetbrains.mps.nodeEditor.cellMenu.DefaultAttributeSubstituteInfo;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.*;


/**
 * Author: Sergey Dmitriev.
 * Time: Nov 7, 2003 7:06:31 PM
 */
public class EditorManager {
  private static final Logger LOG = Logger.getLogger(EditorManager.class);

  public static final Object BIG_CELL_CONTEXT = new Object();

  public static final Object RIGHT_TRANSFORM_HINT_JUST_ADDED = new Object();
  public static final Object RIGHT_TRANSFORM_HINT_ANCHOR_CELL_ID = new Object();
  public static final Object RIGHT_TRANSFORM_HINT_ANCHOR_TAG = new Object();

  private HashMap<ReferencedNodeContext, EditorCell> myMap = new HashMap<ReferencedNodeContext, EditorCell>();
  private boolean myCreatingInspectedCell = false;

  private Map<Class, Stack<EditorCell>> myAttributedClassesToAttributedCellStacksMap = new HashMap<Class, Stack<EditorCell>>();

  private Stack<SNode> myAttributesStack = new Stack<SNode>();

  public static EditorManager getInstanceFromContext(IOperationContext operationContext) {
    return operationContext.getComponent(EditorManager.class);
  }

  /*package*/ EditorCell createRootCell(EditorContext context, SNode node, List<SModelEvent> events) {
    return createRootCell(context, node, events, false);
  }


  private EditorCell createRootCell(EditorContext context, SNode node, List<SModelEvent> events, boolean isInspectorCell) {
    try {
      AbstractEditorComponent nodeEditorComponent = context.getNodeEditorComponent();
      EditorCell rootCell = nodeEditorComponent.getRootCell();
      ReferencedNodeContext refContext = ReferencedNodeContext.createNodeContext(node);
      myMap.clear();
      myMap.put(refContext, rootCell);
      myCreatingInspectedCell = isInspectorCell;
      return createEditorCell(context, events, refContext);
    } finally {
      myMap.clear();
    }
  }


  private static Map<ReferencedNodeContext, EditorCell> findBigDescendantCellsAndTheirNodes(EditorCell cell) {
    Map<ReferencedNodeContext, EditorCell> result = new HashMap<ReferencedNodeContext, EditorCell>();
    if (cell instanceof EditorCell_Collection) {
      for (EditorCell childCell : ((EditorCell_Collection) cell)) {
        Object bigCellContext = childCell.getUserObject(BIG_CELL_CONTEXT);
        if (bigCellContext instanceof ReferencedNodeContext) {
          ReferencedNodeContext refContext = (ReferencedNodeContext) bigCellContext;
          result.put(refContext, childCell);
        } else {
          result.putAll(findBigDescendantCellsAndTheirNodes(childCell));
        }
      }
    }
    return result;
  }

  //creating a cell for attributed property
  public EditorCell createPropertyAttributeCell(EditorContext context, SNode propertyAttribute, EditorCell propertyCell) {
    return createRoleAttributeCell(context, propertyAttribute, PropertyAttributeConcept.class, propertyCell);
  }

  //creating a cell for attributed link
  public EditorCell createLinkAttributeCell(EditorContext context, SNode linkAttribute, EditorCell refCell) {
    return createRoleAttributeCell(context, linkAttribute, LinkAttributeConcept.class, refCell);
  }

  public EditorCell getCurrentAttributedPropertyCell() {
    return getCurrentAttributedCellWithRole(PropertyAttributeConcept.class);
  }

  public EditorCell getCurrentAttributedLinkCell() {
    return getCurrentAttributedCellWithRole(LinkAttributeConcept.class);
  }

  public EditorCell getCurrentAttributedNodeCell() {
    return getCurrentAttributedCellWithRole(AttributeConcept.class);
  }

  // use parameter attributeClass carefully, it is a "kind" of an attribute rather than an exact class of an attribute
  public EditorCell createRoleAttributeCell(EditorContext context, SNode roleAttribute, Class attributeClass, EditorCell cellWithRole) {
    return context.createRoleAttributeCell(attributeClass, cellWithRole, roleAttribute);
  }

  /*package*/ EditorCell doCreateRoleAttributeCell(Class attributeClass, EditorCell cellWithRole, EditorContext context, SNode roleAttribute) {
    Stack<EditorCell> stack = myAttributedClassesToAttributedCellStacksMap.get(attributeClass);
    if (stack == null) {
      stack = new Stack<EditorCell>();
      myAttributedClassesToAttributedCellStacksMap.put(attributeClass, stack);
    }
    stack.push(cellWithRole);
    EditorCell result = createEditorCell(context, null, ReferencedNodeContext.createNodeContext(roleAttribute));
    EditorCell cellWithRolePopped = stack.pop();
    LOG.assertLog(cellWithRolePopped == cellWithRole);
    //setting substitute info
    AnnotationLinkDeclaration linkDeclaration = roleAttribute.findAnnotationLinkDeclaration(context.getOperationContext().getScope());
    if (linkDeclaration != null) {
      DefaultAttributeSubstituteInfo substituteInfo = new DefaultAttributeSubstituteInfo(cellWithRole.getSNode(), roleAttribute, linkDeclaration, context);
      result.setSubstituteInfo(substituteInfo);
      if (result instanceof EditorCell_Collection) {
        if (((EditorCell_Collection)result).containsCell(cellWithRole)) {
          for (EditorCell cell : ((EditorCell_Collection)result).contentCells()) {
            if (cell != cellWithRole && cell.getSubstituteInfo() == null) {
              cell.setSubstituteInfo(substituteInfo);
            }
          }
        }
      }
    }
    return result;
  }

  public EditorCell createNodeAttributeCell(EditorContext context, SNode attribute, EditorCell nodeCell) {
    return createRoleAttributeCell(context, attribute, AttributeConcept.class, nodeCell);
  }

  public EditorCell getCurrentAttributedCellWithRole(Class attributeClass) {
    Stack<EditorCell> stack = myAttributedClassesToAttributedCellStacksMap.get(attributeClass);
    if (stack == null) {
      stack = new Stack<EditorCell>();
      myAttributedClassesToAttributedCellStacksMap.put(attributeClass, stack);
    }
    return stack.isEmpty() ? null : stack.peek();
  }


  /*package*/ EditorCell createEditorCell(EditorContext context, List<SModelEvent> events, ReferencedNodeContext refContext) {
    SNode node = refContext.getNode();

    for (SNode attribute : node.getNodeAttributes()) {
      //if the whole node has attribute
      if (attribute != null) {
        //if creating this cell for this attribute for the first time
        if (!myAttributesStack.contains(attribute)) {
          myAttributesStack.push(attribute);
          EditorCell nodeCell = createEditorCell(context, events, refContext.contextWithOneMoreAttribute(attribute));
          EditorCell result = createNodeAttributeCell(context, attribute, nodeCell);
          SNode poppedAttribute = myAttributesStack.pop();
          LOG.assertLog(poppedAttribute == attribute);
          return result;
        }
      }
    }

    AbstractEditorComponent nodeEditorComponent = context.getNodeEditorComponent();
    EditorCell oldCell = nodeEditorComponent.getBigCellForRefContext(refContext);
    if (events != null) {
      boolean nodeChanged = false;
      for (SModelEvent event : events) {
        SNode eventNode;
        if (event instanceof SModelChildEvent) {
          eventNode = ((SModelChildEvent) event).getParent();
        } else if (event instanceof SModelReferenceEvent) {
          eventNode = ((SModelReferenceEvent) event).getReference().getSourceNode();
        } else if (event instanceof SModelPropertyEvent) {
          eventNode = ((SModelPropertyEvent) event).getNode();
        } else continue;
        if (nodeEditorComponent.doesCellDependOnNode(oldCell, eventNode)) {
          nodeChanged = true;
          break;
        }
      }

      if (!nodeChanged) {
        if (myMap.containsKey(refContext)) {
          EditorCell editorCell = myMap.get(refContext);
          final Set<SNode> nodesOldCellDependsOn = nodeEditorComponent.getCopyOfNodesCellDependsOn(editorCell);
          final Set<SNodeProxy> refTargetsOldCellDependsOn = nodeEditorComponent.getCopyOfRefTargetsCellDependsOn(editorCell);
          if (nodesOldCellDependsOn != null || refTargetsOldCellDependsOn != null) {
            //voodoo for editor incremental rebuild support:
            // add listen-nothing listener, fill it up,
            // remove listener to report recorded nodes to parent listener
            CellBuildNodeAccessListener listensNothingListener = new CellBuildNodeAccessListener(nodeEditorComponent);
            NodeReadAccessCaster.setCellBuildNodeReadAccessListener(listensNothingListener);
            if (nodesOldCellDependsOn != null) listensNothingListener.addNodesToDependOn(nodesOldCellDependsOn);
            if (refTargetsOldCellDependsOn != null)
              listensNothingListener.addRefTargetsToDependOn(refTargetsOldCellDependsOn);
            NodeReadAccessCaster.removeCellBuildNodeAccessListener();
            //--voodoo
          }
          return editorCell;
        }
      } else {
        myMap.putAll(findBigDescendantCellsAndTheirNodes(oldCell));
      }
    }

    nodeEditorComponent.clearNodesCellDependsOn(oldCell);

    return createEditorCell_internal(context, myCreatingInspectedCell, refContext);
  }


  private EditorCell createEditorCell_internal(final EditorContext context, boolean isInspectorCell, ReferencedNodeContext refContext) {
    final SNode node = refContext.getNode();

    //reset creating inspected cell : we don't create not-root inspected cells
    myCreatingInspectedCell = false;

    INodeEditor editor = getEditor(context, node);
    AbstractEditorComponent abstractEditorComponent = context.getNodeEditorComponent();
    EditorCell nodeCell = null;
    CellBuildNodeAccessListener nodeAccessListener = new CellBuildNodeAccessListener(abstractEditorComponent);
    try {
      //voodoo for editor incremental rebuild support
      NodeReadAccessCaster.setCellBuildNodeReadAccessListener(nodeAccessListener);
      nodeCell = isInspectorCell ? editor.createInspectedCell(context, node) : editor.createEditorCell(context, node);
      //-voodoo
    } catch (Exception e) {
      LOG.error("Failed to create cell for node " + node.getDebugText(), e);
      nodeCell = EditorCell_Error.create(context, node, "!exception!:" + node.getDebugText());
    } finally {
      if (nodeCell != null) {
        nodeCell.putUserObject(BIG_CELL_CONTEXT, refContext);
        abstractEditorComponent.registerAsBigCell(nodeCell, refContext);
        nodeAccessListener.recordingFinishedForCell(nodeCell);
      }
      NodeReadAccessCaster.removeCellBuildNodeAccessListener();
    }

    if (node.hasRightTransformHint()) {
      nodeCell = addRightTransformHintCell(node, nodeCell, context);
      return nodeCell;
    }

    assert nodeCell != null;
    nodeCell.setInspectorCell(isInspectorCell);
    return nodeCell;
  }

  private EditorCell addRightTransformHintCell(final SNode node, EditorCell nodeCell, final EditorContext context) {
    // create the hint cell
    final EditorCell_RTHint rightTransformHintCell = EditorCell_RTHint.create(context, node);
    final CellInfo nodeCellInfo = context.getNodeEditorComponent().getRecentlySelectedCellInfo();

    // delete the hint when pressed ctrl-delete, delete or backspace
    rightTransformHintCell.setAction(EditorCellAction.DELETE, new EditorCellAction() {
      public void execute(final EditorContext context) {
        removeRTHintAndChangeSelection(context, node, nodeCellInfo);
      }
    });
    // delete the hint when double press 'space'
    rightTransformHintCell.setAction(EditorCellAction.RIGHT_TRANSFORM, new EditorCellAction() {
      public void execute(EditorContext context) {
        removeRTHintAndChangeSelection(context, node, nodeCellInfo);
      }
    });
    // delete the hint when double press 'esc'
    EditorCellKeyMap keyMap = new EditorCellKeyMap();
    keyMap.putAction(EditorCellKeyMap.KEY_MODIFIERS_NONE, "VK_ESCAPE", new EditorCellKeyMapAction() {
      public void execute(KeyEvent keyEvent, final EditorContext context) {
        removeRTHintAndChangeSelection(context, node, nodeCellInfo);
      }
    });
    rightTransformHintCell.addKeyMap(keyMap);

    // create the hint's auto-completion menu
    final String transformTag = (String) node.getUserObject(RIGHT_TRANSFORM_HINT_ANCHOR_TAG);
    rightTransformHintCell.setSubstituteInfo(new AbstractNodeSubstituteInfo(context) {
      protected List<INodeSubstituteAction> createActions() {
        List list = ModelActions.createRightTransformHintSubstituteActions(node, transformTag, context.getOperationContext());
        List wrapperList = new LinkedList();
        for (Object action : list) {
          wrapperList.add(new NodeSubstituteActionWrapper((INodeSubstituteAction) action) {
            public SNode doSubstitute(String pattern) {
              node.removeRightTransformHint();
              return super.doSubstitute(pattern);
            }
          });
        }
        return wrapperList;
      }
    });

    // decide position of the hint cell
    EditorCell resultCell;
    Object anchorId = node.getUserObject(RIGHT_TRANSFORM_HINT_ANCHOR_CELL_ID);
    EditorCell anchorCell = anchorId == null ? null : context.getNodeEditorComponent().findCellWithId(nodeCell, anchorId.toString());
    if (anchorCell != null && anchorCell != nodeCell) {
      EditorCell_Collection cellCollection = anchorCell.getParent();
      cellCollection.addCellAt(cellCollection.indexOf(anchorCell) + 1, rightTransformHintCell);
      resultCell = nodeCell;
      rightTransformHintCell.setAnchor(anchorCell);
    } else {
      // couldn't insert hint cell - create wrapper collection and put hint to last position
      EditorCell_Collection rowWrapper = EditorCell_Collection.createHorizontal(context, node);
      rowWrapper.setSelectable(false);
      rowWrapper.setDrawBorder(false);
      rowWrapper.addEditorCell(nodeCell);
      rowWrapper.addEditorCell(rightTransformHintCell);
      resultCell = rowWrapper;
      rightTransformHintCell.setAnchor(nodeCell);
    }

    // set focus
    if (node.getUserObject(RIGHT_TRANSFORM_HINT_JUST_ADDED) != null) {
      CommandProcessor.instance().invokeLater(new Runnable() {
        public void run() {
          node.removeUserObject(RIGHT_TRANSFORM_HINT_JUST_ADDED);
          if (node.hasRightTransformHint()) {
            context.getNodeEditorComponent().changeSelection(rightTransformHintCell);
          }
        }
      });
    }
    return resultCell;
  }

  private void removeRTHintAndChangeSelection(final EditorContext context, SNode node, final CellInfo cellInfoToSelect) {
    node.removeRightTransformHint();
    CommandProcessor.instance().invokeLater(new Runnable() {
      public void run() {
        AbstractEditorComponent nodeEditorComponent = context.getNodeEditorComponent();
        if (cellInfoToSelect == null) return;
        EditorCell newlySelectedCell = cellInfoToSelect.findCell(nodeEditorComponent);
        EditorCell nextSelectableCell = nodeEditorComponent.findNextSelectableCell(newlySelectedCell);
        if (nextSelectableCell != null) {
          context.getNodeEditorComponent().changeSelection(nextSelectableCell);
          if (nextSelectableCell instanceof EditorCell_Label) {
            ((EditorCell_Label) nextSelectableCell).getRenderedTextLine().setCaretPosition(0);
          }
        } else {
          if (newlySelectedCell == null) return;
          context.getNodeEditorComponent().changeSelection(newlySelectedCell);
          if (newlySelectedCell instanceof EditorCell_Label) {
            ((EditorCell_Label) newlySelectedCell).getRenderedTextLine().setCaretPositionToLast();
          }
        }
      }
    });
  }


  /*package*/ static class EditorCell_RTHint extends EditorCell_Constant {

    private EditorCell myAnchorCell;

    protected EditorCell_RTHint(EditorContext editorContext, SNode node) {
      super(editorContext, node, "", true);
      putUserObject(EditorCell.CELL_ID, node.getId());
      setEditable(true);
      setDrawBorder(false);
      setCellBackgroundColor(Color.YELLOW);
      setCellInfoProvider(new ICellInfoProvider() {
        public CellInfo getCellInfo(EditorCell cell) {
          return new RTHintCellInfo(EditorCell_RTHint.this, myAnchorCell);
        }
      });
    }

    private void setAnchor(EditorCell anchorCell) {
      myAnchorCell = anchorCell;
    }

    public static EditorCell_RTHint create(EditorContext editorContext, SNode node) {
      return new EditorCell_RTHint(editorContext, node);
    }

  }


  /*package*/ EditorCell createInspectedCell(EditorContext context, SNode node, List<SModelEvent> events) {
    return createRootCell(context, node, events, true);
  }


  private INodeEditor getEditor(EditorContext context, SNode node) {
    INodeEditor editor = null;//(INodeEditor) node.getUserObject(this.getClass());
/*

    if (editor != null &&
            editor.getClass().getClassLoader() != ClassLoaderManager.getInstance().getClassLoader() &&
            editor.getClass().getClassLoader() != ClassLoader.getSystemClassLoader()) {
      //some editors can be loaded from system class loader i
      //and some editors may be reloaded (project language classses)
      //if editor don't loaded from one of this classLoaders it has to be reloaded

      editor = null;
    }
*/

  /*  if (editor != null) {
      return editor;
    }*/

    editor = EditorsFinderManager.loadEditor(context, node);
    if (editor == null) {
      editor = new DefaultNodeEditor();
    }
//    node.putUserObject(this.getClass(), editor);
    return editor;
  }


  public static class NoAttribute {
  }


  private static class RTHintCellInfo extends CellInfo {
    CellInfo myAnchorCellInfo;

    public RTHintCellInfo(EditorCell_Constant rightTransformHintCell, EditorCell anchorCell) {
      super(rightTransformHintCell);
      myAnchorCellInfo = anchorCell.getCellInfo();
    }

    public EditorCell findCell(AbstractEditorComponent editorComponent) {
      EditorCell anchorCell = myAnchorCellInfo.findCell(editorComponent);
      if (anchorCell == null) return super.findCell(editorComponent);
      EditorCell_Collection parent = anchorCell.getParent();
      return parent.getCellAt(parent.indexOf(anchorCell) + 1);
    }
  }
}
