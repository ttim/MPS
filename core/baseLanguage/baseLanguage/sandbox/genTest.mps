<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:00000000-0000-4000-0000-011c89590393(jetbrains.mps.baseLanguage.sandbox.genTest)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="760a0a8c-eabb-4521-8bfd-65db761a9ba3(jetbrains.mps.baseLanguage.logging)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895905dc(jetbrains.mps.nanoj.constraints)" version="45" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895903fe(jetbrains.mps.baseLanguage.strings.constraints)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590382(jetbrains.mps.lang.test.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:da6483b0-ff12-4b51-a8d8-a0f7e08483f2(webr.templateLanguage.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902d2(jetbrains.mps.baseLanguage.unitTest.constraints)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895903e4(jetbrains.mps.internal.collections.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895903ac(jetbrains.mps.baseLanguageInternal.structure)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959057f(jetbrains.mps.baseLanguage.logging.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590402(jetbrains.mps.baseLanguage.strings.structure)" version="9" />
  <devkit namespace="fbc25dd2-5da4-483a-8b19-70928e1b62d7(jetbrains.mps.devkit.general-purpose)" />
  <maxImportIndex value="19" />
  <import index="14" modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <import index="18" modelUID="f:java_stub#jetbrains.mps.util(jetbrains.mps.util@java_stub)" version="-1" />
  <import index="19" modelUID="f:java_stub#jetbrains.mps.cache(jetbrains.mps.cache@java_stub)" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="3764553758271149919">
    <property name="name:3" value="Foo" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="3427990840445106141">
      <property name="name:3" value="bar" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3427990840445106142" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3427990840445106143" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3427990840445106144">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3427990840445467882">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="3427990840445467883">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.AnonymousClassCreator:3" id="3427990840445467885">
              <node role="cls:3" type="jetbrains.mps.baseLanguage.structure.AnonymousClass:3" id="3427990840445467886">
                <property name="nonStatic:3" value="true" />
                <link role="classifier:3" targetNodeId="19.~AbstractCache$DataSetCreator" resolveInfo="AbstractCache.DataSetCreator" />
                <link role="baseMethodDeclaration:3" targetNodeId="14.~Object.&lt;init&gt;()" resolveInfo="Object" />
                <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3427990840445467887" />
                <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3427990840445467888">
                  <property name="isAbstract:3" value="false" />
                  <property name="name:3" value="create" />
                  <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3427990840445467889" />
                  <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3427990840445467890">
                    <link role="classifier:3" targetNodeId="19.~DataSet" resolveInfo="DataSet" />
                  </node>
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3427990840445467891">
                    <property name="name:3" value="p0" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3427990840445467892">
                      <link role="classifier:3" targetNodeId="14.~Object" />
                    </node>
                  </node>
                  <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3427990840445467893" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="8149292034787910838">
      <property name="name:3" value="bar" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="8149292034787910839" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="8149292034787910840" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="8149292034787910841" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="8149292034787923618">
        <property name="name:3" value="i" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="8149292034787923619" />
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3764553758271149920" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="3764553758271149921">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3764553758271149922" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3764553758271149923" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3764553758271149924" />
    </node>
  </node>
</model>

