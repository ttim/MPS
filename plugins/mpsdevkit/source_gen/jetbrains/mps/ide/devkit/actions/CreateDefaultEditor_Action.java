package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import java.util.List;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import jetbrains.mps.nodeEditor.EditorContext;

public class CreateDefaultEditor_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(CreateDefaultEditor_Action.class);

  public CreateDefaultEditor_Action() {
    super("Generate Default Editor (Expression-like)", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    SNode conceptDeclaration = SNodeOperations.as(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.lang.structure.structure.ConceptDeclaration");
    if (conceptDeclaration == null || SConceptPropertyOperations.getBoolean(conceptDeclaration, "abstract") || SPropertyOperations.getString(conceptDeclaration, "name") == null) {
      return false;
    }

    Queue<SNode> toCheck = QueueSequence.fromQueue(new LinkedList<SNode>());
    QueueSequence.fromQueue(toCheck).addLastElement(conceptDeclaration);
    while (QueueSequence.fromQueue(toCheck).isNotEmpty()) {
      SNode acd = QueueSequence.fromQueue(toCheck).removeFirstElement();
      List<SNode> aspects = ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, acd, "call_findConceptAspectCollection_1567570417158062208", new Class[]{SNode.class, LanguageAspect.class}, LanguageAspect.EDITOR));
      if (!(SConceptOperations.isExactly(acd, "jetbrains.mps.lang.core.structure.BaseConcept")) && ListSequence.fromList(aspects).any(new IWhereFilter<SNode>() {
        public boolean accept(SNode a) {
          return SNodeOperations.isInstanceOf(a, "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration");
        }
      })) {
        return false;
      }
      QueueSequence.fromQueue(toCheck).addSequence(ListSequence.fromList(((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, acd, "virtual_getImmediateSuperconcepts_1222430305282", new Class[]{SNode.class}))));
    }
    return true;
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "CreateDefaultEditor", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      SNode node = event.getData(MPSCommonDataKeys.NODE);
      if (node != null) {
      }
      MapSequence.fromMap(_params).put("selectedNode", node);
    }
    if (MapSequence.fromMap(_params).get("selectedNode") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("editorContext", event.getData(MPSEditorDataKeys.EDITOR_CONTEXT));
    if (MapSequence.fromMap(_params).get("editorContext") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("operationContext", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("operationContext") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      SNode conceptDeclaration = SNodeOperations.as(((SNode) MapSequence.fromMap(_params).get("selectedNode")), "jetbrains.mps.lang.structure.structure.ConceptDeclaration");
      SNode editorDeclaration = SNodeOperations.cast(ConceptEditorHelper.createNewConceptAspectInstance(LanguageAspect.EDITOR, conceptDeclaration, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration")), "jetbrains.mps.lang.editor.structure.ConceptEditorDeclaration");
      if (SPropertyOperations.getString(conceptDeclaration, "virtualPackage") != null) {
        SPropertyOperations.set(editorDeclaration, "virtualPackage", SPropertyOperations.getString(conceptDeclaration, "virtualPackage"));
      }
      BehaviorManager.getInstance().invoke(Object.class, editorDeclaration, "call_createDefaultEditor_2970389781192937380", new Class[]{SNode.class, Boolean.TYPE}, false);
      ((EditorContext) MapSequence.fromMap(_params).get("editorContext")).getNodeEditorComponent().update();
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "CreateDefaultEditor", t);
      }
    }
  }
}
