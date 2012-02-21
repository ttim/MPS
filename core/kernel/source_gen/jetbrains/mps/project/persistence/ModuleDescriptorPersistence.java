package jetbrains.mps.project.persistence;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.project.structure.modules.ModuleDescriptor;
import org.jdom.Element;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.xmlQuery.runtime.AttributeUtils;
import jetbrains.mps.internal.collections.runtime.ISelector;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.modules.LanguageDescriptor;
import jetbrains.mps.project.structure.modules.Dependency;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.Set;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import java.util.Collection;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.project.structure.model.ModelRoot;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.util.Macros;
import jetbrains.mps.project.structure.model.ModelRootManager;
import org.jdom.Document;
import jetbrains.mps.util.JDOMUtil;
import jetbrains.mps.util.FileUtil;
import java.util.UUID;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;

public class ModuleDescriptorPersistence {
  private static final String HEADER_PATTERN = ".*<(language|dev-kit|solution)[^>]+(namespace|name)=\\\"([^\"]+)\\\"[^>]+uuid=\\\"([^\"]+)\\\".*";
  protected static Log log = LogFactory.getLog(ModuleDescriptorPersistence.class);

  private ModuleDescriptorPersistence() {
  }

  public static void loadDependencies(ModuleDescriptor descriptor, Element root) {
    descriptor.getDependencies().addAll(loadDependenciesList(ListSequence.fromList(AttributeUtils.elementChildren(root, "dependencies")).first()));

    descriptor.getUsedLanguages().addAll(ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(root, "usedLanguages")).first(), "usedLanguage")).select(new ISelector<Element, ModuleReference>() {
      public ModuleReference select(Element ul) {
        return ModuleReference.fromString(ul.getText());
      }
    }).toListSequence());

    descriptor.getUsedDevkits().addAll(ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(root, "usedDevKits")).first(), "usedDevKit")).select(new ISelector<Element, ModuleReference>() {
      public ModuleReference select(Element udk) {
        return ModuleReference.fromString(udk.getText());
      }
    }).toListSequence());

    if (descriptor instanceof LanguageDescriptor) {
      LanguageDescriptor ld = (LanguageDescriptor) descriptor;
      // old 
      Element runtimeXML = ListSequence.fromList(AttributeUtils.elementChildren(root, "runtime")).first();
      if (runtimeXML != null) {
        for (Dependency dep : ListSequence.fromList(loadDependenciesList(runtimeXML))) {
          ld.getRuntimeModules().add(dep.getModuleRef());
        }
      }

      // new 
      Element runtimeModulesXML = ListSequence.fromList(AttributeUtils.elementChildren(((Element) root), "runtimeModules")).first();
      if (runtimeModulesXML != null) {
        ld.getRuntimeModules().addAll(parseModuleRefList(runtimeModulesXML));
      }
    }
  }

  private static List<ModuleReference> parseModuleRefList(Element runtimeXML) {
    return ListSequence.fromList(AttributeUtils.elementChildren(runtimeXML, "module")).select(new ISelector<Element, ModuleReference>() {
      public ModuleReference select(Element d) {
        return new ModuleReference(AttributeUtils.stringWithDefault(d.getAttributeValue("name"), ""), AttributeUtils.stringWithDefault(d.getAttributeValue("id"), ""));
      }
    }).toListSequence();
  }

  public static void saveDependencies(Element result, ModuleDescriptor descriptor) {
    Element result_dxyzb6_a0a2 = result;
    if (!(descriptor.getDependencies().isEmpty())) {
      final Element result_dxyzb6_a0a0a0a2 = new Element("dependencies");
      saveDependencyList(result_dxyzb6_a0a0a0a2, descriptor.getDependencies());
      result_dxyzb6_a0a2.addContent(result_dxyzb6_a0a0a0a2);
    }

    if (!(descriptor.getUsedLanguages().isEmpty())) {
      final Element result_dxyzb6_a0a2a0a2 = new Element("usedLanguages");
      for (ModuleReference langRef : SetSequence.fromSet(descriptor.getUsedLanguages())) {
        final Element result_dxyzb6_a0a0a0a2a0a2 = new Element("usedLanguage");
        final String result_dxyzb6_a0a0a0a0a2a0a2 = langRef.toString();
        result_dxyzb6_a0a0a0a2a0a2.setText(result_dxyzb6_a0a0a0a0a2a0a2);
        result_dxyzb6_a0a2a0a2.addContent(result_dxyzb6_a0a0a0a2a0a2);
      }
      result_dxyzb6_a0a2.addContent(result_dxyzb6_a0a2a0a2);
    }

    if (!(descriptor.getUsedDevkits().isEmpty())) {
      final Element result_dxyzb6_a0a4a0a2 = new Element("usedDevKits");
      for (ModuleReference dkRef : SetSequence.fromSet(descriptor.getUsedDevkits())) {
        final Element result_dxyzb6_a0a0a0a4a0a2 = new Element("usedDevKit");
        final String result_dxyzb6_a0a0a0a0a4a0a2 = dkRef.toString();
        result_dxyzb6_a0a0a0a4a0a2.setText(result_dxyzb6_a0a0a0a0a4a0a2);
        result_dxyzb6_a0a4a0a2.addContent(result_dxyzb6_a0a0a0a4a0a2);
      }
      result_dxyzb6_a0a2.addContent(result_dxyzb6_a0a4a0a2);
    }

    if (descriptor instanceof LanguageDescriptor) {
      LanguageDescriptor ld = ((LanguageDescriptor) descriptor);
      Element result_dxyzb6_a1a2a2 = result;
      if (!(ld.getRuntimeModules().isEmpty())) {
        final Element result_dxyzb6_a0a0a1a2a2 = new Element("runtime");
        Set<ModuleReference> runtimeModules = ld.getRuntimeModules();
        saveDependencyList(result_dxyzb6_a0a0a1a2a2, SetSequence.fromSet(runtimeModules).select(new ISelector<ModuleReference, Dependency>() {
          public Dependency select(ModuleReference it) {
            return new Dependency(it, false);
          }
        }).toListSequence());
        result_dxyzb6_a1a2a2.addContent(result_dxyzb6_a0a0a1a2a2);
      }
    }
  }

  public static List<Dependency> loadDependenciesList(Element depElement) {
    return ListSequence.fromList(AttributeUtils.elementChildren(depElement, "dependency")).select(new ISelector<Element, Dependency>() {
      public Dependency select(final Element d) {
        return new _FunctionTypes._return_P0_E0<Dependency>() {
          public Dependency invoke() {
            final Dependency result_dxyzb6_a0a0a0a0a0a3 = new Dependency();
            final ModuleReference result_dxyzb6_a0a0a0a0a0a0a3 = ModuleReference.fromString(d.getText());
            result_dxyzb6_a0a0a0a0a0a3.setModuleRef(result_dxyzb6_a0a0a0a0a0a0a3);
            final boolean result_dxyzb6_a1a0a0a0a0a0a3 = AttributeUtils.booleanWithDefault(d.getAttributeValue("reexport"), true);
            result_dxyzb6_a0a0a0a0a0a3.setReexport(result_dxyzb6_a1a0a0a0a0a0a3);
            return result_dxyzb6_a0a0a0a0a0a3;
          }
        }.invoke();
      }
    }).toListSequence();
  }

  private static void saveDependencyList(Element depElement, Collection<Dependency> dependencies) {
    Element result_dxyzb6_a0a4 = depElement;
    for (Dependency md : Sequence.fromIterable(dependencies)) {
      final Element result_dxyzb6_a0a0a0a4 = new Element("dependency");
      final String result_dxyzb6_a0a0a0a0a4 = md.getModuleRef().toString();
      result_dxyzb6_a0a0a0a4.setText(result_dxyzb6_a0a0a0a0a4);
      final boolean result_dxyzb6_a1a0a0a0a4 = md.isReexport();
      result_dxyzb6_a0a0a0a4.setAttribute("reexport", "" + result_dxyzb6_a1a0a0a0a4);
      result_dxyzb6_a0a4.addContent(result_dxyzb6_a0a0a0a4);
    }
  }

  private static void saveModuleRefList(Element depElement, List<ModuleReference> dependencies) {
    Element result_dxyzb6_a0a5 = depElement;
    for (ModuleReference md : ListSequence.fromList(dependencies)) {
      final Element result_dxyzb6_a0a0a0a5 = new Element("module");
      final String result_dxyzb6_a0a0a0a0a5 = md.getModuleId().toString();
      result_dxyzb6_a0a0a0a5.setAttribute("id", "" + result_dxyzb6_a0a0a0a0a5);
      final String result_dxyzb6_a1a0a0a0a5 = md.getModuleFqName();
      result_dxyzb6_a0a0a0a5.setAttribute("name", "" + result_dxyzb6_a1a0a0a0a5);
      result_dxyzb6_a0a5.addContent(result_dxyzb6_a0a0a0a5);
    }
  }

  public static List<ModelRoot> loadModelRoots(List<Element> modelRootElements, final IFile file, final Macros macros) {
    return ListSequence.fromList(modelRootElements).select(new ISelector<Element, ModelRoot>() {
      public ModelRoot select(Element mre) {
        return loadModelRoot(mre, file, macros);
      }
    }).toListSequence();
  }

  private static ModelRoot loadModelRoot(final Element modelRootElement, final IFile file, final Macros macros) {
    return new _FunctionTypes._return_P0_E0<ModelRoot>() {
      public ModelRoot invoke() {
        final ModelRoot result_dxyzb6_a0a0a7 = new ModelRoot();
        String pathName = modelRootElement.getAttributeValue("path");
        if (pathName == null) {
          // left for compatibility 
          pathName = AttributeUtils.stringWithDefault(modelRootElement.getAttributeValue("rootPath"), "");
        }
        final String result_dxyzb6_a2a0a0a7 = macros.expandPath(pathName, file);
        result_dxyzb6_a0a0a7.setPath(result_dxyzb6_a2a0a0a7);
        if (ListSequence.fromList(AttributeUtils.elementChildren(modelRootElement, "manager")).isNotEmpty()) {
          final ModelRootManager result_dxyzb6_a0a3a0a0a7 = new ModelRootManager();
          Element manager = ListSequence.fromList(AttributeUtils.elementChildren(modelRootElement, "manager")).first();
          final String result_dxyzb6_a1a0a3a0a0a7 = AttributeUtils.stringWithDefault(manager.getAttributeValue("moduleId"), "");
          result_dxyzb6_a0a3a0a0a7.setModuleId(result_dxyzb6_a1a0a3a0a0a7);
          final String result_dxyzb6_a2a0a3a0a0a7 = AttributeUtils.stringWithDefault(manager.getAttributeValue("className"), "");
          result_dxyzb6_a0a3a0a0a7.setClassName(result_dxyzb6_a2a0a3a0a0a7);
          result_dxyzb6_a0a0a7.setManager(result_dxyzb6_a0a3a0a0a7);
        }
        return result_dxyzb6_a0a0a7;
      }
    }.invoke();
  }

  public static List<ModelRoot> loadStubModelEntries(List<Element> stubModelEntryElements, final IFile file, final Macros macros) {
    return ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(stubModelEntryElements).first(), "stubModelEntry")).select(new ISelector<Element, ModelRoot>() {
      public ModelRoot select(Element mre) {
        return loadModelEntry(mre, file, macros);
      }
    }).toListSequence();
  }

  private static ModelRoot loadModelEntry(final Element modelRootElement, final IFile file, final Macros macros) {
    return new _FunctionTypes._return_P0_E0<ModelRoot>() {
      public ModelRoot invoke() {
        final ModelRoot result_dxyzb6_a0a0a9 = new ModelRoot();
        final String result_dxyzb6_a0a0a0a9 = macros.expandPath(modelRootElement.getAttributeValue("path"), file);
        result_dxyzb6_a0a0a9.setPath(result_dxyzb6_a0a0a0a9);
        final ModelRootManager result_dxyzb6_a1a0a0a9 = new ModelRootManager();
        final String result_dxyzb6_a0a1a0a0a9 = AttributeUtils.stringWithDefault(ListSequence.fromList(AttributeUtils.elementChildren(modelRootElement, "manager")).first().getAttributeValue("moduleId"), "");
        result_dxyzb6_a1a0a0a9.setModuleId(result_dxyzb6_a0a1a0a0a9);
        final String result_dxyzb6_a1a1a0a0a9 = AttributeUtils.stringWithDefault(ListSequence.fromList(AttributeUtils.elementChildren(modelRootElement, "manager")).first().getAttributeValue("className"), "");
        result_dxyzb6_a1a0a0a9.setClassName(result_dxyzb6_a1a1a0a0a9);
        result_dxyzb6_a0a0a9.setManager(result_dxyzb6_a1a0a0a9);
        return result_dxyzb6_a0a0a9;
      }
    }.invoke();
  }

  public static void saveModelRoots(Element modelsElement, Set<ModelRoot> modelRoots, IFile file, Macros macros) {
    Element result_dxyzb6_a0a01 = modelsElement;
    for (ModelRoot root : SetSequence.fromSet(modelRoots)) {
      final Element result_dxyzb6_a0a0a0a01 = new Element("modelRoot");
      final String result_dxyzb6_a0a0a0a0a01 = macros.shrinkPath((root.getPath() == null ?
        "" :
        root.getPath()
      ), file);
      result_dxyzb6_a0a0a0a01.setAttribute("path", "" + result_dxyzb6_a0a0a0a0a01);
      if (root.getManager() != null) {
        final Element result_dxyzb6_a0a1a0a0a0a01 = new Element("manager");
        final String result_dxyzb6_a0a0a1a0a0a0a01 = root.getManager().getModuleId();
        result_dxyzb6_a0a1a0a0a0a01.setAttribute("moduleId", "" + result_dxyzb6_a0a0a1a0a0a0a01);
        final String result_dxyzb6_a1a0a1a0a0a0a01 = root.getManager().getClassName();
        result_dxyzb6_a0a1a0a0a0a01.setAttribute("className", "" + result_dxyzb6_a1a0a1a0a0a0a01);
        result_dxyzb6_a0a0a0a01.addContent(result_dxyzb6_a0a1a0a0a0a01);
      }
      result_dxyzb6_a0a01.addContent(result_dxyzb6_a0a0a0a01);
    }
  }

  public static void saveStubModelEntries(Element modelsElement, Set<ModelRoot> modelRoots, IFile file, Macros macros) {
    Element result_dxyzb6_a0a11 = modelsElement;
    for (ModelRoot root : SetSequence.fromSet(modelRoots)) {
      final Element result_dxyzb6_a0a0a0a11 = new Element("stubModelEntry");
      final String result_dxyzb6_a0a0a0a0a11 = macros.shrinkPath((root.getPath() == null ?
        "" :
        root.getPath()
      ), file);
      result_dxyzb6_a0a0a0a11.setAttribute("path", "" + result_dxyzb6_a0a0a0a0a11);
      final Element result_dxyzb6_a1a0a0a0a11 = new Element("manager");
      final String result_dxyzb6_a0a1a0a0a0a11 = root.getManager().getModuleId();
      result_dxyzb6_a1a0a0a0a11.setAttribute("moduleId", "" + result_dxyzb6_a0a1a0a0a0a11);
      final String result_dxyzb6_a1a1a0a0a0a11 = root.getManager().getClassName();
      result_dxyzb6_a1a0a0a0a11.setAttribute("className", "" + result_dxyzb6_a1a1a0a0a0a11);
      result_dxyzb6_a0a0a0a11.addContent(result_dxyzb6_a1a0a0a0a11);
      result_dxyzb6_a0a11.addContent(result_dxyzb6_a0a0a0a11);
    }
  }

  public static String getLanguageNamespace(IFile file) {
    // This method has no usages, probably it can be removed 
    try {
      Document document = JDOMUtil.loadDocument(file);
      return ((Element) document.getRootElement()).getAttributeValue("namespace");
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static void setTimestamp(ModuleDescriptor descriptor, IFile file) {
    descriptor.setTimestamp(Long.toString(file.lastModified()));
  }

  public static void loadBrokenModule(ModuleDescriptor md, IFile file, ModuleReadException exception) {
    md.setNamespace(FileUtil.getNameWithoutExtension(file.getName()));
    md.setUUID(UUID.randomUUID().toString());

    InputStreamReader r = null;
    try {
      r = new InputStreamReader(file.openInputStream(), FileUtil.DEFAULT_CHARSET);
      char[] buf = new char[1024];
      int readChars = r.read(buf);
      String s = new String(buf, 0, readChars);
      Pattern pattern = Pattern.compile(HEADER_PATTERN);
      for (String line : s.split("\n")) {
        Matcher m = pattern.matcher(line);
        if (m.matches()) {
          md.setNamespace(m.group(3));
          md.setUUID(m.group(4));
        }
      }
    } catch (IOException e) {
      if (log.isErrorEnabled()) {
        log.error("", e);
      }
    } finally {
      FileUtil.closeFileSafe(r);
    }
    setTimestamp(md, file);
    md.setLoadException((exception.getCause() == null ?
      exception :
      exception.getCause()
    ));
  }
}
