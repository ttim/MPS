<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.transformation.TLBase.editor">
  <language namespace="jetbrains.mps.bootstrap.editorLanguage" />
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage" />
  <language namespace="jetbrains.mps.baseLanguage" />
  <maxImportIndex value="10" />
  <import index="1" modelUID="jetbrains.mps.transformation.TLBase.structure" />
  <import index="4" modelUID="jetbrains.mps.core.structure" />
  <import index="6" modelUID="jetbrains.mps.bootstrap.structureLanguage.structure" />
  <import index="8" modelUID="jetbrains.mps.transformation@java_stub" />
  <import index="9" modelUID="jetbrains.mps.nodeEditor@java_stub" />
  <import index="10" modelUID="jetbrains.mps.smodel@java_stub" />
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1087903454703">
    <property name="name" value="PropertyMacro_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1087833241328" />
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1087903454708">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1087907544521">
        <property name="text" value="&lt; Property Macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1087907544522">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1087907544523">
          <property name="text" value="propertyMacro_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1088501636842">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="PropertyMacroProviderAspect" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1089123998625">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1140209861260">
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
      <property name="selectable" value="true" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapDeclaration" id="1087911817437">
    <property name="name" value="_PropertyMacroSwitch_KeyMap" />
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapItem" id="1146772585733">
      <property name="description" value="add/remove property macro" />
      <node role="keystroke" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapKeystroke" id="1146772585734">
        <property name="modifiers" value="ctrl+shift" />
        <property name="keycode" value="VK_M" />
      </node>
      <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_IsApplicableFunction" id="1146772585735">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146772585736">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146773380110">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146773380111">
              <property name="name" value="cell" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1146773380112">
                <link role="classifier" extResolveInfo="9.[Classifier]EditorCell" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773380113">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146773380114" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1146773380115">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1146773380116">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146773380117">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1146773380118" />
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1146773380119">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_selectedNode" id="1146773380120" />
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773380121">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorCell).([InstanceMethodDeclaration]getSNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146773380122">
                  <link role="variableDeclaration" targetNodeId="1146773380111" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146773380123">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146773380124">
              <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
              <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]canSwitchPropertyMacro((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell])) : (jetbrains.mps.baseLanguage.types.boolean/jetbrains.mps.baseLanguage.types.boolean))" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146773380125">
                <link role="variableDeclaration" targetNodeId="1146773380111" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_ExecuteFunction" id="1146772585737">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146772585738">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146773399455">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146773399456">
              <property name="name" value="cell" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1146773399457">
                <link role="classifier" extResolveInfo="9.[Classifier]EditorCell" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773399458">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146773399459" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1146773399460">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146773399461">
              <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
              <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]switchPropertyMacro((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]), (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [IScope])) : (jetbrains.mps.baseLanguage.types.void/jetbrains.mps.baseLanguage.types.void))" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146773399462">
                <link role="variableDeclaration" targetNodeId="1146773399456" />
              </node>
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773628732">
                <link role="baseMethodDeclaration" extResolveInfo="10.method ([Classifier]IOperationContext).([InstanceMethodDeclaration]getScope() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [IScope]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773598370">
                  <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getOperationContext() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [IOperationContext]))" />
                  <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146773577061" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapItem" id="1146773424398">
      <property name="description" value="remove property macro" />
      <node role="keystroke" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapKeystroke" id="1146773424399">
        <property name="modifiers" value="ctrl+shift" />
        <property name="keycode" value="VK_M" />
      </node>
      <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_IsApplicableFunction" id="1146773424400">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146773424401">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146773446984">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146773446985">
              <property name="name" value="selectedNode" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1146773446986" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773446987">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorCell).([InstanceMethodDeclaration]getSNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773446988">
                  <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                  <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146773446989" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146773446990">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1146773446991">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146773446992">
                <link role="variableDeclaration" targetNodeId="1146773446985" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1146773446993">
                <link role="concept" targetNodeId="1.1087833241328" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_ExecuteFunction" id="1146773424418">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146773424419">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146773503987">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146773503988">
              <property name="name" value="propertyMacro" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1146773503989" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773503990">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorCell).([InstanceMethodDeclaration]getSNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146773503991">
                  <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                  <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146773503992" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1146773503993">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1146773503994">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146773503995">
                <link role="variableDeclaration" targetNodeId="1146773503988" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_DeleteOperation" id="1146773503996" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1087926271843">
    <property name="name" value="NodeMacro_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1087833466690" />
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1089126084078">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1089126148391">
        <property name="text" value="&lt; Node Macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1096644584231">
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1090493300946">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1090493300947">
          <property name="text" value="templateSourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1090493300948">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1090493300949">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1090493300950">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1090493300951">
          <property name="text" value="templateTargetBuilder_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1090493300952">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateTargetBuilder_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1090493300953">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1089126148396">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="selectable" value="true" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapDeclaration" id="1087927878702">
    <property name="name" value="_NodeMacroSwitch_KeyMap" />
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapItem" id="1146757069336">
      <property name="description" value="convert to/from 'template fragmet'" />
      <node role="keystroke" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapKeystroke" id="1146757069337">
        <property name="modifiers" value="ctrl+shift" />
        <property name="keycode" value="VK_F" />
      </node>
      <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_IsApplicableFunction" id="1146757069338">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146757069339">
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1146757613716">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1146757613718">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146757670422">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1146757672924" />
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.baseLanguage.EqualsExpression" id="1146757623811">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1146757618776">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_selectedNode" id="1146757618777" />
                <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_GetParentOperation" id="1146757618778">
                  <node role="parameter" type="jetbrains.mps.bootstrap.smodelLanguage.OperationParm_Concept" id="1146757618779">
                    <link role="concept" targetNodeId="1.1092059087312" />
                  </node>
                </node>
              </node>
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1146757618775" />
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146764888741">
            <node role="expression" type="jetbrains.mps.baseLanguage.NotExpression" id="1146764889946">
              <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146764899824">
                <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]isInsideTemplateFragment((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.boolean/jetbrains.mps.baseLanguage.types.boolean))" />
                <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
                <node role="actualArgument" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_selectedNode" id="1146764902059" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_ExecuteFunction" id="1146757069340">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146757069341">
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1146760357262">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146760361280">
              <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]switchTemplateFragment((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.void/jetbrains.mps.baseLanguage.types.void))" />
              <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
              <node role="actualArgument" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_selectedNode" id="1146760364499" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapItem" id="1146763185637">
      <property name="description" value="add/remove node macro" />
      <node role="keystroke" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapKeystroke" id="1146763185638">
        <property name="modifiers" value="ctrl+shift" />
        <property name="keycode" value="VK_M" />
      </node>
      <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_IsApplicableFunction" id="1146763185639">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146763185640">
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146764783456">
            <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1146764785176">
              <property name="value" value="true" />
            </node>
          </node>
        </node>
      </node>
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_ExecuteFunction" id="1146763185641">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146763185642">
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1146764794381">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146764797695">
              <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
              <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]switchNodeMacro((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode])) : (jetbrains.mps.baseLanguage.types.void/jetbrains.mps.baseLanguage.types.void))" />
              <node role="actualArgument" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_selectedNode" id="1146764863895" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1088762125437">
    <property name="name" value="ReferenceMacro_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1088761943574" />
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1088763040904">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1088763156827">
        <property name="text" value="&lt; Reference Macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1088763156828">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1088763156829">
          <property name="text" value="referenceMacro_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1088763156830">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="ReferenceMacroProviderAspect" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1088763156831">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1140209834161">
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="-&gt;$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
      <property name="selectable" value="true" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapDeclaration" id="1088969011903">
    <property name="name" value="_ReferenceMacroSwitch_KeyMap" />
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapItem" id="1146765617426">
      <property name="description" value="add/remove reference macro" />
      <node role="keystroke" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapKeystroke" id="1146765617427">
        <property name="modifiers" value="ctrl+shift" />
        <property name="keycode" value="VK_M" />
      </node>
      <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_IsApplicableFunction" id="1146765617428">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146765617429">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146770038514">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146770038515">
              <property name="name" value="cell" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1146770038533">
                <link role="classifier" extResolveInfo="9.[Classifier]EditorCell" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146768862615">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146768843649" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.IfStatement" id="1146770071380">
            <node role="ifTrue" type="jetbrains.mps.baseLanguage.StatementList" id="1146770071382">
              <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146770091576">
                <node role="expression" type="jetbrains.mps.baseLanguage.BooleanConstant" id="1146770104921" />
              </node>
            </node>
            <node role="condition" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1146770088715">
              <node role="leftExpression" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_selectedNode" id="1146770081449" />
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146770081447">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorCell).([InstanceMethodDeclaration]getSNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146770081448">
                  <link role="variableDeclaration" targetNodeId="1146770038515" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146770175781">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146770190815">
              <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]canSwitchReferenceMacro((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell])) : (jetbrains.mps.baseLanguage.types.boolean/jetbrains.mps.baseLanguage.types.boolean))" />
              <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146770193707">
                <link role="variableDeclaration" targetNodeId="1146770038515" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_ExecuteFunction" id="1146765617430">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146765617431">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146766016219">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146766016220">
              <property name="name" value="cell" />
              <node role="type" type="jetbrains.mps.baseLanguage.ClassifierType" id="1146766016221">
                <link role="classifier" extResolveInfo="9.[Classifier]EditorCell" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146766029913">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146766023426" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1146766594804">
            <node role="expression" type="jetbrains.mps.baseLanguage.StaticMethodCall" id="1146766600040">
              <link role="classConcept" extResolveInfo="8.[Classifier]TemplateLanguageUtil" />
              <link role="baseMethodDeclaration" extResolveInfo="8.static method ([Classifier]TemplateLanguageUtil).([StaticMethodDeclaration]switchReferenceMacro((jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell])) : (jetbrains.mps.baseLanguage.types.void/jetbrains.mps.baseLanguage.types.void))" />
              <node role="actualArgument" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146766605401">
                <link role="variableDeclaration" targetNodeId="1146766016220" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapItem" id="1146768766123">
      <property name="description" value="remove reference macro" />
      <node role="keystroke" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMapKeystroke" id="1146768766124">
        <property name="modifiers" value="ctrl+shift" />
        <property name="keycode" value="VK_M" />
      </node>
      <node role="isApplicableFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_IsApplicableFunction" id="1146768766125">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146768766126">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146769424391">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146769424392">
              <property name="name" value="selectedNode" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1146769424393" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146769436407">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorCell).([InstanceMethodDeclaration]getSNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146769436408">
                  <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                  <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146769436409" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146768974154">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1146768982407">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146769455123">
                <link role="variableDeclaration" targetNodeId="1146769424392" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_IsInstanceOfOperation" id="1146768984830">
                <link role="concept" targetNodeId="1.1088761943574" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_ExecuteFunction" id="1146768766127">
        <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146768766128">
          <node role="statement" type="jetbrains.mps.baseLanguage.LocalVariableDeclarationStatement" id="1146769494352">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.LocalVariableDeclaration" id="1146769494353">
              <property name="name" value="referenceMacro" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeType" id="1146769494354" />
              <node role="initializer" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146769494355">
                <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorCell).([InstanceMethodDeclaration]getSNode() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [SNode]))" />
                <node role="instance" type="jetbrains.mps.baseLanguage.InstanceMethodCall" id="1146769494356">
                  <link role="baseMethodDeclaration" extResolveInfo="9.method ([Classifier]EditorContext).([InstanceMethodDeclaration]getSelectedCell() : (jetbrains.mps.baseLanguage.types.classifier/jetbrains.mps.baseLanguage.types.classifier [EditorCell]))" />
                  <node role="instance" type="jetbrains.mps.bootstrap.editorLanguage.CellKeyMap_FunctionParm_editorContext" id="1146769494357" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.ExpressionStatement" id="1146768997362">
            <node role="expression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1146768998739">
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.LocalVariableReference" id="1146769503561">
                <link role="variableDeclaration" targetNodeId="1146769494353" />
              </node>
              <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.Node_DeleteOperation" id="1146769000506" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1092060948911">
    <property name="name" value="TemplateDeclaration_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1092059087312" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1092060948912">
      <property name="drawBorder" value="false" />
      <property name="name" value="nodeBox" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1092060948913">
        <property name="drawBorder" value="false" />
        <property name="name" value="headerRow" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1092060948914">
          <property name="text" value="template:" />
          <property name="drawBorder" value="false" />
          <property name="selectable" value="true" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1092060948915">
          <property name="textBgColor" value="yellow" />
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;no name&gt;" />
          <property name="textBgColorSelected" value="cyan" />
          <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1092060945722">
        <property name="drawBorder" value="false" />
        <property name="name" value="separator" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1092826413145">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="true" />
        <property name="gridLayout" value="true" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1092826609045">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="false" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1092826609046">
            <property name="textBgColor" value="pink" />
            <property name="text" value="Ctrl-Shift-F" />
            <property name="drawBorder" value="false" />
            <property name="name" value="help3" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1092826609047">
            <property name="text" value="convert to template fragment" />
            <property name="drawBorder" value="false" />
          </node>
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1100116537416">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="false" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1100116537417">
            <property name="textBgColor" value="orange" />
            <property name="text" value="Ctrl-Shift-M" />
            <property name="drawBorder" value="false" />
            <property name="name" value="help1" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1100116537418">
            <property name="text" value="convert to macro" />
            <property name="drawBorder" value="false" />
          </node>
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1146604973776">
        <property name="drawBorder" value="false" />
        <property name="name" value="separator" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1092061173513">
        <property name="text" value="content node:" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefNode" id="1092135992437">
        <property name="substituteActionsFactoryId" value="TemplateDeclaration_ContentNode" />
        <property name="drawBorder" value="false" />
        <property name="noTargetText" value="&lt;no content node&gt;" />
        <link role="relationDeclaration" targetNodeId="1.1092060348987" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1095419078589">
    <property name="name" value="MappingConfiguration_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1095416546421" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419078590">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419078591">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419078592">
          <property name="text" value="mapping configuration:" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1095419078593">
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;no name&gt;" />
          <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419376938">
        <property name="drawBorder" value="false" />
        <property name="name" value="separator" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419376939">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419374859">
          <property name="text" value="    " />
          <property name="drawBorder" value="false" />
          <property name="name" value="indent" />
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419376940">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="true" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419376941">
            <property name="text" value="mapping rules:" />
            <property name="drawBorder" value="false" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419376942">
            <property name="drawBorder" value="false" />
            <property name="vertical" value="false" />
            <property name="selectable" value="false" />
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419418662">
              <property name="text" value="    " />
              <property name="drawBorder" value="false" />
              <property name="name" value="indent" />
              <property name="selectable" value="false" />
            </node>
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefNodeList" id="1095419418663">
              <property name="drawBorder" value="false" />
              <property name="vertical" value="true" />
              <property name="gridLayout" value="true" />
              <property name="selectable" value="false" />
              <link role="relationDeclaration" targetNodeId="1.1095416692159" />
            </node>
          </node>
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095423905610">
        <property name="drawBorder" value="false" />
        <property name="name" value="separator" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419459743">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419459744">
          <property name="text" value="    " />
          <property name="drawBorder" value="false" />
          <property name="name" value="indent" />
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419459745">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="true" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419459746">
            <property name="text" value="weaving rules:" />
            <property name="drawBorder" value="false" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419459747">
            <property name="drawBorder" value="false" />
            <property name="vertical" value="false" />
            <property name="selectable" value="false" />
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095419459748">
              <property name="text" value="    " />
              <property name="drawBorder" value="false" />
              <property name="name" value="indent" />
              <property name="selectable" value="false" />
            </node>
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefNodeList" id="1095419459749">
              <property name="drawBorder" value="false" />
              <property name="vertical" value="true" />
              <property name="gridLayout" value="true" />
              <property name="selectable" value="false" />
              <link role="relationDeclaration" targetNodeId="1.1095416692160" />
            </node>
          </node>
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1132882085313">
        <property name="drawBorder" value="false" />
        <property name="name" value="separator" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1132882085314">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1132882085315">
          <property name="text" value="    " />
          <property name="drawBorder" value="false" />
          <property name="name" value="indent" />
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1132882085316">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="true" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1132882085317">
            <property name="text" value="reduction rules:" />
            <property name="drawBorder" value="false" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1132882085318">
            <property name="drawBorder" value="false" />
            <property name="vertical" value="false" />
            <property name="selectable" value="false" />
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1132882085319">
              <property name="text" value="    " />
              <property name="drawBorder" value="false" />
              <property name="name" value="indent" />
              <property name="selectable" value="false" />
            </node>
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefNodeList" id="1132882085320">
              <property name="drawBorder" value="false" />
              <property name="vertical" value="true" />
              <property name="gridLayout" value="true" />
              <property name="selectable" value="false" />
              <link role="relationDeclaration" targetNodeId="1.1132881836530" />
            </node>
          </node>
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133123767598">
        <property name="drawBorder" value="false" />
        <property name="name" value="separator" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1133123767599">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133123767600">
          <property name="text" value="    " />
          <property name="drawBorder" value="false" />
          <property name="name" value="indent" />
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1133123767601">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="true" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133123767602">
            <property name="text" value="output root concepts:" />
            <property name="drawBorder" value="false" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1133123767603">
            <property name="drawBorder" value="false" />
            <property name="vertical" value="false" />
            <property name="selectable" value="false" />
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133123767604">
              <property name="text" value="    " />
              <property name="drawBorder" value="false" />
              <property name="name" value="indent" />
              <property name="selectable" value="false" />
            </node>
            <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefNodeList" id="1133123767605">
              <property name="drawBorder" value="false" />
              <property name="vertical" value="true" />
              <property name="gridLayout" value="true" />
              <property name="selectable" value="false" />
              <link role="relationDeclaration" targetNodeId="1.1132881767512" />
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1095419606578">
    <property name="name" value="MappingRule_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1095416572297" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095419606579">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095441898829">
        <property name="text" value="for each" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095441898830">
        <property name="drawBorder" value="false" />
        <property name="cellProviderId" value="templateMappingRule_SourceQuery_CellProvider" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095424336422">
        <property name="text" value="--&gt;" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1095419687662">
        <property name="allowEmptyText" value="true" />
        <property name="textBgColor" value="orange" />
        <property name="drawBorder" value="false" />
        <property name="noTargetText" value="&lt;no rule name&gt;" />
        <property name="textBgColorSelected" value="cyan" />
        <link role="relationDeclaration" targetNodeId="4.1078489098626" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095424336423">
        <property name="text" value=":" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1095420084444">
        <property name="drawBorder" value="false" />
        <property name="noTargetText" value="&lt;no template&gt;" />
        <link role="relationDeclaration" targetNodeId="1.1095417265990" />
        <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1095420084445">
          <link role="conceptDeclaration" targetNodeId="4.1078489098625" />
          <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1095420084446">
            <property name="drawBorder" value="false" />
            <property name="readOnly" value="true" />
            <property name="noTargetText" value="&lt;no name&gt;" />
            <link role="relationDeclaration" targetNodeId="4.1078489098626" />
          </node>
        </node>
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095442717471">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095442750740">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095442750741">
          <property name="text" value="templateMappingRule_SourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095442750742">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateMappingRule_SourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095442750743">
          <property name="text" value="()" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1095420477103">
    <property name="name" value="WeavingRule_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1095416624611" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095420477104">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095442717472">
        <property name="text" value="for each" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095442717473">
        <property name="drawBorder" value="false" />
        <property name="cellProviderId" value="templateWeavingRule_SourceQuery_CellProvider" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095421134218">
        <property name="text" value="--&gt;" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095676786799">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="true" />
        <property name="gridLayout" value="true" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1095676812694">
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;no template&gt;" />
          <link role="relationDeclaration" targetNodeId="1.1095418098242" />
          <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1095676812695">
            <link role="conceptDeclaration" targetNodeId="1.1092059087312" />
            <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1095676812696">
              <property name="drawBorder" value="false" />
              <property name="readOnly" value="true" />
              <property name="noTargetText" value="&lt;no name&gt;" />
              <link role="relationDeclaration" targetNodeId="4.1078489098626" />
            </node>
          </node>
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095676835588">
          <property name="drawBorder" value="false" />
          <property name="vertical" value="false" />
          <property name="selectable" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095676835589">
            <property name="text" value="context:" />
            <property name="drawBorder" value="false" />
            <property name="selectable" value="true" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095676835590">
            <property name="drawBorder" value="false" />
            <property name="cellProviderId" value="templateWeavingRule_Context_CellProvider" />
          </node>
        </node>
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095422932671">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095422932672">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095422932673">
          <property name="text" value="templateWeavingRule_SourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095422932674">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateWeavingRule_SourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095422932675">
          <property name="text" value="()" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095422932676">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095422932677">
          <property name="text" value="templateWeavingRule_Context_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095422932678">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateWeavingRule_Context_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095422932679">
          <property name="text" value="()" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1095672501074">
    <property name="name" value="TemplateFragment_Editor" />
    <link role="conceptDeclaration" targetNodeId="1.1095672379244" />
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095672654001">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095672654002">
        <property name="text" value="&lt;Template Fragment&gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1100694221900">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1100694221901">
          <property name="text" value="mapping name" />
          <property name="drawBorder" value="false" />
          <property name="nullText" value="&lt;none&gt;" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1100694221902">
          <property name="textBgColor" value="orange" />
          <property name="allowEmptyText" value="true" />
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;no name&gt;" />
          <property name="textBgColorSelected" value="cyan" />
          <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1095757990766">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095757990767">
          <property name="text" value="templateFragment_Context_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1095757990768">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateFragment_Context_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1095757990769">
          <property name="text" value="()" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1096109716628">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1096109764800">
        <property name="textBgColor" value="pink" />
        <property name="text" value="&lt;TF" />
        <property name="drawBorder" value="false" />
        <property name="textBgColorSelected" value="magenta" />
        <property name="selectable" value="true" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1100694105555">
        <property name="textBgColor" value="orange" />
        <property name="drawBorder" value="false" />
        <property name="textBgColorSelected" value="cyan" />
        <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        <node role="renderingCondition" type="jetbrains.mps.bootstrap.editorLanguage.QueryFunction_NodeCondition" id="1146604643746">
          <node role="body" type="jetbrains.mps.baseLanguage.StatementList" id="1146604643747">
            <node role="statement" type="jetbrains.mps.baseLanguage.ReturnStatement" id="1146604692957">
              <node role="expression" type="jetbrains.mps.baseLanguage.NotEqualsExpression" id="1146604723411">
                <node role="leftExpression" type="jetbrains.mps.bootstrap.smodelLanguage.SNodeOperationExpression" id="1146604697085">
                  <node role="leftExpression" type="jetbrains.mps.bootstrap.editorLanguage.NodeCondition_FunctionParm_node" id="1146604695490" />
                  <node role="nodeOperation" type="jetbrains.mps.bootstrap.smodelLanguage.SPropertyAccess" id="1146604698398">
                    <link role="property" targetNodeId="4.1078489098626" />
                  </node>
                </node>
                <node role="rightExpression" type="jetbrains.mps.baseLanguage.NullLiteral" id="1146604704386" />
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1112731832583">
    <link role="conceptDeclaration" targetNodeId="1.1112731569622" />
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1112732002603">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112732044745">
        <property name="text" value="&lt; Switch Macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1112732044746">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112732044747">
          <property name="text" value="templateSourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1112732044748">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112732044749">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112738412383">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1112738370678">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112738412384">
          <property name="text" value="template switch" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1112738412385">
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;choose template switch&gt;" />
          <link role="relationDeclaration" targetNodeId="1.1112731629154" />
          <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1112738378725">
            <link role="conceptDeclaration" targetNodeId="1.1112730859144" />
            <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1112738412386">
              <property name="drawBorder" value="false" />
              <property name="readOnly" value="true" />
              <property name="noTargetText" value="&lt;no name&gt;" />
              <link role="relationDeclaration" targetNodeId="4.1078489098626" />
            </node>
          </node>
        </node>
      </node>
    </node>
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112737925990">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$SWITCH$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1112732167706">
    <link role="conceptDeclaration" targetNodeId="1.1112730859144" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1112732179003">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1113324878579">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1113324878580">
          <property name="text" value="template switch" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1113324878581">
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;no name&gt;" />
          <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1113324878582">
          <property name="text" value="modifies" />
          <property name="drawBorder" value="false" />
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1113324878583">
          <property name="drawBorder" value="false" />
          <property name="noTargetText" value="&lt;none&gt;" />
          <link role="relationDeclaration" targetNodeId="1.1112820671508" />
          <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1113324878584">
            <link role="conceptDeclaration" targetNodeId="1.1112730859144" />
            <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1113324878585">
              <property name="drawBorder" value="false" />
              <property name="readOnly" value="true" />
              <property name="noTargetText" value="&lt;no name&gt;" />
              <link role="relationDeclaration" targetNodeId="4.1078489098626" />
            </node>
          </node>
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112732307916">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1112732228505">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <property name="selectable" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112732307917">
          <property name="text" value="    " />
          <property name="drawBorder" value="false" />
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefNodeList" id="1112732307918">
          <property name="separatorText" value=" " />
          <property name="drawBorder" value="false" />
          <property name="vertical" value="true" />
          <property name="gridLayout" value="true" />
          <property name="selectable" value="false" />
          <link role="relationDeclaration" targetNodeId="1.1112731464728" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1112732352606">
    <link role="conceptDeclaration" targetNodeId="1.1112730955130" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1112732806310">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112733509077">
        <property name="text" value="case" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1112733509078">
        <property name="drawBorder" value="false" />
        <property name="cellProviderId" value="semanticNodeCondition_CellProvider" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1112733509079">
        <property name="text" value="  : " />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1112804833058">
        <property name="drawBorder" value="false" />
        <property name="noTargetText" value="&lt;no template - skip source&gt;" />
        <link role="relationDeclaration" targetNodeId="1.1112804745009" />
        <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1112804790541">
          <link role="conceptDeclaration" targetNodeId="1.1092059087312" />
          <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1112804833059">
            <property name="drawBorder" value="false" />
            <property name="readOnly" value="true" />
            <link role="relationDeclaration" targetNodeId="4.1078489098626" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1112911659681">
    <link role="conceptDeclaration" targetNodeId="1.1112911581741" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1112911714074">
      <property name="drawBorder" value="false" />
      <property name="noTargetText" value="&lt;choose switch&gt;" />
      <link role="relationDeclaration" targetNodeId="1.1112911598335" />
      <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1112911678104">
        <link role="conceptDeclaration" targetNodeId="1.1112730859144" />
        <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1112911714075">
          <property name="drawBorder" value="false" />
          <property name="readOnly" value="true" />
          <property name="noTargetText" value="&lt;no name&gt;" />
          <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1114458549484">
    <link role="conceptDeclaration" targetNodeId="1.1114458327664" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1114458600627">
      <property name="substituteActionsFactoryId" value="ConceptDeclarationReference_ConceptDeclaration" />
      <property name="drawBorder" value="false" />
      <property name="noTargetText" value="&lt;choose concept declaration&gt;" />
      <link role="relationDeclaration" targetNodeId="1.1114458346385" />
      <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1114458566423">
        <link role="conceptDeclaration" targetNodeId="6.1071489090640" />
        <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1114458600628">
          <property name="drawBorder" value="false" />
          <property name="readOnly" value="true" />
          <property name="noTargetText" value="&lt;no name&gt;" />
          <link role="relationDeclaration" targetNodeId="4.1078489098626" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1114458648191">
    <link role="conceptDeclaration" targetNodeId="1.1114456532170" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1114461204693">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114461360775">
        <property name="text" value="case:" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1114461360776">
        <property name="drawBorder" value="false" />
        <property name="cellProviderId" value="reductionRuleCondition_AspectId" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114461360777">
        <property name="text" value="--&gt;" />
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_RefCell" id="1132950999824">
        <property name="drawBorder" value="false" />
        <property name="noTargetText" value="&lt;no template&gt;" />
        <link role="relationDeclaration" targetNodeId="1.1132950837789" />
        <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.InlineEditorComponent" id="1132950999823">
          <link role="conceptDeclaration" targetNodeId="1.1092059087312" />
          <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Property" id="1132951007170">
            <property name="drawBorder" value="false" />
            <property name="readOnly" value="true" />
            <link role="relationDeclaration" targetNodeId="4.1078489098626" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1114707211025">
    <link role="conceptDeclaration" targetNodeId="1.1118773211870" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114709637381">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$IF$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1114709712821">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114709792729">
        <property name="text" value="&lt; conditional macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1114709792730">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114709792731">
          <property name="text" value="nodeCondition_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1114709792732">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="semanticNodeCondition_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114709792733">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114709792734">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1114729546995">
    <link role="conceptDeclaration" targetNodeId="1.1114729360583" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114729602402">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$COPY_SRCL$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1114729602403">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114729602404">
        <property name="text" value="&lt; Copy Src List of Nodes macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1114729602405">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114729602406">
          <property name="text" value="templateSourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1114729602407">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114729602408">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1114729602409">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1118773368750">
    <link role="conceptDeclaration" targetNodeId="1.1114706874351" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118773368751">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$COPY_SRC$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1118773368752">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118773368753">
        <property name="text" value="&lt; Copy Src Node macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1118773368754">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118773368755">
          <property name="text" value="templateSourceNodeQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1118773368756">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceNodeQueryId" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118773368757">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1118786597045">
    <link role="conceptDeclaration" targetNodeId="1.1118786554307" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118786597046">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$LOOP$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1118786597047">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118786597048">
        <property name="text" value="&lt; loop macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1118786597049">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118786597050">
          <property name="text" value="templateSourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1118786597051">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118786597052">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1118786597053">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1131073370410">
    <link role="conceptDeclaration" targetNodeId="1.1131073187192" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073370411">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$MAP_SRC$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1131073370412">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073370413">
        <property name="text" value="&lt; map src node macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1131073370414">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073370415">
          <property name="text" value="templateSourceNodeQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1131073370416">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceNodeQueryId_Optional" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073370417">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1131073696555">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073696556">
          <property name="text" value="templateSourceNodeMapper_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1131073696557">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceNodeMapperId" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073696558">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1131073370418">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.ConceptEditorDeclaration" id="1133037934981">
    <link role="conceptDeclaration" targetNodeId="1.1133037731736" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133037959673">
      <property name="editable" value="true" />
      <property name="textFgColor" value="DARK_BLUE" />
      <property name="text" value="$MAP_SRCL$" />
      <property name="fontStyle" value="BOLD_ITALIC" />
      <property name="drawBorder" value="false" />
      <property name="textBgColorSelected" value="cyan" />
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1133038004770">
      <property name="drawBorder" value="false" />
      <property name="vertical" value="true" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133038004771">
        <property name="text" value="&lt; map src nodes macro &gt;" />
        <property name="drawBorder" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1133038004772">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133038004773">
          <property name="text" value="templateSourceQuery_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1133038004774">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceQuery_CellProvider" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133038004775">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Collection" id="1133038043414">
        <property name="drawBorder" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133038043415">
          <property name="text" value="templateSourceNodeMapper_" />
          <property name="drawBorder" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Custom" id="1133038043416">
          <property name="drawBorder" value="false" />
          <property name="cellProviderId" value="templateSourceNodeMapperId" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133038043417">
          <property name="text" value="(..)" />
          <property name="drawBorder" value="false" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.CellModel_Constant" id="1133038004780">
        <property name="drawBorder" value="false" />
        <property name="selectable" value="false" />
      </node>
    </node>
  </node>
</model>

