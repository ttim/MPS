package jetbrains.mps.make.runtime.script;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.make.runtime.ITarget;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.make.runtime.ITask;
import jetbrains.mps.make.runtime.IProducer;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.make.runtime.internal.util.GraphAnalyzer;

public class TargetRange {
  private Map<ITarget.Name, ITarget> targetsView = MapSequence.fromMap(new HashMap<ITarget.Name, ITarget>());
  private Set<ITarget> allTargets = SetSequence.fromSet(new HashSet<ITarget>());
  private Map<ITarget.Name, TargetRange.TargetRefs> allRefs = MapSequence.fromMap(new HashMap<ITarget.Name, TargetRange.TargetRefs>());

  public TargetRange() {
  }

  public void addTarget(ITarget trg) {
    if (!(SetSequence.fromSet(allTargets).contains(trg))) {
      trg = this.primAddTarget(trg);
      SetSequence.fromSet(allTargets).addElement(trg);
      this.updateRefs(trg);
    }
  }

  public void addRelated(Iterable<ITarget> availableTargets) {
    Set<ITarget.Name> valences = SetSequence.fromSetWithValues(new HashSet<ITarget.Name>(), Sequence.fromIterable(MapSequence.fromMap(targetsView).values()).translate(new ITranslator2<ITarget, ITarget.Name>() {
      public Iterable<ITarget.Name> translate(final ITarget trg) {
        return new Iterable<ITarget.Name>() {
          public Iterator<ITarget.Name> iterator() {
            return new YieldingIterator<ITarget.Name>() {
              private int __CP__ = 0;
              private ITarget.Name _2__yield_vyrmkm_a0a0b0a0a1;
              private Iterator<ITarget.Name> _2__yield_vyrmkm_a0a0b0a0a1_it;
              private ITarget.Name _6__yield_vyrmkm_b0a0b0a0a1;
              private Iterator<ITarget.Name> _6__yield_vyrmkm_b0a0b0a0a1_it;
              private ITarget.Name _10__yield_vyrmkm_c0a0b0a0a1;
              private Iterator<ITarget.Name> _10__yield_vyrmkm_c0a0b0a0a1_it;
              private ITarget.Name _14__yield_vyrmkm_d0a0b0a0a1;
              private Iterator<ITarget.Name> _14__yield_vyrmkm_d0a0b0a0a1_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2__yield_vyrmkm_a0a0b0a0a1_it = trg.before().iterator();
                    case 3:
                      if (!(this._2__yield_vyrmkm_a0a0b0a0a1_it.hasNext())) {
                        this.__CP__ = 5;
                        break;
                      }
                      this._2__yield_vyrmkm_a0a0b0a0a1 = this._2__yield_vyrmkm_a0a0b0a0a1_it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this._6__yield_vyrmkm_b0a0b0a0a1_it = trg.notBefore().iterator();
                    case 7:
                      if (!(this._6__yield_vyrmkm_b0a0b0a0a1_it.hasNext())) {
                        this.__CP__ = 9;
                        break;
                      }
                      this._6__yield_vyrmkm_b0a0b0a0a1 = this._6__yield_vyrmkm_b0a0b0a0a1_it.next();
                      this.__CP__ = 8;
                      break;
                    case 9:
                      this._10__yield_vyrmkm_c0a0b0a0a1_it = trg.after().iterator();
                    case 11:
                      if (!(this._10__yield_vyrmkm_c0a0b0a0a1_it.hasNext())) {
                        this.__CP__ = 13;
                        break;
                      }
                      this._10__yield_vyrmkm_c0a0b0a0a1 = this._10__yield_vyrmkm_c0a0b0a0a1_it.next();
                      this.__CP__ = 12;
                      break;
                    case 13:
                      this._14__yield_vyrmkm_d0a0b0a0a1_it = trg.notAfter().iterator();
                    case 15:
                      if (!(this._14__yield_vyrmkm_d0a0b0a0a1_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._14__yield_vyrmkm_d0a0b0a0a1 = this._14__yield_vyrmkm_d0a0b0a0a1_it.next();
                      this.__CP__ = 16;
                      break;
                    case 6:
                      this.__CP__ = 3;
                      this.yield(_2__yield_vyrmkm_a0a0b0a0a1);
                      return true;
                    case 10:
                      this.__CP__ = 7;
                      this.yield(_6__yield_vyrmkm_b0a0b0a0a1);
                      return true;
                    case 14:
                      this.__CP__ = 11;
                      this.yield(_10__yield_vyrmkm_c0a0b0a0a1);
                      return true;
                    case 17:
                      this.__CP__ = 15;
                      this.yield(_14__yield_vyrmkm_d0a0b0a0a1);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 6;
                      break;
                    case 8:
                      this.__CP__ = 10;
                      break;
                    case 12:
                      this.__CP__ = 14;
                      break;
                    case 16:
                      this.__CP__ = 17;
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
    }));
    List<ITarget> available = Sequence.fromIterable(availableTargets).toListSequence();
    int atsize;
    do {
      atsize = SetSequence.fromSet(allTargets).count();
      for (Iterator<ITarget> it = ListSequence.fromList(available).iterator(); it.hasNext();) {
        ITarget trg = it.next();
        Iterable<ITarget.Name> trgval = Sequence.fromIterable(trg.before()).concat(Sequence.fromIterable(trg.notBefore())).concat(Sequence.fromIterable(trg.after())).concat(Sequence.fromIterable(trg.notAfter()));
        if (SetSequence.fromSet(valences).contains(trg.getName()) || Sequence.fromIterable(trgval).any(new IWhereFilter<ITarget.Name>() {
          public boolean accept(ITarget.Name tn) {
            return MapSequence.fromMap(targetsView).containsKey(tn);
          }
        })) {
          addTarget(trg);
          SetSequence.fromSet(valences).addSequence(Sequence.fromIterable(trgval));
          it.remove();
        }
      }
    } while (atsize < SetSequence.fromSet(allTargets).count());
  }

  public ITarget getTarget(ITarget.Name name) {
    return MapSequence.fromMap(targetsView).get(name);
  }

  public boolean hasTarget(ITarget.Name name) {
    return MapSequence.fromMap(targetsView).containsKey(name);
  }

  public Iterable<ITarget> sortedTargets() {
    return Sequence.fromIterable(new TargetRange.TargetsGraph().topologicalSort()).select(new ISelector<ITarget.Name, ITarget>() {
      public ITarget select(ITarget.Name tn) {
        return MapSequence.fromMap(targetsView).get(tn);
      }
    });
  }

  public boolean hasCycles() {
    return ListSequence.fromList(new TargetRange.TargetsGraph().findCycles()).isNotEmpty();
  }

  public List<List<ITarget.Name>> cycles() {
    return new TargetRange.TargetsGraph().findCycles();
  }

  private ITarget primAddTarget(ITarget trg) {
    ITarget prev = MapSequence.fromMap(targetsView).get(trg.getName());
    if (prev != null) {
      trg = new TargetRange.CompositeTarget(trg, prev);
    }
    MapSequence.fromMap(targetsView).put(trg.getName(), trg);
    return trg;
  }

  private void updateRefs(ITarget trg) {
    TargetRange.TargetRefs refs = MapSequence.fromMap(allRefs).get(trg.getName());
    if (refs == null) {
      refs = new TargetRange.TargetRefs();
      MapSequence.fromMap(allRefs).put(trg.getName(), refs);
    }
    ListSequence.fromList(refs.before).addSequence(Sequence.fromIterable(trg.before()).concat(Sequence.fromIterable(trg.notAfter())));
    ListSequence.fromList(refs.after).addSequence(Sequence.fromIterable(trg.after()).concat(Sequence.fromIterable(trg.notBefore())));
    for (ITarget.Name bf : ListSequence.fromList(refs.before)) {
      if (MapSequence.fromMap(allRefs).containsKey(bf)) {
        ListSequence.fromList(MapSequence.fromMap(allRefs).get(bf).after).addElement(trg.getName());
      }
    }
    for (ITarget.Name bf : ListSequence.fromList(refs.after)) {
      if (MapSequence.fromMap(allRefs).containsKey(bf)) {
        ListSequence.fromList(MapSequence.fromMap(allRefs).get(bf).before).addElement(trg.getName());
      }
    }
    for (IMapping<ITarget.Name, TargetRange.TargetRefs> m : MapSequence.fromMap(allRefs)) {
      if (ListSequence.fromList(m.value().before).contains(trg.getName()) && !(ListSequence.fromList(refs.after).contains(m.key()))) {
        ListSequence.fromList(refs.after).addElement(m.key());
      }
      if (ListSequence.fromList(m.value().after).contains(trg.getName()) && !(ListSequence.fromList(refs.before).contains(m.key()))) {
        ListSequence.fromList(refs.before).addElement(m.key());
      }
    }
  }

  public static class CompositeTarget implements ITarget {
    private ITarget first;
    private ITarget second;

    public CompositeTarget(ITarget first, ITarget second) {
      assert first.getName().equals(second.getName());
      this.first = first;
      this.second = second;
    }

    public Iterable<ITask> tasks() {
      return Sequence.fromIterable(first.tasks()).concat(Sequence.fromIterable(second.tasks()));
    }

    public Iterable<ITarget.Name> notAfter() {
      return Sequence.fromIterable(first.notAfter()).concat(Sequence.fromIterable(second.notAfter()));
    }

    public Iterable<ITarget.Name> after() {
      return Sequence.fromIterable(first.after()).concat(Sequence.fromIterable(second.after()));
    }

    public Iterable<ITarget.Name> notBefore() {
      return Sequence.fromIterable(first.notBefore()).concat(Sequence.fromIterable(second.notBefore()));
    }

    public Iterable<ITarget.Name> before() {
      return Sequence.fromIterable(first.before()).concat(Sequence.fromIterable(second.before()));
    }

    public IProducer producer() {
      return null;
    }

    public jetbrains.mps.make.runtime.ISelector selector() {
      return null;
    }

    public ITarget.Name getName() {
      return first.getName();
    }
  }

  private static class TargetRefs {
    private List<ITarget.Name> before = ListSequence.fromList(new LinkedList<ITarget.Name>());
    private List<ITarget.Name> after = ListSequence.fromList(new LinkedList<ITarget.Name>());

    public TargetRefs() {
    }
  }

  private class TargetsGraph extends GraphAnalyzer<ITarget.Name> {
    public TargetsGraph() {
    }

    @Override
    public Iterable<ITarget.Name> backwardEdges(ITarget.Name v) {
      return ListSequence.fromList(MapSequence.fromMap(allRefs).get(v).after).where(new IWhereFilter<ITarget.Name>() {
        public boolean accept(ITarget.Name tn) {
          return MapSequence.fromMap(allRefs).containsKey(tn);
        }
      });
    }

    @Override
    public Iterable<ITarget.Name> forwardEdges(ITarget.Name v) {
      return ListSequence.fromList(MapSequence.fromMap(allRefs).get(v).before).where(new IWhereFilter<ITarget.Name>() {
        public boolean accept(ITarget.Name tn) {
          return MapSequence.fromMap(allRefs).containsKey(tn);
        }
      });
    }

    @Override
    public Iterable<ITarget.Name> vertices() {
      return MapSequence.fromMap(allRefs).keySet();
    }
  }
}
