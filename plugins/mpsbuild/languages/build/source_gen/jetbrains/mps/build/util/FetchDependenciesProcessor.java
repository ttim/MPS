package jetbrains.mps.build.util;

/*Generated by MPS */

import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.build.behavior.BuildExternalDependency_Behavior;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class FetchDependenciesProcessor {
  private TemplateQueryContext genContext;
  private SNode project;

  public FetchDependenciesProcessor(SNode project, TemplateQueryContext genContext) {
    this.genContext = genContext;
    this.project = project;
  }

  public void process() {
    VisibleArtifacts artifacts = new VisibleArtifacts(project, genContext);
    artifacts.collect();
    UnpackHelper helper = new UnpackHelper(artifacts, genContext);
    for (SNode dep : SNodeOperations.getDescendants(project, "jetbrains.mps.build.structure.BuildExternalDependency", false, new String[]{})) {
      BuildExternalDependency_Behavior.call_fetchDependencies_5908258303322131137(dep, artifacts, new FetchDependenciesProcessor.RequiredDependenciesBuilderImpl(artifacts, dep, helper));
    }
    helper.eval();

    List<SNode> statements = helper.getStatements();
    if (!(ListSequence.fromList(statements).isEmpty())) {
      SNode wf = SModelOperations.createNewNode(SNodeOperations.getModel(project), "jetbrains.mps.build.structure.BuildCustomWorkflow", null);
      SNode taskpart = SModelOperations.createNewNode(SNodeOperations.getModel(project), "jetbrains.mps.build.workflow.structure.BwfTaskPart", null);
      SLinkOperations.setTarget(taskpart, "task", SLinkOperations.getTarget(new FetchDependenciesProcessor.QuotationClass_t02zqv_a0a0c0h0a().createNode(), "target", false), false);
      ListSequence.fromList(SLinkOperations.getTargets(wf, "parts", true)).addElement(taskpart);
      SNode stask = SModelOperations.createNewNode(SNodeOperations.getModel(project), "jetbrains.mps.build.workflow.structure.BwfSubTask", null);
      SPropertyOperations.set(stask, "name", "fetch");
      ListSequence.fromList(SLinkOperations.getTargets(taskpart, "subTasks", true)).addElement(stask);
      ListSequence.fromList(SLinkOperations.getTargets(stask, "statements", true)).addSequence(ListSequence.fromList(statements));
      ListSequence.fromList(SLinkOperations.getTargets(project, "aspects", true)).addElement(wf);
    }
  }

  private class RequiredDependenciesBuilderImpl implements RequiredDependenciesBuilder {
    private final VisibleArtifacts artifacts;
    private final SNode dep;
    private final UnpackHelper helper;

    public RequiredDependenciesBuilderImpl(VisibleArtifacts artifacts, SNode dep, UnpackHelper helper) {
      this.artifacts = artifacts;
      this.dep = dep;
      this.helper = helper;
    }

    public void add(SNode node) {
      if (!(check(node))) {
        return;
      }
      helper.add(node, false);
    }

    public void addWithContent(SNode node) {
      if (!(check(node))) {
        return;
      }
      helper.add(node, true);
    }

    private boolean check(SNode node) {
      if (SNodeOperations.getModel(node).isTransient()) {
        genContext.showErrorMessage(dep, "returned dependency in transient model: " + node.getDebugText());
        return false;
      }
      if (!(artifacts.contains(node))) {
        genContext.showErrorMessage(dep, "returned node which is not available in dependencies: " + node.getDebugText());
        return false;
      }
      return true;
    }

    public void addAll(Iterable<SNode> nodes) {
      for (SNode n : Sequence.fromIterable(nodes)) {
        if (n != null) {
          add(n);
        }
      }
    }
  }

  public static class QuotationClass_t02zqv_a0a0c0h0a {
    public QuotationClass_t02zqv_a0a0c0h0a() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.workflow.structure.BwfTaskDependency", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("target", quotedNode1_2, SModelReference.fromString("r:14f06230-41df-42af-9a25-81de46539bf1(jetbrains.mps.build.workflow.accessories)"), SNodeId.fromString("7128123785277844790")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
