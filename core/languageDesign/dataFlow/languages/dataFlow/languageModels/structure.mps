<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.dataFlow.structure">
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
  <maxImportIndex value="4" />
  <import index="1" modelUID="jetbrains.mps.bootstrap.dataFlow.structure" version="-1" />
  <import index="2" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" version="-1" />
  <import index="3" modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  <import index="4" modelUID="jetbrains.mps.bootstrap.sharedConcepts.structure" version="-1" />
  <visible index="2" modelUID="jetbrains.mps.core.structure" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206442055221">
    <property name="name" value="DataFlowBuilder" />
    <property name="rootable" value="true" />
    <link role="extends" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1206442812839">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="builderBlock" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="1206442659665" resolveInfo="BuilderBlock" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1206442096288">
      <property name="role" value="conceptDeclaration" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="2.1169125787135" resolveInfo="AbstractConceptDeclaration" />
    </node>
    <node role="implements" type="jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference" id="1206442081098">
      <link role="intfc" targetNodeId="2v.1169194658468" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206442659665">
    <property name="name" value="BuilderBlock" />
    <property name="package" value="BuilderBlock" />
    <link role="extends" targetNodeId="3.1137021947720" resolveInfo="ConceptFunction" />
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.ReferenceConceptLink" id="1206442803478">
      <link role="conceptLinkDeclaration" targetNodeId="3.1161119487665" resolveInfo="applicableConceptFunctionParameter" />
      <link role="target" targetNodeId="1206442747519" resolveInfo="NodeParameter" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1206442717682">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137545148427" resolveInfo="conceptFunctionReturnType" />
      <node role="target" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1206442719043" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206442747519">
    <property name="name" value="NodeParameter" />
    <property name="package" value="BuilderBlock" />
    <link role="extends" targetNodeId="3.1107135704075" resolveInfo="ConceptFunctionParameter" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206442776255">
      <property name="value" value="node" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1206442792945">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206443583064">
    <property name="name" value="EmitStatement" />
    <property name="package" value="Instructions" />
    <link role="extends" targetNodeId="3.1068580123157" resolveInfo="Statement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1206443598502">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473854053" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206443660532">
    <property name="package" value="Instructions" />
    <property name="name" value="EmitNopStatement" />
    <link role="extends" targetNodeId="1206443583064" resolveInfo="EmitInstructionStatement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206443676814">
      <property name="value" value="nop" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206443823146">
    <property name="package" value="Instructions.Variable" />
    <property name="name" value="EmitReadStatement" />
    <link role="extends" targetNodeId="1206444622344" resolveInfo="EmitVariableStatement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206443845242">
      <property name="value" value="read" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206444349662">
    <property name="package" value="Instructions.Variable" />
    <property name="name" value="EmitWriteStatement" />
    <link role="extends" targetNodeId="1206444622344" resolveInfo="EmitVariableStatement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206444399445">
      <property name="value" value="write" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206444622344">
    <property name="package" value="Instructions.Variable" />
    <property name="name" value="BaseEmitVariableStatement" />
    <link role="extends" targetNodeId="1206443583064" resolveInfo="EmitStatement" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1206444629799">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="variable" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="3.1068431790191" resolveInfo="Expression" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1206444683066">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473854053" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206444875712">
    <property name="name" value="Position" />
    <property name="package" value="Positions" />
    <link role="extends" targetNodeId="2v.1133920641626" resolveInfo="BaseConcept" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1206444890198">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473854053" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206444910183">
    <property name="package" value="Positions" />
    <property name="name" value="RelativePosition" />
    <link role="extends" targetNodeId="1206444875712" resolveInfo="Position" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1206444923842">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="relativeTo" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="3.1068431790191" resolveInfo="Expression" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1206444922122">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473854053" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206445069217">
    <property name="package" value="Positions" />
    <property name="name" value="BeforePosition" />
    <link role="extends" targetNodeId="1206444910183" resolveInfo="RelativePosition" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206445077405">
      <property name="value" value="before" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206445082906">
    <property name="package" value="Positions" />
    <property name="name" value="AfterPosition" />
    <link role="extends" targetNodeId="1206444910183" resolveInfo="RelativePosition" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206445101611">
      <property name="value" value="after" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206445181593">
    <property name="package" value="Instructions.Jump" />
    <property name="name" value="BaseEmitJumpStatement" />
    <link role="extends" targetNodeId="1206443583064" resolveInfo="EmitStatement" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1206445193860">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="jumpTo" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="1206444875712" resolveInfo="Position" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1206445189609">
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473854053" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206445295557">
    <property name="package" value="Instructions.Jump" />
    <property name="name" value="EmitIfJumpStatement" />
    <link role="extends" targetNodeId="1206445181593" resolveInfo="EmitJumpStatement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206445305386">
      <property name="value" value="ifjump" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1206445310309">
    <property name="package" value="Instructions.Jump" />
    <property name="name" value="EmitJumpStatement" />
    <link role="extends" targetNodeId="1206445181593" resolveInfo="BaseEmitJumpStatement" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1206445353264">
      <property name="value" value="jump" />
      <link role="conceptPropertyDeclaration" targetNodeId="2v.1137473891462" resolveInfo="alias" />
    </node>
  </node>
</model>

