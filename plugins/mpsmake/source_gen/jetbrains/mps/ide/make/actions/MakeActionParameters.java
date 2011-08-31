package jetbrains.mps.ide.make.actions;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.generator.GeneratorManager;
import jetbrains.mps.smodel.resources.ModelsToResources;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.Generator;

public class MakeActionParameters {
  private IOperationContext context;
  private List<SModelDescriptor> models;
  private SModelDescriptor cmodel;
  private List<IModule> modules;
  private IModule cmodule;

  public MakeActionParameters(IOperationContext context, List<SModelDescriptor> models, SModelDescriptor cmodel, List<IModule> modules, IModule cmodule) {
    this.context = context;
    this.models = (models != null ?
      ListSequence.<SModelDescriptor>fromListWithValues(new ArrayList<SModelDescriptor>(), models) :
      null
    );
    this.cmodel = cmodel;
    this.modules = (modules != null ?
      ListSequence.<IModule>fromListWithValues(new ArrayList<IModule>(), modules) :
      null
    );
    this.cmodule = cmodule;
  }

  public String actionText(boolean cleanMake) {
    StringBuilder sb = new StringBuilder();
    sb.append((cleanMake ?
      "Rebuild " :
      "Make "
    ));
    IModule module = this.moduleToMake();
    SModelDescriptor model = this.modelToMake();
    if (model != null) {
      if (!(model.isGeneratable())) {
        return null;
      }

      sb.append("Model '").append(model.getSModelReference().getSModelFqName().getCompactPresentation()).append("'");

    } else if (this.models != null && ListSequence.<SModelDescriptor>fromList(this.models).count() > 1) {
      Iterable<SModelDescriptor> mds = this.models;
      if (!(Sequence.<SModelDescriptor>fromIterable(mds).any(new IWhereFilter<SModelDescriptor>() {
        public boolean accept(SModelDescriptor md) {
          return md != null && md.isGeneratable();
        }
      }))) {
        return null;
      }

      sb.append("Selected Models");

    } else if (module != null) {
      if (module.isPackaged()) {
        return null;
      }

      sb.append(NameUtil.shortNameFromLongName(module.getClass().getName().replaceAll("\\$.*", ""))).append(" '").append(NameUtil.compactNamespace(module.getModuleReference().getModuleFqName())).append("'");

    } else if (this.modules != null && ListSequence.<IModule>fromList(this.modules).count() > 1) {
      Iterable<IModule> mods = this.modules;
      if (Sequence.<IModule>fromIterable(mods).any(new IWhereFilter<IModule>() {
        public boolean accept(IModule m) {
          return m == null;
        }
      }) || Sequence.<IModule>fromIterable(mods).all(new IWhereFilter<IModule>() {
        public boolean accept(IModule m) {
          return m.isPackaged();
        }
      })) {
        return null;
      }

      sb.append("Selected Modules");

    } else {
      return null;
    }
    return sb.toString();
  }

  public Iterable<IResource> collectInput(boolean dirtyOnly) {
    final IModule module = this.moduleToMake();
    final SModelDescriptor model = this.modelToMake();
    Iterable<SModelDescriptor> smds = Sequence.<SModelDescriptor>fromIterable(Sequence.<SModelDescriptor>fromClosure(new ISequenceClosure<SModelDescriptor>() {
      public Iterable<SModelDescriptor> iterable() {
        return new Iterable<SModelDescriptor>() {
          public Iterator<SModelDescriptor> iterator() {
            return new YieldingIterator<SModelDescriptor>() {
              private int __CP__ = 0;
              private Iterable<SModelDescriptor> _7_models;
              private SModelDescriptor _8__yield_nk3wxj_b0a0a0a0a0c0b;
              private Iterator<SModelDescriptor> _8__yield_nk3wxj_b0a0a0a0a0c0b_it;
              private Iterable<SModelDescriptor> _14_modelsFromModule;
              private SModelDescriptor _15__yield_nk3wxj_c0b0a0a0a0c0b;
              private Iterator<SModelDescriptor> _15__yield_nk3wxj_c0b0a0a0a0c0b_it;
              private Iterable<SModelDescriptor> _21_modelsFromModules;
              private SModelDescriptor _22__yield_nk3wxj_c0c0a0a0a0c0b;
              private Iterator<SModelDescriptor> _22__yield_nk3wxj_c0c0a0a0a0c0b_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 8:
                      this._8__yield_nk3wxj_b0a0a0a0a0c0b_it = Sequence.fromIterable(Sequence.<SModelDescriptor>fromIterable(_7_models).where(new IWhereFilter<SModelDescriptor>() {
                        public boolean accept(SModelDescriptor md) {
                          return md.isGeneratable();
                        }
                      })).iterator();
                    case 9:
                      if (!(this._8__yield_nk3wxj_b0a0a0a0a0c0b_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._8__yield_nk3wxj_b0a0a0a0a0c0b = this._8__yield_nk3wxj_b0a0a0a0a0c0b_it.next();
                      this.__CP__ = 10;
                      break;
                    case 15:
                      this._15__yield_nk3wxj_c0b0a0a0a0c0b_it = Sequence.fromIterable(_14_modelsFromModule).iterator();
                    case 16:
                      if (!(this._15__yield_nk3wxj_c0b0a0a0a0c0b_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._15__yield_nk3wxj_c0b0a0a0a0c0b = this._15__yield_nk3wxj_c0b0a0a0a0c0b_it.next();
                      this.__CP__ = 17;
                      break;
                    case 22:
                      this._22__yield_nk3wxj_c0c0a0a0a0c0b_it = Sequence.fromIterable(_21_modelsFromModules).iterator();
                    case 23:
                      if (!(this._22__yield_nk3wxj_c0c0a0a0a0c0b_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._22__yield_nk3wxj_c0c0a0a0a0c0b = this._22__yield_nk3wxj_c0c0a0a0a0c0b_it.next();
                      this.__CP__ = 24;
                      break;
                    case 2:
                      if (model != null && model.isGeneratable()) {
                        this.__CP__ = 3;
                        break;
                      } else if (models != null && ListSequence.<SModelDescriptor>fromList(models).count() > 1) {
                        this.__CP__ = 5;
                        break;
                      } else if (module != null) {
                        this.__CP__ = 12;
                        break;
                      } else if (modules != null && ListSequence.<IModule>fromList(modules).count() > 1) {
                        this.__CP__ = 19;
                        break;
                      }
                      this.__CP__ = 1;
                      break;
                    case 11:
                      this.__CP__ = 9;
                      this.yield(_8__yield_nk3wxj_b0a0a0a0a0c0b);
                      return true;
                    case 4:
                      this.__CP__ = 1;
                      this.yield(model);
                      return true;
                    case 18:
                      this.__CP__ = 16;
                      this.yield(_15__yield_nk3wxj_c0b0a0a0a0c0b);
                      return true;
                    case 25:
                      this.__CP__ = 23;
                      this.yield(_22__yield_nk3wxj_c0c0a0a0a0c0b);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 5:
                      this._7_models = MakeActionParameters.this.models;
                      this.__CP__ = 8;
                      break;
                    case 10:
                      this.__CP__ = 11;
                      break;
                    case 3:
                      this.__CP__ = 4;
                      break;
                    case 12:
                      ModelAccess.instance().runReadAction(new Runnable() {
                        public void run() {
                          _14_modelsFromModule = modelsToMake(module);
                        }
                      });
                      this.__CP__ = 15;
                      break;
                    case 17:
                      this.__CP__ = 18;
                      break;
                    case 19:
                      this._21_modelsFromModules = null;
                      ModelAccess.instance().runReadAction(new Runnable() {
                        public void run() {
                          for (IModule mod : ListSequence.<IModule>fromList(MakeActionParameters.this.modules)) {
                            _21_modelsFromModules = Sequence.<SModelDescriptor>fromIterable(_21_modelsFromModules).concat(Sequence.<SModelDescriptor>fromIterable(modelsToMake(mod)));
                          }
                        }
                      });
                      this.__CP__ = 22;
                      break;
                    case 24:
                      this.__CP__ = 25;
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
    })).where(new IWhereFilter<SModelDescriptor>() {
      public boolean accept(SModelDescriptor md) {
        return !(GeneratorManager.isDoNotGenerate(md));
      }
    });
    return new ModelsToResources(context, Sequence.<SModelDescriptor>fromIterable(smds).toListSequence()).resources(dirtyOnly);
  }

  public Iterable<SModelDescriptor> modelsToMake(IModule module) {
    Iterable<SModelDescriptor> models = Sequence.<SModelDescriptor>fromIterable(((Iterable<SModelDescriptor>) module.getOwnModelDescriptors())).where(new IWhereFilter<SModelDescriptor>() {
      public boolean accept(SModelDescriptor it) {
        return it.isGeneratable();
      }
    });
    if (module instanceof Language) {
      for (Generator gen : ListSequence.<Generator>fromList(((Language) module).getGenerators())) {
        models = Sequence.<SModelDescriptor>fromIterable(models).concat(Sequence.<SModelDescriptor>fromIterable(modelsToMake(gen)));
      }
    }
    return models;
  }

  private IModule moduleToMake() {
    Iterable<IModule> modulesSeq = ((Iterable<IModule>) this.modules);
    if (Sequence.<IModule>fromIterable(modulesSeq).count() == 1) {
      return Sequence.<IModule>fromIterable(modulesSeq).first();
    } else if (Sequence.<IModule>fromIterable(modulesSeq).count() > 1) {
      return null;
    }
    return this.cmodule;
  }

  private SModelDescriptor modelToMake() {
    Iterable<SModelDescriptor> modelsSeq = ((Iterable<SModelDescriptor>) this.models);
    if (Sequence.<SModelDescriptor>fromIterable(modelsSeq).count() == 1) {
      return Sequence.<SModelDescriptor>fromIterable(modelsSeq).first();
    } else if (Sequence.<SModelDescriptor>fromIterable(modelsSeq).count() > 1) {
      return null;
    }
    return this.cmodel;
  }
}
