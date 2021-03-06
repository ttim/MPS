<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:3eecec87-82a4-4ea1-952b-7d3a8d81c769(jetbrains.mps.execution.commands.typesystem)">
  <persistence version="7" />
  <language namespace="7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)" />
  <language namespace="f3347d8a-0e79-4f35-8ac9-1574f25c986f(jetbrains.mps.execution.commands)" />
  <devkit namespace="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  <import index="rzqf" modelUID="r:d78df0bb-be4f-4e0d-8142-c0b2df70a5a3(jetbrains.mps.execution.commands.structure)" version="0" />
  <import index="tpee" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="4" />
  <import index="fxg7" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.io(JDK/java.io@java_stub)" version="-1" />
  <import index="tpeh" modelUID="r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)" version="-1" />
  <import index="de39" modelUID="f:java_stub#742f6602-5a2f-4313-aa6e-ae1cd4ffdc61#com.intellij.execution.process(MPS.Platform/com.intellij.execution.process@java_stub)" version="-1" />
  <import index="tpck" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" implicit="yes" />
  <import index="tp25" modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" implicit="yes" />
  <import index="tp3r" modelUID="r:00000000-0000-4000-0000-011c8959034b(jetbrains.mps.lang.quotation.structure)" version="0" implicit="yes" />
  <import index="tp2q" modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" implicit="yes" />
  <import index="tpd4" modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="3" implicit="yes" />
  <import index="mdoc" modelUID="r:7757a4ec-c551-4194-a1b0-7ea4e576ea60(jetbrains.mps.execution.commands.behavior)" version="-1" implicit="yes" />
  <roots>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863700">
      <property name="name" nameId="tpck.1169194664001" value="typeof_CommandBuilderExpression" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="command" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863710">
      <property name="name" nameId="tpck.1169194664001" value="typeof_CommandParameterAssignment" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="command" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863726">
      <property name="name" nameId="tpck.1169194664001" value="typeof_CommandParameterReference" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="command" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863739">
      <property name="name" nameId="tpck.1169194664001" value="typeof_CommandReferenceExpression" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="command" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863770">
      <property name="virtualPackage" nameId="tpck.1193676396447" value="processBuilder" />
      <property name="name" nameId="tpck.1169194664001" value="typeof_ProcessBuilderExpression" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863790">
      <property name="name" nameId="tpck.1169194664001" value="typeof_ProcessBuilderKeyPart" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="processBuilder" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863816">
      <property name="name" nameId="tpck.1169194664001" value="typeof_ProcessBuilderPart" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="processBuilder" />
    </node>
    <node type="tpd4.SubtypingRule" typeId="tpd4.1175147670730" id="946964771156863830">
      <property name="name" nameId="tpck.1169194664001" value="processIsProcessHandler" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="946964771156863836">
      <property name="name" nameId="tpck.1169194664001" value="typeof_RedirectOutputExpression" />
    </node>
    <node type="tpd4.SubtypingRule" typeId="tpd4.1175147670730" id="612376536074297013">
      <property name="name" nameId="tpck.1169194664001" value="CommandProcessIsProcess" />
    </node>
    <node type="tpd4.SubtypingRule" typeId="tpd4.1175147670730" id="612376536074297025">
      <property name="name" nameId="tpck.1169194664001" value="CommandProcessCanSurviveWithoutCommand" />
    </node>
    <node type="tpd4.NonTypesystemRule" typeId="tpd4.1195214364922" id="8294204555084580553">
      <property name="name" nameId="tpck.1169194664001" value="check_ReportErrorStatement" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="error" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="2459753140357929039">
      <property name="name" nameId="tpck.1169194664001" value="typeof_StartAndWaitOperation" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="8234001627574081536">
      <property name="name" nameId="tpck.1169194664001" value="typeof_PropertyCommandPart" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="newProcessBuilder" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="889694274152216013">
      <property name="name" nameId="tpck.1169194664001" value="typeof_KeyValueCommandPart" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="newProcessBuilder" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="8234001627573984189">
      <property name="name" nameId="tpck.1169194664001" value="typeof_ProcessBuilderCommandPart" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="newProcessBuilder" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="889694274152052323">
      <property name="name" nameId="tpck.1169194664001" value="typeof_NewProcessBuilderExperssion" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="newProcessBuilder" />
    </node>
    <node type="tpd4.InferenceRule" typeId="tpd4.1174643105530" id="8234001627573984137">
      <property name="name" nameId="tpck.1169194664001" value="typeof_ListCommandPart" />
      <property name="virtualPackage" nameId="tpck.1193676396447" value="newProcessBuilder" />
    </node>
  </roots>
  <root id="946964771156863700">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863701">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="946964771156863702">
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863703">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863704">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863705">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863709" resolveInfo="commandBuilderExpression" />
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863706">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863707">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.CommandProcessType" typeId="rzqf.612376536074296995" id="1810236057992712548">
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tp3r.ReferenceAntiquotation" typeId="tp3r.1196350785117" id="1810236057992712549">
                <property name="linkRole" nameId="tpck.1757699476691236116" value="commandDeclaration" />
                <node role="expression" roleId="tp3r.1196350785111" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1810236057992713024">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1810236057992713018">
                    <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="1810236057992713017">
                      <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863709" resolveInfo="commandBuilderExpression" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="1810236057992713023">
                      <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.6129022259108621329" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="1810236057992713028">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="mdoc.6129022259108621200" resolveInfo="getCommandDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863709">
      <property name="name" nameId="tpck.1169194664001" value="commandBuilderExpression" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281780" resolveInfo="CommandBuilderExpression" />
    </node>
  </root>
  <root id="946964771156863710">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863711">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863712">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863714">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863715">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863716">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863717">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863725" resolveInfo="commandParameterAssignment" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863718">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281765" />
              </node>
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863719">
              <link role="link" roleId="tp25.1138056516764" targetNodeId="tpee.5680397130376446158" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863720">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863721">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863722">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863723">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863725" resolveInfo="commandParameterAssignment" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863724">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281766" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863725">
      <property name="name" nameId="tpck.1169194664001" value="commandParameterAssignment" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281764" resolveInfo="CommandParameterAssignment" />
    </node>
  </root>
  <root id="946964771156863726">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863727">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="946964771156863728">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863729">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863730">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863731">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863732">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863738" resolveInfo="commandParameterReference" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863733">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281758" />
              </node>
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863734">
              <link role="link" roleId="tp25.1138056516764" targetNodeId="tpee.5680397130376446158" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863735">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863736">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863737">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863738" resolveInfo="commandParameterReference" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863738">
      <property name="name" nameId="tpck.1169194664001" value="commandParameterReference" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281756" resolveInfo="CommandParameterReference" />
    </node>
  </root>
  <root id="946964771156863739">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863740">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="946964771156863741">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863742">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863743">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.CommandType" typeId="rzqf.856705193941281750" id="946964771156863744">
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tp3r.ReferenceAntiquotation" typeId="tp3r.1196350785117" id="946964771156863745">
                <property name="linkRole" nameId="tpck.1757699476691236116" value="command" />
                <node role="expression" roleId="tp3r.1196350785111" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863746">
                  <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863747">
                    <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863756" resolveInfo="commandReferenceExpression" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863748">
                    <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281755" />
                  </node>
                </node>
              </node>
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tp3r.ReferenceAntiquotation" typeId="tp3r.1196350785117" id="946964771156863749">
                <property name="linkRole" nameId="tpck.1757699476691236116" value="classifier" />
                <node role="expression" roleId="tp3r.1196350785111" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863750">
                  <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863751">
                    <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863756" resolveInfo="commandReferenceExpression" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863752">
                    <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281755" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863753">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863754">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863755">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863756" resolveInfo="commandReferenceExpression" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863756">
      <property name="name" nameId="tpck.1169194664001" value="commandReferenceExpression" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281753" resolveInfo="CommandReferenceExpression" />
    </node>
  </root>
  <root id="946964771156863770">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863771">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="946964771156863772">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863773">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863774">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessType" typeId="rzqf.856705193941281810" id="946964771156863775" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863776">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863777">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863778">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863789" resolveInfo="processBuilderExpression" />
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863779">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863781">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863782">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="946964771156863783">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863784">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863785">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863786">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863787">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863789" resolveInfo="processBuilderExpression" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863788">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281801" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863789">
      <property name="name" nameId="tpck.1169194664001" value="processBuilderExpression" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281799" resolveInfo="ProcessBuilderExpression" />
    </node>
  </root>
  <root id="946964771156863790">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863791">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863792">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863794">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863795">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.StringType" typeId="tpee.1225271177708" id="946964771156863796" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863797">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863798">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863799">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863800">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863815" resolveInfo="processBuilderKeyPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863801">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281804" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863802">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863804">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863805">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpd4.JoinType" typeId="tpd4.1179479408386" id="946964771156863806">
              <node role="argument" roleId="tpd4.1179479418730" type="tpee.StringType" typeId="tpee.1225271177708" id="946964771156863807" />
              <node role="argument" roleId="tpd4.1179479418730" type="tp2q.ListType" typeId="tp2q.1151688443754" id="946964771156863808">
                <node role="elementType" roleId="tp2q.1151688676805" type="tpee.StringType" typeId="tpee.1225271177708" id="946964771156863809" />
              </node>
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863810">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863811">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863812">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863813">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863815" resolveInfo="processBuilderKeyPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863814">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281805" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863815">
      <property name="name" nameId="tpck.1169194664001" value="processBuilderKeyPart" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281803" resolveInfo="ProcessBuilderKeyPart" />
    </node>
  </root>
  <root id="946964771156863816">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863817">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863818">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863820">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863821">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863822">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863829" resolveInfo="processBuilderPart" />
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863823">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863824">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpd4.JoinType" typeId="tpd4.1179479408386" id="946964771156863825">
              <node role="argument" roleId="tpd4.1179479418730" type="tpee.StringType" typeId="tpee.1225271177708" id="946964771156863826" />
              <node role="argument" roleId="tpd4.1179479418730" type="tp2q.ListType" typeId="tp2q.1151688443754" id="946964771156863827">
                <node role="elementType" roleId="tp2q.1151688676805" type="tpee.StringType" typeId="tpee.1225271177708" id="946964771156863828" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863829">
      <property name="name" nameId="tpck.1169194664001" value="processBuilderPart" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281807" resolveInfo="ProcessBuilderPart" />
    </node>
  </root>
  <root id="946964771156863830">
    <node role="body" roleId="tpd4.1175147624276" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863831">
      <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="946964771156863832">
        <node role="expression" roleId="tpee.1068581517676" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863833">
          <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="946964771156863834">
            <link role="classifier" roleId="tpee.1107535924139" targetNodeId="de39.~ProcessHandler" resolveInfo="ProcessHandler" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863835">
      <property name="name" nameId="tpck.1169194664001" value="processType" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281810" resolveInfo="ProcessType" />
    </node>
  </root>
  <root id="946964771156863836">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="946964771156863837">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863838">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863840">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863841">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessType" typeId="rzqf.856705193941281810" id="946964771156863842" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863843">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863844">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863845">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863846">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863858" resolveInfo="redirectOutputExpression" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863847">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281813" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="946964771156863848">
        <property name="inequationPriority" nameId="tpd4.1212056105818" value="0" />
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863850">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="946964771156863851">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="946964771156863852">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="de39.~ProcessListener" resolveInfo="ProcessListener" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="946964771156863853">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="946964771156863854">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="946964771156863855">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="946964771156863856">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863858" resolveInfo="redirectOutputExpression" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="946964771156863857">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281814" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="1594211126127559580">
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="1594211126127559583">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="1594211126127559530">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="1594211126127559579">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863858" resolveInfo="redirectOutputExpression" />
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="1594211126127610316">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="1594211126127610317">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1594211126127610319">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="1594211126127610320">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="946964771156863858" resolveInfo="redirectOutputExpression" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="1594211126127610321">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.856705193941281813" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="946964771156863858">
      <property name="name" nameId="tpck.1169194664001" value="redirectOutputExpression" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281812" resolveInfo="RedirectOutputExpression" />
    </node>
  </root>
  <root id="612376536074297013">
    <node role="body" roleId="tpd4.1175147624276" type="tpee.StatementList" typeId="tpee.1068580123136" id="612376536074297014">
      <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="612376536074297021">
        <node role="expression" roleId="tpee.1068581517676" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="612376536074297023">
          <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessType" typeId="rzqf.856705193941281810" id="612376536074297024" />
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="612376536074297015">
      <property name="name" nameId="tpck.1169194664001" value="commandProcessType" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.612376536074296995" resolveInfo="CommandProcessType" />
    </node>
  </root>
  <root id="612376536074297025">
    <node role="body" roleId="tpd4.1175147624276" type="tpee.StatementList" typeId="tpee.1068580123136" id="612376536074297026">
      <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="1388651548839401768">
        <node role="expression" roleId="tpee.1068581517676" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="612376536074297029">
          <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.CommandProcessType" typeId="rzqf.612376536074296995" id="612376536074297031" />
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="612376536074297027">
      <property name="name" nameId="tpck.1169194664001" value="commandProcessType" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.612376536074296995" resolveInfo="CommandProcessType" />
    </node>
  </root>
  <root id="8294204555084580553">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="8294204555084580554">
      <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="8294204555084580556">
        <node role="condition" roleId="tpee.1068580123160" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8294204555084580569">
          <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8294204555084580560">
            <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8294204555084580559">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8294204555084580555" resolveInfo="reportStatement" />
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetAncestorOperation" typeId="tp25.1171407110247" id="8294204555084580564">
              <node role="parameter" roleId="tp25.1144104376918" type="tp25.OperationParm_Concept" typeId="tp25.1144101972840" id="8294204555084580565">
                <node role="conceptArgument" roleId="tp25.1207343664468" type="tp25.RefConcept_Reference" typeId="tp25.1177026924588" id="8294204555084588710">
                  <link role="conceptDeclaration" roleId="tp25.1177026940964" targetNodeId="rzqf.856705193941281767" resolveInfo="CommandMethod" />
                </node>
              </node>
            </node>
          </node>
          <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_IsNotNullOperation" typeId="tp25.1172008320231" id="8294204555084580573" />
        </node>
        <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="8294204555084580558">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="8294204555084580574">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="8294204555084580575">
              <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="tpeh.1176897069499" resolveInfo="RulesFunctions_BaseLanguage" />
              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tpeh.7152041109751866346" resolveInfo="check" />
              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="8294204555084580587">
                <node role="creator" roleId="tpee.1145553007750" type="tp2q.HashSetCreator" typeId="tp2q.1226516258405" id="8294204555084580596">
                  <node role="elementType" roleId="tp2q.1237721435807" type="tp25.SNodeType" typeId="tp25.1138055754698" id="8294204555084580597">
                    <link role="concept" roleId="tp25.1138405853777" targetNodeId="tpee.1068431790189" resolveInfo="Type" />
                  </node>
                  <node role="initValue" roleId="tp2q.1237721435808" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8294204555084580598">
                    <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8294204555084580599">
                      <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8294204555084580555" resolveInfo="reportStatement" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="8294204555084580600">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="mdoc.856705193941282181" resolveInfo="getException" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="actualArgument" roleId="tpee.1068499141038" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8294204555084580578">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8294204555084580555" resolveInfo="reportStatement" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="8294204555084580555">
      <property name="name" nameId="tpck.1169194664001" value="reportStatement" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.856705193941281792" resolveInfo="ReportErrorStatement" />
    </node>
  </root>
  <root id="2459753140357929039">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="2459753140357929040">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="1317559410260002203">
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="1317559410260002204">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="1317559410260002205">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1317559410260002206">
              <node role="operand" roleId="tpee.1197027771414" type="tp25.SNodeTypeCastExpression" typeId="tp25.1140137987495" id="1317559410260002207">
                <link role="concept" roleId="tp25.1140138128738" targetNodeId="tpee.1197027756228" resolveInfo="DotExpression" />
                <node role="leftExpression" roleId="tp25.1140138123956" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1317559410260002208">
                  <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="1317559410260002209">
                    <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="2459753140357929041" resolveInfo="operation" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetParentOperation" typeId="tp25.1139613262185" id="1317559410260002210" />
                </node>
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="1317559410260002211">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="tpee.1197027771414" />
              </node>
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="1317559410260002212">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="1317559410260002213">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessType" typeId="rzqf.856705193941281810" id="1317559410260002214" />
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="2459753140357929076">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="2459753140357929080">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="2459753140357929081">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.IntegerType" typeId="tpee.1070534370425" id="1317559410260021045" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="2459753140357929079">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="2459753140357929069">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="2459753140357929071">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="2459753140357929041" resolveInfo="operation" />
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="1611229975416268526">
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="1611229975416268527">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="1611229975416268528">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1611229975416268529">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="1611229975416268530">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="2459753140357929041" resolveInfo="operation" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="1611229975416268531">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.454072909645280896" />
              </node>
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="1611229975416268533">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="1611229975416268534">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.LongType" typeId="tpee.1068581242867" id="1611229975416268536" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="2459753140357929041">
      <property name="name" nameId="tpck.1169194664001" value="operation" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.2459753140357918802" resolveInfo="StartAndWaitOperation" />
    </node>
  </root>
  <root id="8234001627574081536">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="8234001627574081537">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="8234001627574081556">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627574081560">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="8234001627574081561">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.StringType" typeId="tpee.1225271177708" id="8234001627574081563" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627574081559">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="8234001627574081548">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8234001627574081551">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8234001627574081550">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8234001627574081538" resolveInfo="propertyCommandPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="8234001627574081555">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.8234001627574071407" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="8234001627574081574">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627574081578">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="8234001627574081579">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpd4.JoinType" typeId="tpd4.1179479408386" id="8234001627574081581">
              <node role="argument" roleId="tpd4.1179479418730" type="tpee.StringType" typeId="tpee.1225271177708" id="8234001627574081583" />
              <node role="argument" roleId="tpd4.1179479418730" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="8234001627574081586">
                <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
              </node>
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627574081577">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="8234001627574081566">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8234001627574081569">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8234001627574081568">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8234001627574081538" resolveInfo="propertyCommandPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="8234001627574081573">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.8234001627574071408" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="8234001627574081538">
      <property name="name" nameId="tpck.1169194664001" value="propertyCommandPart" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.8234001627574071406" resolveInfo="PropertyCommandPart" />
    </node>
  </root>
  <root id="889694274152216013">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="889694274152216014">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="889694274152216025">
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152216028">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="889694274152216017">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="889694274152216020">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="889694274152216019">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="889694274152216015" resolveInfo="keyValueCommandPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="889694274152216024">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.889694274152177539" />
              </node>
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152216029">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="889694274152216030">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.StringType" typeId="tpee.1225271177708" id="889694274152216032" />
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="889694274152216043">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152216047">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="889694274152216048">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpd4.JoinType" typeId="tpd4.1179479408386" id="889694274152216050">
              <node role="argument" roleId="tpd4.1179479418730" type="tpee.StringType" typeId="tpee.1225271177708" id="889694274152216051" />
              <node role="argument" roleId="tpd4.1179479418730" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="889694274152216055">
                <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
              </node>
              <node role="argument" roleId="tpd4.1179479418730" type="rzqf.ProcessBuilderCommandPartType" typeId="rzqf.889694274152216058" id="6868250101935566571" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152216046">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="889694274152216035">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="889694274152216038">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="889694274152216037">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="889694274152216015" resolveInfo="keyValueCommandPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="889694274152216042">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.889694274152177540" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="6868250101935571150">
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="6868250101935571151">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="6868250101935571152">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="6868250101935571153">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="889694274152216015" resolveInfo="keyValueCommandPart" />
            </node>
          </node>
        </node>
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="6868250101935571154">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="6868250101935571155">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessBuilderCommandPartType" typeId="rzqf.889694274152216058" id="6868250101935571156" />
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="889694274152216015">
      <property name="name" nameId="tpck.1169194664001" value="keyValueCommandPart" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.889694274152177535" resolveInfo="KeyValueCommandPart" />
    </node>
  </root>
  <root id="8234001627573984189">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="8234001627573984190">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="8234001627573984196">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627573984200">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="8234001627573984201">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessBuilderCommandPartType" typeId="rzqf.889694274152216058" id="8234001627573984203" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627573984199">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="8234001627573984193">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8234001627573984195">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8234001627573984191" resolveInfo="processBuilderCommandPart" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="8234001627573984191">
      <property name="name" nameId="tpck.1169194664001" value="processBuilderCommandPart" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.889694274152177536" resolveInfo="ProcessBuilderCommandPart" />
    </node>
  </root>
  <root id="889694274152052323">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="889694274152052324">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateEquationStatement" typeId="tpd4.1174658326157" id="889694274152055975">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152055979">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="889694274152055980">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="rzqf.ProcessType" typeId="rzqf.856705193941281810" id="889694274152055982" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152055978">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="889694274152055972">
            <node role="term" roleId="tpd4.1174657509053" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="889694274152055974">
              <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="889694274152052325" resolveInfo="newProcessBuilderExpression" />
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="889694274152056854">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152056858">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="889694274152056859">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="889694274152061884">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152056857">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="889694274152055985">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="889694274152055988">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="889694274152055987">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="889694274152052325" resolveInfo="newProcessBuilderExpression" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="889694274152056853">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.2343546112398330902" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tp2q.ForEachStatement" typeId="tp2q.1153943597977" id="889694274152061896">
        <node role="variable" roleId="tp2q.1153944400369" type="tp2q.ForEachVariable" typeId="tp2q.1153944193378" id="889694274152061897">
          <property name="name" nameId="tpck.1169194664001" value="part" />
        </node>
        <node role="inputSequence" roleId="tp2q.1153944424730" type="tpee.DotExpression" typeId="tpee.1197027756228" id="889694274152095731">
          <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="889694274152095730">
            <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="889694274152052325" resolveInfo="newProcessBuilderExpression" />
          </node>
          <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="889694274152095735">
            <link role="link" roleId="tp25.1138056546658" targetNodeId="rzqf.2343546112398330901" />
          </node>
        </node>
        <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="889694274152061899">
          <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="889694274152095740">
            <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152095744">
              <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="889694274152095745">
                <node role="quotedNode" roleId="tp3r.1196350785114" type="tpd4.JoinType" typeId="tpd4.1179479408386" id="889694274152095747">
                  <node role="argument" roleId="tpd4.1179479418730" type="tpee.StringType" typeId="tpee.1225271177708" id="889694274152095748" />
                  <node role="argument" roleId="tpd4.1179479418730" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="889694274152095751">
                    <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
                  </node>
                  <node role="argument" roleId="tpd4.1179479418730" type="rzqf.ProcessBuilderCommandPartType" typeId="rzqf.889694274152216058" id="6868250101935575616" />
                </node>
              </node>
            </node>
            <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="889694274152095743">
              <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="889694274152095737">
                <node role="term" roleId="tpd4.1174657509053" type="tp2q.ForEachVariableReference" typeId="tp2q.1153944233411" id="889694274152095739">
                  <link role="variable" roleId="tp2q.1153944258490" targetNodeId="889694274152061897" resolveInfo="part" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="889694274152052325">
      <property name="name" nameId="tpck.1169194664001" value="newProcessBuilderExpression" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.2343546112398330898" resolveInfo="NewProcessBuilderExpression" />
    </node>
  </root>
  <root id="8234001627573984137">
    <node role="body" roleId="tpd4.1195213635060" type="tpee.StatementList" typeId="tpee.1068580123136" id="8234001627573984138">
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="8234001627573984149">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627573984153">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="8234001627573984154">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tp2q.ListType" typeId="tp2q.1151688443754" id="8234001627574005999">
              <node role="elementType" roleId="tp2q.1151688676805" type="tpee.WildCardType" typeId="tpee.1171903607971" id="8234001627574012486" />
            </node>
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627573984152">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="8234001627573984141">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8234001627573984144">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8234001627573984143">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8234001627573984139" resolveInfo="listCommandPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="8234001627573984148">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.6868250101935610315" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="statement" roleId="tpee.1068581517665" type="tpd4.CreateStrongLessThanInequationStatement" typeId="tpd4.1179832490862" id="8234001627573984181">
        <node role="rightExpression" roleId="tpd4.1174660783414" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627573984185">
          <node role="normalType" roleId="tpd4.1185788644032" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="8234001627573984186">
            <node role="quotedNode" roleId="tp3r.1196350785114" type="tpee.StringType" typeId="tpee.1225271177708" id="8234001627573984188" />
          </node>
        </node>
        <node role="leftExpression" roleId="tpd4.1174660783413" type="tpd4.NormalTypeClause" typeId="tpd4.1185788614172" id="8234001627573984184">
          <node role="normalType" roleId="tpd4.1185788644032" type="tpd4.TypeOfExpression" typeId="tpd4.1174657487114" id="8234001627573984173">
            <node role="term" roleId="tpd4.1174657509053" type="tpee.DotExpression" typeId="tpee.1197027756228" id="8234001627573984176">
              <node role="operand" roleId="tpee.1197027771414" type="tpd4.ApplicableNodeReference" typeId="tpd4.1174650418652" id="8234001627573984175">
                <link role="applicableNode" roleId="tpd4.1174650432090" targetNodeId="8234001627573984139" resolveInfo="listCommandPart" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="8234001627573984180">
                <link role="link" roleId="tp25.1138056516764" targetNodeId="rzqf.6868250101935610316" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="applicableNode" roleId="tpd4.1174648101952" type="tpd4.ConceptReference" typeId="tpd4.1174642788531" id="8234001627573984139">
      <property name="name" nameId="tpck.1169194664001" value="listCommandPart" />
      <link role="concept" roleId="tpd4.1174642800329" targetNodeId="rzqf.6868250101935610313" resolveInfo="ListCommandPart" />
    </node>
  </root>
</model>

