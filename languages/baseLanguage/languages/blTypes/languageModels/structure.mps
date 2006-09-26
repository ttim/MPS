<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.baseLanguage.blTypes.structure">
  <language namespace="jetbrains.mps.bootstrap.structureLanguage" />
  <maxImportIndex value="3" />
  <import index="1" modelUID="jetbrains.mps.core.structure" />
  <import index="2" modelUID="jetbrains.mps.baseLanguage.blTypes.structure" />
  <import index="3" modelUID="jetbrains.mps.baseLanguage.structure" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1159268361238">
    <property name="name" value="HelginsArrayType" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1159268361240">
      <property name="value" value="array" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1159268361241">
      <property name="value" value="internal array type" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1159268361239">
      <property name="sourceCardinality" value="0..1" />
      <property name="role" value="componentType" />
      <link role="target" targetNodeId="1.1078489098625" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1159268590033">
    <property name="rootable" value="true" />
    <property name="name" value="PrimitiveTypeDescriptor" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1159268590032">
      <property name="sourceCardinality" value="0..n" />
      <property name="role" value="extends" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1159268661480" resolveInfo="PrimitiveTypeRef" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1159268661480">
    <property name="name" value="PrimitiveTypeRef" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1159268661479">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="descriptor" />
      <link role="target" targetNodeId="1159268590033" resolveInfo="PrimitiveTypeDescriptor" />
    </node>
  </node>
</model>

