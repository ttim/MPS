package jetbrains.mps.generator.newGenerator;

import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.TemplateFunctionMethodName;
import jetbrains.mps.transformation.TLBase.structure.ReferenceMacro;
import jetbrains.mps.transformation.TLBase.structure.ReferenceMacro_GetReferent;
import jetbrains.mps.util.QueryMethodGenerated;
import jetbrains.mps.logging.Logger;

/**
 * Created by: Sergey Dmitriev
 * Date: Jan 25, 2007
 */
public class ReferenceInfo_Macro extends ReferenceInfo {
  private SNode myTemplateReferenceNode;
  private ReferenceMacro myReferenceMacro;
  private String myResolveInfoForDynamicResolve;

  public ReferenceInfo_Macro(SNode outputSourceNode, ReferenceMacro refMacro, SNode inputNode, SNode templateReferenceNode) {
    super(outputSourceNode, refMacro.getLink().getRole(), inputNode);
    myTemplateReferenceNode = templateReferenceNode;
    myReferenceMacro = refMacro;
  }

  public SNode getInputTargetNode() {
    String role = myReferenceMacro.getLink().getRole();
    return myTemplateReferenceNode.getReferent(role);
  }

  public SNode doResolve_Straightforward(TemplateModelGenerator_New generator) {
    //todo it should be removed after going to new generator
    generator.setCurrentBuilder(getOutputSourceNode());
    SNode outputTargetNode = expandReferenceMacro(generator);
    generator.setCurrentBuilder(null);
    return outputTargetNode;
  }

  public SNode doResolve_Tricky(TemplateModelGenerator_New generator) {
    // nothing
    return null;
  }

  public String getResolveInfoForDynamicResolve() {
    return myResolveInfoForDynamicResolve;
  }

  public String getResolveInfoForNothing() {
    SNode templateTargetNode = getInputTargetNode();
    if (templateTargetNode != null) {
      return templateTargetNode.getName();
    }
    return null;
  }

  public boolean isRequired() {
    return getOutputSourceNode().isReferentRequired(getReferenceRole());
  }

  public SNode expandReferenceMacro(ITemplateGenerator generator) {
    String role = myReferenceMacro.getLink().getRole();

    // try new query
    ReferenceMacro_GetReferent function = myReferenceMacro.getReferentFunction();
    if (function == null) {
      generator.showErrorMessage(getInputNode(), myReferenceMacro.getNode(), "couldn't evaluate reference macro");
      return null;
    }

    SNode templateValue = myTemplateReferenceNode.getReferent(role);
    String methodName = TemplateFunctionMethodName.referenceMacro_GetReferent(function.getNode());
    Object[] args_old = new Object[]{
            getInputNode(),
            templateValue,
            myTemplateReferenceNode,
            generator.getInputModel(),
            generator,
            generator.getScope(),
            generator.getGeneratorSessionContext()};

    Object[] args_new = new Object[]{
            getInputNode(),
            myTemplateReferenceNode,
            getOutputSourceNode(),
            generator.getInputModel(),
            generator};

    SNode outputTargetNode = null;
    try {
      Object result = QueryMethodGenerated.invoke_GetReferent(methodName, args_old, args_new, myReferenceMacro.getModel());
      if (result instanceof SNode) {
        outputTargetNode = (SNode) result;
      } else {
        myResolveInfoForDynamicResolve = (String) result;
      }
    } catch (Throwable t) {
      generator.showErrorMessage(getInputNode(), myReferenceMacro.getNode(), "couldn't evaluate reference macro");
      Logger.getLogger(this.getClass()).error(t, myReferenceMacro.getNode());
      return null;
    }

    if (outputTargetNode == null) {
      return null;
    }

    // check referent because it's manual and thus error prone mapping
    if (outputTargetNode.getModel() == generator.getInputModel()) {
      generator.showWarningMessage(getOutputSourceNode(), "reference '" + role + "' to input model in output node " + getOutputSourceNode().getDebugText());
      generator.showInformationMessage(outputTargetNode, " -- referent node: " + outputTargetNode.getDebugText());
      generator.showInformationMessage(myReferenceMacro.getNode(), " -- template node: " + myReferenceMacro.getNode().getDebugText());
      generator.getGeneratorSessionContext().addTransientModelToKeep(generator.getInputModel());
    }

    return outputTargetNode;
  }

  public void showErrorMessage(ITemplateGenerator generator) {
    generator.showErrorMessage(getOutputSourceNode(), "couldn't resolve reference '" + getReferenceRole() + "' in output node " + getOutputSourceNode().getDebugText());
    generator.showErrorMessage(myReferenceMacro.getParent().getNode(), "-- original reference was " + myReferenceMacro.getParent().getNode().getDebugText());
    generator.showErrorMessage(getInputNode(), "-- input node was " + getInputNode().getDebugText());
  }
}
