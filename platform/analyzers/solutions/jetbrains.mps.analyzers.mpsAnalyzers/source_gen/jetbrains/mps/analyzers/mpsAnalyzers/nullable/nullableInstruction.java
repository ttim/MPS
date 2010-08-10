package jetbrains.mps.analyzers.mpsAnalyzers.nullable;

/*Generated by MPS */

import jetbrains.mps.analyzers.runtime.framework.GeneratedInstruction;
import jetbrains.mps.smodel.SNode;

public class nullableInstruction extends GeneratedInstruction {
  private SNode myexpression;
  private String myPresentation;

  public nullableInstruction(SNode expression) {
    StringBuilder sb = new StringBuilder();
    sb.append("nullable");
    myexpression = expression;
    putUserObject("expression", expression);
    addParameter(expression);
    sb.append(" " + expression);
    myPresentation = sb.toString();
  }

  @Override
  public String commandPresentation() {
    return myPresentation;
  }

  public SNode getexpression() {
    return myexpression;
  }
}
