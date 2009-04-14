package jetbrains.mpslite.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.MappingScriptContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SModel;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mpslite.behavior.IMPSLiteConcept_Behavior;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mpslite.behavior.AbstractConceptReference_Behavior;
import jetbrains.mpslite.behavior.LineList_Behavior;
import jetbrains.mpslite.generator.template.util.EditorGenerationUtils;
import jetbrains.mps.smodel.SModelRepository;

public class QueriesGenerated {

  public static void mappingScript_CodeBlock_1238589718396(final IOperationContext operationContext, final MappingScriptContext _context) {
    Language language = Language.getLanguageFor(_context.getOriginalInputModel().getModelDescriptor());
    if (language == null) {
      return;
    }
    SModel structureModel = language.getStructureModelDescriptor().getSModel();
    Map<SNode, SNode> conceptsToTargets = MapSequence.fromMap(new HashMap<SNode, SNode>());
    Map<SNode, SNode> partsToLinkDeclarations = MapSequence.fromMap(new HashMap<SNode, SNode>());
    SNode conceptContainer = ListSequence.fromList(SModelOperations.getRoots(_context.getModel(), "jetbrains.mpslite.structure.ConceptContainer")).first();
    List<SNode> mpsliteConceptDeclarations = SNodeOperations.getDescendants(conceptContainer, "jetbrains.mpslite.structure.MPSLiteConceptDeclaration", false);
    List<SNode> allConcepts = SLinkOperations.getTargets(conceptContainer, "mpsLiteConcept", true);
    for(SNode conceptDeclaration : allConcepts) {
      SNode concept = SConceptOperations.createNewNode("jetbrains.mps.lang.structure.structure.ConceptDeclaration", null);
      SPropertyOperations.set(concept, "name", SPropertyOperations.getString(conceptDeclaration, "name"));
      SPropertyOperations.set(concept, "rootable", "" + IMPSLiteConcept_Behavior.call_isRootable_1239714833738(conceptDeclaration));
      if (IMPSLiteConcept_Behavior.call_isAbstract_1239715026284(conceptDeclaration)) {
        SNode booleanConceptProperty = SLinkOperations.addNewChild(concept, "conceptProperty", "jetbrains.mps.lang.structure.structure.BooleanConceptProperty");
        SNode conceptProperty_Abstract = SNodeOperations.cast(ListSequence.fromList(SLinkOperations.getTargets(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept"), "conceptPropertyDeclaration", true)).where(new IWhereFilter <SNode>() {

          public boolean accept(SNode it) {
            return "abstract".equals(SPropertyOperations.getString(it, "name"));
          }
        }).first(), "jetbrains.mps.lang.structure.structure.BooleanConceptPropertyDeclaration");
        SLinkOperations.setTarget(booleanConceptProperty, "conceptPropertyDeclaration", conceptProperty_Abstract, false);
      }
      MapSequence.fromMap(conceptsToTargets).put(conceptDeclaration, concept);
    }
    //     extends
    for(SNode conceptDeclaration : allConcepts) {
      SLinkOperations.setTarget(((SNode)conceptsToTargets.get(conceptDeclaration)), "extends", SNodeOperations.cast(AbstractConceptReference_Behavior.call_getConcept_1238594571574(SLinkOperations.getTarget(conceptDeclaration, "extends", true), conceptsToTargets), "jetbrains.mps.lang.structure.structure.ConceptDeclaration"), false);
    }
    //     structure
    for(SNode conceptDeclaration : mpsliteConceptDeclarations) {
      LineList_Behavior.call_fillConceptStructure_1238593666753(SLinkOperations.getTarget(conceptDeclaration, "lineList", true), SNodeOperations.cast(conceptsToTargets.get(conceptDeclaration), "jetbrains.mps.lang.structure.structure.ConceptDeclaration"), conceptsToTargets, partsToLinkDeclarations);
    }
    List<SNode> binaryOperations = SNodeOperations.getDescendants(conceptContainer, "jetbrains.mpslite.structure.BinaryOperationConcept", false);
    for(SNode binaryOperationConcept : binaryOperations) {
      EditorGenerationUtils.fillBinaryOperationStructure(binaryOperationConcept, conceptsToTargets, partsToLinkDeclarations);
    }
    List<SNode> variableConcepts = SNodeOperations.getDescendants(conceptContainer, "jetbrains.mpslite.structure.VariableConcept", false);
    for(SNode variableConcept : variableConcepts) {
      EditorGenerationUtils.fillVariableConceptStruncture(variableConcept, conceptsToTargets, partsToLinkDeclarations);
    }
    //     editor
    SModel editorModel = language.getEditorModelDescriptor().getSModel();
    SModel actionsModel = language.getActionsModelDescriptor().getSModel();
    Map<SNode, SNode> conceptsToEditors = MapSequence.fromMap(new HashMap<SNode, SNode>());
    for(SNode conceptDeclaration : mpsliteConceptDeclarations) {
      SNode editor = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration", null);
      SNode lineList = SLinkOperations.getTarget(conceptDeclaration, "lineList", true);
      SNode contentCell = EditorGenerationUtils.generateEditorCellModel(lineList, conceptDeclaration, partsToLinkDeclarations);
      if (contentCell == null) {
        continue;
      }
      SLinkOperations.setTarget(editor, "cellModel", contentCell, true);
      SLinkOperations.setTarget(editor, "conceptDeclaration", conceptsToTargets.get(conceptDeclaration), false);
      MapSequence.fromMap(conceptsToEditors).put(conceptDeclaration, editor);
    }
    for(SNode variableConcept : variableConcepts) {
      SNode editor = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration", null);
      SNode lineList = SLinkOperations.getTarget(variableConcept, "concreteSyntax", true);
      SNode contentCell = EditorGenerationUtils.generateEditorCellModel(lineList, variableConcept, partsToLinkDeclarations);
      if (contentCell == null) {
        continue;
      }
      SLinkOperations.setTarget(editor, "cellModel", contentCell, true);
      SLinkOperations.setTarget(editor, "conceptDeclaration", conceptsToTargets.get(variableConcept), false);
      MapSequence.fromMap(conceptsToEditors).put(variableConcept, editor);
    }
    SNode actions = SConceptOperations.createNewNode("jetbrains.mps.lang.actions.structure.SideTransformHintSubstituteActions", null);
    SPropertyOperations.set(actions, "name", "_BinaryOperations_SideTransform");
    for(SNode binaryOperationConcept : binaryOperations) {
      SNode editor = SConceptOperations.createNewNode("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration", null);
      SNode contentCell = EditorGenerationUtils.generateBinaryOperationCellModel(binaryOperationConcept, partsToLinkDeclarations);
      SLinkOperations.setTarget(editor, "cellModel", contentCell, true);
      SLinkOperations.setTarget(editor, "conceptDeclaration", conceptsToTargets.get(binaryOperationConcept), false);
      MapSequence.fromMap(conceptsToEditors).put(binaryOperationConcept, editor);
      EditorGenerationUtils.fillBinarySideTransformActions(binaryOperationConcept, actions, conceptsToTargets, partsToLinkDeclarations);
    }
    //     setting roots and deleting input roots
    structureModel.setLoading(true);
    for(SNode root : ListSequence.fromList(ListSequence.<SNode>fromArray()).addSequence(ListSequence.fromList(SModelOperations.getRoots(structureModel, null)))) {
      structureModel.removeRoot(root);
    }
    for(SNode conceptDeclaration : allConcepts) {
      SNode concept = conceptsToTargets.get(conceptDeclaration);
      SModelOperations.addRootNode(structureModel, concept);
    }
    structureModel.setLoading(false);
    SModelRepository.getInstance().markChanged(structureModel);
    editorModel.setLoading(true);
    for(SNode root : ListSequence.fromList(ListSequence.<SNode>fromArray()).addSequence(ListSequence.fromList(SModelOperations.getRoots(editorModel, null)))) {
      editorModel.removeRoot(root);
    }
    for(SNode conceptDeclaration : allConcepts) {
      SNode editorDeclaration = conceptsToEditors.get(conceptDeclaration);
      SModelOperations.addRootNode(editorModel, editorDeclaration);
    }
    editorModel.setLoading(false);
    actionsModel.setLoading(true);
    for(SNode root : ListSequence.fromList(ListSequence.<SNode>fromArray()).addSequence(ListSequence.fromList(SModelOperations.getRoots(actionsModel, null)))) {
      actionsModel.removeRoot(root);
    }
    SModelOperations.addRootNode(actionsModel, actions);
    actionsModel.setLoading(false);
    SModelRepository.getInstance().markChanged(editorModel);
    SModelRepository.getInstance().markChanged(actionsModel);
    SNodeOperations.deleteNode(conceptContainer);
  }

}
