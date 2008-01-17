<?xml version="1.0" encoding="UTF-8"?>
<model name="jetbrains.mps.propertylanguage.editor">
  <persistence version="1" />
  <refactoringHistory />
  <language namespace="jetbrains.mps.bootstrap.editorLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.editorLanguage.structure" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.editorLanguage.editor" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.editorLanguage.constraints" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.editorLanguage.actions" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.editorLanguage.helgins" version="-1" />
  </language>
  <language namespace="jetbrains.mps.baseLanguage">
    <languageAspect modelUID="jetbrains.mps.baseLanguage.structure" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.intentions" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.actions" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.editor" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.findUsages" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.constraints" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.scripts" version="-1" />
    <languageAspect modelUID="jetbrains.mps.baseLanguage.helgins" version="-1" />
  </language>
  <language namespace="jetbrains.mps.bootstrap.smodelLanguage">
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.actions" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.structure" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.scripts" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.helgins" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.constraints" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.intentions" version="-1" />
    <languageAspect modelUID="jetbrains.mps.bootstrap.smodelLanguage.editor" version="-1" />
  </language>
  <maxImportIndex value="4" />
  <import index="1" modelUID="jetbrains.mps.propertylanguage.structure" version="-1" />
  <import index="2" modelUID="jetbrains.mps.core.structure" version="-1" />
  <import index="3" modelUID="jetbrains.mps.buildlanguage.editor" version="-1" />
  <import index="4" modelUID="jetbrains.mps.buildlanguage.structure" version="6" />
  <node type="jetbrains.mps.bootstrap.editorLanguage.structure.ConceptEditorDeclaration" id="1200505270682">
    <link role="conceptDeclaration" targetNodeId="1.1200504738494" resolveInfo="PropertyNode" />
    <node role="cellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1200505277122">
      <property name="vertical" value="true" />
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Collection" id="1200505279858">
        <property name="selectable" value="false" />
        <property name="vertical" value="false" />
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_ConceptProperty" id="1200505285985">
          <link role="relationDeclaration" targetNodeId="2.1137473891462" resolveInfo="alias" />
        </node>
        <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Property" id="1200505291268">
          <link role="relationDeclaration" targetNodeId="2.1169194664001" resolveInfo="name" />
        </node>
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1200505296645">
        <property name="selectable" value="false" />
        <property name="editable" value="false" />
      </node>
      <node role="childCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_RefNodeList" id="1200505324007">
        <property name="vertical" value="true" />
        <property name="selectable" value="false" />
        <link role="relationDeclaration" targetNodeId="1.1200504738496" />
        <node role="emptyCellModel" type="jetbrains.mps.bootstrap.editorLanguage.structure.CellModel_Constant" id="1200505331367">
          <property name="text" value="&lt;property declarations&gt;" />
          <link role="styleClass" targetNodeId="3.1200419086632" resolveInfo="prompting" />
        </node>
      </node>
    </node>
  </node>
</model>

