package jetbrains.mps.stubs.util;

/*Generated by MPS */

import jetbrains.mps.smodel.descriptor.source.StubModelDataSource;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.smodel.BaseSModelDescriptor;
import jetbrains.mps.project.IModule;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.ModelLoadingState;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.nodeidmap.ForeignNodeIdMap;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.smodel.MPSModuleRepository;
import jetbrains.mps.project.ModuleId;
import java.util.List;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.smodel.SNodeId;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.baseLanguage.tuples.runtime.MultiTuple;
import jetbrains.mps.smodel.SModelStereotype;
import jetbrains.mps.smodel.SModelReference;
import java.io.InputStream;
import org.jdom.input.SAXBuilder;
import java.io.IOException;
import org.jdom.JDOMException;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.persistence.def.DescriptorLoadResult;
import jetbrains.mps.smodel.SModelFqName;
import jetbrains.mps.vfs.IFile;

public class ConfStubSource extends StubModelDataSource {
  private ModelRoot root;

  public ConfStubSource(ModelRoot root) {
    this.root = root;
  }

  public BaseSModelDescriptor.ModelLoadResult loadSModel(IModule module, SModelDescriptor descriptor, ModelLoadingState state) {
    SModel model = new SModel(descriptor.getSModelReference(), new ForeignNodeIdMap());
    model.setLoading(true);
    try {
      ModuleReference lang = MPSModuleRepository.getInstance().getModuleById(ModuleId.fromString("32d0a39c-772f-4490-8142-e50f9a9f19d4")).getModuleReference();
      model.addLanguage(lang);
      module.addUsedLanguage(lang);

      String pkg = model.getSModelFqName().getLongName();
      List<Tuples._3<String, String, SNode>> doclst = ListSequence.fromList(new ArrayList<Tuples._3<String, String, SNode>>());
      SNode sample = SConceptOperations.createNewNode("jetbrains.mps.platform.conf.structure.ConfigurationXmlDocument", null);
      PathItem pi = ConfPathItem.getPathItem(root.getPath());
      for (String docres : ListSequence.fromList(pi.resources(pkg))) {
        SNodeId id = ConfReader.createForeignId(pi.baseName(docres));
        SNode doc = (SNode) model.getNodeById(id);
        if ((doc == null)) {
          doc = SConceptOperations.createNewNode(NameUtil.nodeFQName(SConceptOperations.findConceptDeclaration("jetbrains.mps.platform.conf.structure.ConfigurationXmlDocument")), sample);
          doc.setId(id);
          SPropertyOperations.set(doc, "name", pi.baseName(docres));
          SModelOperations.addRootNode(((SModel) model), doc);
        }
        ListSequence.fromList(doclst).addElement(MultiTuple.<String,String,SNode>from(pkg, docres, doc));
      }
      final StubModelDescriptors descs = new StubModelDescriptors(SModelStereotype.getStubStereotypeForId("conf"), root, module, false);
      ConfReader reader = new ConfReader(new ConfReader.Resolver() {
        public SModelReference stubModelReference(String pk) {
          return descs.javaStubRef(pk);
        }
      }, new ConfReader.Resolver() {
        public SModelReference stubModelReference(String pk) {
          return descs.smodelRefWithId(pk);
        }
      });
      for (Tuples._3<String, String, SNode> doctuple : ListSequence.fromList(doclst)) {
        InputStream is = null;
        try {
          is = pi.openResource(doctuple._0(), doctuple._1());
          reader.read(doctuple._2(), new SAXBuilder().build(is));
        } catch (IOException e) {
          e.printStackTrace();
        } catch (JDOMException e) {
          e.printStackTrace();
        }
        if (is != null) {
          try {
            is.close();
          } catch (IOException e) {
          }
        }
      }
      SNodeOperations.deleteNode(sample);

    } finally {
      model.setLoading(false);
    }
    return new BaseSModelDescriptor.ModelLoadResult(model, ModelLoadingState.FULLY_LOADED);
  }

  public DescriptorLoadResult loadDescriptor(IModule module, SModelFqName name) {
    return null;
  }

  public boolean containFile(IFile file) {
    return false;
  }

  public long getTimestamp() {
    return 0;
  }
}
