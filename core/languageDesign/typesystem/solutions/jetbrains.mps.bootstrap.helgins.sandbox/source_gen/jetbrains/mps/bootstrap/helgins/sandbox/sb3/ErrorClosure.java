package jetbrains.mps.bootstrap.helgins.sandbox.sb3;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.typesystem.inference.TypeContextManager;
import jetbrains.mps.util.Computable;

public class ErrorClosure<Q> {
  public ErrorClosure() {
  }

  private <K, C extends CClass> Map<K, C> f(_FunctionTypes._return_P1_E0<? extends K, ? super C> arg) {
    return null;
  }

  public void gg(String s) {
  }

  public void g() {
    Q q;
    f(new _FunctionTypes._return_P1_E0<String, CClass>() {
      public String invoke(CClass c) {
        return "";
      }
    });
    Iterable<String> s;
    String runResolveAction = TypeContextManager.getInstance().runResolveAction(new Computable<String>() {
      public String compute() {
        return "";
      }
    });
  }
}
