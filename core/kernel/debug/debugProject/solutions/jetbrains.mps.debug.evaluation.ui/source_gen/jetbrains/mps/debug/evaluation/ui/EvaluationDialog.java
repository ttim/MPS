package jetbrains.mps.debug.evaluation.ui;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import jetbrains.mps.logging.Logger;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.embeddableEditor.EmbeddableEditor;
import jetbrains.mps.debug.runtime.JavaUiState;
import jetbrains.mps.debug.runtime.DebugSession;
import java.awt.Dimension;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.project.ModuleContext;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.SModelDescriptor;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import jetbrains.mps.debug.evaluation.ValueProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ModalityState;
import jetbrains.mps.ide.ui.MPSTree;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.ui.TextTreeNode;
import jetbrains.mps.debug.api.integration.ui.WatchableNode;
import jetbrains.mps.debug.runtime.java.programState.watchables.CalculatedValue;
import java.awt.Color;
import jetbrains.mps.ide.messages.Icons;

public class EvaluationDialog extends BaseDialog {
  private static final Logger LOG = Logger.getLogger(EvaluationDialog.class);

  private final JPanel myPanel = new JPanel(new BorderLayout());
  private final JTabbedPane myTabbedPane = new JTabbedPane();
  private final IOperationContext myContext;
  private EvaluationDialog.MyTree myTree;
  private EmbeddableEditor myEditor;
  private EmbeddableEditor myResultEditor;
  private final AbstractEvaluationLogic myEvaluationData;

  public EvaluationDialog(final IOperationContext context, JavaUiState uiState, DebugSession debugSession) {
    super(context.getMainFrame(), "Evaluate");
    this.myContext = context;
    this.setSize(new Dimension(500, 500));
    this.setModal(false);

    this.myEvaluationData = AbstractEvaluationLogic.createInstance(context, uiState, debugSession);
    if (myEvaluationData.isDeveloperMode()) {
      myEvaluationData.addGenerationListener(new _FunctionTypes._void_P1_E0<SNode>() {
        public void invoke(SNode result) {
          EvaluationDialog.this.updateGenerationResultTab(result);
        }
      });
    }

    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        EvaluationDialog.this.myEditor = new EmbeddableEditor(new ModuleContext(EvaluationDialog.this.myEvaluationData.getModule(), EvaluationDialog.this.myEvaluationData.getModule().getMPSProject()), EvaluationDialog.this.myEvaluationData.getModule(), EvaluationDialog.this.myEvaluationData.getRootToShow(), myEvaluationData.getNodeToShow(), true);

        for (Language language : EvaluationDialog.this.myEvaluationData.getRequiredLanguages()) {
          EvaluationDialog.this.myEditor.addLanguage(language);
        }
      }
    });

    final Wrappers._T<SModelDescriptor> d = new Wrappers._T<SModelDescriptor>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        d.value = myEditor.getModel();
      }
    });
    myEvaluationData.setModel(d.value);

    myPanel.add(this.myEditor.getComponenet(), BorderLayout.NORTH);
    myTree = new EvaluationDialog.MyTree();
    myPanel.add(new JScrollPane(myTree), BorderLayout.CENTER);

    if (myEvaluationData.isDeveloperMode()) {
      this.myTabbedPane.addTab("Main", myPanel);
    }

    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosed(WindowEvent event) {
        EvaluationDialog.this.myEditor.disposeEditor();
        EvaluationDialog.this.myEvaluationData.getModule().dispose();
      }
    });
  }

  protected JComponent getMainComponent() {
    if (myEvaluationData.isDeveloperMode()) {
      return this.myTabbedPane;
    } else {
      return myPanel;
    }
  }

  @BaseDialog.Button(position = 0, name = "Evaluate", mnemonic = 'E', defaultButton = true)
  public void buttonEvaluate() {
    try {
      ValueProxy evaluatedValue = myEvaluationData.evaluate();
      if (evaluatedValue != null) {
        setSuccess(evaluatedValue);
      } else {
        setFailure(null, "Evaluation returned null.");
      }
    } catch (BaseEvaluationException e) {
      setFailure(e, null);
      LOG.error(e);
    }
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C', defaultButton = false)
  public void buttonCancel() {
    this.dispose();
  }

  private void setSuccess(@NotNull ValueProxy evaluatedValue) {
    myTree.setResultProxy(evaluatedValue);
    myTree.rebuildLater();
  }

  private void setFailure(@Nullable Throwable error, @Nullable String message) {
    if (error != null) {
      myTree.setError(error.getMessage());
    } else {
      myTree.setError(message);
    }
    myTree.rebuildLater();
  }

  public void updateGenerationResultTab(final SNode generatedResult) {
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      public void run() {
        if (EvaluationDialog.this.myResultEditor == null) {
          ModelAccess.instance().runWriteActionInCommand(new Runnable() {
            public void run() {
              EvaluationDialog.this.myResultEditor = new EmbeddableEditor(new ModuleContext(myEvaluationData.getModule(), myEvaluationData.getModule().getMPSProject()), myEvaluationData.getModule(), generatedResult, generatedResult, false);
            }
          });
          EvaluationDialog.this.myTabbedPane.add("Generated Result", EvaluationDialog.this.myResultEditor.getComponenet());
          EvaluationDialog.this.myTabbedPane.validate();
        } else {
          ModelAccess.instance().runReadAction(new Runnable() {
            public void run() {
              EvaluationDialog.this.myResultEditor.setNode(generatedResult);
            }
          });
        }
      }
    }, ModalityState.NON_MODAL);
  }

  private static class MyTree extends MPSTree {
    @Nullable
    private ValueProxy myValueProxy;
    @Nullable
    private String myErrorText;

    public MyTree() {
      super();
      this.rebuildNow();
    }

    public void setResultProxy(ValueProxy valueProxy) {
      myValueProxy = valueProxy;
      myErrorText = null;
    }

    private void setError(String text) {
      myErrorText = text;
      myValueProxy = null;
    }

    @Override
    protected MPSTreeNode rebuild() {
      MPSTreeNode rootTreeNode = new TextTreeNode("Evaluation Result");
      if (myValueProxy != null) {
        rootTreeNode.add(new WatchableNode(new CalculatedValue(this.myValueProxy.getJDIValue())));
      } else if (myErrorText != null) {
        rootTreeNode.add(new EvaluationDialog.ErrorTreeNode(myErrorText));
      }
      this.setRootVisible(false);
      this.setShowsRootHandles(true);
      return rootTreeNode;
    }
  }

  private static class ErrorTreeNode extends TextTreeNode {
    public ErrorTreeNode(@NotNull String text) {
      super(text);

      updatePresentation();
    }

    @Override
    public boolean isLeaf() {
      return true;
    }

    @Override
    protected void updatePresentation() {
      super.updatePresentation();

      setColor(Color.RED);
      setIcon(Icons.ERROR_ICON);
    }
  }
}
