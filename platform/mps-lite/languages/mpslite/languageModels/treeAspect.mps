<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mpslite.treeAspect">
  <persistence version="1" />
  <language namespace="jetbrains.mps.ypath" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <language namespace="jetbrains.mpslite" />
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage" />
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang" />
  <language namespace="jetbrains.mps.quotation" />
  <language namespace="jetbrains.mps.core" />
  <maxImportIndex value="4" />
  <import index="1" modelUID="jetbrains.mpslite.structure" version="-1" />
  <import index="2" modelUID="jetbrains.mpslite.constraints" version="-1" />
  <import index="3" modelUID="jetbrains.mps.core.structure" version="-1" />
  <import index="4" modelUID="java.lang@java_stub" version="-1" />
  <node type="jetbrains.mps.ypath.structure.TreePathAspect" id="1196682965759">
    <property name="name" value="MPSLite_Nodes" />
    <node role="features" type="jetbrains.mps.ypath.structure.GenericParamFeature" id="1196691896258">
      <property name="name" value="child" />
      <node role="getter" type="jetbrains.mps.ypath.structure.GenericFeatureGetterFun" id="1196691896259">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196691896260">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196762323356">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1196762323357" />
          </node>
        </node>
      </node>
      <node role="cardinal" type="jetbrains.mps.ypath.structure.GenericFeatureCardinalFun" id="1196691896261">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196691896262">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196691994951">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1196691994952">
              <property name="value" value="false" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameterQueryFunction" type="jetbrains.mps.ypath.structure.ParameterQueryFun" id="1196691896264">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196691896265">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196691913854">
            <node role="expression" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression" id="1196691913855">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196691913856">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196762437728">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1196762443434">
                    <link role="link" targetNodeId="1.1196683118212" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.ypath.structure.NodeTypeFunctionParam" id="1196762452278" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1196691913859">
                  <link role="conceptMethodDeclaration" targetNodeId="2.1182844609628" resolveInfo="getChildDeclarations" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation" id="1196691913860" />
            </node>
          </node>
        </node>
      </node>
      <node role="targetTypeFunction" type="jetbrains.mps.ypath.structure.TargetTypeFun" id="1196691896266">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196691896267">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196691919541">
            <node role="expression" type="jetbrains.mps.quotation.structure.Quotation" id="1196691919542">
              <node role="quotedNode" type="jetbrains.mpslite.structure.NodeType" id="1196691919543">
                <node role="referenceAntiquotation$link_attribute$concept" type="jetbrains.mps.quotation.structure.ReferenceAntiquotation" id="1196691919544">
                  <node role="expression" type="jetbrains.mps.ypath.structure.ParamFunctionParam" id="1196691919545" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="toStringFunction" type="jetbrains.mps.ypath.structure.ToStringFun" id="1196691896268">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196691896269">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196691983240">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196691983241">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1196691983242">
                <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.ypath.structure.ParamFunctionParam" id="1196691983243" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameterType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1196691905899">
        <link role="concept" targetNodeId="1.1182511424766" resolveInfo="ChildDeclarationPart" />
      </node>
    </node>
    <node role="features" type="jetbrains.mps.ypath.structure.GenericParamFeature" id="1196696793183">
      <property name="name" value="property" />
      <node role="getter" type="jetbrains.mps.ypath.structure.GenericFeatureGetterFun" id="1196696793184">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196696793185">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196696885610">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1196696885611" />
          </node>
        </node>
      </node>
      <node role="cardinal" type="jetbrains.mps.ypath.structure.GenericFeatureCardinalFun" id="1196696793186">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196696793187">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196696858245">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1196696858246">
              <property name="value" value="true" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameterType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1196696797742">
        <link role="concept" targetNodeId="1.1182511940438" resolveInfo="PropertyDeclarationPart" />
      </node>
      <node role="parameterQueryFunction" type="jetbrains.mps.ypath.structure.ParameterQueryFun" id="1196696793189">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196696793190">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196696813791">
            <node role="expression" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression" id="1196696813792">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196696813793">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196763103817">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1196763107445">
                    <link role="link" targetNodeId="1.1196683118212" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.ypath.structure.NodeTypeFunctionParam" id="1196696813795" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1196696813796">
                  <link role="conceptMethodDeclaration" targetNodeId="2.1182844484263" resolveInfo="getPropertyDeclarations" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation" id="1196696813797" />
            </node>
          </node>
        </node>
      </node>
      <node role="targetTypeFunction" type="jetbrains.mps.ypath.structure.TargetTypeFun" id="1196696793191">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196696793192">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196696829064">
            <node role="expression" type="jetbrains.mps.quotation.structure.Quotation" id="1196696829065">
              <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1196696846409">
                <link role="classifier" targetNodeId="4.~String" resolveInfo="String" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="toStringFunction" type="jetbrains.mps.ypath.structure.ToStringFun" id="1196696793193">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196696793194">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196696851176">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196696851538">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1196696852416">
                <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.ypath.structure.ParamFunctionParam" id="1196696851177" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="features" type="jetbrains.mps.ypath.structure.GenericParamFeature" id="1196763170990">
      <property name="name" value="reference" />
      <node role="getter" type="jetbrains.mps.ypath.structure.GenericFeatureGetterFun" id="1196763170991">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196763170992">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196763264061">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1196763264062" />
          </node>
        </node>
      </node>
      <node role="cardinal" type="jetbrains.mps.ypath.structure.GenericFeatureCardinalFun" id="1196763170993">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196763170994">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196763260465">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1196763260466">
              <property name="value" value="true" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameterType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1196763175752">
        <link role="concept" targetNodeId="1.1182845659293" resolveInfo="ReferenceDeclarationPart" />
      </node>
      <node role="parameterQueryFunction" type="jetbrains.mps.ypath.structure.ParameterQueryFun" id="1196763170996">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196763170997">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196763181674">
            <node role="expression" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression" id="1196763195418">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196763186430">
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ConceptMethodCall" id="1196763189870">
                  <link role="conceptMethodDeclaration" targetNodeId="2.1182846367232" resolveInfo="getReferenceDeclarations" />
                </node>
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196763182801">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1196763185007">
                    <link role="link" targetNodeId="1.1196683118212" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.ypath.structure.NodeTypeFunctionParam" id="1196763181675" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ToListOperation" id="1196763197169" />
            </node>
          </node>
        </node>
      </node>
      <node role="targetTypeFunction" type="jetbrains.mps.ypath.structure.TargetTypeFun" id="1196763170998">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196763170999">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196763205841">
            <node role="expression" type="jetbrains.mps.quotation.structure.Quotation" id="1196763205842">
              <node role="quotedNode" type="jetbrains.mpslite.structure.NodeType" id="1196763208141">
                <node role="referenceAntiquotation$link_attribute$concept" type="jetbrains.mps.quotation.structure.ReferenceAntiquotation" id="1196763211408">
                  <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196763218551">
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1196763252068">
                      <link role="link" targetNodeId="1.1182845809628" />
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.ypath.structure.ParamFunctionParam" id="1196763217706" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="toStringFunction" type="jetbrains.mps.ypath.structure.ToStringFun" id="1196763171000">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1196763171001">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1196763256131">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1196763256727">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess" id="1196763257808">
                <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.ypath.structure.ParamFunctionParam" id="1196763256132" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="treePathType" type="jetbrains.mps.ypath.structure.TreePathType" id="1196682965760">
      <node role="nodeType" type="jetbrains.mpslite.structure.NodeType" id="1196683324389" />
    </node>
  </node>
</model>

