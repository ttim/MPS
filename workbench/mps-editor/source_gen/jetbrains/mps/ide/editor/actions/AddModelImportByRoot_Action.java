package jetbrains.mps.ide.editor.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.nodeEditor.cells.EditorCell_Label;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import com.intellij.openapi.project.Project;
import jetbrains.mps.project.IModule;
import jetbrains.mps.nodeEditor.cellMenu.NodeSubstituteInfo;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cellMenu.DefaultChildSubstituteInfo;
import java.util.List;
import jetbrains.mps.smodel.action.INodeSubstituteAction;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.nodeEditor.cells.EditorCell;

public class AddModelImportByRoot_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(AddModelImportByRoot_Action.class);

  public AddModelImportByRoot_Action() {
    super("Add Model Import by Root", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  @Override
  public boolean isDumbAware() {
    return false;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ((SModelDescriptor) MapSequence.fromMap(_params).get("model")) instanceof EditableSModelDescriptor;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "AddModelImportByRoot", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("module", event.getData(MPSCommonDataKeys.MODULE));
    if (MapSequence.fromMap(_params).get("module") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("model", event.getData(MPSCommonDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("model") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    MapSequence.fromMap(_params).put("editorComponent", event.getData(MPSEditorDataKeys.EDITOR_COMPONENT));
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<String> initialText = new Wrappers._T<String>("");

      final EditorCell_Label errorLabel = AddModelImportByRoot_Action.this.getErrorCell(_params);
      final SNode unresolvedReference = SNodeOperations.as(((SNode) MapSequence.fromMap(_params).get("node")), "jetbrains.mps.baseLanguage.structure.UnresolvedNameReference");

      if (errorLabel != null) {
        initialText.value = errorLabel.getRenderedText();
      } else if (unresolvedReference != null) {
        initialText.value = SPropertyOperations.getString(unresolvedReference, "resolveName");
      }

      ImportHelper.addModelImportByRoot(((Project) MapSequence.fromMap(_params).get("project")), ((IModule) MapSequence.fromMap(_params).get("module")), ((SModelDescriptor) MapSequence.fromMap(_params).get("model")), initialText.value, AddModelImportByRoot_Action.this, new ImportHelper.ModelImportByRootCallback() {
        public void importForRootAdded(String rootName) {
          String textToMatch = (rootName != null ?
            rootName :
            initialText.value
          );
          if (textToMatch.length() == 0) {
            return;
          }
          NodeSubstituteInfo substituteInfo = null;
          if (errorLabel != null) {
            substituteInfo = errorLabel.getSubstituteInfo();
          } else if (unresolvedReference != null && ((EditorContext) MapSequence.fromMap(_params).get("editorContext")) != null) {
            substituteInfo = new DefaultChildSubstituteInfo(SNodeOperations.getParent(unresolvedReference), unresolvedReference, SNodeOperations.getContainingLinkDeclaration(unresolvedReference), ((EditorContext) MapSequence.fromMap(_params).get("editorContext")));
            substituteInfo.setOriginalText(initialText.value);
          }
          if (substituteInfo == null) {
            return;
          }
          substituteInfo.invalidateActions();
          List<INodeSubstituteAction> matchingActions = substituteInfo.getMatchingActions(textToMatch, true);
          if ((int) ListSequence.fromList(matchingActions).count() == 1) {
            ListSequence.fromList(matchingActions).first().substitute(((EditorContext) MapSequence.fromMap(_params).get("editorContext")), initialText.value);
          }
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "AddModelImportByRoot", t);
      }
    }
  }

  private EditorCell_Label getErrorCell(final Map<String, Object> _params) {
    if (((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")) == null) {
      return null;
    }
    EditorCell selectedCell = ((EditorComponent) MapSequence.fromMap(_params).get("editorComponent")).getSelectedCell();
    if (selectedCell instanceof EditorCell_Label) {
      EditorCell_Label editorCellLabel = (EditorCell_Label) selectedCell;
      if (editorCellLabel.isErrorState() && !(isEmpty_3mx29z_a0a0b0c0f(editorCellLabel.getText()))) {
        return editorCellLabel;
      }
    }
    return null;
  }

  public static boolean isEmpty_3mx29z_a0a0b0c0f(String str) {
    return str == null || str.length() == 0;
  }
}
