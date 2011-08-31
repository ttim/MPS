package jetbrains.mps.make.script;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import java.util.Map;
import jetbrains.mps.make.facet.IFacet;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.make.facet.ITarget;
import java.util.List;
import jetbrains.mps.internal.make.runtime.script.ValidationError;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.make.runtime.script.InvalidScript;
import jetbrains.mps.internal.make.runtime.script.TargetRange;
import jetbrains.mps.internal.make.runtime.script.Script;
import jetbrains.mps.make.facet.FacetRegistry;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.internal.make.runtime.util.GraphAnalyzer;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class ScriptBuilder {
  private static Logger LOG = Logger.getLogger(ScriptBuilder.class);

  private Map<IFacet.Name, IFacet> facetsView = MapSequence.<IFacet.Name,IFacet>fromMap(new HashMap<IFacet.Name, IFacet>());
  private Set<IFacet.Name> facets = SetSequence.<IFacet.Name>fromSet(new HashSet<IFacet.Name>());
  private Set<ITarget.Name> requestedTargets = SetSequence.<ITarget.Name>fromSet(new HashSet<ITarget.Name>());
  private ITarget.Name finalTarget;
  private ITarget.Name startingTarget;
  private List<ValidationError> errors = ListSequence.<ValidationError>fromList(new ArrayList<ValidationError>());

  public ScriptBuilder() {
  }

  public ScriptBuilder withFacetName(IFacet.Name facetName) {
    SetSequence.fromSet(facets).addElement(facetName);
    return this;
  }

  public ScriptBuilder withFacetNames(IFacet.Name... facetNames) {
    return withFacetNames(Sequence.fromArray(facetNames));
  }

  public ScriptBuilder withFacetNames(Iterable<IFacet.Name> facetNames) {
    SetSequence.fromSet(facets).addSequence(Sequence.<IFacet.Name>fromIterable(facetNames));
    return this;
  }

  @Deprecated
  public ScriptBuilder withFacets(Iterable<IFacet> facets) {
    for (IFacet fct : Sequence.<IFacet>fromIterable(facets)) {
      MapSequence.<IFacet.Name,IFacet>fromMap(facetsView).put(fct.getName(), fct);
    }
    return this;
  }

  public ScriptBuilder withAuxTarget(ITarget.Name targetName) {
    if (targetName == null) {
      throw new NullPointerException();
    }
    SetSequence.fromSet(requestedTargets).addElement(targetName);
    return this;
  }

  public ScriptBuilder withStartingTarget(ITarget.Name targetName) {
    if (targetName == null) {
      throw new NullPointerException();
    }
    SetSequence.fromSet(requestedTargets).addElement(targetName);
    this.startingTarget = targetName;
    return this;
  }

  public ScriptBuilder withFinalTarget(ITarget.Name targetName) {
    if (targetName == null) {
      throw new NullPointerException();
    }
    SetSequence.fromSet(requestedTargets).addElement(targetName);
    this.finalTarget = targetName;
    return this;
  }

  public IScript toScript() {
    collectFacets();
    if (ListSequence.<ValidationError>fromList(errors).isNotEmpty()) {
      return new InvalidScript(errors);
    }
    final Map<IFacet.Name, ScriptBuilder.FacetRefs> refs = MapSequence.<IFacet.Name,ScriptBuilder.FacetRefs>fromMap(new HashMap<IFacet.Name, ScriptBuilder.FacetRefs>());
    this.collectRefs(refs);
    if (ListSequence.<ValidationError>fromList(errors).isNotEmpty()) {
      return new InvalidScript(errors);
    }
    Iterable<IFacet.Name> sortedFacets = this.toposortByExtended(refs);
    if (ListSequence.<ValidationError>fromList(errors).isNotEmpty()) {
      return new InvalidScript(errors);
    }
    TargetRange tr = new TargetRange();
    this.collectTargets(sortedFacets, tr);
    if (ListSequence.<ValidationError>fromList(errors).isNotEmpty()) {
      return new InvalidScript(errors);
    }
    Script sc = new Script(tr, finalTarget);
    sc.validate();
    return sc;
  }

  private void collectFacets() {
    for (IFacet.Name fn : SetSequence.<IFacet.Name>fromSet(facets)) {
      IFacet fct = FacetRegistry.getInstance().lookup(fn);
      if (fct != null) {
        MapSequence.<IFacet.Name,IFacet>fromMap(facetsView).put(fn, fct);
      } else {
        String msg = "facet not found: " + fn;
        LOG.error(msg);
        error(fn, msg);
      }
    }
  }

  private void collectTargets(Iterable<IFacet.Name> sortedFacets, TargetRange tr) {
    List<ITarget> allTargets = ListSequence.<ITarget>fromList(Sequence.<IFacet.Name>fromIterable(sortedFacets).<ITarget>translate(new ITranslator2<IFacet.Name, ITarget>() {
      public Iterable<ITarget> translate(IFacet.Name fname) {
        return MapSequence.<IFacet.Name,IFacet>fromMap(facetsView).get(fname).targets();
      }
    }).toListSequence()).reversedList();
    for (ITarget trg : ListSequence.<ITarget>fromList(allTargets)) {
      if (SetSequence.<ITarget.Name>fromSet(requestedTargets).contains(trg.getName())) {
        tr.addTarget(trg);
      }
    }
    for (ITarget.Name tn : SetSequence.<ITarget.Name>fromSet(requestedTargets)) {
      if (!(tr.hasTarget(tn))) {
        LOG.error("target not found: " + tn);
        error(tn, "target not found: " + tn);
      }
    }
    if (ListSequence.<ValidationError>fromList(errors).isNotEmpty()) {
      return;
    }
    tr.addRelatedPrecursors(Sequence.<IFacet>fromIterable(MapSequence.fromMap(facetsView).values()).<ITarget>translate(new ITranslator2<IFacet, ITarget>() {
      public Iterable<ITarget> translate(IFacet fct) {
        return fct.targets();
      }
    }));
  }

  private void collectRefs(final Map<IFacet.Name, ScriptBuilder.FacetRefs> refs) {
    for (IFacet fct : Sequence.<IFacet>fromIterable(MapSequence.fromMap(facetsView).values())) {
      ScriptBuilder.FacetRefs facetRefs = new ScriptBuilder.FacetRefs();
      this.collectRequired(fct, fct.extended(), facetRefs.extended);
      this.collectRequired(fct, fct.required(), facetRefs.required);
      this.collectOptional(fct, fct.optional(), facetRefs.optional);
      MapSequence.<IFacet.Name,ScriptBuilder.FacetRefs>fromMap(refs).put(fct.getName(), facetRefs);
    }
  }

  private Iterable<IFacet.Name> toposortByExtended(final Map<IFacet.Name, ScriptBuilder.FacetRefs> refs) {
    for (IMapping<IFacet.Name, ScriptBuilder.FacetRefs> m : SetSequence.<IMapping<IFacet.Name, ScriptBuilder.FacetRefs>>fromSet(MapSequence.fromMap(refs).mappingsSet())) {
      IFacet fct = MapSequence.<IFacet.Name,IFacet>fromMap(facetsView).get(m.key());
      for (IFacet ex : ListSequence.<IFacet>fromList(m.value().extended)) {
        ListSequence.<IFacet>fromList(MapSequence.<IFacet.Name,ScriptBuilder.FacetRefs>fromMap(refs).get(ex.getName()).extendedBy).addElement(fct);
      }
    }
    GraphAnalyzer<IFacet.Name> ga = new GraphAnalyzer<IFacet.Name>() {
      @Override
      public Iterable<IFacet.Name> forwardEdges(IFacet.Name v) {
        return ListSequence.<IFacet>fromList(MapSequence.<IFacet.Name,ScriptBuilder.FacetRefs>fromMap(refs).get(v).extendedBy).<IFacet.Name>select(new ISelector<IFacet, IFacet.Name>() {
          public IFacet.Name select(IFacet f) {
            return f.getName();
          }
        });
      }

      @Override
      public Iterable<IFacet.Name> backwardEdges(IFacet.Name v) {
        return ListSequence.<IFacet>fromList(MapSequence.<IFacet.Name,ScriptBuilder.FacetRefs>fromMap(refs).get(v).extended).<IFacet.Name>select(new ISelector<IFacet, IFacet.Name>() {
          public IFacet.Name select(IFacet f) {
            return f.getName();
          }
        });
      }

      @Override
      public Iterable<IFacet.Name> vertices() {
        return MapSequence.fromMap(refs).keySet();
      }
    };
    for (List<IFacet.Name> cyc : ListSequence.<List<IFacet.Name>>fromList(ga.findCycles())) {
      LOG.error("found cycle: " + cyc);
      error(null, "found cycle: " + cyc);
    }
    return ga.topologicalSort();
  }

  private void collectRequired(IFacet fct, Iterable<IFacet.Name> facets, List<IFacet> required) {
    for (IFacet.Name req : Sequence.<IFacet.Name>fromIterable(facets)) {
      IFacet f = MapSequence.<IFacet.Name,IFacet>fromMap(facetsView).get(req);
      if (f == null) {
        String msg = "not found required facet: " + req;
        LOG.error(msg);
        error(fct.getName(), msg);
      } else {
        ListSequence.<IFacet>fromList(required).addElement(f);
      }
    }
  }

  private void collectOptional(IFacet fct, Iterable<IFacet.Name> facets, List<IFacet> optional) {
    for (IFacet.Name opt : Sequence.<IFacet.Name>fromIterable(facets)) {
      IFacet f = MapSequence.<IFacet.Name,IFacet>fromMap(facetsView).get(opt);
      if (f == null) {
        String msg = "not found optional facet: " + opt;
        LOG.debug(msg);
      } else {
        ListSequence.<IFacet>fromList(optional).addElement(f);
      }
    }
  }

  private void error(Object o, String message) {
    ListSequence.<ValidationError>fromList(this.errors).addElement(new ValidationError(o, message));
  }

  private void clearErrors() {
    ListSequence.<ValidationError>fromList(this.errors).clear();
  }

  private static class FacetRefs {
    private List<IFacet> extended = ListSequence.<IFacet>fromList(new ArrayList<IFacet>());
    private List<IFacet> extendedBy = ListSequence.<IFacet>fromList(new ArrayList<IFacet>());
    private List<IFacet> required = ListSequence.<IFacet>fromList(new ArrayList<IFacet>());
    private List<IFacet> optional = ListSequence.<IFacet>fromList(new ArrayList<IFacet>());

    public FacetRefs() {
    }
  }
}
