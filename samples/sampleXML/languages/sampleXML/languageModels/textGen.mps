<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:f6ac4dc8-7952-47a8-af10-2331849a8476(jetbrains.mps.sampleXML.textGen)">
  <persistence version="3" />
  <refactoringHistory />
  <language namespace="b83431fe-5c8f-40bc-8a36-65e25f4dd253(jetbrains.mps.lang.textGen)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:de0d3c0c-d049-41cf-bbf9-a920ba513cd3(jetbrains.mps.lang.textGen.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <devkit namespace="2677cb18-f558-4e33-bc38-a5139cee06dc(jetbrains.mps.devkit.language-design)" />
  <maxImportIndex value="5" />
  <import index="1" modelUID="r:ec0ffc91-3a14-4002-ac57-dd36c5dcf10a(jetbrains.mps.sampleXML.structure)" version="-1" />
  <import index="2" modelUID="f:java_stub#org.jdom(org.jdom@java_stub)" version="-1" />
  <import index="3" modelUID="f:java_stub#org.jdom.output(org.jdom.output@java_stub)" version="-1" />
  <import index="4" modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <import index="5" modelUID="f:java_stub#jetbrains.mps.logging(jetbrains.mps.logging@java_stub)" version="-1" />
  <node type="jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration" id="1236699935298">
    <link role="conceptDeclaration" targetNodeId="1.1225239603382" resolveInfo="Document" />
    <node role="textGenBlock" type="jetbrains.mps.lang.textGen.structure.GenerateTextDeclaration" id="1236699935299">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236699935300">
        <node role="statement" type="jetbrains.mps.lang.textGen.structure.OperationCall" id="1236701194917">
          <link role="function" targetNodeId="1236700487434" resolveInfo="appendByElement" />
          <node role="parameter" type="jetbrains.mps.lang.textGen.structure.NodeParameter" id="1236701196981" />
        </node>
      </node>
    </node>
  </node>
  <visible index="2" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" />
  <node type="jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration" id="1236700479964">
    <property name="name" value="ElementCreator" />
    <node role="function" type="jetbrains.mps.lang.textGen.structure.PrivateMethodDeclaration" id="1236700609238">
      <property name="name" value="createElement" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236700614898">
        <link role="classifier" targetNodeId="2.~Element" resolveInfo="Element" />
      </node>
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700609240">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700642827">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700642828">
            <property name="name" value="result" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236700642829">
              <link role="classifier" targetNodeId="2.~Element" resolveInfo="Element" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1236700642830">
              <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1236700642831">
                <link role="baseMethodDeclaration" targetNodeId="2.~Element.&lt;init&gt;(java.lang.String)" resolveInfo="Element" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642832">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1236700665619">
                    <link role="variableDeclaration" targetNodeId="1236700623868" resolveInfo="element" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1236700642834">
                    <link role="property" targetNodeId="2v.1169194664001" resolveInfo="name" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1236700642835">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700642836">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1236700642837">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700642838">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700642839">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642840">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642841">
                      <link role="variableDeclaration" targetNodeId="1236700642828" resolveInfo="result" />
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236700642842">
                      <link role="baseMethodDeclaration" targetNodeId="2.~Element.setAttribute(java.lang.String,java.lang.String):org.jdom.Element" resolveInfo="setAttribute" />
                      <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642843">
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642844">
                          <link role="variableDeclaration" targetNodeId="1236700642857" resolveInfo="attribute" />
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1236700642845">
                          <link role="property" targetNodeId="2v.1169194664001" resolveInfo="name" />
                        </node>
                      </node>
                      <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642846">
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642847">
                          <link role="variableDeclaration" targetNodeId="1236700642857" resolveInfo="attribute" />
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1236700642848">
                          <link role="property" targetNodeId="1.1225239603363" resolveInfo="value" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="1236700642849">
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="1236700642850" />
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642851">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642852">
                    <link role="variableDeclaration" targetNodeId="1236700642857" resolveInfo="attribute" />
                  </node>
                  <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1236700642853">
                    <link role="property" targetNodeId="1.1225239603363" resolveInfo="value" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642854">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1236700667980">
              <link role="variableDeclaration" targetNodeId="1236700623868" resolveInfo="element" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1236700642856">
              <link role="link" targetNodeId="1.1225239603386" />
            </node>
          </node>
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700642857">
            <property name="name" value="attribute" />
            <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1236700642858">
              <link role="concept" targetNodeId="1.1225239603361" resolveInfo="Attribute" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700642859">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700642860">
            <property name="name" value="first" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.BooleanType" id="1236700642861" />
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1236700642862">
              <property name="value" value="true" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1236700642863">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700642864">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1236700642865">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700642866">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1236700642867">
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700642868">
                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700642869">
                      <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642870">
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642871">
                          <link role="variableDeclaration" targetNodeId="1236700642828" resolveInfo="result" />
                        </node>
                        <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236700642872">
                          <link role="baseMethodDeclaration" targetNodeId="2.~Element.addContent(java.lang.String):org.jdom.Element" resolveInfo="addContent" />
                          <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1236700642873">
                            <property name="value" value="\n" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1236700642874">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642875">
                      <link role="variableDeclaration" targetNodeId="1236700642860" resolveInfo="first" />
                    </node>
                  </node>
                </node>
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700642876">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642877">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642878">
                      <link role="variableDeclaration" targetNodeId="1236700642828" resolveInfo="result" />
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236700642879">
                      <link role="baseMethodDeclaration" targetNodeId="2.~Element.addContent(java.lang.String):org.jdom.Element" resolveInfo="addContent" />
                      <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642880">
                        <node role="operand" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression" id="1236700642881">
                          <link role="concept" targetNodeId="1.1225239603393" resolveInfo="Text" />
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642882">
                            <link role="variableDeclaration" targetNodeId="1236700642901" resolveInfo="part" />
                          </node>
                        </node>
                        <node role="operation" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess" id="1236700642883">
                          <link role="property" targetNodeId="1.1225239603394" resolveInfo="text" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642884">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642885">
                  <link role="variableDeclaration" targetNodeId="1236700642901" resolveInfo="part" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1236700642886">
                  <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1236700642887">
                    <link role="conceptDeclaration" targetNodeId="1.1225239603393" resolveInfo="Text" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1236700642888">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700642889">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700642890">
                  <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642891">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642892">
                      <link role="variableDeclaration" targetNodeId="1236700642828" resolveInfo="result" />
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236700642893">
                      <link role="baseMethodDeclaration" targetNodeId="2.~Element.addContent(org.jdom.Content):org.jdom.Element" resolveInfo="addContent" />
                      <node role="actualArgument" type="jetbrains.mps.lang.textGen.structure.PrivateMethodCall" id="1236700702804">
                        <link role="function" targetNodeId="1236700609238" resolveInfo="createElement" />
                        <node role="parameter" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression" id="1236700758357">
                          <link role="concept" targetNodeId="1.1225239603385" resolveInfo="Element" />
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700748120">
                            <link role="variableDeclaration" targetNodeId="1236700642901" resolveInfo="part" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642894">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700642895">
                  <link role="variableDeclaration" targetNodeId="1236700642901" resolveInfo="part" />
                </node>
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.Node_IsInstanceOfOperation" id="1236700642896">
                  <node role="conceptArgument" type="jetbrains.mps.lang.smodel.structure.RefConcept_Reference" id="1236700642897">
                    <link role="conceptDeclaration" targetNodeId="1.1225239603385" resolveInfo="Element" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700764875">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression" id="1236700766487">
                <node role="rValue" type="jetbrains.mps.baseLanguage.structure.BooleanConstant" id="1236700767912">
                  <property name="value" value="false" />
                </node>
                <node role="lValue" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700764876">
                  <link role="variableDeclaration" targetNodeId="1236700642860" resolveInfo="first" />
                </node>
              </node>
            </node>
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700642898">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1236700670859">
              <link role="variableDeclaration" targetNodeId="1236700623868" resolveInfo="element" />
            </node>
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="1236700642900">
              <link role="link" targetNodeId="1.1225239603387" />
            </node>
          </node>
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700642901">
            <property name="name" value="part" />
            <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1236700642902">
              <link role="concept" targetNodeId="1.1225239603390" resolveInfo="ElementPart" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ReturnStatement" id="1236700775431">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700777292">
            <link role="variableDeclaration" targetNodeId="1236700642828" resolveInfo="result" />
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1236700623868">
        <property name="name" value="element" />
        <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1236700623869">
          <link role="concept" targetNodeId="1.1225239603385" resolveInfo="Element" />
        </node>
      </node>
    </node>
    <node role="operation" type="jetbrains.mps.lang.textGen.structure.OperationDeclaration" id="1236700487434">
      <property name="name" value="appendByElement" />
      <node role="returnType" type="jetbrains.mps.baseLanguage.structure.VoidType" id="1236700487435" />
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700487436">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700571834">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700571835">
            <property name="name" value="element" />
            <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1236700571836">
              <link role="concept" targetNodeId="1.1225239603385" resolveInfo="Element" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700571837">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParameterReference" id="1236700605066">
                <link role="variableDeclaration" targetNodeId="1236700593595" resolveInfo="node" />
              </node>
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="1236700571839">
                <link role="link" targetNodeId="1.1225239603384" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700571840">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700571841">
            <property name="name" value="result" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236700571842">
              <link role="classifier" targetNodeId="2.~Element" resolveInfo="Element" />
            </node>
            <node role="initializer" type="jetbrains.mps.lang.textGen.structure.PrivateMethodCall" id="1236700684755">
              <link role="function" targetNodeId="1236700609238" resolveInfo="createElement" />
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700687787">
                <link role="variableDeclaration" targetNodeId="1236700571835" resolveInfo="element" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700791060">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700791061">
            <property name="name" value="document" />
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236700791062">
              <link role="classifier" targetNodeId="2.~Document" resolveInfo="Document" />
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1236700810642">
              <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1236700810643">
                <link role="baseMethodDeclaration" targetNodeId="2.~Document.&lt;init&gt;()" resolveInfo="Document" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700818617">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700818932">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700818618">
              <link role="variableDeclaration" targetNodeId="1236700791061" resolveInfo="document" />
            </node>
            <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236700821905">
              <link role="baseMethodDeclaration" targetNodeId="2.~Document.setRootElement(org.jdom.Element):org.jdom.Document" resolveInfo="setRootElement" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700823921">
                <link role="variableDeclaration" targetNodeId="1236700571841" resolveInfo="result" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.TryCatchStatement" id="1236700827376">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700827377">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700869045">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700869046">
                <property name="name" value="prettyFormat" />
                <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236700869047">
                  <link role="classifier" targetNodeId="3.~Format" resolveInfo="Format" />
                </node>
                <node role="initializer" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1236700884894">
                  <link role="baseMethodDeclaration" targetNodeId="3.~Format.getPrettyFormat():org.jdom.output.Format" resolveInfo="getPrettyFormat" />
                  <link role="classConcept" targetNodeId="3.~Format" resolveInfo="Format" />
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236700887615">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236700889429">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700887616">
                  <link role="variableDeclaration" targetNodeId="1236700869046" resolveInfo="prettyFormat" />
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236700892152">
                  <link role="baseMethodDeclaration" targetNodeId="3.~Format.setTextMode(org.jdom.output.Format$TextMode):org.jdom.output.Format" resolveInfo="setTextMode" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference" id="1236700942811">
                    <link role="classifier" targetNodeId="3.~Format$TextMode" resolveInfo="Format.TextMode" />
                    <link role="variableDeclaration" targetNodeId="3.~Format$TextMode.PRESERVE" resolveInfo="PRESERVE" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700954189">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700954190">
                <property name="name" value="xmlOutputter" />
                <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236700954191">
                  <link role="classifier" targetNodeId="3.~XMLOutputter" resolveInfo="XMLOutputter" />
                </node>
                <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1236700977029">
                  <node role="creator" type="jetbrains.mps.baseLanguage.structure.ClassCreator" id="1236700977030">
                    <link role="baseMethodDeclaration" targetNodeId="3.~XMLOutputter.&lt;init&gt;(org.jdom.output.Format)" resolveInfo="XMLOutputter" />
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700981187">
                      <link role="variableDeclaration" targetNodeId="1236700869046" resolveInfo="prettyFormat" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1236700987314">
              <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700987315">
                <property name="name" value="output" />
                <node role="type" type="jetbrains.mps.baseLanguage.structure.StringType" id="1236700987316" />
                <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1236701000679">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236700999912">
                    <link role="variableDeclaration" targetNodeId="1236700954190" resolveInfo="xmlOutputter" />
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1236701009714">
                    <link role="baseMethodDeclaration" targetNodeId="3.~XMLOutputter.outputString(org.jdom.Document):java.lang.String" resolveInfo="outputString" />
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236701012497">
                      <link role="variableDeclaration" targetNodeId="1236700791061" resolveInfo="document" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement" type="jetbrains.mps.lang.textGen.structure.AppendOperation" id="1236701016436">
              <node role="arguments" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1236701048799">
                <link role="variableDeclaration" targetNodeId="1236700987315" resolveInfo="output" />
              </node>
              <node role="notNullArg" type="jetbrains.mps.baseLanguage.structure.Expression" id="1236701025829" />
            </node>
          </node>
          <node role="catchClause" type="jetbrains.mps.baseLanguage.structure.CatchClause" id="1236700827379">
            <node role="throwable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1236700827380">
              <property name="name" value="e" />
              <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1236701070395">
                <link role="classifier" targetNodeId="4.~Exception" resolveInfo="Exception" />
              </node>
            </node>
            <node role="catchBody" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1236700827382">
              <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1236701106380">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1236701176929">
                  <link role="baseMethodDeclaration" targetNodeId="5.~Logger.getLogger(java.lang.Class):jetbrains.mps.logging.Logger" resolveInfo="getLogger" />
                  <link role="classConcept" targetNodeId="5.~Logger" resolveInfo="Logger" />
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.ClassifierClassExpression" id="1236701176930">
                    <link role="classifier" targetNodeId="2.~Document" resolveInfo="Document" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration" id="1236700593595">
        <property name="name" value="node" />
        <node role="type" type="jetbrains.mps.lang.smodel.structure.SNodeType" id="1236700593596">
          <link role="concept" targetNodeId="1.1225239603382" resolveInfo="Document" />
        </node>
      </node>
    </node>
  </node>
</model>

