package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import java.util.Set;
import com.intellij.openapi.util.Pair;
import jetbrains.mps.workbench.ActionPlace;
import jetbrains.mps.util.Condition;
import jetbrains.mps.workbench.action.BaseAction;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import com.intellij.openapi.actionSystem.AnActionEvent;
import jetbrains.mps.intentions.IntentionsManager;
import jetbrains.mps.intentions.SurroundWithIntention;
import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.intentions.Intention;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.workbench.MPSDataKeys;
import jetbrains.mps.nodeEditor.EditorContext;
import java.util.Collection;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import java.util.Comparator;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import com.intellij.openapi.extensions.PluginId;
import org.jetbrains.annotations.Nullable;

public class SurroundWithIntentions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(SurroundWithIntentions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.SurroundWithIntentions_ActionGroup";

  private Set<Pair<ActionPlace, Condition<BaseAction>>> myPlaces = SetSequence.fromSet(new HashSet<Pair<ActionPlace, Condition<BaseAction>>>());

  public SurroundWithIntentions_ActionGroup() {
    super("SurroundWithIntentions", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void doUpdate(AnActionEvent event) {
    try {
      SurroundWithIntentions_ActionGroup.this.removeAll();

      IntentionsManager.QueryDescriptor query = new IntentionsManager.QueryDescriptor();
      query.setIntentionClass(SurroundWithIntention.class);
      query.setInstantiate(true);
      query.setCurrentNodeOnly(true);

      List<Tuples._2<Intention, SNode>> groupItems = ListSequence.fromList(new ArrayList<Tuples._2<Intention, SNode>>());
      SNode node = event.getData(MPSDataKeys.NODE);
      final EditorContext context = event.getData(MPSDataKeys.EDITOR_CONTEXT);

      Collection<Pair<Intention, SNode>> intentions = IntentionsManager.getInstance().getAvailableIntentions(query, node, context);
      for (Pair<Intention, SNode> pair : Sequence.fromIterable(intentions)) {
        ListSequence.fromList(groupItems).addElement(MultiTuple.<Intention,SNode>from(pair.getFirst(), pair.getSecond()));
      }
      if (ListSequence.fromList(groupItems).isEmpty()) {
        return;
      }

      ListSequence.fromList(groupItems).sort(new Comparator<Tuples._2<Intention, SNode>>() {
        public int compare(Tuples._2<Intention, SNode> a, Tuples._2<Intention, SNode> b) {
          return a._0().getDescription(a._1(), context).compareTo(b._0().getDescription(b._1(), context));
        }
      }, true).visitAll(new IVisitor<Tuples._2<Intention, SNode>>() {
        public void visit(Tuples._2<Intention, SNode> it) {
          SurroundWithIntentions_ActionGroup.this.addParameterizedAction(new SurroundIntentionAction_Action((SurroundWithIntention) it._0(), it._1()), PluginId.getId("jetbrains.mps.ide"), (SurroundWithIntention) it._0(), it._1());
        }
      });
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
    for (Pair<ActionPlace, Condition<BaseAction>> p : this.myPlaces) {
      this.addPlace(p.first, p.second);
    }
  }

  public void addPlace(ActionPlace place, @Nullable Condition<BaseAction> cond) {
    SetSequence.fromSet(this.myPlaces).addElement(new Pair<ActionPlace, Condition<BaseAction>>(place, cond));
  }

  public boolean isStrict() {
    return false;
  }
}
