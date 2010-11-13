<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:aa7e8178-3b66-4295-bcce-165c85d78006(jetbrains.mps.stubs.javastub)">
  <persistence version="5" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="7866978e-a0f0-4cc7-81bc-4d213d9375e1(jetbrains.mps.lang.smodel)" />
  <language namespace="3a13115c-633c-4c5c-bbcc-75c4219e9555(jetbrains.mps.lang.quotation)" />
  <language namespace="ceab5195-25ea-4f22-9b92-103b95ca8c0c(jetbrains.mps.lang.core)" />
  <language namespace="7a5dda62-9140-4668-ab76-d5ed1746f2b2(jetbrains.mps.lang.typesystem)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="760a0a8c-eabb-4521-8bfd-65db761a9ba3(jetbrains.mps.baseLanguage.logging)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:aa7e8178-3b66-4295-bcce-165c85d78006(jetbrains.mps.stubs.javastub)" version="-1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <maxImportIndex value="15" />
  <import index="1" modelUID="f:java_stub#jetbrains.mps.logging(jetbrains.mps.logging@java_stub)" version="-1" />
  <import index="2" modelUID="f:java_stub#jetbrains.mps.reloading(jetbrains.mps.reloading@java_stub)" version="-1" />
  <import index="3" modelUID="f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)" version="-1" />
  <import index="4" modelUID="f:java_stub#java.util(java.util@java_stub)" version="-1" />
  <import index="5" modelUID="f:java_stub#jetbrains.mps.baseLanguage.structure(jetbrains.mps.baseLanguage.structure@java_stub)" version="-1" />
  <import index="6" modelUID="f:java_stub#jetbrains.mps.util(jetbrains.mps.util@java_stub)" version="-1" />
  <import index="7" modelUID="f:java_stub#org.objectweb.asm(org.objectweb.asm@java_stub)" version="-1" />
  <import index="9" modelUID="r:eafb5d8e-2952-4826-b4ad-be2b9011f598(jetbrains.mps.stubs.javastub.asm)" version="-1" />
  <import index="10" modelUID="f:java_stub#jetbrains.mps.stubs.javastub.asm(jetbrains.mps.stubs.javastub.asm@java_stub)" version="-1" />
  <import index="11" modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <import index="12" modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <import index="13" modelUID="f:java_stub#jetbrains.mps.stubs.javastub.classpath(jetbrains.mps.stubs.javastub.classpath@java_stub)" version="-1" />
  <import index="14" modelUID="f:java_stub#org.objectweb.asm.tree(org.objectweb.asm.tree@java_stub)" version="-1" />
  <import index="15" modelUID="r:d0deafb6-c4af-4c30-b09c-3ec1bfe23ece(jetbrains.mps.baseLanguage.stubs)" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="7241381882860001930">
    <property name="abstractClass:3" value="false" />
    <property name="name:3" value="ASMModelLoader" />
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860002265" />
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="7241381882860002266">
      <property name="isFinal:3" value="true" />
      <property name="name:3" value="LOG" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860002267">
        <link role="classifier:3" targetNodeId="1.~Logger" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="7241381882860002268" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860002269">
        <link role="classConcept:3" targetNodeId="1.~Logger" />
        <link role="baseMethodDeclaration:3" targetNodeId="1.~Logger.getLogger(java.lang.Class):jetbrains.mps.logging.Logger" />
        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression:3" id="7241381882860002270">
          <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="7241381882860002271">
      <property name="name:3" value="myCpItem" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860002272">
        <link role="classifier:3" targetNodeId="2.~IClassPathItem" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="7241381882860002273" />
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="7241381882860002277">
      <property name="name:3" value="myModel" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860002278">
        <link role="classifier:3" targetNodeId="3.~SModel" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="7241381882860002279" />
    </node>
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="7241381882860002280">
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860002281" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860002282">
        <property name="name:3" value="classPathItem" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860002283">
          <link role="classifier:3" targetNodeId="2.~IClassPathItem" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860002286">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860002287">
          <link role="classifier:3" targetNodeId="3.~SModel" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860002288">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5050730786286138318">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5050730786286138319">
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1738898960265272379">
              <link role="variableDeclaration:3" targetNodeId="7241381882860002271" resolveInfo="myCpItem" />
            </node>
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5050730786286138323">
              <link role="variableDeclaration:3" targetNodeId="7241381882860002282" resolveInfo="classPathItem" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5050730786286138324">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5050730786286138325">
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1738898960265272377">
              <link role="variableDeclaration:3" targetNodeId="7241381882860002277" resolveInfo="myModel" />
            </node>
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5050730786286138329">
              <link role="variableDeclaration:3" targetNodeId="7241381882860002286" resolveInfo="model" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="7241381882860002307">
      <property name="name:3" value="updateModel" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860002308" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="7241381882860002309" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860002310">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.TryCatchStatement:3" id="7241381882860002311">
          <node role="catchClause:3" type="jetbrains.mps.baseLanguage.structure.CatchClause:3" id="7241381882860002312">
            <node role="catchBody:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860002313">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860002314">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860002315">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="7241381882860002316">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860002266" resolveInfo="LOG" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860002317">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.~Logger.error(java.lang.String,java.lang.Throwable):void" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860002318">
                      <property name="value:3" value="Exception" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860002319">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860002320" resolveInfo="e" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="throwable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860002320">
              <property name="name:3" value="e" />
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860002321">
                <link role="classifier:3" targetNodeId="11.~Exception" />
              </node>
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860002322">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7241381882860002331">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860002332">
                <property name="name:3" value="pack" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272913" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1738898960265272898">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1738898960265272899">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860002277" resolveInfo="myModel" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1738898960265272900">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399910">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399911">
                <property name="name:3" value="loader" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399912">
                  <link role="classifier:3" targetNodeId="4558608847800740951" resolveInfo="ClassifierLoader" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4350187567640399913">
                  <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4350187567640399914">
                    <link role="baseMethodDeclaration:3" targetNodeId="4558608847800740953" resolveInfo="ClassifierLoader" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399915">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860002277" resolveInfo="myModel" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399916">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860002271" resolveInfo="myCpItem" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814082464">
                      <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="2566197375814082465">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061438" resolveInfo="ClassifierUpdater" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="7241381882860002345">
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860002347">
                <property name="name:3" value="name" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272930" />
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860002349">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="1654569470761175047">
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654569470761175048">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="1654569470761175064" />
                  </node>
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="1654569470761175060">
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="1654569470761175063" />
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654569470761175052">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1654569470761175051">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860002277" resolveInfo="myModel" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654569470761175056">
                        <link role="baseMethodDeclaration:3" targetNodeId="3.~SModel.getNodeById(jetbrains.mps.smodel.SNodeId):jetbrains.mps.smodel.SNode" resolveInfo="getNodeById" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="1654569470761175058">
                          <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008243" resolveInfo="createId" />
                          <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="1654569470761175059">
                            <link role="variableDeclaration:3" targetNodeId="7241381882860002347" resolveInfo="name" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399918">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399921">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399920">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399911" resolveInfo="loader" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640419071">
                      <link role="baseMethodDeclaration:3" targetNodeId="4350187567640399576" resolveInfo="getRootClassifier" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640419072">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860002347" resolveInfo="name" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6962464904663134542">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6962464904663134543">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860002271" resolveInfo="myCpItem" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6962464904663134544">
                  <link role="baseMethodDeclaration:3" targetNodeId="2.~IClassPathItem.getRootClasses(java.lang.String):java.lang.Iterable" resolveInfo="getRootClasses" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6962464904663134545">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860002332" resolveInfo="pack" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="4163040004507702758">
      <property name="isFinal:3" value="true" />
      <property name="name:3" value="SKIP_PRIVATE" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4350187567640399901" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="4163040004507702760" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="4163040004507702761">
        <property name="value:3" value="false" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="7241381882860008238">
    <property name="name:3" value="ASMNodeId" />
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008239" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="7241381882860008240">
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008241" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008242" />
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008243">
      <property name="name:3" value="createId" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008244" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008245">
        <link role="classifier:3" targetNodeId="3.~SNodeId" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008246">
        <property name="name:3" value="fqClassName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272915" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008248">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008249">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008250">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008251">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNodeId$Foreign.&lt;init&gt;(java.lang.String)" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008252">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="7241381882860008253">
                  <link role="classifier:3" targetNodeId="3.~SNodeId$Foreign" />
                  <link role="variableDeclaration:3" targetNodeId="3.~SNodeId$Foreign.ID_PREFIX" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008254">
                  <link role="classConcept:3" targetNodeId="6.~NameUtil" />
                  <link role="baseMethodDeclaration:3" targetNodeId="6.~NameUtil.shortNameFromLongName(java.lang.String):java.lang.String" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008255">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860008246" resolveInfo="fqClassName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008256">
      <property name="name:3" value="createId" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008257" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008258">
        <link role="classifier:3" targetNodeId="3.~SNodeId" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008259">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008260">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008261">
        <property name="name:3" value="field" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008262">
          <link role="classifier:3" targetNodeId="9.7241381882860006793" resolveInfo="ASMField" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008263">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008264">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008265">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008266">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNodeId$Foreign.&lt;init&gt;(java.lang.String)" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008267">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008268">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008269">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="7241381882860008270">
                      <link role="classifier:3" targetNodeId="3.~SNodeId$Foreign" />
                      <link role="variableDeclaration:3" targetNodeId="3.~SNodeId$Foreign.ID_PREFIX" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008271">
                      <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                      <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008428" resolveInfo="shortNameFromSlashedLongName" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008272">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008273">
                          <link role="variableDeclaration:3" targetNodeId="7241381882860008259" resolveInfo="cls" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008274">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009833" resolveInfo="getName" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008275">
                    <property name="value:3" value="." />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008276">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008277">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860008261" resolveInfo="field" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008278">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006908" resolveInfo="getName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008279">
      <property name="name:3" value="createFieldId" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008280" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008281">
        <link role="classifier:3" targetNodeId="3.~SNodeId" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008282">
        <property name="name:3" value="fqClassName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272934" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008284">
        <property name="name:3" value="fieldName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272927" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008286">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008287">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008288">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008289">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNodeId$Foreign.&lt;init&gt;(java.lang.String)" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008290">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008291">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008292">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="7241381882860008293">
                      <link role="classifier:3" targetNodeId="3.~SNodeId$Foreign" />
                      <link role="variableDeclaration:3" targetNodeId="3.~SNodeId$Foreign.ID_PREFIX" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008294">
                      <link role="classConcept:3" targetNodeId="6.~NameUtil" />
                      <link role="baseMethodDeclaration:3" targetNodeId="6.~NameUtil.shortNameFromLongName(java.lang.String):java.lang.String" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008295">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860008282" resolveInfo="fqClassName" />
                      </node>
                    </node>
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008296">
                    <property name="value:3" value="." />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008297">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008284" resolveInfo="fieldName" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008298">
      <property name="name:3" value="createId" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008299" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008300">
        <link role="classifier:3" targetNodeId="3.~SNodeId" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008301">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008302">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008303">
        <property name="name:3" value="method" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008304">
          <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008305">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7241381882860008306">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860008307">
            <property name="name:3" value="sb" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008308">
              <link role="classifier:3" targetNodeId="11.~StringBuilder" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008309">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008310">
                <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.&lt;init&gt;()" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008311">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008312">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008313">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008314">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008315">
                <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008428" resolveInfo="shortNameFromSlashedLongName" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008316">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008317">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860008301" resolveInfo="cls" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008318">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009833" resolveInfo="getName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008319">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008320">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008321">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008322">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008323">
                <property name="charConstant:3" value="." />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008324">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008325">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008326">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008303" resolveInfo="method" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008327">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006548" resolveInfo="isConstructor" />
            </node>
          </node>
          <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="7241381882860008328">
            <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008329">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008330">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008331">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008332">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008333">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008334">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008335">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860008303" resolveInfo="method" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008336">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008337">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008338">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008339">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008340">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008341">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008342">
                    <property name="value:3" value="&lt;init&gt;" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008343">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008344">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008345">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008346">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008347">
                <property name="charConstant:3" value="(" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008348">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008349">
            <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
            <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008614" resolveInfo="appendList" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008350">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008351">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008352">
                <link role="variableDeclaration:3" targetNodeId="7241381882860008303" resolveInfo="method" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008353">
                <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006625" resolveInfo="getParameterTypes" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008354">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008355">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008356">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008357">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008358">
                <property name="charConstant:3" value=")" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008359">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="7241381882860008360">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008361">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008362">
                <link role="variableDeclaration:3" targetNodeId="7241381882860008303" resolveInfo="method" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008363">
                <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006548" resolveInfo="isConstructor" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008364">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008365">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008366">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008367">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008368">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008369">
                    <property name="charConstant:3" value=":" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008370">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008371">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008372">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008373">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008374">
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008375">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008376">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860008303" resolveInfo="method" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008377">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006592" resolveInfo="getReturnType" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008378">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008379">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008380">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNodeId$Foreign.&lt;init&gt;(java.lang.String)" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008381">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="7241381882860008382">
                  <link role="classifier:3" targetNodeId="3.~SNodeId$Foreign" />
                  <link role="variableDeclaration:3" targetNodeId="3.~SNodeId$Foreign.ID_PREFIX" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008383">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008384">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860008307" resolveInfo="sb" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008385">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.toString():java.lang.String" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008386">
      <property name="name:3" value="createAnnotationMethodId" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7241381882860008387" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008388">
        <link role="classifier:3" targetNodeId="3.~SNodeId" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008389">
        <property name="name:3" value="fqClassName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272916" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008391">
        <property name="name:3" value="methodName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272908" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008393">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7241381882860008394">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860008395">
            <property name="name:3" value="sb" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008396">
              <link role="classifier:3" targetNodeId="11.~StringBuilder" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008397">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008398">
                <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.&lt;init&gt;()" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008399">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008400">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008401">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008395" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008402">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008403">
                <link role="classConcept:3" targetNodeId="6.~NameUtil" />
                <link role="baseMethodDeclaration:3" targetNodeId="6.~NameUtil.shortNameFromLongName(java.lang.String):java.lang.String" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008404">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008389" resolveInfo="fqClassName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008405">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008406">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008407">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008395" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008408">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008409">
                <property name="charConstant:3" value="." />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008410">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008411">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008412">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008395" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008413">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008414">
                <link role="variableDeclaration:3" targetNodeId="7241381882860008391" resolveInfo="methodName" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008415">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008416">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008417">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008395" resolveInfo="sb" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008418">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008419">
                <property name="value:3" value="()" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008420">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008421">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008422">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNodeId$Foreign.&lt;init&gt;(java.lang.String)" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008423">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="7241381882860008424">
                  <link role="classifier:3" targetNodeId="3.~SNodeId$Foreign" />
                  <link role="variableDeclaration:3" targetNodeId="3.~SNodeId$Foreign.ID_PREFIX" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008425">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008426">
                    <link role="variableDeclaration:3" targetNodeId="7241381882860008395" resolveInfo="sb" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008427">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.toString():java.lang.String" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008428">
      <property name="name:3" value="shortNameFromSlashedLongName" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="7241381882860008429" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272903" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008431">
        <property name="name:3" value="slashedLongName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272910" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008433">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7241381882860008434">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860008435">
            <property name="name:3" value="offset" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="7241381882860008436" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008437">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008438">
                <link role="variableDeclaration:3" targetNodeId="7241381882860008431" resolveInfo="slashedLongName" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008439">
                <link role="baseMethodDeclaration:3" targetNodeId="11.~String.lastIndexOf(int):int" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008440">
                  <property name="charConstant:3" value="/" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008441">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="7241381882860008442">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008443">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008435" resolveInfo="offset" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="7241381882860008444">
              <property name="value:3" value="0" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008445">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008446">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008447">
                <link role="variableDeclaration:3" targetNodeId="7241381882860008431" resolveInfo="slashedLongName" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008448">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008449">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008450">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008431" resolveInfo="slashedLongName" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008451">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~String.substring(int):java.lang.String" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008452">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008453">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008435" resolveInfo="offset" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="7241381882860008454">
                  <property name="value:3" value="1" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008455">
      <property name="name:3" value="asString" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="7241381882860008456" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="1738898960265272905" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008458">
        <property name="name:3" value="type" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008459">
          <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008460">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008461">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008462">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008463">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008464">
              <link role="classifier:3" targetNodeId="9.7241381882860009267" resolveInfo="ASMParameterizedType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008465">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7241381882860008466">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860008467">
                <property name="name:3" value="sb" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008468">
                  <link role="classifier:3" targetNodeId="11.~StringBuilder" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008469">
                  <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008470">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.&lt;init&gt;()" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008471">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008472">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008473">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008467" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008474">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008475">
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008476">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008477">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008478">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008479">
                            <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                          </node>
                          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008480">
                            <link role="classifier:3" targetNodeId="9.7241381882860009267" resolveInfo="ASMParameterizedType" />
                          </node>
                        </node>
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008481">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009306" resolveInfo="getRawType" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008482">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008483">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008484">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008467" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008485">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008486">
                    <property name="charConstant:3" value="&lt;" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008487">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008488">
                <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008614" resolveInfo="appendList" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008489">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008467" resolveInfo="sb" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008490">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008491">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008492">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008493">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008494">
                        <link role="classifier:3" targetNodeId="9.7241381882860009267" resolveInfo="ASMParameterizedType" />
                      </node>
                    </node>
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008495">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009338" resolveInfo="getActualTypeArguments" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008496">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008497">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008498">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008467" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008499">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008500">
                    <property name="charConstant:3" value="&gt;" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008501">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008502">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008503">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008467" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008504">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.toString():java.lang.String" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008505">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008506">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008507">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008508">
              <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008509">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008510">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008511">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008512">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008513">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008514">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                    </node>
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008515">
                      <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                    </node>
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008516">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008517">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008518">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008519">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008520">
              <link role="classifier:3" targetNodeId="9.7241381882860002146" resolveInfo="ASMArrayType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008521">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008522">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008523">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008524">
                  <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                  <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008525">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008526">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008527">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008528">
                          <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                        </node>
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008529">
                          <link role="classifier:3" targetNodeId="9.7241381882860002146" resolveInfo="ASMArrayType" />
                        </node>
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008530">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002162" resolveInfo="getElementType" />
                    </node>
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008531">
                  <property name="value:3" value="[]" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008532">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008533">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008534">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008535">
              <link role="classifier:3" targetNodeId="9.7241381882860007172" resolveInfo="ASMVarArgType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008536">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008537">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008538">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008539">
                  <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                  <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008540">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008541">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008542">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008543">
                          <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                        </node>
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008544">
                          <link role="classifier:3" targetNodeId="9.7241381882860007172" resolveInfo="ASMVarArgType" />
                        </node>
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008545">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007188" resolveInfo="getElementType" />
                    </node>
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008546">
                  <property name="value:3" value="..." />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008547">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008548">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008549">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008550">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008551">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008552">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008553">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008554">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008555">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008556">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                    </node>
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008557">
                      <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
                    </node>
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008558">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006777" resolveInfo="getName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008559">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008560">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008561">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008562">
              <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008563">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008564">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008565">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008566">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008567">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008568">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                    </node>
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008569">
                      <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
                    </node>
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008570">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008571">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008572">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008573">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008574">
              <link role="classifier:3" targetNodeId="9.7241381882860008819" resolveInfo="ASMExtendsType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008575">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008576">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008577">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008578">
                  <property name="value:3" value="? extends " />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008579">
                  <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                  <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008580">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008581">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008582">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008583">
                          <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                        </node>
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008584">
                          <link role="classifier:3" targetNodeId="9.7241381882860008819" resolveInfo="ASMExtendsType" />
                        </node>
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008585">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008836" resolveInfo="getBase" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008586">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008587">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008588">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008589">
              <link role="classifier:3" targetNodeId="9.7241381882860008734" resolveInfo="ASMSuperType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008590">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008591">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008592">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008593">
                  <property name="value:3" value="? super " />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008594">
                  <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                  <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008595">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="7241381882860008596">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="7241381882860008597">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008598">
                          <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                        </node>
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008599">
                          <link role="classifier:3" targetNodeId="9.7241381882860008734" resolveInfo="ASMSuperType" />
                        </node>
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008600">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008751" resolveInfo="getBase" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008601">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="7241381882860008602">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008603">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008604">
              <link role="classifier:3" targetNodeId="9.7241381882860007300" resolveInfo="ASMUnboundedType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008605">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7241381882860008606">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008607">
                <property name="value:3" value="?" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ThrowStatement:3" id="7241381882860008608">
          <node role="throwable:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7241381882860008609">
            <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7241381882860008610">
              <link role="baseMethodDeclaration:3" targetNodeId="11.~RuntimeException.&lt;init&gt;(java.lang.String)" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7241381882860008611">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="7241381882860008612">
                  <property name="value:3" value="unexpected type: " />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008613">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008458" resolveInfo="type" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7241381882860008614">
      <property name="name:3" value="appendList" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="7241381882860008615" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="7241381882860008616" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008617">
        <property name="name:3" value="sb" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008618">
          <link role="classifier:3" targetNodeId="11.~StringBuilder" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7241381882860008619">
        <property name="name:3" value="types" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008620">
          <link role="classifier:3" targetNodeId="4.~List" />
          <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008621">
            <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
          </node>
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008622">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7241381882860008623">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7241381882860008624">
            <property name="name:3" value="iterator" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008625">
              <link role="classifier:3" targetNodeId="4.~Iterator" />
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7241381882860008626">
                <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008627">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008628">
                <link role="variableDeclaration:3" targetNodeId="7241381882860008619" resolveInfo="types" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008629">
                <link role="baseMethodDeclaration:3" targetNodeId="4.~List.iterator():java.util.Iterator" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.WhileStatement:3" id="7241381882860008630">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008631">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008632">
              <link role="variableDeclaration:3" targetNodeId="7241381882860008624" resolveInfo="iterator" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008633">
              <link role="baseMethodDeclaration:3" targetNodeId="4.~Iterator.hasNext():boolean" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008634">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008635">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008636">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008637">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008617" resolveInfo="sb" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008638">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7241381882860008639">
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008455" resolveInfo="asString" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008640">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008641">
                        <link role="variableDeclaration:3" targetNodeId="7241381882860008624" resolveInfo="iterator" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008642">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~Iterator.next():java.lang.Object" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7241381882860008643">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008644">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7241381882860008645">
                  <link role="variableDeclaration:3" targetNodeId="7241381882860008624" resolveInfo="iterator" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008646">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~Iterator.hasNext():boolean" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7241381882860008647">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7241381882860008648">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7241381882860008649">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7241381882860008650">
                      <link role="variableDeclaration:3" targetNodeId="7241381882860008617" resolveInfo="sb" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7241381882860008651">
                      <link role="baseMethodDeclaration:3" targetNodeId="11.~StringBuilder.append(char):java.lang.StringBuilder" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="7241381882860008652">
                        <property name="charConstant:3" value="," />
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
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="4558608847800740951">
    <property name="name:3" value="ClassifierLoader" />
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4350187567640399888">
      <property name="name:3" value="myCpItem" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399889">
        <link role="classifier:3" targetNodeId="2.~IClassPathItem" resolveInfo="IClassPathItem" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4350187567640399890" />
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4350187567640399891">
      <property name="name:3" value="myModel" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399892">
        <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4350187567640399893" />
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="2566197375814082441">
      <property name="name:3" value="myUpdater" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814082442" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082443">
        <link role="classifier:3" targetNodeId="2566197375814061436" resolveInfo="ClassifierUpdater" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4350187567640399576">
      <property name="name:3" value="loadRootClassifier" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4350187567640399925" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399578">
        <property name="name:3" value="name" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="4350187567640399579" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399580">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3670640979273648268">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3670640979273648269">
            <link role="baseMethodDeclaration:3" targetNodeId="4350187567640399603" resolveInfo="getClassifier" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3670640979273648270">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399578" resolveInfo="name" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="3670640979273648271">
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3670640979273648272">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3670640979273648273">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3670640979273648274">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3670640979273648275">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399891" resolveInfo="myModel" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3670640979273648276">
                      <link role="baseMethodDeclaration:3" targetNodeId="3.~SModel.addRoot(jetbrains.mps.smodel.SNode):void" resolveInfo="addRoot" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3670640979273648277">
                        <link role="variableDeclaration:3" targetNodeId="3670640979273648278" resolveInfo="n" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3670640979273648278">
                <property name="name:3" value="n" />
                <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="3670640979273648279" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814082427" />
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4350187567640399603">
      <property name="name:3" value="getClassifier" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4350187567640399604" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399605">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640399606">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399607">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4350187567640399608" />
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399610">
            <link role="classConcept:3" targetNodeId="2.~AbstractClassPathItem" resolveInfo="AbstractClassPathItem" />
            <link role="baseMethodDeclaration:3" targetNodeId="2.~AbstractClassPathItem.isAnonymous(java.lang.String):boolean" resolveInfo="isAnonymous" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399611">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399671" resolveInfo="name" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="4350187567640399612" />
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399613">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399614">
            <property name="name:3" value="pack" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="4350187567640399615" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399616">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399617">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399891" resolveInfo="myModel" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399618">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SModel.getLongName():java.lang.String" resolveInfo="getLongName" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399619">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399620">
            <property name="name:3" value="code" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ArrayType:3" id="4350187567640399621">
              <node role="componentType:3" type="jetbrains.mps.baseLanguage.structure.ByteType:3" id="4350187567640399622" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399623">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399624">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399888" resolveInfo="myCpItem" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399625">
                <link role="baseMethodDeclaration:3" targetNodeId="2.~IClassPathItem.getClass(java.lang.String):byte[]" resolveInfo="getClass" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.TernaryOperatorExpression:3" id="4350187567640399626">
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399627">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399671" resolveInfo="name" />
                  </node>
                  <node role="ifFalse:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4350187567640399628">
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399629">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399671" resolveInfo="name" />
                    </node>
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4350187567640399630">
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399631">
                        <link role="variableDeclaration:3" targetNodeId="4350187567640399614" resolveInfo="pack" />
                      </node>
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4350187567640399632">
                        <property name="value:3" value="." />
                      </node>
                    </node>
                  </node>
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399633">
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4350187567640399634">
                      <property name="value:3" value="0" />
                    </node>
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399635">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399636">
                        <link role="variableDeclaration:3" targetNodeId="4350187567640399614" resolveInfo="pack" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399637">
                        <link role="baseMethodDeclaration:3" targetNodeId="11.~String.length():int" resolveInfo="length" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640399638">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399639">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399640">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399620" resolveInfo="code" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4350187567640399641" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399642">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4350187567640399643" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399645">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399646">
            <property name="name:3" value="reader" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399647">
              <link role="classifier:3" targetNodeId="7.~ClassReader" resolveInfo="ClassReader" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4350187567640399648">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4350187567640399649">
                <link role="baseMethodDeclaration:3" targetNodeId="7.~ClassReader.&lt;init&gt;(byte[])" resolveInfo="ClassReader" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399650">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399620" resolveInfo="code" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814082484">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814082485">
            <property name="name:3" value="ac" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082486">
              <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814082487">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="2566197375814082488">
                <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009454" resolveInfo="ASMClass" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082489">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399646" resolveInfo="reader" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399651">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399652">
            <property name="name:3" value="res" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399653">
              <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4350187567640399654">
              <link role="baseMethodDeclaration:3" targetNodeId="4350187567640399795" resolveInfo="createClassifierForClass" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399655">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399671" resolveInfo="name" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399656">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399891" resolveInfo="myModel" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399657">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399646" resolveInfo="reader" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3670640979273648240">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.closures.structure.CompactInvokeFunctionExpression:3" id="3670640979273648246">
            <node role="function:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3670640979273648247">
              <link role="variableDeclaration:3" targetNodeId="3670640979273626088" resolveInfo="adder" />
            </node>
            <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3670640979273648249">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3670640979273648248">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399652" resolveInfo="res" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3670640979273648253">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082467">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082469">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="2566197375814082468">
              <link role="variableDeclaration:3" targetNodeId="2566197375814082441" resolveInfo="myUpdater" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082473">
              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814082184" resolveInfo="updateClassifier" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082474">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399652" resolveInfo="res" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082490">
                <link role="variableDeclaration:3" targetNodeId="2566197375814082485" resolveInfo="ac" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399663">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4350187567640399664">
            <link role="baseMethodDeclaration:3" targetNodeId="4350187567640399674" resolveInfo="updateInnerClassifiers" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082482">
              <link role="variableDeclaration:3" targetNodeId="2566197375814082485" resolveInfo="ac" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399668">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399652" resolveInfo="res" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399671">
        <property name="name:3" value="name" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="4350187567640399672" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3670640979273626088">
        <property name="name:3" value="adder" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.closures.structure.FunctionType:3" id="3670640979273630584">
          <node role="resultType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3670640979273648238" />
          <node role="parameterType:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="3670640979273648237" />
        </node>
      </node>
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3670640979273648351" />
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4350187567640399674">
      <property name="name:3" value="updateInnerClassifiers" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4350187567640399675" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4350187567640399676" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399677">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="4350187567640399678">
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399679">
            <property name="name:3" value="cn" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399680">
              <link role="classifier:3" targetNodeId="14.~InnerClassNode" resolveInfo="InnerClassNode" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399681">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640419079">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4350187567640419080">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="4350187567640419081">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BitwiseAndExpression:3" id="4350187567640419082">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640419083">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640419084">
                        <link role="variableDeclaration:3" targetNodeId="4350187567640399679" resolveInfo="cn" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="4350187567640419085">
                        <link role="fieldDeclaration:3" targetNodeId="14.~InnerClassNode.access" resolveInfo="access" />
                      </node>
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4350187567640419086">
                      <link role="classifier:3" targetNodeId="7.~Opcodes" resolveInfo="Opcodes" />
                      <link role="variableDeclaration:3" targetNodeId="7.~Opcodes.ACC_SYNTHETIC" resolveInfo="ACC_SYNTHETIC" />
                    </node>
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4350187567640419087">
                  <property name="value:3" value="0" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640419088">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="4350187567640419089" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="4350187567640419092" />
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640419094">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640419095">
                <property name="name:3" value="isPrivate" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="4350187567640419096" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4350187567640419097">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4350187567640419098">
                    <property name="value:3" value="0" />
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="4350187567640419099">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BitwiseAndExpression:3" id="4350187567640419100">
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640419101">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640419102">
                          <link role="variableDeclaration:3" targetNodeId="4350187567640399679" resolveInfo="cn" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="4350187567640419103">
                          <link role="fieldDeclaration:3" targetNodeId="14.~InnerClassNode.access" resolveInfo="access" />
                        </node>
                      </node>
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4350187567640419104">
                        <link role="classifier:3" targetNodeId="7.~Opcodes" resolveInfo="Opcodes" />
                        <link role="variableDeclaration:3" targetNodeId="7.~Opcodes.ACC_PRIVATE" resolveInfo="ACC_PRIVATE" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640419105">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640419106">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="4350187567640419107" />
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="4350187567640419108">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4350187567640419109">
                  <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
                  <link role="variableDeclaration:3" targetNodeId="4163040004507702758" resolveInfo="SKIP_PRIVATE" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640419110">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640419095" resolveInfo="isPrivate" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="4350187567640419093" />
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399695">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399696">
                <property name="name:3" value="name" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399697">
                  <link role="classifier:3" targetNodeId="11.~String" resolveInfo="String" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399698">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399699">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399679" resolveInfo="cn" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="4350187567640399700">
                    <link role="fieldDeclaration:3" targetNodeId="14.~InnerClassNode.name" resolveInfo="name" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640399701">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399702">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="4350187567640399703" />
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399704">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4350187567640399705" />
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399706">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399696" resolveInfo="name" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640419114">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640419115">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="4350187567640419128" />
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="4386136458768467706">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4386136458768467713">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4386136458768467714">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399696" resolveInfo="name" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4386136458768467715">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~String.startsWith(java.lang.String):boolean" resolveInfo="startsWith" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4386136458768468384">
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4386136458768468387">
                        <property name="value:3" value="$" />
                      </node>
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4386136458768468379">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4386136458768468378">
                          <link role="variableDeclaration:3" targetNodeId="4350187567640399791" resolveInfo="ac" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4386136458768468383">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009833" resolveInfo="getName" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="4350187567640419113" />
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399707">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399708">
                <property name="name:3" value="index" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4350187567640399709" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399710">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399711">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399696" resolveInfo="name" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399712">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~String.lastIndexOf(java.lang.String):int" resolveInfo="lastIndexOf" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4350187567640399713">
                      <property name="value:3" value="/" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640399714">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399715">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399716">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399717">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399718">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399719">
                        <link role="variableDeclaration:3" targetNodeId="4350187567640399696" resolveInfo="name" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399720">
                        <link role="baseMethodDeclaration:3" targetNodeId="11.~String.substring(int):java.lang.String" resolveInfo="substring" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4350187567640399721">
                          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4350187567640399722">
                            <property name="value:3" value="1" />
                          </node>
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399723">
                            <link role="variableDeclaration:3" targetNodeId="4350187567640399708" resolveInfo="index" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399724">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399696" resolveInfo="name" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4350187567640399725">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4350187567640399726">
                  <property name="value:3" value="-1" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399727">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399708" resolveInfo="index" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="4350187567640399728" />
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399729">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399730">
                <property name="name:3" value="isStatic" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="4350187567640399731" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4350187567640399732">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4350187567640399733">
                    <property name="value:3" value="0" />
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="4350187567640399734">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BitwiseAndExpression:3" id="4350187567640399735">
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399736">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399737">
                          <link role="variableDeclaration:3" targetNodeId="4350187567640399679" resolveInfo="cn" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="4350187567640399738">
                          <link role="fieldDeclaration:3" targetNodeId="14.~InnerClassNode.access" resolveInfo="access" />
                        </node>
                      </node>
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4350187567640399739">
                        <link role="classifier:3" targetNodeId="7.~Opcodes" resolveInfo="Opcodes" />
                        <link role="variableDeclaration:3" targetNodeId="7.~Opcodes.ACC_STATIC" resolveInfo="ACC_STATIC" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3670640979273648318">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3670640979273648319">
                <link role="baseMethodDeclaration:3" targetNodeId="4350187567640399603" resolveInfo="getClassifier" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3670640979273648320">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399696" resolveInfo="name" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="3670640979273648321">
                  <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3670640979273648322">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3670640979273648323">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3670640979273648324">
                        <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="3670640979273648325">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3670640979273648326">
                            <link role="variableDeclaration:3" targetNodeId="4350187567640399730" resolveInfo="isStatic" />
                          </node>
                        </node>
                        <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3670640979273648327">
                          <node role="operand:3" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression:16" id="3670640979273648328">
                            <link role="concept:16" targetNodeId="12.1107461130800:3" resolveInfo="Classifier" />
                            <node role="leftExpression:16" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3670640979273648329">
                              <link role="variableDeclaration:3" targetNodeId="3670640979273648341" resolveInfo="n" />
                            </node>
                          </node>
                          <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="3670640979273648330">
                            <link role="property:16" targetNodeId="12.521412098689998745:3" resolveInfo="nonStatic" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3670640979273648331">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3670640979273648332">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3670640979273648333">
                          <link role="variableDeclaration:3" targetNodeId="4350187567640399793" resolveInfo="cls" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3670640979273648334">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.addStaticInnerClassifiers(jetbrains.mps.baseLanguage.structure.Classifier):void" resolveInfo="addStaticInnerClassifiers" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="3670640979273648335">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="3670640979273648336">
                              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3670640979273648337">
                                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3670640979273648338">
                                  <link role="variableDeclaration:3" targetNodeId="3670640979273648341" resolveInfo="n" />
                                </node>
                                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetAdapterOperation:16" id="3670640979273648339" />
                              </node>
                              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3670640979273648346">
                                <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3670640979273648341">
                    <property name="name:3" value="n" />
                    <node role="type:3" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="3670640979273648342" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399788">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399789">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399791" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399790">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7894199968368685027" resolveInfo="getInnerClasses" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399791">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399792">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399793">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399794">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4350187567640399795">
      <property name="name:3" value="createClassifierForClass" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4350187567640399796" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399797">
        <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399798">
        <property name="name:3" value="fqName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="4350187567640399799" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399800">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399801">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399802">
        <property name="name:3" value="reader" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399803">
          <link role="classifier:3" targetNodeId="7.~ClassReader" resolveInfo="ClassReader" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399804">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399805">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399806">
            <property name="name:3" value="result" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399807">
              <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4350187567640399808" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4350187567640399809">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4350187567640399810">
            <property name="name:3" value="kind" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399811">
              <link role="classifier:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399812">
              <link role="baseMethodDeclaration:3" targetNodeId="13.~ClassifierKind.getClassifierKind(org.objectweb.asm.ClassReader):jetbrains.mps.stubs.javastub.classpath.ClassifierKind" resolveInfo="getClassifierKind" />
              <link role="classConcept:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399813">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399802" resolveInfo="reader" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640399814">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399815">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399816">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399810" resolveInfo="kind" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4350187567640399817" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399818">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4350187567640399819">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4350187567640399820" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4350187567640399821">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399822">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399823">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399824">
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399825">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
                </node>
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399826">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ClassConcept" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399827">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399800" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399828">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399829">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399810" resolveInfo="kind" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4350187567640399830">
              <link role="enumClass:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
              <link role="enumConstantDeclaration:3" targetNodeId="13.~ClassifierKind.CLASS" resolveInfo="CLASS" />
            </node>
          </node>
          <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="4350187567640399831">
            <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399832">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399833">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399834">
                  <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399835">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
                  </node>
                  <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399836">
                    <link role="classConcept:3" targetNodeId="5.~Interface" resolveInfo="Interface" />
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~Interface.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.Interface" resolveInfo="newInstance" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399837">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399800" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399838">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399839">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399810" resolveInfo="kind" />
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4350187567640399840">
                <link role="enumClass:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
                <link role="enumConstantDeclaration:3" targetNodeId="13.~ClassifierKind.INTERFACE" resolveInfo="INTERFACE" />
              </node>
            </node>
          </node>
          <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="4350187567640399841">
            <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399842">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399843">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399844">
                  <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399845">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
                  </node>
                  <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399846">
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~Annotation.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.Annotation" resolveInfo="newInstance" />
                    <link role="classConcept:3" targetNodeId="5.~Annotation" resolveInfo="Annotation" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399847">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399800" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399848">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399849">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399810" resolveInfo="kind" />
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4350187567640399850">
                <link role="enumClass:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
                <link role="enumConstantDeclaration:3" targetNodeId="13.~ClassifierKind.ANNOTATIONS" resolveInfo="ANNOTATIONS" />
              </node>
            </node>
          </node>
          <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="4350187567640399851">
            <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399852">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399853">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399854">
                  <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399855">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
                  </node>
                  <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399856">
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~EnumClass.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.EnumClass" resolveInfo="newInstance" />
                    <link role="classConcept:3" targetNodeId="5.~EnumClass" resolveInfo="EnumClass" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399857">
                      <link role="variableDeclaration:3" targetNodeId="4350187567640399800" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399858">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399859">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399810" resolveInfo="kind" />
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4350187567640399860">
                <link role="enumClass:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
                <link role="enumConstantDeclaration:3" targetNodeId="13.~ClassifierKind.ENUM" resolveInfo="ENUM" />
              </node>
            </node>
          </node>
          <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="4350187567640399861">
            <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4350187567640399862">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4350187567640399863">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4350187567640399864" />
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4350187567640399865">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399866">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399810" resolveInfo="kind" />
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4350187567640399867">
                <link role="enumClass:3" targetNodeId="13.~ClassifierKind" resolveInfo="ClassifierKind" />
                <link role="enumConstantDeclaration:3" targetNodeId="13.~ClassifierKind.UNKNOWN" resolveInfo="UNKNOWN" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399868">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399869">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399870">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399871">
              <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setName(java.lang.String):void" resolveInfo="setName" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399872">
                <link role="baseMethodDeclaration:3" targetNodeId="6.~NameUtil.shortNameFromLongName(java.lang.String):java.lang.String" resolveInfo="shortNameFromLongName" />
                <link role="classConcept:3" targetNodeId="6.~NameUtil" resolveInfo="NameUtil" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399873">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399874">
                    <link role="variableDeclaration:3" targetNodeId="4350187567640399798" resolveInfo="fqName" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399875">
                    <link role="baseMethodDeclaration:3" targetNodeId="11.~String.replace(char,char):java.lang.String" resolveInfo="replace" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="4350187567640399876">
                      <property name="charConstant:3" value="$" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CharConstant:3" id="4350187567640399877">
                      <property name="charConstant:3" value="." />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399878">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399879">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4350187567640399880">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399881">
                <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399882">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4350187567640399883">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4350187567640399884">
                <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008243" resolveInfo="createId" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399885">
                  <link role="variableDeclaration:3" targetNodeId="4350187567640399798" resolveInfo="fqName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4350187567640399886">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4350187567640399887">
            <link role="variableDeclaration:3" targetNodeId="4350187567640399806" resolveInfo="result" />
          </node>
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4558608847800740952" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="4558608847800740953">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4558608847800740954" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4558608847800740955" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4558608847800740956">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399935">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399937">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399940">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399930" resolveInfo="model" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399936">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399891" resolveInfo="myModel" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4350187567640399942">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4350187567640399944">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4350187567640399947">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399932" resolveInfo="cpItem" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4350187567640399943">
              <link role="variableDeclaration:3" targetNodeId="4350187567640399888" resolveInfo="myCpItem" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082456">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="2566197375814082457">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082461">
              <link role="variableDeclaration:3" targetNodeId="2566197375814082453" resolveInfo="updater" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="2566197375814082462">
              <link role="variableDeclaration:3" targetNodeId="2566197375814082441" resolveInfo="myUpdater" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399930">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399931">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4350187567640399932">
        <property name="name:3" value="cpItem" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4350187567640399934">
          <link role="classifier:3" targetNodeId="2.~IClassPathItem" resolveInfo="IClassPathItem" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814082453">
        <property name="name:3" value="updater" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082454">
          <link role="classifier:3" targetNodeId="2566197375814061436" resolveInfo="ClassifierUpdater" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="2566197375814061436">
    <property name="name:3" value="ClassifierUpdater" />
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="2566197375814064481">
      <property name="isFinal:3" value="true" />
      <property name="name:3" value="LOG" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064482">
        <link role="classifier:3" targetNodeId="1.~Logger" resolveInfo="Logger" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814064483" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064484">
        <link role="baseMethodDeclaration:3" targetNodeId="1.~Logger.getLogger(java.lang.Class):jetbrains.mps.logging.Logger" resolveInfo="getLogger" />
        <link role="classConcept:3" targetNodeId="1.~Logger" resolveInfo="Logger" />
        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression:3" id="2566197375814082157">
          <link role="classifier:3" targetNodeId="2566197375814061436" resolveInfo="ClassifierUpdater" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814082184">
      <property name="name:3" value="updateClassifier" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="2566197375814082185" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814082186" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814082187">
        <property name="name:3" value="clsfr" />
        <property name="isFinal:3" value="true" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082188">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814082189">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082491">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082191">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814082192">
          <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="2566197375814082193">
            <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082194">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814082201">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814082202">
                  <property name="name:3" value="cls" />
                  <property name="isFinal:3" value="true" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082203">
                    <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
                  </node>
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814082204">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082205">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
                    </node>
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082206">
                      <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814082207">
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082208">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082510">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082210">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009788" resolveInfo="isPublic" />
                  </node>
                </node>
                <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="2566197375814082211">
                  <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082212">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082213">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082214">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082215">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082216">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814082217" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082218">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082219">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082220">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082221">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082222">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814082223">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~PublicVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PublicVisibility" resolveInfo="newInstance" />
                          <link role="classConcept:3" targetNodeId="5.~PublicVisibility" resolveInfo="PublicVisibility" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082224">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082225">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082226">
                              <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082227">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082228">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082229">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082230">
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.setAbstractClass(boolean):void" resolveInfo="setAbstractClass" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082231">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082511">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082233">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009773" resolveInfo="isAbstract" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082234">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082235">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082236">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082237">
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082238">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082518">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082240">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009818" resolveInfo="isDeprecated" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082241">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082242">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062123" resolveInfo="updateAnnotations" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082519">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082244">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082245">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082246">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061665" resolveInfo="updateTypeVariables" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082524">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082248">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082249">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082250">
                      <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                    </node>
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082251">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082252">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082253">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062183" resolveInfo="updateExtendsAndImplements" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082523">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082255">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082256">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082257">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062256" resolveInfo="updateInstanceFields" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082558">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082259">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082260">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082261">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062362" resolveInfo="updateStaticFields" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082565">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082263">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082264">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082265">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062601" resolveInfo="updateConstructors" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082566">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082267">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082268">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082269">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062809" resolveInfo="updateInstanceMethods" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082567">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082271">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082272">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082273">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063039" resolveInfo="updateStaticMethods" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082557">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082275">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082276">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082277">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082278">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082202" resolveInfo="cls" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082279">
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.setIsFinal(boolean):void" resolveInfo="setIsFinal" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082280">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082574">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082282">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009803" resolveInfo="isFinal" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814082283">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082284">
                <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
              </node>
              <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082285">
                <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814082286">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082287">
              <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082288">
              <link role="classifier:3" targetNodeId="5.~Annotation" resolveInfo="Annotation" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082289">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814082296">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814082297">
                <property name="name:3" value="annotation" />
                <property name="isFinal:3" value="true" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082298">
                  <link role="classifier:3" targetNodeId="5.~Annotation" resolveInfo="Annotation" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814082299">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082300">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082301">
                    <link role="classifier:3" targetNodeId="5.~Annotation" resolveInfo="Annotation" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814082302">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082303">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082495">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082305">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009788" resolveInfo="isPublic" />
                </node>
              </node>
              <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="2566197375814082306">
                <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082307">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082308">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082309">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082310">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082297" resolveInfo="annotation" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082311">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814082312" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082313">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082314">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082315">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082316">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814082297" resolveInfo="annotation" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082317">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814082318">
                        <link role="classConcept:3" targetNodeId="5.~PublicVisibility" resolveInfo="PublicVisibility" />
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~PublicVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PublicVisibility" resolveInfo="newInstance" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082319">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082320">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082321">
                            <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082322">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082323">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062508" resolveInfo="updateAnnotationMethods" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082496">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082325">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814082297" resolveInfo="annotation" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082326">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082327">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062123" resolveInfo="updateAnnotations" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082497">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082329">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814082297" resolveInfo="annotation" />
                </node>
              </node>
            </node>
          </node>
          <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="2566197375814082330">
            <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082331">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814082338">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814082339">
                  <property name="name:3" value="intfc" />
                  <property name="isFinal:3" value="true" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082340">
                    <link role="classifier:3" targetNodeId="5.~Interface" resolveInfo="Interface" />
                  </node>
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814082341">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082342">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
                    </node>
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082343">
                      <link role="classifier:3" targetNodeId="5.~Interface" resolveInfo="Interface" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814082344">
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082345">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082575">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082347">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009788" resolveInfo="isPublic" />
                  </node>
                </node>
                <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="2566197375814082348">
                  <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082349">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082350">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082351">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082352">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082353">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814082354" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814082355">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082356">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082357">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082358">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082359">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814082360">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~PublicVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PublicVisibility" resolveInfo="newInstance" />
                          <link role="classConcept:3" targetNodeId="5.~PublicVisibility" resolveInfo="PublicVisibility" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082361">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082362">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082363">
                              <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082364">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082365">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082366">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082367">
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~Interface.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082368">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082550">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082370">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009818" resolveInfo="isDeprecated" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082371">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082372">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062123" resolveInfo="updateAnnotations" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082549">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082374">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082375">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082376">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061665" resolveInfo="updateTypeVariables" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082548">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814082378">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082379">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814082380">
                      <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                    </node>
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082381">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082382">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082383">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062147" resolveInfo="updateExtendsForInterface" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082537">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082385">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082386">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082387">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062362" resolveInfo="updateStaticFields" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082576">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082389">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814082390">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814082391">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814062809" resolveInfo="updateInstanceMethods" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082538">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082189" resolveInfo="ac" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814082393">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814082339" resolveInfo="intfc" />
                  </node>
                </node>
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814082394">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814082395">
                <link role="variableDeclaration:3" targetNodeId="2566197375814082187" resolveInfo="clsfr" />
              </node>
              <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082396">
                <link role="classifier:3" targetNodeId="5.~Interface" resolveInfo="Interface" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814061665">
      <property name="name:3" value="updateTypeVariables" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814061666" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814061667" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061668">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061669">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061670">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061671">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061672">
        <property name="name:3" value="result" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061673">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061674">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814061675">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061676">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061677">
              <link role="variableDeclaration:3" targetNodeId="2566197375814061668" resolveInfo="cls" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061678">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009857" resolveInfo="getTypeParameters" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061679">
            <property name="name:3" value="tv" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061680">
              <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061681">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061682">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061683">
                <property name="name:3" value="typeVariableDeclaration" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061684">
                  <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814061685">
                  <link role="classConcept:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061686">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061670" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061687">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061688">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061689">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061683" resolveInfo="typeVariableDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061690">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061691">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061692">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814061679" resolveInfo="tv" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061693">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061694">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061695">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061696">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061672" resolveInfo="result" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061697">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~GenericDeclaration.addTypeVariableDeclaration(jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration):void" resolveInfo="addTypeVariableDeclaration" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061698">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061683" resolveInfo="typeVariableDeclaration" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814061699">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814061700">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061701">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061679" resolveInfo="tv" />
                </node>
                <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061702">
                  <link role="classifier:3" targetNodeId="9.7241381882860008759" resolveInfo="ASMFormalTypeParameter" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061703">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061704">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061705">
                    <property name="name:3" value="tp" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061706">
                      <link role="classifier:3" targetNodeId="9.7241381882860008759" resolveInfo="ASMFormalTypeParameter" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814061707">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061708">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814061679" resolveInfo="tv" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061709">
                        <link role="classifier:3" targetNodeId="9.7241381882860008759" resolveInfo="ASMFormalTypeParameter" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814061710">
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814061711">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061712">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061713">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814061705" resolveInfo="tp" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061714">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008801" resolveInfo="getClassBound" />
                      </node>
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814061715" />
                  </node>
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061716">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061717">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061718">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061719">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814061683" resolveInfo="typeVariableDeclaration" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061720">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.setBound(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setBound" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814061721">
                            <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061722">
                              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061723">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061705" resolveInfo="tp" />
                              </node>
                              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061724">
                                <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008801" resolveInfo="getClassBound" />
                              </node>
                            </node>
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814061725" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061726">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814061672" resolveInfo="result" />
                            </node>
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061727">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814061670" resolveInfo="model" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814061728">
                  <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061729">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061730">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814061705" resolveInfo="tp" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061731">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008809" resolveInfo="getInterfaceBounds" />
                    </node>
                  </node>
                  <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061732">
                    <property name="name:3" value="act" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061733">
                      <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                    </node>
                  </node>
                  <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061734">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061735">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061736">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061737">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814061683" resolveInfo="typeVariableDeclaration" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061738">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.addAuxBounds(jetbrains.mps.baseLanguage.structure.ClassifierType):void" resolveInfo="addAuxBounds" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814061739">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814061740">
                              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061741">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061732" resolveInfo="act" />
                              </node>
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814061742" />
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061743">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061672" resolveInfo="result" />
                              </node>
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061744">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061670" resolveInfo="model" />
                              </node>
                            </node>
                            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061745">
                              <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
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
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814061746">
      <property name="name:3" value="updateTypeVariables" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814061747" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814061748" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061749">
        <property name="name:3" value="method" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061750">
          <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061751">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061752">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061753">
        <property name="name:3" value="result" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061754">
          <link role="classifier:3" targetNodeId="5.~BaseMethodDeclaration" resolveInfo="BaseMethodDeclaration" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061755">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061756">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061757">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061758">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061759">
            <property name="name:3" value="typeVars" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061760">
              <link role="classifier:3" targetNodeId="4.~Map" resolveInfo="Map" />
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061761">
                <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
              </node>
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061762">
                <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814061763">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="2566197375814061764">
                <link role="baseMethodDeclaration:3" targetNodeId="4.~HashMap.&lt;init&gt;()" resolveInfo="HashMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061765">
                  <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
                </node>
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061766">
                  <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814061767">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061768">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061769">
              <link role="variableDeclaration:3" targetNodeId="2566197375814061749" resolveInfo="method" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061770">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006583" resolveInfo="getTypeParameters" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061771">
            <property name="name:3" value="tv" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061772">
              <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061773">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061774">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061775">
                <property name="name:3" value="typeVariableDeclaration" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061776">
                  <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814061777">
                  <link role="classConcept:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061778">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061751" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061779">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061780">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061781">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061775" resolveInfo="typeVariableDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061782">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061783">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061784">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814061771" resolveInfo="tv" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061785">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061786">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061787">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061788">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061753" resolveInfo="result" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061789">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~GenericDeclaration.addTypeVariableDeclaration(jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration):void" resolveInfo="addTypeVariableDeclaration" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061790">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061775" resolveInfo="typeVariableDeclaration" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061791">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061792">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061793">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061759" resolveInfo="typeVars" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061794">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~Map.put(java.lang.Object,java.lang.Object):java.lang.Object" resolveInfo="put" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061795">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061771" resolveInfo="tv" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061796">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061775" resolveInfo="typeVariableDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814061797">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061798">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061799">
              <link role="variableDeclaration:3" targetNodeId="2566197375814061749" resolveInfo="method" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061800">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006583" resolveInfo="getTypeParameters" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061801">
            <property name="name:3" value="tv" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061802">
              <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061803">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061804">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061805">
                <property name="name:3" value="typeVariableDeclaration" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061806">
                  <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061807">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061808">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061759" resolveInfo="typeVars" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061809">
                    <link role="baseMethodDeclaration:3" targetNodeId="4.~Map.get(java.lang.Object):java.lang.Object" resolveInfo="get" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061810">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814061801" resolveInfo="tv" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814061811">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814061812">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061813">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061801" resolveInfo="tv" />
                </node>
                <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061814">
                  <link role="classifier:3" targetNodeId="9.7241381882860008759" resolveInfo="ASMFormalTypeParameter" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061815">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061816">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061817">
                    <property name="name:3" value="tp" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061818">
                      <link role="classifier:3" targetNodeId="9.7241381882860008759" resolveInfo="ASMFormalTypeParameter" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814061819">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061820">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814061801" resolveInfo="tv" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061821">
                        <link role="classifier:3" targetNodeId="9.7241381882860008759" resolveInfo="ASMFormalTypeParameter" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814061822">
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814061823">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061824">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061825">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814061817" resolveInfo="tp" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061826">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008801" resolveInfo="getClassBound" />
                      </node>
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814061827" />
                  </node>
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061828">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061829">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061830">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061831">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814061805" resolveInfo="typeVariableDeclaration" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061832">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.setBound(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setBound" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814061833">
                            <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061834">
                              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061835">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061817" resolveInfo="tp" />
                              </node>
                              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061836">
                                <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008801" resolveInfo="getClassBound" />
                              </node>
                            </node>
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061837">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814061753" resolveInfo="result" />
                            </node>
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061838">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814061755" resolveInfo="cls" />
                            </node>
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061839">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814061751" resolveInfo="model" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814061840">
                  <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061841">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061842">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814061817" resolveInfo="tp" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061843">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008809" resolveInfo="getInterfaceBounds" />
                    </node>
                  </node>
                  <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061844">
                    <property name="name:3" value="act" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061845">
                      <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                    </node>
                  </node>
                  <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061846">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061847">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061848">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061849">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814061805" resolveInfo="typeVariableDeclaration" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061850">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.addAuxBounds(jetbrains.mps.baseLanguage.structure.ClassifierType):void" resolveInfo="addAuxBounds" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814061851">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814061852">
                              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061853">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061844" resolveInfo="act" />
                              </node>
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061854">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061753" resolveInfo="result" />
                              </node>
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061855">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061755" resolveInfo="cls" />
                              </node>
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061856">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814061751" resolveInfo="model" />
                              </node>
                            </node>
                            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061857">
                              <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
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
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814061858">
      <property name="name:3" value="findTypeVariableDeclaration" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814061859" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061860">
        <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061861">
        <property name="name:3" value="genDecl" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061862">
          <link role="classifier:3" targetNodeId="5.~GenericDeclaration" resolveInfo="GenericDeclaration" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061863">
        <property name="name:3" value="name" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814061864" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061865">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814061866">
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061867">
            <property name="name:3" value="tvd" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061868">
              <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061869">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814061870">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061871">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061872">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061863" resolveInfo="name" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061873">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~String.equals(java.lang.Object):boolean" resolveInfo="equals" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061874">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061875">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814061867" resolveInfo="tvd" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061876">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.getName():java.lang.String" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061877">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814061878">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061879">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814061867" resolveInfo="tvd" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814061880">
            <link role="baseMethodDeclaration:3" targetNodeId="6.~IterableUtil.asIterable(java.util.Iterator):java.lang.Iterable" resolveInfo="asIterable" />
            <link role="classConcept:3" targetNodeId="6.~IterableUtil" resolveInfo="IterableUtil" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061881">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061882">
                <link role="variableDeclaration:3" targetNodeId="2566197375814061861" resolveInfo="genDecl" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061883">
                <link role="baseMethodDeclaration:3" targetNodeId="5.~GenericDeclaration.typeVariableDeclarations():java.util.Iterator" resolveInfo="typeVariableDeclarations" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814061884">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814061885" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814061886">
      <property name="name:3" value="createTypeVariableReference" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814061887" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061888">
        <link role="classifier:3" targetNodeId="5.~TypeVariableReference" resolveInfo="TypeVariableReference" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061889">
        <property name="name:3" value="genDecl" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061890">
          <link role="classifier:3" targetNodeId="5.~GenericDeclaration" resolveInfo="GenericDeclaration" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814061891">
        <property name="name:3" value="name" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814061892" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061893">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814061894">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814061895">
            <property name="name:3" value="result" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814061896">
              <link role="classifier:3" targetNodeId="5.~TypeVariableReference" resolveInfo="TypeVariableReference" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814061897">
              <link role="classConcept:3" targetNodeId="5.~TypeVariableReference" resolveInfo="TypeVariableReference" />
              <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableReference.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.TypeVariableReference" resolveInfo="newInstance" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061898">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061899">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061889" resolveInfo="genDecl" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061900">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814061901">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814061902">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061903">
              <link role="variableDeclaration:3" targetNodeId="2566197375814061895" resolveInfo="result" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814061904">
              <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableReference.setTypeVariableDeclaration(jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration):void" resolveInfo="setTypeVariableDeclaration" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814061905">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061858" resolveInfo="findTypeVariableDeclaration" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061906">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061889" resolveInfo="genDecl" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814061907">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814061891" resolveInfo="name" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814061908">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814061909">
            <link role="variableDeclaration:3" targetNodeId="2566197375814061895" resolveInfo="result" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062123">
      <property name="name:3" value="updateAnnotations" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062124" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062125" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062126">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062127">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062128">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062129">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062130">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062131">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062132">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062133">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062126" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062134">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009877" resolveInfo="getAnnotations" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062135">
            <property name="name:3" value="annotation" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062136">
              <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062137">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062138">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062139">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062140">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062128" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062141">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062142">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062143">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062135" resolveInfo="annotation" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062144">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062145">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062128" resolveInfo="cls" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062146">
                        <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
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
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062147">
      <property name="name:3" value="updateExtendsForInterface" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062148" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062149" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062150">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062151">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062152">
        <property name="name:3" value="intfc" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062153">
          <link role="classifier:3" targetNodeId="5.~Interface" resolveInfo="Interface" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062154">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062155">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062156">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062157">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062158">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062159">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062152" resolveInfo="intfc" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062160">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062161">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062162">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062163">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062150" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062164">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009867" resolveInfo="getGenericInterfaces" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062165">
            <property name="name:3" value="type" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062166">
              <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062167">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062168">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062169">
                <property name="name:3" value="classifierType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062170">
                  <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814062171">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062172">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062173">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062165" resolveInfo="type" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062174" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062175">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062152" resolveInfo="intfc" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062176">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062156" resolveInfo="model" />
                    </node>
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062177">
                    <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062178">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062179">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062180">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062152" resolveInfo="intfc" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062181">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~Interface.addExtendedInterface(jetbrains.mps.baseLanguage.structure.ClassifierType):void" resolveInfo="addExtendedInterface" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062182">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062169" resolveInfo="classifierType" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062183">
      <property name="name:3" value="updateExtendsAndImplements" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062184" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062185" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062186">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062187">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062188">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062189">
          <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062190">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062191">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062192">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062193">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062194">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062195">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062188" resolveInfo="cls" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062196">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062197">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062198">
            <property name="name:3" value="refSuperclass" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062199">
              <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062200">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062201">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062186" resolveInfo="ac" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062202">
                <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009894" resolveInfo="getGenericSuperclass" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062203">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814062204">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062205">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062198" resolveInfo="refSuperclass" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062206" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062207">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062208">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062209">
                <property name="name:3" value="classifierType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062210">
                  <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814062211">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062212">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062213">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062198" resolveInfo="refSuperclass" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062214" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062215">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062188" resolveInfo="cls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062216">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062192" resolveInfo="model" />
                    </node>
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062217">
                    <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062218">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062219">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062220">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062188" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062221">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.setSuperclass(jetbrains.mps.baseLanguage.structure.ClassifierType):void" resolveInfo="setSuperclass" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062222">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062209" resolveInfo="classifierType" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062223">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062224">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062225">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062188" resolveInfo="cls" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062226">
              <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.getImplementedInterfaces():java.util.List" resolveInfo="getImplementedInterfaces" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062227">
            <property name="name:3" value="itype" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814082174">
              <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062229">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062230">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062231">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062232">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062227" resolveInfo="itype" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062233">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.delete():void" resolveInfo="delete" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062234">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062235">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062236">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062186" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062237">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009867" resolveInfo="getGenericInterfaces" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062238">
            <property name="name:3" value="type" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062239">
              <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062240">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062241">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062242">
                <property name="name:3" value="classifierType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062243">
                  <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814062244">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062245">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062246">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062238" resolveInfo="type" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062247" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062248">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062188" resolveInfo="cls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062249">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062192" resolveInfo="model" />
                    </node>
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062250">
                    <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062251">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062252">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062253">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062188" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062254">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.addImplementedInterface(jetbrains.mps.baseLanguage.structure.ClassifierType):void" resolveInfo="addImplementedInterface" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062255">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062242" resolveInfo="classifierType" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062256">
      <property name="name:3" value="updateInstanceFields" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062257" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062258" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062259">
        <property name="name:3" value="refCls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062260">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062261">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062262">
          <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062263">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062264">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062265">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062266">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062267">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062268">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062261" resolveInfo="cls" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062269">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062270">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062271">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062272">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062259" resolveInfo="refCls" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062273">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009902" resolveInfo="getDeclaredFields" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062274">
            <property name="name:3" value="field" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062275">
              <link role="classifier:3" targetNodeId="9.7241381882860006793" resolveInfo="ASMField" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062276">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062277">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814062278">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814062279">
                  <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
                  <link role="variableDeclaration:3" targetNodeId="4163040004507702758" resolveInfo="SKIP_PRIVATE" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062280">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062281">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062282">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006918" resolveInfo="isPrivate" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062283">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062284" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062285">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062286">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062287">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062288">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006997" resolveInfo="isStatic" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062289">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062290" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062291">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062292">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062293">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062294">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007027" resolveInfo="isCompilerGenerated" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062295">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062296" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062297">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062298">
                <property name="name:3" value="decl" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062299">
                  <link role="classifier:3" targetNodeId="5.~FieldDeclaration" resolveInfo="FieldDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062300">
                  <link role="classConcept:3" targetNodeId="5.~FieldDeclaration" resolveInfo="FieldDeclaration" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FieldDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.FieldDeclaration" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062301">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062265" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062302">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062303">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062304">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062305">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062306">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062307">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062308">
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008256" resolveInfo="createId" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062309">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062259" resolveInfo="refCls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062310">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062311">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062312">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062313">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062314">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FieldDeclaration.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062315">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063370" resolveInfo="createVisibility" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062316">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062317">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062265" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062318">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062319">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062320">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062321">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062322">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062323">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062324">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006908" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062325">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062326">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062327">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062328">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062329">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062330">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062331">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062332">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007048" resolveInfo="getGenericType" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062333" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062334">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062261" resolveInfo="cls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062335">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062265" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062336">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062337">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062338">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062339">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FieldDeclaration.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062340">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062341">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062342">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006963" resolveInfo="isDeprecated" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062343">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062344">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062345">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062274" resolveInfo="field" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062346">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007056" resolveInfo="getAnnotations" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062347">
                <property name="name:3" value="annotation" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062348">
                  <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062349">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062350">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062351">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062352">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062353">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~VariableDeclaration.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062354">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062355">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062347" resolveInfo="annotation" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062356">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062265" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062357">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062358">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062359">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062261" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062360">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.addField(jetbrains.mps.baseLanguage.structure.FieldDeclaration):void" resolveInfo="addField" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062361">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062298" resolveInfo="decl" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062362">
      <property name="name:3" value="updateStaticFields" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062363" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062364" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062365">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062366">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062367">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062368">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062369">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062370">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062371">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062372">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062373">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062374">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062367" resolveInfo="cls" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062375">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062376">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062377">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062378">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062365" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062379">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009902" resolveInfo="getDeclaredFields" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062380">
            <property name="name:3" value="field" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062381">
              <link role="classifier:3" targetNodeId="9.7241381882860006793" resolveInfo="ASMField" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062382">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062383">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814062384">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814062385">
                  <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
                  <link role="variableDeclaration:3" targetNodeId="4163040004507702758" resolveInfo="SKIP_PRIVATE" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062386">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062387">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062388">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006918" resolveInfo="isPrivate" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062389">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062390" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062391">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="2566197375814062392">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062393">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062394">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062395">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006997" resolveInfo="isStatic" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062396">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062397" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062398">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062399">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062400">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062401">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007027" resolveInfo="isCompilerGenerated" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062402">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062403" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062404">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062405">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062406">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062407">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007012" resolveInfo="isEnumConstant" />
                </node>
              </node>
              <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="2566197375814062408">
                <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062409">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062410">
                    <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062411">
                      <property name="name:3" value="decl" />
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062412">
                        <link role="classifier:3" targetNodeId="5.~StaticFieldDeclaration" resolveInfo="StaticFieldDeclaration" />
                      </node>
                      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062413">
                        <link role="classConcept:3" targetNodeId="5.~StaticFieldDeclaration" resolveInfo="StaticFieldDeclaration" />
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~StaticFieldDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration" resolveInfo="newInstance" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062414">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062371" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062415">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062416">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062417">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062418">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062419">
                          <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                        </node>
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062420">
                        <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062421">
                          <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008256" resolveInfo="createId" />
                          <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062422">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062365" resolveInfo="ac" />
                          </node>
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062423">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062424">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062425">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062426">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062427">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~StaticFieldDeclaration.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062428">
                          <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063370" resolveInfo="createVisibility" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062429">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                          </node>
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062430">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062371" resolveInfo="model" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062431">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062432">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062433">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062434">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062435">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062436">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062437">
                            <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006908" resolveInfo="getName" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062438">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062439">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062440">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062441">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062442">
                          <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062443">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062444">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062445">
                              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007048" resolveInfo="getGenericType" />
                            </node>
                          </node>
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062446" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062447">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062367" resolveInfo="cls" />
                          </node>
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062448">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062371" resolveInfo="model" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062449">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062450">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062451">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062452">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~StaticFieldDeclaration.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062453">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062454">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062455">
                            <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006963" resolveInfo="isDeprecated" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062456">
                    <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062457">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062458">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062459">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007056" resolveInfo="getAnnotations" />
                      </node>
                    </node>
                    <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062460">
                      <property name="name:3" value="annotation" />
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062461">
                        <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                      </node>
                    </node>
                    <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062462">
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062463">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062464">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062465">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062466">
                            <link role="baseMethodDeclaration:3" targetNodeId="5.~VariableDeclaration.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062467">
                              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062468">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814062460" resolveInfo="annotation" />
                              </node>
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062469">
                                <link role="variableDeclaration:3" targetNodeId="2566197375814062371" resolveInfo="model" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062470">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062471">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062472">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062367" resolveInfo="cls" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062473">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.addStaticField(jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration):void" resolveInfo="addStaticField" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062474">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062411" resolveInfo="decl" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062475">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062476">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062477">
                    <property name="name:3" value="enumClass" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062478">
                      <link role="classifier:3" targetNodeId="5.~EnumClass" resolveInfo="EnumClass" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814062479">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062480">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062367" resolveInfo="cls" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062481">
                        <link role="classifier:3" targetNodeId="5.~EnumClass" resolveInfo="EnumClass" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062482">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062483">
                    <property name="name:3" value="enumConstantDeclaration" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062484">
                      <link role="classifier:3" targetNodeId="5.~EnumConstantDeclaration" resolveInfo="EnumConstantDeclaration" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062485">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~EnumConstantDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration" resolveInfo="newInstance" />
                      <link role="classConcept:3" targetNodeId="5.~EnumConstantDeclaration" resolveInfo="EnumConstantDeclaration" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062486">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062371" resolveInfo="model" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062487">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062488">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062489">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062490">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062483" resolveInfo="enumConstantDeclaration" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062491">
                        <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062492">
                      <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062493">
                        <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008256" resolveInfo="createId" />
                        <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062494">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062365" resolveInfo="ac" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062495">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062496">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062497">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062498">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062483" resolveInfo="enumConstantDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062499">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~EnumConstantDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062500">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062501">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062380" resolveInfo="field" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062502">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006908" resolveInfo="getName" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062503">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062504">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062505">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062477" resolveInfo="enumClass" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062506">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~EnumClass.addEnumConstant(jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration):void" resolveInfo="addEnumConstant" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062507">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062483" resolveInfo="enumConstantDeclaration" />
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
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062508">
      <property name="name:3" value="updateAnnotationMethods" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062509" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062510" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062511">
        <property name="name:3" value="refCls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062512">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062513">
        <property name="name:3" value="annotation" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062514">
          <link role="classifier:3" targetNodeId="5.~Annotation" resolveInfo="Annotation" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062515">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062516">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062517">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062518">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062519">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062520">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062513" resolveInfo="annotation" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062521">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062522">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062523">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062524">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062511" resolveInfo="refCls" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062525">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009912" resolveInfo="getDeclaredMethods" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062526">
            <property name="name:3" value="m" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062527">
              <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062528">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062529">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062530">
                <property name="name:3" value="methodDeclaration" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062531">
                  <link role="classifier:3" targetNodeId="5.~AnnotationMethodDeclaration" resolveInfo="AnnotationMethodDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062532">
                  <link role="classConcept:3" targetNodeId="5.~AnnotationMethodDeclaration" resolveInfo="AnnotationMethodDeclaration" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationMethodDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.AnnotationMethodDeclaration" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062533">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062517" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062534">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062535">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062536">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062537">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062538">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062539">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062540">
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008298" resolveInfo="createId" />
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062541">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062511" resolveInfo="refCls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062542">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062526" resolveInfo="m" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062543">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062544">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062545">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062546">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~InstanceMethodDeclaration.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062547">
                    <link role="classConcept:3" targetNodeId="5.~PublicVisibility" resolveInfo="PublicVisibility" />
                    <link role="baseMethodDeclaration:3" targetNodeId="5.~PublicVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PublicVisibility" resolveInfo="newInstance" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062548">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062517" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062549">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062550">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062551">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062552">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062553">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062554">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062526" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062555">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062556">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062557">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062558">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062559">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setReturnType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setReturnType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062560">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062561">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062562">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062526" resolveInfo="m" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062563">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006600" resolveInfo="getGenericReturnType" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062564" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062565">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062513" resolveInfo="annotation" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062566">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062517" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062567">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062568">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062569">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062570">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062571">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062572">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062573">
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008386" resolveInfo="createAnnotationMethodId" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062574">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062575">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062511" resolveInfo="refCls" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062576">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009843" resolveInfo="getFqName" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062577">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062578">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062526" resolveInfo="m" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062579">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062580">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062581">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062582">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062583">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062584">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062585">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationMethodDeclaration.setDefaultValue(jetbrains.mps.baseLanguage.structure.Expression):void" resolveInfo="setDefaultValue" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062586">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063500" resolveInfo="getAnnotationValue" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062587">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062588">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062526" resolveInfo="m" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062589">
                            <link role="baseMethodDeclaration:3" targetNodeId="9.6678934770475968071" resolveInfo="getAnnotationDefault" />
                          </node>
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062590">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062517" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814062591">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814062592" />
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062593">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062594">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062526" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062595">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.6678934770475968071" resolveInfo="getAnnotationDefault" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062596">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062597">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062598">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062513" resolveInfo="annotation" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062599">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.addMethod(jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration):void" resolveInfo="addMethod" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062600">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062530" resolveInfo="methodDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062601">
      <property name="name:3" value="updateConstructors" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062602" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062603" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062604">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062605">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062606">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062607">
          <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062608">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062609">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062610">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062611">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062612">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062613">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062606" resolveInfo="cls" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062614">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062615">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062616">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062617">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062604" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062618">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009922" resolveInfo="getDeclaredConstructors" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062619">
            <property name="name:3" value="c" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062620">
              <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062621">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062622">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814062623">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814062624">
                  <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
                  <link role="variableDeclaration:3" targetNodeId="4163040004507702758" resolveInfo="SKIP_PRIVATE" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062625">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062626">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062627">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006409" resolveInfo="isPrivate" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062628">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062629" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062630">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062631">
                <property name="name:3" value="constructor" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062632">
                  <link role="classifier:3" targetNodeId="5.~ConstructorDeclaration" resolveInfo="ConstructorDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062633">
                  <link role="classConcept:3" targetNodeId="5.~ConstructorDeclaration" resolveInfo="ConstructorDeclaration" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ConstructorDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ConstructorDeclaration" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062634">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062610" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062635">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062636">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062637">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062638">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062639">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062640">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062641">
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008298" resolveInfo="createId" />
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062642">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062604" resolveInfo="ac" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062643">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062644">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062645">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062646">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062647">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setBody(jetbrains.mps.baseLanguage.structure.StatementList):void" resolveInfo="setBody" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814062648">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814062649">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062650">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814062651">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814062652">
                            <node role="creator:3" type="jetbrains.mps.lang.smodel.structure.SNodeCreator:16" id="2566197375814062653">
                              <node role="createdType:16" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="2566197375814062654">
                                <link role="concept:16" targetNodeId="12.5293379017992965193:3" resolveInfo="StubStatementList" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetAdapterOperation:16" id="2566197375814062655" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062656">
                        <link role="classifier:3" targetNodeId="5.~StatementList" resolveInfo="StatementList" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="2566197375814062657" />
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062658">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062659">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062660">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062661">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ConstructorDeclaration.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062662">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063336" resolveInfo="createVisibility" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062663">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062664">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062610" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062665">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062666">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062667">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062668">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062669">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062670">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062671">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006488" resolveInfo="isDeprecated" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062672">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062673">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062674">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062675">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006583" resolveInfo="getTypeParameters" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062676">
                <property name="name:3" value="tv" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062677">
                  <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062678">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062679">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062680">
                    <property name="name:3" value="typeVariableDeclaration" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062681">
                      <link role="classifier:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062682">
                      <link role="classConcept:3" targetNodeId="5.~TypeVariableDeclaration" resolveInfo="TypeVariableDeclaration" />
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration" resolveInfo="newInstance" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062683">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062684">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062606" resolveInfo="cls" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062685">
                          <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062686">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062687">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062688">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062680" resolveInfo="typeVariableDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062689">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~TypeVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062690">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062691">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062676" resolveInfo="tv" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062692">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062693">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062694">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062695">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062696">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~GenericDeclaration.addTypeVariableDeclaration(jetbrains.mps.baseLanguage.structure.TypeVariableDeclaration):void" resolveInfo="addTypeVariableDeclaration" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062697">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062680" resolveInfo="typeVariableDeclaration" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062698">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062699">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062700">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062701">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062702">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062703">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062606" resolveInfo="cls" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062704">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.getName():java.lang.String" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062705">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062706">
                <property name="name:3" value="parameterType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062707">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062708">
                    <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062709">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062710">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062711">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006635" resolveInfo="getGenericParameterTypes" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062712">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062713">
                <property name="name:3" value="parameterNames" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062714">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814062715" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062716">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062717">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062718">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006645" resolveInfo="getParameterNames" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForStatement:3" id="2566197375814062719">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="2566197375814062720">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062721">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062771" resolveInfo="i" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062722">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062723">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062706" resolveInfo="parameterType" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062724">
                    <link role="baseMethodDeclaration:3" targetNodeId="4.~List.size():int" resolveInfo="size" />
                  </node>
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062725">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062726">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062727">
                    <property name="name:3" value="pt" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062728">
                      <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062729">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062730">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062706" resolveInfo="parameterType" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062731">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062732">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062771" resolveInfo="i" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062733">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062734">
                    <property name="name:3" value="pd" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062735">
                      <link role="classifier:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062736">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~ParameterDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ParameterDeclaration" resolveInfo="newInstance" />
                      <link role="classConcept:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062737">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062610" resolveInfo="model" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062738">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062739">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062740">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062734" resolveInfo="pd" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062741">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062742">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062743">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062713" resolveInfo="parameterNames" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062744">
                          <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062745">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814062771" resolveInfo="i" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062746">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062747">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062748">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062734" resolveInfo="pd" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062749">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setType" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062750">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062751">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062727" resolveInfo="pt" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062752">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062753">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062606" resolveInfo="cls" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062754">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062610" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062755">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062756">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063404" resolveInfo="addAnnotationsToParameter" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062757">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062734" resolveInfo="pd" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062758">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062759">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062760">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062761">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006662" resolveInfo="getParameterAnnotations" />
                        </node>
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062762">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062763">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062771" resolveInfo="i" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062764">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062765">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062766">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062767">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addParameter(jetbrains.mps.baseLanguage.structure.ParameterDeclaration):void" resolveInfo="addParameter" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062768">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062734" resolveInfo="pd" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="iteration:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="2566197375814062769">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062770">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062771" resolveInfo="i" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062771">
                <property name="name:3" value="i" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="2566197375814062772" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="2566197375814062773">
                  <property name="value:3" value="0" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062774">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062775">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062776">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062777">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006608" resolveInfo="getAnnotations" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062778">
                <property name="name:3" value="annotation" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062779">
                  <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062780">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062781">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062782">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062783">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062784">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062785">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062786">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062778" resolveInfo="annotation" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062787">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062610" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062788">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062789">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062790">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062619" resolveInfo="c" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062791">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006673" resolveInfo="getExceptionTypes" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062792">
                <property name="name:3" value="exception" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062793">
                  <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062794">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062795">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062796">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062797">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062798">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addThrowsItem(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="addThrowsItem" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062799">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062800">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062792" resolveInfo="exception" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062801">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062802">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062606" resolveInfo="cls" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062803">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062610" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062804">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062805">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062806">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062606" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062807">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.addConstructor(jetbrains.mps.baseLanguage.structure.ConstructorDeclaration):void" resolveInfo="addConstructor" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062808">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062631" resolveInfo="constructor" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814062809">
      <property name="name:3" value="updateInstanceMethods" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814062810" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814062811" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062812">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062813">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814062814">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062815">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062816">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062817">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062818">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062819">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062820">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062821">
                <link role="variableDeclaration:3" targetNodeId="2566197375814062814" resolveInfo="cls" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062822">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814062823">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062824">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062825">
              <link role="variableDeclaration:3" targetNodeId="2566197375814062812" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062826">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009912" resolveInfo="getDeclaredMethods" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062827">
            <property name="name:3" value="m" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062828">
              <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062829">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062830">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814062831">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814062832">
                  <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
                  <link role="variableDeclaration:3" targetNodeId="4163040004507702758" resolveInfo="SKIP_PRIVATE" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062833">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062834">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062835">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006409" resolveInfo="isPrivate" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062836">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062837" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062838">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062839">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062840">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062841">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006473" resolveInfo="isStatic" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062842">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062843" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062844">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062845">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062846">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062847">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006533" resolveInfo="isBridge" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062848">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062849" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814062850">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062851">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062852">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062853">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006561" resolveInfo="isCompilerGenerated" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062854">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814062855" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062856">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062857">
                <property name="name:3" value="methodDeclaration" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062858">
                  <link role="classifier:3" targetNodeId="5.~InstanceMethodDeclaration" resolveInfo="InstanceMethodDeclaration" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062859">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~InstanceMethodDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~InstanceMethodDeclaration" resolveInfo="InstanceMethodDeclaration" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062860">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062861">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062862">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062863">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062864">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062865">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062866">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062867">
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008298" resolveInfo="createId" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062868">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062812" resolveInfo="ac" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062869">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062870">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062871">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062872">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062873">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setBody(jetbrains.mps.baseLanguage.structure.StatementList):void" resolveInfo="setBody" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814062874">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814062875">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062876">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814062877">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814062878">
                            <node role="creator:3" type="jetbrains.mps.lang.smodel.structure.SNodeCreator:16" id="2566197375814062879">
                              <node role="createdType:16" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="2566197375814062880">
                                <link role="concept:16" targetNodeId="12.5293379017992965193:3" resolveInfo="StubStatementList" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetAdapterOperation:16" id="2566197375814062881" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062882">
                        <link role="classifier:3" targetNodeId="5.~StatementList" resolveInfo="StatementList" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062883">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062884">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062885">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062886">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~InstanceMethodDeclaration.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062887">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063336" resolveInfo="createVisibility" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062888">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062889">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062890">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062891">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062892">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062893">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setIsFinal(boolean):void" resolveInfo="setIsFinal" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062894">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062895">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062896">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006503" resolveInfo="isFinal" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062897">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062898">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062899">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062900">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~InstanceMethodDeclaration.setIsAbstract(boolean):void" resolveInfo="setIsAbstract" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062901">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062902">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062903">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006518" resolveInfo="isAbstract" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062904">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062905">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062906">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062907">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062908">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062909">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062910">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006488" resolveInfo="isDeprecated" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062911">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062912">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061746" resolveInfo="updateTypeVariables" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062913">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062914">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062915">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062916">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062814" resolveInfo="cls" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062917">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062918">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062919">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062920">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062921">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062922">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062923">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062924">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062925">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062926">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062927">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setReturnType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setReturnType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062928">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062929">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062930">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062931">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006600" resolveInfo="getGenericReturnType" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062932">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062933">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062814" resolveInfo="cls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062934">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062935">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062936">
                <property name="name:3" value="parameterTypes" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062937">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062938">
                    <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062939">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062940">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062941">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006635" resolveInfo="getGenericParameterTypes" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062942">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062943">
                <property name="name:3" value="parameterNames" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062944">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814062945" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062946">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062947">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062948">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006645" resolveInfo="getParameterNames" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForStatement:3" id="2566197375814062949">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="2566197375814062950">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062951">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063001" resolveInfo="i" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062952">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062953">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062936" resolveInfo="parameterTypes" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062954">
                    <link role="baseMethodDeclaration:3" targetNodeId="4.~List.size():int" resolveInfo="size" />
                  </node>
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814062955">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062956">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062957">
                    <property name="name:3" value="paramType" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062958">
                      <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062959">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062960">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062936" resolveInfo="parameterTypes" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062961">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062962">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063001" resolveInfo="i" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814062963">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814062964">
                    <property name="name:3" value="parameterDeclaration" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814062965">
                      <link role="classifier:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814062966">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~ParameterDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ParameterDeclaration" resolveInfo="newInstance" />
                      <link role="classConcept:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062967">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062968">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062969">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062970">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062964" resolveInfo="parameterDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062971">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062972">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062973">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062943" resolveInfo="parameterNames" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062974">
                          <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062975">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814063001" resolveInfo="i" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062976">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062977">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062978">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062964" resolveInfo="parameterDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062979">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setType" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062980">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062981">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062957" resolveInfo="paramType" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062982">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814062983">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062814" resolveInfo="cls" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062984">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062985">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814062986">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063404" resolveInfo="addAnnotationsToParameter" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062987">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062964" resolveInfo="parameterDeclaration" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062988">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062989">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062990">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062991">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006662" resolveInfo="getParameterAnnotations" />
                        </node>
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062992">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062993">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063001" resolveInfo="i" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814062994">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814062995">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062996">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814062997">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addParameter(jetbrains.mps.baseLanguage.structure.ParameterDeclaration):void" resolveInfo="addParameter" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814062998">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814062964" resolveInfo="parameterDeclaration" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="iteration:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="2566197375814062999">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063000">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063001" resolveInfo="i" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063001">
                <property name="name:3" value="i" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="2566197375814063002" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="2566197375814063003">
                  <property name="value:3" value="0" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063004">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063005">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063006">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063007">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006673" resolveInfo="getExceptionTypes" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063008">
                <property name="name:3" value="exception" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063009">
                  <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063010">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063011">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063012">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063013">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063014">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addThrowsItem(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="addThrowsItem" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063015">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063016">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063008" resolveInfo="exception" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063017">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063018">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062814" resolveInfo="cls" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063019">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063020">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063021">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063022">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062827" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063023">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006608" resolveInfo="getAnnotations" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063024">
                <property name="name:3" value="annotation" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063025">
                  <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063026">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063027">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063028">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063029">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063030">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063031">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063032">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063024" resolveInfo="annotation" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063033">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814062818" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063034">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063035">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063036">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814062814" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063037">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~Classifier.addMethod(jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration):void" resolveInfo="addMethod" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063038">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814062857" resolveInfo="methodDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063039">
      <property name="name:3" value="updateStaticMethods" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814063040" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814063041" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063042">
        <property name="name:3" value="ac" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063043">
          <link role="classifier:3" targetNodeId="9.7241381882860009362" resolveInfo="ASMClass" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063044">
        <property name="name:3" value="cls" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063045">
          <link role="classifier:3" targetNodeId="5.~ClassConcept" resolveInfo="ClassConcept" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063046">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063047">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063048">
            <property name="name:3" value="model" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063049">
              <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063050">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063051">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063052">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063053">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063054">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063055">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063042" resolveInfo="ac" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063056">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009912" resolveInfo="getDeclaredMethods" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063057">
            <property name="name:3" value="m" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063058">
              <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063059">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063060">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814063061">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063062">
                  <link role="classifier:3" targetNodeId="7241381882860001930" resolveInfo="ASMModelLoader" />
                  <link role="variableDeclaration:3" targetNodeId="4163040004507702758" resolveInfo="SKIP_PRIVATE" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063063">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063064">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063065">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006409" resolveInfo="isPrivate" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063066">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814063067" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063068">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="2566197375814063069">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063070">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063071">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063072">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006473" resolveInfo="isStatic" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063073">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814063074" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063075">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063076">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063077">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063078">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006561" resolveInfo="isCompilerGenerated" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063079">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814063080" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063081">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814063082">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063083">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063084">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
                  </node>
                  <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063085">
                    <link role="classifier:3" targetNodeId="5.~EnumClass" resolveInfo="EnumClass" />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063086">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063269" resolveInfo="isGeneratedEnumMethod" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063087">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063088">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="2566197375814063089" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063090">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063091">
                <property name="name:3" value="methodDeclaration" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063092">
                  <link role="classConcept:3" targetNodeId="5.~StaticMethodDeclaration" resolveInfo="StaticMethodDeclaration" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~StaticMethodDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063093">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                  </node>
                </node>
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063094">
                  <link role="classifier:3" targetNodeId="5.~StaticMethodDeclaration" resolveInfo="StaticMethodDeclaration" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063095">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063096">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063097">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063098">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063099">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063100">
                  <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.setId(jetbrains.mps.smodel.SNodeId):void" resolveInfo="setId" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063101">
                    <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008298" resolveInfo="createId" />
                    <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063102">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063042" resolveInfo="ac" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063103">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063104">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063105">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063106">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063107">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setBody(jetbrains.mps.baseLanguage.structure.StatementList):void" resolveInfo="setBody" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814063108">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063109">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063110">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814063111">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814063112">
                            <node role="creator:3" type="jetbrains.mps.lang.smodel.structure.SNodeCreator:16" id="2566197375814063113">
                              <node role="createdType:16" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="2566197375814063114">
                                <link role="concept:16" targetNodeId="12.5293379017992965193:3" resolveInfo="StubStatementList" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetAdapterOperation:16" id="2566197375814063115" />
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063116">
                        <link role="classifier:3" targetNodeId="5.~StatementList" resolveInfo="StatementList" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063117">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063118">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063119">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063120">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~StaticMethodDeclaration.setVisibility(jetbrains.mps.baseLanguage.structure.Visibility):void" resolveInfo="setVisibility" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063121">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063336" resolveInfo="createVisibility" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063122">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063123">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063124">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063125">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063126">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063127">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setIsDeprecated(boolean):void" resolveInfo="setIsDeprecated" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063128">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063129">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063130">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006488" resolveInfo="isDeprecated" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063131">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063132">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063133">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063134">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006503" resolveInfo="isFinal" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063135">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063136">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063137">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063138">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063139">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setIsFinal(boolean):void" resolveInfo="setIsFinal" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="2566197375814063140">
                        <property name="value:3" value="true" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063141">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063142">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061746" resolveInfo="updateTypeVariables" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063143">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063144">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063145">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063146">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063147">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063148">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063149">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063150">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063151">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063152">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063153">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063154">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063155">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063156">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063157">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.setReturnType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setReturnType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063158">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063159">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063160">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063161">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006600" resolveInfo="getGenericReturnType" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063162">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063163">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063164">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063165">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063166">
                <property name="name:3" value="parameterTypes" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063167">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063168">
                    <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063169">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063170">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063171">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006635" resolveInfo="getGenericParameterTypes" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063172">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063173">
                <property name="name:3" value="parameterNames" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063174">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814063175" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063176">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063177">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063178">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006645" resolveInfo="getParameterNames" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForStatement:3" id="2566197375814063179">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="2566197375814063180">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063181">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063231" resolveInfo="i" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063182">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063183">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063166" resolveInfo="parameterTypes" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063184">
                    <link role="baseMethodDeclaration:3" targetNodeId="4.~List.size():int" resolveInfo="size" />
                  </node>
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063185">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063186">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063187">
                    <property name="name:3" value="paramType" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063188">
                      <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063189">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063190">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063166" resolveInfo="parameterTypes" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063191">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063192">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063231" resolveInfo="i" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063193">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063194">
                    <property name="name:3" value="parameterDeclaration" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063195">
                      <link role="classifier:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063196">
                      <link role="classConcept:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~ParameterDeclaration.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ParameterDeclaration" resolveInfo="newInstance" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063197">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063198">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063199">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063200">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063194" resolveInfo="parameterDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063201">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setName(java.lang.String):void" resolveInfo="setName" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063202">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063203">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063173" resolveInfo="parameterNames" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063204">
                          <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063205">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814063231" resolveInfo="i" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063206">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063207">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063208">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063194" resolveInfo="parameterDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063209">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseVariableDeclaration.setType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setType" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063210">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063211">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063187" resolveInfo="paramType" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063212">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063213">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063214">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063215">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063216">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063404" resolveInfo="addAnnotationsToParameter" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063217">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063194" resolveInfo="parameterDeclaration" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063218">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063219">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063220">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063221">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006662" resolveInfo="getParameterAnnotations" />
                        </node>
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063222">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063223">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063231" resolveInfo="i" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063224">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063225">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063226">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063227">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addParameter(jetbrains.mps.baseLanguage.structure.ParameterDeclaration):void" resolveInfo="addParameter" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063228">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063194" resolveInfo="parameterDeclaration" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="iteration:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="2566197375814063229">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063230">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063231" resolveInfo="i" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063231">
                <property name="name:3" value="i" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="2566197375814063232" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="2566197375814063233">
                  <property name="value:3" value="0" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063234">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063235">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063236">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063237">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006608" resolveInfo="getAnnotations" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063238">
                <property name="name:3" value="annotation" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063239">
                  <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063240">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063241">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063242">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063243">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063244">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063245">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063246">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063238" resolveInfo="annotation" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063247">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063248">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063249">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063250">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063057" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063251">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006673" resolveInfo="getExceptionTypes" />
                </node>
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063252">
                <property name="name:3" value="exception" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063253">
                  <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063254">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063255">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063256">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063257">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063258">
                      <link role="baseMethodDeclaration:3" targetNodeId="5.~BaseMethodDeclaration.addThrowsItem(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="addThrowsItem" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063259">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063260">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063252" resolveInfo="exception" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063261">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063262">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063263">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063048" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063264">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063265">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063266">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063044" resolveInfo="cls" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063267">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassConcept.addStaticMethod(jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration):void" resolveInfo="addStaticMethod" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063268">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063091" resolveInfo="methodDeclaration" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063269">
      <property name="name:3" value="isGeneratedEnumMethod" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814063270" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="2566197375814063271" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063272">
        <property name="name:3" value="m" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063273">
          <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063274">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063275">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814063276">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063277">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063278">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063279">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063272" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063280">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063281">
                <link role="baseMethodDeclaration:3" targetNodeId="11.~String.equals(java.lang.Object):boolean" resolveInfo="equals" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063282">
                  <property name="value:3" value="values" />
                </node>
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063283">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063284">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063285">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063272" resolveInfo="m" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063286">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006625" resolveInfo="getParameterTypes" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063287">
                <link role="baseMethodDeclaration:3" targetNodeId="4.~List.isEmpty():boolean" resolveInfo="isEmpty" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063288">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063289">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="2566197375814063290">
                <property name="value:3" value="true" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063291">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814063292">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814063293">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063294">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063295">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063296">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063272" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063297">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006384" resolveInfo="getName" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063298">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~String.equals(java.lang.Object):boolean" resolveInfo="equals" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063299">
                    <property name="value:3" value="valueOf" />
                  </node>
                </node>
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063300">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063301">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063302">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063303">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063272" resolveInfo="m" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063304">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006625" resolveInfo="getParameterTypes" />
                    </node>
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063305">
                    <link role="baseMethodDeclaration:3" targetNodeId="4.~List.size():int" resolveInfo="size" />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="2566197375814063306">
                  <property name="value:3" value="1" />
                </node>
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063307">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063308">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063309">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063310">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063272" resolveInfo="m" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063311">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006625" resolveInfo="getParameterTypes" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063312">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="2566197375814063313">
                    <property name="value:3" value="0" />
                  </node>
                </node>
              </node>
              <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063314">
                <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063315">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063316">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063317">
                <property name="name:3" value="type" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063318">
                  <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063319">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063320">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063321">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063322">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063272" resolveInfo="m" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063323">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006625" resolveInfo="getParameterTypes" />
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063324">
                      <link role="baseMethodDeclaration:3" targetNodeId="4.~List.get(int):java.lang.Object" resolveInfo="get" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="2566197375814063325">
                        <property name="value:3" value="0" />
                      </node>
                    </node>
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063326">
                    <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063327">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063328">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063329">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063330">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063317" resolveInfo="type" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063331">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063332">
                  <link role="baseMethodDeclaration:3" targetNodeId="11.~String.equals(java.lang.Object):boolean" resolveInfo="equals" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063333">
                    <property name="value:3" value="java.lang.String" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063334">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="2566197375814063335" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063336">
      <property name="name:3" value="createVisibility" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="2566197375814063337" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063338">
        <link role="classifier:3" targetNodeId="5.~Visibility" resolveInfo="Visibility" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063339">
        <property name="name:3" value="m" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063340">
          <link role="classifier:3" targetNodeId="9.7241381882860005690" resolveInfo="ASMMethod" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063341">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063342">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063343">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063344">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063345">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063346">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063339" resolveInfo="m" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063347">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006424" resolveInfo="isPublic" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063348">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063349">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063350">
                <link role="classConcept:3" targetNodeId="5.~PublicVisibility" resolveInfo="PublicVisibility" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~PublicVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PublicVisibility" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063351">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063341" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063352">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063353">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063354">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063339" resolveInfo="m" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063355">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006409" resolveInfo="isPrivate" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063356">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063357">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063358">
                <link role="classConcept:3" targetNodeId="5.~PrivateVisibility" resolveInfo="PrivateVisibility" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~PrivateVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PrivateVisibility" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063359">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063341" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063360">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063361">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063362">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063339" resolveInfo="m" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063363">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006439" resolveInfo="isProtected" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063364">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063365">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063366">
                <link role="classConcept:3" targetNodeId="5.~ProtectedVisibility" resolveInfo="ProtectedVisibility" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~ProtectedVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ProtectedVisibility" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063367">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063341" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063368">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063369" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063370">
      <property name="name:3" value="createVisibility" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="2566197375814063371" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063372">
        <link role="classifier:3" targetNodeId="5.~Visibility" resolveInfo="Visibility" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063373">
        <property name="name:3" value="f" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063374">
          <link role="classifier:3" targetNodeId="9.7241381882860006793" resolveInfo="ASMField" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063375">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063376">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063377">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063378">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063379">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063380">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063373" resolveInfo="f" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063381">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006933" resolveInfo="isPublic" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063382">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063383">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063384">
                <link role="classConcept:3" targetNodeId="5.~PublicVisibility" resolveInfo="PublicVisibility" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~PublicVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PublicVisibility" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063385">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063375" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063386">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063387">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063388">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063373" resolveInfo="f" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063389">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006918" resolveInfo="isPrivate" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063390">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063391">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063392">
                <link role="classConcept:3" targetNodeId="5.~PrivateVisibility" resolveInfo="PrivateVisibility" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~PrivateVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PrivateVisibility" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063393">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063375" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063394">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063395">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063396">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063373" resolveInfo="f" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063397">
              <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860006948" resolveInfo="isProtected" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063398">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063399">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063400">
                <link role="classConcept:3" targetNodeId="5.~ProtectedVisibility" resolveInfo="ProtectedVisibility" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~ProtectedVisibility.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ProtectedVisibility" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063401">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063375" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063402">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063403" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063404">
      <property name="name:3" value="addAnnotationsToParameter" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814063405" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814063406" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063407">
        <property name="name:3" value="pd" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063408">
          <link role="classifier:3" targetNodeId="5.~ParameterDeclaration" resolveInfo="ParameterDeclaration" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063409">
        <property name="name:3" value="annotations" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063410">
          <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
          <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063411">
            <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
          </node>
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063412">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063413">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063414">
            <link role="variableDeclaration:3" targetNodeId="2566197375814063409" resolveInfo="annotations" />
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063415">
            <property name="name:3" value="a" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063416">
              <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063417">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063418">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063419">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063420">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063407" resolveInfo="pd" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063421">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~VariableDeclaration.addAnnotation(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="addAnnotation" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063422">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063423">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063415" resolveInfo="a" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063424">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063425">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063407" resolveInfo="pd" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063426">
                        <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
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
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063427">
      <property name="name:3" value="createAnnotation" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814063428" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063429">
        <link role="classifier:3" targetNodeId="5.~AnnotationInstance" resolveInfo="AnnotationInstance" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063430">
        <property name="name:3" value="annotation" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063431">
          <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063432">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063433">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063434">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063435">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063436">
            <property name="name:3" value="result" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063437">
              <link role="classifier:3" targetNodeId="5.~AnnotationInstance" resolveInfo="AnnotationInstance" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063438">
              <link role="classConcept:3" targetNodeId="5.~AnnotationInstance" resolveInfo="AnnotationInstance" />
              <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationInstance.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.AnnotationInstance" resolveInfo="newInstance" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063439">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063432" resolveInfo="model" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063440">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063441">
            <property name="name:3" value="c" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063442">
              <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063443">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063444">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063445">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063430" resolveInfo="annotation" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063446">
                  <link role="baseMethodDeclaration:3" targetNodeId="10.~ASMAnnotation.getType():jetbrains.mps.stubs.javastub.asm.ASMType" resolveInfo="getType" />
                </node>
              </node>
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063447">
                <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063448">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063449">
            <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064304" resolveInfo="addClassifierReference" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063450">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063451">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063436" resolveInfo="result" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063452">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
              </node>
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063453">
              <link role="classifier:3" targetNodeId="5.~AnnotationInstance" resolveInfo="AnnotationInstance" />
              <link role="variableDeclaration:3" targetNodeId="5.~AnnotationInstance.ANNOTATION" resolveInfo="ANNOTATION" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063454">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063441" resolveInfo="c" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063455">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063456">
            <property name="name:3" value="values" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063457">
              <link role="classifier:3" targetNodeId="4.~Map" resolveInfo="Map" />
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814063458" />
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063459">
                <link role="classifier:3" targetNodeId="11.~Object" resolveInfo="Object" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063460">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063461">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063430" resolveInfo="annotation" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063462">
                <link role="baseMethodDeclaration:3" targetNodeId="10.~ASMAnnotation.getValues():java.util.Map" resolveInfo="getValues" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063463">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063464">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063465">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063456" resolveInfo="values" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063466">
              <link role="baseMethodDeclaration:3" targetNodeId="4.~Map.keySet():java.util.Set" resolveInfo="keySet" />
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063467">
            <property name="name:3" value="key" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814063468" />
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063469">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063470">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063471">
                <property name="name:3" value="value" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063472">
                  <link role="classifier:3" targetNodeId="5.~AnnotationInstanceValue" resolveInfo="AnnotationInstanceValue" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063473">
                  <link role="classConcept:3" targetNodeId="5.~AnnotationInstanceValue" resolveInfo="AnnotationInstanceValue" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationInstanceValue.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.AnnotationInstanceValue" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063474">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063432" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063475">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063476">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064349" resolveInfo="addAnnotationMethodReference" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063477">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063478">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063471" resolveInfo="value" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063479">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063480">
                  <link role="classifier:3" targetNodeId="5.~AnnotationInstanceValue" resolveInfo="AnnotationInstanceValue" />
                  <link role="variableDeclaration:3" targetNodeId="5.~AnnotationInstanceValue.KEY" resolveInfo="KEY" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063481">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063441" resolveInfo="c" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063482">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063467" resolveInfo="key" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063483">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063484">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063485">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063471" resolveInfo="value" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063486">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationInstanceValue.setValue(jetbrains.mps.baseLanguage.structure.Expression):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063487">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063500" resolveInfo="getAnnotationValue" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063488">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063489">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063456" resolveInfo="values" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063490">
                        <link role="baseMethodDeclaration:3" targetNodeId="4.~Map.get(java.lang.Object):java.lang.Object" resolveInfo="get" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063491">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063467" resolveInfo="key" />
                        </node>
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063492">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063432" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063493">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063494">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063495">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063436" resolveInfo="result" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063496">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationInstance.addValue(jetbrains.mps.baseLanguage.structure.AnnotationInstanceValue):void" resolveInfo="addValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063497">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063471" resolveInfo="value" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063498">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063499">
            <link role="variableDeclaration:3" targetNodeId="2566197375814063436" resolveInfo="result" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063500">
      <property name="name:3" value="getAnnotationValue" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814063501" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063502">
        <link role="classifier:3" targetNodeId="5.~Expression" resolveInfo="Expression" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063503">
        <property name="name:3" value="value" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063504">
          <link role="classifier:3" targetNodeId="11.~Object" resolveInfo="Object" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063505">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063506">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063507">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063508">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063509">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063510">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063511">
              <link role="classifier:3" targetNodeId="11.~Byte" resolveInfo="Byte" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063512">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063513">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063514">
                <property name="name:3" value="b" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063515">
                  <link role="classifier:3" targetNodeId="11.~Byte" resolveInfo="Byte" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063516">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063517">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063518">
                    <link role="classifier:3" targetNodeId="11.~Byte" resolveInfo="Byte" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063519">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063520">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063521">
                  <link role="classifier:3" targetNodeId="5.~IntegerConstant" resolveInfo="IntegerConstant" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063522">
                  <link role="classConcept:3" targetNodeId="5.~IntegerConstant" resolveInfo="IntegerConstant" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerConstant.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.IntegerConstant" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063523">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063524">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063525">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063526">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063520" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063527">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerConstant.setValue(int):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063528">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063514" resolveInfo="b" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063529">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063530">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063520" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063531">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063532">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063533">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063534">
              <link role="classifier:3" targetNodeId="11.~Boolean" resolveInfo="Boolean" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063535">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063536">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063537">
                <property name="name:3" value="b" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063538">
                  <link role="classifier:3" targetNodeId="11.~Boolean" resolveInfo="Boolean" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063539">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063540">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063541">
                    <link role="classifier:3" targetNodeId="11.~Boolean" resolveInfo="Boolean" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063542">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063543">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063544">
                  <link role="classifier:3" targetNodeId="5.~BooleanConstant" resolveInfo="BooleanConstant" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063545">
                  <link role="classConcept:3" targetNodeId="5.~BooleanConstant" resolveInfo="BooleanConstant" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BooleanConstant.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.BooleanConstant" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063546">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063547">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063548">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063549">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063543" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063550">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~BooleanConstant.setValue(boolean):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063551">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063537" resolveInfo="b" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063552">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063553">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063543" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063554">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063555">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063556">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063557">
              <link role="classifier:3" targetNodeId="11.~Character" resolveInfo="Character" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063558">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063559">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063560" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063561">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063562">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063563">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063564">
              <link role="classifier:3" targetNodeId="11.~Short" resolveInfo="Short" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063565">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063566">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063567">
                <property name="name:3" value="s" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063568">
                  <link role="classifier:3" targetNodeId="11.~Short" resolveInfo="Short" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063569">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063570">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063571">
                    <link role="classifier:3" targetNodeId="11.~Short" resolveInfo="Short" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063572">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063573">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063574">
                  <link role="classifier:3" targetNodeId="5.~IntegerConstant" resolveInfo="IntegerConstant" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063575">
                  <link role="classConcept:3" targetNodeId="5.~IntegerConstant" resolveInfo="IntegerConstant" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerConstant.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.IntegerConstant" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063576">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063577">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063578">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063579">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063573" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063580">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerConstant.setValue(int):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063581">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063567" resolveInfo="s" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063582">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063583">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063573" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063584">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063585">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063586">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063587">
              <link role="classifier:3" targetNodeId="11.~Integer" resolveInfo="Integer" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063588">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063589">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063590">
                <property name="name:3" value="i" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063591">
                  <link role="classifier:3" targetNodeId="11.~Integer" resolveInfo="Integer" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063592">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063593">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063594">
                    <link role="classifier:3" targetNodeId="11.~Integer" resolveInfo="Integer" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063595">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063596">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063597">
                  <link role="classifier:3" targetNodeId="5.~IntegerConstant" resolveInfo="IntegerConstant" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063598">
                  <link role="classConcept:3" targetNodeId="5.~IntegerConstant" resolveInfo="IntegerConstant" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerConstant.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.IntegerConstant" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063599">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063600">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063601">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063602">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063596" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063603">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerConstant.setValue(int):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063604">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063590" resolveInfo="i" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063605">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063606">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063596" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063607">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063608">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063609">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063610">
              <link role="classifier:3" targetNodeId="11.~Long" resolveInfo="Long" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063611">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063612">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063613" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063614">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063615">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063616">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063617">
              <link role="classifier:3" targetNodeId="11.~Float" resolveInfo="Float" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063618">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063619">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063620">
                <property name="name:3" value="f" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063621">
                  <link role="classifier:3" targetNodeId="11.~Float" resolveInfo="Float" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063622">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063623">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063624">
                    <link role="classifier:3" targetNodeId="11.~Float" resolveInfo="Float" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063625">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063626">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063627">
                  <link role="classifier:3" targetNodeId="5.~FloatingPointConstant" resolveInfo="FloatingPointConstant" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063628">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FloatingPointConstant.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.FloatingPointConstant" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~FloatingPointConstant" resolveInfo="FloatingPointConstant" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063629">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063630">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063631">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063632">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063626" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063633">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FloatingPointConstant.setValue(java.lang.String):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814063634">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063635">
                      <property name="value:3" value="" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063636">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063620" resolveInfo="f" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063637">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063638">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063626" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063639">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063640">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063641">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063642">
              <link role="classifier:3" targetNodeId="11.~Double" resolveInfo="Double" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063643">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063644">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063645">
                <property name="name:3" value="d" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063646">
                  <link role="classifier:3" targetNodeId="11.~Double" resolveInfo="Double" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063647">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063648">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063649">
                    <link role="classifier:3" targetNodeId="11.~Double" resolveInfo="Double" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063650">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063651">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063652">
                  <link role="classifier:3" targetNodeId="5.~FloatingPointConstant" resolveInfo="FloatingPointConstant" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063653">
                  <link role="classConcept:3" targetNodeId="5.~FloatingPointConstant" resolveInfo="FloatingPointConstant" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FloatingPointConstant.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.FloatingPointConstant" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063654">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063655">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063656">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063657">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063651" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063658">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~FloatingPointConstant.setValue(java.lang.String):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814063659">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063660">
                      <property name="value:3" value="" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063661">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063645" resolveInfo="d" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063662">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063663">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063651" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063664">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063665">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063666">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814063667" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063668">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063669">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063670">
                <property name="name:3" value="s" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814063671" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063672">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063673">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814063674" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063675">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063676">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063677">
                  <link role="classifier:3" targetNodeId="5.~StringLiteral" resolveInfo="StringLiteral" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063678">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~StringLiteral.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.StringLiteral" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~StringLiteral" resolveInfo="StringLiteral" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063679">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063680">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063681">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063682">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063676" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063683">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~StringLiteral.setValue(java.lang.String):void" resolveInfo="setValue" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063684">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063670" resolveInfo="s" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063685">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063686">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063676" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063687">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063688">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063689">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063690">
              <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063691">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063692">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063693">
                <property name="name:3" value="list" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063694">
                  <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063695">
                    <link role="classifier:3" targetNodeId="11.~Object" resolveInfo="Object" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063696">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063697">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063698">
                    <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063699">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063700">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063701">
                  <link role="classifier:3" targetNodeId="5.~ArrayLiteral" resolveInfo="ArrayLiteral" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063702">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ArrayLiteral.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ArrayLiteral" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~ArrayLiteral" resolveInfo="ArrayLiteral" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063703">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814063704">
              <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063705">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063693" resolveInfo="list" />
              </node>
              <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063706">
                <property name="name:3" value="o" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063707">
                  <link role="classifier:3" targetNodeId="11.~Object" resolveInfo="Object" />
                </node>
              </node>
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063708">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063709">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063710">
                    <property name="name:3" value="annotationValue" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063711">
                      <link role="classifier:3" targetNodeId="5.~Expression" resolveInfo="Expression" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063712">
                      <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063500" resolveInfo="getAnnotationValue" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063713">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063706" resolveInfo="o" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063714">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063715">
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814063716">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063717">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063710" resolveInfo="annotationValue" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063718" />
                  </node>
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063719">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063720">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063721">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063722">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063700" resolveInfo="res" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063723">
                          <link role="baseMethodDeclaration:3" targetNodeId="5.~ArrayLiteral.addItem(jetbrains.mps.baseLanguage.structure.Expression):void" resolveInfo="addItem" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063724">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814063710" resolveInfo="annotationValue" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063725">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063726">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063700" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063727">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063728">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063729">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063730">
              <link role="classifier:3" targetNodeId="9.7241381882860008658" resolveInfo="ASMEnumValue" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063731">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063732">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063733">
                <property name="name:3" value="enumValue" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063734">
                  <link role="classifier:3" targetNodeId="9.7241381882860008658" resolveInfo="ASMEnumValue" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063735">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063736">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063737">
                    <link role="classifier:3" targetNodeId="9.7241381882860008658" resolveInfo="ASMEnumValue" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063738">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063739">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063740">
                  <link role="classifier:3" targetNodeId="5.~EnumConstantReference" resolveInfo="EnumConstantReference" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063741">
                  <link role="classConcept:3" targetNodeId="5.~EnumConstantReference" resolveInfo="EnumConstantReference" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~EnumConstantReference.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.EnumConstantReference" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063742">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063743">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063744">
                <property name="name:3" value="c" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063745">
                  <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063746">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063747">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063748">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063733" resolveInfo="enumValue" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063749">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008685" resolveInfo="getType" />
                    </node>
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063750">
                    <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063751">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063752">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064304" resolveInfo="addClassifierReference" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063753">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063754">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063739" resolveInfo="res" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063755">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063756">
                  <link role="classifier:3" targetNodeId="5.~EnumConstantReference" resolveInfo="EnumConstantReference" />
                  <link role="variableDeclaration:3" targetNodeId="5.~EnumConstantReference.ENUM_CLASS" resolveInfo="ENUM_CLASS" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063757">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063744" resolveInfo="c" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063758">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063759">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064396" resolveInfo="addEnumConstReference" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063760">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063761">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063739" resolveInfo="res" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063762">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063763">
                  <link role="classifier:3" targetNodeId="5.~EnumConstantReference" resolveInfo="EnumConstantReference" />
                  <link role="variableDeclaration:3" targetNodeId="5.~EnumConstantReference.ENUM_CONSTANT_DECLARATION" resolveInfo="ENUM_CONSTANT_DECLARATION" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063764">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063733" resolveInfo="enumValue" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063765">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063766">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063739" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063767">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063768">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063769">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063770">
              <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063771">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063772">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063773">
                <property name="name:3" value="annotation" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063774">
                  <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063775">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063776">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063777">
                    <link role="classifier:3" targetNodeId="10.~ASMAnnotation" resolveInfo="ASMAnnotation" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063778">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063779">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063780">
                  <link role="classifier:3" targetNodeId="5.~AnnotationInstanceExpression" resolveInfo="AnnotationInstanceExpression" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063781">
                  <link role="classConcept:3" targetNodeId="5.~AnnotationInstanceExpression" resolveInfo="AnnotationInstanceExpression" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationInstanceExpression.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.AnnotationInstanceExpression" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063782">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063783">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063784">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063785">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063779" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063786">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~AnnotationInstanceExpression.setAnnotationInstance(jetbrains.mps.baseLanguage.structure.AnnotationInstance):void" resolveInfo="setAnnotationInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063787">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063427" resolveInfo="createAnnotation" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063788">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063773" resolveInfo="annotation" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063789">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063790">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063791">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063779" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063792">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063793">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063794">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063795">
              <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063796">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063797">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063798">
                <property name="name:3" value="classType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063799">
                  <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063800">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063801">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063802">
                    <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063803">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063804">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063805">
                  <link role="classifier:3" targetNodeId="5.~ClassifierClassExpression" resolveInfo="ClassifierClassExpression" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063806">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassifierClassExpression.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ClassifierClassExpression" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~ClassifierClassExpression" resolveInfo="ClassifierClassExpression" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063807">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063808">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063809">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064304" resolveInfo="addClassifierReference" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063810">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063811">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063804" resolveInfo="res" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063812">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063813">
                  <link role="classifier:3" targetNodeId="5.~ClassifierClassExpression" resolveInfo="ClassifierClassExpression" />
                  <link role="variableDeclaration:3" targetNodeId="5.~ClassifierClassExpression.CLASSIFIER" resolveInfo="CLASSIFIER" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063814">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063798" resolveInfo="classType" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063815">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063816">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063804" resolveInfo="res" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063817">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063818">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063819">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063820">
                <property name="name:3" value="primitiveType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063821">
                  <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063822">
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063823">
                    <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
                  </node>
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063824">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063825">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063826">
                <property name="name:3" value="res" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063827">
                  <link role="classifier:3" targetNodeId="5.~PrimitiveClassExpression" resolveInfo="PrimitiveClassExpression" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063828">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~PrimitiveClassExpression.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.PrimitiveClassExpression" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~PrimitiveClassExpression" resolveInfo="PrimitiveClassExpression" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063829">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063830">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063831">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063832">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063826" resolveInfo="res" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063833">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~PrimitiveClassExpression.setPrimitiveType(jetbrains.mps.baseLanguage.structure.PrimitiveType):void" resolveInfo="setPrimitiveType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063834">
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063835">
                      <link role="classifier:3" targetNodeId="5.~PrimitiveType" resolveInfo="PrimitiveType" />
                    </node>
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063836">
                      <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063837">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063820" resolveInfo="primitiveType" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063838" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063839" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063840">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063505" resolveInfo="model" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063841">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063842">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063826" resolveInfo="res" />
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063843">
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063844">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063845">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063846">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063847">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="2566197375814082166">
              <link role="variableDeclaration:3" targetNodeId="2566197375814064481" resolveInfo="LOG" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063849">
              <link role="baseMethodDeclaration:3" targetNodeId="1.~Logger.error(java.lang.String):void" resolveInfo="error" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814063850">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814063851">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814063852">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063853">
                      <property name="value:3" value="couldn't create annotation value from " />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression:3" id="2566197375814063854">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.TernaryOperatorExpression:3" id="2566197375814063855">
                        <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063856">
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063857">
                            <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                          </node>
                          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063858" />
                        </node>
                        <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063859">
                          <property name="value:3" value="" />
                        </node>
                        <node role="ifFalse:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063860">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063861">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063862">
                              <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063863">
                              <link role="baseMethodDeclaration:3" targetNodeId="11.~Object.getClass():java.lang.Class" resolveInfo="getClass" />
                            </node>
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063864">
                            <link role="baseMethodDeclaration:3" targetNodeId="11.~Class.getName():java.lang.String" resolveInfo="getName" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814063865">
                    <property name="value:3" value=" : " />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063866">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063503" resolveInfo="value" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063867">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814063868" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814063869">
      <property name="name:3" value="getTypeByASMType" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814063870" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063871">
        <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063872">
        <property name="name:3" value="type" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063873">
          <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063874">
        <property name="name:3" value="method" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063875">
          <link role="classifier:3" targetNodeId="5.~BaseMethodDeclaration" resolveInfo="BaseMethodDeclaration" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063876">
        <property name="name:3" value="classifier" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063877">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814063878">
        <property name="name:3" value="model" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063879">
          <link role="classifier:3" targetNodeId="3.~SModel" resolveInfo="SModel" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063880">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063881">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063882">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063883">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063884">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006715" resolveInfo="BOOLEAN" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063885">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063886">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063887">
                <link role="baseMethodDeclaration:3" targetNodeId="5.~BooleanType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.BooleanType" resolveInfo="newInstance" />
                <link role="classConcept:3" targetNodeId="5.~BooleanType" resolveInfo="BooleanType" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063888">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063889">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063890">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063891">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063892">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006727" resolveInfo="BYTE" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063893">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063894">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063895">
                <link role="classConcept:3" targetNodeId="5.~ByteType" resolveInfo="ByteType" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~ByteType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ByteType" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063896">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063897">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063898">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063899">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063900">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006733" resolveInfo="SHORT" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063901">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063902">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063903">
                <link role="baseMethodDeclaration:3" targetNodeId="5.~ShortType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ShortType" resolveInfo="newInstance" />
                <link role="classConcept:3" targetNodeId="5.~ShortType" resolveInfo="ShortType" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063904">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063905">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063906">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063907">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063908">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006739" resolveInfo="INT" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063909">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063910">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063911">
                <link role="classConcept:3" targetNodeId="5.~IntegerType" resolveInfo="IntegerType" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~IntegerType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.IntegerType" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063912">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063913">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063914">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063915">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063916">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006751" resolveInfo="LONG" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063917">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063918">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063919">
                <link role="classConcept:3" targetNodeId="5.~LongType" resolveInfo="LongType" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~LongType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.LongType" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063920">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063921">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063922">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063923">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063924">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006745" resolveInfo="FLOAT" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063925">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063926">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063927">
                <link role="classConcept:3" targetNodeId="5.~FloatType" resolveInfo="FloatType" />
                <link role="baseMethodDeclaration:3" targetNodeId="5.~FloatType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.FloatType" resolveInfo="newInstance" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063928">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063929">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063930">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063931">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063932">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006757" resolveInfo="DOUBLE" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063933">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063934">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063935">
                <link role="baseMethodDeclaration:3" targetNodeId="5.~DoubleType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.DoubleType" resolveInfo="newInstance" />
                <link role="classConcept:3" targetNodeId="5.~DoubleType" resolveInfo="DoubleType" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063936">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063937">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063938">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063939">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063940">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006709" resolveInfo="VOID" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063941">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063942">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063943">
                <link role="baseMethodDeclaration:3" targetNodeId="5.~VoidType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.VoidType" resolveInfo="newInstance" />
                <link role="classConcept:3" targetNodeId="5.~VoidType" resolveInfo="VoidType" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063944">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063945">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814063946">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063947">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814063948">
              <link role="classifier:3" targetNodeId="9.7241381882860006706" resolveInfo="ASMPrimitiveType" />
              <link role="variableDeclaration:3" targetNodeId="9.7241381882860006721" resolveInfo="CHAR" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063949">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063950">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063951">
                <link role="baseMethodDeclaration:3" targetNodeId="5.~CharType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.CharType" resolveInfo="newInstance" />
                <link role="classConcept:3" targetNodeId="5.~CharType" resolveInfo="CharType" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063952">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063953">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063954">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063955">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063956">
              <link role="classifier:3" targetNodeId="9.7241381882860002146" resolveInfo="ASMArrayType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063957">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063958">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063959">
                <property name="name:3" value="array" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063960">
                  <link role="classifier:3" targetNodeId="9.7241381882860002146" resolveInfo="ASMArrayType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063961">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063962">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063963">
                    <link role="classifier:3" targetNodeId="9.7241381882860002146" resolveInfo="ASMArrayType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063964">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063965">
                <property name="name:3" value="componentType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063966">
                  <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814063967">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063968">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063969">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063959" resolveInfo="array" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063970">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002162" resolveInfo="getElementType" />
                    </node>
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063971">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063972">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063973">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063974">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063975">
                <property name="name:3" value="result" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063976">
                  <link role="classifier:3" targetNodeId="5.~ArrayType" resolveInfo="ArrayType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814063977">
                  <link role="classConcept:3" targetNodeId="5.~ArrayType" resolveInfo="ArrayType" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ArrayType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ArrayType" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063978">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814063979">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814063980">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063981">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063975" resolveInfo="result" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814063982">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ArrayType.setComponentType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setComponentType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063983">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063965" resolveInfo="componentType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814063984">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814063985">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063975" resolveInfo="result" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814063986">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814063987">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063988">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063989">
              <link role="classifier:3" targetNodeId="9.7241381882860007172" resolveInfo="ASMVarArgType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814063990">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063991">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063992">
                <property name="name:3" value="varArgType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063993">
                  <link role="classifier:3" targetNodeId="9.7241381882860007172" resolveInfo="ASMVarArgType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814063994">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814063995">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063996">
                    <link role="classifier:3" targetNodeId="9.7241381882860007172" resolveInfo="ASMVarArgType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814063997">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814063998">
                <property name="name:3" value="componentType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814063999">
                  <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064000">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064001">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064002">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063992" resolveInfo="varArgType" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064003">
                      <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860007188" resolveInfo="getElementType" />
                    </node>
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064004">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064005">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064006">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064007">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064008">
                <property name="name:3" value="result" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064009">
                  <link role="classifier:3" targetNodeId="5.~VariableArityType" resolveInfo="VariableArityType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064010">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~VariableArityType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.VariableArityType" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~VariableArityType" resolveInfo="VariableArityType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064011">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064012">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064013">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064014">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064008" resolveInfo="result" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064015">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~VariableArityType.setComponentType(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setComponentType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064016">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063998" resolveInfo="componentType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064017">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064018">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064008" resolveInfo="result" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064019">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064020">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064021">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064022">
              <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064023">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064024">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064025">
                <property name="name:3" value="tv" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064026">
                  <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064027">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064028">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064029">
                    <link role="classifier:3" targetNodeId="9.7241381882860008701" resolveInfo="ASMTypeVariable" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064030">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="2566197375814064031">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814064032">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064033">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064034" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814064035">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064036">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061858" resolveInfo="findTypeVariableDeclaration" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064037">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064038">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064039">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064025" resolveInfo="tv" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064040">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                      </node>
                    </node>
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064041" />
                </node>
              </node>
              <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064042">
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814064043">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064044">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061858" resolveInfo="findTypeVariableDeclaration" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064045">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064046">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064047">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064025" resolveInfo="tv" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064048">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                      </node>
                    </node>
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064049" />
                </node>
                <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="2566197375814064050">
                  <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064051">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064052">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064053">
                        <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814064054">
                          <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                          <link role="variableDeclaration:3" targetNodeId="9.7241381882860002173" resolveInfo="OBJECT" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064055">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064056">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064057">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064058">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064059">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064060">
                      <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061886" resolveInfo="createTypeVariableReference" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064061">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064062">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064063">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814064025" resolveInfo="tv" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064064">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064065">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064066">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064067">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814061886" resolveInfo="createTypeVariableReference" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064068">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064069">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064070">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064025" resolveInfo="tv" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064071">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008718" resolveInfo="getName" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064072">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064073">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064074">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064075">
              <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064076">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064077">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064078">
                <property name="name:3" value="c" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064079">
                  <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064080">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064081">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064082">
                    <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064083">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064084">
                <property name="name:3" value="classifierType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064085">
                  <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064086">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassifierType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.ClassifierType" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064087">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064088">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064089">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064304" resolveInfo="addClassifierReference" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064090">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064091">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064084" resolveInfo="classifierType" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064092">
                    <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getNode():jetbrains.mps.smodel.SNode" resolveInfo="getNode" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="2566197375814064093">
                  <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                  <link role="variableDeclaration:3" targetNodeId="5.~ClassifierType.CLASSIFIER" resolveInfo="CLASSIFIER" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064094">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064078" resolveInfo="c" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064095">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064096">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064084" resolveInfo="classifierType" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064097">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064098">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064099">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064100">
              <link role="classifier:3" targetNodeId="9.7241381882860009267" resolveInfo="ASMParameterizedType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064101">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064102">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064103">
                <property name="name:3" value="pt" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064104">
                  <link role="classifier:3" targetNodeId="9.7241381882860009267" resolveInfo="ASMParameterizedType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064105">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064106">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064107">
                    <link role="classifier:3" targetNodeId="9.7241381882860009267" resolveInfo="ASMParameterizedType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064108">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064109">
                <property name="name:3" value="rawType" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064110">
                  <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064111">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064112">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064113">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064114">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064103" resolveInfo="pt" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064115">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009306" resolveInfo="getRawType" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064116">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064117">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064118">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                    </node>
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064119">
                    <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064120">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064121">
                <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064243" resolveInfo="addTypeParameters" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064122">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064123">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064103" resolveInfo="pt" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064124">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860009338" resolveInfo="getActualTypeArguments" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064125">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064126">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064127">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064109" resolveInfo="rawType" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064128">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064129">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064109" resolveInfo="rawType" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064130">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064131">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064132">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064133">
              <link role="classifier:3" targetNodeId="9.7241381882860008819" resolveInfo="ASMExtendsType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064134">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064135">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064136">
                <property name="name:3" value="e" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064137">
                  <link role="classifier:3" targetNodeId="9.7241381882860008819" resolveInfo="ASMExtendsType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064138">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064139">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064140">
                    <link role="classifier:3" targetNodeId="9.7241381882860008819" resolveInfo="ASMExtendsType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064141">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064142">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064143">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064144">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064136" resolveInfo="e" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064145">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008836" resolveInfo="getBase" />
                  </node>
                </node>
                <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064146">
                  <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064147">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064148">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064149">
                    <property name="name:3" value="ct" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064150">
                      <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064151">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064152">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064153">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814064136" resolveInfo="e" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064154">
                          <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008836" resolveInfo="getBase" />
                        </node>
                      </node>
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064155">
                        <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064156">
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064157">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064158">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064159">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064149" resolveInfo="ct" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064160">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064161">
                      <link role="baseMethodDeclaration:3" targetNodeId="11.~String.equals(java.lang.Object):boolean" resolveInfo="equals" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814064162">
                        <property name="value:3" value="java.lang.Object" />
                      </node>
                    </node>
                  </node>
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064163">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064164">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064165">
                        <link role="baseMethodDeclaration:3" targetNodeId="5.~WildCardType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.WildCardType" resolveInfo="newInstance" />
                        <link role="classConcept:3" targetNodeId="5.~WildCardType" resolveInfo="WildCardType" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064166">
                          <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064167">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064168">
                <property name="name:3" value="r" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064169">
                  <link role="classifier:3" targetNodeId="5.~UpperBoundType" resolveInfo="UpperBoundType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064170">
                  <link role="classConcept:3" targetNodeId="5.~UpperBoundType" resolveInfo="UpperBoundType" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~UpperBoundType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.UpperBoundType" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064171">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064172">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064173">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064174">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064168" resolveInfo="r" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064175">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~UpperBoundType.setBound(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setBound" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064176">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064177">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064178">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064136" resolveInfo="e" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064179">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008836" resolveInfo="getBase" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064180">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064181">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064182">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064183">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064184">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064168" resolveInfo="r" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064185">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064186">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064187">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064188">
              <link role="classifier:3" targetNodeId="9.7241381882860008734" resolveInfo="ASMSuperType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064189">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064190">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064191">
                <property name="name:3" value="e" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064192">
                  <link role="classifier:3" targetNodeId="9.7241381882860008734" resolveInfo="ASMSuperType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064193">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064194">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064195">
                    <link role="classifier:3" targetNodeId="9.7241381882860008734" resolveInfo="ASMSuperType" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064196">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064197">
                <property name="name:3" value="r" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064198">
                  <link role="classifier:3" targetNodeId="5.~LowerBoundType" resolveInfo="LowerBoundType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064199">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~LowerBoundType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.LowerBoundType" resolveInfo="newInstance" />
                  <link role="classConcept:3" targetNodeId="5.~LowerBoundType" resolveInfo="LowerBoundType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064200">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064201">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064202">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064203">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064197" resolveInfo="r" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064204">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~LowerBoundType.setBound(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="setBound" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064205">
                    <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064206">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064207">
                        <link role="variableDeclaration:3" targetNodeId="2566197375814064191" resolveInfo="e" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064208">
                        <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008751" resolveInfo="getBase" />
                      </node>
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064209">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063874" resolveInfo="method" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064210">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063876" resolveInfo="classifier" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064211">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064212">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064213">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064197" resolveInfo="r" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064214">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="2566197375814064215">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064216">
              <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
            </node>
            <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064217">
              <link role="classifier:3" targetNodeId="9.7241381882860007300" resolveInfo="ASMUnboundedType" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064218">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064219">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064220">
                <property name="name:3" value="w" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064221">
                  <link role="classifier:3" targetNodeId="5.~WildCardType" resolveInfo="WildCardType" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064222">
                  <link role="classConcept:3" targetNodeId="5.~WildCardType" resolveInfo="WildCardType" />
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~WildCardType.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.WildCardType" resolveInfo="newInstance" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064223">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064224">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064225">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064220" resolveInfo="w" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064226">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064227">
            <property name="name:3" value="result" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064228">
              <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064229">
              <link role="baseMethodDeclaration:3" targetNodeId="5.~Type.newInstance(jetbrains.mps.smodel.SModel):jetbrains.mps.baseLanguage.structure.Type" resolveInfo="newInstance" />
              <link role="classConcept:3" targetNodeId="5.~Type" resolveInfo="Type" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064230">
                <link role="variableDeclaration:3" targetNodeId="2566197375814063878" resolveInfo="model" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064231">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064232">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="2566197375814082172">
              <link role="variableDeclaration:3" targetNodeId="2566197375814064481" resolveInfo="LOG" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064234">
              <link role="baseMethodDeclaration:3" targetNodeId="1.~Logger.error(java.lang.String,java.lang.Object):void" resolveInfo="error" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814064235">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="2566197375814064236">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814064237">
                    <property name="value:3" value="Can't convert type " />
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064238">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814063872" resolveInfo="type" />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="2566197375814064239">
                  <property name="value:3" value=" class : " />
                </node>
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064240">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064227" resolveInfo="result" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064241">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064242">
            <link role="variableDeclaration:3" targetNodeId="2566197375814064227" resolveInfo="result" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814064243">
      <property name="name:3" value="addTypeParameters" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814064244" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814064245" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064246">
        <property name="name:3" value="typeParameters" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064247">
          <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
          <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.UpperBoundType:3" id="2566197375814064248">
            <node role="bound:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064249">
              <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064250">
        <property name="name:3" value="method" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064251">
          <link role="classifier:3" targetNodeId="5.~BaseMethodDeclaration" resolveInfo="BaseMethodDeclaration" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064252">
        <property name="name:3" value="classifier" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064253">
          <link role="classifier:3" targetNodeId="5.~Classifier" resolveInfo="Classifier" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064254">
        <property name="name:3" value="result" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064255">
          <link role="classifier:3" targetNodeId="5.~ClassifierType" resolveInfo="ClassifierType" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064256">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064257">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064258">
            <property name="name:3" value="toAdd" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064259">
              <link role="classifier:3" targetNodeId="4.~List" resolveInfo="List" />
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064260">
                <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="2566197375814064261">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="2566197375814064262">
                <link role="baseMethodDeclaration:3" targetNodeId="4.~ArrayList.&lt;init&gt;()" resolveInfo="ArrayList" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064263">
                  <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814064264">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064265">
            <link role="variableDeclaration:3" targetNodeId="2566197375814064246" resolveInfo="typeParameters" />
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064266">
            <property name="name:3" value="tv" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064267">
              <link role="classifier:3" targetNodeId="9.7241381882860008653" resolveInfo="ASMType" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064268">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064269">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064270">
                <property name="name:3" value="type" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064271">
                  <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064272">
                  <link role="baseMethodDeclaration:3" targetNodeId="2566197375814063869" resolveInfo="getTypeByASMType" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064273">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064266" resolveInfo="tv" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064274">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064250" resolveInfo="method" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064275">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064252" resolveInfo="classifier" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064276">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064277">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814064254" resolveInfo="result" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064278">
                      <link role="baseMethodDeclaration:3" targetNodeId="3.~BaseAdapter.getModel():jetbrains.mps.smodel.SModel" resolveInfo="getModel" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064279">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="2566197375814064280">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064281">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064270" resolveInfo="type" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064282" />
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064283">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064284">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064285">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064286">
                      <link role="variableDeclaration:3" targetNodeId="2566197375814064258" resolveInfo="toAdd" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064287">
                      <link role="baseMethodDeclaration:3" targetNodeId="4.~List.clear():void" resolveInfo="clear" />
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.BreakStatement:3" id="2566197375814064288" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064289">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064290">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064291">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064258" resolveInfo="toAdd" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064292">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~List.add(java.lang.Object):boolean" resolveInfo="add" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064293">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064270" resolveInfo="type" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForeachStatement:3" id="2566197375814064294">
          <node role="iterable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064295">
            <link role="variableDeclaration:3" targetNodeId="2566197375814064258" resolveInfo="toAdd" />
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064296">
            <property name="name:3" value="tvr" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064297">
              <link role="classifier:3" targetNodeId="5.~Type" resolveInfo="Type" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064298">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064299">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064300">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064301">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064254" resolveInfo="result" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064302">
                  <link role="baseMethodDeclaration:3" targetNodeId="5.~ClassifierType.addParameter(jetbrains.mps.baseLanguage.structure.Type):void" resolveInfo="addParameter" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064303">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064296" resolveInfo="tvr" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814064304">
      <property name="name:3" value="addClassifierReference" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814064305" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814064306" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064307">
        <property name="name:3" value="sourceNode" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064308">
          <link role="classifier:3" targetNodeId="3.~SNode" resolveInfo="SNode" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064309">
        <property name="name:3" value="role" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814064310" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064311">
        <property name="name:3" value="clsType" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064312">
          <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064313">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064314">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814064315">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064316">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064317">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064307" resolveInfo="sourceNode" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064318">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.getReferent(java.lang.String):jetbrains.mps.smodel.SNode" resolveInfo="getReferent" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064319">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064309" resolveInfo="role" />
                </node>
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064320" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064321">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064322" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="2566197375814064323" />
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064324">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064325">
            <property name="name:3" value="targetModelRef" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064326">
              <link role="classifier:3" targetNodeId="3.~SModelReference" resolveInfo="SModelReference" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064327">
              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064451" resolveInfo="getModelReferenceFor" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064328">
                <link role="classConcept:3" targetNodeId="6.~NodeNameUtil" resolveInfo="NodeNameUtil" />
                <link role="baseMethodDeclaration:3" targetNodeId="6.~NodeNameUtil.getNamespace(java.lang.String):java.lang.String" resolveInfo="getNamespace" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064329">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064330">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064311" resolveInfo="clsType" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064331">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064332">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064333">
            <property name="name:3" value="nodeId" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064334">
              <link role="classifier:3" targetNodeId="3.~SNodeId" resolveInfo="SNodeId" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064335">
              <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008243" resolveInfo="createId" />
              <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064336">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064337">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064311" resolveInfo="clsType" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064338">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="2566197375814064339" />
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064340">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064341">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064342">
              <link role="variableDeclaration:3" targetNodeId="2566197375814064307" resolveInfo="sourceNode" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064343">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.addReference(jetbrains.mps.smodel.SReference):void" resolveInfo="addReference" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064344">
                <link role="classConcept:3" targetNodeId="3.~SReference" resolveInfo="SReference" />
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SReference.create(java.lang.String,jetbrains.mps.smodel.SNode,jetbrains.mps.smodel.SModelReference,jetbrains.mps.smodel.SNodeId):jetbrains.mps.smodel.SReference" resolveInfo="create" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064345">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064309" resolveInfo="role" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064346">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064307" resolveInfo="sourceNode" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064347">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064325" resolveInfo="targetModelRef" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064348">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064333" resolveInfo="nodeId" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814064349">
      <property name="name:3" value="addAnnotationMethodReference" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814064350" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814064351" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064352">
        <property name="name:3" value="sourceNode" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064353">
          <link role="classifier:3" targetNodeId="3.~SNode" resolveInfo="SNode" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064354">
        <property name="name:3" value="role" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814064355" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064356">
        <property name="name:3" value="annotationType" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064357">
          <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064358">
        <property name="name:3" value="method" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814064359" />
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064360">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064361">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814064362">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064363">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064364">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064352" resolveInfo="sourceNode" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064365">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.getReferent(java.lang.String):jetbrains.mps.smodel.SNode" resolveInfo="getReferent" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064366">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064354" resolveInfo="role" />
                </node>
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064367" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064368">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064369" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="2566197375814064370" />
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064371">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064372">
            <property name="name:3" value="targetRef" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064373">
              <link role="classifier:3" targetNodeId="3.~SModelReference" resolveInfo="SModelReference" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064374">
              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064451" resolveInfo="getModelReferenceFor" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064375">
                <link role="baseMethodDeclaration:3" targetNodeId="6.~NodeNameUtil.getNamespace(java.lang.String):java.lang.String" resolveInfo="getNamespace" />
                <link role="classConcept:3" targetNodeId="6.~NodeNameUtil" resolveInfo="NodeNameUtil" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064376">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064377">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064356" resolveInfo="annotationType" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064378">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064379">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064380">
            <property name="name:3" value="nodeId" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064381">
              <link role="classifier:3" targetNodeId="3.~SNodeId" resolveInfo="SNodeId" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064382">
              <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008386" resolveInfo="createAnnotationMethodId" />
              <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064383">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064384">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064356" resolveInfo="annotationType" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064385">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                </node>
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064386">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064358" resolveInfo="method" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064387">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064388">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064389">
              <link role="variableDeclaration:3" targetNodeId="2566197375814064352" resolveInfo="sourceNode" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064390">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.addReference(jetbrains.mps.smodel.SReference):void" resolveInfo="addReference" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064391">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SReference.create(java.lang.String,jetbrains.mps.smodel.SNode,jetbrains.mps.smodel.SModelReference,jetbrains.mps.smodel.SNodeId):jetbrains.mps.smodel.SReference" resolveInfo="create" />
                <link role="classConcept:3" targetNodeId="3.~SReference" resolveInfo="SReference" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064392">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064354" resolveInfo="role" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064393">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064352" resolveInfo="sourceNode" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064394">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064372" resolveInfo="targetRef" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064395">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064380" resolveInfo="nodeId" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814064396">
      <property name="name:3" value="addEnumConstReference" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="2566197375814064397" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814064398" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064399">
        <property name="name:3" value="sourceNode" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064400">
          <link role="classifier:3" targetNodeId="3.~SNode" resolveInfo="SNode" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064401">
        <property name="name:3" value="role" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814064402" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064403">
        <property name="name:3" value="enumValue" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064404">
          <link role="classifier:3" targetNodeId="9.7241381882860008658" resolveInfo="ASMEnumValue" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064405">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="2566197375814064406">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="2566197375814064407">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064408">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064409">
                <link role="variableDeclaration:3" targetNodeId="2566197375814064399" resolveInfo="sourceNode" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064410">
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.getReferent(java.lang.String):jetbrains.mps.smodel.SNode" resolveInfo="getReferent" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064411">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064401" resolveInfo="role" />
                </node>
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2566197375814064412" />
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064413">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="2566197375814064414" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="2566197375814064415" />
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064416">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064417">
            <property name="name:3" value="classType" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064418">
              <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.CastExpression:3" id="2566197375814064419">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064420">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064421">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064403" resolveInfo="enumValue" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064422">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008685" resolveInfo="getType" />
                </node>
              </node>
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064423">
                <link role="classifier:3" targetNodeId="9.7241381882860002170" resolveInfo="ASMClassType" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064424">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064425">
            <property name="name:3" value="targetRef" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064426">
              <link role="classifier:3" targetNodeId="3.~SModelReference" resolveInfo="SModelReference" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="2566197375814064427">
              <link role="baseMethodDeclaration:3" targetNodeId="2566197375814064451" resolveInfo="getModelReferenceFor" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064428">
                <link role="classConcept:3" targetNodeId="6.~NodeNameUtil" resolveInfo="NodeNameUtil" />
                <link role="baseMethodDeclaration:3" targetNodeId="6.~NodeNameUtil.getNamespace(java.lang.String):java.lang.String" resolveInfo="getNamespace" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064429">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064430">
                    <link role="variableDeclaration:3" targetNodeId="2566197375814064417" resolveInfo="classType" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064431">
                    <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="2566197375814064432">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="2566197375814064433">
            <property name="name:3" value="nodeId" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064434">
              <link role="classifier:3" targetNodeId="3.~SNodeId" resolveInfo="SNodeId" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064435">
              <link role="baseMethodDeclaration:3" targetNodeId="7241381882860008279" resolveInfo="createFieldId" />
              <link role="classConcept:3" targetNodeId="7241381882860008238" resolveInfo="ASMNodeId" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064436">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064437">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064417" resolveInfo="classType" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064438">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860002193" resolveInfo="getName" />
                </node>
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064439">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064440">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064403" resolveInfo="enumValue" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064441">
                  <link role="baseMethodDeclaration:3" targetNodeId="9.7241381882860008693" resolveInfo="getConstant" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064442">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="2566197375814064443">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064444">
              <link role="variableDeclaration:3" targetNodeId="2566197375814064399" resolveInfo="sourceNode" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="2566197375814064445">
              <link role="baseMethodDeclaration:3" targetNodeId="3.~SNode.addReference(jetbrains.mps.smodel.SReference):void" resolveInfo="addReference" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064446">
                <link role="classConcept:3" targetNodeId="3.~SReference" resolveInfo="SReference" />
                <link role="baseMethodDeclaration:3" targetNodeId="3.~SReference.create(java.lang.String,jetbrains.mps.smodel.SNode,jetbrains.mps.smodel.SModelReference,jetbrains.mps.smodel.SNodeId):jetbrains.mps.smodel.SReference" resolveInfo="create" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064447">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064401" resolveInfo="role" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064448">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064399" resolveInfo="sourceNode" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064449">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064425" resolveInfo="targetRef" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="2566197375814064450">
                  <link role="variableDeclaration:3" targetNodeId="2566197375814064433" resolveInfo="nodeId" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="2566197375814064451">
      <property name="name:3" value="getModelReferenceFor" />
      <property name="isAbstract:3" value="false" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2566197375814064452">
        <link role="classifier:3" targetNodeId="3.~SModelReference" resolveInfo="SModelReference" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="2566197375814064453" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814064454">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="2566197375814064455">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="2566197375814064456">
            <link role="classConcept:3" targetNodeId="13.~StubHelper" resolveInfo="StubHelper" />
            <link role="baseMethodDeclaration:3" targetNodeId="13.~StubHelper.uidForPackageInStubs(java.lang.String):jetbrains.mps.smodel.SModelReference" resolveInfo="uidForPackageInStubs" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2566197375814064457">
              <link role="variableDeclaration:3" targetNodeId="2566197375814064458" resolveInfo="packageName" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2566197375814064458">
        <property name="name:3" value="packageName" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="2566197375814064459" />
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="2566197375814061437" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="2566197375814061438">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="2566197375814061439" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="2566197375814061440" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="2566197375814061441" />
    </node>
  </node>
</model>

