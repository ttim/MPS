package jetbrains.mps.lang.plugin.scripts;

/*Generated by MPS */

import jetbrains.mps.lang.script.runtime.BaseMigrationScript;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.lang.script.runtime.AbstractMigrationRefactoring;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class UpdateIcons_MigrationScript extends BaseMigrationScript {
  public UpdateIcons_MigrationScript(IOperationContext operationContext) {
    super("Update Icons");
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Update Action Icons";
      }

      public String getAdditionalInfo() {
        return "Update Action Icons";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.lang.plugin.structure.ActionDeclaration";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return StringUtils.isNotEmpty(SPropertyOperations.getString(node, "iconPath")) && (SLinkOperations.getTarget(node, "icon", true) == null);
      }

      public void doUpdateInstanceNode(SNode node) {
        SNode icon = SLinkOperations.setNewChild(node, "icon", "jetbrains.mps.lang.resources.structure.IconResource");
        SPropertyOperations.set(icon, "path", SPropertyOperations.getString(node, "iconPath"));
        SPropertyOperations.set(node, "iconPath", null);
      }

      public boolean isShowAsIntention() {
        return true;
      }
    });
    this.addRefactoring(new AbstractMigrationRefactoring(operationContext) {
      public String getName() {
        return "Update Tool Icons";
      }

      public String getAdditionalInfo() {
        return "Update Tool Icons";
      }

      public String getFqNameOfConceptToSearchInstances() {
        return "jetbrains.mps.lang.plugin.structure.BaseToolDeclaration";
      }

      public boolean isApplicableInstanceNode(SNode node) {
        return StringUtils.isNotEmpty(SPropertyOperations.getString(node, "icon")) && (SLinkOperations.getTarget(node, "toolIcon", true) == null);
      }

      public void doUpdateInstanceNode(SNode node) {
        SNode icon = SLinkOperations.setNewChild(node, "toolIcon", "jetbrains.mps.lang.resources.structure.IconResource");
        SPropertyOperations.set(icon, "path", SPropertyOperations.getString(node, "icon"));
        SPropertyOperations.set(node, "icon", null);
      }

      public boolean isShowAsIntention() {
        return true;
      }
    });
  }
}
