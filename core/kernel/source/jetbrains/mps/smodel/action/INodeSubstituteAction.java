package jetbrains.mps.smodel.action;

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.nodeEditor.AbstractEditorComponent;
import jetbrains.mps.nodeEditor.EditorContext;

import javax.swing.Icon;

public interface INodeSubstituteAction {
  SNode getSourceNode();

  SNode getOutputConcept();

  String getMatchingText(String pattern);
  String getVisibleMatchingText(String pattern);
  String getDescriptionText(String pattern);
  Icon getIconFor(String pattern);

  boolean canSubstituteStrictly(String pattern);
  boolean canSubstitute(String pattern);

  SNode substitute(EditorContext context, String pattern);
}
