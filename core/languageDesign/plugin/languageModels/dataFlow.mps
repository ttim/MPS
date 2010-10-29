<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:00000000-0000-4000-0000-011c89590362(jetbrains.mps.lang.plugin.dataFlow)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="7fa12e9c-b949-4976-b4fa-19accbc320b4(jetbrains.mps.lang.dataFlow)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="7866978e-a0f0-4cc7-81bc-4d213d9375e1(jetbrains.mps.lang.smodel)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959037d(jetbrains.mps.lang.dataFlow.structure)" version="0" />
  <maxImportIndex value="6" />
  <import index="1" modelUID="r:00000000-0000-4000-0000-011c89590368(jetbrains.mps.lang.plugin.structure)" version="23" />
  <import index="2" modelUID="r:00000000-0000-4000-0000-011c895902c0(jetbrains.mps.baseLanguage.behavior)" version="-1" />
  <import index="3" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <import index="6" modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1225441160586">
    <property name="virtualPackage:0" value="Command" />
    <link role="conceptDeclaration:0" targetNodeId="1.1225441160166:23" resolveInfo="BaseExecuteCommandStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1225441160587">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1225441160588" />
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1225441216909">
    <property name="virtualPackage:0" value="Command" />
    <link role="conceptDeclaration:0" targetNodeId="1.1225441216717:23" resolveInfo="CommandClosureLiteral" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1225441216910">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1225441216911">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="1230216704593">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1230216704594">
            <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="1230216740984">
              <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1230216753279">
                <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1230216751562" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1230216757587">
                  <link role="link:16" targetNodeId="6.1199569916463:3" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1230216714831">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1230216713036" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="1230216723102">
              <link role="baseMethodDeclaration:16" targetNodeId="2.1230212745736" resolveInfo="isExecuteSynchronous" />
            </node>
          </node>
          <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="1230216763001">
            <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1230216763002">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="1230216768309">
                <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1230216768310">
                  <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitReadStatement:0" id="1230216768311">
                    <node role="variable:0" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="1230216768312">
                      <link role="variableDeclaration:3" targetNodeId="1230216768313" resolveInfo="var" />
                    </node>
                  </node>
                </node>
                <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="1230216768313">
                  <property name="name:3" value="var" />
                  <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="1230216768314">
                    <link role="concept:16" targetNodeId="3.1068431474542:3" resolveInfo="VariableDeclaration" />
                  </node>
                </node>
                <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1230216768315">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1230216768316">
                    <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1230216768317" />
                    <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1230216768318">
                      <link role="link:16" targetNodeId="6.1199569916463:3" />
                    </node>
                  </node>
                  <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_ConceptMethodCall:16" id="1230216768319">
                    <link role="baseMethodDeclaration:16" targetNodeId="2.1214501165480" resolveInfo="getExternalVariablesDeclarations" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1229346284580">
    <property name="virtualPackage:0" value="Command" />
    <link role="conceptDeclaration:0" targetNodeId="1.1229346248766:23" resolveInfo="BaseExecuteCommandStatementSync" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1229346284581">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1229346284582">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="1229346294724">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1229346294725">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1229346294726">
              <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1229346294727" />
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1229346294728">
                <link role="link:16" targetNodeId="1.1225441160167:23" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1229346294729">
              <link role="link:16" targetNodeId="6.1199569916463:3" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1241366389346">
    <property name="virtualPackage:0" value="Actions.Action.Parameters" />
    <link role="conceptDeclaration:0" targetNodeId="1.1206092561075:23" resolveInfo="ActionParameterReferenceOperation" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1241366389347">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1241366389348">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitReadStatement:0" id="1241370846227">
          <node role="variable:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1241370850448">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1241370850449" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1241370850450">
              <link role="link:16" targetNodeId="1.1206092795071:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1241370860091">
    <property name="virtualPackage:0" value="Actions.Action.Parameters" />
    <link role="conceptDeclaration:0" targetNodeId="1.1205679047295:23" resolveInfo="ActionParameterDeclaration" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1241370860092">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1241370860093">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitWriteStatement:0" id="1562714432501063756">
          <node role="variable:0" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1562714432501063758" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1241370896352">
    <property name="virtualPackage:0" value="Actions.Action.Parameters" />
    <link role="conceptDeclaration:0" targetNodeId="1.1217252428768:23" resolveInfo="ActionDataParameterReferenceOperation" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1241370896353">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1241370896354">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitReadStatement:0" id="1241370903183">
          <node role="variable:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1241370906748">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1241370905513" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1241370915065">
              <link role="link:16" targetNodeId="1.1217252428771:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1241370921111">
    <property name="virtualPackage:0" value="Actions.Action.Parameters" />
    <link role="conceptDeclaration:0" targetNodeId="1.1217252042208:23" resolveInfo="ActionDataParameterDeclaration" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1241370921112">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1241370921113">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitWriteStatement:0" id="1241370924005">
          <node role="variable:0" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1241370926569" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1241370933774">
    <property name="virtualPackage:0" value="Actions.Action.Parameters" />
    <link role="conceptDeclaration:0" targetNodeId="1.1227008846812:23" resolveInfo="ActionConstructionParameterDeclaration" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1241370933775">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1241370933776">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitWriteStatement:0" id="1241370936792">
          <node role="variable:0" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1241370941779" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="1241370946249">
    <property name="virtualPackage:0" value="Actions.Action.Parameters" />
    <link role="conceptDeclaration:0" targetNodeId="1.1227008925923:23" resolveInfo="ActionConstructorParameterReferenceOperation" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="1241370946250">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1241370946251">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitReadStatement:0" id="1241370948408">
          <node role="variable:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1241370950786">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="1241370950285" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="1241370965728">
              <link role="link:16" targetNodeId="1.1227008991854:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="5003188907306360695">
    <property name="virtualPackage:0" value="Actions.Groups.GroupContents.Statements" />
    <link role="conceptDeclaration:0" targetNodeId="1.1207145475354:23" resolveInfo="AddElementStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="5003188907306360696">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5003188907306360697">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitReadStatement:0" id="5003188907306360698">
          <node role="variable:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5003188907306360701">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="5003188907306360700" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="5003188907306360705">
              <link role="link:16" targetNodeId="1.1207145494930:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="4434783588132677143">
    <property name="virtualPackage:0" value="RunConfigs.Configuration.Execute.Statements" />
    <link role="conceptDeclaration:0" targetNodeId="1.678887849223472895:23" resolveInfo="DisposeConsoleBlock" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="4434783588132677144">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4434783588132677145">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="4434783588132677146">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4434783588132677149">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="4434783588132677148" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="4434783588132677153">
              <link role="link:16" targetNodeId="6.1199569916463:3" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="4434783588132759534">
    <property name="virtualPackage:0" value="RunConfigs.Configuration.Execute.Statements" />
    <link role="conceptDeclaration:0" targetNodeId="1.678887849223472893:23" resolveInfo="ProcessHandlerStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="4434783588132759535">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4434783588132759536">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6830288638224174529">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6830288638224174532">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6830288638224174531" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6830288638224174536">
              <link role="link:16" targetNodeId="1.678887849223564268:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="4434783588132759545">
    <property name="virtualPackage:0" value="RunConfigs.Configuration.Execute.Statements" />
    <link role="conceptDeclaration:0" targetNodeId="1.678887849223472894:23" resolveInfo="ExecutionConsoleStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="4434783588132759546">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4434783588132759547">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6830288638224175047">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6830288638224175049">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6830288638224175050" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6830288638224175051">
              <link role="link:16" targetNodeId="1.678887849223524739:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="4434783588132759557">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4434783588132759560">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="4434783588132759559" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="4434783588132759564">
              <link role="link:16" targetNodeId="1.678887849223527748:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="8415911927033508115">
    <property name="virtualPackage:0" value="RunConfigs.Create.CreateStatement" />
    <link role="conceptDeclaration:0" targetNodeId="1.7066926174333289651:23" resolveInfo="CreateRunConfigStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="8415911927033508116">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8415911927033508117">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="3947518959181631523">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3947518959181631526">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="3947518959181631525" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="3947518959181631530">
              <link role="link:16" targetNodeId="1.4418372807722332007:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="3947518959181631532">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3947518959181631535">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="3947518959181631534" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="3947518959181631539">
              <link role="link:16" targetNodeId="1.7162284997071987551:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="8415911927033508118">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="8415911927033508119">
            <property name="name:7" value="property" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="8415911927033508124">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="8415911927033508123" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess:16" id="8415911927033508129">
              <link role="link:16" targetNodeId="1.7066926174333292874:23" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8415911927033508121">
            <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="8415911927033508131">
              <node role="codeFor:0" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="8415911927033508133">
                <link role="variable:7" targetNodeId="8415911927033508119" resolveInfo="property" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="8415911927033508134">
    <property name="virtualPackage:0" value="RunConfigs.Create.CreateStatement" />
    <link role="conceptDeclaration:0" targetNodeId="1.7066926174333292873:23" resolveInfo="RunConfigPropertyInstance" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="8415911927033508135">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8415911927033508136">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6267318242960589407">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6267318242960589409">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6267318242960589410" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6267318242960589411">
              <link role="link:16" targetNodeId="1.7066926174333292903:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitWriteStatement:0" id="8415911927033508146">
          <node role="variable:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="8415911927033508149">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="8415911927033508148" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="8415911927033508153">
              <link role="link:16" targetNodeId="1.7066926174333292904:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="9061443648117359387">
    <property name="virtualPackage:0" value="RunConfigs.Configuration.Execute.Statements" />
    <link role="conceptDeclaration:0" targetNodeId="1.9061443648117357794:23" resolveInfo="ProcessStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="9061443648117359388">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="9061443648117359389">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="9061443648117359390">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="9061443648117359393">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="9061443648117359392" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="9061443648117359397">
              <link role="link:16" targetNodeId="1.9061443648117357798:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6483235410534828646">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6483235410534828649">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6483235410534828648" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6483235410534828653">
              <link role="link:16" targetNodeId="1.6483235410534827157:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="4290387479601704088">
    <property name="virtualPackage:0" value="Actions.Groups.GroupMembers" />
    <link role="conceptDeclaration:0" targetNodeId="1.1203088046679:23" resolveInfo="ActionInstance" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="4290387479601704089">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4290387479601704090">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="4290387479601704096">
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4290387479601704097">
            <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="4290387479601704093">
              <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4290387479601704120">
                <link role="variableDeclaration:3" targetNodeId="4290387479601704100" resolveInfo="expression" />
              </node>
            </node>
          </node>
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4290387479601704110">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="4290387479601704109" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess:16" id="4290387479601704116">
              <link role="link:16" targetNodeId="1.1227011543811:23" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4290387479601704100">
            <property name="name:3" value="expression" />
            <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="4290387479601704104">
              <link role="concept:16" targetNodeId="3.1068431790191:3" resolveInfo="Expression" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="4290387479601704121">
    <property name="virtualPackage:0" value="Actions.Groups.GroupContents.Statements" />
    <link role="conceptDeclaration:0" targetNodeId="1.1227013049127:23" resolveInfo="AddStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="4290387479601704122">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4290387479601704123">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="4290387479601704124">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4290387479601704127">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="4290387479601704126" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="4290387479601704131">
              <link role="link:16" targetNodeId="1.1227013166210:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="485694842829517361">
    <property name="virtualPackage:0" value="Tool.Operations" />
    <link role="conceptDeclaration:0" targetNodeId="1.5896642449625987000:23" resolveInfo="AddTabOperation" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="485694842829517362">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="485694842829517363">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="485694842829517364">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="485694842829517367">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="485694842829517366" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="485694842829517371">
              <link role="link:16" targetNodeId="1.7566788359602201160:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="6938053545825396484">
    <property name="virtualPackage:0" value="Tool.Operations" />
    <link role="conceptDeclaration:0" targetNodeId="1.6938053545825350222:23" resolveInfo="ToolTab" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="6938053545825396485">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6938053545825396486">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6938053545825396487">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6938053545825396490">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6938053545825396489" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6938053545825396494">
              <link role="link:16" targetNodeId="1.6938053545825381648:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6938053545825396496">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6938053545825396499">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6938053545825396498" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6938053545825396503">
              <link role="link:16" targetNodeId="1.6938053545825381649:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6938053545825396506">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6938053545825396509">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6938053545825396508" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6938053545825396513">
              <link role="link:16" targetNodeId="1.6938053545825381650:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="6938053545825396515">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6938053545825396518">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="6938053545825396517" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="6938053545825396522">
              <link role="link:16" targetNodeId="1.6938053545825381651:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration:0" id="5158570261711860781">
    <property name="virtualPackage:0" value="EditorTab.Methods" />
    <link role="conceptDeclaration:0" targetNodeId="1.5703381818026462228:23" resolveInfo="AskStatement" />
    <node role="builderBlock:0" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock:0" id="5158570261711860782">
      <node role="body:0" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5158570261711860783">
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="5158570261712309218">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5158570261712309221">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="5158570261712309220" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="5158570261712309225">
              <link role="link:16" targetNodeId="1.5703381818026464830:23" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement:0" id="5158570261712309227">
          <node role="codeFor:0" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5158570261712309230">
            <node role="operand:3" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter:0" id="5158570261712309229" />
            <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SLinkAccess:16" id="5158570261712309234">
              <link role="link:16" targetNodeId="1.5703381818026464829:23" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

