package jetbrains.mps.build.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.Extension;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;

public class Extension_CanEditBaseDir_ extends Extension.Default<_FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> {
  public Extension_CanEditBaseDir_() {
    super("jetbrains.mps.build.CanEditBaseDir");
  }

  public _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> get() {
    // we are here => we are in standalone MPS => can edit basedir 
    return new _FunctionTypes._return_P1_E0<Boolean, SNode>() {
      public Boolean invoke(SNode p) {
        return (p != null);
      }
    };
  }
}
