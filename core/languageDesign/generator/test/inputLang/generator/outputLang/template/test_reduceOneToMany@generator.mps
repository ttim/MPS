<?xml version="1.0" encoding="UTF-8"?>
<model modelUID="r:eca8e1c7-93fd-4ddf-9db6-91f9c2320691(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceOneToMany@generator)">
  <persistence version="4" />
  <refactoringHistory />
  <language namespace="b401a680-8325-4110-8fd3-84331ff25bef(jetbrains.mps.lang.generator)" />
  <language namespace="d7706f63-9be2-479c-a3da-ae92af1e64d5(jetbrains.mps.lang.generator.generationContext)" />
  <language namespace="157a9668-bf58-417b-893e-53d86388dc56(jetbrains.mps.transformation.test.outputLang)" />
  <language namespace="f3061a53-9226-4cc5-a443-f952ceaf5816(jetbrains.mps.baseLanguage)" />
  <language namespace="7866978e-a0f0-4cc7-81bc-4d213d9375e1(jetbrains.mps.lang.smodel)" />
  <language namespace="ceab5195-25ea-4f22-9b92-103b95ca8c0c(jetbrains.mps.lang.core)" />
  <language namespace="83888646-71ce-4f1c-9c53-c54016f6ad4f(jetbrains.mps.baseLanguage.collections)" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902bc(jetbrains.mps.lang.sharedConcepts.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902e2(jetbrains.mps.lang.generator.constraints)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959028c(jetbrains.mps.lang.structure.constraints)" version="11" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ca(jetbrains.mps.baseLanguage.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902db(jetbrains.mps.baseLanguage.blTypes.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590334(jetbrains.mps.baseLanguage.closures.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590338(jetbrains.mps.baseLanguage.closures.structure)" version="3" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902e8(jetbrains.mps.lang.generator.structure)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590301(jetbrains.mps.lang.smodel.structure)" version="16" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902fb(jetbrains.mps.lang.smodel.constraints)" version="21" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints)" version="83" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590292(jetbrains.mps.lang.structure.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902ba(jetbrains.mps.lang.sharedConcepts.constraints)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c895902f3(jetbrains.mps.lang.generator.generationContext.structure)" version="0" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590283(jetbrains.mps.lang.core.constraints)" version="2" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c8959032e(jetbrains.mps.baseLanguage.collections.structure)" version="7" />
  <languageAspect modelUID="r:00000000-0000-4000-0000-011c89590328(jetbrains.mps.baseLanguage.collections.constraints)" version="6" />
  <maxImportIndex value="4" />
  <import index="1" modelUID="r:00000000-0000-4000-0000-011c89590605(jetbrains.mps.transformation.test.outputLang.structure)" version="-1" />
  <import index="2" modelUID="r:00000000-0000-4000-0000-011c895905f4(jetbrains.mps.transformation.test.inputLang.structure)" version="-1" />
  <import index="3" modelUID="r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)" version="0" />
  <import index="4" modelUID="r:eca8e1c7-93fd-4ddf-9db6-91f9c2320691(jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceOneToMany@generator)" version="-1" />
  <node type="jetbrains.mps.lang.generator.structure.MappingConfiguration:2" id="3893401255414084744">
    <property name="name:2" value="main" />
    <node role="reductionMappingRule:2" type="jetbrains.mps.lang.generator.structure.Reduction_MappingRule:2" id="3893401255414086883">
      <link role="applicableConcept:2" targetNodeId="2.1195171011194" resolveInfo="InputNode_A" />
      <node role="ruleConsequence:2" type="jetbrains.mps.lang.generator.structure.TemplateDeclarationReference:2" id="3893401255414100169">
        <link role="template:2" targetNodeId="3893401255414100167" resolveInfo="reduce_InputNode_A" />
      </node>
      <node role="conditionFunction:2" type="jetbrains.mps.lang.generator.structure.BaseMappingRule_Condition:2" id="3893401255414132234">
        <node role="body:2" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3893401255414132235">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3893401255414132236">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3893401255414132259">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3893401255414132254">
                <node role="operand:3" type="jetbrains.mps.lang.smodel.structure.SNodeTypeCastExpression:16" id="3893401255414132252">
                  <link role="concept:16" targetNodeId="2.1195168316083" resolveInfo="InputRoot" />
                  <node role="leftExpression:16" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3893401255414132242">
                    <node role="operand:3" type="jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode:2" id="3893401255414132237" />
                    <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetContainingRootOperation:16" id="3893401255414132247" />
                  </node>
                </node>
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="3893401255414132258">
                  <link role="property:16" targetNodeId="2.1202243304949" resolveInfo="useInTest" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Property_HasValue_Enum:16" id="3893401255414132263">
                <node role="value:16" type="jetbrains.mps.lang.smodel.structure.EnumMemberReference:16" id="3893401255414132264">
                  <link role="enumMember:16" targetNodeId="2.341670684286865622" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="rootMappingRule:2" type="jetbrains.mps.lang.generator.structure.Root_MappingRule:2" id="3893401255414086885">
      <link role="applicableConcept:2" targetNodeId="2.1195168316083" resolveInfo="InputRoot" />
      <link role="template:2" targetNodeId="3893401255414086886" resolveInfo="map_InputRoot" />
      <node role="conditionFunction:2" type="jetbrains.mps.lang.generator.structure.BaseMappingRule_Condition:2" id="3893401255414129777">
        <node role="body:2" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3893401255414129778">
          <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3893401255414131864">
            <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3893401255414131871">
              <node role="operand:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3893401255414131866">
                <node role="operand:3" type="jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode:2" id="3893401255414131865" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.SPropertyAccess:16" id="3893401255414131870">
                  <link role="property:16" targetNodeId="2.1202243304949" resolveInfo="useInTest" />
                </node>
              </node>
              <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Property_HasValue_Enum:16" id="3893401255414132232">
                <node role="value:16" type="jetbrains.mps.lang.smodel.structure.EnumMemberReference:16" id="3893401255414132233">
                  <link role="enumMember:16" targetNodeId="2.341670684286865622" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.transformation.test.outputLang.structure.OutputRoot" id="3893401255414086886">
    <property name="name" value="OutputRoot" />
    <property name="text" value="chilren were generated from a single child in input node." />
    <node role="rootTemplateAnnotation$attribute" type="jetbrains.mps.lang.generator.structure.RootTemplateAnnotation:2" id="3893401255414086887">
      <link role="applicableConcept:2" targetNodeId="2.1195168316083" resolveInfo="InputRoot" />
    </node>
    <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="3893401255414086888">
      <node role="nodeMacro$attribute" type="jetbrains.mps.lang.generator.structure.CopySrcListMacro:2" id="3893401255414086893">
        <property name="comment:2" value="all children" />
        <node role="sourceNodesQuery:2" type="jetbrains.mps.lang.generator.structure.SourceSubstituteMacro_SourceNodesQuery:2" id="3893401255414086894">
          <node role="body:2" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3893401255414086895">
            <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3893401255414100160">
              <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.DotExpression:3" id="3893401255414100162">
                <node role="operand:3" type="jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode:2" id="3893401255414100161" />
                <node role="operation:3" type="jetbrains.mps.lang.smodel.structure.Node_GetChildrenOperation:16" id="3893401255414100166" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.generator.structure.TemplateDeclaration:2" id="3893401255414100167">
    <property name="name:2" value="reduce_InputNode_A" />
    <link role="applicableConcept:2" targetNodeId="2.1195171011194" resolveInfo="InputNode_A" />
    <node role="contentNode:2" type="jetbrains.mps.transformation.test.outputLang.structure.OutputRoot" id="3893401255414100170">
      <property name="name" value="_context_" />
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="3893401255414100171">
        <property name="text" value="child #1" />
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="3893401255414100173" />
        <node role="nodeMacro$attribute" type="jetbrains.mps.lang.generator.structure.LoopMacro:2" id="3893401255414161782">
          <property name="comment:2" value="list of two input nodes" />
          <node role="sourceNodesQuery:2" type="jetbrains.mps.lang.generator.structure.SourceSubstituteMacro_SourceNodesQuery:2" id="3893401255414161783">
            <node role="body:2" type="jetbrains.mps.baseLanguage.structure.StatementList:3" id="3893401255414161784">
              <node role="statement:3" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement:3" id="3893401255414163870">
                <node role="expression:3" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression:3" id="3893401255414163871">
                  <node role="creator:3" type="jetbrains.mps.baseLanguage.collections.structure.ListCreatorWithInit:7" id="3893401255414169139">
                    <node role="elementType:7" type="jetbrains.mps.lang.smodel.structure.SNodeType:16" id="3893401255414169141" />
                    <node role="initValue:7" type="jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode:2" id="3893401255414169143" />
                    <node role="initValue:7" type="jetbrains.mps.lang.generator.structure.TemplateFunctionParameter_sourceNode:2" id="3893401255414169145" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1391450457158185608">
        <property name="text" value="child #2" />
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1391450457158185609" />
      </node>
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1892993302480068636">
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1892993302480068637" />
        <node role="nodeMacro$attribute" type="jetbrains.mps.lang.generator.structure.IncludeMacro:2" id="1892993302480068639">
          <link role="includeTemplate:2" targetNodeId="1892993302480251689" resolveInfo="reduce_InputNode_A_included" />
        </node>
      </node>
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1892993302480310362">
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1892993302480310363" />
        <node role="nodeMacro$attribute" type="jetbrains.mps.lang.generator.structure.SwitchMacro:2" id="1892993302480310365">
          <link role="templateSwitch:2" targetNodeId="1892993302480310366" resolveInfo="switch_InputNode_A" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.generator.structure.TemplateDeclaration:2" id="1892993302480251689">
    <property name="name:2" value="reduce_InputNode_A_included" />
    <node role="contentNode:2" type="jetbrains.mps.transformation.test.outputLang.structure.OutputRoot" id="1892993302480251691">
      <property name="name" value="context" />
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1892993302480251692">
        <property name="text" value="child included #1" />
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1892993302480251693" />
      </node>
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1892993302480277769">
        <property name="text" value="child included #2" />
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1892993302480277770" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.generator.structure.TemplateSwitch:2" id="1892993302480310366">
    <property name="name:2" value="switch_InputNode_A" />
    <node role="reductionMappingRule:2" type="jetbrains.mps.lang.generator.structure.Reduction_MappingRule:2" id="1892993302480310367">
      <link role="applicableConcept:2" targetNodeId="2.1195171011194" resolveInfo="InputNode_A" />
      <node role="ruleConsequence:2" type="jetbrains.mps.lang.generator.structure.TemplateDeclarationReference:2" id="1892993302480311962">
        <link role="template:2" targetNodeId="1892993302480311955" resolveInfo="reduce_InputNode_A_switch" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.lang.generator.structure.TemplateDeclaration:2" id="1892993302480311955">
    <property name="name:2" value="reduce_InputNode_A_switch" />
    <node role="contentNode:2" type="jetbrains.mps.transformation.test.outputLang.structure.OutputRoot" id="1892993302480311957">
      <property name="name" value="context" />
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1892993302480311958">
        <property name="text" value="child switch #1" />
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1892993302480311959" />
      </node>
      <node role="outputChild" type="jetbrains.mps.transformation.test.outputLang.structure.OutputNode" id="1892993302480311960">
        <property name="text" value="child switch #2" />
        <node role="templateFragment$attribute" type="jetbrains.mps.lang.generator.structure.TemplateFragment:2" id="1892993302480311961" />
      </node>
    </node>
  </node>
</model>

