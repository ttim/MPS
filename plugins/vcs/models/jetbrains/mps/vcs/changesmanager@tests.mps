<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:e7e02271-4574-4bd7-8641-cf8bca0b1900(jetbrains.mps.vcs.changesmanager@tests)">
  <persistence version="7" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <language namespace="7866978e-a0f0-4cc7-81bc-4d213d9375e1(jetbrains.mps.lang.smodel)" />
  <language namespace="28f9e497-3b42-4291-aeba-0a1039153ab1(jetbrains.mps.lang.plugin)" />
  <language namespace="774bf8a0-62e5-41e1-af63-f4812e60e48b(jetbrains.mps.baseLanguage.checkedDots)" />
  <import index="lcr" modelUID="r:d634c129-ecb4-4acd-bd8c-5f057c144ffa(jetbrains.mps.vcs.changesmanager)" version="-1" />
  <import index="qjxg" modelUID="f:java_stub#83f155ff-422c-4b5a-a2f2-b459302dd215#org.junit(jetbrains.mps.baseLanguage.unitTest.libs/org.junit@java_stub)" version="-1" />
  <import index="fxg7" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.io(JDK/java.io@java_stub)" version="-1" />
  <import index="msyo" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.util(MPS.Core/jetbrains.mps.util@java_stub)" version="-1" />
  <import index="ms53" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#jetbrains.mps(MPS.Workbench/jetbrains.mps@java_stub)" version="-1" />
  <import index="vehe" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#com.intellij.openapi.project(MPS.Workbench/com.intellij.openapi.project@java_stub)" version="-1" />
  <import index="vsqj" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.project(MPS.Core/jetbrains.mps.project@java_stub)" version="-1" />
  <import index="8iu6" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#jetbrains.mps.ide.project(MPS.Workbench/jetbrains.mps.ide.project@java_stub)" version="-1" />
  <import index="cu2c" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.smodel(MPS.Core/jetbrains.mps.smodel@java_stub)" version="-1" />
  <import index="rhwp" modelUID="f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#jetbrains.mps.smodel.descriptor(MPS.Core/jetbrains.mps.smodel.descriptor@java_stub)" version="-1" />
  <import index="tpee" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="-1" />
  <import index="e2lb" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)" version="-1" />
  <import index="tpck" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <import index="3hjc" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#jetbrains.mps.ide.vfs(MPS.Workbench/jetbrains.mps.ide.vfs@java_stub)" version="-1" />
  <import index="zfwc" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#com.intellij.openapi.vfs(MPS.Workbench/com.intellij.openapi.vfs@java_stub)" version="-1" />
  <import index="vulw" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#com.intellij.openapi.vcs.changes(MPS.Workbench/com.intellij.openapi.vcs.changes@java_stub)" version="-1" />
  <import index="zftr" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#com.intellij.openapi.vcs(MPS.Workbench/com.intellij.openapi.vcs@java_stub)" version="-1" />
  <import index="w36m" modelUID="f:java_stub#86441d7a-e194-42da-81a5-2161ec62a379#com.intellij.openapi.vcs.checkin(MPS.Workbench/com.intellij.openapi.vcs.checkin@java_stub)" version="-1" />
  <import index="k7g3" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.util(JDK/java.util@java_stub)" version="-1" />
  <import index="tp2c" modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" implicit="yes" />
  <import index="bfxj" modelUID="r:5744ed46-c83f-47cd-94ce-f24d1f92d6a1(jetbrains.mps.vcs.diff)" version="-1" implicit="yes" />
  <import index="tp2q" modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" implicit="yes" />
  <import index="pxpg" modelUID="r:5a550369-d6d9-4c89-a89b-1bb748dc20b3(jetbrains.mps.baseLanguage.checkedDots.structure)" version="-1" implicit="yes" />
  <import index="tp4k" modelUID="r:00000000-0000-4000-0000-011c89590368(jetbrains.mps.lang.plugin.structure)" version="5" implicit="yes" />
  <import index="tp25" modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="-1" implicit="yes" />
  <roots>
    <node type="tpee.ClassConcept" typeId="tpee.1068390468198" id="3089989024970166387">
      <property name="name" nameId="tpck.1169194664001" value="CommonChangesManagerTest" />
    </node>
  </roots>
  <root id="3089989024970166387">
    <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="3089989024970190377">
      <property name="name" nameId="tpck.1169194664001" value="myRegistry" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="3089989024970190378" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="3089989024970190380">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="lcr.3161776655522589894" resolveInfo="CurrentDifferenceRegistry" />
      </node>
    </node>
    <node role="staticField" roleId="tpee.1128555889557" type="tpee.StaticFieldDeclaration" typeId="tpee.1070462154015" id="3089989024970167949">
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <property name="name" nameId="tpck.1169194664001" value="DESTINATION_PROJECT_DIR" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="3089989024970167950" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="3089989024970172899">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
      </node>
      <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="3089989024970172901">
        <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="3089989024970172903">
          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="fxg7.~File%d&lt;init&gt;(java%dio%dFile,java%dlang%dString)" resolveInfo="File" />
          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="3089989024970174143">
            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="msyo.~FileUtil%dgetTempDir()%cjava%dio%dFile" resolveInfo="getTempDir" />
            <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="msyo.~FileUtil" resolveInfo="FileUtil" />
          </node>
          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3089989024970174145">
            <property name="value" nameId="tpee.1070475926801" value="testConflicts" />
          </node>
        </node>
      </node>
    </node>
    <node role="staticField" roleId="tpee.1128555889557" type="tpee.StaticFieldDeclaration" typeId="tpee.1070462154015" id="3089989024970174146">
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <property name="name" nameId="tpck.1169194664001" value="PROJECT_ARCHIVE" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="3089989024970174147" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="3089989024970174148">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="fxg7.~File" resolveInfo="File" />
      </node>
      <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="3089989024970174149">
        <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="3089989024970174150">
          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="fxg7.~File%d&lt;init&gt;(java%dlang%dString)" resolveInfo="File" />
          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3089989024970174152">
            <property name="value" nameId="tpee.1070475926801" value="testbench/modules/fugue.zip" />
          </node>
        </node>
      </node>
    </node>
    <node role="staticField" roleId="tpee.1128555889557" type="tpee.StaticFieldDeclaration" typeId="tpee.1070462154015" id="3089989024970174155">
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <property name="name" nameId="tpck.1169194664001" value="PROJECT_FILE" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="3089989024970174156" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="3089989024970174159" />
      <node role="initializer" roleId="tpee.1068431790190" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3089989024970174161">
        <property name="value" nameId="tpee.1070475926801" value="fugue.mpr" />
      </node>
    </node>
    <node role="method" roleId="tpee.1107880067339" type="tpee.InstanceMethodDeclaration" typeId="tpee.1068580123165" id="1187100870427681208">
      <property name="name" nameId="tpck.1169194664001" value="waitForChangesManager" />
      <node role="returnType" roleId="tpee.1068580123133" type="tpee.VoidType" typeId="tpee.1068581517677" id="1187100870427681209" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="1187100870427681212" />
      <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427681211">
        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="1187100870427681254">
          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="1187100870427681255">
            <property name="name" nameId="tpck.1169194664001" value="finished" />
            <node role="type" roleId="tpee.5680397130376446158" type="tpee.BooleanType" typeId="tpee.1070534644030" id="1187100870427681256" />
            <node role="initializer" roleId="tpee.1068431790190" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="1187100870427681265">
              <property name="value" nameId="tpee.1068580123138" value="false" />
            </node>
          </node>
        </node>
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681213">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427681220">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427681215">
              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="1187100870427681214">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970190377" resolveInfo="myRegistry" />
              </node>
              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427681219">
                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522590506" resolveInfo="getCommandQueue" />
              </node>
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427681224">
              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3722815385094288757" resolveInfo="addTask" />
              <node role="actualArgument" roleId="tpee.1068499141038" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="1187100870427681225">
                <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427681226">
                  <node role="statement" roleId="tpee.1068581517665" type="tpee.SynchronizedStatement" typeId="tpee.1170075670744" id="1187100870427682295">
                    <node role="expression" roleId="tpee.1170075728144" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="4346819404427339040">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427339021" resolveInfo="myWaitLock" />
                    </node>
                    <node role="block" roleId="tpee.1170075736412" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427682297">
                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681258">
                        <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="1187100870427681260">
                          <node role="rValue" roleId="tpee.1068498886297" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="1187100870427681263">
                            <property name="value" nameId="tpee.1068580123138" value="true" />
                          </node>
                          <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="1187100870427681259">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="1187100870427681255" resolveInfo="finished" />
                          </node>
                        </node>
                      </node>
                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681238">
                        <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427681240">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="4346819404427339041">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427339021" resolveInfo="myWaitLock" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427681244">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Object%dnotify()%cvoid" resolveInfo="notify" />
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
        <node role="statement" roleId="tpee.1068581517665" type="tpee.WhileStatement" typeId="tpee.1076505808687" id="1187100870427681267">
          <node role="condition" roleId="tpee.1076505808688" type="tpee.NotExpression" typeId="tpee.1081516740877" id="1187100870427681270">
            <node role="expression" roleId="tpee.1081516765348" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="1187100870427681272">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="1187100870427681255" resolveInfo="finished" />
            </node>
          </node>
          <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427681269">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.SynchronizedStatement" typeId="tpee.1170075670744" id="1187100870427682259">
              <node role="expression" roleId="tpee.1170075728144" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="4346819404427339039">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427339021" resolveInfo="myWaitLock" />
              </node>
              <node role="block" roleId="tpee.1170075736412" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427682261">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.TryCatchStatement" typeId="tpee.1164879751025" id="1187100870427681288">
                  <node role="body" roleId="tpee.1164879758292" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427681289">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681280">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427681282">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="4346819404427339043">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427339021" resolveInfo="myWaitLock" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427681286">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Object%dwait()%cvoid" resolveInfo="wait" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="catchClause" roleId="tpee.1164903496223" type="tpee.CatchClause" typeId="tpee.1164903280175" id="1187100870427681290">
                    <node role="throwable" roleId="tpee.1164903359217" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="1187100870427681291">
                      <property name="name" nameId="tpck.1169194664001" value="e" />
                      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="1187100870427681294">
                        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~InterruptedException" resolveInfo="InterruptedException" />
                      </node>
                    </node>
                    <node role="catchBody" roleId="tpee.1164903359218" type="tpee.StatementList" typeId="tpee.1068580123136" id="1187100870427681293">
                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681295">
                        <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427681297">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="1187100870427681296">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="1187100870427681291" resolveInfo="e" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427681301">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Throwable%dprintStackTrace()%cvoid" resolveInfo="printStackTrace" />
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
      </node>
    </node>
    <node role="method" roleId="tpee.1107880067339" type="tpee.InstanceMethodDeclaration" typeId="tpee.1068580123165" id="7666889591690494787">
      <property name="name" nameId="tpck.1169194664001" value="getCurrentDifference" />
      <node role="returnType" roleId="tpee.1068580123133" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7666889591690494792">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="lcr.3161776655522572366" resolveInfo="CurrentDifference" />
      </node>
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="7666889591690494791" />
      <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="7666889591690494790">
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427296500">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427296501">
            <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="4346819404427296502">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970190377" resolveInfo="myRegistry" />
            </node>
            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427296503">
              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522590297" resolveInfo="getCurrentDifference" />
              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.CastExpression" typeId="tpee.1070534934090" id="4346819404427296504">
                <node role="expression" roleId="tpee.1070534934092" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427296505">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427296506">
                    <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="cu2c.~SModelRepository" resolveInfo="SModelRepository" />
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="cu2c.~SModelRepository%dgetInstance()%cjetbrains%dmps%dsmodel%dSModelRepository" resolveInfo="getInstance" />
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427296507">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="cu2c.~SModelRepository%dgetModelDescriptor(jetbrains%dmps%dsmodel%dSModelFqName)%cjetbrains%dmps%dsmodel%dSModelDescriptor" resolveInfo="getModelDescriptor" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427296508">
                      <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="cu2c.~SModelFqName" resolveInfo="SModelFqName" />
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="cu2c.~SModelFqName%dfromString(java%dlang%dString)%cjetbrains%dmps%dsmodel%dSModelFqName" resolveInfo="fromString" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="4346819404427296509">
                        <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="4346819404427296510">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494793" resolveInfo="shortName" />
                        </node>
                        <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4346819404427296511">
                          <property name="value" nameId="tpee.1070475926801" value="ru.geevee.fugue." />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="type" roleId="tpee.1070534934091" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="4346819404427296512">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="rhwp.~EditableSModelDescriptor" resolveInfo="EditableSModelDescriptor" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" roleId="tpee.1068580123134" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="7666889591690494793">
        <property name="name" nameId="tpck.1169194664001" value="shortName" />
        <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="7666889591690494794" />
      </node>
    </node>
    <node role="method" roleId="tpee.1107880067339" type="tpee.InstanceMethodDeclaration" typeId="tpee.1068580123165" id="3089989024970167309">
      <property name="name" nameId="tpck.1169194664001" value="doTest" />
      <node role="returnType" roleId="tpee.1068580123133" type="tpee.VoidType" typeId="tpee.1068581517677" id="3089989024970167310" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="3089989024970167311" />
      <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="3089989024970167312">
        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3089989024970190370">
          <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="3089989024970180543">
            <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="ms53.~TestMain" resolveInfo="TestMain" />
            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="ms53.~TestMain%dtestOnProjectCopy(java%dio%dFile,java%dio%dFile,java%dlang%dString,jetbrains%dmps%dTestMain$ProjectRunnable,java%dlang%dString%d%d%d)%cboolean" resolveInfo="testOnProjectCopy" />
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalStaticFieldReference" typeId="tpee.1172008963197" id="3089989024970190371">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970174146" resolveInfo="PROJECT_ARCHIVE" />
            </node>
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalStaticFieldReference" typeId="tpee.1172008963197" id="3089989024970190372">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970167949" resolveInfo="DESTINATION_PROJECT_DIR" />
            </node>
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalStaticFieldReference" typeId="tpee.1172008963197" id="3089989024970190373">
              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970174155" resolveInfo="PROJECT_FILE" />
            </node>
            <node role="actualArgument" roleId="tpee.1068499141038" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="3089989024970180552">
              <node role="parameter" roleId="tp2c.1199569906740" type="tpee.ParameterDeclaration" typeId="tpee.1068498886292" id="3089989024970180554">
                <property name="name" nameId="tpck.1169194664001" value="project" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="3089989024970190376">
                  <link role="classifier" roleId="tpee.1107535924139" targetNodeId="vsqj.~Project" resolveInfo="Project" />
                </node>
              </node>
              <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="3089989024970180553">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.TryCatchStatement" typeId="tpee.1164879751025" id="3089989024970180559">
                  <node role="body" roleId="tpee.1164879758292" type="tpee.StatementList" typeId="tpee.1068580123136" id="3089989024970180560">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4346819404427307549">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4346819404427307550">
                        <property name="name" nameId="tpck.1169194664001" value="ideaProject" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="4346819404427307551">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="vehe.~Project" resolveInfo="Project" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427307552">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="8iu6.~ProjectHelper%dtoIdeaProject(jetbrains%dmps%dproject%dProject)%ccom%dintellij%dopenapi%dproject%dProject" resolveInfo="toIdeaProject" />
                          <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="8iu6.~ProjectHelper" resolveInfo="ProjectHelper" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="4346819404427307553">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970180554" resolveInfo="project" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3089989024970190381">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="3089989024970190383">
                        <node role="rValue" roleId="tpee.1068498886297" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="3089989024970190387">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522590016" resolveInfo="getInstance" />
                          <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="lcr.3161776655522589894" resolveInfo="CurrentDifferenceRegistry" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427307554">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427307550" resolveInfo="ideaProject" />
                          </node>
                        </node>
                        <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalInstanceFieldReference" typeId="tpee.7785501532031639928" id="3089989024970190382">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970190377" resolveInfo="myRegistry" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681304">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="1187100870427681305">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="1187100870427681208" resolveInfo="waitForChangesManager" />
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="7666889591690494829" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="1187100870427681191">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="1187100870427681192">
                        <property name="name" nameId="tpck.1169194664001" value="html" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="1187100870427681193">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="lcr.3161776655522572366" resolveInfo="CurrentDifference" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="7666889591690494826">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7666889591690494787" resolveInfo="getCurrentDifference" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7666889591690494827">
                            <property name="value" nameId="tpee.1070475926801" value="html" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7666889591690494839">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7666889591690494840">
                        <property name="name" nameId="tpck.1169194664001" value="ui" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7666889591690494841">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="lcr.3161776655522572366" resolveInfo="CurrentDifference" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="7666889591690494842">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7666889591690494787" resolveInfo="getCurrentDifference" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7666889591690494843">
                            <property name="value" nameId="tpee.1070475926801" value="ui" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="7666889591690494844">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="7666889591690494845">
                        <property name="name" nameId="tpck.1169194664001" value="util" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="7666889591690494846">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="lcr.3161776655522572366" resolveInfo="CurrentDifference" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="7666889591690494847">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="7666889591690494787" resolveInfo="getCurrentDifference" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="7666889591690494848">
                            <property name="value" nameId="tpee.1070475926801" value="util" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427282168" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681315">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="1187100870427682208">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertNull(java%dlang%dObject)%cvoid" resolveInfo="assertNull" />
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427682210">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="1187100870427682209">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="1187100870427681192" resolveInfo="html" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427682214">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7666889591690494849">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7666889591690494850">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertNull(java%dlang%dObject)%cvoid" resolveInfo="assertNull" />
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7666889591690494851">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7666889591690494859">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494840" resolveInfo="ui" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7666889591690494853">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7666889591690494854">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7666889591690494855">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertNull(java%dlang%dObject)%cvoid" resolveInfo="assertNull" />
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7666889591690494856">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7666889591690494860">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7666889591690494858">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427282169" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427681200">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="1187100870427681202">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="1187100870427681201">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="1187100870427681192" resolveInfo="html" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="1187100870427681206">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522687321" resolveInfo="setEnabled" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="1187100870427681207">
                            <property name="value" nameId="tpee.1068580123138" value="true" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427280321">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427280323">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427280322">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494840" resolveInfo="ui" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427281074">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522687321" resolveInfo="setEnabled" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="4346819404427281075">
                            <property name="value" nameId="tpee.1068580123138" value="true" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427281076">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427281077">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427281081">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427281079">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522687321" resolveInfo="setEnabled" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="4346819404427281080">
                            <property name="value" nameId="tpee.1068580123138" value="true" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="1187100870427682216">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="1187100870427682217">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="1187100870427681208" resolveInfo="waitForChangesManager" />
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427282170" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7666889591690492872">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7666889591690494685">
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertFalse(boolean)%cvoid" resolveInfo="assertFalse" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7666889591690494691">
                          <node role="operand" roleId="tpee.1197027771414" type="pxpg.CheckedDotExpression" typeId="pxpg.4079382982702596667" id="7666889591690494729">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7666889591690494687">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7666889591690494688">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="1187100870427681192" resolveInfo="html" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7666889591690494689">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7666889591690494690">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="bfxj.3834754559947609967" resolveInfo="getModelChanges" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp2q.IsEmptyOperation" typeId="tp2q.1165530316231" id="7666889591690494695" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7666889591690494861">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="7666889591690494862">
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertFalse(boolean)%cvoid" resolveInfo="assertFalse" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7666889591690494863">
                          <node role="operand" roleId="tpee.1197027771414" type="pxpg.CheckedDotExpression" typeId="pxpg.4079382982702596667" id="7666889591690494864">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="7666889591690494865">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="7666889591690494879">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494840" resolveInfo="ui" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7666889591690494867">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="7666889591690494868">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="bfxj.3834754559947609967" resolveInfo="getModelChanges" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp2q.IsEmptyOperation" typeId="tp2q.1165530316231" id="7666889591690494869" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="7666889591690494870">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427282079">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertNull(java%dlang%dObject)%cvoid" resolveInfo="assertNull" />
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427282082">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427282083">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427282084">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427282171" />
                    <node role="statement" roleId="tpee.1068581517665" type="tp4k.ExecuteCommandStatement" typeId="tp4k.1225441285519" id="4346819404427282203">
                      <node role="commandClosureLiteral" roleId="tp4k.1225441160167" type="tp4k.CommandClosureLiteral" typeId="tp4k.1225441216717" id="4346819404427282204">
                        <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="4346819404427282205">
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4346819404427282872">
                            <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4346819404427282873">
                              <property name="name" nameId="tpck.1169194664001" value="model" />
                              <node role="type" roleId="tpee.5680397130376446158" type="tp25.SModelType" typeId="tp25.1143226024141" id="4346819404427282883" />
                              <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427282875">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427296486">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427296485">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427296490">
                                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522682202" resolveInfo="getModelDescriptor" />
                                  </node>
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427282878">
                                  <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="cu2c.~SModelDescriptor%dgetSModel()%cjetbrains%dmps%dsmodel%dSModel" resolveInfo="getSModel" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4346819404427293032">
                            <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4346819404427293033">
                              <property name="name" nameId="tpck.1169194664001" value="root" />
                              <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4346819404427293034">
                                <link role="concept" roleId="tp25.1138405853777" targetNodeId="tpee.1068390468198" resolveInfo="ClassConcept" />
                              </node>
                              <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293035">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293036">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427293037">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427282873" resolveInfo="model" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Model_RootsOperation" typeId="tp25.1171315804604" id="4346819404427293038">
                                    <link role="concept" roleId="tp25.1171315804605" targetNodeId="tpee.1068390468198" resolveInfo="ClassConcept" />
                                  </node>
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tp2q.FindFirstOperation" typeId="tp2q.1225727723840" id="4346819404427293039">
                                  <node role="closure" roleId="tp2q.1204796294226" type="tp2c.ClosureLiteral" typeId="tp2c.1199569711397" id="4346819404427293040">
                                    <node role="body" roleId="tp2c.1199569916463" type="tpee.StatementList" typeId="tpee.1068580123136" id="4346819404427293041">
                                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427293042">
                                        <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293043">
                                          <node role="operand" roleId="tpee.1197027771414" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4346819404427293044">
                                            <property name="value" nameId="tpee.1070475926801" value="SearchPanel" />
                                          </node>
                                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427293045">
                                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dequals(java%dlang%dObject)%cboolean" resolveInfo="equals" />
                                            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293046">
                                              <node role="operand" roleId="tpee.1197027771414" type="tpee.ParameterReference" typeId="tpee.1068581242874" id="4346819404427293047">
                                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427293049" resolveInfo="r" />
                                              </node>
                                              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="4346819404427293048">
                                                <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
                                              </node>
                                            </node>
                                          </node>
                                        </node>
                                      </node>
                                    </node>
                                    <node role="parameter" roleId="tp2c.1199569906740" type="tp2q.SmartClosureParameterDeclaration" typeId="tp2q.1203518072036" id="4346819404427293049">
                                      <property name="name" nameId="tpck.1169194664001" value="r" />
                                      <node role="type" roleId="tpee.5680397130376446158" type="tpee.UndefinedType" typeId="tpee.4836112446988635817" id="4346819404427293050" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427293053">
                            <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="4346819404427293060">
                              <node role="rValue" roleId="tpee.1068498886297" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4346819404427293063">
                                <property name="value" nameId="tpee.1070475926801" value="SearchPanelModified" />
                              </node>
                              <node role="lValue" roleId="tpee.1068498886295" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293055">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427293054">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427293033" resolveInfo="root" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="4346819404427293059">
                                  <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427293065">
                            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293094">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293089">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427293080">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427293033" resolveInfo="root" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkAccess" typeId="tp25.1138056143562" id="4346819404427293093">
                                  <link role="link" roleId="tp25.1138056516764" targetNodeId="tpee.1165602531693" />
                                </node>
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_DeleteOperation" typeId="tp25.1140133623887" id="4346819404427293103" />
                            </node>
                          </node>
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427293105">
                            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293119">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293107">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427293106">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427293033" resolveInfo="root" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="4346819404427293111">
                                  <link role="link" roleId="tp25.1138056546658" targetNodeId="tpee.1068390468199" />
                                </node>
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tp2q.ClearAllElementsOperation" typeId="tp2q.1227022210526" id="4346819404427293123" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427293126">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="4346819404427293127">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="1187100870427681208" resolveInfo="waitForChangesManager" />
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427293129">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427293130">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertFalse(boolean)%cvoid" resolveInfo="assertFalse" />
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293131">
                          <node role="operand" roleId="tpee.1197027771414" type="pxpg.CheckedDotExpression" typeId="pxpg.4079382982702596667" id="4346819404427293132">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427293133">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427293138">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427293135">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427293136">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="bfxj.3834754559947609967" resolveInfo="getModelChanges" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tp2q.IsEmptyOperation" typeId="tp2q.1165530316231" id="4346819404427293137" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427296462" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4346819404427300937">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4346819404427300938">
                        <property name="name" nameId="tpck.1169194664001" value="utilVFile" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="4346819404427300939">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="zfwc.~VirtualFile" resolveInfo="VirtualFile" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427300940">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="3hjc.~VirtualFileUtils%dgetVirtualFile(jetbrains%dmps%dvfs%dIFile)%ccom%dintellij%dopenapi%dvfs%dVirtualFile" resolveInfo="getVirtualFile" />
                          <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="3hjc.~VirtualFileUtils" resolveInfo="VirtualFileUtils" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427300941">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427300942">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427300943">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427300944">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522682202" resolveInfo="getModelDescriptor" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427300945">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="rhwp.~EditableSModelDescriptor%dgetModelFile()%cjetbrains%dmps%dvfs%dIFile" resolveInfo="getModelFile" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4346819404427319263">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4346819404427319264">
                        <property name="name" nameId="tpck.1169194664001" value="change" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="4346819404427319265">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="vulw.~Change" resolveInfo="Change" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427319266">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427319267">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="vulw.~ChangeListManager%dgetInstance(com%dintellij%dopenapi%dproject%dProject)%ccom%dintellij%dopenapi%dvcs%dchanges%dChangeListManager" resolveInfo="getInstance" />
                            <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="vulw.~ChangeListManager" resolveInfo="ChangeListManager" />
                            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427319268">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427307550" resolveInfo="ideaProject" />
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427319269">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="vulw.~ChangeListManager%dgetChange(com%dintellij%dopenapi%dvfs%dVirtualFile)%ccom%dintellij%dopenapi%dvcs%dchanges%dChange" resolveInfo="getChange" />
                            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427319270">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427300938" resolveInfo="utilVFile" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.AssertStatement" typeId="tpee.1160998861373" id="4346819404427319273">
                      <node role="condition" roleId="tpee.1160998896846" type="tpee.NotEqualsExpression" typeId="tpee.1073239437375" id="4346819404427319276">
                        <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.NullLiteral" typeId="tpee.1070534058343" id="4346819404427319279" />
                        <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427319275">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427319264" resolveInfo="change" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4346819404427338405">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4346819404427338406">
                        <property name="name" nameId="tpck.1169194664001" value="checkinEnvironment" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="4346819404427338407">
                          <link role="classifier" roleId="tpee.1107535924139" targetNodeId="w36m.~CheckinEnvironment" resolveInfo="CheckinEnvironment" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="pxpg.CheckedDotExpression" typeId="pxpg.4079382982702596667" id="4346819404427338838">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427338409">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427338410">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="zftr.~ProjectLevelVcsManager%dgetInstance(com%dintellij%dopenapi%dproject%dProject)%ccom%dintellij%dopenapi%dvcs%dProjectLevelVcsManager" resolveInfo="getInstance" />
                              <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="zftr.~ProjectLevelVcsManager" resolveInfo="ProjectLevelVcsManager" />
                              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427338411">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427307550" resolveInfo="ideaProject" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427338412">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="zftr.~ProjectLevelVcsManager%dgetVcsFor(com%dintellij%dopenapi%dvfs%dVirtualFile)%ccom%dintellij%dopenapi%dvcs%dAbstractVcs" resolveInfo="getVcsFor" />
                              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427338413">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427300938" resolveInfo="utilVFile" />
                              </node>
                            </node>
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427338414">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="zftr.~AbstractVcs%dgetCheckinEnvironment()%ccom%dintellij%dopenapi%dvcs%dcheckin%dCheckinEnvironment" resolveInfo="getCheckinEnvironment" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.AssertStatement" typeId="tpee.1160998861373" id="4346819404427338842">
                      <node role="condition" roleId="tpee.1160998896846" type="tpee.NotEqualsExpression" typeId="tpee.1073239437375" id="4346819404427338845">
                        <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.NullLiteral" typeId="tpee.1070534058343" id="4346819404427338848" />
                        <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427338844">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427338406" resolveInfo="checkinEnvironment" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427338417">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427338419">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427338418">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427338406" resolveInfo="checkinEnvironment" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427338669">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="w36m.~CheckinEnvironment%dcommit(java%dutil%dList,java%dlang%dString)%cjava%dutil%dList" resolveInfo="commit" />
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427338672">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="k7g3.~Arrays%dasList(java%dlang%dObject%d%d%d)%cjava%dutil%dList" resolveInfo="asList" />
                            <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="k7g3.~Arrays" resolveInfo="Arrays" />
                            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427338673">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4346819404427319264" resolveInfo="change" />
                            </node>
                          </node>
                          <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4346819404427338675">
                            <property name="value" nameId="tpee.1070475926801" value="dumb commit" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427338676" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427338678">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.LocalInstanceMethodCall" typeId="tpee.3066917033203108594" id="4346819404427338679">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="1187100870427681208" resolveInfo="waitForChangesManager" />
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4346819404427338681">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.StaticMethodCall" typeId="tpee.1081236700937" id="4346819404427338682">
                        <link role="classConcept" roleId="tpee.1144433194310" targetNodeId="qjxg.~Assert" resolveInfo="Assert" />
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="qjxg.~Assert%dassertNull(java%dlang%dObject)%cvoid" resolveInfo="assertNull" />
                        <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4346819404427338683">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4346819404427338684">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="7666889591690494845" resolveInfo="util" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4346819404427338685">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="lcr.3161776655522689398" resolveInfo="getChangeSet" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4346819404427282172" />
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="1187100870427660268">
                      <node role="expression" roleId="tpee.1068581517676" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="1187100870427660270">
                        <property name="value" nameId="tpee.1068580123138" value="true" />
                      </node>
                    </node>
                  </node>
                  <node role="catchClause" roleId="tpee.1164903496223" type="tpee.CatchClause" typeId="tpee.1164903280175" id="3089989024970180561">
                    <node role="throwable" roleId="tpee.1164903359217" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3089989024970180562">
                      <property name="name" nameId="tpck.1169194664001" value="e" />
                      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="3089989024970180565">
                        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~Throwable" resolveInfo="Throwable" />
                      </node>
                    </node>
                    <node role="catchBody" roleId="tpee.1164903359218" type="tpee.StatementList" typeId="tpee.1068580123136" id="3089989024970180564">
                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3089989024970180566">
                        <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3089989024970180568">
                          <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3089989024970180567">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3089989024970180562" resolveInfo="e" />
                          </node>
                          <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3089989024970180572">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Throwable%dprintStackTrace()%cvoid" resolveInfo="printStackTrace" />
                          </node>
                        </node>
                      </node>
                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="3089989024970180574">
                        <node role="expression" roleId="tpee.1068581517676" type="tpee.BooleanConstant" typeId="tpee.1068580123137" id="3089989024970180576">
                          <property name="value" nameId="tpee.1068580123138" value="false" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="1934260009352712914">
              <property name="value" nameId="tpee.1070475926801" value="jetbrains.mps.vcs" />
            </node>
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="1934260009352712916">
              <property name="value" nameId="tpee.1070475926801" value="Git4Idea" />
            </node>
            <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="1934260009352712951">
              <property name="value" nameId="tpee.1070475926801" value="jetbrains.mps.ide.make" />
            </node>
          </node>
        </node>
      </node>
      <node role="annotation" roleId="tpee.1188208488637" type="tpee.AnnotationInstance" typeId="tpee.1188207840427" id="3089989024970167313">
        <link role="annotation" roleId="tpee.1188208074048" targetNodeId="qjxg.~Test" resolveInfo="Test" />
      </node>
    </node>
    <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="3089989024970166388" />
    <node role="constructor" roleId="tpee.1068390468201" type="tpee.ConstructorDeclaration" typeId="tpee.1068580123140" id="3089989024970166389">
      <node role="returnType" roleId="tpee.1068580123133" type="tpee.VoidType" typeId="tpee.1068581517677" id="3089989024970166390" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PublicVisibility" typeId="tpee.1146644602865" id="3089989024970166391" />
      <node role="body" roleId="tpee.1068580123135" type="tpee.StatementList" typeId="tpee.1068580123136" id="3089989024970166392" />
    </node>
    <node role="field" roleId="tpee.1068390468199" type="tpee.FieldDeclaration" typeId="tpee.1068390468200" id="4346819404427339021">
      <property name="name" nameId="tpck.1169194664001" value="myWaitLock" />
      <property name="isFinal" nameId="tpee.1176718929932" value="true" />
      <node role="visibility" roleId="tpee.1178549979242" type="tpee.PrivateVisibility" typeId="tpee.1146644623116" id="4346819404427339022" />
      <node role="type" roleId="tpee.5680397130376446158" type="tpee.ClassifierType" typeId="tpee.1107535904670" id="4346819404427339023">
        <link role="classifier" roleId="tpee.1107535924139" targetNodeId="e2lb.~Object" resolveInfo="Object" />
      </node>
      <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="4346819404427339036">
        <node role="creator" roleId="tpee.1145553007750" type="tpee.ClassCreator" typeId="tpee.1212685548494" id="4346819404427339037">
          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~Object%d&lt;init&gt;()" resolveInfo="Object" />
        </node>
      </node>
    </node>
  </root>
</model>

