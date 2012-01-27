package jetbrains.mps.baseLanguage.collections.trove.plugin;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.Extension;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class Extension_customContainers_ extends Extension.Default<_FunctionTypes._return_P0_E0<? extends List<SNode>>> {
  public Extension_customContainers_() {
    super("jetbrains.mps.baseLanguage.collections.customContainers");
  }

  public _FunctionTypes._return_P0_E0<? extends List<SNode>> get() {
    return new _FunctionTypes._return_P0_E0<List<SNode>>() {
      public List<SNode> invoke() {
        List<SNode> res = new ArrayList<SNode>();
        // Find the model(s) with custom container declarations 
        SModelDescriptor desc = GlobalScope.getInstance().getModelDescriptor(SModelFqName.fromString("jetbrains.mps.baseLanguage.collections.trove.containers"));
        SModel mdl = desc.getSModel();
        if (mdl != null) {
          ListSequence.fromList(res).addSequence(ListSequence.fromList(SModelOperations.getNodes(mdl, "jetbrains.mps.baseLanguage.collections.structure.CustomContainers")));
        }
        return res;
      }
    };
  }
}
