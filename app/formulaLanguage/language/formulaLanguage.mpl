<?xml version="1.0" encoding="UTF-8"?>
<language namespace="jetbrains.mps.formulaLanguage" generatorOutputPath="${mps_home}\app\formulaLanguage\source_gen" compileInMPS="false">
  <models>
    <modelRoot path="${language_descriptor}\languageModels" namespacePrefix="jetbrains.mps.formulaLanguage" />
  </models>
  <accessoryModels />
  <generators>
    <generator generatorUID="jetbrains.mps.formulaLanguage#1130266266255">
      <models>
        <modelRoot path="${language_descriptor}\generator" namespacePrefix="jetbrains.mps.formulaLanguage.generator" />
      </models>
      <external-templates />
      <mapping-priorities />
    </generator>
  </generators>
  <classPath>
    <entry path="${mps_home}\app\formulaLanguage\classes" />
  </classPath>
  <languageRuntimeClassPath />
  <sourcePath />
  <dependencies>
    <dependency reexport="true">jetbrains.mps.regexp</dependency>
  </dependencies>
  <usedLanguages>
    <usedLanguages>jetbrains.mps.regexp</usedLanguages>
  </usedLanguages>
  <extendedLanguages />
</language>

