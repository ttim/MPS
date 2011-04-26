package jetbrains.mps.nanoc.plugin;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.prefs.BasePrefsPage;
import jetbrains.mps.nanoc.jetbrains.mps.nanoc.pluginutil.ProgramsLocationEditor;
import javax.swing.Icon;
import com.intellij.openapi.project.Project;
import jetbrains.mps.plugins.pluginparts.prefs.BaseProjectPrefsComponent;
import com.intellij.openapi.options.ConfigurationException;
import jetbrains.mps.nanoc.debug.ProgramsLocationUtil;
import javax.swing.JComponent;
import jetbrains.mps.util.EqualUtil;

public class ProgramsLocationComponent_GDBLocation_PreferencesPage extends BasePrefsPage {
  private ProgramsLocationEditor myComponent;
  private Icon icon;

  public ProgramsLocationComponent_GDBLocation_PreferencesPage(Project project, BaseProjectPrefsComponent prefsComponent) {
    super(project, prefsComponent);
  }

  public String getDisplayName() {
    return "GDB Location";
  }

  public Icon getIcon() {
    return this.icon;
  }

  public boolean isModified() {
    return this.isModified(this.getProject(), this.myComponent);
  }

  public void apply() throws ConfigurationException {
    if (this.myComponent != null) {
      this.commit(this.getProject(), this.myComponent);
    }
  }

  private void commit(Project project, ProgramsLocationEditor component) {
    ((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGDBLocation = ((ProgramsLocationEditor) component).getGDBLocation();
    ProgramsLocationUtil.setGdbLocation(((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGDBLocation);
    ((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGCCLocation = ((ProgramsLocationEditor) component).getGCCLocation();
    ProgramsLocationUtil.setGccLocation(((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGCCLocation);
  }

  public JComponent createComponent() {
    if (this.myComponent == null) {
      this.myComponent = new ProgramsLocationEditor();
    }
    return this.myComponent;
  }

  private boolean isModified(Project project, ProgramsLocationEditor component) {
    return !(EqualUtil.equals(((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGDBLocation, ((ProgramsLocationEditor) component).getGDBLocation())) || !(EqualUtil.equals(((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGCCLocation, ((ProgramsLocationEditor) component).getGCCLocation()));
  }

  public void disposeUIResources() {
    this.myComponent = null;
  }

  public void reset() {
    if (this.myComponent != null) {
      this.reset(this.getProject(), this.myComponent);
    }
  }

  private void reset(Project project, ProgramsLocationEditor component) {
    ((ProgramsLocationEditor) component).setGDBLocation(((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGDBLocation);
    ((ProgramsLocationEditor) component).setGCCLocation(((ProgramsLocationComponent_PreferencesComponent) ProgramsLocationComponent_GDBLocation_PreferencesPage.this.getPrefsComponent()).getStateObject().myGCCLocation);
  }

  @Override
  public String getHelpTopic() {
    return "GDB_Location";
  }
}
