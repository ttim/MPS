package jetbrains.mps.refactoring;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.SModelReference;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;

public class StructureModificationLog {
  private List<StructureModification> myDataList = ListSequence.fromList(new ArrayList<StructureModification>());

  public StructureModificationLog() {
  }

  public List<StructureModification> getHistory() {
    return myDataList;
  }

  public void addStructureModification(StructureModification data) {
    ListSequence.fromList(myDataList).addElement(data);
  }

  public int getLatestVersion(SModelReference modelRef) {
    if ((int) ListSequence.fromList(myDataList).count() == 0) {
      return -1;
    }
    Map<SModelReference, Integer> deps = ListSequence.fromList(myDataList).last().getDependencies();
    return (MapSequence.fromMap(deps).containsKey(modelRef) ?
      MapSequence.fromMap(deps).get(modelRef) + 1 :
      -1
    );
  }
}
