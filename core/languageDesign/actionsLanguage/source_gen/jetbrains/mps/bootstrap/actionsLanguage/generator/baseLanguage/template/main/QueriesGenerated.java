package jetbrains.mps.bootstrap.actionsLanguage.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.CreateRootRuleContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.actionsLanguage.behavior.NodeFactory_Behavior;
import jetbrains.mps.bootstrap.actionsLanguage.behavior.NodeSubstituteActionsBuilder_Behavior;
import jetbrains.mps.bootstrap.actionsLanguage.behavior.SideTransformHintSubstituteActionsBuilder_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.actionsLanguage.behavior.RemoveSTByConditionPart_Behavior;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.datatransfer.PasteWrapperManager;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.generator.template.WeavingMappingRuleContext;

public class QueriesGenerated {

  public static boolean createRootRule_Condition_1221138344773(final IOperationContext operationContext, final CreateRootRuleContext _context) {
    return ListSequence.fromList(SModelOperations.getNodes(_context.getInputModel(), "jetbrains.mps.bootstrap.actionsLanguage.structure.PasteWrapper")).isNotEmpty();
  }

  public static Object propertyMacro_GetPropertyValue_1172253035856(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode nodeFactory = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.bootstrap.actionsLanguage.structure.NodeFactory", false, false);
    return NodeFactory_Behavior.call_getQueryMethodName_1220279061997(nodeFactory);
  }

  public static Object propertyMacro_GetPropertyValue_1172253230032(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode builder = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.bootstrap.actionsLanguage.structure.NodeSubstituteActionsBuilder", false, false);
    return NodeSubstituteActionsBuilder_Behavior.call_getPreconditionQueryMethodName_1220278671791(builder);
  }

  public static Object propertyMacro_GetPropertyValue_1172253315888(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode builder = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.bootstrap.actionsLanguage.structure.SideTransformHintSubstituteActionsBuilder", false, false);
    return SideTransformHintSubstituteActionsBuilder_Behavior.call_getPreconditionQueryMethodName_1220279571415(builder);
  }

  public static Object propertyMacro_GetPropertyValue_1177328723627(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NodeSubstituteActionsBuilder_Behavior.call_getBuilderQueryMethodName_1220278926652(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1177441873740(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SideTransformHintSubstituteActionsBuilder_Behavior.call_getBuilderQueryMethodName_1220279234749(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1178541129260(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1181736567569(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "removeActionsByCondition_" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1181738947306(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1183017316762(final IOperationContext operationContext, final PropertyMacroContext _context) {
    if (_context.getInputModel().getLongName().endsWith(".actions")) {
      return "QueriesGenerated";
    } else
    {
      return "ActionsQueriesGenerated";
    }
  }

  public static Object propertyMacro_GetPropertyValue_1196434222023(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "text");
  }

  public static Object propertyMacro_GetPropertyValue_1196435166148(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "text");
  }

  public static Object propertyMacro_GetPropertyValue_1197457082670(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return RemoveSTByConditionPart_Behavior.call_getQueryMethodName_1220279474449(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1203348876735(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1203349256426(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "variableDeclaration", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1210018108545(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "variableDeclaration", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1221138086226(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(_context.getNode(), "sourceConcept", false));
  }

  public static Object propertyMacro_GetPropertyValue_1221138096817(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(_context.getNode(), "targetConcept", false));
  }

  public static Object propertyMacro_GetPropertyValue_1221139659867(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return PasteWrapperManager.PASTE_WRAPPER_CLASS_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1221139734444(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return PasteWrapperManager.PASTE_WRAPPERS_FACTORY_METHOD;
  }

  public static Object referenceMacro_GetReferent_1202914532639(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.bootstrap.actionsLanguage.structure.NodeSubstituteActionsBuilder", false, false), "applicableConcept", false);
  }

  public static Object referenceMacro_GetReferent_1203068874715(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "concept", false);
  }

  public static Object referenceMacro_GetReferent_1220273696371(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "concept", false);
  }

  public static Object referenceMacro_GetReferent_1220273762488(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(_context.getNode()), "concept", false);
  }

  public static Object referenceMacro_GetReferent_1220273980246(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(_context.getNode()), "concept", false);
  }

  public static Object referenceMacro_GetReferent_1220274179468(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode concept = SLinkOperations.getTarget(SNodeOperations.getParent(_context.getNode()), "concept", false);
    if ((concept == null)) {
      _context.showErrorMessage(_context.getNode(), "output concept is not specified");
    }
    return concept;
  }

  public static Object referenceMacro_GetReferent_1220274221901(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "wrappedConcept", false);
  }

  public static Object referenceMacro_GetReferent_1220274244791(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode outputConcept = SLinkOperations.getTarget(SNodeOperations.getParent(_context.getNode()), "concept", false);
    if (outputConcept == null) {
      _context.showWarningMessage(SNodeOperations.getParent(_context.getNode()), "output concept is not specified");
    }
    return outputConcept;
  }

  public static boolean ifMacro_Condition_1177499899976(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "descriptionText", true) != null;
  }

  public static boolean ifMacro_Condition_1177499903622(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "matchingText", true) != null;
  }

  public static boolean ifMacro_Condition_1177514488331(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "matchingText", true), "body", true) != null;
  }

  public static boolean ifMacro_Condition_1177514494000(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "descriptionText", true), "body", true) != null;
  }

  public static boolean ifMacro_Condition_1178782034640(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "commonInitializer", true) != null;
  }

  public static boolean ifMacro_Condition_1181738756958(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.getParent(_context.getNode()), "commonInitializer", true) != null;
  }

  public static boolean ifMacro_Condition_1201900835343(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "matchingText", true) != null;
  }

  public static boolean ifMacro_Condition_1201900835367(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "descriptionText", true) != null;
  }

  public static boolean ifMacro_Condition_1203026970108(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "canSubstitute", true) != null;
  }

  public static boolean ifMacro_Condition_1203026970132(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "canSubstitute", true) != null;
  }

  public static boolean ifMacro_Condition_1203026970156(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "descriptionText", true) != null;
  }

  public static boolean ifMacro_Condition_1203026970180(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "matchingText", true) != null;
  }

  public static boolean ifMacro_Condition_1203073021643(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "icon", true) != null;
  }

  public static boolean ifMacro_Condition_1203073315188(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "icon", true) != null;
  }

  public static boolean ifMacro_Condition_1203073872725(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "icon", true) != null;
  }

  public static boolean ifMacro_Condition_1203074384106(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "icon", true), "body", true) != null;
  }

  public static boolean ifMacro_Condition_1203349777665(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "commonInitializer", true) != null;
  }

  public static boolean ifMacro_Condition_1206027920373(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "returnSmallPart", true) == null);
  }

  public static boolean ifMacro_Condition_1206027954955(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "returnSmallPart", true) != null);
  }

  public static boolean ifMacro_Condition_1215607715367(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.hasValue(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.bootstrap.actionsLanguage.structure.SideTransformHintSubstituteActionsBuilder", false, false), "side", null, null);
  }

  public static boolean ifMacro_Condition_1218638013323(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "matchingText", true), "body", true) != null;
  }

  public static boolean ifMacro_Condition_1218638036038(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "matchingText", true) != null;
  }

  public static boolean ifMacro_Condition_1218638060185(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "matchingText", true) != null;
  }

  public static boolean ifMacro_Condition_1218638073951(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "matchingText", true) != null;
  }

  public static SNode sourceNodeQuery_1172253185556(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1172253302099(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1172253384416(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1177353800103(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "query", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177405091687(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "wrapperBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177499792023(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "handler", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177499861510(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "matchingText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177499864799(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "descriptionText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177510051563(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "query", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177510450110(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1177510459082(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1177510544571(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1177510684590(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "handler", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177514451569(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "matchingText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177514456119(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "descriptionText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1178541085974(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1178782016772(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "commonInitializer", true), "body", true);
  }

  public static SNode sourceNodeQuery_1179457640853(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "initializerBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_1179457640870(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "type", true));
  }

  public static SNode sourceNodeQuery_1180114556480(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "nodeBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_1181736318685(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "condition", true), "body", true);
  }

  public static SNode sourceNodeQuery_1181738763214(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SNodeOperations.getParent(_context.getNode()), "commonInitializer", true), "body", true);
  }

  public static SNode sourceNodeQuery_1181738947298(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1181738985209(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "initializerBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_1181738985228(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "type", true));
  }

  public static SNode sourceNodeQuery_1182820930324(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "handler", true), "body", true);
  }

  public static SNode sourceNodeQuery_1197457249775(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "condition", true), "body", true);
  }

  public static SNode sourceNodeQuery_1199903106468(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "query", true), "body", true);
  }

  public static SNode sourceNodeQuery_1201900835262(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "query", true), "body", true);
  }

  public static SNode sourceNodeQuery_1201900835281(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1201900835296(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1201900835319(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "handler", true), "body", true);
  }

  public static SNode sourceNodeQuery_1201900835332(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "matchingText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1201900835356(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "descriptionText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203026970093(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "handler", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203026970121(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "canSubstitute", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203026970147(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "descriptionText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203026970171(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "matchingText", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203073040158(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "icon", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203073328859(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "icon", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203073876261(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "icon", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203074405261(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "icon", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203348867882(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1203348974786(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "initializerBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203349032899(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1203349791101(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "commonInitializer", true), "body", true);
  }

  public static SNode sourceNodeQuery_1206027958053(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    SNode smallPart = SLinkOperations.getTarget(_context.getNode(), "returnSmallPart", true);
    return SLinkOperations.getTarget(smallPart, "body", true);
  }

  public static SNode sourceNodeQuery_1210018108535(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "variableDeclaration", false), "type", true);
  }

  public static SNode sourceNodeQuery_1221138112690(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "wrapperFunction", true), "body", true);
  }

  public static Iterable sourceNodesQuery_1177330914926(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendantsWhereConceptInList(_context.getNode(), new String[]{"jetbrains.mps.bootstrap.actionsLanguage.structure.ConceptSubstitutePart","jetbrains.mps.bootstrap.actionsLanguage.structure.SubstituteMenuPart"}, false);
  }

  public static Iterable sourceNodesQuery_1177441873770(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SNodeOperations.getDescendantsWhereConceptInList(_context.getNode(), new String[]{"jetbrains.mps.bootstrap.actionsLanguage.structure.IncludeRightTransformForNodePart","jetbrains.mps.bootstrap.actionsLanguage.structure.ConceptRightTransformPart","jetbrains.mps.bootstrap.actionsLanguage.structure.SideTransformMenuPart"}, false);
  }

  public static Iterable sourceNodesQuery_1178541065624(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "variable", true);
  }

  public static Iterable sourceNodesQuery_1179457640889(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "variable", true);
  }

  public static Iterable sourceNodesQuery_1181738947315(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.getParent(_context.getNode()), "variable", true);
  }

  public static Iterable sourceNodesQuery_1181738985246(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.getParent(_context.getNode()), "variable", true);
  }

  public static Iterable sourceNodesQuery_1203348857747(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "variable", true);
  }

  public static Iterable sourceNodesQuery_1203348941622(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "variable", true);
  }

  public static Iterable sourceNodesQuery_1221138066478(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SModelOperations.getNodes(_context.getInputModel(), "jetbrains.mps.bootstrap.actionsLanguage.structure.PasteWrapper");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186794781128(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186795057567(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186795061791(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186795065171(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186795068567(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186795071822(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1197455643098(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByMappingLabel("classQueriesGenerated");
  }

}
