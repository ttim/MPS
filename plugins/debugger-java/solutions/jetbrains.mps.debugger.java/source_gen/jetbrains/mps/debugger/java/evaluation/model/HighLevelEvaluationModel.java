package jetbrains.mps.debugger.java.evaluation.model;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.debug.runtime.DebugSession;
import jetbrains.mps.debug.evaluation.ui.EvaluationAuxModule;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class HighLevelEvaluationModel extends AbstractEvaluationModel {
  private SNode myLocationRootCopy;
  private SNode myNodeToShow;

  public HighLevelEvaluationModel(Project project, @NotNull DebugSession session, @NotNull EvaluationAuxModule module, boolean isInContext) {
    super(project, session, module, new StackFrameContext(session.getUiState()), isInContext);

    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        // TODO not all languages have block statements; type of used statement should be specified via plugin 
        myNodeToShow = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.BlockStatement", null);
        AttributeOperations.createAndSetAttrbiute(myNodeToShow, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.debug.evaluation.structure.ToEvaluateAnnotation")), "jetbrains.mps.debug.evaluation.structure.ToEvaluateAnnotation");

        SNode locationNode = myEvaluationContext.getLocationNode();
        SNode locationRoot = getLocationRoot();
        HighLevelEvaluationModel.this.myLocationRootCopy = SNodeOperations.copyNode(locationRoot);
        SNode locationNodeCopy = HighLevelEvaluationModel.this.findNodesCopy(locationRoot, HighLevelEvaluationModel.this.myLocationRootCopy, locationNode);

        SNodeOperations.insertNextSiblingChild(locationNodeCopy, myNodeToShow);
      }
    });
  }

  @Nullable
  private SNode getLocationRoot() {
    SNode locationNode = myEvaluationContext.getLocationNode();
    if (locationNode != null) {
      return SNodeOperations.getAncestor(locationNode, null, false, true);
    }
    return null;
  }

  private SNode findNodesCopy(SNode root, SNode rootCopy, final SNode originalNodeToFind) {
    if (originalNodeToFind == root) {
      return rootCopy;
    }
    SNode parentsCopy = this.findNodesCopy(root, rootCopy, SNodeOperations.getParent(originalNodeToFind));
    return ListSequence.<SNode>fromList(SNodeOperations.getChildren(parentsCopy)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SNodeOperations.getContainingLinkRole(it).equals(SNodeOperations.getContainingLinkRole(originalNodeToFind));
      }
    }).skip(SNodeOperations.getIndexInParent(originalNodeToFind)).first();
  }

  @NotNull
  public SNode getNodeToShow() {
    return myNodeToShow;
  }

  @NotNull
  public SNode getRootToShow() {
    return myLocationRootCopy;
  }

  @Override
  public void updateState() {
    super.updateState();
    throw new RuntimeException("update state unimplemented!");
  }

  public HighLevelEvaluationModel copy(boolean isInContext) {
    HighLevelEvaluationModel model = new HighLevelEvaluationModel(myDebugSession.getProject(), myDebugSession, myAuxModule, isInContext);
    return model;
  }
}
