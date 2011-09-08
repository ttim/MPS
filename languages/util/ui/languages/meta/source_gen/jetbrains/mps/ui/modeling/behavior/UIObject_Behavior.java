package jetbrains.mps.ui.modeling.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class UIObject_Behavior {
  public static void init(SNode thisNode) {
  }

  public static Iterable<SNode> call_allExtends_8115675450774407592(final SNode thisNode) {
    return Sequence.fromClosure(new ISequenceClosure<SNode>() {
      public Iterable<SNode> iterable() {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _2_uio;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_uio = thisNode;
                    case 3:
                      if (!((_2_uio != null))) {
                        this.__CP__ = 1;
                        break;
                      }
                      this.__CP__ = 4;
                      break;
                    case 5:
                      _2_uio = SLinkOperations.getTarget(_2_uio, "extends", false);
                      this.__CP__ = 3;
                      break;
                    case 6:
                      this.__CP__ = 5;
                      this.yield(_2_uio);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
                      break;
                    default:
                      break __loop__;
                  }
                } while (true);
                return false;
              }
            };
          }
        };
      }
    });
  }

  public static SNode call_actuallyBelongsTo_1719339442171687163(SNode thisNode) {
    if ((SLinkOperations.getTarget(thisNode, "belongsTo", false) != null)) {
      return SLinkOperations.getTarget(thisNode, "belongsTo", false);
    }
    return ((SLinkOperations.getTarget(thisNode, "extends", false) != null) ?
      UIObject_Behavior.call_actuallyBelongsTo_1719339442171687163(SLinkOperations.getTarget(thisNode, "extends", false)) :
      null
    );
  }

  public static SNode call_mustBelongTo_1719339442171055203(SNode thisNode) {
    return Sequence.fromIterable(UIObject_Behavior.call_allExtends_8115675450774407592(thisNode)).skip(1).select(new ISelector<SNode, SNode>() {
      public SNode select(SNode o) {
        return SLinkOperations.getTarget(o, "belongsTo", false);
      }
    }).findFirst(new IWhereFilter<SNode>() {
      public boolean accept(SNode bt) {
        return (bt != null);
      }
    });
  }

  public static SNode virtual_findTemplate_3939571372331676060(SNode thisNode, SModel model, IScope scope) {
    final List<SNode> ael = Sequence.fromIterable(UIObject_Behavior.call_allExtends_8115675450774407592(thisNode)).toListSequence();
    return ListSequence.fromList(SModelOperations.getNodesIncludingImported(model, scope, "jetbrains.mps.ui.modeling.structure.UIObjectTemplate")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode tpl) {
        return ListSequence.fromList(ael).contains(SLinkOperations.getTarget(tpl, "uiObject", false));
      }
    }).sort(new ISelector<SNode, Comparable<?>>() {
      public Comparable<?> select(SNode tpl) {
        return ListSequence.fromList(ael).indexOf(SLinkOperations.getTarget(tpl, "uiObject", false));
      }
    }, true).first();
  }
}
