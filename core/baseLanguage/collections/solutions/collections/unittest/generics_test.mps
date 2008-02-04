<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.baseLanguage.ext.collections.unittest.generics_test">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang" />
  <language namespace="jetbrains.mps.baseLanguage.unitTest" />
  <maxImportIndex value="3" />
  <import index="1" modelUID="java.lang@java_stub" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1170878927223">
    <property name="name" value="MySequence" />
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1170878984788">
      <property name="name" value="get" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceType" id="1170879087418">
        <node role="elementType" type="jetbrains.mps.baseLanguage.structure.TypeVariableReference" id="1170879089295">
          <link role="typeVariableDeclaration" targetNodeId="1170878969084" resolveInfo="T" />
        </node>
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170878984790">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170878998354">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1170879044935">
            <node role="creator" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceCreatorWithSupplier" id="1170879048265">
              <node role="supplier" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ValueSupplierBlock" id="1170879048266">
                <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879048267">
                  <node role="statement" type="jetbrains.mps.baseLanguage.structure.WhileStatement" id="1170879058955">
                    <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1170879101984">
                      <property name="value" value="true" />
                    </node>
                    <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879058957">
                      <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1170879687723">
                        <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1170879687724">
                          <property name="name" value="next" />
                          <node role="type" type="jetbrains.mps.baseLanguage.structure.TypeVariableReference" id="1170879751040">
                            <link role="typeVariableDeclaration" targetNodeId="1170878969084" resolveInfo="T" />
                          </node>
                          <node role="initializer" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall" id="1170879451050">
                            <link role="baseMethodDeclaration" targetNodeId="1170879062052" resolveInfo="getNext" />
                            <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170879451051" />
                          </node>
                        </node>
                      </node>
                      <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1170879711714">
                        <node role="condition" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1170879715328">
                          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1170879717159" />
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1170879713999">
                            <link role="variableDeclaration" targetNodeId="1170879687724" resolveInfo="next" />
                          </node>
                        </node>
                        <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879711716">
                          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.TraversalStopStatement" id="1170879720785" />
                        </node>
                      </node>
                      <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.TraversalYieldStatement" id="1170879727334">
                        <node role="value" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1170879730305">
                          <link role="variableDeclaration" targetNodeId="1170879687724" resolveInfo="next" />
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
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1170879062052">
      <property name="name" value="getNext" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.TypeVariableReference" id="1170879071180">
        <link role="typeVariableDeclaration" targetNodeId="1170878969084" resolveInfo="T" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879062054">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170879079306">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1170879081152" />
        </node>
      </node>
    </node>
    <node role="typeVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration" id="1170878969084">
      <property name="name" value="T" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1170879883276">
    <property name="name" value="BooleanSequence" />
    <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1170879927240">
      <property name="name" value="myCount" />
      <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1170879929008" />
      <node role="initializer" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1170879936416">
        <property name="value" value="0" />
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1170879915003">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.Type" id="1170879915004" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879915005" />
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1170879903124">
      <property name="name" value="getNext" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1170879907908">
        <link role="classifier" targetNodeId="1.~Boolean" resolveInfo="Boolean" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879903126">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1170879946355">
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.LessThanExpression" id="1170880099041">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880085315">
              <link role="variableDeclaration" targetNodeId="1170879927240" resolveInfo="myCount" />
              <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880085316" />
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1170880092570">
              <property name="value" value="5" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170879946357">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1170880107999">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1170880109330">
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1170880112867">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1170880113839">
                    <property name="value" value="1" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880111553">
                    <link role="variableDeclaration" targetNodeId="1170879927240" resolveInfo="myCount" />
                    <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880111554" />
                  </node>
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880108000">
                  <link role="variableDeclaration" targetNodeId="1170879927240" resolveInfo="myCount" />
                  <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880108001" />
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170880094711">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1170880472434">
                <property name="value" value="true" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170880188056">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1170880190136" />
        </node>
      </node>
    </node>
    <node role="superclass" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1170879893309">
      <link role="classifier" targetNodeId="1170878927223" resolveInfo="MySequence" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1170879899248">
        <link role="classifier" targetNodeId="1.~Boolean" resolveInfo="Boolean" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1170880204174">
    <property name="name" value="IntegerSequence" />
    <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1170880204175">
      <property name="name" value="myCount" />
      <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1170880204176" />
      <node role="initializer" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1170884550089">
        <property name="value" value="-1" />
      </node>
    </node>
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1170880204178">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.Type" id="1170880204179" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170880204180" />
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1170880204181">
      <property name="name" value="getNext" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1170880227446">
        <link role="classifier" targetNodeId="1.~Integer" resolveInfo="Integer" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170880204183">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1170880204184">
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.LessThanExpression" id="1170880204185">
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880204186">
              <link role="variableDeclaration" targetNodeId="1170880204175" resolveInfo="myCount" />
              <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880204187" />
            </node>
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1170880204188">
              <property name="value" value="5" />
            </node>
          </node>
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1170880204189">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1170880204190">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1170880204191">
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1170880204192">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1170880204193">
                    <property name="value" value="1" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880204194">
                    <link role="variableDeclaration" targetNodeId="1170880204175" resolveInfo="myCount" />
                    <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880204195" />
                  </node>
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880204196">
                  <link role="variableDeclaration" targetNodeId="1170880204175" resolveInfo="myCount" />
                  <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880204197" />
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170880204198">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.FieldReference" id="1170880493077">
                <link role="variableDeclaration" targetNodeId="1170880204175" resolveInfo="myCount" />
                <node role="instance" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1170880493078" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1170880204207">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1170880204208" />
        </node>
      </node>
    </node>
    <node role="superclass" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1170880204209">
      <link role="classifier" targetNodeId="1170878927223" resolveInfo="MySequence" />
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1170880215836">
        <link role="classifier" targetNodeId="1.~Integer" resolveInfo="Integer" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.unitTest.structure.BTestCase" id="1172029167443">
    <property name="testCaseName" value="Generics1" />
    <node role="testMethodList" type="jetbrains.mps.baseLanguage.unitTest.structure.TestMethodList" id="1172029167444">
      <node role="testMethod" type="jetbrains.mps.baseLanguage.unitTest.structure.TestMethod" id="1172029180836">
        <property name="methodName" value="test1" />
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1172029180837">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1172029188738">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1172029188739">
              <property name="name" value="bools" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1172029188740">
                <link role="classifier" targetNodeId="1170879883276" resolveInfo="BooleanSequence" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1172029188741">
                <link role="baseMethodDeclaration" targetNodeId="1170879915003" resolveInfo="BooleanSequence" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement" id="1172029188742">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable" id="1172029188743">
              <property name="name" value="bool" />
            </node>
            <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall" id="1172029188744">
              <link role="baseMethodDeclaration" targetNodeId="1170878984788" resolveInfo="get" />
              <node role="instance" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1172029188745">
                <link role="variableDeclaration" targetNodeId="1172029188739" resolveInfo="bools" />
              </node>
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1172029188746">
              <node role="statement" type="jetbrains.mps.baseLanguage.unitTest.structure.AssertTrue" id="1172029260167">
                <node role="condition" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall" id="1172029269302">
                  <link role="baseMethodDeclaration" targetNodeId="1.~Boolean.booleanValue():boolean" resolveInfo="booleanValue" />
                  <node role="instance" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1172029269303">
                    <link role="variable" targetNodeId="1172029188743" resolveInfo="bool" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1198168231473" />
      </node>
      <node role="testMethod" type="jetbrains.mps.baseLanguage.unitTest.structure.TestMethod" id="1172029195858">
        <property name="methodName" value="test2" />
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1172029195859">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1172029203862">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1172029203863">
              <property name="name" value="ints" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1172029203864">
                <link role="classifier" targetNodeId="1170880204174" resolveInfo="IntegerSequence" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1172029203865">
                <link role="baseMethodDeclaration" targetNodeId="1170880204178" resolveInfo="IntegerSequence" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1172029203866">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1172029203867">
              <property name="name" value="count" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1172029203868" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1172029203869">
                <property name="value" value="0" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement" id="1172029203870">
            <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable" id="1172029203871">
              <property name="name" value="i" />
            </node>
            <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall" id="1172029203872">
              <link role="baseMethodDeclaration" targetNodeId="1170878984788" resolveInfo="get" />
              <node role="instance" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1172029203873">
                <link role="variableDeclaration" targetNodeId="1172029203863" resolveInfo="ints" />
              </node>
            </node>
            <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1172029203874">
              <node role="statement" type="jetbrains.mps.baseLanguage.unitTest.structure.AssertEquals" id="1172029277744">
                <node role="expected" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1172029280997">
                  <link role="variableDeclaration" targetNodeId="1172029203867" resolveInfo="count" />
                </node>
                <node role="actual" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCall" id="1172029288407">
                  <link role="baseMethodDeclaration" targetNodeId="1.~Integer.intValue():int" resolveInfo="intValue" />
                  <node role="instance" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference" id="1172029284779">
                    <link role="variable" targetNodeId="1172029203871" resolveInfo="i" />
                  </node>
                </node>
              </node>
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1172029203880">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1172029203881">
                  <node role="rValue" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1172029203882">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1172029203883">
                      <property name="value" value="1" />
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1172029203884">
                      <link role="variableDeclaration" targetNodeId="1172029203867" resolveInfo="count" />
                    </node>
                  </node>
                  <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1172029203885">
                    <link role="variableDeclaration" targetNodeId="1172029203867" resolveInfo="count" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1198168231503" />
      </node>
    </node>
  </node>
</model>

