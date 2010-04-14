<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:a258f9a5-18d3-4bea-a833-20735290774c(jetbrains.mps.baseLanguage.overloadedOperators.structure)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="c72da2b9-7cce-4447-8389-f407dc1158b7(jetbrains.mps.lang.structure)" />
  <language namespace="fc8d557e-5de6-4dd8-b749-aab2fb23aefc(jetbrains.mps.baseLanguage.overloadedOperators)" />
  <language namespace="ceab5195-25ea-4f22-9b92-103b95ca8c0c(jetbrains.mps.lang.core)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)" version="17" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590345(jetbrains.mps.lang.pattern.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959034b(jetbrains.mps.lang.quotation.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590340(jetbrains.mps.lang.pattern.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959033d(jetbrains.mps.lang.annotations.structure)" version="0" />
  <devkit namespace="2677cb18-f558-4e33-bc38-a5139cee06dc(jetbrains.mps.devkit.language-design)" />
  <maxImportIndex value="2" />
  <import index="2" modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" />
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="483844232470132813">
    <property name="name:0" value="OverloadedBinaryOperator" />
    <link role="extends:0" targetNodeId="2v.1137021947720:3" resolveInfo="ConceptFunction" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="6677452554237917709">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="returnType" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="6677452554239170993">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="leftType" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="6677452554239170994">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="rightType" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2838654975957155510">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="operator" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2838654975957036198" resolveInfo="Operator" />
    </node>
    <node role="conceptLink:0" type="jetbrains.mps.lang.structure.structure.ReferenceConceptLink:0" id="7789383629180759505">
      <link role="conceptLinkDeclaration:0" targetNodeId="2v.1161119487665:3" resolveInfo="applicableConceptFunctionParameter" />
      <link role="target:0" targetNodeId="483844232470668960" resolveInfo="LeftOperand" />
    </node>
    <node role="conceptLink:0" type="jetbrains.mps.lang.structure.structure.ReferenceConceptLink:0" id="7789383629180759507">
      <link role="conceptLinkDeclaration:0" targetNodeId="2v.1161119487665:3" resolveInfo="applicableConceptFunctionParameter" />
      <link role="target:0" targetNodeId="7789383629180756961" resolveInfo="RightOperand" />
    </node>
  </node>
  <visible index="3" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" />
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="483844232470139399">
    <property name="name:0" value="OverloadedOperatorContainer" />
    <property name="rootable:0" value="true" />
    <link role="extends:0" targetNodeId="3v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="483844232470139400">
      <property name="metaClass:0" value="aggregation" />
      <property name="sourceCardinality:0" value="0..n" />
      <property name="role:0" value="operators" />
      <link role="target:0" targetNodeId="483844232470132813" resolveInfo="OverloadedBinaryOperator" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2838654975956759196">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="customOperators" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="1569627462442419521" resolveInfo="CustomOperatorDeclaration" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="483844232470139409">
      <link role="intfc:0" targetNodeId="3v.1169194658468:0" resolveInfo="INamedConcept" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="483844232470668960">
    <property name="name:0" value="LeftOperand" />
    <link role="extends:0" targetNodeId="2v.1107135704075:3" resolveInfo="ConceptFunctionParameter" />
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="483844232470668961">
      <link role="intfc:0" targetNodeId="3v.1169194658468:0" resolveInfo="INamedConcept" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="7789383629180756963">
      <property name="value:0" value="left" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="7789383629180756961">
    <property name="name:0" value="RightOperand" />
    <link role="extends:0" targetNodeId="2v.1107135704075:3" resolveInfo="ConceptFunctionParameter" />
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="7789383629180756962">
      <property name="value:0" value="right" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2838654975957036198">
    <property name="name:0" value="Operator" />
    <link role="extends:0" targetNodeId="3v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.BooleanConceptProperty:0" id="2838654975957155507">
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473854053:0" resolveInfo="abstract" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2838654975957155508">
    <property name="name:0" value="BinaryOperationReference" />
    <link role="extends:0" targetNodeId="2838654975957036198" resolveInfo="Operator" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2838654975957155509">
      <property name="metaClass:0" value="reference" />
      <property name="sourceCardinality:0" value="1" />
      <property name="role:0" value="binaryOperation" />
      <link role="target:0" targetNodeId="2.1071489090640:0" resolveInfo="ConceptDeclaration" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="2838654975957402167">
    <property name="name:0" value="CustomOperator" />
    <link role="extends:0" targetNodeId="2838654975957036198" resolveInfo="Operator" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="2838654975957402169">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="declaration" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="1569627462442419521" resolveInfo="CustomOperatorDeclaration" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1569627462441399919">
    <property name="name:0" value="CustomOperatorUsage" />
    <link role="extends:0" targetNodeId="2v.1081773326031:3" resolveInfo="BinaryOperation" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1569627462441399920">
      <property name="metaClass:0" value="reference" />
      <property name="sourceCardinality:0" value="1" />
      <property name="role:0" value="operator" />
      <link role="target:0" targetNodeId="1569627462442419521" resolveInfo="CustomOperatorDeclaration" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1569627462442419521">
    <property name="name:0" value="CustomOperatorDeclaration" />
    <link role="extends:0" targetNodeId="3v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1569627462442419522">
      <link role="intfc:0" targetNodeId="3v.1169194658468:0" resolveInfo="INamedConcept" />
    </node>
  </node>
</model>

