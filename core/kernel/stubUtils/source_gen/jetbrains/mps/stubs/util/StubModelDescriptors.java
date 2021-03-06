package jetbrains.mps.stubs.util;

/*Generated by MPS */

import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.project.IModule;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.Set;
import jetbrains.mps.stubs.BaseStubModelDescriptor;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.descriptor.source.ModelDataSource;
import jetbrains.mps.smodel.descriptor.source.StubModelDataSource;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.smodel.SModelId;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.LanguageID;
import jetbrains.mps.project.StubModelsResolver;

public abstract class StubModelDescriptors {
  private String stubStereotype;
  private Iterable<ModelRoot> modelRoot;
  private IModule module;

  public StubModelDescriptors(String stereotype, ModelRoot mr, IModule module) {
    this(stereotype, Sequence.<ModelRoot>singleton(mr), module);
  }

  public StubModelDescriptors(String stereotype, Iterable<ModelRoot> roots, IModule module) {
    this.stubStereotype = stereotype;
    this.modelRoot = roots;
    this.module = module;
  }

  public Set<BaseStubModelDescriptor> getDescriptors(_FunctionTypes._return_P1_E0<? extends PathItem, ? super String> getPathItem) {
    Set<BaseStubModelDescriptor> result = SetSequence.fromSet(new HashSet<BaseStubModelDescriptor>());
    for (ModelRoot mr : modelRoot) {
      collectDescriptors(mr, "", getPathItem, result);
    }
    return result;
  }

  private void collectDescriptors(ModelRoot loc, String prefix, _FunctionTypes._return_P1_E0<? extends PathItem, ? super String> getPathItem, Set<BaseStubModelDescriptor> result) {
    PathItem pi = getPathItem.invoke(loc.getPath());
    for (String subpkg : ListSequence.fromList(pi.subpackages(prefix))) {
      if (ListSequence.fromList(pi.resources(subpkg)).isNotEmpty()) {
        SModelReference smref = smodelRefWithId(subpkg);
        SModelDescriptor descById = SModelRepository.getInstance().getModelDescriptor(smref);
        if (descById != null) {
          assert descById.getModule() == module;
          SetSequence.fromSet(result).addElement(((BaseStubModelDescriptor) descById));
          ModelDataSource dataSource = ((BaseStubModelDescriptor) descById).getSource();
          if (dataSource instanceof MultiRootModelDataSource) {
            ((MultiRootModelDataSource) dataSource).addRoot(loc);
          }
        } else {
          BaseStubModelDescriptor desc = new BaseStubModelDescriptor(smref, createStubsSource(module.getModuleReference(), loc), module);
          SModelRepository.getInstance().registerModelDescriptor(desc, module);
          SetSequence.fromSet(result).addElement(desc);
        }
      }
      ModelRoot mr = new ModelRoot();
      mr.setPath(loc.getPath());
      collectDescriptors(mr, subpkg, getPathItem, result);
    }
  }

  public abstract StubModelDataSource createStubsSource(ModuleReference origin, ModelRoot root);

  public SModelReference smodelRefWithId(String pkg) {
    SModelFqName fqname = new SModelFqName(module.getModuleFqName(), pkg, stubStereotype);
    SModelId modelId = SModelId.foreign(stubStereotype, module.getModuleReference().getModuleId().toString(), pkg);
    return new SModelReference(fqname, modelId);
  }

  public SModelReference smodelRefWithFqName(String pkg) {
    return SModelReference.fromString(pkg + "@" + stubStereotype);
  }

  public SModelReference javaStubRef(String pkg) {
    String stereo = SModelStereotype.getStubStereotypeForId(LanguageID.JAVA);
    Set<SModelReference> models = StubModelsResolver.getInstance().resolveModel(module, new SModelFqName(pkg, stereo), null);
    SModelReference mr = (models.isEmpty() ?
      null :
      models.iterator().next()
    );
    ModuleReference moduleRef = (mr == null ?
      null :
      SModelRepository.getInstance().getModelDescriptor(mr).getModule().getModuleReference()
    );

    String mfq = "MPS.Workbench";
    String muid = "86441d7a-e194-42da-81a5-2161ec62a379";

    if (moduleRef != null) {
      mfq = moduleRef.getModuleFqName();
      muid = moduleRef.getModuleId().toString();
    }
    SModelFqName fqname = new SModelFqName(mfq, pkg, stereo);
    SModelId modelId = SModelId.foreign(stereo, muid, pkg);
    return new SModelReference(fqname, modelId);
  }
}
