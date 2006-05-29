<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.constraintsLanguage.structure">
  <language namespace="jetbrains.mps.bootstrap.structureLanguage" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage" />
  <maxImportIndex value="10" />
  <import index="1" modelUID="jetbrains.mps.core.structure" />
  <import index="2" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" />
  <import index="3" modelUID="jetbrains.mps.baseLanguage.structure" />
  <import index="5" modelUID="java.lang@java_stub" />
  <import index="6" modelUID="jetbrains.mps.smodel@java_stub" />
  <import index="9" modelUID="jetbrains.mps.smodel.search@java_stub" />
  <import index="10" modelUID="jetbrains.mps.ide@java_stub" />
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1147467115080">
    <property name="name" value="NodePropertyConstraint" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1147467194506">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="applicableConcept" />
      <link role="target" targetNodeId="2.1071489090640" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1147467295099">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="applicableProperty" />
      <link role="target" targetNodeId="2.1071489288299" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1147468630220">
      <property name="role" value="propertyGetter" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1147467790433" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1147467351491">
    <property name="rootable" value="true" />
    <property name="name" value="NodePropertyConstraintSet" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1147467368445">
      <property name="sourceCardinality" value="0..n" />
      <property name="role" value="nodePropertyConstraint" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1147467115080" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1147467790433">
    <property name="name" value="ConstraintFunction_PropertyGetter" />
    <link role="extends" targetNodeId="1147468248771" />
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1147468324383">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137545148427" />
      <node role="target" type="jetbrains.mps.baseLanguage.ClassifierType" id="1147468354204">
        <link role="classifier" extResolveInfo="5.[Classifier]String" />
      </node>
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1147468362003">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137546998352" />
      <node role="target" type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1147468365020">
        <property name="name" value="PropertyGetter_FunctionParm_node" />
        <link role="extends" targetNodeId="3.1107135704075" />
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1147468428841">
          <property name="value" value="node" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1147468428842">
          <property name="value" value="function parameter" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
        </node>
      </node>
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1147468034457">
      <property name="value" value="getter" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1147468034458">
      <property name="value" value="embedded block of code" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1147468248771">
    <property name="name" value="BaseConstraintFunction" />
    <link role="extends" targetNodeId="3.1137021947720" />
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1148934577363">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148684180339">
    <property name="name" value="ConstraintFunction_ReferentSearchScope_Factory" />
    <link role="extends" targetNodeId="1148934493876" />
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148685281814">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137545148427" />
      <node role="target" type="jetbrains.mps.baseLanguage.ClassifierType" id="1148685793082">
        <link role="classifier" extResolveInfo="9.[Classifier]ISearchScope" />
      </node>
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148685212404">
      <property name="value" value="search scope provider" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148685236406">
      <property name="value" value="embedded block of code" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148687112784">
    <property name="rootable" value="true" />
    <property name="name" value="NodeReferentConstraintSet" />
    <link role="extends" targetNodeId="1.1078489098625" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1148687980226">
      <property name="sourceCardinality" value="0..n" />
      <property name="role" value="nodeReferentConstraint" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1148687176410" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148687176410">
    <property name="name" value="NodeReferentConstraint" />
    <link role="extends" targetNodeId="1.1133920641626" />
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1148687201775">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="applicableConcept" />
      <link role="target" targetNodeId="2.1071489090640" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1148687202698">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="applicableLink" />
      <link role="target" targetNodeId="2.1071489288298" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1148934990679">
      <property name="sourceCardinality" value="0..1" />
      <property name="role" value="searchScopePrecondition" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1148934343083" />
    </node>
    <node role="linkDeclaration" type="jetbrains.mps.bootstrap.structureLanguage.LinkDeclaration" id="1148687345559">
      <property name="sourceCardinality" value="1" />
      <property name="role" value="searchScopeFactory" />
      <property name="metaClass" value="aggregation" />
      <link role="target" targetNodeId="1148684180339" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148934343083">
    <property name="name" value="ConstraintFunction_ReferentSearchScope_Precondition" />
    <link role="extends" targetNodeId="1148934493876" />
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934343084">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137545148427" />
      <node role="target" type="jetbrains.mps.baseLanguage.ClassifierType" id="1148934929957">
        <link role="classifier" extResolveInfo="10.[Classifier]IStatus" />
      </node>
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934343108">
      <property name="value" value="search scope precondition" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934343109">
      <property name="value" value="embedded block of code" />
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148934493876">
    <property name="name" value="ConstraintFunction_ReferentSearchScope_AbstractBase" />
    <link role="extends" targetNodeId="1147468248771" />
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934636678">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137546998352" />
      <node role="target" type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148934636679">
        <property name="name" value="ConceptParameter_ReferentSearchScope_referenceNode" />
        <link role="extends" targetNodeId="3.1107135704075" />
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934636680">
          <property name="value" value="referenceNode" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934636681">
          <property name="value" value="function parameter" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
        </node>
      </node>
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934636682">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137546998352" />
      <node role="target" type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148934636683">
        <property name="name" value="ConceptParameter_ReferentSearchScope_enclosingNode" />
        <link role="extends" targetNodeId="3.1107135704075" />
        <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934636684">
          <link role="conceptLinkDeclaration" targetNodeId="3.1137545963098" />
          <node role="target" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1148934636685" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934636686">
          <property name="value" value="enclosingNode" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934636687">
          <property name="value" value="function parameter" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
        </node>
      </node>
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934636688">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137546998352" />
      <node role="target" type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148934636689">
        <property name="name" value="ConceptParameter_ReferentSearchScope_model" />
        <link role="extends" targetNodeId="3.1107135704075" />
        <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934636690">
          <link role="conceptLinkDeclaration" targetNodeId="3.1137545963098" />
          <node role="target" type="jetbrains.mps.bootstrap.smodelLanguage.SModelType" id="1148934636691" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934636692">
          <property name="value" value="model" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934636693">
          <property name="value" value="function parameter" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
        </node>
      </node>
    </node>
    <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934760097">
      <link role="conceptLinkDeclaration" targetNodeId="3.1137546998352" />
      <node role="target" type="jetbrains.mps.bootstrap.structureLanguage.ConceptDeclaration" id="1148934760098">
        <property name="name" value="ConceptParameter_ReferentSearchScope_scope" />
        <link role="extends" targetNodeId="3.1107135704075" />
        <node role="conceptLink" type="jetbrains.mps.bootstrap.structureLanguage.AggregationConceptLink" id="1148934760099">
          <link role="conceptLinkDeclaration" targetNodeId="3.1137545963098" />
          <node role="target" type="jetbrains.mps.baseLanguage.ClassifierType" id="1148934760100">
            <link role="classifier" extResolveInfo="6.[Classifier]IScope" />
          </node>
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934760101">
          <property name="value" value="scope" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473891462" />
        </node>
        <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.StringConceptProperty" id="1148934760102">
          <property name="value" value="function parameter" />
          <link role="conceptPropertyDeclaration" targetNodeId="1.1137473914776" />
        </node>
      </node>
    </node>
    <node role="conceptProperty" type="jetbrains.mps.bootstrap.structureLanguage.BooleanConceptProperty" id="1148934569050">
      <link role="conceptPropertyDeclaration" targetNodeId="1.1137473854053" />
    </node>
  </node>
</model>

