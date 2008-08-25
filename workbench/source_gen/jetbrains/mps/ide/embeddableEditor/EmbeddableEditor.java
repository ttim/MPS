package jetbrains.mps.ide.embeddableEditor;

/*Generated by MPS */

import javax.swing.JPanel;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponent;
import jetbrains.mps.nodeEditor.UIEditorComponent;
import jetbrains.mps.smodel.IOperationContext;
import javax.swing.JSplitPane;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.ModelOwner;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.ProjectModels;
import jetbrains.mps.nodeEditor.inspector.InspectorEditorComponentFactory;
import javax.swing.JScrollPane;
import javax.swing.JComponent;
import jetbrains.mps.generator.GeneratorManager;
import java.util.Arrays;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelRepository;

public class EmbeddableEditor extends JPanel {

  private InspectorEditorComponent myInspector;
  private UIEditorComponent myEditorComponent;
  private IOperationContext myContext;
  private JSplitPane mySplitter;
  private SModelDescriptor myModel;
  private ModelOwner myOwner;
  private SNode myNode;

  public EmbeddableEditor(IOperationContext context, ModelOwner owner) {
    super();
    this.myContext = context;
    this.myOwner = owner;
    this.myModel = ProjectModels.createDescriptorFor(this.myOwner);
    this.myInspector = InspectorEditorComponentFactory.getInspectorEditorComponent();
    this.myEditorComponent = new UIEditorComponent(this.myContext, this.myInspector);
    this.mySplitter = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(this.myEditorComponent), new JScrollPane(this.myInspector));
    this.mySplitter.setDividerLocation(150);
    this.add(this.mySplitter);
  }

  public void setNode(SNode node) {
    this.myNode = node;
    this.setEditNode();
  }

  public JComponent getComponent() {
    return this.mySplitter;
  }

  public GenerateResult generate(EditorGenerateType type) {
    if (this.myNode == null) {
      return null;
    }
    GeneratorManager manager = this.myContext.getComponent(GeneratorManager.class);
    manager.generateModelsWithProgressWindow(Arrays.asList(this.myModel), this.myContext, type, false);
    return new GenerateResult(this.myNode, this.myContext, this.myModel);
  }

  public void addLanguage(final Language language) {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {

      public void run() {
        EmbeddableEditor.this.myModel.getSModel().addImportedModel(language.getStructureModelDescriptor().getModelUID());
      }

    });
  }

  private void setEditNode() {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {

      public void run() {
        EmbeddableEditor.this.myModel.getSModel().addRoot(EmbeddableEditor.this.myNode);
        EmbeddableEditor.this.myEditorComponent.editNode(EmbeddableEditor.this.myNode, EmbeddableEditor.this.myContext);
      }

    });
  }

  public void disposeEditor() {
    SModelRepository.getInstance().unRegisterModelDescriptors(this.myOwner);
  }

}
