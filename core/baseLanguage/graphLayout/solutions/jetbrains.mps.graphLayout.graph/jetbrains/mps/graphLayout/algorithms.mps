<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:5aba4e89-d910-492c-9b56-c5e3fe8c0f28(jetbrains.mps.graphLayout.algorithms)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <language namespace="fd392034-7849-419d-9071-12563d152375(jetbrains.mps.baseLanguage.closures)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <maxImportIndex value="4" />
  <import index="1" modelUID="r:d228b8c9-d2b1-4686-9904-e3c49a346bc6(jetbrains.mps.graphLayout.graph)" version="-1" />
  <import index="2" modelUID="r:8254b240-abed-4f97-a7cd-2eef733ec7fb(jetbrains.mps.graphLayout.util)" version="-1" />
  <import index="4" modelUID="f:java_stub#java.lang(java.lang@java_stub)" version="-1" />
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="4660430665333277271">
    <property name="name:3" value="Dfs" />
    <property name="abstractClass:3" value="true" />
    <property name="package:3" value="dfs" />
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="4519409331094618576">
      <property name="name:3" value="BEFORE" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4519409331094618600" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4519409331094618579" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4519409331094618581">
        <property name="value:3" value="0" />
      </node>
    </node>
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="4519409331094618582">
      <property name="name:3" value="DURING" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4519409331094618601" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4519409331094618585" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4519409331094618587">
        <property name="value:3" value="1" />
      </node>
    </node>
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="4519409331094618588">
      <property name="name:3" value="AFTER" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4519409331094618602" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4519409331094618591" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4519409331094618593">
        <property name="value:3" value="2" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="1646208389854254821">
      <property name="name:3" value="doDfs" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="1646208389854254822" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1646208389854254823" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1646208389854254824">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1646208389854254837">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="1646208389854254838">
            <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277333" resolveInfo="doDfs" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1646208389854254839">
              <link role="variableDeclaration:3" targetNodeId="1646208389854254835" resolveInfo="graph" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="1646208389854254843">
              <link role="enumConstantDeclaration:3" targetNodeId="1.190081711777509663" resolveInfo="FRONT" />
              <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1646208389854254835">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854254836">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4660430665333277333">
      <property name="name:3" value="doDfs" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4660430665333277334" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4660430665333277335" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277336">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1654665216152485570">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654665216152485571">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ThisExpression:3" id="1654665216152485572" />
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654665216152485573">
              <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485538" resolveInfo="init" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485574">
                <link role="variableDeclaration:3" targetNodeId="4660430665333277350" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485575">
                <link role="variableDeclaration:3" targetNodeId="1646208389854254825" resolveInfo="direction" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4660430665333277337">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4660430665333277338">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4660430665333277345">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4660430665333277341">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277279" resolveInfo="myGraph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4660430665333277349">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277340">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4660430665333277359">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4660430665333277367">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4660430665333277363">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4660430665333277366">
                    <link role="variable:7" targetNodeId="4660430665333277338" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4660430665333277362">
                    <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
                  </node>
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="4519409331094618594">
                  <link role="variableDeclaration:3" targetNodeId="4519409331094618576" resolveInfo="BEFORE" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277361">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4519409331094803431">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4519409331094803432">
                    <link role="baseMethodDeclaration:3" targetNodeId="4519409331094802661" resolveInfo="processRoot" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="529057043639072445">
                      <link role="variable:7" targetNodeId="4660430665333277338" resolveInfo="node" />
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277376">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4660430665333277377">
                    <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277371" resolveInfo="dfs" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4660430665333277378">
                      <link role="variable:7" targetNodeId="4660430665333277338" resolveInfo="node" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="2899723422951324821" />
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5180427534212043091">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="5180427534212043093">
                    <link role="baseMethodDeclaration:3" targetNodeId="5180427534212043085" resolveInfo="postprocessRoot" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="529057043639072446">
                      <link role="variable:7" targetNodeId="4660430665333277338" resolveInfo="node" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4660430665333277350">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277351">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1646208389854254825">
        <property name="name:3" value="direction" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854254827">
          <link role="classifier:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="1654665216152485538">
      <property name="name:3" value="init" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1654665216152551159" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="1654665216152485540" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485536">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485541">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485537">
        <property name="name:3" value="direction" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485542">
          <link role="classifier:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654665216152485543">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1654665216152485544">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="1654665216152485545">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485546">
              <link role="variableDeclaration:3" targetNodeId="1654665216152485536" resolveInfo="graph" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1654665216152485547">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277279" resolveInfo="myGraph" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1654665216152485548">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="1654665216152485549">
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1654665216152485550">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
            </node>
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="1654665216152485551">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="1654665216152485552">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485553">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485554">
                  <link role="variableDeclaration:3" targetNodeId="1654665216152485536" resolveInfo="graph" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1654665216152485555">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="1654665216152485556">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485557">
              <link role="variableDeclaration:3" targetNodeId="1654665216152485537" resolveInfo="direction" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1654665216152485558">
              <link role="variableDeclaration:3" targetNodeId="1646208389854254566" resolveInfo="myDirection" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="1654665216152485559">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="1654665216152485535">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654665216152485560">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1654665216152485561">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277279" resolveInfo="myGraph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654665216152485562">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654665216152485563">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1654665216152485564">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="1654665216152485565">
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="1654665216152485566">
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1654665216152485567">
                    <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
                  </node>
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="1654665216152485568">
                    <link role="variable:7" targetNodeId="1654665216152485535" resolveInfo="node" />
                  </node>
                </node>
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="1654665216152485569">
                  <link role="variableDeclaration:3" targetNodeId="4519409331094618576" resolveInfo="BEFORE" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4660430665333277371">
      <property name="name:3" value="dfs" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4660430665333277372" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="5213231752900615985" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277374">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277383">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4660430665333277389">
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4660430665333277385">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4660430665333277388">
                <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4660430665333277384">
                <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
              </node>
            </node>
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="4519409331094618595">
              <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277427">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4660430665333277428">
            <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277405" resolveInfo="preprocess" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4660430665333277429">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2899723422951325020">
              <link role="variableDeclaration:3" targetNodeId="2899723422951324817" resolveInfo="from" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4660430665333277431">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4660430665333277432">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4660430665333277436">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4660430665333277435">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4660430665333277440">
              <link role="baseMethodDeclaration:3" targetNodeId="1.190081711777510145" resolveInfo="getEdges" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="1646208389854254819">
                <link role="variableDeclaration:3" targetNodeId="1646208389854254566" resolveInfo="myDirection" />
              </node>
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277434">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="1646208389854262407">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="1646208389854262411">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1646208389854262414">
                  <link role="variableDeclaration:3" targetNodeId="2899723422951324817" resolveInfo="from" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="1646208389854262410">
                  <link role="variable:7" targetNodeId="4660430665333277432" resolveInfo="edge" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1646208389854262409">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277443">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4660430665333277444">
                    <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277419" resolveInfo="processEdge" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4660430665333277445">
                      <link role="variable:7" targetNodeId="4660430665333277432" resolveInfo="edge" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1646208389854273134">
                      <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4660430665333277473">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4660430665333277474">
                    <property name="name:3" value="target" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277475">
                      <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4660430665333277476">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4660430665333277477">
                        <link role="variable:7" targetNodeId="4660430665333277432" resolveInfo="edge" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4660430665333277478">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1646208389854254820">
                          <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4660430665333277448">
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277449">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277484">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4660430665333277485">
                        <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277371" resolveInfo="dfs" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4660430665333277486">
                          <link role="variableDeclaration:3" targetNodeId="4660430665333277474" resolveInfo="target" />
                        </node>
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="2899723422951324823">
                          <link role="variable:7" targetNodeId="4660430665333277432" resolveInfo="edge" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4660430665333277480">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4660430665333277464">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4660430665333277479">
                        <link role="variableDeclaration:3" targetNodeId="4660430665333277474" resolveInfo="target" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4660430665333277463">
                        <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
                      </node>
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="4519409331094618596">
                      <link role="variableDeclaration:3" targetNodeId="4519409331094618576" resolveInfo="BEFORE" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277488">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4660430665333277489">
            <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277412" resolveInfo="postprocess" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4660430665333277490">
              <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="2899723422951325022">
              <link role="variableDeclaration:3" targetNodeId="2899723422951324817" resolveInfo="from" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277394">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4660430665333277400">
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4660430665333277396">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4660430665333277399">
                <link role="variableDeclaration:3" targetNodeId="4660430665333277379" resolveInfo="node" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4660430665333277395">
                <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
              </node>
            </node>
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="4519409331094618597">
              <link role="variableDeclaration:3" targetNodeId="4519409331094618588" resolveInfo="AFTER" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4660430665333277379">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277380">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2899723422951324817">
        <property name="name:3" value="from" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2899723422951324819">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4519409331094802661">
      <property name="name:3" value="preprocessRoot" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4519409331094802662" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="4519409331094802665" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4519409331094802664" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639072441">
        <property name="name:3" value="root" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639072442">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5180427534212043085">
      <property name="name:3" value="postprocessRoot" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5180427534212043086" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="5180427534212043089" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212043088" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639072443">
        <property name="name:3" value="root" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639072444">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4660430665333277405">
      <property name="name:3" value="preprocess" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4660430665333277406" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="4660430665333277409" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277408" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4660430665333277410">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277411">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2899723422951325023">
        <property name="name:3" value="from" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2899723422951325025">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4660430665333277419">
      <property name="name:3" value="processEdge" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4660430665333277420" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="4660430665333277423" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277422" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4660430665333277424">
        <property name="name:3" value="edge" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854266725">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1646208389854266726">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854266727">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4660430665333277412">
      <property name="name:3" value="postprocess" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4660430665333277413" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="4660430665333277418" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277415" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4660430665333277416">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277417">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2899723422951325028">
        <property name="name:3" value="from" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2899723422951325029">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4660430665333277279">
      <property name="name:3" value="myGraph" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4660430665333277280" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277282">
        <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4660430665333277292">
      <property name="name:3" value="myDfsState" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="4644851485137245018" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4660430665333277294">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277295">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277296">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="1646208389854254566">
      <property name="name:3" value="myDirection" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="1646208389854254567" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854254569">
        <link role="classifier:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4660430665333277272" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="4660430665333277273">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4660430665333277274" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4660430665333277275" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277276" />
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4660430665333277452">
      <property name="name:3" value="getDfsState" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4660430665333277453">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277454">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4660430665333277455">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="4660430665333277462" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4660430665333277457">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4660430665333277458">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4660430665333277459">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ThisExpression:3" id="4660430665333277460" />
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="4660430665333277461">
              <link role="fieldDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310498455">
      <property name="name:3" value="getGraph" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498459">
        <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="6074874003310498457" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310498458">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="6074874003310498464">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498466">
            <link role="variableDeclaration:3" targetNodeId="4660430665333277279" resolveInfo="myGraph" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="5180427534212042655">
    <property name="name:3" value="TopologicalSorting" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="5180427534212042776">
      <property name="name:3" value="sort" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="5180427534212042820">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042822">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5180427534212042778" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212042779">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5180427534212042786">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5180427534212042787">
            <property name="name:3" value="sorter" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042788">
              <link role="classifier:3" targetNodeId="5180427534212042655" resolveInfo="TopologicalSorter" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5180427534212042789">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5180427534212042790">
                <link role="baseMethodDeclaration:3" targetNodeId="5180427534212042771" resolveInfo="TopologicalSorter" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5180427534212042792">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5180427534212042794">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5180427534212042793">
              <link role="variableDeclaration:3" targetNodeId="5180427534212042787" resolveInfo="sorter" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5180427534212042798">
              <link role="baseMethodDeclaration:3" targetNodeId="5180427534212042687" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5180427534212042799">
                <link role="variableDeclaration:3" targetNodeId="5180427534212042780" resolveInfo="g" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="920414672219845782">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219845783">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ThrowStatement:3" id="920414672219845802">
              <node role="throwable:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="920414672219845804">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="920414672219845806">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~IllegalArgumentException.&lt;init&gt;(java.lang.String)" resolveInfo="IllegalArgumentException" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="920414672219845807">
                    <property name="value:3" value="input graph must be acyclic" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="920414672219845797">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219845796">
              <link role="variableDeclaration:3" targetNodeId="5180427534212042787" resolveInfo="sorter" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="920414672219845801">
              <link role="baseMethodDeclaration:3" targetNodeId="920414672219845786" resolveInfo="getHasCycles" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="5180427534212042812">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5180427534212042815">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5180427534212042814">
              <link role="variableDeclaration:3" targetNodeId="5180427534212042787" resolveInfo="sorter" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5180427534212042819">
              <link role="baseMethodDeclaration:3" targetNodeId="5180427534212042800" resolveInfo="getOrder" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5180427534212042780">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042781">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="throwsItem:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219845732">
        <link role="classifier:3" targetNodeId="4.~IllegalArgumentException" resolveInfo="IllegalArgumentException" />
      </node>
    </node>
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="5180427534212042771">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5180427534212042772" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212042774" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5180427534212042775" />
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5180427534212042679">
      <property name="name:3" value="myOrder" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5180427534212042680" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="5180427534212042682">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042684">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="920414672219845734">
      <property name="name:3" value="myHasCycles" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="920414672219845735" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="920414672219845737" />
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5180427534212042656" />
    <node role="superclass:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042678">
      <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5180427534212042687">
      <property name="name:3" value="doDfs" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5180427534212042688" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5180427534212042689" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5180427534212042690">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042691">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212042692">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5180427534212042698">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5180427534212042700">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5180427534212042738">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator:7" id="5180427534212042739">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042740">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5180427534212042699">
              <link role="variableDeclaration:3" targetNodeId="5180427534212042679" resolveInfo="myOrder" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="920414672219845750">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="920414672219845752">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="920414672219845755">
              <property name="value:3" value="false" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="920414672219845751">
              <link role="variableDeclaration:3" targetNodeId="920414672219845734" resolveInfo="hasCycles" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5180427534212042694">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.SuperMethodCall:3" id="5180427534212042695">
            <link role="baseMethodDeclaration:3" targetNodeId="1646208389854254821" resolveInfo="doDfs" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5180427534212042696">
              <link role="variableDeclaration:3" targetNodeId="5180427534212042690" resolveInfo="graph" />
            </node>
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="5180427534212042693">
        <link role="annotation:3" targetNodeId="4.~Override" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5180427534212042719">
      <property name="name:3" value="postprocess" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5180427534212042720" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="5180427534212042721" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5180427534212042722">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042723">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="2899723422951325113">
        <property name="name:3" value="from" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="2899723422951325115">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212042724">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5180427534212042741">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5180427534212042743">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5180427534212042742">
              <link role="variableDeclaration:3" targetNodeId="5180427534212042679" resolveInfo="myOrder" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddFirstElementOperation:7" id="5180427534212042747">
              <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5180427534212042749">
                <link role="variableDeclaration:3" targetNodeId="5180427534212042722" resolveInfo="node" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="5180427534212042725">
        <link role="annotation:3" targetNodeId="4.~Override" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5180427534212042800">
      <property name="name:3" value="getOrder" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="5180427534212042805">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5180427534212042807">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5180427534212042804" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212042803">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="5180427534212042808">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5180427534212042810">
            <link role="variableDeclaration:3" targetNodeId="5180427534212042679" resolveInfo="myOrder" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="920414672219845786">
      <property name="name:3" value="getHasCycles" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="920414672219845791" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="920414672219845790" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219845789">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="920414672219845792">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="920414672219845795">
            <link role="variableDeclaration:3" targetNodeId="920414672219845734" resolveInfo="myHasCycles" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="920414672219845738">
      <property name="name:3" value="processEdge" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="920414672219845739" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="920414672219845740" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219845743">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="920414672219845756">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219845758">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="920414672219845776">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="920414672219845778">
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="920414672219845777">
                  <link role="variableDeclaration:3" targetNodeId="920414672219845734" resolveInfo="hasCycles" />
                </node>
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="920414672219845781">
                  <property name="value:3" value="true" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="920414672219845772">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="920414672219845775">
              <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
              <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="920414672219845766">
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="920414672219845765">
                <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277452" resolveInfo="getDfsState" />
              </node>
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="920414672219845769">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="920414672219845770">
                  <link role="variableDeclaration:3" targetNodeId="920414672219845741" resolveInfo="edge" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="920414672219845771">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="920414672219845744">
        <link role="annotation:3" targetNodeId="4.~Override" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="920414672219845741">
        <property name="name:3" value="edge" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854266719">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1646208389854266720">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1646208389854266721">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="5180427534212043147">
    <property name="name:3" value="TopologicalNumbering" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="920414672219832483">
      <property name="name:3" value="number" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="920414672219832509">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832512">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832513">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="920414672219832485" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219832486">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="920414672219832490">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="920414672219832491">
            <property name="name:3" value="sorting" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="920414672219832492">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832494">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="920414672219832497">
              <link role="baseMethodDeclaration:3" targetNodeId="5180427534212042776" resolveInfo="sort" />
              <link role="classConcept:3" targetNodeId="5180427534212042655" resolveInfo="TopologicalSorting" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="920414672219832498">
                <link role="variableDeclaration:3" targetNodeId="920414672219832488" resolveInfo="graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="920414672219832516">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="920414672219832517">
            <property name="name:3" value="numbering" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="920414672219832518">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832521">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832522">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="920414672219832524">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="920414672219832526">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832528">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="920414672219832529">
                  <link role="variableDeclaration:3" targetNodeId="920414672219832488" resolveInfo="graph" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="920414672219835491">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="920414672219835492">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="920414672219835496">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="920414672219835495">
              <link role="variableDeclaration:3" targetNodeId="920414672219832488" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="920414672219835500">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219835494">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="920414672219835501">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="920414672219835507">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="920414672219835510">
                  <property name="value:3" value="0" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="920414672219835503">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="920414672219835506">
                    <link role="variable:7" targetNodeId="920414672219835492" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835502">
                    <link role="variableDeclaration:3" targetNodeId="920414672219832517" resolveInfo="numbering" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="920414672219835512">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="920414672219835513">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835516">
            <link role="variableDeclaration:3" targetNodeId="920414672219832491" resolveInfo="sorting" />
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219835515">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="920414672219835517">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="920414672219835518">
                <property name="name:7" value="edge" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="920414672219835522">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="920414672219835521">
                  <link role="variable:7" targetNodeId="920414672219835513" resolveInfo="node" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="920414672219835526">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821110932" resolveInfo="getOutEdges" />
                </node>
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="920414672219835520">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="920414672219835549">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="920414672219835550">
                    <property name="name:3" value="target" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219835551">
                      <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="920414672219835552">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="920414672219835553">
                        <link role="variable:7" targetNodeId="920414672219835518" resolveInfo="edge" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="920414672219835554">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="920414672219835527">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="920414672219835538">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="920414672219835542">
                      <link role="classConcept:3" targetNodeId="4.~Math" resolveInfo="Math" />
                      <link role="baseMethodDeclaration:3" targetNodeId="4.~Math.max(int,int):int" resolveInfo="max" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="920414672219835543">
                        <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835556">
                          <link role="variableDeclaration:3" targetNodeId="920414672219835550" resolveInfo="target" />
                        </node>
                        <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835547">
                          <link role="variableDeclaration:3" targetNodeId="920414672219832517" resolveInfo="numbering" />
                        </node>
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="920414672219835562">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="920414672219835565">
                          <property name="value:3" value="1" />
                        </node>
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="920414672219835558">
                          <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="920414672219835561">
                            <link role="variable:7" targetNodeId="920414672219835513" resolveInfo="node" />
                          </node>
                          <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835557">
                            <link role="variableDeclaration:3" targetNodeId="920414672219832517" resolveInfo="numbering" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="920414672219835529">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835555">
                        <link role="variableDeclaration:3" targetNodeId="920414672219835550" resolveInfo="target" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835528">
                        <link role="variableDeclaration:3" targetNodeId="920414672219832517" resolveInfo="numbering" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="920414672219832531">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="920414672219835489">
            <link role="variableDeclaration:3" targetNodeId="920414672219832517" resolveInfo="numbering" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="920414672219832488">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219832489">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="throwsItem:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="920414672219845809">
        <link role="classifier:3" targetNodeId="4.~IllegalArgumentException" resolveInfo="IllegalArgumentException" />
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5180427534212043148" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="5180427534212043149">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5180427534212043150" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="920414672219832482" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5180427534212043152" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="4179389957059009260">
    <property name="name:3" value="ShortestPath" />
    <node role="staticField:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration:3" id="4250605017401923948">
      <property name="isFinal:3" value="true" />
      <property name="name:3" value="INF" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4250605017401923951" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4250605017401923952" />
      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DivExpression:3" id="4250605017401923956">
        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4250605017401923959">
          <property name="value:3" value="2" />
        </node>
        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4250605017401923955">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          <link role="variableDeclaration:3" targetNodeId="4.~Integer.MAX_VALUE" resolveInfo="MAX_VALUE" />
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="1418350014056290822">
      <property name="name:3" value="getPath" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="1418350014056290829">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290831">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1418350014056290824" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1418350014056290825">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="1418350014056290845">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall:3" id="1418350014056290847">
            <link role="baseMethodDeclaration:3" targetNodeId="4179389957059009270" resolveInfo="getPath" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1418350014056290848">
              <link role="variableDeclaration:3" targetNodeId="1418350014056290832" resolveInfo="graph" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1418350014056290850">
              <link role="variableDeclaration:3" targetNodeId="1418350014056290834" resolveInfo="source" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1418350014056290852">
              <link role="variableDeclaration:3" targetNodeId="1418350014056290839" resolveInfo="target" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1418350014056290854">
              <link role="variableDeclaration:3" targetNodeId="1418350014056290842" resolveInfo="direction" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="1418350014056290856">
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1418350014056290857">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1418350014056290860">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="1418350014056290861">
                    <property name="value:3" value="true" />
                  </node>
                </node>
              </node>
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1418350014056290858">
                <property name="name:3" value="edge" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290859">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1418350014056290832">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290833">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1418350014056290834">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290836">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1418350014056290839">
        <property name="name:3" value="target" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290841">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1418350014056290842">
        <property name="name:3" value="direction" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290844">
          <link role="classifier:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="4179389957059009270">
      <property name="name:3" value="getPath" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="4179389957059009274">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012232">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4179389957059009272" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4179389957059012235">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012236">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4179389957059012237">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012239">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4179389957059012240">
        <property name="name:3" value="target" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012242">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4179389957059012246">
        <property name="name:3" value="direction" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012249">
          <link role="classifier:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1418350014056290802">
        <property name="name:3" value="filter" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.closures.structure.FunctionType:3" id="1418350014056290804">
          <node role="parameterType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1418350014056290806">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="resultType:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="1418350014056290807" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012250">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012257">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012258">
            <property name="name:3" value="dist" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4179389957059012259">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012262">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012263">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4179389957059012265">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4179389957059012267">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012268">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012235" resolveInfo="graph" />
                </node>
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012270">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012272">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012273">
            <property name="name:3" value="prev" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4179389957059012274">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012277">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012278">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4179389957059012280">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4179389957059012282">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012283">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012235" resolveInfo="graph" />
                </node>
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012285">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012287">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012288">
            <property name="name:3" value="queue" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.QueueType:7" id="4179389957059012289">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012291">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4179389957059012293">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator:7" id="4179389957059012294">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012295">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012297">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4179389957059012304">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4179389957059012307">
              <property name="value:3" value="0" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012300">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012303">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012237" resolveInfo="source" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012299">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012258" resolveInfo="dist" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012309">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4179389957059012315">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4179389957059012318" />
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012311">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012314">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012237" resolveInfo="source" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012310">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012273" resolveInfo="prev" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012320">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012322">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012321">
              <link role="variableDeclaration:3" targetNodeId="4179389957059012288" resolveInfo="queue" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddLastElementOperation:7" id="4179389957059012326">
              <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012328">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012237" resolveInfo="source" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012335">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012336">
            <property name="name:3" value="found" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="4179389957059012337" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="4179389957059012339">
              <property name="value:3" value="false" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.WhileStatement:3" id="4179389957059012330">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="4179389957059012345">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012340">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012333">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012288" resolveInfo="queue" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="4179389957059012344" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4179389957059012348">
              <property name="value:3" value="0" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012332">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012357">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012358">
                <property name="name:3" value="cur" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012359">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012362">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012361">
                    <link role="variableDeclaration:3" targetNodeId="4179389957059012288" resolveInfo="queue" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.RemoveFirstElementOperation:7" id="4179389957059012366" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4179389957059012378">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012379">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012387">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4179389957059012389">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="4179389957059012392">
                      <property name="value:3" value="true" />
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012388">
                      <link role="variableDeclaration:3" targetNodeId="4179389957059012336" resolveInfo="found" />
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.BreakStatement:3" id="4179389957059012394" />
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4179389957059012383">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012386">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012240" resolveInfo="target" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012382">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012358" resolveInfo="cur" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4179389957059012368">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4179389957059012369">
                <property name="name:7" value="edge" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012373">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012372">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012358" resolveInfo="cur" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4179389957059012395">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.190081711777510145" resolveInfo="getEdges" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012396">
                    <link role="variableDeclaration:3" targetNodeId="4179389957059012246" resolveInfo="direction" />
                  </node>
                </node>
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012371">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="1418350014056290808">
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1418350014056290812">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1418350014056290811">
                      <link role="variableDeclaration:3" targetNodeId="1418350014056290802" resolveInfo="filter" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation:3" id="1418350014056290816">
                      <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="1418350014056290817">
                        <link role="variable:7" targetNodeId="4179389957059012369" resolveInfo="edge" />
                      </node>
                    </node>
                  </node>
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1418350014056290810">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012403">
                      <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012404">
                        <property name="name:3" value="next" />
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012405">
                          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                        </node>
                        <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012408">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4179389957059012407">
                            <link role="variable:7" targetNodeId="4179389957059012369" resolveInfo="edge" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4179389957059012412">
                            <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012415">
                              <link role="variableDeclaration:3" targetNodeId="4179389957059012358" resolveInfo="cur" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4179389957059012397">
                      <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4179389957059012422">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4179389957059012425" />
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012418">
                          <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012421">
                            <link role="variableDeclaration:3" targetNodeId="4179389957059012404" resolveInfo="next" />
                          </node>
                          <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012417">
                            <link role="variableDeclaration:3" targetNodeId="4179389957059012258" resolveInfo="dist" />
                          </node>
                        </node>
                      </node>
                      <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012399">
                        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012426">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012428">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012427">
                              <link role="variableDeclaration:3" targetNodeId="4179389957059012288" resolveInfo="queue" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddLastElementOperation:7" id="4179389957059012432">
                              <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012434">
                                <link role="variableDeclaration:3" targetNodeId="4179389957059012404" resolveInfo="next" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012436">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4179389957059012442">
                            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4179389957059012450">
                              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4179389957059012453">
                                <property name="value:3" value="1" />
                              </node>
                              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012446">
                                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012449">
                                  <link role="variableDeclaration:3" targetNodeId="4179389957059012358" resolveInfo="cur" />
                                </node>
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012445">
                                  <link role="variableDeclaration:3" targetNodeId="4179389957059012258" resolveInfo="dist" />
                                </node>
                              </node>
                            </node>
                            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012438">
                              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012441">
                                <link role="variableDeclaration:3" targetNodeId="4179389957059012404" resolveInfo="next" />
                              </node>
                              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012437">
                                <link role="variableDeclaration:3" targetNodeId="4179389957059012258" resolveInfo="dist" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012455">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4179389957059012462">
                            <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4179389957059012465">
                              <link role="variable:7" targetNodeId="4179389957059012369" resolveInfo="edge" />
                            </node>
                            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012458">
                              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012461">
                                <link role="variableDeclaration:3" targetNodeId="4179389957059012404" resolveInfo="next" />
                              </node>
                              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012457">
                                <link role="variableDeclaration:3" targetNodeId="4179389957059012273" resolveInfo="prev" />
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
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4179389957059012467">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012468">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4179389957059012474">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4179389957059012476" />
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="4179389957059012472">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012473">
              <link role="variableDeclaration:3" targetNodeId="4179389957059012336" resolveInfo="found" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012478">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012479">
            <property name="name:3" value="path" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="4179389957059012480">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012482">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4179389957059012484">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator:7" id="4179389957059012485">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012486">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4179389957059012499">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4179389957059012500">
            <property name="name:3" value="cur" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4179389957059012501">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4179389957059012503">
              <link role="variableDeclaration:3" targetNodeId="4179389957059012240" resolveInfo="target" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.WhileStatement:3" id="4179389957059012505">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4179389957059012514">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4179389957059012517" />
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012510">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012513">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012500" resolveInfo="cur" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012509">
                <link role="variableDeclaration:3" targetNodeId="4179389957059012273" resolveInfo="prev" />
              </node>
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4179389957059012507">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012518">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012527">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012519">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012479" resolveInfo="path" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddFirstElementOperation:7" id="4179389957059012531">
                  <node role="argument:7" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012534">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012537">
                      <link role="variableDeclaration:3" targetNodeId="4179389957059012500" resolveInfo="cur" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012533">
                      <link role="variableDeclaration:3" targetNodeId="4179389957059012273" resolveInfo="prev" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4179389957059012539">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4179389957059012541">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4179389957059012553">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4179389957059012545">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012548">
                      <link role="variableDeclaration:3" targetNodeId="4179389957059012500" resolveInfo="cur" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012544">
                      <link role="variableDeclaration:3" targetNodeId="4179389957059012273" resolveInfo="prev" />
                    </node>
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4179389957059012557">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012558">
                      <link role="variableDeclaration:3" targetNodeId="4179389957059012500" resolveInfo="cur" />
                    </node>
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012540">
                  <link role="variableDeclaration:3" targetNodeId="4179389957059012500" resolveInfo="cur" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4179389957059012488">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4179389957059012490">
            <link role="variableDeclaration:3" targetNodeId="4179389957059012479" resolveInfo="path" />
          </node>
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4179389957059009261" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="1654665216152485424">
    <property name="name:3" value="STNumbering" />
    <node role="staticInnerClassifiers:3" type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="5213231752900627202">
      <property name="nonStatic:3" value="false" />
      <property name="name:3" value="Numbering" />
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5213231752900627258">
        <property name="name:3" value="mySign" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900627259" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900627261">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627264">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627265">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5213231752900627288">
        <property name="name:3" value="myLow" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900627289" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900627291">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627294">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627305">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5213231752900627274">
        <property name="name:3" value="myList" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900627275" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="5213231752900627277">
          <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627279">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5213231752900627585">
        <property name="name:3" value="myTarget" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900627586" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627588">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900627203" />
      <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="5213231752900627204">
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900627205" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900627206" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627207" />
      </node>
      <node role="superclass:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627210">
        <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900627211">
        <property name="name:3" value="doDfs" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900627212" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900627213" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900627214">
          <property name="name:3" value="graph" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627215">
            <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900627450">
          <property name="name:3" value="source" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627452">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900627456">
          <property name="name:3" value="stEdge" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627458">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900627459">
          <property name="name:3" value="low" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900627461">
            <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627464">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627465">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627216">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627222">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="5213231752900627223">
              <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485538" resolveInfo="init" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627224">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627214" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="5213231752900627227">
                <link role="enumConstantDeclaration:3" targetNodeId="1.2899723422951324703" resolveInfo="BOTH" />
                <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627466">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627468">
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627467">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627288" resolveInfo="myLow" />
              </node>
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627471">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627459" resolveInfo="low" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627473">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627475">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900627478">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5213231752900627480">
                  <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                  <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627482">
                    <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627483">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900627214" resolveInfo="graph" />
                  </node>
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627474">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627258" resolveInfo="mySign" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627496">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627497">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="5213231752900627502">
                <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627499">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627500">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627450" resolveInfo="source" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="5213231752900627501">
                  <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277452" resolveInfo="getDfsState" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627559">
            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627560">
              <property name="name:3" value="target" />
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627561">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627562">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627563">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627456" resolveInfo="stEdge" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627564">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627565">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900627450" resolveInfo="source" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627590">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627592">
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627591">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627585" resolveInfo="myTarget" />
              </node>
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627595">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627560" resolveInfo="target" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627539">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627545">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5213231752900627548">
                <property name="value:3" value="-1" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627541">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627544">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627450" resolveInfo="source" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627540">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627258" resolveInfo="mySign" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627566">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627568">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900627571">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit:7" id="5213231752900627572">
                  <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627573">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                  <node role="initValue:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627575">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900627450" resolveInfo="source" />
                  </node>
                  <node role="initValue:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627577">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900627560" resolveInfo="target" />
                  </node>
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627567">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627274" resolveInfo="myList" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627519">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="5213231752900627520">
              <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277371" resolveInfo="dfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627557">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627560" resolveInfo="target" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627522">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627456" resolveInfo="stEdge" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900627228">
        <property name="name:3" value="preprocess" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900627229" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="5213231752900627230" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900627231">
          <property name="name:3" value="node" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627232">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900627233">
          <property name="name:3" value="from" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627234">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627235">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="5213231752900627578">
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="5213231752900627582">
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627596">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627585" resolveInfo="myTarget" />
              </node>
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627581">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627231" resolveInfo="node" />
              </node>
            </node>
            <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627580">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627244">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627245">
                  <property name="name:3" value="prev" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627246">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627249">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627248">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627233" resolveInfo="from" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627253">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627254">
                        <link role="variableDeclaration:3" targetNodeId="5213231752900627231" resolveInfo="node" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627345">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627346">
                  <property name="name:3" value="prevIndex" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="5213231752900627347" />
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627350">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627349">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627274" resolveInfo="myList" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetIndexOfOperation:7" id="5213231752900627354">
                      <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627356">
                        <link role="variableDeclaration:3" targetNodeId="5213231752900627245" resolveInfo="prev" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627397">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627398">
                  <property name="name:3" value="nodeIndex" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="5213231752900627399" />
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627412">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900627346" resolveInfo="prevIndex" />
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="5213231752900627358">
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627359">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627401">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627403">
                      <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="5213231752900627407">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5213231752900627410">
                          <property name="value:3" value="1" />
                        </node>
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627406">
                          <link role="variableDeclaration:3" targetNodeId="5213231752900627346" resolveInfo="prevIndex" />
                        </node>
                      </node>
                      <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627402">
                        <link role="variableDeclaration:3" targetNodeId="5213231752900627398" resolveInfo="nodeIndex" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="5213231752900627371">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5213231752900627374">
                    <property name="value:3" value="0" />
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627363">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627367">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627370">
                        <link role="variableDeclaration:3" targetNodeId="5213231752900627231" resolveInfo="node" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627366">
                        <link role="variableDeclaration:3" targetNodeId="5213231752900627288" resolveInfo="myLow" />
                      </node>
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627362">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627258" resolveInfo="mySign" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627414">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627416">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627415">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900627274" resolveInfo="myList" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.InsertElementOperation:7" id="5213231752900627420">
                    <node role="index:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627423">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627398" resolveInfo="nodeIndex" />
                    </node>
                    <node role="element:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627424">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627231" resolveInfo="node" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627426">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627432">
                  <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.UnaryMinus:3" id="5213231752900627438">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627441">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627445">
                        <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627448">
                          <link role="variableDeclaration:3" targetNodeId="5213231752900627231" resolveInfo="node" />
                        </node>
                        <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627444">
                          <link role="variableDeclaration:3" targetNodeId="5213231752900627288" resolveInfo="myLow" />
                        </node>
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627440">
                        <link role="variableDeclaration:3" targetNodeId="5213231752900627258" resolveInfo="mySign" />
                      </node>
                    </node>
                  </node>
                  <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900627428">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627431">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627245" resolveInfo="prev" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627427">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627258" resolveInfo="mySign" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="5213231752900627236">
          <link role="annotation:3" targetNodeId="4.~Override" />
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900627597">
        <property name="name:3" value="getList" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="5213231752900627601">
          <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627603">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900627599" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627600">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="5213231752900627604">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900627606">
              <link role="variableDeclaration:3" targetNodeId="5213231752900627274" resolveInfo="myList" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="1654665216152485441">
      <property name="name:3" value="number" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="1654665216152485446">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485449">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485450">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1654665216152485443" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654665216152485444">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627135">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627136">
            <property name="name:3" value="stEdge" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627137">
              <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="5213231752900627138" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627139">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627140">
            <property name="name:3" value="deleteAfter" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="5213231752900627141" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="5213231752900627142">
              <property name="value:3" value="false" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="5213231752900627143">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="5213231752900627144">
            <property name="name:7" value="edge" />
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627145">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="5213231752900627146">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627147">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627148">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627149">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="5213231752900627150">
                      <link role="variable:7" targetNodeId="5213231752900627144" resolveInfo="edge" />
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627151">
                      <link role="variableDeclaration:3" targetNodeId="5213231752900627136" resolveInfo="stEdge" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="5213231752900627152">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627153">
                  <link role="variableDeclaration:3" targetNodeId="1654665216152485456" resolveInfo="target" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627154">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="5213231752900627155">
                    <link role="variable:7" targetNodeId="5213231752900627144" resolveInfo="edge" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627156">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627157">
                      <link role="variableDeclaration:3" targetNodeId="1654665216152485453" resolveInfo="source" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627158">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627159">
              <link role="variableDeclaration:3" targetNodeId="1654665216152485453" resolveInfo="source" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627160">
              <link role="baseMethodDeclaration:3" targetNodeId="1.1327612371813210994" resolveInfo="getEdges" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="5213231752900627161">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627162">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627163">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627164">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627165">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627166">
                    <link role="variableDeclaration:3" targetNodeId="1654665216152485453" resolveInfo="source" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627167">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112323" resolveInfo="addEdgeTo" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627168">
                      <link role="variableDeclaration:3" targetNodeId="1654665216152485456" resolveInfo="target" />
                    </node>
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627169">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627136" resolveInfo="stEdge" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627170">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900627171">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="5213231752900627172">
                  <property name="value:3" value="true" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627173">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627140" resolveInfo="deleteAfter" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="5213231752900627174">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="5213231752900627175" />
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627176">
              <link role="variableDeclaration:3" targetNodeId="5213231752900627136" resolveInfo="stEdge" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900619507">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900619508">
            <property name="name:3" value="biconnectedComponents" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890106">
              <link role="classifier:3" targetNodeId="3720762119843889438" resolveInfo="BiconnectedComponents" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900619511">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="6074874003310494645">
                <link role="baseMethodDeclaration:3" targetNodeId="3720762119843889440" resolveInfo="BiconnectedComponents" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900619514">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900619516">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900619515">
              <link role="variableDeclaration:3" targetNodeId="5213231752900619508" resolveInfo="firstDfs" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900619520">
              <link role="baseMethodDeclaration:3" targetNodeId="3720762119843889906" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310494646">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485451" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900619523">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485453" resolveInfo="source" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627178">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627136" resolveInfo="stEdge" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627107">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627108">
            <property name="name:3" value="low" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900627109">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627112">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627113">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310494647">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627116">
                <link role="variableDeclaration:3" targetNodeId="5213231752900619508" resolveInfo="firstDfs" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310494651">
                <link role="baseMethodDeclaration:3" targetNodeId="3720762119843890076" resolveInfo="getLow" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900627616">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900627617">
            <property name="name:3" value="numbering" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900627618">
              <link role="classifier:3" targetNodeId="5213231752900627202" resolveInfo="STNumbering.SecondDfs" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900627620">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5213231752900627979">
                <link role="baseMethodDeclaration:3" targetNodeId="5213231752900627204" resolveInfo="STNumbering.SecondDfs" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627981">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627983">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627982">
              <link role="variableDeclaration:3" targetNodeId="5213231752900627617" resolveInfo="secondDfs" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627987">
              <link role="baseMethodDeclaration:3" targetNodeId="5213231752900627211" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627988">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485451" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900627990">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485453" resolveInfo="source" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627992">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627136" resolveInfo="stEdge" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627994">
                <link role="variableDeclaration:3" targetNodeId="5213231752900627108" resolveInfo="low" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900628268">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900628269">
            <property name="name:3" value="res" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900628270">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900628273">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900628274">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900628276">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5213231752900628278">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900628279">
                  <link role="variableDeclaration:3" targetNodeId="1654665216152485451" resolveInfo="graph" />
                </node>
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900628281">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900628289">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900628290">
            <property name="name:3" value="curNum" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="5213231752900628291" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5213231752900628293">
              <property name="value:3" value="0" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="5213231752900628284">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="5213231752900628285">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900628295">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900628294">
              <link role="variableDeclaration:3" targetNodeId="5213231752900627617" resolveInfo="secondDfs" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900628299">
              <link role="baseMethodDeclaration:3" targetNodeId="5213231752900627597" resolveInfo="getList" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900628287">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900628300">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900628306">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="5213231752900628310">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900628311">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900628290" resolveInfo="curNum" />
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900628302">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="5213231752900628305">
                    <link role="variable:7" targetNodeId="5213231752900628285" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900628301">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900628269" resolveInfo="res" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="5213231752900627184">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900627185">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900627186">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900627187">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627188">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900627136" resolveInfo="stEdge" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900627189">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.4660430665333277202" resolveInfo="removeFromGraph" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900627190">
            <link role="variableDeclaration:3" targetNodeId="5213231752900627140" resolveInfo="deleteAfter" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="5213231752900615693">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900628312">
            <link role="variableDeclaration:3" targetNodeId="5213231752900628269" resolveInfo="res" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485451">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485452">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485453">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485455">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485456">
        <property name="name:3" value="target" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485458">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1654665216152485425" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="1654665216152485857">
    <property name="name:3" value="GraphOrientation" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="1654665216152485863">
      <property name="name:3" value="orientST" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="516638300680465145">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="516638300680465148">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="516638300680465149">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1654665216152485865" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654665216152485866">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="1654665216152485875">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="1654665216152485876">
            <property name="name:3" value="stNumbering" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="1654665216152485877">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485880">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485881">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="1654665216152485886">
              <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485441" resolveInfo="number" />
              <link role="classConcept:3" targetNodeId="1654665216152485424" resolveInfo="STNumbering" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485887">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485867" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485891">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485869" resolveInfo="source" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152485893">
                <link role="variableDeclaration:3" targetNodeId="1654665216152485872" resolveInfo="target" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="1654665216152488903">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="1654665216152488904">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654665216152488908">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="1654665216152488907">
              <link role="variableDeclaration:3" targetNodeId="1654665216152485867" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654665216152488912">
              <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152485905" resolveInfo="getEdges" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654665216152488906">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="1654665216152488926">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="1654665216152488927">
                <property name="name:3" value="sourceNum" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="1654665216152488928" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="1654665216152488935">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654665216152488939">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="1654665216152488938">
                      <link role="variable:7" targetNodeId="1654665216152488904" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654665216152488943">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111981" resolveInfo="getSource" />
                    </node>
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="1654665216152488930">
                    <link role="variableDeclaration:3" targetNodeId="1654665216152485876" resolveInfo="stNumbering" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="1654665216152488945">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="1654665216152488946">
                <property name="name:3" value="targetNum" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="1654665216152488947" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="1654665216152488948">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654665216152488949">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="1654665216152488950">
                      <link role="variable:7" targetNodeId="1654665216152488904" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654665216152488951">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                    </node>
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="1654665216152488952">
                    <link role="variableDeclaration:3" targetNodeId="1654665216152485876" resolveInfo="stNumbering" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="1654665216152488913">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="1654665216152488915">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="1654665216152488958">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="1654665216152488960">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="1654665216152488959">
                      <link role="variable:7" targetNodeId="1654665216152488904" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="1654665216152488989">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152488964" resolveInfo="revert" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="1654665216152488954">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="1654665216152488953">
                  <link role="variableDeclaration:3" targetNodeId="1654665216152488927" resolveInfo="sourceNum" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="1654665216152488957">
                  <link role="variableDeclaration:3" targetNodeId="1654665216152488946" resolveInfo="targetNum" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="516638300680465151">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="516638300680465153">
            <link role="variableDeclaration:3" targetNodeId="1654665216152485876" resolveInfo="stNumbering" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485867">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485868">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485869">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485871">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="1654665216152485872">
        <property name="name:3" value="target" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="1654665216152485874">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="4644851485137274645">
      <property name="name:3" value="orientST" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137274654">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274657">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274658">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137274647" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137274648">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="3021256511735324762">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="3021256511735324763">
            <property name="name:3" value="firstEdge" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3021256511735324764">
              <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3021256511735324765">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3021256511735324766">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3021256511735324767">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137274659" resolveInfo="graph" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3021256511735324768">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152485905" resolveInfo="getEdges" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="3021256511735324769" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137274663">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137274664">
            <property name="name:3" value="source" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274665">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3021256511735324771">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3021256511735324770">
                <link role="variableDeclaration:3" targetNodeId="3021256511735324763" resolveInfo="firstEdge" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3021256511735324775">
                <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111981" resolveInfo="getSource" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137274679">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137274680">
            <property name="name:3" value="target" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274681">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3021256511735324778">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3021256511735324777">
                <link role="variableDeclaration:3" targetNodeId="3021256511735324763" resolveInfo="firstEdge" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3021256511735324782">
                <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137274692">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137274693">
            <property name="name:3" value="stNumbering" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137274694">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274695">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274696">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="4644851485137274697">
              <link role="classConcept:3" targetNodeId="1654665216152485424" resolveInfo="STNumbering" />
              <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485441" resolveInfo="number" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137274698">
                <link role="variableDeclaration:3" targetNodeId="4644851485137274659" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274734">
                <link role="variableDeclaration:3" targetNodeId="4644851485137274664" resolveInfo="source" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274735">
                <link role="variableDeclaration:3" targetNodeId="4644851485137274680" resolveInfo="target" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4644851485137274701">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4644851485137274702">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137274703">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137274704">
              <link role="variableDeclaration:3" targetNodeId="4644851485137274659" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137274705">
              <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152485905" resolveInfo="getEdges" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137274706">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137274707">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137274708">
                <property name="name:3" value="sourceNum" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4644851485137274709" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137274710">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137274711">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137274712">
                      <link role="variable:7" targetNodeId="4644851485137274702" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137274713">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111981" resolveInfo="getSource" />
                    </node>
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274714">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137274693" resolveInfo="stNumbering" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137274715">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137274716">
                <property name="name:3" value="targetNum" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4644851485137274717" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137274718">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137274719">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137274720">
                      <link role="variable:7" targetNodeId="4644851485137274702" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137274721">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                    </node>
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274722">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137274693" resolveInfo="stNumbering" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137274723">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137274724">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137274725">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137274726">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137274727">
                      <link role="variable:7" targetNodeId="4644851485137274702" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137274728">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152488964" resolveInfo="revert" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="4644851485137274729">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274730">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137274708" resolveInfo="sourceNum" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274731">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137274716" resolveInfo="targetNum" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137274732">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137274733">
            <link role="variableDeclaration:3" targetNodeId="4644851485137274693" resolveInfo="stNumbering" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="4644851485137274678" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137274659">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137274660">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="1654665216152485858" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="5213231752900660164">
    <property name="name:3" value="ConnectivityComponents" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="5213231752900660278">
      <property name="name:3" value="getComponents" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900660282">
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660286">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660285">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900660280" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900660281">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="5213231752900660298">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="5213231752900660299">
            <property name="name:3" value="dfs" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660300">
              <link role="classifier:3" targetNodeId="5213231752900660172" resolveInfo="ConnectivityComponents.MyDfs" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900660302">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5213231752900665210">
                <link role="baseMethodDeclaration:3" targetNodeId="5213231752900660174" resolveInfo="ConnectivityComponents.MyDfs" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900665212">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900665214">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900665213">
              <link role="variableDeclaration:3" targetNodeId="5213231752900660299" resolveInfo="dfs" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900665218">
              <link role="baseMethodDeclaration:3" targetNodeId="5213231752900660200" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900665219">
                <link role="variableDeclaration:3" targetNodeId="5213231752900660287" resolveInfo="graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="5213231752900665231">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900665234">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="5213231752900665233">
              <link role="variableDeclaration:3" targetNodeId="5213231752900660299" resolveInfo="dfs" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="5213231752900665238">
              <link role="baseMethodDeclaration:3" targetNodeId="5213231752900665221" resolveInfo="getComponents" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900660287">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660288">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
    </node>
    <node role="staticInnerClassifiers:3" type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="5213231752900660172">
      <property name="nonStatic:3" value="false" />
      <property name="name:3" value="MyDfs" />
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5213231752900660179">
        <property name="name:3" value="myComponents" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900660180" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900660182">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660185">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660186">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="5213231752900660227">
        <property name="name:3" value="myCurrentComponent" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900660228" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="5213231752900660230" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="5213231752900660295" />
      <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="5213231752900660174">
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900660175" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900660176" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900660177" />
      </node>
      <node role="superclass:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660178">
        <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900660200">
        <property name="name:3" value="doDfs" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900660201" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900660202" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900660203">
          <property name="name:3" value="graph" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660204">
            <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900660205">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900660216">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900660218">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="5213231752900660221">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="5213231752900660223">
                  <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                  <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660225">
                    <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900660226">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900660203" resolveInfo="graph" />
                  </node>
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900660217">
                <link role="variableDeclaration:3" targetNodeId="5213231752900660179" resolveInfo="myComponents" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900660232">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900660234">
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900660233">
                <link role="variableDeclaration:3" targetNodeId="5213231752900660227" resolveInfo="currentComponent" />
              </node>
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="5213231752900660249">
                <property name="value:3" value="-1" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900660207">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.SuperMethodCall:3" id="5213231752900660208">
              <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277333" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900660209">
                <link role="variableDeclaration:3" targetNodeId="5213231752900660203" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="5213231752900660214">
                <link role="enumConstantDeclaration:3" targetNodeId="1.2899723422951324703" resolveInfo="BOTH" />
                <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="5213231752900660206">
          <link role="annotation:3" targetNodeId="4.~Override" />
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900660238">
        <property name="name:3" value="preprocessRoot" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900660239" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="5213231752900660240" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900660241">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900660245">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="5213231752900660247">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900660248">
                <link role="variableDeclaration:3" targetNodeId="5213231752900660227" resolveInfo="myCurrentComponent" />
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="5213231752900660242">
          <link role="annotation:3" targetNodeId="4.~Override" />
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639079613">
          <property name="name:3" value="root" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639079614">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900660250">
        <property name="name:3" value="preprocess" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="5213231752900660251" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="5213231752900660252" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900660253">
          <property name="name:3" value="node" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660254">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900660255">
          <property name="name:3" value="from" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900660256">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900660257">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900660264">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="5213231752900660270">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900660273">
                <link role="variableDeclaration:3" targetNodeId="5213231752900660227" resolveInfo="myCurrentComponent" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="5213231752900660266">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="5213231752900660269">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900660253" resolveInfo="node" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="5213231752900660265">
                  <link role="variableDeclaration:3" targetNodeId="5213231752900660179" resolveInfo="myComponents" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="5213231752900660258">
          <link role="annotation:3" targetNodeId="4.~Override" />
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="5213231752900665221">
        <property name="name:3" value="getComponents" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="5213231752900665222">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900665223">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900665224">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900665225" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900665226">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="5213231752900665227">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="5213231752900665228">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ThisExpression:3" id="5213231752900665229" />
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="5213231752900665230">
                <link role="fieldDeclaration:3" targetNodeId="5213231752900660179" resolveInfo="myComponents" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900660165" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="5213231752900665923">
    <property name="name:3" value="BiconnectAugmentation" />
    <node role="staticInnerClassifiers:3" type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="6074874003310495255">
      <property name="nonStatic:3" value="false" />
      <property name="name:3" value="MyDfs" />
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="6074874003310495256">
        <property name="name:3" value="myLow" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310495257" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="6074874003310495258">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495259">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495260">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="6074874003310495261">
        <property name="name:3" value="myNum" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310495262" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="6074874003310495263">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495264">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495265">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="6074874003310495266">
        <property name="name:3" value="myCurNum" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310495267" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="6074874003310495268" />
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="6074874003310498442">
        <property name="name:3" value="myNewNode" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310498443" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498445">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="6074874003310498474">
        <property name="name:3" value="mySource" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310498475" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498477">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="6074874003310498571">
        <property name="name:3" value="myConnectToNew" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310498572" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="6074874003310498574">
          <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498576">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="6074874003310495269" />
      <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="6074874003310495270">
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="6074874003310495271" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="6074874003310495272" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495273" />
      </node>
      <node role="superclass:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495274">
        <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310495275">
        <property name="name:3" value="doDfs" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="6074874003310498674">
          <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498676">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="6074874003310495277" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495278">
          <property name="name:3" value="graph" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495279">
            <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495280">
          <property name="name:3" value="source" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495281">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495284">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495285">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310495286">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="6074874003310495287">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="6074874003310495288">
                  <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                  <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495289">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495290">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495278" resolveInfo="graph" />
                  </node>
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495291">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495292">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310495293">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="6074874003310495294">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="6074874003310495295">
                  <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                  <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495296">
                    <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495297">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495278" resolveInfo="graph" />
                  </node>
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495298">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498416">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310498418">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="6074874003310498421">
                <property name="value:3" value="0" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498417">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495266" resolveInfo="myCurNum" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498478">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310498480">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498483">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495280" resolveInfo="source" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498479">
                <link role="variableDeclaration:3" targetNodeId="6074874003310498474" resolveInfo="mySource" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498578">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310498580">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="6074874003310498583">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashSetCreator:7" id="6074874003310498585">
                  <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498587">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498579">
                <link role="variableDeclaration:3" targetNodeId="6074874003310498571" resolveInfo="myConnectToNew" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498425">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310498426">
              <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485538" resolveInfo="init" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498427">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495278" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="6074874003310498428">
                <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Direction" />
                <link role="enumConstantDeclaration:3" targetNodeId="1.2899723422951324703" resolveInfo="BOTH" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498433">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310498434">
              <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277371" resolveInfo="dfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498435">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495280" resolveInfo="source" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="6074874003310498437" />
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="6074874003310498678">
            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="6074874003310498679">
              <property name="name:3" value="result" />
              <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="6074874003310498680">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498682">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
              <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="6074874003310498684">
                <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashSetCreator:7" id="6074874003310498686">
                  <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310498688">
                    <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="6074874003310498618">
            <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="6074874003310498619">
              <property name="name:7" value="node" />
            </node>
            <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498622">
              <link role="variableDeclaration:3" targetNodeId="6074874003310498571" resolveInfo="myConnectToNew" />
            </node>
            <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310498621">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498623">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498690">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310498689">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310498679" resolveInfo="result" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation:7" id="6074874003310498694">
                    <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498696">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498697">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310498442" resolveInfo="myNewNode" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310498698">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112323" resolveInfo="addEdgeTo" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="6074874003310498699">
                          <link role="variable:7" targetNodeId="6074874003310498619" resolveInfo="node" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="6074874003310498701">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310498703">
              <link role="variableDeclaration:3" targetNodeId="6074874003310498679" resolveInfo="result" />
            </node>
          </node>
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310495332">
        <property name="name:3" value="preprocess" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="6074874003310495333" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="6074874003310495334" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495335">
          <property name="name:3" value="node" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495336">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495337">
          <property name="name:3" value="from" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495338">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495339">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495340">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310495341">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="6074874003310495342">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495343">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495266" resolveInfo="myCurNum" />
                </node>
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495344">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495345">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495335" resolveInfo="node" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495346">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495347">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310495348">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498422">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495335" resolveInfo="node" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495350">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495351">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495335" resolveInfo="node" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495352">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="6074874003310495353">
          <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310495354">
        <property name="name:3" value="processEdge" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="6074874003310495355" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="6074874003310495356" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495357">
          <property name="name:3" value="edge" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495358">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495359">
          <property name="name:3" value="source" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495360">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495361">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="6074874003310495362">
            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="6074874003310495363">
              <property name="name:3" value="next" />
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495364">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310495365">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495366">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495357" resolveInfo="edge" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310495367">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495368">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495359" resolveInfo="source" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="6074874003310495369">
            <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495370">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495371">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310495372">
                  <link role="baseMethodDeclaration:3" targetNodeId="6074874003310495403" resolveInfo="changeLow" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495373">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495359" resolveInfo="source" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310495374">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495363" resolveInfo="next" />
                  </node>
                </node>
              </node>
            </node>
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="6074874003310495375">
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="6074874003310495376">
                <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
                <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
              </node>
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495377">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310495378">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495363" resolveInfo="next" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310495379">
                  <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277452" resolveInfo="getDfsState" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="6074874003310495380">
          <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310495381">
        <property name="name:3" value="postprocess" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="6074874003310495382" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="6074874003310495383" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495384">
          <property name="name:3" value="node" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495385">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495386">
          <property name="name:3" value="from" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495387">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495388">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="6074874003310498609">
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="6074874003310498613">
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="6074874003310498616" />
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498612">
                <link role="variableDeclaration:3" targetNodeId="6074874003310495386" resolveInfo="from" />
              </node>
            </node>
            <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310498611">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="6074874003310495389">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="6074874003310495390">
                  <property name="name:3" value="prev" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495391">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310495392">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495393">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495386" resolveInfo="from" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310495394">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495395">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310495384" resolveInfo="node" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="6074874003310498510">
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310498511">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="6074874003310498537">
                    <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310498538">
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498546">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310498547">
                          <link role="baseMethodDeclaration:3" targetNodeId="6074874003310498438" resolveInfo="createNewNode" />
                        </node>
                      </node>
                    </node>
                    <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="6074874003310498542">
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="6074874003310498545" />
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498541">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310498442" resolveInfo="myNewNode" />
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498589">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498591">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498590">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310498571" resolveInfo="myConnectToNew" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation:7" id="6074874003310498595">
                        <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498597">
                          <link role="variableDeclaration:3" targetNodeId="6074874003310495384" resolveInfo="node" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498558">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310498567">
                      <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310498560">
                        <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498563">
                          <link role="variableDeclaration:3" targetNodeId="6074874003310495384" resolveInfo="node" />
                        </node>
                        <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498559">
                          <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
                        </node>
                      </node>
                      <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498570">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310498442" resolveInfo="myNewNode" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanOrEqualsExpression:3" id="6074874003310498519">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310498533">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310498564">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498565">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310495384" resolveInfo="node" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498566">
                        <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
                      </node>
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498522">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
                    </node>
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310498515">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310498518">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495390" resolveInfo="prev" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498514">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495396">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310495397">
                  <link role="baseMethodDeclaration:3" targetNodeId="6074874003310495403" resolveInfo="changeLow" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310495398">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495390" resolveInfo="prev" />
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495399">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495400">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495384" resolveInfo="node" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495401">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="6074874003310495402">
          <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310495403">
        <property name="name:3" value="changeLow" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="6074874003310495404" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="6074874003310495405" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495406">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="6074874003310495407">
            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="6074874003310495408">
              <property name="name:3" value="oldLow" />
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495409">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495410">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495411">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495432" resolveInfo="node" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495412">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="6074874003310495413">
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="6074874003310495418">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495419">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="6074874003310495420">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495408" resolveInfo="oldLow" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495421">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
                </node>
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495422">
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495423">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
                </node>
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495424">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495434" resolveInfo="newLow" />
                </node>
              </node>
            </node>
            <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310495425">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310495426">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310495427">
                  <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495428">
                    <link role="variableDeclaration:3" targetNodeId="6074874003310495434" resolveInfo="newLow" />
                  </node>
                  <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310495429">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310495430">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495432" resolveInfo="node" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310495431">
                      <link role="variableDeclaration:3" targetNodeId="6074874003310495256" resolveInfo="myLow" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495432">
          <property name="name:3" value="node" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495433">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="6074874003310495434">
          <property name="name:3" value="newLow" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="6074874003310495435">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="6074874003310498438">
        <property name="name:3" value="createNewNode" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="6074874003310498439" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="6074874003310498440" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="6074874003310498441">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498449">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310498451">
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498450">
                <link role="variableDeclaration:3" targetNodeId="6074874003310498442" resolveInfo="myNewNode" />
              </node>
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498468">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="6074874003310498467">
                  <link role="baseMethodDeclaration:3" targetNodeId="6074874003310498455" resolveInfo="getGraph" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310498472">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112344" resolveInfo="addNode" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498484">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="6074874003310498493">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="6074874003310498496">
                <property name="value:3" value="-1" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="6074874003310498486">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498492">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310498442" resolveInfo="myNewNode" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498485">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310495261" resolveInfo="myNum" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="6074874003310498599">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498601">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498600">
                <link role="variableDeclaration:3" targetNodeId="6074874003310498571" resolveInfo="myConnectToNew" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation:7" id="6074874003310498605">
                <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="6074874003310498607">
                  <link role="variableDeclaration:3" targetNodeId="6074874003310498474" resolveInfo="mySource" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="5213231752900665929">
      <property name="name:3" value="makeBiconnected" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="5213231752900665933">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900665935">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900665931" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="5213231752900665932">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="5213231752900665951">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498708">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="6074874003310498705">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="6074874003310498707">
                <link role="baseMethodDeclaration:3" targetNodeId="6074874003310495270" resolveInfo="BiconnectAugmentation.MyDfs" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310498712">
              <link role="baseMethodDeclaration:3" targetNodeId="6074874003310495275" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498713">
                <link role="variableDeclaration:3" targetNodeId="5213231752900665936" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ListElementAccessExpression:7" id="6074874003310498722">
                <node role="index:7" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="6074874003310498725">
                  <property name="value:3" value="0" />
                </node>
                <node role="list:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="6074874003310498717">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="6074874003310498716">
                    <link role="variableDeclaration:3" targetNodeId="5213231752900665936" resolveInfo="graph" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="6074874003310498721">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="5213231752900665936">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="5213231752900665938">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="529057043639336278">
      <property name="name:3" value="smartMakeBiconnected" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="529057043639336282">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639336285">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="529057043639336280" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639336281">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639337084">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639337085">
            <property name="name:3" value="addedEdges" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="529057043639337086">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337088">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="529057043639337090">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashSetCreator:7" id="529057043639337091">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337092">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639336290">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639336291">
            <property name="name:3" value="root" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639336292">
              <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="529057043639337065">
              <link role="baseMethodDeclaration:3" targetNodeId="4644851485137240287" resolveInfo="createTree" />
              <link role="classConcept:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639337066">
                <link role="variableDeclaration:3" targetNodeId="529057043639336286" resolveInfo="graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639337154">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337155">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639337194">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639337195">
                <property name="name:3" value="toConnect" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="529057043639337196">
                  <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337198">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="529057043639337200">
                  <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit:7" id="529057043639337201">
                    <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337202">
                      <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639337191">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall:3" id="529057043639337192">
                <link role="baseMethodDeclaration:3" targetNodeId="529057043639337073" resolveInfo="collectListNodes" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337203">
                  <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337205">
                  <link role="variableDeclaration:3" targetNodeId="529057043639337195" resolveInfo="toConnect" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="529057043639341233" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639337207">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337208">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639383865">
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383866">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639383884">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383885">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383886">
                          <link role="variableDeclaration:3" targetNodeId="529057043639337195" resolveInfo="toConnect" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation:7" id="529057043639383887">
                          <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383888">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383889">
                              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383893">
                                <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                              </node>
                              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383891">
                                <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246278" resolveInfo="getNodes" />
                              </node>
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="529057043639383892" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="529057043639383880">
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="529057043639383883">
                      <property name="value:3" value="1" />
                    </node>
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383875">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383870">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383869">
                          <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383874">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                        </node>
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="529057043639383879" />
                    </node>
                  </node>
                  <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="529057043639383894">
                    <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383895">
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639383896">
                        <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639383897">
                          <property name="name:3" value="cutpoint" />
                          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639383898">
                            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                          </node>
                          <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383899">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383900">
                              <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383901">
                              <link role="baseMethodDeclaration:3" targetNodeId="529057043639383804" resolveInfo="getCutpoint" />
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383902">
                                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383903">
                                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383904">
                                    <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                                  </node>
                                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383905">
                                    <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                                  </node>
                                </node>
                                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="529057043639383906" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639383907">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383908">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383909">
                            <link role="variableDeclaration:3" targetNodeId="529057043639337195" resolveInfo="toConnect" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation:7" id="529057043639383910">
                            <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383911">
                              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383912">
                                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383916">
                                  <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                                </node>
                                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383914">
                                  <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246278" resolveInfo="getNodes" />
                                </node>
                              </node>
                              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.FindFirstOperation:7" id="529057043639383917">
                                <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="529057043639383918">
                                  <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383919">
                                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639383922">
                                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="529057043639383924">
                                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383927">
                                          <link role="variableDeclaration:3" targetNodeId="529057043639383897" resolveInfo="cutpoint" />
                                        </node>
                                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639383923">
                                          <link role="variableDeclaration:3" targetNodeId="529057043639383920" resolveInfo="it" />
                                        </node>
                                      </node>
                                    </node>
                                  </node>
                                  <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="529057043639383920">
                                    <property name="name:7" value="it" />
                                    <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="529057043639383921" />
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
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="529057043639337217">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="529057043639337220">
                  <property name="value:3" value="1" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337212">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337211">
                    <link role="variableDeclaration:3" targetNodeId="529057043639337195" resolveInfo="toConnect" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="529057043639337216" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639337248">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639337249">
                <property name="name:3" value="prev" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337250">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="529057043639337253" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="529057043639337241">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="529057043639337242">
                <property name="name:7" value="node" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337251">
                <link role="variableDeclaration:3" targetNodeId="529057043639337195" resolveInfo="toConnect" />
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337244">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639337254">
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="529057043639337262">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337263">
                      <link role="variableDeclaration:3" targetNodeId="529057043639337249" resolveInfo="prev" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="529057043639337264" />
                  </node>
                  <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337256">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639337272">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337274">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337273">
                          <link role="variableDeclaration:3" targetNodeId="529057043639337085" resolveInfo="addedEdges" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation:7" id="529057043639337278">
                          <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337281">
                            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337280">
                              <link role="variableDeclaration:3" targetNodeId="529057043639337249" resolveInfo="prev" />
                            </node>
                            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639337285">
                              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112323" resolveInfo="addEdgeTo" />
                              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="529057043639337286">
                                <link role="variable:7" targetNodeId="529057043639337242" resolveInfo="node" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639337266">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="529057043639337268">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="529057043639337271">
                      <link role="variable:7" targetNodeId="529057043639337242" resolveInfo="node" />
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337267">
                      <link role="variableDeclaration:3" targetNodeId="529057043639337249" resolveInfo="prev" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="529057043639337183">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337184">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337185">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337186">
                  <link role="variableDeclaration:3" targetNodeId="529057043639336291" resolveInfo="root" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639337187">
                  <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="529057043639337188" />
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="529057043639337189">
              <property name="value:3" value="0" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="529057043639337068">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639337190">
            <link role="variableDeclaration:3" targetNodeId="529057043639337085" resolveInfo="addedEdges" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639336286">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639336287">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="529057043639337073">
      <property name="name:3" value="collectListNodes" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="529057043639337077" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337076">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639337093">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="529057043639337107">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="529057043639337110">
              <property name="value:3" value="0" />
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337102">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337097">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639337096">
                  <link role="variableDeclaration:3" targetNodeId="529057043639337081" resolveInfo="component" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639337101">
                  <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="529057043639337106" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337095">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.Statement:3" id="529057043639340118" />
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639340119">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639340120">
                <property name="name:3" value="componentNodes" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="529057043639340121">
                  <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639340122">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340123">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340124">
                    <link role="variableDeclaration:3" targetNodeId="529057043639337081" resolveInfo="component" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639340125">
                    <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246278" resolveInfo="getNodes" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639340128">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340129">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639340143">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340144">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340145">
                      <link role="variableDeclaration:3" targetNodeId="529057043639337112" resolveInfo="nodes" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation:7" id="529057043639340146">
                      <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340147">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340148">
                          <link role="variableDeclaration:3" targetNodeId="529057043639340120" resolveInfo="componentNodes" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="529057043639340149" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="529057043639340139">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="529057043639340142">
                  <property name="value:3" value="1" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340134">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340133">
                    <link role="variableDeclaration:3" targetNodeId="529057043639340120" resolveInfo="componentNodes" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="529057043639340138" />
                </node>
              </node>
              <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="529057043639340150">
                <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340151">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639340178">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340180">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340179">
                        <link role="variableDeclaration:3" targetNodeId="529057043639337112" resolveInfo="nodes" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation:7" id="529057043639340184">
                        <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340187">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340186">
                            <link role="variableDeclaration:3" targetNodeId="529057043639340120" resolveInfo="componentNodes" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.FindFirstOperation:7" id="529057043639340191">
                            <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="529057043639340192">
                              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340193">
                                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639340196">
                                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="529057043639340198">
                                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340201">
                                      <link role="variableDeclaration:3" targetNodeId="529057043639340175" resolveInfo="cutpoint" />
                                    </node>
                                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340197">
                                      <link role="variableDeclaration:3" targetNodeId="529057043639340194" resolveInfo="it" />
                                    </node>
                                  </node>
                                </node>
                              </node>
                              <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="529057043639340194">
                                <property name="name:7" value="it" />
                                <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="529057043639340195" />
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
          <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="529057043639337137">
            <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337138">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="529057043639337139">
                <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="529057043639337140">
                  <property name="name:7" value="child" />
                </node>
                <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639337144">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639337143">
                    <link role="variableDeclaration:3" targetNodeId="529057043639337081" resolveInfo="component" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639337148">
                    <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                  </node>
                </node>
                <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639337142">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639337149">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall:3" id="529057043639337150">
                      <link role="baseMethodDeclaration:3" targetNodeId="529057043639337073" resolveInfo="collectListNodes" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="529057043639337151">
                        <link role="variable:7" targetNodeId="529057043639337140" resolveInfo="child" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639337153">
                        <link role="variableDeclaration:3" targetNodeId="529057043639337112" resolveInfo="nodes" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340290">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340289">
                          <link role="variableDeclaration:3" targetNodeId="529057043639337081" resolveInfo="component" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639340294">
                          <link role="baseMethodDeclaration:3" targetNodeId="529057043639340206" resolveInfo="getChildCutpoint" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="529057043639340295">
                            <link role="variable:7" targetNodeId="529057043639337140" resolveInfo="child" />
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
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639337081">
        <property name="name:3" value="component" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337082">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639337112">
        <property name="name:3" value="nodes" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="529057043639337114">
          <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639337116">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639340175">
        <property name="name:3" value="cutpoint" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639340177">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="529057043639337111" />
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="5213231752900665924" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="903391227141019952">
    <property name="name:3" value="WeightedTopologicalNumbering" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="903391227141019962">
      <property name="name:3" value="number" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="903391227141019964" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="903391227141019965">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="903391227141022947">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="903391227141022948">
            <property name="name:3" value="sorting" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="903391227141022949">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141022950">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="903391227141022951">
              <link role="classConcept:3" targetNodeId="5180427534212042655" resolveInfo="TopologicalSorting" />
              <link role="baseMethodDeclaration:3" targetNodeId="5180427534212042776" resolveInfo="sort" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="903391227141022952">
                <link role="variableDeclaration:3" targetNodeId="903391227141019974" resolveInfo="graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="903391227141022953">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="903391227141022954">
            <property name="name:3" value="numbering" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="903391227141022955">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141022956">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141022957">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="903391227141022958">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="903391227141022959">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141022960">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="903391227141022961">
                  <link role="variableDeclaration:3" targetNodeId="903391227141019974" resolveInfo="graph" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="903391227141022962">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="903391227141022963">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="903391227141022964">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="903391227141022965">
              <link role="variableDeclaration:3" targetNodeId="903391227141019974" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="903391227141022966">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="903391227141022967">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="903391227141022968">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="903391227141022969">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="903391227141022970">
                  <property name="value:3" value="0" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="903391227141022971">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="903391227141022972">
                    <link role="variable:7" targetNodeId="903391227141022963" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141022973">
                    <link role="variableDeclaration:3" targetNodeId="903391227141022954" resolveInfo="numbering" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="903391227141022974">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="903391227141022975">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141022976">
            <link role="variableDeclaration:3" targetNodeId="903391227141022948" resolveInfo="sorting" />
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="903391227141022977">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="903391227141022978">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="903391227141022979">
                <property name="name:7" value="edge" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="903391227141022980">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="903391227141022981">
                  <link role="variable:7" targetNodeId="903391227141022975" resolveInfo="node" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="903391227141022982">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821110932" resolveInfo="getOutEdges" />
                </node>
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="903391227141022983">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="903391227141022984">
                  <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="903391227141022985">
                    <property name="name:3" value="target" />
                    <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141022986">
                      <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                    </node>
                    <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="903391227141022987">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="903391227141022988">
                        <link role="variable:7" targetNodeId="903391227141022979" resolveInfo="edge" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="903391227141022989">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="903391227141022990">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="903391227141022991">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="903391227141022992">
                      <link role="classConcept:3" targetNodeId="4.~Math" resolveInfo="Math" />
                      <link role="baseMethodDeclaration:3" targetNodeId="4.~Math.max(int,int):int" resolveInfo="max" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="903391227141022993">
                        <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141022994">
                          <link role="variableDeclaration:3" targetNodeId="903391227141022985" resolveInfo="target" />
                        </node>
                        <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141022995">
                          <link role="variableDeclaration:3" targetNodeId="903391227141022954" resolveInfo="numbering" />
                        </node>
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="903391227141022996">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="903391227141023007">
                          <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="903391227141023010">
                            <link role="variable:7" targetNodeId="903391227141022979" resolveInfo="edge" />
                          </node>
                          <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="903391227141023006">
                            <link role="variableDeclaration:3" targetNodeId="903391227141019976" resolveInfo="weights" />
                          </node>
                        </node>
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="903391227141022998">
                          <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="903391227141022999">
                            <link role="variable:7" targetNodeId="903391227141022975" resolveInfo="node" />
                          </node>
                          <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141023000">
                            <link role="variableDeclaration:3" targetNodeId="903391227141022954" resolveInfo="numbering" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="903391227141023001">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141023002">
                        <link role="variableDeclaration:3" targetNodeId="903391227141022985" resolveInfo="target" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141023003">
                        <link role="variableDeclaration:3" targetNodeId="903391227141022954" resolveInfo="numbering" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="903391227141023004">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="903391227141023005">
            <link role="variableDeclaration:3" targetNodeId="903391227141022954" resolveInfo="numbering" />
          </node>
        </node>
      </node>
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="903391227141019969">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141019972">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141019973">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="903391227141019974">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141019975">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="903391227141019976">
        <property name="name:3" value="weights" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="903391227141019978">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141019981">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141019982">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
      <node role="throwsItem:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="903391227141022940">
        <link role="classifier:3" targetNodeId="4.~IllegalArgumentException" resolveInfo="IllegalArgumentException" />
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="903391227141019953" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="3720762119843889432">
    <property name="name:3" value="BiconnectedComponent" />
    <property name="package:3" value="biconnectedComponents" />
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137244748">
      <property name="name:3" value="addComponent" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137244749" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137244750" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137244751">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244752">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137244753">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244754">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244699" resolveInfo="myChildren" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation:7" id="4644851485137244755">
              <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244756">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244763" resolveInfo="component" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244757">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244758">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244759">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244765" resolveInfo="node" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137244760">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244761">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244763" resolveInfo="component" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244762">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244708" resolveInfo="myCutpoints" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244763">
        <property name="name:3" value="component" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244879">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244765">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244766">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137244767">
      <property name="name:3" value="addComponent" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137244768" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137244769" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137244770">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244771">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137244772">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244773">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244699" resolveInfo="myChildren" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddElementOperation:7" id="4644851485137244774">
              <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244775">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244782" resolveInfo="component" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244776">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244777">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244778">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244784" resolveInfo="edge" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137244779">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244780">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244782" resolveInfo="component" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244781">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244782">
        <property name="name:3" value="component" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244880">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244784">
        <property name="name:3" value="edge" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244785">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137244786">
      <property name="name:3" value="addNode" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137244787" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137244788" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137244789">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244790">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137244791">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244792">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244695" resolveInfo="myNodes" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation:7" id="4644851485137244793">
              <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244794">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244795" resolveInfo="node" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244795">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244796">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137246201">
      <property name="name:3" value="getChildren" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="4644851485137246205">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246207">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137246203" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246204">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137246208">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246210">
            <link role="variableDeclaration:3" targetNodeId="4644851485137244699" resolveInfo="myChildren" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137246278">
      <property name="name:3" value="getNodes" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="4644851485137246282">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246284">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137246280" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246281">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137246285">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246287">
            <link role="variableDeclaration:3" targetNodeId="4644851485137244695" resolveInfo="myNodes" />
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137246288">
      <property name="name:3" value="getConnection" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246292">
        <link role="classifier:3" targetNodeId="4.~Object" resolveInfo="Object" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137246290" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246291">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137246295">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246299">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246298">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation:7" id="4644851485137246303">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246305">
                <link role="variableDeclaration:3" targetNodeId="4644851485137246293" resolveInfo="child" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246297">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137246306">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137246309">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246312">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137246293" resolveInfo="child" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246308">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
                </node>
              </node>
            </node>
          </node>
          <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="4644851485137246313">
            <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246314">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137246315">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137246318">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246321">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137246293" resolveInfo="child" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246317">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137244708" resolveInfo="myCutpoints" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137246293">
        <property name="name:3" value="child" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246294">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="529057043639340206">
      <property name="name:3" value="getChildCutpoint" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639340210">
        <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="529057043639340208" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340209">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639340220">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340221">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="529057043639340222">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation:7" id="529057043639340223">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340224">
                <link role="variableDeclaration:3" targetNodeId="529057043639340211" resolveInfo="child" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340225">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639340271">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639340272">
                <property name="name:3" value="bridge" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639340273">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="529057043639340274">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340275">
                    <link role="variableDeclaration:3" targetNodeId="529057043639340211" resolveInfo="child" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="529057043639340276">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639340238">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639340239">
                <property name="name:3" value="cutpoint" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639340240">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340247">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340277">
                    <link role="variableDeclaration:3" targetNodeId="529057043639340272" resolveInfo="bridge" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639340251">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111981" resolveInfo="getSource" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639340253">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340254">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639340265">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="529057043639340267">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340279">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340278">
                        <link role="variableDeclaration:3" targetNodeId="529057043639340272" resolveInfo="bridge" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639340283">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340266">
                      <link role="variableDeclaration:3" targetNodeId="529057043639340239" resolveInfo="cutpoint" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639340258">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="529057043639340257">
                  <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246278" resolveInfo="getNodes" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsOperation:7" id="529057043639340262">
                  <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340264">
                    <link role="variableDeclaration:3" targetNodeId="529057043639340239" resolveInfo="cutpoint" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="529057043639340285">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639340287">
                <link role="variableDeclaration:3" targetNodeId="529057043639340239" resolveInfo="cutpoint" />
              </node>
            </node>
          </node>
          <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="529057043639340230">
            <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639340231">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="529057043639340232">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="529057043639340233">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639340234">
                    <link role="variableDeclaration:3" targetNodeId="529057043639340211" resolveInfo="child" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="529057043639340235">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137244708" resolveInfo="myCutpoints" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639340211">
        <property name="name:3" value="child" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639340212">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="529057043639383804">
      <property name="name:3" value="getCutpoint" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639383805">
        <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="529057043639383806" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383807">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639383808">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383809">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="529057043639383810">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsKeyOperation:7" id="529057043639383811">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639383812">
                <link role="variableDeclaration:3" targetNodeId="529057043639383846" resolveInfo="child" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383813">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639383814">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639383815">
                <property name="name:3" value="bridge" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639383816">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="529057043639383817">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639383818">
                    <link role="variableDeclaration:3" targetNodeId="529057043639383846" resolveInfo="child" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="529057043639383819">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="529057043639383820">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="529057043639383821">
                <property name="name:3" value="cutpoint" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639383822">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383823">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383824">
                    <link role="variableDeclaration:3" targetNodeId="529057043639383815" resolveInfo="bridge" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383825">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111981" resolveInfo="getSource" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="529057043639383826">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383827">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="529057043639383828">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="529057043639383829">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383830">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383831">
                        <link role="variableDeclaration:3" targetNodeId="529057043639383815" resolveInfo="bridge" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="529057043639383832">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383833">
                      <link role="variableDeclaration:3" targetNodeId="529057043639383821" resolveInfo="cutpoint" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotExpression:3" id="529057043639383848">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="529057043639383849">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="529057043639383850">
                    <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246278" resolveInfo="getNodes" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsOperation:7" id="529057043639383851">
                    <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383852">
                      <link role="variableDeclaration:3" targetNodeId="529057043639383821" resolveInfo="cutpoint" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="529057043639383838">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="529057043639383839">
                <link role="variableDeclaration:3" targetNodeId="529057043639383821" resolveInfo="cutpoint" />
              </node>
            </node>
          </node>
          <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="529057043639383840">
            <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="529057043639383841">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="529057043639383842">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="529057043639383843">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="529057043639383844">
                    <link role="variableDeclaration:3" targetNodeId="529057043639383846" resolveInfo="child" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="529057043639383845">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137244708" resolveInfo="myCutpoints" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="529057043639383846">
        <property name="name:3" value="child" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="529057043639383847">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137246834">
      <property name="name:3" value="toString" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="4644851485137246838" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137246836" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246837">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137246844">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137246845">
            <property name="name:3" value="builder" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246846">
              <link role="classifier:3" targetNodeId="4.~StringBuilder" resolveInfo="StringBuilder" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137246848">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137246849">
                <link role="baseMethodDeclaration:3" targetNodeId="4.~StringBuilder.&lt;init&gt;()" resolveInfo="StringBuilder" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246860">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246862">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246861">
              <link role="variableDeclaration:3" targetNodeId="4644851485137246845" resolveInfo="builder" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246866">
              <link role="baseMethodDeclaration:3" targetNodeId="4.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" resolveInfo="append" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246907">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246879">
                  <property name="value:3" value="\n" />
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246920">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246923">
                    <property name="value:3" value=" children" />
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246911">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246876">
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246872">
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246868">
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246867">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137246839" resolveInfo="prefix" />
                          </node>
                          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246871">
                            <property name="value:3" value=" C: " />
                          </node>
                        </node>
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137246875">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246278" resolveInfo="getNodes" />
                        </node>
                      </node>
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246910">
                        <property name="value:3" value=" has " />
                      </node>
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246915">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137246914">
                        <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="4644851485137246919" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4644851485137246881">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4644851485137246882">
            <property name="name:7" value="child" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137246885">
            <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246884">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246886">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246888">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246887">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137246845" resolveInfo="builder" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246892">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" resolveInfo="append" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246903">
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246906">
                      <property name="value:3" value=":\n" />
                    </node>
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246898">
                      <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246894">
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246893">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137246839" resolveInfo="prefix" />
                        </node>
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246897">
                          <property name="value:3" value=" from " />
                        </node>
                      </node>
                      <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137246901">
                        <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246288" resolveInfo="getConnection" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137246902">
                          <link role="variable:7" targetNodeId="4644851485137246882" resolveInfo="child" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246925">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246927">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246926">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137246845" resolveInfo="builder" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246931">
                  <link role="baseMethodDeclaration:3" targetNodeId="4.~StringBuilder.append(java.lang.String):java.lang.StringBuilder" resolveInfo="append" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246933">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137246932">
                      <link role="variable:7" targetNodeId="4644851485137246882" resolveInfo="child" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246937">
                      <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246834" resolveInfo="toString" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4644851485137246939">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StringLiteral:3" id="4644851485137246942">
                          <property name="value:3" value="  " />
                        </node>
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246938">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137246839" resolveInfo="prefix" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137246851">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246854">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246853">
              <link role="variableDeclaration:3" targetNodeId="4644851485137246845" resolveInfo="builder" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246858">
              <link role="baseMethodDeclaration:3" targetNodeId="4.~StringBuilder.toString():java.lang.String" resolveInfo="toString" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137246839">
        <property name="name:3" value="prefix" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.StringType:3" id="4644851485137246841" />
      </node>
    </node>
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="4644851485137244713">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137244714" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="529057043639336299" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137244716">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244717">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244718">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137244719">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashSetCreator:7" id="4644851485137244720">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244721">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244722">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244695" resolveInfo="myNodes" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244723">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244724">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137244725">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit:7" id="4644851485137244726">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244876">
                  <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244728">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244699" resolveInfo="myChildren" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244729">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244730">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137244731">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashMapCreator:7" id="4644851485137244732">
                <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244877">
                  <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
                </node>
                <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244734">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244735">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244703" resolveInfo="myBridges" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244736">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244737">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137244738">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashMapCreator:7" id="4644851485137244739">
                <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244878">
                  <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
                </node>
                <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244741">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244742">
              <link role="variableDeclaration:3" targetNodeId="4644851485137244708" resolveInfo="myCutpoints" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4644851485137244695">
      <property name="name:3" value="myNodes" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244696" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="4644851485137244697">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244698">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4644851485137244699">
      <property name="name:3" value="myChildren" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244700" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="4644851485137244701">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244837">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4644851485137244703">
      <property name="name:3" value="myBridges" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244704" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137244705">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244848">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244707">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4644851485137244708">
      <property name="name:3" value="myCutpoints" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244709" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137244710">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244862">
          <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244712">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="staticInnerClassifiers:3" type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="4644851485137244688">
      <property name="nonStatic:3" value="false" />
      <property name="name:3" value="TreeMaker" />
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137250766">
        <property name="name:3" value="doDfs" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137250767" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137250768" />
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137250769">
          <property name="name:3" value="graph" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137250770">
            <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137250786">
          <property name="name:3" value="component" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137250788">
            <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
          </node>
        </node>
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137250771">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137250777">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137250778">
              <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485538" resolveInfo="init" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137250779">
                <link role="variableDeclaration:3" targetNodeId="4644851485137250769" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4644851485137250782">
                <link role="enumConstantDeclaration:3" targetNodeId="1.2899723422951324703" resolveInfo="BOTH" />
                <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137250784">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137250785">
              <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244881" resolveInfo="dfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137250801">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137250796">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137250789">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137250769" resolveInfo="graph" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137250800">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="4644851485137250805" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4644851485137250807" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137250809">
                <link role="variableDeclaration:3" targetNodeId="4644851485137250786" resolveInfo="component" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137244881">
        <property name="name:3" value="dfs" />
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137244882" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137250761" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137244884">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137245016">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137245024">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="4644851485137245030">
                <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137245020">
                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137245023">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                </node>
                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137245019">
                  <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137245997">
            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137245998">
              <property name="name:3" value="nextComponent" />
              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137245999">
                <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
              </node>
              <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246000">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244887" resolveInfo="component" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137246097">
            <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4644851485137246101">
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4644851485137246104" />
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246100">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244994" resolveInfo="from" />
              </node>
            </node>
            <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246099">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137246002">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137246003">
                  <property name="name:3" value="lowNum" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4644851485137246004" />
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137246005">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137246006">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246007">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246008">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137244903" resolveInfo="myLow" />
                      </node>
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246009">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137244911" resolveInfo="myNum" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137246062">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137246063">
                  <property name="name:3" value="source" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246064">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246065">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246066">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137244994" resolveInfo="from" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246067">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246068">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137246011">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137246012">
                  <property name="name:3" value="sourceNum" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4644851485137246013" />
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137246017">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246069">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137246063" resolveInfo="source" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246016">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137244911" resolveInfo="myNum" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137245116">
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137245117">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137245129">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137245131">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137245130">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137244887" resolveInfo="component" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137245135">
                        <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244786" resolveInfo="addNode" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137245136">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="4644851485137245975">
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137245976">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137246003" resolveInfo="lowNum" />
                  </node>
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246026">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137246012" resolveInfo="sourceNum" />
                  </node>
                </node>
                <node role="elsifClauses:3" type="jetbrains.mps.baseLanguage.structure.ElsifClause:3" id="4644851485137245982">
                  <node role="statementList:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137245984">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246029">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137246031">
                        <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137246034">
                          <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137246036">
                            <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244713" resolveInfo="BiconnectedComponent" />
                          </node>
                        </node>
                        <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246030">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246048">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246057">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246056">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246061">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244786" resolveInfo="addNode" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246070">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137246063" resolveInfo="source" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137251363">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137251364">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251365">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137251366">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244786" resolveInfo="addNode" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137251368">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246038">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246040">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246039">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137244887" resolveInfo="component" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246044">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244748" resolveInfo="addComponent" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246045">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                          </node>
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246072">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137246063" resolveInfo="source" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4644851485137245990">
                    <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137245991">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137246003" resolveInfo="lowNum" />
                    </node>
                    <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246028">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137246012" resolveInfo="sourceNum" />
                    </node>
                  </node>
                </node>
                <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="4644851485137246073">
                  <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246074">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246075">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137246076">
                        <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137246077">
                          <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137246078">
                            <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244713" resolveInfo="BiconnectedComponent" />
                          </node>
                        </node>
                        <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246079">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246088">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246089">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246090">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246091">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244786" resolveInfo="addNode" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246093">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246081">
                      <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246082">
                        <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246083">
                          <link role="variableDeclaration:3" targetNodeId="4644851485137244887" resolveInfo="component" />
                        </node>
                        <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246084">
                          <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244767" resolveInfo="addComponent" />
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246085">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                          </node>
                          <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246094">
                            <link role="variableDeclaration:3" targetNodeId="4644851485137244994" resolveInfo="from" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="4644851485137246105">
              <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246106">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246107">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246109">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246108">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137244887" resolveInfo="component" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246113">
                      <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244786" resolveInfo="addNode" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246114">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4644851485137246158">
            <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4644851485137246159">
              <property name="name:7" value="edge" />
            </node>
            <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246160">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246161">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246162">
                <link role="baseMethodDeclaration:3" targetNodeId="1.1327612371813210994" resolveInfo="getEdges" />
              </node>
            </node>
            <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246163">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137246164">
                <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137246165">
                  <property name="name:3" value="next" />
                  <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137246166">
                    <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                  </node>
                  <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246167">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137246168">
                      <link role="variable:7" targetNodeId="4644851485137246159" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246169">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137246170">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137244885" resolveInfo="node" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137246171">
                <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4644851485137246172">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="4644851485137246183">
                    <link role="variableDeclaration:3" targetNodeId="4519409331094618576" resolveInfo="BEFORE" />
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4644851485137246174">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246175">
                      <link role="variableDeclaration:3" targetNodeId="4644851485137246165" resolveInfo="next" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137246176">
                      <link role="variableDeclaration:3" targetNodeId="4660430665333277292" resolveInfo="myDfsState" />
                    </node>
                  </node>
                </node>
                <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137246177">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246178">
                    <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137246179">
                      <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244881" resolveInfo="dfs" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246180">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137246165" resolveInfo="next" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4644851485137246181">
                        <link role="variable:7" targetNodeId="4644851485137246159" resolveInfo="edge" />
                      </node>
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246182">
                        <link role="variableDeclaration:3" targetNodeId="4644851485137245998" resolveInfo="nextComponent" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244885">
          <property name="name:3" value="node" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244886">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244994">
          <property name="name:3" value="from" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244996">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244887">
          <property name="name:3" value="component" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244889">
            <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
          </node>
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244689" />
      <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="4644851485137244690">
        <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137244691" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137244692" />
        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137244693">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244939">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244941">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244944">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244919" resolveInfo="low" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244940">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244903" resolveInfo="myLow" />
              </node>
            </node>
          </node>
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137244947">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137244949">
              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137244952">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244925" resolveInfo="num" />
              </node>
              <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137244948">
                <link role="variableDeclaration:3" targetNodeId="4644851485137244911" resolveInfo="myNum" />
              </node>
            </node>
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244919">
          <property name="name:3" value="low" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137244920">
            <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244923">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244924">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
          </node>
        </node>
        <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137244925">
          <property name="name:3" value="num" />
          <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137244927">
            <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244930">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244931">
              <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
            </node>
          </node>
        </node>
      </node>
      <node role="superclass:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244694">
        <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4644851485137244903">
        <property name="name:3" value="myLow" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244904" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137244906">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244909">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244910">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
        </node>
      </node>
      <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4644851485137244911">
        <property name="name:3" value="myNum" />
        <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4644851485137244912" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4644851485137244914">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244917">
            <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137244918">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
    </node>
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="4644851485137240287">
      <property name="name:3" value="createTree" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137240289" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137240290">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137240832">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137240833">
            <property name="name:3" value="tree" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240834">
              <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponentsTree" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137240836">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137240837">
                <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244713" resolveInfo="BiconnectedComponent" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137240297">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137240298">
            <property name="name:3" value="components" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240299">
              <link role="classifier:3" targetNodeId="3720762119843889438" resolveInfo="BiconnectedComponents" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137240301">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137240302">
                <link role="baseMethodDeclaration:3" targetNodeId="3720762119843889440" resolveInfo="BiconnectedComponents" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137240308">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137240310">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137240309">
              <link role="variableDeclaration:3" targetNodeId="4644851485137240298" resolveInfo="components" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137240314">
              <link role="baseMethodDeclaration:3" targetNodeId="4644851485137240395" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137240315">
                <link role="variableDeclaration:3" targetNodeId="4644851485137240293" resolveInfo="graph" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137246241">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137250810">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137246242">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137246244">
                <link role="baseMethodDeclaration:3" targetNodeId="4644851485137244690" resolveInfo="BiconnectedComponent.TreeMaker" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246246">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246245">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137240298" resolveInfo="components" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246250">
                    <link role="baseMethodDeclaration:3" targetNodeId="3720762119843890076" resolveInfo="getLow" />
                  </node>
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137246253">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137246252">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137240298" resolveInfo="components" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137246257">
                    <link role="baseMethodDeclaration:3" targetNodeId="3720762119843890086" resolveInfo="getNum" />
                  </node>
                </node>
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137250814">
              <link role="baseMethodDeclaration:3" targetNodeId="4644851485137250766" resolveInfo="doDfs" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137250815">
                <link role="variableDeclaration:3" targetNodeId="4644851485137240293" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137250817">
                <link role="variableDeclaration:3" targetNodeId="4644851485137240833" resolveInfo="tree" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4644851485137251894">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4644851485137251895">
            <property name="name:3" value="treeCandidate" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137251896">
              <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponent" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137251904">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137251899">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251898">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137240833" resolveInfo="tree" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137251903">
                  <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="4644851485137251908" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137251853">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137251854">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137251872">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137251874">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251920">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137251895" resolveInfo="treeCandidate" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251873">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137240833" resolveInfo="tree" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="4644851485137251887">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.InstanceOfExpression:3" id="4644851485137251915">
              <node role="classType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137251918">
                <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
              </node>
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137251909">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251890">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137240833" resolveInfo="tree" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137251913">
                  <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246288" resolveInfo="getConnection" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251914">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137251895" resolveInfo="treeCandidate" />
                  </node>
                </node>
              </node>
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4644851485137251868">
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137251863">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137251858">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137251857">
                    <link role="variableDeclaration:3" targetNodeId="4644851485137240833" resolveInfo="tree" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137251862">
                    <link role="baseMethodDeclaration:3" targetNodeId="4644851485137246201" resolveInfo="getChildren" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetSizeOperation:7" id="4644851485137251867" />
              </node>
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4644851485137251871">
                <property name="value:3" value="1" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4644851485137240304">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4644851485137240838">
            <link role="variableDeclaration:3" targetNodeId="4644851485137240833" resolveInfo="tree" />
          </node>
        </node>
      </node>
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240291">
        <link role="classifier:3" targetNodeId="3720762119843889432" resolveInfo="BiconnectedComponentsTree" />
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137240293">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240294">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3720762119843889433" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="3720762119843889438">
    <property name="name:3" value="BiconnectedComponents" />
    <property name="package:3" value="biconnectedComponents" />
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4644851485137240395">
      <property name="name:3" value="doDfs" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4644851485137240396" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4644851485137240397" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4644851485137240398">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240399">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137240400">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137240401">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137240402">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137240403">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137240404">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240405">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137240406">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137240398" resolveInfo="graph" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137240407">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137240408">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137240409">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4644851485137240410">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4644851485137240411">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4644851485137240412">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137240413">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137240398" resolveInfo="graph" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137240414">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137240415">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137240416">
            <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485538" resolveInfo="init" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137240417">
              <link role="variableDeclaration:3" targetNodeId="4644851485137240398" resolveInfo="graph" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4644851485137240418">
              <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Direction" />
              <link role="enumConstantDeclaration:3" targetNodeId="1.2899723422951324703" resolveInfo="BOTH" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137240419">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4644851485137240420">
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4644851485137240421">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889900" resolveInfo="myCurNum" />
            </node>
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4644851485137240422">
              <property name="value:3" value="0" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4644851485137240423">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4644851485137240424">
            <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277371" resolveInfo="dfs" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137240425">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4644851485137240426">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137240427">
                  <link role="variableDeclaration:3" targetNodeId="4644851485137240398" resolveInfo="graph" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4644851485137240428">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.GetFirstOperation:7" id="4644851485137240429" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4644851485137240430" />
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="4644851485137240431">
        <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843889906">
      <property name="name:3" value="doDfs" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3720762119843889907" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3720762119843889908" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843889909">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889910">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843889911">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889912">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843889913">
        <property name="name:3" value="stEdge" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889914">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843889915">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889916">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889917">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="3720762119843889918">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="3720762119843889919">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889920">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889921">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843889909" resolveInfo="graph" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889922">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889923">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889924">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="3720762119843889925">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="3720762119843889926">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889927">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889928">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843889909" resolveInfo="graph" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889929">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889930">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3720762119843889931">
            <link role="baseMethodDeclaration:3" targetNodeId="1654665216152485538" resolveInfo="init" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889932">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889909" resolveInfo="graph" />
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="3720762119843889933">
              <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Direction" />
              <link role="enumConstantDeclaration:3" targetNodeId="1.2899723422951324703" resolveInfo="BOTH" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889934">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889935">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="3720762119843889963">
              <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843889937">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889938">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889911" resolveInfo="source" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3720762119843889939">
                <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277452" resolveInfo="getDfsState" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889940">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889941">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889942">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889911" resolveInfo="source" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843889943">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889944">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889911" resolveInfo="source" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889945">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889946">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889947">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="3720762119843889948">
              <property name="value:3" value="0" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843889949">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889950">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889911" resolveInfo="source" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889951">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889952">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889953">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="3720762119843889954">
              <property name="value:3" value="1" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889955">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889900" resolveInfo="myCurNum" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889956">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3720762119843889957">
            <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277371" resolveInfo="dfs" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3720762119843889958">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889959">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889913" resolveInfo="stEdge" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3720762119843889960">
                <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889961">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843889911" resolveInfo="source" />
                </node>
              </node>
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889962">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889913" resolveInfo="stEdge" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843889975">
      <property name="name:3" value="preprocess" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3720762119843889976" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="3720762119843889977" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843889978">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889979">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843889980">
        <property name="name:3" value="from" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889981">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843889982">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889983">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889984">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="3720762119843889985">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889986">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889900" resolveInfo="myCurNum" />
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843889987">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889988">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889978" resolveInfo="node" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889989">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843889990">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843889991">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889992">
              <link role="variableDeclaration:3" targetNodeId="3720762119843889978" resolveInfo="node" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843889993">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843889994">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889978" resolveInfo="node" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843889995">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="3720762119843889996">
        <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843889997">
      <property name="name:3" value="processEdge" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3720762119843889998" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="3720762119843889999" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843890000">
        <property name="name:3" value="edge" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890001">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843890002">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890003">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890004">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="3720762119843890005">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="3720762119843890006">
            <property name="name:3" value="next" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890007">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3720762119843890008">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890009">
                <link role="variableDeclaration:3" targetNodeId="3720762119843890000" resolveInfo="edge" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3720762119843890010">
                <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890011">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843890002" resolveInfo="source" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="3720762119843890012">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890013">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843890014">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3720762119843890015">
                <link role="baseMethodDeclaration:3" targetNodeId="3720762119843890047" resolveInfo="changeLow" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890016">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843890002" resolveInfo="source" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3720762119843890017">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843890006" resolveInfo="next" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="3720762119843890018">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalStaticFieldReference:3" id="3720762119843890024">
              <link role="variableDeclaration:3" targetNodeId="4519409331094618582" resolveInfo="DURING" />
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843890020">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3720762119843890021">
                <link role="variableDeclaration:3" targetNodeId="3720762119843890006" resolveInfo="next" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3720762119843890022">
                <link role="baseMethodDeclaration:3" targetNodeId="4660430665333277452" resolveInfo="getDfsState" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="3720762119843890023">
        <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843890025">
      <property name="name:3" value="postprocess" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3720762119843890026" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.ProtectedVisibility:3" id="3720762119843890027" />
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843890028">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890029">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843890030">
        <property name="name:3" value="from" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890031">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890032">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4644851485137250270">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4644851485137250274">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4644851485137250277" />
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4644851485137250273">
              <link role="variableDeclaration:3" targetNodeId="3720762119843890030" resolveInfo="from" />
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4644851485137250272">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="3720762119843890033">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="3720762119843890034">
                <property name="name:3" value="prev" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890035">
                  <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3720762119843890036">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890037">
                    <link role="variableDeclaration:3" targetNodeId="3720762119843890030" resolveInfo="from" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="3720762119843890038">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890039">
                      <link role="variableDeclaration:3" targetNodeId="3720762119843890028" resolveInfo="node" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843890040">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="3720762119843890041">
                <link role="baseMethodDeclaration:3" targetNodeId="3720762119843890047" resolveInfo="changeLow" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3720762119843890042">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843890034" resolveInfo="prev" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843890043">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890044">
                    <link role="variableDeclaration:3" targetNodeId="3720762119843890028" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843890045">
                    <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="annotation:3" type="jetbrains.mps.baseLanguage.structure.AnnotationInstance:3" id="3720762119843890046">
        <link role="annotation:3" targetNodeId="4.~Override" resolveInfo="Override" />
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843890047">
      <property name="name:3" value="changeLow" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3720762119843890048" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="3720762119843890049" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890050">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="3720762119843890051">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="3720762119843890052">
            <property name="name:3" value="oldLow" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890053">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843890054">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890055">
                <link role="variableDeclaration:3" targetNodeId="3720762119843890072" resolveInfo="node" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843890056">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="3720762119843890057">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="3720762119843890058">
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843890059">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="3720762119843890060">
                <link role="variableDeclaration:3" targetNodeId="3720762119843890052" resolveInfo="oldLow" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843890061">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
              </node>
            </node>
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843890062">
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843890063">
                <link role="variableDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
              </node>
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890064">
                <link role="variableDeclaration:3" targetNodeId="3720762119843890074" resolveInfo="newLow" />
              </node>
            </node>
          </node>
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890065">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843890066">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="3720762119843890067">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890068">
                  <link role="variableDeclaration:3" targetNodeId="3720762119843890074" resolveInfo="newLow" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="3720762119843890069">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="3720762119843890070">
                    <link role="variableDeclaration:3" targetNodeId="3720762119843890072" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="3720762119843890071">
                    <link role="variableDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843890072">
        <property name="name:3" value="node" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890073">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="3720762119843890074">
        <property name="name:3" value="newLow" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890075">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843890076">
      <property name="name:3" value="getLow" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="3720762119843890077">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890078">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890079">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3720762119843890080" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890081">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843890082">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3720762119843890083">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ThisExpression:3" id="3720762119843890084" />
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="3720762119843890085">
              <link role="fieldDeclaration:3" targetNodeId="3720762119843889890" resolveInfo="myLow" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="3720762119843890086">
      <property name="name:3" value="getNum" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="3720762119843890087">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890088">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843890089">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3720762119843890090" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843890091">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3720762119843890092">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3720762119843890093">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ThisExpression:3" id="3720762119843890094" />
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.FieldReferenceOperation:3" id="3720762119843890095">
              <link role="fieldDeclaration:3" targetNodeId="3720762119843889895" resolveInfo="myNum" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="3720762119843889890">
      <property name="name:3" value="myLow" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="3720762119843889891" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="3720762119843889892">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889893">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889894">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="3720762119843889895">
      <property name="name:3" value="myNum" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="3720762119843889896" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="3720762119843889897">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889898">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889899">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="3720762119843889900">
      <property name="name:3" value="myCurNum" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="3720762119843889901" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="3720762119843889902" />
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3720762119843889439" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="3720762119843889440">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="3720762119843889441" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="3720762119843889442" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3720762119843889443" />
    </node>
    <node role="superclass:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="3720762119843889692">
      <link role="classifier:3" targetNodeId="4660430665333277271" resolveInfo="Dfs" />
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="4250605017401923979">
    <property name="name:3" value="FordBellman" />
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4250605017401924033">
      <property name="name:3" value="doAlgorithm" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4250605017401924034" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4250605017401924334" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924036">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924129">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4250605017401924130">
            <link role="baseMethodDeclaration:3" targetNodeId="4250605017401924062" resolveInfo="init" />
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ForStatement:3" id="4250605017401924132">
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924133">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4250605017401928107">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4250605017401928108">
                <property name="name:7" value="node" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928112">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928111">
                  <link role="variableDeclaration:3" targetNodeId="4250605017401923997" resolveInfo="myGraph" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4250605017401928116">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
                </node>
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401928110">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4250605017401928117">
                  <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4250605017401928118">
                    <property name="name:7" value="edge" />
                  </node>
                  <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928177">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928171">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928170">
                        <link role="variable:7" targetNodeId="4250605017401928108" resolveInfo="node" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4250605017401928175">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.190081711777510145" resolveInfo="getEdges" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401928176">
                          <link role="variableDeclaration:3" targetNodeId="4250605017401928043" resolveInfo="direction" />
                        </node>
                      </node>
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.WhereOperation:7" id="4250605017401928181">
                      <node role="closure:7" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="4250605017401928182">
                        <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401928183">
                          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401928186">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928188">
                              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401928187">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401924335" resolveInfo="edgeFilter" />
                              </node>
                              <node role="operation:3" type="jetbrains.mps.baseLanguage.closures.structure.InvokeFunctionOperation:3" id="4250605017401928192">
                                <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401928193">
                                  <link role="variableDeclaration:3" targetNodeId="4250605017401928184" resolveInfo="it" />
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="parameter:3" type="jetbrains.mps.baseLanguage.collections.structure.SmartClosureParameterDeclaration:7" id="4250605017401928184">
                          <property name="name:7" value="it" />
                          <node role="type:7" type="jetbrains.mps.baseLanguage.structure.WildCardType:3" id="4250605017401928185" />
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401928120">
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4250605017401928121">
                      <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401928122">
                        <property name="name:3" value="target" />
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401928123">
                          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
                        </node>
                        <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928124">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928125">
                            <link role="variable:7" targetNodeId="4250605017401928118" resolveInfo="edge" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4250605017401928196">
                            <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928198">
                              <link role="variable:7" targetNodeId="4250605017401928108" resolveInfo="node" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4250605017401928127">
                      <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401928128">
                        <property name="name:3" value="sourceDist" />
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4250605017401928129" />
                        <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928130">
                          <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928200">
                            <link role="variable:7" targetNodeId="4250605017401928108" resolveInfo="node" />
                          </node>
                          <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928134">
                            <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4250605017401928135">
                      <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401928136">
                        <property name="name:3" value="targetDist" />
                        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4250605017401928137" />
                        <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928138">
                          <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928139">
                            <link role="variableDeclaration:3" targetNodeId="4250605017401928122" resolveInfo="target" />
                          </node>
                          <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928140">
                            <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4250605017401928141">
                      <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401928142">
                        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401928143">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401928144">
                            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928145">
                              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928146">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401928122" resolveInfo="target" />
                              </node>
                              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928147">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
                              </node>
                            </node>
                            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4250605017401928148">
                              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928149">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401928128" resolveInfo="sourceDist" />
                              </node>
                              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928150">
                                <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928151">
                                  <link role="variable:7" targetNodeId="4250605017401928118" resolveInfo="edge" />
                                </node>
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928152">
                                  <link role="variableDeclaration:3" targetNodeId="4250605017401924005" resolveInfo="myWeights" />
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401928153">
                          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401928154">
                            <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928155">
                              <link role="variable:7" targetNodeId="4250605017401928118" resolveInfo="edge" />
                            </node>
                            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928156">
                              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928157">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401928122" resolveInfo="target" />
                              </node>
                              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928158">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401924041" resolveInfo="myPrev" />
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.AndExpression:3" id="4250605017401928159">
                        <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="4250605017401928160">
                          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928161">
                            <link role="variableDeclaration:3" targetNodeId="4250605017401928136" resolveInfo="targetDist" />
                          </node>
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="4250605017401928162">
                            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928163">
                              <link role="variableDeclaration:3" targetNodeId="4250605017401928128" resolveInfo="sourceDist" />
                            </node>
                            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928164">
                              <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401928165">
                                <link role="variable:7" targetNodeId="4250605017401928118" resolveInfo="edge" />
                              </node>
                              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928166">
                                <link role="variableDeclaration:3" targetNodeId="4250605017401924005" resolveInfo="myWeights" />
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="4250605017401928167">
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928168">
                            <link role="variableDeclaration:3" targetNodeId="4250605017401928128" resolveInfo="sourceDist" />
                          </node>
                          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4250605017401928169">
                            <link role="classifier:3" targetNodeId="4179389957059009260" resolveInfo="ShortestPath" />
                            <link role="variableDeclaration:3" targetNodeId="4250605017401923948" resolveInfo="INF" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="variable:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401924135">
            <property name="name:3" value="iter" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="4250605017401924136" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4250605017401924138">
              <property name="value:3" value="0" />
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="4250605017401924140">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.MinusExpression:3" id="4250605017401924149">
              <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4250605017401924152">
                <property name="value:3" value="1" />
              </node>
              <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401924144">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924143">
                  <link role="variableDeclaration:3" targetNodeId="4250605017401923997" resolveInfo="myGraph" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4250605017401924148">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112214" resolveInfo="getNumNodes" />
                </node>
              </node>
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401924139">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924135" resolveInfo="iter" />
            </node>
          </node>
          <node role="iteration:3" type="jetbrains.mps.baseLanguage.structure.PostfixIncrementExpression:3" id="4250605017401924154">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401924155">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924135" resolveInfo="iter" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401924335">
        <property name="name:3" value="edgeFilter" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.closures.structure.FunctionType:3" id="4250605017401924339">
          <node role="resultType:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="4250605017401924342" />
          <node role="parameterType:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924341">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401928043">
        <property name="name:3" value="direction" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401928046">
          <link role="classifier:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4250605017401932554">
      <property name="name:3" value="doAlgorithm" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4250605017401932555" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4250605017401932556" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401932557">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401932558">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall:3" id="4250605017401932559">
            <link role="baseMethodDeclaration:3" targetNodeId="4250605017401924033" resolveInfo="doAlgorithm" />
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="4250605017401932560">
              <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401932561">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401932564">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="4250605017401932565">
                    <property name="value:3" value="true" />
                  </node>
                </node>
              </node>
              <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401932562">
                <property name="name:3" value="edge" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401932563">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="4250605017401932569">
              <link role="enumConstantDeclaration:3" targetNodeId="1.190081711777509663" resolveInfo="FRONT" />
              <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4250605017401924062">
      <property name="name:3" value="init" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4250605017401924063" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4250605017401924066" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924065">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924067">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924069">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4250605017401924072">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4250605017401924074">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924075">
                  <link role="variableDeclaration:3" targetNodeId="4250605017401923997" resolveInfo="myGraph" />
                </node>
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924077">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924068">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924041" resolveInfo="myPrev" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924079">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924081">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4250605017401924084">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="4250605017401924086">
                <link role="baseMethodDeclaration:3" targetNodeId="2.5180427534211916791" resolveInfo="NodeMap" />
                <node role="typeParameter:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924089">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
                <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924091">
                  <link role="variableDeclaration:3" targetNodeId="4250605017401923997" resolveInfo="myGraph" />
                </node>
              </node>
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924092">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="4250605017401924094">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="4250605017401924095">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401924099">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924098">
              <link role="variableDeclaration:3" targetNodeId="4250605017401923997" resolveInfo="myGraph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4250605017401924103">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924097">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924104">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924110">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4250605017401924113">
                  <link role="classifier:3" targetNodeId="4179389957059009260" resolveInfo="ShortestPath" />
                  <link role="variableDeclaration:3" targetNodeId="4250605017401923948" resolveInfo="INF" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401924106">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="4250605017401924109">
                    <link role="variable:7" targetNodeId="4250605017401924095" resolveInfo="node" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924105">
                    <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924115">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924121">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="4250605017401924124">
              <property name="value:3" value="0" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401924117">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924120">
                <link role="variableDeclaration:3" targetNodeId="4250605017401924001" resolveInfo="mySource" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924116">
                <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="method:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodDeclaration:3" id="4250605017401924285">
      <property name="name:3" value="getShortestPath" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4250605017401924287" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924288">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4250605017401924298">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401924299">
            <property name="name:3" value="path" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="4250605017401924300">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924302">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="4250605017401924304">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.LinkedListCreator:7" id="4250605017401924305">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924306">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="4250605017401924363">
          <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924364">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4250605017401927983">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="4250605017401927985" />
            </node>
          </node>
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="4250605017401927975">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="4250605017401927978">
              <link role="classifier:3" targetNodeId="4179389957059009260" resolveInfo="ShortestPath" />
              <link role="variableDeclaration:3" targetNodeId="4250605017401923948" resolveInfo="INF" />
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401924368">
              <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401924371">
                <link role="variableDeclaration:3" targetNodeId="4250605017401924296" resolveInfo="target" />
              </node>
              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924367">
                <link role="variableDeclaration:3" targetNodeId="4250605017401924054" resolveInfo="myDist" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4250605017401927989">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401927990">
            <property name="name:3" value="cur" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401927991">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401927993">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924296" resolveInfo="target" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.WhileStatement:3" id="4250605017401924312">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="4250605017401927995">
            <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401927998">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924001" resolveInfo="mySource" />
            </node>
            <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401927994">
              <link role="variableDeclaration:3" targetNodeId="4250605017401927990" resolveInfo="cur" />
            </node>
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401924314">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="4250605017401928008">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="4250605017401928009">
                <property name="name:3" value="prev" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401928010">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="4250605017401928013">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928016">
                    <link role="variableDeclaration:3" targetNodeId="4250605017401927990" resolveInfo="cur" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401928012">
                    <link role="variableDeclaration:3" targetNodeId="4250605017401924041" resolveInfo="myPrev" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401928018">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928020">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928019">
                  <link role="variableDeclaration:3" targetNodeId="4250605017401924299" resolveInfo="path" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddFirstElementOperation:7" id="4250605017401928024">
                  <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928026">
                    <link role="variableDeclaration:3" targetNodeId="4250605017401928009" resolveInfo="prev" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401928028">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401928030">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="4250605017401928034">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928033">
                    <link role="variableDeclaration:3" targetNodeId="4250605017401928009" resolveInfo="prev" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="4250605017401928038">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.1646208389854254579" resolveInfo="getOpposite" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928201">
                      <link role="variableDeclaration:3" targetNodeId="4250605017401927990" resolveInfo="cur" />
                    </node>
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401928029">
                  <link role="variableDeclaration:3" targetNodeId="4250605017401927990" resolveInfo="cur" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="4250605017401924308">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="4250605017401924310">
            <link role="variableDeclaration:3" targetNodeId="4250605017401924299" resolveInfo="path" />
          </node>
        </node>
      </node>
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="4250605017401924293">
        <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924295">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401924296">
        <property name="name:3" value="target" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924297">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4250605017401923997">
      <property name="name:3" value="myGraph" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4250605017401923998" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924000">
        <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4250605017401924001">
      <property name="name:3" value="mySource" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4250605017401924002" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924004">
        <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4250605017401924005">
      <property name="name:3" value="myWeights" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4250605017401924006" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4250605017401924008">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924011">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924012">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4250605017401924041">
      <property name="name:3" value="myPrev" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4250605017401924042" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4250605017401924048">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924052">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924053">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
      </node>
    </node>
    <node role="field:3" type="jetbrains.mps.baseLanguage.structure.FieldDeclaration:3" id="4250605017401924054">
      <property name="name:3" value="myDist" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PrivateVisibility:3" id="4250605017401924055" />
      <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4250605017401924057">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924060">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401924061">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4250605017401923980" />
    <node role="constructor:3" type="jetbrains.mps.baseLanguage.structure.ConstructorDeclaration:3" id="4250605017401923981">
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.structure.VoidType:3" id="4250605017401923982" />
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="4250605017401923983" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="4250605017401923984">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924013">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924015">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401924018">
              <link role="variableDeclaration:3" targetNodeId="4250605017401923985" resolveInfo="graph" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924014">
              <link role="variableDeclaration:3" targetNodeId="4250605017401923997" resolveInfo="myGraph" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924020">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924022">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401924025">
              <link role="variableDeclaration:3" targetNodeId="4250605017401923987" resolveInfo="source" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924021">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924001" resolveInfo="mySource" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="4250605017401924027">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="4250605017401924029">
            <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="4250605017401924032">
              <link role="variableDeclaration:3" targetNodeId="4250605017401923990" resolveInfo="weights" />
            </node>
            <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalInstanceFieldReference:3" id="4250605017401924028">
              <link role="variableDeclaration:3" targetNodeId="4250605017401924005" resolveInfo="myWeights" />
            </node>
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401923985">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401923986">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401923987">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401923989">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="4250605017401923990">
        <property name="name:3" value="weights" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="4250605017401923992">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401923995">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="4250605017401923996">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="7144400041334857035">
    <property name="name:3" value="MinCostMaxFlow" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="7144400041334857041">
      <property name="name:3" value="getFlow" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="7144400041334857045">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857048">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857049">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7144400041334857043" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334857044">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334857072">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334857073">
            <property name="name:3" value="flow" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="7144400041334857074">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857077">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857078">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7144400041334857080">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashMapCreator:7" id="7144400041334857081">
                <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857082">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857083">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334857085">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334857086">
            <property name="name:3" value="opposite" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="7144400041334857087">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857090">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857091">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7144400041334857093">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashMapCreator:7" id="7144400041334857094">
                <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857095">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857096">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="9057893087611431592">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="9057893087611431593">
            <property name="name:3" value="capacity" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="9057893087611431594">
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="9057893087611431598">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="9057893087611431597">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="9057893087611431600">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashMapCreator:7" id="9057893087611431601">
                <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="9057893087611431602">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="9057893087611431603">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334863018">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334863019">
            <property name="name:3" value="dummyEdges" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.SetType:7" id="7144400041334863020">
              <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334863022">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7144400041334863024">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashSetCreator:7" id="7144400041334863025">
                <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334863026">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="7144400041334857102">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="7144400041334857103">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334857107">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334857106">
              <link role="variableDeclaration:3" targetNodeId="7144400041334857050" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334857111">
              <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152485905" resolveInfo="getEdges" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334857105">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="9057893087611431605">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="9057893087611431611">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="9057893087611431615">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="9057893087611431618">
                    <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="9057893087611431614">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857058" resolveInfo="initialCapacity" />
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="9057893087611431607">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="9057893087611431610">
                    <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431606">
                    <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="9057893087611429489">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="9057893087611429495">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="9057893087611429498">
                  <property name="value:3" value="0" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="9057893087611429491">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="9057893087611429494">
                    <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611429490">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334857114">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334857115">
                <property name="name:3" value="oppositeEdge" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857116">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334857124">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334857119">
                    <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334857118">
                      <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                    </node>
                    <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334857123">
                      <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111989" resolveInfo="getTarget" />
                    </node>
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334857128">
                    <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112323" resolveInfo="addEdgeTo" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334857130">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334857129">
                        <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334857134">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821111981" resolveInfo="getSource" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334857137">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334857143">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334857146">
                  <link role="variableDeclaration:3" targetNodeId="7144400041334857115" resolveInfo="oppositeEdge" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334857139">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334857142">
                    <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334857138">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857086" resolveInfo="opposite" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334860904">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334860910">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334860913">
                  <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334860906">
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860905">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857086" resolveInfo="opposite" />
                  </node>
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860909">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857115" resolveInfo="oppositeEdge" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334857148">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334857154">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="7144400041334857157">
                  <property name="value:3" value="0" />
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334857150">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334857153">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857115" resolveInfo="oppositeEdge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431619">
                    <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334857159">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334857165">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.UnaryMinus:3" id="7144400041334857171">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334857174">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334857177">
                      <link role="variable:7" targetNodeId="7144400041334857103" resolveInfo="edge" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334857173">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334857065" resolveInfo="cost" />
                    </node>
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334857161">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334857164">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857115" resolveInfo="oppositeEdge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334857160">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857065" resolveInfo="cost" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863028">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334863030">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863029">
                  <link role="variableDeclaration:3" targetNodeId="7144400041334863019" resolveInfo="dummyEdges" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.AddSetElementOperation:7" id="7144400041334863034">
                  <node role="argument:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863036">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334857115" resolveInfo="oppositeEdge" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334857184">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334857185">
            <property name="name:3" value="hasPath" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.BooleanType:3" id="7144400041334857186" />
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="7144400041334857188">
              <property name="value:3" value="true" />
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.WhileStatement:3" id="7144400041334857179">
          <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334857189">
            <link role="variableDeclaration:3" targetNodeId="7144400041334857185" resolveInfo="hasPath" />
          </node>
          <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334857181">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334860801">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334860802">
                <property name="name:3" value="shortestPathFinder" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334860803">
                  <link role="classifier:3" targetNodeId="4250605017401923979" resolveInfo="FordBellman" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="7144400041334860804">
                  <node role="creator:3" type="jetbrains.mps.baseLanguage.structure.ClassCreator:3" id="7144400041334860805">
                    <link role="baseMethodDeclaration:3" targetNodeId="4250605017401923981" resolveInfo="FordBellman" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334860806">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334857050" resolveInfo="graph" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334860808">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334857052" resolveInfo="source" />
                    </node>
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334860813">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334857065" resolveInfo="cost" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334860814">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334860816">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860815">
                  <link role="variableDeclaration:3" targetNodeId="7144400041334860802" resolveInfo="shortestPathFinder" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334860820">
                  <link role="baseMethodDeclaration:3" targetNodeId="4250605017401924033" resolveInfo="doAlgorithm" />
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral:3" id="7144400041334860821">
                    <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860822">
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334860825">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="9057893087611431633">
                          <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="9057893087611431636">
                            <property name="value:3" value="0" />
                          </node>
                          <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="9057893087611431629">
                            <node role="key:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="9057893087611431632">
                              <link role="variableDeclaration:3" targetNodeId="7144400041334860823" resolveInfo="edge" />
                            </node>
                            <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431628">
                              <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                    <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7144400041334860823">
                      <property name="name:3" value="edge" />
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334860824">
                        <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                      </node>
                    </node>
                  </node>
                  <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.EnumConstantReference:3" id="7144400041334860837">
                    <link role="enumConstantDeclaration:3" targetNodeId="1.190081711777509663" resolveInfo="FRONT" />
                    <link role="enumClass:3" targetNodeId="1.190081711777509657" resolveInfo="Edge.Direction" />
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334860839">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334860840">
                <property name="name:3" value="path" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.ListType:7" id="7144400041334860841">
                  <node role="elementType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334860843">
                    <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                  </node>
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334860846">
                  <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860845">
                    <link role="variableDeclaration:3" targetNodeId="7144400041334860802" resolveInfo="shortestPathFinder" />
                  </node>
                  <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334860850">
                    <link role="baseMethodDeclaration:3" targetNodeId="4250605017401924285" resolveInfo="getShortestPath" />
                    <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="7144400041334860851">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334857055" resolveInfo="target" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7144400041334860853">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860854">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334860862">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334860864">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.BooleanConstant:3" id="7144400041334860867">
                      <property name="value:3" value="false" />
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860863">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334857185" resolveInfo="hasPath" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.EqualsExpression:3" id="7144400041334860858">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="7144400041334860861" />
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860857">
                  <link role="variableDeclaration:3" targetNodeId="7144400041334860840" resolveInfo="path" />
                </node>
              </node>
              <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="7144400041334860868">
                <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860869">
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334860875">
                    <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334860876">
                      <property name="name:3" value="minCapacity" />
                      <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="7144400041334860877" />
                      <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference:3" id="7144400041334860879">
                        <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                        <link role="variableDeclaration:3" targetNodeId="4.~Integer.MAX_VALUE" resolveInfo="MAX_VALUE" />
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="7144400041334860870">
                    <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="7144400041334860871">
                      <property name="name:7" value="edge" />
                    </node>
                    <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860880">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334860840" resolveInfo="path" />
                    </node>
                    <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860873">
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334860881">
                        <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334860883">
                          <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="7144400041334860887">
                            <link role="classConcept:3" targetNodeId="4.~Math" resolveInfo="Math" />
                            <link role="baseMethodDeclaration:3" targetNodeId="4.~Math.min(int,int):int" resolveInfo="min" />
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860888">
                              <link role="variableDeclaration:3" targetNodeId="7144400041334860876" resolveInfo="minCapacity" />
                            </node>
                            <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334860892">
                              <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334860895">
                                <link role="variable:7" targetNodeId="7144400041334860871" resolveInfo="edge" />
                              </node>
                              <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431621">
                                <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                              </node>
                            </node>
                          </node>
                          <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860882">
                            <link role="variableDeclaration:3" targetNodeId="7144400041334860876" resolveInfo="minCapacity" />
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="7144400041334860914">
                    <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="7144400041334860915">
                      <property name="name:7" value="edge" />
                    </node>
                    <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334860918">
                      <link role="variableDeclaration:3" targetNodeId="7144400041334860840" resolveInfo="path" />
                    </node>
                    <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860917">
                      <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="7144400041334860919">
                        <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334863039">
                          <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863038">
                            <link role="variableDeclaration:3" targetNodeId="7144400041334863019" resolveInfo="dummyEdges" />
                          </node>
                          <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ContainsOperation:7" id="7144400041334863043">
                            <node role="argument:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863045">
                              <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                            </node>
                          </node>
                        </node>
                        <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860921">
                          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="7144400041334863048">
                            <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="7144400041334863049">
                              <property name="name:3" value="realEdge" />
                              <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334863050">
                                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                              </node>
                              <node role="initializer:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863051">
                                <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863052">
                                  <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                </node>
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863053">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334857086" resolveInfo="opposite" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863054">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334863055">
                              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.MinusExpression:3" id="7144400041334863056">
                                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863057">
                                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863058">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334863049" resolveInfo="realEdge" />
                                  </node>
                                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863059">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                                  </node>
                                </node>
                                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863060">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334860876" resolveInfo="minCapacity" />
                                </node>
                              </node>
                              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863061">
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863062">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                                </node>
                                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863063">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334863049" resolveInfo="realEdge" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863064">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334863065">
                              <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7144400041334863066">
                                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863067">
                                  <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863068">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334863049" resolveInfo="realEdge" />
                                  </node>
                                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431622">
                                    <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                                  </node>
                                </node>
                                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863070">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334860876" resolveInfo="minCapacity" />
                                </node>
                              </node>
                              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863071">
                                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863072">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334863049" resolveInfo="realEdge" />
                                </node>
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431623">
                                  <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                                </node>
                              </node>
                            </node>
                          </node>
                          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863074">
                            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334863075">
                              <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863076">
                                <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863077">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334863049" resolveInfo="realEdge" />
                                </node>
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863078">
                                  <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                                </node>
                              </node>
                              <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863079">
                                <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863080">
                                  <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                </node>
                                <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431624">
                                  <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                        <node role="ifFalseStatement:3" type="jetbrains.mps.baseLanguage.structure.BlockStatement:3" id="7144400041334860997">
                          <node role="statements:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334860998">
                            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863082">
                              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334863083">
                                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="7144400041334863084">
                                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863085">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334860876" resolveInfo="minCapacity" />
                                  </node>
                                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863086">
                                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863087">
                                      <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                    </node>
                                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863088">
                                      <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                                    </node>
                                  </node>
                                </node>
                                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863089">
                                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863090">
                                    <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                  </node>
                                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863091">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                                  </node>
                                </node>
                              </node>
                            </node>
                            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863092">
                              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334863093">
                                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.MinusExpression:3" id="7144400041334863094">
                                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863095">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334860876" resolveInfo="minCapacity" />
                                  </node>
                                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863096">
                                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863097">
                                      <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                    </node>
                                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431627">
                                      <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                                    </node>
                                  </node>
                                </node>
                                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863099">
                                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863100">
                                    <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                  </node>
                                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431625">
                                    <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
                                  </node>
                                </node>
                              </node>
                            </node>
                            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863102">
                              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="7144400041334863103">
                                <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863104">
                                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863105">
                                    <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                  </node>
                                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863106">
                                    <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
                                  </node>
                                </node>
                                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863107">
                                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="7144400041334863108">
                                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863109">
                                      <link role="variable:7" targetNodeId="7144400041334860915" resolveInfo="edge" />
                                    </node>
                                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863110">
                                      <link role="variableDeclaration:3" targetNodeId="7144400041334857086" resolveInfo="opposite" />
                                    </node>
                                  </node>
                                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="9057893087611431626">
                                    <link role="variableDeclaration:3" targetNodeId="9057893087611431593" resolveInfo="capacity" />
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
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="7144400041334863113">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="7144400041334863114">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334863117">
            <link role="variableDeclaration:3" targetNodeId="7144400041334863019" resolveInfo="dummyEdges" />
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="7144400041334863116">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="7144400041334863118">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="7144400041334863120">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="7144400041334863119">
                  <link role="variable:7" targetNodeId="7144400041334863114" resolveInfo="edge" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="7144400041334863124">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.4660430665333277202" resolveInfo="removeFromGraph" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="7144400041334857098">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="7144400041334857100">
            <link role="variableDeclaration:3" targetNodeId="7144400041334857073" resolveInfo="flow" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7144400041334857050">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857051">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7144400041334857052">
        <property name="name:3" value="source" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857054">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7144400041334857055">
        <property name="name:3" value="target" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857057">
          <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7144400041334857058">
        <property name="name:3" value="initialCapacity" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="7144400041334857060">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857063">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857064">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="7144400041334857065">
        <property name="name:3" value="cost" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="7144400041334857067">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857070">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="7144400041334857071">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="7144400041334857036" />
  </node>
  <node type="jetbrains.mps.baseLanguage.structure.ClassConcept:3" id="228830736476010494">
    <property name="name:3" value="MinCostCirculation" />
    <node role="staticMethod:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodDeclaration:3" id="228830736476010500">
      <property name="name:3" value="getCirculation" />
      <node role="returnType:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="228830736476010651">
        <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010654">
          <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
        </node>
        <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010655">
          <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
        </node>
      </node>
      <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="228830736476010502" />
      <node role="body:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476010503">
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="228830736476016180">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="228830736476016181">
            <property name="name:3" value="capacity" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="228830736476016182">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476016185">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476016186">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="228830736476016188">
              <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.HashMapCreator:7" id="228830736476016189">
                <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476016190">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476016191">
                  <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="228830736476010647">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="228830736476010648">
            <property name="name:3" value="source" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010649">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476010657">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476010656">
                <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476010661">
                <link role="baseMethodDeclaration:3" targetNodeId="1.6088058844796081411" resolveInfo="addDummyNode" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="228830736476010669">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="228830736476010670">
            <property name="name:3" value="target" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010671">
              <link role="classifier:3" targetNodeId="1.4671312709908983848" resolveInfo="Node" />
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476010674">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476010673">
                <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476010678">
                <link role="baseMethodDeclaration:3" targetNodeId="1.6088058844796081411" resolveInfo="addDummyNode" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476016193">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476016194">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016198">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016197">
              <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016202">
              <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152485905" resolveInfo="getEdges" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016196">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476016203">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="228830736476016209">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.MinusExpression:3" id="228830736476016217">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016221">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016224">
                      <link role="variable:7" targetNodeId="228830736476016194" resolveInfo="edge" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016220">
                      <link role="variableDeclaration:3" targetNodeId="228830736476010512" resolveInfo="low" />
                    </node>
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016213">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016216">
                      <link role="variable:7" targetNodeId="228830736476016194" resolveInfo="edge" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016212">
                      <link role="variableDeclaration:3" targetNodeId="228830736476010519" resolveInfo="initialCapacity" />
                    </node>
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016205">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016208">
                    <link role="variable:7" targetNodeId="228830736476016194" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016204">
                    <link role="variableDeclaration:3" targetNodeId="228830736476016181" resolveInfo="capacity" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476015999">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476016000">
            <property name="name:7" value="node" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016004">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016003">
              <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016008">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821107956" resolveInfo="getNodes" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016002">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="228830736476016009">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016013">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016012">
                  <link role="variable:7" targetNodeId="228830736476016000" resolveInfo="node" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016017">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.6088058844796081325" resolveInfo="isDummy" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016011">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ContinueStatement:3" id="228830736476016018" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="228830736476016020">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="228830736476016021">
                <property name="name:3" value="diff" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.IntegerType:3" id="228830736476016022" />
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="228830736476016024">
                  <property name="value:3" value="0" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476016026">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476016027">
                <property name="name:7" value="edge" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016031">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016030">
                  <link role="variable:7" targetNodeId="228830736476016000" resolveInfo="node" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016035">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.190081711777510135" resolveInfo="getInEdges" />
                </node>
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016029">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476016036">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.PlusAssignmentExpression:3" id="228830736476016038">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016042">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016045">
                        <link role="variable:7" targetNodeId="228830736476016027" resolveInfo="edge" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016041">
                        <link role="variableDeclaration:3" targetNodeId="228830736476010512" resolveInfo="low" />
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016037">
                      <link role="variableDeclaration:3" targetNodeId="228830736476016021" resolveInfo="diff" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476016048">
              <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476016049">
                <property name="name:7" value="edge" />
              </node>
              <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016050">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016051">
                  <link role="variable:7" targetNodeId="228830736476016000" resolveInfo="node" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016052">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821110932" resolveInfo="getOutEdges" />
                </node>
              </node>
              <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016053">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476016054">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.MinusAssignmentExpression:3" id="228830736476016060">
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016061">
                      <link role="variableDeclaration:3" targetNodeId="228830736476016021" resolveInfo="diff" />
                    </node>
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016062">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016063">
                        <link role="variable:7" targetNodeId="228830736476016049" resolveInfo="edge" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016064">
                        <link role="variableDeclaration:3" targetNodeId="228830736476010512" resolveInfo="low" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="228830736476023998">
              <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="228830736476023999">
                <property name="name:3" value="newEdge" />
                <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476024000">
                  <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
                </node>
                <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="228830736476024025" />
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="228830736476016066">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016067">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476024011">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="228830736476024012">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016142">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016143">
                        <link role="variableDeclaration:3" targetNodeId="228830736476010648" resolveInfo="source" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016144">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112323" resolveInfo="addEdgeTo" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016145">
                          <link role="variable:7" targetNodeId="228830736476016000" resolveInfo="node" />
                        </node>
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024019">
                      <link role="variableDeclaration:3" targetNodeId="228830736476023999" resolveInfo="newEdge" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.GreaterThanExpression:3" id="228830736476026722">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476026723">
                  <link role="variableDeclaration:3" targetNodeId="228830736476016021" resolveInfo="diff" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="228830736476026724">
                  <property name="value:3" value="0" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="228830736476016155">
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016156">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476024014">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="228830736476024015">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016160">
                      <node role="operand:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016177">
                        <link role="variable:7" targetNodeId="228830736476016000" resolveInfo="node" />
                      </node>
                      <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016162">
                        <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821112323" resolveInfo="addEdgeTo" />
                        <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016178">
                          <link role="variableDeclaration:3" targetNodeId="228830736476010670" resolveInfo="target" />
                        </node>
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024018">
                      <link role="variableDeclaration:3" targetNodeId="228830736476023999" resolveInfo="newEdge" />
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.LessThanExpression:3" id="228830736476026725">
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476026726">
                  <link role="variableDeclaration:3" targetNodeId="228830736476016021" resolveInfo="diff" />
                </node>
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="228830736476026727">
                  <property name="value:3" value="0" />
                </node>
              </node>
            </node>
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="228830736476024021">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="228830736476024027">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="228830736476024030" />
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024026">
                  <link role="variableDeclaration:3" targetNodeId="228830736476023999" resolveInfo="newEdge" />
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476024023">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476024002">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="228830736476024008">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="228830736476024032">
                      <link role="classConcept:3" targetNodeId="4.~Math" resolveInfo="Math" />
                      <link role="baseMethodDeclaration:3" targetNodeId="4.~Math.abs(int):int" resolveInfo="abs" />
                      <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024033">
                        <link role="variableDeclaration:3" targetNodeId="228830736476016021" resolveInfo="diff" />
                      </node>
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476024004">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024020">
                        <link role="variableDeclaration:3" targetNodeId="228830736476023999" resolveInfo="newEdge" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024003">
                        <link role="variableDeclaration:3" targetNodeId="228830736476016181" resolveInfo="capacity" />
                      </node>
                    </node>
                  </node>
                </node>
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476024035">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="228830736476024041">
                    <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.IntegerConstant:3" id="228830736476024044">
                      <property name="value:3" value="0" />
                    </node>
                    <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476024037">
                      <node role="key:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024040">
                        <link role="variableDeclaration:3" targetNodeId="228830736476023999" resolveInfo="newEdge" />
                      </node>
                      <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476024036">
                        <link role="variableDeclaration:3" targetNodeId="228830736476010526" resolveInfo="cost" />
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement:3" id="228830736476016243">
          <node role="localVariableDeclaration:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration:3" id="228830736476016244">
            <property name="name:3" value="flow" />
            <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="228830736476016245">
              <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476016246">
                <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
              </node>
              <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476016247">
                <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
              </node>
            </node>
            <node role="initializer:3" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall:3" id="228830736476016248">
              <link role="baseMethodDeclaration:3" targetNodeId="7144400041334857041" resolveInfo="getFlow" />
              <link role="classConcept:3" targetNodeId="7144400041334857035" resolveInfo="MinCostMaxFlow" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016249">
                <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016250">
                <link role="variableDeclaration:3" targetNodeId="228830736476010648" resolveInfo="source" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016251">
                <link role="variableDeclaration:3" targetNodeId="228830736476010670" resolveInfo="target" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016252">
                <link role="variableDeclaration:3" targetNodeId="228830736476016181" resolveInfo="capacity" />
              </node>
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476016253">
                <link role="variableDeclaration:3" targetNodeId="228830736476010526" resolveInfo="cost" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476016255">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476016256">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016260">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016259">
              <link role="variableDeclaration:3" targetNodeId="228830736476010648" resolveInfo="source" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016264">
              <link role="baseMethodDeclaration:3" targetNodeId="1.8567569493821110932" resolveInfo="getOutEdges" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016258">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.IfStatement:3" id="228830736476016265">
              <node role="condition:3" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression:3" id="228830736476016273">
                <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016277">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016280">
                    <link role="variable:7" targetNodeId="228830736476016256" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016276">
                    <link role="variableDeclaration:3" targetNodeId="228830736476016181" resolveInfo="capacity" />
                  </node>
                </node>
                <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476016269">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016272">
                    <link role="variable:7" targetNodeId="228830736476016256" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016268">
                    <link role="variableDeclaration:3" targetNodeId="228830736476016244" resolveInfo="flow" />
                  </node>
                </node>
              </node>
              <node role="ifTrue:3" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016267">
                <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="228830736476016281">
                  <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.NullLiteral:3" id="228830736476016283" />
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476016318">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476016319">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016328">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016323">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016322">
                <link role="variableDeclaration:3" targetNodeId="228830736476010648" resolveInfo="source" />
              </node>
              <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016327">
                <link role="baseMethodDeclaration:3" targetNodeId="1.1327612371813210994" resolveInfo="getEdges" />
              </node>
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.ConcatOperation:7" id="228830736476016332">
              <node role="rightExpression:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016335">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016334">
                  <link role="variableDeclaration:3" targetNodeId="228830736476010670" resolveInfo="target" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476016339">
                  <link role="baseMethodDeclaration:3" targetNodeId="1.1327612371813210994" resolveInfo="getEdges" />
                </node>
              </node>
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476016321">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476016340">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476016342">
                <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476016341">
                  <link role="variableDeclaration:3" targetNodeId="228830736476016244" resolveInfo="flow" />
                </node>
                <node role="operation:3" type="jetbrains.mps.baseLanguage.collections.structure.MapRemoveOperation:7" id="228830736476016346">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476016348">
                    <link role="variable:7" targetNodeId="228830736476016319" resolveInfo="edge" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476015981">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476015983">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476015982">
              <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476015987">
              <link role="baseMethodDeclaration:3" targetNodeId="1.228830736476010680" resolveInfo="remove" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476015988">
                <link role="variableDeclaration:3" targetNodeId="228830736476010648" resolveInfo="source" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476015990">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476015992">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476015991">
              <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476015996">
              <link role="baseMethodDeclaration:3" targetNodeId="1.228830736476010680" resolveInfo="remove" />
              <node role="actualArgument:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476015997">
                <link role="variableDeclaration:3" targetNodeId="228830736476010670" resolveInfo="target" />
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement:7" id="228830736476024899">
          <node role="variable:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable:7" id="228830736476024900">
            <property name="name:7" value="edge" />
          </node>
          <node role="inputSequence:7" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="228830736476024901">
            <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476024902">
              <link role="variableDeclaration:3" targetNodeId="228830736476010504" resolveInfo="graph" />
            </node>
            <node role="operation:3" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation:3" id="228830736476024903">
              <link role="baseMethodDeclaration:3" targetNodeId="1.1654665216152485905" resolveInfo="getEdges" />
            </node>
          </node>
          <node role="body:7" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="228830736476024904">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="228830736476024905">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.AssignmentExpression:3" id="228830736476024906">
                <node role="rValue:3" type="jetbrains.mps.baseLanguage.structure.PlusExpression:3" id="228830736476024907">
                  <node role="rightExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476024908">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476024909">
                      <link role="variable:7" targetNodeId="228830736476024900" resolveInfo="edge" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.ParameterReference:3" id="228830736476024910">
                      <link role="variableDeclaration:3" targetNodeId="228830736476010512" resolveInfo="low" />
                    </node>
                  </node>
                  <node role="leftExpression:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476024911">
                    <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476024912">
                      <link role="variable:7" targetNodeId="228830736476024900" resolveInfo="edge" />
                    </node>
                    <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024913">
                      <link role="variableDeclaration:3" targetNodeId="228830736476016244" resolveInfo="flow" />
                    </node>
                  </node>
                </node>
                <node role="lValue:3" type="jetbrains.mps.baseLanguage.collections.structure.MapElement:7" id="228830736476024914">
                  <node role="key:7" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference:7" id="228830736476024915">
                    <link role="variable:7" targetNodeId="228830736476024900" resolveInfo="edge" />
                  </node>
                  <node role="map:7" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476024916">
                    <link role="variableDeclaration:3" targetNodeId="228830736476016244" resolveInfo="flow" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ReturnStatement:3" id="228830736476010663">
          <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference:3" id="228830736476021984">
            <link role="variableDeclaration:3" targetNodeId="228830736476016244" resolveInfo="flow" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="228830736476010504">
        <property name="name:3" value="graph" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010505">
          <link role="classifier:3" targetNodeId="1.8567569493821103298" resolveInfo="Graph" />
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="228830736476010512">
        <property name="name:3" value="low" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="228830736476010514">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010517">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010518">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="228830736476010519">
        <property name="name:3" value="initialCapacity" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="228830736476010521">
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010525">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010524">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
        </node>
      </node>
      <node role="parameter:3" type="jetbrains.mps.baseLanguage.structure.ParameterDeclaration:3" id="228830736476010526">
        <property name="name:3" value="cost" />
        <node role="type:3" type="jetbrains.mps.baseLanguage.collections.structure.MapType:7" id="228830736476010528">
          <node role="keyType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010531">
            <link role="classifier:3" targetNodeId="1.8567569493821103292" resolveInfo="Edge" />
          </node>
          <node role="valueType:7" type="jetbrains.mps.baseLanguage.structure.ClassifierType:3" id="228830736476010532">
            <link role="classifier:3" targetNodeId="4.~Integer" resolveInfo="Integer" />
          </node>
        </node>
      </node>
    </node>
    <node role="visibility:3" type="jetbrains.mps.baseLanguage.structure.PublicVisibility:3" id="228830736476010495" />
  </node>
</model>

