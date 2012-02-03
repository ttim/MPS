<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:baa8d683-513d-4695-bd7b-2c1c3e940d01(jetbrains.mps.buildScript.pluginSolution.plugin)">
  <persistence version="7" />
  <language namespace="22e72e4c-0f69-46ce-8403-6750153aa615(jetbrains.mps.execution.configurations)" />
  <language namespace="756e911c-3f1f-4a48-bdf5-a2ceb91b723c(jetbrains.mps.execution.settings)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="28f9e497-3b42-4291-aeba-0a1039153ab1(jetbrains.mps.lang.plugin)" />
  <language namespace="7866978e-a0f0-4cc7-81bc-4d213d9375e1(jetbrains.mps.lang.smodel)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <language namespace="f3347d8a-0e79-4f35-8ac9-1574f25c986f(jetbrains.mps.execution.commands)" />
  <language namespace="443f4c36-fcf5-4eb6-9500-8d06ed259e3e(jetbrains.mps.baseLanguage.classifiers)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <import index="awpe" modelUID="r:5a505993-793e-4b2d-84cf-271f9dde39b3(jetbrains.mps.execution.lib)" version="1" />
  <import index="3ior" modelUID="r:e9081cad-d8c3-45f2-b4ad-1dabd5ff82af(jetbrains.mps.buildScript.structure)" version="-1" />
  <import index="ximz" modelUID="r:d3378a35-13da-49cb-8ad1-afbd30e88ad8(jetbrains.mps.ant.execution)" version="-1" />
  <import index="tpss" modelUID="r:00000000-0000-4000-0000-011c895904c0(jetbrains.mps.buildlanguage.behavior)" version="-1" />
  <import index="cu2c" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.smodel(MPS.Core/jetbrains.mps.smodel@java_stub)" version="-1" />
  <import index="9nge" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.generator.fileGenerator(MPS.Core/jetbrains.mps.generator.fileGenerator@java_stub)" version="-1" />
  <import index="59et" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.vfs(MPS.Core/jetbrains.mps.vfs@java_stub)" version="-1" />
  <import index="vsqj" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.project(MPS.Core/jetbrains.mps.project@java_stub)" version="-1" />
  <import index="eva" modelUID="r:a1b1112d-dd34-4046-a6a3-811fd290d232(jetbrains.mps.execution.configurations.pluginSolution.plugin)" version="-1" />
  <import index="tnlc" modelUID="r:14f06230-41df-42af-9a25-81de46539bf1(jetbrains.mps.build.workflow.accessories)" version="-1" />
  <import index="8xvf" modelUID="r:ed179f4d-7cf2-479d-8348-50c1fc63b96a(jetbrains.mps.build.workflow.structure)" version="0" />
  <import index="tpck" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <import index="uhxm" modelUID="r:f3383ae6-205a-4e7c-8dd9-c29966e29e49(jetbrains.mps.execution.configurations.structure)" version="0" implicit="yes" />
  <import index="tpee" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="-1" implicit="yes" />
  <import index="fb9u" modelUID="r:0194e190-08ef-44f6-ab95-d9cffdb7e27b(jetbrains.mps.execution.settings.structure)" version="0" implicit="yes" />
  <import index="tp4k" modelUID="r:00000000-0000-4000-0000-011c89590368(jetbrains.mps.lang.plugin.structure)" version="5" implicit="yes" />
  <import index="tp25" modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="-1" implicit="yes" />
  <import index="tp2c" modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" implicit="yes" />
  <import index="tp4f" modelUID="r:00000000-0000-4000-0000-011c89590373(jetbrains.mps.baseLanguage.classifiers.structure)" version="0" implicit="yes" />
  <import index="rzqf" modelUID="r:d78df0bb-be4f-4e0d-8142-c0b2df70a5a3(jetbrains.mps.execution.commands.structure)" version="-1" implicit="yes" />
  <import index="tp2q" modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" implicit="yes" />
  <roots>
    <node type="uhxm.RunConfiguration" typeId="uhxm.2401501559171345993" id="4468328282078607076">
      <property name="name" nameId="tpck.1169194664001" value="Build Script" />
      <link role="configurationKind" roleId="uhxm.2401501559171353314" targetNodeId="4468328282078639071" resolveInfo="Build Script" />
    </node>
    <node type="uhxm.RunConfigurationKind" typeId="uhxm.2401501559171345994" id="4468328282078639071">
      <property name="name" nameId="tpck.1169194664001" value="Build Script" />
    </node>
    <node type="uhxm.RunConfigurationExecutor" typeId="uhxm.7806358006983614956" id="4468328282078708516">
      <property name="canRun" nameId="uhxm.5925077313451868299" value="true" />
      <property name="configurationName" nameId="uhxm.1931462339887551644" value="myRunConfiguration" />
      <link role="configuration" roleId="fb9u.946964771156905618" targetNodeId="4468328282078607076" resolveInfo="Build Script" />
    </node>
    <node type="uhxm.RunConfigurationProducer" typeId="uhxm.4366236229294105349" id="3767587139140991018" />
  </roots>
  <root id="4468328282078607076">
    <node role="editor" roleId="uhxm.3754890006475816675" type="fb9u.SettingsEditor" typeId="fb9u.946964771156066621" id="4468328282078607077">
      <node role="createEditor" roleId="fb9u.946964771156066622" type="fb9u.CreateEditor_Function" typeId="fb9u.946964771156066566" id="4468328282078607078">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4468328282078607079">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4468328282078706034">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4468328282078706042">
              <node role="operand" roleId="tpee.1197027771414" type="fb9u.EditorExpression" typeId="fb9u.946964771156066588" id="4468328282078706035">
                <link role="persistentPropertyDeclaration" roleId="fb9u.946964771156066589" targetNodeId="4468328282078641627" resolveInfo="myNode" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="fb9u.EditorOperationCall" typeId="fb9u.946964771156066606" id="4468328282078708450">
                <link role="editorOperationDeclaration" roleId="fb9u.946964771156066609" targetNodeId="awpe.1977878056377381441" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="resetFrom" roleId="fb9u.946964771156066624" type="fb9u.ResetFrom_Function" typeId="fb9u.946964771156066614" id="4468328282078708452">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4468328282078708453">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4468328282078708455">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4468328282078708463">
              <node role="operand" roleId="tpee.1197027771414" type="fb9u.EditorExpression" typeId="fb9u.946964771156066588" id="4468328282078708456">
                <link role="persistentPropertyDeclaration" roleId="fb9u.946964771156066589" targetNodeId="4468328282078641627" resolveInfo="myNode" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="fb9u.EditorOperationCall" typeId="fb9u.946964771156066606" id="4468328282078708471">
                <link role="editorOperationDeclaration" roleId="fb9u.946964771156066609" targetNodeId="awpe.1977878056377381460" />
                <node role="arguments" roleId="fb9u.946964771156066607" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4468328282078708476">
                  <node role="operand" roleId="tpee.1197027771414" type="fb9u.Configuration_Parameter" typeId="fb9u.946964771156067216" id="4468328282078708473" />
                  <node role="operation" roleId="tpee.1197027833540" type="fb9u.PersistentPropertyReferenceOperation" typeId="fb9u.946964771156066574" id="4468328282078708481">
                    <link role="variableDeclaration" roleId="fb9u.946964771156066575" targetNodeId="4468328282078641627" resolveInfo="myNode" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="applyTo" roleId="fb9u.946964771156066623" type="fb9u.ApplyTo_Function" typeId="fb9u.946964771156066601" id="4468328282078708482">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4468328282078708483">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4468328282078708486">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4468328282078708494">
              <node role="operand" roleId="tpee.1197027771414" type="fb9u.EditorExpression" typeId="fb9u.946964771156066588" id="4468328282078708487">
                <link role="persistentPropertyDeclaration" roleId="fb9u.946964771156066589" targetNodeId="4468328282078641627" resolveInfo="myNode" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="fb9u.EditorOperationCall" typeId="fb9u.946964771156066606" id="4468328282078708503">
                <link role="editorOperationDeclaration" roleId="fb9u.946964771156066609" targetNodeId="awpe.1977878056377381469" />
                <node role="arguments" roleId="fb9u.946964771156066607" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4468328282078708510">
                  <node role="operand" roleId="tpee.1197027771414" type="fb9u.Configuration_Parameter" typeId="fb9u.946964771156067216" id="4468328282078708507" />
                  <node role="operation" roleId="tpee.1197027833540" type="fb9u.PersistentPropertyReferenceOperation" typeId="fb9u.946964771156066574" id="4468328282078708515">
                    <link role="variableDeclaration" roleId="fb9u.946964771156066575" targetNodeId="4468328282078641627" resolveInfo="myNode" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="icon" roleId="uhxm.4763274727405873310" type="tp4k.IconResource" typeId="tp4k.2330114057060456691" id="4468328282078607080" />
    <node role="persistentProperty" roleId="fb9u.946964771156066595" type="fb9u.PersistentPropertyDeclaration" typeId="fb9u.946964771156066585" id="4468328282078641627">
      <property name="name" nameId="tpck.1169194664001" value="myNode" />
      <node role="type" roleId="tpee.5680397130376446158" type="fb9u.TemplatePersistentConfigurationType" typeId="fb9u.946964771156066557" id="4468328282078642020">
        <link role="persistentConfiguration" roleId="fb9u.946964771156066333" targetNodeId="awpe.1977878056377381335" resolveInfo="Node" />
      </node>
      <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="4468328282078647158">
        <node role="creator" roleId="tpee.1145553007750" type="fb9u.PersistentConfigurationTemplateInitializer" typeId="fb9u.946964771156066582" id="4468328282078668057">
          <link role="template" roleId="fb9u.946964771156066583" targetNodeId="awpe.1977878056377381335" resolveInfo="Node" />
          <node role="parameter" roleId="fb9u.946964771156066584" type="tp25.ReadConceptReferenceExpression" typeId="tp25.448792706993295611" id="4468328282078706026">
            <link role="conceptDeclaration" roleId="tp25.448792706993295615" targetNodeId="3ior.5617550519002745363" resolveInfo="BuildProject" />
          </node>
          <node role="parameter" roleId="fb9u.946964771156066584" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="4468328282078706028">
            <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="4468328282078706029">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4468328282078706032">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="4468328282078706033">
                  <property name="value" nameId="tpee.1068580123138" value="true" />
                </node>
              </node>
            </node>
            <node role="parameter" roleId="tp2c.1199569906740" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="4468328282078706030">
              <property name="name" nameId="tpck.1169194664001" value="node" />
              <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4468328282078706031" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </root>
  <root id="4468328282078639071">
    <node role="icon" roleId="uhxm.7966814097310618131" type="tp4k.IconResource" typeId="tp4k.2330114057060456691" id="4468328282078639072" />
  </root>
  <root id="4468328282078708516">
    <node role="execute" roleId="uhxm.7945003362267213473" type="uhxm.ExecuteConfiguration_Function" typeId="uhxm.6139196002333163564" id="4468328282078708517">
      <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4468328282078708518">
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="352677614185351913">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="352677614185351914">
            <property name="name" nameId="tpck.1169194664001" value="file" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="352677614185351915">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="59et.~IFile" resolveInfo="IFile" />
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3767587139140990991">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3767587139140990992">
            <property name="name" nameId="tpck.1169194664001" value="mainTaskName" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="3767587139140990993" />
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tp4k.ExecuteLightweightCommandStatement" typeId="tp4k.1225441341971" id="352677614185351916">
          <node role="commandClosureLiteral" roleId="tp4k.1225441160167" type="tp4k.CommandClosureLiteral" typeId="tp4k.1225441216717" id="352677614185351917">
            <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="352677614185351918">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3767587139140987198">
                <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3767587139140987199">
                  <property name="name" nameId="tpck.1169194664001" value="node" />
                  <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="3767587139140987200">
                    <link role="concept" roleId="tp25.1138405853777" targetNodeId="3ior.5617550519002745363" resolveInfo="BuildProject" />
                  </node>
                  <node role="initializer" roleId="tpee.1068431790190" type="tp25.SNodeTypeCastExpression" typeId="tp25.1140137987495" id="3767587139140987228">
                    <link role="concept" roleId="tp25.1140138128738" targetNodeId="3ior.5617550519002745363" resolveInfo="BuildProject" />
                    <node role="leftExpression" roleId="tp25.1140138123956" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140987201">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140987202">
                        <node role="operand" roleId="tpee.1197027771414" type="uhxm.ConfigurationFromExecutorReference" typeId="uhxm.7806358006983738927" id="3767587139140987203" />
                        <node role="operation" roleId="tpee.1197027833540" type="fb9u.PersistentPropertyReferenceOperation" typeId="fb9u.946964771156066574" id="3767587139140987204">
                          <link role="variableDeclaration" roleId="fb9u.946964771156066575" targetNodeId="4468328282078641627" resolveInfo="myNode" />
                        </node>
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp4f.DefaultClassifierMethodCallOperation" typeId="tp4f.1205769149993" id="3767587139140987205">
                        <link role="member" roleId="tp4f.1205756909548" targetNodeId="awpe.1977878056377381336" resolveInfo="getNode" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="352677614185351919">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="352677614185351920">
                  <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="352677614185351921">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="352677614185351914" resolveInfo="file" />
                  </node>
                  <node role="rValue" roleId="tpee.1068498886297" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="352677614185351922">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="9nge.~FileGenerationUtil%dgetDefaultOutputDir(jetbrains%dmps%dsmodel%dSModel,jetbrains%dmps%dvfs%dIFile)%cjetbrains%dmps%dvfs%dIFile" resolveInfo="getDefaultOutputDir" />
                    <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="9nge.~FileGenerationUtil" resolveInfo="FileGenerationUtil" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351923">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139140987211">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139140987199" resolveInfo="node" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetModelOperation" typeId="tp25.1143234257716" id="352677614185351925" />
                    </node>
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351926">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="352677614185351927">
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="59et.~FileSystem" resolveInfo="FileSystem" />
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="59et.~FileSystem%dgetInstance()%cjetbrains%dmps%dvfs%dFileSystem" resolveInfo="getInstance" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="352677614185351928">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="59et.~FileSystem%dgetFileByPath(java%dlang%dString)%cjetbrains%dmps%dvfs%dIFile" resolveInfo="getFileByPath" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351929">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351930">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351931">
                              <node role="operand" roleId="tpee.1197027771414" type="tp25.SemanticDowncastExpression" typeId="tp25.1145404486709" id="352677614185351932">
                                <node role="leftExpression" roleId="tp25.1145404616321" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351933">
                                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetModelOperation" typeId="tp25.1143234257716" id="352677614185351935" />
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139140987214">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139140987199" resolveInfo="node" />
                                  </node>
                                </node>
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="352677614185351936">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="cu2c.~SModel%dgetModelDescriptor()%cjetbrains%dmps%dsmodel%dSModelDescriptor" resolveInfo="getModelDescriptor" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="352677614185351937">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="cu2c.~SModelDescriptor%dgetModule()%cjetbrains%dmps%dproject%dIModule" resolveInfo="getModule" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="352677614185351938">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="vsqj.~IModule%dgetGeneratorOutputPath()%cjava%dlang%dString" resolveInfo="getGeneratorOutputPath" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.SingleLineComment" typeId="tpee.6329021646629104954" id="3767587139140990905">
                <node role="commentPart" roleId="tpee.6329021646629175155" type="tpee.TextCommentPart" typeId="tpee.6329021646629104957" id="3767587139140990906">
                  <property name="text" nameId="tpee.6329021646629104958" value="todo" />
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="352677614185351939">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="352677614185351940">
                  <node role="rValue" roleId="tpee.1068498886297" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351941">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="352677614185351942">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="352677614185351914" resolveInfo="file" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="352677614185351943">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="59et.~IFile%dgetDescendant(java%dlang%dString)%cjetbrains%dmps%dvfs%dIFile" resolveInfo="getDescendant" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="3767587139140990900">
                        <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3767587139140990903">
                          <property name="value" nameId="tpee.1070475926801" value=".xml" />
                        </node>
                        <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140987220">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139140987217">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139140987199" resolveInfo="node" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="3767587139140987232">
                            <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="352677614185351947">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="352677614185351914" resolveInfo="file" />
                  </node>
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.SingleLineComment" typeId="tpee.6329021646629104954" id="3767587139140991016">
                <node role="commentPart" roleId="tpee.6329021646629175155" type="tpee.TextCommentPart" typeId="tpee.6329021646629104957" id="3767587139140991017">
                  <property name="text" nameId="tpee.6329021646629104958" value="todo select task" />
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3767587139140991012">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="3767587139140991013">
                  <node role="rValue" roleId="tpee.1068498886297" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140990994">
                    <node role="operand" roleId="tpee.1197027771414" type="tp25.SNodeTypeCastExpression" typeId="tp25.1140137987495" id="3767587139140990995">
                      <link role="concept" roleId="tp25.1140138128738" targetNodeId="8xvf.2769948622284546675" resolveInfo="BwfTask" />
                      <node role="leftExpression" roleId="tp25.1140138123956" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140990996">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140990997">
                          <node role="operand" roleId="tpee.1197027771414" type="tp25.NodeRefExpression" typeId="tp25.1219352745532" id="3767587139140990998">
                            <link role="referentNode" roleId="tp25.1219352800908" targetNodeId="tnlc.7306485738221408315" resolveInfo="common" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="3767587139140990999">
                            <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.7306485738221391508" />
                          </node>
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tp2q.FindFirstOperation" typeId="tp2q.1225727723840" id="3767587139140991000">
                          <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="3767587139140991001">
                            <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="3767587139140991002">
                              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3767587139140991003">
                                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140991004">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="3767587139140991005">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139140991008" resolveInfo="it" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_IsInstanceOfOperation" typeId="tp25.1139621453865" id="3767587139140991006">
                                    <node role="conceptArgument" roleId="tp25.1177027386292" type="tp25.RefConcept_Reference" typeId="tp25.1177026924588" id="3767587139140991007">
                                      <link role="conceptDeclaration" roleId="tp25.1177026940964" targetNodeId="8xvf.2769948622284546675" resolveInfo="BwfTask" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                            </node>
                            <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="3767587139140991008">
                              <property name="name" nameId="tpck.1169194664001" value="it" />
                              <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="3767587139140991009" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="3767587139140991010">
                      <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
                    </node>
                  </node>
                  <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139140991014">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139140990992" resolveInfo="mainTaskName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="uhxm.StartProcessHandlerStatement" typeId="uhxm.946964771156870353" id="4468328282078709742">
          <node role="expression" roleId="tpee.1068581517676" type="rzqf.CommandBuilderExpression" typeId="rzqf.856705193941281780" id="3767587139140948425">
            <link role="commandPart" roleId="rzqf.6129022259108621329" targetNodeId="ximz.352677614185351709" resolveInfo="ant" />
            <node role="argument" roleId="rzqf.856705193941281781" type="rzqf.CommandParameterAssignment" typeId="rzqf.856705193941281764" id="3767587139140948426">
              <link role="parameterDeclaration" roleId="rzqf.856705193941281765" targetNodeId="ximz.352677614185351771" resolveInfo="antFilePath" />
              <node role="value" roleId="rzqf.856705193941281766" type="tpee.DotExpression" typeId="tpee.1197027756228" id="352677614185351949">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="352677614185351950">
                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="352677614185351914" resolveInfo="file" />
                </node>
                <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="352677614185351951">
                  <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="59et.~IFile%dgetPath()%cjava%dlang%dString" resolveInfo="getPath" />
                </node>
              </node>
            </node>
            <node role="argument" roleId="rzqf.856705193941281781" type="rzqf.CommandParameterAssignment" typeId="rzqf.856705193941281764" id="3767587139140990907">
              <link role="parameterDeclaration" roleId="rzqf.856705193941281765" targetNodeId="ximz.352677614185351780" resolveInfo="targetName" />
              <node role="value" roleId="rzqf.856705193941281766" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139140991011">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139140990992" resolveInfo="mainTaskName" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="beforeTask" roleId="uhxm.6550182048787537895" type="uhxm.BeforeTaskCall" typeId="uhxm.6550182048787537880" id="3767587139140986969">
      <link role="beforeTask" roleId="uhxm.6550182048787537881" targetNodeId="eva.5487985028841950959" resolveInfo="MakeNodePointers" />
      <node role="parameter" roleId="uhxm.5475888311765521408" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="3767587139140987190">
        <node role="creator" roleId="tpee.1145553007750" type="tp2q.ListCreatorWithInit" typeId="tp2q.1160600644654" id="3767587139140987192">
          <node role="elementType" roleId="tp2q.1237721435807" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="3767587139140987194">
            <link role="classifier" roleId="tpee.1107535924139" targetNodeId="cu2c.~SNodePointer" resolveInfo="SNodePointer" />
          </node>
          <node role="initValue" roleId="tp2q.1237721435808" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140986987">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140986978">
              <node role="operand" roleId="tpee.1197027771414" type="uhxm.ConfigurationFromExecutorReference" typeId="uhxm.7806358006983738927" id="3767587139140986970" />
              <node role="operation" roleId="tpee.1197027833540" type="fb9u.PersistentPropertyReferenceOperation" typeId="fb9u.946964771156066574" id="3767587139140986983">
                <link role="variableDeclaration" roleId="fb9u.946964771156066575" targetNodeId="4468328282078641627" resolveInfo="myNode" />
              </node>
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tp4f.DefaultClassifierMethodCallOperation" typeId="tp4f.1205769149993" id="3767587139140986993">
              <link role="member" roleId="tp4f.1205756909548" targetNodeId="awpe.1977878056377381357" resolveInfo="getNodePointer" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </root>
  <root id="3767587139140991018">
    <node role="configuration" roleId="uhxm.4366236229294139631" type="fb9u.PersistentConfigurationType" typeId="fb9u.946964771156066332" id="3767587139140991019">
      <link role="persistentConfiguration" roleId="fb9u.946964771156066333" targetNodeId="4468328282078607076" resolveInfo="Build Script" />
    </node>
    <node role="produce" roleId="uhxm.4366236229294149036" type="uhxm.RunConfigurationProducerPart" typeId="uhxm.4366236229294149030" id="3767587139140991020">
      <node role="create" roleId="uhxm.3642991921657904774" type="uhxm.Create_ConceptFunction" typeId="uhxm.4366236229294149059" id="3767587139140991021">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3767587139140991022">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3767587139141004522">
            <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3767587139141004523">
              <property name="name" nameId="tpck.1169194664001" value="containingRoot" />
              <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="3767587139141004524" />
              <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139141004525">
                <node role="operand" roleId="tpee.1197027771414" type="uhxm.Source_ConceptFunctionParameter" typeId="uhxm.3642991921657904775" id="3767587139141004526" />
                <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetContainingRootOperation" typeId="tp25.1171310072040" id="3767587139141004527" />
              </node>
            </node>
          </node>
          <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="3767587139140991025">
            <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="3767587139140991027">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3767587139141004543">
                <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3767587139141004544">
                  <property name="name" nameId="tpck.1169194664001" value="configuration" />
                  <node role="type" roleId="tpee.5680397130376446158" type="fb9u.PersistentConfigurationType" typeId="fb9u.946964771156066332" id="3767587139141004545">
                    <link role="persistentConfiguration" roleId="fb9u.946964771156066333" targetNodeId="4468328282078607076" resolveInfo="Build Script" />
                  </node>
                  <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="3767587139141004546">
                    <node role="creator" roleId="tpee.1145553007750" type="uhxm.RunConfigurationCreator" typeId="uhxm.3642991921658122718" id="3767587139141004547">
                      <link role="configuration" roleId="uhxm.3642991921658122719" targetNodeId="4468328282078607076" resolveInfo="Build Script" />
                      <node role="configurationName" roleId="uhxm.529406319400385974" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139141004548">
                        <node role="operand" roleId="tpee.1197027771414" type="tp25.SNodeTypeCastExpression" typeId="tp25.1140137987495" id="3767587139141004549">
                          <link role="concept" roleId="tp25.1140138128738" targetNodeId="tpck.1169194658468" resolveInfo="INamedConcept" />
                          <node role="leftExpression" roleId="tp25.1140138123956" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139141004550">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139141004523" resolveInfo="containingRoot" />
                          </node>
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="3767587139141004551">
                          <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3767587139141004555">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139141019595">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139141004559">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139141004556">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139141004544" resolveInfo="configuration" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="fb9u.PersistentPropertyReferenceOperation" typeId="fb9u.946964771156066574" id="3767587139141004564">
                      <link role="variableDeclaration" roleId="fb9u.946964771156066575" targetNodeId="4468328282078641627" resolveInfo="myNode" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp4f.DefaultClassifierMethodCallOperation" typeId="tp4f.1205769149993" id="3767587139141019601">
                    <link role="member" roleId="tp4f.1205756909548" targetNodeId="awpe.1977878056377381385" resolveInfo="setNode" />
                    <node role="actualArgument" roleId="tp4f.1205770614681" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139141019602">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139141004523" resolveInfo="containingRoot" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="3767587139140991051">
                <node role="expression" roleId="tpee.1068581517676" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139141004552">
                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139141004544" resolveInfo="configuration" />
                </node>
              </node>
            </node>
            <node role="condition" roleId="tpee.1068580123160" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3767587139140991042">
              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3767587139141004528">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3767587139141004523" resolveInfo="containingRoot" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_IsInstanceOfOperation" typeId="tp25.1139621453865" id="3767587139140991048">
                <node role="conceptArgument" roleId="tp25.1177027386292" type="tp25.RefConcept_Reference" typeId="tp25.1177026924588" id="3767587139140991050">
                  <link role="conceptDeclaration" roleId="tp25.1177026940964" targetNodeId="3ior.5617550519002745363" resolveInfo="BuildProject" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="3767587139140991054">
            <node role="expression" roleId="tpee.1068581517676" type="tpee.NullLiteral" typeId="tpee.1070534058343" id="3767587139140991056" />
          </node>
        </node>
      </node>
      <node role="source" roleId="uhxm.7301162575811113551" type="uhxm.NodeSource" typeId="uhxm.7301162575811126385" id="3767587139140991024" />
    </node>
  </root>
</model>

