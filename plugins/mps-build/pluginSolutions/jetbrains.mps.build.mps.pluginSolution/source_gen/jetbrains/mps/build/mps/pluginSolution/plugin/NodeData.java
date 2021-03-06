package jetbrains.mps.build.mps.pluginSolution.plugin;

/*Generated by MPS */

import java.util.List;
import javax.swing.Icon;

public interface NodeData {
  public List<NodeData> getChildren();
  public String getText();
  public Icon getIcon(boolean expanded);
  public boolean canHaveChildren();
  public void addChildren(NodeData nodeData);
  public NodeData getParent();
  public void setParent(NodeData parent);
}
