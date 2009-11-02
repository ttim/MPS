package jetbrains.mps.ide.actions;

/*Generated by MPS */

import javax.swing.JPanel;
import jetbrains.mps.ide.findusages.view.UsagesView;
import jetbrains.mps.project.MPSProject;
import java.awt.BorderLayout;
import jetbrains.mps.ide.findusages.view.treeholder.treeview.ViewOptions;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.ide.findusages.findalgorithm.finders.IFinder;
import jetbrains.mps.ide.findusages.model.SearchResults;
import jetbrains.mps.ide.findusages.model.SearchQuery;
import com.intellij.openapi.progress.ProgressIndicator;
import java.util.List;
import jetbrains.mps.ide.findusages.model.SearchResult;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.HashSet;
import jetbrains.mps.ide.findusages.model.IResultProvider;
import jetbrains.mps.ide.findusages.view.FindUtils;
import java.util.Arrays;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.IModule;
import jetbrains.mps.ide.findusages.view.treeholder.treeview.INodeRepresentator;
import java.util.EnumMap;
import jetbrains.mps.nodeEditor.MessageStatus;
import java.util.Map;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.ide.findusages.view.treeholder.tree.TextOptions;
import javax.swing.Icon;
import jetbrains.mps.ide.messages.Icons;
import org.jdom.Element;
import jetbrains.mps.ide.findusages.CantSaveSomethingException;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.ide.findusages.CantLoadSomethingException;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;

public class ModelCheckerViewer extends JPanel {
  private UsagesView myUsagesView;
  private MPSProject myProject;
  private ModelCheckerTool_Tool myTool;
  private ModelCheckerResults myLastResults;
  private ModelCheckerViewer.MyNodeRepresentator myNodeRepresentator = new ModelCheckerViewer.MyNodeRepresentator();

  public ModelCheckerViewer(MPSProject project, ModelCheckerTool_Tool tool) {
    this.myProject = project;
    this.myTool = tool;

    this.setLayout(new BorderLayout());
    ViewOptions viewOptions = new ViewOptions(true, false, false, false, false);
    viewOptions.myCategory = true;

    this.myUsagesView = new UsagesView(this.myProject, viewOptions) {
      public void close() {
        ModelCheckerViewer.this.myTool.removeTab(this.getComponent());
        ModelCheckerViewer.this.myTool.makeUnavailableLater();
      }
    };
    this.myUsagesView.setCustomNodeRepresentator(this.myNodeRepresentator);
    this.add(this.myUsagesView.getComponent());
  }

  public void checkModel(final SModel model, final IScope scope) {
    ModelCheckerViewer.this.myLastResults = ModelCheckerResultsFinder.getResults(model, scope);
    this.myNodeRepresentator.saveCheckerResults(this.myLastResults);

    IFinder finder = new IFinder() {
      public SearchResults find(SearchQuery searchQuery, ProgressIndicator indicator) {
        List<SearchResult<SNode>> searchResults = ListSequence.fromList(new ArrayList<SearchResult<SNode>>());
        for (ModelCheckerResults.Result result : ListSequence.fromList(ModelCheckerViewer.this.myLastResults.getResultsList())) {
          ListSequence.fromList(searchResults).addElement(new SearchResult<SNode>(result.getNode(), result.getStatus().toString()));
        }
        return new SearchResults<SNode>(new HashSet<SNode>(), searchResults);
      }
    };

    IResultProvider resultProvider = FindUtils.makeProvider(Arrays.asList(finder));
    SearchQuery searchQuery = new SearchQuery(this.myProject.getScope());
    this.myUsagesView.setRunOptions(resultProvider, searchQuery, new UsagesView.ButtonConfiguration(false, false, false), new SearchResults());
    ProgressManager.getInstance().run(new Task.Modal(this.myProject.getComponent(Project.class), "Searching", true) {
      public void run(@NotNull ProgressIndicator indicator) {
        indicator.setIndeterminate(true);
        ModelCheckerViewer.this.myUsagesView.run(indicator);

        ModelCheckerViewer.this.myTool.openToolLater(true);
      }
    });
  }

  public void checkModule(final IModule module, final IScope scope) {
    //  TODO
    ModelCheckerViewer.this.myTool.openToolLater(true);
  }

  public static class MyNodeRepresentator implements INodeRepresentator {
    private static final String NODE = "node";
    private static final String NODE_REFERENCE = "reference";
    private static final String STATUS = "status";
    private static final String MESSAGE = "message";
    private static EnumMap<MessageStatus, String> COLOR_FOR_ERROR;

    private Map<SNodeId, ModelCheckerResults.Result> myCheckerResultForNode = MapSequence.fromMap(new HashMap<SNodeId, ModelCheckerResults.Result>());

    public MyNodeRepresentator() {
    }

    public String getResultsText(TextOptions options) {
      int size = options.mySubresultsCount;
      String sizeRepr = size + " issue" + ((size == 1 ?
        "" :
        "s"
      ));
      return "<strong>" + sizeRepr + " found</strong>";
    }

    public Icon getResultsIcon() {
      return Icons.ERROR_ICON;
    }

    public String getPresentation(SNode node) {
      ModelCheckerResults.Result result = MapSequence.fromMap(this.myCheckerResultForNode).get(getNodeId(node));
      String color = COLOR_FOR_ERROR.get(result.getStatus());
      String message = result.getMessage();
      message = message.replaceAll("&", "&amp;");
      message = message.replaceAll("<", "&lt;");
      message = message.replaceAll(">", "&gt;");
      return "<span style=\"color: " + color + "\">" + message + "</span>";
    }

    public void write(Element element, MPSProject project) throws CantSaveSomethingException {
      for (IMapping<SNodeId, ModelCheckerResults.Result> nodeResultPair : MapSequence.fromMap(this.myCheckerResultForNode)) {
        Element resultXML = new Element(NODE);
        resultXML.setAttribute(NODE_REFERENCE, nodeResultPair.key().toString());
        resultXML.setAttribute(STATUS, nodeResultPair.value().getStatus().name());
        resultXML.setAttribute(MESSAGE, nodeResultPair.value().getMessage());
        element.addContent(resultXML);
      }
    }

    public void read(Element element, MPSProject project) throws CantLoadSomethingException {
      MapSequence.fromMap(this.myCheckerResultForNode).clear();
      {
        Element resultXML;
        Iterator<Element> resultXML_iterator = element.getChildren(NODE).iterator();
        while (true) {
          if (!(resultXML_iterator.hasNext())) {
            break;
          }
          resultXML = resultXML_iterator.next();
          {
            SNodeId nodeId = SNodeId.fromString(resultXML.getAttribute(NODE_REFERENCE).getValue());
            MessageStatus status = MessageStatus.valueOf(resultXML.getAttribute(STATUS).getValue());
            String message = resultXML.getAttribute(MESSAGE).getValue();
            MapSequence.fromMap(this.myCheckerResultForNode).put(nodeId, new ModelCheckerResults.Result(null, status, message));
          }
        }
      }
    }

    public void saveCheckerResults(ModelCheckerResults results) {
      MapSequence.fromMap(this.myCheckerResultForNode).clear();
      for (ModelCheckerResults.Result result : ListSequence.fromList(results.getResultsList())) {
        MapSequence.fromMap(this.myCheckerResultForNode).put(getNodeId(result.getNode()), result);
      }
    }

    private static SNodeId getNodeId(final SNode node) {
      final Wrappers._T<SNodeId> nodeId = new Wrappers._T<SNodeId>();
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          nodeId.value = node.getSNodeId();
        }
      });
      return nodeId.value;
    }

    static {
      COLOR_FOR_ERROR = new EnumMap(MessageStatus.class);
      //  TODO green?
      COLOR_FOR_ERROR.put(MessageStatus.OK, "#267F00");
      COLOR_FOR_ERROR.put(MessageStatus.WARNING, "#CEC548");
      COLOR_FOR_ERROR.put(MessageStatus.ERROR, "#AF0000");
    }
  }
}
