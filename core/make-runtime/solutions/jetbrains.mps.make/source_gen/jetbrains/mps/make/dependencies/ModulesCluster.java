package jetbrains.mps.make.dependencies;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.List;
import java.util.Iterator;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.IListSequence;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.project.dependency.GlobalModuleDependenciesManager;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.internal.collections.runtime.CollectionSequence;
import jetbrains.mps.project.DevKit;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.internal.make.runtime.util.GraphAnalyzer;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class ModulesCluster {
  private Map<ModuleReference, IModule> modulesView = MapSequence.fromMap(new HashMap<ModuleReference, IModule>());
  private Map<ModuleReference, ModulesCluster.ModuleDeps> allDeps = MapSequence.fromMap(new HashMap<ModuleReference, ModulesCluster.ModuleDeps>());

  public ModulesCluster(Iterable<IModule> mods) {
    addAll(mods);
  }

  public void add(IModule mod) {
    this.primAdd(mod);
  }

  public void addAll(Iterable<IModule> mods) {
    for (IModule mod : mods) {
      primAdd(mod);
    }
  }

  public void collectRequired(Iterable<IModule> pool) {
    Set<ModuleReference> allRequired = SetSequence.fromSetWithValues(new HashSet<ModuleReference>(), Sequence.fromIterable(MapSequence.fromMap(allDeps).values()).translate(new ITranslator2<ModulesCluster.ModuleDeps, ModuleReference>() {
      public Iterable<ModuleReference> translate(ModulesCluster.ModuleDeps dep) {
        return dep.required;
      }
    }));
    List<IModule> available = Sequence.fromIterable(pool).toListSequence();
    int atSize;
    do {
      atSize = MapSequence.fromMap(allDeps).count();
      for (Iterator<IModule> it = ListSequence.fromList(available).iterator(); it.hasNext();) {
        IModule mod = it.next();
        ModuleReference mr = mod.getModuleReference();
        if (SetSequence.fromSet(allRequired).contains(mr)) {
          primAdd(mod);
          SetSequence.fromSet(allRequired).addSequence(ListSequence.fromList(MapSequence.fromMap(allDeps).get(mr).required));
          it.remove();
        }
      }
    } while (atSize < MapSequence.fromMap(allDeps).count());
  }

  public void collectAllRequired() {
  }

  public boolean hasCycles() {
    return ListSequence.fromList(new ModulesCluster.ModulesGraph().findCycles()).isNotEmpty();
  }

  public Iterable<? extends Iterable<IModule>> buildOrder() {
    List<List<ModuleReference>> order = new ModulesCluster.ModulesGraph().totalOrder();
    Iterable<? extends Iterable<ModuleReference>> compacted = Sequence.fromIterable(this.compact(order)).toListSequence();
    return Sequence.fromIterable(compacted).select(new ISelector<Iterable<ModuleReference>, IListSequence<IModule>>() {
      public IListSequence<IModule> select(Iterable<ModuleReference> cycle) {
        return Sequence.fromIterable(cycle).select(new ISelector<ModuleReference, IModule>() {
          public IModule select(ModuleReference mr) {
            return MapSequence.fromMap(modulesView).get(mr);
          }
        }).toListSequence();
      }
    }).toListSequence();
  }

  private Iterable<Iterable<ModuleReference>> compact(List<List<ModuleReference>> order) {
    final Wrappers._T<Iterable<ModuleReference>> prev = new Wrappers._T<Iterable<ModuleReference>>(null);
    return ListSequence.fromList(order).concat(Sequence.fromIterable(Sequence.<List<ModuleReference>>singleton(null))).translate(new ITranslator2<List<ModuleReference>, Iterable<ModuleReference>>() {
      public Iterable<Iterable<ModuleReference>> translate(final List<ModuleReference> cycle) {
        return new Iterable<Iterable<ModuleReference>>() {
          public Iterator<Iterable<ModuleReference>> iterator() {
            return new YieldingIterator<Iterable<ModuleReference>>() {
              private int __CP__ = 0;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      if (cycle == null) {
                        this.__CP__ = 3;
                        break;
                      } else if (prev.value == null) {
                        this.__CP__ = 6;
                        break;
                      }
                      this.__CP__ = 8;
                      break;
                    case 9:
                      if (ListSequence.fromList(cycle).translate(new ITranslator2<ModuleReference, ModuleReference>() {
                        public Iterable<ModuleReference> translate(ModuleReference mr) {
                          return MapSequence.fromMap(allDeps).get(mr).required;
                        }
                      }).intersect(Sequence.fromIterable(prev.value).translate(new ITranslator2<ModuleReference, ModuleReference>() {
                        public Iterable<ModuleReference> translate(ModuleReference mr) {
                          return MapSequence.fromMap(allDeps).get(mr).dependent;
                        }
                      })).isEmpty()) {
                        this.__CP__ = 10;
                        break;
                      }
                      this.__CP__ = 12;
                      break;
                    case 4:
                      this.__CP__ = 5;
                      this.yield(prev.value);
                      return true;
                    case 13:
                      this.__CP__ = 14;
                      this.yield(prev.value);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 3:
                      this.__CP__ = 4;
                      break;
                    case 5:
                      prev.value = null;
                      this.__CP__ = 1;
                      break;
                    case 6:
                      prev.value = ListSequence.fromList(cycle).toListSequence();
                      this.__CP__ = 1;
                      break;
                    case 8:
                      this.__CP__ = 9;
                      break;
                    case 10:
                      prev.value = Sequence.fromIterable(prev.value).concat(ListSequence.fromList(cycle).toListSequence());
                      this.__CP__ = 1;
                      break;
                    case 12:
                      this.__CP__ = 13;
                      break;
                    case 14:
                      prev.value = ListSequence.fromList(cycle).toListSequence();
                      this.__CP__ = 1;
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

  private boolean isDirty(IModule mod) {
    return false;
  }

  private void primAdd(IModule mod) {
    ModuleReference mr = mod.getModuleReference();
    if (!(MapSequence.fromMap(modulesView).containsKey(mr))) {
      MapSequence.fromMap(modulesView).put(mr, mod);
      updateDeps(mod);
    }
  }

  public void updateDeps(IModule mod) {
    ModuleReference mr = mod.getModuleReference();
    ModulesCluster.ModuleDeps deps = MapSequence.fromMap(allDeps).get(mr);
    if (deps == null) {
      deps = new ModulesCluster.ModuleDeps(mr);
      MapSequence.fromMap(allDeps).put(mr, deps);
    }
    ListSequence.fromList(deps.required).addSequence(Sequence.fromIterable(required(mod)));
    for (ModuleReference req : deps.required) {
      if (MapSequence.fromMap(allDeps).containsKey(req)) {
        ListSequence.fromList(MapSequence.fromMap(allDeps).get(req).dependent).addElement(mr);
      }
    }
    for (IMapping<ModuleReference, ModulesCluster.ModuleDeps> m : MapSequence.fromMap(allDeps).mappingsSet()) {
      if (ListSequence.fromList(m.value().required).contains(mr) && !(ListSequence.fromList(deps.dependent).contains(m.key()))) {
        ListSequence.fromList(deps.dependent).addElement(m.key());
      }
    }
  }

  private Iterable<ModuleReference> required(IModule mod) {
    GlobalModuleDependenciesManager depman = new GlobalModuleDependenciesManager(mod);
    Set<IModule> reqmods = SetSequence.fromSetWithValues(new HashSet<IModule>(), Sequence.fromIterable(((Iterable<Language>) depman.getUsedLanguages())).translate(new ITranslator2<Language, Generator>() {
      public Iterable<Generator> translate(Language lang) {
        return lang.getGenerators();
      }
    }));
    SetSequence.fromSet(reqmods).addSequence(CollectionSequence.fromCollection(depman.getModules(GlobalModuleDependenciesManager.Deptype.COMPILE)));
    SetSequence.fromSet(reqmods).addSequence(CollectionSequence.fromCollection(depman.getModules(GlobalModuleDependenciesManager.Deptype.VISIBLE)));
    Iterable<ModuleReference> reqs = SetSequence.fromSet(reqmods).select(new ISelector<IModule, ModuleReference>() {
      public ModuleReference select(IModule m) {
        return m.getModuleReference();
      }
    });
    if (mod instanceof Generator) {
      reqs = Sequence.fromIterable(reqs).concat(Sequence.fromIterable(Sequence.<ModuleReference>singleton(((Generator) mod).getSourceLanguage().getModuleReference())));
    } else if (mod instanceof Language) {
    } else if (mod instanceof DevKit) {
    } else {
    }
    return Sequence.fromIterable(reqs).distinct().toListSequence();
  }

  public static class ModuleDeps {
    private List<ModuleReference> dependent = ListSequence.fromList(new LinkedList<ModuleReference>());
    private List<ModuleReference> required = ListSequence.fromList(new LinkedList<ModuleReference>());

    public ModuleDeps(ModuleReference mod) {
      ListSequence.fromList(dependent).addElement(mod);
      ListSequence.fromList(required).addElement(mod);
    }
  }

  public class ModulesGraph extends GraphAnalyzer<ModuleReference> {
    public ModulesGraph() {
    }

    public Iterable<ModuleReference> forwardEdges(ModuleReference v) {
      return ListSequence.fromList(MapSequence.fromMap(allDeps).get(v).dependent).where(new IWhereFilter<ModuleReference>() {
        public boolean accept(ModuleReference mod) {
          return MapSequence.fromMap(allDeps).containsKey(mod);
        }
      });
    }

    public Iterable<ModuleReference> backwardEdges(ModuleReference v) {
      return ListSequence.fromList(MapSequence.fromMap(allDeps).get(v).required).where(new IWhereFilter<ModuleReference>() {
        public boolean accept(ModuleReference mod) {
          return MapSequence.fromMap(allDeps).containsKey(mod);
        }
      });
    }

    public Iterable<ModuleReference> vertices() {
      return MapSequence.fromMap(allDeps).keySet();
    }
  }
}
