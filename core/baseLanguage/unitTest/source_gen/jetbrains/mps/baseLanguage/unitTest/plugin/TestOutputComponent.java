package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import javax.swing.JComponent;
import com.intellij.execution.impl.ConsoleViewImpl;
import java.util.List;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.openapi.util.Key;
import com.intellij.execution.process.ProcessOutputTypes;
import javax.swing.SwingUtilities;
import org.apache.commons.lang.ObjectUtils;
import jetbrains.mps.debug.api.info.StacktraceUtil;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.util.Disposer;

public class TestOutputComponent implements TestView {
  private JComponent component;
  private ConsoleViewImpl consoleView;
  private List<TestOutputComponent.Message> messages;
  private String filterClass;
  private String filterMethod;
  private TestRunState state;

  public TestOutputComponent(Project project, JComponent parentComponent, ConsoleViewImpl console, TestRunState state) {
    this.messages = ListSequence.fromList(new ArrayList<TestOutputComponent.Message>());
    this.consoleView = console;
    this.component = this.consoleView.getComponent();
    this.state = state;
  }

  public void update() {
    final Wrappers._T<String> text = new Wrappers._T<String>(null);
    final Wrappers._T<Key> key = new Wrappers._T<Key>(null);
    final Wrappers._T<String> test = new Wrappers._T<String>(this.state.getLoseClass());
    final Wrappers._T<String> method = new Wrappers._T<String>(this.state.getLoseMethod());
    if (test.value != null && method.value != null) {
      text.value = "\nError: couldn't find method '" + method.value + "' in '" + test.value + "'\n\n";
      key.value = ProcessOutputTypes.STDERR;
    } else if (this.state.getAvailableText() != null) {
      text.value = this.state.getAvailableText();
      key.value = this.state.getKey();
      test.value = this.state.getCurrentClass();
      method.value = this.state.getCurrentMethod();
    }
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        TestOutputComponent.this.appendWithParameters(test.value, method.value, text.value, key.value);
      }
    });
  }

  public void init() {
    this.clear();
  }

  public JComponent getComponent() {
    return this.component;
  }

  public String getCurrentClassName() {
    return this.state.getCurrentClass();
  }

  public String getCurrentMethodName() {
    return this.state.getCurrentMethod();
  }

  public void filter(String filterClass, String filterMethod) {
    if (!(ObjectUtils.equals(filterClass, this.filterClass)) || !(ObjectUtils.equals(filterMethod, this.filterMethod))) {
      this.filterClass = filterClass;
      this.filterMethod = filterMethod;
      this.consoleView.clear();
      for (TestOutputComponent.Message message : ListSequence.fromList(this.messages)) {
        this.append(message);
      }
    }
  }

  public void appendWithParameters(String testClass, String testMethod, String text, Key type) {
    TestOutputComponent.Message newMessage = new TestOutputComponent.Message(testClass, testMethod, text, type);
    ListSequence.fromList(this.messages).addElement(newMessage);
    this.append(newMessage);
  }

  public void append(String message, Key type) {
    TestOutputComponent.Message newMessage = new TestOutputComponent.Message(this.getCurrentClassName(), this.getCurrentMethodName(), message, type);
    ListSequence.fromList(this.messages).addElement(newMessage);
    this.append(newMessage);
  }

  public void clear() {
    this.messages = ListSequence.fromList(new ArrayList<TestOutputComponent.Message>());
    this.consoleView.clear();
  }

  private void append(TestOutputComponent.Message message) {
    if (message.matches(this.filterClass, this.filterMethod)) {
      if (ProcessOutputTypes.STDERR.equals(message.getType())) {
        StacktraceUtil.appendStacktraceToConsole(this.consoleView, message.getMessage(), ConsoleViewContentType.ERROR_OUTPUT);
      } else if (ProcessOutputTypes.SYSTEM.equals(message.getType())) {
        this.consoleView.print(message.getMessage(), ConsoleViewContentType.SYSTEM_OUTPUT);
      } else if (ProcessOutputTypes.STDOUT.equals(message.getType())) {
        this.consoleView.print(message.getMessage(), ConsoleViewContentType.NORMAL_OUTPUT);
      }
    }
  }

  public void dispose() {
    Disposer.dispose(this.consoleView);
  }

  public ConsoleViewImpl getConsole() {
    return this.consoleView;
  }

  private static class Message {
    private String testClass;
    private String testMethod;
    private String message;
    private Key type;

    public Message(String testClass, String testMethod, String message, Key types) {
      this.testClass = testClass;
      this.testMethod = testMethod;
      this.message = message;
      this.type = types;
    }

    public boolean matches(String testClass, String testMethod) {
      return testClass == null || (testClass.equals(this.testClass) && (testMethod == null || testMethod.equals(this.testMethod)));
    }

    public String getMessage() {
      return this.message;
    }

    private Key getType() {
      return this.type;
    }
  }
}
