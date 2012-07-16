package jetbrains.mps.execution.lib.ui;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.NonNls;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import java.util.List;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.progress.ProgressMonitor;
import java.util.Set;
import java.util.Collections;
import jetbrains.mps.findUsages.SearchType;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class NodeByConceptChooser extends AbstractMainNodeChooser {
  @NotNull
  private String myTargetConcept;
  @Nullable
  private _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> myAcceptor;
  private final GlobalFilteredScope myScope;

  public NodeByConceptChooser() {
    this("jetbrains.mps.lang.core.structure.BaseConcept", null);
  }

  public NodeByConceptChooser(@NonNls String conceptFqName, @Nullable _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> acceptor) {
    super();

    myTargetConcept = conceptFqName;
    myAcceptor = acceptor;

    final IModule[] module = new IModule[1];
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        module[0] = getTargetConceptNode().getModel().getModelDescriptor().getModule();
      }
    });
    myScope = new GlobalFilteredScope(MPSModuleRepository.getInstance(), SModelRepository.getInstance()) {
      @Nullable
      @Override
      protected Iterable<IModule> getRequiredModules() {
        return Sequence.<IModule>singleton(module[0]);
      }
    };
  }

  public String getTargetConcept() {
    return myTargetConcept;
  }

  public SNode getTargetConceptNode() {
    return (SNode) SModelUtil.findConceptDeclaration(myTargetConcept, GlobalScope.getInstance());
  }

  public void setTargetConcept(String targetConcept) {
    myTargetConcept = targetConcept;
  }

  public void setTargetConcept(SNode targetConcept) {
    myTargetConcept = ((String) BehaviorManager.getInstance().invoke(Object.class, targetConcept, "virtual_getFqName_1213877404258", new Class[]{SNode.class}));
  }

  public _FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> getAcceptor() {
    return myAcceptor;
  }

  public void setAcceptor(_FunctionTypes._return_P1_E0<? extends Boolean, ? super SNode> acceptor) {
    myAcceptor = acceptor;
  }

  protected List<SNode> findToChooseFromOnInit(FindUsagesManager manager, ProgressMonitor monitor) {
    Set<SNode> instances = manager.findUsages(Collections.singleton(((SNode) getTargetConceptNode())), SearchType.INSTANCES, myScope, monitor);
    if (this.myAcceptor == null) {
      return ListSequence.fromListWithValues(new ArrayList<SNode>(), instances);
    } else {
      return ListSequence.fromList(ListSequence.fromListWithValues(new ArrayList<SNode>(), instances)).where(new IWhereFilter<SNode>() {
        public boolean accept(SNode it) {
          return NodeByConceptChooser.this.myAcceptor.invoke(it);
        }
      }).toListSequence();
    }
  }

  protected List<SModelDescriptor> getModelDescriptors(String model) {
    return myScope.getModelDescriptors(model);
  }

  protected Iterable<SNode> findNodes(SModel model, final String fqName) {
    return ListSequence.fromList(SModelOperations.getNodes(((SModel) model), null)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        if (!(it.isInstanceOfConcept(NodeByConceptChooser.this.myTargetConcept))) {
          return false;
        }
        if (myAcceptor == null) {
          return getFqName(it).equals(fqName);
        } else {
          return myAcceptor.invoke(it) && getFqName(it).equals(fqName);
        }
      }
    });
  }
}
