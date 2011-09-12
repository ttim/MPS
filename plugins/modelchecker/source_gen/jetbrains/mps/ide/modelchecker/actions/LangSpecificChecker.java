package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import jetbrains.mps.typesystem.inference.ITypeContextOwner;
import jetbrains.mps.ide.INodeChecker;
import com.intellij.openapi.extensions.Extensions;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.typesystem.inference.TypeContextManager;
import java.util.Set;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.internal.collections.runtime.SetSequence;

public class LangSpecificChecker extends SpecificChecker implements ITypeContextOwner {
  private INodeChecker[] myLanguageCheckers;

  public LangSpecificChecker() {
    myLanguageCheckers = Extensions.getExtensions(INodeChecker.CHECKERS);
  }

  public List<SearchResult<ModelCheckerIssue>> checkModel(SModel model, ProgressContext progressContext, IOperationContext operationContext) {
    List<SearchResult<ModelCheckerIssue>> results = ListSequence.fromList(new ArrayList<SearchResult<ModelCheckerIssue>>());
    for (SNode rootNode : ListSequence.fromList(SModelOperations.getRoots(model, null))) {
      TypeContextManager.getInstance().getOrCreateContext(rootNode, this, true);
      if (!(progressContext.checkAndUpdateIndicator("Checking " + SModelOperations.getModelName(model) + " for constraints & scopes..."))) {
        break;
      }
      for (INodeChecker checker : myLanguageCheckers) {
        Set<IErrorReporter> iErrorReporters = checker.getErrors(rootNode, operationContext);
        for (IErrorReporter errorReporter : SetSequence.fromSet(iErrorReporters)) {
          addIssue(results, errorReporter.getSNode(), errorReporter.reportError(), SpecificChecker.getResultCategory(errorReporter.getMessageStatus()), "constraints", null);
        }
      }
      TypeContextManager.getInstance().removeOwnerForRootNodeContext(rootNode, this);
    }
    return results;
  }
}
