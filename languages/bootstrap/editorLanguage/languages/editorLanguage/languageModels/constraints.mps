<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.bootstrap.editorLanguage.constraints">
  <language namespace="jetbrains.mps.bootstrap.constraintsLanguage" />
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <maxImportIndex value="10" />
  <import index="1" modelUID="jetbrains.mps.bootstrap.editorLanguage.structure" />
  <import index="2" modelUID="jetbrains.mps.core.structure" />
  <import index="3" modelUID="jetbrains.mps.smodel@java_stub" />
  <import index="4" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" />
  <import index="5" modelUID="jetbrains.mps.smodel.search@java_stub" />
  <import index="6" modelUID="jetbrains.mps.bootstrap.structureLanguage@java_stub" />
  <import index="7" modelUID="java.util@java_stub" />
  <import index="8" modelUID="jetbrains.mps.ide@java_stub" />
  <import index="9" modelUID="jetbrains.mps.smodel.constraints@java_stub" />
  <import index="10" modelUID="jetbrains.mps.bootstrap.editorLanguage.constraints@java_stub" />
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.NodePropertyConstraintSet" id="1147473568712">
    <property name="name" value="EDTL_property" />
    <node role="nodePropertyConstraint" type="jetbrains.mps.bootstrap.constraintsLanguage.NodePropertyConstraint" id="1147473587979">
      <link role="applicableConcept" targetNodeId="1.1071666914219" />
      <link role="applicableProperty" targetNodeId="2.1078489098626" />
      <node role="propertyGetter" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_PropertyGetter" id="1147474122159">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1147474122160">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1147474917363">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1147474917364">
              <property name="name" value="editedConcept" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1147474917366">
                <link role="concept" targetNodeId="4.1071489090640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1147474870127">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.PropertyGetter_FunctionParm_node" id="1147474159061" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1147474893019">
                  <link role="link" targetNodeId="1.1080736633876" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1147474933868">
            <node role="condition" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1147474938279">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1147474940813" />
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1147474935731">
                <link role="variableDeclaration" targetNodeId="1147474917364" />
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1147474933870">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1147474945251">
                <node role="expression" type="jetbrains.mps.baseLanguage.PlusExpression" id="1147474959381">
                  <node role="rightExpression" type="jetbrains.mps.baseLanguage.StringLiteral" id="1147474976900">
                    <property name="value" value="_Editor" />
                  </node>
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1147474955301">
                    <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1147474949644">
                      <link role="variableDeclaration" targetNodeId="1147474917364" />
                    </node>
                    <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess" id="1147474957287">
                      <link role="property" targetNodeId="2.1078489098626" />
                    </node>
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1147475374218">
            <node role="expression" type="jetbrains.mps.baseLanguage.StringLiteral" id="1147475376361">
              <property name="value" value="?_Editor" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.NodeReferentConstraintSet" id="1148925938735">
    <property name="name" value="EDTL_reference" />
    <node role="nodeReferentConstraint" type="jetbrains.mps.bootstrap.constraintsLanguage.NodeReferentConstraint" id="1148937952591">
      <link role="applicableConcept" targetNodeId="1.1139848536355" />
      <link role="applicableLink" targetNodeId="1.1140103550593" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_ReferentSearchScope_Factory" id="1148937952592">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1148937952593">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1148938217619">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1148938217620">
              <property name="name" value="editorComponent" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1148938217622">
                <link role="concept" targetNodeId="1.1080736578640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1148938180175">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_enclosingNode" id="1148938178674" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1148938183395">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1148938191507" />
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1148938196634">
                    <link role="concept" targetNodeId="1.1080736578640" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1148938291534">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1148938291535">
              <property name="name" value="editedConcept" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1148938291537">
                <link role="concept" targetNodeId="4.1071489090640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1148938263938">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1148938262125">
                  <link role="variableDeclaration" targetNodeId="1148938217620" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1148938269939">
                  <link role="link" targetNodeId="1.1080736633876" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1149208402946">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1149208409229">
              <link role="classConcept" extResolveInfo="5.[Classifier]SModelSearchUtil" />
              <link role="baseMethodDeclaration" extResolveInfo="5.static method ([Classifier]SModelSearchUtil).([StaticMethodDeclaration]createConceptHierarchyScope((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ConceptDeclaration])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [IConceptHierarchyScope]))" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.CastExpression" id="1149208409230">
                <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149208409231">
                  <link role="variableDeclaration" targetNodeId="1148938291535" />
                </node>
                <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1149208409232">
                  <link role="classifier" extResolveInfo="6.[Classifier]ConceptDeclaration" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="searchScopePrecondition" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_ReferentSearchScope_Precondition" id="1148938831838">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1148938831839">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1148938838997">
            <node role="condition" type="jetbrains.mps.baseLanguage.EqualsExpression" id="1148938899491">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1148938907025" />
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1148939697054">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1148938864126">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_enclosingNode" id="1148938861750" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1148938865455">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1148938877222" />
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1148938886474">
                      <link role="concept" targetNodeId="1.1080736578640" />
                    </node>
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1148939707758">
                  <link role="link" targetNodeId="1.1080736633876" />
                </node>
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1148938838999">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1148938910854">
                <node role="expression" type="jetbrains.mps.baseLanguage.StringLiteral" id="1149030129600">
                  <property name="value" value="couldn't obtain edited concept" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1148939720166">
            <node role="expression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1149030137226" />
          </node>
        </node>
      </node>
    </node>
    <node role="nodeReferentConstraint" type="jetbrains.mps.bootstrap.constraintsLanguage.NodeReferentConstraint" id="1158689838067">
      <link role="applicableConcept" targetNodeId="1.1158589789017" />
      <link role="applicableLink" targetNodeId="1.1158589865362" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_ReferentSearchScope_Factory" id="1158689838068">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158689838069">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158690007234">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158690007235">
              <property name="name" value="editorComponent" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158690007236">
                <link role="concept" targetNodeId="1.1080736578640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158690007237">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_enclosingNode" id="1158690007238" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1158690007239">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1158690007240" />
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1158690007241">
                    <link role="concept" targetNodeId="1.1080736578640" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1158690007242">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1158690007243">
              <property name="name" value="editedConcept" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1158690007244">
                <link role="concept" targetNodeId="4.1071489090640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158690007245">
                <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158690007246">
                  <link role="variableDeclaration" targetNodeId="1158690007235" resolveInfo="editorComponent" />
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158690007247">
                  <link role="link" targetNodeId="1.1080736633876" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158691324808">
            <node role="expression" type="jetbrains.mps.baseLanguage.NewExpression" id="1158691327997">
              <link role="baseMethodDeclaration" extResolveInfo="10.constructor [Classifier]CellMenu_ReplaceNode_ReplacementConceptSearchScope[ConstructorDeclaration] ((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ConceptDeclaration]))" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.CastExpression" id="1158691443422">
                <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1158691451581">
                  <link role="classifier" extResolveInfo="6.[Classifier]ConceptDeclaration" />
                </node>
                <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1158691456660">
                  <link role="variableDeclaration" targetNodeId="1158690007243" resolveInfo="editedConcept" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="searchScopePrecondition" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_ReferentSearchScope_Precondition" id="1158689912367">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1158689912368">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1158689922866">
            <node role="condition" type="jetbrains.mps.baseLanguage.EqualsExpression" id="1158689922867">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1158689922868" />
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158689922869">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1158689922870">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_enclosingNode" id="1158689922871" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1158689922872">
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1158689922873" />
                    <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1158689922874">
                      <link role="concept" targetNodeId="1.1080736578640" />
                    </node>
                  </node>
                </node>
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkAccess" id="1158689922875">
                  <link role="link" targetNodeId="1.1080736633876" />
                </node>
              </node>
            </node>
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1158689922876">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158689922877">
                <node role="expression" type="jetbrains.mps.baseLanguage.StringLiteral" id="1158689922878">
                  <property name="value" value="couldn't obtain edited concept" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1158689922879">
            <node role="expression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1158689922880" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.constraintsLanguage.NodeReferentConstraintSet" id="1149282891878">
    <property name="name" value="EDTL_reference_tmp" />
    <node role="nodeReferentConstraint" type="jetbrains.mps.bootstrap.constraintsLanguage.NodeReferentConstraint" id="1149282906863">
      <link role="applicableConcept" targetNodeId="1.1073389214265" />
      <link role="applicableLink" targetNodeId="1.1075905542141" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_ReferentSearchScope_Factory" id="1149282906864">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1149282906865">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149283904334">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149283904335">
              <property name="name" value="editor" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1149283904336">
                <link role="concept" targetNodeId="1.1080736578640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1149283904337">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_enclosingNode" id="1149283904338" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1149283904339">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1149283904340" />
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1149283904341">
                    <link role="concept" targetNodeId="1.1080736578640" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284003270">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284003271">
              <property name="name" value="localActionSets" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1149284003273">
                <link role="elementConcept" targetNodeId="1.1075814723765" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SemanticDowncastExpression" id="1149283994128">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1149283961767">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149283959750">
                    <link role="variableDeclaration" targetNodeId="1149283904335" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1149283964002">
                    <link role="link" targetNodeId="1.1080736633878" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284038572">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284038573">
              <property name="name" value="searchScope" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1149284038574">
                <link role="classifier" extResolveInfo="5.[Classifier]ISearchScope" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.NewExpression" id="1149284051107">
                <link role="baseMethodDeclaration" extResolveInfo="5.constructor [Classifier]SimpleSearchScope[ConstructorDeclaration] ((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [List, &lt;jetbrains.mps.baseLanguage.types.classifier [SNode]&gt;]))" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284130047">
                  <link role="variableDeclaration" targetNodeId="1149284003271" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284147002">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284147003">
              <property name="name" value="searchScope2" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1149284147004">
                <link role="classifier" extResolveInfo="5.[Classifier]ISearchScope" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1149284209960">
                <link role="baseMethodDeclaration" extResolveInfo="5.static method ([Classifier]SModelSearchUtil).([StaticMethodDeclaration]createModelAndImportedModelsScope((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SModel]), (jetbrains.mps.baseLanguage.types.boolean/jetbrains.mps.baseLanguage.types.boolean), (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [IScope])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ISearchScope]))" />
                <link role="classConcept" extResolveInfo="5.[Classifier]SModelSearchUtil" />
                <node role="actualArgument" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_model" id="1149284212586" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1149284218572">
                  <property name="value" value="true" />
                </node>
                <node role="actualArgument" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_scope" id="1149284229231" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1149284241998">
            <node role="expression" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1149284246673">
              <link role="baseMethodDeclaration" extResolveInfo="5.method ([Classifier]ISearchScope).([InstanceMethodDeclaration]append((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ISearchScope])) : (jetbrains.mps.baseLanguage.types.void/jetbrains.mps.baseLanguage.types.void))" />
              <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284241999">
                <link role="variableDeclaration" targetNodeId="1149284038573" />
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284253283">
                <link role="variableDeclaration" targetNodeId="1149284147003" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1149284255848">
            <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284259053">
              <link role="variableDeclaration" targetNodeId="1149284038573" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="nodeReferentConstraint" type="jetbrains.mps.bootstrap.constraintsLanguage.NodeReferentConstraint" id="1149284472388">
      <link role="applicableConcept" targetNodeId="1.1075814723765" />
      <link role="applicableLink" targetNodeId="1.1076585521578" />
      <node role="searchScopeFactory" type="jetbrains.mps.bootstrap.constraintsLanguage.ConstraintFunction_ReferentSearchScope_Factory" id="1149284472389">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1149284472390">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284513429">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284513430">
              <property name="name" value="editor" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1149284513431">
                <link role="concept" targetNodeId="1.1080736578640" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1149284513432">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_enclosingNode" id="1149284513433" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1149284513434">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Inclusion" id="1149284513435" />
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1149284513436">
                    <link role="concept" targetNodeId="1.1080736578640" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284513437">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284513438">
              <property name="name" value="localActionSets" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeListType" id="1149284513439">
                <link role="elementConcept" targetNodeId="1.1075814723765" />
              </node>
              <node role="initializer" type="jetbrains.mps.bootstrap.smodelLanguage.SemanticDowncastExpression" id="1149284513440">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1149284513441">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284513442">
                    <link role="variableDeclaration" targetNodeId="1149284513430" />
                  </node>
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SLinkListAccess" id="1149284513443">
                    <link role="link" targetNodeId="1.1080736633878" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284513444">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284513445">
              <property name="name" value="searchScope" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1149284513446">
                <link role="classifier" extResolveInfo="5.[Classifier]ISearchScope" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.NewExpression" id="1149284513447">
                <link role="baseMethodDeclaration" extResolveInfo="5.constructor [Classifier]SimpleSearchScope[ConstructorDeclaration] ((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [List, &lt;jetbrains.mps.baseLanguage.types.classifier [SNode]&gt;]))" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284513448">
                  <link role="variableDeclaration" targetNodeId="1149284513438" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1149284513449">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1149284513450">
              <property name="name" value="searchScope2" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1149284513451">
                <link role="classifier" extResolveInfo="5.[Classifier]ISearchScope" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1149284513452">
                <link role="classConcept" extResolveInfo="5.[Classifier]SModelSearchUtil" />
                <link role="baseMethodDeclaration" extResolveInfo="5.static method ([Classifier]SModelSearchUtil).([StaticMethodDeclaration]createModelAndImportedModelsScope((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SModel]), (jetbrains.mps.baseLanguage.types.boolean/jetbrains.mps.baseLanguage.types.boolean), (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [IScope])) : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ISearchScope]))" />
                <node role="actualArgument" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_model" id="1149284513453" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1149284513454">
                  <property name="value" value="true" />
                </node>
                <node role="actualArgument" type="jetbrains.mps.bootstrap.constraintsLanguage.ConceptParameter_ReferentSearchScope_scope" id="1149284513455" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1149284513456">
            <node role="expression" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1149284513457">
              <link role="baseMethodDeclaration" extResolveInfo="5.method ([Classifier]ISearchScope).([InstanceMethodDeclaration]append((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [ISearchScope])) : (jetbrains.mps.baseLanguage.types.void/jetbrains.mps.baseLanguage.types.void))" />
              <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284513458">
                <link role="variableDeclaration" targetNodeId="1149284513445" />
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284513459">
                <link role="variableDeclaration" targetNodeId="1149284513450" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1149284513460">
            <node role="expression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1149284513461">
              <link role="variableDeclaration" targetNodeId="1149284513445" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

