package jetbrains.mps.lang.dataFlow;

/*Generated by MPS */

import jetbrains.mps.components.CoreComponent;
import jetbrains.mps.logging.Logger;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.MPSModuleRepository;
import java.util.Map;
import java.util.HashMap;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.lang.dataFlow.framework.Program;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.Language;
import jetbrains.mps.smodel.ModuleRepositoryFacade;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.LanguageAspect;

public class DataFlowManager implements CoreComponent {
  private static Logger LOG = Logger.getLogger(DataFlowManager.class);
  private static DataFlowManager INSTANCE;

  private ClassLoaderManager myClassLoaderManager;
  private MPSModuleRepository myModuleRepository;
  private Map<String, DataFlowBuilder> myBuilders = new HashMap<String, DataFlowBuilder>();
  private boolean myLoaded = false;
  private ReloadAdapter myReloadHandler = new ReloadAdapter() {
    public void unload() {
      DataFlowManager.this.clear();
    }
  };

  public DataFlowManager(ClassLoaderManager classLoaderManager, MPSModuleRepository moduleRepository) {
    this.myClassLoaderManager = classLoaderManager;
    this.myModuleRepository = moduleRepository;
  }

  public void init() {
    if (INSTANCE != null) {
      throw new IllegalStateException("double initialization");
    }
    INSTANCE = this;
    this.myClassLoaderManager.addReloadHandler(this.myReloadHandler);
  }

  public void dispose() {
    this.myClassLoaderManager.removeReloadHandler(this.myReloadHandler);
    INSTANCE = null;
  }

  public void register(String conceptFqName, DataFlowBuilder builder) {
    this.myBuilders.put(conceptFqName, builder);
  }

  public Program buildProgramFor(SNode node) {
    checkLoaded();
    return new MPSProgramBuilder(this).buildProgram(node);
  }

  /*package*/ DataFlowBuilder getBuilderFor(String conceptName) {
    checkLoaded();
    return this.myBuilders.get(conceptName);
  }

  private void clear() {
    this.myBuilders.clear();
    myLoaded = false;
  }

  private void checkLoaded() {
    if (myLoaded) {
      return;
    }
    myLoaded = true;
    this.load();
  }

  private void load() {
    for (Language l : ModuleRepositoryFacade.getInstance().getAllModules(Language.class)) {
      SModelDescriptor dfaModel = LanguageAspect.DATA_FLOW.get(l);
      if (dfaModel != null && !(dfaModel.getSModel().rootsCount() == 0)) {
        String dfaBuildersClassName = dfaModel.getLongName() + ".DFABuilders";
        Class<? extends DataFlowBuilders> buildersClass = l.getClass(dfaBuildersClassName);
        if (buildersClass != null) {
          DataFlowBuilders builders = null;
          try {
            builders = buildersClass.newInstance();
            builders.install(this);
          } catch (Throwable t) {
            LOG.error(t);
          }
        }
      }
    }
  }

  public static DataFlowManager getInstance() {
    return INSTANCE;
  }
}
