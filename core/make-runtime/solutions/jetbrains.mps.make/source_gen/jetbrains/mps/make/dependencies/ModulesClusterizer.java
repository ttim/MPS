package jetbrains.mps.make.dependencies;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.make.resources.IResource;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.resources.IMResource;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.IListSequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.generator.runtime.TemplateModule;
import java.util.Queue;
import jetbrains.mps.internal.collections.runtime.QueueSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.language.LanguageRuntime;
import jetbrains.mps.smodel.language.LanguageRegistry;
import java.util.Collection;

public class ModulesClusterizer {
  private static Logger LOG = Logger.getLogger(ModulesCluster.class);

  public ModulesClusterizer() {
  }

  public Iterable<? extends Iterable<IResource>> clusterize(Iterable<IResource> res) {
    final Iterable<IResource> mres = Sequence.fromIterable(res).where(new IWhereFilter<IResource>() {
      public boolean accept(IResource r) {
        return r instanceof IMResource;
      }
    }).toListSequence();
    Iterable<IModule> mods = Sequence.fromIterable(mres).<IModule>select(new ISelector<IResource, IModule>() {
      public IModule select(IResource r) {
        return ((IMResource) r).module();
      }
    });
    List<IResource> rest = Sequence.fromIterable(res).subtract(Sequence.fromIterable(mres)).toListSequence();
    ModulesCluster clst = new ModulesCluster(mods);
    clst.collectRequired(mods);
    return Sequence.fromIterable(clst.buildOrder()).<List<IResource>>select(new ISelector<Iterable<IModule>, IListSequence<IResource>>() {
      public IListSequence<IResource> select(final Iterable<IModule> cl) {
        return Sequence.fromIterable(mres).where(new IWhereFilter<IResource>() {
          public boolean accept(IResource r) {
            return Sequence.fromIterable(cl).contains(((IMResource) r).module());
          }
        }).toListSequence();
      }
    }).concat(Sequence.fromIterable((ListSequence.fromList(rest).isNotEmpty() ?
      Sequence.<List<IResource>>singleton(rest) :
      null
    ))).toListSequence();
  }

  public Iterable<String> allUsedLangNamespaces(Iterable<IResource> cluster) {
    Iterable<IResource> mres = Sequence.fromIterable(cluster).where(new IWhereFilter<IResource>() {
      public boolean accept(IResource r) {
        return r instanceof IMResource;
      }
    }).toListSequence();
    Iterable<IModule> mods = Sequence.fromIterable(mres).<IModule>select(new ISelector<IResource, IModule>() {
      public IModule select(IResource r) {
        return ((IMResource) r).module();
      }
    });
    return allNamespaces(mods);
  }

  private Iterable<String> allNamespaces(Iterable<IModule> modules) {
    Set<String> namespaces = SetSequence.fromSet(new HashSet<String>());
    Set<TemplateModule> seen = SetSequence.fromSet(new HashSet<TemplateModule>());
    Queue<String> nsq = QueueSequence.fromQueue(new LinkedList<String>());
    for (IModule mod : modules) {
      Iterable<Language> langs = mod.getDependenciesManager().getAllUsedLanguages();
      QueueSequence.fromQueue(nsq).addSequence(Sequence.fromIterable(langs).<String>select(new ISelector<Language, String>() {
        public String select(Language it) {
          return it.getModuleDescriptor().getNamespace();
        }
      }));
      while (QueueSequence.fromQueue(nsq).isNotEmpty()) {
        String ns = QueueSequence.fromQueue(nsq).removeFirstElement();
        LanguageRuntime lr = LanguageRegistry.getInstance().getLanguage(ns);
        if (lr == null) {
          LOG.debug("language not found for namespace " + ns);
          continue;
        }
        if (!(SetSequence.fromSet(namespaces).contains(ns))) {
          SetSequence.fromSet(namespaces).addElement(ns);
          Collection<TemplateModule> gens = lr.getGenerators();
          if (gens != null) {
            for (TemplateModule tm : gens) {
              if (!(SetSequence.fromSet(seen).contains(tm))) {
                QueueSequence.fromQueue(nsq).addSequence(Sequence.fromIterable(tm.getUsedLanguages()));
                SetSequence.fromSet(seen).addElement(tm);
              }
            }
          }
        }
      }
    }
    return SetSequence.fromSet(namespaces).toListSequence();
  }
}
