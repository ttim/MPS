<?xml version="1.0" encoding="UTF-8"?>
<model name="webr.xml.actions">
  <language namespace="jetbrains.mps.bootstrap.actionsLanguage" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage" />
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang" />
  <language namespace="jetbrains.mps.bootstrap.sharedConcepts" />
  <maxImportIndex value="10" />
  <import index="1" modelUID="webr.xml.structure" />
  <import index="4" modelUID="webr.xmlSchema.structure" />
  <import index="5" modelUID="java.lang@java_stub" />
  <import index="6" modelUID="webr.xmlInternal.structure" />
  <import index="7" modelUID="webr.xml.actions@java_stub" />
  <import index="8" modelUID="jetbrains.mps.smodel@java_stub" />
  <import index="9" modelUID="java.util@java_stub" />
  <import index="10" modelUID="webr.xmlSchema.constraints" />
  <node type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActions" id="1167519968820">
    <property name="name" value="xml_nodeSubstitute" />
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1167699332639">
      <property name="useNewActions" value="true" />
      <link role="applicableConcept" targetNodeId="1.1165235274815" />
      <node role="part" type="jetbrains.mps.bootstrap.actionsLanguage.AddMenuPart" id="1177613609141">
        <link role="concept" targetNodeId="1.1167700349452" />
        <node role="part" type="jetbrains.mps.bootstrap.actionsLanguage.ParameterizedSubstituteMenuPart" id="1177613613454">
          <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177613682054">
            <link role="concept" targetNodeId="4.1167697887602" />
          </node>
          <node role="query" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_ParameterizedSubstitute_Query" id="1177613613456">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177613613457">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177614675901">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177614675902">
                  <property name="name" value="elementDeclaration" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177614675903">
                    <link role="concept" targetNodeId="4.1167838236835" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1177614663540">
                    <link role="baseMethodDeclaration" targetNodeId="1177614168858" resolveInfo="getParentElement" />
                    <link role="classConcept" targetNodeId="1177614157967" resolveInfo="ElementUtil" />
                    <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parentNode" id="1177614665494" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614939992">
                <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1177614941510">
                  <link role="baseMethodDeclaration" targetNodeId="1177614897656" resolveInfo="getAttributeDeclarations" />
                  <link role="classConcept" targetNodeId="1177614889905" resolveInfo="AttributeUtil" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614944136">
                    <link role="variableDeclaration" targetNodeId="1177614675902" resolveInfo="elementDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="handler" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_ParameterizedSubstitute_Handler" id="1177613613458">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177613613459">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177613784332">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177613784333">
                  <property name="name" value="attribute" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177613784334">
                    <link role="concept" targetNodeId="1.1167700349452" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177613773799">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.sharedConcepts.ConceptFunctionParameter_model" id="1177613771079" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Model_CreateNewNodeOperation" id="1177613775488">
                      <link role="concept" targetNodeId="1.1167700349452" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177613827263">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177613833955">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177613829656">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177613827264">
                      <link role="variableDeclaration" targetNodeId="1177613784333" resolveInfo="attribute" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177613831626">
                      <link role="link" targetNodeId="1.1167701332877" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1177613836112">
                    <node role="parameter" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parameterObject" id="1177613838583" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177613845445">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177613855730">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177613847416">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177613845446">
                      <link role="variableDeclaration" targetNodeId="1177613784333" resolveInfo="attribute" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177613851354">
                      <link role="link" targetNodeId="1.1167703268127" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetNewChildOperation" id="1177613858372">
                    <link role="concept" targetNodeId="1.1161373262136" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177613801744">
                <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177613801745">
                  <link role="variableDeclaration" targetNodeId="1177613784333" resolveInfo="attribute" />
                </node>
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_ParameterizedSubstitute_String" id="1177613734274">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177613734275">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177613741682">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177613747950">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parameterObject" id="1177613741683" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess" id="1177613748998">
                    <link role="property" targetNodeId="4.1167698115100" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1167757687265">
      <property name="actionsFactoryAspectId" value="Content" />
      <property name="useNewActions" value="false" />
      <link role="applicableConcept" targetNodeId="1.1161371727643" />
      <node role="variable" type="jetbrains.mps.bootstrap.actionsLanguage.SubstituteNodeBuilderVariableDeclaration" id="1181874645399">
        <property name="name" value="parentElement" />
        <node role="initializerBlock" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_SubstituteVariableInitializer" id="1181874645400">
          <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1181874645401">
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1181874687619">
              <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1181874689119">
                <link role="classConcept" targetNodeId="1177614157967" resolveInfo="ElementUtil" />
                <link role="baseMethodDeclaration" targetNodeId="1177614168858" resolveInfo="getParentElement" />
                <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parentNode" id="1181874689120" />
              </node>
            </node>
          </node>
        </node>
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1181874663163">
          <link role="concept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="variable" type="jetbrains.mps.bootstrap.actionsLanguage.SubstituteNodeBuilderVariableDeclaration" id="1183566520742">
        <property name="name" value="isMixed" />
        <node role="initializerBlock" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_SubstituteVariableInitializer" id="1183566520743">
          <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183566520744">
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183566605347">
              <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1183566889650">
                <link role="baseMethodDeclaration" extResolveInfo="7.static method ([Classifier]MixedUtil).([StaticMethodDeclaration]isMixed((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.boolean/jetbrains.mps.baseLanguage.types.boolean))" />
                <link role="classConcept" extResolveInfo="7.[Classifier]MixedUtil" />
                <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.SubstituteNodeBuilderVariableReference" id="1183566889651">
                  <link role="variableDeclaration" targetNodeId="1181874645399" resolveInfo="parentElement" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="type" type="jetbrains.mps.baseLanguage.BooleanType" id="1183566552945" />
      </node>
      <node role="part" type="jetbrains.mps.bootstrap.actionsLanguage.RemoveByConditionPart" id="1177863610304">
        <node role="condition" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_RemoveBy_Condition" id="1177863610305">
          <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177863610306">
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177864663629">
              <node role="expression" type="jetbrains.mps.baseLanguage.AndExpression" id="1177864670093">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177864665449">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_childConcept" id="1177864665450" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Concept_IsExactlyOperation" id="1177864665451">
                    <link role="conceptDeclaration" targetNodeId="1.1161371727643" />
                  </node>
                </node>
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.AndExpression" id="1183568013511">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.NotExpression" id="1183568056952">
                    <node role="expression" type="jetbrains.mps.bootstrap.actionsLanguage.SubstituteNodeBuilderVariableReference" id="1183568056953">
                      <link role="variableDeclaration" targetNodeId="1183566520742" resolveInfo="isMixed" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177864675174">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptRefExpression" id="1177864675175">
                      <link role="conceptDeclaration" targetNodeId="1.1163340203555" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Concept_IsAssignableFromOperation" id="1177864675176">
                      <node role="sconceptExpression" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_concept" id="1177864675177" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="part" type="jetbrains.mps.bootstrap.actionsLanguage.AddMenuPart" id="1177864774724">
        <link role="concept" targetNodeId="1.1167523027466" />
        <node role="part" type="jetbrains.mps.bootstrap.actionsLanguage.ParameterizedSubstituteMenuPart" id="1177864777991">
          <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177865246397">
            <link role="concept" targetNodeId="4.1167838236835" />
          </node>
          <node role="query" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_ParameterizedSubstitute_Query" id="1177864777993">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177864777994">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177867934948">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177867934949">
                  <property name="name" value="schema" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177867934950">
                    <link role="concept" targetNodeId="4.1167513239198" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1177867925708">
                    <link role="baseMethodDeclaration" targetNodeId="1177865741913" resolveInfo="findSchema" />
                    <link role="classConcept" targetNodeId="1177614157967" resolveInfo="ElementUtil" />
                    <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parentNode" id="1177867928633" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177868576826">
                <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1177868578534">
                  <link role="baseMethodDeclaration" targetNodeId="1177868509565" resolveInfo="getElementDeclarations" />
                  <link role="classConcept" targetNodeId="1177614157967" resolveInfo="ElementUtil" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177868580349">
                    <link role="variableDeclaration" targetNodeId="1177867934949" resolveInfo="schema" />
                  </node>
                  <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.SubstituteNodeBuilderVariableReference" id="1181874704885">
                    <link role="variableDeclaration" targetNodeId="1181874645399" resolveInfo="parentElement" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="handler" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_ParameterizedSubstitute_Handler" id="1177864777995">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177864777996">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177865452798">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177865452799">
                  <property name="name" value="element" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177865452800">
                    <link role="concept" targetNodeId="1.1167523027466" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177865444743">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.sharedConcepts.ConceptFunctionParameter_model" id="1177865442381" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Model_CreateNewNodeOperation" id="1177865446231">
                      <link role="concept" targetNodeId="1.1167523027466" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177865469925">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177865476341">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177865472210">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177865469926">
                      <link role="variableDeclaration" targetNodeId="1177865452799" resolveInfo="element" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177865474603">
                      <link role="link" targetNodeId="1.1167523262932" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1177865477609">
                    <node role="parameter" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parameterObject" id="1177865480395" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177865454745">
                <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177865454746">
                  <link role="variableDeclaration" targetNodeId="1177865452799" resolveInfo="element" />
                </node>
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_ParameterizedSubstitute_String" id="1177865292908">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177865292909">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177865297895">
                <node role="expression" type="jetbrains.mps.baseLanguage.PlusExpression" id="1177865300334">
                  <node role="rightExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177865311326">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parameterObject" id="1177865304635" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess" id="1177865312173">
                      <link role="property" targetNodeId="4.1167838788027" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.StringLiteral" id="1177865297896">
                    <property name="value" value="&lt;" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.ClassConcept" id="1177614157967">
    <property name="name" value="ElementUtil" />
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1177614168858">
      <property name="name" value="getParentElement" />
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177614172064">
        <link role="concept" targetNodeId="4.1167838236835" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177614168860">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177614216633">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177614216634">
            <property name="name" value="elementDeclaration" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177614216635">
              <link role="concept" targetNodeId="4.1167838236835" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NullLiteral" id="1177614605283" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.WhileStatement" id="1177614249958">
          <node role="condition" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1177614251336">
            <property name="value" value="true" />
          </node>
          <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177614249960">
            <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177614268931">
              <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614272984">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614270169">
                  <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNullOperation" id="1177614274329" />
              </node>
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177614268933">
                <node role="statement" type="jetbrains.mps.baseLanguage.BreakStatement" id="1177614276517" />
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177614284894">
              <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614288666">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614286132">
                  <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1177614290323">
                  <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1177614293513">
                    <link role="conceptDeclaration" targetNodeId="1.1167523027466" />
                  </node>
                </node>
              </node>
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177614284896">
                <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614321915">
                  <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177614323074">
                    <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614326453">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1177614326454">
                        <link role="concept" targetNodeId="1.1167523027466" />
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614326455">
                          <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                        </node>
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177614326456">
                        <link role="link" targetNodeId="1.1167523262932" />
                      </node>
                    </node>
                    <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614321916">
                      <link role="variableDeclaration" targetNodeId="1177614216634" resolveInfo="elementDeclaration" />
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.BreakStatement" id="1177614329833" />
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177614393121">
              <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614396424">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614394311">
                  <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1177614398112">
                  <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1177614401083">
                    <link role="conceptDeclaration" targetNodeId="1.1161371727643" />
                  </node>
                </node>
              </node>
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177614393123">
                <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177614502324">
                  <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177614502325">
                    <property name="name" value="content" />
                    <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177614502326">
                      <link role="concept" targetNodeId="1.1161371727643" />
                    </node>
                    <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1177614462137">
                      <link role="concept" targetNodeId="1.1161371727643" />
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614462138">
                        <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614457598">
                  <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177614458616">
                    <node role="rValue" type="jetbrains.mps.baseLanguage.ext.collections.lang.SequenceOperationExpression" id="1177614462135">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614462136">
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614502327">
                          <link role="variableDeclaration" targetNodeId="1177614502325" resolveInfo="content" />
                        </node>
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SConceptLinkAccess" id="1177614462139">
                          <link role="conceptLinkDeclaration" targetNodeId="1.1175781935927" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.GetFirstOperation" id="1177614462140" />
                    </node>
                    <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614457599">
                      <link role="variableDeclaration" targetNodeId="1177614216634" resolveInfo="elementDeclaration" />
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177614476095">
                  <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614480836">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614477098">
                      <link role="variableDeclaration" targetNodeId="1177614216634" resolveInfo="elementDeclaration" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNotNullOperation" id="1177614482149" />
                  </node>
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177614476097">
                    <node role="statement" type="jetbrains.mps.baseLanguage.BreakStatement" id="1177614484275" />
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614525949">
                  <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177614527045">
                    <node role="rValue" type="jetbrains.mps.baseLanguage.ext.collections.lang.SequenceOperationExpression" id="1177614530190">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614530191">
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614530192">
                          <link role="variableDeclaration" targetNodeId="1177614502325" resolveInfo="content" />
                        </node>
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SConceptLinkAccess" id="1177614530193">
                          <link role="conceptLinkDeclaration" targetNodeId="1.1175095327345" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.GetFirstOperation" id="1177614530194" />
                    </node>
                    <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614525950">
                      <link role="variableDeclaration" targetNodeId="1177614216634" resolveInfo="elementDeclaration" />
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177614545118">
                  <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614548030">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614546152">
                      <link role="variableDeclaration" targetNodeId="1177614216634" resolveInfo="elementDeclaration" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNotNullOperation" id="1177614549562" />
                  </node>
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177614545120">
                    <node role="statement" type="jetbrains.mps.baseLanguage.BreakStatement" id="1177614551251" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614570363">
              <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177614571396">
                <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177614574838">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614572556">
                    <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1177614575729" />
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177614570364">
                  <link role="variableDeclaration" targetNodeId="1177614202129" resolveInfo="node" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614222372">
          <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614222373">
            <link role="variableDeclaration" targetNodeId="1177614216634" resolveInfo="elementDeclaration" />
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1177614202129">
        <property name="name" value="node" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177614202130" />
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1178546172395" />
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1177865741913">
      <property name="name" value="findSchema" />
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177865746041">
        <link role="concept" targetNodeId="4.1167513239198" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177865741915">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177866565235">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177866565236">
            <property name="name" value="schema" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177866565237">
              <link role="concept" targetNodeId="4.1167513239198" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NullLiteral" id="1177867495851" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177866621782">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177866621783">
            <property name="name" value="element" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177866621784">
              <link role="concept" targetNodeId="1.1167523027466" />
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177866600199">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177866598089">
                <link role="variableDeclaration" targetNodeId="1177865752637" resolveInfo="node" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1177866602450">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1177866609388">
                  <link role="concept" targetNodeId="1.1167523027466" />
                </node>
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1177866616969" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177866657536">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177866660776">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177866658961">
              <link role="variableDeclaration" targetNodeId="1177866621783" resolveInfo="element" />
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNullOperation" id="1177866662277" />
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177866657538">
            <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177867418498">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177867418499">
                <property name="name" value="containingRoot" />
                <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177867418500" />
                <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177866715531">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177866713390">
                    <link role="variableDeclaration" targetNodeId="1177865752637" resolveInfo="node" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetContainingRootOperation" id="1177866718111" />
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177867586267">
              <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177867592505">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177867588442">
                  <link role="variableDeclaration" targetNodeId="1177867418499" resolveInfo="containingRoot" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1177867593818">
                  <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1177867625711">
                    <link role="conceptDeclaration" targetNodeId="6.1166472279594" />
                  </node>
                </node>
              </node>
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177867586269">
                <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177867642994">
                  <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177867643809">
                    <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177867658474">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1177867652393">
                        <link role="concept" targetNodeId="6.1166472279594" />
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177867651702">
                          <link role="variableDeclaration" targetNodeId="1177867418499" resolveInfo="containingRoot" />
                        </node>
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177867660475">
                        <link role="link" targetNodeId="6.1167755779835" />
                      </node>
                    </node>
                    <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177867642995">
                      <link role="variableDeclaration" targetNodeId="1177866565236" resolveInfo="schema" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.BlockStatement" id="1177867669727">
            <node role="statements" type="jetbrains.mps.baseLanguage.StatementList" id="1177867669728">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177867679871">
                <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177867680576">
                  <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177867695976">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177867686972">
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177867685141">
                        <link role="variableDeclaration" targetNodeId="1177866621783" resolveInfo="element" />
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177867690380">
                        <link role="link" targetNodeId="1.1167523262932" />
                      </node>
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1177867698618">
                      <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1177867704949">
                        <link role="concept" targetNodeId="4.1167513239198" />
                      </node>
                    </node>
                  </node>
                  <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177867679872">
                    <link role="variableDeclaration" targetNodeId="1177866565236" resolveInfo="schema" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177866571318">
          <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177866571319">
            <link role="variableDeclaration" targetNodeId="1177866565236" resolveInfo="schema" />
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1177865752637">
        <property name="name" value="node" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177865752638" />
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1178546172569" />
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1177868509565">
      <property name="name" value="getElementDeclarations" />
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1177868511709">
        <link role="elementConcept" targetNodeId="4.1167838236835" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177868509567">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1183582188852">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1183582188853">
            <property name="name" value="elementDeclarations" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183582188854">
              <link role="elementConcept" targetNodeId="4.1167838236835" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.GenericNewExpression" id="1177868726078">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListCreator" id="1177868727158">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1177868727159">
                  <link role="elementConcept" targetNodeId="4.1167838236835" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1183582240793">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1183582240794">
            <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1183582282262">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1183582282263">
                <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183582482711">
                  <node role="expression" type="jetbrains.mps.baseLanguage.ext.collections.lang.SequenceOperationExpression" id="1183582483388">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183582482712">
                      <link role="variableDeclaration" targetNodeId="1183582188853" resolveInfo="elementDeclarations" />
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.AddElementOperation" id="1183582485111">
                      <node role="argument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582497584">
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1183582501371">
                          <link role="link" targetNodeId="4.1167531079758" />
                        </node>
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582492931">
                          <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1183582496906">
                            <link role="link" targetNodeId="4.1167537980718" />
                          </node>
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582492225">
                            <link role="variableDeclaration" targetNodeId="1177868530070" resolveInfo="schema" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.AndExpression" id="1183582288176">
                <node role="rightExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582298750">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess" id="1183582310181">
                    <link role="property" targetNodeId="4.1168022873076" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582298213">
                    <link role="variableDeclaration" targetNodeId="1177868530070" resolveInfo="schema" />
                  </node>
                </node>
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582284978">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNotNullOperation" id="1183582286216" />
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582284407">
                    <link role="variableDeclaration" targetNodeId="1177868530070" resolveInfo="schema" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582243468">
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNullOperation" id="1183582244990" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582242834">
              <link role="variableDeclaration" targetNodeId="1177868534760" resolveInfo="elementDeclaration" />
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.BlockStatement" id="1183582537603">
            <node role="statements" type="jetbrains.mps.baseLanguage.StatementList" id="1183582537604" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183582222062">
          <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183582222063">
            <link role="variableDeclaration" targetNodeId="1183582188853" resolveInfo="elementDeclarations" />
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1177868530070">
        <property name="name" value="schema" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177868530071">
          <link role="concept" targetNodeId="4.1167513239198" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1177868534760">
        <property name="name" value="elementDeclaration" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177868538481">
          <link role="concept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1178546172699" />
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1183582816811">
      <property name="name" value="checkElement" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1183582816812" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1183582816813" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183582816814">
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1183582867267">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582870951">
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1183582873195">
              <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1183582879731">
                <link role="conceptDeclaration" targetNodeId="4.1167512696010" />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582870151">
              <link role="variableDeclaration" targetNodeId="1183582836952" resolveInfo="elementDeclaration" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1183582867269">
            <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1183582899932">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1183582899933">
                <property name="name" value="elementWithContent" />
                <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183582899934">
                  <link role="concept" targetNodeId="4.1167512696010" />
                </node>
                <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1183582894019">
                  <link role="concept" targetNodeId="4.1167512696010" />
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582893377">
                    <link role="variableDeclaration" targetNodeId="1183582836952" resolveInfo="elementDeclaration" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183582974814">
              <node role="expression" type="jetbrains.mps.baseLanguage.LocalStaticMethodCall" id="1183582974815">
                <link role="baseMethodDeclaration" targetNodeId="1183582927939" resolveInfo="checkComplexType" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183582977694">
                  <link role="variableDeclaration" targetNodeId="1183582824601" resolveInfo="elementDeclarations" />
                </node>
                <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183582985380">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1183582987024">
                    <link role="link" targetNodeId="4.1167842409344" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183582980574">
                    <link role="variableDeclaration" targetNodeId="1183582899933" resolveInfo="elementWithContent" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.IfStatement" id="1183583022669">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1183583022670">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1183583046319">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1183583046320">
                  <property name="name" value="elementWithType" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183583046321">
                    <link role="concept" targetNodeId="4.1167838362804" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1183583040915">
                    <link role="concept" targetNodeId="4.1167838362804" />
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583038899">
                      <link role="variableDeclaration" targetNodeId="1183582836952" resolveInfo="elementDeclaration" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183583079463">
                <node role="expression" type="jetbrains.mps.baseLanguage.LocalStaticMethodCall" id="1183583079464">
                  <link role="baseMethodDeclaration" targetNodeId="1183583062838" resolveInfo="checkComplexTypeReference" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583110887">
                    <link role="variableDeclaration" targetNodeId="1183582824601" resolveInfo="elementDeclarations" />
                  </node>
                  <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183583114226">
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1183583115901">
                      <link role="link" targetNodeId="4.1167839503230" />
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183583113548">
                      <link role="variableDeclaration" targetNodeId="1183583046320" resolveInfo="elementWithType" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183583028870">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1183583030451">
                <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1183583034565">
                  <link role="conceptDeclaration" targetNodeId="4.1167838362804" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583028254">
                <link role="variableDeclaration" targetNodeId="1183582836952" resolveInfo="elementDeclaration" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183582824601">
        <property name="name" value="elementDeclarations" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183582824602">
          <link role="elementConcept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183582836952">
        <property name="name" value="elementDeclaration" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183582839742">
          <link role="concept" targetNodeId="4.1167838236835" />
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1183582927939">
      <property name="name" value="checkComplexType" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183582939377">
        <property name="name" value="elementDeclarations" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183582939378">
          <link role="elementConcept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183582941848">
        <property name="name" value="complexType" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183582948700">
          <link role="concept" targetNodeId="4.1167615791597" />
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1183582927940" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1183582927941" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183582927942">
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1183583165908">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183583169013">
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsNotNullOperation" id="1183583171035" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583168195">
              <link role="variableDeclaration" targetNodeId="1183582941848" resolveInfo="complexType" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1183583165910">
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183583233582">
              <node role="expression" type="jetbrains.mps.baseLanguage.LocalStaticMethodCall" id="1183583233583">
                <link role="baseMethodDeclaration" targetNodeId="1183583194114" resolveInfo="checkTypeExpressionList" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583235793">
                  <link role="variableDeclaration" targetNodeId="1183582939377" resolveInfo="elementDeclarations" />
                </node>
                <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183583239598">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1183583242429">
                    <link role="link" targetNodeId="4.1167841515196" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583238983">
                    <link role="variableDeclaration" targetNodeId="1183582941848" resolveInfo="complexType" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1183583062838">
      <property name="name" value="checkComplexTypeReference" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183583085304">
        <property name="name" value="elementDeclarations" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183583085305">
          <link role="elementConcept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183583087309">
        <property name="name" value="complexTypeReference" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183583096267">
          <link role="concept" targetNodeId="4.1167790566663" />
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1183583062839" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1183583062840" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183583062841">
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183583260653">
          <node role="expression" type="jetbrains.mps.baseLanguage.LocalStaticMethodCall" id="1183583260654">
            <link role="baseMethodDeclaration" targetNodeId="1183582927939" resolveInfo="checkComplexType" />
            <node role="actualArgument" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583261926">
              <link role="variableDeclaration" targetNodeId="1183583085304" resolveInfo="elementDeclarations" />
            </node>
            <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183583264943">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1183583267731">
                <link role="link" targetNodeId="4.1167790582664" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583264047">
                <link role="variableDeclaration" targetNodeId="1183583087309" resolveInfo="complexTypeReference" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1183583194114">
      <property name="name" value="checkTypeExpressionList" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183583205664">
        <property name="name" value="elementDeclarations" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183583205665">
          <link role="elementConcept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183583216141">
        <property name="name" value="typeExpressionList" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183583217883">
          <link role="concept" targetNodeId="4.1167795596947" />
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1183583194115" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1183583194116" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183583194117">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1183583295438">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1183583295439">
            <property name="name" value="typeExpressions" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183583295440">
              <link role="elementConcept" targetNodeId="4.1167590960646" />
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183583285947">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccessAsList" id="1183583288812">
                <link role="link" targetNodeId="4.1167795626698" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583285146">
                <link role="variableDeclaration" targetNodeId="1183583216141" resolveInfo="typeExpressionList" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachStatement" id="1183583297833">
          <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachVariable" id="1183583297834">
            <property name="name" value="typeExpression" />
          </node>
          <node role="inputSequence" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183583301274">
            <link role="variableDeclaration" targetNodeId="1183583295439" resolveInfo="typeExpressions" />
          </node>
          <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183583297836">
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183583362637">
              <node role="expression" type="jetbrains.mps.baseLanguage.LocalStaticMethodCall" id="1183583362638">
                <link role="baseMethodDeclaration" targetNodeId="1183583317797" resolveInfo="checkTypeExpression" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.ParameterReference" id="1183583365535">
                  <link role="variableDeclaration" targetNodeId="1183583205664" resolveInfo="elementDeclarations" />
                </node>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachVariableReference" id="1183583369265">
                  <link role="variable" targetNodeId="1183583297834" resolveInfo="typeExpression" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1183583317797">
      <property name="name" value="checkTypeExpression" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183583342803">
        <property name="name" value="elementDeclarations" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1183583342804">
          <link role="elementConcept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1183583343227">
        <property name="name" value="typeExpression" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1183583350923">
          <link role="concept" targetNodeId="4.1167590960646" />
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1183583317798" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1183583317799" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1183583317800" />
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1178550127299" />
  </node>
  <node type="jetbrains.mps.baseLanguage.ClassConcept" id="1177614889905">
    <property name="name" value="AttributeUtil" />
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1177614897656">
      <property name="name" value="getAttributeDeclarations" />
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1177614902847">
        <link role="elementConcept" targetNodeId="4.1167697887602" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177614897658">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177614968623">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177614968624">
            <property name="name" value="attributeDeclarations" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1177614968625">
              <link role="elementConcept" targetNodeId="4.1167697887602" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.GenericNewExpression" id="1177614978862">
              <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListCreator" id="1177614979692">
                <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1177614979693">
                  <link role="elementConcept" targetNodeId="4.1167697887602" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177637943096">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177637943097">
            <property name="name" value="complexType" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177637943098">
              <link role="concept" targetNodeId="4.1167615791597" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177637954350">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177637960887">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177637957728">
              <link role="variableDeclaration" targetNodeId="1177614922771" resolveInfo="elementDeclaration" />
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1177637962482">
              <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1177637966796">
                <link role="conceptDeclaration" targetNodeId="4.1167512696010" />
              </node>
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177637954352">
            <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177637973845">
              <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177637974769">
                <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177637987637">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1177637979994">
                    <link role="concept" targetNodeId="4.1167512696010" />
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177637979287">
                      <link role="variableDeclaration" targetNodeId="1177614922771" resolveInfo="elementDeclaration" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177637989201">
                    <link role="link" targetNodeId="4.1167842409344" />
                  </node>
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177637973846">
                  <link role="variableDeclaration" targetNodeId="1177637943097" resolveInfo="complexType" />
                </node>
              </node>
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.IfStatement" id="1177637993031">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177637998240">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177637996206">
                <link role="variableDeclaration" targetNodeId="1177614922771" resolveInfo="elementDeclaration" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1177637999600">
                <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1177638003884">
                  <link role="conceptDeclaration" targetNodeId="4.1167838362804" />
                </node>
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1177637993033">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177638010511">
                <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1177638011294">
                  <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177638029119">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177638022928">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1177638013284">
                        <link role="concept" targetNodeId="4.1167838362804" />
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1177638012641">
                          <link role="variableDeclaration" targetNodeId="1177614922771" resolveInfo="elementDeclaration" />
                        </node>
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177638024632">
                        <link role="link" targetNodeId="4.1167839503230" />
                      </node>
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177638030730">
                      <link role="link" targetNodeId="4.1167790582664" />
                    </node>
                  </node>
                  <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177638010512">
                    <link role="variableDeclaration" targetNodeId="1177637943097" resolveInfo="complexType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.BlockStatement" id="1177638038341">
              <node role="statements" type="jetbrains.mps.baseLanguage.StatementList" id="1177638038342">
                <node role="statement" type="jetbrains.mps.baseLanguage.ThrowStatement" id="1177638040046">
                  <node role="throwable" type="jetbrains.mps.baseLanguage.NewExpression" id="1177638041954">
                    <link role="baseMethodDeclaration" extResolveInfo="5.constructor [Classifier]UnsupportedOperationException[ConstructorDeclaration] ()" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177638144347">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177638144348">
            <property name="name" value="typeExpressionList" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177638144349">
              <link role="concept" targetNodeId="4.1167795596947" />
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177638131673">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177638129891">
                <link role="variableDeclaration" targetNodeId="1177637943097" resolveInfo="complexType" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1177638135799">
                <link role="link" targetNodeId="4.1167841515196" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1183586757333">
          <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1183586758169">
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_ConceptMethodCall" id="1183586759769">
              <link role="conceptMethodDeclaration" targetNodeId="10.1183585335179" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183586762416">
                <link role="variableDeclaration" targetNodeId="1177614968624" resolveInfo="attributeDeclarations" />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1183586757334">
              <link role="variableDeclaration" targetNodeId="1177638144348" resolveInfo="typeExpressionList" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177614985591">
          <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177614985592">
            <link role="variableDeclaration" targetNodeId="1177614968624" resolveInfo="attributeDeclarations" />
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1177614922771">
        <property name="name" value="elementDeclaration" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177614922772">
          <link role="concept" targetNodeId="4.1167838236835" />
        </node>
      </node>
      <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1178546172377" />
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.PublicVisibility" id="1178550126484" />
  </node>
  <node type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactories" id="1178622211354">
    <property name="name" value="xml_nodeFactory" />
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1178622222480">
      <property name="description" value="Wrap with complex text" />
      <link role="applicableConcept" targetNodeId="1.1161911457732" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1178622222481">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1178622222482">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1178622251812">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1178622255443">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1178622254174" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1178622257788">
                <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1178622263915">
                  <link role="conceptDeclaration" targetNodeId="1.1163340203555" />
                </node>
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1178622251814">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1178622269620">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1178622276751">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1178622270950">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1178622269621" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1178622274998">
                      <link role="link" targetNodeId="1.1161911474092" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.LinkList_AddChildOperation" id="1178622278441">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1178622283700">
                      <link role="concept" targetNodeId="1.1163340203555" />
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1178622280524" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1178622500722">
      <property name="description" value="Wrap with content list" />
      <link role="applicableConcept" targetNodeId="1.1163629230879" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1178622500723">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1178622500724">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1178622538480">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1178622549459">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1178622545016" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1178622554056">
                <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.RefConcept_Reference" id="1178622560700">
                  <link role="conceptDeclaration" targetNodeId="1.1161371727643" />
                </node>
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1178622538482">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1178622607892">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1178622615358">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1178622609474">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1178622607893" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1178622613228">
                      <link role="link" targetNodeId="1.1163629255661" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.LinkList_AddChildOperation" id="1178622616847">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1178622620266">
                      <link role="concept" targetNodeId="1.1161371727643" />
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1178622619150" />
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
</model>

