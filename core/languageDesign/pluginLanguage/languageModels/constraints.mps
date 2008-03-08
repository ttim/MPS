<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.pluginLanguage.constraints">
  <persistence version="1"/>
  <refactoringHistory/>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.constraintsLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.quotation"/>
  <language namespace="jetbrains.mps.core"/>
  <language namespace="jetbrains.mps.bootstrap.findUsagesLanguage"/>
  <language namespace="jetbrains.mps.bootstrap.sharedConcepts"/>
  <maxImportIndex value="19"/>
  <import index="3" modelUID="jetbrains.mps.core.structure" version="-1"/>
  <import index="4" modelUID="java.lang@java_stub" version="-1"/>
  <import index="5" modelUID="jetbrains.mps.util@java_stub" version="-1"/>
  <import index="7" modelUID="jetbrains.mps.bootstrap.pluginLanguage.structure" version="-1"/>
  <import index="8" modelUID="jetbrains.mps.smodel@java_stub" version="-1"/>
  <import index="9" modelUID="jetbrains.mps.ide.toolsPane@java_stub" version="-1"/>
  <import index="10" modelUID="jetbrains.mps.baseLanguage.structure" version="0"/>
  <import index="11" modelUID="jetbrains.mps.smodel.search@java_stub" version="-1"/>
  <import index="12" modelUID="jetbrains.mps.ide.findusages.model.searchquery@java_stub" version="-1"/>
  <import index="13" modelUID="java.util@java_stub" version="-1"/>
  <import index="14" modelUID="jetbrains.mps.ide.findusages.model.result@java_stub" version="-1"/>
  <import index="15" modelUID="jetbrains.mps.ide.actions@java_stub" version="-1"/>
  <import index="16" modelUID="jetbrains.mps.ide.action@java_stub" version="-1"/>
  <import index="18" modelUID="jetbrains.mps.baseLanguage.findUsages" version="-1"/>
  <import index="19" modelUID="jetbrains.mps.baseLanguage.constraints" version="-1"/>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1203086933326">
    <property name="package" value="Actions.Action"/>
    <link role="concept" targetNodeId="7.1203071646776" resolveInfo="Action"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1203086933327">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203086933328"/>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1203086959942">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203086959943">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203086959944">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203086959945">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203086959946">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1203086959947">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227896816">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1203086959950"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1203093300887">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203086959951">
              <property name="value" value="_Action"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1203873385358">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873387861">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203873385360">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203873429080">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873528966">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873534658">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227936774">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1203873545948"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1203873545949">
                  <link role="conceptMethodDeclaration" targetNodeId="1203086959942" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203873531844">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388982892">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1203873501488">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1203873501881">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203873501882">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1203873501883"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1203873501884"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873501885">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204388982893">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1203094511966">
    <property name="package" value="Actions.Groups"/>
    <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1203094511967">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203094511968"/>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1203094543712">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203094543713">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203094543714">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203094543715">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203094543716">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1203094543717">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227894215">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1203094543720"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1203094550206">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203094543721">
              <property name="value" value="_ActionGroup"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1203873563137">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873563138">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203873563139">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203873563140">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873563141">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873563142">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227832311">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1203873563144"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1203873563145">
                  <link role="conceptMethodDeclaration" targetNodeId="1203094543712" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203873563146">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388969249">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1203873563148">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1203873563149">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203873563150">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1203873563151"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1203873567560"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873563153">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204388969250">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204995370957">
      <property name="name" value="getID"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204995378700">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204995370959">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204995384599">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204995396671">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204995401965">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204995406729">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204995405963"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1205002845442">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204995400388">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204995393464">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1204995393465">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204995393466">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204995393467">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1204995393468"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1204995393469"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204995393470">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204995393471">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1203686306502">
    <property name="package" value="Actions.Groups.GroupMembers"/>
    <link role="concept" targetNodeId="7.1203680534665" resolveInfo="ExtentionPoint"/>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1203686308396">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203686311898">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203686308398">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203686329587">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203686329588">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1203686329589">
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227913192">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1203686329592"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1203689181796">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203686329593">
              <property name="value" value="_ExtentionPoint"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1203873574983">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873574984">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203873574985">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203873574986">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873574987">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873574988">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227955909">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1203873574990"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1203873574991">
                  <link role="conceptMethodDeclaration" targetNodeId="1203686308396" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203873574992">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388987800">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1203873574994">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1203873574995">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203873574996">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1203873574997"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1203873574998"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873574999">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204388987801">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1203686306503">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203686306504"/>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204042998735">
    <property name="package" value="EditorTab"/>
    <link role="concept" targetNodeId="7.1203866019489" resolveInfo="TabbedEditorDeclaration"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1204042998736">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204042998737"/>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204043000833">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204043000834">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204043000835">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204043000836">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204043000837">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204043000838">
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227898005">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204043000841"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1204043005125">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204043000842">
              <property name="value" value="_TabbedEditor"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204043000843">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204043000844">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204043000845">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204043000846">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204043000847">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204043000848">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227832108">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204043000850"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1204043000851">
                  <link role="conceptMethodDeclaration" targetNodeId="1204043000833" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204043000852">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388996445">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1204043000854">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204043000855">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204043000856">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1204043000857"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1204043000858"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204043000859">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204388996446">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204047775341">
    <property name="package" value="EditorTab"/>
    <link role="concept" targetNodeId="7.1203851787677" resolveInfo="AbstractEditorTab"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1204047775342">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204047775343"/>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204047777640">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204047777641">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204047777642">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204047777643">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204047777644">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204047777645">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227928525">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204047777648"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1204047789761">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204047777649">
              <property name="value" value="_Tab"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204047777650">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204047777651">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204047777652">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204047777653">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204047777654">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204047777655">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227959731">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204047777657"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1204047777658">
                  <link role="conceptMethodDeclaration" targetNodeId="1204047777640" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204047777659">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388992443">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1204047777661">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204047777662">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204047777663">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1204047777664"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1204047777665"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204047777666">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204388992444">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204464473854">
    <property name="package" value="Tool"/>
    <link role="concept" targetNodeId="7.1203071677434" resolveInfo="Tool"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1204464473855">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204464473856"/>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204469301508">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204469301509">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204469301510">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204469301511">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204469301512">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204469301513">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301514">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204469301515"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1204469301516">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204469301517">
              <property name="value" value="_Tool"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204469301518">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204469301519">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204469301520">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204469301521">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204469301522">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204469301523">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301524">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204469301525"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1204469301526">
                  <link role="conceptMethodDeclaration" targetNodeId="1204469301508" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204469301527">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301528">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1204469301529">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204469301530">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301531">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1204469301532"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1204469301533"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204469301534">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204469301535">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204478905752">
    <property name="package" value="ProjectPane"/>
    <link role="concept" targetNodeId="7.1203080649866" resolveInfo="ProjectPane"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1204478905753">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204478905754"/>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204478907413">
      <property name="name" value="getGeneratedName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204478907414">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204478907415">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204478907416">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204478907417">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204478907418">
              <link role="baseMethodDeclaration"
                    targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String"
                    resolveInfo="toValidIdentifier"/>
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204478907419">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204478907420"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                      id="1204478907421">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name"/>
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204478907422">
              <property name="value" value="_ProjectPane"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration"
          id="1204478907423">
      <property name="name" value="getGeneratedClassFQName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204478907424">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204478907425">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204478907426">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204478907427">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204478907428">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204478907429">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                      id="1204478907430"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                      id="1204478907431">
                  <link role="conceptMethodDeclaration" targetNodeId="1204478907413" resolveInfo="getGeneratedName"/>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204478907432">
                <property name="value" value="."/>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204478907433">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                    id="1204478907434">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204478907435">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204478907436">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression"
                          id="1204478907437"/>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                          id="1204478907438"/>
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204478907439">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel"/>
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204478907440">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String"
                      resolveInfo="getLongName"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204903964188">
    <property name="package" value="Actions.Groups.GroupMembers"/>
    <link role="concept" targetNodeId="7.1204903488751" resolveInfo="JavaAction"/>
    <node role="references" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint"
          id="1204903967582">
      <link role="applicableLink" targetNodeId="7.1204903542721"/>
      <node role="searchScopeFactory"
            type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory"
            id="1204903971582">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204903971583">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
                id="1204903976928">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                  id="1204903976929">
              <property name="name" value="correntNodes"/>
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType"
                    id="1204903976930">
                <link role="elementConcept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept"/>
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression"
                    id="1204904249012">
                <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator"
                      id="1204904249013">
                  <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType"
                        id="1204904249014">
                    <link role="elementConcept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept"/>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement"
                id="1204907538240">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable"
                  id="1204907538241">
              <property name="name" value="classNode"/>
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204907538242">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1204907565707">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204907565708">
                  <node role="operand"
                        type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference"
                        id="1204907570997">
                    <link role="variable" targetNodeId="1204907538241" resolveInfo="classNode"/>
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall"
                        id="1204907565711">
                    <link role="conceptMethodDeclaration" targetNodeId="19.1199631877012" resolveInfo="isDescendant"/>
                    <node role="actualArgument"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression"
                          id="1204907601040">
                      <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept"/>
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                            id="1204907565712">
                        <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1204907565713">
                          <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType"
                                id="1204909171626">
                            <link role="classifier" targetNodeId="16.~ActionGroupElement"
                                  resolveInfo="ActionGroupElement"/>
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                              id="1204907565715">
                          <link role="link" targetNodeId="10.1107535924139"/>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204907565716">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement"
                        id="1204907565717">
                    <node role="expression"
                          type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression"
                          id="1204907565718">
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.Expression"
                            id="1204907565719"/>
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                            id="1204907565720">
                        <link role="variableDeclaration" targetNodeId="1204903976929" resolveInfo="correntNodes"/>
                      </node>
                      <node role="operation"
                            type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.AddElementOperation"
                            id="1204907565721">
                        <node role="argument"
                              type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference"
                              id="1204907610904">
                          <link role="variable" targetNodeId="1204907538241" resolveInfo="classNode"/>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204907538272">
              <node role="operand"
                    type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_model"
                    id="1204907538273"/>
              <node role="operation"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_RootsIncludingImportedOperation"
                    id="1204907538274">
                <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept"/>
                <node role="scope"
                      type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope"
                      id="1204907538275"/>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204903984979">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1204904222884">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)"
                    resolveInfo="SimpleSearchScope"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1204904245322">
                <link role="variableDeclaration" targetNodeId="1204903976929" resolveInfo="correntNodes"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1204903964189">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204903964190"/>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204992362939">
    <property name="package" value="Actions.Groups.GroupModification"/>
    <link role="concept" targetNodeId="7.1203092361741" resolveInfo="ModificationStatement"/>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration"
          id="1204992362940">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204992362941"/>
    </node>
    <node role="references" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint"
          id="1204992440745">
      <link role="applicableLink" targetNodeId="7.1204992316090"/>
      <node role="searchScopeFactory"
            type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory"
            id="1204992443387">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204992443388">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204992450371">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1204992456701">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)"
                    resolveInfo="SimpleSearchScope"/>
              <node role="actualArgument"
                    type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression"
                    id="1204996103863">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.Expression" id="1204996103864"/>
                <node role="operand"
                      type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression"
                      id="1204992779285">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.Expression"
                        id="1204992779286"/>
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204992779287">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204992779288">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression"
                            id="1204992779289">
                        <link role="concept" targetNodeId="7.1203092361741" resolveInfo="ModificationStatement"/>
                        <node role="leftExpression"
                              type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_referenceNode"
                              id="1204996934705"/>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                            id="1204992779291">
                        <link role="link" targetNodeId="7.1203092736097"/>
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess"
                          id="1204992779292">
                      <link role="link" targetNodeId="7.1203087991474"/>
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.WhereOperation"
                        id="1204992779293">
                    <node role="whereClosure"
                          type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.WhereBlock"
                          id="1204992779294">
                      <node role="defaultInputElement"
                            type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.DefaultInputElement"
                            id="1204992779295">
                        <property name="name" value="it"/>
                      </node>
                      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204992779296">
                        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement"
                              id="1204992788213">
                          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                                id="1204992788934">
                            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ClosureParameterReference"
                                  id="1204992788214">
                              <link role="closureParameter" targetNodeId="1204992779295" resolveInfo="it"/>
                            </node>
                            <node role="operation"
                                  type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                                  id="1204992791330">
                              <node role="conceptArgument"
                                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference"
                                    id="1204992799912">
                                <link role="conceptDeclaration" targetNodeId="7.1203680534665"
                                      resolveInfo="ExtentionPoint"/>
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation"
                      id="1204996106135"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

