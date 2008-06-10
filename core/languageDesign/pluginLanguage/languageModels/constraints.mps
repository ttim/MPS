<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.pluginLanguage.constraints">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.constraintsLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1" />
  </language>
  <language namespace="jetbrains.mps.quotation" />
  <language namespace="jetbrains.mps.bootstrap.sharedConcepts" />
  <language namespace="jetbrains.mps.bootstrap.helgins" />
  <language namespace="jetbrains.mps.baseLanguage.strings" />
  <language namespace="jetbrains.mps.core" />
  <languageAspect modelUID="jetbrains.mps.bootstrap.pluginLanguage.structure" version="1" />
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
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <maxImportIndex value="28" />
  <import index="3" modelUID="jetbrains.mps.core.structure" version="-1" />
  <import index="4" modelUID="java.lang@java_stub" version="-1" />
  <import index="5" modelUID="jetbrains.mps.util@java_stub" version="-1" />
  <import index="7" modelUID="jetbrains.mps.bootstrap.pluginLanguage.structure" version="1" />
  <import index="8" modelUID="jetbrains.mps.smodel@java_stub" version="-1" />
  <import index="10" modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  <import index="11" modelUID="jetbrains.mps.smodel.search@java_stub" version="-1" />
  <import index="16" modelUID="jetbrains.mps.ide.action@java_stub" version="-1" />
  <import index="19" modelUID="jetbrains.mps.baseLanguage.constraints" version="-1" />
  <import index="20" modelUID="jetbrains.mps.plugins@java_stub" version="-1" />
  <import index="21" modelUID="jetbrains.mps.project@java_stub" version="-1" />
  <import index="24" modelUID="jetbrains.mps.baseLanguage.classifiers.structure" version="-1" />
  <import index="25" modelUID="jetbrains.mps.baseLanguage.classifiers.constraints" version="-1" />
  <import index="28" modelUID="jetbrains.mps.bootstrap.structureLanguage.editor@java_stub" version="-1" />
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1203086933326">
    <property name="package" value="Actions.Action" />
    <link role="concept" targetNodeId="7.1203071646776" resolveInfo="Action" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1203086933327">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203086933328">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1205608042456">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1205608042457">
            <property name="name" value="module" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608042458">
              <link role="classifier" targetNodeId="21.~IModule" resolveInfo="IModule" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608042459">
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1205608042460">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModelDescriptor.getModule():jetbrains.mps.project.IModule" resolveInfo="getModule" />
              </node>
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608042461">
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1205608042462">
                  <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getModelDescriptor():jetbrains.mps.smodel.SModelDescriptor" resolveInfo="getModelDescriptor" />
                </node>
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1205608104857">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1205608106812">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608111629">
                      <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205608111630" />
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1205608111631" />
                    </node>
                    <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608110440">
                      <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1205608042469">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205608042470">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1205608126241">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608126242">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608126243">
                  <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205608126244" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205608126245">
                    <link role="link" targetNodeId="7.1205607379485" />
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1205608126246">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1205610317621">
                    <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205610275836">
                      <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1205608126248">
                        <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608133203">
                          <link role="classifier" targetNodeId="16.~MPSAction" resolveInfo="MPSAction" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205610283370">
                        <link role="link" targetNodeId="10.1107535924139" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1205608042473">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression" id="1205608042474">
              <node role="classType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608042475">
                <link role="classifier" targetNodeId="8.~Language" resolveInfo="Language" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205608042476">
                <link role="variableDeclaration" targetNodeId="1205608042457" resolveInfo="module" />
              </node>
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement" id="1205608042477">
            <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205608042478">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1205608145283">
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205608145284">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1205608162909">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608162910">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608162911">
                        <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205608162912" />
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205608162913">
                          <link role="link" targetNodeId="7.1205607379485" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1205608162914">
                        <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1205608162915">
                          <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205610323045">
                            <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1205608162916">
                              <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608174184">
                                <link role="classifier" targetNodeId="20.~CurrentProjectMPSAction" resolveInfo="CurrentProjectMPSAction" />
                              </node>
                            </node>
                            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205610325328">
                              <link role="link" targetNodeId="10.1107535924139" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1205608155412">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608155413">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608155414">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1205608155415">
                        <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1205608155416">
                          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205608155417">
                            <link role="variableDeclaration" targetNodeId="1205608042457" resolveInfo="module" />
                          </node>
                          <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608155418">
                            <link role="classifier" targetNodeId="8.~Language" resolveInfo="Language" />
                          </node>
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1205608155419">
                        <link role="baseMethodDeclaration" targetNodeId="8.~Language.getPluginModelDescriptor():jetbrains.mps.smodel.SModelDescriptor" resolveInfo="getPluginModelDescriptor" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1205608155420">
                      <link role="baseMethodDeclaration" targetNodeId="8.~SModelDescriptor.getSModel():jetbrains.mps.smodel.SModel" resolveInfo="getSModel" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608155421">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205608168933" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1205608155423" />
                  </node>
                </node>
                <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement" id="1205608176874">
                  <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205608176875">
                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1205608183360">
                      <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608183361">
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205608183362">
                          <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205608183363" />
                          <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205608183364">
                            <link role="link" targetNodeId="7.1205607379485" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1205608183365">
                          <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1205608183366">
                            <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205610328376">
                              <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1205608183367">
                                <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205608183368">
                                  <link role="classifier" targetNodeId="16.~MPSAction" resolveInfo="MPSAction" />
                                </node>
                              </node>
                              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205610330253">
                                <link role="link" targetNodeId="10.1107535924139" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1203086959942">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203086959943">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203086959944">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203086959945">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203086959946">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1203086959947">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
              <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227896816">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203086959950" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1203093300887">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203086959951">
              <property name="value" value="_Action" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1203873385358">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873387861">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203873385360">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203873429080">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873528966">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873534658">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227936774">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203873545948" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1203873545949">
                  <link role="conceptMethodDeclaration" targetNodeId="1203086959942" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203873531844">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388982892">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1203873501488">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1203873501881">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203873501882">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203873501883" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1203873501884" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873501885">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204388982893">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1205852411226">
      <property name="name" value="createType" />
      <link role="overriddenMethod" targetNodeId="25.1205753057931" resolveInfo="createType" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205852411227">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1205852411228">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1205852411229">
            <property name="name" value="type" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1205852411230">
              <link role="concept" targetNodeId="7.1205852320419" resolveInfo="ActionType" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1205852411231">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1205852411232">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1205852411233">
                  <link role="concept" targetNodeId="7.1205852320419" resolveInfo="ActionType" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1205852411234">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205852411235">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205852411236">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205852411237">
                <link role="variableDeclaration" targetNodeId="1205852411229" resolveInfo="type" />
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205852429184">
                <link role="link" targetNodeId="7.1205852349655" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1205852411239">
              <node role="parameter" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205852411240" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1205852411241">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205852411242">
            <link role="variableDeclaration" targetNodeId="1205852411229" resolveInfo="type" />
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1205852412480">
        <link role="concept" targetNodeId="24.1205752813637" resolveInfo="BaseClassifierType" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1203094511966">
    <property name="package" value="Actions.Groups" />
    <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1203094511967">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203094511968" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1205591866276">
      <property name="name" value="getGroupPrefix" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205591880856">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205591866278">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1205591950658">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1205591950659">
            <property name="name" value="prefix" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1205591950660">
              <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1205592166478">
              <property name="value" value="" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1205591950662">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1205591950663">
            <property name="name" value="parentGroup" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1205591950664">
              <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205591950665">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205591950666" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation" id="1205591950667">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept" id="1205591950668">
                  <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1205591950669">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205591950670">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1205591950671">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1205591950672">
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1205592199979">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205592203608">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205592202357">
                      <link role="variableDeclaration" targetNodeId="1205591950663" resolveInfo="parentGroup" />
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1205592205923">
                      <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205591950673">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205591950674">
                      <link role="variableDeclaration" targetNodeId="1205591950663" resolveInfo="parentGroup" />
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1205591950675">
                      <link role="conceptMethodDeclaration" targetNodeId="1205591866276" resolveInfo="getInternalGroupsPrefix" />
                    </node>
                  </node>
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205591950676">
                  <link role="variableDeclaration" targetNodeId="1205591950659" resolveInfo="prefix" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1205591950677">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1205591950678" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205591967118">
              <link role="variableDeclaration" targetNodeId="1205591950663" resolveInfo="parentGroup" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1205592019848">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1205592021616">
            <link role="variableDeclaration" targetNodeId="1205591950659" resolveInfo="prefix" />
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1203094543712">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203094543713">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203094543714">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203094543715">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203094543716">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1205590994443">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1205591000056">
                <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
                <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205591000057">
                  <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205591000058" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1205591000059">
                    <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                  </node>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205592152756">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205592144973" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1205592144974">
                  <link role="conceptMethodDeclaration" targetNodeId="1205591866276" resolveInfo="getGroupPrefix" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203094543721">
              <property name="value" value="_ActionGroup" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1203873563137">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873563138">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203873563139">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203873563140">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873563141">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873563142">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227832311">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203873563144" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1203873563145">
                  <link role="conceptMethodDeclaration" targetNodeId="1203094543712" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203873563146">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388969249">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1203873563148">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1203873563149">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203873563150">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203873563151" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1203873567560" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873563153">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204388969250">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204995370957">
      <property name="name" value="getID" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204995378700">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204995370959">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204995384599">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204995396671">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204995401965">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204995406729">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204995405963" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1205002845442">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204995400388">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204995393464">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1204995393465">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204995393466">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204995393467">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204995393468" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1204995393469" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204995393470">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204995393471">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1207492216922">
      <property name="name" value="createType" />
      <link role="overriddenMethod" targetNodeId="25.1205753057931" resolveInfo="createType" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207492216923">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1207492216924">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1207492216925">
            <property name="name" value="type" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1207492216926">
              <link role="concept" targetNodeId="7.1207490810216" resolveInfo="GroupType" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1207492216927">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1207492216928">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1207492216929">
                  <link role="concept" targetNodeId="7.1207490810216" resolveInfo="GroupType" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207492216930">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207492216931">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207492216932">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207492216933">
                <link role="variableDeclaration" targetNodeId="1207492216925" resolveInfo="type" />
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1207492239230">
                <link role="link" targetNodeId="7.1207490810218" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1207492216935">
              <node role="parameter" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1207492216936" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1207492216937">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207492216938">
            <link role="variableDeclaration" targetNodeId="1207492216925" resolveInfo="type" />
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1207492217691">
        <link role="concept" targetNodeId="24.1205752813637" resolveInfo="BaseClassifierType" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1203686306502">
    <property name="package" value="Actions.Groups.GroupMembers" />
    <link role="concept" targetNodeId="7.1203680534665" resolveInfo="ExtentionPoint" />
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1203686308396">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203686311898">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203686308398">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203686329587">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203686329588">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1203686329589">
              <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227913192">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203686329592" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1203689181796">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203686329593">
              <property name="value" value="_ExtentionPoint" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1203873574983">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873574984">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203873574985">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203873574986">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873574987">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1203873574988">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227955909">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203873574990" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1203873574991">
                  <link role="conceptMethodDeclaration" targetNodeId="1203686308396" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203873574992">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388987800">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1203873574994">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1203873574995">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203873574996">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1203873574997" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1203873574998" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1203873574999">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204388987801">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1203686306503">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203686306504" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204042998735">
    <property name="package" value="EditorTab" />
    <link role="concept" targetNodeId="7.1203866019489" resolveInfo="TabbedEditorDeclaration" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1204042998736">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204042998737" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204043000833">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204043000834">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204043000835">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204043000836">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204043000837">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204043000838">
              <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227898005">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204043000841" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1204043005125">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204043000842">
              <property name="value" value="_TabbedEditor" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204043000843">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204043000844">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204043000845">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204043000846">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204043000847">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204043000848">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227832108">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204043000850" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1204043000851">
                  <link role="conceptMethodDeclaration" targetNodeId="1204043000833" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204043000852">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388996445">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1204043000854">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204043000855">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204043000856">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204043000857" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1204043000858" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204043000859">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204388996446">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204047775341">
    <property name="package" value="EditorTab" />
    <link role="concept" targetNodeId="7.1203851787677" resolveInfo="AbstractEditorTab" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1204047775342">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204047775343" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204047777640">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204047777641">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204047777642">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204047777643">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204047777644">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204047777645">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
              <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227928525">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204047777648" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1204047789761">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204047777649">
              <property name="value" value="_Tab" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204047777650">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204047777651">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204047777652">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204047777653">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204047777654">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204047777655">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227959731">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204047777657" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1204047777658">
                  <link role="conceptMethodDeclaration" targetNodeId="1204047777640" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204047777659">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204388992443">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1204047777661">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204047777662">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204047777663">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204047777664" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1204047777665" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204047777666">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204388992444">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204464473854">
    <property name="package" value="Tool" />
    <link role="concept" targetNodeId="7.1203071677434" resolveInfo="Tool" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1204464473855">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204464473856" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204469301508">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204469301509">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204469301510">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204469301511">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204469301512">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1204469301513">
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
              <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301514">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204469301515" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1204469301516">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204469301517">
              <property name="value" value="_Tool" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1204469301518">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204469301519">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204469301520">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204469301521">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204469301522">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1204469301523">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301524">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204469301525" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1204469301526">
                  <link role="conceptMethodDeclaration" targetNodeId="1204469301508" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204469301527">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301528">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1204469301529">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1204469301530">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204469301531">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1204469301532" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1204469301533" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1204469301534">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204469301535">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1208273066932">
      <property name="name" value="hasNumber" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1208273072039" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208273066934">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208273084682">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AndExpression" id="1208273097089">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.AndExpression" id="1208273117716">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.LessThanOrEqualsExpression" id="1208273125021">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1208273126267">
                  <property name="value" value="9" />
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208273120918">
                  <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1208273120238" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1208273122270">
                    <link role="property" targetNodeId="7.1204464939608" resolveInfo="number" />
                  </node>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LessThanOrEqualsExpression" id="1208273114165">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1208273114166">
                  <property name="value" value="0" />
                </node>
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208273114167">
                  <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1208273114168" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1208273114169">
                    <link role="property" targetNodeId="7.1204464939608" resolveInfo="number" />
                  </node>
                </node>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1208273094567">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208273094568">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208273094569">
                  <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1208273094570" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1208273094571">
                    <link role="property" targetNodeId="7.1204464939608" resolveInfo="number" />
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Property_HasValue_Simple" id="1208273094572">
                  <node role="value" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1208273094573" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1208529467292">
      <property name="name" value="createType" />
      <link role="overriddenMethod" targetNodeId="25.1205753057931" resolveInfo="createType" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208529467294">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1208529496566">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1208529496567">
            <property name="name" value="type" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1208529496568">
              <link role="concept" targetNodeId="7.1208528650020" resolveInfo="ToolType" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1208529509832">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1208529509833">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1208529509834">
                  <link role="concept" targetNodeId="7.1208528650020" resolveInfo="ToolType" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208529518463">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1208529598530">
            <node role="rValue" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1208529600079" />
            <node role="lValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208529519481">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208529518464">
                <link role="variableDeclaration" targetNodeId="1208529496567" resolveInfo="type" />
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1208529597451">
                <link role="link" targetNodeId="7.1208529537963" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1208529512476">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208529515509">
            <link role="variableDeclaration" targetNodeId="1208529496567" resolveInfo="type" />
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1208977148226">
        <link role="concept" targetNodeId="24.1205752813637" resolveInfo="BaseClassifierType" />
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1208950212990">
      <property name="name" value="getExpandedIconPath" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1208950212991">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208950212992">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1208950212993">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1208950212994">
            <property name="name" value="result" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1208950212995">
              <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1208950212996" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1208950212997">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1208950212998">
            <property name="name" value="module" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1208950212999">
              <link role="classifier" targetNodeId="21.~IModule" resolveInfo="IModule" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1208950213000">
              <link role="baseMethodDeclaration" targetNodeId="28.~EditorUtil.findAnchorModule(jetbrains.mps.smodel.SNode):jetbrains.mps.project.IModule" resolveInfo="findAnchorModule" />
              <link role="classConcept" targetNodeId="28.~EditorUtil" resolveInfo="EditorUtil" />
              <node role="actualArgument" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1208950213001" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1208950213002">
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1208950213003">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1208950213004" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208950213005">
              <link role="variableDeclaration" targetNodeId="1208950212998" resolveInfo="module" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208950213006">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208950213007">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1208950213008">
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208950213009">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1208950213010">
                    <link role="classConcept" targetNodeId="5.~Macros" resolveInfo="Macros" />
                    <link role="baseMethodDeclaration" targetNodeId="5.~Macros.moduleDescriptor(jetbrains.mps.project.IModule):jetbrains.mps.util.Macros" resolveInfo="moduleDescriptor" />
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208950213011">
                      <link role="variableDeclaration" targetNodeId="1208950212998" resolveInfo="module" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1208950213012">
                    <link role="baseMethodDeclaration" targetNodeId="5.~Macros.expandPath(java.lang.String,jetbrains.mps.vfs.IFile):java.lang.String" resolveInfo="expandPath" />
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208950213013">
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1208950218866">
                        <link role="property" targetNodeId="7.1204464929231" resolveInfo="icon" />
                      </node>
                      <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1208950213015" />
                    </node>
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208950213016">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208950213017">
                        <link role="variableDeclaration" targetNodeId="1208950212998" resolveInfo="module" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1208950213018">
                        <link role="baseMethodDeclaration" targetNodeId="21.~IModule.getDescriptorFile():jetbrains.mps.vfs.IFile" resolveInfo="getDescriptorFile" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208950213019">
                  <link role="variableDeclaration" targetNodeId="1208950212994" resolveInfo="result" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208950213020">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1208950213021">
            <link role="variableDeclaration" targetNodeId="1208950212994" resolveInfo="result" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204903964188">
    <property name="package" value="Actions.Groups.GroupMembers" />
    <link role="concept" targetNodeId="7.1204903488751" resolveInfo="JavaAction" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1204903964189">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204903964190" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1204992362939">
    <property name="package" value="Actions.Groups.GroupModification" />
    <link role="concept" targetNodeId="7.1203092361741" resolveInfo="ModificationStatement" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1204992362940">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204992362941" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1205675729058">
    <property name="package" value="Actions.Groups.GroupMembers" />
    <link role="concept" targetNodeId="7.1205675355325" resolveInfo="ParameterizedActionCreator" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1205675729059">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205675729060" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1205853294030">
    <property name="package" value="Actions.Action" />
    <link role="concept" targetNodeId="7.1205852320419" resolveInfo="ActionType" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1205853294031">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205853294032" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1205853298190">
      <property name="name" value="getMembers" />
      <link role="overriddenMethod" targetNodeId="25.1205837324654" resolveInfo="getMembers" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1205853298191">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1205853298192">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205853298193">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1205853298194">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1205853298195" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1205853302206">
                <link role="link" targetNodeId="7.1205852349655" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1205853298197">
              <link role="conceptMethodDeclaration" targetNodeId="25.1205836846834" resolveInfo="getMembers" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1205853305035">
                <link role="variableDeclaration" targetNodeId="1205853298593" resolveInfo="contextNode" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1205853298593">
        <property name="name" value="contextNode" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1205853298594" />
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1205853298595">
        <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1206093187355">
    <property name="package" value="Actions.Action" />
    <link role="concept" targetNodeId="7.1206092561075" resolveInfo="ActionParameterReferenceOperation" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1206093187356">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206093187357" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1206111575439">
    <property name="package" value="Custom" />
    <link role="concept" targetNodeId="7.1206110063106" resolveInfo="CustomPlugin" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1206111575440">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206111575441" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1206116394033">
      <property name="name" value="getGeneratedName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1206116394034">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206116394035">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1206116394036">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1206116394037">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1206116394038">
              <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.toValidIdentifier(java.lang.String):java.lang.String" resolveInfo="toValidIdentifier" />
              <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206116394039">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1206116394040" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1206116400924">
                  <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1206116394042">
              <property name="value" value="_CustomPlugin" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1206116394043">
      <property name="name" value="getGeneratedClassFQName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1206116394044">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206116394045">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1206116394046">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1206116394047">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1206116394048">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206116394049">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1206116394050" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1206116394051">
                  <link role="conceptMethodDeclaration" targetNodeId="1206116394033" resolveInfo="getGeneratedName" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1206116394052">
                <property name="value" value="." />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206116394053">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1206116394054">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1206116394055">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206116394056">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1206116394057" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation" id="1206116394058" />
                  </node>
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1206116394059">
                    <link role="classifier" targetNodeId="8.~SModel" resolveInfo="SModel" />
                  </node>
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1206116394060">
                <link role="baseMethodDeclaration" targetNodeId="8.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1206111578032">
      <property name="name" value="createType" />
      <link role="overriddenMethod" targetNodeId="25.1205753057931" resolveInfo="createType" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206111578033">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1206111578034">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1206111578035">
            <property name="name" value="type" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1206111578036">
              <link role="concept" targetNodeId="7.1206111617316" resolveInfo="PluginType" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1206111578037">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1206111578038">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1206111578039">
                  <link role="concept" targetNodeId="7.1206111617316" resolveInfo="PluginType" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206111578040">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206111578041">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206111578042">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206111578043">
                <link role="variableDeclaration" targetNodeId="1206111578035" resolveInfo="type" />
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1206116346832">
                <link role="link" targetNodeId="7.1206111659667" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1206111578045">
              <node role="parameter" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1206111578046" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1206111578047">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206111578048">
            <link role="variableDeclaration" targetNodeId="1206111578035" resolveInfo="type" />
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1206111578458">
        <link role="concept" targetNodeId="24.1205752813637" resolveInfo="BaseClassifierType" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1206111906874">
    <property name="package" value="Custom" />
    <link role="concept" targetNodeId="7.1206111617316" resolveInfo="PluginType" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1206111906875">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206111906876" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1206111917156">
      <property name="name" value="getMembers" />
      <link role="overriddenMethod" targetNodeId="25.1205837324654" resolveInfo="getMembers" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206111917157">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1206111917158">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206111917159">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206111917160">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1206111917161" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1206191135145">
                <link role="link" targetNodeId="7.1206111659667" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1206111917163">
              <link role="conceptMethodDeclaration" targetNodeId="25.1205836846834" resolveInfo="getMembers" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1206111929060">
                <link role="variableDeclaration" targetNodeId="1206111917324" resolveInfo="contextNode" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1206111917324">
        <property name="name" value="contextNode" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1206111917325" />
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1206111917326">
        <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1207318339097">
    <property name="package" value="Actions.Action" />
    <link role="concept" targetNodeId="7.1207318242772" resolveInfo="KeyMapKeystroke" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1207318339098">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207318339099" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1207318356744">
      <property name="name" value="getKeyStroke" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1207318356745">
        <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207318356746">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1207318356747">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1207318356748">
            <property name="name" value="result" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1207318356749">
              <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1207318356750">
              <property name="value" value="" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1207318356751">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1207318356752">
            <property name="name" value="modifiers" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1207318356753">
              <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318356754">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1207318356755" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1207318356756">
                <link role="property" targetNodeId="7.1207318242773" resolveInfo="modifiers" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1207318356757">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207318356758">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207318356759">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1207318356760">
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1207318356761">
                  <property name="value" value="" />
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356762">
                  <link role="variableDeclaration" targetNodeId="1207318356752" resolveInfo="modifiers" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1207318356763">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1207318356764" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356765">
              <link role="variableDeclaration" targetNodeId="1207318356752" resolveInfo="modifiers" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207318356766">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1207318356767">
            <node role="rValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318360871">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356769">
                <link role="variableDeclaration" targetNodeId="1207318356752" resolveInfo="modifiers" />
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1207318360872">
                <link role="baseMethodDeclaration" targetNodeId="4.~String.replaceAll(java.lang.String,java.lang.String):java.lang.String" resolveInfo="replaceAll" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1207318356770">
                  <property name="value" value="\\+" />
                </node>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1207318356771">
                  <property name="value" value=" " />
                </node>
              </node>
            </node>
            <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356772">
              <link role="variableDeclaration" targetNodeId="1207318356748" resolveInfo="result" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1207318356773">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1207318356774">
            <property name="name" value="keyName" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1207318356775">
              <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1207318356776">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207318356777">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207318356778">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1207318356779">
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356780">
                  <link role="variableDeclaration" targetNodeId="1207318356774" resolveInfo="keyName" />
                </node>
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318364639">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318356782">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1207318356783" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1207318356784">
                      <link role="property" targetNodeId="7.1207318242774" resolveInfo="keycode" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1207318364640">
                    <link role="baseMethodDeclaration" targetNodeId="4.~String.substring(int):java.lang.String" resolveInfo="substring" />
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1207318356785">
                      <property name="value" value="3" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318367797">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318356788">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1207318356789" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1207318356790">
                <link role="property" targetNodeId="7.1207318242774" resolveInfo="keycode" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1207318367798">
              <link role="baseMethodDeclaration" targetNodeId="4.~String.startsWith(java.lang.String):boolean" resolveInfo="startsWith" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1207318356787">
                <property name="value" value="VK_" />
              </node>
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement" id="1207318356791">
            <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207318356792">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207318356793">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1207318356794">
                  <node role="rValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207318356795">
                    <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1207318356796" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1207318356797">
                      <link role="property" targetNodeId="7.1207318242774" resolveInfo="keycode" />
                    </node>
                  </node>
                  <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356798">
                    <link role="variableDeclaration" targetNodeId="1207318356774" resolveInfo="keyName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207318356799">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1207318356800">
            <node role="rValue" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1207318356801">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1207318356802">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356803">
                  <link role="variableDeclaration" targetNodeId="1207318356774" resolveInfo="keyName" />
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1207318356804">
                  <property name="value" value=" " />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356805">
                <link role="variableDeclaration" targetNodeId="1207318356748" resolveInfo="result" />
              </node>
            </node>
            <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356806">
              <link role="variableDeclaration" targetNodeId="1207318356748" resolveInfo="result" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1207318356807">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1207318356808">
            <link role="variableDeclaration" targetNodeId="1207318356748" resolveInfo="result" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1207490921195">
    <property name="package" value="Actions.Groups" />
    <link role="concept" targetNodeId="7.1207490810216" resolveInfo="GroupType" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1207490921196">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207490921197" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1207490923166">
      <property name="name" value="getMembers" />
      <link role="overriddenMethod" targetNodeId="25.1205837324654" resolveInfo="getMembers" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207490923167">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1207490923168">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207490923169">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207490923170">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1207490923171" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1207492049468">
                <link role="link" targetNodeId="7.1207490810218" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1207490923173">
              <link role="conceptMethodDeclaration" targetNodeId="25.1205836846834" resolveInfo="getMembers" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1207492054232">
                <link role="variableDeclaration" targetNodeId="1207492039392" resolveInfo="contextNode" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1207492039392">
        <property name="name" value="contextNode" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1207492039393" />
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1207492039394">
        <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1208353979039">
    <property name="package" value="Tool.Methods" />
    <link role="concept" targetNodeId="7.1204471433283" resolveInfo="ToolInstanceExpression" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1208353979040">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208353979041" />
    </node>
    <node role="canBeAChild" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_CanBeAChild" id="1208353982089">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208353982090">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208353985763">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1208353985764">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1208353985765" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208353985766">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_parentNode" id="1208353994990" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation" id="1208353985768">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept" id="1208353985769">
                  <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1208353989958">
                    <link role="conceptDeclaration" targetNodeId="7.1203071677434" resolveInfo="Tool" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1208355170183">
    <property name="package" value="Actions.Groups.GroupContents" />
    <link role="concept" targetNodeId="7.1207145475354" resolveInfo="AddElementStatement" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1208355170184">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208355170185" />
    </node>
    <node role="canBeAChild" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_CanBeAChild" id="1208355172827">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208355172828">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208355177439">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1208355177440">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1208355177441" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208355177442">
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation" id="1208355177443">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Inclusion" id="1208355177444" />
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_ConceptList" id="1208355177445">
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.structure.ConceptReference" id="1208355177446">
                    <link role="concept" targetNodeId="7.1207145360364" resolveInfo="BuildGroupBlock" />
                  </node>
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.structure.ConceptReference" id="1208355177447">
                    <link role="concept" targetNodeId="7.1207489456631" resolveInfo="DoUpdateGroupBlock" />
                  </node>
                </node>
              </node>
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_parentNode" id="1208355182199" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1208355211083">
    <property name="package" value="Shared" />
    <link role="concept" targetNodeId="7.1206106212999" resolveInfo="Log" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1208355211084">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208355211085" />
    </node>
    <node role="canBeAChild" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_CanBeAChild" id="1208355213133">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1208355213134">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1208355215229">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1208355215230">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1208355215231" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1208355215232">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_parentNode" id="1208355231910" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation" id="1208355215234">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_ConceptList" id="1208355215235">
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.structure.ConceptReference" id="1208355215236">
                    <link role="concept" targetNodeId="7.1203071646776" resolveInfo="ActionDeclaration" />
                  </node>
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.structure.ConceptReference" id="1208355215237">
                    <link role="concept" targetNodeId="7.1206110063106" resolveInfo="CustomPluginDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1209909575772">
    <property name="package" value="Shared" />
    <link role="concept" targetNodeId="7.1209909558075" resolveInfo="ProjectOperation" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1209909575773">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1209909575774" />
    </node>
    <node role="canBeAChild" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_CanBeAChild" id="1209909578496">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1209909578497">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1209909597225">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1209909597226">
            <property name="name" value="can" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1209909597227" />
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1209909608206">
              <property name="value" value="false" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1209909584811">
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1209909588814">
            <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_parentNode" id="1209909587194" />
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation" id="1209909589742">
              <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1209909592487">
                <link role="conceptDeclaration" targetNodeId="10.1197027756228" resolveInfo="DotExpression" />
              </node>
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1209909584813">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1209909612047">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1209909615131">
                <node role="rValue" type="jetbrains.mps.bootstrap.helgins.structure.IsSubtypeExpression" id="1209909631069">
                  <node role="subtypeExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1209912752533">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1209909634972">
                      <node role="operand" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1209909640568">
                        <link role="concept" targetNodeId="10.1197027756228" resolveInfo="DotExpression" />
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_parentNode" id="1209909634397" />
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1209909647599">
                        <link role="link" targetNodeId="10.1197027771414" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.helgins.structure.Node_TypeOperation" id="1209912755148" />
                  </node>
                  <node role="supertypeExpression" type="jetbrains.mps.quotation.structure.Quotation" id="1209909652636">
                    <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1209909847835">
                      <link role="classifier" targetNodeId="21.~MPSProject" resolveInfo="MPSProject" />
                    </node>
                  </node>
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1209909612048">
                  <link role="variableDeclaration" targetNodeId="1209909597226" resolveInfo="can" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1209909609815">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1209909609816">
            <link role="variableDeclaration" targetNodeId="1209909597226" resolveInfo="can" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1209912147980">
    <property name="package" value="Tool" />
    <link role="concept" targetNodeId="7.1208528650020" resolveInfo="ToolType" />
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1209912152864">
      <property name="name" value="getMembers" />
      <link role="overriddenMethod" targetNodeId="25.1205837324654" resolveInfo="getMembers" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1209912152866">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1209912307307">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1209912310718">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1209912307719">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1209912307308" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1209912309995">
                <link role="link" targetNodeId="7.1208529537963" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1209912312534">
              <link role="conceptMethodDeclaration" targetNodeId="25.1205752112173" resolveInfo="getMembers" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1209912157076">
        <property name="name" value="contextNode" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1209912157077" />
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1209912157079">
        <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1209912334785">
      <property name="name" value="getClassExpression" />
      <link role="overriddenMethod" targetNodeId="19.1194035415601" resolveInfo="getClassExpression" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1209912334787">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1209912356305">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1209912356306" />
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1209912339579">
        <link role="concept" targetNodeId="10.1068431790191" resolveInfo="Expression" />
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1209912147981">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1209912147982" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1210071607017">
    <property name="package" value="GenerationListener" />
    <link role="concept" targetNodeId="7.1210070489991" resolveInfo="GenerationListenerDeclaration" />
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210071610071">
      <property name="name" value="getClassName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.strings.structure.StringType" id="1210071666191" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210071610073">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210071768333">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1210071759979">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1210071759980">
              <property name="value" value="_GenerationListener" />
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210071759981">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210071759982" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1210071759983">
                <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210071770050">
      <property name="name" value="getFieldName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.strings.structure.StringType" id="1210071772131" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210071770052">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210071789934">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1210071799034">
            <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.decapitalize(java.lang.String):java.lang.String" resolveInfo="decapitalize" />
            <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
            <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210071803574">
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1210072126578">
                <link role="conceptMethodDeclaration" targetNodeId="1210071610071" resolveInfo="getClassName" />
              </node>
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210071801561" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1210071607018">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210071607019" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1210179993484">
    <property name="package" value="Preference" />
    <link role="concept" targetNodeId="7.1210179134063" resolveInfo="PreferencesComponentDeclaration" />
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1210179993485">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210179993486" />
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210179996472">
      <property name="name" value="getClassName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.strings.structure.StringType" id="1210180015849" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210179996474">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210180018842">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1210180021759">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1210180024043">
              <property name="value" value="PreferencesComponent" />
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210180019581">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210180018843" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1210180020719">
                <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210181616131">
      <property name="name" value="getFieldName" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.strings.structure.StringType" id="1210181616132" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210181616133">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210181616134">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1210181626903">
            <link role="baseMethodDeclaration" targetNodeId="5.~NameUtil.decapitalize(java.lang.String):java.lang.String" resolveInfo="decapitalize" />
            <link role="classConcept" targetNodeId="5.~NameUtil" resolveInfo="NameUtil" />
            <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210181629178">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210181628910" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1210181632120">
                <link role="conceptMethodDeclaration" targetNodeId="1210179996472" resolveInfo="getClassName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210185197905">
      <property name="name" value="createType" />
      <link role="overriddenMethod" targetNodeId="25.1205753057931" resolveInfo="createType" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210185197907">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1210185244926">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1210185244927">
            <property name="name" value="type" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210185244928">
              <link role="concept" targetNodeId="7.1210184105060" resolveInfo="PreferencesComponentType" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1210185252923">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1210185252924">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210185252925">
                  <link role="concept" targetNodeId="7.1210184105060" resolveInfo="PreferencesComponentType" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210185260591">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1210185286749">
            <node role="rValue" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210185287842" />
            <node role="lValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210185261123">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1210185260592">
                <link role="variableDeclaration" targetNodeId="1210185244927" resolveInfo="type" />
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1210185267979">
                <link role="link" targetNodeId="7.1210184138184" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210185256477">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1210185256478">
            <link role="variableDeclaration" targetNodeId="1210185244927" resolveInfo="type" />
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210185199920">
        <link role="concept" targetNodeId="24.1205752813637" resolveInfo="BaseClassifierType" />
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210186220060">
      <property name="name" value="getMembers" />
      <link role="overriddenMethod" targetNodeId="25.1205752112173" resolveInfo="getMembers" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210186220062">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1210186494112">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1210186494113">
            <property name="name" value="members" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1210186494114">
              <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1210186503094">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator" id="1210186503095">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1210186503096">
                  <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210186507355">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210186508765">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1210186507356">
              <link role="variableDeclaration" targetNodeId="1210186494113" resolveInfo="members" />
            </node>
            <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.AddAllElementsOperation" id="1210186513841">
              <node role="argument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210186523953">
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210186519697" />
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess" id="1210186539105">
                  <link role="link" targetNodeId="7.1210179829398" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210186505234">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1210186505235">
            <link role="variableDeclaration" targetNodeId="1210186494113" resolveInfo="members" />
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1210186231818">
        <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1210184276511">
    <property name="package" value="Preference" />
    <link role="concept" targetNodeId="7.1210184105060" resolveInfo="PreferencesComponentType" />
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210184282612">
      <property name="name" value="getMembers" />
      <link role="overriddenMethod" targetNodeId="25.1205837324654" resolveInfo="getMembers" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210184282614">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210184313631">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210184325865">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210184313918">
              <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ThisNodeExpression" id="1210184313632" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1210184324519">
                <link role="link" targetNodeId="7.1210184138184" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1210184329399">
              <link role="conceptMethodDeclaration" targetNodeId="25.1205836846834" resolveInfo="getMembers" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1210184334231">
                <link role="variableDeclaration" targetNodeId="1210184285441" resolveInfo="contextNode" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1210184285441">
        <property name="name" value="contextNode" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210184285442" />
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1210184285444">
        <link role="elementConcept" targetNodeId="24.1205752032448" resolveInfo="IMember" />
      </node>
    </node>
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210184345174">
      <property name="name" value="getClassExpression" />
      <link role="overriddenMethod" targetNodeId="19.1194035415601" resolveInfo="getClassExpression" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210184345176">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1210184357642">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1210184357643" />
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210184347946">
        <link role="concept" targetNodeId="10.1068431790191" resolveInfo="Expression" />
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1210184276512">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210184276513" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptBehavior" id="1210186952371">
    <property name="package" value="Preference" />
    <link role="concept" targetNodeId="7.1210179190070" resolveInfo="PersistentPropertyDeclaration" />
    <node role="method" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptMethodDeclaration" id="1210187280769">
      <property name="name" value="getVisiblity" />
      <link role="overriddenMethod" targetNodeId="25.1205836775660" resolveInfo="getVisiblity" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210187280771">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1210187321578">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1210187338534">
            <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1210187338535">
              <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210187338536">
                <link role="concept" targetNodeId="10.1146644602865" resolveInfo="PublicVisibility" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1210187288797">
        <link role="concept" targetNodeId="10.1146644584814" resolveInfo="Visibility" />
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstructorDeclaration" id="1210187284040">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1210187284041" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstraints" id="1213104844944">
    <link role="concept" targetNodeId="7.1203071646776" resolveInfo="ActionDeclaration" />
    <node role="referent" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint" id="1213104845546">
      <link role="applicableLink" targetNodeId="7.1205607379485" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory" id="1213104845547">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104845548">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104845549">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104845550">
              <property name="name" value="correntNodes" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104845551">
                <link role="elementConcept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1213104845552">
                <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator" id="1213104845553">
                  <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104845554">
                    <link role="elementConcept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement" id="1213104845555">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable" id="1213104845556">
              <property name="name" value="classNode" />
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104845557">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1213104845558">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104845559">
                  <node role="operand" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1213104845560">
                    <link role="variable" targetNodeId="1213104845556" resolveInfo="classNode" />
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1213104845561">
                    <link role="conceptMethodDeclaration" targetNodeId="19.1199631877012" resolveInfo="isDescendant" />
                    <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1213104845562">
                      <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104845563">
                        <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1213104845564">
                          <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213104845565">
                            <link role="classifier" targetNodeId="16.~MPSAction" resolveInfo="MPSAction" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1213104845566">
                          <link role="link" targetNodeId="10.1107535924139" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104845567">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1213104845568">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104845569">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104845570">
                        <link role="variableDeclaration" targetNodeId="1213104845550" resolveInfo="correntNodes" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.AddElementOperation" id="1213104845571">
                        <node role="argument" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1213104845572">
                          <link role="variable" targetNodeId="1213104845556" resolveInfo="classNode" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104845573">
              <node role="operand" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_model" id="1213104845574" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_RootsIncludingImportedOperation" id="1213104845575">
                <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                <node role="scope" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope" id="1213104845576" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213104845577">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1213104845578">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)" resolveInfo="SimpleSearchScope" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104845579">
                <link role="variableDeclaration" targetNodeId="1213104845550" resolveInfo="correntNodes" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstraints" id="1213104846183">
    <link role="concept" targetNodeId="7.1204903488751" resolveInfo="JavaAction" />
    <node role="referent" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint" id="1213104846184">
      <link role="applicableLink" targetNodeId="7.1204903542721" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory" id="1213104846185">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104846186">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104846187">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104846188">
              <property name="name" value="correntNodes" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104846189">
                <link role="elementConcept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1213104846190">
                <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator" id="1213104846191">
                  <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104846192">
                    <link role="elementConcept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement" id="1213104846193">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable" id="1213104846194">
              <property name="name" value="classNode" />
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104846195">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1213104846196">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104846197">
                  <node role="operand" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1213104846198">
                    <link role="variable" targetNodeId="1213104846194" resolveInfo="classNode" />
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1213104846199">
                    <link role="conceptMethodDeclaration" targetNodeId="19.1199631877012" resolveInfo="isDescendant" />
                    <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1213104846200">
                      <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104846201">
                        <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1213104846202">
                          <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213104846203">
                            <link role="classifier" targetNodeId="16.~ActionGroupElement" resolveInfo="ActionGroupElement" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1213104846204">
                          <link role="link" targetNodeId="10.1107535924139" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104846205">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1213104846206">
                    <node role="expression" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression" id="1213104846207">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104846208">
                        <link role="variableDeclaration" targetNodeId="1213104846188" resolveInfo="correntNodes" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.AddElementOperation" id="1213104846209">
                        <node role="argument" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1213104846210">
                          <link role="variable" targetNodeId="1213104846194" resolveInfo="classNode" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104846211">
              <node role="operand" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_model" id="1213104846212" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_RootsIncludingImportedOperation" id="1213104846213">
                <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                <node role="scope" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope" id="1213104846214" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213104846215">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1213104846216">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)" resolveInfo="SimpleSearchScope" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104846217">
                <link role="variableDeclaration" targetNodeId="1213104846188" resolveInfo="correntNodes" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstraints" id="1213104856986">
    <link role="concept" targetNodeId="7.1205675355325" resolveInfo="ParameterizedActionCreator" />
    <node role="referent" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint" id="1213104856987">
      <link role="applicableLink" targetNodeId="7.1205675413186" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory" id="1213104856988">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104856989">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104856990">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104856991">
              <property name="name" value="correntNodes" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104856992">
                <link role="elementConcept" targetNodeId="10.1068580123140" resolveInfo="ConstructorDeclaration" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1213104856993">
                <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator" id="1213104856994">
                  <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104856995">
                    <link role="elementConcept" targetNodeId="10.1068580123140" resolveInfo="ConstructorDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement" id="1213104856996">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable" id="1213104856997">
              <property name="name" value="classNode" />
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104856998">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1213104856999">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104857000">
                  <node role="operand" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1213104857001">
                    <link role="variable" targetNodeId="1213104856997" resolveInfo="classNode" />
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1213104857002">
                    <link role="conceptMethodDeclaration" targetNodeId="19.1199631877012" resolveInfo="isDescendant" />
                    <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1213104857003">
                      <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104857004">
                        <node role="operand" type="jetbrains.mps.quotation.structure.Quotation" id="1213104857005">
                          <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1213104857006">
                            <link role="classifier" targetNodeId="16.~MPSAction" resolveInfo="MPSAction" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1213104857007">
                          <link role="link" targetNodeId="10.1107535924139" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104857008">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1213104857009">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104857010">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104857011">
                        <link role="variableDeclaration" targetNodeId="1213104856991" resolveInfo="correntNodes" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.AddAllElementsOperation" id="1213104857012">
                        <node role="argument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104857013">
                          <node role="operand" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1213104857014">
                            <link role="variable" targetNodeId="1213104856997" resolveInfo="classNode" />
                          </node>
                          <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess" id="1213104857015">
                            <link role="link" targetNodeId="10.1068390468201" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104857016">
              <node role="operand" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_model" id="1213104857017" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_RootsIncludingImportedOperation" id="1213104857018">
                <link role="concept" targetNodeId="10.1068390468198" resolveInfo="ClassConcept" />
                <node role="scope" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope" id="1213104857019" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213104857020">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1213104857021">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)" resolveInfo="SimpleSearchScope" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104857022">
                <link role="variableDeclaration" targetNodeId="1213104856991" resolveInfo="correntNodes" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConceptConstraints" id="1213104860268">
    <link role="concept" targetNodeId="7.1203092361741" resolveInfo="ModificationStatement" />
    <node role="referent" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint" id="1213104860269">
      <link role="applicableLink" targetNodeId="7.1204992316090" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory" id="1213104860270">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104860271">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104860272">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104860273">
              <property name="name" value="contents" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1213104860274">
                <link role="concept" targetNodeId="7.1207145102141" resolveInfo="GroupContents" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860275">
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1213104860276">
                  <link role="link" targetNodeId="7.1207145245948" />
                </node>
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860277">
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1213104860278">
                    <link role="link" targetNodeId="7.1203092736097" />
                  </node>
                  <node role="operand" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1213104860279">
                    <link role="concept" targetNodeId="7.1203092361741" resolveInfo="ModificationStatement" />
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_referenceNode" id="1213104860280" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1213104860281">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104860282">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213104860283">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1213104860284">
                  <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)" resolveInfo="SimpleSearchScope" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1213104860285">
                    <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListCreator" id="1213104860286">
                      <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104860287" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860288">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860289">
                <link role="variableDeclaration" targetNodeId="1213104860273" resolveInfo="contents" />
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation" id="1213104860290">
                <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1213104860291">
                  <link role="conceptDeclaration" targetNodeId="7.1207145360364" resolveInfo="BuildGroupBlock" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213104860292">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1213104860293">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)" resolveInfo="SimpleSearchScope" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860294">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860295">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860296">
                    <node role="operand" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression" id="1213104860297">
                      <link role="concept" targetNodeId="7.1207145163717" resolveInfo="ElementListContents" />
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860298">
                        <link role="variableDeclaration" targetNodeId="1213104860273" resolveInfo="contents" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess" id="1213104860299">
                      <link role="link" targetNodeId="7.1207145201301" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.WhereOperation" id="1213104860300">
                    <node role="whereClosure" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.WhereBlock" id="1213104860301">
                      <node role="defaultInputElement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.DefaultInputElement" id="1213104860302">
                        <property name="name" value="it" />
                      </node>
                      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104860303">
                        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1213104860304">
                          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860305">
                            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ClosureParameterReference" id="1213104860306">
                              <link role="closureParameter" targetNodeId="1213104860302" resolveInfo="it" />
                            </node>
                            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation" id="1213104860307">
                              <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1213104860308">
                                <link role="conceptDeclaration" targetNodeId="7.1203680534665" resolveInfo="ExtentionPoint" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation" id="1213104860309" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="referent" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint" id="1213104860310">
      <link role="applicableLink" targetNodeId="7.1203092736097" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunction_ReferentSearchScope_Factory" id="1213104860311">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104860312">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104860313">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104860314">
              <property name="name" value="actionGroupDeclarations" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104860315">
                <link role="elementConcept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860316">
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_RootsIncludingImportedOperation" id="1213104860317">
                  <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
                  <node role="scope" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope" id="1213104860318" />
                </node>
                <node role="operand" type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_model" id="1213104860319" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104860320">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104860321">
              <property name="name" value="groupDeclaration" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1213104860322">
                <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860323">
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation" id="1213104860324">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept" id="1213104860325">
                    <link role="concept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
                  </node>
                </node>
                <node role="operand" type="jetbrains.mps.bootstrap.constraintsLanguage.structure.ConstraintFunctionParameter_referenceNode" id="1213104860326" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1213104860327">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1213104860328">
              <property name="name" value="thisGroupChildGroups" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeListType" id="1213104860329">
                <link role="elementConcept" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860330">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860331">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860332">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860333">
                      <link role="variableDeclaration" targetNodeId="1213104860321" resolveInfo="groupDeclaration" />
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetDescendantsOperation" id="1213104860334" />
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.WhereOperation" id="1213104860335">
                    <node role="whereClosure" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.WhereBlock" id="1213104860336">
                      <node role="defaultInputElement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.DefaultInputElement" id="1213104860337">
                        <property name="name" value="it" />
                      </node>
                      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1213104860338">
                        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1213104860339">
                          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860340">
                            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ClosureParameterReference" id="1213104860341">
                              <link role="closureParameter" targetNodeId="1213104860337" resolveInfo="it" />
                            </node>
                            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation" id="1213104860342">
                              <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1213104860343">
                                <link role="conceptDeclaration" targetNodeId="7.1203087890642" resolveInfo="ActionGroupDeclaration" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation" id="1213104860344" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1213104860345">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860346">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860347">
                <link role="variableDeclaration" targetNodeId="1213104860328" resolveInfo="thisGroupChildGroups" />
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.AddElementOperation" id="1213104860348">
                <node role="argument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860349">
                  <link role="variableDeclaration" targetNodeId="1213104860321" resolveInfo="groupDeclaration" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1213104860350">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1213104860351">
              <link role="baseMethodDeclaration" targetNodeId="11.~SimpleSearchScope.&lt;init&gt;(java.util.List)" resolveInfo="SimpleSearchScope" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860352">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1213104860353">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860354">
                    <link role="variableDeclaration" targetNodeId="1213104860314" resolveInfo="actionGroupDeclarations" />
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ExcludeOperation" id="1213104860355">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1213104860356">
                      <link role="variableDeclaration" targetNodeId="1213104860328" resolveInfo="thisGroupChildGroups" />
                    </node>
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation" id="1213104860357" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

