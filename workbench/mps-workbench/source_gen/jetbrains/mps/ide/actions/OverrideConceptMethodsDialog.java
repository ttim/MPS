package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.ide.util.GroupedNodesChooser;
import javax.swing.JCheckBox;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.openapi.project.Project;
import jetbrains.mps.plugins.projectplugins.ProjectPluginManager;
import com.intellij.ui.NonFocusableCheckBox;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Comparator;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class OverrideConceptMethodsDialog extends GroupedNodesChooser {
  private JCheckBox myRemoveAttributes;
  private JCheckBox myAddReturn;
  private BehaviorDialogsPersistentOptions_PreferencesComponent myOptions;

  public OverrideConceptMethodsDialog(SNodePointer[] methods, Project project) {
    super(methods, false, true, project);
  }

  @Override
  protected void initOptions() {
    try {
      myOptions = myProject.getComponent(ProjectPluginManager.class).getPrefsComponent(BehaviorDialogsPersistentOptions_PreferencesComponent.class);
    } catch (Exception e) {
      myOptions = null;
    }

    myAddReturn = new NonFocusableCheckBox("Add return keyword");
    myAddReturn.setMnemonic('r');
    myRemoveAttributes = new NonFocusableCheckBox("Remove Attributes");
    myRemoveAttributes.setMnemonic('t');
    myOptionControls = new JCheckBox[]{myAddReturn, myRemoveAttributes};
  }

  protected boolean showInsertOverride() {
    return true;
  }

  @Override
  protected String getText(SNode node) {
    if (SNodeOperations.isInstanceOf(node, "jetbrains.mps.lang.behavior.structure.ConceptBehavior")) {
      SNode concept = SLinkOperations.getTarget(SNodeOperations.cast(node, "jetbrains.mps.lang.behavior.structure.ConceptBehavior"), "concept", false);
      if ((concept != null)) {
        return ((String) BehaviorManager.getInstance().invoke(Object.class, concept, "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
      }
    }
    return super.getText(node);
  }

  @Override
  protected void customizeOptionsPanel() {
    myAddReturn.setSelected((myOptions != null ?
      myOptions.getStateObject().addReturnsOnImplement :
      false
    ));
    myRemoveAttributes.setSelected((myOptions != null ?
      myOptions.getStateObject().removeAttributes :
      true
    ));
  }

  public boolean isAddReturn() {
    return myAddReturn.isSelected();
  }

  public boolean isRemoveAttributes() {
    return myRemoveAttributes.isSelected();
  }

  @Override
  public void dispose() {
    if (myOptions != null) {
      myOptions.getStateObject().addReturnsOnImplement = myAddReturn.isSelected();
      myOptions.getStateObject().removeAttributes = myRemoveAttributes.isSelected();
    }
    super.dispose();
  }

  public static Iterable<SNode> sortMethods(SNode baseClass, Iterable<SNode> methods) {
    final Map<SNode, Integer> containerIndex = MapSequence.fromMap(new HashMap<SNode, Integer>());
    int i = 1;
    for (SNode c : ((List<SNode>) BehaviorManager.getInstance().invoke(Object.class, baseClass, "call_getAllSuperBehaviors_1818770337282950280", new Class[]{SNode.class}))) {
      MapSequence.fromMap(containerIndex).put(c, i++);
    }
    return Sequence.fromIterable(methods).sort(new Comparator<SNode>() {
      public int compare(SNode a, SNode b) {
        SNode parentA = SNodeOperations.getParent(a);
        SNode parentB = SNodeOperations.getParent(b);
        if (parentA == parentB) {
          return new Integer(parentA.getIndexOfChild(a)).compareTo(parentB.getIndexOfChild(b));
        }
        int iA = (parentA != null && MapSequence.fromMap(containerIndex).containsKey(parentA) ?
          MapSequence.fromMap(containerIndex).get(parentA) :
          0
        );
        int iB = (parentB != null && MapSequence.fromMap(containerIndex).containsKey(parentB) ?
          MapSequence.fromMap(containerIndex).get(parentB) :
          0
        );
        return new Integer(iA).compareTo(iB);
      }
    }, true);
  }

  public static SNodePointer[] toNodePointers(Iterable<SNode> methods) {
    return Sequence.fromIterable(methods).select(new ISelector<SNode, SNodePointer>() {
      public SNodePointer select(SNode it) {
        return new SNodePointer(it);
      }
    }).toGenericArray(SNodePointer.class);
  }
}
