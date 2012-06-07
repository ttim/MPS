package jetbrains.mps.ide.actions;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.plugins.relations.RelationDescriptor;
import jetbrains.mps.plugins.projectplugins.ProjectPluginManager;
import jetbrains.mps.ide.project.ProjectHelper;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.ModelAccess;
import com.intellij.openapi.project.Project;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.ide.projectPane.ProjectPane;
import java.util.Iterator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.Set;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.view.FindUtils;
import jetbrains.mps.progress.EmptyProgressMonitor;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import javax.swing.SwingUtilities;
import jetbrains.mps.ide.platform.refactoring.RefactoringAccess;
import jetbrains.mps.ide.platform.refactoring.RefactoringViewAction;
import jetbrains.mps.ide.platform.refactoring.RefactoringViewItem;

public class DeleteNodesHelper {
  private List<SNode> myNodesToDelete;
  private IOperationContext myContext;

  public DeleteNodesHelper(List<SNode> nodes, IOperationContext context) {
    myContext = context;
    myNodesToDelete = ListSequence.fromListWithValues(new ArrayList<SNode>(), nodes);
  }

  public boolean hasOptions() {
    return ListSequence.fromList(myNodesToDelete).translate(new ITranslator2<SNode, RelationDescriptor>() {
      public Iterable<RelationDescriptor> translate(final SNode node) {
        List<RelationDescriptor> tabs = ProjectPluginManager.getApplicableTabs(ProjectHelper.toIdeaProject(myContext.getProject()), node);
        return ListSequence.fromList(tabs).where(new IWhereFilter<RelationDescriptor>() {
          public boolean accept(RelationDescriptor it) {
            return it.isApplicable(node) && !(it.getNodes(node).isEmpty());
          }
        });
      }
    }).isNotEmpty();
  }

  public void deleteNodes(final boolean safe, final boolean aspects, final boolean fromProjectPane) {
    assert !(ModelAccess.instance().canRead()) : "can lead to deadlock";

    final Project ideaProject = ProjectHelper.toIdeaProject(myContext.getProject());
    final _FunctionTypes._void_P0_E0 performer = new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        ProjectPane projectPane = ProjectPane.getInstance(ideaProject);

        for (Iterator<SNode> iterator = myNodesToDelete.iterator(); iterator.hasNext();) {
          SNode sNode = iterator.next();
          if (!(iterator.hasNext()) && fromProjectPane) {
            projectPane.rebuildTree();
            projectPane.selectNextNode(sNode);
          }
          if (sNode.isDeleted()) {
            continue;
          }
          sNode.delete();
        }
      }
    };
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        if (aspects) {
          List<SNode> addNodes = ListSequence.fromList(myNodesToDelete).translate(new ITranslator2<SNode, SNode>() {
            public Iterable<SNode> translate(final SNode node) {
              List<RelationDescriptor> tabs = ProjectPluginManager.getApplicableTabs(ideaProject, node);
              return ListSequence.fromList(tabs).where(new IWhereFilter<RelationDescriptor>() {
                public boolean accept(RelationDescriptor it) {
                  return it.isApplicable(node);
                }
              }).translate(new ITranslator2<RelationDescriptor, SNode>() {
                public Iterable<SNode> translate(final RelationDescriptor tab) {
                  List<SNode> nodes = tab.getNodes(node);
                  return ListSequence.fromList(nodes).where(new IWhereFilter<SNode>() {
                    public boolean accept(SNode it) {
                      return tab.getBaseNode(it) == node;
                    }
                  });
                }
              });
            }
          }).toListSequence();
          ListSequence.fromList(myNodesToDelete).addSequence(ListSequence.fromList(addNodes));
        }
      }
    });

    if (!(safe)) {
      ModelAccess.instance().runWriteActionInCommand(new Runnable() {
        public void run() {
          performer.invoke();
        }
      });
      return;
    }

    ProgressManager.getInstance().run(new Task.Modal(ideaProject, "Finding Usages", true) {
      public void run(@NotNull final ProgressIndicator p0) {
        final Set<SearchResult<SNode>> results = SetSequence.fromSet(new HashSet<SearchResult<SNode>>());
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {

            ListSequence.fromList(myNodesToDelete).visitAll(new IVisitor<SNode>() {
              public void visit(SNode it) {
                SearchResults<SNode> usages = FindUtils.getSearchResults(new EmptyProgressMonitor(), it, GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.NodeAndDescendantsUsages_Finder");
                SetSequence.fromSet(results).addSequence(ListSequence.fromList(usages.getSearchResults()));

                if (p0.isCanceled()) {
                  return;
                }

                if (SNodeOperations.isInstanceOf(it, "jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration")) {
                  SearchResults<SNode> instances = FindUtils.getSearchResults(new EmptyProgressMonitor(), it, GlobalScope.getInstance(), "jetbrains.mps.lang.structure.findUsages.ConceptInstances_Finder");
                  SetSequence.fromSet(results).addSequence(ListSequence.fromList(instances.getSearchResults()));
                }

                if (p0.isCanceled()) {
                  return;
                }
              }
            });
          }
        });

        if (p0.isCanceled()) {
          return;
        }

        Set<SNode> nodes = SetSequence.fromSetWithValues(new HashSet<SNode>(), SetSequence.fromSet(results).select(new ISelector<SearchResult<SNode>, SNode>() {
          public SNode select(SearchResult<SNode> it) {
            return it.getObject();
          }
        }));
        for (SearchResult<SNode> searchResult : ListSequence.fromListWithValues(new ArrayList<SearchResult<SNode>>(), results)) {
          SNode resultNode = searchResult.getObject();

          for (SNode anc : ListSequence.fromList(SNodeOperations.getAncestors(resultNode, null, false))) {
            if (SetSequence.fromSet(nodes).contains(anc)) {
              SetSequence.fromSet(results).removeElement(searchResult);
              break;
            }
          }
        }
        final SearchResults sr = new SearchResults(SetSequence.fromSetWithValues(new HashSet<SNode>(), myNodesToDelete), SetSequence.fromSet(results).toListSequence());

        if (p0.isCanceled()) {
          return;
        }

        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            RefactoringAccess.getInstance().showRefactoringView(ideaProject, new RefactoringViewAction() {
              public void performAction(RefactoringViewItem refactoringViewItem) {
                ModelAccess.instance().runWriteActionInCommand(new Runnable() {
                  public void run() {
                    performer.invoke();
                  }
                });
                refactoringViewItem.close();
              }
            }, sr, false, "Safe Delete");
          }
        });
      }
    });
  }
}
