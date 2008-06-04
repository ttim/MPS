<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.structureLanguage.findUsages">
  <persistence version="1"/>
  <refactoringHistory/>
  <language namespace="jetbrains.mps.bootstrap.findUsagesLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.findUsagesLanguage.structure" version="1"/>
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.structureLanguage"/>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0"/>
  </language>
  <language namespace="jetbrains.mps.bootstrap.sharedConcepts"/>
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="1"/>
  </language>
  <language namespace="jetbrains.mps.baseLanguageInternal"/>
  <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="1"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <languageAspect modelUID="jetbrains.mps.closures.structure" version="0"/>
  <maxImportIndex value="17"/>
  <import index="2" modelUID="jetbrains.mps.core.structure" version="-1"/>
  <import index="3" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" version="-1"/>
  <import index="5" modelUID="jetbrains.mps.findUsages@java_stub" version="-1"/>
  <import index="6" modelUID="java.util@java_stub" version="-1"/>
  <import index="7" modelUID="jetbrains.mps.smodel@java_stub" version="-1"/>
  <import index="10" modelUID="java.lang@java_stub" version="-1"/>
  <import index="11" modelUID="jetbrains.mps.ide.findusages.model@java_stub" version="-1"/>
  <import index="14" modelUID="jetbrains.mps.ide.progress@java_stub" version="-1"/>
  <import index="15" modelUID="jetbrains.mps.util@java_stub" version="-1"/>
  <import index="16" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure@java_stub" version="-1"/>
  <import index="17" modelUID="com.intellij.openapi.progress@java_stub" version="-1"/>
  <node type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FinderDeclaration" id="1197632773078">
    <property name="name" value="ConceptInstances"/>
    <property name="description" value="Concept Instances"/>
    <property name="isVisible" value="true"/>
    <link role="forConcept" targetNodeId="3.1169125787135" resolveInfo="AbstractConceptDeclaration"/>
    <node role="findFunction" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FindBlock" id="1197632773081">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1197632773082">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1197634574462">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1197634574463">
            <property name="name" value="resNodes"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1197634574464">
              <link role="classifier" targetNodeId="6.~List" resolveInfo="List"/>
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1197634602013">
                <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
              </node>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1210514216999">
              <link role="baseMethodDeclaration" targetNodeId="6.~ArrayList.&lt;init&gt;(java.util.Collection)"
                    resolveInfo="ArrayList"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1210514234981">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1210514234982">
                  <link role="baseMethodDeclaration"
                        targetNodeId="5.~FindUsagesManager.getInstance():jetbrains.mps.findUsages.FindUsagesManager"
                        resolveInfo="getInstance"/>
                  <link role="classConcept" targetNodeId="5.~FindUsagesManager" resolveInfo="FindUsagesManager"/>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                      id="1210514234983">
                  <link role="baseMethodDeclaration"
                        targetNodeId="5.~FindUsagesManager.findInstances(jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration,jetbrains.mps.smodel.IScope,jetbrains.mps.ide.progress.IAdaptiveProgressMonitor,boolean):java.util.Set"
                        resolveInfo="findInstances"/>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.CastExpression"
                        id="1210514536858">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                          id="1210514544817">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                            id="1210514536859"/>
                      <node role="operation"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                            id="1210514545697"/>
                    </node>
                    <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1210514591043">
                      <link role="classifier" targetNodeId="16.~AbstractConceptDeclaration"
                            resolveInfo="AbstractConceptDeclaration"/>
                    </node>
                  </node>
                  <node role="actualArgument"
                        type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope"
                        id="1210514234985"/>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.NewExpression"
                        id="1212169387306">
                    <link role="baseMethodDeclaration"
                          targetNodeId="5.~FindUsagesManager$ProgressAdapter.&lt;init&gt;(com.intellij.openapi.progress.ProgressIndicator)"
                          resolveInfo="FindUsagesManager.ProgressAdapter"/>
                    <node role="actualArgument"
                          type="jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference"
                          id="1212595713478">
                      <property name="name" value="indicator"/>
                      <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1212595748964">
                        <link role="classifier" targetNodeId="17.~ProgressIndicator" resolveInfo="ProgressIndicator"/>
                      </node>
                    </node>
                  </node>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.BooleanConstant"
                        id="1210514234988">
                    <property name="value" value="false"/>
                  </node>
                </node>
              </node>
              <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1210514514506">
                <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1197635106703">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1197635106704">
            <node role="statement" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ResultStatement"
                  id="1200268665345">
              <node role="foundResult" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1200268665879">
                <link role="baseMethodDeclaration" targetNodeId="11.~SearchResult.&lt;init&gt;()"
                      resolveInfo="SearchResult"/>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.NewExpression"
                      id="1200268665880">
                  <link role="baseMethodDeclaration"
                        targetNodeId="7.~SNodePointer.&lt;init&gt;(jetbrains.mps.smodel.SNode)"
                        resolveInfo="SNodePointer"/>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                        id="1200268665881">
                    <link role="variableDeclaration" targetNodeId="1197635106707" resolveInfo="node"/>
                  </node>
                </node>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StringLiteral"
                      id="1200268665882">
                  <property name="value" value="Concept Instances"/>
                </node>
              </node>
              <node role="foundNode" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1200306749512">
                <link role="variableDeclaration" targetNodeId="1197635106707" resolveInfo="node"/>
              </node>
            </node>
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1197635117960">
            <link role="variableDeclaration" targetNodeId="1197634574463" resolveInfo="resNodes"/>
          </node>
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1197635106707">
            <property name="name" value="resNode"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1197635110178">
              <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="categorizeBlock" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.CategorizeBlock"
          id="1206463350774">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206463350775">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206463353621">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1206463353904">
            <property name="value" value="Concept Instances"/>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FinderDeclaration" id="1197636141662">
    <property name="name" value="NodeUsages"/>
    <property name="description" value="Node Usages"/>
    <property name="isVisible" value="true"/>
    <link role="forConcept" targetNodeId="2.1133920641626" resolveInfo="BaseConcept"/>
    <node role="findFunction" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FindBlock" id="1197636141665">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1197636141666">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1197636333572">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1197636333573">
            <property name="name" value="resRefs"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1197636333574">
              <link role="classifier" targetNodeId="6.~Set" resolveInfo="Set"/>
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1197636440259">
                <link role="classifier" targetNodeId="7.~SReference" resolveInfo="SReference"/>
              </node>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204740201790">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1197636333577">
                <link role="baseMethodDeclaration"
                      targetNodeId="5.~FindUsagesManager.getInstance():jetbrains.mps.findUsages.FindUsagesManager"
                      resolveInfo="getInstance"/>
                <link role="classConcept" targetNodeId="5.~FindUsagesManager" resolveInfo="FindUsagesManager"/>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204740201791">
                <link role="baseMethodDeclaration"
                      targetNodeId="5.~FindUsagesManager.findUsages(java.util.Set,jetbrains.mps.smodel.IScope,jetbrains.mps.ide.progress.IAdaptiveProgressMonitor,boolean):java.util.Set"
                      resolveInfo="findUsages"/>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall"
                      id="1210514353351">
                  <link role="baseMethodDeclaration"
                        targetNodeId="15.~CollectionUtil.asSet(java.lang.Object[]):java.util.Set" resolveInfo="asSet"/>
                  <link role="classConcept" targetNodeId="15.~CollectionUtil" resolveInfo="CollectionUtil"/>
                  <node role="actualArgument"
                        type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                        id="1210514355686"/>
                </node>
                <node role="actualArgument"
                      type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope"
                      id="1206463389285"/>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.NewExpression"
                      id="1212595819940">
                  <link role="baseMethodDeclaration"
                        targetNodeId="5.~FindUsagesManager$ProgressAdapter.&lt;init&gt;(com.intellij.openapi.progress.ProgressIndicator)"
                        resolveInfo="FindUsagesManager.ProgressAdapter"/>
                  <node role="actualArgument"
                        type="jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference"
                        id="1212595819941">
                    <property name="name" value="indicator"/>
                    <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1212595819942">
                      <link role="classifier" targetNodeId="17.~ProgressIndicator" resolveInfo="ProgressIndicator"/>
                    </node>
                  </node>
                </node>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.BooleanConstant"
                      id="1210514285983">
                  <property name="value" value="false"/>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1197636333587">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1197636333588">
            <node role="statement" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ResultStatement"
                  id="1200268559644">
              <node role="foundNode" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204740202247">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1200306865435">
                  <link role="variableDeclaration" targetNodeId="1197636333598" resolveInfo="reference"/>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                      id="1204740202248">
                  <link role="baseMethodDeclaration"
                        targetNodeId="7.~SReference.getSourceNode():jetbrains.mps.smodel.SNode"
                        resolveInfo="getSourceNode"/>
                </node>
              </node>
            </node>
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1197636333597">
            <link role="variableDeclaration" targetNodeId="1197636333573" resolveInfo="resNodes"/>
          </node>
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1197636333598">
            <property name="name" value="reference"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1197636448384">
              <link role="classifier" targetNodeId="7.~SReference" resolveInfo="SReference"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="categorizeBlock" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.CategorizeBlock"
          id="1206463393131">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206463393132">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206463395212">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1206463395558">
            <property name="value" value="Node Usages"/>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FinderDeclaration" id="1198430852441">
    <property name="name" value="NodeAndDescendantsUsages"/>
    <property name="description" value="Node &amp; Descendants Usages"/>
    <property name="isVisible" value="true"/>
    <link role="forConcept" targetNodeId="2.1133920641626" resolveInfo="BaseConcept"/>
    <node role="findFunction" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FindBlock" id="1198430852444">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1198430852445">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1198431665992">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1198431665993">
            <property name="name" value="nodes"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1198431665994">
              <link role="classifier" targetNodeId="6.~Set" resolveInfo="Set"/>
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1198431665995">
                <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
              </node>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1198431665996">
              <link role="baseMethodDeclaration" targetNodeId="6.~HashSet.&lt;init&gt;()" resolveInfo="HashSet"/>
              <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1198431665997">
                <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1198431671842">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204740201788">
            <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1198431671843">
              <link role="variableDeclaration" targetNodeId="1198431665993" resolveInfo="nodes"/>
            </node>
            <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                  id="1204740201789">
              <link role="baseMethodDeclaration" targetNodeId="6.~Set.add(java.lang.Object):boolean" resolveInfo="add"/>
              <node role="actualArgument"
                    type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                    id="1206445166378"/>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement"
              id="1206538130614">
          <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable"
                id="1206538130615">
            <property name="name" value="child"/>
          </node>
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206538130622">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206538197370">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206538197371">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1206538197372">
                  <link role="variableDeclaration" targetNodeId="1198431665993" resolveInfo="nodes"/>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                      id="1206538197373">
                  <link role="baseMethodDeclaration" targetNodeId="6.~Set.add(java.lang.Object):boolean"
                        resolveInfo="add"/>
                  <node role="actualArgument"
                        type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference"
                        id="1206538197422">
                    <link role="variable" targetNodeId="1206538130615" resolveInfo="child"/>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206538139284">
            <node role="operand"
                  type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                  id="1206538138470"/>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetDescendantsOperation"
                  id="1206538183743"/>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.RemarkStatement" id="1198431051277"/>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1198431046405">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1198431046406">
            <property name="name" value="resRefs"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1198431046407">
              <link role="classifier" targetNodeId="6.~Set" resolveInfo="Set"/>
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1198431046408">
                <link role="classifier" targetNodeId="7.~SReference" resolveInfo="SReference"/>
              </node>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204740202361">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1198431046410">
                <link role="classConcept" targetNodeId="5.~FindUsagesManager" resolveInfo="FindUsagesManager"/>
                <link role="baseMethodDeclaration"
                      targetNodeId="5.~FindUsagesManager.getInstance():jetbrains.mps.findUsages.FindUsagesManager"
                      resolveInfo="getInstance"/>
              </node>
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                    id="1204740202362">
                <link role="baseMethodDeclaration"
                      targetNodeId="5.~FindUsagesManager.findUsages(java.util.Set,jetbrains.mps.smodel.IScope,jetbrains.mps.ide.progress.IAdaptiveProgressMonitor,boolean):java.util.Set"
                      resolveInfo="findUsages"/>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1198431718643">
                  <link role="variableDeclaration" targetNodeId="1198431665993" resolveInfo="nodes"/>
                </node>
                <node role="actualArgument"
                      type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope"
                      id="1206463374367"/>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.NewExpression"
                      id="1212595810141">
                  <link role="baseMethodDeclaration"
                        targetNodeId="5.~FindUsagesManager$ProgressAdapter.&lt;init&gt;(com.intellij.openapi.progress.ProgressIndicator)"
                        resolveInfo="FindUsagesManager.ProgressAdapter"/>
                  <node role="actualArgument"
                        type="jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference"
                        id="1212595810142">
                    <property name="name" value="indicator"/>
                    <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1212595810143">
                      <link role="classifier" targetNodeId="17.~ProgressIndicator" resolveInfo="ProgressIndicator"/>
                    </node>
                  </node>
                </node>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.BooleanConstant"
                      id="1210514391607">
                  <property name="value" value="false"/>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1198430917729">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1198430917730">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1198432150344">
              <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1198432150345">
                <node role="statement" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ResultStatement"
                      id="1206467338197">
                  <node role="foundNode" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206467342075">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                          id="1206467340652">
                      <link role="variableDeclaration" targetNodeId="1198430917741" resolveInfo="reference"/>
                    </node>
                    <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                          id="1206467344124">
                      <link role="baseMethodDeclaration"
                            targetNodeId="7.~SReference.getSourceNode():jetbrains.mps.smodel.SNode"
                            resolveInfo="getSourceNode"/>
                    </node>
                  </node>
                </node>
              </node>
              <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1198432151848">
                <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204740202513">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                        id="1198432158146">
                    <link role="variableDeclaration" targetNodeId="1198431665993" resolveInfo="nodes"/>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                        id="1204740202514">
                    <link role="baseMethodDeclaration" targetNodeId="6.~Set.contains(java.lang.Object):boolean"
                          resolveInfo="contains"/>
                    <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                          id="1204740201767">
                      <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                            id="1198432166869">
                        <link role="variableDeclaration" targetNodeId="1198430917741" resolveInfo="reference"/>
                      </node>
                      <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                            id="1204740201768">
                        <link role="baseMethodDeclaration"
                              targetNodeId="7.~SReference.getSourceNode():jetbrains.mps.smodel.SNode"
                              resolveInfo="getSourceNode"/>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1198431473341">
            <link role="variableDeclaration" targetNodeId="1198431046406" resolveInfo="resRefs"/>
          </node>
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1198430917741">
            <property name="name" value="reference"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1198430917742">
              <link role="classifier" targetNodeId="7.~SReference" resolveInfo="SReference"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="categorizeBlock" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.CategorizeBlock"
          id="1206463379525">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206463379526">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206463382498">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1206463382766">
            <property name="value" value="Node Descendants Usages"/>
          </node>
        </node>
      </node>
    </node>
    <node role="searchedNodesBlock" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.SearchedNodesBlock"
          id="1206538095562">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206538095563">
        <node role="statement" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachStatement"
              id="1206538104269">
          <node role="variable" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariable"
                id="1206538104270">
            <property name="name" value="child"/>
          </node>
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206538104272">
            <node role="statement" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.NodeStatement"
                  id="1206538121968">
              <node role="foundNode"
                    type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.ForEachVariableReference"
                    id="1206538122033">
                <link role="variable" targetNodeId="1206538104270" resolveInfo="child"/>
              </node>
            </node>
          </node>
          <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206538205986">
            <node role="operand"
                  type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                  id="1206538205987"/>
            <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetDescendantsOperation"
                  id="1206538205988"/>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FinderDeclaration" id="1201275992898">
    <property name="isVisible" value="true"/>
    <property name="name" value="LinkExamples"/>
    <property name="description" value="Find Link Examples"/>
    <link role="forConcept" targetNodeId="3.1071489288298" resolveInfo="LinkDeclaration"/>
    <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.IsApplicableBlock"
          id="1201275992899">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1201275992900">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1201276252832">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1201276252833">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203721648074">
              <node role="operand"
                    type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                    id="1201276254491"/>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsInstanceOfOperation"
                    id="1201276256871">
                <node role="conceptArgument"
                      type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1201276258404">
                  <link role="conceptDeclaration" targetNodeId="3.1149608206811"
                        resolveInfo="AnnotationLinkDeclaration"/>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="findFunction" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FindBlock" id="1201275992901">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1201275992902">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1201278073462">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1201278073463">
            <property name="name" value="role"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1201278073464">
              <link role="classifier" targetNodeId="10.~String" resolveInfo="String"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203721648435">
              <node role="operand"
                    type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                    id="1206445129998"/>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                    id="1201278147784">
                <link role="property" targetNodeId="3.1071599776563" resolveInfo="role"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1201278326042">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1201278326043">
            <property name="name" value="conceptDeclaration"/>
            <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1201278326044">
              <link role="concept" targetNodeId="3.1169125787135" resolveInfo="AbstractConceptDeclaration"/>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1203721648262">
              <node role="operand"
                    type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                    id="1206445131421"/>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAncestorOperation"
                    id="1201278326047">
                <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.structure.OperationParm_Concept"
                      id="1201278326048">
                  <node role="conceptArgument"
                        type="jetbrains.mps.bootstrap.smodelLanguage.structure.RefConcept_Reference" id="1210514248324">
                    <link role="conceptDeclaration" targetNodeId="3.1169125787135"
                          resolveInfo="AbstractConceptDeclaration"/>
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1201278330832">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1201278330833">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1206466287605">
              <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206466287606">
                <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1206466287607">
                  <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206466287608">
                    <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement"
                          id="1206466287609">
                      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206466287610">
                        <node role="statement"
                              type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ResultStatement"
                              id="1206466287611">
                          <node role="foundNode" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                id="1206466287612">
                            <link role="variableDeclaration" targetNodeId="1206466287620" resolveInfo="child"/>
                          </node>
                        </node>
                      </node>
                      <node role="iterable" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                            id="1206466287613">
                        <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                              id="1206466287614">
                          <link role="baseMethodDeclaration"
                                targetNodeId="7.~SNode.getChildren(java.lang.String):java.util.List"
                                resolveInfo="getChildren"/>
                          <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                id="1206466287615">
                            <link role="variableDeclaration" targetNodeId="1201278073463" resolveInfo="role"/>
                          </node>
                        </node>
                        <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                              id="1206466287616">
                          <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression"
                                id="1206466287617">
                            <node role="expression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                  id="1206466287618">
                              <link role="variableDeclaration" targetNodeId="1206466287649" resolveInfo="instance"/>
                            </node>
                            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType"
                                  id="1206466287619">
                              <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                            id="1206466287620">
                        <property name="name" value="child"/>
                        <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1206466287621">
                          <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
                        </node>
                      </node>
                    </node>
                  </node>
                  <node role="condition" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206466287622">
                    <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206466287623">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                            id="1206466287624"/>
                      <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SPropertyAccess"
                            id="1206466287625">
                        <link role="property" targetNodeId="3.1071599937831" resolveInfo="metaClass"/>
                      </node>
                    </node>
                    <node role="operation"
                          type="jetbrains.mps.bootstrap.smodelLanguage.structure.Property_HasValue_Enum"
                          id="1206466287626">
                      <node role="value" type="jetbrains.mps.bootstrap.smodelLanguage.structure.EnumMemberReference"
                            id="1206466287627">
                        <link role="enumMember" targetNodeId="3.1084199179705" resolveInfo="aggregation"/>
                      </node>
                    </node>
                  </node>
                  <node role="ifFalseStatement" type="jetbrains.mps.baseLanguage.structure.BlockStatement"
                        id="1206466287628">
                    <node role="statements" type="jetbrains.mps.baseLanguage.structure.StatementList"
                          id="1206466287629">
                      <node role="statement"
                            type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
                            id="1206466287630">
                        <node role="localVariableDeclaration"
                              type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1206466287631">
                          <property name="name" value="referent"/>
                          <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType"
                                id="1206466287632">
                            <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
                          </node>
                          <node role="initializer" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                                id="1206466287633">
                            <node role="operation"
                                  type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                                  id="1206466287634">
                              <link role="baseMethodDeclaration"
                                    targetNodeId="7.~SNode.getReferent(java.lang.String):jetbrains.mps.smodel.SNode"
                                    resolveInfo="getReferent"/>
                              <node role="actualArgument"
                                    type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                    id="1206466287635">
                                <link role="variableDeclaration" targetNodeId="1201278073463" resolveInfo="role"/>
                              </node>
                            </node>
                            <node role="operand" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression"
                                  id="1206466287636">
                              <node role="expression" type="jetbrains.mps.baseLanguage.structure.CastExpression"
                                    id="1206466287637">
                                <node role="expression"
                                      type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                      id="1206466287638">
                                  <link role="variableDeclaration" targetNodeId="1206466287649" resolveInfo="instance"/>
                                </node>
                                <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType"
                                      id="1206466287639">
                                  <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
                                </node>
                              </node>
                            </node>
                          </node>
                        </node>
                      </node>
                      <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="1206466287640">
                        <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression"
                              id="1206466287641">
                          <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral"
                                id="1206466287642"/>
                          <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                id="1206466287643">
                            <link role="variableDeclaration" targetNodeId="1206466287631" resolveInfo="referent"/>
                          </node>
                        </node>
                        <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList"
                              id="1206466287644">
                          <node role="statement"
                                type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ResultStatement"
                                id="1206466287645">
                            <node role="foundNode" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                                  id="1206466287646">
                              <link role="variableDeclaration" targetNodeId="1206466287631" resolveInfo="referent"/>
                            </node>
                          </node>
                        </node>
                      </node>
                    </node>
                  </node>
                </node>
              </node>
              <node role="iterable" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ExecuteFinderExpression"
                    id="1206466287647">
                <link role="finder" targetNodeId="1197632773078" resolveInfo="ConceptInstances"/>
                <node role="queryNode" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                      id="1206466287648">
                  <link role="variableDeclaration" targetNodeId="1201278326043" resolveInfo="conceptDeclaration"/>
                </node>
              </node>
              <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                    id="1206466287649">
                <property name="name" value="instance"/>
                <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1206466287650"/>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotExpression" id="1206466274909">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1206466277520">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1206466274910">
                <link role="variableDeclaration" targetNodeId="1201278326043" resolveInfo="conceptDeclaration"/>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsNullOperation"
                    id="1206466280882"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="categorizeBlock" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.CategorizeBlock"
          id="1206463363235">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1206463363236">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1206463366004">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1206463366334">
            <property name="value" value="Link Examples"/>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FinderDeclaration" id="1211301915928">
    <property name="name" value="ExactConceptInstances"/>
    <property name="description" value="Exact Concept Instances"/>
    <property name="isVisible" value="true"/>
    <property name="longDescription"
              value="only instances of the specified concept, not including instances of it's subconcepts"/>
    <link role="forConcept" targetNodeId="3.1071489090640" resolveInfo="ConceptDeclaration"/>
    <node role="findFunction" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.FindBlock" id="1211301915936">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1211301915937">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement"
              id="1211301915938">
          <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"
                id="1211301915939">
            <property name="name" value="resNodes"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1211301915940">
              <link role="classifier" targetNodeId="6.~List" resolveInfo="List"/>
              <node role="parameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1211301915941">
                <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
              </node>
            </node>
            <node role="initializer" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1211301915942">
              <link role="baseMethodDeclaration" targetNodeId="6.~ArrayList.&lt;init&gt;(java.util.Collection)"
                    resolveInfo="ArrayList"/>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1211301915943">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.StaticMethodCall" id="1211301915944">
                  <link role="classConcept" targetNodeId="5.~FindUsagesManager" resolveInfo="FindUsagesManager"/>
                  <link role="baseMethodDeclaration"
                        targetNodeId="5.~FindUsagesManager.getInstance():jetbrains.mps.findUsages.FindUsagesManager"
                        resolveInfo="getInstance"/>
                </node>
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation"
                      id="1211301915945">
                  <link role="baseMethodDeclaration"
                        targetNodeId="5.~FindUsagesManager.findExactInstances(jetbrains.mps.bootstrap.structureLanguage.structure.AbstractConceptDeclaration,jetbrains.mps.smodel.IScope,jetbrains.mps.ide.progress.IAdaptiveProgressMonitor,boolean):java.util.Set"
                        resolveInfo="findExactInstances"/>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.CastExpression"
                        id="1211301915946">
                    <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression"
                          id="1211301915947">
                      <node role="operand"
                            type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ConceptFunctionParameter_node"
                            id="1211301915948"/>
                      <node role="operation"
                            type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetAdapterOperation"
                            id="1211301915949"/>
                    </node>
                    <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1211301915950">
                      <link role="classifier" targetNodeId="16.~AbstractConceptDeclaration"
                            resolveInfo="AbstractConceptDeclaration"/>
                    </node>
                  </node>
                  <node role="actualArgument"
                        type="jetbrains.mps.bootstrap.sharedConcepts.structure.ConceptFunctionParameter_scope"
                        id="1211301915951"/>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.NewExpression"
                        id="1212595800266">
                    <link role="baseMethodDeclaration"
                          targetNodeId="5.~FindUsagesManager$ProgressAdapter.&lt;init&gt;(com.intellij.openapi.progress.ProgressIndicator)"
                          resolveInfo="FindUsagesManager.ProgressAdapter"/>
                    <node role="actualArgument"
                          type="jetbrains.mps.baseLanguageInternal.structure.InternalVariableReference"
                          id="1212595800267">
                      <property name="name" value="indicator"/>
                      <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1212595800268">
                        <link role="classifier" targetNodeId="17.~ProgressIndicator" resolveInfo="ProgressIndicator"/>
                      </node>
                    </node>
                  </node>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.BooleanConstant"
                        id="1211301915954">
                    <property name="value" value="false"/>
                  </node>
                </node>
              </node>
              <node role="typeParameter" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1211301915955">
                <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
              </node>
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ForeachStatement" id="1211301915956">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1211301915957">
            <node role="statement" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.ResultStatement"
                  id="1211301915958">
              <node role="foundResult" type="jetbrains.mps.baseLanguage.structure.NewExpression" id="1211301915959">
                <link role="baseMethodDeclaration" targetNodeId="11.~SearchResult.&lt;init&gt;()"
                      resolveInfo="SearchResult"/>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.NewExpression"
                      id="1211301915960">
                  <link role="baseMethodDeclaration"
                        targetNodeId="7.~SNodePointer.&lt;init&gt;(jetbrains.mps.smodel.SNode)"
                        resolveInfo="SNodePointer"/>
                  <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                        id="1211301915961">
                    <link role="variableDeclaration" targetNodeId="1211301915965" resolveInfo="resNode"/>
                  </node>
                </node>
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.StringLiteral"
                      id="1211301915962">
                  <property name="value" value="Concept Instances"/>
                </node>
              </node>
              <node role="foundNode" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference"
                    id="1211301915963">
                <link role="variableDeclaration" targetNodeId="1211301915965" resolveInfo="resNode"/>
              </node>
            </node>
          </node>
          <node role="iterable" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1211301915964">
            <link role="variableDeclaration" targetNodeId="1211301915939" resolveInfo="resNodes"/>
          </node>
          <node role="variable" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1211301915965">
            <property name="name" value="resNode"/>
            <node role="type" type="jetbrains.mps.baseLanguage.structure.ClassifierType" id="1211301915966">
              <link role="classifier" targetNodeId="7.~SNode" resolveInfo="SNode"/>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="categorizeBlock" type="jetbrains.mps.bootstrap.findUsagesLanguage.structure.CategorizeBlock"
          id="1211301915967">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1211301915968">
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1211301915969">
          <node role="expression" type="jetbrains.mps.baseLanguage.structure.StringLiteral" id="1211301915970">
            <property name="value" value="Concept Instances"/>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

