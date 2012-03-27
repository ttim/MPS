package jetbrains.mps.build.ant;

/*Generated by MPS */

import org.apache.tools.ant.Task;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import org.apache.tools.ant.types.FileSet;
import java.util.Iterator;
import org.apache.tools.ant.types.resources.FileResource;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.BuildException;
import java.util.Set;
import java.util.Hashtable;
import org.apache.tools.ant.util.JavaEnvUtils;
import java.io.FileNotFoundException;
import org.apache.tools.ant.taskdefs.Execute;
import java.io.IOException;
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import org.apache.tools.ant.ProjectComponent;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.io.FileInputStream;
import java.util.LinkedHashSet;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.apache.tools.ant.types.EnumeratedAttribute;
import java.util.Scanner;

public abstract class MpsLoadTask extends Task {
  public static final String CONFIGURATION_NAME = "configuration.name";
  public static final String BUILD_NUMBER = "build.number";

  private File myMpsHome;
  protected final WhatToDo myWhatToDo = new WhatToDo();
  private boolean myUsePropertiesAsMacro = false;
  private boolean myFork = true;
  private final List<String> myJvmArgs = new ArrayList<String>();

  public MpsLoadTask() {
  }

  public void setMpsHome(File mpsHome) {
    myMpsHome = mpsHome;
  }

  public File getMpsHome() {
    return myMpsHome;
  }

  public void setFailOnError(boolean failOnError) {
    myWhatToDo.updateFailOnError(failOnError);
  }

  public void setLogLevel(MpsLoadTask.LogLevelAttribute logLevel) {
    myWhatToDo.updateLogLevel(logLevel.getLevel());
  }

  public void setFork(boolean fork) {
    myFork = fork;
  }

  public void addConfiguredModel(FileSet modelsInner) {
    Iterator it = modelsInner.iterator();
    while (it.hasNext()) {
      FileResource next = (FileResource) it.next();
      myWhatToDo.addModelFile(next.getFile());
    }
  }

  public void addConfiguredModules(FileSet modulesInner) {
    Iterator it = modulesInner.iterator();
    while (it.hasNext()) {
      FileResource next = (FileResource) it.next();
      myWhatToDo.addModuleFile(next.getFile());
    }
  }

  public void addConfiguredProject(ProjectNested projectInner) {
    Iterator it = projectInner.iterator();
    while (it.hasNext()) {
      FileResource next = (FileResource) it.next();
      myWhatToDo.addProjectFile(next.getFile());
    }
  }

  public void addConfiguredExclude(ExcludeNested excludeInner) {
    for (File file : excludeInner.getExcludedFromDiffFiles()) {
      myWhatToDo.excludeFileFromDiff(file);
    }
  }

  public void addConfiguredLibrary(LibraryDataType libraryInner) {
    if (libraryInner.getName() == null) {
      log("Library missing required attribute name.", Project.MSG_ERR);
    } else
    if (libraryInner.getDir() == null) {
      throw new BuildException("Library missing required attribute dir.");
    }
    myWhatToDo.addLibrary(libraryInner.getName(), libraryInner.getDir(), libraryInner.getCompile());
  }

  public void addConfiguredMacro(Macro macro) {
    myWhatToDo.addMacro(macro.getName(), macro.getPath().getAbsolutePath());
  }

  public boolean getUsePropertiesAsMacro() {
    return myUsePropertiesAsMacro;
  }

  public void setUsePropertiesAsMacro(boolean usePropertiesAsMacro) {
    myUsePropertiesAsMacro = usePropertiesAsMacro;
  }

  public void addConfiguredJvmArg(Arg jvmArg) {
    if (!(myFork)) {
      throw new BuildException("Nested jvmarg is only allowed in fork mode.");
    }
    log("Nested jvmarg is deprecated. Use jvmargs instead.", Project.MSG_WARN);
    myJvmArgs.add(jvmArg.getValue());
  }

  public void addConfiguredJvmArgs(JvmArgs jvmArg) {
    if (!(myFork)) {
      throw new BuildException("Nested jvmargs is only allowed in fork mode.");
    }
    myJvmArgs.addAll(jvmArg.getArgs());
  }

  @Override
  public void execute() throws BuildException {
    checkMpsHome();
    Set<File> classPaths = calculateClassPath();
    if (myUsePropertiesAsMacro) {
      Hashtable properties = getProject().getProperties();
      for (Object name : properties.keySet()) {
        Object value = properties.get(name);
        myWhatToDo.addMacro((String) name, (String) value);
      }
    }
    if (myFork) {
      String currentClassPathString = System.getProperty("java.class.path");
      List<String> commandLine = new ArrayList<String>();
      commandLine.add(JavaEnvUtils.getJreExecutable("java"));
      if (myJvmArgs.isEmpty()) {
        commandLine.addAll(new JvmArgs().getArgs());
      } else {
        commandLine.addAll(myJvmArgs);
      }
      StringBuilder sb = new StringBuilder();
      String pathSeparator = System.getProperty("path.separator");
      for (File cp : classPaths) {
        sb.append(pathSeparator);
        sb.append(cp.getAbsolutePath());
      }
      commandLine.add("-classpath");
      commandLine.add(currentClassPathString + sb.toString());
      commandLine.add(AntBootstrap.class.getCanonicalName());
      commandLine.add(getWorkerClass().getCanonicalName());
      dumpPropertiesToWhatToDo();
      try {
        commandLine.add(myWhatToDo.dumpToTmpFile().getAbsolutePath());
      } catch (FileNotFoundException e) {
        throw new BuildException(e);
      }
      Execute exe = new Execute(getExecuteStreamHandler());
      exe.setAntRun(this.getProject());
      exe.setWorkingDirectory(this.getProject().getBaseDir());
      exe.setCommandline(commandLine.toArray(new String[commandLine.size()]));
      try {
        int i = exe.execute();
        if (i != 0) {
          processNonZeroExitCode(i);
        }
      } catch (IOException e) {
        log(e, Project.MSG_ERR);
      }
    } else {
      List<URL> classPathUrls = new ArrayList<URL>();
      for (File path : classPaths) {
        try {
          classPathUrls.add(new URL("file:///" + path + ((path.isDirectory() ?
            "/" :
            ""
          ))));
        } catch (MalformedURLException e) {
          throw new BuildException(e);
        }
      }
      URLClassLoader classLoader = new URLClassLoader(classPathUrls.toArray(new URL[classPathUrls.size()]), ProjectComponent.class.getClassLoader());
      try {
        Class<?> whatToGenerateClass = classLoader.loadClass(WhatToDo.class.getCanonicalName());
        Object whatToGenerate = whatToGenerateClass.newInstance();
        myWhatToDo.cloneTo(whatToGenerate);
        Class<?> generatorClass = classLoader.loadClass(getWorkerClass().getCanonicalName());
        Constructor<?> constructor = generatorClass.getConstructor(whatToGenerateClass, ProjectComponent.class);
        Object generator = constructor.newInstance(whatToGenerate, this);
        Method method = generatorClass.getMethod("work");
        method.invoke(generator);
      } catch (Throwable t) {
        throw new BuildException(t.getMessage() + "\n" + "Used class path: " + classPathUrls.toString());
      }
    }
  }

  private void outputBuildNumber() {
    String antTaskBuildNumber = null;
    URL resource = getClass().getResource("/build.number");
    if (resource == null) {
      log("Can't determine version of ant task.", Project.MSG_DEBUG);
      return;
    }
    try {
      antTaskBuildNumber = MpsLoadTask.readBuildNumber(resource.openStream());
      if (antTaskBuildNumber == null || antTaskBuildNumber.isEmpty()) {
        log("Can't determine version of ant task.", Project.MSG_DEBUG);
        return;
      }
    } catch (IOException ignore) {
      log("Can't determine version of ant task.", Project.MSG_DEBUG);
      return;
    }
    String mpsBuildNumber = null;
    try {
      mpsBuildNumber = MpsLoadTask.readBuildNumber(new FileInputStream(new File(myMpsHome.getAbsolutePath() + File.separator + "build.number")));
      if (mpsBuildNumber == null || mpsBuildNumber.isEmpty()) {
        log("Can't determine version of MPS.", Project.MSG_DEBUG);
        return;
      }
    } catch (IOException ignore) {
      log("Can't determine version of MPS.", Project.MSG_DEBUG);
      return;
    }
    if (mpsBuildNumber.equals(antTaskBuildNumber)) {
      log("Build number " + mpsBuildNumber, Project.MSG_INFO);
    } else {
      log("MPS build number is " + mpsBuildNumber + ", while ant task build number is " + antTaskBuildNumber + ".\n" + "This may cause errors.", Project.MSG_WARN);
    }
  }

  private void processNonZeroExitCode(int i) {
    throw new BuildException("Process exited with code " + i + ".");
  }

  private void dumpPropertiesToWhatToDo() {
    Hashtable properties = getProject().getProperties();
    for (Object key : properties.keySet()) {
      myWhatToDo.putProperty((String) key, (String) properties.get(key));
    }
  }

  protected MyExecuteStreamHandler getExecuteStreamHandler() {
    return new MyExecuteStreamHandler(this);
  }

  private void checkMpsHome() {
    if (myMpsHome == null) {
      String mpsHomePath = getProject().getProperty("mps.home");
      if (mpsHomePath == null || !(getProject().resolveFile(mpsHomePath).exists())) {
        throw new BuildException("Path to mps home expected. Specify mps.home property or mpshome attribute.");
      }
      myMpsHome = getProject().resolveFile(mpsHomePath);
    }
    outputBuildNumber();
  }

  private File absolutePath(String path) {
    return new File(myMpsHome.getAbsolutePath() + File.separator + path.replace('/', File.separatorChar));
  }

  private Set<File> calculateClassPath() {
    File[] pathsToLook;
    if (absolutePath("classes").exists()) {
      //         absolutePath("platform/uiLanguage"), 
      //         absolutePath("core/kernel/xmlQuery/runtime"), 
      //         absolutePath("platform/gtext"), 
      //         absolutePath("platform/builders"), 
      pathsToLook = new File[]{absolutePath("core"), absolutePath("lib"), absolutePath("plugins/mpsbuild/languages/solutions/jetbrains.mps.build.mps.runtime"), absolutePath("languages/baseLanguage/closures/runtime"), absolutePath("languages/baseLanguage/collections/runtime"), absolutePath("languages/baseLanguage/baseLanguage/solutions/jetbrains.mps.baseLanguage.search"), absolutePath("workbench/typesystemUi/classes"), absolutePath("MPSPlugin/apiclasses")};
    } else {
      pathsToLook = new File[]{absolutePath("lib"), absolutePath("plugin"), absolutePath("plugins")};
    }
    Set<File> classPaths = new LinkedHashSet<File>();
    for (File path : pathsToLook) {
      if (!(path.exists()) || (!(path.isDirectory()) && !(path.getAbsolutePath().endsWith(".jar")))) {
        throw new BuildException(myMpsHome + " is invalid MPS home path: path " + path + " does not exist or is not a directory or a jar file.");
      } else
      if (!(path.isDirectory())) {
        classPaths.add(path.getAbsoluteFile());
      } else {
        gatherAllClassesAndJarsUnder(path, classPaths);
      }
    }
    File mpsClasses = absolutePath("classes");
    if (mpsClasses.exists()) {
      classPaths.add(mpsClasses);
    }
    return classPaths;
  }

  protected abstract Class<? extends MpsWorker> getWorkerClass();

  private void gatherAllClassesAndJarsUnder(File dir, Set<File> result) {
    if (dir.getName().equals("classes") || dir.getName().equals("classes_gen") || dir.getName().equals("apiclasses")) {
      result.add(dir);
      return;
    }
    File[] children = dir.listFiles();
    //  we do not want trove different from ours in $mps.home$/lib 
    String troveJar = "trove" + File.separator + "lib" + File.separator + "trove";
    //  to provide right order of class loading, 
    //  files go first 
    for (File f : children) {
      if (!(f.isDirectory())) {
        if (f.getName().endsWith(".jar") && !(f.getName().contains("ant.jar")) && !(f.getPath().contains(troveJar))) {
          result.add(f);
        }
      }
    }
    for (File f : children) {
      if (f.isDirectory()) {
        if (f.getName().equals("classes") || f.getName().equals("classes_gen")) {
          result.add(f);
        } else {
          gatherAllClassesAndJarsUnder(f, result);
        }
      }
    }
  }

  public static String readBuildNumber(InputStream stream) {
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new InputStreamReader(stream));
      String buildNumber = null;
      String configurationName = null;
      while (true) {
        String line = bufferedReader.readLine();
        if (line == null) {
          break;
        }
        if (line.startsWith(CONFIGURATION_NAME)) {
          String tmp = line.substring(CONFIGURATION_NAME.length());
          configurationName = tmp.replaceAll("(\\s*)=(\\s*)(.*)", "$3");
        } else
        if (line.startsWith(BUILD_NUMBER)) {
          String tmp = line.substring(BUILD_NUMBER.length());
          buildNumber = tmp.replaceAll("(\\s*)=(\\s*)(.*)", "$3");
        }
      }
      if (buildNumber != null && configurationName != null) {
        return configurationName + "." + buildNumber;
      }
    } catch (FileNotFoundException ignore) {
    } catch (IOException ignore) {
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (IOException ignore) {
        }
      }
    }
    return null;
  }

  private static   enum LogLevel {
    ERROR(Project.MSG_ERR),
    WARNING(Project.MSG_WARN),
    INFO(Project.MSG_INFO),
    DEBUG(Project.MSG_DEBUG);

    private int myLevel;

    LogLevel(int level) {
      myLevel = level;
    }

    public int getLevel() {
      return myLevel;
    }
  }

  public static class LogLevelAttribute extends EnumeratedAttribute {
    private static final List<String> myLevels = new ArrayList<String>();

    public LogLevelAttribute() {
    }

    public String[] getValues() {
      return myLevels.toArray(new String[myLevels.size()]);
    }

    public int getLevel() {
      return MpsLoadTask.LogLevel.values()[myLevels.indexOf(getValue())].getLevel();
    }

    private static String getLevelText(MpsLoadTask.LogLevel l) {
      return l.name().toLowerCase();
    }

    static {
      for (MpsLoadTask.LogLevel l : MpsLoadTask.LogLevel.values()) {
        myLevels.add(MpsLoadTask.LogLevelAttribute.getLevelText(l));
      }
    }
  }

  public static abstract class AbstractOutputReader extends Thread {
    private InputStream myInputStream;

    public AbstractOutputReader(InputStream inputStream) {
      this.myInputStream = inputStream;
    }

    public void run() {
      Scanner s = new Scanner(this.myInputStream);
      try {
        while (!((this.isInterrupted())) && s.hasNextLine()) {
          this.addMessage(s.nextLine());
        }
      } catch (Exception e) {
      }
    }

    protected abstract void addMessage(String message);
  }
}
