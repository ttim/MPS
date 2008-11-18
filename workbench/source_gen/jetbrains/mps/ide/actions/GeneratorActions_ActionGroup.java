package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.actions.GeneratedActionGroup;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.workbench.actions.language.GenerateTemplateQueriesAction;
import jetbrains.mps.workbench.actions.module.ShowModuleDependenciesAction;
import jetbrains.mps.workbench.actions.language.DeleteGeneratorAction;
import jetbrains.mps.workbench.action.ActionFactory;

public class GeneratorActions_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(GeneratorActions_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.GeneratorActions";
  public static final String LABEL_ID_generatorNew = ID + "generatorNew";

  public GeneratorActions_ActionGroup() {
    super("", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      this.addAnchor(GeneratorActions_ActionGroup.LABEL_ID_generatorNew);
      this.add(new GenerateTemplateQueriesAction(true));
      this.add(new GenerateTemplateQueriesAction(false));
      this.addSeparator();
      this.add(new ShowModuleDependenciesAction());
      this.addSeparator();
      this.add(new DeleteGeneratorAction());
      this.addSeparator();
      this.add(ActionFactory.getInstance().getRegisteredAction(new CheckGenerator_Action()));
      this.addSeparator();
      this.add(ActionFactory.getInstance().getRegisteredAction(new GeneratorProperties_Action()));
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }

  public void adjust() {
  }

}
