package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.errors.MessageStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public abstract class SpecificChecker {
  protected static Log log = LogFactory.getLog(SpecificChecker.class);

  public SpecificChecker() {
  }

  public abstract List<SearchResult<ModelCheckerIssue>> checkModel(SModel model, ProgressMonitor progressContext, IOperationContext operationContext);

  protected static void addIssue(List<SearchResult<ModelCheckerIssue>> results, SNode node, String message, String severity, String issueType, IModelCheckerFix fix) {
    if (filterIssue(node)) {
      if (SNodeOperations.getContainingRoot(node) == null) {
        if (log.isErrorEnabled()) {
          log.error("Node without containing root", new IllegalStateException());
        }
      }
      ListSequence.fromList(results).addElement(ModelCheckerIssue.getSearchResultForNode(node, message, fix, severity, issueType));
    }
  }

  public static String getResultCategory(MessageStatus messageStatus) {
    switch (messageStatus) {
      case ERROR:
        return ModelChecker.SEVERITY_ERROR;
      case WARNING:
        return ModelChecker.SEVERITY_WARNING;
      case OK:
        return ModelChecker.SEVERITY_INFO;
      default:
        return ModelChecker.SEVERITY_ERROR;
    }
  }

  public static boolean filterIssue(SNode node) {
    SNode container = AttributeOperations.getAttribute(node, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.test.structure.NodePropertiesContainer")));
    if (container == null) {
      return true;
    }
    for (SNode property : SLinkOperations.getTargets(container, "properties", true)) {
      if (SNodeOperations.isInstanceOf(property, "jetbrains.mps.lang.test.structure.NodeErrorPropety")) {
        return false;
      }
    }
    return true;
  }
}
