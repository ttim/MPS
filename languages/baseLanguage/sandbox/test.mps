<?xml version="1.0" encoding="UTF-8"?>
<model namespace="jetbrains.mps.baseLanguage.sandbox">
  <maxReferenceID value="1" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <import referenceID="1" name="lang" namespace="java" />
  <node type="jetbrains.mps.baseLanguage.Interface" id="1107798112109">
    <property name="name" value="MyInterface1" />
    <node role="method" type="jetbrains.mps.baseLanguage.InstanceMethodDeclaration" id="1108072220361">
      <property name="name" value="c1_method1" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1108072230878" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1108072220360" />
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.InstanceMethodDeclaration" id="1107798125190">
      <property name="name" value="i1_method1" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1107798236213" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1107798125189" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.Interface" id="1107798291253">
    <property name="name" value="MyInterface2" />
    <node role="method" type="jetbrains.mps.baseLanguage.InstanceMethodDeclaration" id="1107798308803">
      <property name="name" value="i2_method1" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1107798330899" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1107804546450" />
    </node>
    <node role="extendedInterface" type="jetbrains.mps.baseLanguage.InterfaceType" id="1107798301770">
      <link role="classifier" targetNodeId="1107798112109" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.ClassConcept" id="1107799696578">
    <property name="name" value="MyClass1" />
    <node role="constructor" type="jetbrains.mps.baseLanguage.ConstructorDeclaration" id="1107804670837">
      <node role="returnType" type="jetbrains.mps.baseLanguage.Type" id="1107805405537" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1107804671822" />
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1107804600891">
      <property name="name" value="test" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1107804609597">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1107804749521">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1107804718170">
            <property name="name" value="c1" />
            <node role="type" type="jetbrains.mps.baseLanguage.ClassType" id="1107804718169">
              <link role="classifier" targetNodeId="1107799696578" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NewExpression" id="1107805405538">
              <node role="constructorCall" type="jetbrains.mps.baseLanguage.ConstructorCall" id="1107804725031">
                <link role="baseMethodDeclaration" targetNodeId="1107804670837" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1107908942130">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1107908937283">
            <property name="name" value="c2" />
            <node role="type" type="jetbrains.mps.baseLanguage.ClassType" id="1107908937282">
              <link role="classifier" targetNodeId="1107799696578" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NullLiteral" id="1107908942129" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1107911157354">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1107911152820">
            <property name="name" value="iiii" />
            <node role="type" type="jetbrains.mps.baseLanguage.LongType" id="1107911169983" />
            <node role="initializer" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1107911180234">
              <link role="variableDeclaration" targetNodeId="1107804718170" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1107908955448">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1107908951039">
            <property name="name" value="ii1" />
            <node role="type" type="jetbrains.mps.baseLanguage.InterfaceType" id="1107908951038">
              <link role="classifier" targetNodeId="1107798112109" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NullLiteral" id="1107908955447" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1107805405539">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1107804621959">
            <property name="name" value="i1" />
            <node role="type" type="jetbrains.mps.baseLanguage.InterfaceType" id="1107804621958">
              <link role="classifier" targetNodeId="1107798112109" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NewExpression" id="1107805405540">
              <node role="constructorCall" type="jetbrains.mps.baseLanguage.ConstructorCall" id="1107804636445">
                <link role="baseMethodDeclaration" targetNodeId="1107804670837" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1107804742957">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1107804739566">
            <property name="name" value="i2" />
            <node role="type" type="jetbrains.mps.baseLanguage.InterfaceType" id="1107804739565">
              <link role="classifier" targetNodeId="1107798291253" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.NewExpression" id="1107910636597">
              <node role="constructorCall" type="jetbrains.mps.baseLanguage.ConstructorCall" id="1107910582190">
                <link role="baseMethodDeclaration" targetNodeId="1107804670837" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1108056261008">
          <node role="expression" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1108056266135">
            <link role="baseMethodDeclaration" targetNodeId="1107798125190" />
            <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1108056261007">
              <link role="variableDeclaration" targetNodeId="1107804718170" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1108073009517">
          <node role="expression" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1108073015535">
            <link role="baseMethodDeclaration" targetNodeId="1108072220361" />
            <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1108073640437">
              <link role="variableDeclaration" targetNodeId="1107804621959" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1108057328902">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1108057766847" />
          <node role="condition" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1108057337281">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1108057339799" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1108073660376">
              <link role="variableDeclaration" targetNodeId="1107804621959" />
            </node>
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1107804605393" />
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.StaticMethodDeclaration" id="1108145568859">
      <property name="name" value="test2" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1108145581503" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1108145576814" />
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.InstanceMethodDeclaration" id="1107804569312">
      <property name="name" value="c1_method1" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1107804672136" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1107804569311" />
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.InstanceMethodDeclaration" id="1108056226176">
      <property name="name" value="c1_method2" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1108056216784" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1108056217566" />
    </node>
    <node role="implementedInterface" type="jetbrains.mps.baseLanguage.InterfaceType" id="1107799709954">
      <link role="classifier" targetNodeId="1107798112109" />
    </node>
    <node role="implementedInterface" type="jetbrains.mps.baseLanguage.InterfaceType" id="1107799712220">
      <link role="classifier" targetNodeId="1107798291253" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.ClassConcept" id="1109202018158">
    <property name="name" value="Test_Generics" />
    <node role="method" type="jetbrains.mps.baseLanguage.InstanceMethodDeclaration" id="1109202040317">
      <property name="name" value="method" />
      <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1109202043552">
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1109202122479">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1109202116963">
            <property name="name" value="aaa" />
            <node role="type" type="jetbrains.mps.baseLanguage.ClassType" id="1109202106383">
              <link role="classifier" targetNodeId="1109202018158" />
              <node role="parameter" type="jetbrains.mps.baseLanguage.ClassType" id="1109202116337">
                <link role="classifier" targetNodeId="1107799696578" />
              </node>
              <node role="parameter" type="jetbrains.mps.baseLanguage.ClassType" id="1109204654375">
                <link role="classifier" targetNodeId="1.1087811447849" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1109204730681">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1109204664284">
            <property name="name" value="bbb" />
            <node role="type" type="jetbrains.mps.baseLanguage.ClassType" id="1109204664283">
              <link role="classifier" targetNodeId="1109202018158" />
              <node role="parameter" type="jetbrains.mps.baseLanguage.BooleanType" id="1109204699926" />
              <node role="parameter" type="jetbrains.mps.baseLanguage.ClassType" id="1109204729321">
                <link role="classifier" targetNodeId="1.1087811447849" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1109204785532">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1109204778810">
            <property name="name" value="iii" />
            <node role="type" type="jetbrains.mps.baseLanguage.InterfaceType" id="1109204778809">
              <link role="classifier" targetNodeId="1107798112109" />
              <node role="parameter" type="jetbrains.mps.baseLanguage.ByteType" id="1109204784953" />
            </node>
          </node>
        </node>
      </node>
      <node role="returnType" type="jetbrains.mps.baseLanguage.VoidType" id="1109202040316" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.Interface" id="1109281248484">
    <property name="name" value="MyGenericInterface" />
    <node role="typeVariableDeclaration" type="jetbrains.mps.baseLanguage.TypeVariableDeclaration" id="1109281830015">
      <property name="name" value="T" />
    </node>
    <node role="typeVariableDeclaration" type="jetbrains.mps.baseLanguage.TypeVariableDeclaration" id="1109281834454">
      <property name="name" value="E" />
    </node>
  </node>
</model>

