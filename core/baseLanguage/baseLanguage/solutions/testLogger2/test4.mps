<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:00000000-0000-4000-0000-011c895903a8(test4)">
  <persistence version="3" />
  <refactoringHistory />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <maxImportIndex value="3" />
  <import index="1" modelUID="r:00000000-0000-4000-0000-011c895903a5(test2)" version="-1" />
  <import index="2" modelUID="f:java_stub#jetbrains.mps.util(jetbrains.mps.util@java_stub)" version="-1" />
  <import index="3" modelUID="f:java_stub#java.util(java.util@java_stub)" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1191320829704">
    <property name="name" value="D" />
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1194436425013">
      <property name="name" value="foo" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1194436425014" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1194436425015" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1194436425016">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1194436487473">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1194436487474">
            <property name="name" value="n" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1194436487475">
              <link role="classifier" targetNodeId="3.~Map" resolveInfo="Map" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1217888382293">
              <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1217888382295">
                <link role="baseMethodDeclaration" targetNodeId="3.~HashMap.&lt;init&gt;()" resolveInfo="HashMap" />
                <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.TypeVariableReference" id="1194436502765">
                  <link role="typeVariableDeclaration" targetNodeId="1194436419997" resolveInfo="T" />
                </node>
                <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.TypeVariableReference" id="1194436505313">
                  <link role="typeVariableDeclaration" targetNodeId="1194436419997" resolveInfo="T" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1224501432822">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1224501432823">
            <property name="name" value="i" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1224501432824" />
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1224501433544">
              <property name="value" value="23" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1224501434500">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.BitwiseOrOperation" id="1224501435908">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.BitwiseOrOperation" id="1224501437287">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1224501435926">
                <property name="value" value="23" />
              </node>
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1224501437383">
                <property name="value" value="3" />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1224501434501">
              <property name="value" value="23" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1191320829705" />
    <node role="superclass" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1191320861257">
      <link role="classifier" targetNodeId="1.1191320001477" />
    </node>
    <node role="typeVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration" id="1194436419997">
      <property name="name" value="T" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1191327613036">
    <property name="name" value="E" />
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1191327613037" />
    <node role="superclass" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1191327616147">
      <link role="classifier" targetNodeId="1.1191327608581" />
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1224155144570">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1224155144571" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1224155144572" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1224155144573">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1224158517544">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1224158517545">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.Statement" id="1224158517546" />
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1224158518173">
            <property name="value" value="true" />
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

