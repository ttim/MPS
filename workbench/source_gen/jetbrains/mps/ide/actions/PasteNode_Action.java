package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.openapi.editor.Editor;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.editor.MPSEditorDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.datatransfer.PasteNodeData;
import jetbrains.mps.ide.datatransfer.CopyPasteUtil;
import jetbrains.mps.smodel.IOperationContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.nodeEditor.datatransfer.NodePaster;
import jetbrains.mps.datatransfer.PasteEnv;
import jetbrains.mps.resolve.Resolver;
import jetbrains.mps.ide.navigation.NavigationSupport;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import java.io.IOException;

public class PasteNode_Action extends BaseAction {
  private static final Icon ICON = getIcon();
  protected static Log log = LogFactory.getLog(PasteNode_Action.class);

  public PasteNode_Action() {
    super("Paste", "", ICON);
    this.setIsAlwaysVisible(true);
    this.setExecuteOutsideCommand(true);
    this.addPlace(null);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    boolean searchPanelInactive = ((Editor) MapSequence.fromMap(_params).get("editor")) == null || !(((EditorComponent) ((Editor) MapSequence.fromMap(_params).get("editor")).getCurrentEditorComponent().getEditorComponent()).isSearchPanelVisible());
    return searchPanelInactive && ((SModelDescriptor) MapSequence.fromMap(_params).get("contextModel")) instanceof EditableSModelDescriptor && PasteNode_Action.this.canPasteNodes(_params);
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "PasteNode", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(MPSCommonDataKeys.MPS_PROJECT));
    MapSequence.fromMap(_params).put("editor", event.getData(MPSEditorDataKeys.MPS_EDITOR));
    MapSequence.fromMap(_params).put("ideaProject", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("ideaProject") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("pack", event.getData(MPSDataKeys.VIRTUAL_PACKAGE));
    MapSequence.fromMap(_params).put("context", event.getData(MPSCommonDataKeys.OPERATION_CONTEXT));
    if (MapSequence.fromMap(_params).get("context") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("contextModel", event.getData(MPSCommonDataKeys.CONTEXT_MODEL));
    if (MapSequence.fromMap(_params).get("contextModel") == null) {
      return false;
    }
    MapSequence.fromMap(_params).put("node", event.getData(MPSCommonDataKeys.NODE));
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      PasteNodeData pasteNodeData = PasteNode_Action.this.getPasteData(_params);
      final Runnable addImportsRunnable = CopyPasteUtil.addImportsWithDialog(pasteNodeData.getSourceModule(), ((SModelDescriptor) MapSequence.fromMap(_params).get("contextModel")).getSModel(), pasteNodeData.getNecessaryLanguages(), pasteNodeData.getNecessaryModels(), ((IOperationContext) MapSequence.fromMap(_params).get("context")));
      final List<SNode> pasteNodes = pasteNodeData.getNodes();
      final Set<SReference> refsToResolve = pasteNodeData.getRequireResolveReferences();
      if (pasteNodes == null || pasteNodes.size() == 0) {
        return;
      }
      ModelAccess.instance().runCommandInEDT(new Runnable() {
        public void run() {
          if (addImportsRunnable != null) {
            addImportsRunnable.run();
          }
          if (((SNode) MapSequence.fromMap(_params).get("node")) == null) {
            NodePaster paster = new NodePaster(pasteNodes);
            if (!(paster.canPasteAsRoots())) {
              return;
            }
            paster.pasteAsRoots(((SModelDescriptor) MapSequence.fromMap(_params).get("contextModel")).getSModel(), ((String) MapSequence.fromMap(_params).get("pack")));
          } else {
            NodePaster paster = new NodePaster(pasteNodes);
            if (!(paster.canPaste(((SNode) MapSequence.fromMap(_params).get("node")), PasteEnv.PROJECT_TREE))) {
              return;
            }
            paster.paste(((SNode) MapSequence.fromMap(_params).get("node")), PasteEnv.PROJECT_TREE);
          }
          Resolver.resolveReferences(refsToResolve, ((IOperationContext) MapSequence.fromMap(_params).get("context")));
          // make sure editor will be open 
          final SNode root = pasteNodes.get(0).getContainingRoot();
          assert root != null;
          ModelAccess.instance().runReadInEDT(new Runnable() {
            public void run() {
              NavigationSupport.getInstance().openNode(((IOperationContext) MapSequence.fromMap(_params).get("context")), root, true, true);
              NavigationSupport.getInstance().selectInTree(((IOperationContext) MapSequence.fromMap(_params).get("context")), root, false);
            }
          });
        }
      }, ((MPSProject) MapSequence.fromMap(_params).get("project")));
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "PasteNode", t);
      }
    }
  }

  private PasteNodeData getPasteData(final Map<String, Object> _params) {
    final Wrappers._T<PasteNodeData> result = new Wrappers._T<PasteNodeData>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        result.value = CopyPasteUtil.getPasteNodeDataFromClipboard(((SModelDescriptor) MapSequence.fromMap(_params).get("contextModel")).getSModel());
      }
    });
    return result.value;
  }

  private boolean canPasteNodes(final Map<String, Object> _params) {
    return PasteNode_Action.this.getPasteData(_params) != null;
  }

  private static Icon getIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(PasteNode_Action.class.getResourceAsStream("menu-paste.png")));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for PasteNode", e);
      }
      return null;
    }
  }
}
