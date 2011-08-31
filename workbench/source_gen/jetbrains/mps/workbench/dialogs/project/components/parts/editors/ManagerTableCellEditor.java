package jetbrains.mps.workbench.dialogs.project.components.parts.editors;

/*Generated by MPS */

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.project.structure.model.ModelRootManager;
import javax.swing.DefaultListCellRenderer;
import java.awt.Component;
import javax.swing.JList;
import jetbrains.mps.util.NameUtil;
import java.util.List;
import jetbrains.mps.smodel.IOperationContext;
import java.util.ArrayList;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.behaviour.BehaviorManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;

public class ManagerTableCellEditor extends DefaultCellEditor {
  private JComboBox myCombo;

  public ManagerTableCellEditor(final IBindedDialog owner) {
    super(new JComboBox(ListSequence.<ModelRootManager>fromList(getManagers(owner.getOperationContext())).toGenericArray(ModelRootManager.class)));
    myCombo = ((JComboBox) super.getComponent());

    myCombo.setRenderer(new DefaultListCellRenderer() {
      public Component getListCellRendererComponent(JList list, Object value, int index, boolean selected, boolean focus) {
        ModelRootManager manager = ((ModelRootManager) value);
        String managerName = NameUtil.shortNameFromLongName(manager.getClassName());
        return super.getListCellRendererComponent(list, managerName, index, selected, focus);
      }
    });
  }

  public static List<ModelRootManager> getManagers(final IOperationContext context) {
    final List<ModelRootManager> result = ListSequence.<ModelRootManager>fromList(new ArrayList<ModelRootManager>());
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (SNode node : ListSequence.<SNode>fromList(getManagerNodes(context))) {
          Language language = Language.getLanguageFor(node.getModel().getModelDescriptor());
          ModelRootManager manager = new ModelRootManager(language.getModuleReference().getModuleId().toString(), ((String) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(SNodeOperations.cast(node, "jetbrains.mps.lang.stubs.structure.AbstractModelCreator"), "jetbrains.mps.lang.stubs.structure.AbstractModelCreator"), "call_getGeneratedClassFQName_5553449326502826666", new Class[]{SNode.class})));
          ListSequence.<ModelRootManager>fromList(result).addElement(manager);
        }
      }
    });
    return result;
  }

  public static List<SNode> getManagerNodes(final IOperationContext context) {
    final List<SNode> result = new ArrayList<SNode>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        for (Language l : MPSModuleRepository.getInstance().getAllLanguages()) {
          SModelDescriptor stubsAspect = LanguageAspect.STUBS.get(l);
          if (stubsAspect == null) {
            continue;
          }
          SModel model = stubsAspect.getSModel();
          result.addAll(SModelOperations.getRoots(model, "jetbrains.mps.lang.stubs.structure.StubsCreatorDeclaration"));
        }
      }
    });
    return result;
  }
}
