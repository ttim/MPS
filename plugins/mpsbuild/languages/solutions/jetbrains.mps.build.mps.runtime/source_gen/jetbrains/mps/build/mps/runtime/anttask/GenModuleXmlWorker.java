package jetbrains.mps.build.mps.runtime.anttask;

/*Generated by MPS */

import jetbrains.mps.build.ant.MpsWorker;
import jetbrains.mps.build.ant.WhatToDo;
import org.apache.tools.ant.ProjectComponent;
import jetbrains.mps.build.ant.Environment;
import jetbrains.mps.project.Project;
import java.util.List;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.util.Computable;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import java.io.PrintWriter;
import java.io.PrintStream;
import jetbrains.mps.project.Solution;
import jetbrains.mps.smodel.Language;
import java.util.Collection;
import java.io.IOException;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.project.dependency.GlobalModuleDependenciesManager;
import java.io.File;

public class GenModuleXmlWorker extends MpsWorker {
  public static final String INDENT_WITH = "  ";
  public static final int INDENT_INNER_XML = 2;

  public GenModuleXmlWorker(WhatToDo whatToDo) {
    super(whatToDo);
  }

  public GenModuleXmlWorker(WhatToDo whatToDo, ProjectComponent component) {
    super(whatToDo, component);
  }

  public GenModuleXmlWorker(WhatToDo whatToDo, ProjectComponent component, Environment environment) {
    super(whatToDo, component, environment);
  }

  public GenModuleXmlWorker(WhatToDo whatToDo, MpsWorker.AntLogger logger) {
    super(whatToDo, logger);
  }

  protected void executeTask(Project project, MpsWorker.ObjectsToProcess go) {
  }

  protected void showStatistic() {
  }

  @Override
  public void work() {
    setupEnvironment();
    final Project project = createDummyProject();
    reload();
    List<String> parameters = myWhatToDo.getParameters();
    for (String parameter : parameters) {
      processParameter(project, parameter);
    }
    dispose();
    showStatistic();
  }

  public void processParameter(Project project, String parameter) {
    ModuleXml params = GenModuleXmlTask.decode(parameter);

    final ModuleReference moduleRef = ModuleReference.fromString(params.getRef());
    IModule module = ModelAccess.instance().runReadAction(new Computable<IModule>() {
      public IModule compute() {
        return MPSModuleRepository.getInstance().getModule(moduleRef);
      }
    });
    IFile xmlfile = FileSystem.getInstance().getFileByPath(params.getDestfile());

    writeFile(xmlfile, moduleRef, module, params.getInnerText(INDENT_INNER_XML, INDENT_WITH));
  }

  public void writeFile(IFile file, ModuleReference moduleRef, IModule module, String extraText) {

    try {
      PrintWriter wr = new PrintWriter(new PrintStream(file.openOutputStream()));
      wr.println("<module namespace=\"" + moduleRef.getModuleFqName() + "\" uuid=\"" + moduleRef.getModuleId() + "\" type=\"" + ((module instanceof Solution ?
        "solution" :
        (module instanceof Language ?
          "language" :
          "unknown"
        )
      )) + "\">");

      wr.println(INDENT_WITH + "<dependencies>");
      Collection<IModule> dependencies = getDepenencies(module);
      if (dependencies == null) {
        // <node> 
        error("module " + moduleRef + " was not found in repository");
        return;
      }
      for (IModule m : dependencies) {
        wr.println(INDENT_WITH + INDENT_WITH + "<module ref=\"" + m.getModuleReference().toString() + "\" />");
      }
      wr.println(INDENT_WITH + "</dependencies>");

      wr.println(extraText);

      wr.println("</module>");
      wr.close();
    } catch (IOException e) {
      error("Error writing to " + file.getPath());
    }
  }

  private Collection<IModule> getDepenencies(final IModule module) {
    if (module == null) {
      return null;
    }
    final Wrappers._T<Collection<IModule>> res = new Wrappers._T<Collection<IModule>>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        res.value = new GlobalModuleDependenciesManager(module).getModules(GlobalModuleDependenciesManager.Deptype.COMPILE);
      }
    });
    return res.value;
  }

  public static void main(String[] args) {
    new GenModuleXmlWorker(WhatToDo.fromDumpInFile(new File(args[0])), new MpsWorker.LogLogger()).workFromMain();
  }
}
