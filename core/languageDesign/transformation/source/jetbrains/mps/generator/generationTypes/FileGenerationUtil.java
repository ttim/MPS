package jetbrains.mps.generator.generationTypes;

import jetbrains.mps.smodel.*;
import jetbrains.mps.generator.GenerationStatus;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.generator.fileGenerator.IFileGenerator;
import jetbrains.mps.textGen.TextGenManager;
import jetbrains.mps.plugin.IProjectHandler;
import jetbrains.mps.ide.messages.IMessageHandler;
import jetbrains.mps.util.FileUtil;
import jetbrains.mps.project.IModule;
import jetbrains.mps.logging.Logger;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.rmi.RemoteException;

public class FileGenerationUtil {
  public static final Logger LOG = Logger.getLogger(FileGenerationUtil.class);

  private static String LAST_GENERATION_TIME = "lastGenerationTime";

  public static long getLastGenerationTime(SModelDescriptor sm) {
    Set<IModule> modules = sm.getModules();

    if (modules.size() != 1) {
      LOG.warning("model " + sm.getModelUID() + " has to many owners : " + modules);
    }

    IModule module = modules.iterator().next();

    String outputPath = module.getGeneratorOutputPath();

    String sourcesDir = outputPath + File.separator + sm.getLongName().replace('.', File.separatorChar);

    return FileUtil.getNewestFileTime(new File(sourcesDir));
  }

  public static void updateLastGenerationTime(SModelDescriptor sm) {
//    sm.setAttribute(LAST_GENERATION_TIME, "" + System.currentTimeMillis());
  }

  public static boolean generationRequired(SModelDescriptor sm) {
    if (SModelStereotype.JAVA_STUB.equals(sm.getStereotype())) {
      return false;
    }        

    if (sm.getModelFile() == null) {
      return false;
    }

    if (Language.isAccessoryModel(sm)) {
      return false;
    }

//    if (sm.getSModel().getRoots().size() == 0) {
//      return false;
//    }

    return sm.lastChangeTime() >= getLastGenerationTime(sm);
  }

  public static void handleOutput(IOperationContext context, SModelDescriptor sm, GenerationStatus status, String outputDir, IMessageHandler messages) {
    if (outputDir == null) throw new RuntimeException("Unspecified output path. Please specify one.");

    File outputRootDirectory = new File(outputDir);
    GeneratorManager gm = context.getProject().getComponentSafe(GeneratorManager.class);
    Map<SNode, String> outputNodeContents = new LinkedHashMap<SNode, String>();

    if (generateText(context, status, outputNodeContents, messages)) {

      System.out.println("model = " + sm.getModelUID());

      int yesNo = JOptionPane.showConfirmDialog(context.getMainFrame(), "Generated code isn't compilable." + "" +
              "Are you sure that you want generate file from it?", "Generated Code Isn't Compilable", JOptionPane.YES_NO_OPTION);

      if (yesNo == JOptionPane.NO_OPTION) return;
    }

    Set<File> generatedFiles = new HashSet<File>();
    Set<File> directories = new HashSet<File>();

    generateFiles(status, sm, outputRootDirectory, gm, outputNodeContents, generatedFiles, directories);


    IProjectHandler handler = context.getProject().getProjectHandler();
    if (handler != null) {
      try {
        handler.addFilesToVCS(new ArrayList<File>(generatedFiles));
      } catch (RemoteException e) {
        e.printStackTrace();
      }
    }

    cleanUp(context, generatedFiles, directories);
  }

  public static boolean generateText(IOperationContext context, GenerationStatus status, Map<SNode, String> outputNodeContents, IMessageHandler messages) {
    boolean hasErrors = false;
    for (SNode outputNode : status.getOutputModel().getRoots()) {
      try {
        TextGenerationUtil.TextGenerationResult result = TextGenerationUtil.generateText(context, outputNode, messages);
        hasErrors |= result.hasErrors();
        outputNodeContents.put(outputNode, result.getText());
      } finally {
        // todo: get rid of this.
        TextGenManager.reset();
      }
    }
    return hasErrors;
  }

  public static void cleanUp(IOperationContext context, Set<File> generatedFiles, Set<File> directories) {
    // clear garbage
    List<File> filesToDelete = new ArrayList<File>();
    for (File dir : directories) {
      for (File outputDirectoryFile : dir.listFiles()) {
        if (!outputDirectoryFile.isDirectory() && !outputDirectoryFile.isHidden()) {
          if (!generatedFiles.contains(outputDirectoryFile)) {
            filesToDelete.add(outputDirectoryFile);
          }
        }
      }
    }
    IProjectHandler projectHandler = context.getProject().getProjectHandler();
    if (projectHandler != null) {
      try {
        projectHandler.deleteFilesAndRemoveFromVCS(filesToDelete);
      } catch(RemoteException ex) {
        GenerateFilesGenerationType.LOG.error(ex);
      }
    } else {
      for (File file : filesToDelete) {
        file.delete();
      }
    }
  }

  public static void generateFiles(GenerationStatus status, SModelDescriptor sm, File outputRootDirectory, GeneratorManager gm, Map<SNode, String> outputNodeContents, Set<File> generatedFiles, Set<File> directories) {
    updateLastGenerationTime(sm);
    for (SNode outputRootNode : outputNodeContents.keySet()) {
      try {
        SNode originalInputNode = null;
        if (status.getTraceMap() != null) {
          originalInputNode = status.getTraceMap().getOriginalInputNode(outputRootNode);
        }
        IFileGenerator fileGenerator = gm.chooseFileGenerator(outputRootNode, originalInputNode);
        if (fileGenerator == null) {
          GenerateFilesGenerationType.LOG.error("Couldn't find file generator for output node: " + outputRootNode.getDebugText());
          gm.chooseFileGenerator(outputRootNode, originalInputNode);
        } else {
          File generatedFile = fileGenerator.generateFile(outputRootNode, originalInputNode, status.getSourceModel(), outputNodeContents.get(outputRootNode), outputRootDirectory);

          if (generatedFile != null) {
            generatedFiles.add(generatedFile);
            directories.add(generatedFile.getParentFile());
          }
        }
      } catch (IOException e) {
        GenerateFilesGenerationType.LOG.error(e);
      }
    }
  }
}
