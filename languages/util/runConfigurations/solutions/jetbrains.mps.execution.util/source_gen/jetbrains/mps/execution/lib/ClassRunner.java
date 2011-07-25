package jetbrains.mps.execution.lib;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import org.apache.commons.lang.StringUtils;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Method;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.io.File;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.util.Arrays;

public class ClassRunner {
  @NotNull
  public static final String CLASS_PREFIX = "c";
  @NotNull
  public static final String FILE_PREFIX = "f";

  public ClassRunner() {
  }

  public static void main(String[] args) {
    String className = null;
    String fileName = null;

    // parse args 
    for (int i = 0; i < args.length; i++) {
      if (getCommandLineFromPrefix(CLASS_PREFIX).equals(args[i])) {
        if (i >= args.length - 1) {
          System.err.println("Class name after " + getCommandLineFromPrefix(ClassRunner.CLASS_PREFIX) + " expected.");
          return;
        }
        className = args[i + 1];
        i++;
      } else if (getCommandLineFromPrefix(FILE_PREFIX).equals(args[i])) {
        if (i >= args.length - 1) {
          System.err.println("File name after " + getCommandLineFromPrefix(FILE_PREFIX) + " expected.");
          return;
        }
        fileName = args[i + 1];
      }
    }

    // check if empty 
    if (StringUtils.isEmpty(className)) {
      System.err.println("Main class name expected (example " + getCommandLineFromPrefix(CLASS_PREFIX) + " com.mycompany.ClassName).");
      return;
    } else if (StringUtils.isEmpty(fileName)) {
      System.err.println("Path to file with arguments expected (example " + getCommandLineFromPrefix(ClassRunner.FILE_PREFIX) + " /path/to/file).");
      return;
    }

    // read 
    List<String> fileContents;
    try {
      fileContents = readArguments(fileName);
    } catch (IOException e) {
      System.err.println("Could not read file with arguments.");
      e.printStackTrace();
      return;
    }

    // execute 
    try {
      Class<?> classToStart = Class.forName(className);
      Method method = classToStart.getMethod("main", args.getClass());
      method.invoke(null, ListSequence.fromList(fileContents).toGenericArray(String.class));
    } catch (ClassNotFoundException c) {
      System.err.println("Class " + className + " was not found.");
      c.printStackTrace();
    } catch (NoSuchMethodException e) {
      System.err.println("Class " + className + " does not have main method.");
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.getCause().printStackTrace();
    } catch (IllegalAccessException e) {
      System.err.println("Method main in class " + className + " is not public.");
      e.printStackTrace();
    }

  }

  public static List<String> readArguments(String fileName) throws IOException {
    List<String> result = ListSequence.fromList(new ArrayList<String>());
    new File(fileName).deleteOnExit();
    LineNumberReader reader = new LineNumberReader(new FileReader(fileName));
    while (true) {
      String line = reader.readLine();
      if (line == null) {
        break;
      }
      if (StringUtils.isEmpty(line)) {
        continue;
      }
      ListSequence.fromList(result).addSequence(ListSequence.fromList(Arrays.asList(line.split("(\\s)+"))));
    }
    return result;
  }

  @NotNull
  private static String getCommandLineFromPrefix(String prefix) {
    return "-" + prefix;
  }
}
