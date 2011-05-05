package jetbrains.mps.tests;

/*Generated by MPS */

import jetbrains.mps.testbench.junit.runners.ModuleSymbolicSuite;
import org.junit.runner.RunWith;

@ModuleSymbolicSuite.ModuleClassSymbols(classes = {"jetbrains.mps.editorTest.AnonymousClassTest_Test", "jetbrains.mps.editorTest.AssignmentTest_Test", "jetbrains.mps.editorTest.BadCodeInTheLeftTest_Test", "jetbrains.mps.editorTest.BadCodeTest_Test", "jetbrains.mps.editorTest.EqualsTest_Test", "jetbrains.mps.editorTest.ForEachTest_Test", "jetbrains.mps.editorTest.ForTest_Test", "jetbrains.mps.editorTest.RemoveNodeTest_Test", "jetbrains.mps.editorTest.ReturnNullTest_Test", "jetbrains.mps.editorTest.IfAndElseTest_Test", "jetbrains.mps.editorTest.TwoPlusTwo_Test", "jetbrains.mps.editorTest.SelectTwoCells_Test", "jetbrains.mps.editorTest.IntentionTest_Test", "jetbrains.mps.editorTest.TwoMullTwo_Test", "jetbrains.mps.editorTest.RightTransformInAnnotation_Test", "jetbrains.mps.editorTest.RightTransform_Test", "jetbrains.mps.editorTest.AssignmentExpression_Test", "jetbrains.mps.editorTest.STHintTest_Test", "jetbrains.mps.editorTest.RightTransformWithSmallPatternCompletion_Test", "jetbrains.mps.editorTest.AssigningToField_Test", "jetbrains.mps.editorTest.DeleteStatement_Test", "jetbrains.mps.editorTest.DeleteVariableInitializer_Test", "jetbrains.mps.editorTest.DeleteFieldReference_Test", "jetbrains.mps.editorTest.IntSpaceA_Test", "jetbrains.mps.editorTest.MathE_Test", "jetbrains.mps.editorTest.DeleteFirstChild_Test", "jetbrains.mps.editorTest.DeleteOverridenMethodInBehavior_Test", "jetbrains.mps.editorTest.smartStatementsInsert_Test", "jetbrains.mps.editorTest.SidedeleteAtTheEnd_Test", "jetbrains.mps.editorTest.SidedeleteAtStart_Test", "jetbrains.mps.editorTest.SidedeleteAtStartOfIf_Test", "jetbrains.mps.editorTest.SidedeleteAtEndWithOneStatement_Test", "jetbrains.mps.editorTest.InsertBeforeInIf_Test", "jetbrains.mps.editorTest.PressingEndWithSelectedNode_Test", "jetbrains.mps.editorTest.BracesTest_Test", "jetbrains.mps.editorTest.TypeToTypeof_Test", "jetbrains.mps.editorTest.AnnotationSelection_Test", "jetbrains.mps.editorTest.ActionAtFirstPostionProblem_Test", "jetbrains.mps.editorTest.CompexTransformTest_Test", "jetbrains.mps.editorTest.SideDeleteAtEndWithBackSpace_Test", "jetbrains.mps.editorTest.AssignLeftTransform_Test", "jetbrains.mps.editorTest.DotExpression_Test", "jetbrains.mps.editorTest.LeftTransformOfDotOperation_Test", "jetbrains.mps.editorTest.SurrondByParensesis_Test", "jetbrains.mps.editorTest.ReplacingSelection_Test", "jetbrains.mps.editorTest.EnterAfterElseIf_Test", "jetbrains.mps.editorTest.PressingBackspaseInFirstPosition_Test", "jetbrains.mps.editorTest.PressingDelInLastPosition_Test", "jetbrains.mps.editorTest.SelectionByShiftArrows_Test", "jetbrains.mps.editorTest.MovingNode_Test", "jetbrains.mps.editorTest.MoveNodeRange_Test", "jetbrains.mps.editorTest.DefaultCellInfoTest_Test", "jetbrains.mps.editorTest.RestoreCellSelection_Test", "jetbrains.mps.editorTest.RestoreRangeSeletion_Test", "jetbrains.mps.editorTest.AssociativityProblem_Test", "jetbrains.mps.editorTest.PriorityProblem_Test", "jetbrains.mps.editorTest.EditorCellSomeProblem_Test", "jetbrains.mps.editorTest.CaretInStaticMethodCall_Test", "jetbrains.mps.editorTest.ConflictingRigthTransform_Test", "jetbrains.mps.editorTest.TypingIncorrectTextInFields_Test", "jetbrains.mps.editorTest.InsertBeforeUnaryMinus_Test", "jetbrains.mps.editorTest.InterWithNonLabelSelected_Test", "jetbrains.mps.editorTest.FieldDeletion_Test", "jetbrains.mps.editorTest.WrappingCellShouldntBeSelectable_Test", "jetbrains.mps.editorTest.DeleteIfPossibleMethod_Test", "jetbrains.mps.editorTest.IntelligentInputWithSubstitutionChooser_Test", "jetbrains.mps.editorTest.ReplacePlusWithMinus_Test", "jetbrains.mps.editorTest.AddingTypeParameterToConstructor_Test", "jetbrains.mps.editorTest.SmartReferenseUpdateOnChange_Test", "jetbrains.mps.editorTest.SubstitudeAmbigousActions_Test", "jetbrains.mps.editorTest.DeleteOnSelectedNode_Test", "jetbrains.mps.editorTest.SelectionOfWrappedCell_Test", "jetbrains.mps.editorTest.RestoringSThintCell_Test", "jetbrains.mps.editorTest.NodeAfterSubstitutionHasNoErrorCell_Test", "jetbrains.mps.editorTest.AddingParameterThroughtWrapper_Test", "jetbrains.mps.editorTest.AddingParameterWithEnter_Test", "jetbrains.mps.editorTest.SubstituteSmallPatternInLeft_Test", "jetbrains.mps.editorTest.PerformLeftTransformWithNoLeftTransformActions_Test", "jetbrains.mps.editorTest.TestForNonEmptyProperty_Test", "jetbrains.mps.editorTest.SettingTextToNodeAfterApplingAction_Test", "jetbrains.mps.editorTest.TryingToLeftTransformNewExpression_Test", "jetbrains.mps.editorTest.SurrondWithParenthesisTest_Test", "jetbrains.mps.editorTest.PriorityCheckTest_Test", "jetbrains.mps.editorTest.SubstitutionOfMethodWithNameSimularToStaticMethod_Test", "jetbrains.mps.editorTest.ReturnFollowerByVarName_Test", "jetbrains.mps.editorTest.ReturnFollowedBySpaceVarName_Test", "jetbrains.mps.editorTest.DeleteOpenCurlyBrace_Test", "jetbrains.mps.editorTest.DeleteClosingCurlyBrace_Test", "jetbrains.mps.editorTest.TestAutoresolve_Test", "jetbrains.mps.editorTest.Post_ThisSettingClassConcept_Test", "jetbrains.mps.editorTest.Post_ThisSavingClassConceptSet_Test", "jetbrains.mps.editorTest.Post_ThisSavingClassConceptUnset_Test", "jetbrains.mps.editorTest.Post_ThisRemovingClassConcept_Test", "jetbrains.mps.editorTest.EditingNotEditableProperty_Test", "jetbrains.mps.editorTest.Pre_LocalStaicFieldToStaticFieldReference_Test", "jetbrains.mps.editorTest.Post_StaticFieldToLocalStaticFieldReference_Test", "jetbrains.mps.editorTest.StaticBehaviorMethodWithParameters_completion_Test", "jetbrains.mps.editorTest.RT_toStaticFieldReference_Test", "jetbrains.mps.editorTest.RT_addTypeVariable_Test", "jetbrains.mps.editorTest.RT_toArray_Test", "jetbrains.mps.editorTest.LT_PlusExpression_with_Cast_Test", "jetbrains.mps.editorTest.LT_MapElement_with_Assignment_Test", "jetbrains.mps.editorTest.LT_Assignment_with_PlusAssignment_Test", "jetbrains.mps.editorTest.LT_SNodeTypeCast_with_PlusExpression_Test", "jetbrains.mps.editorTest.LT_PostfixIncrement_with_Plus_Test", "jetbrains.mps.editorTest.LT_PlusExpression_with_Plus_Test", "jetbrains.mps.editorTest.LT_AssignmentRValue_with_PlusAssignment_Test", "jetbrains.mps.editorTest.LT_PlusExpressionRArgument_with_Plus_Test", "jetbrains.mps.editorTest.LT_PlusExpressionRArgument_with_Mul_Test", "jetbrains.mps.editorTest.LT_MulExpressionRArgument_with_Plus_Test", "jetbrains.mps.editorTest.LT_PlusExpressionRArgument_with_Assignment_Test", "jetbrains.mps.editorTest.LT_PostfixIncrementExpression_with_PrefixIncrement_Test", "jetbrains.mps.editorTest.LT_PostfixDecrementExpression_with_PrefixDecrement_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_Cast_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_UnaryMinus_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_MinusAssignment_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_PlusOperation_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_Not_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_Parenthesis_Test", "jetbrains.mps.editorTest.LT_DotExpression_with_PrefixDecrement_Test", "jetbrains.mps.editorTest.SurroundExpressionWithParenthesis_Test", "jetbrains.mps.editorTest.SimpleUndoTest_Test", "jetbrains.mps.editorTest.SimpleRedoTest_Test", "jetbrains.mps.editorTest.RT_Assert_with_colon_Test", "jetbrains.mps.editorTest.RT_AssertBinaryOperation_with_colon_Test", "jetbrains.mps.editorTest.RT_AssertInstanceMethodCallOperation_with_colon_Test", "jetbrains.mps.editorTest.LT_ListElementAccess_with_PlusOperation_Test", "jetbrains.mps.editorTest.RT_ClassTypeVarialeDeclaration_with_AngleBracker_Test", "jetbrains.mps.editorTest.RT_ClassTypeVariableDeclaration_with_ampersand_Test", "jetbrains.mps.editorTest.NO_RT_ClassTypeVarialeDeclaration_on_typing_ampersand_inbetween_Test", "jetbrains.mps.editorTest.UndoVariableNameChangeAtOnce_Test", "jetbrains.mps.editorTest.UndoVariableNameCreationAtOnce_Test", "jetbrains.mps.editorTest.UndoSustitutionOfExpressionWithIntContant_Test", "jetbrains.mps.refactoringTest.ChangeMethodParametersForStatement_Test", "jetbrains.mps.refactoringTest.ConceptFunctioParameterTest_Test", "jetbrains.mps.refactoringTest.ConceptMethod_Test", "jetbrains.mps.refactoringTest.ExtractFromAnonymous_Test", "jetbrains.mps.refactoringTest.ExtractFromStatements_Test", "jetbrains.mps.refactoringTest.ExtractMethodFromConstructor_Test", "jetbrains.mps.refactoringTest.FindInputVariables_Test", "jetbrains.mps.refactoringTest.BreakStatement_Test", "jetbrains.mps.refactoringTest.ExtractBreak_Test", "jetbrains.mps.refactoringTest.ExtractContinue_Test", "jetbrains.mps.refactoringTest.ExtractDefaultClassifierMethodDeclaration_Test", "jetbrains.mps.refactoringTest.ExtractFromExpression_Test", "jetbrains.mps.refactoringTest.ExtractFromExpressionWithoutReturn_Test", "jetbrains.mps.refactoringTest.ExtractDifferentReturns_Test", "jetbrains.mps.refactoringTest.ExtractFromStatementWithReturnValue_Test", "jetbrains.mps.refactoringTest.ExtractFromStatementsEndsWithReturn_Test", "jetbrains.mps.refactoringTest.MethodsWithoutReturnStatement_Test", "jetbrains.mps.refactoringTest.OneReturnStatement_Test", "jetbrains.mps.refactoringTest.OneReturnTransformation_Test", "jetbrains.mps.refactoringTest.ReturnStatement_Test", "jetbrains.mps.refactoringTest.ExtractFromIntention_Test", "jetbrains.mps.refactoringTest.staticContainerBehaviorTest_Test", "jetbrains.mps.refactoringTest.staticContainerClassTest_Test", "jetbrains.mps.refactoringTest.AddThrowDeclaration_Test", "jetbrains.mps.refactoringTest.ChangeMethodName_Test", "jetbrains.mps.refactoringTest.ChangeReturningType_Test", "jetbrains.mps.refactoringTest.ChangeSignatureOfStaticMethod_Test", "jetbrains.mps.refactoringTest.AddParameter_Test", "jetbrains.mps.refactoringTest.ChangeParameterName_Test", "jetbrains.mps.refactoringTest.ChangeParameterType_Test", "jetbrains.mps.refactoringTest.ChangeParametersOrder_Test", "jetbrains.mps.refactoringTest.RemoveParameter_Test", "jetbrains.mps.refactoringTest.TwoParametersWithSameType_Test", "jetbrains.mps.refactoringTest.DeclarationVariablesInMethod_Test", "jetbrains.mps.refactoringTest.InlineFromAnotherClass_Test", "jetbrains.mps.refactoringTest.InlineFromExpression_Test", "jetbrains.mps.refactoringTest.InlineRecursiveMethod_Test", "jetbrains.mps.refactoringTest.InlineWithNoSourcesAttached_Test", "jetbrains.mps.refactoringTest.SimpleInlineWithOneReturn_Test", "jetbrains.mps.refactoringTest.InlineFromBehavior_Test", "jetbrains.mps.refactoringTest.InlineFromBehaviorWithMethods_Test", "jetbrains.mps.refactoringTest.InlineInBehaviorWithThis_Test", "jetbrains.mps.refactoringTest.InlineMethodThatChangesParameters_Test", "jetbrains.mps.refactoringTest.InlineModelWithConstants_Test", "jetbrains.mps.refactoringTest.OneReturnWithNotVariableParameters_Test", "jetbrains.mps.refactoringTest.OneReturnWithParameteres_Test", "jetbrains.mps.refactoringTest.CheckStaticVisibility_Test", "jetbrains.mps.refactoringTest.CheckVisibility_Test", "jetbrains.mps.refactoringTest.CheckInlineCanBePerformed_Test", "jetbrains.mps.refactoringTest.CheckInlineWithThrow_Test", "jetbrains.mps.refactoringTest.InlineManyReturns_Test", "jetbrains.mps.refactoringTest.InlineMethodWithReturnAtTheEnd_Test", "jetbrains.mps.refactoringTest.InlineMethodWithVoidType_Test", "jetbrains.mps.refactoringTest.InlineWithVoidTypeAndBug_Test", "jetbrains.mps.refactoringTest.InlineWithoutReturnStatement_Test", "jetbrains.mps.refactoringTest.InlineStaticFromAnotherClass_Test", "jetbrains.mps.refactoringTest.StaticMethod_Test", "jetbrains.mps.refactoringTest.InlineFromConceptFunction_Test", "jetbrains.mps.refactoringTest.InlineLocalVariableReferenceWithoutDeclarationDeleting_Test", "jetbrains.mps.refactoringTest.InlineLocalVariableReferense_Test", "jetbrains.mps.refactoringTest.InlineReferenceWithAssignment_Test", "jetbrains.mps.refactoringTest.InlineWithoutDeclarationDeletion_Test", "jetbrains.mps.refactoringTest.SimpleInlineVariable_Test", "jetbrains.mps.refactoringTest.MoveMethodWithFields_Test", "jetbrains.mps.refactoringTest.MoveMethodWithMethods_Test", "jetbrains.mps.refactoringTest.MoveMethodWithUssages_Test", "jetbrains.mps.refactoringTest.SimpleMoveMethod_Test", "jetbrains.mps.refactoringTest.InlineMethodInTest_Test", "jetbrains.mps.refactoringTest.ChangeSigantureOfInterface_Test", "jetbrains.mps.refactoringTest.MoveStaticFieldSimpleTest_Test", "jetbrains.mps.refactoringTest.MoveStaticFieldWithUsageTest_Test", "jetbrains.mps.refactoringTest.MoveMethodWithParameters_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousInterfaceTest_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousAbstractClassTest_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousWithTypeVariablesTest_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousToStaticTest_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousWithTypeVariablesComplexTest_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousWithLocalVariablesTest_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousAbstractClassWithConstructorTest_Test", "jetbrains.mps.refactoringTest.InlineMethodWithUnusedParameters_Test", "jetbrains.mps.refactoringTest.InlineMethodWithConceptFunctionParameters_Test", "jetbrains.mps.refactoringTest.SimpleFindForExtractFromExpression_Test", "jetbrains.mps.refactoringTest.SimpleFindForExtractFromStatement_Test", "jetbrains.mps.refactoringTest.SimpleFindForExtractWithReturn_Test", "jetbrains.mps.refactoringTest.SimpleFindForExtractFromManyStatements_Test", "jetbrains.mps.refactoringTest.ExtractMethodWithOutputVaryableFromStatement_Test", "jetbrains.mps.refactoringTest.ReplaceOutputVaryable_Test", "jetbrains.mps.refactoringTest.ExtractMethodWithOutputVaryableFromExpression_Test", "jetbrains.mps.refactoringTest.SimpleFindAndMoveForIntroduceLocalVar_Test", "jetbrains.mps.refactoringTest.SimpleFindForIntroduceConstant_Test", "jetbrains.mps.refactoringTest.SimpleFindForIntroduceLocalVariable_Test", "jetbrains.mps.refactoringTest.FindAndMoveFromIfForIntroduceLocalVar_Test", "jetbrains.mps.refactoringTest.IntroduceVariableFromAnonimousClass_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousWithLocalVariables_Test", "jetbrains.mps.refactoringTest.IntroduceConstantFromAnonimousClass_Test", "jetbrains.mps.refactoringTest.ExtractAddingNewDeclaration_Test", "jetbrains.mps.refactoringTest.FindForMethodWithOutputVariable_Test", "jetbrains.mps.refactoringTest.FindForMethodWithIVariableLikeNodes_Test", "jetbrains.mps.refactoringTest.ExtractMethodWithThrows_Test", "jetbrains.mps.refactoringTest.InlineInsideClosure_Test", "jetbrains.mps.refactoringTest.InlineInClosureWithOutsideAssingment_Test", "jetbrains.mps.refactoringTest.InlineAssingmentWithClosures_Test", "jetbrains.mps.refactoringTest.InlineAssingmentInClosure_Test", "jetbrains.mps.refactoringTest.ConvertAnonymousWithParameterReference_Test", "jetbrains.mps.refactoringTest.IntroduceVariableFromWildcards_Test", "jetbrains.mps.refactoringTest.ExtractMethodFromClosure_Test", "jetbrains.mps.refactoringTest.SimpleMoveStaticMethod_Test", "jetbrains.mps.refactoringTest.IntroduceFinalLocalVariable_Test", "jetbrains.mps.refactoringTest.IntroduceFinalField_Test", "jetbrains.mps.asTest.AsTest_Test"}, tests = {"test_AnonymousClassTest", "test_AssignmentTest", "test_BadCodeInTheLeftTest", "test_BadCodeTest", "test_EqualsTest", "test_ForEachTest", "test_ForTest", "test_RemoveNodeTest", "test_ReturnNullTest", "test_IfAndElseTest", "test_TwoPlusTwo", "test_SelectTwoCells", "test_IntentionTest", "test_TwoMullTwo", "test_RightTransformInAnnotation", "test_RightTransform", "test_AssignmentExpression", "test_STHintTest", "test_RightTransformWithSmallPatternCompletion", "test_AssigningToField", "test_DeleteStatement", "test_DeleteVariableInitializer", "test_DeleteFieldReference", "test_IntSpaceA", "test_MathE", "test_DeleteFirstChild", "test_DeleteOverridenMethodInBehavior", "test_smartStatementsInsert", "test_SidedeleteAtTheEnd", "test_SidedeleteAtStart", "test_SidedeleteAtStartOfIf", "test_SidedeleteAtEndWithOneStatement", "test_InsertBeforeInIf", "test_PressingEndWithSelectedNode", "test_BracesTest", "test_TypeToTypeof", "test_AnnotationSelection", "test_ActionAtFirstPostionProblem", "test_CompexTransformTest", "test_SideDeleteAtEndWithBackSpace", "test_AssignLeftTransform", "test_DotExpression", "test_LeftTransformOfDotOperation", "test_SurrondByParensesis", "test_ReplacingSelection", "test_EnterAfterElseIf", "test_PressingBackspaseInFirstPosition", "test_PressingDelInLastPosition", "test_SelectionByShiftArrows", "test_MovingNode", "test_MoveNodeRange", "test_DefaultCellInfoTest", "test_RestoreCellSelection", "test_RestoreRangeSeletion", "test_AssociativityProblem", "test_PriorityProblem", "test_EditorCellSomeProblem", "test_CaretInStaticMethodCall", "test_ConflictingRigthTransform", "test_TypingIncorrectTextInFields", "test_InsertBeforeUnaryMinus", "test_InterWithNonLabelSelected", "test_FieldDeletion", "test_WrappingCellShouldntBeSelectable", "test_DeleteIfPossibleMethod", "test_IntelligentInputWithSubstitutionChooser", "test_ReplacePlusWithMinus", "test_AddingTypeParameterToConstructor", "test_SmartReferenseUpdateOnChange", "test_SubstitudeAmbigousActions", "test_DeleteOnSelectedNode", "test_SelectionOfWrappedCell", "test_RestoringSThintCell", "test_NodeAfterSubstitutionHasNoErrorCell", "test_AddingParameterThroughtWrapper", "test_AddingParameterWithEnter", "test_SubstituteSmallPatternInLeft", "test_PerformLeftTransformWithNoLeftTransformActions", "test_TestForNonEmptyProperty", "test_SettingTextToNodeAfterApplingAction", "test_TryingToLeftTransformNewExpression", "test_noBinaryOperation,test_thereIsAlreadyParenthesis,test_treeRotation", "test_testRotation", "test_SubstitutionOfMethodWithNameSimularToStaticMethod", "test_ReturnFollowerByVarName", "test_ReturnFollowedBySpaceVarName", "test_DeleteOpenCurlyBrace", "test_DeleteClosingCurlyBrace", "test_TestAutoresolve", "test_Post_ThisSettingClassConcept", "test_Post_ThisSavingClassConceptSet", "test_Post_ThisSavingClassConceptUnset", "test_Post_ThisRemovingClassConcept", "test_EditingNotEditableProperty", "test_Pre_LocalStaicFieldToStaticFieldReference", "test_Post_StaticFieldToLocalStaticFieldReference", "test_StaticBehaviorMethodWithParameters_completion", "test_RT_toStaticFieldReference", "test_RT_addTypeVariable", "test_RT_toArray", "test_LT_PlusExpression_with_Cast", "test_LT_MapElement_with_Assignment", "test_LT_Assignment_with_PlusAssignment", "test_LT_SNodeTypeCast_with_PlusExpression", "test_LT_PostfixIncrement_with_Plus", "test_LT_PlusExpression_with_Plus", "test_LT_AssignmentRValue_with_PlusAssignment", "test_LT_PlusExpressionRArgument_with_Plus", "test_LT_PlusExpressionRArgument_with_Mul", "test_LT_MulExpressionRArgument_with_Plus", "test_LT_PlusExpressionRArgument_with_Assignment", "test_LT_PostfixIncrementExpression_with_PrefixIncrement", "test_LT_PostfixDecrementExpression_with_PrefixDecrement", "test_LT_DotExpression_with_Cast", "test_LT_DotExpression_with_UnaryMinus", "test_LT_DotExpression_with_MinusAssignment", "test_LT_DotExpression_with_PlusOperation", "test_LT_DotExpression_with_Not", "test_LT_DotExpression_with_Parenthesis", "test_LT_DotExpression_with_PrefixDecrement", "test_SurroundExpressionWithParenthesis", "test_SimpleUndoTest", "test_SimpleRedoTest", "test_RT_Assert_with_colon", "test_RT_AssertBinaryOperation_with_colon", "test_RT_AssertInstanceMethodCallOperation_with_colon", "test_LT_ListElementAccess_with_PlusOperation", "test_RT_ClassTypeVarialeDeclaration_with_AngleBracker", "test_RT_ClassTypeVariableDeclaration_with_ampersand", "test_NO_RT_ClassTypeVarialeDeclaration_on_typing_ampersand_inbetween", "test_UndoVariableNameChangeAtOnce", "test_UndoVariableNameCreationAtOnce", "test_UndoSustitutionOfExpressionWithIntContant", "test_changeMethodParametersForStatement", "test_ConceptFunctioParameterTest", "test_conceptMethod", "test_ExtractFromAnonymous", "test_extractFromStatements", "test_ExtractMethodFromConstructor", "test_inputVariablesTest", "test_noBreaks,test_oneBreak,test_oneContionue,test_breakAndContinue", "test_ExtractBreak", "test_ExtractContinue", "test_extractFromMethod,test_extractFromExecute", "test_extractFromExpression", "test_extractFromExpressionWithoutReturn", "test_extractDifferentReturns", "test_extractFromStatementWithReturnValue", "test_extractFromStatementsEndsWithReturn", "test_checkReturnWithoutReturn", "test_oneReturnStatement,test_returnAndOutVariable", "test_oneReturnTransformation", "test_alwaysReturn,test_retunInAnonymousClass,test_notAlwaysReturn", "test_extractExpression", "test_staticContainerBehaviorTest", "test_staticContainerClassTest", "test_AddThrowDeclaration", "test_ChangeMethodName", "test_ChangeReturningType", "test_ChangeSignatureOfStaticMethod", "test_AddParameter", "test_ChangeParameterName", "test_ChangeParameterType", "test_ChangeParametersOrder", "test_RemoveParameter", "test_TwoParametersWithSameType", "test_DeclarationVariablesInMethod", "test_InlineFromAnotherClass", "test_InlineFromExpression", "test_InlineRecursiveMethod", "test_InlineWithNoSourcesAttached", "test_SimpleInlineWithOneReturn", "test_InlineFromBehavior", "test_InlineFromBehaviorWithMethods", "test_InlineInBehaviorWithThis", "test_InlineMethodThatChangesParameters", "test_InlineModelWithConstants", "test_OneReturnWithNotVariableParameters", "test_OneReturnWithParameteres", "test_CheckStaticVisibility", "test_CheckVisibility", "test_CheckInlineCanBePerformed", "test_CheckInlineWithThrow", "test_InlineManyReturns", "test_InlineMethodWithReturnAtTheEnd", "test_InlineMethodWithVoidType", "test_InlineWithVoidTypeAndBug", "test_InlineWithoutReturnStatement", "test_InlineStaticFromAnotherClass", "test_StaticMethod", "test_deinition,test_reference", "test_InlineLocalVariableReferenceWithoutDeclarationDeleting", "test_InlineLocalVariableReferense", "test_InlineReferenceWithAssignment", "test_inlineWithoutDeclarationDeletion", "test_simpleInlineVariable", "test_MoveMethodWithFields", "test_MoveMethodWithMethods", "test_check", "test_check", "test_InlineMethodTest", "test_ChangeSigantureOfInterface", "test_SimpleTest", "test_UsageTest", "test_check", "test_InterfaceTest", "test_AbstractClassTest", "test_TypeVariablesTest", "test_ToStaticTest", "test_TypeVariablesComplexTest", "test_WithLocalVariablesTest", "test_AbstractClassWithConstructorTest", "test_InlineMethodWithUnusedParameters", "test_InlineMethodWithConceptFunctionParameters", "test_SimpleFindForExtractFromExpressionTest", "test_SimpleFindForExtractFromStatementTest", "test_SimpleFindForExtractWithReturnTest", "test_SimpleFindForExtractFromManyStatementsTest", "test_ExtractMethodWithOutputVaryableFromStatementTest", "test_ReplaceOutputVaryableTest", "test_ExtractMethodWithOutputVaryableFromStatementTest", "test_SimpleFindAndMoveForIntroduceLocalVarTest", "test_SimpleFindForIntroduceConstantTest", "test_SimpleFindAndMoveForIntroduceLocalVariableTest", "test_SimpleFindAndMoveForIntroduceLocalVarTest", "test_IntroduceVariableFromAnonimousClassTest", "test_AbstractClassTest", "test_IntroduceConstantFromAnonimousClassTest", "test_ExtractAddingNewDeclaration", "test_FindForMethodWithOutputVariableTest", "test_FindForMethodWithIVariableLikeNodesTest", "test_ExtractMethodWithThrowsTest", "test_InlineInsideClosureTest", "test_InlineInClosureWithOutsideAssingmentTest", "test_InlineAssingmentWithClosures", "test_InlineAssingmentInClosure", "test_WithParameterReferenceTest", "test_IntroduceVariableFromWildcardsTest", "test_ExtractMethodFromClosure", "test_SimpleMoveStaticMethod", "test_IntroduceFinalLocalVariable", "test_IntroduceFinalField", "test_as"})
@ModuleSymbolicSuite.ModuleReference("9c8b4b95-5d89-4201-ad78-0b2db3a22768(jetbrains.mps.baseLanguage.test)")
@RunWith(ModuleSymbolicSuite.class)
public class TestModule_jetbrains_mps_baseLanguage_test {
  public TestModule_jetbrains_mps_baseLanguage_test() {
  }
}
