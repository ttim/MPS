<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:14f06230-41df-42af-9a25-81de46539bf1(jetbrains.mps.build.workflow.accessories)" doNotGenerate="true">
  <persistence version="7" />
  <language namespace="698a8d22-a104-47a0-ba8d-10e3ec237f13(jetbrains.mps.build.workflow)" />
  <language namespace="b401a680-8325-4110-8fd3-84331ff25bef(jetbrains.mps.lang.generator)" />
  <devkit namespace="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  <import index="8xvf" modelUID="r:ed179f4d-7cf2-479d-8348-50c1fc63b96a(jetbrains.mps.build.workflow.structure)" version="0" />
  <import index="tpck" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" implicit="yes" />
  <roots>
    <node type="8xvf.BwfTaskLibrary" typeId="8xvf.7306485738221391506" id="7306485738221408314">
      <property name="name" nameId="tpck.1169194664001" value="java" />
    </node>
    <node type="8xvf.BwfTaskLibrary" typeId="8xvf.7306485738221391506" id="7306485738221408315">
      <property name="name" nameId="tpck.1169194664001" value="common" />
    </node>
  </roots>
  <root id="7306485738221408314">
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390862">
      <property name="name" nameId="tpck.1169194664001" value="compileJava" />
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390870">
      <property name="name" nameId="tpck.1169194664001" value="processResources" />
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390868">
      <property name="name" nameId="tpck.1169194664001" value="classes" />
      <node role="dependencies" roleId="8xvf.2769948622284574302" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221390872">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390862" resolveInfo="compileJava" />
      </node>
      <node role="dependencies" roleId="8xvf.2769948622284574302" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221390874">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390870" resolveInfo="processResources" />
      </node>
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390876">
      <property name="name" nameId="tpck.1169194664001" value="assemble" />
      <node role="dependencies" roleId="8xvf.2769948622284574302" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221390878">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390868" resolveInfo="classes" />
      </node>
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390885">
      <property name="name" nameId="tpck.1169194664001" value="test" />
      <node role="dependencies" roleId="8xvf.2769948622284574302" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221390894">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390868" resolveInfo="classes" />
      </node>
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390881">
      <property name="name" nameId="tpck.1169194664001" value="check" />
      <node role="dependencies" roleId="8xvf.2769948622284574302" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221390896">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390885" resolveInfo="test" />
      </node>
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTaskPart" typeId="8xvf.3961775458390032824" id="7306485738221408319">
      <link role="task" roleId="8xvf.3961775458390032825" targetNodeId="7306485738221408317" resolveInfo="build" />
      <node role="additionalDependencies" roleId="8xvf.3961775458390352322" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221455027">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390881" resolveInfo="check" />
      </node>
      <node role="additionalDependencies" roleId="8xvf.3961775458390352322" type="8xvf.BwfTaskDependency" typeId="8xvf.2769948622284574294" id="7306485738221455029">
        <link role="target" roleId="8xvf.2769948622284574295" targetNodeId="7306485738221390876" resolveInfo="assemble" />
      </node>
    </node>
    <node role="imports" roleId="8xvf.7306485738221455030" type="8xvf.BwfTaskLibraryDependency" typeId="8xvf.7306485738221471031" id="7306485738221487426">
      <link role="target" roleId="8xvf.7306485738221471032" targetNodeId="7306485738221408315" resolveInfo="common" />
    </node>
  </root>
  <root id="7306485738221408315">
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221408317">
      <property name="name" nameId="tpck.1169194664001" value="build" />
    </node>
    <node role="parts" roleId="8xvf.7306485738221391508" type="8xvf.BwfTask" typeId="8xvf.2769948622284546675" id="7306485738221390898">
      <property name="name" nameId="tpck.1169194664001" value="clean" />
    </node>
  </root>
</model>

