package jetbrains.mps.execution.common.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.regexp.runtime.Replacer;
import java.util.regex.Matcher;

public class _Replacer_tq53pp_a0a0f0r implements Replacer {
  /*package*/ IGeneratedToClass_Behavior _enclosingClass;
  /*package*/ Object _closureContext;

  public _Replacer_tq53pp_a0a0f0r(IGeneratedToClass_Behavior enclosingClass, Object closureContext) {
    this._enclosingClass = enclosingClass;
    this._closureContext = (Object) closureContext;
  }

  public String replace(Matcher matcher) {
    return matcher.group(1).toUpperCase();
  }
}
