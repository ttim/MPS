package jetbrains.mps.refactoring;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.smodel.SNodePointer;

public class StructureModification {
  private Map<SModelReference, Integer> myDependencies = MapSequence.fromMap(new HashMap<SModelReference, Integer>());
  private List<StructureModification.Entry> myModificationList = ListSequence.fromList(new ArrayList<StructureModification.Entry>());

  public StructureModification() {
  }

  public void addDependencyModel(SModelReference modelRef, int version) {
    MapSequence.fromMap(myDependencies).put(modelRef, version);
  }

  public void setDependencies(Map<SModelReference, Integer> dependencies) {
    myDependencies = dependencies;
  }

  public Map<SModelReference, Integer> getDependencies() {
    return myDependencies;
  }

  public List<StructureModification.Entry> getData() {
    return myModificationList;
  }

  public boolean apply(final ModelLinkMap linkMap) {
    final Wrappers._boolean updated = new Wrappers._boolean(false);
    ListSequence.fromList(myModificationList).visitAll(new IVisitor<StructureModification.Entry>() {
      public void visit(StructureModification.Entry it) {
        updated.value |= it.apply(linkMap);
      }
    });
    return updated.value;
  }

  public static interface Entry {
    public boolean apply(ModelLinkMap linkMap);
  }

  public static class MoveNode implements StructureModification.Entry {
    public SNodePointer oldID;
    public SNodePointer newID;
    public String resolveInfo;

    public MoveNode(SNodePointer id, SNodePointer to) {
      oldID = id;
      newID = to;
    }

    public boolean apply(ModelLinkMap linkMap) {
      return linkMap.moveNode(oldID, newID);
    }
  }

  public static class RenameNode implements StructureModification.Entry {
    public SNodePointer oldID;
    public StructureModification.RenameNode.RenameType type;
    public String oldValue;
    public String newValue;

    public RenameNode(SNodePointer id, StructureModification.RenameNode.RenameType type, String newValue) {
      oldID = id;
      this.type = type;
      this.newValue = newValue;
    }

    public boolean apply(ModelLinkMap linkMap) {
      switch (type) {
        case CONCEPT:
        case PROPERTY:
          return linkMap.setName(oldID, newValue);
        case CHILD:
        case REFERENCE:
          return linkMap.setRole(oldID, newValue);
        default:
          return false;
      }
    }

    public static     enum RenameType {
      CONCEPT(),
      PROPERTY(),
      CHILD(),
      REFERENCE();

      RenameType() {
      }
    }
  }

  public static class RenameModel implements StructureModification.Entry {
    public SModelReference oldModel;
    public SModelReference newModel;

    public RenameModel() {
    }

    public boolean apply(ModelLinkMap linkMap) {
      return linkMap.updateModelReference(oldModel, newModel);
    }
  }
}
