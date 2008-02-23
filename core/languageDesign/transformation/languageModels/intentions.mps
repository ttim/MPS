<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.transformation.TLBase.intentions">
  <persistence version="1"/>
  <refactoringHistory/>
  <language namespace="jetbrains.mps.baseLanguage"/>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.intentionsLanguage"/>
  <language namespace="jetbrains.mps.bootstrap.editorLanguage"/>
  <language namespace="jetbrains.mps.bootstrap.sharedConcepts"/>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="0"/>
  </language>
  <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="1"/>
  <maxImportIndex value="14"/>
  <import index="1" modelUID="jetbrains.mps.transformation.TLBase.structure" version="0"/>
  <import index="2" modelUID="jetbrains.mps.core.structure" version="-1"/>
  <import index="3" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" version="-1"/>
  <import index="4" modelUID="jetbrains.mps.transformation@java_stub" version="-1"/>
  <import index="5" modelUID="jetbrains.mps.nodeEditor@java_stub" version="-1"/>
  <import index="6" modelUID="jetbrains.mps.smodel@java_stub" version="-1"/>
  <import index="7" modelUID="java.util@java_stub" version="-1"/>
  <import index="8" modelUID="jetbrains.mps.baseLanguage.structure" version="0"/>
  <import index="9" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure@java_stub" version="-1"/>
  <import index="10" modelUID="jetbrains.mps.plugin@java_stub" version="-1"/>
  <import index="11" modelUID="jetbrains.mps.generator.template@java_stub" version="-1"/>
  <import index="12" modelUID="java.lang@java_stub" version="-1"/>
  <import index="13" modelUID="java.io@java_stub" version="-1"/>
  <import index="14" modelUID="jetbrains.mps.transformation.TLBase.structure@java_stub" version="-1"/>
  <node type="jetbrains.mps.bootstrap.intentionsLanguage.structure.IntentionDeclaration" id="1195665973055">
    <property name="name" value="CreateTemplateDeclarationFromUsage"/>
    <property name="isErrorIntention" value="false"/>
    <link role="forConcept" targetNodeId="1.1168559098955" resolveInfo="RuleConsequence"/>
    <node role="descriptionFunction" type="jetbrains.mps.bootstrap.intentionsLanguage.structure.DescriptionBlock"
          id="1195665973125">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1195665973126">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1195665973127">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1195665973128">
            <property name="value" value="Create template declaration from usage"/>
          </node>
        </node>
      </node>
    </node>
    <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.intentionsLanguage.structure.IsApplicableBlock"
          id="1195665973144">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1195665973145">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1195665973146">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1195665973147">
            <link role="baseMethodDeclaration"
                  targetNodeId="5.~CreateFromUsageUtil.isApplicable(jetbrains.mps.nodeEditor.EditorContext):boolean"
                  resolveInfo="isApplicable"/>
            <link role="classConcept" targetNodeId="5.~CreateFromUsageUtil" resolveInfo="CreateFromUsageUtil"/>
            <node role="actualArgument"
                  type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_editorContext"
                  id="1195666126675"/>
          </node>
        </node>
      </node>
    </node>
    <node role="executeFunction" type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ExecuteBlock"
          id="1195665973181">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1195665973182">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1195665973183">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1195665973184">
            <property name="name" value="template"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1195665973185">
              <link role="concept" targetNodeId="1.1092059087312" resolveInfo="TemplateDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1195665973186">
              <node role="leftExpression"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1195665973187">
                <node role="leftExpression"
                      type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                      id="1195665973188"/>
                <node role="nodeOperation"
                      type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                      id="1195665973189"/>
              </node>
              <node role="nodeOperation"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_CreateNewRootNodeOperation"
                    id="1195665973190">
                <link role="concept" targetNodeId="1.1092059087312" resolveInfo="TemplateDeclaration"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1195665973191">
          <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                id="1195665973192">
            <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1195665973193">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1195665973194">
                <link role="variableDeclaration" targetNodeId="1195665973184" resolveInfo="template"/>
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                    id="1195665973195">
                <link role="property" targetNodeId="2.1169194664001" resolveInfo="name"/>
              </node>
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Property_SetOperation"
                  id="1195665973196">
              <node role="value" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1195665973197">
                <link role="baseMethodDeclaration"
                      targetNodeId="5.~CreateFromUsageUtil.getText(jetbrains.mps.nodeEditor.EditorContext):java.lang.String"
                      resolveInfo="getText"/>
                <link role="classConcept" targetNodeId="5.~CreateFromUsageUtil" resolveInfo="CreateFromUsageUtil"/>
                <node role="actualArgument"
                      type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_editorContext"
                      id="1195666101742"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1195665973199">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1195665973200">
            <property name="name" value="applicableConcept"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SConceptType" id="1195665973201"/>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1195665973202">
              <node role="leftExpression"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1195665973203">
                <node role="leftExpression"
                      type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                      id="1195665973204"/>
                <node role="nodeOperation"
                      type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation"
                      id="1195665973205">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept"
                        id="1195665973206">
                    <link role="concept" targetNodeId="1.1167327847730" resolveInfo="Reduction_MappingRule"/>
                  </node>
                </node>
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                    id="1195665973207">
                <link role="link" targetNodeId="1.1167169349424"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1195665973208">
          <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                id="1195665973209">
            <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1195665973210">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1195665973211">
                <link role="variableDeclaration" targetNodeId="1195665973184" resolveInfo="template"/>
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                    id="1195665973212">
                <link role="link" targetNodeId="1.1168285871518"/>
              </node>
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                  id="1195665973213">
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1195665973214">
                <link role="variableDeclaration" targetNodeId="1195665973200" resolveInfo="applicableConcept"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1195665973215">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1195665973216">
            <property name="name" value="reference"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1195665973217">
              <link role="concept" targetNodeId="1.1168559333462" resolveInfo="TemplateDeclarationReference"/>
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1195665973218">
              <node role="leftExpression"
                    type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                    id="1195665973219"/>
              <node role="nodeOperation"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ReplaceWithNewOperation"
                    id="1195665973220">
                <link role="concept" targetNodeId="1.1168559333462" resolveInfo="TemplateDeclarationReference"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1195665973221">
          <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                id="1195665973222">
            <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1195665973223">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1195665973224">
                <link role="variableDeclaration" targetNodeId="1195665973216" resolveInfo="reference"/>
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                    id="1195665973225">
                <link role="link" targetNodeId="1.1168559393589"/>
              </node>
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                  id="1195665973226">
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1195665973227">
                <link role="variableDeclaration" targetNodeId="1195665973184" resolveInfo="template"/>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.intentionsLanguage.structure.IntentionDeclaration" id="1203775431223">
    <property name="name" value="ConvertInlineTemplateToTemplateFragment"/>
    <link role="forConcept" targetNodeId="1.1177093525992" resolveInfo="InlineTemplate_RuleConsequence"/>
    <node role="descriptionFunction" type="jetbrains.mps.bootstrap.intentionsLanguage.structure.DescriptionBlock"
          id="1203775431224">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203775431225">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203775470228">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203775470229">
            <property name="value" value="Convert inline template to template fragment"/>
          </node>
        </node>
      </node>
    </node>
    <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.intentionsLanguage.structure.IsApplicableBlock"
          id="1203775431226">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203775431227">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1203776371855">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1203776371856">
            <property name="name" value="ruleNode"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1203776371857">
              <link role="concept" targetNodeId="1.1167169308231" resolveInfo="BaseMappingRule"/>
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1203776371858">
              <node role="nodeOperation"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation"
                    id="1203776371859">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept"
                      id="1203776371860">
                  <link role="concept" targetNodeId="1.1167169308231" resolveInfo="BaseMappingRule"/>
                </node>
              </node>
              <node role="leftExpression"
                    type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                    id="1203776371861"/>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1203776375910">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203776375911">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203776444320">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1203776447775">
                <property name="value" value="false"/>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1203776395279">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1203776412146">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1203776433827">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                      id="1203776434565">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                        id="1203776434566">
                    <link role="variableDeclaration" targetNodeId="1203776371856" resolveInfo="ruleNode"/>
                  </node>
                  <node role="operation"
                        type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                        id="1203776434567">
                    <node role="conceptArgument"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference"
                          id="1203776439663">
                      <link role="conceptDeclaration" targetNodeId="1.1167327847730"
                            resolveInfo="Reduction_MappingRule"/>
                    </node>
                  </node>
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                      id="1203776418994">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                        id="1203776417883">
                    <link role="variableDeclaration" targetNodeId="1203776371856" resolveInfo="ruleNode"/>
                  </node>
                  <node role="operation"
                        type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                        id="1203776420527">
                    <node role="conceptArgument"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference"
                          id="1203776426935">
                      <link role="conceptDeclaration" targetNodeId="1.1167171569011" resolveInfo="Weaving_MappingRule"/>
                    </node>
                  </node>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776396359">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1203776396360">
                  <link role="variableDeclaration" targetNodeId="1203776371856" resolveInfo="ruleNode"/>
                </node>
                <node role="operation"
                      type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                      id="1203776396361">
                  <node role="conceptArgument"
                        type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1203776407989">
                    <link role="conceptDeclaration" targetNodeId="1.1167514355419" resolveInfo="Root_MappingRule"/>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203776450387">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1203776451654">
            <property name="value" value="true"/>
          </node>
        </node>
      </node>
    </node>
    <node role="executeFunction" type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ExecuteBlock"
          id="1203775431228">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203775431229">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1203775487326">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1203775487327">
            <property name="name" value="templateNode"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1203775487328">
              <link role="concept" targetNodeId="1.1092059087312" resolveInfo="TemplateDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1203775487329">
              <node role="nodeOperation"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.Model_CreateNewRootNodeOperation"
                    id="1203775487330">
                <link role="concept" targetNodeId="1.1092059087312" resolveInfo="TemplateDeclaration"/>
              </node>
              <node role="leftExpression"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression" id="1203775487331">
                <node role="nodeOperation"
                      type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetModelOperation"
                      id="1203775487332"/>
                <node role="leftExpression"
                      type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                      id="1203775487333"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1203776055299">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1203776055300">
            <property name="name" value="ruleNode"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1203776055301">
              <link role="concept" targetNodeId="1.1167169308231" resolveInfo="BaseMappingRule"/>
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1203776071740">
              <node role="nodeOperation"
                    type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation"
                    id="1203776071741">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept"
                      id="1203776071742">
                  <link role="concept" targetNodeId="1.1167169308231" resolveInfo="BaseMappingRule"/>
                </node>
              </node>
              <node role="leftExpression"
                    type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                    id="1203776071743"/>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203775487334">
          <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                id="1203775487335">
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                  id="1203775487336">
              <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                    id="1203775487337">
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                      id="1203775487338">
                  <link role="link" targetNodeId="1.1167169349424"/>
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1203776079744">
                  <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
                </node>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeOperationExpression"
                  id="1203775487343">
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                    id="1203775487344">
                <link role="link" targetNodeId="1.1168285871518"/>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1203775487345">
                <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203775780052">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203775803328">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203775781663">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1203775780053">
                <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                    id="1203775783759">
                <link role="property" targetNodeId="2.1169194664001" resolveInfo="name"/>
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Property_SetOperation"
                  id="1203775805268">
              <node role="value" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1203775807567">
                <property name="value" value="template1"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203775686764">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203775811755">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203775688188">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1203775686765">
                <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                    id="1203775776581">
                <link role="link" targetNodeId="1.1092060348987"/>
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                  id="1203775825508">
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203775841527">
                <node role="operand"
                      type="jetbrains.mps.bootstrap.intentionsLanguage.structure.ConceptFunctionParameter_node"
                      id="1203775828698"/>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                      id="1203775844794">
                  <link role="link" targetNodeId="1.1177093586806"/>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1203776481016">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203776481017">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203776501309">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776528114">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776509720">
                  <node role="operand" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression"
                        id="1203776502467">
                    <link role="concept" targetNodeId="1.1167514355419" resolveInfo="Root_MappingRule"/>
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                          id="1203776501310">
                      <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                        id="1203776526144">
                    <link role="link" targetNodeId="1.1167514355421"/>
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                      id="1203776531569">
                  <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                        id="1203776543946">
                    <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776484881">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1203776483708">
              <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                  id="1203776490306">
              <node role="conceptArgument" type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference"
                    id="1203776496542">
                <link role="conceptDeclaration" targetNodeId="1.1167514355419" resolveInfo="Root_MappingRule"/>
              </node>
            </node>
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1203776558750">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203776558751">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
                    id="1203776825305">
                <node role="localVariableDeclaration"
                      type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1203776825306">
                  <property name="name" value="templateRefNode"/>
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"
                        id="1203776825307">
                    <link role="concept" targetNodeId="1.1168559333462" resolveInfo="TemplateDeclarationReference"/>
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776840700">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776840701">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression"
                            id="1203776840702">
                        <link role="concept" targetNodeId="1.1167171569011" resolveInfo="Weaving_MappingRule"/>
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                              id="1203776840703">
                          <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                            id="1203776840704">
                        <link role="link" targetNodeId="1.1169570368028"/>
                      </node>
                    </node>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetNewChildOperation"
                          id="1203776840705">
                      <link role="concept" targetNodeId="1.1168559333462" resolveInfo="TemplateDeclarationReference"/>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203776847754">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776871400">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776849053">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                          id="1203776847755">
                      <link role="variableDeclaration" targetNodeId="1203776825306" resolveInfo="templateRefNoded"/>
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                          id="1203776869868">
                      <link role="link" targetNodeId="1.1168559393589"/>
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                        id="1203776873246">
                    <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                          id="1203776877123">
                      <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.RemarkStatement" id="1203777005542">
                <property name="value" value="context function creation"/>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
                    id="1203776965491">
                <node role="localVariableDeclaration"
                      type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1203776965492">
                  <property name="name" value="contextFunction"/>
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"
                        id="1203776965493">
                    <link role="concept" targetNodeId="1.1184616041890"
                          resolveInfo="Weaving_MappingRule_ContextNodeQuery"/>
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776987604">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776987605">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression"
                            id="1203776987606">
                        <link role="concept" targetNodeId="1.1167171569011" resolveInfo="Weaving_MappingRule"/>
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                              id="1203776987607">
                          <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                            id="1203776987608">
                        <link role="link" targetNodeId="1.1184616230853"/>
                      </node>
                    </node>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetNewChildOperation"
                          id="1203776987609"/>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203776992846">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776999851">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776993973">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                          id="1203776992847">
                      <link role="variableDeclaration" targetNodeId="1203776965492" resolveInfo="contextFunction"/>
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                          id="1203776998615">
                      <link role="link" targetNodeId="8.1137022507850"/>
                    </node>
                  </node>
                  <node role="operation"
                        type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetNewChildOperation"
                        id="1203777002509"/>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
                    id="1203777147659">
                <node role="localVariableDeclaration"
                      type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1203777147660">
                  <property name="name" value="exprStmt"/>
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"
                        id="1203777147661">
                    <link role="concept" targetNodeId="8.1068580123155" resolveInfo="ExpressionStatement"/>
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203777159804">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203777159805">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203777159806">
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                              id="1203777159807">
                          <link role="variableDeclaration" targetNodeId="1203776965492" resolveInfo="contextFunction"/>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                              id="1203777159808">
                          <link role="link" targetNodeId="8.1137022507850"/>
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess"
                            id="1203777159809">
                        <link role="link" targetNodeId="8.1068581517665"/>
                      </node>
                    </node>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.LinkList_AddNewChildOperation"
                          id="1203777159810">
                      <link role="concept" targetNodeId="8.1068580123155" resolveInfo="ExpressionStatement"/>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203777163623">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203777268309">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203777165219">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                          id="1203777163624">
                      <link role="variableDeclaration" targetNodeId="1203777147660" resolveInfo="exprStmt"/>
                    </node>
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                          id="1203777176221">
                      <link role="link" targetNodeId="8.1068580123156"/>
                    </node>
                  </node>
                  <node role="operation"
                        type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetNewChildOperation"
                        id="1203777270030">
                    <link role="concept" targetNodeId="1.1167169188348"
                          resolveInfo="TemplateFunctionParameter_sourceNode"/>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776563537">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1203776562067">
                <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                    id="1203776566898">
                <node role="conceptArgument"
                      type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1203776571744">
                  <link role="conceptDeclaration" targetNodeId="1.1167171569011" resolveInfo="Weaving_MappingRule"/>
                </node>
              </node>
            </node>
            <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement" id="1203776745135">
              <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203776745136">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
                      id="1203776882938">
                  <node role="localVariableDeclaration"
                        type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1203776882939">
                    <property name="name" value="templateRefNode"/>
                    <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType"
                          id="1203776882940">
                      <link role="concept" targetNodeId="1.1168559333462" resolveInfo="TemplateDeclarationReference"/>
                    </node>
                    <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                          id="1203776882941">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776882942">
                        <node role="operand"
                              type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeTypeCastExpression"
                              id="1203776882943">
                          <link role="concept" targetNodeId="1.1167327847730" resolveInfo="Reduction_MappingRule"/>
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                id="1203776882944">
                            <link role="variableDeclaration" targetNodeId="1203776055300" resolveInfo="ruleNode"/>
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                              id="1203776903470">
                          <link role="link" targetNodeId="1.1169672767469"/>
                        </node>
                      </node>
                      <node role="operation"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetNewChildOperation"
                            id="1203776882946">
                        <link role="concept" targetNodeId="1.1168559333462" resolveInfo="TemplateDeclarationReference"/>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement"
                      id="1203776882947">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776882948">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776882949">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                            id="1203776914440">
                        <link role="variableDeclaration" targetNodeId="1203776882939" resolveInfo="templateRefNode"/>
                      </node>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess"
                            id="1203776918847">
                        <link role="link" targetNodeId="1.1168559393589"/>
                      </node>
                    </node>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation"
                          id="1203776882952">
                      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                            id="1203776882953">
                        <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1203776131734">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203776132736">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1203776131735">
              <link role="variableDeclaration" targetNodeId="1203775487327" resolveInfo="templateNode"/>
            </node>
            <node role="operation" type="jetbrains.mps.bootstrap.editorLanguage.structure.SelectLaterOperation"
                  id="1203776134097">
              <node role="editorContext"
                    type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_editorContext"
                    id="1203776151537"/>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

