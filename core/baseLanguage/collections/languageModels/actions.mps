<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:00000000-0000-4000-0000-011c89590326(jetbrains.mps.baseLanguage.collections.actions)">
  <persistence version="3" />
  <refactoringHistory />
  <language namespace="aee9cad2-acd4-4608-aef2-0004f6a1cdbd(jetbrains.mps.lang.actions)" />
  <language namespace="7866978e-a0f0-4cc7-81bc-4d213d9375e1(jetbrains.mps.lang.smodel)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="13744753-c81f-424a-9c1b-cf8943bf4e86(jetbrains.mps.lang.sharedConcepts)" />
  <language namespace="7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902a4(jetbrains.mps.lang.actions.constraints)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902a8(jetbrains.mps.lang.actions.structure)" version="23" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="8" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ba(jetbrains.mps.lang.sharedConcepts.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)" version="17" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959030d(jetbrains.mps.lang.constraints.structure)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590340(jetbrains.mps.lang.pattern.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902bc(jetbrains.mps.lang.sharedConcepts.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959033d(jetbrains.mps.lang.annotations.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590345(jetbrains.mps.lang.pattern.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="0" />
  <maxImportIndex value="10" />
  <import index="1" modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="2" />
  <import index="2" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="0" />
  <import index="3" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <import index="4" modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="1" />
  <import index="7" modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <node type="jetbrains.mps.lang.actions.structure.SideTransformHintSubstituteActions" id="1151703690959">
    <property name="name" value="BLC_rtansform" />
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.SideTransformHintSubstituteActionsBuilder" id="1197932848431">
      <link role="applicableConcept" targetNodeId="2.1068431790191" resolveInfo="Expression" />
      <node role="precondition" type="jetbrains.mps.lang.actions.structure.SideTransformHintSubstitutePreconditionFunction" id="1197932868400">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1197932868401">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1197932910362">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1197932910363">
              <property name="name" value="type" />
              <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1197932910364" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227892181">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_sourceNode" id="1197932902888" />
                <node role="operation" type="jetbrains.mps.lang.typesystem.structure.Node_TypeOperation" id="1197932905048" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1197933037391">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227820490">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.CoerceStrongExpression" id="1197933043413">
                <node role="nodeToCoerce" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1197933043414">
                  <link role="variableDeclaration" targetNodeId="1197932910363" resolveInfo="type" />
                </node>
                <node role="pattern" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1197933043415">
                  <property name="name" value="mapType" />
                  <link role="concept" targetNodeId="1.1197683403723" resolveInfo="MapType" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsNotNullOperation" id="1197933039662" />
            </node>
          </node>
        </node>
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.AddMenuPart" id="1197933246483">
        <link role="concept" targetNodeId="1.1197932370469" resolveInfo="MapElement" />
        <node role="part" type="jetbrains.mps.lang.actions.structure.SimpleSideTransformMenuPart" id="1197933256959">
          <node role="handler" type="jetbrains.mps.lang.actions.structure.QueryFunction_SideTransform_Handler" id="1197933256960">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1197933256961">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1197933278094">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1197933278095">
                  <property name="name" value="mapElement" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1197933278096">
                    <link role="concept" targetNodeId="1.1197932370469" resolveInfo="MapElement" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227896096">
                    <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_sourceNode" id="1197933268558" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_ReplaceWithNewOperation" id="1197933272593">
                      <link role="concept" targetNodeId="1.1197932370469" resolveInfo="MapElement" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1197933285851">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227822175">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227852750">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1197933285852">
                      <link role="variableDeclaration" targetNodeId="1197933278095" resolveInfo="mapElement" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1197933290778">
                      <link role="link" targetNodeId="1.1197932505799" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Link_SetTargetOperation" id="1197933292923">
                    <node role="linkTarget" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_sourceNode" id="1197933295768" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1197933280004">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1197933280005">
                  <link role="variableDeclaration" targetNodeId="1197933278095" resolveInfo="mapElement" />
                </node>
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.lang.actions.structure.SideTransform_SimpleString" id="1197933261228">
            <property name="text" value="[" />
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.SideTransformHintSubstituteActionsBuilder" id="1207757118239">
      <link role="applicableConcept" targetNodeId="1.1152141311721" resolveInfo="SequenceCreatorWithSupplier" />
      <node role="precondition" type="jetbrains.mps.lang.actions.structure.SideTransformHintSubstitutePreconditionFunction" id="1207757132200">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207757132201">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207757139504">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207757142385">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207757140072">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_sourceNode" id="1207757139505" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1207757141848">
                  <link role="link" targetNodeId="1.1207756918186" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsNullOperation" id="1207757143634" />
            </node>
          </node>
        </node>
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.AddMenuPart" id="1207757154565">
        <link role="concept" targetNodeId="1.1152141311721" resolveInfo="SequenceCreatorWithSupplier" />
        <node role="part" type="jetbrains.mps.lang.actions.structure.SimpleSideTransformMenuPart" id="1207757160449">
          <node role="handler" type="jetbrains.mps.lang.actions.structure.QueryFunction_SideTransform_Handler" id="1207757160450">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1207757160451">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1207757195164">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207757200172">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207757195817">
                    <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_sourceNode" id="1207757195165" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1207757199463">
                      <link role="link" targetNodeId="1.1207756918186" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Link_SetNewChildOperation" id="1207757204662">
                    <link role="concept" targetNodeId="2.1068431790189" resolveInfo="Type" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1207757224696">
                <node role="expression" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_sourceNode" id="1207757225932" />
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.lang.actions.structure.SideTransform_SimpleString" id="1207757173287">
            <property name="text" value="&lt;" />
          </node>
          <node role="descriptionText" type="jetbrains.mps.lang.actions.structure.SideTransform_SimpleString" id="1207757837311">
            <property name="text" value="add type parameter" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.actions.structure.NodeSubstituteActions" id="1152143990738">
    <property name="name" value="BLC_substitute" />
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder" id="1152144005896">
      <property name="description" value="some blocks allows using of stop/skip/yield statements" />
      <link role="applicableConcept" targetNodeId="2.1068580123157" />
      <node role="part" type="jetbrains.mps.lang.actions.structure.RemovePart" id="1177410566270">
        <link role="conceptToRemove" targetNodeId="2.1068581242878" />
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.AddMenuPart" id="1177410617481">
        <link role="concept" targetNodeId="2.1068580123157" />
        <node role="part" type="jetbrains.mps.lang.actions.structure.ConceptsSubstituteMenuPart" id="1177410708020">
          <node role="query" type="jetbrains.mps.lang.actions.structure.QueryFunction_ParameterizedSubstitute_Query" id="1177410708021">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410708022">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1177410712554">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1177410712555">
                  <property name="name" value="yieldAllowed" />
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1177410712556" />
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410716705">
                    <property name="value" value="false" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1177410718343">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1177410718344">
                  <property name="name" value="stopAllowed" />
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1177410718345" />
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410722801">
                    <property name="value" value="false" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1177410725708">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1177410725709">
                  <property name="name" value="skipAllowed" />
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1177410725710" />
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410736561">
                    <property name="value" value="false" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1177410740933">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1177410740934">
                  <property name="name" value="parentClosure" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1177410740935">
                    <link role="concept" targetNodeId="2.1152728232947" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227867290">
                    <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1177410750795" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation" id="1177410755656">
                      <node role="parameter" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept" id="1177410757753">
                        <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1207854191485">
                          <link role="conceptDeclaration" targetNodeId="2.1152728232947" resolveInfo="Closure" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177410764933">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227840971">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410767438">
                    <link role="variableDeclaration" targetNodeId="1177410740934" resolveInfo="parentClosure" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1177410770778">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1177410773645">
                      <link role="conceptDeclaration" targetNodeId="1.1152125346253" />
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410764935">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410777055">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410777579">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410777056">
                        <link role="variableDeclaration" targetNodeId="1177410712555" resolveInfo="yieldAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410778253">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410780491">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410782117">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410780492">
                        <link role="variableDeclaration" targetNodeId="1177410718344" resolveInfo="stopAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410783166">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177410785140">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227921609">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410786681">
                    <link role="variableDeclaration" targetNodeId="1177410740934" resolveInfo="parentClosure" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1177410795997">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1177410797978">
                      <link role="conceptDeclaration" targetNodeId="1.1152906997013" />
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410785142">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410802645">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410803080">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410802646">
                        <link role="variableDeclaration" targetNodeId="1177410712555" resolveInfo="yieldAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410803771">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410806224">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410806688">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410806225">
                        <link role="variableDeclaration" targetNodeId="1177410718344" resolveInfo="stopAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410807397">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410808712">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410810555">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410808713">
                        <link role="variableDeclaration" targetNodeId="1177410725709" resolveInfo="skipAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410811198">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177410812357">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227887470">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410814705">
                    <link role="variableDeclaration" targetNodeId="1177410740934" resolveInfo="parentClosure" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1177410817432">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1177410821025">
                      <link role="conceptDeclaration" targetNodeId="1.1153513461623" />
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410812359">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410823398">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410823941">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410823399">
                        <link role="variableDeclaration" targetNodeId="1177410718344" resolveInfo="stopAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410824622">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410826902">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1177410829214">
                      <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410826903">
                        <link role="variableDeclaration" targetNodeId="1177410725709" resolveInfo="skipAllowed" />
                      </node>
                      <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1177410829934">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1177410837284">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1177410837285">
                  <property name="name" value="concepts" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeListType" id="1177410837286">
                    <link role="elementConcept" targetNodeId="7.1169125787135" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1177410868314">
                    <node role="creator" type="jetbrains.mps.lang.smodel.structure.SNodeListCreator" id="1177410869943">
                      <node role="createdType" type="jetbrains.mps.lang.smodel.structure.SNodeListType" id="1177410869944">
                        <link role="elementConcept" targetNodeId="7.1169125787135" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177410874540">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410875787">
                  <link role="variableDeclaration" targetNodeId="1177410712555" resolveInfo="yieldAllowed" />
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410874542">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1180049679692">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207844116163">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1180049679693">
                        <link role="variableDeclaration" targetNodeId="1177410837285" resolveInfo="concepts" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation" id="1180049831399">
                        <node role="argument" type="jetbrains.mps.lang.smodel.structure.ConceptRefExpression" id="1180050201907">
                          <link role="conceptDeclaration" targetNodeId="1.1152141063573" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177410955499">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410959216">
                  <link role="variableDeclaration" targetNodeId="1177410718344" resolveInfo="stopAllowed" />
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410955501">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410961489">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207844116190">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410961490">
                        <link role="variableDeclaration" targetNodeId="1177410837285" resolveInfo="concepts" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation" id="1180049891519">
                        <node role="argument" type="jetbrains.mps.lang.smodel.structure.ConceptRefExpression" id="1180049896837">
                          <link role="conceptDeclaration" targetNodeId="1.1152141130888" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177410967309">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410970090">
                  <link role="variableDeclaration" targetNodeId="1177410725709" resolveInfo="skipAllowed" />
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177410967311">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1177410972320">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1207844116137">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410972321">
                        <link role="variableDeclaration" targetNodeId="1177410837285" resolveInfo="concepts" />
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation" id="1180049909248">
                        <node role="argument" type="jetbrains.mps.lang.smodel.structure.ConceptRefExpression" id="1180049916441">
                          <link role="conceptDeclaration" targetNodeId="1.1152141160639" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1177410980385">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1177410981793">
                  <link role="variableDeclaration" targetNodeId="1177410837285" resolveInfo="concepts" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="precondition" type="jetbrains.mps.lang.actions.structure.NodeSubstitutePreconditionFunction" id="1160672994889">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1160672994890">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1160673732287">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1160673732288">
              <property name="name" value="block" />
              <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1160673732290" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227903807">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1160673028611" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation" id="1174260289759">
                  <node role="parameter" type="jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList" id="1160673224984">
                    <node role="concept" type="jetbrains.mps.lang.smodel.structure.ConceptReference" id="1160673232314">
                      <link role="concept" targetNodeId="1.1152125346253" />
                    </node>
                    <node role="concept" type="jetbrains.mps.lang.smodel.structure.ConceptReference" id="1160673257878">
                      <link role="concept" targetNodeId="1.1152906997013" />
                    </node>
                    <node role="concept" type="jetbrains.mps.lang.smodel.structure.ConceptReference" id="1160673266146">
                      <link role="concept" targetNodeId="1.1153513461623" />
                    </node>
                    <node role="concept" type="jetbrains.mps.lang.smodel.structure.ConceptReference" id="1168506952345">
                      <link role="concept" targetNodeId="1.1168502774204" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1160673736713">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1160673763013">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1160673765376" />
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1160673759981">
                <link role="variableDeclaration" targetNodeId="1160673732288" resolveInfo="block" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder" id="1178286508713">
      <property name="description" value="Sort direction constants" />
      <link role="applicableConcept" targetNodeId="2.1068431790191" />
      <node role="precondition" type="jetbrains.mps.lang.actions.structure.NodeSubstitutePreconditionFunction" id="1178286539824">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286539825">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286574940">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224580333225">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224580440500">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224580442933">
                  <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1224580442398" />
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224580444186">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224580445699">
                      <link role="conceptDeclaration" targetNodeId="1.1209727891789" resolveInfo="ComparatorSortOperation" />
                    </node>
                  </node>
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224580335764">
                  <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1224580335047" />
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224580336938">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224580339715">
                      <link role="conceptDeclaration" targetNodeId="1.1205679737078" resolveInfo="SortOperationNew" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227891537">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1178286574941" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1178286592083">
                  <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1178286605808">
                    <link role="conceptDeclaration" targetNodeId="1.1168502632000" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.AddMenuPart" id="1178286618907">
        <link role="concept" targetNodeId="1.1178286324487" />
        <node role="part" type="jetbrains.mps.lang.actions.structure.SimpleItemSubstitutePart" id="1178286778130">
          <node role="handler" type="jetbrains.mps.lang.actions.structure.QueryFunction_Substitute_Handler" id="1178286778131">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286778132">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1178286833792">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1178286833793">
                  <property name="name" value="direction" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1178286833794">
                    <link role="concept" targetNodeId="1.1178286324487" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227883277">
                    <node role="operand" type="jetbrains.mps.lang.sharedConcepts.structure.ConceptFunctionParameter_model" id="1178287198861" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Model_CreateNewNodeOperation" id="1178287203472">
                      <link role="concept" targetNodeId="1.1178286324487" />
                      <node role="prototypeNode" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_currentTargetNode" id="1178287212565" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286866564">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227958862">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227884805">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1178286866565">
                      <link role="variableDeclaration" targetNodeId="1178286833793" resolveInfo="direction" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1178286881453">
                      <link role="property" targetNodeId="2.1068580123138" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation" id="1178286884403">
                    <node role="value" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1178286886832">
                      <property name="value" value="true" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1178286899031">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1178286900440">
                  <link role="variableDeclaration" targetNodeId="1178286833793" resolveInfo="direction" />
                </node>
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteString" id="1178286785139">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286785140">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286793272">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1178286793273">
                  <property name="value" value="asc" />
                </node>
              </node>
            </node>
          </node>
          <node role="descriptionText" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteString" id="1178286798185">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286798186">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286799365">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1178286799366">
                  <property name="value" value="Sort in ascending order" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="part" type="jetbrains.mps.lang.actions.structure.SimpleItemSubstitutePart" id="1178286893949">
          <node role="handler" type="jetbrains.mps.lang.actions.structure.QueryFunction_Substitute_Handler" id="1178286893950">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286893951">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1178286893952">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1178286893953">
                  <property name="name" value="direction" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1178286893954">
                    <link role="concept" targetNodeId="1.1178286324487" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227853019">
                    <node role="operand" type="jetbrains.mps.lang.sharedConcepts.structure.ConceptFunctionParameter_model" id="1178287221677" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Model_CreateNewNodeOperation" id="1178287232077">
                      <link role="concept" targetNodeId="1.1178286324487" />
                      <node role="prototypeNode" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_currentTargetNode" id="1178287236515" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286893958">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227842086">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227881832">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1178286893961">
                      <link role="variableDeclaration" targetNodeId="1178286893953" resolveInfo="direction" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1178286913946">
                      <link role="property" targetNodeId="2.1068580123138" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation" id="1178286893963">
                    <node role="value" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1178286916374">
                      <property name="value" value="false" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1178286918637">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1178286920691">
                  <link role="variableDeclaration" targetNodeId="1178286893953" resolveInfo="direction" />
                </node>
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteString" id="1178286893965">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286893966">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286893967">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1178286893968">
                  <property name="value" value="desc" />
                </node>
              </node>
            </node>
          </node>
          <node role="descriptionText" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteString" id="1178286893969">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286893970">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286893971">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1178286893972">
                  <property name="value" value="Sort in descending order" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder" id="1160663024951">
      <property name="description" value="some of operations are only applicable to 'list' (like add/addAll etc.)" />
      <link role="applicableConcept" targetNodeId="2.1197027803184" resolveInfo="IOperation" />
      <node role="variable" type="jetbrains.mps.lang.actions.structure.SubstituteNodeBuilderVariableDeclaration" id="1206444869425">
        <property name="name" value="applicableTypesInfo" />
        <node role="initializerBlock" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteVariableInitializer" id="1206444869426">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206444869427">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1206444901806">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1206444901807">
                <property name="name" value="result" />
                <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1206444901808">
                  <link role="classifier" targetNodeId="1206444812617" resolveInfo="ApplicableTypesInfo" />
                </node>
                <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1217888389696">
                  <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1217888389698">
                    <link role="baseMethodDeclaration" targetNodeId="1206444910904" resolveInfo="ApplicableTypesInfo" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1206445072653">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1206445072654">
                <property name="name" value="leftExpression" />
                <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1206445072655">
                  <link role="concept" targetNodeId="2.1068431790191" resolveInfo="Expression" />
                </node>
                <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1206445072656" />
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1206445072657">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206445072658">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206445072659">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1206445072660">
                    <node role="rValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445072661">
                      <node role="operand" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression" id="1206445072662">
                        <link role="concept" targetNodeId="2.1197027756228" resolveInfo="DotExpression" />
                        <node role="leftExpression" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1206445072663" />
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1206445072664">
                        <link role="link" targetNodeId="2.1197027771414" />
                      </node>
                    </node>
                    <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445072665">
                      <link role="variableDeclaration" targetNodeId="1206445072654" resolveInfo="leftExpression" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445072666">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1206445072667" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1206445072668">
                  <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1206445072669">
                    <link role="conceptDeclaration" targetNodeId="2.1197027756228" resolveInfo="DotExpression" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1206445072670">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206445072671">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1206445072672">
                  <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1206445072673">
                    <property name="name" value="leftType" />
                    <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1206445072674" />
                    <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445072675">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445072676">
                        <link role="variableDeclaration" targetNodeId="1206445072654" resolveInfo="leftExpression" />
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.typesystem.structure.Node_TypeOperation" id="1206445072677" />
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1206445072678">
                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1206445072679">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1206445072680" />
                    <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.CoerceStrongExpression" id="1206445072681">
                      <node role="pattern" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1206445072682">
                        <property name="name" value="sequenceType" />
                        <link role="concept" targetNodeId="1.1151689724996" resolveInfo="SequenceType" />
                      </node>
                      <node role="nodeToCoerce" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445072683">
                        <link role="variableDeclaration" targetNodeId="1206445072673" resolveInfo="leftType" />
                      </node>
                    </node>
                  </node>
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206445072684">
                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206445072685">
                      <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1206445072686">
                        <node role="lValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445079079">
                          <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445077922">
                            <link role="variableDeclaration" targetNodeId="1206444901807" resolveInfo="result" />
                          </node>
                          <node role="operation" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation" id="1206445082003">
                            <link role="fieldDeclaration" targetNodeId="1206444853421" resolveInfo="myApplicableToSequence" />
                          </node>
                        </node>
                        <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1206445072688">
                          <property name="value" value="true" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1206445072689">
                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1206445072690">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1206445072691" />
                    <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.CoerceStrongExpression" id="1206445072692">
                      <node role="nodeToCoerce" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445072693">
                        <link role="variableDeclaration" targetNodeId="1206445072673" resolveInfo="leftType" />
                      </node>
                      <node role="pattern" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1206445072694">
                        <property name="name" value="listType" />
                        <link role="concept" targetNodeId="1.1151688443754" resolveInfo="ListType" />
                      </node>
                    </node>
                  </node>
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206445072695">
                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206445072696">
                      <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1206445072697">
                        <node role="lValue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445088271">
                          <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445087442">
                            <link role="variableDeclaration" targetNodeId="1206444901807" resolveInfo="result" />
                          </node>
                          <node role="operation" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation" id="1206445092413">
                            <link role="fieldDeclaration" targetNodeId="1206444830682" resolveInfo="myApplicableToList" />
                          </node>
                        </node>
                        <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1206445072699">
                          <property name="value" value="true" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445072700">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445072701">
                  <link role="variableDeclaration" targetNodeId="1206445072654" resolveInfo="leftExpression" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsNotNullOperation" id="1206445072702" />
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1206445113263">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1206445113264">
                <link role="variableDeclaration" targetNodeId="1206444901807" resolveInfo="result" />
              </node>
            </node>
          </node>
        </node>
        <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1206444874366">
          <link role="classifier" targetNodeId="1206444812617" resolveInfo="ApplicableTypesInfo" />
        </node>
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.RemoveByConditionPart" id="1177414262137">
        <node role="condition" type="jetbrains.mps.lang.actions.structure.QueryFunction_RemoveBy_Condition" id="1177414262138">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177414262139">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1177414598711">
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1177414600340">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445364286">
                  <node role="operand" type="jetbrains.mps.lang.actions.structure.SubstituteNodeBuilderVariableReference" id="1206445362941">
                    <link role="variableDeclaration" targetNodeId="1206444869425" resolveInfo="applicableTypesInfo" />
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation" id="1206445368132">
                    <link role="fieldDeclaration" targetNodeId="1206444853421" resolveInfo="myApplicableToSequence" />
                  </node>
                </node>
              </node>
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1177414598713">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.RemarkStatement" id="1203976212864">
                  <property name="value" value="remove all subconcepts of SequenceOperation" />
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1177414606349">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203976138980">
                    <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_concept" id="1203976138684" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Concept_IsSubConceptOfOperation" id="1203976143195">
                      <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1203976148227">
                        <link role="conceptDeclaration" targetNodeId="1.1151701983961" resolveInfo="SequenceOperation" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1203976160044">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1203976160045">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.RemarkStatement" id="1203976228305">
                  <property name="value" value="remove all subconcepts of AbstractListOperation" />
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203976167964">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203976171385">
                    <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_concept" id="1203976170690" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Concept_IsSubConceptOfOperation" id="1203976175612">
                      <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1203976179074">
                        <link role="conceptDeclaration" targetNodeId="1.1160612356232" resolveInfo="AbstractListOperation" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1203976161841">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206445379728">
                  <node role="operand" type="jetbrains.mps.lang.actions.structure.SubstituteNodeBuilderVariableReference" id="1206445376727">
                    <link role="variableDeclaration" targetNodeId="1206444869425" resolveInfo="applicableTypesInfo" />
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation" id="1206445385542">
                    <link role="fieldDeclaration" targetNodeId="1206444830682" resolveInfo="myApplicableToList" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.RemarkStatement" id="1203976243756">
              <property name="value" value="don't touch anything else" />
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1203976200286">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1203976201452">
                <property name="value" value="false" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.actions.structure.NodeFactories" id="1174261408149">
    <property name="name" value="BLC_factories" />
    <node role="nodeFactory" type="jetbrains.mps.lang.actions.structure.NodeFactory" id="1174261447072">
      <link role="applicableConcept" targetNodeId="1.1153248196026" />
      <node role="setupFunction" type="jetbrains.mps.lang.actions.structure.NodeSetupFunction" id="1174261447073">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1174261447074">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1174261461892">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227921161">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227958002">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.NodeSetupFunction_NewNode" id="1174261461893" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1174261465504">
                  <link role="property" targetNodeId="3.1169194664001" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation" id="1174261475897">
                <node role="value" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1174261479602">
                  <property name="value" value="it" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeFactory" type="jetbrains.mps.lang.actions.structure.NodeFactory" id="1178286959322">
      <link role="applicableConcept" targetNodeId="1.1168502632000" />
      <node role="setupFunction" type="jetbrains.mps.lang.actions.structure.NodeSetupFunction" id="1178286959323">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1178286959324">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1178286970716">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227820877">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227906705">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227847189">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227844939">
                    <node role="operand" type="jetbrains.mps.lang.actions.structure.NodeSetupFunction_NewNode" id="1178286970717" />
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1178286984953">
                      <link role="link" targetNodeId="1.1171960857530" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Link_SetNewChildOperation" id="1178286991986">
                    <link role="concept" targetNodeId="1.1178286324487" />
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1178287004332">
                  <link role="property" targetNodeId="2.1068580123138" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation" id="1178287007662">
                <node role="value" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1178287009836">
                  <property name="value" value="true" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1206444812617">
    <property name="name" value="ApplicableTypesInfo" />
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1206444910904">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1206444910905" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1206444910906" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206444910907" />
    </node>
    <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1206444830682">
      <property name="name" value="myApplicableToList" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1206444830683" />
      <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1206444832544" />
      <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1206445050615">
        <property name="value" value="false" />
      </node>
    </node>
    <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1206444853421">
      <property name="name" value="myApplicableToSequence" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1206444853422" />
      <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1206444855127" />
      <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1206445053992">
        <property name="value" value="false" />
      </node>
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1206444812618" />
  </node>
  <node type="jetbrains.mps.lang.actions.structure.NodeSubstituteActions" id="1201885292343">
    <property name="name" value="subs_MappingOperation" />
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder" id="1201885300354">
      <link role="applicableConcept" targetNodeId="1.1151701983961" resolveInfo="SequenceOperation" />
      <node role="part" type="jetbrains.mps.lang.actions.structure.AddMenuPart" id="1201885368159">
        <link role="concept" targetNodeId="1.1201792049884" resolveInfo="MappingOperation" />
        <node role="part" type="jetbrains.mps.lang.actions.structure.SimpleItemSubstitutePart" id="1201885380996">
          <node role="handler" type="jetbrains.mps.lang.actions.structure.QueryFunction_Substitute_Handler" id="1201885380997">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1201885380998">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1201885431180">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1201885431181">
                  <property name="name" value="mo" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1201885431182">
                    <link role="concept" targetNodeId="1.1201792049884" resolveInfo="MappingOperation" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1201885431183">
                    <node role="creator" type="jetbrains.mps.lang.smodel.structure.SNodeCreator" id="1201885431184">
                      <node role="createdType" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1201885431185">
                        <link role="concept" targetNodeId="1.1201792049884" resolveInfo="MappingOperation" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1201885766482">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1201885766483">
                  <property name="name" value="cl" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1201885766484">
                    <link role="concept" targetNodeId="4.1199569711397" resolveInfo="ClosureLiteral" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227851003">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227921704">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1201885766487">
                        <link role="variableDeclaration" targetNodeId="1201885431181" resolveInfo="mo" />
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1201885766488">
                        <link role="link" targetNodeId="1.1201885182287" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Link_SetNewChildOperation" id="1201885766489">
                      <link role="concept" targetNodeId="4.1199569711397" resolveInfo="ClosureLiteral" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1204045240169">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1204045240170">
                  <property name="name" value="scpd" />
                  <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1204045240171">
                    <link role="concept" targetNodeId="1.1203518072036" resolveInfo="SmartClosureParameterDeclaration" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227913344">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204227900212">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1204045240174">
                        <link role="variableDeclaration" targetNodeId="1201885766483" resolveInfo="cl" />
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1204045240175">
                        <link role="link" targetNodeId="4.1199569906740" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_AddNewChildOperation" id="1204045240176">
                      <link role="concept" targetNodeId="1.1203518072036" resolveInfo="SmartClosureParameterDeclaration" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204045243266">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204045249925">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204045243681">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1204045243267">
                      <link role="variableDeclaration" targetNodeId="1204045240170" resolveInfo="scpd" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1204045245225">
                      <link role="property" targetNodeId="3.1169194664001" resolveInfo="name" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Property_SetOperation" id="1204045250812">
                    <node role="value" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1204045254943">
                      <property name="value" value="it" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1204045258323">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1204045261043">
                  <link role="variableDeclaration" targetNodeId="1201885431181" resolveInfo="mo" />
                </node>
              </node>
            </node>
          </node>
          <node role="matchingText" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteString" id="1201885388799">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1201885388800">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1201885392659">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1201885392660">
                  <property name="value" value="map" />
                </node>
              </node>
            </node>
          </node>
          <node role="descriptionText" type="jetbrains.mps.lang.actions.structure.QueryFunction_SubstituteString" id="1201885400175">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1201885400176">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1201885402419">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1201885402420">
                  <property name="value" value="mapping operation with closure" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.actions.structure.NodeSubstituteActions" id="1224446760828">
    <property name="name" value="remove_SkipStatement_and_StopStatement" />
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder" id="1224446770027">
      <link role="applicableConcept" targetNodeId="2.1068580123157" resolveInfo="Statement" />
      <node role="precondition" type="jetbrains.mps.lang.actions.structure.NodeSubstitutePreconditionFunction" id="1224446775945">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1224446775946">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1224446897485">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1224446897486">
              <property name="name" value="cl" />
              <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1224446897487">
                <link role="concept" targetNodeId="4.1199569711397" resolveInfo="ClosureLiteral" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224446897488">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1224446897489" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation" id="1224446897490">
                  <node role="parameter" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept" id="1224446897491">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224446897492">
                      <link role="conceptDeclaration" targetNodeId="4.1199569711397" resolveInfo="ClosureLiteral" />
                    </node>
                  </node>
                  <node role="parameter" type="jetbrains.mps.lang.smodel.structure.OperationParm_Inclusion" id="1224446897493" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1224446983954">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1224446983955">
              <property name="name" value="parent" />
              <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1224446983956" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224453650284">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224453649927">
                  <link role="variableDeclaration" targetNodeId="1224446897486" resolveInfo="cl" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetParentOperation" id="1224453652531" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1224446902334">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224446913326">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1224446927999">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224446965616">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224446965627">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224446965628">
                      <link role="variableDeclaration" targetNodeId="1224446983955" resolveInfo="parent" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224446965629">
                      <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224446965630">
                        <link role="conceptDeclaration" targetNodeId="1.1201792049884" resolveInfo="TranslateOperation" />
                      </node>
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224446965631">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224446965632">
                      <link role="variableDeclaration" targetNodeId="1224446983955" resolveInfo="parent" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224446965633">
                      <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224446965634">
                        <link role="conceptDeclaration" targetNodeId="1.1204980550705" resolveInfo="VisitAllOperation" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224446902891">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224446902335">
                  <link role="variableDeclaration" targetNodeId="1224446897486" resolveInfo="cl" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsNullOperation" id="1224446911818" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.RemovePart" id="1224446992075">
        <link role="conceptToRemove" targetNodeId="1.1224446583770" resolveInfo="SkipStatement" />
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.lang.actions.structure.NodeSubstituteActionsBuilder" id="1224451907809">
      <link role="applicableConcept" targetNodeId="2.1068580123157" resolveInfo="Statement" />
      <node role="precondition" type="jetbrains.mps.lang.actions.structure.NodeSubstitutePreconditionFunction" id="1224451929757">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1224451929758">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1224452713813">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1224452713814">
              <property name="name" value="cl" />
              <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1224452713815">
                <link role="concept" targetNodeId="4.1199569711397" resolveInfo="ClosureLiteral" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224452713816">
                <node role="operand" type="jetbrains.mps.lang.actions.structure.ConceptFunctionParameter_parentNode" id="1224452713817" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation" id="1224452713818">
                  <node role="parameter" type="jetbrains.mps.lang.smodel.structure.OperationParm_Concept" id="1224452713819">
                    <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224452713820">
                      <link role="conceptDeclaration" targetNodeId="4.1199569711397" resolveInfo="ClosureLiteral" />
                    </node>
                  </node>
                  <node role="parameter" type="jetbrains.mps.lang.smodel.structure.OperationParm_Inclusion" id="1224452713821" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1224452713822">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1224452713823">
              <property name="name" value="parent" />
              <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1224452713824" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224453657844">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224453657557">
                  <link role="variableDeclaration" targetNodeId="1224452713814" resolveInfo="cl" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetParentOperation" id="1224453659053" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1224452713831">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224452713832">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1224452713833">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224452713834">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1224498039825">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224452713835">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224452713836">
                        <link role="variableDeclaration" targetNodeId="1224452713823" resolveInfo="parent" />
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224452713838">
                        <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224452713839">
                          <link role="conceptDeclaration" targetNodeId="1.1201792049884" resolveInfo="TranslateOperation" />
                        </node>
                      </node>
                    </node>
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224498043895">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224498043896">
                        <link role="variableDeclaration" targetNodeId="1224452713823" resolveInfo="parent" />
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224498043897">
                        <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224498043898">
                          <link role="conceptDeclaration" targetNodeId="1.1224414427926" resolveInfo="SequenceCreator" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224452713840">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224452713841">
                      <link role="variableDeclaration" targetNodeId="1224452713823" resolveInfo="parent" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1224452713842">
                      <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1224452713843">
                        <link role="conceptDeclaration" targetNodeId="1.1204980550705" resolveInfo="VisitAllOperation" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1224452713844">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1224452713845">
                  <link role="variableDeclaration" targetNodeId="1224452713814" resolveInfo="cl" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsNullOperation" id="1224452713846" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="part" type="jetbrains.mps.lang.actions.structure.RemovePart" id="1224452742147">
        <link role="conceptToRemove" targetNodeId="1.1224451845108" resolveInfo="StopStatement" />
      </node>
    </node>
  </node>
</model>

