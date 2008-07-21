<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.transformationTest.test">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.transformationTest">
    <languageAspect modelUID="jetbrains.mps.transformationTest.constraints" version="0" />
    <languageAspect modelUID="jetbrains.mps.transformationTest.structure" version="1" />
  </language>
  <language namespace="jetbrains.mps.core">
    <languageAspect modelUID="jetbrains.mps.core.constraints" version="2" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.constraints" version="83" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.constraints" version="21" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.constraints" version="6" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1" />
  </language>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.baseLanguage.unitTest.constraints" version="1" />
  <languageAspect modelUID="jetbrains.mps.closures.constraints" version="2" />
  <languageAspect modelUID="jetbrains.mps.internal.collections.constraints" version="2" />
  <maxImportIndex value="2" />
  <import index="1" modelUID="java.util.regex@java_stub" version="-1" />
  <import index="2" modelUID="java.nio@java_stub" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1210841413989">
    <property name="name" value="cs1" />
    <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1210841423933">
      <property name="name" value="f" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility" id="1210841423934" />
      <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1210841426800" />
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1210841413990" />
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1216060197773">
      <property name="name" value="fib" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1216060197774" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1216060197775" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216060197776">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1216636534989">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1216636534990">
            <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1216636534991">
              <link role="baseMethodDeclaration" targetNodeId="1216636521770" resolveInfo="foo" />
            </node>
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1216636534992" />
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1216636521770">
      <property name="name" value="foo" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1216636521771" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1216636521772" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216636521773">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1216636525024">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1216636525025">
            <property name="name" value="a" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1216636525026" />
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1216636527465">
              <property name="value" value="10" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1216636529311">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1216636529595">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1216636529676">
              <property name="value" value="1" />
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1216636529312">
              <link role="variableDeclaration" targetNodeId="1216636525025" resolveInfo="a" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1216555790494">
    <property name="name" value="BadReadAction" />
    <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1216555839003">
      <property name="name" value="field" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility" id="1216555839004" />
      <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1216555846710" />
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1216555790495" />
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1216555790496">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1216555790497" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1216555790498" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216555790499">
        <node role="statement" type="jetbrains.mps.bootstrap.smodelLanguage.structure.ExecuteLightweightCommandStatement" id="1216555825117">
          <node role="commandClosureLiteral" type="jetbrains.mps.bootstrap.smodelLanguage.structure.CommandClosureLiteral" id="1216555825118">
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216555825119">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1216555831605">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1216555832952">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1216555831606" />
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation" id="1216555855930">
                    <link role="fieldDeclaration" targetNodeId="1216555839003" resolveInfo="field" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1216561660079">
    <property name="name" value="ForEach" />
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1216561660080" />
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1216561660081">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1216561660082" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1216561660083" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216561660084">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1216561926116">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1216561926117">
            <property name="name" value="list" />
            <node role="type" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ListType" id="1216561926118">
              <node role="elementType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1216561936355">
                <link role="classifier" targetNodeId="2.~IntBuffer" resolveInfo="IntBuffer" />
              </node>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1216561958705" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement" id="1216561909576">
          <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable" id="1216561909577">
            <property name="name" value="a" />
          </node>
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1216561909579">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1216561980919">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1216561981089">
                <node role="operand" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1216561980920">
                  <link role="variable" targetNodeId="1216561909577" resolveInfo="a" />
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1216561985265">
                  <link role="baseMethodDeclaration" targetNodeId="2.~IntBuffer.toString():java.lang.String" resolveInfo="toString" />
                </node>
              </node>
            </node>
          </node>
          <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1216561952592">
            <link role="variableDeclaration" targetNodeId="1216561926117" resolveInfo="list" />
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

