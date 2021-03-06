package jetbrains.mps.build.util;

/*Generated by MPS */

import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.generator.template.TemplateQueryContext;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModel;
import java.util.concurrent.ConcurrentMap;
import jetbrains.mps.build.behavior.BuildProject_Behavior;
import jetbrains.mps.smodel.SModelDescriptor;

public class Context {
  private Map<String, Object> myProperties = MapSequence.fromMap(new HashMap<String, Object>());
  private TemplateQueryContext myGenerationContext;

  public Context() {
  }

  public Context(TemplateQueryContext generationContext) {
    myGenerationContext = generationContext;
  }

  @Nullable
  public Object put(String key, Object value) {
    Object previousValue = MapSequence.fromMap(myProperties).get(key);
    MapSequence.fromMap(myProperties).put(key, value);
    return previousValue;
  }

  @Nullable
  public <T> T get(String key) {
    return ((T) MapSequence.fromMap(myProperties).get(key));
  }

  protected SNode getBuildProject(SNode node) {
    return SNodeOperations.getAncestor(node, "jetbrains.mps.build.structure.BuildProject", true, false);
  }

  public MacroHelper getMacros(SNode context) {
    SNode buildProject = getBuildProject(context);
    if (buildProject == null) {
      return null;
    }
    buildProject = SNodeOperations.as(DependenciesHelper.getOriginalNode(buildProject, myGenerationContext), "jetbrains.mps.build.structure.BuildProject");
    if (buildProject == null) {
      return null;
    }
    return new MacroHelper.MacroContext(buildProject, myGenerationContext).getMacros(buildProject);
  }

  public String getBuildProjectName(SNode node) {
    return SPropertyOperations.getString(getBuildProject(node), "name");
  }

  @NotNull
  public IModule getModule(SModel model) {
    if (myGenerationContext != null) {
      return myGenerationContext.getOriginalInputModel().getModelDescriptor().getModule();
    }
    return model.getModelDescriptor().getModule();
  }

  public String getTempPath(SNode node, String name, String... categories) {
    assert myGenerationContext != null;

    SNode project = getBuildProject(node);
    ConcurrentMap<SNode, String> sessionMap = GenerationUtil.<SNode,String>getSessionMap(project, myGenerationContext, "Context_tempPath");
    String result = sessionMap.get(node);
    if (result != null) {
      return result;
    }

    result = new PathProvider(myGenerationContext, project).createTempPath(name, categories);
    if (sessionMap.putIfAbsent(node, result) != null) {
      result = sessionMap.get(node);
    }
    return result;
  }

  public String getBasePath_Local(SNode node) {
    SNode buildProject = this.getBuildProject(node);
    if ((buildProject == null)) {
      return null;
    }
    return BuildProject_Behavior.call_getBasePath_4959435991187146924(buildProject, this);
  }

  public RelativePathHelper getRelativePathHelper(@NotNull SModel model) {
    if (model.isTransient() && myGenerationContext != null) {
      model = myGenerationContext.getOriginalInputModel();
    }
    SModelDescriptor modelDescriptor = model.getModelDescriptor();
    if (model.isTransient() || modelDescriptor == null) {
      return null;
    }
    IModule module = modelDescriptor.getModule();
    if (module == null || module.getDescriptorFile() == null || module.isPackaged()) {
      return null;
    }
    String basePath = module.getDescriptorFile().getParent().getPath();
    return new RelativePathHelper(basePath);
  }

  public TemplateQueryContext getGenerationContext() {
    return myGenerationContext;
  }

  @NotNull
  public static Context defaultContext() {
    return new Context();
  }

  @NotNull
  public static Context defaultContext(final TemplateQueryContext gencontext) {
    if (gencontext == null) {
      return defaultContext();
    }

    return new Context(gencontext);
  }
}
