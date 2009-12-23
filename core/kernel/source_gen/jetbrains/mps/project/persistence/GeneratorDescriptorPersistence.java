package jetbrains.mps.project.persistence;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.project.structure.modules.GeneratorDescriptor;
import org.jdom.Element;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.util.Macros;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.xmlQuery.runtime.AttributeUtils;
import jetbrains.mps.project.structure.modules.ModuleReference;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingPriorityRule;
import jetbrains.mps.project.structure.modules.mappingpriorities.RuleType;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_AbstractRef;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefAllLocal;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefAllGlobal;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_SimpleRef;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_ExternalRef;
import jetbrains.mps.project.structure.modules.mappingpriorities.MappingConfig_RefSet;

public class GeneratorDescriptorPersistence {
  protected static Log log = LogFactory.getLog(GeneratorDescriptorPersistence.class);

  public static GeneratorDescriptor loadGeneratorDescriptor(final Element generatorElement, final IFile file, final Macros macros) {
    GeneratorDescriptor descriptor = new _FunctionTypes._return_P0_E0<GeneratorDescriptor>() {
      public GeneratorDescriptor invoke() {
        GeneratorDescriptor result_9427_0 = new GeneratorDescriptor();
        String genUID = generatorElement.getAttributeValue("generatorUID");
        String result_9427_1 = genUID;
        result_9427_0.setGeneratorUID(result_9427_1);

        if (generatorElement.getAttributeValue("uuid") != null) {
          String result_9427_2 = generatorElement.getAttributeValue("uuid");
          result_9427_0.setUUID(result_9427_2);
        }

        if (generatorElement.getAttributeValue("name") != null) {
          String result_9427_3 = generatorElement.getAttributeValue("name");
          result_9427_0.setNamespace(result_9427_3);
        }

        if (ListSequence.fromList(AttributeUtils.elementChildren(generatorElement, "models")).isNotEmpty()) {
          result_9427_0.getModelRoots().addAll(ModuleDescriptorPersistence.loadModelRoots(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(generatorElement, "models")).first(), "modelRoot"), file, macros));
        } else {
          // old - for backwards compatibility 
          result_9427_0.getModelRoots().addAll(ModuleDescriptorPersistence.loadModelRoots(AttributeUtils.elementChildren(generatorElement, "modelRoot"), file, macros));
        }

        ModuleDescriptorPersistence.loadDependencies(result_9427_0, generatorElement);

        // "depends on" generators 
        for (Element refGenerator : ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(generatorElement, "external-templates")).first(), "generator"))) {
          result_9427_0.getDepGenerators().add(ModuleReference.fromString(refGenerator.getAttributeValue("generatorUID")));
        }

        for (Element ruleElement : ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(generatorElement, "mapping-priorities")).first(), "mapping-priority-rule"))) {
          MappingPriorityRule result_9427_4 = new MappingPriorityRule();
          // TODO: remove when the error disappear. Remove trim() also 
          try {
            RuleType result_9427_5 = RuleType.parse(ruleElement.getAttributeValue("kind").trim());
            result_9427_4.setType(result_9427_5);
          } catch (IllegalArgumentException e) {
            if (log.isErrorEnabled()) {
              log.error(e.getMessage() + " Rule type for generator " + genUID + " is set to EQUALS. You can change this in Generator Properties dialog.", e);
            }
            RuleType result_9427_6 = RuleType.STRICTLY_TOGETHER;
            result_9427_4.setType(result_9427_6);
          }

          if (ListSequence.fromList(AttributeUtils.elementChildren(ruleElement, "greater-priority-mapping")).isNotEmpty()) {
            MappingConfig_AbstractRef result_9427_7 = loadGeneratorMappingConfigRef(ListSequence.fromList(AttributeUtils.elementChildren(ruleElement, "greater-priority-mapping")).first(), genUID, false);
            result_9427_4.setLeft(result_9427_7);
          }
          if (ListSequence.fromList(AttributeUtils.elementChildren(ruleElement, "lesser-priority-mapping")).isNotEmpty()) {
            MappingConfig_AbstractRef result_9427_8 = loadGeneratorMappingConfigRef(ListSequence.fromList(AttributeUtils.elementChildren(ruleElement, "lesser-priority-mapping")).first(), genUID, false);
            result_9427_4.setRight(result_9427_8);
          }
          result_9427_0.getPriorityRules().add(result_9427_4);
        }
        return result_9427_0;
      }
    }.invoke();
    ModuleDescriptorPersistence.setTimestamp(descriptor, file, false);
    return descriptor;
  }

  public static void saveGeneratorDescriptor(Element languageGeneratorsElement, GeneratorDescriptor descriptor, IFile file, Macros macros) {
    Element result_9427_9 = languageGeneratorsElement;
    Element result_9427_10 = new Element("generator");
    if (descriptor.getNamespace() != null) {
      String result_9427_11 = descriptor.getNamespace();
      result_9427_10.setAttribute("name", "" + result_9427_11);
    }
    if (descriptor.getGeneratorUID() != null) {
      String result_9427_12 = descriptor.getGeneratorUID();
      result_9427_10.setAttribute("generatorUID", "" + result_9427_12);
    }
    if (descriptor.getUUID() != null) {
      String result_9427_13 = descriptor.getUUID();
      result_9427_10.setAttribute("uuid", "" + result_9427_13);
    }

    Element result_9427_14 = new Element("models");
    ModuleDescriptorPersistence.saveModelRoots(result_9427_14, descriptor.getModelRoots(), file, macros);
    result_9427_10.addContent(result_9427_14);

    // "depends on" generators 
    Element result_9427_15 = new Element("external-templates");
    for (ModuleReference generatorReference : ListSequence.fromList(descriptor.getDepGenerators())) {
      Element result_9427_16 = new Element("generator");
      String result_9427_17 = generatorReference.toString();
      result_9427_16.setAttribute("generatorUID", "" + result_9427_17);
      result_9427_15.addContent(result_9427_16);
    }
    result_9427_10.addContent(result_9427_15);

    ModuleDescriptorPersistence.saveDependencies(result_9427_10, descriptor);

    // mapping priority rules 
    Element result_9427_18 = new Element("mapping-priorities");
    for (MappingPriorityRule rule : ListSequence.fromList(descriptor.getPriorityRules())) {
      Element result_9427_19 = new Element("mapping-priority-rule");
      String result_9427_20 = rule.getType().getName();
      result_9427_19.setAttribute("kind", "" + result_9427_20);
      Element result_9427_21 = new Element("greater-priority-mapping");
      saveGeneratorMappingConfigRef(rule.getLeft(), result_9427_21);
      result_9427_19.addContent(result_9427_21);
      Element result_9427_22 = new Element("lesser-priority-mapping");
      saveGeneratorMappingConfigRef(rule.getRight(), result_9427_22);
      result_9427_19.addContent(result_9427_22);
      result_9427_18.addContent(result_9427_19);
    }
    result_9427_10.addContent(result_9427_18);

    // Refresh was removed here, since this method is only called in 
    // LanguageDescriptorPersistence.saveLanguageDescriptor method, 
    // which does refresh at the en 
    result_9427_9.addContent(result_9427_10);
  }

  private static void saveGeneratorMappingConfigRef(MappingConfig_AbstractRef mappingRef, Element parentElement) {
    Element result_9427_23 = parentElement;
    if (mappingRef instanceof MappingConfig_RefAllLocal) {
      Element result_9427_24 = new Element("all-local-mappings");
      result_9427_23.addContent(result_9427_24);
    } else if (mappingRef instanceof MappingConfig_RefAllGlobal) {
      Element result_9427_25 = new Element("all-mappings");
      result_9427_23.addContent(result_9427_25);
    } else if (mappingRef instanceof MappingConfig_SimpleRef) {
      Element result_9427_26 = new Element("mapping-node");
      String result_9427_27 = ((MappingConfig_SimpleRef) mappingRef).getModelUID();
      result_9427_26.setAttribute("modelUID", "" + result_9427_27);
      String result_9427_28 = ((MappingConfig_SimpleRef) mappingRef).getNodeID();
      result_9427_26.setAttribute("nodeID", "" + result_9427_28);
      result_9427_23.addContent(result_9427_26);
    } else if (mappingRef instanceof MappingConfig_ExternalRef) {
      Element result_9427_29 = new Element("generator");
      String result_9427_30 = ((MappingConfig_ExternalRef) mappingRef).getGenerator().toString();
      result_9427_29.setAttribute("generatorUID", "" + result_9427_30);
      result_9427_23.addContent(result_9427_29);
      Element result_9427_31 = new Element("external-mapping");
      saveGeneratorMappingConfigRef(((MappingConfig_ExternalRef) mappingRef).getMappingConfig(), result_9427_31);
      result_9427_23.addContent(result_9427_31);
    } else if (mappingRef instanceof MappingConfig_RefSet) {
      Element result_9427_32 = new Element("mapping-set");
      for (MappingConfig_AbstractRef mappingRefInner : ListSequence.fromList(((MappingConfig_RefSet) mappingRef).getMappingConfigs())) {
        Element result_9427_33 = new Element("mapping-set-element");
        saveGeneratorMappingConfigRef(mappingRefInner, result_9427_33);
        result_9427_32.addContent(result_9427_33);
      }
      result_9427_23.addContent(result_9427_32);
    }
  }

  public static MappingConfig_AbstractRef loadGeneratorMappingConfigRef(final Element parentElement, final String genUID, boolean childOfGen) {
    if (ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "all-mappings")).isNotEmpty()) {
      return new MappingConfig_RefAllGlobal();
    } else if (ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "all-local-mappings")).isNotEmpty()) {
      final MappingConfig_RefAllLocal local = new MappingConfig_RefAllLocal();
      if (childOfGen) {
        return local;
      }

      return new _FunctionTypes._return_P0_E0<MappingConfig_ExternalRef>() {
        public MappingConfig_ExternalRef invoke() {
          MappingConfig_ExternalRef result_9427_34 = new MappingConfig_ExternalRef();
          ModuleReference result_9427_35 = ModuleReference.fromString(genUID);
          result_9427_34.setGenerator(result_9427_35);
          MappingConfig_AbstractRef result_9427_36 = local;
          result_9427_34.setMappingConfig(result_9427_36);
          return result_9427_34;
        }
      }.invoke();
    } else if (ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "mapping-set")).isNotEmpty()) {
      final MappingConfig_RefSet mappingSet = new MappingConfig_RefSet();
      for (Element mappingSetElement : ListSequence.fromList(AttributeUtils.elementChildren(ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "mapping-set")).first(), "mapping-set-element"))) {
        mappingSet.getMappingConfigs().add(loadGeneratorMappingConfigRef(mappingSetElement, genUID, true));
      }

      if (childOfGen) {
        return mappingSet;
      }

      return new _FunctionTypes._return_P0_E0<MappingConfig_ExternalRef>() {
        public MappingConfig_ExternalRef invoke() {
          MappingConfig_ExternalRef result_9427_37 = new MappingConfig_ExternalRef();
          ModuleReference result_9427_38 = ModuleReference.fromString(genUID);
          result_9427_37.setGenerator(result_9427_38);
          MappingConfig_AbstractRef result_9427_39 = mappingSet;
          result_9427_37.setMappingConfig(result_9427_39);
          return result_9427_37;
        }
      }.invoke();
    } else if (ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "generator")).isNotEmpty()) {
      // external reference 
      return new _FunctionTypes._return_P0_E0<MappingConfig_ExternalRef>() {
        public MappingConfig_ExternalRef invoke() {
          MappingConfig_ExternalRef result_9427_40 = new MappingConfig_ExternalRef();
          ModuleReference result_9427_41 = ModuleReference.fromString(ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "generator")).first().getAttributeValue("generatorUID"));
          result_9427_40.setGenerator(result_9427_41);
          MappingConfig_AbstractRef result_9427_42 = loadGeneratorMappingConfigRef(ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "external-mapping")).first(), ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "generator")).first().getAttributeValue("generatorUID"), true);
          result_9427_40.setMappingConfig(result_9427_42);
          return result_9427_40;
        }
      }.invoke();
    } else if (ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "mapping-node")).isNotEmpty()) {
      // simple reference 
      ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "mapping-node")).first();

      final MappingConfig_SimpleRef mapping_SimpleRef = new MappingConfig_SimpleRef();
      MappingConfig_SimpleRef result_9427_43 = mapping_SimpleRef;
      String result_9427_44 = ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "mapping-node")).first().getAttributeValue("modelUID");
      result_9427_43.setModelUID(result_9427_44);
      String result_9427_45 = ListSequence.fromList(AttributeUtils.elementChildren(parentElement, "mapping-node")).first().getAttributeValue("nodeID");
      result_9427_43.setNodeID(result_9427_45);

      if (childOfGen) {
        return mapping_SimpleRef;
      }

      return new _FunctionTypes._return_P0_E0<MappingConfig_ExternalRef>() {
        public MappingConfig_ExternalRef invoke() {
          MappingConfig_ExternalRef result_9427_46 = new MappingConfig_ExternalRef();
          ModuleReference result_9427_47 = ModuleReference.fromString(genUID);
          result_9427_46.setGenerator(result_9427_47);
          MappingConfig_AbstractRef result_9427_48 = mapping_SimpleRef;
          result_9427_46.setMappingConfig(result_9427_48);
          return result_9427_46;
        }
      }.invoke();
    }

    // empty? 
    return new MappingConfig_AbstractRef();
  }
}
