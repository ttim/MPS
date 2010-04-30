package jetbrains.mps.baseLanguage.util.plugin.refactorings;

/*Generated by MPS */

import java.util.List;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.HashMap;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.dataFlow.framework.instructions.Instruction;
import jetbrains.mps.lang.dataFlow.framework.instructions.ReadInstruction;
import jetbrains.mps.baseLanguage.behavior.IParameter_Behavior;
import jetbrains.mps.baseLanguage.behavior.VariableDeclaration_Behavior;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.behavior.IStaticContainerForMethods_Behavior;

public abstract class ExtractMethodRefactoring {
  protected ExtractMethodRefactoringParameters myParameters;
  protected ExtractMethodRefactoringAnalyzer myAnalyzer;
  private IStaticContainerProcessor myStaticContainer;
  protected List<MethodMatch> myMatches;

  public ExtractMethodRefactoring(ExtractMethodRefactoringParameters parameters) {
    this.myParameters = parameters;
    this.myAnalyzer = parameters.getAnalyzer();
  }

  @NotNull
  public abstract SNode doRefactor();

  public abstract void replaceMatch(MethodMatch match, SNode methodDeclaration);

  public DuplicatesProcessor<MethodMatch> getDuplicatesProcessor() {
    return null;
  }

  protected MethodMatch createMatch(List<SNode> nodes, Map<SNode, SNode> inputMapping, List<SNode> parametersOrder) {
    MethodMatch match = new MethodMatch(parametersOrder);
    for (SNode node : ListSequence.fromList(nodes)) {
      match.putNode(node);
    }
    for (SNode node : SetSequence.fromSet(MapSequence.fromMap(inputMapping).keySet())) {
      match.putMapping(node, MapSequence.fromMap(inputMapping).get(node));
    }
    return match;
  }

  protected SNode createNewMethod(SNode returnType, List<SNode> params, SNode body) {
    SNode myMethod;
    if (this.myStaticContainer != null) {
      myMethod = this.myStaticContainer.createNewMethod();
    } else {
      IExtractMethodRefactoringProcessor processor = this.myAnalyzer.getExtractMethodReafactoringProcessor();
      myMethod = processor.createNewMethod();
    }
    this.fillBaseMethodDeclaration(myMethod, returnType, params, body);
    return myMethod;
  }

  protected SNode fillBaseMethodDeclaration(SNode declaration, SNode returnType, List<SNode> params, SNode body) {
    if (SNodeOperations.isInstanceOf(declaration, "jetbrains.mps.baseLanguage.structure.IVisible")) {
      SNode visibleDeclaration = SNodeOperations.cast(declaration, "jetbrains.mps.baseLanguage.structure.IVisible");
      SLinkOperations.setTarget(visibleDeclaration, "visibility", this.myParameters.getVisibilityLevel().getNode(), true);
    }
    SNode methodDeclaration = declaration;
    SLinkOperations.setTarget(methodDeclaration, "returnType", SNodeOperations.copyNode(returnType), true);
    SPropertyOperations.set(methodDeclaration, "name", this.myParameters.getName());
    ListSequence.fromList(SLinkOperations.getTargets(methodDeclaration, "parameter", true)).addSequence(ListSequence.fromList(params));
    SLinkOperations.setTarget(methodDeclaration, "body", body, true);
    return methodDeclaration;
  }

  protected void addMethod(SNode node) {
    if (this.myStaticContainer == null) {
      IExtractMethodRefactoringProcessor processor = this.myAnalyzer.getExtractMethodReafactoringProcessor();
      processor.addMethod(node);
    } else {
      this.myStaticContainer.addMethod(node);
    }
  }

  protected Map<SNode, SNode> createInputParameters(SNode body, List<SNode> parameters) {
    Map<SNode, SNode> result = MapSequence.fromMap(new HashMap<SNode, SNode>());
    for (MethodParameter methodParameter : ListSequence.fromList(this.myParameters.getParameters())) {
      if (methodParameter.isSelected()) {
        SNode parameter = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ParameterDeclaration", null);
        SLinkOperations.setTarget(parameter, "type", SNodeOperations.copyNode(methodParameter.getType()), true);
        SPropertyOperations.set(parameter, "name", methodParameter.getName());
        if (methodParameter.isFinal()) {
          SPropertyOperations.set(parameter, "isFinal", "" + true);
        }
        ListSequence.fromList(parameters).addElement(parameter);
        MapSequence.fromMap(result).put(methodParameter.getDeclaration(), parameter);
      }
    }
    return result;
  }

  protected void replaceInputVariablesByParameters(SNode body, Map<SNode, SNode> variableDeclarationToParameter, Map<SNode, SNode> mapping) {
    /*
      for (Instruction instruction : SetSequence.fromSet(this.myAnalyzer.getInstructions())) {
        if (instruction instanceof ReadInstruction) {
          ReadInstruction readInstruction = (ReadInstruction) instruction;
          SNode variable = ((SNode) readInstruction.getVariable());
          if (SNodeOperations.isInstanceOf(((SNode) instruction.getSource()), "jetbrains.mps.baseLanguage.structure.AbstractCreator")) {
            continue;
          }
          SNode variableReference = MapSequence.fromMap(mapping).get(((SNode) instruction.getSource()));
          if (MapSequence.fromMap(variableDeclarationToParameter).containsKey(variable) && variableReference != null) {
            SNodeOperations.replaceWithAnother(variableReference, this.createReference(MapSequence.fromMap(variableDeclarationToParameter).get(variable)));
          }
        }
      }
    */
    for (SNode variableReference : ListSequence.fromList(SNodeOperations.getDescendants(body, "jetbrains.mps.baseLanguage.structure.VariableReference", false, new String[]{}))) {
      if (MapSequence.fromMap(variableDeclarationToParameter).containsKey(SLinkOperations.getTarget(variableReference, "variableDeclaration", false))) {
        SNodeOperations.replaceWithAnother(variableReference, this.createReference(MapSequence.fromMap(variableDeclarationToParameter).get(SLinkOperations.getTarget(variableReference, "variableDeclaration", false))));
      }
    }
    for (SNode parameter : ListSequence.fromList(SNodeOperations.getDescendants(body, "jetbrains.mps.baseLanguage.structure.IParameter", false, new String[]{}))) {
      if (MapSequence.fromMap(variableDeclarationToParameter).containsKey(IParameter_Behavior.call_getDeclaration_1225282371351(parameter))) {
        SNodeOperations.replaceWithAnother(parameter, this.createReference(MapSequence.fromMap(variableDeclarationToParameter).get(IParameter_Behavior.call_getDeclaration_1225282371351(parameter))));
      }
    }
  }

  public Map<SNode, SNode> createInputVaryablesMapping(Map<SNode, SNode> variableDeclarationToParameter) {
    Map<SNode, SNode> mapping = MapSequence.fromMap(new HashMap<SNode, SNode>());
    for (SNode node : ListSequence.fromList(this.myParameters.getNodesToRefactor())) {
      for (SNode varReference : ListSequence.fromList(SNodeOperations.getDescendants(node, "jetbrains.mps.baseLanguage.structure.VariableReference", false, new String[]{}))) {
        SNode varDeclaration = SLinkOperations.getTarget(varReference, "variableDeclaration", false);
        if (MapSequence.fromMap(variableDeclarationToParameter).containsKey(varDeclaration)) {
          MapSequence.fromMap(mapping).put(varReference, MapSequence.fromMap(variableDeclarationToParameter).get(varDeclaration));
        }
      }
      for (SNode parameter : ListSequence.fromList(SNodeOperations.getDescendants(node, "jetbrains.mps.baseLanguage.structure.IParameter", false, new String[]{}))) {
        SNode declaration = IParameter_Behavior.call_getDeclaration_1225282371351(parameter);
        if (MapSequence.fromMap(variableDeclarationToParameter).containsKey(declaration)) {
          MapSequence.fromMap(mapping).put(parameter, MapSequence.fromMap(variableDeclarationToParameter).get(declaration));
        }
      }
    }
    return mapping;
  }

  protected SNode createReference(SNode variable) {
    return VariableDeclaration_Behavior.call_createReference_1213877517482(variable);
  }

  protected List<SNode> createCallParameters() {
    List<SNode> result = new ArrayList<SNode>();
    for (MethodParameter parameter : ListSequence.fromList(this.myParameters.getParameters())) {
      if (parameter.isSelected()) {
        ListSequence.fromList(result).addElement(parameter.getReference());
      }
    }
    return result;
  }

  protected SNode createMethodCall(SNode methodDeclaration, List<SNode> parameters) {
    if (this.myStaticContainer == null) {
      IExtractMethodRefactoringProcessor processor = this.myAnalyzer.getExtractMethodReafactoringProcessor();
      return processor.createMethodCall(methodDeclaration, parameters);
    } else {
      return this.myStaticContainer.createMethodCall(methodDeclaration, parameters);
    }
  }

  public SNode createMethodCall(MethodMatch match, SNode methodDeclaration) {
    return this.createMethodCall(methodDeclaration, match.getCallParameters());
  }

  public void setStaticContainer(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      this.myStaticContainer = new ClassStaticContainerProcessor(node);
    } else if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.baseLanguage.structure.IStaticContainerForMethods")) {
      SNode staticContainer = SNodeOperations.cast(node, "jetbrains.mps.baseLanguage.structure.IStaticContainerForMethods");
      this.myStaticContainer = IStaticContainerForMethods_Behavior.call_getStaticContainerProcessor_1222174378300(staticContainer, node);
    } else {
      throw new IllegalArgumentException();
    }
  }

  public List<MethodMatch> getMatches() {
    return this.myMatches;
  }

  public abstract SNode getMethodType();
}
