package jetbrains.mps.lang.smodel.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.Language;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelOperations;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import javax.swing.JOptionPane;
import java.awt.Frame;

public class CheckLangForJavaStubModels_Action extends BaseAction {
  private static final Icon ICON = null;
  private static Logger LOG = Logger.getLogger(CheckLangForJavaStubModels_Action.class);

  public CheckLangForJavaStubModels_Action() {
    super("Check for java_stubs Usages", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((IModule) MapSequence.fromMap(_params).get("module")) instanceof Language;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      LOG.error("User's action doUpdate method failed. Action:" + "CheckLangForJavaStubModels", t);
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      Language language = ((Language) ((IModule) MapSequence.fromMap(_params).get("module")));
      Set<String> langStubModels = SetSequence.fromSet(new HashSet<String>());
      Set<String> otherStubModels = SetSequence.fromSet(new HashSet<String>());
      for (EditableSModelDescriptor md : SetSequence.fromSet(language.getAspectModelDescriptors())) {
        for (SModelReference model : ListSequence.fromList(SModelOperations.getImportedModelUIDs(md.getSModel()))) {
          if (model.getStereotype().equals(SModelStereotype.getStubStereotypeForId(LanguageID.JAVA))) {
            SModelDescriptor langModelForStub = SModelRepository.getInstance().getModelDescriptor(SModelReference.fromString(model.getLongName()));
            String modelName = model.getSModelFqName().toString();
            if (langModelForStub != null && language.getAspectForModel(langModelForStub) != null) {
              SetSequence.fromSet(langStubModels).addElement(modelName);
            } else {
              SetSequence.fromSet(otherStubModels).addElement(modelName);
            }
          }
        }
      }
      String langStubsMsg = "";
      for (String modelName : SetSequence.fromSet(langStubModels)) {
        langStubsMsg += "  " + modelName + "\n";
      }
      String otherStubsMsg = "";
      for (String modelName : SetSequence.fromSet(otherStubModels)) {
        otherStubsMsg += "  " + modelName + "\n";
      }
      String message = ((SetSequence.fromSet(langStubModels).isEmpty() ?
        "No language stub models" :
        "Language stub models: \n" + langStubsMsg
      )) + "\n" + ((SetSequence.fromSet(otherStubModels).isEmpty() ?
        "No other stub models" :
        "Other stub models: \n" + otherStubsMsg
      ));
      JOptionPane.showMessageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), message);
    } catch (Throwable t) {
      LOG.error("User's action execute method failed. Action:" + "CheckLangForJavaStubModels", t);
    }
  }
}
