<?xml version="1.0" encoding="UTF-8"?>
<language namespace="jetbrains.mps.baseLanguage.blTypes" generatorOutputPath="${mps_home}\source_gen" compileInMPS="false">
  <structure>
    <model modelUID="jetbrains.mps.baseLanguage.blTypes.structure" />
  </structure>
  <constraints>
    <model modelUID="jetbrains.mps.baseLanguage.blTypes.constraints" />
  </constraints>
  <editor>
    <model modelUID="jetbrains.mps.baseLanguage.blTypes.editor" />
  </editor>
  <models>
    <modelRoot path="${language_descriptor}\languageModels" namespacePrefix="jetbrains.mps.baseLanguage.blTypes" />
    <modelRoot path="${language_descriptor}\languageAccessories" namespacePrefix="jetbrains.mps.baseLanguage.blTypes" />
  </models>
  <module />
  <accessoryModels>
    <model modelUID="jetbrains.mps.baseLanguage.blTypes.primitiveDescriptors" />
  </accessoryModels>
  <generators />
  <classPath />
  <runtimeClassPath />
  <sourcePath />
  <osgiOptions>
    <requiredBundles />
    <exportedPackage />
  </osgiOptions>
  <dependencies>
    <dependency>jetbrains.mps.baseLanguage</dependency>
  </dependencies>
</language>

