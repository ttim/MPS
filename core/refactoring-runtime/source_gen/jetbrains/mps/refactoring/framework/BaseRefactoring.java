package jetbrains.mps.refactoring.framework;

/*Generated by MPS */

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import java.util.ArrayList;
import jetbrains.mps.ide.findusages.model.SearchResults;

public abstract class BaseRefactoring implements IRefactoring {
  private Set<String> myTransientParameters = new HashSet<String>();

  public BaseRefactoring() {
  }

  protected void addTransientParameter(String parameter) {
    myTransientParameters.add(parameter);
  }

  public Set<String> getTransientParameters() {
    return myTransientParameters;
  }

  @Deprecated
  public String getKeyStroke() {
    return "";
  }

  public Class getOverridenRefactoringClass() {
    return null;
  }

  public boolean init(RefactoringContext refactoringContext) {
    return true;
  }

  public List<SModel> getModelsToGenerate(RefactoringContext refactoringContext) {
    return new ArrayList<SModel>();
  }

  public void doWhenDone(RefactoringContext refactoringContext) {
  }

  public SearchResults getAffectedNodes(RefactoringContext refactoringContext) {
    return new SearchResults();
  }
}
