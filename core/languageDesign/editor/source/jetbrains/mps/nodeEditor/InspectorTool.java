package jetbrains.mps.nodeEditor;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import com.intellij.openapi.fileEditor.FileEditor;
import com.intellij.openapi.actionSystem.DataProvider;
import com.intellij.ui.LightColors;
import com.intellij.ui.HyperlinkLabel;
import jetbrains.mps.ide.projectPane.Icons;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponent;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.workbench.tools.BaseProjectTool;
import jetbrains.mps.workbench.editors.MPSEditorOpener;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NonNls;

import javax.swing.*;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.HyperlinkEvent;
import java.awt.BorderLayout;

public class InspectorTool extends BaseProjectTool {
  public static final String ID = "Inspector";

  private JPanel myComponent;
  private InspectorEditorComponent myInspectorComponent;
  private MyMessagePanel myMessagePanel = new MyMessagePanel();
  private FileEditor myFileEditor;

  public InspectorTool(Project project) {
    super(project, ID, 5, Icons.INSPECTOR_ICON, ToolWindowAnchor.BOTTOM, true, false);
  }

  public void initComponent() {
    super.initComponent();
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        myComponent = new MyPanel();
        myInspectorComponent = new InspectorEditorComponent();
        myComponent.add(myInspectorComponent.getExternalComponent(), BorderLayout.CENTER);
        myMessagePanel.setNode(null);
        myComponent.add(myMessagePanel, BorderLayout.NORTH);
      }
    });
  }

  public void disposeComponent() {
    myInspectorComponent.dispose();
  }

  protected boolean isInitiallyAvailable() {
    return true;
  }

  public EditorComponent getInspector() {
    return myInspectorComponent;
  }

  public JComponent getComponent() {
    return myComponent;
  } 

  public void inspect(final SNode node, IOperationContext context, FileEditor fileEditor, @Nullable Runnable afterInspect) {
    myFileEditor = fileEditor;
    myInspectorComponent.inspectNode(node, context, afterInspect);

    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        myMessagePanel.setNode(node);
      }
    });
  }

  public void activate() {
    //we need this in order for the following code to work:
    //
    // inspect(node, context, editor, null);
    // activate();
    //
    // if we won't use runReadInEDT, the openTool(true) call might be called
    // before node is selected in inspector and focus will be lost.
    ModelAccess.instance().runReadInEDT(new Runnable() {
      public void run() {
        openTool(true);
      }
    });
  }



  private class MyPanel extends JPanel implements DataProvider {
    private MyPanel() {
      super(new BorderLayout());
    }

    @Nullable
    public Object getData(@NonNls String dataId) {
      if (MPSDataKeys.FILE_EDITOR.getName().equals(dataId)) {
        return myFileEditor;
      }
      return null;
    }
  }

  private class MyMessagePanel extends JPanel {
    private static final String NO_CONCEPT_MESSAGE = "<no node>";

    private JLabel myLabel = new JLabel();
    private HyperlinkLabel myOpenConceptLabel = new HyperlinkLabel("Open Concept Declaration");
    private SNode myNode;

    private MyMessagePanel() {
      setLayout(new BorderLayout());

      setBackground(LightColors.YELLOW);
      setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));

      add(myLabel, BorderLayout.CENTER);
      add(myOpenConceptLabel, BorderLayout.EAST);

      myOpenConceptLabel.setOpaque(false);
      myOpenConceptLabel.addHyperlinkListener(new HyperlinkListener() {
        public void hyperlinkUpdate(HyperlinkEvent e) {
          ModelAccess.instance().runWriteActionInCommand(new Runnable() {
            public void run() {
              SNode concept = SNodeOperations.getConceptDeclaration(myNode);
              getProject().getComponent(MPSEditorOpener.class).openNode(concept);
            }
          });
        }
      });
    }

    public void setNode(SNode node) {
      myNode = node;
      if (node == null) {
        myLabel.setText(NO_CONCEPT_MESSAGE);
        myOpenConceptLabel.setVisible(false);
      } else {
        myLabel.setText(node.getConceptFqName());
        myOpenConceptLabel.setVisible(true);
      }
    }
  }
}
