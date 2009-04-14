<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:e119dbbd-3529-4067-8bad-6b9edd79d0b6(jetbrains.mps.baseLanguage.tuples.typesystem)">
  <persistence version="3" />
  <refactoringHistory />
  <language namespace="7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="ceab5195-25ea-4f22-9b92-103b95ca8c0c(jetbrains.mps.lang.core)" />
  <language namespace="a247e09e-2435-45ba-b8d2-07e93feba96a(jetbrains.mps.baseLanguage.tuples)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959033d(jetbrains.mps.lang.annotations.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590340(jetbrains.mps.lang.pattern.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)" version="17" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="4" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959034b(jetbrains.mps.lang.quotation.structure)" version="0" />
  <devkit namespace="2677cb18-f558-4e33-bc38-a5139cee06dc(jetbrains.mps.devkit.language-design)" />
  <maxImportIndex value="6" />
  <import index="1" modelUID="r:309aeee7-bee8-445c-b31d-35928d1da75f(jetbrains.mps.baseLanguage.tuples.structure)" version="-1" />
  <import index="2" modelUID="f:java_stub#jetbrains.mps.typesystem.inference(jetbrains.mps.typesystem.inference@java_stub)" version="-1" />
  <import index="3" modelUID="r:00000000-0000-4000-0000-011c895902c0(jetbrains.mps.baseLanguage.behavior)" version="-1" />
  <import index="4" modelUID="f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)" version="-1" />
  <import index="5" modelUID="f:java_stub#java.util(java.util@java_stub)" version="-1" />
  <import index="6" modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <node type="jetbrains.mps.lang.typesystem.structure.InferenceRule" id="1238853976031">
    <property name="name" value="typeof_IndexedTupleLiteral" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238853976032">
      <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1238854144244">
        <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238854144245">
          <property name="name" value="memberTypes" />
          <node role="type" type="jetbrains.mps.baseLanguage.collections.structure.ListType" id="1238854144246">
            <node role="elementType" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1238854150132" />
          </node>
          <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1238854157432">
            <node role="creator" type="jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit" id="1238854157433">
              <node role="elementType" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1238854157434" />
            </node>
          </node>
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1238854160582">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238854160583">
          <node role="statement" type="jetbrains.mps.lang.typesystem.structure.TypeVarDeclaration" id="1238854189111">
            <property name="name" value="mt" />
          </node>
          <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateEquationStatement" id="1238854196373">
            <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238854201098">
              <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1238854201099">
                <node role="term" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238854206545">
                  <link role="variableDeclaration" targetNodeId="1238854160586" resolveInfo="mbr" />
                </node>
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238854196377">
              <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeVarReference" id="1238854294684">
                <link role="typeVarDeclaration" targetNodeId="1238854189111" resolveInfo="mt" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1238854211333">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854284609">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238854211334">
                <link role="variableDeclaration" targetNodeId="1238854144245" resolveInfo="memberTypes" />
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation" id="1238854285903">
                <node role="argument" type="jetbrains.mps.lang.typesystem.structure.TypeVarReference" id="1238854286809">
                  <link role="typeVarDeclaration" targetNodeId="1238854189111" resolveInfo="mt" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="iterable" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854184248">
          <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238854182616">
            <link role="applicableNode" targetNodeId="1238853976033" resolveInfo="tuple" />
          </node>
          <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238854184913">
            <link role="link" targetNodeId="1.1238853845806" />
          </node>
        </node>
        <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238854160586">
          <property name="name" value="mbr" />
          <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1238854161667" />
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateEquationStatement" id="1238854056178">
        <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238854059793">
          <node role="normalType" type="jetbrains.mps.lang.quotation.structure.Quotation" id="1238854059794">
            <node role="quotedNode" type="jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleType" id="1238854080187">
              <node role="memberType" type="jetbrains.mps.baseLanguage.structure.Type" id="1238854082290">
                <node role="_attr_$attribute" type="jetbrains.mps.lang.quotation.structure.ListAntiquotation" id="1238854095543">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238854309286">
                    <link role="variableDeclaration" targetNodeId="1238854144245" resolveInfo="memberTypes" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238854056183">
          <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1238854050913">
            <node role="term" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238854053370">
              <link role="applicableNode" targetNodeId="1238853976033" resolveInfo="tuple" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1238853976033">
      <property name="name" value="tuple" />
      <link role="concept" targetNodeId="1.1238853782547" resolveInfo="IndexedTupleLiteral" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InequationReplacementRule" id="1238854440948">
    <property name="name" value="tuple_comparableTo_tuple" />
    <node role="supertypeNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1238854462052">
      <property name="name" value="rightTuple" />
      <link role="concept" targetNodeId="1.1238852151516" resolveInfo="IndexedTupleType" />
    </node>
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238854440950">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1238854492399">
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1238854504554">
          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854514021">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854511824">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238854510818">
                <link role="applicableNode" targetNodeId="1238854462052" resolveInfo="rightTuple" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238854513286">
                <link role="link" targetNodeId="1.1238852204892" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation" id="1238854514628" />
          </node>
          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854498701">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854496238">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238854495843">
                <link role="applicableNode" targetNodeId="1238854451595" resolveInfo="leftTuple" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238854497591">
                <link role="link" targetNodeId="1.1238852204892" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation" id="1238854499023" />
          </node>
        </node>
        <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1238854516076">
          <property name="value" value="Member types count don't match" />
        </node>
        <node role="nodeToReport" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238856131474">
          <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ErrorInfoExpression" id="1238856130474" />
          <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1238856138672">
            <link role="baseMethodDeclaration" targetNodeId="2.~EquationInfo.getNodeWithError():jetbrains.mps.smodel.SNode" resolveInfo="getNodeWithError" />
          </node>
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop" id="1238854545571">
        <node role="loopVariable" type="jetbrains.mps.lang.typesystem.structure.MultipleForeachLoopVariable" id="1238854545572">
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238854545573">
            <property name="name" value="lmt" />
            <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1238854547886" />
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854552934">
            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238854552674">
              <link role="applicableNode" targetNodeId="1238854451595" resolveInfo="leftTuple" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238854554077">
              <link role="link" targetNodeId="1.1238852204892" />
            </node>
          </node>
        </node>
        <node role="loopVariable" type="jetbrains.mps.lang.typesystem.structure.MultipleForeachLoopVariable" id="1238854555216">
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238854555217">
            <property name="name" value="rmt" />
            <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1238854556482" />
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238854562003">
            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238854560780">
              <link role="applicableNode" targetNodeId="1238854462052" resolveInfo="rightTuple" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238854562696">
              <link role="link" targetNodeId="1.1238852204892" />
            </node>
          </node>
        </node>
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238854545576">
          <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateLessThanInequationStatement" id="1238854598691">
            <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238854598692">
              <node role="normalType" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238948717415">
                <link role="variableDeclaration" targetNodeId="1238854545573" resolveInfo="lmt" />
              </node>
            </node>
            <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238854598694">
              <node role="normalType" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238948718863">
                <link role="variableDeclaration" targetNodeId="1238854555217" resolveInfo="rmt" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1238854451595">
      <property name="name" value="leftTuple" />
      <link role="concept" targetNodeId="1.1238852151516" resolveInfo="IndexedTupleType" />
    </node>
  </node>
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" />
  <node type="jetbrains.mps.lang.typesystem.structure.InferenceRule" id="1238857867840">
    <property name="name" value="typeof_IndexedTupleMemberAccessExpression" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238857867841">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1238859427576">
        <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1238859439694">
          <property name="value" value="Index must be a constant expression" />
        </node>
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863517763">
          <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238859428820">
            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238859428821">
              <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238859428822">
              <link role="link" targetNodeId="1.1238857834412" />
            </node>
          </node>
          <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall" id="1238863518119">
            <link role="baseMethodDeclaration" targetNodeId="3.1238860258777" resolveInfo="isCompileTimeConstant" />
          </node>
        </node>
        <node role="nodeToReport" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863619782">
          <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238863616807">
            <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
          </node>
          <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238863623524">
            <link role="link" targetNodeId="1.1238857834412" />
          </node>
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateLessThanInequationStatement" id="1238857999186">
        <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238858002476">
          <node role="normalType" type="jetbrains.mps.lang.quotation.structure.Quotation" id="1238858002477">
            <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1238858005494" />
          </node>
        </node>
        <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238857999190">
          <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1238857984180">
            <node role="term" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238857987009">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238857986584">
                <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238857992606">
                <link role="link" targetNodeId="1.1238857834412" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1238863666749">
        <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238863666750">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1238863900100">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238863900101">
              <property name="name" value="idxValue" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1238863900102">
                <link role="classifier" targetNodeId="6.~Object" resolveInfo="Object" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863900103">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863900104">
                  <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238863900105">
                    <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238863900106">
                    <link role="link" targetNodeId="1.1238857834412" />
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall" id="1238863900107">
                  <link role="baseMethodDeclaration" targetNodeId="3.1238860310638" resolveInfo="getCompileTimeConstantValue" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863900108">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863900109">
                      <node role="operand" type="jetbrains.mps.lang.smodel.structure.SemanticDowncastExpression" id="1238863900110">
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863900111">
                          <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863900112">
                            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238863900113">
                              <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
                            </node>
                            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238863900114">
                              <link role="link" targetNodeId="1.1238857834412" />
                            </node>
                          </node>
                          <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetModelOperation" id="1238863900115" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1238863900116">
                        <link role="baseMethodDeclaration" targetNodeId="4.~SModel.getModelDescriptor():jetbrains.mps.smodel.SModelDescriptor" resolveInfo="getModelDescriptor" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1238863900117">
                      <link role="baseMethodDeclaration" targetNodeId="4.~SModelDescriptor.getModule():jetbrains.mps.project.IModule" resolveInfo="getModule" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1238864106020">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238864106021">
              <property name="isFinal" value="true" />
              <property name="name" value="index" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1238864106022" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.TernaryOperatorExpression" id="1238864118291">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression" id="1238864127275">
                  <node role="classType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1238864144417">
                    <link role="classifier" targetNodeId="6.~Integer" resolveInfo="Integer" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864121493">
                    <link role="variableDeclaration" targetNodeId="1238863900101" resolveInfo="idxValue" />
                  </node>
                </node>
                <node role="ifFalse" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1238864210118">
                  <property name="value" value="-1" />
                </node>
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864206029">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1238864199531">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression" id="1238864201045">
                      <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864201046">
                        <link role="variableDeclaration" targetNodeId="1238863900101" resolveInfo="idxValue" />
                      </node>
                      <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1238864201047">
                        <link role="classifier" targetNodeId="6.~Integer" resolveInfo="Integer" />
                      </node>
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1238864207466">
                    <link role="baseMethodDeclaration" targetNodeId="6.~Integer.intValue():int" resolveInfo="intValue" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.lang.typesystem.structure.WhenConcreteStatement" id="1238864005360">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238864005361">
              <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1238864218062">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.AndExpression" id="1238864228420">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.LessThanExpression" id="1238864233305">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864231051">
                      <link role="variableDeclaration" targetNodeId="1238864106021" resolveInfo="index" />
                    </node>
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864258437">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864256244">
                        <node role="operand" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression" id="1238864248043">
                          <property name="asCast" value="true" />
                          <link role="concept" targetNodeId="1.1238852151516" resolveInfo="IndexedTupleType" />
                          <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.WhenConcreteVariableReference" id="1238864241823">
                            <link role="whenConcreteVar" targetNodeId="1238864005363" resolveInfo="tupleType" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238864257559">
                          <link role="link" targetNodeId="1.1238852204892" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation" id="1238864258936" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.GreaterThanOrEqualsExpression" id="1238864227076">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864221547">
                      <link role="variableDeclaration" targetNodeId="1238864106021" resolveInfo="index" />
                    </node>
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1238864227323">
                      <property name="value" value="0" />
                    </node>
                  </node>
                </node>
                <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1238864261325">
                  <property name="value" value="Index value out of range" />
                </node>
                <node role="nodeToReport" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864272385">
                  <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238864272136">
                    <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238864274140">
                    <link role="link" targetNodeId="1.1238857834412" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1238864283553">
                <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1238864283554">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1238864556764">
                    <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1238864556765">
                      <property name="name" value="mtypes" />
                      <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeListType" id="1238864556766">
                        <link role="elementConcept" targetNodeId="2v.1068431790189" resolveInfo="Type" />
                      </node>
                      <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864556767">
                        <node role="operand" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression" id="1238864556768">
                          <property name="asCast" value="true" />
                          <link role="concept" targetNodeId="1.1238852151516" resolveInfo="IndexedTupleType" />
                          <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.WhenConcreteVariableReference" id="1238913399575">
                            <link role="whenConcreteVar" targetNodeId="1238864005363" resolveInfo="tupleType" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238864556772">
                          <link role="link" targetNodeId="1.1238852204892" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateEquationStatement" id="1238864299354">
                    <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238864302333">
                      <node role="normalType" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864560594">
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864556773">
                          <link role="variableDeclaration" targetNodeId="1238864556765" resolveInfo="mtypes" />
                        </node>
                        <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.GetElementOperation" id="1238864563071">
                          <node role="argument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864570106">
                            <link role="variableDeclaration" targetNodeId="1238864106021" resolveInfo="index" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1238864299357">
                      <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1238864289746">
                        <node role="term" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238864292420">
                          <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.AndExpression" id="1238864285438">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.LessThanExpression" id="1238864285439">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864285440">
                      <link role="variableDeclaration" targetNodeId="1238864106021" resolveInfo="index" />
                    </node>
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864285441">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864285442">
                        <node role="operand" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression" id="1238864285443">
                          <property name="asCast" value="true" />
                          <link role="concept" targetNodeId="1.1238852151516" resolveInfo="IndexedTupleType" />
                          <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.WhenConcreteVariableReference" id="1238864285444">
                            <link role="whenConcreteVar" targetNodeId="1238864005363" resolveInfo="tupleType" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1238864285445">
                          <link role="link" targetNodeId="1.1238852204892" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation" id="1238864285446" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.GreaterThanOrEqualsExpression" id="1238864285447">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1238864285448">
                      <link role="variableDeclaration" targetNodeId="1238864106021" resolveInfo="index" />
                    </node>
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1238864285449">
                      <property name="value" value="0" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="argumentRepresentator" type="jetbrains.mps.lang.typesystem.structure.WhenConcreteVariableDeclaration" id="1238864005363">
              <property name="name" value="tupleType" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.Type" id="1238864005364" />
            </node>
            <node role="argument" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1238864035483">
              <node role="term" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238864035484">
                <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238864035485">
                  <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238864035486">
                  <link role="link" targetNodeId="1.1238857764950" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863672153">
          <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1238863668351">
            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1238863667827">
              <link role="applicableNode" targetNodeId="1238857867842" resolveInfo="mae" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1238863671547">
              <link role="link" targetNodeId="1.1238857834412" />
            </node>
          </node>
          <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall" id="1238863684725">
            <link role="baseMethodDeclaration" targetNodeId="3.1238860258777" resolveInfo="isCompileTimeConstant" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1238857867842">
      <property name="name" value="mae" />
      <link role="concept" targetNodeId="1.1238857743184" resolveInfo="IndexedTupleMemberAccessExpression" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InferenceRule" id="1239579059907">
    <property name="name" value="typeof_NamedTupleLiteral" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239579059908">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1239579091243">
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1239579101730">
          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579110756">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579107882">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579104015">
                <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579103718">
                  <link role="applicableNode" targetNodeId="1239579059909" resolveInfo="literal" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579107075">
                  <link role="link" targetNodeId="1.1239560008022" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1239579108832">
                <link role="link" targetNodeId="1.1239529553065" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation" id="1239579112166" />
          </node>
          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579100566">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579095836">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579095518">
                <link role="applicableNode" targetNodeId="1239579059909" resolveInfo="literal" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1239579099020">
                <link role="link" targetNodeId="1.1239560910577" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation" id="1239579100835" />
          </node>
        </node>
        <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1239579121787">
          <property name="value" value="Invalid components number" />
        </node>
        <node role="nodeToReport" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579149219">
          <link role="applicableNode" targetNodeId="1239579059909" resolveInfo="literal" />
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateEquationStatement" id="1239579256747">
        <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239579259491">
          <node role="normalType" type="jetbrains.mps.lang.quotation.structure.Quotation" id="1239579259492">
            <node role="quotedNode" type="jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType" id="1239579262690">
              <node role="referenceAntiquotation$link_attribute$classifier" type="jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation" id="1239579268252">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579272722">
                  <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579272479">
                    <link role="applicableNode" targetNodeId="1239579059909" resolveInfo="literal" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579273905">
                    <link role="link" targetNodeId="1.1239560008022" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239579256752">
          <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1239579201172">
            <node role="term" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579253531">
              <link role="applicableNode" targetNodeId="1239579059909" resolveInfo="literal" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239579059909">
      <property name="name" value="literal" />
      <link role="concept" targetNodeId="1.1239559992092" resolveInfo="NamedTupleLiteral" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InferenceRule" id="1239579296083">
    <property name="name" value="typeof_NamedTupleComponentReference" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239579296084">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateLessThanInequationStatement" id="1239579311797">
        <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239579316349">
          <node role="normalType" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579322153">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579316941">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579316350">
                <link role="applicableNode" targetNodeId="1239579296085" resolveInfo="reference" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579320056">
                <link role="link" targetNodeId="1.1239560595302" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579322823">
              <link role="link" targetNodeId="1.1239462974287" />
            </node>
          </node>
        </node>
        <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239579311800">
          <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1239579305052">
            <node role="term" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579308004">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579307146">
                <link role="applicableNode" targetNodeId="1239579296085" resolveInfo="reference" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579308503">
                <link role="link" targetNodeId="1.1239560837729" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239579296085">
      <property name="name" value="reference" />
      <link role="concept" targetNodeId="1.1239560581441" resolveInfo="NamedTupleComponentReference" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InequationReplacementRule" id="1239579497085">
    <property name="name" value="namedTuple_comparableTo_namedTuple" />
    <node role="supertypeNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239579532425">
      <property name="name" value="right" />
      <link role="concept" targetNodeId="1.1239531918181" resolveInfo="NamedTupleType" />
    </node>
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239579497087">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1239579585554">
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1239579594144">
          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579597493">
            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579596338">
              <link role="applicableNode" targetNodeId="1239579532425" resolveInfo="right" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579598422">
              <link role="link" targetNodeId="1.1239531948650" />
            </node>
          </node>
          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579589151">
            <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579589109">
              <link role="applicableNode" targetNodeId="1239579510770" resolveInfo="left" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579591860">
              <link role="link" targetNodeId="1.1239531948650" />
            </node>
          </node>
        </node>
        <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1239579600795">
          <property name="value" value="Different named tuples" />
        </node>
        <node role="nodeToReport" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579637562">
          <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ErrorInfoExpression" id="1239579637563" />
          <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1239579637564">
            <link role="baseMethodDeclaration" targetNodeId="2.~EquationInfo.getNodeWithError():jetbrains.mps.smodel.SNode" resolveInfo="getNodeWithError" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239579510770">
      <property name="name" value="left" />
      <link role="concept" targetNodeId="1.1239531918181" resolveInfo="NamedTupleType" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InferenceRule" id="1239579751280">
    <property name="name" value="typeof_NamedTupleComponentAccessOperation" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239579751281">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateStrongLessThanInequationStatement" id="1239642907285">
        <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239642914823">
          <node role="normalType" type="jetbrains.mps.lang.quotation.structure.Quotation" id="1239642914824">
            <node role="quotedNode" type="jetbrains.mps.baseLanguage.tuples.structure.NamedTupleType" id="1239642917094">
              <node role="referenceAntiquotation$link_attribute$classifier" type="jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation" id="1239642943298">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239642978836">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239642975436">
                    <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239642975437">
                      <link role="applicableNode" targetNodeId="1239579751282" resolveInfo="operation" />
                    </node>
                    <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239642975438">
                      <link role="link" targetNodeId="1.1239576542472" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_GetParentOperation" id="1239642979773" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239642907288">
          <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1239642894205">
            <node role="term" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239642902620">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239642902621">
                <link role="applicableNode" targetNodeId="1239579751282" resolveInfo="operation" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall" id="1239642902622">
                <link role="baseMethodDeclaration" targetNodeId="3.1213877410070" resolveInfo="getOperand" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.CreateEquationStatement" id="1239579829277">
        <node role="rightExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239579837265">
          <node role="normalType" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579842069">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239579837500">
              <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579837266">
                <link role="applicableNode" targetNodeId="1239579751282" resolveInfo="operation" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579840637">
                <link role="link" targetNodeId="1.1239576542472" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239579844050">
              <link role="link" targetNodeId="1.1239462974287" />
            </node>
          </node>
        </node>
        <node role="leftExpression" type="jetbrains.mps.lang.typesystem.structure.NormalTypeClause" id="1239579829280">
          <node role="normalType" type="jetbrains.mps.lang.typesystem.structure.TypeOfExpression" id="1239579816726">
            <node role="term" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239579825140">
              <link role="applicableNode" targetNodeId="1239579751282" resolveInfo="operation" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239579751282">
      <property name="name" value="operation" />
      <link role="concept" targetNodeId="1.1239576519914" resolveInfo="NamedTupleComponentAccessOperation" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.SubtypingRule" id="1239617235022">
    <property name="name" value="supertypesOf_namedTupleType_ClassifierType" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239617235023">
      <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1239617328566">
        <node role="expression" type="jetbrains.mps.lang.quotation.structure.Quotation" id="1239617329473">
          <node role="quotedNode" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1239617329474">
            <node role="referenceAntiquotation$link_attribute$classifier" type="jetbrains.mps.lang.quotation.structure.ReferenceAntiquotation" id="1239617329475">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239617329476">
                <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239617329477">
                  <link role="applicableNode" targetNodeId="1239617256755" resolveInfo="ntt" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239617329478">
                  <link role="link" targetNodeId="1.1239531948650" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239617256755">
      <property name="name" value="ntt" />
      <link role="concept" targetNodeId="1.1239531918181" resolveInfo="NamedTupleType" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.SubtypingRule" id="1239722373118">
    <property name="name" value="supertypesOf_namedTupleType_indexedTupleType" />
    <property name="isWeak" value="true" />
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239722373119">
      <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1239722401063">
        <node role="expression" type="jetbrains.mps.lang.quotation.structure.Quotation" id="1239722403690">
          <node role="quotedNode" type="jetbrains.mps.baseLanguage.tuples.structure.IndexedTupleType" id="1239722405209">
            <node role="memberType" type="jetbrains.mps.baseLanguage.structure.Type" id="1239722407121">
              <node role="_attr_$attribute" type="jetbrains.mps.lang.quotation.structure.ListAntiquotation" id="1239722423570">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239722451901">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239722440219">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239722435335">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239722429931">
                        <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ApplicableNodeReference" id="1239722429014">
                          <link role="applicableNode" targetNodeId="1239722394649" resolveInfo="namedTupleType" />
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239722435020">
                          <link role="link" targetNodeId="1.1239531948650" />
                        </node>
                      </node>
                      <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1239722436222">
                        <link role="link" targetNodeId="1.1239529553065" />
                      </node>
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.SelectOperationNew" id="1239722441219">
                      <node role="closure" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral" id="1239722441220">
                        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239722441221">
                          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1239722448100">
                            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239722448375">
                              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1239722448101">
                                <link role="variableDeclaration" targetNodeId="1239722441222" resolveInfo="cmp" />
                              </node>
                              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1239722450179">
                                <link role="link" targetNodeId="1.1239462974287" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="parameter" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration" id="1239722441222">
                          <property name="name" value="cmp" />
                          <node role="type" type="jetbrains.mps.baseLanguage.structure.WildCardType" id="1239722441223" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.collections.structure.ToListOperation" id="1239722452785" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239722394649">
      <property name="name" value="ntt" />
      <link role="concept" targetNodeId="1.1239531918181" resolveInfo="NamedTupleType" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InequationReplacementRule" id="1239724813932">
    <property name="name" value="indexedTuple_NOT_comparableTo_null" />
    <node role="supertypeNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239724870591">
      <property name="name" value="indexedTupleType" />
      <link role="concept" targetNodeId="1.1238852151516" resolveInfo="IndexedTupleType" />
    </node>
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239724813934">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1239724876893">
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1239724881205">
          <property name="value" value="false" />
        </node>
        <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1239724883844">
          <property name="value" value="Null is not comparable to tuple type" />
        </node>
        <node role="nodeToReport" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239724901763">
          <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ErrorInfoExpression" id="1239724901343" />
          <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1239724903186">
            <link role="baseMethodDeclaration" targetNodeId="2.~EquationInfo.getNodeWithError():jetbrains.mps.smodel.SNode" resolveInfo="getNodeWithError" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239724866468">
      <property name="name" value="nullType" />
      <link role="concept" targetNodeId="2v.1204200696010" resolveInfo="NullType" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.typesystem.structure.InequationReplacementRule" id="1239724908712">
    <property name="name" value="namedTuple_NOT_comparableTo_null" />
    <node role="supertypeNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239724930106">
      <property name="name" value="namedTupleType" />
      <link role="concept" targetNodeId="1.1239531918181" resolveInfo="NamedTupleType" />
    </node>
    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1239724908714">
      <node role="statement" type="jetbrains.mps.lang.typesystem.structure.AssertStatement" id="1239724938324">
        <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1239724938325">
          <property name="value" value="false" />
        </node>
        <node role="errorString" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1239724938326">
          <property name="value" value="Null is not comparable to tuple type" />
        </node>
        <node role="nodeToReport" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1239724938327">
          <node role="operand" type="jetbrains.mps.lang.typesystem.structure.ErrorInfoExpression" id="1239724938328" />
          <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1239724938329">
            <link role="baseMethodDeclaration" targetNodeId="2.~EquationInfo.getNodeWithError():jetbrains.mps.smodel.SNode" resolveInfo="getNodeWithError" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" type="jetbrains.mps.lang.typesystem.structure.ConceptReference" id="1239724923576">
      <property name="name" value="nullType" />
      <link role="concept" targetNodeId="2v.1204200696010" resolveInfo="NullType" />
    </node>
  </node>
</model>

