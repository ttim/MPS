package jetbrains.mps.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.INodeAdapter;
import jetbrains.mps.regexp.structure.RegexpExpression;

public interface RegexpUsingConstruction extends INodeAdapter {
  public static String REGEXP = "regexp";

  public RegexpExpression getRegexp();
  public void setRegexp(RegexpExpression node);
}
