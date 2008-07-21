<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.findUsagesLanguage.behavior">
  <persistence version="1"/>
  <refactoringHistory/>
  <language namespace="jetbrains.mps.bootstrap.constraintsLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.constraints" version="9"/>
    <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.constraints" version="6"/>
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.constraints" version="21"/>
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.constraints" version="83"/>
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0"/>
  </language>
  <languageAspect modelUID="jetbrains.mps.bootstrap.intentionsLanguage.constraints" version="1"/>
  <languageAspect modelUID="jetbrains.mps.bootstrap.findUsagesLanguage.structure" version="1"/>
  <languageAspect modelUID="jetbrains.mps.bootstrap.sharedConcepts.constraints" version="0"/>
  <languageAspect modelUID="jetbrains.mps.bootstrap.structureLanguage.constraints" version="11"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.core.constraints" version="2"/>
  <languageAspect modelUID="jetbrains.mps.closures.constraints" version="2"/>
  <languageAspect modelUID="jetbrains.mps.bootstrap.findUsagesLanguage.constraints" version="4"/>
  <languageAspect modelUID="jetbrains.mps.internal.collections.constraints" version="2"/>
  <maxImportIndex value="5"/>
  <import index="1" modelUID="jetbrains.mps.bootstrap.findUsagesLanguage.structure" version="1"/>
  <import index="2" modelUID="java.lang@java_stub" version="-1"/>
  <import index="3" modelUID="jetbrains.mps.util@java_stub" version="-1"/>
  <import index="4" modelUID="jetbrains.mps.bootstrap.findUsagesLanguage.behavior" version="-1"/>
  <import index="5" modelUID="jetbrains.mps.smodel@java_stub" version="-1"/>
  <visible index="2" modelUID="jetbrains.mps.core.structure"/>
  <visible index="3" modelUID="jetbrains.mps.core.behavior"/>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1213877240100">
    <link role="concept" targetNodeId="1.1197044488845" resolveInfo="FinderDeclaration"/>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1213877240101">
      <property name="name" value="getGeneratedClassName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213877240102">
        <link role="classifier" targetNodeId="2.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877240103">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213877240104">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1213877240105">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1213877240106">
              <link role="classConcept" targetNodeId="3.~NameUtil" resolveInfo="NameUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="3.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213877240107">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1213877240108"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1213877240109">
                  <link role="property" targetNodeId="2v.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1213877240110">
              <property name="value" value="_Finder"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1213877240111">
      <property name="name" value="getConceptName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213877240112">
        <link role="classifier" targetNodeId="2.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877240113">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213877240114">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213877240115">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213877240116">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                    id="1213877240117"/>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                    id="1213877240118">
                <link role="link" targetNodeId="1.1197044488847"/>
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                  id="1213877240119">
              <link role="conceptMethodDeclaration" targetNodeId="3v.1213877404258" resolveInfo="getFqName"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1213877240120">
      <property name="name" value="getGeneratedClassLongName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213877240121">
        <link role="classifier" targetNodeId="2.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877240122">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213877240123">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1213877240124">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1213877240125">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213877240126">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1213877240127"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1213877240128">
                  <link role="conceptMethodDeclaration" targetNodeId="1213877240101"
                        resolveInfo="getGeneratedClassName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1213877240129">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall"
                  id="1213877240130">
              <link role="baseMethodDeclaration" targetNodeId="5.~SModelDescriptor.getLongName():java.lang.String"
                    resolveInfo="getLongName"/>
              <node role="instance" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall" id="1213877240131">
                <link role="baseMethodDeclaration"
                      targetNodeId="5.~SModel.getModelDescriptor():jetbrains.mps.smodel.SModelDescriptor"
                      resolveInfo="getModelDescriptor"/>
                <node role="instance" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                      id="1213877240132">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1213877240133">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                          id="1213877240134">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                            id="1213877240135"/>
                      <node role="operation"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                            id="1213877240136"/>
                    </node>
                    <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213877240137">
                      <link role="classifier" targetNodeId="5.~SModel" resolveInfo="SModel"/>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1216644254063">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216644254064"/>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1213877299657">
    <property name="package" value="Statements"/>
    <link role="concept" targetNodeId="1.1206197741569" resolveInfo="ExecuteFinderExpression"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1213877299658">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877299659"/>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1213877363196">
    <property name="package" value="Statements"/>
    <link role="concept" targetNodeId="1.1207141825411" resolveInfo="CheckCancelledStatusStatement"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1213877363197">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877363198"/>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1213877373943">
    <property name="package" value="Statements"/>
    <link role="concept" targetNodeId="1.1200242336756" resolveInfo="ResultStatement"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1213877373944">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877373945"/>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1213877418351">
    <property name="package" value="Statements"/>
    <link role="concept" targetNodeId="1.1200242562138" resolveInfo="NodeStatement"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1213877418352">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213877418353"/>
    </node>
  </node>
</model>

