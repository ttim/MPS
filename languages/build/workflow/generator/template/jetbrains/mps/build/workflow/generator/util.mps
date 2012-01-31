<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:2b3dd9e8-e205-47a3-b3cc-ff31af700b6b(jetbrains.mps.build.workflow.generator.util)">
  <persistence version="7" />
  <language namespace="d7706f63-9be2-479c-a3da-ae92af1e64d5(jetbrains.mps.lang.generator.generationContext)" />
  <devkit namespace="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  <import index="xld7" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.make.dependencies.graph(MPS.Core/jetbrains.mps.make.dependencies.graph@java_stub)" version="-1" />
  <import index="k7g3" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.util(JDK/java.util@java_stub)" version="-1" />
  <import index="8xvf" modelUID="r:ed179f4d-7cf2-479d-8348-50c1fc63b96a(jetbrains.mps.build.workflow.structure)" version="-1" />
  <import index="tpee" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="-1" implicit="yes" />
  <import index="tpck" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" implicit="yes" />
  <import index="tp25" modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="-1" implicit="yes" />
  <import index="tp2c" modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" implicit="yes" />
  <import index="tp2q" modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" implicit="yes" />
  <import index="tpf3" modelUID="r:00000000-0000-4000-0000-011c895902f3(jetbrains.mps.lang.generator.generationContext.structure)" version="0" implicit="yes" />
  <import index="e2lb" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)" version="-1" implicit="yes" />
  <roots>
    <node type="tpee.ClassConcept" typeId="tpee.1068390468198" id="4755209551904406840">
      <property name="name" nameId="tpck.1169194664001" value="CycleHelper" />
    </node>
  </roots>
  <root id="4755209551904406840">
    <node role="staticInnerClassifiers" roleId="tpee.1178616825527" type="tpee.ClassConcept" typeId="tpee.1068390468198" id="4755209551904421660">
      <property name="nonStatic" nameId="tpee.521412098689998745" value="true" />
      <property name="name" nameId="tpck.1169194664001" value="Module" />
      <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="4755209551904421666">
        <property name="name" nameId="tpck.1169194664001" value="module" />
        <property name="isFinal" nameId="tpee.1176718929932" value="true" />
        <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="4755209551904421667" />
        <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4755209551904421669">
          <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
        </node>
      </node>
      <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="7385586609667636793">
        <property name="name" nameId="tpck.1169194664001" value="targets" />
        <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="7385586609667636794" />
        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667636796">
          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~Set" resolveInfo="Set" />
          <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667636798">
            <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
          </node>
        </node>
      </node>
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="4755209551904421661" />
      <node role="constructor" roleId="tpee.1068390468201" type="tpee.ConstructorDeclaration" typeId="tpee.1068580123140" id="4755209551904421670">
        <node role="returnType" roleId="tpee.1068580123133" type="tpee.VoidType" typeId="tpee.1068581517677" id="4755209551904421671" />
        <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="4755209551904421672" />
        <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="4755209551904421674">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4755209551904421677">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="4755209551904421679">
              <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4755209551904421686">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.ThisExpression" typeId="tpee.1070475354124" id="4755209551904421689" />
                <node role="operation" roleId="tpee.1197027833540" type="tpee.FieldReferenceOperation" typeId="tpee.1197029447546" id="4755209551904421688">
                  <link role="fieldDeclaration" roleId="tpee.1197029500499" targetNodeId="4755209551904421666" resolveInfo="module" />
                </node>
              </node>
              <node role="rValue" roleId="tpee.1068498886297" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="4755209551904421683">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4755209551904421675" resolveInfo="module" />
              </node>
            </node>
          </node>
        </node>
        <node role="parameter" roleId="tpee.1068580123134" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="4755209551904421675">
          <property name="name" nameId="tpck.1169194664001" value="module" />
          <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4755209551904421676">
            <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
          </node>
        </node>
      </node>
      <node role="implementedInterface" roleId="tpee.1095933932569" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667505405">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="xld7.~IVertex" resolveInfo="IVertex" />
      </node>
      <node role="method" roleId="tpee.1107880067339" type="tpee.InstanceMethodDeclaration" typeId="tpee.1068580123165" id="7385586609667523574">
        <property name="isAbstract" nameId="tpee.1178608670077" value="false" />
        <property name="name" nameId="tpck.1169194664001" value="getNexts" />
        <property name="isFinal" nameId="tpee.1181808852946" value="false" />
        <property name="isDeprecated" nameId="tpee.1224848525476" value="false" />
        <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="7385586609667523575" />
        <node role="returnType" roleId="tpee.1068580123133" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667523576">
          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~Set" resolveInfo="Set" />
          <node role="parameter" roleId="tpee.1109201940907" type="tpee.UpperBoundType" typeId="tpee.1171903916106" id="7385586609667523577">
            <node role="bound" roleId="tpee.1171903916107" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667523578">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="xld7.~IVertex" resolveInfo="IVertex" />
            </node>
          </node>
        </node>
        <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667523579">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="7385586609667636800">
            <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636801">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="7385586609667636821">
                <node role="condition" roleId="tpee.1068580123160" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636837">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636827">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636824">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4755209551904421666" resolveInfo="module" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667636833">
                      <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389320" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp2q.IsEmptyOperation" typeId="tp2q.1165530316231" id="7385586609667636843" />
                </node>
                <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636823">
                  <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636844">
                    <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667636853">
                      <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636845">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636793" resolveInfo="targets" />
                      </node>
                      <node role="rValue" roleId="tpee.1068498886297" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7385586609667636857">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Collections%demptySet()%cjava%dutil%dSet" resolveInfo="emptySet" />
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="k7g3.~Collections" resolveInfo="Collections" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifFalseStatement" roleId="tpee.1082485599094" type="tpee.BlockStatement" typeId="tpee.1082485599095" id="7385586609667636858">
                  <node role="statements" roleId="tpee.1082485599096" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636859">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636860">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667636862">
                        <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636861">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636793" resolveInfo="targets" />
                        </node>
                        <node role="rValue" roleId="tpee.1068498886297" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667636865">
                          <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667636869">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~HashSet%d&lt;init&gt;()" resolveInfo="HashSet" />
                            <node role="typeParameter" roleId="tpee.1212687122400" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667636871">
                              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667636873">
                      <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636874">
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667638337">
                          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667638338">
                            <property name="name" nameId="tpck.1169194664001" value="tm" />
                            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638339">
                              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                            </node>
                            <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667638340">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667638341">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667523582" resolveInfo="map" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667638342">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Map%dget(java%dlang%dObject)%cjava%dlang%dObject" resolveInfo="get" />
                                <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667638343">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638344">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636876" resolveInfo="ref" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="7385586609667638345">
                                    <link role="link" roleId="tp25.1138056516764" targetNodeId="8xvf.4755209551904389317" />
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="7385586609667638348">
                          <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667638349">
                            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667638373">
                              <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667638377">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667638374">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636891" resolveInfo="genContext" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tpf3.GenerationContextOp_ShowErrorMessage" typeId="tpf3.1217960179967" id="7385586609667638383">
                                  <node role="messageText" roleId="tpf3.1217960314448" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667638385">
                                    <property name="value" nameId="tpee.1070475926801" value="internal problem: unsatisfied local dependency" />
                                  </node>
                                  <node role="referenceNode" roleId="tpf3.1217960407512" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638386">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636876" resolveInfo="ref" />
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="condition" roleId="tpee.1068580123160" type="tpee.EqualsExpression" typeId="tpee.1068580123152" id="7385586609667638369">
                            <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.NullLiteral" typeId="tpee.1070534058343" id="7385586609667638372" />
                            <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638352">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638338" resolveInfo="tm" />
                            </node>
                          </node>
                          <node role="ifFalseStatement" roleId="tpee.1082485599094" type="tpee.BlockStatement" typeId="tpee.1082485599095" id="7385586609667638387">
                            <node role="statements" roleId="tpee.1082485599096" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667638388">
                              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667638389">
                                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667638393">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667638390">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636793" resolveInfo="targets" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667638401">
                                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Set%dadd(java%dlang%dObject)%cboolean" resolveInfo="add" />
                                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638403">
                                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638338" resolveInfo="tm" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667636876">
                        <property name="name" nameId="tpck.1169194664001" value="ref" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667636878">
                          <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389316" resolveInfo="BwfJavaModuleReference" />
                        </node>
                      </node>
                      <node role="iterable" roleId="tpee.1144226360166" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636882">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636879">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4755209551904421666" resolveInfo="module" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667636887">
                          <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389320" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition" roleId="tpee.1068580123160" type="tpee.EqualsExpression" typeId="tpee.1068580123152" id="7385586609667636807">
              <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.NullLiteral" typeId="tpee.1070534058343" id="7385586609667636810" />
              <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636804">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636793" resolveInfo="targets" />
              </node>
            </node>
          </node>
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636812">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636813">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636793" resolveInfo="targets" />
            </node>
          </node>
        </node>
      </node>
      <node role="method" roleId="tpee.1107880067339" type="tpee.InstanceMethodDeclaration" typeId="tpee.1068580123165" id="7385586609667638459">
        <property name="name" nameId="tpck.1169194664001" value="getModule" />
        <node role="returnType" roleId="tpee.1068580123133" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667638460">
          <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
        </node>
        <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="7385586609667638461" />
        <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667638462">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667638463">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667638464">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4755209551904421666" resolveInfo="module" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method" roleId="tpee.1107880067339" type="tpee.InstanceMethodDeclaration" typeId="tpee.1068580123165" id="4755209551904411819">
      <property name="name" nameId="tpck.1169194664001" value="processCycles" />
      <node role="returnType" roleId="tpee.1068580123133" type="tpee.VoidType" typeId="tpee.1068581517677" id="4755209551904411820" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="4755209551904411821" />
      <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="4755209551904411822">
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667605170">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667605171">
            <property name="name" nameId="tpck.1169194664001" value="modules" />
            <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeListType" typeId="tp25.1145383075378" id="7385586609667605172">
              <link role="elementConcept" roleId="tp25.1145383142433" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
            </node>
            <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667605174">
              <node role="creator" roleId="tpee.1145553007750" type="tp25.SNodeListCreator" typeId="tp25.1145567426890" id="7385586609667605176">
                <node role="createdType" roleId="tp25.1145567471833" type="tp25.SNodeListType" typeId="tp25.1145383075378" id="7385586609667605177">
                  <link role="elementConcept" roleId="tp25.1145383142433" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667638407">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667638408">
            <property name="name" nameId="tpck.1169194664001" value="graph" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638409">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="xld7.~Graph" resolveInfo="Graph" />
              <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638411">
                <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
              </node>
            </node>
            <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667638413">
              <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667638415">
                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="xld7.~Graph%d&lt;init&gt;()" resolveInfo="Graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667605180">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667605184">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667605181">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667605171" resolveInfo="modules" />
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tp2q.AddAllElementsOperation" typeId="tp2q.1160666733551" id="7385586609667605190">
              <node role="argument" roleId="tp2q.1160666822012" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636739">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636707">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667605195">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667605192">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4755209551904406846" resolveInfo="project" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667636703">
                      <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.2769948622284574304" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp2q.WhereOperation" typeId="tp2q.1202120902084" id="7385586609667636713">
                    <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="7385586609667636714">
                      <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636715">
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636718">
                          <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636722">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667636719">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636716" resolveInfo="it" />
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_IsInstanceOfOperation" typeId="tp25.1139621453865" id="7385586609667636733">
                              <node role="conceptArgument" roleId="tp25.1177027386292" type="tp25.RefConcept_Reference" typeId="tp25.1177026924588" id="7385586609667636735">
                                <link role="conceptDeclaration" roleId="tp25.1177026940964" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="7385586609667636716">
                        <property name="name" nameId="tpck.1169194664001" value="it" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="7385586609667636717" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="operation" roleId="tpee.1197027833540" type="tp2q.SelectOperation" typeId="tp2q.1202128969694" id="7385586609667636745">
                  <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="7385586609667636746">
                    <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636747">
                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636750">
                        <node role="expression" roleId="tpee.1068580123156" type="tp25.SNodeTypeCastExpression" typeId="tp25.1140137987495" id="7385586609667636754">
                          <link role="concept" roleId="tp25.1140138128738" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                          <node role="leftExpression" roleId="tp25.1140138123956" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667636751">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636748" resolveInfo="it" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="7385586609667636748">
                      <property name="name" nameId="tpck.1169194664001" value="it" />
                      <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="7385586609667636749" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667636757">
          <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667636758">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667638417">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667638418">
                <property name="name" nameId="tpck.1169194664001" value="module" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638419">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667638420">
                  <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667638421">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="4755209551904421670" resolveInfo="CycleHelper.Module" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638422">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636770">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636775">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667636771">
                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667523582" resolveInfo="map" />
                </node>
                <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667636781">
                  <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Map%dput(java%dlang%dObject,java%dlang%dObject)%cjava%dlang%dObject" resolveInfo="put" />
                  <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667636783">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                  </node>
                  <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638423">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638418" resolveInfo="module" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="7385586609667704273">
              <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667704274">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667704297">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704301">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667704298">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636891" resolveInfo="genContext" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpf3.GenerationContextOp_ShowErrorMessage" typeId="tpf3.1217960179967" id="7385586609667704308">
                      <node role="messageText" roleId="tpf3.1217960314448" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667704311">
                        <property name="value" nameId="tpee.1070475926801" value="empty output path" />
                      </node>
                      <node role="referenceNode" roleId="tpf3.1217960407512" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704310">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" roleId="tpee.1068580123160" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704289">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704280">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704277">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667704285">
                    <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.7385586609667649463" resolveInfo="outputFolder" />
                  </node>
                </node>
                <node role="operation" roleId="tpee.1197027833540" type="tpee.IsEmptyOperation" typeId="tpee.1225271369338" id="7385586609667704296" />
              </node>
              <node role="elsifClauses" roleId="tpee.1206060520071" type="tpee.ElsifClause" typeId="tpee.1206060495898" id="7385586609667704312">
                <node role="condition" roleId="tpee.1206060619838" type="tpee.OrExpression" typeId="tpee.1080223426719" id="7385586609667704336">
                  <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704351">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704342">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704339">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667704347">
                        <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.7385586609667649463" resolveInfo="outputFolder" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667704356">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dendsWith(java%dlang%dString)%cboolean" resolveInfo="endsWith" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667704358">
                        <property name="value" nameId="tpee.1070475926801" value="\\" />
                      </node>
                    </node>
                  </node>
                  <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704327">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704318">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704315">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667704323">
                        <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.7385586609667649463" resolveInfo="outputFolder" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667704332">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dendsWith(java%dlang%dString)%cboolean" resolveInfo="endsWith" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667704334">
                        <property name="value" nameId="tpee.1070475926801" value="/" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statementList" roleId="tpee.1206060644605" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667704314">
                  <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667704359">
                    <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704360">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667704361">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636891" resolveInfo="genContext" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tpf3.GenerationContextOp_ShowErrorMessage" typeId="tpf3.1217960179967" id="7385586609667704362">
                        <node role="messageText" roleId="tpf3.1217960314448" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667704363">
                          <property name="value" nameId="tpee.1070475926801" value="output path shouldn't end with slash" />
                        </node>
                        <node role="referenceNode" roleId="tpf3.1217960407512" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704364">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636760" resolveInfo="jm" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667636760">
            <property name="name" nameId="tpck.1169194664001" value="jm" />
            <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667636762">
              <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
            </node>
          </node>
          <node role="iterable" roleId="tpee.1144226360166" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667636764">
            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667605171" resolveInfo="modules" />
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667648749">
          <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667648750">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667638424">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667638428">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638425">
                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638408" resolveInfo="graph" />
                </node>
                <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667638434">
                  <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="xld7.~Graph%dadd(jetbrains%dmps%dmake%ddependencies%dgraph%dIVertex)%cvoid" resolveInfo="add" />
                  <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667648768">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667648752" resolveInfo="module" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667648752">
            <property name="name" nameId="tpck.1169194664001" value="module" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667648756">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
            </node>
          </node>
          <node role="iterable" roleId="tpee.1144226360166" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667648760">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="7385586609667648757">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667523582" resolveInfo="map" />
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667648766">
              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Map%dvalues()%cjava%dutil%dCollection" resolveInfo="values" />
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667638442">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667638443">
            <property name="name" nameId="tpck.1169194664001" value="cycles" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638444">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~List" resolveInfo="List" />
              <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638445">
                <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~List" resolveInfo="List" />
                <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638446">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                </node>
              </node>
            </node>
            <node role="initializer" roleId="tpee.1068431790190" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7385586609667638447">
              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="xld7.~Graphs%dfindStronglyConnectedComponents(jetbrains%dmps%dmake%ddependencies%dgraph%dGraph)%cjava%dutil%dList" resolveInfo="findStronglyConnectedComponents" />
              <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="xld7.~Graphs" resolveInfo="Graphs" />
              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638448">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638408" resolveInfo="graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667638486">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7385586609667638488">
            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Collections%dreverse(java%dutil%dList)%cvoid" resolveInfo="reverse" />
            <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="k7g3.~Collections" resolveInfo="Collections" />
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638489">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638443" resolveInfo="cycles" />
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667638466">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667638467">
            <property name="name" nameId="tpck.1169194664001" value="cycleCounter" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.IntegerType" typeId="tpee.1070534370425" id="7385586609667638468" />
            <node role="initializer" roleId="tpee.1068431790190" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="7385586609667638470">
              <property name="value" nameId="tpee.1068580320021" value="0" />
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667638491">
          <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667638492">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="7385586609667638501">
              <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667638502">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ContinueStatement" typeId="tpee.1082113931046" id="7385586609667640358" />
              </node>
              <node role="condition" roleId="tpee.1068580123160" type="tpee.LessThanExpression" typeId="tpee.1081506773034" id="7385586609667640354">
                <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667638508">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638505">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638494" resolveInfo="cycle" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667638514">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~List%dsize()%cint" resolveInfo="size" />
                  </node>
                </node>
                <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="7385586609667640357">
                  <property name="value" nameId="tpee.1068580320021" value="2" />
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="7385586609667640359" />
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667704127">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7385586609667704129">
                <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="k7g3.~Collections" resolveInfo="Collections" />
                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Collections%dsort(java%dutil%dList,java%dutil%dComparator)%cvoid" resolveInfo="sort" />
                <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704130">
                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638494" resolveInfo="cycle" />
                </node>
                <node role="actualArgument" roleId="tpee.1068499141038" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="7385586609667704132">
                  <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667704133">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667704134">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704197">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667704190">
                          <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667704192">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Integer%d&lt;init&gt;(int)" resolveInfo="Integer" />
                            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704170">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704161">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667704158">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667704138" resolveInfo="m1" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667704167">
                                  <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7385586609667638459" resolveInfo="getModule" />
                                </node>
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetIndexInParentOperation" typeId="tp25.1179168000618" id="7385586609667704176" />
                            </node>
                          </node>
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667704202">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Integer%dcompareTo(java%dlang%dInteger)%cint" resolveInfo="compareTo" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704221">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704211">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667704207">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667704141" resolveInfo="m2" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667704217">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7385586609667638459" resolveInfo="getModule" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetIndexInParentOperation" typeId="tp25.1179168000618" id="7385586609667704227" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="parameter" roleId="tp2c.1199569906740" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="7385586609667704138">
                    <property name="name" nameId="tpck.1169194664001" value="m1" />
                    <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667704140">
                      <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                    </node>
                  </node>
                  <node role="parameter" roleId="tp2c.1199569906740" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="7385586609667704141">
                    <property name="name" nameId="tpck.1169194664001" value="m2" />
                    <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667704143">
                      <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640361">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640362">
                <property name="name" nameId="tpck.1169194664001" value="first" />
                <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667640363">
                  <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640379">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640368">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640365">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638494" resolveInfo="cycle" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667640373">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~List%dget(int)%cjava%dlang%dObject" resolveInfo="get" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="7385586609667640376">
                        <property name="value" nameId="tpee.1068580320021" value="0" />
                      </node>
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667640385">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7385586609667638459" resolveInfo="getModule" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640757">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640758">
                <property name="name" nameId="tpck.1169194664001" value="model" />
                <node role="type" roleId="tpee.5680397130376446158" type="tp25.SModelType" typeId="tp25.1143226024141" id="7385586609667640759" />
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640760">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640761">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640362" resolveInfo="first" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_GetModelOperation" typeId="tp25.1143234257716" id="7385586609667640762" />
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640399">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640400">
                <property name="name" nameId="tpck.1169194664001" value="cycleX" />
                <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667640401">
                  <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640415">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640763">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640758" resolveInfo="model" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Model_CreateNewNodeOperation" typeId="tp25.1143235216708" id="7385586609667640421">
                    <link role="concept" roleId="tp25.1143235391024" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640424">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667640437">
                <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640428">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640425">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640400" resolveInfo="cycleX" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667640433">
                    <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
                  </node>
                </node>
                <node role="rValue" roleId="tpee.1068498886297" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="7385586609667640443">
                  <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667640440">
                    <property name="value" nameId="tpee.1070475926801" value="java.modules.cycle." />
                  </node>
                  <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.PrefixIncrementExpression" typeId="tpee.1239709250944" id="7385586609667640454">
                    <node role="expression" roleId="tpee.1239714902950" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640450">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638467" resolveInfo="cycleCounter" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667704231">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667704241">
                <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704235">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704232">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640400" resolveInfo="cycleX" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667704240">
                    <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.7385586609667649463" resolveInfo="outputFolder" />
                  </node>
                </node>
                <node role="rValue" roleId="tpee.1068498886297" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="7385586609667704263">
                  <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667704247">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667704244">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640362" resolveInfo="first" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667704252">
                      <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.7385586609667649463" resolveInfo="outputFolder" />
                    </node>
                  </node>
                  <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7385586609667704266">
                    <property name="value" nameId="tpee.1070475926801" value=".cycle" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640386">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640390">
                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640387">
                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640362" resolveInfo="first" />
                </node>
                <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_InsertPrevSiblingOperation" typeId="tp25.1143224127713" id="7385586609667640396">
                  <node role="insertedNode" roleId="tp25.1143224127716" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640422">
                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640400" resolveInfo="cycleX" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640613">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640614">
                <property name="name" nameId="tpck.1169194664001" value="sources" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640615">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~Set" resolveInfo="Set" />
                  <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640618">
                    <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~String" resolveInfo="String" />
                  </node>
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667640620">
                  <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667640622">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~HashSet%d&lt;init&gt;()" resolveInfo="HashSet" />
                    <node role="typeParameter" roleId="tpee.1212687122400" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640624">
                      <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~String" resolveInfo="String" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640705">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640706">
                <property name="name" nameId="tpck.1169194664001" value="classpath" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640707">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~Set" resolveInfo="Set" />
                  <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640708">
                    <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~String" resolveInfo="String" />
                  </node>
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667640709">
                  <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667640710">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~HashSet%d&lt;init&gt;()" resolveInfo="HashSet" />
                    <node role="typeParameter" roleId="tpee.1212687122400" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640711">
                      <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~String" resolveInfo="String" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667640459">
              <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667640460">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640485">
                  <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640486">
                    <property name="name" nameId="tpck.1169194664001" value="module" />
                    <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667640487">
                      <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389307" resolveInfo="BwfJavaModule" />
                    </node>
                    <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640488">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640489">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640462" resolveInfo="m" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667640490">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7385586609667638459" resolveInfo="getModule" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640468">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640504">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640494">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640491">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640486" resolveInfo="module" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667640500">
                        <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389320" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp2q.RemoveWhereOperation" typeId="tp2q.3055999550620853964" id="7385586609667640510">
                      <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="7385586609667640511">
                        <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667640512">
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640515">
                            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640519">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640516">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638494" resolveInfo="cycle" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667640525">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~List%dcontains(java%dlang%dObject)%cboolean" resolveInfo="contains" />
                                <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640531">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667640527">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640513" resolveInfo="it" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="7385586609667640538">
                                    <link role="link" roleId="tp25.1138056516764" targetNodeId="8xvf.4755209551904389317" />
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="7385586609667640513">
                          <property name="name" nameId="tpck.1169194664001" value="it" />
                          <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="7385586609667640514" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640568">
                  <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640569">
                    <property name="name" nameId="tpck.1169194664001" value="mref" />
                    <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667640570">
                      <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389316" resolveInfo="BwfJavaModuleReference" />
                    </node>
                    <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640584">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640764">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640758" resolveInfo="model" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.Model_CreateNewNodeOperation" typeId="tp25.1143235216708" id="7385586609667640589">
                        <link role="concept" roleId="tp25.1143235391024" targetNodeId="8xvf.4755209551904389316" resolveInfo="BwfJavaModuleReference" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640591">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667640604">
                    <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640595">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640592">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640569" resolveInfo="mref" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="7385586609667640600">
                        <link role="link" roleId="tp25.1138056516764" targetNodeId="8xvf.4755209551904389317" />
                      </node>
                    </node>
                    <node role="rValue" roleId="tpee.1068498886297" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640607">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640400" resolveInfo="cycleX" />
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640540">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640553">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640544">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640541">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640486" resolveInfo="module" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667640549">
                        <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389320" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp2q.AddElementOperation" typeId="tp2q.1160612413312" id="7385586609667640559">
                      <node role="argument" roleId="tp2q.1160612519549" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640608">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640569" resolveInfo="mref" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640625">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640629">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640626">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640614" resolveInfo="sources" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667640634">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Set%daddAll(java%dutil%dCollection)%cboolean" resolveInfo="addAll" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640696">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640671">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640644">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640640">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640486" resolveInfo="module" />
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667640650">
                              <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389313" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp2q.SelectOperation" typeId="tp2q.1202128969694" id="7385586609667640677">
                            <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="7385586609667640678">
                              <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667640679">
                                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640682">
                                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640686">
                                    <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667640683">
                                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640680" resolveInfo="it" />
                                    </node>
                                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667640691">
                                      <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.4755209551904389309" resolveInfo="path" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                              <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="7385586609667640680">
                                <property name="name" nameId="tpck.1169194664001" value="it" />
                                <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="7385586609667640681" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tp2q.ToListOperation" typeId="tp2q.1151702311717" id="7385586609667640704" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640712">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640713">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640731">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640706" resolveInfo="classpath" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7385586609667640715">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Set%daddAll(java%dutil%dCollection)%cboolean" resolveInfo="addAll" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640716">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640717">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640718">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640719">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640486" resolveInfo="module" />
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667640733">
                              <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389314" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp2q.SelectOperation" typeId="tp2q.1202128969694" id="7385586609667640721">
                            <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="7385586609667640722">
                              <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667640723">
                                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640724">
                                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640725">
                                    <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667640726">
                                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640728" resolveInfo="it" />
                                    </node>
                                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667640727">
                                      <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.4755209551904389309" resolveInfo="path" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                              <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="7385586609667640728">
                                <property name="name" nameId="tpck.1169194664001" value="it" />
                                <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="7385586609667640729" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tp2q.ToListOperation" typeId="tp2q.1151702311717" id="7385586609667640730" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640462">
                <property name="name" nameId="tpck.1169194664001" value="m" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667640466">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
                </node>
              </node>
              <node role="iterable" roleId="tpee.1144226360166" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640467">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638494" resolveInfo="cycle" />
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667640744">
              <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667640745">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640753">
                  <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640754">
                    <property name="name" nameId="tpck.1169194664001" value="path" />
                    <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667640755">
                      <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389308" resolveInfo="BwfPath" />
                    </node>
                    <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640768">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640765">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640758" resolveInfo="model" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.Model_CreateNewNodeOperation" typeId="tp25.1143235216708" id="7385586609667640773">
                        <link role="concept" roleId="tp25.1143235391024" targetNodeId="8xvf.4755209551904389308" resolveInfo="BwfPath" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640775">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667640789">
                    <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640779">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640776">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640754" resolveInfo="path" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667640785">
                        <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.4755209551904389309" resolveInfo="path" />
                      </node>
                    </node>
                    <node role="rValue" roleId="tpee.1068498886297" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640793">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640747" resolveInfo="src" />
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640795">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640810">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640799">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640796">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640400" resolveInfo="cycleX" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667640806">
                        <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389313" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp2q.AddElementOperation" typeId="tp2q.1160612413312" id="7385586609667640816">
                      <node role="argument" roleId="tp2q.1160612519549" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640818">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640754" resolveInfo="path" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640747">
                <property name="name" nameId="tpck.1169194664001" value="src" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="7385586609667640751" />
              </node>
              <node role="iterable" roleId="tpee.1144226360166" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640752">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640614" resolveInfo="sources" />
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ForeachStatement" typeId="tpee.1144226303539" id="7385586609667640819">
              <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="7385586609667640820">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7385586609667640821">
                  <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640822">
                    <property name="name" nameId="tpck.1169194664001" value="path" />
                    <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667640823">
                      <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.4755209551904389308" resolveInfo="BwfPath" />
                    </node>
                    <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640824">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640825">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640758" resolveInfo="model" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.Model_CreateNewNodeOperation" typeId="tp25.1143235216708" id="7385586609667640826">
                        <link role="concept" roleId="tp25.1143235391024" targetNodeId="8xvf.4755209551904389308" resolveInfo="BwfPath" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640827">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667640828">
                    <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640829">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640830">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640822" resolveInfo="path" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="7385586609667640831">
                        <link role="property" roleId="tp25.1138056395725" targetNodeId="8xvf.4755209551904389309" resolveInfo="path" />
                      </node>
                    </node>
                    <node role="rValue" roleId="tpee.1068498886297" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640832">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640840" resolveInfo="cpath" />
                    </node>
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667640833">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640834">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667640835">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640836">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640400" resolveInfo="cycleX" />
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="7385586609667640845">
                        <link role="link" roleId="tp25.1138056546658" targetNodeId="8xvf.4755209551904389314" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp2q.AddElementOperation" typeId="tp2q.1160612413312" id="7385586609667640838">
                      <node role="argument" roleId="tp2q.1160612519549" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640839">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640822" resolveInfo="path" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667640840">
                <property name="name" nameId="tpck.1169194664001" value="cpath" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="7385586609667640841" />
              </node>
              <node role="iterable" roleId="tpee.1144226360166" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667640843">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667640706" resolveInfo="classpath" />
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.SingleLineComment" typeId="tpee.6329021646629104954" id="7385586609667640750">
              <node role="commentPart" roleId="tpee.6329021646629175155" type="tpee.TextCommentPart" typeId="tpee.6329021646629104957" id="7385586609667640846">
                <property name="text" nameId="tpee.6329021646629104958" value="TODO collect dependencies!!" />
              </node>
            </node>
          </node>
          <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7385586609667638494">
            <property name="name" nameId="tpck.1169194664001" value="cycle" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638496">
              <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~List" resolveInfo="List" />
              <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667638498">
                <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
              </node>
            </node>
          </node>
          <node role="iterable" roleId="tpee.1144226360166" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7385586609667638499">
            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667638443" resolveInfo="cycles" />
          </node>
        </node>
      </node>
    </node>
    <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="4755209551904406846">
      <property name="name" nameId="tpck.1169194664001" value="project" />
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="4755209551904406847" />
      <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4755209551904411796">
        <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.2769948622284546673" resolveInfo="BwfProject" />
      </node>
    </node>
    <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="7385586609667523582">
      <property name="name" nameId="tpck.1169194664001" value="map" />
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="7385586609667523583" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667523585">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="k7g3.~Map" resolveInfo="Map" />
        <node role="parameter" roleId="tpee.1109201940907" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667523588" />
        <node role="parameter" roleId="tpee.1109201940907" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667523590">
          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
        </node>
      </node>
      <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="7385586609667523592">
        <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="7385586609667523594">
          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~HashMap%d&lt;init&gt;()" resolveInfo="HashMap" />
          <node role="typeParameter" roleId="tpee.1212687122400" type="tp25.SNodeType" typeId="tp25.1138055754698" id="7385586609667605165" />
          <node role="typeParameter" roleId="tpee.1212687122400" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7385586609667605167">
            <link role="classifier" roleId="tpee.1107535924139" targetNodeId="4755209551904421660" resolveInfo="CycleHelper.Module" />
          </node>
        </node>
      </node>
    </node>
    <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="4755209551904406841" />
    <node role="constructor" roleId="tpee.1068390468201" type="tpee.ConstructorDeclaration" typeId="tpee.1068580123140" id="4755209551904411797">
      <node role="returnType" roleId="tpee.1068580123133" type="tpee.VoidType" typeId="tpee.1068581517677" id="4755209551904411798" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="4755209551904411799" />
      <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="4755209551904411801">
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4755209551904411804">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="4755209551904411806">
            <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4755209551904411815">
              <node role="operand" roleId="tpee.1197027771414" type="tpee.ThisExpression" typeId="tpee.1070475354124" id="4755209551904411818" />
              <node role="operation" roleId="tpee.1197027833540" type="tpee.FieldReferenceOperation" typeId="tpee.1197029447546" id="4755209551904411817">
                <link role="fieldDeclaration" roleId="tpee.1197029500499" targetNodeId="4755209551904406846" resolveInfo="project" />
              </node>
            </node>
            <node role="rValue" roleId="tpee.1068498886297" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="4755209551904411810">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4755209551904411802" resolveInfo="project" />
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7385586609667636894">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="7385586609667636895">
            <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7385586609667636896">
              <node role="operand" roleId="tpee.1197027771414" type="tpee.ThisExpression" typeId="tpee.1070475354124" id="7385586609667636897" />
              <node role="operation" roleId="tpee.1197027833540" type="tpee.FieldReferenceOperation" typeId="tpee.1197029447546" id="7385586609667636898">
                <link role="fieldDeclaration" roleId="tpee.1197029500499" targetNodeId="7385586609667636891" resolveInfo="genContext" />
              </node>
            </node>
            <node role="rValue" roleId="tpee.1068498886297" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="7385586609667636899">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7385586609667636888" resolveInfo="genContext" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" roleId="tpee.1068580123134" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="4755209551904411802">
        <property name="name" nameId="tpck.1169194664001" value="project" />
        <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4755209551904411803">
          <link role="concept" roleId="tp25.1138405853777" targetNodeId="8xvf.2769948622284546673" resolveInfo="BwfProject" />
        </node>
      </node>
      <node role="parameter" roleId="tpee.1068580123134" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="7385586609667636888">
        <property name="name" nameId="tpck.1169194664001" value="genContext" />
        <node role="type" roleId="tpee.5680397130376446158" type="tpf3.GenerationContextType" typeId="tpf3.1216860049633" id="7385586609667636890" />
      </node>
    </node>
    <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="7385586609667636891">
      <property name="name" nameId="tpck.1169194664001" value="genContext" />
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="7385586609667636892" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpf3.GenerationContextType" typeId="tpf3.1216860049633" id="7385586609667636893" />
    </node>
  </root>
</model>

