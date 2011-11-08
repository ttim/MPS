package jetbrains.mps.ide.hierarchy;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.smodel.SModelDescriptor;
import java.util.ArrayList;
import jetbrains.mps.smodel.event.SModelListener;
import jetbrains.mps.smodel.LanguageHierarchyCache;
import jetbrains.mps.project.listener.ModelCreationListener;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.LanguageAspect;
import com.intellij.openapi.project.Project;
import jetbrains.mps.ide.MPSCoreComponents;
import jetbrains.mps.ide.projectPane.Icons;
import jetbrains.mps.project.AbstractModule;
import jetbrains.mps.project.GlobalScope;

public class HierarchyViewTool extends AbstractHierarchyView {
  private List<SModelDescriptor> myStructureModels = new ArrayList<SModelDescriptor>();
  private SModelListener myModelListener;
  private LanguageHierarchyCache myCache;
  private ModelCreationListener myCreationListener = new ModelCreationListener() {
    public boolean isApplicable(SModelDescriptor m) {
      return m.getModule() instanceof Language && LanguageAspect.STRUCTURE.equals(((Language) m.getModule()).getAspectForModel(m));
    }

    public void onCreate(SModelDescriptor m) {
      onCreateStructureModel(m);
    }
  };

  public HierarchyViewTool(Project project, MPSCoreComponents coreComponents) {
    super(project, "Hierarchy", 8, Icons.HIERARCHY_ICON);
    myCache = coreComponents.getLanguageHierarchyCache();
  }

  public void onCreateStructureModel(SModelDescriptor md) {
    myStructureModels.add(md);
    md.addModelListener(myModelListener);
  }

  @Override
  public void initComponent() {
    super.initComponent();
    myModelListener = new HierarchyModelListener(this.myHierarchyTree);
    AbstractModule.registerModelCreationListener(myCreationListener);
  }

  @Override
  public void disposeComponent() {
    AbstractModule.unregisterModelCreationListener(myCreationListener);
    super.disposeComponent();
  }

  @Override
  public void projectOpened() {
    super.projectOpened();
    for (SModelDescriptor md : GlobalScope.getInstance().getModelDescriptors()) {
      if (LanguageAspect.STRUCTURE.is(md)) {
        myStructureModels.add(md);
      }
    }
  }

  @Override
  public void projectClosed() {
    super.projectClosed();
    myStructureModels.clear();
  }

  protected AbstractHierarchyTree createHierarchyTree(boolean isParentHierarchy) {
    return new ConceptHierarchyTree(myCache, this, isParentHierarchy);
  }

  protected void doRegister() {
    for (SModelDescriptor md : myStructureModels) {
      md.addModelListener(myModelListener);
    }
  }

  protected void doUnregister() {
    for (SModelDescriptor md : myStructureModels) {
      md.removeModelListener(myModelListener);
    }
    myStructureModels.clear();
  }

  public int getPriority() {
    return 2;
  }
}
