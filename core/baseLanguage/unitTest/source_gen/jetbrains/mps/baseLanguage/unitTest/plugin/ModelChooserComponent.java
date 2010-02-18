package jetbrains.mps.baseLanguage.unitTest.plugin;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.plugin.BaseChooserComponent;
import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;
import java.util.Collections;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.findUsages.FindUsagesManager;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.project.GlobalScope;
import com.intellij.openapi.progress.EmptyProgressIndicator;
import jetbrains.mps.smodel.SModel;

public class ModelChooserComponent extends BaseChooserComponent {
  private List<SModelDescriptor> checkedModels = ListSequence.fromList(new ArrayList<SModelDescriptor>());

  public ModelChooserComponent() {
    super();
    this.init(new ActionListener() {
      public void actionPerformed(ActionEvent p0) {
        ModelChooserComponent.this.collectModels();
        StringBuilder result = new StringBuilder();
        SModelDescriptor modelDescriptor = CommonChoosers.showDialogModelChooser(ModelChooserComponent.this, ModelChooserComponent.this.checkedModels, Collections.EMPTY_LIST);
        if (modelDescriptor != null) {
          result.append(modelDescriptor.getLongName());
          ModelChooserComponent.this.setText(result.toString());
        }
      }
    });
  }

  private void collectModels() {
    ListSequence.fromList(this.checkedModels).clear();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        List<SNode> nodes = ListSequence.fromListWithValues(new ArrayList<SNode>(), FindUsagesManager.getInstance().findInstances(((AbstractConceptDeclaration) SNodeOperations.getAdapter(SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"))), GlobalScope.getInstance(), new FindUsagesManager.ProgressAdapter(new EmptyProgressIndicator()), false));
        for (SNode node : nodes) {
          SModel model = SNodeOperations.getModel(node);
          SModelDescriptor md = model.getModelDescriptor();
          if (ListSequence.fromList(ModelChooserComponent.this.checkedModels).contains(md)) {
            continue;
          }
          ListSequence.fromList(ModelChooserComponent.this.checkedModels).addElement(md);
        }
      }
    });
  }
}
