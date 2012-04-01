package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.awt.Frame;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Set;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import java.util.Collections;

public class SetNodePackage_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(SetNodePackage_Action.class);

  public SetNodePackage_Action() {
    super("Set Virtual Package...", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes"))).all(new IWhereFilter<SNode>() {
      public boolean accept(SNode n) {
        return SNodeOperations.getParent(n) == null && !(SNodeOperations.getModel(n).isNotEditable());
      }
    });
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "SetNodePackage", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("frame", event.getData(MPSCommonDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("scope", event.getData(MPSCommonDataKeys.SCOPE));
    if (MapSequence.fromMap(_params).get("scope") == null) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSCommonDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
        for (SNode node : ListSequence.fromList(nodes)) {
          if (!(SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.core.structure.BaseConcept"))) {
            error = true;
            break;
          }
        }
      }
      if (error || nodes == null) {
        MapSequence.fromMap(_params).put("nodes", null);
      } else {
        MapSequence.fromMap(_params).put("nodes", ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes));
      }
    }
    if (MapSequence.fromMap(_params).get("nodes") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      final Wrappers._T<List<String>> packages = new Wrappers._T<List<String>>();
      final Wrappers._T<String> oldPackage = new Wrappers._T<String>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          packages.value = SetNodePackage_Action.this.fetchExistingPackages(((List<SNode>) MapSequence.fromMap(_params).get("nodes")), _params);
          oldPackage.value = SPropertyOperations.getString(ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes"))).first(), "virtualPackage");
        }
      });
      final SetNodePackageDialog dialog = new SetNodePackageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Set Virtual Package", packages.value);
      dialog.setPackage(oldPackage.value);
      dialog.showDialog();
      if (dialog.isCancelled()) {
        return;
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          for (SNode node : ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes")))) {
            SPropertyOperations.set(node, "virtualPackage", dialog.getPackage());
            if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration")) {
              for (SNode aspect : ListSequence.fromList(((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), "call_findAllAspects_7754459869734028917", new Class[]{SNode.class})))) {
                SPropertyOperations.set(((SNode) aspect), "virtualPackage", dialog.getPackage());
              }
            }
          }
        }
      });
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "SetNodePackage", t);
      }
    }
  }

  /*package*/ List<String> fetchExistingPackages(List<SNode> nlist, final Map<String, Object> _params) {
    Set<SModel> models = SetSequence.fromSetWithValues(new HashSet<SModel>(), ListSequence.fromList(nlist).select(new ISelector<SNode, SModel>() {
      public SModel select(SNode n) {
        return SNodeOperations.getModel(n);
      }
    }));
    Set<String> packages = SetSequence.fromSetWithValues(new HashSet<String>(), SetSequence.fromSet(models).translate(new ITranslator2<SModel, SNode>() {
      public Iterable<SNode> translate(SModel m) {
        return SModelOperations.getRoots(m, "jetbrains.mps.lang.core.structure.BaseConcept");
      }
    }).select(new ISelector<SNode, String>() {
      public String select(SNode r) {
        return SPropertyOperations.getString(r, "virtualPackage");
      }
    }).where(new IWhereFilter<String>() {
      public boolean accept(String p) {
        return p != null;
      }
    }));
    List<String> result = ListSequence.fromListWithValues(new ArrayList<String>(), packages);
    Collections.sort(result);
    return result;
  }
}
