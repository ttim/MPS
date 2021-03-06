package jetbrains.mps.workbench.dialogs.project.components.parts.creators;

/*Generated by MPS */

import jetbrains.mps.util.Computable;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.FilteredGlobalScope;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;

public class DevKitChooser implements Computable<List<ModuleReference>> {
  private final IBindedDialog myOwner;

  public DevKitChooser(IBindedDialog owner) {
    myOwner = owner;
  }

  public List<ModuleReference> compute() {
    final Wrappers._T<List<ModuleReference>> dkRefs = new Wrappers._T<List<ModuleReference>>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        Iterable<DevKit> devkits = new FilteredGlobalScope().getVisibleDevkits();
        dkRefs.value = Sequence.fromIterable(devkits).select(new ISelector<DevKit, ModuleReference>() {
          public ModuleReference select(DevKit it) {
            return it.getModuleReference();
          }
        }).toListSequence();
      }
    });
    return CommonChoosers.showDialogModuleCollectionChooser(myOwner.getMainComponent(), "devkit", dkRefs.value, null);
  }
}
