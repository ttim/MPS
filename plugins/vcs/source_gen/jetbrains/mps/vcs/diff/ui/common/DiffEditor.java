package jetbrains.mps.vcs.diff.ui.common;

/*Generated by MPS */

import jetbrains.mps.nodeEditor.EditorMessageOwner;
import javax.swing.JPanel;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponent;
import java.util.Map;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.nodeEditor.EditorComponent;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SNodeId;
import javax.swing.JComponent;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.nodeEditor.cells.EditorCell;
import jetbrains.mps.smodel.event.SModelEvent;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.nodeEditor.cells.EditorCell_Constant;

public class DiffEditor implements EditorMessageOwner {
  private DiffEditor.MainEditorComponent myMainEditorComponent;
  private JPanel myTopComponent;
  private InspectorEditorComponent myInspector;
  private Map<ModelChange, List<ChangeEditorMessage>> myChangeToMessages = MapSequence.fromMap(new HashMap<ModelChange, List<ChangeEditorMessage>>());

  public DiffEditor(IOperationContext context, SNode node, String contentTitle, boolean isLeftEditor) {
    myMainEditorComponent = new DiffEditor.MainEditorComponent(context, isLeftEditor);
    myInspector = new InspectorEditorComponent(isLeftEditor);
    Sequence.fromIterable(getEditorComponents()).visitAll(new IVisitor<EditorComponent>() {
      public void visit(EditorComponent ec) {
        ec.setNoVirtualFile(true);
      }
    });

    SModel model = SNodeOperations.getModel(node);
    if (model != null) {
      boolean editable = !(model.isNotEditable());
      setReadOnly(!(editable));
    }

    myMainEditorComponent.editNode(node, myMainEditorComponent.getOperationContext());
    myInspector.getExternalComponent().setPreferredSize(new Dimension());
    Sequence.fromIterable(getEditorComponents()).visitAll(new IVisitor<EditorComponent>() {
      public void visit(EditorComponent ec) {
        ec.getLeftEditorHighlighter().setDefaultFoldingAreaPaintersEnabled(false);
        ec.setPopupMenuEnabled(false);
      }
    });

    myTopComponent = new JPanel(new BorderLayout());
    JLabel title = new JLabel(contentTitle);
    title.setToolTipText(contentTitle);
    myTopComponent.add(title, BorderLayout.NORTH);
    myTopComponent.add(myMainEditorComponent.getExternalComponent(), BorderLayout.CENTER);
    myTopComponent.setPreferredSize(new Dimension());
  }

  public SNode getEditedNode() {
    return getMainEditor().getEditedNode();
  }

  public void editRoot(@NotNull Project project, @NotNull SNodeId rootId, @NotNull SModel model) {
    SNode root = model.getNodeById(rootId);
    if (root != null && SNodeOperations.getParent(root) == null) {
      getMainEditor().editNode(root, DiffTemporaryModule.getOperationContext(project, model));
    }
  }

  public void inspect(SNode node) {
    myInspector.inspectNode(node, myMainEditorComponent.getOperationContext());
    myInspector.getHighlightManager().repaintAndRebuildEditorMessages();
  }

  public void setReadOnly(final boolean readOnly) {
    Sequence.fromIterable(getEditorComponents()).visitAll(new IVisitor<EditorComponent>() {
      public void visit(EditorComponent ec) {
        ec.setReadOnly(readOnly);
      }
    });
  }

  public JComponent getTopComponent() {
    return myTopComponent;
  }

  public DiffEditor.MainEditorComponent getMainEditor() {
    return myMainEditorComponent;
  }

  public InspectorEditorComponent getInspector() {
    return myInspector;
  }

  public EditorComponent getEditorComponent(boolean inspector) {
    return (inspector ?
      myInspector :
      myMainEditorComponent
    );
  }

  public void highlightChange(SModel model, ModelChange change, ChangeEditorMessage.ConflictChecker conflictChecker) {
    final List<ChangeEditorMessage> messages = ChangeEditorMessageFactory.createMessages(model, change, this, conflictChecker);
    if (ListSequence.fromList(messages).isEmpty()) {
      return;
    }
    MapSequence.fromMap(myChangeToMessages).put(change, messages);
    Sequence.fromIterable(getEditorComponents()).visitAll(new IVisitor<EditorComponent>() {
      public void visit(final EditorComponent ec) {
        ListSequence.fromList(messages).visitAll(new IVisitor<ChangeEditorMessage>() {
          public void visit(ChangeEditorMessage m) {
            ec.getHighlightManager().mark(m);
          }
        });
      }
    });
  }

  public void repaintAndRebuildEditorMessages() {
    Sequence.fromIterable(getEditorComponents()).visitAll(new IVisitor<EditorComponent>() {
      public void visit(EditorComponent ec) {
        ec.getHighlightManager().repaintAndRebuildEditorMessages();
      }
    });
  }

  public List<ChangeEditorMessage> getMessagesForChange(ModelChange change) {
    return MapSequence.fromMap(myChangeToMessages).get(change);
  }

  public void unhighlightAllChanges() {
    Sequence.fromIterable(getEditorComponents()).visitAll(new IVisitor<EditorComponent>() {
      public void visit(EditorComponent ec) {
        ec.getHighlightManager().clearForOwner(DiffEditor.this);
      }
    });
    MapSequence.fromMap(myChangeToMessages).clear();
  }

  public void dispose() {
    myMainEditorComponent.dispose();
    myMainEditorComponent = null;
    myInspector.dispose();
    myInspector = null;
  }

  private Iterable<EditorComponent> getEditorComponents() {
    return Sequence.fromArray(new EditorComponent[]{myMainEditorComponent, myInspector});
  }

  public class MainEditorComponent extends EditorComponent {
    public MainEditorComponent(IOperationContext operationContext, boolean rightToLeft) {
      super(operationContext, false, rightToLeft);
    }

    public EditorCell createRootCell(List<SModelEvent> events) {
      if (getEditedNode() == null || getEditedNode().isDeleted()) {
        EditorContext editorContext = getEditorContext();
        return new EditorCell_Constant(editorContext, getEditedNode(), "");
      }
      return getEditorContext().createRootCell(getEditedNode(), events);
    }
  }
}
