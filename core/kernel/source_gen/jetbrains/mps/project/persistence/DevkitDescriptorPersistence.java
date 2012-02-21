package jetbrains.mps.project.persistence;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.project.structure.modules.DevkitDescriptor;
import jetbrains.mps.vfs.IFile;
import org.jdom.Document;
import jetbrains.mps.util.JDOMUtil;
import org.jdom.Element;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.xmlQuery.runtime.AttributeUtils;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.io.OutputStream;

public class DevkitDescriptorPersistence {
  protected static Log log = LogFactory.getLog(DevkitDescriptorPersistence.class);

  private DevkitDescriptorPersistence() {
  }

  public static DevkitDescriptor loadDevKitDescriptor(IFile file) {
    try {
      Document document = JDOMUtil.loadDocument(file);
      final Element root = ((Element) document.getRootElement());
      DevkitDescriptor descriptor = new _FunctionTypes._return_P0_E0<DevkitDescriptor>() {
        public DevkitDescriptor invoke() {
          final DevkitDescriptor result_raojav_a0a0c0a0a = new DevkitDescriptor();
          final String result_raojav_a0a0a0c0a0a = root.getAttributeValue("name");
          result_raojav_a0a0c0a0a.setNamespace(result_raojav_a0a0a0c0a0a);
          final String result_raojav_a1a0a0c0a0a = root.getAttributeValue("uuid");
          result_raojav_a0a0c0a0a.setUUID(result_raojav_a1a0a0c0a0a);

          ModuleDescriptorPersistence.loadDependencies(result_raojav_a0a0c0a0a, root);

          for (Element exportedLang : ListSequence.fromList(AttributeUtils.elementChildren(root, "exported-language"))) {
            result_raojav_a0a0c0a0a.getExportedLanguages().add(ModuleReference.fromString(exportedLang.getAttributeValue("name")));
          }

          for (Element xde : ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(root, "extendedDevKits")).first(), "extendedDevKit"))) {
            result_raojav_a0a0c0a0a.getExtendedDevkits().add(ModuleReference.fromString(xde.getText()));
          }

          for (Element xse : ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(root, "exported-solutions")).first(), "exported-solution"))) {
            result_raojav_a0a0c0a0a.getExportedSolutions().add(ModuleReference.fromString(xse.getText()));
          }
          return result_raojav_a0a0c0a0a;
        }
      }.invoke();

      ModuleDescriptorPersistence.setTimestamp(descriptor, file);
      return descriptor;
    } catch (Exception e) {
      throw new ModuleReadException(e);
    }
  }

  public static void saveDevKitDescriptor(final DevkitDescriptor descriptor, IFile file) {
    Element root = new _FunctionTypes._return_P0_E0<Element>() {
      public Element invoke() {
        final Element result_raojav_a0a0a0b = new Element("dev-kit");
        final String result_raojav_a0a0a0a0b = descriptor.getNamespace();
        result_raojav_a0a0a0b.setAttribute("name", "" + result_raojav_a0a0a0a0b);

        if (descriptor.getUUID() != null) {
          final String result_raojav_a0a2a0a0a0b = descriptor.getUUID();
          result_raojav_a0a0a0b.setAttribute("uuid", "" + result_raojav_a0a2a0a0a0b);
        }

        ModuleDescriptorPersistence.saveDependencies(result_raojav_a0a0a0b, descriptor);

        for (ModuleReference lang : SetSequence.fromSet(descriptor.getExportedLanguages())) {
          final Element result_raojav_a0a6a0a0a0b = new Element("exported-language");
          final String result_raojav_a0a0a6a0a0a0b = lang.toString();
          result_raojav_a0a6a0a0a0b.setAttribute("name", "" + result_raojav_a0a0a6a0a0a0b);
          result_raojav_a0a0a0b.addContent(result_raojav_a0a6a0a0a0b);
        }

        if (!(descriptor.getExtendedDevkits().isEmpty())) {
          final Element result_raojav_a0a8a0a0a0b = new Element("extendedDevKits");
          for (ModuleReference ref : SetSequence.fromSet(descriptor.getExtendedDevkits())) {
            final Element result_raojav_a0a0a0a8a0a0a0b = new Element("extendedDevKit");
            final String result_raojav_a0a0a0a0a8a0a0a0b = ref.toString();
            result_raojav_a0a0a0a8a0a0a0b.setText(result_raojav_a0a0a0a0a8a0a0a0b);
            result_raojav_a0a8a0a0a0b.addContent(result_raojav_a0a0a0a8a0a0a0b);
          }
          result_raojav_a0a0a0b.addContent(result_raojav_a0a8a0a0a0b);
        }

        if (!(descriptor.getExportedSolutions().isEmpty())) {
          final Element result_raojav_a0a01a0a0a0b = new Element("exported-solutions");
          for (ModuleReference ref : SetSequence.fromSet(descriptor.getExportedSolutions())) {
            final Element result_raojav_a0a0a0a01a0a0a0b = new Element("exported-solution");
            final String result_raojav_a0a0a0a0a01a0a0a0b = ref.toString();
            result_raojav_a0a0a0a01a0a0a0b.setText(result_raojav_a0a0a0a0a01a0a0a0b);
            result_raojav_a0a01a0a0a0b.addContent(result_raojav_a0a0a0a01a0a0a0b);
          }
          result_raojav_a0a0a0b.addContent(result_raojav_a0a01a0a0a0b);
        }
        return result_raojav_a0a0a0b;
      }
    }.invoke();

    try {
      OutputStream os = file.openOutputStream();
      JDOMUtil.writeDocument(new Document(root), os);
    } catch (Exception e) {
      if (log.isErrorEnabled()) {
        log.error("", e);
      }
    }

    ModuleDescriptorPersistence.setTimestamp(descriptor, file);
  }
}
