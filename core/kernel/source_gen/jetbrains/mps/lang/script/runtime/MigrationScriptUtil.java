package jetbrains.mps.lang.script.runtime;

/*Generated by MPS */

import jetbrains.mps.logging.Logger;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import java.util.ArrayList;
import jetbrains.mps.lang.script.util.ScriptNameUtil;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.project.Solution;
import jetbrains.mps.project.structure.modules.SolutionKind;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.project.GlobalScope;

public class MigrationScriptUtil {
  private static final Logger LOG = Logger.getLogger(MigrationScriptUtil.class);

  public MigrationScriptUtil() {
  }

  public static List<SNode> getMigrationScripts(Language language) {
    SModelDescriptor modelDescr = LanguageAspect.SCRIPTS.get(language);
    SModel model = (modelDescr == null ?
      null :
      modelDescr.getSModel()
    );
    return SModelOperations.getRoots(model, "jetbrains.mps.lang.script.structure.MigrationScript");
  }

  public static List<BaseMigrationScript> getScriptInstances(List<SNodePointer> scriptNodePointers, IOperationContext context) {
    List<BaseMigrationScript> scriptInstances = new ArrayList<BaseMigrationScript>();
    for (SNodePointer scriptNodePointer : scriptNodePointers) {
      SNode scriptNode = scriptNodePointer.getNode();
      BaseMigrationScript script = MigrationScriptUtil.getBaseScriptForNode(context, scriptNode);
      if (script != null) {
        scriptInstances.add(script);
      }
    }
    return scriptInstances;
  }

  public static BaseMigrationScript getBaseScriptForNode(IOperationContext context, SNode scriptNode) {
    if (scriptNode == null) {
      return null;
    }
    String fqClassName = ScriptNameUtil.getMigrationScriptFqClassName(scriptNode);
    Class<BaseMigrationScript> aClass;
    String languageNamespace = NameUtil.namespaceFromLongName(fqClassName);
    languageNamespace = languageNamespace.substring(0, languageNamespace.length() - ".scripts".length());
    IModule mod = ModuleRepositoryFacade.getInstance().getModule(languageNamespace, Language.class);
    if (mod == null) {
      Solution sol = ModuleRepositoryFacade.getInstance().getModule(languageNamespace, Solution.class);
      if (sol != null && sol.getModuleDescriptor().getKind() != SolutionKind.NONE) {
        mod = sol;
      }
    }
    if (mod == null) {
      LOG.error("Module not found: " + languageNamespace);
      return null;
    }
    aClass = mod.getClass(fqClassName);
    if (aClass == null) {
      return null;
    }
    try {
      Constructor<BaseMigrationScript> constructor = aClass.getConstructor(IOperationContext.class);
      return constructor.newInstance(context);
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    } catch (NoSuchMethodException e) {
      throw new RuntimeException(e);
    } catch (InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public static SNode getApplicableConcept(AbstractMigrationRefactoring migrationRefactoring) {
    return SModelUtil.findConceptDeclaration(migrationRefactoring.getFqNameOfConceptToSearchInstances(), GlobalScope.getInstance());
  }

  public static boolean isApplicableRefactoring(SNode node, AbstractMigrationRefactoring migrationRefactoring) {
    try {
      return migrationRefactoring.isApplicableInstanceNode(node);
    } catch (Throwable t) {
      LOG.error("script failed: " + t.getMessage(), t);
    }
    return false;
  }

  public static void performRefactoring(SNode node, AbstractMigrationRefactoring migrationRefactoring) {
    try {
      migrationRefactoring.doUpdateInstanceNode(node);
    } catch (Throwable t) {
      LOG.error("script failed: " + t.getMessage(), t);
    }
  }
}
