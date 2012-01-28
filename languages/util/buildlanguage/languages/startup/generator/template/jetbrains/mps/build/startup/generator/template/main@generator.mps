<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:9eaefcec-a5af-4365-b04c-b6940eebe416(jetbrains.mps.build.startup.generator.template.main@generator)">
  <persistence version="7" />
  <language namespace="b401a680-8325-4110-8fd3-84331ff25bef(jetbrains.mps.lang.generator)" />
  <language namespace="d7706f63-9be2-479c-a3da-ae92af1e64d5(jetbrains.mps.lang.generator.generationContext)" />
  <language namespace="a83c3bd0-2f7e-4ba1-8373-12d49e99f57e(jetbrains.mps.gtext)" />
  <language namespace="4a1e4a24-105b-44ed-959c-6586fc957db3(jetbrains.mps.bash)" />
  <language namespace="823d79c6-2e26-4b0e-92a0-e1884a10bba9(jetbrains.mps.xml.deprecated)" />
  <language namespace="ceab5195-25ea-4f22-9b92-103b95ca8c0c(jetbrains.mps.lang.core)" />
  <devkit namespace="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  <import index="s7om" modelUID="r:a930f08c-5447-4203-8f2e-507bb76fab12(jetbrains.mps.build.startup.structure)" version="-1" />
  <import index="fxg7" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.io(JDK/java.io@java_stub)" version="-1" />
  <import index="e2lb" modelUID="f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)" version="-1" />
  <import index="tgdw" modelUID="r:f9efd379-0776-49f3-ae79-8113b86e36ad(jetbrains.mps.build.startup.behavior)" version="-1" />
  <import index="tpck" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" implicit="yes" />
  <import index="tpf8" modelUID="r:00000000-0000-4000-0000-011c895902e8(jetbrains.mps.lang.generator.structure)" version="2" implicit="yes" />
  <import index="jvj3" modelUID="r:a8223385-58f6-47fc-9412-c59396fbedb5(jetbrains.mps.bash.builtin)" version="-1" implicit="yes" />
  <import index="u9e0" modelUID="r:49b10014-fe6b-4682-a69d-1c3d6188eba3(jetbrains.mps.bash.structure)" version="-1" implicit="yes" />
  <import index="tpee" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="-1" implicit="yes" />
  <import index="tpih" modelUID="r:00000000-0000-4000-0000-011c89590575(jetbrains.mps.gtext.structure)" version="0" implicit="yes" />
  <import index="tp25" modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="-1" implicit="yes" />
  <import index="tpkv" modelUID="r:00000000-0000-4000-0000-011c895905a3(jetbrains.mps.xml.deprecated.structure)" version="0" implicit="yes" />
  <import index="tp2q" modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" implicit="yes" />
  <import index="tp3r" modelUID="r:00000000-0000-4000-0000-011c8959034b(jetbrains.mps.lang.quotation.structure)" version="0" implicit="yes" />
  <roots>
    <node type="tpf8.MappingConfiguration" typeId="tpf8.1095416546421" id="3885435385580635038">
      <property name="name" nameId="tpck.1169194664001" value="main" />
    </node>
    <node type="tpih.GDocument" typeId="tpih.1184639540818" id="3885435385580638721">
      <property name="extension" nameId="tpih.1184639664013" value="bat" />
      <property name="documentName" nameId="tpih.1184639635512" value="WindowsStartupScript" />
    </node>
    <node type="u9e0.ShellScript" typeId="u9e0.3321051580269925631" id="3885435385580638984">
      <property name="name" nameId="tpck.1169194664001" value="UnixStartupScript" />
    </node>
    <node type="tpkv.Document" typeId="tpkv.1119976146404" id="3885435385580639723">
      <property name="name" nameId="tpck.1169194664001" value="Info" />
      <property name="extension" nameId="tpkv.1234428502488" value="plist" />
    </node>
    <node type="tpih.GDocument" typeId="tpih.1184639540818" id="4962066449779579859">
      <property name="documentName" nameId="tpih.1184639635512" value="mps" />
      <property name="extension" nameId="tpih.1184639664013" value="vmoptions" />
    </node>
  </roots>
  <root id="3885435385580635038">
    <node role="rootMappingRule" roleId="tpf8.1167514678247" type="tpf8.Root_MappingRule" typeId="tpf8.1167514355419" id="5842819808956701256">
      <property name="keepSourceRoot" nameId="tpf8.1177959072138" value="true" />
      <link role="applicableConcept" roleId="tpf8.1167169349424" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
      <link role="template" roleId="tpf8.1167514355421" targetNodeId="3885435385580639723" resolveInfo="Info" />
    </node>
    <node role="rootMappingRule" roleId="tpf8.1167514678247" type="tpf8.Root_MappingRule" typeId="tpf8.1167514355419" id="5842819808956716889">
      <property name="keepSourceRoot" nameId="tpf8.1177959072138" value="true" />
      <link role="applicableConcept" roleId="tpf8.1167169349424" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
      <link role="template" roleId="tpf8.1167514355421" targetNodeId="3885435385580638984" resolveInfo="UnixStartupScript" />
    </node>
    <node role="rootMappingRule" roleId="tpf8.1167514678247" type="tpf8.Root_MappingRule" typeId="tpf8.1167514355419" id="5842819808956716890">
      <property name="keepSourceRoot" nameId="tpf8.1177959072138" value="true" />
      <link role="applicableConcept" roleId="tpf8.1167169349424" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
      <link role="template" roleId="tpf8.1167514355421" targetNodeId="3885435385580638721" resolveInfo="WindowsStartupScript" />
    </node>
    <node role="rootMappingRule" roleId="tpf8.1167514678247" type="tpf8.Root_MappingRule" typeId="tpf8.1167514355419" id="5842819808956701316">
      <link role="applicableConcept" roleId="tpf8.1167169349424" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
      <link role="template" roleId="tpf8.1167514355421" targetNodeId="4962066449779579859" resolveInfo="mps" />
    </node>
  </root>
  <root id="3885435385580638721">
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.RootTemplateAnnotation" typeId="tpf8.1168619357332" id="3885435385580638722">
      <link role="applicableConcept" roleId="tpf8.1168619429071" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
    </node>
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638723">
      <property name="propertyName" nameId="tpck.1757699476691236117" value="documentName" />
      <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638724">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638725">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956703322">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703324">
              <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956703323" />
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956703328">
                <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638730">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638731">
        <property name="text" nameId="tpih.1164413036326" value="@echo off" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638732" />
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638733">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638734">
        <property name="text" nameId="tpih.1164413036326" value="set PROJECT_HOME=" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638735">
        <property name="text" nameId="tpih.1164413036326" value="%~dp0" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638736">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638737">
        <property name="text" nameId="tpih.1164413036326" value="set JAVA=" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638738">
        <property name="text" nameId="tpih.1164413036326" value="javaw" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638739">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638740">
        <property name="text" nameId="tpih.1164413036326" value="IF EXIST &quot;%PROJECT_HOME%jre&quot; set JAVA=&quot;%PROJECT_HOME%jre\bin\%JAVA%&quot;" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638750">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638751">
        <property name="text" nameId="tpih.1164413036326" value="set MAIN_CLASS=" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638752">
        <property name="text" nameId="tpih.1164413036326" value="some.main.class" />
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638753">
          <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638754">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638755">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956703329">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703331">
                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956703330" />
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956703337">
                    <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580631186" resolveInfo="startupClass" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638762">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638763">
        <property name="text" nameId="tpih.1164413036326" value="IF &quot;%MPS_VM_OPTIONS%&quot; == &quot;&quot; (" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638764" />
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638765">
        <property name="text" nameId="tpih.1164413036326" value="SET MPS_VM_OPTIONS=&quot;%PROJECT_HOME%" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638766">
        <property name="text" nameId="tpih.1164413036326" value="vmoptions.file" />
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638767">
          <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638768">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638769">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956911540">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956911548">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779444502">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956911542">
                      <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956911541" />
                      <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="5842819808956911547">
                        <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911442" resolveInfo="getPathToVmOptionsFile" />
                      </node>
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4962066449779444506">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dreplace(java%dlang%dCharSequence,java%dlang%dCharSequence)%cjava%dlang%dString" resolveInfo="replace" />
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779448078">
                        <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="4962066449779448077" />
                        <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="4962066449779480072">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911479" resolveInfo="getVmOptionsExtension" />
                        </node>
                      </node>
                      <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="4962066449779480078">
                        <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4962066449779480079">
                          <property name="value" nameId="tpee.1070475926801" value="exe." />
                        </node>
                        <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779480080">
                          <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="4962066449779480081" />
                          <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="4962066449779480082">
                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911479" resolveInfo="getVmOptionsExtension" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="5842819808956911552">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dreplace(java%dlang%dCharSequence,java%dlang%dCharSequence)%cjava%dlang%dString" resolveInfo="replace" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="5842819808956911553">
                      <property name="value" nameId="tpee.1070475926801" value="/" />
                    </node>
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="5842819808956911555">
                      <property name="value" nameId="tpee.1070475926801" value="\\" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638774">
        <property name="text" nameId="tpih.1164413036326" value="&quot;" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638775" />
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638776">
        <property name="text" nameId="tpih.1164413036326" value=")" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638777">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638778">
        <property name="text" nameId="tpih.1164413036326" value="set ACC=" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638779" />
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638780">
        <property name="text" nameId="tpih.1164413036326" value="FOR /F &quot;delims=&quot; %%i in (" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638781">
        <property name="text" nameId="tpih.1164413036326" value="'TYPE %MPS_VM_OPTIONS%'" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638782">
        <property name="text" nameId="tpih.1164413036326" value=") DO call :parse_vmoptions" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638783">
        <property name="text" nameId="tpih.1164413036326" value=" &quot;%%i&quot;" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638784" />
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638785">
        <property name="text" nameId="tpih.1164413036326" value="set JVM_ARGS=%ACC%" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638811">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638812">
        <property name="text" nameId="tpih.1164413036326" value="::" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638813">
        <property name="text" nameId="tpih.1164413036326" value="set ADDITIONAL_JVM_ARGS=" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638814">
        <property name="text" nameId="tpih.1164413036326" value="additional args" />
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638815">
          <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638816">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638817">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956703396">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703400">
                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956703397" />
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956703406">
                    <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582733" resolveInfo="options" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.LoopMacro" typeId="tpf8.1118786554307" id="5842819808956703338">
        <node role="sourceNodesQuery" roleId="tpf8.1167952069335" type="tpf8.SourceSubstituteMacro_SourceNodesQuery" typeId="tpf8.1167951910403" id="5842819808956703339">
          <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="5842819808956703340">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956911531">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956911533">
                <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956911532" />
                <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="5842819808956911538">
                  <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911345" resolveInfo="getCommentedOptions" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638835">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638836">
        <property name="text" nameId="tpih.1164413036326" value="set CLASSPATH=" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638837">
        <property name="text" nameId="tpih.1164413036326" value="&quot;%PROJECT_HOME%" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638838">
        <property name="text" nameId="tpih.1164413036326" value="path" />
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638839">
          <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638840">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638841">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956716773">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779480160">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716788">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716780">
                      <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716775">
                        <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956716774" />
                        <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="5842819808956716779">
                          <link role="link" roleId="tp25.1138056546658" targetNodeId="s7om.3885435385580582696" />
                        </node>
                      </node>
                      <node role="operation" roleId="tpee.1197027833540" type="tp2q.GetFirstOperation" typeId="tp2q.1165525191778" id="5842819808956716787" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956716792">
                      <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582154" resolveInfo="path" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4962066449779480164">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dreplace(java%dlang%dCharSequence,java%dlang%dCharSequence)%cjava%dlang%dString" resolveInfo="replace" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4962066449779480165">
                      <property name="value" nameId="tpee.1070475926801" value="/" />
                    </node>
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4962066449779480167">
                      <property name="value" nameId="tpee.1070475926801" value="\\" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638858">
        <property name="text" nameId="tpih.1164413036326" value="&quot;" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638859">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638860">
        <property name="text" nameId="tpih.1164413036326" value="set CLASSPATH=%CLASSPATH%;" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638861">
        <property name="text" nameId="tpih.1164413036326" value="&quot;%PROJECT_HOME%" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638862">
        <property name="text" nameId="tpih.1164413036326" value="path" />
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638863">
          <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638864">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638865">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580638866">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580638867">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716765">
                    <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="3885435385580638869" />
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956716772">
                      <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582154" resolveInfo="path" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580638871">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dreplace(java%dlang%dCharSequence,java%dlang%dCharSequence)%cjava%dlang%dString" resolveInfo="replace" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580638872">
                      <property name="value" nameId="tpee.1070475926801" value="/" />
                    </node>
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580638873">
                      <property name="value" nameId="tpee.1070475926801" value="\\" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638874">
        <property name="text" nameId="tpih.1164413036326" value="&quot;" />
      </node>
      <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.LoopMacro" typeId="tpf8.1118786554307" id="3885435385580638875">
        <node role="sourceNodesQuery" roleId="tpf8.1167952069335" type="tpf8.SourceSubstituteMacro_SourceNodesQuery" typeId="tpf8.1167951910403" id="3885435385580638876">
          <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638877">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580638878">
              <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580638879">
                <node role="operation" roleId="tpee.1197027833540" type="tp2q.SkipOperation" typeId="tp2q.1172650591544" id="3885435385580638887">
                  <node role="elementsToSkip" roleId="tp2q.1172658456740" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="3885435385580638888">
                    <property name="value" nameId="tpee.1068580320021" value="1" />
                  </node>
                </node>
                <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703409">
                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956703408" />
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="5842819808956703414">
                    <link role="link" roleId="tp25.1138056546658" targetNodeId="s7om.3885435385580582696" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638889" />
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638890">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638891">
        <property name="text" nameId="tpih.1164413036326" value="pushd " />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638892">
        <property name="text" nameId="tpih.1164413036326" value="basedir" />
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580638893">
          <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580638894">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580638895">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956703416">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703418">
                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956703417" />
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956703422">
                    <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582155" resolveInfo="startupFolder" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638920">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638921">
        <property name="text" nameId="tpih.1164413036326" value="start &quot;&quot; %JAVA% %JVM_ARGS% %ADDITIONAL_JVM_ARGS% -classpath %CLASSPATH% %MAIN_CLASS% %*" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638922">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638923">
        <property name="text" nameId="tpih.1164413036326" value="popd" />
      </node>
    </node>
    <node role="item" roleId="tpih.1184639733180" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638939" />
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638940">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638941">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638942">
          <property name="text" nameId="tpih.1164413036326" value="exit" />
        </node>
        <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638943" />
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638944">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638945">
          <property name="text" nameId="tpih.1164413036326" value=":parse_vmoptions" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638946">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638947">
          <property name="text" nameId="tpih.1164413036326" value="if not defined ACC goto emptyacc" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638948">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638949">
          <property name="text" nameId="tpih.1164413036326" value="if &quot;%SEPARATOR%&quot; == &quot;&quot; goto noseparator" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638950">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638951">
          <property name="text" nameId="tpih.1164413036326" value="set ACC=%ACC%%SEPARATOR%%1" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638952">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638953">
          <property name="text" nameId="tpih.1164413036326" value="goto :eof" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638954" />
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638955">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638956">
          <property name="text" nameId="tpih.1164413036326" value=":noseparator" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638957">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638958">
          <property name="text" nameId="tpih.1164413036326" value="set ACC=%ACC% %1" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638959">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638960">
          <property name="text" nameId="tpih.1164413036326" value="goto :eof" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GNewLine" typeId="tpih.1164413172275" id="3885435385580638961" />
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638962">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638963">
          <property name="text" nameId="tpih.1164413036326" value=":emptyacc" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638964">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638965">
          <property name="text" nameId="tpih.1164413036326" value="set ACC=%1" />
        </node>
      </node>
      <node role="item" roleId="tpih.1166928665191" type="tpih.GLine" typeId="tpih.1166926309597" id="3885435385580638966">
        <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="3885435385580638967">
          <property name="text" nameId="tpih.1164413036326" value="goto :eof" />
        </node>
      </node>
    </node>
  </root>
  <root id="3885435385580638984">
    <node role="commands" roleId="u9e0.3321051580270016552" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580638985">
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580638986">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580638987">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580638988">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580638989">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580638990">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.QuotesCommandSubstitution" typeId="u9e0.4857814468235197608" id="3885435385580638991">
                  <node role="command" roleId="u9e0.4857814468235197593" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580638992">
                    <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580638993">
                      <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580638994">
                        <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580638995">
                          <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.6027654792138152393" resolveInfo="uname" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580638996">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639630" resolveInfo="UNAME" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580638997">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580638998">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580638999">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639000">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639001">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639002">
                  <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639003">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639004">
                      <property name="word" nameId="u9e0.8353259571485353282" value="$0" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639005">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639617" resolveInfo="SCRIPT_PATH" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639006">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639007">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639008">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.IfCommand" typeId="u9e0.7633559109508737477" id="3885435385580639009">
              <node role="ifTrue" roleId="u9e0.7633559109508737479" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639010">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639011">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639012">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639013" />
                  </node>
                  <node role="comment" roleId="u9e0.2635812496400429929" type="u9e0.CommentedText" typeId="u9e0.8457058248751600624" id="3885435385580639014">
                    <property name="comment" nameId="u9e0.8457058248751600627" value="readlink resolves symbolic links, but on linux only" />
                  </node>
                </node>
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639015">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639016">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639017">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639018">
                        <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639019">
                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.QuotesCommandSubstitution" typeId="u9e0.4857814468235197608" id="3885435385580639020">
                            <node role="command" roleId="u9e0.4857814468235197593" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639021">
                              <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639022">
                                <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639023">
                                  <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639024">
                                    <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.7093590863634209406" resolveInfo="readlink" />
                                    <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.OptionSetReference" typeId="u9e0.7803330421057156061" id="3885435385580639025">
                                      <node role="refToOptions" roleId="u9e0.7803330421057584568" type="u9e0.OptionReference" typeId="u9e0.7803330421057519636" id="3885435385580639026">
                                        <link role="option" roleId="u9e0.7803330421057519637" targetNodeId="jvj3.7093590863634209413" />
                                      </node>
                                    </node>
                                    <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentReference" typeId="u9e0.7803330421058150857" id="3885435385580639027">
                                      <link role="arg" roleId="u9e0.7803330421058150858" targetNodeId="jvj3.7093590863634209418" resolveInfo="FILE" />
                                      <node role="value" roleId="u9e0.7803330421058150868" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639028">
                                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639029">
                                          <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639030">
                                            <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639031">
                                              <property name="word" nameId="u9e0.8353259571485353282" value="$0" />
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
                        <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639032">
                          <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639617" resolveInfo="SCRIPT_PATH" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="testCommand" roleId="u9e0.7633559109508737478" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639033">
                <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.EqualityStrings2" typeId="u9e0.898011086340135411" id="3885435385580639034">
                  <node role="left" roleId="u9e0.9034131902191635404" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639035">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639036">
                      <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639037">
                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639038">
                          <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639630" resolveInfo="UNAME" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="right" roleId="u9e0.9034131902191635405" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639039">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639040">
                      <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639041">
                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639042">
                          <property name="word" nameId="u9e0.8353259571485353282" value="Linux" />
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
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639043">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639044">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639045">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639046">
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639047">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639618" resolveInfo="PROJECT_HOME" />
              </node>
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639048">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.QuotesCommandSubstitution" typeId="u9e0.4857814468235197608" id="3885435385580639049">
                  <node role="command" roleId="u9e0.4857814468235197593" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639050">
                    <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639051">
                      <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639052">
                        <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639053">
                          <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.9034131902186148391" resolveInfo="dirname" />
                          <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentReference" typeId="u9e0.7803330421058150857" id="3885435385580639054">
                            <link role="arg" roleId="u9e0.7803330421058150858" targetNodeId="jvj3.9034131902186148394" resolveInfo="OPTION" />
                            <node role="value" roleId="u9e0.7803330421058150868" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639055">
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639056">
                                <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639057">
                                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639058">
                                    <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639617" resolveInfo="SCRIPT_PATH" />
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
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639059">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639060">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639061">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639062">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639063">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639064">
                  <property name="word" nameId="u9e0.8353259571485353282" value=".." />
                  <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639065">
                    <property name="propertyName" nameId="tpck.1757699476691236117" value="word" />
                    <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639066">
                      <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639067">
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3885435385580639068">
                          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580639069">
                            <property name="name" nameId="tpck.1169194664001" value="startupDir" />
                            <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="3885435385580639070" />
                            <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716870">
                              <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956716869" />
                              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956716874">
                                <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582155" resolveInfo="startupFolder" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="3885435385580639078">
                          <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639079">
                            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580639080">
                              <node role="expression" roleId="tpee.1068580123156" type="tpee.AssignmentExpression" typeId="tpee.1068498886294" id="3885435385580639081">
                                <node role="rValue" roleId="tpee.1068498886297" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580639082">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639083">
                                    <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639069" resolveInfo="startupDir" />
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580639084">
                                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dsubstring(int,int)%cjava%dlang%dString" resolveInfo="substring" />
                                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="3885435385580639085">
                                      <property name="value" nameId="tpee.1068580320021" value="0" />
                                    </node>
                                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.MinusExpression" typeId="tpee.1068581242869" id="3885435385580639086">
                                      <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="3885435385580639087">
                                        <property name="value" nameId="tpee.1068580320021" value="1" />
                                      </node>
                                      <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580639088">
                                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639089">
                                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639069" resolveInfo="startupDir" />
                                        </node>
                                        <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580639090">
                                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dlength()%cint" resolveInfo="length" />
                                        </node>
                                      </node>
                                    </node>
                                  </node>
                                </node>
                                <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639091">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639069" resolveInfo="startupDir" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="condition" roleId="tpee.1068580123160" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580639092">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639093">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639069" resolveInfo="startupDir" />
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580639094">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dendsWith(java%dlang%dString)%cboolean" resolveInfo="endsWith" />
                              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580639095">
                                <property name="value" nameId="tpee.1070475926801" value="/" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3885435385580639096">
                          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580639097">
                            <property name="name" nameId="tpck.1169194664001" value="path" />
                            <node role="type" roleId="tpee.5680397130376446158" type="tpee.ArrayType" typeId="tpee.1070534760951" id="3885435385580639098">
                              <node role="componentType" roleId="tpee.1070534760952" type="tpee.StringType" typeId="tpee.1225271177708" id="3885435385580639099" />
                            </node>
                            <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580639100">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639101">
                                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639069" resolveInfo="startupDir" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580639102">
                                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dsplit(java%dlang%dString)%cjava%dlang%dString[]" resolveInfo="split" />
                                <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580639103">
                                  <property name="value" nameId="tpee.1070475926801" value="/" />
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3885435385580639104">
                          <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580639105">
                            <property name="name" nameId="tpck.1169194664001" value="pathFromStartupDir" />
                            <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="3885435385580639106" />
                            <node role="initializer" roleId="tpee.1068431790190" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580639107">
                              <property name="value" nameId="tpee.1070475926801" value=".." />
                            </node>
                          </node>
                        </node>
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.ForStatement" typeId="tpee.1144231330558" id="3885435385580639108">
                          <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639109">
                            <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580639110">
                              <node role="expression" roleId="tpee.1068580123156" type="tpee.PlusAssignmentExpression" typeId="tpee.1215695189714" id="3885435385580639111">
                                <node role="rValue" roleId="tpee.1068498886297" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580639112">
                                  <property name="value" nameId="tpee.1070475926801" value="/.." />
                                </node>
                                <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639113">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639105" resolveInfo="pathFromStartupDir" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="variable" roleId="tpee.1144230900587" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580639114">
                            <property name="name" nameId="tpck.1169194664001" value="i" />
                            <node role="type" roleId="tpee.5680397130376446158" type="tpee.IntegerType" typeId="tpee.1070534370425" id="3885435385580639115" />
                            <node role="initializer" roleId="tpee.1068431790190" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="3885435385580639116">
                              <property name="value" nameId="tpee.1068580320021" value="0" />
                            </node>
                          </node>
                          <node role="condition" roleId="tpee.1144231399730" type="tpee.LessThanExpression" typeId="tpee.1081506773034" id="3885435385580639117">
                            <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639118">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639114" resolveInfo="i" />
                            </node>
                            <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.MinusExpression" typeId="tpee.1068581242869" id="3885435385580639119">
                              <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="3885435385580639120">
                                <property name="value" nameId="tpee.1068580320021" value="1" />
                              </node>
                              <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580639121">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639122">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639097" resolveInfo="path" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tpee.ArrayLengthOperation" typeId="tpee.1208890769693" id="3885435385580639123" />
                              </node>
                            </node>
                          </node>
                          <node role="iteration" roleId="tpee.1144231408325" type="tpee.PostfixIncrementExpression" typeId="tpee.1214918800624" id="3885435385580639124">
                            <node role="expression" roleId="tpee.1239714902950" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639125">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639114" resolveInfo="i" />
                            </node>
                          </node>
                        </node>
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="3885435385580639126">
                          <node role="expression" roleId="tpee.1068581517676" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580639127">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580639105" resolveInfo="pathFromStartupDir" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639128">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639619" resolveInfo="PROJECT_HOME_FROM_STARTUP_DIR" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639129">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639130">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639131">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.Command" typeId="u9e0.3905757829901343108" id="3885435385580639132" />
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639133">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639134">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639135">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.IfCommand" typeId="u9e0.7633559109508737477" id="3885435385580639136">
              <node role="testCommand" roleId="u9e0.7633559109508737478" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639137">
                <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.ZeroStringConditionalExpression" typeId="u9e0.9034131902191629589" id="3885435385580639138">
                  <node role="word" roleId="u9e0.9034131902191439564" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639139">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639140">
                      <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639141">
                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639142">
                          <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639626" resolveInfo="JDK_HOME" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue" roleId="u9e0.7633559109508737479" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639143">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639144">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639145">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639146">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639147">
                        <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639148">
                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639149">
                            <property name="word" nameId="u9e0.8353259571485353282" value="java" />
                          </node>
                        </node>
                        <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639150">
                          <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639620" resolveInfo="JAVA" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifFalse" roleId="u9e0.7633559109508737480" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639151">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639152">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639153">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639154">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639155">
                        <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639156">
                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639157">
                            <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639158">
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639159">
                                <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639626" resolveInfo="JDK_HOME" />
                              </node>
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639160">
                                <property name="word" nameId="u9e0.8353259571485353282" value="/bin/java" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639161">
                          <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639620" resolveInfo="JAVA" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639162">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639163">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639164">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639165">
                        <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.7803330421062580359" resolveInfo="echo" />
                        <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639166">
                          <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639167">
                            <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639168">
                              <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639169">
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639170">
                                  <property name="word" nameId="u9e0.8353259571485353282" value="$0 info: Using jdk located in " />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639171">
                                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639626" resolveInfo="JDK_HOME" />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639172">
                                  <property name="word" nameId="u9e0.8353259571485353282" value="." />
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
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639173">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639174">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639175">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.Command" typeId="u9e0.3905757829901343108" id="3885435385580639176" />
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639177">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639178">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639179">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639180">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639181">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639182">
                  <property name="word" nameId="u9e0.8353259571485353282" value="some.main.class" />
                  <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639183">
                    <property name="propertyName" nameId="tpck.1757699476691236117" value="word" />
                    <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639184">
                      <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639185">
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956716875">
                          <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716877">
                            <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956716876" />
                            <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956716881">
                              <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580631186" resolveInfo="startupClass" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639192">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639621" resolveInfo="MAIN_CLASS" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639193">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639194">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639195">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.Command" typeId="u9e0.3905757829901343108" id="3885435385580639196" />
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639197">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639198">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639199">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.IfCommand" typeId="u9e0.7633559109508737477" id="3885435385580639200">
              <node role="testCommand" roleId="u9e0.7633559109508737478" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639201">
                <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.ZeroStringConditionalExpression" typeId="u9e0.9034131902191629589" id="3885435385580639202">
                  <node role="word" roleId="u9e0.9034131902191439564" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639203">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639204">
                      <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639205">
                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639206">
                          <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639627" resolveInfo="MPS_VM_OPTIONS" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue" roleId="u9e0.7633559109508737479" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639207">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639208">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639209">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639210">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639211">
                        <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639212">
                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639213">
                            <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639214">
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639215">
                                <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639618" resolveInfo="PROJECT_HOME" />
                              </node>
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639216">
                                <property name="word" nameId="u9e0.8353259571485353282" value="/" />
                              </node>
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639217">
                                <property name="word" nameId="u9e0.8353259571485353282" value="pathToVmoptionsFile" />
                                <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639218">
                                  <property name="propertyName" nameId="tpck.1757699476691236117" value="word" />
                                  <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639219">
                                    <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639220">
                                      <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956911498">
                                        <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956911500">
                                          <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956911499" />
                                          <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="5842819808956911504">
                                            <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911442" resolveInfo="getPathToVmOptionsFile" />
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
                        <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639225">
                          <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639627" resolveInfo="MPS_VM_OPTIONS" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifFalse" roleId="u9e0.7633559109508737480" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639226">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639227">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639228">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639229">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639230">
                        <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.7803330421062580359" resolveInfo="echo" />
                        <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639231">
                          <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639232">
                            <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639233">
                              <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639234">
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639235">
                                  <property name="word" nameId="u9e0.8353259571485353282" value="$0 info: Using vmoptions defined in " />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639236">
                                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639627" resolveInfo="MPS_VM_OPTIONS" />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639237">
                                  <property name="word" nameId="u9e0.8353259571485353282" value="." />
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
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639247">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639248">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639249">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639250">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639251">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.QuotesCommandSubstitution" typeId="u9e0.4857814468235197608" id="3885435385580639252">
                  <node role="command" roleId="u9e0.4857814468235197593" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639253">
                    <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639254">
                      <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639255">
                        <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639256">
                          <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.9034131902183128184" resolveInfo="cat" />
                          <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639257">
                            <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639258">
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639259">
                                <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639260">
                                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639261">
                                    <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639627" resolveInfo="MPS_VM_OPTIONS" />
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="following" roleId="u9e0.8474643070111818352" type="u9e0.PipelineOperatorConnection" typeId="u9e0.8474643070111988418" id="3885435385580639262">
                          <node role="basePipeline" roleId="u9e0.8474643070111988415" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639263">
                            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639264">
                              <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.9034131902186554428" resolveInfo="tr" />
                              <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639265">
                                <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639266">
                                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SingleQuote" typeId="u9e0.3263637656455059140" id="3885435385580639267">
                                    <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639268">
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639269">
                                        <property name="word" nameId="u9e0.8353259571485353282" value="\n" />
                                      </node>
                                    </node>
                                  </node>
                                </node>
                              </node>
                              <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639270">
                                <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639271">
                                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SingleQuote" typeId="u9e0.3263637656455059140" id="3885435385580639272">
                                    <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639273">
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639274">
                                        <property name="word" nameId="u9e0.8353259571485353282" value=" " />
                                      </node>
                                    </node>
                                  </node>
                                </node>
                              </node>
                            </node>
                            <node role="following" roleId="u9e0.8474643070111818352" type="u9e0.PipelineOperatorConnection" typeId="u9e0.8474643070111988418" id="3885435385580639275">
                              <node role="basePipeline" roleId="u9e0.8474643070111988415" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639276">
                                <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639277">
                                  <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.9034131902186554428" resolveInfo="tr" />
                                  <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639278">
                                    <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639279">
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SingleQuote" typeId="u9e0.3263637656455059140" id="3885435385580639280">
                                        <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639281">
                                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639282">
                                            <property name="word" nameId="u9e0.8353259571485353282" value="\r" />
                                          </node>
                                        </node>
                                      </node>
                                    </node>
                                  </node>
                                  <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639283">
                                    <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639284">
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SingleQuote" typeId="u9e0.3263637656455059140" id="3885435385580639285">
                                        <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639286">
                                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639287">
                                            <property name="word" nameId="u9e0.8353259571485353282" value=" " />
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
                  </node>
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639288">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639624" resolveInfo="JVM_ARGS" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommentedCommandList" typeId="u9e0.8457058248751696156" id="3885435385580639372">
        <node role="commandList" roleId="u9e0.8457058248751696157" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639373">
          <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639374">
            <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639375">
              <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639376">
                <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639377">
                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="5842819808956703273">
                    <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="5842819808956703274">
                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639380">
                        <property name="word" nameId="u9e0.8353259571485353282" value="additional.args" />
                        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639381">
                          <property name="propertyName" nameId="tpck.1757699476691236117" value="word" />
                          <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639382">
                            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639383">
                              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956911516">
                                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956911520">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956911517" />
                                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956911527">
                                    <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582733" resolveInfo="options" />
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
                <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639390">
                  <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639625" resolveInfo="ADDITIONAL_JVM_ARGS" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.LoopMacro" typeId="tpf8.1118786554307" id="5842819808956703169">
          <node role="sourceNodesQuery" roleId="tpf8.1167952069335" type="tpf8.SourceSubstituteMacro_SourceNodesQuery" typeId="tpf8.1167951910403" id="5842819808956703170">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="5842819808956703171">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956911509">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956911511">
                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956911510" />
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="5842819808956911515">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911345" resolveInfo="getCommentedOptions" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639402">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639403">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639404">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.Command" typeId="u9e0.3905757829901343108" id="3885435385580639405" />
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639406">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639407">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639408">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639409">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639410">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639411">
                  <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639412" />
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639413">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639622" resolveInfo="CLASSPATH" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639414">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639415">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639416">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639417">
              <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639418">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639419">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639622" resolveInfo="CLASSPATH" />
                </node>
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639420">
                  <property name="word" nameId="u9e0.8353259571485353282" value=":" />
                </node>
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639421">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639619" resolveInfo="PROJECT_HOME_FROM_STARTUP_DIR" />
                </node>
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639422">
                  <property name="word" nameId="u9e0.8353259571485353282" value="/" />
                </node>
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639423">
                  <property name="word" nameId="u9e0.8353259571485353282" value="path" />
                  <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639424">
                    <property name="propertyName" nameId="tpck.1757699476691236117" value="word" />
                    <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639425">
                      <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639426">
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580639427">
                          <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703305">
                            <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="3885435385580639430" />
                            <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956703312">
                              <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582154" resolveInfo="path" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639435">
                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639622" resolveInfo="CLASSPATH" />
              </node>
            </node>
          </node>
        </node>
        <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.LoopMacro" typeId="tpf8.1118786554307" id="3885435385580639436">
          <node role="sourceNodesQuery" roleId="tpf8.1167952069335" type="tpf8.SourceSubstituteMacro_SourceNodesQuery" typeId="tpf8.1167951910403" id="3885435385580639437">
            <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639438">
              <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580639439">
                <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580639440">
                  <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="3885435385580639443" />
                  <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="5842819808956703299">
                    <link role="link" roleId="tp25.1138056546658" targetNodeId="s7om.3885435385580582696" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639447">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639448">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639449">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.Command" typeId="u9e0.3905757829901343108" id="3885435385580639450" />
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639451">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639452">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639453">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639454">
              <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.3263637656462774222" resolveInfo="cd" />
              <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentReference" typeId="u9e0.7803330421058150857" id="3885435385580639455">
                <link role="arg" roleId="u9e0.7803330421058150858" targetNodeId="jvj3.3263637656462774227" resolveInfo="directory" />
                <node role="value" roleId="u9e0.7803330421058150868" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639456">
                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639457">
                    <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639458">
                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639459">
                        <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639618" resolveInfo="PROJECT_HOME" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639460">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639461">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639462">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639463">
              <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.3263637656462774222" resolveInfo="cd" />
              <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentReference" typeId="u9e0.7803330421058150857" id="3885435385580639464">
                <link role="arg" roleId="u9e0.7803330421058150858" targetNodeId="jvj3.3263637656462774227" resolveInfo="directory" />
                <node role="value" roleId="u9e0.7803330421058150868" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639465">
                  <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639466">
                    <property name="word" nameId="u9e0.8353259571485353282" value="basedir" />
                    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639467">
                      <property name="propertyName" nameId="tpck.1757699476691236117" value="word" />
                      <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639468">
                        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639469">
                          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956703314">
                            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956703316">
                              <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956703315" />
                              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956703320">
                                <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582155" resolveInfo="startupFolder" />
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
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639493">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639494">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639495">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.IfCommand" typeId="u9e0.7633559109508737477" id="3885435385580639496">
              <node role="testCommand" roleId="u9e0.7633559109508737478" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639497">
                <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.EqualityStrings2" typeId="u9e0.898011086340135411" id="3885435385580639498">
                  <node role="left" roleId="u9e0.9034131902191635404" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639499">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639500">
                      <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639501">
                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639502">
                          <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639630" resolveInfo="UNAME" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="right" roleId="u9e0.9034131902191635405" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639503">
                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639504">
                      <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639505">
                        <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639506">
                          <property name="word" nameId="u9e0.8353259571485353282" value="Darwin" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue" roleId="u9e0.7633559109508737479" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639507">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639508">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639509">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639510">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.IfCommand" typeId="u9e0.7633559109508737477" id="3885435385580639511">
                        <node role="testCommand" roleId="u9e0.7633559109508737478" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639512">
                          <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.ZeroStringConditionalExpression" typeId="u9e0.9034131902191629589" id="3885435385580639513">
                            <node role="word" roleId="u9e0.9034131902191439564" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639514">
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639515">
                                <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639629" resolveInfo="DYLD_LIBRARY_PATH" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="ifTrue" roleId="u9e0.7633559109508737479" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639516">
                          <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639517">
                            <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639518">
                              <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639519">
                                <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639520">
                                  <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639521">
                                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639522">
                                      <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639628" resolveInfo="PWD" />
                                    </node>
                                  </node>
                                  <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639523">
                                    <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639629" resolveInfo="DYLD_LIBRARY_PATH" />
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="ifFalse" roleId="u9e0.7633559109508737480" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639524">
                          <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639525">
                            <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639526">
                              <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639527">
                                <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639528">
                                  <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639529">
                                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639530">
                                      <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639629" resolveInfo="DYLD_LIBRARY_PATH" />
                                    </node>
                                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639531">
                                      <property name="word" nameId="u9e0.8353259571485353282" value=":" />
                                    </node>
                                    <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639532">
                                      <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639628" resolveInfo="PWD" />
                                    </node>
                                  </node>
                                  <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639533">
                                    <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639629" resolveInfo="DYLD_LIBRARY_PATH" />
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
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639534">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639535">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639536">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639537">
                        <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.3263637656462774233" resolveInfo="export" />
                        <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentReference" typeId="u9e0.7803330421058150857" id="3885435385580639538">
                          <link role="arg" roleId="u9e0.7803330421058150858" targetNodeId="jvj3.3263637656462774246" resolveInfo="name" />
                          <node role="value" roleId="u9e0.7803330421058150868" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639539">
                            <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639540">
                              <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639629" resolveInfo="DYLD_LIBRARY_PATH" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="elseIf" roleId="u9e0.7633559109508737481" type="u9e0.ElifCommand" typeId="u9e0.7633559109508737482" id="3885435385580639541">
                <node role="testCommand" roleId="u9e0.7633559109508737485" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639542">
                  <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.EqualityStrings2" typeId="u9e0.898011086340135411" id="3885435385580639543">
                    <node role="left" roleId="u9e0.9034131902191635404" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639544">
                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639545">
                        <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639546">
                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639547">
                            <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639630" resolveInfo="UNAME" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="right" roleId="u9e0.9034131902191635405" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639548">
                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639549">
                        <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639550">
                          <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639551">
                            <property name="word" nameId="u9e0.8353259571485353282" value="Linux" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="commands" roleId="u9e0.7633559109508737484" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639552">
                  <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639553">
                    <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639554">
                      <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639555">
                        <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.IfCommand" typeId="u9e0.7633559109508737477" id="3885435385580639556">
                          <node role="testCommand" roleId="u9e0.7633559109508737478" type="u9e0.ConditionalCommand" typeId="u9e0.3147078024747082354" id="3885435385580639557">
                            <node role="conditionalExpression" roleId="u9e0.3147078024747082356" type="u9e0.ZeroStringConditionalExpression" typeId="u9e0.9034131902191629589" id="3885435385580639558">
                              <node role="word" roleId="u9e0.9034131902191439564" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639559">
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639560">
                                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639623" resolveInfo="LD_LIBRARY_PATH" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="ifTrue" roleId="u9e0.7633559109508737479" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639561">
                            <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639562">
                              <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639563">
                                <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639564">
                                  <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639565">
                                    <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639566">
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639567">
                                        <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639628" resolveInfo="PWD" />
                                      </node>
                                    </node>
                                    <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639568">
                                      <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639623" resolveInfo="LD_LIBRARY_PATH" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="ifFalse" roleId="u9e0.7633559109508737480" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639569">
                            <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639570">
                              <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639571">
                                <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639572">
                                  <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.VariableAssingment" typeId="u9e0.3999172467441325687" id="3885435385580639573">
                                    <node role="value" roleId="u9e0.3999172467441293221" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639574">
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639575">
                                        <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639623" resolveInfo="LD_LIBRARY_PATH" />
                                      </node>
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639576">
                                        <property name="word" nameId="u9e0.8353259571485353282" value=":" />
                                      </node>
                                      <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639577">
                                        <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639628" resolveInfo="PWD" />
                                      </node>
                                    </node>
                                    <node role="lvalue" roleId="u9e0.3999172467441293220" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639578">
                                      <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639623" resolveInfo="LD_LIBRARY_PATH" />
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
                  <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639579">
                    <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639580">
                      <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639581">
                        <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639582">
                          <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.3263637656462774233" resolveInfo="export" />
                          <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentReference" typeId="u9e0.7803330421058150857" id="3885435385580639583">
                            <link role="arg" roleId="u9e0.7803330421058150858" targetNodeId="jvj3.3263637656462774246" resolveInfo="name" />
                            <node role="value" roleId="u9e0.7803330421058150868" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639584">
                              <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.VariableReference" typeId="u9e0.9034131902187955344" id="3885435385580639585">
                                <link role="variable" roleId="u9e0.9034131902187955345" targetNodeId="3885435385580639623" resolveInfo="LD_LIBRARY_PATH" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifFalse" roleId="u9e0.7633559109508737480" type="u9e0.InputLines" typeId="u9e0.3321051580269917239" id="3885435385580639586">
                <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639587">
                  <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639588">
                    <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639589">
                      <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.ExternalCommandCall" typeId="u9e0.4857814468241254997" id="3885435385580639590">
                        <link role="declaration" roleId="u9e0.4857814468241607046" targetNodeId="jvj3.7803330421062580359" resolveInfo="echo" />
                        <node role="refToOptions" roleId="u9e0.4857814468241607047" type="u9e0.ArgumentListReference" typeId="u9e0.3147078024744633269" id="3885435385580639591">
                          <node role="words" roleId="u9e0.3147078024744633271" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639592">
                            <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.DoubleQuote" typeId="u9e0.3263637656455059166" id="3885435385580639593">
                              <node role="word" roleId="u9e0.3147078024751877535" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639594">
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639595">
                                  <property name="word" nameId="u9e0.8353259571485353282" value="$0 warning: " />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639596">
                                  <property name="word" nameId="u9e0.8353259571485353282" value="Unknown operating system " />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639597">
                                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639630" resolveInfo="UNAME" />
                                </node>
                                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639598">
                                  <property name="word" nameId="u9e0.8353259571485353282" value=". Do not know how to add PWD to libraries path." />
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
        </node>
      </node>
      <node role="lines" roleId="u9e0.3321051580270635008" type="u9e0.CommandList" typeId="u9e0.3321051580269894529" id="3885435385580639599">
        <node role="head" roleId="u9e0.3321051580273150845" type="u9e0.HeadCommandList" typeId="u9e0.8474643070102636479" id="3885435385580639600">
          <node role="base" roleId="u9e0.8474643070102636485" type="u9e0.HeadPipeline" typeId="u9e0.8474643070110245381" id="3885435385580639601">
            <node role="command" roleId="u9e0.8474643070110463418" type="u9e0.FreeCommand" typeId="u9e0.9034131902193581134" id="3885435385580639602">
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639603">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639604">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639620" resolveInfo="JAVA" />
                </node>
              </node>
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639605">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639606">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639624" resolveInfo="JVM_ARGS" />
                </node>
              </node>
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639607">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639608">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639625" resolveInfo="ADDITIONAL_JVM_ARGS" />
                </node>
              </node>
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639609">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639610">
                  <property name="word" nameId="u9e0.8353259571485353282" value="-classpath" />
                </node>
              </node>
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639611">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639612">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639622" resolveInfo="CLASSPATH" />
                </node>
              </node>
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639613">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.BasicParameterExpansion" typeId="u9e0.3999172467442053841" id="3885435385580639614">
                  <link role="variable" roleId="u9e0.3999172467442053842" targetNodeId="3885435385580639621" resolveInfo="MAIN_CLASS" />
                </node>
              </node>
              <node role="translatedWord" roleId="u9e0.9034131902193581135" type="u9e0.GeneralizedWord" typeId="u9e0.8353259571483884165" id="3885435385580639615">
                <node role="units" roleId="u9e0.8353259571485385865" type="u9e0.SimpleWord" typeId="u9e0.8353259571485353280" id="3885435385580639616">
                  <property name="word" nameId="u9e0.8353259571485353282" value="$*" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639617">
      <property name="name" nameId="tpck.1169194664001" value="SCRIPT_PATH" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639618">
      <property name="name" nameId="tpck.1169194664001" value="PROJECT_HOME" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639619">
      <property name="name" nameId="tpck.1169194664001" value="PROJECT_HOME_FROM_STARTUP_DIR" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639620">
      <property name="name" nameId="tpck.1169194664001" value="JAVA" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639621">
      <property name="name" nameId="tpck.1169194664001" value="MAIN_CLASS" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639622">
      <property name="name" nameId="tpck.1169194664001" value="CLASSPATH" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639623">
      <property name="name" nameId="tpck.1169194664001" value="LD_LIBRARY_PATH" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639624">
      <property name="name" nameId="tpck.1169194664001" value="JVM_ARGS" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639625">
      <property name="name" nameId="tpck.1169194664001" value="ADDITIONAL_JVM_ARGS" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639626">
      <property name="name" nameId="tpck.1169194664001" value="JDK_HOME" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639627">
      <property name="name" nameId="tpck.1169194664001" value="MPS_VM_OPTIONS" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639628">
      <property name="name" nameId="tpck.1169194664001" value="PWD" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639629">
      <property name="name" nameId="tpck.1169194664001" value="DYLD_LIBRARY_PATH" />
    </node>
    <node role="usedVars" roleId="u9e0.9034131902190735828" type="u9e0.VariableNameDeclaration" typeId="u9e0.7633559109506263695" id="3885435385580639630">
      <property name="name" nameId="tpck.1169194664001" value="UNAME" />
    </node>
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.RootTemplateAnnotation" typeId="tpf8.1168619357332" id="3885435385580639631">
      <link role="applicableConcept" roleId="tpf8.1168619429071" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
    </node>
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580639632">
      <property name="propertyName" nameId="tpck.1757699476691236117" value="name" />
      <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580639633">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580639634">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580639635">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956716882">
              <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="3885435385580639637" />
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956716886">
                <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </root>
  <root id="3885435385580639723">
    <node role="rootElement" roleId="tpkv.1119976595358" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639724">
      <property name="name" nameId="tpck.1169194664001" value="plist" />
      <node role="attribute" roleId="tpkv.1107866791721" type="tpkv.Attribute" typeId="tpkv.1107866742882" id="3885435385580639725">
        <property name="name" nameId="tpck.1169194664001" value="version" />
        <property name="value" nameId="tpkv.1107866755246" value="1.0" />
      </node>
      <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639726">
        <property name="name" nameId="tpck.1169194664001" value="dict" />
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639727">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639728">
            <property name="name" nameId="tpck.1169194664001" value="C" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleName" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640261">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640268">
            <property name="name" nameId="tpck.1169194664001" value="M" />
            <property name="text" nameId="tpkv.1107866834687" value="MPS" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639742">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639743">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleGetInfoString" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640282">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640289">
            <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $version$" />
            <property name="text" nameId="tpkv.1107866834687" value="JetBrains MPS $version$" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639757">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639758">
            <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleShortVersionString" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640303">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640310">
            <property name="name" nameId="tpck.1169194664001" value="$version$" />
            <property name="text" nameId="tpkv.1107866834687" value="$version$" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639794">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639795">
            <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleVersion" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640324">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640331">
            <property name="name" nameId="tpck.1169194664001" value="$build$" />
            <property name="text" nameId="tpkv.1107866834687" value="$build$" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639831">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639832">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleExecutable" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640345">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640352">
            <property name="name" nameId="tpck.1169194664001" value="m" />
            <property name="text" nameId="tpkv.1107866834687" value="mps" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639846">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639847">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleIconFile" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640360">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640374">
            <property name="name" nameId="tpck.1169194664001" value="mps.icns" />
            <property name="text" nameId="tpkv.1107866834687" value="mps.icns" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639879">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639880">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleDevelopmentRegion" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639881">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639882">
            <property name="name" nameId="tpck.1169194664001" value="English" />
            <property name="text" nameId="tpkv.1107866834687" value="English" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639883">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639884">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleInfoDictionaryVersion" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639885">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639886">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="6.0" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639887">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639888">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundlePackageType" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639889">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639890">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="APPL" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639891">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639892">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleSignature" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639893">
          <property name="name" nameId="tpck.1169194664001" value="string" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639894">
            <property name="name" nameId="tpck.1169194664001" value="" />
            <property name="text" nameId="tpkv.1107866834687" value="????" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639895">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639896">
            <property name="name" nameId="tpck.1169194664001" value="CB" />
            <property name="text" nameId="tpkv.1107866834687" value="CFBundleDocumentTypes" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639906">
          <property name="name" nameId="tpck.1169194664001" value="array" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639907">
            <property name="name" nameId="tpck.1169194664001" value="dict" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639908">
              <property name="name" nameId="tpck.1169194664001" value="key" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639909">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="CFBundleTypeExtensions" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639910">
              <property name="name" nameId="tpck.1169194664001" value="array" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639911">
                <property name="name" nameId="tpck.1169194664001" value="string" />
                <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640381">
                  <property name="name" nameId="tpck.1169194664001" value="m" />
                  <property name="text" nameId="tpkv.1107866834687" value="mpr" />
                </node>
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580639979">
              <property name="name" nameId="tpck.1169194664001" value="key" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580639980">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="CFBundleTypeIconFile" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640383">
              <property name="name" nameId="tpck.1169194664001" value="string" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640384">
                <property name="name" nameId="tpck.1169194664001" value="mps.icns" />
                <property name="text" nameId="tpkv.1107866834687" value="mps.icns" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640012">
              <property name="name" nameId="tpck.1169194664001" value="key" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640013">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="CFBundleTypeName" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640386">
              <property name="name" nameId="tpck.1169194664001" value="string" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640387">
                <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS Project" />
                <property name="text" nameId="tpkv.1107866834687" value="JetBrains MPS Project" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640023">
              <property name="name" nameId="tpck.1169194664001" value="key" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640024">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="CFBundleTypeRole" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640389">
              <property name="name" nameId="tpck.1169194664001" value="string" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640390">
                <property name="name" nameId="tpck.1169194664001" value="Editor" />
                <property name="text" nameId="tpkv.1107866834687" value="Editor" />
              </node>
            </node>
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640052">
          <property name="name" nameId="tpck.1169194664001" value="key" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640053">
            <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
            <property name="text" nameId="tpkv.1107866834687" value="Java" />
          </node>
        </node>
        <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640054">
          <property name="name" nameId="tpck.1169194664001" value="dict" />
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640055">
            <property name="name" nameId="tpck.1169194664001" value="key" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640056">
              <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
              <property name="text" nameId="tpkv.1107866834687" value="ClassPath" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640057">
            <property name="name" nameId="tpck.1169194664001" value="string" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640058">
              <property name="name" nameId="tpck.1169194664001" value="" />
              <property name="text" nameId="tpkv.1107866834687" value="$APP_PACKAGE/classpathitem:" />
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580640059">
                <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
                <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580640060">
                  <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580640061">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3885435385580640062">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580640063">
                        <property name="name" nameId="tpck.1169194664001" value="pathString" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="3885435385580640064" />
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640065">
                          <property name="value" nameId="tpee.1070475926801" value="" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3885435385580640066">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580640067">
                        <property name="name" nameId="tpck.1169194664001" value="prefix" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tpee.StringType" typeId="tpee.1225271177708" id="3885435385580640068" />
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640069">
                          <property name="value" nameId="tpee.1070475926801" value="$APP_PACKAGE/" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="3885435385580640070">
                      <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="3885435385580640071">
                        <property name="name" nameId="tpck.1169194664001" value="classPathItemList" />
                        <node role="type" roleId="tpee.5680397130376446158" type="tp25.SNodeListType" typeId="tp25.1145383075378" id="3885435385580640072">
                          <link role="elementConcept" roleId="tp25.1145383142433" targetNodeId="s7om.3885435385580582153" resolveInfo="ClassPathItem" />
                        </node>
                        <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580640075">
                          <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="3885435385580640076" />
                          <node role="operation" roleId="tpee.1197027833540" type="tp25.SLinkListAccess" typeId="tp25.1138056282393" id="5842819808956653746">
                            <link role="link" roleId="tp25.1138056546658" targetNodeId="s7om.3885435385580582696" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tp2q.ForEachStatement" typeId="tp2q.1153943597977" id="3885435385580640080">
                      <node role="variable" roleId="tp2q.1153944400369" type="tp2q.ForEachVariable" typeId="tp2q.1153944193378" id="3885435385580640081">
                        <property name="name" nameId="tpck.1169194664001" value="cpItem" />
                      </node>
                      <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580640082">
                        <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580640083">
                          <node role="expression" roleId="tpee.1068580123156" type="tpee.PlusAssignmentExpression" typeId="tpee.1215695189714" id="3885435385580640084">
                            <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640085">
                              <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640063" resolveInfo="pathString" />
                            </node>
                            <node role="rValue" roleId="tpee.1068498886297" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="3885435385580640086">
                              <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640087">
                                <property name="value" nameId="tpee.1070475926801" value=":" />
                              </node>
                              <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="3885435385580640088">
                                <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640089">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640067" resolveInfo="prefix" />
                                </node>
                                <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580640090">
                                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956653747">
                                    <node role="operand" roleId="tpee.1197027771414" type="tp2q.ForEachVariableReference" typeId="tp2q.1153944233411" id="3885435385580640092">
                                      <link role="variable" roleId="tp2q.1153944258490" targetNodeId="3885435385580640081" resolveInfo="cpItem" />
                                    </node>
                                    <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956653751">
                                      <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582154" resolveInfo="path" />
                                    </node>
                                  </node>
                                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580640094">
                                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dreplace(java%dlang%dCharSequence,java%dlang%dCharSequence)%cjava%dlang%dString" resolveInfo="replace" />
                                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640095">
                                      <property name="value" nameId="tpee.1070475926801" value="\\" />
                                    </node>
                                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640096">
                                      <property name="value" nameId="tpee.1070475926801" value="/" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="inputSequence" roleId="tp2q.1153944424730" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580640097">
                        <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640098">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640071" resolveInfo="classPathItemList" />
                        </node>
                        <node role="operation" roleId="tpee.1197027833540" type="tp2q.CutOperation" typeId="tp2q.1205753590798" id="3885435385580640099">
                          <node role="length" roleId="tp2q.1205753261887" type="tpee.IntegerConstant" typeId="tpee.1068580320020" id="3885435385580640100">
                            <property name="value" nameId="tpee.1068580320021" value="1" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="3885435385580640101">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.PlusAssignmentExpression" typeId="tpee.1215695189714" id="3885435385580640102">
                        <node role="rValue" roleId="tpee.1068498886297" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="3885435385580640103">
                          <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640104">
                            <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640067" resolveInfo="prefix" />
                          </node>
                          <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580640105">
                            <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956701251">
                              <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="3885435385580640107">
                                <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640108">
                                  <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640071" resolveInfo="classPathItemList" />
                                </node>
                                <node role="operation" roleId="tpee.1197027833540" type="tp2q.GetLastOperation" typeId="tp2q.1165595910856" id="3885435385580640109" />
                              </node>
                              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956701255">
                                <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582154" resolveInfo="path" />
                              </node>
                            </node>
                            <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="3885435385580640111">
                              <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dreplace(java%dlang%dCharSequence,java%dlang%dCharSequence)%cjava%dlang%dString" resolveInfo="replace" />
                              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640112">
                                <property name="value" nameId="tpee.1070475926801" value="\\" />
                              </node>
                              <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="3885435385580640113">
                                <property name="value" nameId="tpee.1070475926801" value="/" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="lValue" roleId="tpee.1068498886295" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640114">
                          <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640063" resolveInfo="pathString" />
                        </node>
                      </node>
                    </node>
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="3885435385580640115">
                      <node role="expression" roleId="tpee.1068581517676" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="3885435385580640116">
                        <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="3885435385580640063" resolveInfo="pathString" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640117">
            <property name="name" nameId="tpck.1169194664001" value="key" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640118">
              <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
              <property name="text" nameId="tpkv.1107866834687" value="JVMVersion" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640119">
            <property name="name" nameId="tpck.1169194664001" value="string" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640120">
              <property name="name" nameId="tpck.1169194664001" value="" />
              <property name="text" nameId="tpkv.1107866834687" value="1.6+" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640121">
            <property name="name" nameId="tpck.1169194664001" value="key" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640122">
              <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
              <property name="text" nameId="tpkv.1107866834687" value="MainClass" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640123">
            <property name="name" nameId="tpck.1169194664001" value="string" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640124">
              <property name="name" nameId="tpck.1169194664001" value="c" />
              <property name="text" nameId="tpkv.1107866834687" value="class" />
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580640125">
                <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
                <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580640126">
                  <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580640127">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956653739">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956653741">
                        <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956653740" />
                        <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956653745">
                          <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580631186" resolveInfo="startupClass" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640134">
            <property name="name" nameId="tpck.1169194664001" value="key" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640135">
              <property name="name" nameId="tpck.1169194664001" value="JetBrains MPS $VERSION$ (build $BUILD_VERSION$)" />
              <property name="text" nameId="tpkv.1107866834687" value="Properties" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640136">
            <property name="name" nameId="tpck.1169194664001" value="dict" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640137">
              <property name="name" nameId="tpck.1169194664001" value="key" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640138">
                <property name="name" nameId="tpck.1169194664001" value="a" />
                <property name="text" nameId="tpkv.1107866834687" value="apple.laf.useScreenMenuBar" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640139">
              <property name="name" nameId="tpck.1169194664001" value="string" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640140">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="true" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640141">
              <property name="name" nameId="tpck.1169194664001" value="key" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640142">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="com.apple.mrj.application.live-resize" />
              </node>
            </node>
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640143">
              <property name="name" nameId="tpck.1169194664001" value="string" />
              <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640144">
                <property name="name" nameId="tpck.1169194664001" value="" />
                <property name="text" nameId="tpkv.1107866834687" value="false" />
              </node>
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640145">
            <property name="name" nameId="tpck.1169194664001" value="key" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640146">
              <property name="name" nameId="tpck.1169194664001" value="" />
              <property name="text" nameId="tpkv.1107866834687" value="VMOptions" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640147">
            <property name="name" nameId="tpck.1169194664001" value="string" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640148">
              <property name="name" nameId="tpck.1169194664001" value="" />
              <property name="text" nameId="tpkv.1107866834687" value="VM Options" />
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="3885435385580640149">
                <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
                <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="3885435385580640150">
                  <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="3885435385580640151">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4962066449779484949">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779484951">
                        <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="4962066449779484950" />
                        <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="4962066449779484955">
                          <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956701267" resolveInfo="getDefaultVmoptions" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640158">
            <property name="name" nameId="tpck.1169194664001" value="key" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="3885435385580640159">
              <property name="name" nameId="tpck.1169194664001" value="W" />
              <property name="text" nameId="tpkv.1107866834687" value="WorkingDirectory" />
            </node>
          </node>
          <node role="content" roleId="tpkv.1107866800972" type="tpkv.Element" typeId="tpkv.1107866778860" id="3885435385580640160">
            <property name="name" nameId="tpck.1169194664001" value="string" />
            <node role="content" roleId="tpkv.1107866800972" type="tpkv.Text" typeId="tpkv.1107866821377" id="5842819808956621524">
              <property name="name" nameId="tpck.1169194664001" value="$APP_PACKAGE" />
              <property name="text" nameId="tpkv.1107866834687" value="$APP_PACKAGE" />
              <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="5842819808956621525">
                <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
                <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="5842819808956621526">
                  <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="5842819808956621527">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="5842819808956621528">
                      <node role="expression" roleId="tpee.1068580123156" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="5842819808956621534">
                        <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.DotExpression" typeId="tpee.1197027756228" id="5842819808956621538">
                          <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="5842819808956621537" />
                          <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="5842819808956653532">
                            <link role="property" roleId="tp25.1138056395725" targetNodeId="s7om.3885435385580582155" resolveInfo="startupFolder" />
                          </node>
                        </node>
                        <node role="leftExpression" roleId="tpee.1081773367580" type="tpee.PlusExpression" typeId="tpee.1068581242875" id="5842819808956621530">
                          <node role="leftExpression" roleId="tpee.1081773367580" type="tpf8.TemplateFunctionParameter_templatePropertyValue" typeId="tpf8.1167756221419" id="5842819808956621529" />
                          <node role="rightExpression" roleId="tpee.1081773367579" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="5842819808956621533">
                            <property name="value" nameId="tpee.1070475926801" value="/" />
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
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.RootTemplateAnnotation" typeId="tpf8.1168619357332" id="3885435385580640203">
      <link role="applicableConcept" roleId="tpf8.1168619429071" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
    </node>
    <node role="doctype" roleId="tpkv.1234365333275" type="tpkv.DocumentTypeDeclaration" typeId="tpkv.1234365312778" id="3885435385580640204">
      <property name="name" nameId="tpck.1169194664001" value="plist" />
      <node role="externalID" roleId="tpkv.1234366449577" type="tpkv.PublicId" typeId="tpkv.1234366368307" id="3885435385580640205">
        <property name="publicID" nameId="tpkv.1234366432701" value="-//Apple Computer//DTD PLIST 1.0//EN" />
        <property name="systemID" nameId="tpkv.1234366432703" value="http://www.apple.com/DTDs/PropertyList-1.0.dtd" />
      </node>
    </node>
  </root>
  <root id="4962066449779579859">
    <node role="item" roleId="tpih.1184639733180" type="tpih.GLine" typeId="tpih.1166926309597" id="4962066449779579881">
      <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="4962066449779579882">
        <property name="text" nameId="tpih.1164413036326" value="text" />
      </node>
      <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.CopySrcListMacro" typeId="tpf8.1114729360583" id="4962066449779579885">
        <node role="sourceNodesQuery" roleId="tpf8.1168278589236" type="tpf8.SourceSubstituteMacro_SourceNodesQuery" typeId="tpf8.1167951910403" id="4962066449779579886">
          <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4962066449779579887">
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4962066449779579889">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4962066449779579890">
                <property name="name" nameId="tpck.1169194664001" value="options" />
                <node role="type" roleId="tpee.5680397130376446158" type="tpee.ArrayType" typeId="tpee.1070534760951" id="4962066449779579891">
                  <node role="componentType" roleId="tpee.1070534760952" type="tpee.StringType" typeId="tpee.1225271177708" id="4962066449779579900" />
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779579893">
                  <node role="operand" roleId="tpee.1197027771414" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779579894">
                    <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="4962066449779579895" />
                    <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="4962066449779579896">
                      <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956701267" resolveInfo="getDefaultVmoptions" />
                    </node>
                  </node>
                  <node role="operation" roleId="tpee.1197027833540" type="tpee.InstanceMethodCallOperation" typeId="tpee.1202948039474" id="4962066449779579897">
                    <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="e2lb.~String%dsplit(java%dlang%dString)%cjava%dlang%dString[]" resolveInfo="split" />
                    <node role="actualArgument" roleId="tpee.1068499141038" type="tpee.StringLiteral" typeId="tpee.1070475926800" id="4962066449779579898">
                      <property name="value" nameId="tpee.1070475926801" value="\\s" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tpee.LocalVariableDeclarationStatement" typeId="tpee.1068581242864" id="4962066449779579908">
              <node role="localVariableDeclaration" roleId="tpee.1068581242865" type="tpee.LocalVariableDeclaration" typeId="tpee.1068581242863" id="4962066449779579909">
                <property name="name" nameId="tpck.1169194664001" value="lines" />
                <node role="type" roleId="tpee.5680397130376446158" type="tp2q.ListType" typeId="tp2q.1151688443754" id="4962066449779579910">
                  <node role="elementType" roleId="tp2q.1151688676805" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4962066449779579912">
                    <link role="concept" roleId="tp25.1138405853777" targetNodeId="tpih.1166926309597" resolveInfo="GLine" />
                  </node>
                </node>
                <node role="initializer" roleId="tpee.1068431790190" type="tpee.GenericNewExpression" typeId="tpee.1145552977093" id="4962066449779579914">
                  <node role="creator" roleId="tpee.1145553007750" type="tp2q.ListCreatorWithInit" typeId="tp2q.1160600644654" id="4962066449779579915">
                    <node role="elementType" roleId="tp2q.1237721435807" type="tp25.SNodeType" typeId="tp25.1138055754698" id="4962066449779579916">
                      <link role="concept" roleId="tp25.1138405853777" targetNodeId="tpih.1166926309597" resolveInfo="GLine" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" roleId="tpee.1068581517665" type="tp2q.ForEachStatement" typeId="tp2q.1153943597977" id="4962066449779579902">
              <node role="variable" roleId="tp2q.1153944400369" type="tp2q.ForEachVariable" typeId="tp2q.1153944193378" id="4962066449779579903">
                <property name="name" nameId="tpck.1169194664001" value="option" />
              </node>
              <node role="inputSequence" roleId="tp2q.1153944424730" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4962066449779579906">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4962066449779579890" resolveInfo="options" />
              </node>
              <node role="body" roleId="tpee.1154032183016" type="tpee.StatementList" typeId="tpee.1068580123136" id="4962066449779579905">
                <node role="statement" roleId="tpee.1068581517665" type="tpee.IfStatement" typeId="tpee.1068580123159" id="4962066449779579923">
                  <node role="condition" roleId="tpee.1068580123160" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779579927">
                    <node role="operand" roleId="tpee.1197027771414" type="tp2q.ForEachVariableReference" typeId="tp2q.1153944233411" id="4962066449779579926">
                      <link role="variable" roleId="tp2q.1153944258490" targetNodeId="4962066449779579903" resolveInfo="option" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tpee.IsEmptyOperation" typeId="tpee.1225271369338" id="4962066449779579931" />
                  </node>
                  <node role="ifTrue" roleId="tpee.1068580123161" type="tpee.StatementList" typeId="tpee.1068580123136" id="4962066449779579925">
                    <node role="statement" roleId="tpee.1068581517665" type="tpee.ContinueStatement" typeId="tpee.1082113931046" id="4962066449779579932" />
                  </node>
                </node>
                <node role="statement" roleId="tpee.1068581517665" type="tpee.Statement" typeId="tpee.1068580123157" id="4962066449779579933" />
                <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4962066449779579956">
                  <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779579958">
                    <node role="operand" roleId="tpee.1197027771414" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4962066449779579957">
                      <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4962066449779579909" resolveInfo="lines" />
                    </node>
                    <node role="operation" roleId="tpee.1197027833540" type="tp2q.AddElementOperation" typeId="tp2q.1160612413312" id="4962066449779579962">
                      <node role="argument" roleId="tp2q.1160612519549" type="tp3r.Quotation" typeId="tp3r.1196350785113" id="4962066449779579948">
                        <node role="quotedNode" roleId="tp3r.1196350785114" type="tpih.GLine" typeId="tpih.1166926309597" id="4962066449779579950">
                          <node role="item" roleId="tpih.1166928665191" type="tpih.GText" typeId="tpih.1164412789837" id="4962066449779579951">
                            <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tp3r.PropertyAntiquotation" typeId="tp3r.1196866233735" id="4962066449779579952">
                              <property name="propertyName" nameId="tpck.1757699476691236117" value="text" />
                              <property name="label" nameId="tp3r.6489343236075007666" value="GText" />
                              <node role="expression" roleId="tp3r.1196350785111" type="tp2q.ForEachVariableReference" typeId="tp2q.1153944233411" id="4962066449779579954">
                                <link role="variable" roleId="tp2q.1153944258490" targetNodeId="4962066449779579903" resolveInfo="option" />
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
            <node role="statement" roleId="tpee.1068581517665" type="tpee.ReturnStatement" typeId="tpee.1068581242878" id="4962066449779579920">
              <node role="expression" roleId="tpee.1068581517676" type="tpee.LocalVariableReference" typeId="tpee.1068581242866" id="4962066449779579922">
                <link role="variableDeclaration" roleId="tpee.1068581517664" targetNodeId="4962066449779579909" resolveInfo="lines" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.RootTemplateAnnotation" typeId="tpf8.1168619357332" id="4962066449779579861">
      <link role="applicableConcept" roleId="tpf8.1168619429071" targetNodeId="s7om.3885435385580582152" resolveInfo="MpsStartupScript" />
    </node>
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="4962066449779579862">
      <property name="propertyName" nameId="tpck.1757699476691236117" value="extension" />
      <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="4962066449779579863">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4962066449779579864">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4962066449779579865">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779579867">
              <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="4962066449779579866" />
              <node role="operation" roleId="tpee.1197027833540" type="tp25.Node_ConceptMethodCall" typeId="tp25.1179409122411" id="4962066449779579871">
                <link role="baseMethodDeclaration" roleId="tpee.1068499141037" targetNodeId="tgdw.5842819808956911479" resolveInfo="getVmOptionsExtension" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="smodelAttribute" roleId="tpck.5169995583184591170" type="tpf8.PropertyMacro" typeId="tpf8.1087833241328" id="4962066449779579872">
      <property name="propertyName" nameId="tpck.1757699476691236117" value="documentName" />
      <node role="propertyValueFunction" roleId="tpf8.1167756362303" type="tpf8.PropertyMacro_GetPropertyValue" typeId="tpf8.1167756080639" id="4962066449779579875">
        <node role="body" roleId="tpee.1137022507850" type="tpee.StatementList" typeId="tpee.1068580123136" id="4962066449779579876">
          <node role="statement" roleId="tpee.1068581517665" type="tpee.ExpressionStatement" typeId="tpee.1068580123155" id="4962066449779579877">
            <node role="expression" roleId="tpee.1068580123156" type="tpee.DotExpression" typeId="tpee.1197027756228" id="4962066449779579878">
              <node role="operation" roleId="tpee.1197027833540" type="tp25.SPropertyAccess" typeId="tp25.1138056022639" id="4962066449779579879">
                <link role="property" roleId="tp25.1138056395725" targetNodeId="tpck.1169194664001" resolveInfo="name" />
              </node>
              <node role="operand" roleId="tpee.1197027771414" type="tpf8.TemplateFunctionParameter_sourceNode" typeId="tpf8.1167169188348" id="4962066449779579880" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </root>
</model>

