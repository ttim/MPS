<?xml version="1.0" encoding="UTF-8"?>
<language namespace="jetbrains.mps.ypath" compileInMPS="false">
  <models>
    <modelRoot path="${language_descriptor}\languageModels" namespacePrefix="jetbrains.mps.ypath" />
    <modelRoot path="${language_descriptor}\languageAccessories" namespacePrefix="jetbrains.mps.ypath" />
  </models>
  <accessoryModels>
    <model modelUID="r:1222075024816(jetbrains.mps.ypath.treepaths)" />
    <model modelUID="r:1222075024815(jetbrains.mps.ypath.internal.generator.helper)" />
  </accessoryModels>
  <generators>
    <generator generatorUID="ypath#1168438160182">
      <models>
        <modelRoot path="${language_descriptor}\generators\baseLanguage\templates" namespacePrefix="jetbrains.mps.ypath.generator.baseLanguage.template" />
      </models>
      <external-templates>
        <generator generatorUID="jetbrains.mps.baseLanguage#1129914002933" />
      </external-templates>
      <dependencies>
        <dependency reexport="true">jetbrains.mps.baseLanguage</dependency>
        <dependency reexport="true">jetbrains.mps.baseLanguageInternal</dependency>
        <dependency reexport="true">jetbrains.mps.closures</dependency>
        <dependency reexport="true">ypath#1168438160182</dependency>
      </dependencies>
      <usedLanguages>
        <usedLanguages>jetbrains.mps.baseLanguageInternal</usedLanguages>
        <usedLanguages>jetbrains.mps.ypath</usedLanguages>
        <usedLanguages>jetbrains.mps.closures</usedLanguages>
      </usedLanguages>
      <mapping-priorities>
        <mapping-priority-rule kind="strictly_before">
          <greater-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1191841379233" />
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1197288608511" />
          </lesser-priority-mapping>
        </mapping-priority-rule>
        <mapping-priority-rule kind="strictly_before">
          <greater-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1197288608511" />
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1195732300474" />
          </lesser-priority-mapping>
        </mapping-priority-rule>
        <mapping-priority-rule kind="strictly_before">
          <greater-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1195732300474" />
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1196711340877" />
          </lesser-priority-mapping>
        </mapping-priority-rule>
        <mapping-priority-rule kind="strictly_before">
          <greater-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1196711340877" />
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1190373998785" />
          </lesser-priority-mapping>
        </mapping-priority-rule>
        <mapping-priority-rule kind="strictly_before">
          <greater-priority-mapping>
            <mapping-node modelUID="r:1222075024817(jetbrains.mps.ypath.generator.baseLanguage.template.generic@generator)" nodeID="1190373998785" />
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <mapping-node modelUID="r:1222075024819(jetbrains.mps.ypath.generator.baseLanguage.template.main@generator)" nodeID="*" />
          </lesser-priority-mapping>
        </mapping-priority-rule>
        <mapping-priority-rule kind="strictly_together">
          <greater-priority-mapping>
            <mapping-node modelUID="r:1222075024819(jetbrains.mps.ypath.generator.baseLanguage.template.main@generator)" nodeID="1168438163478" />
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <generator generatorUID="jetbrains.mps.baseLanguage#1129914002933" />
            <external-mapping>
              <mapping-node modelUID="r:1222075024075(jetbrains.mps.baseLanguage.generator.java.closures@generator)" nodeID="*" />
            </external-mapping>
          </lesser-priority-mapping>
        </mapping-priority-rule>
      </mapping-priorities>
    </generator>
  </generators>
  <classPath>
    <entry path="${language_descriptor}\classes" />
    <entry path="${language_descriptor}\runtime\classes" />
  </classPath>
  <languageRuntimeClassPath>
    <entry path="${language_descriptor}\runtime\classes" />
  </languageRuntimeClassPath>
  <sourcePath />
  <extendedLanguages>
    <extendedLanguage>jetbrains.mps.core</extendedLanguage>
    <extendedLanguage>jetbrains.mps.baseLanguage</extendedLanguage>
    <extendedLanguage>jetbrains.mps.bootstrap.structureLanguage</extendedLanguage>
  </extendedLanguages>
</language>

