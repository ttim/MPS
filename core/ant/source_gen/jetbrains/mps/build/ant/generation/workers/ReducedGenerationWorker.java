package jetbrains.mps.build.ant.generation.workers;

/*Generated by MPS */

import jetbrains.mps.build.ant.WhatToDo;
import jetbrains.mps.build.ant.MpsWorker;
import jetbrains.mps.project.Project;
import jetbrains.mps.project.ProjectOperationContext;
import jetbrains.mps.smodel.ModelAccess;
import java.util.concurrent.Future;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.make.MakeSession;
import jetbrains.mps.make.script.IScript;
import jetbrains.mps.make.script.ScriptBuilder;
import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.smodel.resources.IMResource;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.project.IModule;
import jetbrains.mps.make.script.IScriptController;
import java.util.concurrent.ExecutionException;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.make.script.IPropertiesPool;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.generator.impl.dependencies.GenerationDependenciesCache;
import jetbrains.mps.generator.info.GeneratorPathsComponent;
import jetbrains.mps.generator.info.ForeignPathsProvider;
import java.io.File;
import jetbrains.mps.internal.make.runtime.util.DirUtil;
import jetbrains.mps.generator.fileGenerator.FileGenerationUtil;

public class ReducedGenerationWorker extends GeneratorWorker {
  private ReducedGenerationWorker.ModuleOutputPaths myOutputPaths;
  private ReducedGenerationWorker.MyForeignRootPaths myForeignRootPaths;

  public ReducedGenerationWorker(WhatToDo whatToDo) {
    super(whatToDo);
  }

  public ReducedGenerationWorker(WhatToDo whatToDo, MpsWorker.AntLogger logger) {
    super(whatToDo, logger);
  }

  @Override
  protected void generate(Project project, MpsWorker.ObjectsToProcess go) {
    ProjectOperationContext ctx = new ProjectOperationContext(project);

    ModelAccess.instance().flushEventQueue();
    Future<IResult> res;
    IOperationContext context = new ProjectOperationContext(project);


    BuildMakeService bms = new BuildMakeService();
    MakeSession ms = new MakeSession(context, getMyMessageHandler(), true) {
      @Override
      public IScript toScript(ScriptBuilder scriptBuilder) {
        scriptBuilder.withFacetNames(new IFacet.Name("jetbrains.mps.build.reduced.ReportFiles"), new IFacet.Name("jetbrains.mps.build.reduced.CollectHashes"));
        return scriptBuilder.toScript();
      }
    };

    final List<String> writtenFiles = ListSequence.fromList(new ArrayList<String>());
    final Map<String, String> fileHashes = MapSequence.fromMap(new HashMap<String, String>());
    final Iterable<IMResource> resources = Sequence.fromIterable(collectResources(ctx, go)).toListSequence();

    this.myOutputPaths = new ReducedGenerationWorker.ModuleOutputPaths(Sequence.fromIterable(resources).select(new ISelector<IMResource, IModule>() {
      public IModule select(IMResource r) {
        return r.module();
      }
    }));

    IScriptController scriptCtl = configureFacets(resources, fileHashes, writtenFiles);

    try {
      res = bms.make(ms, resources, null, scriptCtl);
      if (!(res.get().isSucessful())) {
        myErrors.add("Make was not successful");
      }
      if (writtenFiles != null) {
        for (String f : writtenFiles) {
          System.out.println("##WRITTEN##" + f);
        }
      }
    } catch (InterruptedException e) {
      myErrors.add(e.toString());
    } catch (ExecutionException e) {
      myErrors.add(e.toString());
    }
  }

  private IScriptController configureFacets(final Iterable<IMResource> resources, final Map<String, String> fileHashes, final List<String> writtenFiles) {
    final String outputRoot = myWhatToDo.getProperty("OUTPUT_ROOT_DIR");
    final String cachesOutputRoot = myWhatToDo.getProperty("CACHES_OUTPUT_ROOT_DIR");
    final boolean useTransientOutput = Sequence.fromIterable(resources).any(new IWhereFilter<IMResource>() {
      public boolean accept(IMResource r) {
        return r.module().getModuleDescriptor().isUseTransientOutput();
      }
    });
    this.myForeignRootPaths = (useTransientOutput ?
      new ReducedGenerationWorker.MyForeignRootPaths(Sequence.<String>singleton(outputRoot)) :
      null
    );

    return new IScriptController.Stub() {
      @Override
      public void setup(IPropertiesPool pp, Iterable<ITarget> toExecute, Iterable<? extends IResource> input) {
        super.setup(pp, toExecute, input);
        Tuples._1<Boolean> skipReconcile = (Tuples._1<Boolean>) pp.properties(new ITarget.Name("jetbrains.mps.lang.core.Make.reconcile"), Object.class);
        skipReconcile._0(true);

        Tuples._1<Boolean> skipCopyTraceinfo = (Tuples._1<Boolean>) pp.properties(new ITarget.Name("jetbrains.mps.lang.traceable.CopyTraceInfo.copyTraceInfo"), Object.class);
        skipCopyTraceinfo._0(true);

        Tuples._2<Boolean, Boolean> compileProps = (Tuples._2<Boolean, Boolean>) pp.properties(new ITarget.Name("jetbrains.mps.baseLanguage.JavaCompile.compile"), Object.class);
        compileProps._1(true);

        Tuples._1<List<String>> report = (Tuples._1<List<String>>) pp.properties(new ITarget.Name("jetbrains.mps.build.reduced.ReportFiles.report"), Object.class);
        report._0(writtenFiles);

        Tuples._1<Map<String, String>> hashes = (Tuples._1<Map<String, String>>) pp.properties(new ITarget.Name("jetbrains.mps.build.reduced.CollectHashes.collect"), Object.class);
        hashes._0(fileHashes);

        // override solution's output path 
        Tuples._1<_FunctionTypes._return_P1_E0<? extends IFile, ? super String>> pathToFile = (Tuples._1<_FunctionTypes._return_P1_E0<? extends IFile, ? super String>>) pp.properties(new ITarget.Name("jetbrains.mps.lang.core.Make.make"), Object.class);
        pathToFile._0(new _FunctionTypes._return_P1_E0<IFile, String>() {
          public IFile invoke(String path) {
            if (useTransientOutput && outputRoot != null) {
              String localOutPath = myOutputPaths.toLocalPath(path);
              if (localOutPath != null) {
                return FileSystem.getInstance().getFileByPath(outputRoot).getDescendant(localOutPath);
              }
            }

            // use transient folder for caches always 
            if (cachesOutputRoot != null) {
              String localOutCachePath = myOutputPaths.toLocalCachePath(path);
              if (localOutCachePath != null) {
                return FileSystem.getInstance().getFileByPath(cachesOutputRoot).getDescendant(localOutCachePath);
              }
            }

            // can't convert, return the literal path 
            return FileSystem.getInstance().getFileByPath(path);
          }
        });
      }
    };
  }

  @Override
  protected void make() {
    // TODO we do not need make in ReducedGenerationWorker 
    super.make();
  }

  @Override
  protected void setupEnvironment() {
    super.setupEnvironment();
    GenerationDependenciesCache.getInstance().registerCachePathRedirect(new GenerationDependenciesCache.CachePathRedirect() {
      public String redirectTo(String outputPath) {
        return (myOutputPaths != null ?
          myOutputPaths.toLocalCachePath(outputPath) :
          null
        );
      }
    });
    GeneratorPathsComponent.getInstance().registerForeignPathsProvider(new ForeignPathsProvider() {
      public boolean isForeign(IFile path) {
        return (myForeignRootPaths != null ?
          myForeignRootPaths.isForeign(path.getPath()) :
          false
        );
      }
    });
  }

  public static void main(String[] args) {
    MpsWorker mpsWorker = new ReducedGenerationWorker(WhatToDo.fromDumpInFile(new File(args[0])), new MpsWorker.SystemOutLogger());
    mpsWorker.workFromMain();
  }

  private static class ModuleOutputPaths {
    private String[] sortedOutDirs;
    private String[] sortedTestOutDirs;
    private String[] sortedOutCacheDirs;
    private String[] sortedTestOutCacheDirs;

    public ModuleOutputPaths(Iterable<IModule> modules) {
      this.sortedOutDirs = DirUtil.sortDirs(Sequence.fromIterable(modules).select(new ISelector<IModule, String>() {
        public String select(IModule mod) {
          return mod.getGeneratorOutputPath();
        }
      }));
      this.sortedOutCacheDirs = DirUtil.sortDirs(Sequence.fromIterable(modules).select(new ISelector<IModule, String>() {
        public String select(IModule mod) {
          return FileGenerationUtil.getCachesPath(mod.getGeneratorOutputPath());
        }
      }));

      this.sortedTestOutDirs = DirUtil.sortDirs(Sequence.fromIterable(modules).select(new ISelector<IModule, String>() {
        public String select(IModule mod) {
          return mod.getTestsGeneratorOutputPath();
        }
      }));
      this.sortedTestOutCacheDirs = DirUtil.sortDirs(Sequence.fromIterable(modules).select(new ISelector<IModule, String>() {
        public String select(IModule mod) {
          return FileGenerationUtil.getCachesPath(mod.getTestsGeneratorOutputPath());
        }
      }));
    }

    public String toLocalPath(String path) {
      String normPath = DirUtil.normalizeAsDir(path);
      int idx = DirUtil.findPrefixAsDir(normPath, sortedOutDirs);
      if (idx >= 0) {
        return DirUtil.withoutPrefix(normPath, sortedOutDirs[idx]);
      }

      int tidx = DirUtil.findPrefixAsDir(normPath, sortedTestOutDirs);
      if (tidx >= 0) {
        return DirUtil.withoutPrefix(normPath, sortedTestOutDirs[tidx]);
      }

      // not found 
      return null;
    }

    public String toLocalCachePath(String path) {
      String normPath = DirUtil.normalizeAsDir(path);
      int idx = DirUtil.findPrefixAsDir(normPath, sortedOutCacheDirs);
      if (idx >= 0) {
        return DirUtil.withoutPrefix(normPath, sortedOutCacheDirs[idx]);
      }

      int tidx = DirUtil.findPrefixAsDir(normPath, sortedTestOutCacheDirs);
      if (tidx >= 0) {
        return DirUtil.withoutPrefix(normPath, sortedTestOutCacheDirs[tidx]);
      }

      // not found 
      return null;
    }
  }

  private static class MyForeignRootPaths {
    private String[] rootPaths;

    public MyForeignRootPaths(Iterable<String> foreignRoots) {
      this.rootPaths = Sequence.fromIterable(foreignRoots).select(new ISelector<String, String>() {
        public String select(String dir) {
          return DirUtil.normalizeAsDir(dir);
        }
      }).sort(new ISelector<String, Comparable<?>>() {
        public Comparable<?> select(String dir) {
          return dir;
        }
      }, true).toGenericArray(String.class);
    }

    public boolean isForeign(String path) {
      return DirUtil.findPrefixAsDir(path, rootPaths) >= 0;
    }
  }
}
