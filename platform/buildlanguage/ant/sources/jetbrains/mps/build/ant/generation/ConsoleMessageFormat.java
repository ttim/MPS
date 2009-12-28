package jetbrains.mps.build.ant.generation;

import jetbrains.mps.build.ant.IBuildServerMessageFormat;
import org.jetbrains.annotations.NotNull;

public class ConsoleMessageFormat implements IBuildServerMessageFormat {
  @Override
  public StringBuffer escapeBuildMessage(@NotNull StringBuffer message) {
    return message;
  }

  @Override
  public String escapeBuildMessage(@NotNull String message) {
    return message;
  }

  @Override
  public String getLinesSeparator() {
    return System.getProperty("line.separator");
  }

  @Override
  public String formatTestStart(@NotNull String testName) {
    return "Test Started: " + testName;
  }

  @Override
  public String formatTestFinish(@NotNull String testName) {
    return "Test Finished: " + testName;
  }

  @Override
  public CharSequence formatTestFailure(@NotNull String testName, @NotNull String message, @NotNull CharSequence details) {
    return "Test Failed: " + testName + " with message:\n" + message + "\n" + details;
  }

  @Override
  public boolean isBuildServerMessage(@NotNull CharSequence message) {
    return false;
  }

  @Override
  public int hasContinuation(@NotNull String message) {
    return 0;
  }
}
