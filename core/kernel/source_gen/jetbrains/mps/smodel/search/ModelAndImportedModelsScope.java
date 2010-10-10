package jetbrains.mps.smodel.search;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.IScope;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.util.Condition;
import jetbrains.mps.util.ConditionalIterable;

public class ModelAndImportedModelsScope extends AbstractSearchScope {
  private static final Logger LOG = Logger.getLogger(ModelAndImportedModelsScope.class);

  private SModel myModel;
  private boolean myRootsOnly;
  private IScope myScope;
  private List<SModelDescriptor> myModels;

  public ModelAndImportedModelsScope(SModel model, boolean rootsOnly, IScope scope) {
    myModel = model;
    myRootsOnly = rootsOnly;
    myScope = scope;
  }

  @NotNull
  public List<SModelDescriptor> getModels() {
    if (myModels == null) {
      if (myModel == null) {
        myModels = new ArrayList<SModelDescriptor>(1);
      } else {
        myModels = myModel.allImportedModels(myScope);
        myModels.add(0, myModel.getModelDescriptor());
      }
    }
    return myModels;
  }

  @NotNull
  public List<SNode> getNodes(Condition<SNode> condition) {
    List<SModelDescriptor> models = getModels();
    List<SNode> result = new ArrayList<SNode>();
    if (myRootsOnly) {
      for (SModelDescriptor model : models) {
        Iterable<SNode> roots = new ConditionalIterable(model.getSModel().roots(), condition);
        for (SNode root : roots) {
          result.add(root);
        }
      }
    } else {
      for (SModelDescriptor model : models) {
        try {
          if (model == null) {
            continue;
          }
          if (condition instanceof IsInstanceCondition) {
            IsInstanceCondition isInstance = (IsInstanceCondition) condition;
            result.addAll(model.getSModel().getFastNodeFinder().getNodes(isInstance.getConceptFqName(), true));
          } else {
            result.addAll(model.getSModel().allNodes(condition));
          }
        } catch (Throwable t) {
          LOG.error("error collecting nodes form model " + model, t);
        }
      }
    }
    return result;
  }
}
