package jetbrains.mps.ide.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.typesystem.inference.NodeTypesComponentsRepository;
import java.util.Set;
import jetbrains.mps.util.Pair;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.nodeEditor.MessageStatus;

public class TypesystemChecker extends SpecificChecker {
  public TypesystemChecker() {
  }

  public List<SearchResult<ModelCheckerIssue>> checkModel(SModel model, ProgressContext progressContext, IOperationContext operationContext) {
    List<SearchResult<ModelCheckerIssue>> results = ListSequence.fromList(new ArrayList<SearchResult<ModelCheckerIssue>>());

    for (SNode rootNode : ListSequence.fromList(SModelOperations.getRoots(model, null))) {
      if (!(progressContext.checkAndUpdateIndicator("Checking " + SModelOperations.getModelName(model) + " for typesystem rules..."))) {
        break;
      }
      TypeCheckingContext typeCheckingContext = NodeTypesComponentsRepository.getInstance().createTypeCheckingContext(rootNode);
      typeCheckingContext.setOperationContext(operationContext);
      Set<Pair<SNode, List<IErrorReporter>>> nodeWithErrors = typeCheckingContext.checkRootAndGetErrors(true);
      for (Pair<SNode, List<IErrorReporter>> nodeErrorReporters : SetSequence.fromSet(nodeWithErrors)) {
        SNode node = nodeErrorReporters.o1;
        for (IErrorReporter errorReporter : ListSequence.fromList(nodeErrorReporters.o2)) {
          addIssue(results, node, errorReporter.reportError(), getResultCategory(errorReporter.getMessageStatus()), "type system", null);
        }
      }
    }
    return results;
  }

  private static String getResultCategory(MessageStatus messageStatus) {
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
}
