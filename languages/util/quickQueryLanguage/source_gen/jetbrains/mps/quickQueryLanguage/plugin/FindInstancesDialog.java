package jetbrains.mps.quickQueryLanguage.plugin;

/*Generated by MPS */

import jetbrains.mps.ide.dialogs.BaseDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.ide.embeddableEditor.EmbeddableEditor;
import jetbrains.mps.ide.findusages.view.optionseditor.components.ScopeEditor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.kernel.model.TemporaryModelOwner;
import jetbrains.mps.project.IModule;
import jetbrains.mps.ide.project.ProjectHelper;
import java.awt.Dimension;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.compiler.IClassesData;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.List;
import jetbrains.mps.smodel.BootstrapLanguages;
import jetbrains.mps.ide.findusages.view.optionseditor.options.ScopeOptions;
import javax.swing.JComponent;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.kernel.model.SModelUtil;
import java.util.Collections;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.quickQueryLanguage.runtime.Query;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.project.Project;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import jetbrains.mps.ide.findusages.model.holders.NodeHolder;
import jetbrains.mps.ide.findusages.view.UsagesViewTool;
import jetbrains.mps.ide.findusages.view.FindUtils;

public class FindInstancesDialog extends BaseDialog {
  private JPanel myPanel = new JPanel(new BorderLayout());
  private IOperationContext myContext;
  private EmbeddableEditor myEditor;
  private ScopeEditor myScope;
  private SNode myNode;
  private boolean myDisposed = false;
  private TemporaryModelOwner myModelOwner = new TemporaryModelOwner();

  public FindInstancesDialog(final IOperationContext context, final IModule module) {
    super(ProjectHelper.toMainFrame(context.getProject()), "Find Instances by condition");
    this.myContext = context;
    this.setSize(new Dimension(500, 500));
    this.setModal(false);
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        FindInstancesDialog.this.myNode = SConceptOperations.createNewNode("jetbrains.mps.quickQueryLanguage.structure.ModelQuery", null);
        SNode statementList = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.StatementList", null);
        SNode expressionStatement = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ExpressionStatement", null);
        SNode defaultCondition = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.BooleanConstant", null);
        SPropertyOperations.set(defaultCondition, "value", "" + true);
        SLinkOperations.setTarget(expressionStatement, "expression", defaultCondition, true);
        ListSequence.fromList(SLinkOperations.getTargets(statementList, "statement", true)).addElement(expressionStatement);
        SLinkOperations.setTarget(SLinkOperations.getTarget(FindInstancesDialog.this.myNode, "condition", true), "body", statementList, true);
        FindInstancesDialog.this.myEditor = new EmbeddableEditor(context, myModelOwner, myNode) {
          @Override
          protected void processClassesData(IClassesData cd) {
            doProcessClassesData(cd);
          }
        };
      }
    });
    if (module instanceof Language) {
      final Wrappers._T<List<Language>> languageList = new Wrappers._T<List<Language>>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          languageList.value = ((Language) module).getAllExtendedLanguages();
        }
      });
      for (Language extendedLanguage : languageList.value) {
        this.myEditor.addLanguageStructureModel(extendedLanguage);
      }
    }
    this.myPanel.add(this.myEditor.getComponenet(), BorderLayout.CENTER);
    this.myEditor.addLanguageStructureModel(BootstrapLanguages.collectionsLanguage());
    if (module instanceof Language) {
      this.myEditor.addLanguageStructureModel((Language) module);
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        FindInstancesDialog.this.myScope = new ScopeEditor(new ScopeOptions());
        FindInstancesDialog.this.myPanel.add(FindInstancesDialog.this.myScope.getComponent(), BorderLayout.SOUTH);
      }
    });
  }

  protected JComponent getMainComponent() {
    return this.myPanel;
  }

  public void setConceptDeclaration(final SNode declaration) {
    ModelAccess.instance().runWriteActionInCommand(new Runnable() {
      public void run() {
        SLinkOperations.setTarget(FindInstancesDialog.this.myNode, "conceptDeclaration", SNodeOperations.cast(declaration, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration"), false);
      }
    });
  }

  @BaseDialog.Button(position = 0, name = "Find", mnemonic = 'F', defaultButton = true)
  public void buttonFind() {
    final Wrappers._T<Language> language = new Wrappers._T<Language>();
    ModelAccess.instance().runWriteAction(new Runnable() {
      public void run() {
        language.value = SModelUtil.getDeclaringLanguage(SNodeOperations.getConceptDeclaration(FindInstancesDialog.this.myNode));
      }
    });
    // <node> 
    myEditor.make(Collections.singleton(language.value.getClassPathItem()));
  }

  private void doProcessClassesData(IClassesData cd) {
    if (cd == null) {
      return;
    }
    final Wrappers._T<SModel> model = new Wrappers._T<SModel>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        model.value = SNodeOperations.getModel(myNode);
      }
    });
    String fqName = model.value.getModelDescriptor().getLongName() + "." + QueryExecutor.GENERATED_QUERY_NAME;
    ClassLoader loader = cd.getClassLoader(QueryExecutor.class.getClassLoader());
    final Wrappers._T<Query> query = new Wrappers._T<Query>(null);
    try {
      query.value = (Query) Class.forName(fqName, true, loader).newInstance();
    } catch (ClassNotFoundException ignore) {
    } catch (IllegalAccessException ignore) {

    } catch (InstantiationException ignore) {
    }
    if (query.value == null) {
      return;
    }

    final IScope scope = this.myScope.getOptions().getScope(this.myContext, model.value.getModelDescriptor());
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        FindInstancesDialog.this.execute(FindInstancesDialog.this.myContext.getProject(), query.value, SNodeOperations.cast(myNode, "jetbrains.mps.quickQueryLanguage.structure.BaseQuery"), scope);
      }
    });
  }

  @BaseDialog.Button(position = 1, name = "Cancel", mnemonic = 'C', defaultButton = false)
  public void buttonCancel() {
    this.dispose();
  }

  public void execute(Project project, Query query, final SNode queryNode, final IScope scope) {
    final Wrappers._T<SearchQuery> searchQuery = new Wrappers._T<SearchQuery>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (SLinkOperations.getTarget(queryNode, "conceptDeclaration", false) != null) {
          searchQuery.value = new SearchQuery(new NodeHolder(SLinkOperations.getTarget(queryNode, "conceptDeclaration", false)), scope);
        } else {
          searchQuery.value = new SearchQuery(scope);
        }
      }
    });
    UsagesViewTool tool = project.getComponent(UsagesViewTool.class);
    tool.findUsages(FindUtils.makeProvider(new QueryFinder(query)), searchQuery.value, true, true, false, "No usages for that node");
  }

  @Override
  public void dispose() {
    super.dispose();
    if (myDisposed) {
      return;
    }
    myDisposed = true;
    ModelAccess.instance().runWriteInEDT(new Runnable() {
      public void run() {
        myEditor.disposeEditor();
        myModelOwner.unregisterModelOwner();
      }
    });
  }
}
