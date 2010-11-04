package jetbrains.mps.internal.make.runtime.script;

/*Generated by MPS */

import jetbrains.mps.make.script.IScript;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.make.facet.ITarget;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.make.script.IVariablesPool;
import jetbrains.mps.make.script.IResult;
import jetbrains.mps.make.script.IMonitor;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.make.script.IJob;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;

public class Script implements IScript {
  private static Logger LOG = Logger.getLogger(Script.class);

  private ITarget.Name defaultTargetName;
  private TargetRange targetRange;
  private List<ValidationError> errors = ListSequence.fromList(new ArrayList<ValidationError>());
  private boolean validated = false;
  private _FunctionTypes._void_P1_E0<? super IVariablesPool> init;

  public Script(TargetRange targetRange, ITarget.Name defaultTargetName, _FunctionTypes._void_P1_E0<? super IVariablesPool> init) {
    this(targetRange, defaultTargetName);
    this.init = init;
  }

  public Script(TargetRange targetRange, ITarget.Name defaultTargetName) {
    this.targetRange = targetRange;
    this.defaultTargetName = defaultTargetName;
  }

  public void validate() {
    ListSequence.fromList(errors).clear();
    if (!(targetRange.hasTarget(defaultTargetName))) {
      LOG.error("unknown default target: " + defaultTargetName);
      error(defaultTargetName, "unknown default target: " + defaultTargetName);
    }
    if (targetRange.hasCycles()) {
      LOG.error("cycle(s) detected: " + targetRange.cycles());
      error(this, "cycle(s) detected: " + targetRange.cycles());
    }
    validated = true;
  }

  public void invalidate() {
    this.validated = false;
  }

  public boolean isValid() {
    return validated && ListSequence.fromList(errors).isEmpty();
  }

  public Iterable<ITarget> allTargets() {
    return targetRange.sortedTargets();
  }

  public ITarget defaultTarget() {
    ITarget trg = targetRange.getTarget(defaultTargetName);
    if (trg == null) {
      LOG.error("no such target: " + defaultTargetName);
    }
    return trg;
  }

  private void error(Object o, String message) {
    ListSequence.fromList(this.errors).addElement(new ValidationError(o, message));
  }

  public IResult execute(IMonitor monit) {
    validate();
    if (!(isValid())) {
      LOG.error("attempt to execute invalid script");
      throw new IllegalStateException("invalid script");
    }
    LOG.info("Beginning to execute script");
    final CompositeResult results = new CompositeResult();
    Script.VariablesPool pool = new Script.VariablesPool();
    LOG.info("Initializing");
    if (init != null) {
      init.invoke(pool);
    }
    Iterable<ITarget> toExecute = targetRange.targetAndSortedPrecursors(defaultTargetName);
    for (ITarget trg : Sequence.fromIterable(toExecute)) {
      LOG.info("Executing " + trg.getName());
      Iterable<IResource> input = Sequence.fromIterable(targetRange.immediatePrecursors(trg.getName())).select(new ISelector<ITarget, IResult>() {
        public IResult select(ITarget t) {
          return results.getResult(t.getName());
        }
      }).translate(new ITranslator2<IResult, IResource>() {
        public Iterable<IResource> translate(IResult r) {
          return r.output();
        }
      });
      IJob job = trg.createJob();
      IResult jr = job.execute(input, monit, pool);
      results.addResult(trg.getName(), jr);
      if (!(jr.isSucessful()) || monit.pleaseStop()) {
        LOG.info((jr.isSucessful() ?
          "Stop requested" :
          "Execution failed"
        ));
        break;
      }
    }
    LOG.info("Finished executing script");
    return results;
  }

  public class VariablesPool implements IVariablesPool {
    private Map<ITarget.Name, Object> cache = MapSequence.fromMap(new HashMap<ITarget.Name, Object>());

    public VariablesPool() {
    }

    public <T> T variables(ITarget.Name target, Class<T> cls) {
      if (!(MapSequence.fromMap(cache).containsKey(target))) {
        T vars = targetRange.getTarget(target).createVariables(cls);
        MapSequence.fromMap(cache).put(target, vars);
      }
      return cls.cast(MapSequence.fromMap(cache).get(target));
    }
  }
}
