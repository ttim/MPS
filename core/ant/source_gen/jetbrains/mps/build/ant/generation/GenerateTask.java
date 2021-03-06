package jetbrains.mps.build.ant.generation;

/*Generated by MPS */

import jetbrains.mps.build.ant.MpsLoadTask;
import jetbrains.mps.build.ant.MpsWorker;
import jetbrains.mps.build.ant.generation.workers.GeneratorWorker;

public class GenerateTask extends MpsLoadTask {
  {
    myWhatToDo.putProperty(COMPILE, Boolean.toString(true));
    myWhatToDo.putProperty(STRICT_MODE, Boolean.toString(true));
    myWhatToDo.putProperty(PARALLEL_MODE, Boolean.toString(false));
  }

  public static final String COMPILE = "COMPILE";
  public static final String STRICT_MODE = "STRICT_MODE";
  public static final String PARALLEL_MODE = "PARALLEL_MODE";

  public GenerateTask() {
  }

  protected Class<? extends MpsWorker> getWorkerClass() {
    return GeneratorWorker.class;
  }

  public void setCompile(boolean compile) {
    myWhatToDo.putProperty(COMPILE, Boolean.toString(compile));
  }

  protected boolean getCompile() {
    return Boolean.parseBoolean(myWhatToDo.getProperty(COMPILE));
  }

  public void setStrictMode(boolean strictMode) {
    myWhatToDo.putProperty(STRICT_MODE, Boolean.toString(strictMode));
  }

  protected boolean getStrictMode() {
    return Boolean.parseBoolean(myWhatToDo.getProperty(STRICT_MODE));
  }

  public void setParallelMode(boolean parallelMode) {
    myWhatToDo.putProperty(PARALLEL_MODE, Boolean.toString(parallelMode));
  }

  protected boolean getParallelMode() {
    return Boolean.parseBoolean(myWhatToDo.getProperty(PARALLEL_MODE));
  }
}
