<?xml version="1.0" encoding="UTF-8"?>
<language namespace="jetbrains.mps.bootstrap.pluginLanguage" compileInMPS="false">
  <models>
    <modelRoot path="${language_descriptor}\languageModels" namespacePrefix="jetbrains.mps.bootstrap.pluginLanguage"/>
    <modelRoot path="${language_descriptor}\languageAccessories"
               namespacePrefix="jetbrains.mps.bootstrap.pluginLanguage"/>
  </models>
  <accessoryModels/>
  <generators>
    <generator generatorUID="jetbrains.mps.bootstrap.pluginLanguage#1203080439937"
               targetLanguage="jetbrains.mps.baseLanguage">
      <models>
        <modelRoot path="${language_descriptor}\generator\baseLanguage\template"
                   namespacePrefix="jetbrains.mps.bootstrap.pluginLanguage.generator.baseLanguage.template"/>
      </models>
      <external-templates/>
      <dependencies>
        <dependency reexport="false">jetbrains.mps.baseLanguage</dependency>
      </dependencies>
      <mapping-priorities/>
    </generator>
  </generators>
  <classPath/>
  <runtimeClassPath>
    <entry path="${language_descriptor}\classes"/>
  </runtimeClassPath>
  <sourcePath/>
  <osgiOptions>
    <requiredBundles/>
    <exportedPackage/>
  </osgiOptions>
  <extendedLanguages/>
</language>

