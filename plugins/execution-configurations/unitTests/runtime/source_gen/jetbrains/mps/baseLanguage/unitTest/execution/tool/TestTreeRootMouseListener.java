package jetbrains.mps.baseLanguage.unitTest.execution.tool;

/*Generated by MPS */

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestTreeRootMouseListener extends MouseAdapter {
  private StatisticsTableModel statisticsModel;
  private TestOutputComponent outputComponent;
  private TestTree treeComponent;

  public TestTreeRootMouseListener(TestTree tree, StatisticsTableModel statistics, TestOutputComponent outputComponent) {
    statisticsModel = statistics;
    this.outputComponent = outputComponent;
    treeComponent = tree;
  }

  public void mouseClicked(MouseEvent event) {
    if (treeComponent.getPathForLocation(event.getX(), event.getY()) != null) {
      return;
    }
    outputComponent.filter(null, null);
    statisticsModel.setFilter(null, null);
    treeComponent.clearSelection();
  }
}
