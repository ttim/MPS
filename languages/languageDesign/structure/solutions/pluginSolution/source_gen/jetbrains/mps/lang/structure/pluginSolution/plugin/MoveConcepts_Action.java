package jetbrains.mps.lang.structure.pluginSolution.plugin;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.refactoring.framework.RefactoringUtil;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.actions.MPSCommonDataKeys;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.ide.refactoring.SModelReferenceDialog;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.refactoring.framework.RefactoringContext;
import java.util.Arrays;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import com.intellij.openapi.ui.Messages;

public class MoveConcepts_Action extends BaseAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(MoveConcepts_Action.class);

  public MoveConcepts_Action() {
    super("Move Concepts", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  @Override
  public boolean isDumbAware() {
    return true;
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return RefactoringUtil.isApplicable(RefactoringUtil.getRefactoringByClassName("jetbrains.mps.lang.structure.refactorings" + "." + "MoveConcepts"), ((List<SNode>) MapSequence.fromMap(_params).get("target")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "MoveConcepts", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSCommonDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
        for (SNode node : ListSequence.fromList(nodes)) {
          if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"))) {
            error = true;
            break;
          }
        }
      }
      if (error || nodes == null) {
        MapSequence.fromMap(_params).put("target", null);
      } else {
        MapSequence.fromMap(_params).put("target", ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes));
      }
    }
    if (MapSequence.fromMap(_params).get("target") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
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
      if (!(MoveConcepts_Action.this.init(_params))) {
        return;
      }
      final SModelReference targetModel;
      List<SModelReference> myModels;
      myModels = ListSequence.fromList(((List<SModelDescriptor>) (SModelRepository.getInstance().getModelDescriptors()))).select(new ISelector<SModelDescriptor, SModelReference>() {
        public SModelReference select(SModelDescriptor it) {
          return it.getSModelReference();
        }
      }).where(new IWhereFilter<SModelReference>() {
        public boolean accept(SModelReference it) {
          return Language.getModelAspect(SModelRepository.getInstance().getModelDescriptor(it)) == LanguageAspect.STRUCTURE;
        }
      }).toListSequence();
      targetModel = SModelReferenceDialog.getSelectedModel(((MPSProject) MapSequence.fromMap(_params).get("project")).getProject(), myModels);
      if (targetModel == null) {
        return;
      }
      ModelAccess.instance().runReadInEDT(new Runnable() {
        public void run() {
          for (SNode node : ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("target")))) {
            if (!(((SNode) node).isRegistered()) || ((SNode) node).isDisposed()) {
              return;
            }
          }
          if (!(SModelRepository.getInstance().getModelDescriptor(targetModel).isRegistered())) {
            return;
          }
          RefactoringAccess.getInstance().getRefactoringFacade().execute(RefactoringContext.createRefactoringContextByName("jetbrains.mps.lang.structure.refactorings.MoveConcepts", Arrays.asList("targetModel"), Arrays.asList(targetModel), ((List<SNode>) MapSequence.fromMap(_params).get("target")), ((MPSProject) MapSequence.fromMap(_params).get("project"))));
        }
      });


    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "MoveConcepts", t);
      }
    }
  }

  private boolean init(final Map<String, Object> _params) {
    final Wrappers._boolean canRefactor = new Wrappers._boolean(false);
    final Wrappers._boolean hasGenerator = new Wrappers._boolean(false);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        final SModel model = SNodeOperations.getModel(ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("target"))).first());
        canRefactor.value = ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("target"))).all(new IWhereFilter<SNode>() {
          public boolean accept(SNode node) {
            return SNodeOperations.getModel(node) == model;
          }
        });
        hasGenerator.value = ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("target"))).any(new IWhereFilter<SNode>() {
          public boolean accept(SNode node) {
            return ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_findGeneratorFragments_6409339300305625383(node)).isNotEmpty();
          }
        });
      }
    });
    if (!(canRefactor.value)) {
      Messages.showErrorDialog("All concept should be from the same language.", "Move concepts");
      return false;
    }
    if (hasGenerator.value) {
      Messages.showWarningDialog("Generator fragments will not be moved.", "Move concepts");
    }
    return true;
  }
}
