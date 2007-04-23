<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.baseLanguage.actions">
  <language namespace="jetbrains.mps.bootstrap.actionsLanguage" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage" />
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang" />
  <language namespace="jetbrains.mps.bootstrap.sharedConcepts" />
  <language namespace="jetbrains.mps.regexp" />
  <maxImportIndex value="22" />
  <import index="1" modelUID="jetbrains.mps.baseLanguage.structure" />
  <import index="4" modelUID="jetbrains.mps.core.structure" />
  <import index="7" modelUID="jetbrains.mps.baseLanguage.types@java_stub" />
  <import index="17" modelUID="jetbrains.mps.baseLanguage.structure@java_stub" />
  <import index="18" modelUID="jetbrains.mps.helgins.inference@java_stub" />
  <import index="19" modelUID="jetbrains.mps.smodel@java_stub" />
  <import index="20" modelUID="java.lang@java_stub" />
  <import index="21" modelUID="jetbrains.mps.generator@java_stub" />
  <import index="22" modelUID="jetbrains.mps.regexp.jetbrains.mps.regexp.accessory" />
  <node type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActions" id="1115842744505">
    <property name="name" value="BL_node_substitute" />
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1115842748115">
      <property name="actionsFactoryAspectId" value="Expression" />
      <property name="applicableLinkMetaclass" value="aggregation" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1177328442875">
      <property name="useNewActions" value="true" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
      <node role="part" type="jetbrains.mps.bootstrap.actionsLanguage.OverridePart" id="1177328451218">
        <link role="concept" targetNodeId="1.1068580320020" />
        <node role="menuPart" type="jetbrains.mps.bootstrap.actionsLanguage.SimpleItemPart" id="1177328451219">
          <node role="canSubstitute" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_CanSubstitute" id="1177328451220">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177328451221">
              <node role="statement" type="jetbrains.mps.regexp.FindMatchStatement" id="1177328533549">
                <node role="expr" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_pattern" id="1177328536180" />
                <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177328533551">
                  <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1177328556751">
                    <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1177328557628">
                      <property name="value" value="true" />
                    </node>
                  </node>
                </node>
                <node role="regexp" type="jetbrains.mps.regexp.InlineRegexpExpression" id="1177328549273">
                  <node role="regexp" type="jetbrains.mps.regexp.PlusRegexp" id="1177328555466">
                    <node role="regexp" type="jetbrains.mps.regexp.PredefinedSymbolClassRegexp" id="1177328553542">
                      <link role="symbolClass" targetNodeId="22.1174554674770" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1177328559022">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1177328561182" />
              </node>
            </node>
          </node>
          <node role="handler" type="jetbrains.mps.bootstrap.actionsLanguage.QueryFunction_SubstituteHandler" id="1177328451226">
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1177328451227">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1177328451228">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1177328451229">
                  <property name="name" value="result" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1177328451230">
                    <link role="concept" targetNodeId="1.1068580320020" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177328451231">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.sharedConcepts.ConceptFunctionParameter_model" id="1177328451232" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Model_CreateNewNodeOperation" id="1177328451233">
                      <link role="concept" targetNodeId="1.1068580320020" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1177328451234">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177328451235">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1177328451236">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177328451237">
                      <link role="variableDeclaration" targetNodeId="1177328451229" resolveInfo="result" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess" id="1177328461714">
                      <link role="property" targetNodeId="1.1068580320021" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Property_SetOperation" id="1177328451239">
                    <node role="value" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1177328451240">
                      <link role="classConcept" extResolveInfo="20.[Classifier]Integer" />
                      <link role="baseMethodDeclaration" extResolveInfo="20.static method ([Classifier]Integer).([StaticMethodDeclaration]parseInt((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [String]), (jetbrains.mps.baseLanguage.types.int/jetbrains.mps.baseLanguage.types.int)) : (jetbrains.mps.baseLanguage.types.int/jetbrains.mps.baseLanguage.types.int))" />
                      <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_pattern" id="1177328451241" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1177328451242">
                <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1177328451243">
                  <link role="variableDeclaration" targetNodeId="1177328451229" resolveInfo="result" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1119298590500">
      <property name="actionsFactoryAspectId" value="Statement" />
      <property name="applicableLinkMetaclass" value="aggregation" />
      <link role="applicableConcept" targetNodeId="1.1068580123157" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1154033305516">
      <property name="actionsFactoryAspectId" value="Continue_Break_statements" />
      <link role="applicableConcept" targetNodeId="1.1068580123157" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstitutePreconditionFunction" id="1154539862600">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1154539862601">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1154567871793">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1154567871794">
              <property name="name" value="parent" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1154567871796" />
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1154567797129">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parentNode" id="1154567765933" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1171505650216">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_ConceptList" id="1154567826726">
                    <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1154567844056">
                      <link role="concept" targetNodeId="1.1154032098014" />
                    </node>
                    <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1154567849120">
                      <link role="concept" targetNodeId="1.1152728232947" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1163671523326">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1163671523328">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1163671529202">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1163671529891">
                  <property name="value" value="true" />
                </node>
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1163671525323">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1163671528232">
                <link role="variableDeclaration" targetNodeId="1154567871794" resolveInfo="parent" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1163671525325">
                <link role="concept" targetNodeId="1.1154032098014" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1163671541075">
            <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1163671541358">
              <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1163671541076">
                <link role="variableDeclaration" targetNodeId="1154567871794" resolveInfo="parent" />
              </node>
              <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1163671547798">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.ConceptFunctionParameter_parentNode" id="1163671547281" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1171505655373">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_ConceptList" id="1163671555270">
                    <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1163671558053">
                      <link role="concept" targetNodeId="1.1163670490218" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1163671567071">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1163671570450">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1163671569980">
                <link role="variableDeclaration" targetNodeId="1154567871794" resolveInfo="parent" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1163671572138">
                <link role="concept" targetNodeId="1.1163670490218" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1163671567073">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1163671578390">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1163671579095">
                  <property name="value" value="true" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1163671537133">
            <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1163671538885" />
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSubstituteActionsBuilder" id="1127762018548">
      <property name="actionsFactoryAspectId" value="ParameterDeclaration" />
      <property name="applicableLinkMetaclass" value="aggregation" />
      <link role="applicableConcept" targetNodeId="1.1068498886292" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActions" id="1138168268784">
    <property name="name" value="BL_rt_transform" />
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1138168280988">
      <property name="description" value="transform expression of classifier-type into member-access-expression" />
      <property name="actionsFactoryAspectId" value="InstanceMemberAccess" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1158965431412">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158965431413">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1170373576073">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1170373576074">
              <property name="name" value="ct" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1171289483893">
                <link role="classifier" extResolveInfo="17.[Classifier]ClassifierType" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1170373569900">
                <link role="classConcept" extResolveInfo="7.[Classifier]BaseLanguageTypesUtil_new" />
                <link role="baseMethodDeclaration" extResolveInfo="7.static method ([Classifier]BaseLanguageTypesUtil_new).([StaticMethodDeclaration]tryObtain_ClassifierType((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Expression])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ClassifierType]))" />
                <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1171289387344">
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAdapterOperation" id="1171289389487" />
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1170373607940" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1170373651309">
            <node role="expression" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1170373656000">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1170373657768" />
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1170373653530">
                <link role="variableDeclaration" targetNodeId="1170373576074" resolveInfo="ct" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1138168906052">
      <property name="description" value="transform expression into left operand of binary operation" />
      <property name="actionsFactoryAspectId" value="BinaryOperation" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1138169534740">
      <property name="description" value="transform expression into Lvalue of assignment" />
      <property name="actionsFactoryAspectId" value="AssignmentExpression" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1138169661398">
      <property name="description" value="transform expression into left operand of 'instanceof'" />
      <property name="actionsFactoryAspectId" value="InstanceOfExpression" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1173176145405">
      <property name="description" value="transforms array into array access expression" />
      <property name="actionsFactoryAspectId" value="ArrayAccessExpression" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1173186369008">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1173186369009">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1173186489783">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1173186489784">
              <property name="name" value="typeChecker" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1173186489785">
                <link role="classifier" extResolveInfo="18.[Classifier]TypeChecker" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1173186502161">
                <link role="baseMethodDeclaration" extResolveInfo="19.method ([Classifier]IOperationContext).([InstanceMethodDeclaration]getComponent((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Class, &lt;jetbrains.mps.baseLanguage.types.classifier [Object]&gt;])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Object]))" />
                <node role="instance" type="jetbrains.mps.bootstrap.sharedConcepts.ConceptFunctionParameter_operationContext" id="1173186499237" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.ClassifierClassExpression" id="1173186513804">
                  <link role="classifier" extResolveInfo="18.[Classifier]TypeChecker" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1173186393642">
            <node role="expression" type="jetbrains.mps.baseLanguage.InstanceOfExpression" id="1173186567423">
              <node role="classType" type="jetbrains.mps.baseLanguage.ClassifierType" id="1173186576064">
                <link role="classifier" extResolveInfo="17.[Classifier]ArrayType" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1173186639752">
                <link role="baseMethodDeclaration" extResolveInfo="19.static method ([Classifier]BaseAdapter).([StaticMethodDeclaration]fromNode((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [INodeAdapter]))" />
                <link role="classConcept" extResolveInfo="19.[Classifier]BaseAdapter" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1173186640341">
                  <link role="baseMethodDeclaration" extResolveInfo="18.method ([Classifier]TypeChecker).([InstanceMethodDeclaration]getTypeOf((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                  <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1173186640342">
                    <link role="variableDeclaration" targetNodeId="1173186489784" resolveInfo="typeChecker" />
                  </node>
                  <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1173186640343" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1173177437060">
      <property name="description" value="transform array into array length expression" />
      <property name="actionsFactoryAspectId" value="ArrayLengthExpression" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1173186583931">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1173186583932">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1173186583933">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1173186583934">
              <property name="name" value="typeChecker" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1173186583935">
                <link role="classifier" extResolveInfo="18.[Classifier]TypeChecker" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1173186583936">
                <link role="baseMethodDeclaration" extResolveInfo="19.method ([Classifier]IOperationContext).([InstanceMethodDeclaration]getComponent((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Class, &lt;jetbrains.mps.baseLanguage.types.classifier [Object]&gt;])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Object]))" />
                <node role="instance" type="jetbrains.mps.bootstrap.sharedConcepts.ConceptFunctionParameter_operationContext" id="1173186583937" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.ClassifierClassExpression" id="1173186583938">
                  <link role="classifier" extResolveInfo="18.[Classifier]TypeChecker" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1173186655121">
            <node role="expression" type="jetbrains.mps.baseLanguage.InstanceOfExpression" id="1173186655122">
              <node role="classType" type="jetbrains.mps.baseLanguage.ClassifierType" id="1173186655123">
                <link role="classifier" extResolveInfo="17.[Classifier]ArrayType" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1173186655124">
                <link role="baseMethodDeclaration" extResolveInfo="19.static method ([Classifier]BaseAdapter).([StaticMethodDeclaration]fromNode((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [INodeAdapter]))" />
                <link role="classConcept" extResolveInfo="19.[Classifier]BaseAdapter" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1173186655125">
                  <link role="baseMethodDeclaration" extResolveInfo="18.method ([Classifier]TypeChecker).([InstanceMethodDeclaration]getTypeOf((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                  <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1173186655126">
                    <link role="variableDeclaration" targetNodeId="1173186583934" resolveInfo="typeChecker" />
                  </node>
                  <node role="actualArgument" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1173186655127" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1140462494826">
      <property name="description" value="add initializer to variable declaration" />
      <property name="actionsFactoryAspectId" value="AddInitializer" />
      <link role="applicableConcept" targetNodeId="1.1068431474542" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1158969943216">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158969943217">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158969989271">
            <node role="condition" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1158970016315">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158969999009">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1158969996571" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158970002479">
                  <link role="link" targetNodeId="1.1068431790190" />
                </node>
              </node>
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1158970008920" />
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158969989273">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158970012390">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1158970032989" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158970057257">
            <node role="condition" type="jetbrains.mps.baseLanguage.OrExpression" id="1158970083591">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158970066167">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1158970061416" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158970068543">
                  <link role="concept" targetNodeId="1.1068390468200" />
                </node>
              </node>
              <node role="rightExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158970089559">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1158970089560" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158970089561">
                  <link role="concept" targetNodeId="1.1070462154015" />
                </node>
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158970057259">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158970103999">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1158970106079">
                  <property name="value" value="true" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158970200542">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158970204171">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1158970202701" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158970207031">
                <link role="concept" targetNodeId="1.1068581242863" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158970200544">
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158970285543">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158970285544">
                  <property name="name" value="parent" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158970285546">
                    <link role="concept" targetNodeId="4.1133920641626" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158970226567">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1158970225097" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1158970228678" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158970222938">
                <node role="condition" type="jetbrains.mps.baseLanguage.OrExpression" id="1158970255852">
                  <node role="rightExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158970299080">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158970297907">
                      <link role="variableDeclaration" targetNodeId="1158970285544" resolveInfo="parent" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158970302019">
                      <link role="concept" targetNodeId="1.1144231330558" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158970230663">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158970285563">
                      <link role="variableDeclaration" targetNodeId="1158970285544" resolveInfo="parent" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158970233086">
                      <link role="concept" targetNodeId="1.1068581242864" />
                    </node>
                  </node>
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158970222940">
                  <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158970328738">
                    <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1158970331475">
                      <property name="value" value="true" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158970113694">
            <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1158970117774" />
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1140565409777">
      <property name="description" value="tranform type into array type" />
      <property name="actionsFactoryAspectId" value="Type_addArrayBrackets" />
      <link role="applicableConcept" targetNodeId="1.1068431790189" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1140569338029">
      <property name="description" value="add generic parameters to classifier type" />
      <property name="actionsFactoryAspectId" value="ClassifierType_addParameter" />
      <link role="applicableConcept" targetNodeId="1.1107535904670" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1158972050511">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158972050512">
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158972082566">
            <node role="expression" type="jetbrains.mps.baseLanguage.EqualsExpression" id="1158972097901">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.IntegerConstant" id="1158972102544">
                <property name="value" value="0" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158972092977">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158972086678">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1158972085005" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1158972091257">
                    <link role="link" targetNodeId="1.1109201940907" />
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.LinkList_GetCountOperation" id="1158972095275" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1140573012027">
      <property name="description" value="add type variables to class/interface declaration" />
      <property name="actionsFactoryAspectId" value="GenericDeclaration_addTypeVariable" />
      <link role="applicableConcept" targetNodeId="1.1109279851642" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1159200256287">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1159200256288">
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1159200262133">
            <node role="expression" type="jetbrains.mps.baseLanguage.EqualsExpression" id="1159200285624">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.IntegerConstant" id="1159200291018">
                <property name="value" value="0" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159200281044">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159200268136">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1159200266260" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1159200278449">
                    <link role="link" targetNodeId="1.1109279881614" />
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.LinkList_GetCountOperation" id="1159200283701" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1140831852602">
      <property name="description" value="add type parameters to new-expression" />
      <property name="actionsFactoryAspectId" value="NewExpression_addTypeParameter" />
      <property name="transformTag" value="ext_1_RTransform" />
      <link role="applicableConcept" targetNodeId="1.1068581242872" />
      <node role="precondition" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionFunction" id="1159200493867">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1159200493868">
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1159200521776">
            <node role="expression" type="jetbrains.mps.baseLanguage.EqualsExpression" id="1159200521777">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.IntegerConstant" id="1159200521778">
                <property name="value" value="0" />
              </node>
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159200521779">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159200521780">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstitutePreconditionParm_sourceNode" id="1159200521781" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1159200521782">
                    <link role="link" targetNodeId="1.1135374457323" />
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.LinkList_GetCountOperation" id="1159200521783" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1164908910313">
      <property name="description" value="add catch clause" />
      <property name="actionsFactoryAspectId" value="TryCatchStatement_AddCatchClause" />
      <link role="applicableConcept" targetNodeId="1.1164879751025" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1164908927832">
      <property name="description" value="convert to try statement" />
      <property name="actionsFactoryAspectId" value="TryCatchStatement_ConvertToTry" />
      <link role="applicableConcept" targetNodeId="1.1164879751025" />
    </node>
    <node role="actionsBuilder" type="jetbrains.mps.bootstrap.actionsLanguage.RTransformHintSubstituteActionsBuilder" id="1173719449555">
      <property name="description" value="convert to ternary operator" />
      <property name="actionsFactoryAspectId" value="Expression_ConvertToTernaryOpertor" />
      <link role="applicableConcept" targetNodeId="1.1068431790191" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactories" id="1158793282643">
    <property name="name" value="BL_node_factories" />
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1158793299785">
      <link role="applicableConcept" targetNodeId="1.1068580123165" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1158793299786">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158793299787">
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1158793336649">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158793344528">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158793338057">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1158793336650" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158793342402">
                  <link role="link" targetNodeId="1.1068580123133" />
                </node>
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetNewChildOperation" id="1158793355937">
                <link role="concept" targetNodeId="1.1068581517677" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1158797366354">
      <link role="applicableConcept" targetNodeId="1.1081773326031" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1158797366355">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158797366356">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158797380644">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797394757">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158797390115" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158797397414">
                <link role="concept" targetNodeId="1.1081773326031" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158797380646">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1158797416884">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797423091">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797418433">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1158797416885" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158797421559">
                      <link role="link" targetNodeId="1.1081773367580" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1158797424733">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797445988">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158797441096">
                        <link role="concept" targetNodeId="1.1081773326031" />
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158797430703" />
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158797448661">
                        <link role="link" targetNodeId="1.1081773367580" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1158797454697">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797454698">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797454699">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1158797454700" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158797461738">
                      <link role="link" targetNodeId="1.1081773367579" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1158797454702">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158797475773">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158797472553">
                        <link role="concept" targetNodeId="1.1081773326031" />
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158797470724" />
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158797478102">
                        <link role="link" targetNodeId="1.1081773367579" />
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
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1158857529258">
      <link role="applicableConcept" targetNodeId="1.1079359253375" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1158857529259">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158857529260">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158857538697">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158857543060">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158857541106" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158857546264">
                <link role="concept" targetNodeId="1.1068431790191" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158857538699">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1158857558156">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158857564238">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158857560361">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1158857558157" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158857562096">
                      <link role="link" targetNodeId="1.1079359253376" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1158857567880">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158857603117">
                      <link role="concept" targetNodeId="1.1068431790191" />
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158862012692">
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158857597382" />
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1158862017490" />
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
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1158871408597">
      <link role="applicableConcept" targetNodeId="1.1070534934090" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1158871408598">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158871408599">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158871425486">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158871429615">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158871427598" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158871439178">
                <link role="concept" targetNodeId="1.1068431790191" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158871425488">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1158871466304">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158871473043">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158871468384">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1158871466305" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158871470948">
                      <link role="link" targetNodeId="1.1070534934092" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1158871476044">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158871494955">
                      <link role="concept" targetNodeId="1.1068431790191" />
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158871489984">
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158871488249" />
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1158871492157" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1171506337563">
                <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1171506337564">
                  <property name="name" value="castType" />
                  <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1171506337565">
                    <link role="concept" targetNodeId="1.1068431790189" />
                  </node>
                  <node role="initializer" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1171506337566">
                    <link role="classConcept" targetNodeId="1158872173903" resolveInfo="CastExpression_FactoryUtil" />
                    <link role="baseMethodDeclaration" targetNodeId="1158872840752" resolveInfo="computeCastType" />
                    <node role="actualArgument" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1171506340700">
                      <link role="concept" targetNodeId="1.1068431790191" />
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1171506337567" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1171506337568">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1171506337569">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1171506337570">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1171506337571" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1171506337572">
                      <link role="link" targetNodeId="1.1070534934091" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1171506337573">
                    <node role="parameter" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1171506337574">
                      <link role="variableDeclaration" targetNodeId="1171506337564" resolveInfo="castType" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1158938591701">
      <link role="applicableConcept" targetNodeId="1.1068581242878" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1158938591702">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158938591703">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158938599615">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158938604432">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158938602087" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158938606776">
                <link role="concept" targetNodeId="1.1068580123155" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158938599617">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1158938631277">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158938639094">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158938632404">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1158938631278" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158938637874">
                      <link role="link" targetNodeId="1.1068581517676" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1158938640517">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158938652067">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158938693227">
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158938685804">
                          <link role="concept" targetNodeId="1.1068580123155" />
                          <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1158938650956" />
                        </node>
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158938695103">
                          <link role="link" targetNodeId="1.1068580123156" />
                        </node>
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1158938654583" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1159218040860">
      <link role="applicableConcept" targetNodeId="1.1081516740877" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1159218040861">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1159218040862">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1159218070550">
            <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159218075882">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1159218074131" />
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1159218078508">
                <link role="concept" targetNodeId="1.1068431790191" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1159218070552">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1159218104291">
                <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159218109404">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159218105793">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1159218104292" />
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1159218107528">
                      <link role="link" targetNodeId="1.1081516765348" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1159218110749">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1159218130034">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1159218117955">
                        <link role="concept" targetNodeId="1.1068431790191" />
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_SampleNode" id="1159218115970" />
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1159218132519" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeFactory" type="jetbrains.mps.bootstrap.actionsLanguage.NodeFactory" id="1175861783126">
      <link role="applicableConcept" targetNodeId="1.1070475587102" />
      <node role="setupFunction" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction" id="1175861783127">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1175861783128">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1175861804168">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1175861804169">
              <property name="name" value="cls" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1175861804170">
                <link role="concept" targetNodeId="1.1068390468198" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175861820159">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_EnclosingNode" id="1175862431116" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1175861829850">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1175861833633">
                    <link role="concept" targetNodeId="1.1068390468198" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1175862039356">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1175862039357">
              <property name="name" value="extendedClass" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1175862039358">
                <link role="concept" targetNodeId="1.1068390468198" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1175862047138">
                <link role="baseMethodDeclaration" extResolveInfo="19.method ([Classifier]BaseAdapter).([InstanceMethodDeclaration]getNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1175862047139">
                  <link role="baseMethodDeclaration" extResolveInfo="21.static method ([Classifier]JavaModelUtil_new).([StaticMethodDeclaration]findClassifier((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Class])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [Classifier]))" />
                  <link role="classConcept" extResolveInfo="21.[Classifier]JavaModelUtil_new" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.ClassifierClassExpression" id="1175862047140">
                    <link role="classifier" extResolveInfo="20.[Classifier]Object" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1175861853994">
            <node role="condition" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1175862056234">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175863096027">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175861857139">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1175861854997">
                    <link role="variableDeclaration" targetNodeId="1175861804169" resolveInfo="cls" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1175863093495">
                    <link role="link" targetNodeId="1.1165602531693" />
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1175863097528">
                  <link role="link" targetNodeId="1.1107535924139" />
                </node>
              </node>
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1175861862878" />
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1175861853996">
              <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1175862073700">
                <node role="expression" type="jetbrains.mps.baseLanguage.AssignmentExpression" id="1175862074343">
                  <node role="lValue" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1175862073701">
                    <link role="variableDeclaration" targetNodeId="1175862039357" resolveInfo="parent" />
                  </node>
                  <node role="rValue" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1175863123510">
                    <link role="concept" targetNodeId="1.1068390468198" />
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175863011877">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175863006751">
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1175862075438">
                          <link role="variableDeclaration" targetNodeId="1175861804169" resolveInfo="cls" />
                        </node>
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1175863009267">
                          <link role="link" targetNodeId="1.1165602531693" />
                        </node>
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1175863013534">
                        <link role="link" targetNodeId="1.1107535924139" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachStatement" id="1175862060273">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachVariable" id="1175862060274">
              <property name="name" value="constructor" />
            </node>
            <node role="inputSequence" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175862060275">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1175862112598">
                <link role="variableDeclaration" targetNodeId="1175862039357" resolveInfo="parent" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1175862060277">
                <link role="link" targetNodeId="1.1068390468201" />
              </node>
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1175862060278">
              <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1175862060279">
                <node role="condition" type="jetbrains.mps.baseLanguage.ext.collections.lang.SequenceOperationExpression" id="1175862060280">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175862060281">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachVariableReference" id="1175862060282">
                      <link role="variable" targetNodeId="1175862060274" resolveInfo="constructor" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1175862060283">
                      <link role="link" targetNodeId="1.1068580123134" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.IsEmptyOperation" id="1175862060284" />
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1175862060285">
                  <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1175862060286">
                    <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175862060287">
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1175862060288">
                        <node role="leftExpression" type="jetbrains.mps.bootstrap.actionsLanguage.NodeSetupFunction_NewNode" id="1175862060289" />
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1175862060290">
                          <link role="link" targetNodeId="1.1070475587103" />
                        </node>
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Link_SetTargetOperation" id="1175862060291">
                        <node role="parameter" type="jetbrains.mps.baseLanguage.ext.collections.lang.ForEachVariableReference" id="1175862060292">
                          <link role="variable" targetNodeId="1175862060274" resolveInfo="constructor" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1175862060293" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.ClassConcept" id="1158872173903">
    <property name="name" value="CastExpression_FactoryUtil" />
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1158872234373">
      <property name="name" value="canComputeCastType" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.BooleanType" id="1158872765289" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158872234375">
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158872680387">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158872729722">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1158872728049">
              <link role="variableDeclaration" targetNodeId="1158872700499" resolveInfo="castExpression" />
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsRoleOperation" id="1158872733192">
              <link role="conceptOfParent" targetNodeId="1.1068499141036" />
              <link role="linkInParent" targetNodeId="1.1068499141038" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158872680389">
            <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158872755474">
              <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1158872758960">
                <property name="value" value="true" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158872780931">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158872780932">
            <property name="name" value="parent" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158872780934">
              <link role="concept" targetNodeId="4.1133920641626" />
            </node>
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158872524948">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1158875181094">
                <link role="variableDeclaration" targetNodeId="1158872700499" resolveInfo="castExpression" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1171505700968">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1158872542829" />
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_ConceptList" id="1158872547597">
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1158872570802">
                    <link role="concept" targetNodeId="1.1068431474542" />
                  </node>
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1158872590788">
                    <link role="concept" targetNodeId="1.1068581242878" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158872788295">
          <node role="expression" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1158872812367">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158872790735">
              <link role="variableDeclaration" targetNodeId="1158872780932" resolveInfo="parent" />
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1158872796005" />
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1158872700499">
        <property name="name" value="castExpression" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158872702798">
          <link role="concept" targetNodeId="1.1070534934090" />
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1158872840752">
      <property name="name" value="computeCastType" />
      <node role="returnType" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158875414188">
        <link role="concept" targetNodeId="1.1068431790189" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158872840754">
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158872840755">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158872840756">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1158875463033">
              <link role="variableDeclaration" targetNodeId="1158872840778" resolveInfo="contextNode" />
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsRoleOperation" id="1158872855312">
              <link role="conceptOfParent" targetNodeId="1.1068499141036" />
              <link role="linkInParent" targetNodeId="1.1068499141038" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158872840759">
            <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158873150284">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158873150285">
                <property name="name" value="methodCall" />
                <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158873150287">
                  <link role="concept" targetNodeId="1.1068499141036" />
                </node>
                <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158873082698">
                  <link role="concept" targetNodeId="1.1068499141036" />
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873068992">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1158875468753">
                      <link role="variableDeclaration" targetNodeId="1158872840778" resolveInfo="contextNode" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1158873070649" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158873108123">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158873108124">
                <property name="name" value="method" />
                <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158873108126">
                  <link role="concept" targetNodeId="1.1068580123132" />
                </node>
                <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873088934">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158873150288">
                    <link role="variableDeclaration" targetNodeId="1158873150285" resolveInfo="methodCall" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158873098575">
                    <link role="link" targetNodeId="1.1068499141037" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1171506210544">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1171506210545">
                <property name="name" value="index" />
                <node role="type" type="jetbrains.mps.baseLanguage.IntegerType" id="1171506210546" />
                <node role="initializer" type="jetbrains.mps.baseLanguage.ext.collections.lang.SequenceOperationExpression" id="1171506224528">
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.GetIndexOfOperation" id="1171506225906">
                    <node role="argument" type="jetbrains.mps.baseLanguage.ParameterReference" id="1171506235268">
                      <link role="variableDeclaration" targetNodeId="1158872840778" resolveInfo="contextNode" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1171506210548">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1171506210549">
                      <link role="variableDeclaration" targetNodeId="1158873150285" resolveInfo="methodCall" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccessAsList" id="1171506221824">
                      <link role="link" targetNodeId="1.1068499141038" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158873461447">
              <node role="condition" type="jetbrains.mps.baseLanguage.GreaterThanExpression" id="1158873474439">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1171506472858">
                  <link role="variableDeclaration" targetNodeId="1171506210545" resolveInfo="index" />
                </node>
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873469953">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873466217">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158873465012">
                      <link role="variableDeclaration" targetNodeId="1158873108124" resolveInfo="method" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1158873468561">
                      <link role="link" targetNodeId="1.1068580123134" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.LinkList_GetCountOperation" id="1158873471626" />
                </node>
              </node>
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158873461449">
                <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158873555201">
                  <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158873555202">
                    <property name="name" value="declaredParm" />
                    <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158873555204">
                      <link role="concept" targetNodeId="1.1068498886292" />
                    </node>
                    <node role="initializer" type="jetbrains.mps.baseLanguage.ext.collections.lang.SequenceOperationExpression" id="1171505942511">
                      <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.GetElementOperation" id="1171505944561">
                        <node role="argument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1171506476046">
                          <link role="variableDeclaration" targetNodeId="1171506210545" resolveInfo="index" />
                        </node>
                      </node>
                      <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873529633">
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158873528194">
                          <link role="variableDeclaration" targetNodeId="1158873108124" resolveInfo="method" />
                        </node>
                        <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccessAsList" id="1171505931291">
                          <link role="link" targetNodeId="1.1068580123134" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158875559303">
                  <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158875574651">
                    <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158875571337">
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158875569367">
                        <link role="variableDeclaration" targetNodeId="1158873555202" resolveInfo="declaredParm" />
                      </node>
                      <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158875573244">
                        <link role="link" targetNodeId="1.1068431790188" />
                      </node>
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1158875577465" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158872840762">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158872840763">
            <property name="name" value="parent" />
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158872890892" />
            <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158872840765">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.ParameterReference" id="1158872840766">
                <link role="variableDeclaration" targetNodeId="1158872840778" resolveInfo="enclosingNode" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1171505751828">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1158872840768" />
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_ConceptList" id="1158872840769">
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1158872906503">
                    <link role="concept" targetNodeId="1.1068431474542" />
                  </node>
                  <node role="concept" type="jetbrains.mps.bootstrap.smodelLanguage.ConceptReference" id="1158872913441">
                    <link role="concept" targetNodeId="1.1068581242878" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158873690157">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873694989">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158873693160">
              <link role="variableDeclaration" targetNodeId="1158872840763" resolveInfo="parent" />
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158873697115">
              <link role="concept" targetNodeId="1.1068431474542" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158873690159">
            <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158875595483">
              <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158875618599">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158875614347">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeTypeCastExpression" id="1158875608877">
                    <link role="concept" targetNodeId="1.1068431474542" />
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158875598844">
                      <link role="variableDeclaration" targetNodeId="1158872840763" resolveInfo="parent" />
                    </node>
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158875616442">
                    <link role="link" targetNodeId="1.1068431790188" />
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1158875620537" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158873805898">
          <node role="condition" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158873805899">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158873805900">
              <link role="variableDeclaration" targetNodeId="1158872840763" resolveInfo="parent" />
            </node>
            <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1158874084292">
              <link role="concept" targetNodeId="1.1068581242878" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158873805902">
            <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158874179709">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158874179710">
                <property name="name" value="method" />
                <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158874179712">
                  <link role="concept" targetNodeId="1.1068580123132" />
                </node>
                <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158874155064">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158874153860">
                    <link role="variableDeclaration" targetNodeId="1158872840763" resolveInfo="parent" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetAncestorOperation" id="1171505756986">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1158874166708">
                      <link role="concept" targetNodeId="1.1068580123132" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158875630008">
              <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158875645451">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158875640308">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158875639135">
                    <link role="variableDeclaration" targetNodeId="1158874179710" resolveInfo="method" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158875643981">
                    <link role="link" targetNodeId="1.1068580123133" />
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_CopyOperation" id="1158875648420" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158875855913">
          <node role="expression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1158875859306" />
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.ParameterDeclaration" id="1158872840778">
        <property name="name" value="contextNode" />
        <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158872840779">
          <link role="concept" targetNodeId="1.1068431790191" />
        </node>
      </node>
    </node>
  </node>
</model>

