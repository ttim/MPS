package jetbrains.mps.ide.properties;

/*Generated by MPS */

import jetbrains.mps.workbench.dialogs.project.BasePropertiesDialog;
import jetbrains.mps.smodel.Language;
import com.intellij.openapi.Disposable;
import jetbrains.mps.smodel.IOperationContext;
import javax.swing.JPanel;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.InternalFlag;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.ThreadUtils;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.projectPane.ProjectPane;
import com.intellij.openapi.util.Disposer;

public class LanguagePropertiesDialog extends BasePropertiesDialog {
  public Language myLanguage;
  public LanguageProperties myProperties;
  public Disposable myDisposable = new Disposable() {
    public void dispose() {
    }
  };

  /*package*/ LanguagePropertiesDialog(final Language language, IOperationContext operationContext) {
    super(language.getModuleFqName() + " Properties", operationContext);
    myLanguage = language;
    collectLanguageProperties();
  }

  public JPanel createCheckboxPanel() {
    List<StandardComponents.CheckboxDescriptor> list = new ArrayList<StandardComponents.CheckboxDescriptor>();
    if (InternalFlag.isInternalMode()) {
      list.add(new StandardComponents.CheckboxDescriptor(myProperties, ModuleProperties.ENABLE_JAVA_STUBS, "Stubs For Generated Code"));
    }
    list.add(new StandardComponents.CheckboxDescriptor(myProperties, ModuleProperties.COMPILE_IN_MPS, "Compile in MPS"));
    if (InternalFlag.isInternalMode()) {
      list.add(new StandardComponents.CheckboxDescriptor(myProperties, LanguageProperties.DO_NOT_GENERATE_ADAPTERS, "Do Not Generate Adapters"));
    }
    return StandardComponents.createCheckboxPanel(this, list);
  }

  private void collectLanguageProperties() {
    myProperties = new LanguageProperties();
    myProperties.loadFrom(myLanguage.getModuleDescriptor());
  }

  protected boolean doSaveChanges() {
    if (!(checkValidity())) {
      return false;
    }
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        myProperties.saveTo(myLanguage.getModuleDescriptor());
        myLanguage.setLanguageDescriptor(myLanguage.getModuleDescriptor(), true);
        myLanguage.validateExtends();
        myLanguage.save();
      }
    }, getOperationContext().getProject());
    ThreadUtils.runInUIThreadNoWait(new Runnable() {
      public void run() {
        Project project = LanguagePropertiesDialog.this.getOperationContext().getProject();
        ProjectPane.getInstance(project).selectModule(myLanguage, false);
      }
    });
    return true;
  }

  protected String getErrorString() {
    String errors;
    errors = checkStubModels(myProperties.getStubModels());
    if (errors != null) {
      return errors;
    }
    errors = checkStubModels(myProperties.getRuntimeStubModels());
    if (errors != null) {
      return errors;
    }
    return null;
  }

  public void dispose() {
    super.dispose();
    Disposer.dispose(myDisposable);
  }
}
