package jetbrains.mps.bootstrap.editorLanguage.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.action.NodeSubstitutePreconditionContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.editorLanguage.CellMenuUtil;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.action.NodeSetupContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.smodel.action.NodeSubstituteActionsFactoryContext;
import java.util.ArrayList;
import jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.smodel.action.ChildSubstituteActionsHelper;
import jetbrains.mps.smodel.action.DefaultSimpleSubstituteAction;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.smodel.BaseAdapter;
import jetbrains.mps.util.Calculable;
import jetbrains.mps.bootstrap.editorLanguage.constraints.BaseEditorComponent_Behavior;
import jetbrains.mps.smodel.action.DefaultChildNodeSubstituteAction;
import jetbrains.mps.bootstrap.editorLanguage.structure.CellActionId;

public class QueriesGenerated {

  public static boolean nodeSubstituteActionsBuilder_Precondition_CellMenuPart_Abstract_1199894693230(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode editedFeature = CellMenuUtil.getEditedFeature(_context.getParentNode());
    return SNodeOperations.isInstanceOf(editedFeature, "jetbrains.mps.bootstrap.structureLanguage.structure.PropertyDeclaration");
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_CellMenuPart_Abstract_1199894948366(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode editedFeature = CellMenuUtil.getEditedFeature(_context.getParentNode());
    return SNodeOperations.isInstanceOf(editedFeature, "jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration") && SPropertyOperations.hasValue(editedFeature, "metaClass", null, null);
  }

  public static boolean nodeSubstituteActionsBuilder_Precondition_CellMenuPart_Abstract_1199895015796(final IOperationContext operationContext, final NodeSubstitutePreconditionContext _context) {
    SNode editedFeature = CellMenuUtil.getEditedFeature(_context.getParentNode());
    return SNodeOperations.isInstanceOf(editedFeature, "jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration") && SPropertyOperations.hasValue(editedFeature, "metaClass", "aggregation", null);
  }

  public static void nodeFactory_NodeSetup_CellModel_Property_1158947460473(final IOperationContext operationContext, final NodeSetupContext _context) {
    SNode parentRefCell = SNodeOperations.getAncestor(_context.getEnclosingNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefCell", true, false);
    if(parentRefCell != null) {
      SPropertyOperations.set(_context.getNewNode(), "readOnly", "" + (true));
    }
  }

  public static void nodeFactory_NodeSetup_CellModel_Collection_1159287296419(final IOperationContext operationContext, final NodeSetupContext _context) {
    if(SNodeOperations.isInstanceOf(_context.getEnclosingNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection")) {
      SPropertyOperations.set(_context.getNewNode(), "selectable", "false");
    }
    if(SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel")) {
      SNode innerNode = SNodeOperations.copyNode(_context.getSampleNode());
      SLinkOperations.addChild(_context.getNewNode(), "childCellModel", innerNode);
      if(SNodeOperations.isInstanceOf(innerNode, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection")) {
        SPropertyOperations.set(innerNode, "selectable", "false");
      }
    }
  }

  public static void nodeFactory_NodeSetup_CellModel_Alternation_1165441265076(final IOperationContext operationContext, final NodeSetupContext _context) {
    SPropertyOperations.set(_context.getNewNode(), "vertical", "" + (true));
    if(SNodeOperations.isInstanceOf(_context.getSampleNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel")) {
      SLinkOperations.setTarget(_context.getNewNode(), "ifTrueCellModel", SNodeOperations.copyNode(_context.getSampleNode()), true);
    }
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_CellMenuPart_Abstract_1199894656684(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_PropertyValues", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_PropertyPostfixHints", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_CellMenuPart_Abstract_1199894924671(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_ReferentPrimary", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_CellMenuPart_Abstract_1199895015795(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_ReplaceChild_Group", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_ReplaceChild_Item", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_ReplaceChild_CustomChildConcept", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    {
      ConceptDeclaration conceptToAdd = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellMenuPart_ReplaceChildPrimary", operationContext.getScope());
      List<INodeSubstituteAction> defaultActions = ChildSubstituteActionsHelper.createDefaultActions(conceptToAdd, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext);
      result.addAll(defaultActions);
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_EditorCellModel_1177585776510(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SConceptOperations.createNewNode("jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (true));
          return result;
        }

        public String getMatchingText(String pattern) {
          return "collection (vertical)";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (true));
          if((SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", true, false) != null)) {
            SPropertyOperations.set(result, "selectable", "false");
          }
          return result;
        }

        public String getDescriptionText(String pattern) {
          return "collection (vertical)";
        }

        public String getMatchingText(String pattern) {
          return "[/";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (false));
          return result;
        }

        public String getMatchingText(String pattern) {
          return "collection (horizontal)";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (false));
          if((SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", true, false) != null)) {
            SPropertyOperations.set(result, "selectable", "false");
          }
          return result;
        }

        public String getDescriptionText(String pattern) {
          return "collection (horizontal)";
        }

        public String getMatchingText(String pattern) {
          return "[>";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (false));
          SNode indent = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Indent", null);
          SPropertyOperations.set(indent, "selectable", "false");
          SLinkOperations.insertChildFirst(result, "childCellModel", indent);
          if((SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection", true, false) != null)) {
            SPropertyOperations.set(result, "selectable", "false");
          }
          return result;
        }

        public String getDescriptionText(String pattern) {
          return "collection (with indent)";
        }

        public String getMatchingText(String pattern) {
          return "[_";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (true));
          return result;
        }

        public String getMatchingText(String pattern) {
          return "ref.node list (vertical)";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (true));
          if(SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection")) {
            SPropertyOperations.set(result, "selectable", "false");
          }
          return result;
        }

        public String getDescriptionText(String pattern) {
          return "ref.node list (vertical)";
        }

        public String getMatchingText(String pattern) {
          return "(/";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (false));
          return result;
        }

        public String getMatchingText(String pattern) {
          return "ref.node list (horizontal)";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "vertical", "" + (false));
          if(SNodeOperations.isInstanceOf(_context.getParentNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection")) {
            SPropertyOperations.set(result, "selectable", "false");
          }
          return result;
        }

        public String getDescriptionText(String pattern) {
          return "ref.node list (horizontal)";
        }

        public String getMatchingText(String pattern) {
          return "(>";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          return SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefCell", _context.getCurrentTargetNode());
        }

        public String getMatchingText(String pattern) {
          return "ref.cell";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          return SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode", _context.getCurrentTargetNode());
        }

        public String getMatchingText(String pattern) {
          return "ref.node";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          return SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property", _context.getCurrentTargetNode());
        }

        public String getMatchingText(String pattern) {
          return "property";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "editable", "false");
          return result;
        }

        public String getMatchingText(String pattern) {
          return "concept property";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Alternation", _context.getCurrentTargetNode());
          return result;
        }

        public String getDescriptionText(String pattern) {
          return "alternation";
        }

        public String getMatchingText(String pattern) {
          return "if";
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "text", NameUtil.stripQuotes(pattern, "\"", "\""));
          return result;
        }

        public boolean hasSubstitute() {
          return true;
        }

        public boolean canSubstitute_internal(String pattern) {
          return pattern.startsWith("\"");
        }

        public String getDescriptionText(String pattern) {
          return "constant";
        }

        public String getMatchingText(String pattern) {
          return pattern;
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      result.add(new DefaultSimpleSubstituteAction(concept, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

        public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
          SNode result = SConceptOperations.createNewNode("jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Error", _context.getCurrentTargetNode());
          SPropertyOperations.set(result, "text", NameUtil.stripQuotes(pattern, "!", "!"));
          return result;
        }

        public boolean hasSubstitute() {
          return true;
        }

        public boolean canSubstitute_internal(String pattern) {
          return pattern.startsWith("!");
        }

        public String getDescriptionText(String pattern) {
          return "Error label";
        }

        public String getMatchingText(String pattern) {
          return pattern;
        }

      });
    }
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.EditorCellModel", operationContext.getScope());
      SNode childConcept = (SNode)_context.getChildConcept();
      if(SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName((SNode)BaseAdapter.fromAdapter(concept)))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            SNode container = SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.bootstrap.editorLanguage.structure.BaseEditorComponent", true, false);
            return BaseEditorComponent_Behavior.call_getApplicableComponents_1199449552893(container, operationContext.getScope());
          }

        };
        Iterable<SNode> queryResult = (Iterable)calc.calculate();
        assert queryResult != null;
        for(SNode item : queryResult) {
          result.add(new DefaultChildNodeSubstituteAction(item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

            public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
              SNode component = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component", null);
              SLinkOperations.setTarget(component, "editorComponent", ((SNode)this.getParameterObject()), false);
              return component;
            }

            public String getMatchingText(String pattern) {
              return "#" + SPropertyOperations.getString(((SNode)this.getParameterObject()), "name") + "#";
            }

          });
        }
      }
    }
    return result;
  }

  public static List<INodeSubstituteAction> nodeSubstituteActionsBuilder_ActionsFactory_CellActionMapItem_1185874474095(final IOperationContext operationContext, final NodeSubstituteActionsFactoryContext _context) {
    List<INodeSubstituteAction> result = new ArrayList<INodeSubstituteAction>();
    {
      ConceptDeclaration concept = SModelUtil_new.findConceptDeclaration("jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapItem", operationContext.getScope());
      SNode childConcept = (SNode)_context.getChildConcept();
      if(SConceptOperations.isSuperConceptOf(childConcept, NameUtil.nodeFQName((SNode)BaseAdapter.fromAdapter(concept)))) {
        Calculable calc = new Calculable() {

          public Object calculate() {
            return CellActionId.getConstants();
          }

        };
        Iterable<CellActionId> queryResult = (Iterable)calc.calculate();
        assert queryResult != null;
        for(CellActionId item : queryResult) {
          result.add(new DefaultChildNodeSubstituteAction(item, _context.getParentNode(), _context.getCurrentTargetNode(), _context.getChildSetter(), operationContext.getScope()) {

            public SNode createChildNode(Object parameterObject, SModel model, String pattern) {
              SNode newNode = SModelOperations.createNewNode(model, "jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapItem", _context.getCurrentTargetNode());
              SPropertyOperations.set(newNode, "actionId", ((CellActionId)this.getParameterObject()).getValue());
              return newNode;
            }

            public String getMatchingText(String pattern) {
              return ((CellActionId)this.getParameterObject()).getName();
            }

          });
        }
      }
    }
    return result;
  }

}
