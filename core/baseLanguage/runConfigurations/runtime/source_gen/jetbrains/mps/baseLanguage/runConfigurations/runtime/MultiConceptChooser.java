package jetbrains.mps.baseLanguage.runConfigurations.runtime;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.project.IModule;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class MultiConceptChooser extends AbstractMainNodeChooser {
  @NotNull
  private final List<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>> myTargetConcepts = ListSequence.fromList(new ArrayList<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>>());
  private final GlobalFilteredScope myScope;

  public MultiConceptChooser(Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>... targets) {
    this(Sequence.fromIterable(Sequence.fromArray(targets)).toListSequence());
  }

  public MultiConceptChooser(List<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>> targets) {
    ListSequence.fromList(myTargetConcepts).addSequence(ListSequence.fromList(targets).select(new ISelector<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>, Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>>() {
      public Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> select(Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
        return MultiTuple.<SNode,_FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>from((it._0() == null ?
          new _FunctionTypes._return_P0_E0<SNode>() {
            public SNode invoke() {
              final SNode[] conceptDeclaration = new SNode[1];
              ModelAccess.instance().runReadAction(new Runnable() {
                public void run() {
                  conceptDeclaration[0] = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept");
                }
              });
              return conceptDeclaration[0];
            }
          }.invoke() :
          it._0()
        ), it._1());
      }
    }));

    final Iterable<IModule> modules = ListSequence.fromList(myTargetConcepts).select(new ISelector<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>, IModule>() {
      public IModule select(final Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
        final Wrappers._T<IModule> module = new Wrappers._T<IModule>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            module.value = SNodeOperations.getModel(it._0()).getModelDescriptor().getModule();
          }
        });
        return module.value;
      }
    });
    myScope = new GlobalFilteredScope() {
      @Nullable
      @Override
      protected Iterable<IModule> getRequiredModules() {
        return modules;
      }
    };
  }

  protected List<SNode> findToChooseFromOnInit(final FindUsagesManager manager, final FindUsagesManager.ProgressAdapter progressAdapter) {
    return ListSequence.fromList(myTargetConcepts).translate(new ITranslator2<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>, SNode>() {
      public Iterable<SNode> translate(Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
        SNode targetConcept = it._0();
        final _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> function = it._1();
        Set<SNode> instances = manager.findInstances(targetConcept, myScope, progressAdapter, false);
        if (function == null) {
          return ListSequence.fromListWithValues(new ArrayList<SNode>(), instances);
        } else {
          return ListSequence.fromList(ListSequence.fromListWithValues(new ArrayList<SNode>(), instances)).where(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return function.invoke(it);
            }
          }).toListSequence();
        }
      }
    }).toListSequence();
  }

  protected List<SModelDescriptor> getModelDescriptors(String model) {
    return myScope.getModelDescriptors(model);
  }

  protected Iterable<SNode> findNodes(SModel model, final String fqName) {
    return ListSequence.fromList(SModelOperations.getNodes(model, null)).where(new IWhereFilter<SNode>() {
      public boolean accept(final SNode node) {
        return ListSequence.fromList(myTargetConcepts).findFirst(new IWhereFilter<Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>>>() {
          public boolean accept(Tuples._2<SNode, _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode>> it) {
            SNode targetConcept = it._0();
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
}
