<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.transformation.generationContext.structure">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.bootstrap.structureLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.structureLanguage.constraints" version="11" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.constraints" version="6" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.constraints" version="21" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="1" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.constraints" version="83" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.core">
    <languageAspect modelUID="jetbrains.mps.core.constraints" version="2" />
  </language>
  <language namespace="jetbrains.mps.transformation.generationContext" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.internal.collections.constraints" version="2" />
  <languageAspect modelUID="jetbrains.mps.closures.constraints" version="2" />
  <maxImportIndex value="6" />
  <import index="1" modelUID="jetbrains.mps.transformation.generationContext.structure" version="-1" />
  <import index="2" modelUID="jetbrains.mps.transformation.TLBase.structure" version="1" />
  <import index="3" modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  <import index="4" modelUID="jetbrains.mps.core.structure" version="-1" />
  <import index="5" modelUID="jetbrains.mps.smodel@java_stub" version="-1" />
  <import index="6" modelUID="java.lang@java_stub" version="-1" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1216860049619">
    <property name="name" value="GenerationContextOp_Base" />
    <link role="extends" targetNodeId="4.1133920641626" resolveInfo="BaseConcept" />
    <node role="implements" type="jetbrains.mps.bootstrap.structureLanguage.structure.InterfaceConceptReference" id="1216860049620">
      <link role="intfc" targetNodeId="3.1197027803184" resolveInfo="IOperation" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1216860049621">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473854053" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1216860049622">
    <property name="name" value="GenerationContextOp_GetOutputByLabel" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1216860049623">
      <property name="role" value="label" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="2.1200911316486" resolveInfo="MappingLabelDeclaration" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1216860049625">
      <property name="value" value="get output by label" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217282035887">
      <property name="value" value="search output node" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1216860049626">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.PropertyDeclaration" id="1217271982808">
      <property name="name" value="labelName_intern" />
      <link role="dataType" targetNodeId="4.1082983041843" resolveInfo="string" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1216860049627">
    <property name="name" value="GenerationContextOp_GetOutputByLabelAndInput" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.PropertyDeclaration" id="1217272005596">
      <property name="name" value="labelName_intern" />
      <link role="dataType" targetNodeId="4.1082983041843" resolveInfo="string" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1216860049628">
      <property name="role" value="label" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="2.1200911316486" resolveInfo="MappingLabelDeclaration" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1216860049630">
      <property name="value" value="get output by label and input" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217282076780">
      <property name="value" value="search output node" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1216860049631">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1216860049632">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="inputNode" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="3.1068431790191" resolveInfo="Expression" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1216860049633">
    <property name="name" value="GenerationContextType" />
    <link role="extends" targetNodeId="3.1068431790189" resolveInfo="Type" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1216860049634">
      <property name="value" value="gencontext" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217362319643">
      <property name="value" value="generation context type" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1216860049635">
    <property name="name" value="TemplateFunctionParameter_generationContext" />
    <link role="extends" targetNodeId="3.1107135704075" resolveInfo="ConceptFunctionParameter" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1216860049636">
      <property name="value" value="genContext" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1216860049637">
      <property name="value" value="generation context parameter" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1216860049638">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1216861920336">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137545963098" resolveInfo="conceptFunctionParameterType" />
      <node role="target" type="jetbrains.mps.transformation.generationContext.structure.GenerationContextType" id="1216861951775" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1216945228272">
    <property name="name" value="GenerationContextOp_GetScope" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1216945228275">
      <property name="value" value="scope" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217281960527">
      <property name="value" value="access to IScope" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1216945228276">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1217026337388">
      <link role="conceptLinkDeclaration" targetNodeId="3.1217022095863" resolveInfo="returnType" />
      <node role="target" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1217026404184">
        <link role="classifier" targetNodeId="5.~IScope" resolveInfo="IScope" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217004708011">
    <property name="name" value="GenerationContextOp_GetInputModel" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217004708014">
      <property name="value" value="inputModel" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217281871506">
      <property name="value" value="current input model" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217004708015">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1217025941076">
      <link role="conceptLinkDeclaration" targetNodeId="3.1217022095863" resolveInfo="returnType" />
      <node role="target" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType" id="1217025946859" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217026863835">
    <property name="name" value="GenerationContextOp_GetOriginalInputModel" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217026863836">
      <property name="value" value="originalModel" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217281911229">
      <property name="value" value="original input model" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217026863837">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1217026863838">
      <link role="conceptLinkDeclaration" targetNodeId="3.1217022095863" resolveInfo="returnType" />
      <node role="target" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType" id="1217026863839" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217282130234">
    <property name="name" value="GenerationContextOp_GetOutputModel" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217282130235">
      <property name="value" value="outputModel" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217282130236">
      <property name="value" value="current output model" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217282130237">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1217282130238">
      <link role="conceptLinkDeclaration" targetNodeId="3.1217022095863" resolveInfo="returnType" />
      <node role="target" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType" id="1217282130239" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217369610610">
    <property name="name" value="GenerationContextOp_GetTemplateNode" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217369610611">
      <property name="value" value="templateNode" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217369610612">
      <property name="value" value="template node under macro" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217369610613">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1217369610614">
      <link role="conceptLinkDeclaration" targetNodeId="3.1217022095863" resolveInfo="returnType" />
      <node role="target" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1217369699850" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217881979074">
    <property name="name" value="GenerationContextOp_GetPrevInputByLabel" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1217881979075">
      <property name="role" value="label" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="2.1200911316486" resolveInfo="MappingLabelDeclaration" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217881979076">
      <property name="value" value="get prev input by label" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217881979077">
      <property name="value" value="search preceding input node" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217881979078">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.PropertyDeclaration" id="1217881979079">
      <property name="name" value="labelName_intern" />
      <link role="dataType" targetNodeId="4.1082983041843" resolveInfo="string" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217884725453">
    <property name="name" value="GenerationContextOp_GetCopiedOutputByInput" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217884725456">
      <property name="value" value="get copied output by input" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217884725457">
      <property name="value" value="search output node" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217884725458">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1217884725459">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="inputNode" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="3.1068431790191" resolveInfo="Expression" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217889725928">
    <property name="name" value="GenerationContextOp_SessionObjectAccess" />
    <link role="extends" targetNodeId="1217889960776" resolveInfo="GenerationContextOp_UserObjectAccessBase" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217889725929">
      <property name="value" value="session object" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473891462" resolveInfo="alias" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.StringConceptProperty" id="1217889725930">
      <property name="value" value="access to user object" />
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473914776" resolveInfo="short_description" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217891230226">
      <link role="conceptPropertyDeclaration" targetNodeId="3.1197029536315" resolveInfo="lvalue" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217889725931">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473994950" resolveInfo="dontSubstituteByDefault" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.structure.ConceptDeclaration" id="1217889960776">
    <property name="name" value="GenerationContextOp_UserObjectAccessBase" />
    <link role="extends" targetNodeId="1216860049619" resolveInfo="GenerationContextOp_Base" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.structure.BooleanConceptProperty" id="1217889977080">
      <link role="conceptPropertyDeclaration" targetNodeId="4.1137473854053" resolveInfo="abstract" />
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.structure.AggregationConceptLink" id="1217889993472">
      <link role="conceptLinkDeclaration" targetNodeId="3.1217022095863" resolveInfo="returnType" />
      <node role="target" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1217889997318">
        <link role="classifier" targetNodeId="6.~Object" resolveInfo="Object" />
      </node>
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration" id="1217890689512">
      <property name="metaClass" value="aggregation" />
      <property name="role" value="userKey" />
      <property name="sourceCardinality" value="1" />
      <link role="target" targetNodeId="3.1068431790191" resolveInfo="Expression" />
    </node>
  </node>
</model>

