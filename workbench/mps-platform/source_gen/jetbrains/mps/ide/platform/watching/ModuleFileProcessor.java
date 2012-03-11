package jetbrains.mps.ide.platform.watching;

/*Generated by MPS */

import java.util.Set;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import java.util.Map;
import jetbrains.mps.project.Project;
import java.util.List;
import jetbrains.mps.library.ModulesMiner;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.library.LibraryInitializer;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.fileTypes.MPSFileTypesManager;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import jetbrains.mps.project.ProjectManager;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.FileSystem;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.smodel.Generator;
import java.util.ArrayList;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import java.util.Collections;

/*package*/ class ModuleFileProcessor extends EventProcessor {
  private final Set<IModule> myChangedModules = SetSequence.fromSet(new HashSet<IModule>());
  private final Set<IModule> myDeletedModules = SetSequence.fromSet(new HashSet<IModule>());
  private final Map<Project, List<ModulesMiner.ModuleHandle>> myNewProjectModules = MapSequence.fromMap(new HashMap<Project, List<ModulesMiner.ModuleHandle>>());
  private final Map<String, List<ModulesMiner.ModuleHandle>> myNewLibModules = MapSequence.fromMap(new HashMap<String, List<ModulesMiner.ModuleHandle>>());
  private final Set<IModule> myProcessedModules = SetSequence.fromSet(new HashSet<IModule>());

  public ModuleFileProcessor() {
  }

  protected boolean isEmpty() {
    return SetSequence.fromSet(myChangedModules).isEmpty() && SetSequence.fromSet(myDeletedModules).isEmpty() && MapSequence.fromMap(myNewLibModules).isEmpty() && MapSequence.fromMap(myNewProjectModules).isEmpty();
  }

  public void update(ProgressIndicator indicator) {
    indicator.setText("Reloading updated modules... Please wait.");
    for (final IModule module : myChangedModules) {
      String text = "Reloading " + module.getModuleFqName();
      indicator.setText2(text);
      module.reloadFromDisk(false);
      SetSequence.fromSet(myProcessedModules).addElement(module);
    }
    for (final IModule module : myDeletedModules) {
      indicator.setText2("Unloading removed module " + module.getModuleFqName());
      module.dispose();
      MPSModuleRepository.getInstance().removeModule(module);
      SetSequence.fromSet(myProcessedModules).addElement(module);
    }
    // update lib modules 
    for (String lib : SetSequence.fromSet(MapSequence.fromMap(myNewLibModules).keySet())) {
      List<IModule> newModules = LibraryInitializer.getInstance().registerNewModules(lib, MapSequence.fromMap(myNewLibModules).get(lib));
      SetSequence.fromSet(myProcessedModules).addSequence(ListSequence.fromList(newModules));
    }
    // update project modules 
    for (Project project : SetSequence.fromSet(MapSequence.fromMap(myNewProjectModules).keySet())) {
      addNewModules(project, MapSequence.fromMap(myNewProjectModules).get(project));
    }
  }

  public Set<IModule> getProcessedModules() {
    return myProcessedModules;
  }

  public boolean needsReload() {
    return !(SetSequence.fromSet(myProcessedModules).isEmpty());
  }

  protected boolean accepts(VirtualFile file) {
    return file.isDirectory() || MPSFileTypesManager.instance().isModuleFile(file);
  }

  @Override
  protected void processDelete(VirtualFile file) {
    SetSequence.fromSet(myDeletedModules).addSequence(Sequence.fromIterable(replaceGenerators(getModulesByFile(file))));
  }

  @Override
  protected void processCreate(VirtualFile file) {
    // process libraries 
    final String path = file.getPath();
    Iterable<String> libs = LibraryInitializer.getInstance().getLibs();

    String lib = Sequence.fromIterable(libs).where(new IWhereFilter<String>() {
      public boolean accept(String it) {
        return path.startsWith(it);
      }
    }).first();
    if (lib != null) {
      readModulesFrom(lib, path);
    } else {
      Sequence.fromIterable(libs).where(new IWhereFilter<String>() {
        public boolean accept(String it) {
          return it.startsWith(path);
        }
      }).visitAll(new IVisitor<String>() {
        public void visit(String it) {
          readModulesFrom(it, it);
        }
      });
    }

    // process projects 
    for (Project project : ProjectManager.getInstance().getOpenProjects()) {
      for (String p : project.getWatchedModulesPaths()) {
        if (p.startsWith(file.getPath())) {
          IFile moduleFile = FileSystem.getInstance().getFileByPath(p);
          List<ModulesMiner.ModuleHandle> module = ModulesMiner.getInstance().collectModules(moduleFile, false);
          List<ModulesMiner.ModuleHandle> oldList = MapSequence.fromMap(myNewProjectModules).get(project);
          if (oldList == null) {
            MapSequence.fromMap(myNewProjectModules).put(project, module);
          } else {
            ListSequence.fromList(oldList).addSequence(ListSequence.fromList(module));
          }
        }
      }
    }
  }

  private void readModulesFrom(String lib, String path) {
    List<ModulesMiner.ModuleHandle> modules = ModulesMiner.getInstance().collectModules(FileSystem.getInstance().getFileByPath(path), false);
    if (ListSequence.fromList(modules).isEmpty()) {
      return;
    }

    List<ModulesMiner.ModuleHandle> oldList = MapSequence.fromMap(myNewLibModules).get(lib);
    if (oldList == null) {
      MapSequence.fromMap(myNewLibModules).put(lib, modules);
    } else {
      ListSequence.fromList(oldList).addSequence(ListSequence.fromList(modules));
    }
  }

  @Override
  protected void processContentChanged(VirtualFile file) {
    if (file.isDirectory()) {
      return;
    }
    List<IModule> modules = ModuleFileProcessor.getModulesByFile(file);
    SetSequence.fromSet(myChangedModules).addSequence(Sequence.fromIterable(replaceGenerators(modules)).where(new IWhereFilter<IModule>() {
      public boolean accept(IModule it) {
        return it.needReloading();
      }
    }));
  }

  private Iterable<IModule> replaceGenerators(Iterable<IModule> modules) {
    return Sequence.fromIterable(modules).select(new ISelector<IModule, IModule>() {
      public IModule select(IModule it) {
        return (it instanceof Generator ?
          ((Generator) it).getSourceLanguage() :
          it
        );
      }
    });
  }

  public List<IModule> addNewModules(Project p, List<ModulesMiner.ModuleHandle> modules) {
    ArrayList<IModule> result = new ArrayList<IModule>();
    for (ModulesMiner.ModuleHandle m : modules) {
      IModule module = MPSModuleRepository.getInstance().registerModule(m, p);
      ModuleReference mr = module.getModuleReference();
      p.addModule(mr);
      result.add(module);
    }
    return result;
  }

  private static List<IModule> getModulesByFile(final VirtualFile file) {
    final Wrappers._T<List<IModule>> res = new Wrappers._T<List<IModule>>(ListSequence.fromList(new ArrayList<IModule>()));
    final MPSModuleRepository repo = MPSModuleRepository.getInstance();
    final IFile mpsFile = FileSystem.getInstance().getFileByPath(file.getPath());

    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        res.value = (file.isDirectory() ?
          repo.findModulesUnderDir(mpsFile) :
          Collections.singletonList(repo.getModuleByFile(mpsFile))
        );
      }
    });
    return res.value;
  }
}
