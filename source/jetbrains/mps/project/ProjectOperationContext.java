package jetbrains.mps.project;

import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;

/**
 * Created by IntelliJ IDEA.
 * User: Igoor
 * Date: Sep 9, 2005
 * Time: 8:11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProjectOperationContext implements IOperationContext {
  private MPSProject myProject;

  public ProjectOperationContext(MPSProject project) {
    myProject = project;
  }

  public <T> T getComponent(Class<T> clazz) {
    T component = myProject.getComponent(clazz);
    if(component == null) {
      component = ApplicationComponents.getInstance().getComponent(clazz);
    }
    return component;
  }

  public IModule getModule() {
    return null;
  }

  public MPSProject getProject() {
    return myProject;
  }

  public IScope getScope() {
    return myProject;
  }
}
