<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.structureLanguage.structure">
  <language namespace="jetbrains.mps.bootstrap.structureLanguage" />
  <maxImportIndex value="3" />
  <import index="1" modelUID="jetbrains.mps.core.structure" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1071489090640">
    <property name="iconPath" value="${language_descriptor}\icons\structure.png" />
    <property name="rootable" value="true" />
    <property name="name" value="ConceptDeclaration" />
    <link role="extends" targetNodeId="1169125787135" resolveInfo="AbstractConceptDeclaration" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1096454100552">
      <property name="name" value="rootable" />
      <link role="dataType" targetNodeId="1.1082983657063" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1160488491229">
      <property name="name" value="iconPath" />
      <link role="dataType" targetNodeId="1.1082983041843" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1071489389519">
      <property name="sourceCardinality" value="0..1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="extends" />
      <link role="target" targetNodeId="1071489090640" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1169129564478">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="implements" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1169127622168" resolveInfo="InterfaceConceptReference" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1071489288298">
    <property name="name" value="LinkDeclaration" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1071599776563">
      <property name="propertyType" value="string" />
      <property name="name" value="role" />
      <link role="dataType" targetNodeId="1.1082983041843" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1071599937831">
      <property name="propertyType" value="string" />
      <property name="name" value="metaClass" />
      <link role="dataType" targetNodeId="1084199179703" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1071599893252">
      <property name="propertyType" value="string" />
      <property name="name" value="sourceCardinality" />
      <link role="dataType" targetNodeId="1084197782722" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1071599937832">
      <property name="propertyType" value="string" />
      <property name="name" value="targetCardinality" />
      <link role="dataType" targetNodeId="1084197782722" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1071599698500">
      <property name="sourceCardinality" value="0..1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="specializedLink" />
      <link role="target" targetNodeId="1071489288298" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1071599976176">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="target" />
      <link role="target" targetNodeId="1071489090640" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1071489288299">
    <property name="name" value="PropertyDeclaration" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1082985295845">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="dataType" />
      <link role="target" targetNodeId="1082978164218" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1082978164218">
    <property name="name" value="DataTypeDeclaration" />
    <link role="extends" targetNodeId="1.1078489098625" />
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1082978164219">
    <property name="iconPath" value="${language_descriptor}\icons\enum.png" />
    <property name="rootable" value="true" />
    <property name="name" value="EnumerationDataTypeDeclaration" />
    <link role="extends" targetNodeId="1082978164218" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1083171729157">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="memberDataType" />
      <link role="target" targetNodeId="1083243159079" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1083241965437">
      <property name="sourceCardinality" value="0..1" />
      <property name="targetCardinality" value="0..1" />
      <property name="role" value="defaultMember" />
      <link role="target" targetNodeId="1083171877298" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1083172003582">
      <property name="sourceCardinality" value="1..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="member" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1083171877298" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1082978499127">
    <property name="iconPath" value="${language_descriptor}\icons\constrainedTD.png" />
    <property name="rootable" value="true" />
    <property name="name" value="ConstrainedDataTypeDeclaration" />
    <link role="extends" targetNodeId="1082978164218" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1083066089218">
      <property name="propertyType" value="string" />
      <property name="name" value="constraint" />
      <link role="dataType" targetNodeId="1.1082983041843" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1083171877298">
    <property name="name" value="EnumerationMemberDeclaration" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1083923523171">
      <property name="propertyType" value="string" />
      <property name="name" value="internalValue" />
      <link role="dataType" targetNodeId="1.1082983041843" />
    </node>
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1083923523172">
      <property name="propertyType" value="string" />
      <property name="name" value="externalValue" />
      <link role="dataType" targetNodeId="1.1082983041843" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1083243159079">
    <property name="iconPath" value="${language_descriptor}\icons\primitiveTD.png" />
    <property name="name" value="PrimitiveDataTypeDeclaration" />
    <link role="extends" targetNodeId="1082978164218" />
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.EnumerationDataTypeDeclaration" id="1084197782722">
    <property name="name" value="Cardinality" />
    <link role="memberDataType" targetNodeId="1.1082983041843" />
    <link role="defaultMember" targetNodeId="1084197782723" resolveInfo="_0_1" />
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1084197782723">
      <property name="externalValue" value="0..1" />
      <property name="internalValue" value="0..1" />
      <property name="name" value="_0_1" />
    </node>
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1084197782724">
      <property name="externalValue" value="1" />
      <property name="internalValue" value="1" />
      <property name="name" value="_1" />
    </node>
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1084197782725">
      <property name="externalValue" value="0..n" />
      <property name="internalValue" value="0..n" />
      <property name="name" value="_0_n" />
    </node>
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1084197782726">
      <property name="externalValue" value="1..n" />
      <property name="internalValue" value="1..n" />
      <property name="name" value="_1_n" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.EnumerationDataTypeDeclaration" id="1084199179703">
    <property name="name" value="LinkMetaclass" />
    <link role="memberDataType" targetNodeId="1.1082983041843" />
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1084199179704">
      <property name="externalValue" value="reference" />
      <property name="name" value="reference" />
    </node>
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1084199179705">
      <property name="externalValue" value="aggregation" />
      <property name="internalValue" value="aggregation" />
      <property name="name" value="aggregation" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725006687">
    <property name="rootable" value="false" />
    <property name="name" value="ConceptPropertyDeclaration" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1131940019080">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725141344">
    <property name="rootable" value="false" />
    <property name="name" value="IntegerConceptPropertyDeclaration" />
    <link role="extends" targetNodeId="1105725006687" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1137469216124">
      <property name="value" value="integer" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725240314">
    <property name="name" value="BooleanConceptPropertyDeclaration" />
    <link role="extends" targetNodeId="1105725006687" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1137469190995">
      <property name="value" value="boolean" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725281956">
    <property name="rootable" value="false" />
    <property name="name" value="StringConceptPropertyDeclaration" />
    <link role="extends" targetNodeId="1105725006687" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1137469231375">
      <property name="value" value="string" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725413739">
    <property name="name" value="ConceptProperty" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1150227364245">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105725439818">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="conceptPropertyDeclaration" />
      <link role="target" targetNodeId="1105725006687" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725498741">
    <property name="name" value="IntegerConceptProperty" />
    <link role="extends" targetNodeId="1105725413739" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1105725713309">
      <property name="name" value="value" />
      <link role="dataType" targetNodeId="1.1082983657062" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105725523273">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="integerConceptPropertyDeclaration" />
      <link role="target" targetNodeId="1105725141344" />
      <link role="specializedLink" targetNodeId="1105725439818" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725574259">
    <property name="name" value="BooleanConceptProperty" />
    <link role="extends" targetNodeId="1105725413739" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105725597978">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="booleanConceptPropertyDeclaration" />
      <link role="target" targetNodeId="1105725240314" />
      <link role="specializedLink" targetNodeId="1105725439818" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105725638761">
    <property name="name" value="StringConceptProperty" />
    <link role="extends" targetNodeId="1105725413739" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1105725733873">
      <property name="name" value="value" />
      <link role="dataType" targetNodeId="1.1082983041843" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105725659058">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="stringConceptPropertyDeclaration" />
      <link role="specializedLink" targetNodeId="1105725439818" />
      <link role="target" targetNodeId="1105725281956" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105736576531">
    <property name="rootable" value="false" />
    <property name="name" value="ConceptLinkDeclaration" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1137532397763">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105736621938">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="targetType" />
      <link role="target" targetNodeId="1071489090640" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105736674127">
    <property name="name" value="ConceptLink" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1142040108511">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105736734721">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="conceptLinkDeclaration" />
      <link role="target" targetNodeId="1105736576531" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105736778597">
    <property name="rootable" value="false" />
    <property name="name" value="ReferenceConceptLink" />
    <link role="extends" targetNodeId="1105736674127" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1150228875552">
      <property name="value" value="&lt;{referenceConceptLinkDeclaration}&gt;" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105742372452">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="referenceConceptLinkDeclaration" />
      <link role="specializedLink" targetNodeId="1105736734721" />
      <link role="target" targetNodeId="1105741578420" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105736807942">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="target" />
      <link role="target" targetNodeId="1.1078489098625" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105736889287">
    <property name="rootable" value="false" />
    <property name="name" value="AggregationConceptLink" />
    <link role="extends" targetNodeId="1105736674127" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105742417828">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="0..n" />
      <property name="role" value="aggregationConceptLinkDeclaration" />
      <link role="target" targetNodeId="1105741535888" />
      <link role="specializedLink" targetNodeId="1105736734721" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105736901241">
      <property name="sourceCardinality" value="1" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="target" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1.1133920641626" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105741535888">
    <property name="rootable" value="false" />
    <property name="name" value="AggregationConceptLinkDeclaration" />
    <link role="extends" targetNodeId="1105736576531" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1137532980164">
      <property name="value" value="aggregation" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1105741578420">
    <property name="rootable" value="false" />
    <property name="name" value="ReferenceConceptLinkDeclaration" />
    <link role="extends" targetNodeId="1105736576531" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1137533021041">
      <property name="value" value="reference" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1149608206811">
    <property name="rootable" value="true" />
    <property name="name" value="AnnotationLinkDeclaration" />
    <link role="extends" targetNodeId="1071489288298" />
    <node role="propertyDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.PropertyDeclaration" id="1149608445162">
      <property name="name" value="stereotype" />
      <link role="dataType" targetNodeId="1149608316235" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1149608246500">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="source" />
      <link role="target" targetNodeId="1071489090640" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.EnumerationDataTypeDeclaration" id="1149608316235">
    <property name="name" value="AnnotationLinkStereotype" />
    <link role="memberDataType" targetNodeId="1.1082983041843" />
    <link role="defaultMember" targetNodeId="1149608364144" />
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1149608364144">
      <property name="externalValue" value="node" />
      <property name="internalValue" value="node" />
      <property name="name" value="node" />
    </node>
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1149608316236">
      <property name="externalValue" value="link" />
      <property name="internalValue" value="link" />
      <property name="name" value="link" />
    </node>
    <node role="member" type="jetbrains.mps.bootstrap.structureLanguage.EnumerationMemberDeclaration" id="1149608344284">
      <property name="externalValue" value="property" />
      <property name="internalValue" value="property" />
      <property name="name" value="property" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1169125787135">
    <property name="name" value="AbstractConceptDeclaration" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1169125985753">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1071489727083">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="linkDeclaration" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1071489288298" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1071489727084">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="propertyDeclaration" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1071489288299" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105725339613">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="conceptProperty" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1105725413739" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1105736949336">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="conceptLink" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1105736674127" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1137467167200">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="conceptPropertyDeclaration" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1105725006687" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1137532086877">
      <property name="sourceCardinality" value="0..n" />
      <property name="targetCardinality" value="1" />
      <property name="role" value="conceptLinkDeclaration" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1105736576531" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1169125989551">
    <property name="rootable" value="true" />
    <property name="name" value="InterfaceConceptDeclaration" />
    <link role="extends" targetNodeId="1169125787135" resolveInfo="AbstractConceptDeclaration" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1169127546356">
      <property name="sourceCardinality" value="0..n" />
      <property name="role" value="extends" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1169127622168" resolveInfo="InterfaceConceptReference" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1169126267841">
      <property name="value" value="interface concept" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1169127622168">
    <property name="name" value="InterfaceConceptReference" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1169127628841">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="intfc" />
      <link role="target" targetNodeId="1169125989551" resolveInfo="InterfaceConceptDeclaration" />
    </node>
  </node>
</model>

