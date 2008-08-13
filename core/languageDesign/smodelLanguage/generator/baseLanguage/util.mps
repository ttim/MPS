<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.smodelLanguage.generator.baseLanguage.util">
  <persistence version="1"/>
  <refactoringHistory/>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.constraints" version="83"/>
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.constraints" version="21"/>
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="1"/>
  </language>
  <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.bootstrap.structureLanguage.constraints" version="11"/>
  <languageAspect modelUID="jetbrains.mps.closures.constraints" version="2"/>
  <languageAspect modelUID="jetbrains.mps.core.constraints" version="2"/>
  <maxImportIndex value="24"/>
  <import index="1" modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="1"/>
  <import index="2" modelUID="jetbrains.mps.bootstrap.smodelLanguage@java_stub" version="-1"/>
  <import index="4" modelUID="java.lang@java_stub" version="-1"/>
  <import index="5" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" version="-1"/>
  <import index="7" modelUID="jetbrains.mps.smodel@java_stub" version="-1"/>
  <import index="11" modelUID="jetbrains.mps.generator.template@java_stub" version="-1"/>
  <import index="19" modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure@java_stub" version="-1"/>
  <import index="20" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure@java_stub" version="-1"/>
  <import index="23" modelUID="jetbrains.mps.util@java_stub" version="-1"/>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1168968323635">
    <property name="name" value="QueriesUtil"/>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1168968334480">
      <property name="name" value="nodeOp_noParm_conceptList"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1168968338921"/>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1168968334482">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1168968630547">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1168968630548">
            <property name="name" value="parm"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1168968630550">
              <link role="classifier" targetNodeId="4.~Object" resolveInfo="Object"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1168968584618">
              <link role="classConcept" targetNodeId="2.~SModelLanguageUtil" resolveInfo="SModelLanguageUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="2.~SModelLanguageUtil.findNodeOperationParameter(jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation,java.lang.Class):java.lang.Object"
                    resolveInfo="findNodeOperationParameter"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204668499974">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1168968620254">
                  <link role="variableDeclaration" targetNodeId="1168968445647" resolveInfo="op"/>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                      id="1171244853253"/>
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression"
                    id="1168968609576">
                <link role="classifier" targetNodeId="19.~OperationParm_Concept" resolveInfo="OperationParm_Concept"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1168968665241">
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1168968836667">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                  id="1168968675682">
              <link role="variableDeclaration" targetNodeId="1168968630548" resolveInfo="parm"/>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1168968679218"/>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1168968665243">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1168968839965">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1168968842264">
                <property name="value" value="true"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1168968847798">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1168968848972">
            <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1168968847799">
              <link role="variableDeclaration" targetNodeId="1168968630548" resolveInfo="parm"/>
            </node>
            <node role="rValue" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1168968856837">
              <link role="classConcept" targetNodeId="2.~SModelLanguageUtil" resolveInfo="SModelLanguageUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="2.~SModelLanguageUtil.findNodeOperationParameter(jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation,java.lang.Class):java.lang.Object"
                    resolveInfo="findNodeOperationParameter"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204668499946">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1168968856839">
                  <link role="variableDeclaration" targetNodeId="1168968445647" resolveInfo="op"/>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                      id="1171244939922"/>
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression"
                    id="1168968856841">
                <link role="classifier" targetNodeId="19.~OperationParm_ConceptList"
                      resolveInfo="OperationParm_ConceptList"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1168968918836">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1168968923089">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1168968925827"/>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                  id="1168968921869">
              <link role="variableDeclaration" targetNodeId="1168968630548" resolveInfo="parm"/>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1168968445647">
        <property name="name" value="op"/>
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1168968445648">
          <link role="concept" targetNodeId="1.1138411891628"/>
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1178546096892"/>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1168969209239">
      <property name="name" value="nodeOp_hasParm_conceptList"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1168969209240"/>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1168969209241">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1168969209242">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1168969209243">
            <property name="name" value="parm"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1168969209244">
              <link role="classifier" targetNodeId="4.~Object" resolveInfo="Object"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1168969209245">
              <link role="classConcept" targetNodeId="2.~SModelLanguageUtil" resolveInfo="SModelLanguageUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="2.~SModelLanguageUtil.findNodeOperationParameter(jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation,java.lang.Class):java.lang.Object"
                    resolveInfo="findNodeOperationParameter"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204668499940">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1168969209247">
                  <link role="variableDeclaration" targetNodeId="1168969209269" resolveInfo="op"/>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                      id="1171245192546"/>
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression"
                    id="1168969209249">
                <link role="classifier" targetNodeId="19.~OperationParm_Concept" resolveInfo="OperationParm_Concept"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1168969209250">
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1168969209251">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                  id="1168969209252">
              <link role="variableDeclaration" targetNodeId="1168969209243" resolveInfo="parm"/>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1168969209253"/>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1168969209254">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1168969209255">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1168969227538"/>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1168969209257">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1168969209258">
            <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1168969209259">
              <link role="variableDeclaration" targetNodeId="1168969209243" resolveInfo="parm"/>
            </node>
            <node role="rValue" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1168969209260">
              <link role="classConcept" targetNodeId="2.~SModelLanguageUtil" resolveInfo="SModelLanguageUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="2.~SModelLanguageUtil.findNodeOperationParameter(jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation,java.lang.Class):java.lang.Object"
                    resolveInfo="findNodeOperationParameter"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204668499921">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1168969209262">
                  <link role="variableDeclaration" targetNodeId="1168969209269" resolveInfo="op"/>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                      id="1171245240018"/>
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression"
                    id="1168969209264">
                <link role="classifier" targetNodeId="19.~OperationParm_ConceptList"
                      resolveInfo="OperationParm_ConceptList"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1168969209265">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1168969229697">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                  id="1168969209268">
              <link role="variableDeclaration" targetNodeId="1168969209243" resolveInfo="parm"/>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1168969209267"/>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1168969209269">
        <property name="name" value="op"/>
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1168969209270">
          <link role="concept" targetNodeId="1.1138411891628"/>
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1178546096893"/>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1168979165563">
      <property name="name" value="isProperty_hasValueEnum_notNullDefaultValue"/>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1168979234216">
        <property name="name" value="op"/>
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1168979234217">
          <link role="concept" targetNodeId="1.1146171026731"/>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1168979379803">
        <property name="name" value="generator"/>
        <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1168979379804">
          <link role="classifier" targetNodeId="11.~ITemplateGenerator" resolveInfo="ITemplateGenerator"/>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1168979172347"/>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1168979165565">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1170702261821">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1170702261822">
            <property name="name" value="datatype"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1171245931336">
              <link role="classifier" targetNodeId="20.~DataTypeDeclaration" resolveInfo="DataTypeDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1170702261824">
              <link role="classConcept" targetNodeId="2.~SModelLanguageUtil" resolveInfo="SModelLanguageUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="2.~SModelLanguageUtil.getDatatypeFromLeft_SPropertyAccess(jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation):jetbrains.mps.bootstrap.structureLanguage.structure.DataTypeDeclaration"
                    resolveInfo="getDatatypeFromLeft_SPropertyAccess"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204668499913">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1170702286236">
                  <link role="variableDeclaration" targetNodeId="1168979234216" resolveInfo="op"/>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                      id="1171245492653"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1170702261830">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1170702261831">
            <property name="name" value="defMember"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1171245726232">
              <link role="classifier" targetNodeId="20.~EnumerationMemberDeclaration"
                    resolveInfo="EnumerationMemberDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1170702261833">
              <link role="classConcept" targetNodeId="7.~DataTypeUtil" resolveInfo="DataTypeUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="7.~DataTypeUtil.getDefaultMember(jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationDataTypeDeclaration):jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationMemberDeclaration"
                    resolveInfo="getDefaultMember"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1171245941948">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1171245941949">
                  <link role="variableDeclaration" targetNodeId="1170702261822" resolveInfo="datatype"/>
                </node>
                <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1171245941950">
                  <link role="classifier" targetNodeId="20.~EnumerationDataTypeDeclaration"
                        resolveInfo="EnumerationDataTypeDeclaration"/>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1171245789654">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1171245789655">
            <property name="name" value="defMemberNode"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1171245804956">
              <link role="concept" targetNodeId="5.1083171877298"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206476139933">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1170702261841">
                <link role="variableDeclaration" targetNodeId="1170702261831" resolveInfo="defMember"/>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1206476139934">
                <link role="baseMethodDeclaration" targetNodeId="7.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode"
                      resolveInfo="getNode"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170702261837">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1170702261838">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1170702261839"/>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227915726">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1171245789658">
                <link role="variableDeclaration" targetNodeId="1171245789655" resolveInfo="defMemberNode"/>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                    id="1170702261842">
                <link role="property" targetNodeId="5.1083923523171"/>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1178546096795"/>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1168979519274">
      <property name="name" value="isProperty_hasValueEnum_nullDefaultValue"/>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1168979519275">
        <property name="name" value="op"/>
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1168979519276">
          <link role="concept" targetNodeId="1.1146171026731"/>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1168979519277">
        <property name="name" value="generator"/>
        <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1168979519278">
          <link role="classifier" targetNodeId="11.~ITemplateGenerator" resolveInfo="ITemplateGenerator"/>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1168979519279"/>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1168979519280">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1170702390203">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1170702390204">
            <property name="name" value="datatype"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1171246058604">
              <link role="classifier" targetNodeId="20.~DataTypeDeclaration" resolveInfo="DataTypeDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1170702390206">
              <link role="classConcept" targetNodeId="2.~SModelLanguageUtil" resolveInfo="SModelLanguageUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="2.~SModelLanguageUtil.getDatatypeFromLeft_SPropertyAccess(jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperation):jetbrains.mps.bootstrap.structureLanguage.structure.DataTypeDeclaration"
                    resolveInfo="getDatatypeFromLeft_SPropertyAccess"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204668499917">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1170702860570">
                  <link role="variableDeclaration" targetNodeId="1168979519275" resolveInfo="op"/>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                      id="1171246077234"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1170702390212">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1170702390213">
            <property name="name" value="defMember"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1171246102220">
              <link role="classifier" targetNodeId="20.~EnumerationMemberDeclaration"
                    resolveInfo="EnumerationMemberDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1170702390215">
              <link role="classConcept" targetNodeId="7.~DataTypeUtil" resolveInfo="DataTypeUtil"/>
              <link role="baseMethodDeclaration"
                    targetNodeId="7.~DataTypeUtil.getDefaultMember(jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationDataTypeDeclaration):jetbrains.mps.bootstrap.structureLanguage.structure.EnumerationMemberDeclaration"
                    resolveInfo="getDefaultMember"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1171246120426">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1171246120427">
                  <link role="variableDeclaration" targetNodeId="1170702390204" resolveInfo="datatype"/>
                </node>
                <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1171246120428">
                  <link role="classifier" targetNodeId="20.~EnumerationDataTypeDeclaration"
                        resolveInfo="EnumerationDataTypeDeclaration"/>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1171246134157">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1171246134158">
            <property name="name" value="defMemberNode"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1171246134159">
              <link role="concept" targetNodeId="5.1083171877298"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206476139980">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1171246137912">
                <link role="variableDeclaration" targetNodeId="1170702390213" resolveInfo="defMember"/>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1206476139981">
                <link role="baseMethodDeclaration" targetNodeId="7.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode"
                      resolveInfo="getNode"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170702390219">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1170702390220">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227879790">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1171246142288">
                <link role="variableDeclaration" targetNodeId="1171246134158" resolveInfo="defMemberNode"/>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                    id="1170702390223">
                <link role="property" targetNodeId="5.1083923523171"/>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1170702390224"/>
          </node>
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1178546097238"/>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1172424541766">
      <property name="name" value="getConceptFqName"/>
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1172424548134">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String"/>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1172424541768">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1172424577871">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1172424595467">
            <link role="classConcept" targetNodeId="23.~NameUtil" resolveInfo="NameUtil"/>
            <link role="baseMethodDeclaration"
                  targetNodeId="23.~NameUtil.nodeFQName(jetbrains.mps.smodel.SNode):java.lang.String"
                  resolveInfo="nodeFQName"/>
            <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ParameterReference"
                  id="1172424608784">
              <link role="variableDeclaration" targetNodeId="1172424560853" resolveInfo="concept"/>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1172424560853">
        <property name="name" value="concept"/>
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1172424560854">
          <link role="concept" targetNodeId="5.1169125787135"/>
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1178546096743"/>
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1178550081005"/>
  </node>
</model>

