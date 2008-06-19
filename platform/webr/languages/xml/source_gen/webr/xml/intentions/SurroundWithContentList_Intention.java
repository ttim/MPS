package webr.xml.intentions;

/*Generated by MPS */

import jetbrains.mps.intentions.BaseIntention;
import jetbrains.mps.intentions.Intention;
import java.util.Map;
import java.util.HashMap;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.EditorContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import java.util.List;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class SurroundWithContentList_Intention extends BaseIntention implements Intention {

  private Map<String, Object[]> myMap = new HashMap<String, Object[]>();

  public String getConcept() {
    return "webr.xml.structure.Content";
  }

  public boolean isErrorIntention() {
    return false;
  }

  public String getDescription(SNode node, EditorContext editorContext) {
    return "Surround with content list";
  }

  public boolean isApplicable(SNode node, EditorContext editorContext) {
    return true;
  }

  public void execute(SNode node, EditorContext editorContext) {
    SNode contentList = SConceptOperations.createNewNode("webr.xml.structure.ContentList", null);
    List<SNode> selectedNodes = editorContext.getNodeEditorComponent().getNodeRangeSelection().getNodes();
    if (selectedNodes.isEmpty()) {
      selectedNodes.add(editorContext.getSelectedNode());
    }
    SNode first = selectedNodes.get(0);
    SNodeOperations.insertPrevSiblingChild(first, contentList);
    for(SNode selectedNode : selectedNodes) {
      SLinkOperations.addChild(contentList, "content", selectedNode);
    }
    SLinkOperations.addNewChild(contentList, "content", "webr.xml.structure.Content");
  }

  public Object[] getField(String key) {
    Object[] value = this.myMap.get(key);
    if (value == null) {
      value = new Object[1];
      this.myMap.put(key, value);
    }
    return value;
  }

  public void putArgument(String key, Object argument) {
    this.getField(key)[0] = argument;
  }

  public String getSourceModelUID() {
    return "webr.xml.intentions";
  }

}
