package jetbrains.mps.baseLanguage.unitTest.runtime;

/*Generated by MPS */

import java.util.List;
import java.util.regex.Pattern;
import org.junit.runner.Description;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.regex.Matcher;
import java.util.ArrayList;

public class ModernTestEvent {
  public static String START_TEST_PREFIX = "<START_TEST>";
  public static String END_TEST_PREFIX = "<END_TEST>";
  public static String ERROR_TEST_PREFIX = "<TEST_ERROR_BEGIN>";
  public static String ERROR_TEST_SUFFIX = "<TEST_ERROR_END>";
  public static String FAILURE_TEST_PREFIX = "<TEST_FAILURE_BEGIN>";
  public static String FAILURE_TEST_SUFFIX = "<TEST_FAILURE_END>";
  private static List<String> ALL_TOKENS;
  private static Pattern REGEXP_m4mvdg_a0a0b0b0c = Pattern.compile("([^:]+)(?::([^:]+))?:memory=(\\d+):time=(\\d+)", 0);

  private final String myToken;
  private final String myTestCaseName;
  private final String myTestMethodName;
  private final long myMemoryUsage;
  private final long myTime;

  public ModernTestEvent(String token, Description description) {
    myToken = token;
    myTestCaseName = description.getTestClass().getName();
    myTestMethodName = description.getMethodName();
    Runtime runtime = Runtime.getRuntime();
    myMemoryUsage = runtime.totalMemory() - runtime.freeMemory();
    myTime = System.currentTimeMillis();
  }

  private ModernTestEvent(String token, String testCaseName, String testMethodName, long memoryUsage, long time) {
    myToken = token;
    myTestCaseName = testCaseName;
    myTestMethodName = testMethodName;
    myMemoryUsage = memoryUsage;
    myTime = time;
  }

  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(this.myToken);
    builder.append(this.myTestCaseName);
    if (this.myTestMethodName != null) {
      builder.append(':').append(this.myTestMethodName);
    }
    builder.append(":memory=").append(this.myMemoryUsage);
    builder.append(":time=").append(this.myTime);
    return builder.toString();
  }

  public String getToken() {
    return this.myToken;
  }

  public String getTestCaseName() {
    return this.myTestCaseName;
  }

  public String getTestMethodName() {
    return this.myTestMethodName;
  }

  public long getMemoryUsage() {
    return this.myMemoryUsage;
  }

  public long getTime() {
    return this.myTime;
  }

  @Override
  public boolean equals(Object p0) {
    if (p0 == null || !(p0 instanceof ModernTestEvent)) {
      return false;
    }
    ModernTestEvent event = (ModernTestEvent) p0;
    return event.myToken.equals(this.myToken) && event.myTestCaseName.equals(this.myTestCaseName) && event.myTestMethodName.equals(this.myTestMethodName);
  }

  @Override
  public int hashCode() {
    return this.myToken.hashCode() + 10 * this.myTestCaseName.hashCode() + 10 * this.myTestMethodName.hashCode();
  }

  public static String isTestEvent(String messageString) {
    String token = null;
    for (String expectedToken : ListSequence.fromList(ModernTestEvent.ALL_TOKENS)) {
      if (messageString.startsWith(expectedToken)) {
        token = expectedToken;
        break;
      }
    }
    return token;
  }

  public static ModernTestEvent parse(String messageString) {
    ModernTestEvent testEvent = null;
    String expectedToken = isTestEvent(messageString);
    if (expectedToken != null) {
      testEvent = parse(expectedToken, messageString);
    }
    return testEvent;
  }

  private static ModernTestEvent parse(String expectedToken, String messageString) {
    ModernTestEvent testEvent = null;
    if (messageString.startsWith(expectedToken)) {
      String params = messageString.substring(expectedToken.length());
      {
        Pattern _pattern_0 = REGEXP_m4mvdg_a0a0b0b0c;
        Matcher _matcher_0 = _pattern_0.matcher(params);
        if (_matcher_0.matches()) {
          testEvent = new ModernTestEvent(expectedToken, _matcher_0.group(1), _matcher_0.group(2), Long.parseLong(_matcher_0.group(3)), Long.parseLong(_matcher_0.group(4)));
        }
      }
    }
    return testEvent;
  }

  static {
    ModernTestEvent.ALL_TOKENS = ListSequence.fromListAndArray(new ArrayList<String>(), ModernTestEvent.START_TEST_PREFIX, ModernTestEvent.END_TEST_PREFIX, ModernTestEvent.ERROR_TEST_PREFIX, ModernTestEvent.ERROR_TEST_SUFFIX, ModernTestEvent.FAILURE_TEST_PREFIX, ModernTestEvent.FAILURE_TEST_SUFFIX);
  }
}
