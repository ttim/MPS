package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.smodel.resources.MResource;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.Generator;
import jetbrains.mps.internal.collections.runtime.ISequenceClosure;
import jetbrains.mps.make.delta.IDelta;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.internal.make.runtime.util.FilesDelta;
import jetbrains.mps.generator.fileGenerator.FileGenerationUtil;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class RetainedUtil {
  public RetainedUtil() {
  }

  /*package*/ static Map<IModule, Iterable<SModelDescriptor>> collectModelsToRetain(Iterable<IResource> input) {
    final Map<IModule, Iterable<SModelDescriptor>> retainedModels = MapSequence.fromMap(new HashMap<IModule, Iterable<SModelDescriptor>>());
    Iterable<SModelDescriptor> empty = ListSequence.fromList(new ArrayList<SModelDescriptor>());
    for (IResource it : input) {
      MResource mres = ((MResource) it);
      IModule module = mres.module();
      MapSequence.fromMap(retainedModels).put(module, empty);
      Iterable<SModelDescriptor> modelsToRetain = Sequence.fromIterable(((Iterable<SModelDescriptor>) module.getOwnModelDescriptors())).where(new IWhereFilter<SModelDescriptor>() {
        public boolean accept(SModelDescriptor it2) {
          return it2.isGeneratable();
        }
      });
      if (module instanceof Language) {
        for (final Generator gen : ((Language) module).getGenerators()) {
          if (!(MapSequence.fromMap(retainedModels).containsKey(gen))) {
            MapSequence.fromMap(retainedModels).put(gen, Sequence.fromIterable(((Iterable<SModelDescriptor>) gen.getOwnModelDescriptors())).where(new IWhereFilter<SModelDescriptor>() {
              public boolean accept(SModelDescriptor it2) {
                return it2.isGeneratable();
              }
            }));
          }
          modelsToRetain = Sequence.fromIterable(modelsToRetain).concat(Sequence.fromIterable(Sequence.fromClosure(new ISequenceClosure<SModelDescriptor>() {
            public Iterable<SModelDescriptor> iterable() {
              return MapSequence.fromMap(retainedModels).get(gen);
            }
          })));
        }
      } else if (module instanceof Generator) {
        final Language slang = ((Generator) module).getSourceLanguage();
        if (!(MapSequence.fromMap(retainedModels).containsKey(slang))) {
          MapSequence.fromMap(retainedModels).put(slang, Sequence.fromIterable(((Iterable<SModelDescriptor>) slang.getOwnModelDescriptors())).subtract(ListSequence.fromList(module.getOwnModelDescriptors())).where(new IWhereFilter<SModelDescriptor>() {
            public boolean accept(SModelDescriptor it3) {
              return it3.isGeneratable();
            }
          }));
        }
        for (final Generator gen : slang.getGenerators()) {
          if (gen == module) {
            continue;
          }
          if (!(MapSequence.fromMap(retainedModels).containsKey(gen))) {
            MapSequence.fromMap(retainedModels).put(gen, Sequence.fromIterable(((Iterable<SModelDescriptor>) gen.getOwnModelDescriptors())).where(new IWhereFilter<SModelDescriptor>() {
              public boolean accept(SModelDescriptor it2) {
                return it2.isGeneratable();
              }
            }));
          }
          modelsToRetain = Sequence.fromIterable(modelsToRetain).concat(Sequence.fromIterable(Sequence.fromClosure(new ISequenceClosure<SModelDescriptor>() {
            public Iterable<SModelDescriptor> iterable() {
              return MapSequence.fromMap(retainedModels).get(gen);
            }
          })));
        }
        modelsToRetain = Sequence.fromIterable(modelsToRetain).concat(Sequence.fromIterable(Sequence.fromClosure(new ISequenceClosure<SModelDescriptor>() {
          public Iterable<SModelDescriptor> iterable() {
            return MapSequence.fromMap(retainedModels).get(slang);
          }
        })));
      }
      MapSequence.fromMap(retainedModels).put(mres.module(), Sequence.fromIterable(modelsToRetain).subtract(Sequence.fromIterable(mres.models())).toListSequence());
    }
    return retainedModels;
  }

  public static Iterable<IDelta> retainedFilesDelta(Iterable<SModelDescriptor> smd, IModule mod, _FunctionTypes._return_P1_E0<? extends IFile, ? super String> getFile) {
    return new RetainedUtil.RetainedFilesDelta(mod, getFile).deltas(smd);
  }

  public static Iterable<IDelta> retainedCachesDelta(Iterable<SModelDescriptor> smd, IModule mod, _FunctionTypes._return_P1_E0<? extends IFile, ? super String> getFile) {
    return new RetainedUtil.RetainedCachesDelta(mod, getFile).deltas(smd);
  }

  /*package*/ static class RetainedFilesDelta {
    private IModule module;
    protected Map<String, FilesDelta> dir2delta = MapSequence.fromMap(new HashMap<String, FilesDelta>());
    private _FunctionTypes._return_P1_E0<? extends IFile, ? super String> getFile;

    public RetainedFilesDelta(IModule module, _FunctionTypes._return_P1_E0<? extends IFile, ? super String> getFile) {
      this.module = module;
      this.getFile = getFile;
    }

    public Iterable<IDelta> deltas(Iterable<SModelDescriptor> smds) {
      for (SModelDescriptor smd : smds) {
        String output = module.getOutputFor(smd);
        if (output != null) {
          deltaForDir(output).kept(FileGenerationUtil.getDefaultOutputDir(smd, this.getRootOutputDir(output)));
        }
      }
      return this.collectedDeltas();
    }

    protected IFile getRootOutputDir(String output) {
      return getFile.invoke(output);
    }

    private Iterable<IDelta> collectedDeltas() {
      return Sequence.fromIterable(MapSequence.fromMap(dir2delta).values()).<IDelta>select(new ISelector<FilesDelta, IDelta>() {
        public IDelta select(FilesDelta it) {
          return (IDelta) it;
        }
      });
    }

    protected FilesDelta deltaForDir(String dir) {
      if (!(MapSequence.fromMap(dir2delta).containsKey(dir))) {
        MapSequence.fromMap(dir2delta).put(dir, new FilesDelta(this.getRootOutputDir(dir)));
      }
      return MapSequence.fromMap(dir2delta).get(dir);
    }
  }

  /*package*/ static class RetainedCachesDelta extends RetainedUtil.RetainedFilesDelta {
    public RetainedCachesDelta(IModule mod, _FunctionTypes._return_P1_E0<? extends IFile, ? super String> getFile) {
      super(mod, getFile);
    }

    @Override
    protected IFile getRootOutputDir(String output) {
      return FileGenerationUtil.getCachesDir(super.getRootOutputDir(output));
    }
  }
}
