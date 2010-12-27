package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.MPSDataKeys;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.ui.smodel.SModelTreeNode;
import java.awt.Frame;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.smodel.IScope;
import java.util.Set;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import java.util.Collections;

public class SetNodePackage_Action extends GeneratedAction {
  private static final Icon ICON = null;
  protected static Log log = LogFactory.getLog(SetNodePackage_Action.class);

  public SetNodePackage_Action() {
    super("Set Virtual Folder", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(true);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    for (SNode node : ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes")))) {
      if (!(node.isRoot())) {
        return false;
      }
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
        log.error("User's action doUpdate method failed. Action:" + "SetNodePackage", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    {
      List<SNode> nodes = event.getData(MPSDataKeys.NODES);
      boolean error = false;
      if (nodes != null) {
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
    MapSequence.fromMap(_params).put("frame", event.getData(MPSDataKeys.FRAME));
    if (MapSequence.fromMap(_params).get("frame") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("scope", event.getData(MPSDataKeys.SCOPE));
    if (MapSequence.fromMap(_params).get("scope") == null) {
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
          oldPackage.value = ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes"))).first().getProperty(SModelTreeNode.PACK);
        }
      });
      final SetNodePackageDialog dialog = new SetNodePackageDialog(((Frame) MapSequence.fromMap(_params).get("frame")), "Set Virtual Package...", packages.value);
      dialog.setPackage(oldPackage.value);
      dialog.showDialog();
      if (dialog.isCancelled()) {
        return;
      }
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          for (SNode node : ListSequence.fromList(((List<SNode>) MapSequence.fromMap(_params).get("nodes")))) {
            node.setProperty(SModelTreeNode.PACK, dialog.getPackage());
            if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration")) {
              for (SNode aspect : ListSequence.fromList(AbstractConceptDeclaration_Behavior.call_findAllAspects_7754459869734028917(SNodeOperations.cast(node, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), ((IScope) MapSequence.fromMap(_params).get("scope"))))) {
                aspect.setProperty(SModelTreeNode.PACK, dialog.getPackage());
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
    Set<SModel> models = SetSequence.fromSet(new HashSet<SModel>());
    for (SNode node : ListSequence.fromList(nlist)) {
      SetSequence.fromSet(models).addElement(SNodeOperations.getModel(node));
    }
    Set<String> packages = SetSequence.fromSet(new HashSet<String>());
    for (SModel model : SetSequence.fromSet(models)) {
      for (SNode root : ListSequence.fromList(SModelOperations.getRoots(model, null))) {
        String p = root.getProperty(SModelTreeNode.PACK);
        if (p != null) {
          SetSequence.fromSet(packages).addElement(p);
        }
      }
    }
    List<String> result = ListSequence.fromListWithValues(new ArrayList<String>(), packages);
    Collections.sort(result);
    return result;
  }
}
