<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.baseLanguage.sandbox.genTest">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.constraints" version="83" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="webr.logging" />
  <language namespace="jetbrains.mps.baseLanguageInternal" />
  <language namespace="jetbrains.mps.nanoj">
    <languageAspect modelUID="jetbrains.mps.nanoj.constraints" version="45" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.structureLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.structureLanguage.constraints" version="11" />
  </language>
  <languageAspect modelUID="jetbrains.mps.transformationTest.constraints" version="0" />
  <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1" />
  <languageAspect modelUID="webr.templateLanguage.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0" />
  <languageAspect modelUID="jetbrains.mps.core.constraints" version="2" />
  <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.constraints" version="21" />
  <languageAspect modelUID="jetbrains.mps.closures.constraints" version="2" />
  <languageAspect modelUID="jetbrains.mps.baseLanguage.unitTest.constraints" version="1" />
  <maxImportIndex value="17" />
  <import index="14" modelUID="java.lang@java_stub" version="-1" />
  <import index="15" modelUID="java.io@java_stub" version="-1" />
  <import index="16" modelUID="jetbrains.mps.baseLanguage.sandbox.genTest" version="-1" />
  <import index="17" modelUID="java.util@java_stub" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1214554222480">
    <property name="name" value="Fibo" />
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1215091133689">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1215091133690" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215091133691" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215091133692">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215611426564">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215611426565">
            <property name="name" value="abc" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215611426566" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215611369624">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215611369625">
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215611369626" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1215608531941">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1215610375074">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1215610371110">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1215608533568">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1215608531942">
                  <link role="variableDeclaration" targetNodeId="1215601613086" resolveInfo="obj" />
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1215610246136">
                  <link role="baseMethodDeclaration" targetNodeId="14.~Object.toString():java.lang.String" resolveInfo="toString" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1215610373729">
                <link role="baseMethodDeclaration" targetNodeId="14.~String.toString():java.lang.String" resolveInfo="toString" />
              </node>
            </node>
            <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1215610376374">
              <link role="baseMethodDeclaration" targetNodeId="14.~String.toString():java.lang.String" resolveInfo="toString" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599451916">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599451917" />
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599452545">
            <property name="value" value="true" />
          </node>
          <node role="elsifClauses" type="jetbrains.mps.baseLanguage.structure.ElsifClause" id="1215599463956">
            <node role="condition" type="jetbrains.mps.baseLanguage.structure.Expression" id="1215599463957" />
            <node role="statementList" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599463958" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215618939030">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215618939031">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.Statement" id="1215618939032" />
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215618939752">
            <property name="value" value="true" />
          </node>
          <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement" id="1215619340454">
            <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215619340455">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1215619341629">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215619342224">
                  <property name="value" value="2" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1215599448674">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215599450724">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215619194998">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215619195783">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215619196568">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215619196618">
                    <property name="value" value="2" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215619195833">
                    <property name="value" value="2" />
                  </node>
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215619195063">
                  <property name="value" value="2" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599450742">
                <property name="value" value="23" />
              </node>
            </node>
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215618936130">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215618937368">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215618937434">
                  <property name="value" value="2" />
                </node>
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215618936180">
                  <property name="value" value="2" />
                </node>
              </node>
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599449098">
                <property name="value" value="2323" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215592815961">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215592815962">
            <property name="name" value="abcdef" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215592815963" />
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215592822511">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215592823186">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215592918681">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215592921513">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215592922142">
                      <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215592936449">
                        <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215593040930">
                          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.ThisExpression" id="1215593043651" />
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592936483">
                            <property name="value" value="23" />
                          </node>
                        </node>
                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592922160">
                          <property name="value" value="23" />
                        </node>
                      </node>
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592921547">
                        <property name="value" value="23" />
                      </node>
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592920699">
                      <property name="value" value="23" />
                    </node>
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592823236">
                    <property name="value" value="23" />
                  </node>
                </node>
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592822545">
                  <property name="value" value="23" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215592821885">
                <property name="value" value="23" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1215427477608">
        <property name="name" value="abcdef" />
        <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215427477609" />
      </node>
    </node>
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1214554222481" />
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1215188171113">
      <property name="name" value="abcd" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1215188171114" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215188171115" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215188171116">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.Statement" id="1215599085539" />
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1215597235097">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1215597235098">
            <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1215597237412">
              <link role="baseMethodDeclaration" targetNodeId="17.~ArrayList.&lt;init&gt;()" resolveInfo="ArrayList" />
              <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1215597244367">
                <link role="classifier" targetNodeId="14.~String" resolveInfo="String" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1215597110841">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1215597110842">
            <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1215597113000">
              <link role="baseMethodDeclaration" targetNodeId="17.~ArrayList.&lt;init&gt;()" resolveInfo="ArrayList" />
              <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1215597121829">
                <link role="classifier" targetNodeId="14.~String" resolveInfo="String" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599526079">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599526080">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599527491">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599527492">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599528793">
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599528794">
                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599530501">
                      <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599530502">
                        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599532537">
                          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599532538">
                            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599533948">
                              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599533949">
                                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599535829">
                                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599535830">
                                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599537162">
                                      <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599537163">
                                        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215599545478">
                                          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599545479">
                                            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215614294875">
                                              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215614294876">
                                                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215614296708">
                                                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215614296709">
                                                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1215614332239">
                                                      <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215614333945">
                                                        <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215614335230">
                                                          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215614336812">
                                                            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215614338082">
                                                              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614338132">
                                                                <property name="value" value="23" />
                                                              </node>
                                                              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614336862">
                                                                <property name="value" value="23" />
                                                              </node>
                                                            </node>
                                                            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614335327">
                                                              <property name="value" value="23" />
                                                            </node>
                                                          </node>
                                                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614334026">
                                                            <property name="value" value="23" />
                                                          </node>
                                                        </node>
                                                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614332803">
                                                          <property name="value" value="239" />
                                                        </node>
                                                      </node>
                                                    </node>
                                                  </node>
                                                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215614297290">
                                                    <property name="value" value="true" />
                                                  </node>
                                                  <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement" id="1215614306839">
                                                    <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215614306840">
                                                      <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1215614308311">
                                                        <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215614309626">
                                                          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614310270">
                                                            <property name="value" value="23" />
                                                          </node>
                                                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215614308844">
                                                            <property name="value" value="239" />
                                                          </node>
                                                        </node>
                                                      </node>
                                                    </node>
                                                  </node>
                                                </node>
                                              </node>
                                              <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215614295473">
                                                <property name="value" value="true" />
                                              </node>
                                            </node>
                                          </node>
                                          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215614290843">
                                            <property name="value" value="true" />
                                          </node>
                                        </node>
                                        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215599538964">
                                          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215599538965">
                                            <property name="name" value="i" />
                                            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215599538966" />
                                            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215599539984">
                                              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1215599540535">
                                                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.EqualsExpression" id="1215599541774">
                                                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215599543309">
                                                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215599543860">
                                                      <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215599544379">
                                                        <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599544429">
                                                          <property name="value" value="23" />
                                                        </node>
                                                        <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599543894">
                                                          <property name="value" value="23" />
                                                        </node>
                                                      </node>
                                                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599543343">
                                                        <property name="value" value="23" />
                                                      </node>
                                                    </node>
                                                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599542136">
                                                      <property name="value" value="239" />
                                                    </node>
                                                  </node>
                                                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599540569">
                                                    <property name="value" value="2" />
                                                  </node>
                                                </node>
                                                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599540050">
                                                  <property name="value" value="2" />
                                                </node>
                                              </node>
                                              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215599539499">
                                                <property name="value" value="23" />
                                              </node>
                                            </node>
                                          </node>
                                        </node>
                                      </node>
                                      <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599537697">
                                        <property name="value" value="true" />
                                      </node>
                                    </node>
                                  </node>
                                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599536411">
                                    <property name="value" value="true" />
                                  </node>
                                </node>
                              </node>
                              <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599535046">
                                <property name="value" value="true" />
                              </node>
                            </node>
                          </node>
                          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599533135">
                            <property name="value" value="true" />
                          </node>
                        </node>
                      </node>
                      <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599531067">
                        <property name="value" value="true" />
                      </node>
                    </node>
                  </node>
                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599529297">
                    <property name="value" value="true" />
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599527995">
                <property name="value" value="true" />
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215599526755">
            <property name="value" value="true" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1215596775768">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1215596775769">
            <node role="creator" type="jetbrains.mps.baseLanguage.structure.AnonymousClassCreator" id="1215597084839">
              <node role="cls" type="jetbrains.mps.baseLanguage.structure.AnonymousClass" id="1215597084840">
                <link role="classifier" targetNodeId="14.~Object" resolveInfo="Object" />
                <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215597084841" />
                <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1215598086712">
                  <property name="name" value="abcdef" />
                  <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility" id="1215598086713" />
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215598087575" />
                </node>
                <node role="field" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration" id="1215598048966">
                  <property name="name" value="abcdef" />
                  <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility" id="1215598048967" />
                  <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215598050656" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215547460523">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215547460524">
            <property name="name" value="abc" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ArrayType" id="1215547463182">
              <node role="componentType" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215547460525" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215430086972">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215430086973" />
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215430088039">
            <property name="value" value="true" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215201483039">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215201483040">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215201497395">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215201497396">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1215201501999">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215201503627">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215201503661">
                      <property name="value" value="23" />
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215201502626">
                      <property name="value" value="239" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215201497930">
                <property name="value" value="true" />
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1215201484341">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215201484342">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1215201486017">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215201487864">
                    <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215201490774">
                      <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1215201493402">
                        <node role="expression" type="jetbrains.mps.baseLanguage.structure.PlusExpression" id="1215201494874">
                          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215201494971">
                            <property name="value" value="23" />
                          </node>
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215201494045">
                            <property name="value" value="23" />
                          </node>
                        </node>
                      </node>
                      <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215201488008">
                        <property name="value" value="23" />
                      </node>
                    </node>
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.IntegerConstant" id="1215201486410">
                      <property name="value" value="239" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215201484891">
                <property name="value" value="true" />
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1215201483246">
            <property name="value" value="true" />
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215201107128">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215201107129">
            <property name="name" value="l" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ArrayType" id="1215262789368">
              <node role="componentType" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215262792698" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215201083613">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215201083614">
            <property name="name" value="j" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ArrayType" id="1215262796449">
              <node role="componentType" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215201083615" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215201085070">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215201085071">
            <property name="name" value="k" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215201085072" />
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" id="1215201089606">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1215201089607" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215201089608" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215201089609">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1215201091001">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1215201091002">
            <property name="name" value="l" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.IntegerType" id="1215201091003" />
          </node>
        </node>
      </node>
    </node>
    <node role="method" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" id="1215599087444">
      <property name="name" value="abcdef" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1215599087445" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215599087446" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215599087447" />
    </node>
  </node>
  <node type="jetbrains.mps.nanoj.structure.ClassConcept" id="1215176056885">
    <property name="name" value="ABC" />
    <node role="method" type="jetbrains.mps.nanoj.structure.InstanceMethod" id="1215176060108">
      <property name="name" value="abcdef" />
      <node role="type" type="jetbrains.mps.nanoj.structure.VoidType" id="1215176060109" />
      <node role="body" type="jetbrains.mps.nanoj.structure.StatementList" id="1215176060110" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept" id="1215542589224">
    <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215542589225" />
    <node role="constructor" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" id="1215542589226">
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1215542589227" />
      <node role="visibility" type="jetbrains.mps.baseLanguage.structure.PublicVisibility" id="1215542589228" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1215542589229" />
    </node>
  </node>
</model>

