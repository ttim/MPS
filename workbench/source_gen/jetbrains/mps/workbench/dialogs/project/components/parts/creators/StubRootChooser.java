package jetbrains.mps.workbench.dialogs.project.components.parts.creators;

/*Generated by MPS */

import com.intellij.openapi.util.Computable;
import java.util.List;
import jetbrains.mps.project.structure.modules.StubModelsEntry;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import jetbrains.mps.ide.ui.filechoosers.treefilechooser.TreeFileChooser;
import jetbrains.mps.vfs.IFile;
import java.util.ArrayList;
import jetbrains.mps.smodel.LanguageID;

public class StubRootChooser implements Computable<List<StubModelsEntry>> {
  private final IBindedDialog myOwner;

  public StubRootChooser(IBindedDialog owner) {
    myOwner = owner;
  }

  public List<StubModelsEntry> compute() {
    TreeFileChooser chooser = new TreeFileChooser();
    chooser.setMode(TreeFileChooser.MODE_FILES_AND_DIRECTORIES);
    List<IFile> files = chooser.showMultiSelectionDialog(myOwner.getMainComponent());
    List<StubModelsEntry> result = new ArrayList<StubModelsEntry>();
    for (IFile file : files) {
      StubModelsEntry sme = new StubModelsEntry();
      sme.setPath(file.getAbsolutePath());
      sme.setManager(LanguageID.JAVA_MANAGER);
      result.add(sme);
    }
    return result;
  }
}
