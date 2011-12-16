package jetbrains.mps.baseLanguage.unitTest.execution.settings;

/*Generated by MPS */

import jetbrains.mps.execution.api.settings.IPersistentConfiguration;
import jetbrains.mps.execution.api.settings.ITemplatePersistentConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.execution.api.settings.SettingsEditorEx;
import com.intellij.execution.configurations.RuntimeConfigurationException;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import org.jdom.Element;
import com.intellij.openapi.util.WriteExternalException;
import com.intellij.util.xmlb.XmlSerializer;
import com.intellij.openapi.util.InvalidDataException;
import java.util.List;
import jetbrains.mps.baseLanguage.unitTest.execution.client.ITestNodeWrapper;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.ArrayList;
import com.intellij.openapi.progress.ProgressManager;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class JUnitSettings_Configuration implements IPersistentConfiguration, ITemplatePersistentConfiguration {
  protected static Log log = LogFactory.getLog(JUnitSettings_Configuration.class);

  @NotNull
  private JUnitSettings_Configuration.MyState myState = new JUnitSettings_Configuration.MyState();
  private SettingsEditorEx<JUnitSettings_Configuration> myEditorEx;

  public JUnitSettings_Configuration() {
  }

  public void checkConfiguration() throws RuntimeConfigurationException {
    if (this.getRunType() == null) {
      throw new RuntimeConfigurationException("Type of test not selected.");
    }
    if (this.getRunType() != null) {
      // We do not validate, only check if there is something to test, since validating everything be very slow 
      // see MPS-8781 JUnit run configuration check method performance. 
      if (neq_jtq3ac_a0a2a1a0a0(this.getRunType(), JUnitRunTypes2.PROJECT) && ListSequence.fromList(getTests(null)).isEmpty()) {
        throw new RuntimeConfigurationException("Could not find tests to run.");
      }
    }
  }

  @Override
  public void writeExternal(Element element) throws WriteExternalException {
    element.addContent(XmlSerializer.serialize(myState));
  }

  @Override
  public void readExternal(Element element) throws InvalidDataException {
    if (element == null) {
      throw new InvalidDataException("Cant read " + this + ": element is null.");
    }
    XmlSerializer.deserializeInto(myState, (Element) element.getChildren().get(0));
  }

  public String getModel() {
    return myState.myModel;
  }

  public String getModule() {
    return myState.myModule;
  }

  public ClonableList<String> getTestCases() {
    return myState.myTestCases;
  }

  public ClonableList<String> getTestMethods() {
    return myState.myTestMethods;
  }

  public JUnitRunTypes2 getRunType() {
    return myState.myRunType;
  }

  public void setModel(String value) {
    myState.myModel = value;
  }

  public void setModule(String value) {
    myState.myModule = value;
  }

  public void setTestCases(ClonableList<String> value) {
    myState.myTestCases = value;
  }

  public void setTestMethods(ClonableList<String> value) {
    myState.myTestMethods = value;
  }

  public void setRunType(JUnitRunTypes2 value) {
    myState.myRunType = value;
  }

  public List<ITestNodeWrapper> getTests(final Project project) {
    final List<ITestNodeWrapper>[] all = (List<ITestNodeWrapper>[]) new List[1];
    final JUnitSettings_Configuration settings = this;
    if (this.getRunType() != null) {
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          all[0] = Sequence.fromIterable(JUnitSettings_Configuration.this.getRunType().collect(settings, project)).toListSequence();
        }
      });
    }
    return all[0];
  }

  public List<ITestNodeWrapper> getTestsUnderProgress(final Project project) {
    final List<ITestNodeWrapper> stuffToTest = ListSequence.fromList(new ArrayList<ITestNodeWrapper>());
    final JUnitRunTypes2 runTypes2 = this.getRunType();
    final JUnitSettings_Configuration settings = this;
    Runnable collect = new Runnable() {
      public void run() {
        if (runTypes2 != null) {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              ListSequence.fromList(stuffToTest).addSequence(Sequence.fromIterable(runTypes2.collect(settings, project)));
            }
          });
        }
      }
    };
    if (eq_jtq3ac_a0a4a41_0(this.getRunType(), JUnitRunTypes2.PROJECT) || eq_jtq3ac_a0a4a41(this.getRunType(), JUnitRunTypes2.MODULE)) {
      // collecting for module/project is slow, so execute under progress 
      // todo: get rid of casts to MPSProject 
      ProgressManager.getInstance().runProcessWithProgressSynchronously(collect, "Collecting Tests To Run", false, ProjectHelper.toIdeaProject(project));
    } else {
      collect.run();
    }
    return stuffToTest;
  }

  public List<SNodePointer> getTestsToMake(final Project project) {
    final List<ITestNodeWrapper>[] stuffToTest = (List<ITestNodeWrapper>[]) new List[1];
    ApplicationManager.getApplication().invokeAndWait(new Runnable() {
      public void run() {
        stuffToTest[0] = getTestsUnderProgress(project);
      }
    }, ModalityState.NON_MODAL);
    return ListSequence.fromList(stuffToTest[0]).select(new ISelector<ITestNodeWrapper, SNodePointer>() {
      public SNodePointer select(ITestNodeWrapper it) {
        return it.getNodePointer();
      }
    }).toListSequence();
  }

  @Override
  public JUnitSettings_Configuration clone() {
    JUnitSettings_Configuration clone = null;
    try {
      clone = createCloneTemplate();
      clone.myState = (JUnitSettings_Configuration.MyState) myState.clone();
      return clone;
    } catch (CloneNotSupportedException ex) {
      if (log.isErrorEnabled()) {
        log.error("", ex);
      }
    }
    return clone;
  }

  public JUnitSettings_Configuration createCloneTemplate() {
    return new JUnitSettings_Configuration();
  }

  public JUnitSettings_Configuration_Editor getEditor() {
    return new JUnitSettings_Configuration_Editor();
  }

  public SettingsEditorEx<JUnitSettings_Configuration> getEditorEx() {
    if (myEditorEx == null) {
      myEditorEx = getEditor();
    }
    return myEditorEx;
  }

  private static boolean neq_jtq3ac_a0a2a1a0a0(Object a, Object b) {
    return !((a != null ?
      a.equals(b) :
      a == b
    ));
  }

  private static boolean eq_jtq3ac_a0a4a41(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  private static boolean eq_jtq3ac_a0a4a41_0(Object a, Object b) {
    return (a != null ?
      a.equals(b) :
      a == b
    );
  }

  public class MyState {
    public String myModel;
    public String myModule;
    public ClonableList<String> myTestCases = new ClonableList<String>();
    public ClonableList<String> myTestMethods = new ClonableList<String>();
    public JUnitRunTypes2 myRunType;

    public MyState() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
      JUnitSettings_Configuration.MyState state = new JUnitSettings_Configuration.MyState();
      state.myModel = myModel;
      state.myModule = myModule;
      if (myTestCases != null) {
        state.myTestCases = myTestCases.clone();
      }
      if (myTestMethods != null) {
        state.myTestMethods = myTestMethods.clone();
      }
      state.myRunType = myRunType;
      return state;
    }
  }
}
