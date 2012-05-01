package jetbrains.mps.lang.resources.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.generator.fileGenerator.FileGenerationUtil;
import jetbrains.mps.util.MacrosUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.vfs.IFileUtils;
import jetbrains.mps.project.IModule;
import javax.swing.ImageIcon;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IconResource_Behavior {
  private static Class[] PARAMETERS_8974276187400029990 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static void virtual_generate_8974276187400030152(final SNode thisNode) {
    ModelAccess.instance().writeFilesInEDT(new Runnable() {
      public void run() {
        SModelDescriptor model = SNodeOperations.getModel(thisNode).getModelDescriptor();
        String outputRoot = model.getModule().getOutputFor(model);
        IFile outputRootFile = FileSystem.getInstance().getFileByPath(outputRoot);
        IFile output = FileGenerationUtil.getDefaultOutputDir(model, outputRootFile);

        // copy 
        String source = MacrosUtil.expandPath(SPropertyOperations.getString(thisNode, "path"), model.getModule().getModuleFqName());
        IFile sourceFile = FileSystem.getInstance().getFileByPath(source);

        IFileUtils.copyFileContent(sourceFile, output.getDescendant(sourceFile.getName()));
      }
    });
  }

  public static boolean call_isValid_8974276187400030063(SNode thisNode) {
    IModule module = SNodeOperations.getModel(thisNode).getModelDescriptor().getModule();
    if (module == null) {
      return false;
    }
    String path = MacrosUtil.expandPath(SPropertyOperations.getString(thisNode, "path"), module.getModuleFqName());
    if (path == null) {
      return false;
    }
    IFile file = FileSystem.getInstance().getFileByPath(path);
    if (!(file.exists())) {
      return false;
    }
    try {
      new ImageIcon(path);
      return true;
    } catch (Throwable t) {
      return false;
    }
  }

  public static String call_getFilename_8974276187400030131(SNode thisNode) {
    String fullPath = SPropertyOperations.getString(thisNode, "path");
    return fullPath.substring(fullPath.lastIndexOf("/") + 1);
  }

  public static void call_generate_8974276187400029990(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.resources.structure.IconResource"), "virtual_generate_8974276187400030152", PARAMETERS_8974276187400029990);
  }

  public static void callSuper_generate_8974276187400029990(SNode thisNode, String callerConceptFqName) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.resources.structure.IconResource"), callerConceptFqName, "virtual_generate_8974276187400030152", PARAMETERS_8974276187400029990);
  }
}
