<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.mpsLayoutLanguage.editor">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.bootstrap.editorLanguage" />
  <language namespace="jetbrains.mps.baseLanguage.ext.collections.lang">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.ext.collections.lang.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="0" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.actionsLanguage" />
  <language namespace="jetbrains.mps.bootstrap.constraintsLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.constraintsLanguage.structure" version="0" />
  </language>
  <languageAspect modelUID="jetbrains.mps.buildlanguage.constraints" version="6" />
  <languageAspect modelUID="jetbrains.mps.buildlanguage.structure" version="16" />
  <maxImportIndex value="5" />
  <import index="1" modelUID="jetbrains.mps.mpsLayoutLanguage.structure" version="-1" />
  <import index="2" modelUID="jetbrains.mps.core.structure" version="-1" />
  <import index="3" modelUID="jetbrains.mps.nodeEditor@java_stub" version="-1" />
  <import index="4" modelUID="java.awt.color@java_stub" version="-1" />
  <import index="5" modelUID="java.awt@java_stub" version="-1" />
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1202917336768">
    <link role="conceptDeclaration" targetNodeId="1.1202916958754" resolveInfo="MPS" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1202917360631">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203614630183">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1203614743774">
          <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1203614651921">
          <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203430907103">
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204114261650">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204114265324">
          <property name="text" value="basedir" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204114274013">
          <link role="relationDeclaration" targetNodeId="1.1204114229489" resolveInfo="basedir" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204116139217">
          <property name="text" value="set" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204116144985">
          <link role="relationDeclaration" targetNodeId="1.1204116114324" resolveInfo="setBasedir" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204707271675">
        <property name="selectable" value="false" />
        <property name="vertical" value="true" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204707272710">
          <property name="selectable" value="false" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204707272711">
          <property name="selectable" value="false" />
          <property name="vertical" value="false" />
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204707272712">
            <property name="text" value="project home" />
            <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
          </node>
          <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefCell" id="1204707272713">
            <link role="relationDeclaration" targetNodeId="1.1204706457824" />
            <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.structure.InlineEditorComponent" id="1204707272714">
              <link role="conceptDeclaration" targetNodeId="1.1203617883391" resolveInfo="ICompositeComponent" />
              <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204707272715">
                <property name="readOnly" value="true" />
                <property name="allowEmptyText" value="true" />
                <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
              </node>
            </node>
          </node>
        </node>
        <node role="renderingCondition" type="jetbrains.mps.bootstrap.editorLanguage.structure.QueryFunction_NodeCondition" id="1204707330618">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204707330619">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204707331762">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204707331763">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204707331764">
                  <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptFunctionParameter_node" id="1204707331765" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1204707331766">
                    <link role="link" targetNodeId="1.1204706457824" />
                  </node>
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_IsNotNullOperation" id="1204707331767" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204706540746">
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204115922983">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204115928548">
          <property name="text" value="configurations" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList" id="1204115937925">
          <property name="separatorText" value="," />
          <link role="relationDeclaration" targetNodeId="1.1204115898932" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204115917809">
        <property name="selectable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList" id="1203599373311">
        <property name="vertical" value="true" />
        <property name="selectable" value="false" />
        <link role="relationDeclaration" targetNodeId="1.1203599325709" />
        <node role="emptyCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203599381407">
          <property name="text" value="&lt;components&gt;" />
          <link role="styleClass" targetNodeId="1203012208595" resolveInfo="hint" />
        </node>
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204707060234">
      <property name="selectable" value="false" />
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204707060235">
        <property name="text" value="project home" />
        <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefCell" id="1204707060236">
        <link role="relationDeclaration" targetNodeId="1.1204706457824" />
        <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.structure.InlineEditorComponent" id="1204707060237">
          <link role="conceptDeclaration" targetNodeId="1.1203617883391" resolveInfo="ICompositeComponent" />
          <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204707060238">
            <property name="readOnly" value="true" />
            <property name="allowEmptyText" value="true" />
            <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.StyleSheet" id="1203012198750">
    <property name="name" value="MPSLayoutStyles" />
    <node role="styleClass" type="jetbrains.mps.bootstrap.editorLanguage.structure.StyleSheetClass" id="1203012208595">
      <property name="name" value="hint" />
      <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.ForegroundColorStyleSheetItem" id="1203012217846">
        <property name="color" value="lightGray" />
      </node>
    </node>
    <node role="styleClass" type="jetbrains.mps.bootstrap.editorLanguage.structure.StyleSheetClass" id="1203598923024">
      <property name="name" value="keyword" />
      <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.ForegroundColorStyleSheetItem" id="1203598935275">
        <property name="color" value="darkGray" />
      </node>
    </node>
    <node role="styleClass" type="jetbrains.mps.bootstrap.editorLanguage.structure.StyleSheetClass" id="1203598953979">
      <property name="name" value="projectComponent" />
      <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.ForegroundColorStyleSheetItem" id="1203598969200">
        <property name="color" value="DARK_BLUE" />
      </node>
      <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.FontStyleStyleSheetItem" id="1204130052524">
        <property name="style" value="BOLD" />
      </node>
    </node>
    <node role="styleClass" type="jetbrains.mps.bootstrap.editorLanguage.structure.StyleSheetClass" id="1204115710587">
      <property name="name" value="configuration" />
      <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.ForegroundColorStyleSheetItem" id="1204115722526">
        <property name="color" value="query" />
        <node role="query" type="jetbrains.mps.bootstrap.editorLanguage.structure.QueryFunction_Color" id="1204705974203">
          <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204705974204">
            <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204706136934">
              <node role="expression" type="jetbrains.mps.baseLanguage.structure.StaticFieldReference" id="1204706136935">
                <link role="classifier" targetNodeId="5.~Color" resolveInfo="Color" />
                <link role="variableDeclaration" targetNodeId="5.~Color.WHITE" resolveInfo="WHITE" />
              </node>
            </node>
          </node>
        </node>
      </node>
      <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.BackgroundColorStyleSheetItem" id="1204129851721">
        <property name="color" value="gray" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1203598531022">
    <link role="conceptDeclaration" targetNodeId="1.1203598417283" resolveInfo="Jar" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203598537540">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203599089957">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1203599093069">
          <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
          <link role="styleClass" targetNodeId="1203598953979" resolveInfo="projectComponent" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1203599103055">
          <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204128139480">
          <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203598578375">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Indent" id="1203598580877" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList" id="1203598588660">
          <property name="vertical" value="true" />
          <property name="selectable" value="false" />
          <link role="relationDeclaration" targetNodeId="1.1203617897549" />
          <node role="emptyCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203599011357">
            <property name="text" value="&lt;entries&gt;" />
            <link role="styleClass" targetNodeId="1203012208595" resolveInfo="hint" />
          </node>
        </node>
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204116827310">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204116828311">
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204116828312">
          <property name="text" value="excludes" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204116828313">
          <property name="allowEmptyText" value="true" />
          <link role="relationDeclaration" targetNodeId="1.1204107522064" resolveInfo="excludes" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204116832456">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1203598612021">
    <link role="conceptDeclaration" targetNodeId="1.1203598322527" resolveInfo="File" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203598619601">
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1203599074970">
        <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
        <link role="styleClass" targetNodeId="1203598953979" resolveInfo="projectComponent" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1203598625838">
        <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203598633261">
        <property name="text" value="from" />
        <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode" id="1203602068954">
        <property name="attractsFocus" value="2" />
        <link role="relationDeclaration" targetNodeId="1.1203601963019" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204128152423">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204116787222">
      <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1203598704377">
    <link role="conceptDeclaration" targetNodeId="1.1203598512427" resolveInfo="Folder" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203598726332">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203598730256">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1203599137432">
          <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
          <link role="styleClass" targetNodeId="1203598953979" resolveInfo="projectComponent" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1203598734211">
          <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203598738479">
          <property name="text" value="from" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode" id="1203602196974">
          <property name="attractsFocus" value="2" />
          <link role="relationDeclaration" targetNodeId="1.1203602106051" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204128147077">
          <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203598754734">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Indent" id="1203598757236" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList" id="1203598761160">
          <property name="vertical" value="true" />
          <property name="selectable" value="false" />
          <link role="relationDeclaration" targetNodeId="1.1203617897549" />
          <node role="emptyCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203599044452">
            <property name="text" value="&lt;entries&gt;" />
            <link role="styleClass" targetNodeId="1203012208595" resolveInfo="hint" />
          </node>
        </node>
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204116805241">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204116806413">
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204116806414">
          <property name="text" value="excludes" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204116806415">
          <property name="allowEmptyText" value="true" />
          <link role="relationDeclaration" targetNodeId="1.1204107522064" resolveInfo="excludes" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204116811825">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1203599720833">
    <link role="conceptDeclaration" targetNodeId="1.1203599702327" resolveInfo="Module" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203599725664">
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1203599729042">
        <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
        <link role="styleClass" targetNodeId="1203598953979" resolveInfo="projectComponent" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1203607522476">
        <link role="relationDeclaration" targetNodeId="1.1203607480207" resolveInfo="modulelUID" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204128133822">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204116838270">
      <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1203602073283">
    <link role="conceptDeclaration" targetNodeId="1.1203601915645" resolveInfo="Source" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1203602078144">
      <link role="relationDeclaration" targetNodeId="1.1203601923911" resolveInfo="path" />
      <link role="actionMap" targetNodeId="1204017018614" resolveInfo="CompositeSource_RT" />
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1203603529883">
    <link role="conceptDeclaration" targetNodeId="1.1203603490707" resolveInfo="CompositSource" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1203605104985">
      <property name="vertical" value="false" />
      <link role="actionMap" targetNodeId="1204017018614" resolveInfo="CompositeSource_RT" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode" id="1203605107017">
        <link role="relationDeclaration" targetNodeId="1.1203605077185" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1203605112878">
        <property name="text" value="/" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode" id="1203605120208">
        <property name="attractsFocus" value="2" />
        <link role="relationDeclaration" targetNodeId="1.1203605085483" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1204015167480">
    <link role="conceptDeclaration" targetNodeId="1.1204015075559" resolveInfo="Copy" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204015197022">
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1204015203776">
        <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
        <link role="styleClass" targetNodeId="1203598953979" resolveInfo="projectComponent" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204015210358">
        <property name="text" value="from" />
        <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode" id="1204015218159">
        <property name="attractsFocus" value="2" />
        <link role="relationDeclaration" targetNodeId="1.1204015133936" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204128157362">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204116771683">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204116772622">
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204116772623">
          <property name="text" value="excludes" />
          <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204116772624">
          <property name="allowEmptyText" value="true" />
          <link role="relationDeclaration" targetNodeId="1.1204107538752" resolveInfo="excludes" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204116777955">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="configurationReferences_editorComponent" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapDeclaration" id="1204017018614">
    <property name="name" value="CompositeSource_RT" />
    <link role="applicableConcept" targetNodeId="1.1203601915645" resolveInfo="Source" />
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapItem" id="1204017029553">
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_ExecuteFunction" id="1204017029554">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204017029555">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement" id="1204017141668">
            <node role="localVariableDeclaration" type="jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration" id="1204017141669">
              <property name="name" value="newCompositSource" />
              <node role="type" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1204017141670">
                <link role="concept" targetNodeId="1.1203603490707" resolveInfo="CompositSource" />
              </node>
              <node role="initializer" type="jetbrains.mps.baseLanguage.structure.GenericNewExpression" id="1204017141671">
                <node role="creator" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeCreator" id="1204017141672">
                  <node role="createdType" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SNodeType" id="1204017141673">
                    <link role="concept" targetNodeId="1.1203603490707" resolveInfo="CompositSource" />
                  </node>
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204017141674">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204017141675">
              <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_FunctionParm_selectedNode" id="1204017157454" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ReplaceWithAnotherOperation" id="1204017141677">
                <node role="parameter" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1204017141678">
                  <link role="variableDeclaration" targetNodeId="1204017141669" resolveInfo="newCompositSource" />
                </node>
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204017141679">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204017141680">
              <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204017141681">
                <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1204017141682">
                  <link role="variableDeclaration" targetNodeId="1204017141669" resolveInfo="newCompositSource" />
                </node>
                <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1204017141683">
                  <link role="link" targetNodeId="1.1203605077185" />
                </node>
              </node>
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Link_SetTargetOperation" id="1204017141684">
                <node role="parameter" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_FunctionParm_selectedNode" id="1204017162314" />
              </node>
            </node>
          </node>
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204708672262">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204708673530">
              <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptFunctionParameter_editorContext" id="1204708672263" />
              <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204708705196">
                <link role="baseMethodDeclaration" targetNodeId="3.~EditorContext.selectLater(jetbrains.mps.smodel.SNode):void" resolveInfo="selectLater" />
                <node role="actualArgument" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204708716088">
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.LocalVariableReference" id="1204708714509">
                    <link role="variableDeclaration" targetNodeId="1204017141669" resolveInfo="newCompositSource" />
                  </node>
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1204708718934">
                    <link role="link" targetNodeId="1.1203605085483" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1204115676160">
    <link role="conceptDeclaration" targetNodeId="1.1204115658627" resolveInfo="Configuration" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204115682334">
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204115701868">
        <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
        <link role="styleClass" targetNodeId="1204115710587" resolveInfo="configuration" />
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1204115863411">
    <link role="conceptDeclaration" targetNodeId="1.1204115822363" resolveInfo="ConfigurationReference" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefCell" id="1204115867975">
      <link role="relationDeclaration" targetNodeId="1.1204115847973" />
      <node role="editorComponent" type="jetbrains.mps.bootstrap.editorLanguage.structure.InlineEditorComponent" id="1204115867976">
        <link role="conceptDeclaration" targetNodeId="1.1204115658627" resolveInfo="Configuration" />
        <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1204115874150">
          <property name="readOnly" value="true" />
          <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
          <link role="styleClass" targetNodeId="1204115710587" resolveInfo="configuration" />
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.EditorComponentDeclaration" id="1204116610828">
    <property name="name" value="ConfigurationReferencesEditorComponent" />
    <link role="conceptDeclaration" targetNodeId="1.1203598300291" resolveInfo="AbstractProjectComponent" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204299963611">
      <property name="vertical" value="false" />
      <property name="selectable" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204299963612">
        <property name="text" value="include in" />
        <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList" id="1204299963613">
        <property name="separatorText" value="," />
        <link role="relationDeclaration" targetNodeId="1.1204116468206" />
        <node role="emptyCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204299963614">
          <property name="text" value="&lt;any configuration&gt;" />
          <link role="styleClass" targetNodeId="1203012208595" resolveInfo="hint" />
        </node>
      </node>
      <node role="renderingCondition" type="jetbrains.mps.bootstrap.editorLanguage.structure.QueryFunction_NodeCondition" id="1204299963615">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204299963616">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204299963617">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.OrExpression" id="1204299963618">
              <node role="rightExpression" type="jetbrains.mps.baseLanguage.structure.ParenthesizedExpression" id="1204299963619">
                <node role="expression" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.SequenceOperationExpression" id="1204299963620">
                  <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.Expression" id="1204299963621" />
                  <node role="operand" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204299963622">
                    <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptFunctionParameter_node" id="1204299963623" />
                    <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkListAccess" id="1204299963624">
                      <link role="link" targetNodeId="1.1204116468206" />
                    </node>
                  </node>
                  <node role="operation" type="jetbrains.mps.baseLanguage.ext.collections.lang.structure.IsNotEmptyOperation" id="1204299963625" />
                </node>
              </node>
              <node role="leftExpression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204299963626">
                <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptFunctionParameter_editorContext" id="1204299963627" />
                <node role="operation" type="jetbrains.mps.baseLanguage.structure.InstanceMethodCallOperation" id="1204299963628">
                  <link role="baseMethodDeclaration" targetNodeId="3.~EditorContext.isInspector():boolean" resolveInfo="isInspector" />
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapDeclaration" id="1204705662485">
    <property name="name" value="CompositeSource_DeleteAction" />
    <link role="applicableConcept" targetNodeId="1.1203603490707" resolveInfo="CompositeSource" />
    <node role="item" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMapItem" id="1204705713589">
      <property name="actionId" value="delete_action_id" />
      <property name="description" value="remove last folder" />
      <node role="executeFunction" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_ExecuteFunction" id="1204705713590">
        <node role="body" type="jetbrains.mps.baseLanguage.structure.StatementList" id="1204705713591">
          <node role="statement" type="jetbrains.mps.baseLanguage.structure.ExpressionStatement" id="1204705754193">
            <node role="expression" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204705755211">
              <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_FunctionParm_selectedNode" id="1204705754194" />
              <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.Node_ReplaceWithAnotherOperation" id="1204705757635">
                <node role="parameter" type="jetbrains.mps.baseLanguage.structure.DotExpression" id="1204705760404">
                  <node role="operand" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellActionMap_FunctionParm_selectedNode" id="1204705759606" />
                  <node role="operation" type="jetbrains.mps.bootstrap.smodelLanguage.structure.SLinkAccess" id="1204705778003">
                    <link role="link" targetNodeId="1.1203605077185" />
                  </node>
                </node>
              </node>
            </node>
          </node>
        </node>
      </node>
    </node>
  </node>
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1204815116211">
    <link role="conceptDeclaration" targetNodeId="1.1204815005202" resolveInfo="ModuleFromFile" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1204815118338">
      <property name="vertical" value="false" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1204815118339">
        <link role="styleClass" targetNodeId="1203598953979" resolveInfo="projectComponent" />
        <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1204815241449">
        <property name="text" value="from" />
        <link role="styleClass" targetNodeId="1203598923024" resolveInfo="keyword" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNode" id="1204815285088">
        <property name="attractsFocus" value="2" />
        <link role="relationDeclaration" targetNodeId="1.1204815042908" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204815393862">
        <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="ConfigurationReferencesEditorComponent" />
      </node>
    </node>
    <node role="inspectedCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Component" id="1204815401317">
      <link role="editorComponent" targetNodeId="1204116610828" resolveInfo="ConfigurationReferencesEditorComponent" />
    </node>
  </node>
</model>

