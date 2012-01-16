package jetbrains.mps.lang.core.plugin;

/*Generated by MPS */

import jetbrains.mps.make.facet.IFacet;
import java.util.List;
import jetbrains.mps.make.facet.ITarget;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.resources.IPropertiesPersistence;
import jetbrains.mps.make.facet.ITargetEx;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.make.script.IJob;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.script.IJobMonitor;
import jetbrains.mps.make.resources.IPropertiesAccessor;
import jetbrains.mps.make.script.IFeedback;
import jetbrains.mps.make.script.IConfig;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.project.Project;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.generator.IModifiableGenerationSettings;
import jetbrains.mps.generator.GenerationSettingsProvider;
import jetbrains.mps.generator.GenerationOptions;
import jetbrains.mps.make.facet.pluginSolution.plugin.MakeGenerationStrategy;
import jetbrains.mps.ide.generator.GeneratorCacheComponent;
import jetbrains.mps.generator.IGenerationTracer;
import jetbrains.mps.generator.NullGenerationTracer;
import jetbrains.mps.generator.DefaultGenerationParametersProvider;
import jetbrains.mps.make.script.IConfigMonitor;
import jetbrains.mps.smodel.resources.IMResource;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.smodel.resources.MResource;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.DefaultSModelDescriptor;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.loading.ModelLoadingState;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import java.util.Map;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.core.pluginSolution.plugin.RetainedUtil;
import jetbrains.mps.generator.generationTypes.IGenerationHandler;
import jetbrains.mps.make.facet.pluginSolution.plugin.MakeGenerationHandler;
import jetbrains.mps.smodel.resources.GResource;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.messages.IMessageHandler;
import jetbrains.mps.messages.IMessage;
import jetbrains.mps.internal.collections.runtime.ILeftCombinator;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.generator.TransientModelsProvider;
import jetbrains.mps.ide.generator.TransientModelsComponent;
import jetbrains.mps.generator.GenerationFacade;
import jetbrains.mps.project.MPSProject;
import jetbrains.mps.smodel.resources.DResource;
import jetbrains.mps.make.delta.IDelta;
import jetbrains.mps.make.delta.IInternalDelta;
import jetbrains.mps.make.delta.IDeltaVisitor;
import jetbrains.mps.make.script.IPropertiesPool;

public class Generate_Facet extends IFacet.Stub {
  private List<ITarget> targets = ListSequence.fromList(new ArrayList<ITarget>());
  private IFacet.Name name = new IFacet.Name("jetbrains.mps.lang.core.Generate");

  public Generate_Facet() {
    ListSequence.fromList(targets).addElement(new Generate_Facet.Target_checkParameters());
    ListSequence.fromList(targets).addElement(new Generate_Facet.Target_configure());
    ListSequence.fromList(targets).addElement(new Generate_Facet.Target_preloadModels());
    ListSequence.fromList(targets).addElement(new Generate_Facet.Target_generate());
  }

  public Iterable<ITarget> targets() {
    return targets;
  }

  public Iterable<IFacet.Name> optional() {
    return null;
  }

  public Iterable<IFacet.Name> required() {
    return Sequence.fromArray(new IFacet.Name[]{new IFacet.Name("jetbrains.mps.lang.core.Make")});
  }

  public Iterable<IFacet.Name> extended() {
    return null;
  }

  public IFacet.Name getName() {
    return this.name;
  }

  public IPropertiesPersistence propertiesPersistence() {
    return new Generate_Facet.TargetProperties();
  }

  public static class Target_checkParameters implements ITargetEx {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters");

    public Target_checkParameters() {
    }

    public IJob createJob() {
      return new IJob.Stub() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IPropertiesAccessor pa) {
          Iterable<IResource> _output_fi61u2_a0a = null;
          switch (0) {
            case 0:
              if (pa.global().properties(Target_checkParameters.this.getName(), Generate_Facet.Target_checkParameters.Variables.class).project() == null) {
                monitor.reportFeedback(new IFeedback.ERROR(String.valueOf("project is null")));
                return new IResult.FAILURE(_output_fi61u2_a0a);
              }
              if (pa.global().properties(Target_checkParameters.this.getName(), Generate_Facet.Target_checkParameters.Variables.class).operationContext() == null) {
                monitor.reportFeedback(new IFeedback.ERROR(String.valueOf("operationContext is null")));
                return new IResult.FAILURE(_output_fi61u2_a0a);
              }
              if (pa.global().properties(Target_checkParameters.this.getName(), Generate_Facet.Target_checkParameters.Variables.class).cleanMake() == null) {
                monitor.reportFeedback(new IFeedback.ERROR(String.valueOf("no cleanMake")));
                return new IResult.FAILURE(_output_fi61u2_a0a);
              }
            default:
              return new IResult.SUCCESS(_output_fi61u2_a0a);
          }
        }
      };
    }

    public IConfig createConfig() {
      return null;
    }

    public Iterable<ITarget.Name> notAfter() {
      return null;
    }

    public Iterable<ITarget.Name> after() {
      return null;
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return null;
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean isOptional() {
      return false;
    }

    public boolean requiresInput() {
      return false;
    }

    public boolean producesOutput() {
      return false;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return cls.cast(new Variables());
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      if (t != null) {
        ((Tuples._4) t).assign((Tuples._4) copyFrom);
      }
      return t;
    }

    public static class Variables extends MultiTuple._4<Project, IOperationContext, Boolean, _FunctionTypes._return_P0_E0<? extends ProgressMonitor>> {
      public Variables() {
        super();
      }

      public Variables(Project project, IOperationContext operationContext, Boolean cleanMake, _FunctionTypes._return_P0_E0<? extends ProgressMonitor> monitorProvider) {
        super(project, operationContext, cleanMake, monitorProvider);
      }

      public Project project(Project value) {
        return super._0(value);
      }

      public IOperationContext operationContext(IOperationContext value) {
        return super._1(value);
      }

      public Boolean cleanMake(Boolean value) {
        return super._2(value);
      }

      public _FunctionTypes._return_P0_E0<? extends ProgressMonitor> monitorProvider(_FunctionTypes._return_P0_E0<? extends ProgressMonitor> value) {
        return super._3(value);
      }

      public Project project() {
        return super._0();
      }

      public IOperationContext operationContext() {
        return super._1();
      }

      public Boolean cleanMake() {
        return super._2();
      }

      public _FunctionTypes._return_P0_E0<? extends ProgressMonitor> monitorProvider() {
        return super._3();
      }

      @SuppressWarnings(value = "unchecked")
      public Generate_Facet.Target_checkParameters.Variables assignFrom(Tuples._4<Project, IOperationContext, Boolean, _FunctionTypes._return_P0_E0<? extends ProgressMonitor>> from) {
        return (Generate_Facet.Target_checkParameters.Variables) super.assign(from);
      }
    }
  }

  public static class Target_configure implements ITargetEx {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.configure");

    public Target_configure() {
    }

    public IJob createJob() {
      return new IJob.Stub() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IPropertiesAccessor pa) {
          Iterable<IResource> _output_fi61u2_a0b = null;
          switch (0) {
            case 0:
              IModifiableGenerationSettings settings = GenerationSettingsProvider.getInstance().getGenerationSettings();
              pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions((pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions() != null ?
                pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions() :
                GenerationOptions.fromSettings(settings)
              ));
              pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions().incremental(new MakeGenerationStrategy((settings.isIncremental() && settings.isIncrementalUseCache() ?
                GeneratorCacheComponent.getInstance().getCache() :
                null
              ), settings.isIncremental()));
              IGenerationTracer tracer = (pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).saveTransient() ?
                pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).project().getComponent(IGenerationTracer.class) :
                new NullGenerationTracer()
              );
              pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions(pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions().saveTransientModels(pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).saveTransient()).tracing(settings.getPerformanceTracingLevel(), tracer).rebuildAll(pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).cleanMake()).keepOutputModel(true));
              pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).parametersProvider(new DefaultGenerationParametersProvider());
              pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).generationOptions().parameters(pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).parametersProvider());
              return new IResult.SUCCESS(_output_fi61u2_a0b);
            default:
              return new IResult.SUCCESS(_output_fi61u2_a0b);
          }
        }
      };
    }

    public IConfig createConfig() {
      return new IConfig.Stub() {
        @Override
        public boolean configure(final IConfigMonitor cmonitor, final IPropertiesAccessor pa) {
          switch (0) {
            case 0:
              IModifiableGenerationSettings settings = GenerationSettingsProvider.getInstance().getGenerationSettings();
              pa.global().properties(Target_configure.this.getName(), Generate_Facet.Target_configure.Variables.class).saveTransient(settings.isSaveTransientModels());
            default:
              return true;
          }
        }
      };
    }

    public Iterable<ITarget.Name> notAfter() {
      return null;
    }

    public Iterable<ITarget.Name> after() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters")});
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return null;
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean isOptional() {
      return false;
    }

    public boolean requiresInput() {
      return false;
    }

    public boolean producesOutput() {
      return false;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return cls.cast(new Variables());
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      if (t != null) {
        ((Tuples._3) t).assign((Tuples._3) copyFrom);
      }
      return t;
    }

    public static class Variables extends MultiTuple._3<Boolean, GenerationOptions.OptionsBuilder, DefaultGenerationParametersProvider> {
      public Variables() {
        super();
      }

      public Variables(Boolean saveTransient, GenerationOptions.OptionsBuilder generationOptions, DefaultGenerationParametersProvider parametersProvider) {
        super(saveTransient, generationOptions, parametersProvider);
      }

      public Boolean saveTransient(Boolean value) {
        return super._0(value);
      }

      public GenerationOptions.OptionsBuilder generationOptions(GenerationOptions.OptionsBuilder value) {
        return super._1(value);
      }

      public DefaultGenerationParametersProvider parametersProvider(DefaultGenerationParametersProvider value) {
        return super._2(value);
      }

      public Boolean saveTransient() {
        return super._0();
      }

      public GenerationOptions.OptionsBuilder generationOptions() {
        return super._1();
      }

      public DefaultGenerationParametersProvider parametersProvider() {
        return super._2();
      }

      @SuppressWarnings(value = "unchecked")
      public Generate_Facet.Target_configure.Variables assignFrom(Tuples._3<Boolean, GenerationOptions.OptionsBuilder, DefaultGenerationParametersProvider> from) {
        return (Generate_Facet.Target_configure.Variables) super.assign(from);
      }
    }
  }

  public static class Target_preloadModels implements ITargetEx {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{IMResource.class};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.preloadModels");

    public Target_preloadModels() {
    }

    public IJob createJob() {
      return new IJob.Stub() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IPropertiesAccessor pa) {
          Iterable<IResource> _output_fi61u2_a0c = null;
          switch (0) {
            case 0:
              int work = Sequence.fromIterable(input).count() * 100;
              if (work == 0) {
                return new IResult.SUCCESS(_output_fi61u2_a0c);
              }
              monitor.currentProgress().beginWork("Pre-loading models", work, monitor.currentProgress().workLeft());
              Sequence.fromIterable(input).visitAll(new IVisitor<IResource>() {
                public void visit(IResource mod) {
                  MResource mres = ((MResource) mod);
                  monitor.currentProgress().advanceWork("Pre-loading models", 100);
                  Sequence.fromIterable(mres.models()).visitAll(new IVisitor<SModelDescriptor>() {
                    public void visit(final SModelDescriptor smd) {
                      if (smd instanceof DefaultSModelDescriptor) {
                        ModelAccess.instance().runReadAction(new Runnable() {
                          public void run() {
                            ((DefaultSModelDescriptor) smd).getUpdateableModel().getModel(ModelLoadingState.FULLY_LOADED);
                          }
                        });
                      }
                    }
                  });
                }
              });
              monitor.currentProgress().finishWork("Pre-loading models");
              _output_fi61u2_a0c = Sequence.fromIterable(_output_fi61u2_a0c).concat(Sequence.fromIterable(input));
            default:
              return new IResult.SUCCESS(_output_fi61u2_a0c);
          }
        }
      };
    }

    public IConfig createConfig() {
      return null;
    }

    public Iterable<ITarget.Name> notAfter() {
      return null;
    }

    public Iterable<ITarget.Name> after() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Generate.configure")});
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Generate.generate")});
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean isOptional() {
      return false;
    }

    public boolean requiresInput() {
      return true;
    }

    public boolean producesOutput() {
      return true;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return null;
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      return t;
    }
  }

  public static class Target_generate implements ITargetEx {
    private static Class<? extends IResource>[] EXPECTED_INPUT = (Class<? extends IResource>[]) new Class[]{IMResource.class};
    private static Class<? extends IResource>[] EXPECTED_OUTPUT = (Class<? extends IResource>[]) new Class[]{};

    private ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.generate");

    public Target_generate() {
    }

    public IJob createJob() {
      return new IJob.Stub() {
        public IResult execute(final Iterable<IResource> input, final IJobMonitor monitor, final IPropertiesAccessor pa) {
          final Wrappers._T<Iterable<IResource>> _output_fi61u2_a0d = new Wrappers._T<Iterable<IResource>>(null);
          switch (0) {
            case 0:
              boolean generationOk;
              if (!(pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.configure"), Generate_Facet.Target_configure.Variables.class).saveTransient())) {
                IGenerationTracer tracer = pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).project().getComponent(IGenerationTracer.class);
                if (tracer != null) {
                  tracer.discardTracing();
                }
              }
              final Map<IModule, Iterable<SModelDescriptor>> retainedModels = RetainedUtil.collectModelsToRetain(input);

              IGenerationHandler gh = new MakeGenerationHandler(new _FunctionTypes._return_P1_E0<Boolean, GResource>() {
                public Boolean invoke(GResource data) {
                  monitor.currentProgress().advanceWork("Generating", 1000);
                  data.retainedModels(MapSequence.fromMap(retainedModels).get(data.module()));
                  _output_fi61u2_a0d.value = Sequence.fromIterable(_output_fi61u2_a0d.value).concat(Sequence.fromIterable(Sequence.<IResource>singleton(data)));
                  return true;
                }
              });
              IMessageHandler mh = new IMessageHandler() {
                public void handle(IMessage msg) {
                  monitor.reportFeedback(new IFeedback.MESSAGE(msg));
                }

                public void clear() {
                }
              };

              monitor.currentProgress().beginWork("Generating", Sequence.fromIterable(input).foldLeft(0, new ILeftCombinator<IResource, Integer>() {
                public Integer combine(Integer s, IResource it) {
                  return s + Sequence.fromIterable(((MResource) it).models()).count() * 1000;
                }
              }) + 1000, monitor.currentProgress().workLeft());
              monitor.currentProgress().advanceWork("Generating", 1000);
              List<SModelDescriptor> models = Sequence.fromIterable(input).translate(new ITranslator2<IResource, SModelDescriptor>() {
                public Iterable<SModelDescriptor> translate(IResource in) {
                  return ((MResource) in).models();
                }
              }).toListSequence();

              final TransientModelsProvider transModels = (pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).project().getComponent(TransientModelsComponent.class) != null ?
                pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).project().getComponent(TransientModelsComponent.class) :
                new TransientModelsProvider(pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).project(), null)
              );

              generationOk = GenerationFacade.generateModels(pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).project().getComponent(MPSProject.class), models, pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).operationContext(), gh, pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters"), Generate_Facet.Target_checkParameters.Variables.class).monitorProvider().invoke(), mh, pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.configure"), Generate_Facet.Target_configure.Variables.class).generationOptions().create(), transModels);

              monitor.currentProgress().finishWork("Generating");
              if (!(generationOk)) {
                return new IResult.FAILURE(_output_fi61u2_a0d.value);
              }
              _output_fi61u2_a0d.value = Sequence.fromIterable(_output_fi61u2_a0d.value).concat(Sequence.fromIterable(Sequence.<IResource>singleton(new DResource(Sequence.<IDelta>singleton(new IInternalDelta() {
                public IDelta merge(IDelta toMerge) {
                  return this;
                }

                public boolean contains(IDelta other) {
                  return false;
                }

                public boolean reconcile() {
                  if (!(pa.global().properties(new ITarget.Name("jetbrains.mps.lang.core.Generate.configure"), Generate_Facet.Target_configure.Variables.class).saveTransient())) {
                    transModels.removeAllTransient();
                  }
                  return true;
                }

                public boolean acceptVisitor(IDeltaVisitor visitor) {
                  return true;
                }
              })))));
            default:
              return new IResult.SUCCESS(_output_fi61u2_a0d.value);
          }
        }
      };
    }

    public IConfig createConfig() {
      return null;
    }

    public Iterable<ITarget.Name> notAfter() {
      return null;
    }

    public Iterable<ITarget.Name> after() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Generate.configure")});
    }

    public Iterable<ITarget.Name> notBefore() {
      return null;
    }

    public Iterable<ITarget.Name> before() {
      return Sequence.fromArray(new ITarget.Name[]{new ITarget.Name("jetbrains.mps.lang.core.Make.reconcile"), new ITarget.Name("jetbrains.mps.lang.core.Make.make")});
    }

    public ITarget.Name getName() {
      return name;
    }

    public boolean isOptional() {
      return false;
    }

    public boolean requiresInput() {
      return true;
    }

    public boolean producesOutput() {
      return true;
    }

    public Iterable<Class<? extends IResource>> expectedInput() {
      return Sequence.fromArray(EXPECTED_INPUT);
    }

    public Iterable<Class<? extends IResource>> expectedOutput() {
      return null;
    }

    public <T> T createParameters(Class<T> cls) {
      return null;
    }

    public <T> T createParameters(Class<T> cls, T copyFrom) {
      T t = createParameters(cls);
      return t;
    }
  }

  public static class TargetProperties implements IPropertiesPersistence {
    public TargetProperties() {
    }

    public void storeValues(Map<String, String> store, IPropertiesPool properties) {
      {
        ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters");
        if (properties.hasProperties(name)) {
          Generate_Facet.Target_checkParameters.Variables props = properties.properties(name, Generate_Facet.Target_checkParameters.Variables.class);
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.checkParameters.project", null);
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.checkParameters.operationContext", null);
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.checkParameters.cleanMake", String.valueOf(props.cleanMake()));
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.checkParameters.monitorProvider", null);
        }
      }
      {
        ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.configure");
        if (properties.hasProperties(name)) {
          Generate_Facet.Target_configure.Variables props = properties.properties(name, Generate_Facet.Target_configure.Variables.class);
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.configure.saveTransient", String.valueOf(props.saveTransient()));
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.configure.generationOptions", null);
          MapSequence.fromMap(store).put("jetbrains.mps.lang.core.Generate.configure.parametersProvider", null);
        }
      }
    }

    public void loadValues(Map<String, String> store, IPropertiesPool properties) {
      try {
        {
          ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.checkParameters");
          Generate_Facet.Target_checkParameters.Variables props = properties.properties(name, Generate_Facet.Target_checkParameters.Variables.class);
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.checkParameters.project")) {
            props.project(null);
          }
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.checkParameters.operationContext")) {
            props.operationContext(null);
          }
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.checkParameters.cleanMake")) {
            props.cleanMake(Boolean.valueOf(MapSequence.fromMap(store).get("jetbrains.mps.lang.core.Generate.checkParameters.cleanMake")));
          }
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.checkParameters.monitorProvider")) {
            props.monitorProvider(null);
          }
        }
        {
          ITarget.Name name = new ITarget.Name("jetbrains.mps.lang.core.Generate.configure");
          Generate_Facet.Target_configure.Variables props = properties.properties(name, Generate_Facet.Target_configure.Variables.class);
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.configure.saveTransient")) {
            props.saveTransient(Boolean.valueOf(MapSequence.fromMap(store).get("jetbrains.mps.lang.core.Generate.configure.saveTransient")));
          }
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.configure.generationOptions")) {
            props.generationOptions(null);
          }
          if (MapSequence.fromMap(store).containsKey("jetbrains.mps.lang.core.Generate.configure.parametersProvider")) {
            props.parametersProvider(null);
          }
        }
      } catch (RuntimeException re) {
      }
    }
  }
}
