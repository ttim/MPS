package jetbrains.mps.ide.modelchecker.actions;

/*Generated by MPS */

import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.options.SearchableConfigurable;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;
import javax.swing.Icon;
import javax.swing.JComponent;
import com.intellij.openapi.options.ConfigurationException;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import com.intellij.openapi.application.ApplicationManager;

@State(name = "ModelCheckerSettings", storages = {@Storage(id = "other", file = "$APP_CONFIG$/modelCheckerSettings.xml")
})
public class ModelCheckerSettings implements PersistentStateComponent<ModelCheckerSettings.MyState>, ApplicationComponent, SearchableConfigurable {
  private ModelCheckerSettings.MyState myState = new ModelCheckerSettings.MyState();
  private ModelCheckerPreferencesPage myPreferences;
  private boolean myMigrationMode = false;

  public ModelCheckerSettings() {
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Model Checker Settings";
  }

  public void initComponent() {
  }

  public void disposeComponent() {
  }

  public ModelCheckerSettings.MyState getState() {
    return myState;
  }

  public void loadState(ModelCheckerSettings.MyState state) {
    myState = state;
  }

  @Nls
  public String getDisplayName() {
    return "Model Checker";
  }

  @Nullable
  public Icon getIcon() {
    return null;
  }

  @Nullable
  @NonNls
  public String getHelpTopic() {
    return "Model_Checker";
  }

  public JComponent createComponent() {
    return getPreferences().getComponent();
  }

  public boolean isModified() {
    return getPreferences().isModified();
  }

  public void apply() throws ConfigurationException {
    getPreferences().commit();
  }

  public void reset() {
  }

  public void disposeUIResources() {
    myPreferences = null;
  }

  public String getId() {
    return "model.checker";
  }

  public Runnable enableSearch(String option) {
    return null;
  }

  private ModelCheckerPreferencesPage getPreferences() {
    if (myPreferences == null) {
      myPreferences = new ModelCheckerPreferencesPage(this);
    }
    return myPreferences;
  }

  public List<SpecificChecker> getSpecificCheckers() {
    List<SpecificChecker> specificCheckers = ListSequence.fromList(new ArrayList<SpecificChecker>());

    if (myMigrationMode) {
      // todo this is a hack ti use model chacker in migration tool 
      ListSequence.fromList(specificCheckers).addElement(new UnresolvedReferencesChecker());
    } else {
      ListSequence.fromList(specificCheckers).addElement(new UnavailableConceptsChecker());
      ListSequence.fromList(specificCheckers).addElement(new ModelPropertiesChecker());
      ListSequence.fromList(specificCheckers).addElement(new GeneratorTemplatesChecker());
      if (isCheckUnresolvedReferences()) {
        ListSequence.fromList(specificCheckers).addElement(new UnresolvedReferencesChecker());
      }
      ListSequence.fromList(specificCheckers).addElement(new SpecificModelChecker());
    }
    return specificCheckers;
  }

  public boolean checkerIsOn(String category) {
    if (category.equals("type system")) {
      return isCheckTypesystem();
    }
    if (category.equals("constraints and scopes")) {
      return isCheckConstraints();
    }
    return false;
  }

  public boolean isCheckUnresolvedReferences() {
    return myState.myCheckUnresolvedReferences;
  }

  public void setCheckUnresolvedReferences(boolean checkUnresolvedReferences) {
    myState.myCheckUnresolvedReferences = checkUnresolvedReferences;
  }

  public boolean isCheckConstraints() {
    return myState.myCheckConstraints;
  }

  public void setCheckConstraints(boolean checkConstraints) {
    myState.myCheckConstraints = checkConstraints;
  }

  @Deprecated
  public boolean isCheckScopes() {
    return myState.myCheckScopes;
  }

  @Deprecated
  public void setCheckScopes(boolean checkScopes) {
    myState.myCheckScopes = checkScopes;
  }

  public boolean isCheckTypesystem() {
    return myState.myCheckTypesystem;
  }

  public void setCheckTypesystem(boolean checkTypesystem) {
    myState.myCheckTypesystem = checkTypesystem;
  }

  public boolean isCheckStubs() {
    return myState.myCheckStubs;
  }

  public void setCheckStubs(boolean checkStubs) {
    myState.myCheckStubs = checkStubs;
  }

  public boolean isCheckBeforeCommit() {
    return myState.myCheckBeforeCommit;
  }

  public void setCheckBeforeCommit(boolean checkBeforeCommit) {
    myState.myCheckBeforeCommit = checkBeforeCommit;
  }

  @Deprecated
  public void setMigrationMode(boolean migrationMode) {
    myMigrationMode = migrationMode;
  }

  @Deprecated
  public boolean getMigrationMode() {
    return myMigrationMode;
  }

  public static ModelCheckerSettings getInstance() {
    return ApplicationManager.getApplication().getComponent(ModelCheckerSettings.class);
  }

  public static class MyState {
    private boolean myCheckUnresolvedReferences = true;
    private boolean myCheckConstraints = true;
    @Deprecated
    private boolean myCheckScopes = true;
    private boolean myCheckTypesystem = true;
    private boolean myCheckBeforeCommit = true;
    private boolean myCheckStubs = false;

    public MyState() {
    }

    public boolean isCheckUnresolvedReferences() {
      return myCheckUnresolvedReferences;
    }

    public void setCheckUnresolvedReferences(boolean checkUnresolvedReferences) {
      myCheckUnresolvedReferences = checkUnresolvedReferences;
    }

    public boolean isCheckConstraints() {
      return myCheckConstraints;
    }

    public void setCheckConstraints(boolean checkConstraints) {
      myCheckConstraints = checkConstraints;
    }

    @Deprecated
    public boolean isCheckScopes() {
      return myCheckScopes;
    }

    @Deprecated
    public void setCheckScopes(boolean checkScopes) {
      myCheckScopes = checkScopes;
    }

    public boolean isCheckTypesystem() {
      return myCheckTypesystem;
    }

    public void setCheckTypesystem(boolean checkTypesystem) {
      myCheckTypesystem = checkTypesystem;
    }

    public boolean isCheckBeforeCommit() {
      return myCheckBeforeCommit;
    }

    public void setCheckBeforeCommit(boolean checkBeforeCommit) {
      myCheckBeforeCommit = checkBeforeCommit;
    }

    public boolean isCheckStubs() {
      return myCheckStubs;
    }

    public void setCheckStubs(boolean checkStubs) {
      myCheckStubs = checkStubs;
    }
  }
}
