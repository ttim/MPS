<?xml version="1.0" encoding="UTF-8"?>
<language namespace="jetbrains.mps.baseLanguage.closures" uuid="fd392034-7849-419d-9071-12563d152375" java-stubs-enabled="false" compileInMPS="false" doNotGenerateAdapters="false">
  <models>
    <modelRoot path="${language_descriptor}/languageModels" namespacePrefix="jetbrains.mps.baseLanguage.closures" />
  </models>
  <accessoryModels>
    <model modelUID="r:c8f09818-27d0-4e31-9cdf-dedd92fee7ef(jetbrains.mps.baseLanguage.closures.util)" />
  </accessoryModels>
  <generators>
    <generator generatorUID="jetbrains.mps.baseLanguage.closures#1199623535494" uuid="857d0a79-6f44-4f46-84ed-9c5b42632011">
      <models>
        <modelRoot path="${language_descriptor}/generator/baseLanguage/template" namespacePrefix="jetbrains.mps.baseLanguage.closures.generator.baseLanguage.template" />
      </models>
      <external-templates />
      <dependencies>
        <dependency reexport="true">f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)</dependency>
        <dependency reexport="false">83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)</dependency>
        <dependency reexport="false">df345b11-b8c7-4213-ac66-48d2a9b75d88(jetbrains.mps.baseLanguageInternal)</dependency>
        <dependency reexport="false">7fa12e9c-b949-4976-b4fa-19accbc320b4(jetbrains.mps.lang.dataFlow)</dependency>
        <dependency reexport="false">9b80526e-f0bf-4992-bdf5-cee39c1833f3(collections.runtime)</dependency>
      </dependencies>
      <usedLanguages>
        <usedLanguage>5dc5fc0d-37ef-4782-8192-8b5ce1f69f80(jetbrains.mps.baseLanguage.extensionMethods)</usedLanguage>
        <usedLanguage>df345b11-b8c7-4213-ac66-48d2a9b75d88(jetbrains.mps.baseLanguageInternal)</usedLanguage>
      </usedLanguages>
      <mapping-priorities>
        <mapping-priority-rule kind="strictly_before">
          <greater-priority-mapping>
            <generator generatorUID="857d0a79-6f44-4f46-84ed-9c5b42632011(jetbrains.mps.baseLanguage.closures#1199623535494)" />
            <external-mapping>
              <mapping-node modelUID="r:00000000-0000-4000-0000-011c8959033a(jetbrains.mps.baseLanguage.closures.generator.baseLanguage.template.main@generator)" nodeID="608109309169734537" />
            </external-mapping>
          </greater-priority-mapping>
          <lesser-priority-mapping>
            <generator generatorUID="857d0a79-6f44-4f46-84ed-9c5b42632011(jetbrains.mps.baseLanguage.closures#1199623535494)" />
            <external-mapping>
              <mapping-node modelUID="r:00000000-0000-4000-0000-011c8959033a(jetbrains.mps.baseLanguage.closures.generator.baseLanguage.template.main@generator)" nodeID="1199623542211" />
            </external-mapping>
          </lesser-priority-mapping>
        </mapping-priority-rule>
      </mapping-priorities>
    </generator>
  </generators>
  <stubModelEntries>
    <stubModelEntry path="${language_descriptor}/classes" include="false">
      <manager moduleId="f3061a53-9226-4cc5-a443-f952ceaf5816" className="jetbrains.mps.baseLanguage.stubs.JavaStubs" />
    </stubModelEntry>
    <stubModelEntry path="${language_descriptor}/runtime/classes" include="false">
      <manager moduleId="f3061a53-9226-4cc5-a443-f952ceaf5816" className="jetbrains.mps.baseLanguage.stubs.JavaStubs" />
    </stubModelEntry>
  </stubModelEntries>
  <runtimeStubModels>
    <stubModelEntry path="${language_descriptor}/runtime/classes" include="false">
      <manager moduleId="f3061a53-9226-4cc5-a443-f952ceaf5816" className="jetbrains.mps.baseLanguage.stubs.JavaStubs" />
    </stubModelEntry>
  </runtimeStubModels>
  <sourcePath />
  <dependencies>
    <dependency reexport="false">37a3367b-1fb2-44d8-aa6b-18075e74e003(MPS.Classpath)</dependency>
    <dependency reexport="false">857d0a79-6f44-4f46-84ed-9c5b42632011(jetbrains.mps.baseLanguage.closures#1199623535494)</dependency>
    <dependency reexport="false">b401a680-8325-4110-8fd3-84331ff25bef(jetbrains.mps.lang.generator)</dependency>
    <dependency reexport="false">e7d4970e-3e9f-4cf0-a129-f5976c82d635(jetbrains.mps.lang.patterns#1174810948060)</dependency>
    <dependency reexport="false">7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)</dependency>
  </dependencies>
  <runtime>
    <dependency reexport="false">4c6a28d1-2c60-478d-b36e-db9b3cbb21fb(closures.runtime)</dependency>
  </runtime>
  <extendedLanguages>
    <extendedLanguage>f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)</extendedLanguage>
    <extendedLanguage>ceab5195-25ea-4f22-9b92-103b95ca8c0c(jetbrains.mps.lang.core)</extendedLanguage>
  </extendedLanguages>
</language>

