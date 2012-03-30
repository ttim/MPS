package jetbrains.mps.lang.typesystem.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import java.util.Set;
import com.intellij.openapi.util.Pair;
import jetbrains.mps.workbench.ActionPlace;
import jetbrains.mps.util.Condition;
import jetbrains.mps.workbench.action.BaseAction;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.errors.IErrorReporter;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.Nullable;

public class GoToTypeErrorGroup_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(GoToTypeErrorGroup_ActionGroup.class);
  public static final String ID = "jetbrains.mps.lang.typesystem.pluginSolution.plugin.GoToTypeErrorGroup_ActionGroup";

  private Set<Pair<ActionPlace, Condition<BaseAction>>> myPlaces = SetSequence.fromSet(new HashSet<Pair<ActionPlace, Condition<BaseAction>>>());

  public GoToTypeErrorGroup_ActionGroup() {
    super("Go to Rule Which Caused Error", ID);
    this.setIsAlwaysVisible(false);
    this.setIsInternal(false);
    this.setPopup(true);
    try {
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void doUpdate(AnActionEvent event) {
    try {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node == null) {
        GoToTypeErrorGroup_ActionGroup.this.disable(event.getPresentation());
        return;
      }
      EditorComponent editorComponent = event.getData(MPSEditorDataKeys.EDITOR_COMPONENT);
      if (editorComponent == null) {
        GoToTypeErrorGroup_ActionGroup.this.disable(event.getPresentation());
        return;
      }
      IErrorReporter error = editorComponent.getErrorReporterFor(editorComponent.getSelectedCell());
      if (error == null || error.getRuleId() == null || error.getRuleModel() == null || error.getAdditionalRulesIds().isEmpty()) {
        GoToTypeErrorGroup_ActionGroup.this.disable(event.getPresentation());
        return;
      }
      GoToTypeErrorGroup_ActionGroup.this.enable(event.getPresentation());
      GoToTypeErrorGroup_ActionGroup.this.removeAll();
      jetbrains.mps.util.Pair<String, String> firstId = new jetbrains.mps.util.Pair<String, String>(error.getRuleModel(), error.getRuleId());
      for (jetbrains.mps.util.Pair<String, String> id : error.getAdditionalRulesIds()) {
        GoToTypeErrorGroup_ActionGroup.this.addParameterizedAction(new GoToTypeErrorRule_InGroup_Action(id, false), PluginId.getId("jetbrains.mps.lang.typesystem.pluginSolution"), id, false);
      }
      GoToTypeErrorGroup_ActionGroup.this.addParameterizedAction(new GoToTypeErrorRule_InGroup_Action(firstId, true), PluginId.getId("jetbrains.mps.lang.typesystem.pluginSolution"), firstId, true);
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
    for (Pair<ActionPlace, Condition<BaseAction>> p : this.myPlaces) {
      this.addPlace(p.first, p.second);
    }
  }

  public void addPlace(ActionPlace place, @Nullable Condition<BaseAction> cond) {
    SetSequence.fromSet(this.myPlaces).addElement(new Pair<ActionPlace, Condition<BaseAction>>(place, cond));
  }

  public boolean isStrict() {
    return false;
  }
}
