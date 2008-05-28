<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.transformationTest.structure">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.bootstrap.structureLanguage" />
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.core" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <maxImportIndex value="4" />
  <import index="1" modelUID="jetbrains.mps.transformationTest.structure" version="-1" />
  <import index="2" modelUID="jetbrains.mps.patterns.util@java_stub" version="-1" />
  <import index="4" modelUID="java.util@java_stub" version="-1" />
  <visible index="2" modelUID="jetbrains.mps.core.structure" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1210254477612">
    <property name="name" value="TransformationTest" />
    <property name="rootable" value="true" />
    <link role="extends" targetNodeId="1211372351318" resolveInfo="AbstractNodeTest" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1210254502524">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="afterTransformation" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1210673026340">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="test" />
      <link role="target" targetNodeId="1210672408508" resolveInfo="TransformTest" />
    </node>
    <node role="implements" type="jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference" id="1210254486161">
      <link role="intfc" targetNodeId="2v.1169194658468" resolveInfo="INamedConcept" />
    </node>
  </node>
  <visible index="3" modelUID="jetbrains.mps.baseLanguage.structure" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1210672408508">
    <property name="name" value="TransformationTestMethod" />
    <link role="extends" targetNodeId="3v.1137021947720" resolveInfo="ConceptFunction" />
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1210672510360">
      <link role="conceptLinkDeclaration" targetNodeId="3v.1137545148427" resolveInfo="conceptFunctionReturnType" />
      <node role="target" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1210672511630" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.ReferenceConceptLink" id="1210672566480">
      <link role="conceptLinkDeclaration" targetNodeId="3v.1161119487665" resolveInfo="applicableConceptFunctionParameter" />
      <link role="target" targetNodeId="1210672520482" resolveInfo="TransformTestParameter_Node" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1210672520482">
    <property name="name" value="TransformTestParameter_Node" />
    <link role="extends" targetNodeId="3v.1107135704075" resolveInfo="ConceptFunctionParameter" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1210672556321">
      <property name="value" value="node" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1210672600407">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.AnnotationLinkDeclaration" id="1210673592080">
    <property name="role" value="testNode" />
    <link role="source" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    <link role="target" targetNodeId="1210673684636" resolveInfo="TestNodeAnnotation" />
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1210673684636">
    <property name="name" value="TestNodeAnnotation" />
    <link role="extends" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    <node role="implements" type="jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference" id="1210673695631">
      <link role="intfc" targetNodeId="2v.1169194658468" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1210674524691">
    <property name="name" value="TestNodeReference" />
    <link role="extends" targetNodeId="3v.1068431790191" resolveInfo="Expression" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1210674534086">
      <property name="role" value="declaration" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="1210673684636" resolveInfo="TestNodeAnnotation" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1211372351318">
    <property name="name" value="AbstractNodeTest" />
    <property name="rootable" value="false" />
    <link role="extends" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211372386867">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="nodeToCheck" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    </node>
    <node role="implements" type="jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference" id="1211372425154">
      <link role="intfc" targetNodeId="2v.1169194658468" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1211372488595">
    <property name="name" value="SingleNodeTest" />
    <property name="rootable" value="true" />
    <link role="extends" targetNodeId="1211372351318" resolveInfo="AbstractNodeTest" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211372504409">
      <property name="metaClass" value="aggregation" />
      <property name="sourceCardinality" value="1" />
      <property name="role" value="nodeToChek" />
      <link role="target" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
      <link role="specializedLink" targetNodeId="1211372386867" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211372551005">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="testMethod" />
      <link role="target" targetNodeId="1210672408508" resolveInfo="TransformationTestMethod" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1211896175875">
    <property name="name" value="NodesTest" />
    <property name="rootable" value="true" />
    <link role="extends" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    <node role="implements" type="jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference" id="1211896369962">
      <link role="intfc" targetNodeId="2v.1169194658468" resolveInfo="INamedConcept" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211896210986">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="nodeToCheck" />
      <property name="sourceCardinality" value="0..n" />
      <link role="target" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211896246660">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="testMethod" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="3v.1068580123136" resolveInfo="StatementList" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1211979288880">
    <property name="name" value="AssertMatch" />
    <link role="extends" targetNodeId="3v.1068580123157" resolveInfo="Statement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1211979384649">
      <property name="value" value="assert match" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211979305365">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="before" />
      <property name="sourceCardinality" value="0..n" />
      <link role="target" targetNodeId="3v.1068431790191" resolveInfo="Expression" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1211979322383">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="after" />
      <property name="sourceCardinality" value="0..n" />
      <link role="target" targetNodeId="3v.1068431790191" resolveInfo="Expression" />
    </node>
  </node>
</model>

