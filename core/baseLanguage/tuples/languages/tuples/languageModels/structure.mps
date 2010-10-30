<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:309aeee7-bee8-445c-b31d-35928d1da75f(jetbrains.mps.baseLanguage.tuples.structure)">
  <persistence version="4" />
  <refactoringHistory>
    <refactoringContext modelVersion="1">
      <refactoring refactoringClass="jetbrains.mps.lang.structure.scripts.RenameLink" />
      <moveMap />
      <sourceMap />
      <conceptFeatureMap>
        <entry>
          <key featureName="member" conceptFQName="jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleLiteral" featureKind="CHILD" />
          <value featureName="component" conceptFQName="jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleLiteral" featureKind="CHILD" />
        </entry>
      </conceptFeatureMap>
    </refactoringContext>
    <refactoringContext modelVersion="2">
      <refactoring refactoringClass="jetbrains.mps.lang.structure.scripts.RenameLink" />
      <moveMap />
      <sourceMap />
      <conceptFeatureMap>
        <entry>
          <key featureName="memberType" conceptFQName="jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleType" featureKind="CHILD" />
          <value featureName="componentType" conceptFQName="jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleType" featureKind="CHILD" />
        </entry>
      </conceptFeatureMap>
    </refactoringContext>
  </refactoringHistory>
  <language namespace="c72da2b9-7cce-4447-8389-f407dc1158b7(jetbrains.mps.lang.structure)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)" version="17" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959033d(jetbrains.mps.lang.annotations.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590340(jetbrains.mps.lang.pattern.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="4" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959034b(jetbrains.mps.lang.quotation.structure)" version="0" />
  <languageAspect modelUID="r:309aeee7-bee8-445c-b31d-35928d1da75f(jetbrains.mps.baseLanguage.tuples.structure)" version="2" />
  <maxImportIndex value="1" />
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" />
  <visible index="3" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" />
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1238852151516">
    <property name="name:0" value="IndexedTupleType" />
    <link role="extends:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1238852449931">
      <property name="name:0" value="leftBracket" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1238852467039">
      <property name="name:0" value="rightBracket" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1238852204892">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="componentType" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238852191438">
      <property name="value:0" value="[" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238852430464">
      <property name="value:0" value="indexed tuple type" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473914776:0" resolveInfo="shortDescription" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238852475048">
      <property name="value:0" value="[" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1238852449931:2" resolveInfo="leftBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238852478218">
      <property name="value:0" value="]" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1238852467039:2" resolveInfo="rightBracket" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1238853782547">
    <property name="name:0" value="IndexedTupleLiteral" />
    <link role="extends:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1238853845806">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="component" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1238853815813">
      <property name="name:0" value="leftBracket" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1238853826944">
      <property name="name:0" value="rightBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238853800791">
      <property name="value:0" value="[" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238853804498">
      <property name="value:0" value="indexed tuple" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473914776:0" resolveInfo="shortDescription" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238853835339">
      <property name="value:0" value="[" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1238853815813:2" resolveInfo="leftBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238853838301">
      <property name="value:0" value="]" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1238853826944:2" resolveInfo="rightBracket" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1238857743184">
    <property name="name:0" value="IndexedTupleMemberAccessExpression" />
    <link role="extends:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1238857764950">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="tuple" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1238857834412">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="index" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238857777810">
      <property name="value:0" value="[" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1238857781280">
      <property name="value:0" value="access tuple member by index" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473914776:0" resolveInfo="shortDescription" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.BooleanConceptProperty:0" id="1239723185641">
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473994950:0" resolveInfo="dontSubstituteByDefault" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1239360506533">
    <property name="name:0" value="NamedTupleDeclaration" />
    <property name="rootable:0" value="true" />
    <property name="iconPath:0" value="${language_descriptor}/icons/namedTuple.png" />
    <link role="extends:0" targetNodeId="2v.1107461130800:3" resolveInfo="Classifier" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="3142843783245461118">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="extends" />
      <link role="target:0" targetNodeId="1239360506533:2" resolveInfo="NamedTupleDeclaration" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1239546091267">
      <property name="name:0" value="leftBracket" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1239546098880">
      <property name="name:0" value="rightBracket" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239529553065">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="component" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="1239462176079:2" resolveInfo="NamedTupleComponentDeclaration" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239567350755">
      <property name="value:0" value="tuple" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239878181172">
      <property name="value:0" value="named tuple declaration" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473914776:0" resolveInfo="shortDescription" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239546105109">
      <property name="value:0" value="(" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1239546091267:2" resolveInfo="leftBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239546108279">
      <property name="value:0" value=")" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1239546098880:2" resolveInfo="rightBracket" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1239462176079">
    <property name="name:0" value="NamedTupleComponentDeclaration" />
    <link role="extends:0" targetNodeId="3v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="propertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.PropertyDeclaration:0" id="1240400839614">
      <property name="name:0" value="final" />
      <link role="dataType:0" targetNodeId="3v.1082983657063:0" resolveInfo="boolean" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239462974287">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="type" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1239462414586">
      <link role="intfc:0" targetNodeId="2v.1212170275853:3" resolveInfo="IValidIdentifier" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1239462414587">
      <link role="intfc:0" targetNodeId="2v.1188208481402:3" resolveInfo="HasAnnotation" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1239462414588">
      <link role="intfc:0" targetNodeId="2v.1201183863028:3" resolveInfo="TypeDerivable" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1239462414589">
      <link role="intfc:0" targetNodeId="2v.1233920926773:3" resolveInfo="TypeAnnotable" />
    </node>
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1239462445302">
      <link role="intfc:0" targetNodeId="3v.1196978630214:0" resolveInfo="IResolveInfo" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1239531918181">
    <property name="name:0" value="NamedTupleType" />
    <link role="extends:0" targetNodeId="2v.1107535904670:3" resolveInfo="ClassifierType" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239548562987">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="parameterType" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="2v.1068431790189:3" resolveInfo="Type" />
      <link role="specializedLink:0" targetNodeId="2v.1109201940907:3" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1239547086058">
      <property name="name:0" value="leftBracket" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1239547093673">
      <property name="name:0" value="rightBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239536476017">
      <property name="value:0" value="&lt;{tupleDeclaration}&gt; type" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239536476018">
      <property name="value:0" value="reference to named tuple declaration" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473914776:0" resolveInfo="shortDescription" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239547102360">
      <property name="value:0" value="(" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1239547086058:2" resolveInfo="leftBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239547105650">
      <property name="value:0" value=")" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1239547093673:2" resolveInfo="rightBracket" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239531948650">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="tupleDeclaration" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="1239360506533:2" resolveInfo="NamedTupleDeclaration" />
      <link role="specializedLink:0" targetNodeId="2v.1107535924139:3" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1239559992092">
    <property name="name:0" value="NamedTupleLiteral" />
    <link role="extends:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239560910577">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="componentRef" />
      <property name="sourceCardinality:0" value="0..n" />
      <link role="target:0" targetNodeId="1239560581441:2" resolveInfo="NamedTupleComponentReference" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239560008022">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="tupleDeclaration" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="1239360506533:2" resolveInfo="NamedTupleDeclaration" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1239560950602">
      <property name="name:0" value="leftBracket" />
    </node>
    <node role="conceptPropertyDeclaration:0" type="jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration:0" id="1239560957517">
      <property name="name:0" value="rightBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239567234546">
      <property name="value:0" value="&lt;{tupleDeclaration}&gt; literal" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473891462:0" resolveInfo="alias" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239567234547">
      <property name="value:0" value="tuple literal" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="3v.1137473914776:0" resolveInfo="shortDescription" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239560963789">
      <property name="value:0" value="(" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1239560950602:2" resolveInfo="leftBracket" />
    </node>
    <node role="conceptProperty:0" type="jetbrains.mps.lang.structure.structure.StringConceptProperty:0" id="1239560966567">
      <property name="value:0" value=")" />
      <link role="conceptPropertyDeclaration:0" targetNodeId="1239560957517:2" resolveInfo="rightBracket" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1239560581441">
    <property name="name:0" value="NamedTupleComponentReference" />
    <link role="extends:0" targetNodeId="3v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239560837729">
      <property name="metaClass:0" value="aggregation" />
      <property name="role:0" value="value" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="2v.1068431790191:3" resolveInfo="Expression" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239560595302">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="componentDeclaration" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="1239462176079:2" resolveInfo="NamedTupleComponentDeclaration" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.structure.structure.ConceptDeclaration:0" id="1239576519914">
    <property name="name:0" value="NamedTupleComponentAccessOperation" />
    <link role="extends:0" targetNodeId="3v.1133920641626:0" resolveInfo="BaseConcept" />
    <node role="implements:0" type="jetbrains.mps.lang.structure.structure.InterfaceConceptReference:0" id="1239576533734">
      <link role="intfc:0" targetNodeId="2v.1197027803184:3" resolveInfo="IOperation" />
    </node>
    <node role="linkDeclaration:0" type="jetbrains.mps.lang.structure.structure.LinkDeclaration:0" id="1239576542472">
      <property name="metaClass:0" value="reference" />
      <property name="role:0" value="component" />
      <property name="sourceCardinality:0" value="1" />
      <link role="target:0" targetNodeId="1239462176079:2" resolveInfo="NamedTupleComponentDeclaration" />
    </node>
  </node>
</model>

