package jetbrains.mps.workbench.dialogs.project.components.parts.editors;

/*Generated by MPS */

import com.intellij.util.ui.AbstractTableCellEditor;
import jetbrains.mps.workbench.dialogs.project.IBindedDialog;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import jetbrains.mps.workbench.dialogs.choosers.CommonChoosers;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JTable;
import java.util.List;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.plugin.IProjectHandler;
import jetbrains.mps.plugin.MPSPlugin;
import jetbrains.mps.smodel.persistence.IModelRootManager;
import java.util.Collections;

public class HandlerTableCellEditor extends AbstractTableCellEditor {
  private IBindedDialog myOwner;
  private TextFieldWithBrowseButton.NoPathCompletion myClass;
  private JPanel myMainComponent;

  public HandlerTableCellEditor(final IBindedDialog owner, final String caption) {
    myOwner = owner;
    myClass = new TextFieldWithBrowseButton.NoPathCompletion();
    myClass.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String s = CommonChoosers.showDialogStringChooser(myOwner.getMainComponent(), caption, HandlerTableCellEditor.this.getModelRootManagerClassNames(owner.getOperationContext()));
        if (s == null) {
          return;
        }
        myClass.setText(s);
        HandlerTableCellEditor.this.stopCellEditing();
      }
    });
    myMainComponent = new JPanel(new BorderLayout());
    myMainComponent.add(myClass, BorderLayout.CENTER);
  }

  public Object getCellEditorValue() {
    return myClass.getText();
  }

  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    myClass.setText(((String) value));
    return myMainComponent;
  }

  public List<String> getModelRootManagerClassNames(IOperationContext context) {
    IProjectHandler projectHandler = MPSPlugin.getInstance().getProjectHandler(context.getProject());
    if (projectHandler != null) {
      try {
        return projectHandler.findInheritors(IModelRootManager.class.getName());
      } catch (Exception e) {
      }
    }
    return Collections.emptyList();
  }
}
