package jetbrains.mps.execution.lib.ui;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.project.IModule;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.SModelRepository;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.progress.ProgressMonitor;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Set;
import java.util.Collections;
import jetbrains.mps.findUsages.SearchType;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class NodeBySeveralConceptChooser extends AbstractMainNodeChooser {
  @NotNull
  private final List<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>> myTargetConcepts = ListSequence.fromList(new ArrayList<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>>());
  private final GlobalFilteredScope myScope;

  public NodeBySeveralConceptChooser(Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>... targets) {
    this(Sequence.fromIterable(Sequence.fromArray(targets)).toListSequence());
  }

  public NodeBySeveralConceptChooser(List<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>> targets) {
    ListSequence.fromList(myTargetConcepts).addSequence(ListSequence.fromList(targets).select(new ISelector<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>, Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>>() {
      public Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> select(Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
        return MultiTuple.<String,_FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>from((it._0() == null ?
          "jetbrains.mps.lang.core.structure.BaseConcept" :
          it._0()
        ), it._1());
      }
    }));

    final Iterable<IModule> modules = ListSequence.fromList(myTargetConcepts).select(new ISelector<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>, IModule>() {
      public IModule select(final Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
        final Wrappers._T<IModule> module = new Wrappers._T<IModule>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            module.value = SModelUtil.findConceptDeclaration(it._0(), GlobalScope.getInstance()).getModel().getModelDescriptor().getModule();
          }
        });
        return module.value;
      }
    });
    myScope = new GlobalFilteredScope(MPSModuleRepository.getInstance(), SModelRepository.getInstance()) {
      @Nullable
      @Override
      protected Iterable<IModule> getRequiredModules() {
        return modules;
      }
    };
  }

  protected List<SNode> findToChooseFromOnInit(final FindUsagesManager manager, final ProgressMonitor monitor) {
    return (List<SNode>) (ListSequence.fromList(myTargetConcepts).translate(new ITranslator2<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>, SNode>() {
      public Iterable<SNode> translate(Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
        String targetConcept = it._0();
        final _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> function = it._1();
        Set<SNode> instances = manager.findUsages(Collections.singleton(SModelUtil.findConceptDeclaration(targetConcept, GlobalScope.getInstance())), SearchType.INSTANCES, myScope, monitor);
        if (function == null) {
          return instances;
        } else {
          return SetSequence.fromSet(instances).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return function.invoke(it);
            }
          });
        }
      }
    }).toListSequence());
  }

  protected List<SModelDescriptor> getModelDescriptors(String model) {
    return myScope.getModelDescriptors(model);
  }

  protected Iterable<SNode> findNodes(SModel model, final String fqName) {
    return ListSequence.fromList(SModelOperations.getNodes(((SModel) model), null)).where(new IWhereFilter<SNode>() {
      public boolean accept(final SNode node) {
        return ListSequence.fromList(myTargetConcepts).findFirst(new IWhereFilter<Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>>() {
          public boolean accept(Tuples._2<String, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
            String targetConcept = it._0();
            _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> function = it._1();
            if (!(node.isInstanceOfConcept(targetConcept))) {
              return false;
            }
            if (function == null) {
              return getFqName(node).equals(fqName);
            } else {
              return function.invoke(node) && getFqName(node).equals(fqName);
            }
          }
        }) != null;
      }
    });
  }

  public static void main(String... args) {
  }
}
