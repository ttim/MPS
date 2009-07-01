<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:fb7c79f5-02eb-4c97-b60a-34f78483b2cb(jetbrains.mps.baseLanguage.logging.dataFlow)">
  <persistence version="3" />
  <refactoringHistory />
  <language namespace="7fa12e9c-b949-4976-b4fa-19accbc320b4(jetbrains.mps.lang.dataFlow)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590377(jetbrains.mps.lang.dataFlow.constraints)" version="4" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959037d(jetbrains.mps.lang.dataFlow.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959057f(jetbrains.mps.baseLanguage.logging.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="1" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ae(jetbrains.mps.lang.typesystem.constraints)" version="17" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590345(jetbrains.mps.lang.pattern.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959034b(jetbrains.mps.lang.quotation.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959033d(jetbrains.mps.lang.annotations.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902b4(jetbrains.mps.lang.typesystem.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590340(jetbrains.mps.lang.pattern.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <devkit namespace="2677cb18-f558-4e33-bc38-a5139cee06dc(jetbrains.mps.devkit.language-design)" />
  <maxImportIndex value="1" />
  <import index="1" modelUID="r:00000000-0000-4000-0000-011c8959057f(jetbrains.mps.baseLanguage.logging.structure)" version="0" />
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration" id="5058855501989739747">
    <link role="conceptDeclaration" targetNodeId="1.1167227138527" resolveInfo="LogStatement" />
    <node role="builderBlock" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock" id="5058855501989739748">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="5058855501989739749">
        <node role="statement" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement" id="5058855501989770195">
          <node role="codeFor" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="5058855501989770201">
            <node role="operand" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter" id="5058855501989770200" />
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="5058855501989770205">
              <link role="link" targetNodeId="1.1167227463056" />
            </node>
          </node>
        </node>
        <node role="statement" type="jetbrains.mps.baseLanguage.structure.IfStatement" id="5058855501989770213">
          <node role="ifTrue" type="jetbrains.mps.baseLanguage.structure.StatementList" id="5058855501989770214">
            <node role="statement" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement" id="5058855501989770227">
              <node role="codeFor" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="5058855501989770228">
                <node role="operand" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter" id="5058855501989770229" />
                <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="5058855501989770230">
                  <link role="link" targetNodeId="1.1167227561449" />
                </node>
              </node>
            </node>
          </node>
          <node role="condition" type="jetbrains.mps.baseLanguage.structure.NotEqualsExpression" id="5058855501989770223">
            <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.NullLiteral" id="5058855501989770226" />
            <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="5058855501989770218">
              <node role="operand" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter" id="5058855501989770217" />
              <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkAccess" id="5058855501989770222">
                <link role="link" targetNodeId="1.1167227561449" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.dataFlow.structure.DataFlowBuilderDeclaration" id="8259962354560896642">
    <link role="conceptDeclaration" targetNodeId="1.1168401810208" resolveInfo="PrintStatement" />
    <node role="builderBlock" type="jetbrains.mps.lang.dataFlow.structure.BuilderBlock" id="8259962354560896643">
      <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="8259962354560896644">
        <node role="statement" type="jetbrains.mps.baseLanguage.collections.structure.ForEachStatement" id="8259962354560896645">
          <node role="variable" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariable" id="8259962354560896646">
            <property name="name" value="textExpression" />
          </node>
          <node role="inputSequence" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="8259962354560896653">
            <node role="operand" type="jetbrains.mps.lang.dataFlow.structure.NodeParameter" id="8259962354560896652" />
            <node role="operation" type="jetbrains.mps.lang.smodel.structure.SLinkListAccess" id="8259962354560896658">
              <link role="link" targetNodeId="1.1168401864803" />
            </node>
          </node>
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="8259962354560896648">
            <node role="statement" type="jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement" id="8259962354560896660">
              <node role="codeFor" type="jetbrains.mps.baseLanguage.collections.structure.ForEachVariableReference" id="8259962354560896662">
                <link role="variable" targetNodeId="8259962354560896646" resolveInfo="textExpression" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
</model>

